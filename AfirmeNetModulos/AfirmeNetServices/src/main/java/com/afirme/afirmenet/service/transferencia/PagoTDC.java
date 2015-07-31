package com.afirme.afirmenet.service.transferencia;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

@Component
@Scope("prototype")
public class PagoTDC extends Transferencia{
	
	@Autowired
	@Resource(name = "transferenciaPagoServiceImpl")
	TransferenciaAfirmeNet service;
	
	PagoTDC() {
		super(TipoTransferencia.PAGO_DE_SERVICIOS);
	}

	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		TipoValidacion valida[]=new TipoValidacion[]{TipoValidacion.FECHA,TipoValidacion.HORARIO}; 
		return Arrays.asList(valida);
	}

	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {
		// TODO Apéndice de método generado automáticamente
		
	}

}
