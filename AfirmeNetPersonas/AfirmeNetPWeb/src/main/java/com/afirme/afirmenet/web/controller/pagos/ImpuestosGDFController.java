package com.afirme.afirmenet.web.controller.pagos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.pagos.ImpuestoGDF;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.pagos.ImpuestosGDFService;
import com.afirme.afirmenet.service.transferencia.PagoImpuestosGDFService;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({"cuentasPropias", "pago", "estadosList"})
@RequestMapping("/pagos/gdf")
public class ImpuestosGDFController extends TransferenciaController {
	
	@Autowired
	PagoImpuestosGDFService pagoImpuestoGDFService;
	@Autowired
	ImpuestosGDFService impuestosGDFService;
	
	static final Logger LOG = LoggerFactory.getLogger(ImpuestosGDFController.class);
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gdf_seleccion.htm", method = RequestMethod.POST)
	public String selecciona(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/gdf/gdf_seleccion.htm");
		
		List<Cuenta> listaCuentasPropias = (List<Cuenta>) modelMap.get("cuentasPropias");
		if (listaCuentasPropias == null) {
			AfirmeNetUser afirmeNetUser = getSessionUser(request);
			listaCuentasPropias = getCuentasPropias(afirmeNetUser);
		}
		
		modelMap.addAttribute("cuentasPropias", listaCuentasPropias);
		modelMap.addAttribute("pago", new ImpuestoGDF());
		return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_GDF;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ingreso_datos.htm", method = RequestMethod.POST)
	public String ingresoDatos(@ModelAttribute("pago") ImpuestoGDF pago,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/gdf/ingreso_datos.htm");
		
		String errorMsg = "";
		
		// Valida la Linea de Captura
		if (impuestosGDFService.validaLineaCaptura(pago.getLineaCaptura(), pago.getAmount().doubleValue())) {
			
			// TODO validar limites diario y mensual / cdcarguz
			// if (overLimit)
				
			// Se extrae la informacion de Concepto de Impuesto GDF
			ImpuestoGDF recibo = impuestosGDFService.getInfoImpuestoGDF(pago.getLineaCaptura(), pago.getAmount().doubleValue());
			
			if (recibo != null) {
				
				// Valida vigencia de la Linea de Captura
				if (impuestosGDFService.validaFechaLineaCaptura(recibo.getLineaCapturaBase())) {
					
					List<Cuenta> listaCuentasPropias = (List<Cuenta>) modelMap.get("cuentasPropias");
					for (Cuenta cuenta : listaCuentasPropias) {
						if (cuenta.getNumber().equals(pago.getOrigen().getNumber())) {
							recibo.setDebitAccount(cuenta.getNumber());
							recibo.setOrigen(cuenta);
							break;
						}
					}
					// Verifica si la Cuenta seleccionada tiene fondos para realizar el pago del Importe capturado
					if (pago.getAmount().compareTo(recibo.getOrigen().getBalance()) == -1) {
						
						recibo.setAmount(pago.getAmount());
						
						if (modelMap.containsAttribute("estadosList"))
							modelMap.addAttribute("estadosList", modelMap.get("estadosList"));
						else
							modelMap.addAttribute("estadosList", getEstadosList());
						
						modelMap.addAttribute("pago", recibo);
						return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_GDF_DATOS;
						
					} else
						errorMsg = "La cuenta seleccionada [" + recibo.getOrigen().getDescription() + " (" + recibo.getOrigen().getNumberMask() + 
							")] no tiene fondos suficientes [$ " + recibo.getOrigen().getBalanceFormatted() + "]";
					
				} else
					errorMsg = "La Línea de Captura ha caducado.";
				
			} else
				errorMsg = "Error al obtener información de la Línea de Captura.";
			
		} else
			errorMsg = "La Línea de Captura no es válida.";
		
		LOG.error(errorMsg);
		modelMap.addAttribute("error", errorMsg);
		modelMap.addAttribute("cuentasPropias", modelMap.get("cuentasPropias"));
		modelMap.addAttribute("pago", pago);
		return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_GDF;
	}
	
	@RequestMapping(value = "/confirmacion.htm", method = RequestMethod.POST)
	public String confirmacion(@ModelAttribute("pago") ImpuestoGDF pago,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/gdf/confirmacion.htm");
		
		modelMap.addAttribute("pago", pago);
		return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_GDF_CONFIRMACION;
	}
	
	@RequestMapping(value = "/realizar_pago.htm", method = RequestMethod.POST)
	public String ejecutar(@ModelAttribute("pago") ImpuestoGDF pago,
			SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/gdf/comprobante.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		pago.setContractId(afirmeNetUser.getContrato());
		pago.setUserId(afirmeNetUser.getContrato());
		pago.setTipoTransferencia(TipoTransferencia.PAGO_TESORERIA_GOBIERNO_DISTRITO_FEDERAL);
		pago.setTransactionCode(TipoTransferencia.PAGO_TESORERIA_GOBIERNO_DISTRITO_FEDERAL.getValor());
		// Establece fecha y hora de ejecucion
		String fechaDia = TimeUtils.getDateFormat(new Date(), "dd/MMMM/yyyy")+" 00:00";
		Date fechaIncioProgramacion = TimeUtils.getDate(fechaDia, "dd/MMMM/yyyy HH:mm");
		setEjecucionInfo(pago, fechaIncioProgramacion);
		
		// El pago no se toma como Transferencia Favorita
		pago.setAgregarFavoritas(false);
		
		// Se crea la lista de transferencias
		List<TransferenciaBase> transferencia = new ArrayList<TransferenciaBase>(0);
		transferencia.add(pago);
		
		// Se setean las transferencias
		pagoImpuestoGDFService.setTransferencias(transferencia);
		
		// Se ejecutan las transacciones
		String modelAndView = ejecutaTransferencia(modelMap, transferencia, pagoImpuestoGDFService, sessionStatus);
		modelMap.addAttribute("pago", pago);
		return modelAndView;
	}
	
	@RequestMapping(value = "/cancelar.htm", method = RequestMethod.GET)
	public String cancelar(HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("titulo", "Cancelar la Transacción");
		modelMap.addAttribute("mensaje", "Usted perderá la transacción actual y las guardadas con anterioridad, dichas transacciones no podrán recuperarse.");
		modelMap.addAttribute("pregunta", "¿Esta seguro de Cancelar la Transacción?");
		modelMap.addAttribute("action", "consultas/resumen-de-mis-cuentas.htm");
		modelMap.addAttribute("boton", "Sí, cancelar");
		return AfirmeNetWebConstants.MODAL;
	}
	
	private List<String> getEstadosList() {
		List<String> estadosList = new ArrayList<String>();
		estadosList.add("Aguascalientes");
		estadosList.add("Baja California");
		estadosList.add("Baja California Sur");
		estadosList.add("Campeche");
		estadosList.add("Chiapas");
		estadosList.add("Chihuahua");
		estadosList.add("Coahuila");
		estadosList.add("Colima");
		estadosList.add("Distrito Federal");
		estadosList.add("Durango");
		estadosList.add("Estado de México");
		estadosList.add("Guanajuato");
		estadosList.add("Guerrero");
		estadosList.add("Hidalgo");
		estadosList.add("Jalisco");
		estadosList.add("Michoacán");
		estadosList.add("Morelos");
		estadosList.add("Nayarit");
		estadosList.add("Nuevo León");
		estadosList.add("Oaxaca");
		estadosList.add("Puebla");
		estadosList.add("Querétaro");
		estadosList.add("Quintana Roo");
		estadosList.add("San Luis Potosí");
		estadosList.add("Sinaloa");
		estadosList.add("Sonora");
		estadosList.add("Tabasco");
		estadosList.add("Tamaulipas");
		estadosList.add("Tamaulipas");
		estadosList.add("Veracruz");
		estadosList.add("Yucatán");
		estadosList.add("Zacatecas");
		return estadosList;
	}
}
