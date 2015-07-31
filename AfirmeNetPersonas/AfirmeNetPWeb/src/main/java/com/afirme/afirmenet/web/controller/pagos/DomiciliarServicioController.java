package com.afirme.afirmenet.web.controller.pagos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

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
import com.afirme.afirmenet.model.pagos.ConvenioDomiciliacion;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.pagos.ConveniosDomiciliacionService;
import com.afirme.afirmenet.service.transferencia.PagoDomiciliacionService;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

/**
 * @author 0cdcarguz
 *
 */
@Controller
@SessionAttributes({"convenio", "listServicios", "cuentasPropias"})
@RequestMapping("/pagos/domiciliacion")
public class DomiciliarServicioController extends TransferenciaController {

	@Autowired
	PagoDomiciliacionService pagoDomiciliacionService;
	@Autowired
	ConveniosDomiciliacionService convenioService;
	
	static final Logger LOG = LoggerFactory.getLogger(DomiciliarServicioController.class);
	
	/**
	 * Metodo que inicializa el proceso de alta de Domiciliacion de Servicios
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/domiciliacion_seleccion.htm", method = RequestMethod.GET)
	public String seleccionServicio(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_seleccion.htm");
		
		if (modelMap.containsAttribute("listServicios"))
			modelMap.addAttribute("listServicios", modelMap.get("listServicios"));
		else
			modelMap.addAttribute("listServicios", convenioService.getServiciosBasicos400());
		
		modelMap.addAttribute("convenio", new ConvenioDomiciliacion());
		return AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION;
	}
	
	/**
	 * Metodo que redirecciona al contrato de Domiciliacion de Servicios una vez que se haya
	 * seleccionado previamente un servicio
	 * @param convenio
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/domiciliacion_contrato.htm", method = RequestMethod.POST)
	public String autorizacionContrato(@ModelAttribute("convenio") ConvenioDomiciliacion convenio, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_contrato.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		List<ConvenioDomiciliacion> convenioList = convenioService.getContratoServicioDomiciliacion(afirmeNetUser.getContrato());
		
		if (convenioList != null) {
			// Si ya existe convenio con el servicio seleccionado redirecciona a edicion
			for (ConvenioDomiciliacion convenioDomiciliacion : convenioList) {
				if (StringUtils.equals(convenioDomiciliacion.getFolio(), convenio.getFolio())) {
					LOG.debug("\n--> Redireccionando a Edicion de Convenio.");
					convenioDomiciliacion.setTipoMovimiento("M");
					modelMap.addAttribute("convenio", convenioDomiciliacion);
					return AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION_EDICION;
				}
			}
		}
		// Redireccion a Contrato de Domiciliacion de Servicio
		modelMap.addAttribute("convenio", convenio);
		return AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION_CONTRATO;
	}
	
	/**
	 * Metodo que redirecciona a la forma para ingreso de datos
	 * @param convenio
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/domiciliacion_activacion.htm", method = RequestMethod.POST)
	public String ingresoDatos(@ModelAttribute("convenio") ConvenioDomiciliacion convenio, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_activacion.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		List<Cuenta> cuentasPropias = new ArrayList<Cuenta>();
		
		if (!modelMap.containsAttribute("cuentasPropias")) {
			List<Cuenta> listCuentas = getCuentasPropias(afirmeNetUser);
			for (Cuenta cuenta : listCuentas) {
				if (cuenta.getType().equals("DDA") || cuenta.getType().equals("SAV"))
					cuentasPropias.add(cuenta);
			}
			modelMap.addAttribute("cuentasPropias", cuentasPropias);
		}
			
		// Se extrae informacion del Servicio a Domiciliar
		ConvenioDomiciliacion convenioNuevo = convenioService.getInfoServicioDomiciliacion(Integer.parseInt(convenio.getFolio()));
		// Se establece 'Alta' de Servicio
		convenioNuevo.setTipoMovimiento("A");
		
		modelMap.addAttribute("convenio", convenioNuevo);
		return AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION_DATOS;
	}
	
	/**
	 * Metodo para confirmacion de Domiciliacion de Servicios
	 * @param convenio
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/domiciliacion_confirmacion.htm", method = RequestMethod.POST)
	public String confirmacion(@ModelAttribute("convenio") ConvenioDomiciliacion convenio, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_confirmacion.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		List<Cuenta> listCuentas;
		if (!modelMap.containsAttribute("cuentasPropias"))
			listCuentas = getCuentasPropias(afirmeNetUser);
		else
			listCuentas = (List<Cuenta>) modelMap.get("cuentasPropias");
		
		for (Cuenta cuenta : listCuentas) {
			if (cuenta.getNumber().equals(convenio.getOrigen().getNumber())) {
				convenio.setOrigen(cuenta);
				break;
			}
		}
		
		modelMap.addAttribute("convenio", convenio);
		return AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION_CONFIRMACION;
	}
	
	/**
	 * Comprobante de la solicitud de Domiciliacion de Servicios
	 * @param convenio
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/domiciliacion_comprobante.htm", method = RequestMethod.POST)
	public String ejecucionSolicitud(@ModelAttribute("convenio") ConvenioDomiciliacion convenio, 
			SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_comprobante.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		convenio.setContractId(afirmeNetUser.getContrato());
		convenio.setUserId(afirmeNetUser.getNumCliente());
		convenio.setTipoTransferencia(TipoTransferencia.DOMICILIACION_DE_SERVICIOS_BASICOS);
		convenio.setTransactionCode(TipoTransferencia.DOMICILIACION_DE_SERVICIOS_BASICOS.getValor());
		
		// Establece fecha y hora de ejecucion
		String fechaDia = TimeUtils.getDateFormat(new Date(), "dd/MMMM/yyyy")+" 00:00";
		Date fechaIncioProgramacion = TimeUtils.getDate(fechaDia, "dd/MMMM/yyyy HH:mm");
		setEjecucionInfo(convenio, fechaIncioProgramacion);
		
		// El pago no se toma como Transferencia Favorita
		convenio.setAgregarFavoritas(false);
		
		// Se crea la lista de transferencias
		List<TransferenciaBase> transferencia = new ArrayList<TransferenciaBase>(0);
		transferencia.add(convenio);
		
		// Se setean las transferencias
		pagoDomiciliacionService.setTransferencias(transferencia);
		
		// Se ejecutan las transacciones
		String modelAndView = ejecutaTransferencia(modelMap, transferencia, pagoDomiciliacionService, sessionStatus);
		modelMap.addAttribute("convenio", convenio);
		return modelAndView;
	}
	
	@RequestMapping(value = "/domiciliacion_edicion.htm", method = RequestMethod.POST)
	public String edicion(@ModelAttribute("convenio") ConvenioDomiciliacion convenio, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_edicion.htm");
		
		modelMap.addAttribute("convenio", convenio);
		return null;
	}
	
	/**
	 * Metodo para atender solicitudes de Cancelacion de Domiciliacion de Servicio
	 * @param convenio
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/domiciliacion_cancelacion.htm", method = RequestMethod.POST)
	public String cancelacion(@ModelAttribute("convenio") ConvenioDomiciliacion convenio, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_cancelacion.htm");
		
		convenio.setTipoMovimiento("D");
		modelMap.addAttribute("convenio", convenio);
		
		return confirmacion(convenio, request, modelMap);
	}
	
	/**
	 * Metodo para desplegar pantalla de Consulta de Historico de Domiciliacion de Servicio
	 * @param convenio
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/domiciliacion_historico.htm", method = RequestMethod.POST)
	public String consultaHistorico(@ModelAttribute("convenio") ConvenioDomiciliacion convenio, 
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/domiciliacion/domiciliacion_consulta.htm");
		// TODO cdcarguz falta actualizar metodo con ultimas correcciones en AFIRMENET
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		
		Date dateInicio;
		Date dateFin;
		
		try {
			
			DateFormat format = new SimpleDateFormat("dd/MMMM/yyyy", Locale.getDefault());
			
			dateInicio = format.parse(fechaInicio);
			dateFin = format.parse(fechaFin);
			
		} catch (Exception e) {
			
			GregorianCalendar calendar = new GregorianCalendar();
			DateFormat format = new SimpleDateFormat("dd/MMMM/yyyy");
			
			dateFin = calendar.getTime();
			fechaFin = format.format(dateFin);
			
			calendar.add(Calendar.MONTH, -2);
			
			dateInicio = calendar.getTime();
			fechaInicio = format.format(dateInicio);
		}
		
		List<ConvenioDomiciliacion> listConvenios;
		try {
			DateFormat formatDate = new SimpleDateFormat("ddMMyy");
			listConvenios = convenioService
					.getHistorialMovimientos(convenio, formatDate.format(dateInicio), formatDate.format(dateFin));
		} catch (Exception e) {
			listConvenios = new ArrayList<ConvenioDomiciliacion>();
		}

		modelMap.addAttribute("convenio", convenio);
		modelMap.addAttribute("listConvenios", listConvenios);
		modelMap.addAttribute("fechaInicio", fechaInicio);
		modelMap.addAttribute("fechaFin", fechaFin);
		return AfirmeNetWebConstants.MV_PAGOS_DOMICILIACION_HISTORICO;
	}
}
