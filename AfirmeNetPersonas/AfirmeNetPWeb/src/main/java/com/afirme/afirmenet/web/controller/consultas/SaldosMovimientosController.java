package com.afirme.afirmenet.web.controller.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.afirme.afirmenet.ibs.beans.consultas.Consulta;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.beans.consultas.Resumen;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.consultas.MovimientoService;
import com.afirme.afirmenet.web.controller.base.BaseController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

/**
 * Controller que atiende peticiones de saldos y movimientos
 * 
 * 
 * @author Arturo Ivan Martinez Mata
 * 
 */
@Controller
@RequestMapping("/consultas")
public class SaldosMovimientosController extends BaseController {


	static final Logger LOG = LoggerFactory.getLogger(SaldosMovimientosController.class);
	@Autowired(required=true)
	private CuentaService cuentaService;
	@Autowired
	private MovimientoService movimientoService;
	
	/**
	 * Metodo que atiende las peticiones al contexto /resumen-de-mis-cuentas.htm
	 * En el cual se muestran el saldo de todas las cuentas del cliente de manera global 
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping("/resumen-de-mis-cuentas.htm")
	public String resumen(ModelMap model, HttpServletRequest request) {
		LOG.debug("Atendiendo Peticion = "+request.getServletPath());
		AfirmeNetUser afirmeNetUser=getSessionUser(request);
		
		List<Cuenta> cuentasTodas=cuentaService.getCuentas(afirmeNetUser.getContrato(), afirmeNetUser.getCuentasExcluyentes(), true);
		List<Cuenta> cuentas=cuentaService.segmentaCuentasPorTipo(Cuenta.TIPO_CUENTA, cuentasTodas);
		List<Cuenta> creditos=cuentaService.segmentaCuentasPorTipo(Cuenta.TIPO_CREDITO, cuentasTodas);
		List<Cuenta> inversiones=cuentaService.segmentaCuentasPorTipo(Cuenta.TIPO_INVERSION, cuentasTodas);
		List<Resumen> resumen=new ArrayList<Resumen>();
		Resumen resumenCuentas=cuentaService.calculaResumenPorCuenta(Cuenta.TIPO_CUENTA, cuentas);
		Resumen resumenCreditos=cuentaService.calculaResumenPorCredito(Cuenta.TIPO_CREDITO, creditos);
		Resumen resumenInversiones=cuentaService.calculaResumenPorCuenta(Cuenta.TIPO_INVERSION, inversiones);
		if(resumenCuentas.getTieneCuentas()>0)
			resumen.add(resumenCuentas);
		if(resumenCreditos.getTieneCuentas()>0)
			resumen.add(resumenCreditos);
		if(resumenInversiones.getTieneCuentas()>0)
			resumen.add(resumenInversiones);
		model.addAttribute("cuentas", cuentas);
		model.addAttribute("creditos", creditos);
		model.addAttribute("inversiones", inversiones);
		model.addAttribute("resumen", resumen);
		request.getSession().setAttribute(AfirmeNetWebConstants.CUENTAS_SESSION, cuentas);
		request.getSession().setAttribute(AfirmeNetWebConstants.INVERSIONES_SESSION, inversiones);
		return AfirmeNetWebConstants.MV_CONSULTAS_SM_RESUMEN;
	}
	/**
	 * Metodo que atiende las peticiones al contexto /detalle-ultimos-movimientos.htm
	 * En el cual se muestran los ultimos X movimientos de la cuenta seleccionada 
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/detalle-ultimos-movimientos.htm", method = RequestMethod.POST)
	public String ultimos(@ModelAttribute("consulta") Consulta consulta, ModelMap model, HttpServletRequest request) {
		LOG.debug("Atendiendo Peticion = "+request.getServletPath());
		AfirmeNetUser afirmeNetUser=getSessionUser(request);
		consulta.setPaginaActual(1);
		List<Cuenta> cuentas=(List<Cuenta>)request.getSession().getAttribute(AfirmeNetWebConstants.CUENTAS_SESSION);
		Cuenta tempCuenta=cuentaService.seleccionaCuenta(consulta.getCuenta().toString(), cuentas);
		if(tempCuenta==null){
			cuentas=(List<Cuenta>)request.getSession().getAttribute(AfirmeNetWebConstants.INVERSIONES_SESSION);
			tempCuenta=cuentaService.seleccionaCuenta(consulta.getCuenta().toString(), cuentas);
		}
		consulta.setCuentaClabe(tempCuenta.getClabe());
		consulta.setCuentaDesc(tempCuenta.getDescription());
		consulta.setCuentaMoneda(tempCuenta.getCcy());
		consulta.setCuentaNombre(tempCuenta.getNickname());
		
		consulta=movimientoService.mesActual(afirmeNetUser.getContrato(), consulta);
		model.addAttribute("consulta", consulta);
		return AfirmeNetWebConstants.MV_CONSULTAS_SM_DETALLE_ULTIMOS;
	}
	/**
	 * Metodo que atiende las peticiones al contexto /detalle-todos-movimientos.htm
	 * En el cual se muestran todos los movimientos del mes en curso de la cuenta seleccionada 
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping(value = "/detalle-todos-movimientos.htm", method = RequestMethod.POST)
	public String todos(@ModelAttribute("consulta") Consulta consulta,ModelMap model, HttpServletRequest request) {
		LOG.debug("Atendiendo Peticion = "+request.getServletPath());
		AfirmeNetUser afirmeNetUser=getSessionUser(request);
		consulta=movimientoService.mesActual(afirmeNetUser.getContrato(), consulta);
		model.addAttribute("consulta", consulta);
		return AfirmeNetWebConstants.MV_CONSULTAS_SM_DETALLE_TODOS;
	}
	/**
	 * Metodo que atiende las peticiones al contexto /detalle-todos-movimientos-anterior.htm
	 * En el cual se muestran todos los movimientos del mes anterior de la cuenta seleccionada 
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping(value = "/detalle-todos-movimientos-anterior.htm", method = RequestMethod.POST)
	public String mesAnterior(@ModelAttribute("consulta") Consulta consulta,ModelMap model, HttpServletRequest request) {
		LOG.debug("Atendiendo Peticion = "+request.getServletPath());
		AfirmeNetUser afirmeNetUser=getSessionUser(request);
		consulta=movimientoService.mesAnterior(afirmeNetUser.getContrato(), consulta);
		model.addAttribute("consulta", consulta);
		return AfirmeNetWebConstants.MV_CONSULTAS_SM_DETALLE_TODOS;
	}
	/**
	 * Metodo que atiende las peticiones al contexto /detalle-movimientos-retenidos.htm
	 * En el cual se muestran los movimientos retenidos y diferidos del mes en curso de la cuenta seleccionada 
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping(value = "/detalle-movimientos-retenidos.htm", method = RequestMethod.POST)
	public String retenidos(@ModelAttribute("consulta") Consulta consulta, ModelMap model, HttpServletRequest request) {
		model.addAttribute("consulta", consulta);
		return AfirmeNetWebConstants.MV_CONSULTAS_SM_DETALLE_RETENIDOS;
	}
	/**
	 * Metodo que atiende las peticiones al contexto /buscar-movimientos-filtro.htm
	 * En el cual se muestran los filtros para la busqueda avanzada de movimientos 
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping(value = "/buscar-movimientos-filtro.htm", method = RequestMethod.POST)
	public String buscarFiltro(@ModelAttribute("consulta") Consulta consulta,ModelMap model, HttpServletRequest request) {
		model.addAttribute("consulta", consulta);
		return AfirmeNetWebConstants.MV_CONSULTAS_SM_BUSQUEDA_FILTROS;
	}
	/**
	 * Metodo que atiende las peticiones al contexto /buscar-movimientos-resultado.htm
	 * En el cual se muestran los resultados de la busqueda avanzada de movimientos 
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping(value = "/buscar-movimientos-resultado.htm", method = RequestMethod.POST)
	public String buscarResultado(@ModelAttribute("consulta") Consulta consulta,ModelMap model, HttpServletRequest request) {
		LOG.debug("Atendiendo Peticion = "+request.getServletPath());
		AfirmeNetUser afirmeNetUser=getSessionUser(request);
		if(request.getParameter("fechaInicioStr")!=null){
			//System.out.println(request.getParameter("datepicker"));
			consulta.setFechaInicio(Util.fechaDeDatePicker(request.getParameter("fechaInicioStr")));
			//System.out.println(consulta.getFechaInicio());
			consulta.setFechaFin(Util.fechaDeDatePicker(request.getParameter("fechaFinStr")));
		}
		consulta=movimientoService.busqueda(afirmeNetUser.getContrato(), consulta);
		model.addAttribute("consulta", consulta);
		return AfirmeNetWebConstants.MV_CONSULTAS_SM_BUSQUEDA_RESULTADO;
	}
	
	@RequestMapping("/edo-cta-activacion.htm")
	public String activacionEstadoCuenta() {
		return AfirmeNetWebConstants.MV_CONSULTAS_EDO_CTA_ACTIVACION;
	}
}
