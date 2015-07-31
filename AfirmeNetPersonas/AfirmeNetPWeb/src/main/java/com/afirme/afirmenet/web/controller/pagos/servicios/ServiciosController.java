package com.afirme.afirmenet.web.controller.pagos.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.model.DCPermisoServicio;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.pagos.PagosService;
import com.afirme.afirmenet.service.transferencia.TransferenciaPagoServiciosService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@RequestMapping("/servicios")
@SessionAttributes({ "servicio", "horario", "cuentasPropias" })
public class ServiciosController extends TransferenciaController {

	private static final int minutosActivacion = 30;

	@Autowired
	private PagosService pagosService;

	@Autowired
	private TransferenciaPagoServiciosService pagoServiciosService;

	/**
	 * Metodo inicial que muestra la informacion de los servicios configurados,
	 * si no tiene activado el servicio, el listado de servicios no es visible y
	 * le muestra la opcion de activar los servicios, tiene que pasar 30 min
	 * despues de activar servicios para poder utilizar este servicio
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/seleccion", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String serviciosBasicos(HttpServletRequest request, ModelMap modelMap) {
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.PAGO_SERVICIOS));
		// Obtiene el usuario de Session
		AfirmeNetUser user = getSessionUser(request);
		// Busca las cuentas en session;
		List<Cuenta> listaCuentas = (List<Cuenta>) modelMap
				.get("cuentasPropias");

		// Busca si el servicio de pago de servicios ya esta activado
		DCPermisoServicio permisoservicio = pagosService
				.getActivacionServicios(user.getContrato(),
						TipoCliente.PERSONAS);

		if (permisoservicio == null) {
			// Si no esta activado muestra los valores para que se activen
			modelMap.addAttribute("horario", AfirmeNetConstants.horarios
					.get(HorarioServicio.ACTIVACION_SERVICIOS));			
			modelMap.addAttribute("serviciosActivados", false);
			modelMap.addAttribute("mostrarServicios", false);
		} else {
			// Si estan activados valida la fecha de activacion VS la fecha
			// actual y calcula los minutos transcurridos
			DateTime fechaContratacion = new DateTime(permisoservicio
					.getFechaCreacion().getTime());
			Minutes minutes = Minutes.minutesBetween(fechaContratacion,
					DateTime.now());
			List<INSER> servicios = pagosService.getConvenios400();
			modelMap.addAttribute("servicios", servicios);
			if (minutes.getMinutes() >= minutosActivacion) {
				// Mostrar Servicios
				Servicio servicio = new Servicio();
				servicio.setContractId(user.getContrato());
				servicio.setUserId(user.getContrato());
				servicio.setEmailBeneficiary(user.getCorreoElectronico());
				
				modelMap.addAttribute("servicio", servicio);
				modelMap.addAttribute("cuentasPropias",
						listaCuentas == null ? getCuentasPropiasMXP(user)
								: listaCuentas);
				modelMap.addAttribute("tiempoNoCumplido", false);
				modelMap.addAttribute("serviciosActivados", true);

			} else {
				// Mostrar leyenda
				modelMap.addAttribute("tiempoNoCumplido", true);
				modelMap.addAttribute("minutosActivacion", minutosActivacion
						- minutes.getMinutes());
				modelMap.addAttribute("serviciosActivados", true);
			}
			modelMap.addAttribute("mostrarServicios", true);
		}

		return AfirmeNetWebConstants.MV_SERVICIOS_SELECCION;

	}

	/**
	 * Metodo que muestra el contrato de activacion de pago de servicios
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/contrato", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String contrato(ModelMap modelMap) {
		modelMap.addAttribute("CAT", "22.0");
		return AfirmeNetWebConstants.MV_SERVICIOS_CONTRATO;
	}

	/**
	 * Metodo que se ejecuta al aceptar el contrato de servicios, este se
	 * redicciona al metodo serviciosBasicos para que se ejecute la logica de
	 * acuerdo a los minutos transcurridos
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/aceptaContrato", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String aceptaContrato(HttpServletRequest request, ModelMap modelMap) {

		AfirmeNetUser user = getSessionUser(request);
		pagosService.activaServicios(user.getContrato(), TipoCliente.PERSONAS);
		return "forward:/" + AfirmeNetWebConstants.MV_SERVICIOS_SELECCION_RD;

	}

	/**
	 * Metodo que ofrece al usuario la captura del servicio seleccionado
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/capturar", method = RequestMethod.POST)
	public String capturaDatos(@ModelAttribute("servicio") Servicio servicio,
			ModelMap modelMap) {
		modelMap.addAttribute("mapHoras", getHoras());

		List<Cuenta> listaCuentas = (List<Cuenta>) modelMap
				.get("cuentasPropias");
		for (Cuenta cuenta : listaCuentas) {
			if (servicio.getOrigen().getNumber().equals(cuenta.getNumber())) {
				servicio.setOrigen(cuenta);
				servicio.setDebitAccount(cuenta.getNumber());
				servicio.setBankFrm("62");
				servicio.setBankCode("62");
				servicio.setBankReceiving("62");
				servicio.setCurrency(servicio.getOrigen().getCcy());
				
			}
		}

		
		servicio.setTipoServicio(TipoServicio.findByValue(servicio
				.getIdServicio().toString()));
		servicio.setServiceType(Integer.valueOf(servicio.getTipoServicio().getValor()));
		servicio.setTransactionCode(TipoTransferencia.PAGO_DE_SERVICIOS.getValor());
		
		modelMap.addAttribute("servicio", servicio);
		return AfirmeNetWebConstants.MV_SERVICIOS_DATOS;

	}

	/**
	 * Metodo que ejecuta la programacion o pago del servicio
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/confirmar", method = RequestMethod.POST)
	public String confirmar(@ModelAttribute("servicio") Servicio servicio,
			ModelMap modelMap) {

		if(servicio.getTipoServicio().equals(TipoServicio.TELEFONOS_DE_MEXICO)){
			servicio.setCreditAccount(servicio.getLada() + servicio.getNumeroTelefonico());
			servicio.setServiceNumber(servicio.getLada() + servicio.getNumeroTelefonico());
		}else if(servicio.getTipoServicio().equals(TipoServicio.GAS_NATURAL_MEXICO)){
			Date fechaIncioVencimiento = TimeUtils.getDate(
					servicio.getFechaVencimiento() + " 00:00",
					"dd/MMMM/yyyy HH:mm");
			
			servicio.setAnioVencimiento(Integer.valueOf(TimeUtils.getDateFormat(fechaIncioVencimiento, "yy")));
			servicio.setMesVencimiento(Integer.valueOf(TimeUtils.getDateFormat(fechaIncioVencimiento, "MM")));
			servicio.setDiaVencimiento(Integer.valueOf(TimeUtils.getDateFormat(fechaIncioVencimiento, "dd")));
		}
		
		Date fechaIncioProgramacion = null;

		if (servicio.getInicioProgramacion() != null
				&& servicio.getHoraProgramacion() != null) {
			fechaIncioProgramacion = TimeUtils.getDate(
					servicio.getInicioProgramacion() + " "
							+ servicio.getHoraProgramacion(),
					"dd/MMMM/yyyy HH:mm");
		} else {
			String fechaDia = TimeUtils.getDateFormat(new Date(),
					"dd/MMMM/yyyy") + " 00:00";
			fechaIncioProgramacion = TimeUtils.getDate(fechaDia,
					"dd/MMMM/yyyy HH:mm");

		}

		setEjecucionInfo(servicio, fechaIncioProgramacion);
		// Se crea la lista de transferencias
		List<TransferenciaBase> listTransferencias = new ArrayList<TransferenciaBase>(
				0);
		listTransferencias.add(servicio);

		// Se validan las transferencias
		pagoServiciosService.valida(listTransferencias);

		if (listTransferencias.get(0).getErrores() != null
				&& !listTransferencias.get(0).getErrores().isEmpty()) {
			// retorna errores
			Map<String, List<String>> errores = getErrores(listTransferencias);
			modelMap.addAttribute("errores", errores);
			return "forward:/"
					+ AfirmeNetWebConstants.MV_SERVICIOS_SELECCION_RD;
		} else {
			modelMap.addAttribute("servicio", servicio);
			return AfirmeNetWebConstants.MV_SERVICIOS_CONFIRMA;
		}

	}

	/**
	 * Metodo que ejecuta la programacion o pago del servicio
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ejecutar", method = RequestMethod.POST)
	public String ejecutar(@ModelAttribute("servicio") Servicio servicio,
			ModelMap modelMap, SessionStatus sessionStatus) {

		// Se crea la lista de transferencias
		List<TransferenciaBase> ejecutar = new ArrayList<TransferenciaBase>(0);
		ejecutar.add(servicio);

		// Se setean las transferencias
		pagoServiciosService.setTransferencias(ejecutar);

		// Se ejecutan las transacciones
		String modelAndView = ejecutaTransferencia(modelMap, ejecutar,
				pagoServiciosService, sessionStatus);

		modelMap.addAttribute("servicio", servicio);

		return modelAndView;

	}

}
