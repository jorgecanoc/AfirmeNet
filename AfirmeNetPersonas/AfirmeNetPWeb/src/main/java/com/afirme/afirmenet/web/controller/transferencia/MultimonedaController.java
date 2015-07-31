package com.afirme.afirmenet.web.controller.transferencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.transferencia.Divisa;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.divisa.DivisaService;
import com.afirme.afirmenet.service.transferencia.MultimonedaService;
import com.afirme.afirmenet.service.transferencia.TransferenciaService;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({"transferencia", "cuentasOrigen"})
@RequestMapping("/transferencias/multimoneda")
public class MultimonedaController extends TransferenciaController {

	static final Logger LOG = LoggerFactory.getLogger(MultimonedaController.class);
	
	@Autowired
	DivisaService divisaService;
	@Autowired
	MultimonedaService multimonedaService;
	@Autowired
	TransferenciaService transferenciaService;
	
	private List<Cuenta> listaCuentasPropias;
	private List<Divisa> listCuentasSWIFT;
	private List<Divisa> listIntermediarioSWIFT;
	/*
	@RequestMapping(value = "/multimoneda.htm", method = RequestMethod.GET)
	public String ingresoMultimonedaGet(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/multimoneda/multimoneda.htm");
		
		modelMap.addAttribute("transferencia", new Divisa());
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_MULTIMONEDA;
	}
	*/
	/**
	 * Método de inicio de la Transferencia Multimoneda
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/multimoneda.htm", method = RequestMethod.POST)
	public String ingresoMultimoneda(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/multimoneda/multimoneda.htm");
		
		modelMap.addAttribute("transferencia", new Divisa());
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_MULTIMONEDA;
	}
	
	/**
	 * Método para desplegar las listas de cuentas origen y destino, y la información
	 * correspondiente a completar
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ingreso_datos.htm", method = RequestMethod.POST)
	public String ingresoDatos(@ModelAttribute("transferencia") Divisa divisa,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/multimoneda/ingreso_datos.htm");
		/*
		String claveTransfer = request.getParameter("clave") != null ? request.getParameter("clave").toString() : null;
		
		if (StringUtils.isEmpty(divisa.getClaveTransferencia()))
			if (modelMap.containsKey("claveTransfer"))
				claveTransfer = modelMap.get("claveTransfer").toString();
		*/
		String claveTransfer = divisa.getClaveTransferencia();
		// Se valida la clave de transferencia
		divisa = divisaService.validaClaveMultimoneda(claveTransfer);
		
		if (divisa != null) {
			
			AfirmeNetUser afirmeNetUser = getSessionUser(request);
			divisa.setClaveTransferencia(claveTransfer);
			// se obtienen cuentas propias
			if (listaCuentasPropias == null)
				listaCuentasPropias = getCuentasPropias(afirmeNetUser);
			// se obtienen cuentas destino
			if (listCuentasSWIFT == null)
				listCuentasSWIFT = divisaService.getListaCuentasSWIFT(afirmeNetUser.getContrato(), false);
			// Se obtienen cuentas de intermediarios
			if (listIntermediarioSWIFT == null)
				listIntermediarioSWIFT = divisaService.getListaCuentasSWIFT(afirmeNetUser.getContrato(), true);
			
			if (!listaCuentasPropias.isEmpty()) {
				
				divisa.setContractId(afirmeNetUser.getContrato());
				divisa.setUserId(afirmeNetUser.getContrato());
				divisa.setUserReference(claveTransfer);
				divisa.setCurrency("USD");
				
				modelMap.addAttribute("claveTransfer", claveTransfer);
				modelMap.addAttribute("transferencia", divisa);
				modelMap.addAttribute("cuentasOrigen", listaCuentasPropias);
				modelMap.addAttribute("cuentasDestino", listCuentasSWIFT);
				modelMap.addAttribute("cuentasIntermediario", listIntermediarioSWIFT);
				return AfirmeNetWebConstants.MV_TRANSFERENCIAS_MULTIMONEDA_INGRESO_DATOS;
			}
		}
		
