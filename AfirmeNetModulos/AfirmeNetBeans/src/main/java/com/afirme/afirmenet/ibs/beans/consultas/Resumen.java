package com.afirme.afirmenet.ibs.beans.consultas;

import java.math.BigDecimal;

import com.afirme.afirmenet.ibs.generics.Util;

public class Resumen implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2133817530897964716L;
	
	private String descripcion;
	private BigDecimal total;
	private int cuentas;
	/**
	 * @return el descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion el descripcion a establecer
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return el total
	 */
	public BigDecimal getTotal() {
		return total;
	}
	/**
	 * @return el total
	 */
	public String getTotalStr() {
		return Util.formatCCY(total);
	}
	/**
	 * @param total el total a establecer
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	/**
	 * @return el cuentas
	 */
	public int getCuentas() {
		return cuentas;
	}
	/**
	 * @param cuentas el cuentas a establecer
	 */
	public void setCuentas(int cuentas) {
		this.cuentas = cuentas;
	}
	public int getTieneCuentas(){
		return cuentas>0?1:0;
	}

}
