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
import com.afirme.afirmenet.model.transferencia.TransferenciaCuentasPropias;

@Component
@Scope("prototype")
public class TransferenciaPropiasService extends Transferencia{
	
	@Autowired
	@Resource(name = "transferenciaPropiasServiceImpl")
	TransferenciaAfirmeNet service;
	
	@Autowired
	protected ValidacionEspecificaTransferenciaService validacionEspecifica;
	
	TransferenciaPropiasService() {
		super(TipoTransferencia.TRASPASO_PROPIAS);
	}

	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {

		validacionEspecifica.applyValidationsEspecific(
				(List<TransferenciaCuentasPropias>) transferencias,
				tipoTransferencia, getValidacionesEspecificas());

	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		TipoValidacion valida[]=new TipoValidacion[]{TipoValidacion.FECHA,TipoValidacion.HORARIO}; 
		return Arrays.asList(valida);
	}
	
	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		TipoValidacionEspecial valida[]=new TipoValidacionEspecial[]{TipoValidacionEspecial.CLAVE_CAMBIO_PREFERENCIAL}; 
		return Arrays.asList(valida);
	}

}
