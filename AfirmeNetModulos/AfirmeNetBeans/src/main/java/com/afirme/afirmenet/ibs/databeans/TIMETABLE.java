package com.afirme.afirmenet.ibs.databeans;

public class TIMETABLE implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected java.lang.String TRANSTYPE = "";

	public java.lang.String getTRANSTYPE() {
		return TRANSTYPE.toUpperCase().trim();
	}

	public void setTRANSTYPE(java.lang.String TRANSTYPE) {
		this.TRANSTYPE = TRANSTYPE;
	}

	protected java.lang.String DAYOFWEEK = "";

	public java.lang.String getDAYOFWEEK() {
		return DAYOFWEEK.toUpperCase().trim();
	}

	public void setDAYOFWEEK(java.lang.String DAYOFWEEK) {
		this.DAYOFWEEK = DAYOFWEEK;
	}

	protected int INITIME = 0;

	public int getINITIME() {
		return INITIME;
	}

	public void setINITIME(int INITIME) {
		this.INITIME = INITIME;
	}

	protected int ENDTIME = 0;

	public int getENDTIME() {
		return ENDTIME;
	}

	public void setENDTIME(int ENDTIME) {
		this.ENDTIME = ENDTIME;
	}

	protected java.lang.String STS = "";

	public java.lang.String getSTS() {
		return STS.toUpperCase().trim();
	}

	public void setSTS(java.lang.String STS) {
		this.STS = STS;
	}

	protected java.lang.String TRANSDESC = "";

	public java.lang.String getTRANSDESC() {
		return TRANSDESC.toUpperCase().trim();
	}

	public void setTRANSDESC(java.lang.String TRANSDESC) {
		this.TRANSDESC = TRANSDESC;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tTRANSTYPE=" + TRANSTYPE + "\n");
		results.append("\tDAYOFWEEK=" + DAYOFWEEK + "\n");
		results.append("\tINITIME=" + INITIME + "\n");
		results.append("\tENDTIME=" + ENDTIME + "\n");
		results.append("\tSTS=" + STS + "\n");
		results.append("\tTRANSDESC=" + TRANSDESC + "\n");

		return results.toString();
	}

}