/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: SG_DATOS_VARIOS.java
 * Creado: Jun 30, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: SG_DATOS_VARIOS
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

/**
 * @author cosurof
 * 
 */
public class SG_DATOS_VARIOS {

	private String ID_PAQUETE;
	private String ID_FORMA_PAGO;
	private String VDD;
	private String VMM;
	private String VYY;
	private String VHH;
	private String VSS;
	private String DEBACC;
	private BigDecimal AMOUNT;
	private String NUM_TARJETA;
	private String MES_VENCIMIENTO;
	private String ANIO_VENCIMIENTO;
	private String FABRICANTE;
	private String DESCRIPCION;
	private String MODELO;
	private String NUM_SERIE;
	private String NUM_MOTOR;
	private String DESC_ESTADO_RESUMEN;
	private int ID_TIPO_CARGO;
	private int BANK_NUMBER;

	public static final int EFECTIVO = 0;
	public static final int CUENTA_AFIRME = 1;
	public static final int TARJETA_CREDITO = 2;
	public static final int TARJETA_DEBITO = 3;
	public static final int CUENTA_CLABE = 4;

	public SG_DATOS_VARIOS() {
		ID_PAQUETE = "0";
		ID_FORMA_PAGO = "0";
		VDD = "";
		VMM = "";
		VYY = "";
		VHH = "";
		VSS = "";
		DEBACC = "";
		AMOUNT = new BigDecimal(0);
		NUM_TARJETA = "";
		MES_VENCIMIENTO = "";
		ANIO_VENCIMIENTO = "";
		FABRICANTE = "";
		DESCRIPCION = "";
		MODELO = "";
		NUM_SERIE = "";
		NUM_MOTOR = "";
		DESC_ESTADO_RESUMEN = "";
		ID_TIPO_CARGO = CUENTA_AFIRME;
		BANK_NUMBER = 0;

	}

	/**
	 * @return
	 */
	public BigDecimal getAMOUNT() {
		return AMOUNT;
	}

	/**
	 * @return
	 */
	public String getANIO_VENCIMIENTO() {
		return ANIO_VENCIMIENTO;
	}

	/**
	 * @return
	 */
	public String getDEBACC() {
		return DEBACC;
	}

	/**
	 * @return
	 */
	public String getDESC_ESTADO_RESUMEN() {
		return DESC_ESTADO_RESUMEN;
	}

	/**
	 * @return
	 */
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	/**
	 * @return
	 */
	public String getFABRICANTE() {
		return FABRICANTE;
	}

	/**
	 * @return
	 */
	public String getMES_VENCIMIENTO() {
		return MES_VENCIMIENTO;
	}

	/**
	 * @return
	 */
	public String getMODELO() {
		return MODELO;
	}

	/**
	 * @return
	 */
	public String getNUM_MOTOR() {
		return NUM_MOTOR;
	}

	/**
	 * @return
	 */
	public String getNUM_SERIE() {
		return NUM_SERIE;
	}

	/**
	 * @return
	 */
	public String getNUM_TARJETA() {
		return NUM_TARJETA;
	}

	/**
	 * @return
	 */
	public String getVDD() {
		return VDD;
	}

	/**
	 * @return
	 */
	public String getVHH() {
		return VHH;
	}

	/**
	 * @return
	 */
	public String getVMM() {
		return VMM;
	}

	/**
	 * @return
	 */
	public String getVSS() {
		return VSS;
	}

	/**
	 * @return
	 */
	public String getVYY() {
		return VYY;
	}

	/**
	 * @param decimal
	 */
	public void setAMOUNT(BigDecimal decimal) {
		AMOUNT = decimal;
	}

	/**
	 * @param string
	 */
	public void setANIO_VENCIMIENTO(String string) {
		ANIO_VENCIMIENTO = string;
	}

	/**
	 * @param string
	 */
	public void setDEBACC(String string) {
		DEBACC = string;
	}

	/**
	 * @param string
	 */
	public void setDESC_ESTADO_RESUMEN(String string) {
		DESC_ESTADO_RESUMEN = string;
	}

	/**
	 * @param string
	 */
	public void setDESCRIPCION(String string) {
		DESCRIPCION = string;
	}

	/**
	 * @param string
	 */
	public void setFABRICANTE(String string) {
		FABRICANTE = string;
	}

	/**
	 * @param string
	 */
	public void setMES_VENCIMIENTO(String string) {
		MES_VENCIMIENTO = string;
	}

	/**
	 * @param string
	 */
	public void setMODELO(String string) {
		MODELO = string;
	}

	/**
	 * @param string
	 */
	public void setNUM_MOTOR(String string) {
		NUM_MOTOR = string;
	}

	/**
	 * @param string
	 */
	public void setNUM_SERIE(String string) {
		NUM_SERIE = string;
	}

	/**
	 * @param string
	 */
	public void setNUM_TARJETA(String string) {
		NUM_TARJETA = string;
	}

	/**
	 * @param string
	 */
	public void setVDD(String string) {
		VDD = string;
	}

	/**
	 * @param string
	 */
	public void setVHH(String string) {
		VHH = string;
	}

	/**
	 * @param string
	 */
	public void setVMM(String string) {
		VMM = string;
	}

	/**
	 * @param string
	 */
	public void setVSS(String string) {
		VSS = string;
	}

	/**
	 * @param string
	 */
	public void setVYY(String string) {
		VYY = string;
	}

	/**
	 * @return
	 */
	public String getID_FORMA_PAGO() {
		return ID_FORMA_PAGO;
	}

	/**
	 * @return
	 */
	public String getID_PAQUETE() {
		return ID_PAQUETE;
	}

	/**
	 * @param string
	 */
	public void setID_FORMA_PAGO(String string) {
		ID_FORMA_PAGO = string;
	}

	/**
	 * @param string
	 */
	public void setID_PAQUETE(String string) {
		ID_PAQUETE = string;
	}

	/**
	 * @return
	 */
	public int getID_TIPO_CARGO() {
		return ID_TIPO_CARGO;
	}

	/**
	 * @param i
	 */
	public void setID_TIPO_CARGO(int i) {
		ID_TIPO_CARGO = i;
	}

	/**
	 * @return
	 */
	public int getBANK_NUMBER() {
		return BANK_NUMBER;
	}

	/**
	 * @param i
	 */
	public void setBANK_NUMBER(int i) {
		BANK_NUMBER = i;
	}

}
