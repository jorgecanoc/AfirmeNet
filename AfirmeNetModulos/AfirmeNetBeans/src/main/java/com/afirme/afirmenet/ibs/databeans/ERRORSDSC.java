package com.afirme.afirmenet.ibs.databeans;

import java.lang.String;

public class ERRORSDSC implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The attributes.
	 */
	protected String DSC = ""; // ERROR DE DESCRIPCION
	protected String OBS = ""; // NUMERO DE CLIENTE

	/**
	 * Gets the values.
	 */
	public String getDSC() {
		return DSC;
	}

	public String getOBS() {
		return OBS;
	}

	/**
	 * Sets the values.
	 */
	public void setDSC(String DATA) {
		this.DSC = DATA != null ? DATA.trim() : "";
	}

	public void setOBS(String DATA) {
		this.OBS = DATA != null ? DATA.trim() : "";
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tDSC=" + DSC + "\n");
		results.append("\tOBS=" + OBS + "\n");

		return results.toString();
	}
}