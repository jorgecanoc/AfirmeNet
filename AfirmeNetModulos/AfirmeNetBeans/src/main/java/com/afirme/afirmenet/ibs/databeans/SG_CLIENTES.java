/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: SG_CLIENTES.java
 * Creado: Jun 13, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: SG_CLIENTES
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.util.Date;

/**
 * @author cosurof
 * 
 */
public class SG_CLIENTES {

	private String ENTITYID;
	private String USERID;

	private double ID_CLIENTE;
	private double ID_DOMICILIO;

	private String NOMBRE;
	private String APELLIDO_PATERNO;
	private String APELLIDO_MATERNO;
	private String SIGLAS_RFC;
	private String F_RFC;
	private String HOMOCLAVE_RFC;
	private String CLAVE_SEXO;
	private String DESC_SEXO;

	private Date F_NACIMIENTO;
	private String CVE_EDO_CIVIL;
	private String DESC_EDO_CIVIL;
	private int CODIGO_POSTAL;

	private String CALLE_NUMERO;
	private String COLONIA;

	private String OTRACOLONIA;

	private String ID_MUNICIPIO;
	private String DESC_MUNICIPIO;

	private String ID_ESTADO;
	private String DESC_ESTADO;

	private String TELEF_OFICINA;

	private String TELEF_FAX;

	private String TELEF_CASA;

	private String E_MAIL;

	private double ID_COTIZACION;

	private String ADATE;
	private String STS;
	private boolean READONLY;

	public SG_CLIENTES() {

		ENTITYID = "";
		USERID = "";

		ID_CLIENTE = 0;
		ID_DOMICILIO = 0;

		NOMBRE = "";
		APELLIDO_PATERNO = "";
		APELLIDO_MATERNO = "";
		SIGLAS_RFC = "";
		F_RFC = "";
		HOMOCLAVE_RFC = "";
		CLAVE_SEXO = "";
		DESC_SEXO = "";

		F_NACIMIENTO = new Date();
		CVE_EDO_CIVIL = "";
		DESC_EDO_CIVIL = "";
		CODIGO_POSTAL = 0;

		CALLE_NUMERO = "";
		COLONIA = "";

		OTRACOLONIA = "";

		ID_MUNICIPIO = "";
		DESC_MUNICIPIO = "";

		ID_ESTADO = "";
		DESC_ESTADO = "";

		TELEF_OFICINA = "";

		TELEF_FAX = "";

		TELEF_CASA = "";

		E_MAIL = "";
		ID_COTIZACION = 0;

		STS = "";
		READONLY = false;

	}

	/**
	 * @return
	 */
	public String getAPELLIDO_MATERNO() {
		return APELLIDO_MATERNO;
	}

	/**
	 * @return
	 */
	public String getAPELLIDO_PATERNO() {
		return APELLIDO_PATERNO;
	}

	/**
	 * @return
	 */
	public String getCALLE_NUMERO() {
		return CALLE_NUMERO;
	}

	/**
	 * @return
	 */
	public String getCLAVE_SEXO() {
		return CLAVE_SEXO;
	}

	/**
	 * @return
	 */
	public int getCODIGO_POSTAL() {
		return CODIGO_POSTAL;
	}

	/**
	 * @return
	 */
	public String getCOLONIA() {
		return COLONIA;
	}

	/**
	 * @return
	 */
	public String getCVE_EDO_CIVIL() {
		return CVE_EDO_CIVIL;
	}

	/**
	 * @return
	 */
	public String getDESC_ESTADO() {
		return DESC_ESTADO;
	}

	/**
	 * @return
	 */
	public String getDESC_MUNICIPIO() {
		return DESC_MUNICIPIO;
	}

	/**
	 * @return
	 */
	public String getE_MAIL() {
		return E_MAIL;
	}

	/**
	 * @return
	 */
	public Date getF_NACIMIENTO() {
		return F_NACIMIENTO;
	}

	/**
	 * @return
	 */
	public String getF_RFC() {
		return F_RFC;
	}

