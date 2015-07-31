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
public class DolaresService extends Transferencia {

	@Autowired
	@Resource(name = "transferenciaGenericaServiceImpl")
	TransferenciaAfirmeNet service;
	
	DolaresService() {
		super(TipoTransferencia.TRANSFERENCIAS_INTERNACIONALES_DOLARES);
	}

	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		return Arrays.asList(TipoValidacion.LIMITE_DIARIO, TipoValidacion.LIMITE_MENSUAL);
	}

	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		TipoValidacionEspecial valida[] = new TipoValidacionEspecial[]{TipoValidacionEspecial.CLAVE_CAMBIO_PREFERENCIAL}; 
		return Arrays.asList(valida);
	}

	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {
		// TODO Auto-generated method stub
		
	}

}
