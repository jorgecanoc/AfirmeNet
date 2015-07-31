/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: SG_COTIZACIONES_DETAIL.java
 * Creado: May 19, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: SG_COTIZACIONES_DETAIL
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.util.Date;

/**
 * @author cosurof
 * 
 */
public class SG_COTIZACIONES_DETAIL {

	private double ID_COTIZACION;
	private String ID_VERSION_POL;
	private int ID_FORMA_PAGO;
	private int ID_PAQUETE;
	private int NUM_EXHIBICION;
	private double IMP_PRIMA_TOTAL;
	private double NUM_FOLIO_RBO;
	private Date F_VENCIMIENTO;

	public SG_COTIZACIONES_DETAIL() {
		this.ID_COTIZACION = 0;
		this.ID_VERSION_POL = "";
		this.ID_FORMA_PAGO = 0;
		this.ID_PAQUETE = 0;
		this.NUM_EXHIBICION = 0;
		this.IMP_PRIMA_TOTAL = 0;
		this.NUM_FOLIO_RBO = 0;
		this.F_VENCIMIENTO = new Date();
	}

	/**
	 * @return
	 */
	public double getID_COTIZACION() {
		return ID_COTIZACION;
	}

	/**
	 * @return
	 */
	public String getID_VERSION_POL() {
		return ID_VERSION_POL;
	}

	/**
	 * @param string
	 */
	public void setID_COTIZACION(double dob) {
		ID_COTIZACION = dob;
	}

	/**
	 * @param string
	 */
	public void setID_VERSION_POL(String string) {
		ID_VERSION_POL = string;
	}

	/**
	 * @return
	 */
	public int getID_FORMA_PAGO() {
		return ID_FORMA_PAGO;
	}

	/**
	 * @return
	 */
	public int getID_PAQUETE() {
		return ID_PAQUETE;
	}

	/**
	 * @return
	 */
	public int getNUM_EXHIBICION() {
		return NUM_EXHIBICION;
	}

	/**
	 * @param i
	 */
	public void setID_FORMA_PAGO(int i) {
		ID_FORMA_PAGO = i;
	}

	/**
	 * @param i
	 */
	public void setID_PAQUETE(int i) {
		ID_PAQUETE = i;
	}

	/**
	 * @param i
	 */
	public void setNUM_EXHIBICION(int i) {
		NUM_EXHIBICION = i;
	}

	/**
	 * @return
	 */
	public double getIMP_PRIMA_TOTAL() {
		return IMP_PRIMA_TOTAL;
	}

	/**
	 * @param d
	 */
	public void setIMP_PRIMA_TOTAL(double d) {
		IMP_PRIMA_TOTAL = d;
	}

	/**
	 * @return
	 */
	public Date getF_VENCIMIENTO() {
		return F_VENCIMIENTO;
	}

	/**
	 * @return
	 */
	public double getNUM_FOLIO_RBO() {
		return NUM_FOLIO_RBO;
	}

	/**
	 * @param date
	 */
	public void setF_VENCIMIENTO(Date date) {
		F_VENCIMIENTO = date;
	}

	/**
	 * @param d
	 */
	public void setNUM_FOLIO_RBO(double d) {
		NUM_FOLIO_RBO = d;
	}

}
