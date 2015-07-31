package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 07/14/2003 03:14:37<br>
 * &nbsp;&nbsp;&nbsp; table = "SPABANPFBean"
 * 
 * @author Generator
 */
public class SPABANPF implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The BANREC attribute.
	 */
	protected java.math.BigDecimal BANREC = new BigDecimal("0");

	/**
	 * Gets the BANREC value.
	 */
	public java.math.BigDecimal getBANREC() {
		return BANREC;
	}

	/**
	 * Sets the BANREC value.
	 */
	public void setBANREC(java.math.BigDecimal BANREC) {
		this.BANREC = BANREC;
	}

	/**
	 * The BANNOM attribute.
	 */
	protected java.lang.String BANNOM = "";

	/**
	 * Gets the BANNOM value.
	 */
	public java.lang.String getBANNOM() {
		return BANNOM.toUpperCase().trim();
	}

	/**
	 * Sets the BANNOM value.
	 */
	public void setBANNOM(java.lang.String BANNOM) {
		this.BANNOM = BANNOM;
	}

	/**
	 * The BANLAR attribute.
	 */
	protected java.lang.String BANLAR = "";

	/**
	 * Gets the BANLAR value.
	 */
	public java.lang.String getBANLAR() {
		return BANLAR.toUpperCase().trim();
	}

	/**
	 * Sets the BANLAR value.
	 */
	public void setBANLAR(java.lang.String BANLAR) {
		this.BANLAR = BANLAR;
	}

	/**
	 * The BANBTD attribute.
	 */
	protected java.math.BigDecimal BANBTD = new BigDecimal("0");

	/**
	 * Gets the BANBTD value.
	 */
	public java.math.BigDecimal getBANBTD() {
		return BANBTD;
	}

	/**
	 * Sets the BANBTD value.
	 */
	public void setBANBTD(java.math.BigDecimal BANBTD) {
		this.BANBTD = BANBTD;
	}

	/**
	 * The BANBTM attribute.
	 */
	protected java.math.BigDecimal BANBTM = new BigDecimal("0");

	/**
	 * Gets the BANBTM value.
	 */
	public java.math.BigDecimal getBANBTM() {
		return BANBTM;
	}

	/**
	 * Sets the BANBTM value.
	 */
	public void setBANBTM(java.math.BigDecimal BANBTM) {
		this.BANBTM = BANBTM;
	}

	/**
	 * The BANBTY attribute.
	 */
	protected java.math.BigDecimal BANBTY = new BigDecimal("0");

	/**
	 * Gets the BANBTY value.
	 */
	public java.math.BigDecimal getBANBTY() {
		return BANBTY;
	}

	/**
	 * Sets the BANBTY value.
	 */
	public void setBANBTY(java.math.BigDecimal BANBTY) {
		this.BANBTY = BANBTY;
	}

	/**
	 * The BANCLS attribute.
	 */
	protected java.lang.String BANCLS = "";

	/**
	 * Gets the BANCLS value.
	 */
	public java.lang.String getBANCLS() {
		return BANCLS.toUpperCase().trim();
	}

	/**
	 * Sets the BANCLS value.
	 */
	public void setBANCLS(java.lang.String BANCLS) {
		this.BANCLS = BANCLS;
	}

	/**
	 * The BANSTS attribute.
	 */
	protected java.lang.String BANSTS = "";

	/**
	 * Gets the BANSTS value.
	 */
	public java.lang.String getBANSTS() {
		return BANSTS.toUpperCase().trim();
	}

	/**
	 * Sets the BANSTS value.
	 */
	public void setBANSTS(java.lang.String BANSTS) {
		this.BANSTS = BANSTS;
	}

	/**
	 * The BANFLG attribute.
	 */
	protected java.lang.String BANFLG = "";

	/**
	 * Gets the BANFLG value.
	 */
	public java.lang.String getBANFLG() {
		return BANFLG.toUpperCase().trim();
	}

	/**
	 * Sets the BANFLG value.
	 */
	public void setBANFLG(java.lang.String BANFLG) {
		this.BANFLG = BANFLG;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tBANREC=" + BANREC + "\n");
		results.append("\tBANNOM=" + BANNOM + "\n");
		results.append("\tBANLAR=" + BANLAR + "\n");
		results.append("\tBANBTD=" + BANBTD + "\n");
		results.append("\tBANBTM=" + BANBTM + "\n");
		results.append("\tBANBTY=" + BANBTY + "\n");
		results.append("\tBANCLS=" + BANCLS + "\n");
		results.append("\tBANSTS=" + BANSTS + "\n");
		results.append("\tBANFLG=" + BANFLG + "\n");

		return results.toString();
	}

}