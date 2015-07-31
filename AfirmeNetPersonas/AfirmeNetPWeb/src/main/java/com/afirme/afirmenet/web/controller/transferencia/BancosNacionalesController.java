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

import com.afirme.afirmenet.enums.ComisionTransaccion;
import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.acceso.UserService;
import com.afirme.afirmenet.service.transferencia.BancosNacionalesService;
import com.afirme.afirmenet.service.transferencia.ComisionesService;
import com.afirme.afirmenet.service.transferencia.CuentaMailService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;
//import java.text.DateFormat;
//import com.afirme.afirmenet.model.transferencia.Comprobante;

@Controller
@SessionAttributes({"transferencia", "cuentasOrigen","cuentasDestino", "listaTransferencias", "listaSize"})
@RequestMapping("/transferencias/nacionales")
public class BancosNacionalesController extends TransferenciaController {

	@Autowired
	private BancosNacionalesService bancosNacionalesService;
	@Autowired
	private UserService userService;
	@Autowired
	private CuentaMailService cuentaMailService;
	@Autowired
	private ComisionesService comisionesService;
	static final Logger LOG = LoggerFactory.getLogger(BancosNacionalesController.class);

	//private List<Cuenta> listaCuentasPropias;
	//private List<ACCTHIRDUSER> listaCuentasTerceros;
	//private List<TransferenciaBase> listaTransferencias = new ArrayList<TransferenciaBase>();

