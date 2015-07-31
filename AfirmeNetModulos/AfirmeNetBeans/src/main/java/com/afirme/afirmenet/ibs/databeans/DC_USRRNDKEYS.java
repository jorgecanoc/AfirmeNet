/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: DC_ENTRNDKEYS.java
 * Creado: Feb 1, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: DC_ENTRNDKEYS
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cosurof
 *
 */
public class DC_USRRNDKEYS implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String USERID;
	private String KEYID;
	private BigDecimal KEYN1;
	private BigDecimal KEYN2;
	private String	CDATE;
	private String 	EDATE;
	private String  STS;
	

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tUSERID=" + USERID + "\n");
		results.append("\tKEYID=" + KEYID + "\n");
		results.append("\tKEYN1=" + KEYN1 + "\n");
		results.append("\tKEYN2=" + KEYN2 + "\n");
		results.append("\tCDATE=" + CDATE + "\n");
		results.append("\tEDATE=" + EDATE + "\n");
		results.append("\tSTS=" + STS + "\n");

		return results.toString();
	 }

	/**
	 * @return
	 */
	public String getCDATE() {
		return CDATE;
	}

	/**
	 * @return
	 */
	public String getEDATE() {
		return EDATE;
	}


	/**
	 * @return
	 */
	public String getKEYID() {
		return KEYID;
	}

	/**
	 * @return
	 */
	public BigDecimal getKEYN1() {
		return KEYN1;
	}

	/**
	 * @return
	 */
	public BigDecimal getKEYN2() {
		return KEYN2;
	}

	/**
	 * @return
	 */
	public String getSTS() {
		return STS;
	}

	/**
	 * @return
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @param string
	 */
	public void setCDATE(String string) {
		CDATE = string;
	}

	/**
	 * @param string
	 */
	public void setEDATE(String string) {
		EDATE = string;
	}


	/**
	 * @param string
	 */
	public void setKEYID(String string) {
		KEYID = string;
	}

	/**
	 * @param integer
	 */
	public void setKEYN1(BigDecimal integer) {
		KEYN1 = integer;
	}

	/**
	 * @param integer
	 */
	public void setKEYN2(BigDecimal integer) {
		KEYN2 = integer;
	}

	/**
	 * @param string
	 */
	public void setSTS(String string) {
		STS = string;
	}

	/**
	 * @param string
	 */
	public void setUSERID(String string) {
		USERID = string;
	}

}
