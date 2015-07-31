package com.afirme.afirmenet.dao.consultas;

import com.afirme.afirmenet.ibs.beans.consultas.Consulta;

public interface MovimientoDao {
	final int _regXpag=25;

	public static String CLAVE_MES_ANTERIOR="X";
	public static String CLAVE_MES_ACTUAL=" ";
	public static String CLAVE_AVANZADA="C";
	public Consulta consultaOrdenada(Consulta consulta);

	
}