		modelMap.addAttribute("claveError", true);
		return ingresoMultimoneda(request, modelMap);
	}
	
	/**
	 * Llamada AJAX para obtener la informaccion de una cuenta SWIFT/ABA a partir
	 * del número de cuenta
	 * @param divisa
	 * @param cuentaDestino
	 * @param request
	 * @param modelMap
	 */
	@RequestMapping(value = "/get_cuenta_swift", method = RequestMethod.POST)
	public void getInfoCuentaSWIFT(
			@ModelAttribute("transferencia") Divisa divisa,
			@RequestParam("cuentaDestino") String cuentaDestino,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/multimoneda/get_cuenta_swift");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		Divisa destino = divisaService.getCuentaSWIFT(afirmeNetUser.getContrato(), cuentaDestino, false);
		// se obtiene informacion de la cuenta destino
		if (destino != null) {
			// Se establece la cuenta destino para estandarizar la informacion
			Cuenta accDestino = new Cuenta();
			accDestino.setNumber(destino.getCreditAccount());
			divisa.setDestino(accDestino);
			
			divisa.setTipoCodigo(destino.getTipoCodigo());
			divisa.setCodigoABA(destino.getCodigoABA());
			divisa.setCodigoSWIFT(destino.getCodigoSWIFT());
			divisa.setBankName(destino.getBankName());
			divisa.setBankCiudad(destino.getBankCiudad());
			divisa.setBankEstado(destino.getBankEstado());
			divisa.setBankPais(destino.getBankPais());
			divisa.setBankArea(destino.getBankArea());
			divisa.setBankDireccion(destino.getBankDireccion());
			divisa.setPlazaReceiving(destino.getPlazaReceiving());
		}
		
		modelMap.addAttribute("transferencia", divisa);
	}
	
	/**
	 * Método de confirmación de la Transferencia. Muestra un resumen de la 
	 * información previamente especificada
	 * @param divisa
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/confirmacion.htm", method = RequestMethod.POST)
	public String confirmacion(@ModelAttribute("transferencia") Divisa divisa, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/multimoneda/confirmacion.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		for (Cuenta cuenta : listaCuentasPropias) {
			if (cuenta.getNumber().equals(divisa.getOrigen().getNumber())) {
				divisa.setDebitAccount(cuenta.getNumber());
				divisa.setOrigen(cuenta);
				break;
			}
		}
		
		if (divisa.getCodigoSWIFT() != null)
			divisa.setCreditAccount(divisa.getTipoCodigo() + "-" + divisa.getCodigoSWIFT());
		else if (divisa.getCodigoABA() != null)
			divisa.setCreditAccount(divisa.getTipoCodigo() + "-" + divisa.getCodigoABA());
		
		// Se obtiene informacion de la cuenta intermediario, si se especificó
		if (!StringUtils.isEmpty(divisa.getIntermediarioCuenta())) {
			Divisa intermediario = divisaService.getCuentaSWIFT(afirmeNetUser.getContrato(), divisa.getIntermediarioCuenta(), true);
			
			if (intermediario.getCodigoSWIFT() != null)
				divisa.setIntermediarioCodigo(intermediario.getCodigoSWIFT());
			else if (intermediario.getCodigoABA() != null)
				divisa.setIntermediarioCodigo(intermediario.getCodigoABA());
			
			divisa.setIntermediarioTipoCodigo(intermediario.getTipoCodigo());
			divisa.setIntermediarioNombre(intermediario.getBankName());
			divisa.setIntermediarioPlaza(intermediario.getPlazaReceiving());
		}
		
		// Realiza la conversion a MXP
		divisa.setMontoConversion(divisa.getMontoUSD().multiply(divisa.getDivisaVenta()));
		
		// establece comisiones de transferencia
		BigDecimal comision = divisaService.getComisionSWIFT(true);
		divisa.setCommision(comision);
		divisa.setTaxCommision(comision.multiply(BigDecimal.ZERO));
		
		Map<String, String> infoMoneda = divisaService.getInfoCambioMoneda("USD");
		BigDecimal tarifaUSD = new BigDecimal(infoMoneda.get("tarifa"));
		divisa.setCommisionConversion(divisa.getCommision().multiply(tarifaUSD));
		divisa.setTaxCommisionConversion(divisa.getCommisionConversion().multiply(BigDecimal.ZERO));
		
		modelMap.addAttribute("transferencia", divisa);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_MULTIMONEDA_CONFIRMACION;
	}
	
	/**
	 * Método que finaliza la Transferencia
	 * @param divisa
	 * @param sessionStatus
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/comprobante.htm", method = RequestMethod.POST)
	public String ejecutarTransaccionMultimoneda(@ModelAttribute("transferencia") Divisa divisa, 
			SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/multimoneda/comprobante.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		// Se establece la informacion de Divisa para efectuar la Transferencia
		divisa.setTransactionCode("51");
		divisa.setBankReceiving("0");
		divisa.setBankArea(divisa.getPlazaReceiving());
		divisa.setPlazaReceiving("0");
		divisa.setBankFrm("62");
		divisa.setAuthorizationUser(afirmeNetUser.getContrato());
		divisa.setAuthorizationDate(Util.getCurrentDDMMYY());
		// Todas las operaciones se realizan el mismo dia, para ello, se establece el parámetro 'M'
		// [M = mismo dia | S = siguiente dia]
		divisa.setProgrammingDate("M");
		divisa.setProgrammingMinute("00");
		divisa.setProgrammingHour("00");
		divisa.setProgrammingDay(Util.getDD());
		divisa.setProgrammingMonth(Util.getMM());
		divisa.setProgrammingYear(Util.getYY());
		
		Date fechaCompleta = new Date();
		divisa.setValidationDate(TimeUtils.getDateFormat(fechaCompleta, "dd/MM/yy"));
		divisa.setValidationYear(TimeUtils.getDateFormat(fechaCompleta, "yy"));
		divisa.setValidationMonth(TimeUtils.getDateFormat(fechaCompleta, "MM"));
		divisa.setValidationDay(TimeUtils.getDateFormat(fechaCompleta, "dd"));
		divisa.setValidationHour("00");
		divisa.setValidationMinute("00");
		divisa.setValidatorUser(afirmeNetUser.getContrato());
		divisa.setOperatorUser(afirmeNetUser.getContrato());
		divisa.setOperationDate(TimeUtils.getDateFormat(fechaCompleta, "dd/MM/yy"));
		// Se define la la tarifa de la divisa en el campo IVA
		divisa.setIva(divisa.getDivisaVenta().multiply(new BigDecimal(10000)));
		
		List<TransferenciaBase> listaTransferencias = new ArrayList<TransferenciaBase>();
		listaTransferencias.add(divisa);
		
		String modelView = ejecutaTransferencia(modelMap, listaTransferencias, multimonedaService, sessionStatus);
		modelMap.addAttribute("transferencia", divisa);
		
		return modelView;
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
}
