package com.afirme.afirmenet.web.controller.transferencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.afirme.afirmenet.helper.transferencia.DomingoElectronicoHelper;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.DomingoElectronico;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.transferencia.CuentaMailService;
import com.afirme.afirmenet.service.transferencia.DomingoElectronicoService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({ "transferencia", "cuentasPropias", "cuentasJr", "horario" })
@RequestMapping("/transferencias/domingo")
public class DomingoElectronicoController extends TransferenciaController {
	static final Logger LOG = LoggerFactory
			.getLogger(DomingoElectronicoController.class);

	@Autowired
	private CuentaMailService cuentaMailService;

	@Autowired
	DomingoElectronicoService domingoElectronicoService;

	/**
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/seleccion", method = RequestMethod.POST)
	public String cuentas(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/domingo/seleccion");
		initTransferencia(request, modelMap);
		return AfirmeNetWebConstants.MV_DOMINGO_ELEC_CTAS;
	}

	@SuppressWarnings("unchecked")
	private void initTransferencia(HttpServletRequest request, ModelMap modelMap){
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		// Seteo de valores default
		DomingoElectronico transferencia = new DomingoElectronico();
		transferencia.setContractId(afirmeNetUser.getContrato());
		transferencia.setUserId(afirmeNetUser.getContrato());	
		modelMap.addAttribute("transferencia", transferencia);
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.DOMINGO_ELECTRONICO));

		// Obtiene las cuentas propias y valida si alguna es cuenta JR
		List<Cuenta> listaCuentas = (List<Cuenta>) modelMap
				.get("cuentasPropias");
		if(listaCuentas == null){
			modelMap.addAttribute("cuentasPropias",
					getCuentasPropias(afirmeNetUser));			
		}
		List<ACCTHIRDUSER> cuentasJr = (List<ACCTHIRDUSER>) modelMap
				.get("cuentasJr");
		if(cuentasJr == null){
			modelMap.addAttribute("cuentasJr",
					cuentaService.getCuentasJunior(afirmeNetUser.getContrato()));					
		}
	}
	/**
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/datos", method = RequestMethod.POST)
	public String ingresoDatos(
			@ModelAttribute("transferencia") DomingoElectronico transferencia,
			ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/domingo/datos.htm");

		List<Cuenta> listaCuentas = (List<Cuenta>) modelMap
				.get("cuentasPropias");

		for (Cuenta cuenta : listaCuentas) {
			if (transferencia.getOrigen().getNumber()
					.equals(cuenta.getNumber())) {
				transferencia.setOrigen(cuenta);
				transferencia.setDebitAccount(cuenta.getNumber());
			}
		}
		List<ACCTHIRDUSER> cuentasJr = (List<ACCTHIRDUSER>) modelMap
				.get("cuentasJr");

		for (ACCTHIRDUSER cuentaJr : cuentasJr) {
			if (transferencia.getDestino().getNumber()
					.equals(cuentaJr.getACCNUM())) {
				transferencia.setCreditAccount(transferencia.getDestino()
						.getNumber());
				transferencia.setBankReceiving(cuentaJr.getBNKCODE());
				transferencia.setBeneficiaryName(cuentaJr.getACCOWNER());
				transferencia.setPlazaReceiving("0");
				transferencia.setBankFrm("62");
				transferencia.getDestino().setNumber(cuentaJr.getACCNUM());
				transferencia.getDestino().setDescription(
						cuentaJr.getACCOWNER());
				transferencia.getDestino().setCcy(cuentaJr.getCURRENCY());
			}
		}

		transferencia.setEmailBeneficiary(cuentaMailService.getCorreoCuenta(
				transferencia.getContractId(), transferencia.getDestino()
						.getNumber()));
		modelMap.addAttribute("mapHoras", getHoras());
		modelMap.addAttribute("transferencia", transferencia);

		return AfirmeNetWebConstants.MV_DOMINGO_ELEC_DATOS;
	}

	/**
	 * @param transferencia
	 * @param request
	 * @param session
	 * @param modelMap
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/confirmacion", method = RequestMethod.POST)
	public String confirmacion(
			@ModelAttribute("transferencia") DomingoElectronico transferencia,
			ModelMap modelMap) throws ParseException {

		Date fechaIncioProgramacion = TimeUtils.getDate(
				transferencia.getInicioProgramacion() + " "
						+ transferencia.getHoraProgramacion(),
				"dd/MMMM/yyyy HH:mm");

		setEjecucionInfo(transferencia, fechaIncioProgramacion);
		// Se crea la lista de transferencias
		List<TransferenciaBase> listTransferencias = new ArrayList<TransferenciaBase>(
				0);
		listTransferencias.add(transferencia);

		// Se validan las transferencias
		domingoElectronicoService.validaTransferencias(listTransferencias);
		if (listTransferencias.get(0).getErrores() != null
				&& !listTransferencias.get(0).getErrores().isEmpty()) {
			// retorna errores
			Map<String, List<String>> errores = getErrores(listTransferencias);
			modelMap.addAttribute("errores", errores);
			return AfirmeNetWebConstants.MV_DOMINGO_ELEC_CTAS;
		} else {
			modelMap.addAttribute("hora", transferencia.getHoraProgramacion());

			if (transferencia.getProgramacion().equals("DIARIA")) {
				modelMap.addAttribute("dias",
						"Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo");
			} else if (transferencia.getProgramacion().equals("SEMANAL")) {
				modelMap.addAttribute("dias", "Domingo");
			} else {
				modelMap.addAttribute("dias", "N/A");
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy");
			String pattern = "dd 'de' MMMM 'del' yyyy";

			modelMap.addAttribute("fechaInicio", TimeUtils.getDateFormat(
					formatter.parse(transferencia.getInicioProgramacion()),
					pattern));
			modelMap.addAttribute("fechaFin", TimeUtils.getDateFormat(
					formatter.parse(transferencia.getFinProgramacion()),
					pattern));
			modelMap.addAttribute("transferencia", transferencia);

			return AfirmeNetWebConstants.MV_DOMINGO_ELEC_CONFIRMACION;

		}

	}

	/**
	 * @param transferencia
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ejecutar", method = RequestMethod.POST)
	public String ejecutar(
			@ModelAttribute("transferencia") DomingoElectronico transferencia,
			SessionStatus sessionStatus, ModelMap modelMap,
			RedirectAttributes redirectAttributes,HttpServletRequest request) {
		transferencia.setEmail("ARTURO.MARTINEZ@AFIRME.COM");
		transferencia.setTransactionCode(TipoTransferencia.DOMINGO_ELECTRONICO
				.getValor());
		transferencia.setCurrency(transferencia.getOrigen().getCcy());

		// Se genera la lista de programaciones
		List<TransferenciaBase> listTransferencias = new DomingoElectronicoHelper()
				.getProgramacionDomingos(transferencia);

		// Se setea la lista de las programaciones
		domingoElectronicoService.setTransferencias(listTransferencias);

		// Se ejecuta la programacion
		List<Comprobante> comprobantes = (List<Comprobante>) domingoElectronicoService
				.confirmaTransferencias();
		if (comprobantes.get(0).getErrores() == null
				|| comprobantes.get(0).getErrores().isEmpty()) {
			// Genera el registro en programacion de pagos
			transferencia.setReferenceNumber(comprobantes.get(0).getReferenceNumber());
			domingoElectronicoService.generaRegistroPagoConcentrado(transferencia);
		} else {
			// retorna errores
			sessionStatus.setComplete();
			initTransferencia(request, modelMap);
			Map<String, List<String>> errores = getErrores(comprobantes);
			modelMap.addAttribute("errores", errores);
			return AfirmeNetWebConstants.MV_DOMINGO_ELEC_CTAS;
		}

		transferencia.setReferenceNumber(comprobantes.get(0)
				.getReferenceNumber());
		modelMap.addAttribute("transferencia", comprobantes.get(0));
		redirectAttributes.addFlashAttribute("transferencia",
				comprobantes.get(0));
		return "redirect:" + AfirmeNetWebConstants.MV_DOMINGO_ELEC_EJECUTAR;

	}

	@RequestMapping(value = "/ejecutar", method = RequestMethod.GET)
	public String ejecutarPRG(
			@ModelAttribute("transferencia") Comprobante transferencia,
			SessionStatus sessionStatus, RedirectAttributes redirectAttributes,
			ModelMap modelMap) {
		sessionStatus.setComplete();
		return AfirmeNetWebConstants.MV_DOMINGO_ELEC_COMPROBANTE;
	}
}
