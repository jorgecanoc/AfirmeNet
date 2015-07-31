package com.afirme.afirmenet.web.controller.transferencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.model.transferencia.TransferenciaCuentasPropias;
import com.afirme.afirmenet.service.transferencia.CuentaMailService;
import com.afirme.afirmenet.service.transferencia.TipoCambioService;
import com.afirme.afirmenet.service.transferencia.TransferenciaPropiasService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({ "transferencia", "cuentasPropias", "horario",
		"listTransferencias", "guardadas" })
@RequestMapping("/transferencias/propias")
public class CuentasPropiasController extends TransferenciaController {

	static final Logger LOG = LoggerFactory
			.getLogger(CuentasPropiasController.class);

	@Autowired
	private CuentaMailService cuentaMailService;

	@Autowired
	private TransferenciaPropiasService propiasService;
	
	@Autowired
	private TipoCambioService tipoCambioService;

	/**
	 * Metodo para inicializar cuentas propias
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/cuentas_propias.htm", method = RequestMethod.POST)
	public String inicia(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/propias/cuentas_propias.htm");
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		modelMap.addAttribute("cuentasPropias",
				getCuentasPropias(afirmeNetUser));
		List<TransferenciaCuentasPropias> listTransferencias = new ArrayList<TransferenciaCuentasPropias>(
				0);
		modelMap.addAttribute("listTransferencias", listTransferencias);
		TransferenciaCuentasPropias transferencia = new TransferenciaCuentasPropias();
		transferencia.setContractId(afirmeNetUser.getContrato());
		modelMap.addAttribute("transferencia", transferencia);
		modelMap.addAttribute("guardadas", "");
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.TRASPASO_PROPIAS));
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_SELECCION;
	}

	/**
	 * Metodo para seleccionar cuentas propias
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/captura_propias.htm", method = RequestMethod.POST)
	public String captura(
			@ModelAttribute("transferencia") TransferenciaCuentasPropias transferencia,
			HttpServletRequest request, ModelMap modelMap) {

		LOG.debug("Atendiendo Peticion = /transferencias/propias/selecciona_propias.htm");

		List<Cuenta> listaCuentas = (List<Cuenta>) modelMap
				.get("cuentasPropias");
		for (Cuenta cuenta : listaCuentas) {
			if (transferencia.getOrigen().getNumber()
					.equals(cuenta.getNumber())) {
				transferencia.setOrigen(cuenta);
				transferencia.setDebitAccount(cuenta.getNumber());
			}
			if (transferencia.getDestino().getNumber()
					.equals(cuenta.getNumber())) {
				transferencia.setDestino(cuenta);
				transferencia.setCreditAccount(cuenta.getNumber());
				transferencia.setCurrency(cuenta.getCcy());
				transferencia.setBeneficiaryName(transferencia.getDestino().getNickname());
			}
		}

		transferencia.setEmailBeneficiary(cuentaMailService.getCorreoCuenta(
				transferencia.getContractId(), transferencia.getDestino()
						.getNumber()));
		transferencia.setTransactionCode(TipoTransferencia.TRASPASO_PROPIAS.getValor());
		transferencia.setTipoTransferencia(TipoTransferencia.TRASPASO_PROPIAS);

		if (transferencia.getOrigen().getCcy().trim()
				.equals(transferencia.getDestino().getCcy().trim())) {
			modelMap.addAttribute("cambioMoneda", 0);
		} else {
			modelMap.addAttribute("cambioMoneda", 1);
		}


		modelMap.addAttribute("mapHoras", getHoras());
		modelMap.addAttribute("transferencia", transferencia);

		modelMap.addAttribute("guardadas", ((List<TransferenciaCuentasPropias>) modelMap
				.get("listTransferencias")).size());

		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_CAPTURA;
	}

	/**
	 * Metodo para capturar datos de transferencia
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/confirma_propias.htm", method = RequestMethod.POST)
	public String confirma(
			@ModelAttribute("transferencia") TransferenciaCuentasPropias transferencia,
			HttpServletRequest request, ModelMap modelMap) {

		LOG.debug("Atendiendo Peticion = /transferencias/propias/captura_propias.htm");
		modelMap.addAttribute("transferencia", transferencia);

		String fechaProgramacion = request.getParameter("fechaProgramacion");
		String horaProgramacion = request.getParameter("hora");

		//Setea la fecha y hora
		if (fechaProgramacion!=null && !fechaProgramacion.equals("")) {
		Date fechaIncioProgramacion = TimeUtils.getDate(fechaProgramacion + " "	+ horaProgramacion, "dd/MMMM/yyyy HH:mm");		
		setEjecucionInfo(transferencia, fechaIncioProgramacion);
		}else{
			
			String fechaDia=TimeUtils.getDateFormat(new Date(), "dd/MMMM/yyyy")+" 00:00";
			Date fechaIncioProgramacion = TimeUtils.getDate(fechaDia, "dd/MMMM/yyyy HH:mm");		
			setEjecucionInfo(transferencia, fechaIncioProgramacion);	
		}

		// Se crea la lista de transferencias
		List<TransferenciaCuentasPropias> listTransferencias = new ArrayList<TransferenciaCuentasPropias>(0);
		listTransferencias.add(transferencia);
		// Se valida la clave para tasa preferencial si es de distinta ccy	
			propiasService.valida(listTransferencias);
			
		// Opcional Validacion previa a la ejecucion
		// propiasService.validaTransferencias(listTransferencias);

		// Se evaluan las transferencias y se conforma la lista final
		List<TransferenciaBase> a400 = new ArrayList<TransferenciaBase>(0);
		List<TransferenciaBase> conErrores = new ArrayList<TransferenciaBase>(0);
		// Validacion de Trnasferencia
		for (TransferenciaBase tx : listTransferencias) {
			if (tx.getErrores() == null || tx.getErrores().isEmpty()) {
				a400.add(tx);
			} else {
				conErrores.add(tx);
			}
		}

		Map<String, List<String>> errores = getErrores(conErrores);

		if (errores.size() > 0) {
			modelMap.addAttribute("errores", errores);
			TransferenciaCuentasPropias transferenciaN = new TransferenciaCuentasPropias();
			transferenciaN.setContractId(transferencia.getContractId());
			modelMap.addAttribute("transferencia", transferenciaN);
			return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_SELECCION;
		}
		
		if (transferencia.getOrigen().getCcy().trim()
				.equals("USD") && transferencia.getDestino().getCcy().trim().equals("MXP")) {			
	         transferencia.setCURCCY(tipoCambioService.getBuyCCY("USD"));
	         transferencia.setAMTCCY(transferencia.getAmount().multiply(transferencia.getCURCCY()));
	         transferencia.setCUR("B");
			
		} else if(transferencia.getOrigen().getCcy().trim()
				.equals("MXP") && transferencia.getDestino().getCcy().trim().equals("USD"))
	      {
			transferencia.setCURCCY(tipoCambioService.getSellCCY("USD"));
	         transferencia.setAMTCCY(transferencia.getAmount().divide(transferencia.getCURCCY(), 3));
	         transferencia.setCUR("S");
	      }
		

		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_CONFIRMAR;
	}

	/**
	 * Metodo para confirmar datos de transferencia
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/comprobante_propias.htm", method = RequestMethod.POST)
	public String comprobante(
			@ModelAttribute("transferencia") TransferenciaCuentasPropias transferencia,
			SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {

		LOG.debug("Atendiendo Peticion = /transferencias/propias/comprobante_propias.htm");

		cuentaMailService.guardaCorreoCuenta(transferencia.getContractId(),
				transferencia.getCreditAccount(),
				transferencia.getEmailBeneficiary());

		// Se crea la lista de transferencias
		List<TransferenciaBase> listTransferencias = new ArrayList<TransferenciaBase>(
				0);
		listTransferencias.add(transferencia);

		String modelView =  ejecutaTransferencia(modelMap, listTransferencias,
				propiasService, sessionStatus);
		
		TransferenciaCuentasPropias transferenciaN = new TransferenciaCuentasPropias();
		transferenciaN.setContractId(transferencia.getContractId());
		modelMap.addAttribute("transferencia", transferenciaN);
		return modelView;
	}


	/**
	 * Metodo para guardar lista de masivas
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/guarda_propias.htm", method = RequestMethod.POST)
	public String guarda(
			@ModelAttribute("transferencia") TransferenciaCuentasPropias transferencia,
			RedirectAttributes redirect, HttpServletRequest request, ModelMap modelMap) {

		LOG.debug("Atendiendo Peticion = /transferencias/propias/captura_propias.htm");
		modelMap.addAttribute("transferencia", transferencia);

		String fechaProgramacion = request.getParameter("fechaProgramacion");
		String horaProgramacion = request.getParameter("hora");
		//Setea la fecha y hora
		if (fechaProgramacion!=null && !fechaProgramacion.equals("")) {
		Date fechaIncioProgramacion = TimeUtils.getDate(fechaProgramacion + " "	+ horaProgramacion, "dd/MMMM/yyyy HH:mm");		
		setEjecucionInfo(transferencia, fechaIncioProgramacion);
		}else{
			
			String fechaDia=TimeUtils.getDateFormat(new Date(), "dd/MMMM/yyyy")+" 00:00";
			Date fechaIncioProgramacion = TimeUtils.getDate(fechaDia, "dd/MMMM/yyyy HH:mm");		
			setEjecucionInfo(transferencia, fechaIncioProgramacion);	
		}

		List<TransferenciaCuentasPropias> listTransferencias = (List<TransferenciaCuentasPropias>) modelMap
				.get("listTransferencias");
		listTransferencias.add(transferencia);
		TransferenciaCuentasPropias transferenciaNueva = new TransferenciaCuentasPropias();
		transferenciaNueva.setContractId(transferencia.getContractId());
		modelMap.addAttribute("transferencia", transferenciaNueva);

		modelMap.addAttribute("guardadas", listTransferencias.size());
		return "redirect:" + AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_GUARDAR;
	}

	/**
	 * Metodo que atiende la peticion de Guardar Transferencias por medio de GET Request,
	 * de esta manera se evita la duplicidad de peticiones al momento de añadir 
	 * Transferencias a la lista
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/guarda_propias.htm", method = RequestMethod.GET)
	public String guardaPropias(
			@ModelAttribute("transferencia") TransferenciaCuentasPropias transferencia,
			HttpServletRequest request, ModelMap modelMap) {
		
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_SELECCION;
	}
	
	/**
	 * Metodo para confirmar cuentas propias guardadas
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/confguardadas_propias.htm", method = RequestMethod.POST)
	public String confirmaGuardadas(HttpServletRequest request,
			ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/propias/confguardadas_propias.htm");
		List<TransferenciaCuentasPropias> listTransferencias = (List<TransferenciaCuentasPropias>) modelMap
				.get("listTransferencias");
		modelMap.addAttribute("listTransferencias", listTransferencias);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_CONFGUARDADAS;
	}

	/**
	 * Metodo para inicializar cuentas propias
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/compguardadas_propias.htm", method = RequestMethod.POST)
	public String comprobanteGuardadas(SessionStatus sessionStatus, HttpServletRequest request,
			ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/propias/comprobante_propias.htm");

		// Se crea la lista de transferencias
		List<TransferenciaBase> listTransferencias = (List<TransferenciaBase>) modelMap
				.get("listaTransferencias");

		return ejecutaTransferencia(modelMap, listTransferencias,
				propiasService, sessionStatus);

	}
	
	/**
	 * Metodo para regresar a selecciona
	 */
	@RequestMapping(value = "/atrasSelecciona.htm", method = RequestMethod.GET)
	public String atrasSelecciona(@ModelAttribute("transferencia") TransferenciaCuentasPropias transferencia,
			HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("transferencia", transferencia);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_SELECCION;
	}
	
