package com.afirme.afirmenet.ibs.databeans;

public class AF_FOLIOCONSULTA implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The attributes.
	 */
	protected String ENTITYID = "";
	protected String USERID = "";
	protected String FOLIO = "";
	protected String TIPOAPO = "";
	protected String FECHA = "";
	protected String STATUS = "";
	protected String ULTMOVI = "";

	/**
	 * Gets the values.
	 */
	public String getENTITYID() {
		return ENTITYID;
	}

	public String getUSERID() {
		return USERID;
	}

	public String getFOLIO() {
		return FOLIO;
	}

	public String getTIPOAPO() {
		return TIPOAPO;
	}

	public String getFECHA() {
		return FECHA;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public String getULTMOVI() {
		return ULTMOVI;
	}

	/**
	 * Sets the values.
	 */
	public void setENTITYID(String DATA) {
		this.ENTITYID = DATA != null ? DATA.trim() : "";
	}

	public void setUSERID(String DATA) {
		this.USERID = DATA != null ? DATA.trim() : "";
	}

	public void setFOLIO(String DATA) {
		this.FOLIO = DATA != null ? DATA.trim() : "";
	}

	public void setTIPOAPO(String DATA) {
		this.TIPOAPO = DATA != null ? DATA.trim() : "";
	}

	public void setFECHA(String DATA) {
		this.FECHA = DATA != null ? DATA.trim() : "";
	}

	public void setSTATUS(String DATA) {
		this.STATUS = DATA != null ? DATA.trim() : "";
	}

	public void setULTMOVI(String DATA) {
		this.ULTMOVI = DATA != null ? DATA.trim() : "";
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tUSERID  =" + USERID + "\n");
		results.append("\tFOLIO   =" + FOLIO + "\n");
		results.append("\tTIPOAPO =" + TIPOAPO + "\n");
		results.append("\tFECHA   =" + FECHA + "\n");
		results.append("\tSTATUS  =" + STATUS + "\n");
		results.append("\tULTMOVI =" + ULTMOVI + "\n");

		return results.toString();
	}
}