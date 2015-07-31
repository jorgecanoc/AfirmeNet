/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: ABAPF.java
 * Creado: Mar 9, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: ABAPF
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.io.Serializable;

/**
 * @author cosurof
 * 
 */
public class ABAPF implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ABANUM;
	private String ABANOM;
	private String ABACTY;
	private String ABAEDO;

	public ABAPF() {
		ABANUM = "";
		ABANOM = "";
		ABACTY = "";
		ABAEDO = "";
	}

	/**
	 * @return
	 */
	public String getABACTY() {
		return ABACTY;
	}

	/**
	 * @return
	 */
	public String getABAEDO() {
		return ABAEDO;
	}

	/**
	 * @return
	 */
	public String getABANOM() {
		return ABANOM;
	}

	/**
	 * @return
	 */
	public String getABANUM() {
		return ABANUM;
	}

	/**
	 * @param string
	 */
	public void setABACTY(String string) {
		ABACTY = string;
	}

	/**
	 * @param string
	 */
	public void setABAEDO(String string) {
		ABAEDO = string;
	}

	/**
	 * @param string
	 */
	public void setABANOM(String string) {
		ABANOM = string;
	}

	/**
	 * @param string
	 */
	public void setABANUM(String string) {
		ABANUM = string;
	}

}