	/**
	 * Metodo para regresar a captura
	 */
	@RequestMapping(value = "/atrasCaptura.htm", method = RequestMethod.GET)
	public String atrasCaptura(@ModelAttribute("transferencia") TransferenciaCuentasPropias transferencia,
			HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("transferencia", transferencia);
		SortedMap<String, String> mapHoras = new TreeMap<String, String>();
		for (int i = 1; i <= 24; i++) {
			String hora = String.valueOf(i);
			if (i < 10) {
				mapHoras.put("0" + hora + ":00", "0" + hora + ":00 hrs");
				mapHoras.put("0" + hora + ":30", "0" + hora + ":30 hrs");
			} else {
				mapHoras.put(hora + ":00", hora + ":00 hrs");
				mapHoras.put(hora + ":30", hora + ":30 hrs");
			}
		}
		modelMap.addAttribute("mapHoras", mapHoras);
		return AfirmeNetWebConstants.MV_TRANSFERENCIAS_PROPIAS_CAPTURA;
	}
	
	/**
	 * Metodo para cancelar la transaccion
	 */
	@RequestMapping(value = "/cancela.htm", method = RequestMethod.GET)
	public String modalCancela(HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("titulo", "Cancelar la Transacción");
		modelMap.addAttribute("mensaje", "Usted perderá la transacción actual y las guardadas  con anterioridad, dichas transacciones no podrán recuperarse.");
		modelMap.addAttribute("pregunta", "¿Esta seguro de Cancelar la Transacción?");
		modelMap.addAttribute("action", "consultas/resumen-de-mis-cuentas.htm");
		modelMap.addAttribute("boton", "Sí, cancelar");
		return AfirmeNetWebConstants.MODAL;
	}
}
