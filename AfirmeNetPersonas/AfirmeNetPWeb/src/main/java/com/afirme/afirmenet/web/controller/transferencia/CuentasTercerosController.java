package com.afirme.afirmenet.web.controller.transferencia;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.acceso.UserService;
import com.afirme.afirmenet.service.transferencia.TransferenciaTercerosService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;

@Controller
@SessionAttributes({"transferencia", "cuentasOrigen","cuentasDestino", "listaTransferencias", "listaSize"})
@RequestMapping("/transferencias/terceros")
public class CuentasTercerosController extends TransferenciaController {

	static final Logger LOG = LoggerFactory.getLogger(CuentasTercerosController.class);
	
	@Autowired
	private TransferenciaTercerosService tercerosService;
	@Autowired
	private UserService userService;
	
	/**
	 * Metodo de Inicializacion de variables y listas de cuentas 
	 * @param request
	 * @param modelMap
	 * @return
	 */

	@RequestMapping(value = "/cuentas_terceros.htm", method = RequestMethod.POST)
	public String cuentasTerceros(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/terceros/cuentasTerceros.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		List<TransferenciaBase> listaTransferencias = new ArrayList<TransferenciaBase>();
		List<Cuenta> listaCuentasPropias = getCuentasPropias(afirmeNetUser);
		List<ACCTHIRDUSER> listaCuentasTerceros = cuentaTercerosService.getListaTerceros(afirmeNetUser.getContrato(), "03", "");
		
		TransferenciaBase transferencia = new TransferenciaBase();
		transferencia.setContractId(afirmeNetUser.getContrato());
		
		modelMap.addAttribute("transferencia", transferencia);
		modelMap.addAttribute("cuentasOrigen", listaCuentasPropias);
		modelMap.addAttribute("cuentasDestino", listaCuentasTerceros);
		modelMap.addAttribute("listaTransferencias", listaTransferencias);
		modelMap.addAttribute("listaSize", listaTransferencias.size());
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios.get(HorarioServicio.TRASPASO_TERCEROS));

		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_CTA_TERCEROS;
	}
	
	/**
	 * Metodo para confirmar cuentas terceros guardadas
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/guardadas.htm", method = RequestMethod.POST)
	public String confirmaGuardadas(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/terceros/guardadas.htm");
		
		List<TransferenciaBase> listTransferencias = (List<TransferenciaBase>) modelMap.get("listaTransferencias");
		modelMap.addAttribute("listaTransferencias", listTransferencias);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_LISTA_GUARDADAS;
	}	
	/**
	 * Metodo para adicion de Transferencias a la lista de pendientes por ejecutar
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/agrega_transaccion", method = RequestMethod.POST)
	public String guardarTransaccion(@ModelAttribute("transferencia") TransferenciaBase transferencia, 
			RedirectAttributes redirect, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion POST = /transferencias/terceros/agrega_transaccion");
		
		List<TransferenciaBase> listaTransferencias = (List<TransferenciaBase>) modelMap.get("listaTransferencias"); 
		
		String fechaProgramacion = request.getParameter("fechaProgramacion");
		String horaProgramacion = request.getParameter("hora");
		//Setea la fecha y hora
		if (fechaProgramacion != null && !fechaProgramacion.equals("")) {
			Date fechaIncioProgramacion = TimeUtils.getDate(fechaProgramacion + " "	+ horaProgramacion, "dd/MMMM/yyyy HH:mm");
			setEjecucionInfo(transferencia, fechaIncioProgramacion);
		} else {
			String fechaDia = TimeUtils.getDateFormat(new Date(), "dd/MMMM/yyyy")+" 00:00";
			Date fechaIncioProgramacion = TimeUtils.getDate(fechaDia, "dd/MMMM/yyyy HH:mm");
			setEjecucionInfo(transferencia, fechaIncioProgramacion);
		}
		
		listaTransferencias.add(transferencia);

		TransferenciaBase transferenciaNueva = new TransferenciaBase();
		transferenciaNueva.setContractId(transferencia.getContractId());
		modelMap.addAttribute("transferencia", transferenciaNueva);
		
		modelMap.addAttribute("listaTransferencias", listaTransferencias);
		modelMap.addAttribute("listaSize", listaTransferencias.size());
		// Se redirecciona a metodo GET para evitar doble adicion de transacciones a la lista
		return "redirect:" + AfirmeNetWebConstants.MV_TRANSFERENCIAS_AGREGA_TRANSACCION;
	}
	
	/**
	 * Metodo que evita la duplicidad de adiciones a la lista de Transferencias
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/agrega_transaccion", method = RequestMethod.GET)
	public String guardarTransaccionGet(@ModelAttribute("transferencia") TransferenciaBase transferencia, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion GET = /transferencias/terceros/guardar_transaccion");
		
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_CTA_TERCEROS;
	}
	
	/**
	 * Metodo que obtiene la informacion de las cuentas propias y terceros seleccionadas y
	 * redirige a la captura de datos
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ingreso_datos.htm", method = RequestMethod.POST)
	public String ingresoDatos(@ModelAttribute("transferencia") TransferenciaBase transferencia,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/terceros/ingreso_datos.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		List<Cuenta> listaCuentasPropias = (List<Cuenta>) modelMap.get("cuentasOrigen");
		// se llenan los datos de transferencia con la informacion de la cuenta origen seleccionada
		for (Cuenta cuenta : listaCuentasPropias) {
			if (cuenta.getNumber().equals(transferencia.getOrigen().getNumber())) {
				transferencia.setDebitAccount(cuenta.getNumber());
				transferencia.setCurrency(cuenta.getCcy());
				transferencia.setOrigen(cuenta);
				break;
			}
		}
		
		// se obtiene la cuenta de tercero para extraer los valores de la cuenta destino seleccionada
		ACCTHIRDUSER accThird = cuentaTercerosService.getCuentaTercero(afirmeNetUser.getContrato(), transferencia.getDestino().getNumber(), "03", "");
		// se llenan los datos de transferencia de la cuenta destino
		if (accThird.getACCNUM().equals(transferencia.getDestino().getNumber())) {
			transferencia.setCreditAccount(transferencia.getDestino().getNumber());
			transferencia.setBankReceiving(accThird.getBNKNAME());
			transferencia.setBeneficiaryName(accThird.getACCOWNER());
			transferencia.getDestino().setNumber(accThird.getACCNUM());
			transferencia.getDestino().setDescription(accThird.getACCOWNER());
			transferencia.getDestino().setCcy(accThird.getCURRENCY());
			transferencia.getDestino().setBankCode(accThird.getBNKCODE());
			transferencia.getDestino().setBankName(accThird.getBNKNAME());
		}
		
		modelMap.addAttribute("mapHoras", getHoras());
		modelMap.addAttribute("transferencia", transferencia);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_INGRESO_DATOS;
		//TODO return cuentasTerceros(request, modelMap);
	}
	
	/**
	 * Metodo que muestra el resumen de informacion especificada de la Transferencia y
	 * espera confirmacion del usuario
	 * @param transferencia
	 * @param request
	 * @param session
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/confirmacion.htm", method = RequestMethod.POST)
	public String confirmacion(@ModelAttribute("transferencia") TransferenciaBase transferencia,
			HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/terceros/confirmacion.htm");
		
		String fechaProgramacion = request.getParameter("fechaProgramacion") != null ? request.getParameter("fechaProgramacion").toString() : null;
		String horaProgramacion = request.getParameter("horaProgramacion") != null ? request.getParameter("horaProgramacion").toString() : null;
		
		if (StringUtils.isNotEmpty(fechaProgramacion) && StringUtils.isNotEmpty(horaProgramacion)) {
			
			Date programmingDate = TimeUtils.getDate(fechaProgramacion, new SimpleDateFormat("d/MMMM/yyyy"));
			
			transferencia.setProgrammingDate(TimeUtils.getDateFormat(programmingDate, "dd/MM/yy"));
			transferencia.setProgrammingDay(TimeUtils.getDateFormat(programmingDate, "dd"));
			transferencia.setProgrammingMonth(TimeUtils.getDateFormat(programmingDate, "MM"));
			transferencia.setProgrammingYear(TimeUtils.getDateFormat(programmingDate, "yy"));
			
			String[] programmingHour = horaProgramacion.split(":");
			transferencia.setProgrammingHour(programmingHour[0]);
			transferencia.setProgrammingMinute(programmingHour[1]);
		}
		
		List<TransferenciaBase> listaTransferencias = (List<TransferenciaBase>) modelMap.get("listaTransferencias");
		modelMap.addAttribute("listaTransferencias", listaTransferencias);
		
		if (listaTransferencias.size() > 1)
			return AfirmeNetWebConstants.MV_TRANSFERENCIAS_LISTA_GUARDADAS;
		else {
			modelMap.addAttribute("transferencia", transferencia);
			return AfirmeNetWebConstants.MV_TRANSFERENCIAS_CONFIRMACION;
		}
	}
	
	/**
	 * Metodo que ejecuta la Transferencia y recibe respuesta de la transaccion
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/realizarTransferencia.htm", method = RequestMethod.POST)
	public String ejecutarTransaccionTerceros(@ModelAttribute("transferencia") TransferenciaBase transferencia, 
			SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/terceros/realizarTransferencia.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		List<TransferenciaBase> listaTransferencias = (List<TransferenciaBase>)modelMap.get("listaTransferencias");
		listaTransferencias.add(transferencia);
		
		// Se llenan las transferencias de la lista con los parametros base
		for (TransferenciaBase transferenciaBase : listaTransferencias) {
			transferenciaBase.setTransactionCode("03");
			transferenciaBase.setUserId(afirmeNetUser.getContrato());
			transferenciaBase.setContractId(afirmeNetUser.getContrato());
			transferenciaBase.setEmail(userService.getMailUsuario(afirmeNetUser.getContrato()));
			transferenciaBase.setBankFrm("62");
			transferenciaBase.setBankReceiving("62");
			transferenciaBase.setPlazaReceiving("0");
			transferenciaBase.setNarrative("");
			// TODO existen comisiones?
			transferenciaBase.setCommision(BigDecimal.ZERO);
			
			if (transferenciaBase.getIva() == null)
				transferenciaBase.setIva(BigDecimal.ZERO);
			if (transferenciaBase.getRfc() == null)
				transferenciaBase.setRfc("");
			
			Date fechaCompleta = new Date();
			transferenciaBase.setValidationDate(TimeUtils.getDateFormat(fechaCompleta, "dd/MM/yy"));
			transferenciaBase.setValidationYear(TimeUtils.getDateFormat(fechaCompleta, "yy"));
			transferenciaBase.setValidationMonth(TimeUtils.getDateFormat(fechaCompleta, "MM"));
			transferenciaBase.setValidationDay(TimeUtils.getDateFormat(fechaCompleta, "dd"));
			// hora y minuto se establecen como 00:00 para que la transferencia sea inmediata
			transferenciaBase.setValidationHour("00");
			transferenciaBase.setValidationMinute("00");
		}

		String modelView = ejecutaTransferencia(modelMap, listaTransferencias, tercerosService, sessionStatus);
		
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
