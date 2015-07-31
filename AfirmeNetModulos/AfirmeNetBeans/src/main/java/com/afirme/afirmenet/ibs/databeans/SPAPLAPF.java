package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 07/14/2003 03:15:42<br>
 * &nbsp;&nbsp;&nbsp; table = "SPAPLAPFBean"
 * 
 * @author Generator
 */
public class SPAPLAPF implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The PLANUM attribute.
	 */
	protected java.math.BigDecimal PLANUM = new BigDecimal("0");

	/**
	 * Gets the PLANUM value.
	 */
	public java.math.BigDecimal getPLANUM() {
		return PLANUM;
	}

	/**
	 * Sets the PLANUM value.
	 */
	public void setPLANUM(java.math.BigDecimal PLANUM) {
		this.PLANUM = PLANUM;
	}

	/**
	 * The PLANOM attribute.
	 */
	protected java.lang.String PLANOM = "";

	/**
	 * Gets the PLANOM value.
	 */
	public java.lang.String getPLANOM() {
		return PLANOM.toUpperCase().trim();
	}

	/**
	 * Sets the PLANOM value.
	 */
	public void setPLANOM(java.lang.String PLANOM) {
		this.PLANOM = PLANOM;
	}

	/**
	 * The PLALAR attribute.
	 */
	protected java.lang.String PLALAR = "";

	/**
	 * Gets the PLALAR value.
	 */
	public java.lang.String getPLALAR() {
		return PLALAR.toUpperCase().trim();
	}

	/**
	 * Sets the PLALAR value.
	 */
	public void setPLALAR(java.lang.String PLALAR) {
		this.PLALAR = PLALAR;
	}

	/**
	 * The PLABTD attribute.
	 */
	protected java.math.BigDecimal PLABTD = new BigDecimal("0");

	/**
	 * Gets the PLABTD value.
	 */
	public java.math.BigDecimal getPLABTD() {
		return PLABTD;
	}

	/**
	 * Sets the PLABTD value.
	 */
	public void setPLABTD(java.math.BigDecimal PLABTD) {
		this.PLABTD = PLABTD;
	}

	/**
	 * The PLABTM attribute.
	 */
	protected java.math.BigDecimal PLABTM = new BigDecimal("0");

	/**
	 * Gets the PLABTM value.
	 */
	public java.math.BigDecimal getPLABTM() {
		return PLABTM;
	}

	/**
	 * Sets the PLABTM value.
	 */
	public void setPLABTM(java.math.BigDecimal PLABTM) {
		this.PLABTM = PLABTM;
	}

	/**
	 * The PLABTY attribute.
	 */
	protected java.math.BigDecimal PLABTY = new BigDecimal("0");

	/**
	 * Gets the PLABTY value.
	 */
	public java.math.BigDecimal getPLABTY() {
		return PLABTY;
	}

	/**
	 * Sets the PLABTY value.
	 */
	public void setPLABTY(java.math.BigDecimal PLABTY) {
		this.PLABTY = PLABTY;
	}

	/**
	 * The PLACLS attribute.
	 */
	protected java.lang.String PLACLS = "";

	/**
	 * Gets the PLACLS value.
	 */
	public java.lang.String getPLACLS() {
		return PLACLS.toUpperCase().trim();
	}

	/**
	 * Sets the PLACLS value.
	 */
	public void setPLACLS(java.lang.String PLACLS) {
		this.PLACLS = PLACLS;
	}

	/**
	 * The PLASTS attribute.
	 */
	protected java.lang.String PLASTS = "";

	/**
	 * Gets the PLASTS value.
	 */
	public java.lang.String getPLASTS() {
		return PLASTS.toUpperCase().trim();
	}

	/**
	 * Sets the PLASTS value.
	 */
	public void setPLASTS(java.lang.String PLASTS) {
		this.PLASTS = PLASTS;
	}

	/**
	 * The PLAFLG attribute.
	 */
	protected java.lang.String PLAFLG = "";

	/**
	 * Gets the PLAFLG value.
	 */
	public java.lang.String getPLAFLG() {
		return PLAFLG.toUpperCase().trim();
	}

	/**
	 * Sets the PLAFLG value.
	 */
	public void setPLAFLG(java.lang.String PLAFLG) {
		this.PLAFLG = PLAFLG;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tPLANUM=" + PLANUM + "\n");
		results.append("\tPLANOM=" + PLANOM + "\n");
		results.append("\tPLALAR=" + PLALAR + "\n");
		results.append("\tPLABTD=" + PLABTD + "\n");
		results.append("\tPLABTM=" + PLABTM + "\n");
		results.append("\tPLABTY=" + PLABTY + "\n");
		results.append("\tPLACLS=" + PLACLS + "\n");
		results.append("\tPLASTS=" + PLASTS + "\n");
		results.append("\tPLAFLG=" + PLAFLG + "\n");

		return results.toString();
	}

}