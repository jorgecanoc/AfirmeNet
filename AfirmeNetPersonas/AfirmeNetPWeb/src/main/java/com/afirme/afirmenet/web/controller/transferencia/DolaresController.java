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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.transferencia.Divisa;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.divisa.DivisaService;
import com.afirme.afirmenet.service.transferencia.DolaresService;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({"transferencia", "cuentasOrigen", "cuentasDestino" , "cuentasIntermediario"})
@RequestMapping("/transferencias/dolares")
public class DolaresController extends TransferenciaController {

	static final Logger LOG = LoggerFactory.getLogger(CuentasTercerosController.class);
	@Autowired
	private DivisaService divisaService;
	@Autowired
	private DolaresService dolaresService;
	
	// TODO quitar metodo GET
	/*
	@RequestMapping(value = "/dolares.htm", method = RequestMethod.GET)
	public String cuentasDolaresGet(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/dolares/dolares.htm");
		return cuentasDolares(request, modelMap);
	}
	*/
	
	/**
	 * Método que inicializa la información para realizar una Transferencia en Dólares
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dolares.htm", method = RequestMethod.POST)
	public String cuentasDolares(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/dolares/dolares.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		List<Cuenta> listaCuentasPropias = (List<Cuenta>) modelMap.get("cuentasOrigen");
		List<Divisa> listCuentasSWIFT = (List<Divisa>) modelMap.get("cuentasDestino");
		List<Divisa> listIntermediarioSWIFT = (List<Divisa>) modelMap.get("cuentasIntermediario");
		
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
			
			Divisa divisa = new Divisa();
			divisa.setContractId(afirmeNetUser.getContrato());
			divisa.setUserId(afirmeNetUser.getContrato());
			
			modelMap.addAttribute("transferencia", divisa);
			modelMap.addAttribute("cuentasOrigen", listaCuentasPropias);
			modelMap.addAttribute("cuentasDestino", listCuentasSWIFT);
			modelMap.addAttribute("cuentasIntermediario", listIntermediarioSWIFT);
			return AfirmeNetWebConstants.MV_TRANSFERENCIAS_DOLARES;
		}
		// TODO retornar error o a dashboard
		return null;
	}
	
	/**
	 * Método que despliega la información de las cuentas origen y destino previamente
	 * seleccionadas.
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ingreso_datos.htm", method = RequestMethod.POST)
	public String ingresoDatos(@ModelAttribute("transferencia") Divisa divisa,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/dolares/ingreso_datos.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		divisa.setCurrency("USD");
		divisa.setTipoMoneda("USD");
		divisa.setDescMoneda("Dólares");
		
		Map<String, String> mapInfoDivisa = divisaService.getInfoCambioMoneda(divisa.getCurrency());
		divisa.setDescMoneda(mapInfoDivisa.get("descripcion"));
		divisa.setDivisaVenta(new BigDecimal(mapInfoDivisa.get("tarifa")));
		
		List<Cuenta> listaCuentasPropias = (List<Cuenta>) modelMap.get("cuentasOrigen");
		for (Cuenta cuenta : listaCuentasPropias) {
			if (cuenta.getNumber().equals(divisa.getOrigen().getNumber())) {
				divisa.setDebitAccount(cuenta.getNumber());
				divisa.setOrigen(cuenta);
				break;
			}
		}
				
		Divisa destino = divisaService.getCuentaSWIFT(afirmeNetUser.getContrato(), divisa.getCreditAccount(), false);
		// se obtiene informacion de la cuenta destino
		if (destino != null) {
			
			// Se establece la cuenta destino para estandarizar la informacion
			Cuenta cuentaDestino = new Cuenta();
			cuentaDestino.setNumber(destino.getCreditAccount());
			cuentaDestino.setBankName(destino.getBankName());
			divisa.setDestino(cuentaDestino);
			
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
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_DOLARES_INGRESO_DATOS;
	}
	
	/**
	 * Método que muestra un resumen de la información con la que se 
	 * realizará la Transferencia en Dólares
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/confirmacion.htm", method = RequestMethod.POST)
	public String confirmacion(@ModelAttribute("transferencia") Divisa divisa, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/dolares/confirmacion.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		// Se genera el formato para la cuenta destino concatenando el tipo de codigo y el código correspondiente
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
		divisa.setMontoConversion(divisa.getAmount().multiply(divisa.getDivisaVenta()));
		
		// Establece comisiones de transferencia
		BigDecimal comision = divisaService.getComisionSWIFT(true);
		divisa.setCommision(comision);
		divisa.setTaxCommision(comision.multiply(BigDecimal.ZERO));
		
		// TODO verificar porqué la comision siempre se evalua con el cambio de divisa distinto al que esta
		// establecido en el registro de Multimoneda de la BD
		Map<String, String> infoMoneda = divisaService.getInfoCambioMoneda("USD");
		BigDecimal tarifaUSD = new BigDecimal(infoMoneda.get("tarifa"));
		divisa.setCommisionConversion(divisa.getCommision().multiply(tarifaUSD));
		divisa.setTaxCommisionConversion(divisa.getCommisionConversion().multiply(BigDecimal.ZERO));
		
		modelMap.addAttribute("transferencia", divisa);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_DOLARES_CONFIRMACION;
	}
	
	/**
	 * Método que efectúa la Transferencia en Dólares y muestra el estatus e información
	 * correspondiente
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/comprobante.htm", method = RequestMethod.POST)
	public String ejecutarTransaccionDolares(@ModelAttribute("transferencia") Divisa divisa,
			SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/dolares/comprobante.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		divisa.setTransactionCode("04");
		divisa.setCurrency("USD");
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
		divisa.setMontoUSD(BigDecimal.ONE);
		
		List<TransferenciaBase> listaTransferencias = new ArrayList<TransferenciaBase>();
		listaTransferencias.add(divisa);
		
		String modelView = ejecutaTransferencia(modelMap, listaTransferencias, dolaresService, sessionStatus);
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
