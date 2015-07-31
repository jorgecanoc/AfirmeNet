/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: SWIFTPF.java
 * Creado: Mar 8, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: SWIFTPF
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.io.Serializable;

public class SWIFTPF implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SWINUM;
	private String SWINOM;
	private String SWIARE;
	private String SWIEDO;
	private String SWICD;
	private String SWIPAI;

	/**
	 * @return
	 */
	public String getSWIARE() {
		return SWIARE;
	}

	/**
	 * @return
	 */
	public String getSWICD() {
		return SWICD;
	}

	/**
	 * @return
	 */
	public String getSWIEDO() {
		return SWIEDO;
	}

	/**
	 * @return
	 */
	public String getSWINOM() {
		return SWINOM;
	}

	/**
	 * @return
	 */
	public String getSWINUM() {
		return SWINUM;
	}

	/**
	 * @return
	 */
	public String getSWIPAI() {
		return SWIPAI;
	}

	/**
	 * @param string
	 */
	public void setSWIARE(String string) {
		SWIARE = string;
	}

	/**
	 * @param string
	 */
	public void setSWICD(String string) {
		SWICD = string;
	}

	/**
	 * @param string
	 */
	public void setSWIEDO(String string) {
		SWIEDO = string;
	}

	/**
	 * @param string
	 */
	public void setSWINOM(String string) {
		SWINOM = string;
	}

	/**
	 * @param string
	 */
	public void setSWINUM(String string) {
		SWINUM = string;
	}

	/**
	 * @param string
	 */
	public void setSWIPAI(String string) {
		SWIPAI = string;
	}

}
