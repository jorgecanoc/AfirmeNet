package com.afirme.afirmenet.ibs.databeans;

import java.lang.String;

public class CNOFC implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The attributes.
	 */
	private String CNORCD = ""; // CLAVE
	private String CNODSC = ""; // DESCRIPCION

	/**
	 * Gets the values.
	 */
	public String getCNORCD() {
		return CNORCD;
	}

	public String getCNODSC() {
		return CNODSC;
	}

	/**
	 * Sets the values.
	 */
	public void setCNORCD(String DATA) {
		this.CNORCD = DATA != null ? DATA.trim() : "";
	}

	public void setCNODSC(String DATA) {
		this.CNODSC = DATA != null ? DATA.trim() : "";
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tCNORCD =" + CNORCD + "\n");
		results.append("\tCNODSC =" + CNODSC + "\n");

		return results.toString();
	}
}