package com.afirme.afirmenet.service.pagos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.dao.pagos.SegurosPagoDao;
import com.afirme.afirmenet.enums.CoberturaCardif;
import com.afirme.afirmenet.ibs.databeans.cardif.Cobertura;
import com.afirme.afirmenet.ibs.databeans.cardif.PagoCardif;
import com.afirme.afirmenet.ibs.databeans.cardif.SeguroCardif;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.transferencia.Transferencia;
import com.afirme.afirmenet.service.transferencia.TransferenciaAfirmeNet;
import com.afirme.afirmenet.service.transferencia.ValidacionEspecificaTransferenciaService;

@Component
@Scope("prototype")
public class SegurosCardifService extends Transferencia{
	@Autowired
	@Resource(name = "seguroCardifServiceImpl")
	TransferenciaAfirmeNet service;
	@Autowired
	private SegurosPagoDao segurosPagoDao;

	@Autowired
	protected ValidacionEspecificaTransferenciaService validacionEspecifica;
	static final Logger LOG = LoggerFactory.getLogger(SegurosCardifService.class);
	
	SegurosCardifService() {
		super(TipoTransferencia.VENTA_DE_SEGUROS_ANTIFRAUDE);
	}
/*
	public SeguroCardif tienePoliza(BigDecimal cliente);
	public List<PagoCardif> consultaCobranza(SeguroCardif oBeanCardif);
	public List<SeguroCardif> consultaComprobantes(String contrato, String fechaIni, String fechaFin);
	public Cobertura obtenerCobertura(CoberturaCardif tipo);
*/
	@Override
	public TransferenciaAfirmeNet getTransferenciaService() {
		return service;
	}

	@Override
	public List<TipoValidacion> getValidaciones() {
		return Arrays.asList(TipoValidacion.HORARIO, TipoValidacion.FECHA);
	}

	@Override
	public List<TipoValidacionEspecial> getValidacionesEspecificas() {
		TipoValidacionEspecial valida[] = new TipoValidacionEspecial[]{TipoValidacionEspecial.SEGURO_CARDIF}; 
		return Arrays.asList(valida);
	}

	@Override
	public void valida(List<? extends TransferenciaBase> transferencias) {
		validacionEspecifica.applicaValidaticioEspecifica(transferencias, getValidacionesEspecificas(), getTransferenciaService());
	}

	
	public SeguroCardif tienePoliza(BigDecimal cliente) {
		return segurosPagoDao.tienePoliza(cliente);
	}

	
	public List<PagoCardif> consultaCobranza(SeguroCardif oBeanCardif) {
		return segurosPagoDao.consultaCobranza(oBeanCardif);
	}

	
	public List<SeguroCardif> consultaComprobantes(String contrato,
			String fechaIni, String fechaFin) {
		return segurosPagoDao.consultaComprobantes("", contrato, fechaIni, fechaFin);
	}

	
	public Cobertura obtenerCobertura(CoberturaCardif tipo) {
		//Cobertura deChocolate=null;
		Cobertura cobertura= new Cobertura();
		cobertura.setTipo(tipo);
		switch (tipo) {
		case BASICO:
			cobertura.setNombre("Básico");
			cobertura.setCostoMensual(new BigDecimal(40));
			cobertura.setTarjetas(new BigDecimal(25000));
			cobertura.setCheques(new BigDecimal(25000));
			cobertura.setInternet(new BigDecimal(25000));
			cobertura.setCajeros(new BigDecimal(5000));
			cobertura.setCompra(new BigDecimal(25000));
			break;
		case ORO:
			cobertura.setNombre("Oro");
			cobertura.setCostoMensual(new BigDecimal(60));
			cobertura.setTarjetas(new BigDecimal(50000));
			cobertura.setCheques(new BigDecimal(50000));
			cobertura.setInternet(new BigDecimal(50000));
			cobertura.setCajeros(new BigDecimal(5000));
			cobertura.setCompra(new BigDecimal(50000));
			break;
		case PLATINO:
			cobertura.setNombre("Platino");
			cobertura.setCostoMensual(new BigDecimal(95));
			cobertura.setTarjetas(new BigDecimal(100000));
			cobertura.setCheques(new BigDecimal(100000));
			cobertura.setInternet(new BigDecimal(100000));
			cobertura.setCajeros(new BigDecimal(5000));
			cobertura.setCompra(new BigDecimal(100000));
			break;
		}
		//return deChocolate;
		return cobertura;
	}

}
