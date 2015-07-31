/*
 * Creado por:			Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Creacion:		28-Septiembre-2007
 * Modificado por:		Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Modificacion:	1-Octubre-2007
 * */
package com.afirme.afirmenet.ibs.databeans;

import org.springframework.util.StringUtils;

public class TC5000PF {

	private String TCTARJ = "";
	private String TCCLTA = "";
	private String TCTATI = "";
	private String TCCUNT = "";
	private String TCCUNA = "";
	private String TCNOMB = "";
	private String TCLIMC = "";
	private String TCTIPC = "";
	private String TCPAGM = "";
	private String TCTASA = "";
	private String TCFLNC = "";
	private String TCTASD = "";
	private String TCTASF = "";

	/** TASA BANDERA PYME */

	public String getTCTASD() {
		return TCTASD;
	}

	public void setTCTASD(String tCTASD) {
		TCTASD = tCTASD;
	}

	public String getTCTASF() {
		return TCTASF;
	}

	public void setTCTASF(String tCTASF) {
		TCTASF = tCTASF;
	}

	/**********/
	/**
	 * @return
	 */
	public String getTCCLTA() {
		return TCCLTA;
	}

	/**
	 * @return
	 */
	public String getTCCUNA() {
		return TCCUNA;
	}

	/**
	 * @return
	 */
	public String getTCCUNT() {
		return TCCUNT;
	}

	/**
	 * @return
	 */
	public String getTCFLNC() {
		return TCFLNC;
	}

	/**
	 * @return
	 */
	public String getTCLIMC() {
		return TCLIMC;
	}

	/**
	 * @return
	 */
	public String getTCNOMB() {
		return TCNOMB;
	}

	/**
	 * @return
	 */
	public String getTCPAGM() {
		return TCPAGM;
	}

	/**
	 * @return
	 */
	public String getTCTARJ() {
		return TCTARJ;
	}

	/**
	 * @return
	 */
	public String getTCTATI() {
		return TCTATI;
	}

	/**
	 * @param string
	 */
	public void setTCCLTA(String string) {
		TCCLTA = string;
	}

	/**
	 * @param string
	 */
	public void setTCCUNA(String string) {
		TCCUNA = string;
	}

	/**
	 * @param string
	 */
	public void setTCCUNT(String string) {
		TCCUNT = string;
	}

	/**
	 * @param string
	 */
	public void setTCFLNC(String string) {
		TCFLNC = string;
	}

	/**
	 * @param string
	 */
	public void setTCLIMC(String string) {
		TCLIMC = string;
	}

	/**
	 * @param string
	 */
	public void setTCNOMB(String string) {
		TCNOMB = string;
	}

	/**
	 * @param string
	 */
	public void setTCPAGM(String string) {
		TCPAGM = string;
	}

	/**
	 * @param string
	 */
	public void setTCTARJ(String string) {
		TCTARJ = string;
	}

	/**
	 * @param string
	 */
	public void setTCTATI(String string) {
		TCTATI = string;
	}

	/**
	 * @return
	 */
	public String getTCTASA() {
		return TCTASA;
	}

	/**
	 * @return
	 */
	public String getTCTIPC() {
		return TCTIPC;
	}

	/**
	 * @param string
	 */
	public void setTCTASA(String string) {
		TCTASA = string;
	}

	/**
	 * @param string
	 */
	public void setTCTIPC(String string) {
		TCTIPC = string;
	}
	
	/**
	 * @return numero de cuenta con mascara
	 */
	public String getNumberMask() {
		if (!StringUtils.isEmpty(this.TCTARJ)) {
			return (this.TCTARJ.substring(0, this.TCTARJ.length() - 4))
					.replaceAll(".", "*")
					.concat(this.TCTARJ.substring(this.TCTARJ.length() - 4));
		}
		return "************";
	}

}