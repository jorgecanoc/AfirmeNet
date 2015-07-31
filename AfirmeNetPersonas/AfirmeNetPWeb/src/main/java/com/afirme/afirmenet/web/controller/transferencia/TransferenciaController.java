package com.afirme.afirmenet.web.controller.transferencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.model.pagos.ConvenioDomiciliacion;
import com.afirme.afirmenet.model.pagos.ImpuestoGDF;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Divisa;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.model.transferencia.TransferenciaCuentasPropias;
import com.afirme.afirmenet.service.acceso.LogInService;
import com.afirme.afirmenet.service.divisa.DivisaService;
import com.afirme.afirmenet.service.transferencia.CuentaTercerosService;
import com.afirme.afirmenet.service.transferencia.Transferencia;
import com.afirme.afirmenet.service.transferencia.TransferenciaService;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.base.BaseController;
import com.afirme.afirmenet.web.model.FavoritasModel;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
public class TransferenciaController extends BaseController {
	static final Logger LOG = LoggerFactory
			.getLogger(TransferenciaController.class);
	

	@Autowired
	protected CuentaTercerosService cuentaTercerosService;
	@Autowired
	protected LogInService loginService;
	@Autowired
	protected TransferenciaService transferenciaService;
	@Autowired
	protected DivisaService divisaService;	

	public void setEjecucionInfo(TransferenciaBase base, Date fechaCompleta) {

		base.setValidationDate(TimeUtils.getDateFormat(fechaCompleta,
				"dd/MM/yy"));
		base.setValidationYear(TimeUtils.getDateFormat(fechaCompleta, "yy"));
		base.setValidationMonth(TimeUtils.getDateFormat(fechaCompleta, "MM"));
		base.setValidationDay(TimeUtils.getDateFormat(fechaCompleta, "dd"));
		base.setValidationHour(TimeUtils.getDateFormat(fechaCompleta, "HH"));
		base.setValidationMinute(TimeUtils.getDateFormat(fechaCompleta, "mm"));

		base.setProgrammingDate(TimeUtils.getDateFormat(fechaCompleta,
				"dd/MM/yy"));
		base.setProgrammingYear(TimeUtils.getDateFormat(fechaCompleta, "yy"));
		base.setProgrammingMonth(TimeUtils.getDateFormat(fechaCompleta, "MM"));
		base.setProgrammingDay(TimeUtils.getDateFormat(fechaCompleta, "dd"));
		base.setProgrammingHour(TimeUtils.getDateFormat(fechaCompleta, "HH"));
		base.setProgrammingMinute(TimeUtils.getDateFormat(fechaCompleta, "mm"));
	}

	public SortedMap<String, String> getHoras() {
		return getHoras(0, 24);
	}

	public SortedMap<String, String> getHoras(int horaServicioInicio,
			int horaServicioFin) {
		// se genera un Map para desplegar las horas de programacion de
		// transferencias
		SortedMap<String, String> mapHoras = new TreeMap<String, String>();

		int horaActual=Integer.parseInt(TimeUtils.getDateFormat(new Date(), "HH"));

		for (int i = horaActual; i < horaServicioFin; i++) {
			String hora = String.valueOf(i);
			if (i < 10) {
				if (i > 0)
					mapHoras.put("0" + hora + ":00", "0" + hora + ":00 hrs");
				mapHoras.put("0" + hora + ":30", "0" + hora + ":30 hrs");
			} else {
				mapHoras.put(hora + ":00", hora + ":00 hrs");
				if (i < horaServicioFin)
					mapHoras.put(hora + ":30", hora + ":30 hrs");
			}
		}
		return mapHoras;
	}


