package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 02/05/2004 09:31:55<br>
 * &nbsp;&nbsp;&nbsp; table = "SATCVTPFBean"
 * 
 * @author Generator
 */
public class SATCVTPF implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The CVEELE attribute.
	 */
	protected java.lang.String CVEELE = "";

	/**
	 * Gets the CVEELE value.
	 */
	public java.lang.String getCVEELE() {
		return CVEELE.toUpperCase().trim();
	}

	/**
	 * Sets the CVEELE value.
	 */
	public void setCVEELE(java.lang.String CVEELE) {
		this.CVEELE = CVEELE;
	}

	/**
	 * The CVENUM attribute.
	 */
	protected java.math.BigDecimal CVENUM = new BigDecimal("0");

	/**
	 * Gets the CVENUM value.
	 */
	public java.math.BigDecimal getCVENUM() {
		return CVENUM;
	}

	/**
	 * Sets the CVENUM value.
	 */
	public void setCVENUM(java.math.BigDecimal CVENUM) {
		this.CVENUM = CVENUM;
	}

	/**
	 * The CVEDSC attribute.
	 */
	protected java.lang.String CVEDSC = "";

	/**
	 * Gets the CVEDSC value.
	 */
	public java.lang.String getCVEDSC() {
		return CVEDSC.toUpperCase().trim();
	}

	/**
	 * Sets the CVEDSC value.
	 */
	public void setCVEDSC(java.lang.String CVEDSC) {
		this.CVEDSC = CVEDSC;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tCVEELE=" + CVEELE + "\n");
		results.append("\tCVENUM=" + CVENUM + "\n");
		results.append("\tCVEDSC=" + CVEDSC + "\n");

		return results.toString();
	}

}