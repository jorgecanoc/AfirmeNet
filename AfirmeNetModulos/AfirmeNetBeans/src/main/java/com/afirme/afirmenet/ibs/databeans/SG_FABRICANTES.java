/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: SG_FABRICANTES.java
 * Creado: May 11, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: SG_FABRICANTES
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.io.Serializable;

/**
 * @author cosurof
 * 
 */
public class SG_FABRICANTES implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String FABRICANTE;
	private String DESCFABRICANTE;

	public SG_FABRICANTES() {

		this.FABRICANTE = "";
		this.DESCFABRICANTE = "";

	}

	/**
	 * @return
	 */
	public String getDESCFABRICANTE() {
		return DESCFABRICANTE;
	}

	/**
	 * @return
	 */
	public String getFABRICANTE() {
		return FABRICANTE;
	}

	/**
	 * @param string
	 */
	public void setDESCFABRICANTE(String string) {
		DESCFABRICANTE = string;
	}

	/**
	 * @param string
	 */
	public void setFABRICANTE(String string) {
		FABRICANTE = string;
	}

}
