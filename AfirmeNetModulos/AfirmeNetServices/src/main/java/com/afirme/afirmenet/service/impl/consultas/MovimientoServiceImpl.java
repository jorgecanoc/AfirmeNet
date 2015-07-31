package com.afirme.afirmenet.service.impl.consultas;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.consultas.MovimientoDao;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.service.consultas.MovimientoService;
import com.afirme.afirmenet.ibs.beans.consultas.Consulta;

@Service
public class MovimientoServiceImpl implements MovimientoService {
	static final Logger LOG = LoggerFactory
			.getLogger(MovimientoServiceImpl.class);
	@Autowired
	private MovimientoDao movimientoDao;

	@Override
	public Consulta ultimosMovimientos() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Consulta mesAnterior(String contrato, Consulta consulta) {
		//Consulta consulta = null;
		LOG.debug("Atendiendo mesAnterior="+consulta.getCuenta());
		String codigoBusqueda = MovimientoDao.CLAVE_MES_ANTERIOR;
		int mesActual = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int agnoActual = Calendar.getInstance().get(Calendar.YEAR);
		mesActual--;
		if(mesActual==0){
			mesActual=12;
			agnoActual--;
		}
		
		 GregorianCalendar fechaHoy=new GregorianCalendar();
		  fechaHoy.add(Calendar.MONTH,-1);
		  long diaMax=(long)fechaHoy.getActualMaximum(Calendar.DATE);
		
		String sfInicial = String.valueOf(agnoActual);
		//String pdfIni="01/"+(mesActual < 10 ? "0" : "") + mesActual+"/"+agnoActual;
		sfInicial += (mesActual < 10 ? "0" : "") + mesActual + "01";
		
		BigDecimal fInicial = new BigDecimal(sfInicial);

		String sfFinal = String.valueOf(agnoActual);
		sfFinal += (mesActual < 10 ? "0" : "") + mesActual + diaMax;

		//String pdfFin=+diaMax+"/"+(mesActual < 10 ? "0" : "") + mesActual+"/"+agnoActual;
		BigDecimal fFinal = new BigDecimal(sfFinal);


		BigDecimal refInicial = BigDecimal.ZERO;
		BigDecimal refFinal = BigDecimal.ZERO;
		BigDecimal impInicial = BigDecimal.ZERO;
		BigDecimal impFinal = BigDecimal.ZERO;
		
		consulta.setUsuario(contrato);
		//consulta.setCuenta(cuenta);
		consulta.setClave(codigoBusqueda);
		consulta.setFechaInicio(fInicial);
		consulta.setFechaFin(fFinal);
		consulta.setReferenciaFinal(refFinal);
		consulta.setReferenciaInicial(refInicial);
		consulta.setMontoInicial(impInicial);
		consulta.setMontoFinal(impFinal);
		//consulta.setPaginaActual(paginaActual);
		consulta.setRegXpagina(MovimientoDao._regXpag);
		consulta = movimientoDao.consultaOrdenada(consulta);
		return consulta;
	}

	@Override
	public Consulta mesActualRetenidos() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Consulta mesAnteriorRetenidos() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Consulta busqueda(String contrato, Consulta consulta) {
		LOG.debug("Atendiendo busqueda="+consulta.getCuenta());
		String codigoBusqueda = MovimientoDao.CLAVE_AVANZADA;
		consulta.setUsuario(contrato);
		consulta.setClave(codigoBusqueda);
		consulta.setRegXpagina(MovimientoDao._regXpag);
		consulta = movimientoDao.consultaOrdenada(consulta);
		return consulta;
	}

	@Override
	public Consulta mesActual(String contrato, Consulta consulta) {
		//Consulta consulta = null;
		LOG.debug("Atendiendo mesActual="+consulta.getCuenta());
		String codigoBusqueda = MovimientoDao.CLAVE_MES_ACTUAL;
		int mesActual = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int agnoActual = Calendar.getInstance().get(Calendar.YEAR);
		String sfInicial = String.valueOf(agnoActual);
		sfInicial += (mesActual < 10 ? "0" : "") + mesActual + "01";
		BigDecimal fInicial = new BigDecimal(sfInicial);
		String sfFinal = Util.getYYYYMMDD();
		BigDecimal fFinal = new BigDecimal(sfFinal);
		BigDecimal refInicial = BigDecimal.ZERO;
		BigDecimal refFinal = BigDecimal.ZERO;
		BigDecimal impInicial = BigDecimal.ZERO;
		BigDecimal impFinal = BigDecimal.ZERO;
		
		consulta.setUsuario(contrato);
		//consulta.setCuenta(cuenta);
		consulta.setClave(codigoBusqueda);
		consulta.setFechaInicio(fInicial);
		consulta.setFechaFin(fFinal);
		consulta.setReferenciaFinal(refFinal);
		consulta.setReferenciaInicial(refInicial);
		consulta.setMontoInicial(impInicial);
		consulta.setMontoFinal(impFinal);
		//consulta.setPaginaActual(paginaActual);
		consulta.setRegXpagina(MovimientoDao._regXpag);
		consulta = movimientoDao.consultaOrdenada(consulta);
		return consulta;
	}

	

}
