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
import com.afirme.afirmenet.ibs.beans.tarjetas.DatosTDC;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.TC5000PF;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.tarjetas.TDCService;
import com.afirme.afirmenet.service.transferencia.PagoTDC;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({"pago","cuentasPropias", "tdcPropias","horario"})
@RequestMapping("/pagos/tdcPropias")
public class TDCPropiasController extends PagosController{
	
	static final Logger LOG = LoggerFactory
			.getLogger(TDCPropiasController.class);
	
	@Autowired
	private TDCService tdcService;
	
	@Autowired
	private PagoTDC Pago;
	

	@RequestMapping(value = "/tdcPropia.htm", method = RequestMethod.POST)
	public String selecciona(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcPagos/tdcPropia.htm");	
		
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.PAGO_SERVICIOS));
		
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
		pago.setTransactionCode(TipoTransferencia.PAGO_DE_SERVICIOS.getValor());
		pago.setTipoTransferencia(TipoTransferencia.PAGO_DE_SERVICIOS);
		modelMap.addAttribute("pago", pago);
		
		return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/captura_tdcPropia.htm", method = RequestMethod.POST)
	public String captura(
			@ModelAttribute("pago") Servicio pago,HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion =/pagos/tdcPagos/captura_tdcPropia.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
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
		
		List<TC5000PF> listaTarjetas = (List<TC5000PF>) modelMap
				.get("tdcPropias");
		for (TC5000PF tarjeta : listaTarjetas) {
			if (pago.getDatosTDC().getTdcTDCC()
					.equals(tarjeta.getTCTARJ())) {
				pago.setDatosTDC(tdcService.getDatosMQ(setDatosTDC(afirmeNetUser,tarjeta)));
				pago.setCreditAccount(pago.getDatosTDC().getTdcTDCC());
				pago.setBeneficiaryName(pago.getDatosTDC().getTdcNOMCLIE());				
				DC_CONVENIO convenio=new DC_CONVENIO();
				convenio.setSERACC(pago.getDatosTDC().getTdcTDCC());
				//DATOS FIJOS PARA EL PAGO DE TDC PROPIAS
				convenio.setSERDTR(7731);
				convenio.setSERTYP(2);
				convenio.setSERCOM(201);
				convenio.setTCNOMBRE("PAGO DE TARJETA DE CREDITO");				
				pago.setConvenio(convenio);
				pago.setTipoServicio(TipoServicio.findByValorComercial(Integer.toString(pago.getConvenio().getSERCOM())));
				break;
			}

		}
		
		modelMap.addAttribute("mapHoras", getHoras());

		return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS_CAPTURA;
	}
	
	@RequestMapping(value = "/confirma_tdcPropia.htm", method = RequestMethod.POST)
	public String confirma(
			@ModelAttribute("pago") Servicio pago, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcPagos/confirma_tdcPropia.htm");
		
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
		
		
		
		return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS_CONFIRMA;
	}
	
	@RequestMapping(value = "/comprobante_tdcPropia.htm", method = RequestMethod.POST)
	public String comprobante(
			@ModelAttribute("pago") Servicio pago,SessionStatus sessionStatus, HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /pagos/tdcPagos/comprobante_tdcPropia.htm");
		
		// Se crea la lista de transferencias
		List<TransferenciaBase> listPagos = new ArrayList<TransferenciaBase>(
				0);
		listPagos.add(pago);

		String modelView =  ejecutaTransferencia(modelMap, listPagos,
				Pago, sessionStatus);
		
		Servicio transferenciaN = new Servicio();
		transferenciaN.setContractId(pago.getContractId());
		modelMap.addAttribute("pago", transferenciaN);
		return modelView;
		//return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS_COMPROBANTE;
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
		return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS;
	}
	
	/**
	 * Metodo para regresar a captura
	 */
	@RequestMapping(value = "/atrasCaptura.htm", method = RequestMethod.GET)
	public String atrasCaptura(HttpServletRequest request,	ModelMap modelMap) {
		modelMap.addAttribute("mapHoras", getHoras());
		return AfirmeNetWebConstants.MV_PAGOS_TDCPROPIAS_CAPTURA;
	}
	
	
	/**
	 * Metodo para llenar el bean para la consulta de saldos
	 */
	public DatosTDC setDatosTDC(AfirmeNetUser afirmeNetUser,TC5000PF tarjeta) {
		
		DatosTDC beanDatosTDC = new DatosTDC();

		beanDatosTDC.setTdcSUCO("501");
		beanDatosTDC.setTdcTRNM("0001");
		beanDatosTDC.setTdcCTO(afirmeNetUser.getContrato());
		beanDatosTDC.setTdcUSER(afirmeNetUser.getContrato());
		beanDatosTDC.setTdcCLIE(afirmeNetUser.getNumCliente());
		beanDatosTDC.setTdcTDCC(tarjeta.getTCTARJ());
		beanDatosTDC.setTdcNOMCLIE(tarjeta.getTCNOMB());
		
		return beanDatosTDC;
	}


}
