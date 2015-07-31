package com.afirme.afirmenet.ibs.databeans;

import java.lang.String;

public class AF_TRANSFOLIO implements java.io.Serializable {

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
	protected String NOMBRE = "";
	protected String NSS = "";
	protected String RFC = "";
	protected String CURP = "";
	protected String SIEFORE1 = "";
	protected String SIEFORE2 = "";
	protected String SIEFORE3 = "";
	protected String SIEFORE4 = "";
	protected String FECCREA = "";
	protected String TIPOCLIENTE = "";

	protected String STATUS = "";
	protected String ADATE = "";
	protected String AUSER = "";

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

	public String getNOMBRE() {
		return NOMBRE;
	}

	public String getNSS() {
		return NSS;
	}

	public String getRFC() {
		return RFC;
	}

	public String getCURP() {
		return CURP;
	}

	public String getSIEFORE1() {
		return SIEFORE1;
	}

	public String getSIEFORE2() {
		return SIEFORE2;
	}

	public String getSIEFORE3() {
		return SIEFORE3;
	}

	public String getSIEFORE4() {
		return SIEFORE4;
	}

	public String getFECCREA() {
		return FECCREA;
	}

	public String getTIPOCLIENTE() {
		return TIPOCLIENTE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public String getADATE() {
		return ADATE;
	}

	public String getAUSER() {
		return AUSER;
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

	public void setNOMBRE(String DATA) {
		this.NOMBRE = DATA != null ? DATA.trim() : "";
	}

	public void setNSS(String DATA) {
		this.NSS = DATA != null ? DATA.trim() : "";
	}

	public void setRFC(String DATA) {
		this.RFC = DATA != null ? DATA.trim() : "";
	}

	public void setCURP(String DATA) {
		this.CURP = DATA != null ? DATA.trim() : "";
	}

	public void setSIEFORE1(String DATA) {
		this.SIEFORE1 = DATA != null ? DATA.trim() : "";
	}

	public void setSIEFORE2(String DATA) {
		this.SIEFORE2 = DATA != null ? DATA.trim() : "";
	}

	public void setSIEFORE3(String DATA) {
		this.SIEFORE3 = DATA != null ? DATA.trim() : "";
	}

	public void setSIEFORE4(String DATA) {
		this.SIEFORE4 = DATA != null ? DATA.trim() : "";
	}

	public void setFECCREA(String DATA) {
		this.FECCREA = DATA != null ? DATA.trim() : "";
	}

	public void setTIPOCLIENTE(String DATA) {
		this.TIPOCLIENTE = DATA != null ? DATA.trim() : "";
	}

	public void setSTATUS(String DATA) {
		this.STATUS = DATA != null ? DATA.trim() : "";
	}

	public void setAUSER(String DATA) {
		this.AUSER = DATA != null ? DATA.trim() : "";
	}

	public void setADATE(String DATA) {
		if (DATA != null) {
			String DYY = DATA.substring(0, 4);
			String DMM = DATA.substring(4, 6);
			String DDD = DATA.substring(6, 8);
			this.ADATE = DDD + "/" + DMM + "/" + DYY;
		} else
			this.ADATE = "";
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tUSERID  =" + USERID + "\n");
		results.append("\tFOLIO   =" + FOLIO + "\n");
		results.append("\tNOMBRE  =" + NOMBRE + "\n");
		results.append("\tNSS     =" + NSS + "\n");
		results.append("\tRFC     =" + RFC + "\n");
		results.append("\tCURP    =" + CURP + "\n");
		results.append("\tSIEFORE1=" + SIEFORE1 + "\n");
		results.append("\tSIEFORE2=" + SIEFORE2 + "\n");
		results.append("\tSIEFORE3=" + SIEFORE3 + "\n");
		results.append("\tSIEFORE4=" + SIEFORE4 + "\n");
		results.append("\tFECCREA =" + FECCREA + "\n");
		results.append("\tTIPOCLIENTE =" + TIPOCLIENTE + "\n");

		return results.toString();
	}

	public String getFechaOpe() {
		String rt = "";
		String date = this.FECCREA;
		if (!date.equals("")) {
			String DD = date.substring(6, 8);
			String MM = date.substring(4, 6);
			String YY = date.substring(2, 4);
			rt = DD + "/" + MM + "/" + YY;
		}
		return rt;
	}

	public String getHoraOpe() {
		String rt = "";
		String date = this.FECCREA;
		if (!date.equals("")) {
			String HH = date.substring(8, 10);
			String mm = date.substring(10, 12);
			rt = HH + ":" + mm;
		}
		return rt;
	}
}