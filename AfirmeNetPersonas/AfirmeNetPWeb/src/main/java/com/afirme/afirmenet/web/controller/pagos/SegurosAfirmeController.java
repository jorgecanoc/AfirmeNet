package com.afirme.afirmenet.web.controller.pagos;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.afirme.afirmenet.service.acceso.UserService;
import com.afirme.afirmenet.service.pagos.SegurosCardifService;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@RequestMapping("/pagos/seguros/afirme")
public class SegurosAfirmeController extends TransferenciaController {

	@Autowired
	private SegurosCardifService segurosPagoService;
	@Autowired
	private UserService userService;
	
	static final Logger LOG = LoggerFactory
			.getLogger(SegurosAfirmeController.class);

	@RequestMapping(value = "/seguros.htm", method = RequestMethod.POST)
	public String selecciona(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/seguros/seguroPago.htm");

		
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO_AFIRME;
	}
	
	@RequestMapping(value = "/captura_seguroPago.htm", method = RequestMethod.POST)
	public String captura(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/seguros/captura_seguroPago.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO_AFIRME_CAPTURA;
	}
	
	@RequestMapping(value = "/confirma_seguroPago.htm", method = RequestMethod.POST)
	public String confirma(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/seguros/confirma_seguroPago.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO_AFIRME_CONFIRMA;
	}
	
	@RequestMapping(value = "/comprobante_seguroPago.htm", method = RequestMethod.POST)
	public String comprobante(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/seguros/comprobante_seguroPago.htm");
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO_AFIRME_COMPROBANTE;
	}
	
	/**
	 * Metodo para cancelar la transaccion
	 */
	@RequestMapping(value = "/cancelaPago.htm", method = RequestMethod.GET)
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
	@RequestMapping(value = "/atrasSeleccionaPago.htm", method = RequestMethod.GET)
	public String atrasSelecciona(HttpServletRequest request,	ModelMap modelMap) {
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO_AFIRME;
	}
	
	/**
	 * Metodo para regresar a captura
	 */
	@RequestMapping(value = "/atrasCapturaPago.htm", method = RequestMethod.GET)
	public String atrasCaptura(HttpServletRequest request,	ModelMap modelMap) {
		return AfirmeNetWebConstants.MV_PAGOS_SEGURO_AFIRME_CAPTURA;
	}
	

}
