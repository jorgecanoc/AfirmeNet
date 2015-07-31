package com.afirme.afirmenet.ibs.databeans;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 09/29/2003 02:43:20<br>
 * &nbsp;&nbsp;&nbsp; table = "DC_NOMINA_DBean"
 * 
 * @author Generator
 */
public class NOMINA_D implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The ENTITYID attribute.
	 */
	protected java.lang.String ENTITYID = "";

	/**
	 * Gets the ENTITYID value.
	 */
	public java.lang.String getENTITYID() {
		return ENTITYID.toUpperCase().trim();
	}

	/**
	 * Sets the ENTITYID value.
	 */
	public void setENTITYID(java.lang.String ENTITYID) {
		this.ENTITYID = ENTITYID;
	}

	/**
	 * The DEBACC attribute.
	 */
	protected java.lang.String DEBACC = "";

	/**
	 * Gets the DEBACC value.
	 */
	public java.lang.String getDEBACC() {
		return DEBACC.toUpperCase().trim();
	}

	/**
	 * Sets the DEBACC value.
	 */
	public void setDEBACC(java.lang.String DEBACC) {
		this.DEBACC = DEBACC;
	}

	/**
	 * The CREACC attribute.
	 */
	protected java.lang.String CREACC = "";

	/**
	 * Gets the CREACC value.
	 */
	public java.lang.String getCREACC() {
		return CREACC.toUpperCase().trim();
	}

	/**
	 * Sets the CREACC value.
	 */
	public void setCREACC(java.lang.String CREACC) {
		this.CREACC = CREACC;
	}

	/**
	 * The AMOUNT attribute.
	 */
	protected java.math.BigDecimal AMOUNT = null;

	/**
	 * Gets the AMOUNT value.
	 */
	public java.math.BigDecimal getAMOUNT() {
		return AMOUNT;
	}

	/**
	 * Sets the AMOUNT value.
	 */
	public void setAMOUNT(java.math.BigDecimal AMOUNT) {
		this.AMOUNT = AMOUNT;
	}

	/**
	 * The CCY attribute.
	 */
	protected java.lang.String CCY = "";

	/**
	 * Gets the CCY value.
	 */
	public java.lang.String getCCY() {
		return CCY.toUpperCase().trim();
	}

	/**
	 * Sets the CCY value.
	 */
	public void setCCY(java.lang.String CCY) {
		this.CCY = CCY;
	}

	/**
	 * The REFENUM attribute.
	 */
	protected java.lang.String REFENUM = "";

	/**
	 * Gets the REFENUM value.
	 */
	public java.lang.String getREFENUM() {
		return REFENUM.toUpperCase().trim();
	}

	/**
	 * Sets the REFENUM value.
	 */
	public void setREFENUM(java.lang.String REFENUM) {
		this.REFENUM = REFENUM;
	}

	/**
	 * The BNKRECPTOR attribute.
	 */
	protected java.lang.String BNKRECPTOR = "";

	/**
	 * Gets the BNKRECPTOR value.
	 */
	public java.lang.String getBNKRECPTOR() {
		return BNKRECPTOR.toUpperCase().trim();
	}

	/**
	 * Sets the BNKRECPTOR value.
	 */
	public void setBNKRECPTOR(java.lang.String BNKRECPTOR) {
		this.BNKRECPTOR = BNKRECPTOR;
	}

	/**
	 * The NAME attribute.
	 */
	protected java.lang.String NAME = "";

	/**
	 * Gets the NAME value.
	 */
	public java.lang.String getNAME() {
		return NAME.toUpperCase().trim();
	}

	/**
	 * Sets the NAME value.
	 */
	public void setNAME(java.lang.String NAME) {
		this.NAME = NAME;
	}

	/**
	 * The ACCTYPE attribute.
	 */
	protected java.lang.String ACCTYPE = "";

	/**
	 * Gets the ACCTYPE value.
	 */
	public java.lang.String getACCTYPE() {
		return ACCTYPE.toUpperCase().trim();
	}

	/**
	 * Sets the ACCTYPE value.
	 */
	public void setACCTYPE(java.lang.String ACCTYPE) {
		this.ACCTYPE = ACCTYPE;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tDEBACC=" + DEBACC + "\n");
		results.append("\tCREACC=" + CREACC + "\n");
		results.append("\tAMOUNT=" + AMOUNT + "\n");
		results.append("\tCCY=" + CCY + "\n");
		results.append("\tREFENUM=" + REFENUM + "\n");
		results.append("\tBNKRECPTOR=" + BNKRECPTOR + "\n");

		return results.toString();
	}

}