	@SuppressWarnings("unchecked")
	public String ejecutaTransferencia(ModelMap modelMap,
			List<TransferenciaBase> listTransferencias, Transferencia servicio,
			SessionStatus sessionStatus) {
		String modelView = "";
		// Se evaluan las transferencias y se conforma la lista final
		List<TransferenciaBase> a400 = new ArrayList<TransferenciaBase>(0);
		List<TransferenciaBase> conErrores = new ArrayList<TransferenciaBase>(0);
		// Validacion de Trnasferencia
		LOG.debug("TransController- La lista tiene: "
				+ listTransferencias.size() + " elementos.");
		for (TransferenciaBase tx : listTransferencias) {
			if (tx.getErrores() == null || tx.getErrores().isEmpty()) {
				a400.add(tx);
			} else {
				conErrores.add(tx);
			}
		}

		List<Comprobante> comprobantes = new ArrayList<Comprobante>(0);
		List<Comprobante> comprobantesExito = new ArrayList<Comprobante>(0);
		// Validacion de AS400
		LOG.debug("TransController- La lista As400 tiene: " + a400.size()
				+ " elementos.");
		if (!a400.isEmpty()) {
			// Se procesan las trasferencias
			servicio.setTransferencias(a400);
			comprobantes = (List<Comprobante>) servicio
					.confirmaTransferencias();
		}

		// Se generan los comprobante de las descartadas previamente
		for (Comprobante comprobante : comprobantes) {
			if (comprobante.getErrores() != null) {
				// Crea comprobantes
				conErrores.add(comprobante);
			} else {
				comprobantesExito.add(comprobante);
			}
		}

		// Se genera la lista de errores
		Map<String, List<String>> errores = getErrores(conErrores);

		TipoTransferencia tipo = comprobantes.get(0).getTipoTransferencia();
		TipoServicio tipoServ = comprobantes.get(0).getTipoServicio();
		if (modelMap.containsKey("esFavoritas")
				&& (Boolean) modelMap.get("esFavoritas")) {
			tipo = TipoTransferencia.FAVORITAS;
		}
		switch (tipo) {
		case TRASPASO_PROPIAS:
			if (comprobantes.size() > 1) {
				modelMap.addAttribute("errores", errores);
				modelMap.addAttribute("listTransferencias", comprobantesExito);
				modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_COMPFGUARDADAS;
			} else {
				if (errores.size() > 0) {
					modelMap.addAttribute("errores", errores);
					modelMap.addAttribute("listaTransferencias",
							new ArrayList<TransferenciaCuentasPropias>());
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_SELECCION;
				} else {
					sessionStatus.setComplete();
					modelMap.addAttribute("listTransferencias",
							comprobantesExito);
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_COMPROBANTE;
				}
			}
			break;
		case TRASPASO_TERCEROS:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 1) {
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_LISTA_COMPROBANTES;
				} else if (comprobantesExito.size() == 1) {
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_COMPROBANTE;
				} else {
					modelMap.addAttribute("listaTransferencias",
							new ArrayList<TransferenciaBase>());
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_CTA_TERCEROS;
				}
			}
			break;
		case TRANSFERENCIAS_INTERNACIONALES_DOLARES:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 0) {
					// Se guarda la transferencia exitosa en BD
					for (int i = 0; i < listTransferencias.size(); i++) {
						if (listTransferencias.get(i) instanceof Divisa) {
							Divisa divisa = (Divisa) listTransferencias.get(i);
							divisaService.guardaTransferenciaExitosa(divisa,
									comprobantesExito.get(i)
											.getAfirmeNetReference());
						}
					}
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_DOLARES_COMPROBANTE;

				} else {
					modelMap.addAttribute("transferencia", new Divisa());
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_DOLARES;
				}
			}
			break;
		case PAGO_DE_SERVICIOS:
			if (tipoServ.getValorComercial().equals("201")) {
				modelMap.addAttribute("errores", errores);
				if(errores.isEmpty()){
					if (comprobantesExito != null && comprobantesExito.size() > 0) {
						//Aplicacion exitosa
						modelMap.addAttribute("listTransferencias", comprobantesExito);
						sessionStatus.setComplete();
						return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS_COMPROBANTE;
					}
				}else{
					//Retorna errores
					return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS;
				}
			
			}else{
				modelMap.addAttribute("errores", errores);
				if(errores.isEmpty()){
					if (comprobantesExito != null && comprobantesExito.size() > 0) {
						//Aplicacion exitosa
						modelMap.addAttribute("comprobante", comprobantesExito.get(0));
						sessionStatus.setComplete();
						return AfirmeNetWebConstants.MV_SERVICIOS_COMPROBANTE;
					}
				}else{
					//Retorna errores
					return "forward:/" + AfirmeNetWebConstants.MV_SERVICIOS_SELECCION_RD;
				}
				
			}
			

			break;			
		case DOMINGO_ELECTRONICO:

			break;
		case TRANSFERENCIAS_INTERNACIONALES_MULTIMONEDA:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 0) {
					// Se guarda la transferencia exitosa en BD
					for (int i = 0; i < listTransferencias.size(); i++) {
						if (listTransferencias.get(i) instanceof Divisa) {
							Divisa divisa = (Divisa) listTransferencias.get(i);
							divisaService.guardaTransferenciaExitosa(divisa,
									comprobantesExito.get(i)
											.getAfirmeNetReference());
						}
					}
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_MULTIMONEDA_COMPROBANTE;

				} else {
					modelMap.addAttribute("transferencia", new Divisa());
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_MULTIMONEDA;
				}
			}
			break;
		case FAVORITAS:
			modelMap.addAttribute("errores", errores);
			if (comprobantesExito.size() > 0) {
				FavoritasModel newModel = new FavoritasModel();

				newModel.setComprobantes(comprobantesExito);
				modelMap.addAttribute("favoritasModel", newModel);
				modelView =  AfirmeNetWebConstants.MV_FAVORITAS_COMPROBANTE;

			} else {
				modelView = AfirmeNetWebConstants.MV_FAVORITAS_SELECCIONA;
			}

			break;
		case TRANSFERENCIA_SPEI:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 1) {
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_LISTA_COMPROBANTES;
				} else if (comprobantesExito.size() < 1)
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_SELECCION;
				else {
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_COMPROBANTE;
				}
			}
			break;
		case PAGO_INTERBANCARIO:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 1)
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_LISTA_COMPROBANTES;
				else if (comprobantesExito.size() < 1)
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_SELECCION;
				else
					modelView = AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_COMPROBANTE;
			}
			break;
		case PAGO_TESORERIA_GOBIERNO_DISTRITO_FEDERAL:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 0) {
					// TODO insercion a BD / cdcarguz
					// TODO actualizacion de limites de transferencia acumulados / cdcarguz
					// TODO envio de mail de notificacion / cdcarguz
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_GDF_COMPROBANTE;
				} else {
					modelMap.addAttribute("transferencia", new ImpuestoGDF());
					modelView = AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_GDF;
				}
			}
			break;
		case VENTA_DE_SEGUROS_ANTIFRAUDE:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 1)
					modelView = AfirmeNetWebConstants.MV_PAGOS_SEGURO_COMPROBANTE;
				else if (comprobantesExito.size() < 1)
					modelView = AfirmeNetWebConstants.MV_PAGOS_SEGURO_CONTRATO;
				else
					modelView = AfirmeNetWebConstants.MV_PAGOS_SEGURO_CONFIRMA;
			}
			break;
		case DOMICILIACION_DE_SERVICIOS_BASICOS:
			modelMap.addAttribute("errores", errores);
			modelMap.addAttribute("listComprobantes", comprobantesExito);
			if (comprobantesExito != null) {
				if (comprobantesExito.size() > 0) {
					// TODO insercion a BD / cdcarguz
					// TODO actualizacion de limites de transferencia acumulados / cdcarguz
					// TODO envio de mail de notificacion / cdcarguz
					sessionStatus.setComplete();
					modelView = AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION_COMPROBANTE;
				} else {
					modelMap.addAttribute("transferencia", new ConvenioDomiciliacion());
					modelView = AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION;
				}
			}
			break;
		default:
			break;
		}

		return modelView;
	}

	public static Map<String, List<String>> getErrores(
			List<? extends TransferenciaBase> transConErrores) {
		// Se genera la lista de errores
		Map<String, List<String>> errores = new HashMap<String, List<String>>(0);
		List<String> data = null;
		for (TransferenciaBase tx : transConErrores) {
			String origen = tx.getDebitAccount();
			String destino = tx.getCreditAccount();
			if (tx.getOrigen() != null) {
				origen = tx.getOrigen().getNumber();
			}
			if (tx.getDestino() != null) {
				destino = tx.getDestino().getNumber();
			}
			String key = "Cta. Origen: " + origen;
			if(destino != null && !StringUtils.isEmpty(destino)){
				key+= " | Cta. Destino:"+ destino;
			}
			data = new ArrayList<String>(0);
			for (Map.Entry<CodigoExcepcion, String> entry : tx.getErrores()
					.entrySet()) {
				Integer errorKey = entry.getKey().getValue();
				String errorValue = entry.getValue();
				data.add(errorKey + " - " + errorValue);
			}
			errores.put(key, data);
		}

		return errores;
	}

	
}
