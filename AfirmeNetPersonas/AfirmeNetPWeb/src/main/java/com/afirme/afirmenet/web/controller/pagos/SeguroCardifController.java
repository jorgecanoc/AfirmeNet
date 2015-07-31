package com.afirme.afirmenet.web.controller.pagos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.enums.CoberturaCardif;
import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.databeans.cardif.Cobertura;
import com.afirme.afirmenet.ibs.databeans.cardif.SeguroCardif;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.acceso.UserService;
import com.afirme.afirmenet.service.pagos.SegurosCardifService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@RequestMapping("/pagos/seguros/cardif")
public class SeguroCardifController extends TransferenciaController {

	@Autowired
	private SegurosCardifService segurosPagoService;
	@Autowired
	private UserService userService;
	
	static final Logger LOG = LoggerFactory
			.getLogger(SeguroCardifController.class);

	@RequestMapping(value = "/seguros.htm", method = RequestMethod.POST)
	public String selecciona(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/seguros/seguros.htm");	
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		SeguroCardif oBeanCardif =segurosPagoService.tienePoliza(new BigDecimal(afirmeNetUser.getContrato()));
		if (oBeanCardif != null) {
			// Ya tiene una poliza
			//session.setAttribute("oBeanCardif", oBeanCardif);
			return AfirmeNetWebConstants.MV_PAGOS_SEGURO_PAGOS;
		} else {
			// Mostramos la pantalla de contratacion
			oBeanCardif=new SeguroCardif();
			// se obtienen cuentas propias
			List<Cuenta> catCuentasCardif = getCuentasPropias(afirmeNetUser);
			modelMap.addAttribute("horario", AfirmeNetConstants.horarios
					.get(HorarioServicio.VENTA_SEGUROS_ANTIFRAUDE));
			modelMap.addAttribute("catCuentasCardif", catCuentasCardif);
			modelMap.addAttribute("cBasico", segurosPagoService.obtenerCobertura(CoberturaCardif.BASICO));
			modelMap.addAttribute("cOro", segurosPagoService.obtenerCobertura(CoberturaCardif.ORO));
			modelMap.addAttribute("cPlatino", segurosPagoService.obtenerCobertura(CoberturaCardif.PLATINO));
			
			//session.setAttribute("catPaquetesCardif", catPaquetesCardif);
		}

		modelMap.addAttribute("seguroCardif", oBeanCardif);
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO;
	}
	
	@RequestMapping(value = "/contrato_seguros.htm", method = RequestMethod.GET)
	public String captura(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion =/pagos/seguros/contrato_seguros.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO_CONTRATO;
	}
	