	/**
	 * @return
	 */
	public String getHOMOCLAVE_RFC() {
		return HOMOCLAVE_RFC;
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
	public String getID_ESTADO() {
		return ID_ESTADO;
	}

	/**
	 * @return
	 */
	public String getID_MUNICIPIO() {
		return ID_MUNICIPIO;
	}

	/**
	 * @return
	 */
	public String getNOMBRE() {
		return NOMBRE;
	}

	/**
	 * @return
	 */
	public String getOTRACOLONIA() {
		return OTRACOLONIA;
	}

	/**
	 * @return
	 */
	public String getSIGLAS_RFC() {
		return SIGLAS_RFC;
	}

	/**
	 * @return
	 */
	public String getTELEF_CASA() {
		return TELEF_CASA;
	}

	/**
	 * @return
	 */
	public String getTELEF_FAX() {
		return TELEF_FAX;
	}

	/**
	 * @return
	 */
	public String getTELEF_OFICINA() {
		return TELEF_OFICINA;
	}

	/**
	 * @param string
	 */
	public void setAPELLIDO_MATERNO(String string) {
		APELLIDO_MATERNO = string;
	}

	/**
	 * @param string
	 */
	public void setAPELLIDO_PATERNO(String string) {
		APELLIDO_PATERNO = string;
	}

	/**
	 * @param string
	 */
	public void setCALLE_NUMERO(String string) {
		CALLE_NUMERO = string;
	}

	/**
	 * @param string
	 */
	public void setCLAVE_SEXO(String string) {
		CLAVE_SEXO = string;
	}

	/**
	 * @param i
	 */
	public void setCODIGO_POSTAL(int i) {
		CODIGO_POSTAL = i;
	}

	/**
	 * @param string
	 */
	public void setCOLONIA(String string) {
		COLONIA = string;
	}

	/**
	 * @param string
	 */
	public void setCVE_EDO_CIVIL(String string) {
		CVE_EDO_CIVIL = string;
	}

	/**
	 * @param string
	 */
	public void setDESC_ESTADO(String string) {
		DESC_ESTADO = string;
	}

	/**
	 * @param string
	 */
	public void setDESC_MUNICIPIO(String string) {
		DESC_MUNICIPIO = string;
	}

	/**
	 * @param string
	 */
	public void setE_MAIL(String string) {
		E_MAIL = string;
	}

	/**
	 * @param date
	 */
	public void setF_NACIMIENTO(Date date) {
		F_NACIMIENTO = date;
	}

	/**
	 * @param string
	 */
	public void setF_RFC(String string) {
		F_RFC = string;
	}

	/**
	 * @param string
	 */
	public void setHOMOCLAVE_RFC(String string) {
		HOMOCLAVE_RFC = string;
	}

	/**
	 * @param d
	 */
	public void setID_COTIZACION(double d) {
		ID_COTIZACION = d;
	}

	/**
	 * @param string
	 */
	public void setID_ESTADO(String string) {
		ID_ESTADO = string;
	}

	/**
	 * @param string
	 */
	public void setID_MUNICIPIO(String string) {
		ID_MUNICIPIO = string;
	}

	/**
	 * @param string
	 */
	public void setNOMBRE(String string) {
		NOMBRE = string;
	}

	/**
	 * @param string
	 */
	public void setOTRACOLONIA(String string) {
		OTRACOLONIA = string;
	}

	/**
	 * @param string
	 */
	public void setSIGLAS_RFC(String string) {
		SIGLAS_RFC = string;
	}

	/**
	 * @param string
	 */
	public void setTELEF_CASA(String string) {
		TELEF_CASA = string;
	}

	/**
	 * @param string
	 */
	public void setTELEF_FAX(String string) {
		TELEF_FAX = string;
	}

	/**
	 * @param string
	 */
	public void setTELEF_OFICINA(String string) {
		TELEF_OFICINA = string;
	}

	/**
	 * @return
	 */
	public String getENTITYID() {
		return ENTITYID;
	}

	/**
	 * @return
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @param string
	 */
	public void setENTITYID(String string) {
		ENTITYID = string;
	}

	/**
	 * @param string
	 */
	public void setUSERID(String string) {
		USERID = string;
	}

	/**
	 * @return
	 */
	public String getADATE() {
		return ADATE;
	}

	/**
	 * @return
	 */
	public String getSTS() {
		return STS;
	}

	/**
	 * @param string
	 */
	public void setADATE(String string) {
		ADATE = string;
	}

	/**
	 * @param string
	 */
	public void setSTS(String string) {
		STS = string;
	}

	/**
	 * @return
	 */
	public double getID_CLIENTE() {
		return ID_CLIENTE;
	}

	/**
	 * @param d
	 */
	public void setID_CLIENTE(double d) {
		ID_CLIENTE = d;
	}

	/**
	 * @return
	 */
	public String getDESC_EDO_CIVIL() {
		return DESC_EDO_CIVIL;
	}

	/**
	 * @return
	 */
	public String getDESC_SEXO() {
		return DESC_SEXO;
	}

	/**
	 * @param string
	 */
	public void setDESC_EDO_CIVIL(String string) {
		DESC_EDO_CIVIL = string;
	}

	/**
	 * @param string
	 */
	public void setDESC_SEXO(String string) {
		DESC_SEXO = string;
	}

	/**
	 * @return
	 */
	public boolean isREADONLY() {
		return READONLY;
	}

	/**
	 * @param b
	 */
	public void setREADONLY(boolean b) {
		READONLY = b;
	}

	/**
	 * @return
	 */
	public double getID_DOMICILIO() {
		return ID_DOMICILIO;
	}

	/**
	 * @param d
	 */
	public void setID_DOMICILIO(double d) {
		ID_DOMICILIO = d;
	}

}
