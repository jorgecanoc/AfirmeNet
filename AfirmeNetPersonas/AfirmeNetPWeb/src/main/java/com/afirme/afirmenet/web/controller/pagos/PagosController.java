package com.afirme.afirmenet.web.controller.pagos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.enums.ConfigConvenios;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.TC5000PF;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.model.transferencia.TransferenciaCuentasPropias;
import com.afirme.afirmenet.service.pagos.PagosService;
import com.afirme.afirmenet.service.tarjetas.TDCService;
import com.afirme.afirmenet.service.transferencia.Pago;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Component
public class PagosController extends TransferenciaController{
	
	static final Logger LOG = LoggerFactory
			.getLogger(PagosController.class);
	
	@Autowired
	protected TDCService tdcService;
	@Autowired
	protected PagosService pagosService;
	
	public List<TC5000PF> getTarjetas(AfirmeNetUser afirmeNetUser) {

		List<TC5000PF> listaTarjetas = tdcService.getListaTDC(
				afirmeNetUser.getNumCliente());

		return listaTarjetas;
	}
	
	public List<TC5000PF> getTarjetasSinAdicionales(AfirmeNetUser afirmeNetUser) {

		List<TC5000PF> listaTarjetas = tdcService.getListaTDCNoAdicional(getTarjetas(afirmeNetUser));

		return listaTarjetas;
	}
	
	public List<DC_CONVENIO> getTarjetasOtrosPagos(AfirmeNetUser afirmeNetUser,String tipoTDC) {
		List<DC_CONVENIO> listaTarjetas;
			if(!tipoTDC.equals("4")){
				listaTarjetas = pagosService.getConvenios(afirmeNetUser.getContrato(), tipoTDC);
			}else{
				listaTarjetas = pagosService.getConveniosSeg(afirmeNetUser.getContrato());
			}
		return listaTarjetas;
	}
	
	
	public void setTipoPago(String tipoTDC,Servicio pago){
		
		if (tipoTDC.equals("1")) {
			pago.setInterType(ConfigConvenios.TDC_OTROS_BANCOS.getValor());
			pago.setServiceType(ConfigConvenios.TDC.getValor());	
			pago.setTipoServicio(TipoServicio.AGUA_Y_DRENAJE_DE_MONTERREY);
		}else if (tipoTDC.equals("2")) {
			pago.setInterType(ConfigConvenios.TDC_AMERICAN_EXPRESS.getValor());
			pago.setServiceType(ConfigConvenios.TDC.getValor());
		}else if(tipoTDC.equals("3")) {
			pago.setInterType(ConfigConvenios.TDC_AFIRME.getValor());
			pago.setServiceType(ConfigConvenios.TDC.getValor());
			
		}else{
			pago.setInterType(ConfigConvenios.TDC_AFIRME.getValor());
			pago.setServiceType(ConfigConvenios.TDC.getValor());
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public String ejecutaPagos(ModelMap modelMap,
			List<TransferenciaBase> listPagos, Pago servicio,
			SessionStatus sessionStatus) {
		String modelView = "";
		// Se evaluan las transferencias y se conforma la lista final
		List<TransferenciaBase> a400 = new ArrayList<TransferenciaBase>(0);
		List<TransferenciaBase> conErrores = new ArrayList<TransferenciaBase>(0);
		// Validacion de Trnasferencia
		LOG.debug("TransController- La lista tiene: "
				+ listPagos.size() + " elementos.");
		for (TransferenciaBase px : listPagos) {
			if (px.getErrores() == null || px.getErrores().isEmpty()) {
				a400.add(px);
			} else {
				conErrores.add(px);
			}
		}

		List<Comprobante> comprobantes = new ArrayList<Comprobante>(0);
		List<Comprobante> comprobantesExito = new ArrayList<Comprobante>(0);
		// Validacion de AS400
		LOG.debug("TransController- La lista As400 tiene: " + a400.size()
				+ " elementos.");
		if (!a400.isEmpty()) {
			// Se procesan las trasferencias
			servicio.setPagos(a400);
			comprobantes = (List<Comprobante>) servicio
					.confirmaPagos();
		}

		// Se generan los comprobante de las descartadas previamente
		for (Comprobante comprobante : comprobantes) {
			if (comprobante.getErrores() != null) {
				// Crea comprobantes
				conErrores.add(comprobante);
			} else {
				comprobantesExito.add(comprobante);
			}
		}

		// Se genera la lista de errores
		Map<String, List<String>> errores = getErrores(conErrores);

		TipoTransferencia tipo = comprobantes.get(0).getTipoTransferencia();
		if (modelMap.containsKey("esFavoritas")
				&& (Boolean) modelMap.get("esFavoritas")) {
			tipo = TipoTransferencia.FAVORITAS;
		}
		switch (tipo) {
		case PAGO_DE_SERVICIOS:
				if (errores.size() > 0) {
					modelMap.addAttribute("errores", errores);
					modelMap.addAttribute("listaTransferencias",
							new ArrayList<TransferenciaCuentasPropias>());
					modelView = AfirmeNetWebConstants.MV_PAGOS_TDC;
				} else {
					sessionStatus.setComplete();
					modelMap.addAttribute("listTransferencias",
							comprobantesExito);
					modelView = AfirmeNetWebConstants.MV_PAGOS_TDC_COMPROBANTE;
				}

			break;
		default:
			break;
		}

		return modelView;
	}
	

	
}