	@RequestMapping(value = "/confirma_seguros.htm", method = RequestMethod.POST)
	public String confirma(@ModelAttribute("seguroCardif") SeguroCardif seguroCardif,
	HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/seguros/confirma_seguros.htm");
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		// se obtiene la lista de cuentas propias para extraer los valores de la cuenta seleccionada
		List<Cuenta> listaCuentasPropias = getCuentasPropias(afirmeNetUser);
		LOG.debug("seguroCardif: "+seguroCardif);
		// se llenan los datos de transferencia con la informacion de la cuenta origen seleccionada
		for (Cuenta cuenta : listaCuentasPropias) {
			if (cuenta.getNumber().equals(seguroCardif.getOrigen().getNumber())) {
				seguroCardif.setDebitAccount(cuenta.getNumber());
				seguroCardif.setCurrency(cuenta.getCcy());
				seguroCardif.setOrigen(cuenta);
				break;
			}
		}
		String tipoPaquete=request.getParameter("radio").toString();
		CoberturaCardif tipoCobertura=CoberturaCardif.valueOf(tipoPaquete);
		Cobertura cobertura=segurosPagoService.obtenerCobertura(tipoCobertura);
		seguroCardif.setCliente(new BigDecimal(afirmeNetUser.getNumCliente()));
		seguroCardif.setPaquete(String.valueOf(cobertura.getTipo().getValue()));
		seguroCardif.setContractId(afirmeNetUser.getContrato());
		seguroCardif.setUserId(afirmeNetUser.getContrato());
		seguroCardif.setTransactionCode(TipoTransferencia.VENTA_DE_SEGUROS_ANTIFRAUDE.getValor());
		seguroCardif.setPaqueteDescripcion(cobertura.getNombre());
		seguroCardif.setAmount(cobertura.getCostoMensual());
		Date fechaCompleta = new Date();			
		seguroCardif.setValidationDate(TimeUtils.getDateFormat(fechaCompleta, "dd/MM/yy"));
		seguroCardif.setValidationYear(TimeUtils.getDateFormat(fechaCompleta, "yy"));
		seguroCardif.setValidationMonth(TimeUtils.getDateFormat(fechaCompleta, "MM"));
		seguroCardif.setValidationDay(TimeUtils.getDateFormat(fechaCompleta, "dd"));
		// TODO settear tiempo correcto
		seguroCardif.setValidationHour(TimeUtils.getDateFormat(fechaCompleta, "HH"));
		seguroCardif.setValidationMinute(TimeUtils.getDateFormat(fechaCompleta, "mm"));
		
		List<TransferenciaBase> lista=new ArrayList<TransferenciaBase>();
		lista.add(seguroCardif);
		segurosPagoService.valida(lista);
		LOG.debug("seguroCardif: "+seguroCardif);
		modelMap.addAttribute("seguroCardif", seguroCardif);
		if(seguroCardif.getErrores()==null)
			return AfirmeNetWebConstants.MV_PAGOS_SEGURO_CONFIRMA;

		Map<String, List<String>> errores = new HashMap<String, List<String>>(0);
		List<String> data = null;
		for (TransferenciaBase tx : lista) {
			String origen = tx.getDebitAccount();
			String key = "Cta. Origen: " + origen;
			data = new ArrayList<String>(0);
			for (Map.Entry<CodigoExcepcion, String> entry : tx.getErrores()
					.entrySet()) {
				Integer errorKey = entry.getKey().getValue();
				String errorValue = entry.getValue();
				data.add(errorKey + " - " + errorValue);
			}
			errores.put(key, data);
		}
		modelMap.addAttribute("errores", errores);
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO;
	}
	
	@RequestMapping(value = "/comprobante_seguros.htm", method = RequestMethod.POST)
	public String comprobante(@ModelAttribute("seguroCardif") SeguroCardif seguroCardif,
			SessionStatus sessionStatus,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/seguros/comprobante_seguros.htm");
		List<TransferenciaBase> lista=new ArrayList<TransferenciaBase>();
		lista.add(seguroCardif);

		String modelView = ejecutaTransferencia(modelMap, lista, segurosPagoService, sessionStatus);
		List<Comprobante> comprobantesExito=(List<Comprobante>)modelMap.get("listComprobantes");
		LOG.debug("Lista: "+ comprobantesExito.size());
		modelMap.addAttribute("seguroCardif", seguroCardif);
		return modelView;
	}
	
	/**
	 * Metodo para cancelar la transaccion
	 */
	@RequestMapping(value = "/cancela.htm", method = RequestMethod.GET)
	public String modalCancela(HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("titulo", "Cancelar la Transacción");
		modelMap.addAttribute("mensaje", "Usted perderá la transacción actual, dicha transaccion no podrá recuperarse.");
		modelMap.addAttribute("pregunta", "¿Esta seguro de Cancelar la Transacción?");
		modelMap.addAttribute("action", "consultas/resumen-de-mis-cuentas.htm");
		modelMap.addAttribute("boton", "Sí, cancelar");
		return AfirmeNetWebConstants.MODAL;
	}
	
	/**
	 * Metodo para regresar a selecciona
	 */
	@RequestMapping(value = "/atrasSelecciona.htm", method = RequestMethod.GET)
	public String atrasSelecciona(HttpServletRequest request,	ModelMap modelMap) {
		return AfirmeNetWebConstants.MV_PAGOS_TDC;
	}
	

	

}
