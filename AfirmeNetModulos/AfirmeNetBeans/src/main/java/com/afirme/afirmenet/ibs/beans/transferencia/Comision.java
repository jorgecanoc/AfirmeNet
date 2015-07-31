package com.afirme.afirmenet.ibs.beans.transferencia;

import java.math.BigDecimal;

public class Comision  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal fija;
	private BigDecimal porcentaje;
	/**
	 * @return el fija
	 */
	public BigDecimal getFija() {
		return fija;
	}
	/**
	 * @param fija el fija a establecer
	 */
	public void setFija(BigDecimal fija) {
		this.fija = fija;
	}
	/**
	 * @return el porcentaje
	 */
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	/**
	 * @param porcentaje el porcentaje a establecer
	 */
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
}
