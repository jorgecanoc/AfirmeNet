package com.afirme.afirmenet.ibs.databeans;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 06/17/2004 02:26:12<br>
 * &nbsp;&nbsp;&nbsp; table = "DC_BINESBean"
 * 
 * @author Generator
 */
public class DC_BINES implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The BIN attribute.
	 */
	protected java.lang.String BIN = "";

	/**
	 * Gets the BIN value.
	 */
	public java.lang.String getBIN() {
		return BIN.toUpperCase().trim();
	}

	/**
	 * Sets the BIN value.
	 */
	public void setBIN(java.lang.String BIN) {
		this.BIN = BIN;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tBIN=" + BIN + "\n");

		return results.toString();
	}

}