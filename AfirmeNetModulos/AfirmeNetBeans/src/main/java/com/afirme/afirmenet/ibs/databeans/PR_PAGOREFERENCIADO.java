/*
 * Creado por:			Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Creacion:		20-Agosto-2007
 * Modificado por:		Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Modificacion:	21-Agosto-2007
 * */
package com.afirme.afirmenet.ibs.databeans;

public class PR_PAGOREFERENCIADO {

	private String contrato = "";
	private String usuario = "";
	private String DCIBS_REF = "";
	private String PDD = "";
	private String PMM = "";
	private String PYY = "";
	private String PHH = "";
	private String PMIN = "";
	private String VDD = "";
	private String VMM = "";
	private String VYY = "";
	private String VHH = "";
	private String VMIN = "";
	private String OUSER = "";
	private String VUSER = "";
	private String AUSER = "";
	private String ODATE = "";
	private String VDATE = "";
	private String ADATE = "";
	private int NUMAPR = 0;
	private String ESTATUS = "";
	private String codMoneda = "MXP";
	private String cuentaReferenciada = "";
	private String cuentaCargo = "";
	private String referencia1 = "";
	private String referencia2 = "";
	private String referencia3 = "";
	private String referencia4 = "";
	private String dVenc = "";
	private String mVenc = "";
	private String aVenc = "";
	private String monto = "0.00";
	private String recargos = "0.00";
	private String montoSinRecargos = "0.00";
	private int diasGracia = 0;
	private String numConf_AS400 = "";

	/**
	 * @return
	 */
	public String getADATE() {
		return ADATE;
	}

	/**
	 * @return
	 */
	public String getAUSER() {
		return AUSER;
	}

	/**
	 * @return
	 */
	public String getCuentaReferenciada() {
		return cuentaReferenciada;
	}

	/**
	 * @return
	 */
	public String getESTATUS() {
		return ESTATUS;
	}

	/**
	 * @return
	 */
	public int getNUMAPR() {
		return NUMAPR;
	}

	/**
	 * @return
	 */
	public String getODATE() {
		return ODATE;
	}

	/**
	 * @return
	 */
	public String getOUSER() {
		return OUSER;
	}

	/**
	 * @return
	 */
	public String getPDD() {
		return PDD;
	}

	/**
	 * @return
	 */
	public String getPHH() {
		return PHH;
	}

	/**
	 * @return
	 */
	public String getPMIN() {
		return PMIN;
	}

	/**
	 * @return
	 */
	public String getPMM() {
		return PMM;
	}

	/**
	 * @return
	 */
	public String getPYY() {
		return PYY;
	}

	/**
	 * @return
	 */
	public String getVDATE() {
		return VDATE;
	}

	/**
	 * @return
	 */
	public String getVDD() {
		return VDD;
	}

	/**
	 * @return
	 */
	public String getVHH() {
		return VHH;
	}

	/**
	 * @return
	 */
	public String getVMIN() {
		return VMIN;
	}

	/**
	 * @return
	 */
	public String getVMM() {
		return VMM;
	}

	/**
	 * @return
	 */
	public String getVUSER() {
		return VUSER;
	}

	/**
	 * @return
	 */
	public String getVYY() {
		return VYY;
	}

	/**
	 * @param string
	 */
	public void setADATE(String string) {
		ADATE = string;
	}

	/**
	 * @param string
	 */
	public void setAUSER(String string) {
		AUSER = string;
	}

	/**
	 * @param string
	 */
	public void setCuentaReferenciada(String string) {
		cuentaReferenciada = string;
	}

	/**
	 * @param string
	 */
	public void setESTATUS(String string) {
		ESTATUS = string;
	}

	/**
	 * @param i
	 */
	public void setNUMAPR(int i) {
		NUMAPR = i;
	}

	/**
	 * @param string
	 */
	public void setODATE(String string) {
		ODATE = string;
	}

	/**
	 * @param string
	 */
	public void setOUSER(String string) {
		OUSER = string;
	}

	/**
	 * @param string
	 */
	public void setPDD(String string) {
		PDD = string;
	}

	/**
	 * @param string
	 */
	public void setPHH(String string) {
		PHH = string;
	}

