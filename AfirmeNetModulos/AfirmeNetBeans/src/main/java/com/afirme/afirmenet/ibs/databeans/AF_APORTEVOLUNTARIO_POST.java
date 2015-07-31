package com.afirme.afirmenet.ibs.databeans;

import java.lang.String;
import java.math.BigDecimal;

public class AF_APORTEVOLUNTARIO_POST implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	protected String NUMTRANS = "";
	protected String DCIBSREF = "";
	protected String REFERENCIA = "";
	protected String REFERENCIAAFORE = "";
	protected String ENTITYID = "";
	protected String USERID = "";
	protected String FOLIO = "";
	protected String NOMBRE = "";
	protected String NSS = "";
	protected String RFC = "";
	protected String CURP = "";
	protected String TIPOAPO = "";
	protected String CVETIPOAPO = "";
	protected String SIEFORE = "";
	protected String CVESIEFORE = "";
	protected String MONEDA = "";
	protected BigDecimal MONTO = new BigDecimal("0");
	protected String DEDUCEI = "";
	protected String DEBACC = "";
	protected String CREACC = "";
	protected String NUMAPR = "";
	protected String FECHA = "";
	protected String HORA = "";
	protected String ESTATUS = "";
	protected String DESCRIPCIONERROR = "";
	protected String CORREO = "";
	protected String INFORMACION = "";
	protected String VDD = "";
	protected String VMM = "";
	protected String VYY = "";
	protected String VHH = "";
	protected String VSS = "";

	public String getNUMTRANS() {
		return NUMTRANS;
	}

	public String getDCIBSREF() {
		return DCIBSREF;
	}

	public String getREFERENCIA() {
		return REFERENCIA;
	}

	public String getREFERENCIAAFORE() {
		return REFERENCIAAFORE;
	}

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

	public String getTIPOAPO() {
		return TIPOAPO;
	}

	public String getCVETIPOAPO() {
		return CVETIPOAPO;
	}

	public String getSIEFORE() {
		return SIEFORE;
	}

	public String getCVESIEFORE() {
		return CVESIEFORE;
	}

	public String getMONEDA() {
		return MONEDA;
	}

	public BigDecimal getMONTO() {
		return MONTO;
	}

	public String getDEDUCEI() {
		return DEDUCEI;
	}

	public String getDEBACC() {
		return DEBACC;
	}

	public String getCREACC() {
		return CREACC;
	}

	public String getNUMAPR() {
		return NUMAPR;
	}

	public String getFECHA() {
		return FECHA;
	}

	public String getHORA() {
		return HORA;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public String getDESCRIPCIONERROR() {
		return DESCRIPCIONERROR;
	}

	public String getCORREO() {
		return CORREO;
	}

	public String getINFORMACION() {
		return INFORMACION;
	}

	public String getVDD() {
		return VDD;
	}

	public String getVMM() {
		return VMM;
	}

	public String getVYY() {
		return VYY;
	}

	public String getVHH() {
		return VHH;
	}

	public String getVSS() {
		return VSS;
	}

	public void setNUMTRANS(String DATA) {
		this.NUMTRANS = DATA != null ? DATA.trim() : "";
	}

	public void setDCIBSREF(String DATA) {
		this.DCIBSREF = DATA != null ? DATA.trim() : "";
	}

	public void setREFERENCIA(String DATA) {
		this.REFERENCIA = DATA != null ? DATA.trim() : "";
	}

	public void setREFERENCIAAFORE(String DATA) {
		this.REFERENCIAAFORE = DATA != null ? DATA.trim() : "";
	}

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

	public void setTIPOAPO(String DATA) {
		this.TIPOAPO = DATA != null ? DATA.trim() : "";
	}

	public void setCVETIPOAPO(String DATA) {
		this.CVETIPOAPO = DATA != null ? DATA.trim() : "";
	}

	public void setSIEFORE(String DATA) {
		this.SIEFORE = DATA != null ? DATA.trim() : "";
	}

	public void setCVESIEFORE(String DATA) {
		this.CVESIEFORE = DATA != null ? DATA.trim() : "";
	}

	public void setMONEDA(String DATA) {
		this.MONEDA = DATA != null ? DATA.trim() : "";
	}

	public void setMONTO(BigDecimal DATA) {
		this.MONTO = DATA != null ? DATA : new BigDecimal("0");
	}

	public void setDEDUCEI(String DATA) {
		this.DEDUCEI = DATA != null ? DATA.trim() : "";
	}

	public void setDEBACC(String DATA) {
		this.DEBACC = DATA != null ? DATA.trim() : "";
	}

	public void setCREACC(String DATA) {
		this.CREACC = DATA != null ? DATA.trim() : "";
	}

	public void setNUMAPR(String DATA) {
		this.NUMAPR = DATA != null ? DATA.trim() : "";
	}

	public void setFECHA(String DATA) {
		this.FECHA = DATA != null ? DATA.trim() : "";
	}

	public void setHORA(String DATA) {
		this.HORA = DATA != null ? DATA.trim() : "";
	}

	public void setESTATUS(String DATA) {
		this.ESTATUS = DATA != null ? DATA.trim() : "";
	}

	public void setDESCRIPCIONERROR(String DATA) {
		this.DESCRIPCIONERROR = DATA != null ? DATA.trim() : "";
	}

	public void setCORREO(String DATA) {
		this.CORREO = DATA != null ? DATA.trim() : "";
	}

	public void setINFORMACION(String DATA) {
		this.INFORMACION = DATA != null ? DATA.trim() : "";
	}

	public void setVDD(String DATA) {
		this.VDD = DATA != null ? DATA.trim() : "";
	}

	public void setVMM(String DATA) {
		this.VMM = DATA != null ? DATA.trim() : "";
	}

	public void setVYY(String DATA) {
		this.VYY = DATA != null ? DATA.trim() : "";
	}

	public void setVHH(String DATA) {
		this.VHH = DATA != null ? DATA.trim() : "";
	}

	public void setVSS(String DATA) {
		this.VSS = DATA != null ? DATA.trim() : "";
	}
}