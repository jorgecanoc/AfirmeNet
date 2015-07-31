package com.afirme.afirmenet.ibs.databeans;

public class DC_SPEI extends DC_CONFMSG implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected java.lang.String TRACKING_CODE = "";

	protected java.lang.String SPEI_REF = "";

	public java.lang.String getTRACKING_CODE() {
		return TRACKING_CODE;
	}

	public void setTRACKING_CODE(java.lang.String tracking_key) {
		TRACKING_CODE = tracking_key;
	}

	public java.lang.String getSPEI_REF() {
		return SPEI_REF;
	}

	public void setSPEI_REF(java.lang.String spei_ref) {
		SPEI_REF = spei_ref;
	}

}