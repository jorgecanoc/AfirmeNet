package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

public class TEFBANPF implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected java.math.BigDecimal BANCVE = new BigDecimal("0");
	protected java.lang.String BANNOM = "";
	protected java.lang.String BANCEM = "";
	protected java.lang.String BANCRE = "";

	// Getters
	public java.math.BigDecimal getBANCVE() {
		return BANCVE;
	}

	public java.lang.String getBANNOM() {
		return BANNOM.toUpperCase().trim();
	}

	public java.lang.String getBANCEM() {
		return BANCEM.toUpperCase().trim();
	}

	public java.lang.String getBANCRE() {
		return BANCRE.toUpperCase().trim();
	}

	// Setters
	public void setBANCVE(java.math.BigDecimal BANCVE) {
		this.BANCVE = BANCVE;
	}

	public void setBANNOM(java.lang.String BANNOM) {
		this.BANNOM = BANNOM;
	}

	public void setBANCEM(java.lang.String BANCEM) {
		this.BANCEM = BANCEM;
	}

	public void setBANCRE(java.lang.String BANCRE) {
		this.BANCRE = BANCRE;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");

		return results.toString();
	}
}