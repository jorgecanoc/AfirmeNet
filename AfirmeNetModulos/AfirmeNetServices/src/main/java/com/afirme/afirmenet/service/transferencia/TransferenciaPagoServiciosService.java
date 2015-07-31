package com.afirme.afirmenet.service.transferencia;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

@Component
@Scope("prototype")
public class TransferenciaPagoServiciosService extends Transferencia {

	TransferenciaPagoServiciosService() {
		super(TipoTransferencia.PAGO_DE_SERVICIOS);
	}

	@Autowired
	@Resource(name = "transferenciaGenericaServiceImpl")
	TransferenciaAfirmeNet service;

	@Autowired
	ValidacionPagoServicioService pagoServicioService;

	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		TipoValidacion valida[] = new TipoValidacion[] {
				TipoValidacion.LIMITE_DIARIO, TipoValidacion.LIMITE_MENSUAL };
		return Arrays.asList(valida);
	}

	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {
		pagoServicioService
				.sonServiciosValidos((List<Servicio>) transferencias);

	}

}
