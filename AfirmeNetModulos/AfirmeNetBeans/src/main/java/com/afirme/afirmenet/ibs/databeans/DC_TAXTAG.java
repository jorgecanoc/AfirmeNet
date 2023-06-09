package com.afirme.afirmenet.ibs.databeans;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 11/06/2003 11:07:20<br>
 * &nbsp;&nbsp;&nbsp; table = "DC_TAXTAGBean"
 * 
 * @author Generator
 */
public class DC_TAXTAG implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The TAG attribute.
	 */
	protected java.lang.String TAG = "";

	/**
	 * Gets the TAG value.
	 */
	public java.lang.String getTAG() {
		return TAG.toUpperCase().trim();
	}

	/**
	 * Sets the TAG value.
	 */
	public void setTAG(java.lang.String TAG) {
		this.TAG = TAG;
	}

	/**
	 * The TAGNAME attribute.
	 */
	protected java.lang.String TAGNAME = "";

	/**
	 * Gets the TAGNAME value.
	 */
	public java.lang.String getTAGNAME() {
		return TAGNAME.toUpperCase().trim();
	}

	/**
	 * Sets the TAGNAME value.
	 */
	public void setTAGNAME(java.lang.String TAGNAME) {
		this.TAGNAME = TAGNAME;
	}

	/**
	 * The TAGPOS attribute.
	 */
	protected java.lang.String TAGPOS = "";

	/**
	 * Gets the TAGPOS value.
	 */
	public java.lang.String getTAGPOS() {
		return TAGPOS.toUpperCase().trim();
	}

	/**
	 * Sets the TAGPOS value.
	 */
	public void setTAGPOS(java.lang.String TAGPOS) {
		this.TAGPOS = TAGPOS;
	}

	/**
	 * The TAGTYPE attribute.
	 */
	protected java.lang.String TAGTYPE = "";

	/**
	 * Gets the TAGTYPE value.
	 */
	public java.lang.String getTAGTYPE() {
		return TAGTYPE.toUpperCase().trim();
	}

	/**
	 * Sets the TAGTYPE value.
	 */
	public void setTAGTYPE(java.lang.String TAGTYPE) {
		this.TAGTYPE = TAGTYPE;
	}

	/**
	 * The CHECKFLAG attribute.
	 */
	protected java.lang.String CHECKFLAG = "";

	/**
	 * Gets the CHECKFLAG value.
	 */
	public java.lang.String getCHECKFLAG() {
		return CHECKFLAG.toUpperCase().trim();
	}

	/**
	 * Sets the CHECKFLAG value.
	 */
	public void setCHECKFLAG(java.lang.String CHECKFLAG) {
		this.CHECKFLAG = CHECKFLAG;
	}

	/**
	 * The RCPTPOS attribute.
	 */
	protected java.lang.String RCPTPOS = "";

	/**
	 * Gets the RCPTPOS value.
	 */
	public java.lang.String getRCPTPOS() {
		return RCPTPOS.toUpperCase().trim();
	}

	/**
	 * Sets the RCPTPOS value.
	 */
	public void setRCPTPOS(java.lang.String RCPTPOS) {
		this.RCPTPOS = RCPTPOS;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tTAG=" + TAG + "\n");
		results.append("\tTAGNAME=" + TAGNAME + "\n");
		results.append("\tTAGPOS=" + TAGPOS + "\n");
		results.append("\tTAGTYPE=" + TAGTYPE + "\n");
		results.append("\tCHECKFLAG=" + CHECKFLAG + "\n");
		results.append("\tRCPTPOS=" + RCPTPOS + "\n");

		return results.toString();
	}

}