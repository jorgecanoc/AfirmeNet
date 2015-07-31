package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 01/31/2005 10:17:31<br>
 * &nbsp;&nbsp;&nbsp; table = "SATCERPFBean"
 * 
 * @author Generator
 */
public class SATCERPF implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The CEFOL attribute.
	 */
	protected java.math.BigDecimal CEFOL = new BigDecimal("0");

	/**
	 * Gets the CEFOL value.
	 */
	public java.math.BigDecimal getCEFOL() {
		return CEFOL;
	}

	/**
	 * Sets the CEFOL value.
	 */
	public void setCEFOL(java.math.BigDecimal CEFOL) {
		this.CEFOL = CEFOL;
	}

	/**
	 * The CERFC attribute.
	 */
	protected java.lang.String CERFC = "";

	/**
	 * Gets the CERFC value.
	 */
	public java.lang.String getCERFC() {
		return CERFC.trim();
	}

	/**
	 * Sets the CERFC value.
	 */
	public void setCERFC(java.lang.String CERFC) {
		this.CERFC = CERFC;
	}

	/**
	 * The CECADE attribute.
	 */
	protected java.lang.String CECADE = "";

	/**
	 * Gets the CECADE value.
	 */
	public java.lang.String getCECADE() {
		return CECADE.trim();
	}

	/**
	 * Sets the CECADE value.
	 */
	public void setCECADE(java.lang.String CECADE) {
		this.CECADE = CECADE;
	}

	/**
	 * The CESELL attribute.
	 */
	protected java.lang.String CESELL = "";

	/**
	 * Gets the CESELL value.
	 */
	public java.lang.String getCESELL() {
		return CESELL.trim();
	}

	/**
	 * Sets the CESELL value.
	 */
	public void setCESELL(java.lang.String CESELL) {
		this.CESELL = CESELL;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tCEFOL=" + CEFOL + "\n");
		results.append("\tCERFC=" + CERFC + "\n");
		results.append("\tCECADE=" + CECADE + "\n");
		results.append("\tCESELL=" + CESELL + "\n");

		return results.toString();
	}

}