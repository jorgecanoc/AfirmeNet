package com.afirme.afirmenet.service.consultas;

import com.afirme.afirmenet.ibs.beans.consultas.Consulta;

public interface MovimientoService {
	public Consulta ultimosMovimientos();
	public Consulta mesActual(String contrato, Consulta consulta);
	public Consulta mesAnterior(String contrato, Consulta consulta);
	public Consulta mesActualRetenidos();
	public Consulta mesAnteriorRetenidos();
	public Consulta busqueda(String contrato, Consulta consulta);	
}
