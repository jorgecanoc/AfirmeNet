package com.afirme.afirmenet.service.transferencia;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

@Component
@Scope("prototype")
public class Pago extends Transferencia{
	
	Pago() {
		super(TipoTransferencia.PAGO_DE_SERVICIOS);
	}
		
	@Autowired
	@Resource(name = "transferenciaPagoServiceImpl")
	TransferenciaAfirmeNet service;
	
	@Autowired
	ValidacionPagoServicioService pagoServicioService;
	
	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		return Arrays.asList(TipoValidacion.values());
	}

	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {
		pagoServicioService
		.sonServiciosValidos((List<Servicio>) transferencias);
		
	}

	@SuppressWarnings("unchecked")
	public List<? extends ComprobanteTransferencia> confirmaPagos() {
		// Validaciones Generales:
		validacion.applyValidations(pagos, tipoTransferencia, 
				getValidaciones());
		// Validaciones Particulares
		valida(pagos);
		// Ejecuta Transaccion
		List<? extends ComprobanteTransferencia> comprobantes = getTransferenciaService()
				.ejecutaTransferencia(pagos);
		// Validacion si fue marcada como favoritos
		favoritaService.procesaFavoritas((List<Comprobante>) comprobantes);
		
		return comprobantes;
	}

}
