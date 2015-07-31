/*
 * Modificado por:	Christian Antonio Gómez Flores
 * Empresa:			Consiss
 * Fecha:			24-Mayo-2006
 * */

package com.afirme.afirmenet.ibs.databeans;

public class AF_TraspasoAFORE{
	
	private String contrato="";
	private String usuario="";
	private String folioSolCLIP="";
	private String fecha="";
	private String folioTraspasoEV="";
	private String resulWS="";
	private String motivoRechazo="";
	private String folioTraspasoAFAF="";
	private String fechaProbLiq="";
	private String error="";
	private String input="";
	private String output="";

	public AF_TraspasoAFORE(){
	}

	/**
	 * @return
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @return
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @return
	 */
	public String getFolioSolCLIP() {
		return folioSolCLIP;
	}

	/**
	 * @return
	 */
	public String getFolioTraspasoAFAF() {
		return folioTraspasoAFAF;
	}

	/**
	 * @return
	 */
	public String getFolioTraspasoEV() {
		return folioTraspasoEV;
	}

	/**
	 * @return
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @return
	 */
	public String getResulWS() {
		return resulWS;
	}

	/**
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param string
	 */
	public void setContrato(String string) {
		contrato = string;
	}

	/**
	 * @param string
	 */
	public void setFecha(String string) {
		fecha = string;
	}

	/**
	 * @param string
	 */
	public void setFolioSolCLIP(String string) {
		folioSolCLIP = string;
	}

	/**
	 * @param string
	 */
	public void setFolioTraspasoAFAF(String string) {
		folioTraspasoAFAF = string;
	}

	/**
	 * @param string
	 */
	public void setFolioTraspasoEV(String string) {
		folioTraspasoEV = string;
	}

	/**
	 * @param string
	 */
	public void setMotivoRechazo(String string) {
		motivoRechazo = string;
	}

	/**
	 * @param string
	 */
	public void setResulWS(String string) {
		resulWS = string;
	}

	/**
	 * @param string
	 */
	public void setUsuario(String string) {
		usuario = string;
	}

	/**
	 * @return
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param string
	 */
	public void setError(String string) {
		error = string;
	}

	/**
	 * @return
	 */
	public String getFechaProbLiq() {
		return fechaProbLiq;
	}

	/**
	 * @param string
	 */
	public void setFechaProbLiq(String string) {
		fechaProbLiq = string;
	}

	/**
	 * @return
	 */
	public String getInput() {
		return input;
	}

	/**
	 * @return
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param string
	 */
	public void setInput(String string) {
		input = string;
	}

	/**
	 * @param string
	 */
	public void setOutput(String string) {
		output = string;
	}

}