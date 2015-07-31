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
public class PagoImpuestosGDFService extends Transferencia {

	@Autowired
	@Resource(name = "pagoImpuestosGDFServiceImpl")
	TransferenciaAfirmeNet service;
	
	public PagoImpuestosGDFService() {
		super(TipoTransferencia.PAGO_TESORERIA_GOBIERNO_DISTRITO_FEDERAL);
	}
	
	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		return Arrays.asList(TipoValidacion.FECHA, TipoValidacion.HORARIO);
	}

	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		return null;
	}

	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {
	}

}