	/**
	 * @param string
	 */
	public void setPMIN(String string) {
		PMIN = string;
	}

	/**
	 * @param string
	 */
	public void setPMM(String string) {
		PMM = string;
	}

	/**
	 * @param string
	 */
	public void setPYY(String string) {
		PYY = string;
	}

	/**
	 * @param string
	 */
	public void setVDATE(String string) {
		VDATE = string;
	}

	/**
	 * @param string
	 */
	public void setVDD(String string) {
		VDD = string;
	}

	/**
	 * @param string
	 */
	public void setVHH(String string) {
		VHH = string;
	}

	/**
	 * @param string
	 */
	public void setVMIN(String string) {
		VMIN = string;
	}

	/**
	 * @param string
	 */
	public void setVMM(String string) {
		VMM = string;
	}

	/**
	 * @param string
	 */
	public void setVUSER(String string) {
		VUSER = string;
	}

	/**
	 * @param string
	 */
	public void setVYY(String string) {
		VYY = string;
	}

	/**
	 * @return
	 */
	public String getCuentaCargo() {
		return cuentaCargo;
	}

	/**
	 * @param string
	 */
	public void setCuentaCargo(String string) {
		cuentaCargo = string;
	}

	/**
	 * @return
	 */
	public String getAVenc() {
		return aVenc;
	}

	/**
	 * @return
	 */
	public String getDVenc() {
		return dVenc;
	}

	/**
	 * @return
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * @return
	 */
	public String getMVenc() {
		return mVenc;
	}

	/**
	 * @return
	 */
	public String getRecargos() {
		return recargos;
	}

	/**
	 * @return
	 */
	public String getReferencia1() {
		return referencia1;
	}

	/**
	 * @return
	 */
	public String getReferencia2() {
		return referencia2;
	}

	/**
	 * @return
	 */
	public String getReferencia3() {
		return referencia3;
	}

	/**
	 * @return
	 */
	public String getReferencia4() {
		return referencia4;
	}

	/**
	 * @param string
	 */
	public void setAVenc(String string) {
		aVenc = string;
	}

	/**
	 * @param string
	 */
	public void setDVenc(String string) {
		dVenc = string;
	}

	/**
	 * @param string
	 */
	public void setMonto(String string) {
		monto = string;
	}

	/**
	 * @param string
	 */
	public void setMVenc(String string) {
		mVenc = string;
	}

	/**
	 * @param string
	 */
	public void setRecargos(String string) {
		recargos = string;
	}

	/**
	 * @param string
	 */
	public void setReferencia1(String string) {
		referencia1 = string;
	}

	/**
	 * @param string
	 */
	public void setReferencia2(String string) {
		referencia2 = string;
	}

	/**
	 * @param string
	 */
	public void setReferencia3(String string) {
		referencia3 = string;
	}

	/**
	 * @param string
	 */
	public void setReferencia4(String string) {
		referencia4 = string;
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
	public void setUsuario(String string) {
		usuario = string;
	}

	/**
	 * @return
	 */
	public String getCodMoneda() {
		return codMoneda;
	}

	/**
	 * @param string
	 */
	public void setCodMoneda(String string) {
		codMoneda = string;
	}

	/**
	 * @return
	 */
	public String getDCIBS_REF() {
		return DCIBS_REF;
	}

	/**
	 * @param string
	 */
	public void setDCIBS_REF(String string) {
		DCIBS_REF = string;
	}

	/**
	 * @return
	 */
	public String getMontoSinRecargos() {
		return montoSinRecargos;
	}

	/**
	 * @param string
	 */
	public void setMontoSinRecargos(String string) {
		montoSinRecargos = string;
	}

	/**
	 * @return
	 */
	public int getDiasGracia() {
		return diasGracia;
	}

	/**
	 * @param i
	 */
	public void setDiasGracia(int i) {
		diasGracia = i;
	}

	/**
	 * @return
	 */
	public String getNumConf_AS400() {
		return numConf_AS400;
	}

	/**
	 * @param string
	 */
	public void setNumConf_AS400(String string) {
		numConf_AS400 = string;
	}

}