	/**
	 * Metodo de Inicializacion de variables y listas de cuentas 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/bancos_nacionales.htm", method = RequestMethod.POST)
	public String bancosNacionales(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/nacionales/bancos_nacionales.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		List<TransferenciaBase> listaTransferencias = new ArrayList<TransferenciaBase>();
		//Se limpia la lista
		//listaTransferencias.clear();
		// se obtienen cuentas propias
		List<Cuenta> listaCuentasPropias = getCuentasPropias(afirmeNetUser);
		// se obtiene la lista de cuentas de terceros
		List<ACCTHIRDUSER> listaCuentasTerceros = cuentaTercerosService.getListaTerceros(afirmeNetUser.getContrato(), "05", "");
		
		//if (!listaCuentasPropias.isEmpty() && !listaCuentasTerceros.isEmpty()) {
			
			TransferenciaBase transferencia = new TransferenciaBase();
			transferencia.setUserId(afirmeNetUser.getContrato());
			transferencia.setContractId(afirmeNetUser.getContrato());
			
			modelMap.addAttribute("transferencia", transferencia);
			modelMap.addAttribute("cuentasOrigen", listaCuentasPropias);
			modelMap.addAttribute("cuentasDestino", listaCuentasTerceros);
			//Extra
			modelMap.addAttribute("listaTransferencias", listaTransferencias);
			modelMap.addAttribute("listaSize", listaTransferencias.size());
			modelMap.addAttribute("horario", AfirmeNetConstants.horarios.get(HorarioServicio.TRANSFERENCIA_SPEI));

			
			return AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_SELECCION;
		//}
		// TO DO retornar error o a dashboard si no tiene cuentas propias
		//return null;

	}

	/**
	 * Metodo para confirmar transferencias guardadas
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/guardadas.htm", method = RequestMethod.POST)
	public String confirmaGuardadas(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/nacionales/guardadas.htm");
		
		List<TransferenciaBase> listTransferencias = (List<TransferenciaBase>) modelMap.get("listaTransferencias");
		modelMap.addAttribute("listaTransferencias", listTransferencias);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_LISTA_GUARDADAS;
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
		LOG.debug("Atendiendo Peticion POST = /transferencias/nacionales/agrega_transaccion");
		
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
		return "redirect:" + AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_AGREGA_TRANSACCION;
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
		LOG.debug("Atendiendo Peticion GET = /transferencias/nacionales/guardar_transaccion");
		
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_SELECCION;
	}

	/**
	 * Metodo que obtiene la informacion de las cuentas propias y terceros seleccionadas y
	 * redirige a la captura de datos
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/captura.htm", method = RequestMethod.POST)
	public String captura(@ModelAttribute("transferencia") TransferenciaBase transferencia,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/nacionales/captura.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		// se obtiene la lista de cuentas propias para extraer los valores de la cuenta seleccionada
		List<Cuenta> listaCuentasPropias = getCuentasPropias(afirmeNetUser);

		LOG.debug("transferencia: "+transferencia);
		// se llenan los datos de transferencia con la informacion de la cuenta origen seleccionada
		for (Cuenta cuenta : listaCuentasPropias) {
			if (cuenta.getNumber().equals(transferencia.getOrigen().getNumber())) {

				transferencia.setDebitAccount(cuenta.getNumber());
				transferencia.setCurrency(cuenta.getCcy());
				// TODO revisar codigos
				transferencia.setBankFrm("62");
				
				transferencia.setOrigen(cuenta);
				break;
			}
		}
		LOG.debug("destino: "+transferencia.getDestino().getNumber());

		// se obtiene la cuenta de tercero para extraer los valores de la cuenta destino seleccionada
		ACCTHIRDUSER accThird = cuentaTercerosService.getCuentaTercero(afirmeNetUser.getContrato(), transferencia.getDestino().getNumber(), "05", "");

		LOG.debug("destino objeto: "+accThird);
		// se llenan los datos de transferencia de la cuenta destino
		if (accThird.getACCNUM().equals(transferencia.getDestino().getNumber())) {
			
			transferencia.setCreditAccount(transferencia.getDestino().getNumber());
			transferencia.setBankReceiving(accThird.getBNKNAME());
			transferencia.setBeneficiaryName(accThird.getACCOWNER());
			transferencia.getDestino().setNumber(accThird.getACCNUM());
			transferencia.getDestino().setDescription(accThird.getACCOWNER());
			transferencia.getDestino().setCcy(accThird.getCURRENCY());
			transferencia.setBankCode(accThird.getBNKCODE());
			transferencia.getDestino().setBankName(accThird.getBNKNAME());
			transferencia.setEmailBeneficiary(cuentaMailService.getCorreoCuenta(
					transferencia.getContractId(), transferencia.getDestino()
							.getNumber()));
			
			//transferencia.setBankReceiving(accThird.getBNKCODE());
			
			// TODO
			//if (cuenta.getType().equals("40"))			
		}
		modelMap.addAttribute("mapHoras", getHoras());
		modelMap.addAttribute("transferencia", transferencia);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_CAPTURA;
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
	@RequestMapping(value = "/confirma.htm", method = RequestMethod.POST)
	public String confirma(@ModelAttribute("transferencia") TransferenciaBase transferencia,
			HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/nacionales/confirma.htm");

		AfirmeNetUser afirmeNetUser = getSessionUser(request);
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
		ComisionTransaccion ct= ComisionTransaccion.TRANSFERENCIA_SPEI;
		//TODO: revisar si habra una lista de operaciones genericas para no poner fijo "05"
		if("09".equalsIgnoreCase(transferencia.getTransactionCode()))
			ct=ComisionTransaccion.PAGO_INTERBANCARIO;
		transferencia.setCommision(comisionesService.getFee(ct, transferencia.getAmount(), afirmeNetUser.getPaqueteAfirmeNet(), afirmeNetUser.getNumCliente()));
		List<TransferenciaBase> listaTransferencias = (List<TransferenciaBase>) modelMap.get("listaTransferencias");
		modelMap.addAttribute("listaTransferencias", listaTransferencias);
		
		if (listaTransferencias.size() > 1)
			return AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_LISTA_GUARDADAS;
		else {
			modelMap.addAttribute("transferencia", transferencia);
			return AfirmeNetWebConstants.MV_TRANSFERENCIAS_NACIONALES_CONFIRMAR;
		}
	}
	/**
	 * Metodo que ejecuta la Transferencia y recibe respuesta de la transaccion
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/comprobante.htm", method = RequestMethod.POST)
	public String comprobante(@ModelAttribute("transferencia") TransferenciaBase transferencia, 
			SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/nacionales/comprobante.htm");
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		List<TransferenciaBase> listaTransferencias = (List<TransferenciaBase>)modelMap.get("listaTransferencias");
		// Se agrega la transferencia a la lista
		listaTransferencias.add(transferencia);
		// Se llenan las transferencias de la lista con los parametros base
		LOG.debug("Controller- La lista tiene: "+listaTransferencias.size() +" elementos.");
		for (TransferenciaBase transferenciaBase : listaTransferencias) {
			//transferenciaBase.setTransactionCode("05");
			transferenciaBase.setUserId(afirmeNetUser.getContrato());
			transferenciaBase.setContractId(afirmeNetUser.getContrato());
			transferenciaBase.setEmail(userService.getMailUsuario(afirmeNetUser.getContrato()));
			transferenciaBase.setBankFrm("62");
			// TODO revisar codigo de banco receptor, no se obtienen de BD?
			transferenciaBase.setBankReceiving(transferenciaBase.getBankCode());
			// TODO  revisar codigo de plaza receptora
			transferenciaBase.setPlazaReceiving("0");
			transferenciaBase.setNarrative("");

			
			if (transferenciaBase.getIva() == null)
				transferenciaBase.setIva(BigDecimal.ZERO);
			if (transferenciaBase.getRfc() == null)
				transferenciaBase.setRfc("");
			
			Date fechaCompleta = new Date();			
			transferenciaBase.setValidationDate(TimeUtils.getDateFormat(fechaCompleta, "dd/MM/yy"));
			transferenciaBase.setValidationYear(TimeUtils.getDateFormat(fechaCompleta, "yy"));
			transferenciaBase.setValidationMonth(TimeUtils.getDateFormat(fechaCompleta, "MM"));
			transferenciaBase.setValidationDay(TimeUtils.getDateFormat(fechaCompleta, "dd"));
			// TODO settear tiempo correcto
			//transferenciaBase.setValidationHour(TimeUtils.getDateFormat(fechaCompleta, "HH"));
			//transferenciaBase.setValidationMinute(TimeUtils.getDateFormat(fechaCompleta, "mm"));
			transferenciaBase.setValidationHour("00");
			transferenciaBase.setValidationMinute("00");
			//setEjecucionInfo(transferenciaBase, new Date());
		}

		String modelView = ejecutaTransferencia(modelMap, listaTransferencias, bancosNacionalesService, sessionStatus);

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
