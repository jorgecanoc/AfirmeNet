package com.afirme.afirmenet.service.transferencia;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.model.transferencia.DomingoElectronico;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;


@Component
@Scope("prototype")
public class DomingoElectronicoService extends Transferencia {

	@Autowired
	@Resource(name = "transferenciaProgramadaGenericaServiceImpl")
	TransferenciaAfirmeNet service;

	@Autowired
	TransferenciaService transferenciaService;
	
	DomingoElectronicoService() {
		super(TipoTransferencia.DOMINGO_ELECTRONICO);
	}

	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {

	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		return Arrays.asList(TipoValidacion.LIMITE_DIARIO,
				TipoValidacion.LIMITE_MENSUAL, TipoValidacion.FECHA);
	}

	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		return null;
	}
	
	public void generaRegistroPagoConcentrado(
			DomingoElectronico domingoElectronico) {
		transferenciaService.generaRegistroPagoConcentrado(domingoElectronico);
	}

}
