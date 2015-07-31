package com.afirme.afirmenet.web.controller.tdc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.service.tarjetas.TDCService;
import com.afirme.afirmenet.service.transferencia.PagoTDC;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.web.controller.pagos.PagosController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({"pago","cuentasPropias", "tdcPropias","horario"})
@RequestMapping("/tdc/domiciliacion")
public class DomiciliacionController extends PagosController{
	
	static final Logger LOG = LoggerFactory
			.getLogger(DomiciliacionController.class);
	
	
	@Autowired
	private TDCService tdcService;
	
	@Autowired
	private PagoTDC Pago;
	
	@RequestMapping(value = "/tdcDomi.htm", method = RequestMethod.POST)
	public String selecciona(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /tdc/domiciliacion/tdcSelecciona.htm");	
		
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.PROGRAMACION_PAGO_AUT_TDC));
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		modelMap.addAttribute("cuentasPropias",
				getCuentasPropiasMXP(afirmeNetUser));		
		modelMap.addAttribute("tdcPropias",
				getTarjetasSinAdicionales(afirmeNetUser));		
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.PAGO_SERVICIOS));
		
		Servicio pago = new Servicio();
		pago.setContractId(afirmeNetUser.getContrato());
		pago.setEmail(afirmeNetUser.getCorreoElectronico());
		modelMap.addAttribute("pago", pago);
		
		return AfirmeNetWebConstants.MV_TDCDOMI;
	}
	
	@RequestMapping(value = "/contrato_tdcDomi.htm", method = RequestMethod.GET)
	public String captura(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion =/pagos/tdcDomiciliar/contrato_tdcDomi.htm");
		return AfirmeNetWebConstants.MV_TDCDOMI_CONTRATO;
	}
	
	@RequestMapping(value = "/confirma_tdcDomi.htm", method = RequestMethod.GET)
	public String confirma(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcDomiciliar/confirma_tdcDomi.htm");
		return AfirmeNetWebConstants.MV_TDCDOMI_CONFIRMA;
	}
	
	@RequestMapping(value = "/comprobante_tdcDomi.htm", method = RequestMethod.POST)
	public String comprobante(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcDomiciliar/comprobante_tdcDomi.htm");
		return AfirmeNetWebConstants.MV_TDCDOMI_COMPROBANTE;
	}
	
	/**
	 * Metodo para cancelar la transaccion
	 */
	@RequestMapping(value = "/cancela.htm", method = RequestMethod.GET)
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
	@RequestMapping(value = "/atrasSelecciona.htm", method = RequestMethod.GET)
	public String atrasSelecciona(HttpServletRequest request,	ModelMap modelMap) {
		return AfirmeNetWebConstants.MV_TDCDOMI;
	}

}
