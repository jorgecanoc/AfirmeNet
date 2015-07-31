package com.afirme.afirmenet.web.controller.pagos;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.pagos.PagosService;
import com.afirme.afirmenet.service.transferencia.Pago;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.transferencia.CuentasPropiasController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({"pago","cuentasPropias", "tdcList","horario","tipoTDC"})
@RequestMapping("/pagos/tdcPagos")
public class TDCPagosController extends PagosController{
	
	static final Logger LOG = LoggerFactory
			.getLogger(CuentasPropiasController.class);
	
	@Autowired
	private PagosService pagosService;
	
	@Autowired
	private Pago Pago;

	/**
	 * tipo de pago 
	 * TERCEROS (3)
	 * OTROS BANCOS (1)
	 * AMERICAN EXPRESS (2)
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/tdcPago.htm", method = RequestMethod.POST)
	public String selecciona(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcPagos/tdcPago.htm");
		
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.PAGO_SERVICIOS));
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		modelMap.addAttribute("cuentasPropias",
				getCuentasPropiasMXP(afirmeNetUser));
		
		String tipoTDC = (request.getParameter("tipoTDC") != null && !request.getParameter("tipoTDC")
				.equals("null")) ? request.getParameter("tipoTDC") : "";
		modelMap.addAttribute("tipoTDC",tipoTDC);
		
		modelMap.addAttribute("tdcList",
				getTarjetasOtrosPagos(afirmeNetUser,tipoTDC));	
		
		Servicio pago = new Servicio();
		pago.setContractId(afirmeNetUser.getContrato());
		pago.setEmail(afirmeNetUser.getCorreoElectronico());
		pago.setTransactionCode(TipoTransferencia.PAGO_DE_SERVICIOS.getValor());
		pago.setTipoTransferencia(TipoTransferencia.PAGO_DE_SERVICIOS);
		setTipoPago(tipoTDC,pago);
		modelMap.addAttribute("pago", pago);
		
		return AfirmeNetWebConstants.MV_PAGOS_TDC;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/captura_tdcPago.htm", method = RequestMethod.POST)
	public String captura(
			@ModelAttribute("pago") Servicio pago,HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcPagos/captura_tdcPago.htm");
		
		List<Cuenta> listaCuentas = (List<Cuenta>) modelMap
				.get("cuentasPropias");
		for (Cuenta cuenta : listaCuentas) {
			if (pago.getOrigen().getNumber()
					.equals(cuenta.getNumber())) {
				pago.setOrigen(cuenta);
				pago.setDebitAccount(cuenta.getNumber());
				break;
			}
		}
			
		List<DC_CONVENIO> listaTarjetas = (List<DC_CONVENIO>) modelMap
					.get("tdcList");
		for (DC_CONVENIO tarjeta : listaTarjetas) {
			if (pago.getConvenio().getSERACC()
					.equals(tarjeta.getSERACC())) {				
				pago.setConvenio(tarjeta);
				pago.setTipoServicio(TipoServicio.findByValorComercial(Integer.toString(pago.getConvenio().getSERCOM())));
				pago.setCreditAccount(pago.getConvenio().getSERACC());
				pago.setBeneficiaryName(pago.getConvenio().getTCNOMBRE());
				break;
			}

		}		
		
		modelMap.addAttribute("mapHoras", getHoras());

		return AfirmeNetWebConstants.MV_PAGOS_TDC_CAPTURA;
	}
	
	@RequestMapping(value = "/confirma_tdcPago.htm", method = RequestMethod.POST)
	public String confirma(
			@ModelAttribute("pago") Servicio pago,HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcPagos/confirma_tdcPago.htm");
		modelMap.addAttribute("pago", pago);

		String fechaProgramacion = request.getParameter("fechaProgramacion");
		String horaProgramacion = request.getParameter("hora");

		//Setea la fecha y hora
		if ((fechaProgramacion!=null && !fechaProgramacion.equals("")) && (horaProgramacion!=null && !horaProgramacion.equals(""))) {
		Date fechaIncioProgramacion = TimeUtils.getDate(fechaProgramacion + " "	+ horaProgramacion, "dd/MMMM/yyyy HH:mm");		
		setEjecucionInfo(pago, fechaIncioProgramacion);
		}else{
			
			String fechaDia=TimeUtils.getDateFormat(new Date(), "dd/MMMM/yyyy")+" 00:00";
			Date fechaIncioProgramacion = TimeUtils.getDate(fechaDia, "dd/MMMM/yyyy HH:mm");		
			setEjecucionInfo(pago, fechaIncioProgramacion);	
		}
		
		return AfirmeNetWebConstants.MV_PAGOS_TDC_CONFIRMA;
	}
	
	@RequestMapping(value = "/comprobante_tdcPago.htm", method = RequestMethod.POST)
	public String comprobante(
			@ModelAttribute("pago") Servicio pago,SessionStatus sessionStatus,HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcPagos/comprobante_tdcPago.htm");

		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		if(validaToken(request.getParameter("token"), afirmeNetUser.getContrato(),
				        afirmeNetUser.getContrato(),afirmeNetUser.isBasicoSinToken())){
				List<TransferenciaBase> listPagos = new ArrayList<TransferenciaBase>(
						0);
				listPagos.add(pago);
				String modelView =  ejecutaPagos(modelMap, listPagos,
						Pago, sessionStatus);
				Servicio transferenciaN = new Servicio();
				transferenciaN.setContractId(pago.getContractId());
				modelMap.addAttribute("pago", transferenciaN);
				return modelView;
		}

		return AfirmeNetWebConstants.MV_PAGOS_TDC_CONFIRMA; 
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
	public String atrasSelecciona(
			@ModelAttribute("pago") Servicio pago, HttpServletRequest request,	ModelMap modelMap) {
		return AfirmeNetWebConstants.MV_PAGOS_TDC;
	}
	
	/**
	 * Metodo para regresar a captura
	 */
	@RequestMapping(value = "/atrasCaptura.htm", method = RequestMethod.GET)
	public String atrasCaptura(HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("mapHoras", getHoras());
		return AfirmeNetWebConstants.MV_PAGOS_TDC_CAPTURA;
	}
	

}
