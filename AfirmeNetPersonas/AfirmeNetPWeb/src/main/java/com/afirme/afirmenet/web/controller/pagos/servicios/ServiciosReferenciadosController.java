package com.afirme.afirmenet.web.controller.pagos.servicios;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.afirme.afirmenet.service.acceso.UserService;
import com.afirme.afirmenet.service.pagos.SegurosCardifService;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@RequestMapping("/servicios/referenciados")
@SessionAttributes({ "servicio", "horario", "cuentasPropias" })
public class ServiciosReferenciadosController  extends TransferenciaController {

	@Autowired
	private SegurosCardifService segurosPagoService;
	@Autowired
	private UserService userService;
	
	static final Logger LOG = LoggerFactory
			.getLogger(ServiciosReferenciadosController.class);

	@RequestMapping(value = "/selecciona.htm", method = RequestMethod.POST)
	public String selecciona(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /servicios/referenciados/selecciona.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SERVICIO_REFERENCIADO;
	}
	
	@RequestMapping(value = "/captura.htm", method = RequestMethod.POST)
	public String captura(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /servicios/referenciados/captura.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SERVICIO_REFERENCIADO_CAPTURA;
	}
	
	@RequestMapping(value = "/confirma.htm", method = RequestMethod.POST)
	public String confirma(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /servicios/referenciados/confirma.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SERVICIO_REFERENCIADO_CONFIRMA;
	}
	
	@RequestMapping(value = "/comprobante.htm", method = RequestMethod.POST)
	public String comprobante(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /servicios/referenciados/comprobante.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SERVICIO_REFERENCIADO_COMPROBANTE;
	}
	
	/**
	 * Metodo para cancelar la transaccion
	 */
	@RequestMapping(value = "/cancela.htm", method = RequestMethod.GET)
	public String modalCancela(HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("titulo", "Cancelar la Transacci�n");
		modelMap.addAttribute("mensaje", "Usted perder� la transacci�n actual, dicha transaccion no podr� recuperarse.");
		modelMap.addAttribute("pregunta", "�Esta seguro de Cancelar la Transacci�n?");
		modelMap.addAttribute("action", "consultas/resumen-de-mis-cuentas.htm");
		modelMap.addAttribute("boton", "S�, cancelar");
		return AfirmeNetWebConstants.MODAL;
	}
	
	/**
	 * Metodo para regresar a selecciona
	 */
	@RequestMapping(value = "/atrasSelecciona.htm", method = RequestMethod.GET)
	public String atrasSelecciona(HttpServletRequest request,	ModelMap modelMap) {
		return AfirmeNetWebConstants.MV_PAGOS_SERVICIO_REFERENCIADO;
	}
	
	/**
	 * Metodo para regresar a captura
	 */
	@RequestMapping(value = "/atrasCaptura.htm", method = RequestMethod.GET)
	public String atrasCaptura(HttpServletRequest request,	ModelMap modelMap) {
		return AfirmeNetWebConstants.MV_PAGOS_SERVICIO_REFERENCIADO_CAPTURA;
	}
	

}
