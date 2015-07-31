package com.afirme.afirmenet.ibs.databeans;

import java.lang.String;
import java.math.BigDecimal;

/**
 * 
 * @author 0lgsauher
 * 
 */
public class AF_ReimpresionComprobante implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The attributes
	 */
	protected int NUMTRANS = 0;
	protected String DCIBS_REF = "";
	protected String LOTE = "";
	protected String ENTITYID = "";
	protected String USERID = "";
	protected String FOLIO = "";
	protected String NOMBRE = "";
	protected String NSS = "";
	protected String RFC = "";
	protected String CURP = "";
	protected String TIPOAPO = "";
	protected String SIEFORE = "";
	protected String MONEDA = "";
	protected BigDecimal MONTO = new BigDecimal("0");
	protected String DEDUCEI = "";
	protected String SIEFORE1 = "";
	protected String SIEFORE2 = "";
	protected String SIEFORE3 = "";
	protected String SIEFORE4 = "";
	protected String DEBACC = "";
	protected String NUMAPR = "";
	protected String OUSER = "";
	protected String VUSER = "";
	protected String AUSER = "";
	protected String ODATE = "";
	protected String VDATE = "";
	protected String ADATE = "";
	protected String VDD = "";
	protected String VMM = "";
	protected String VYY = "";
	protected String VHH = "";
	protected String VSS = "";
	protected int ID_PROG = 0;

	protected String INI_DD = "";
	protected String INI_MM = "";
	protected String INI_YY = "";
	protected String FIN_DD = "";
	protected String FIN_MM = "";
	protected String FIN_YY = "";
	protected String TIPO_PROG = "";
	protected String TIPOCLIENTE = "";

	protected String DAY1_HH = ""; // Monday
	protected String DAY1_SS = "";
	protected String DAY2_HH = ""; // Tuesday
	protected String DAY2_SS = "";
	protected String DAY3_HH = ""; // Wednesday
	protected String DAY3_SS = "";
	protected String DAY4_HH = ""; // Thursday
	protected String DAY4_SS = "";
	protected String DAY5_HH = ""; // Friday
	protected String DAY5_SS = "";
	protected String DAY6_HH = ""; // Saturday
	protected String DAY6_SS = "";
	protected String DAY7_HH = ""; // Sunday
	protected String DAY7_SS = "";
	protected String MONTHLY_HH = "";
	protected String MONTHLY_SS = "";
	protected int MONTHLY_DAY = 0;
	protected int ANTES_HABIL = 0;

	protected String FECHA_INI = "";
	protected String FECHA_FIN = "";
	protected String START_OPERATION;
	protected String END_OPERATION;

	protected String ESTATUS = "";
	protected String CANCELDATE = "";

	/**
	 * Gets the values.
	 */
	public int getNUMTRANS() {
		return NUMTRANS;
	}

	public String getDCIBS_REF() {
		return DCIBS_REF;
	}

	public String getLOTE() {
		return LOTE;
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

	public String getSIEFORE() {
		return SIEFORE;
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

	public String getDEBACC() {
		return DEBACC;
	}

	public String getNUMAPR() {
		return NUMAPR;
	}

	public String getOUSER() {
		return OUSER;
	}

	public String getVUSER() {
		return VUSER;
	}

	public String getAUSER() {
		return AUSER;
	}

	public String getODATE() {
		return ODATE;
	}

	public String getVDATE() {
		return VDATE;
	}

	public String getADATE() {
		return ADATE;
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

	public int getID_PROG() {
		return ID_PROG;
	}

	public String getINI_DD() {
		return INI_DD;
	}

	public String getINI_MM() {
		return INI_MM;
	}

	public String getINI_YY() {
		return INI_YY;
	}

	public String getFIN_DD() {
		return FIN_DD;
	}

	public String getFIN_MM() {
		return FIN_MM;
	}

	public String getFIN_YY() {
		return FIN_YY;
	}

	public String getTIPO_PROG() {
		return TIPO_PROG;
	}

	public String getTIPOCLIENTE() {
		return TIPOCLIENTE;
	}

	public String getDAY1_HH() {
		return DAY1_HH;
	}

	public String getDAY1_SS() {
		return DAY1_SS;
	}

	public String getDAY2_HH() {
		return DAY2_HH;
	}

	public String getDAY2_SS() {
		return DAY2_SS;
	}

	public String getDAY3_HH() {
		return DAY3_HH;
	}

	public String getDAY3_SS() {
		return DAY3_SS;
	}

	public String getDAY4_HH() {
		return DAY4_HH;
	}

	public String getDAY4_SS() {
		return DAY4_SS;
	}

	public String getDAY5_HH() {
		return DAY5_HH;
	}

	public String getDAY5_SS() {
		return DAY5_SS;
	}

	public String getDAY6_HH() {
		return DAY6_HH;
	}

	public String getDAY6_SS() {
		return DAY6_SS;
	}

	public String getDAY7_HH() {
		return DAY7_HH;
	}

	public String getDAY7_SS() {
		return DAY7_SS;
	}

	public String getMONTHLY_HH() {
		return MONTHLY_HH;
	}

	public String getMONTHLY_SS() {
		return MONTHLY_SS;
	}

	public int getMONTHLY_DAY() {
		return MONTHLY_DAY;
	}

	public int getANTES_HABIL() {
		return ANTES_HABIL;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public String getCANCELDATE() {
		return CANCELDATE;
	}

	public String getSTART_OPERATION() {
		String fechaIni = this.getINI_DD() + "/" + this.getINI_MM() + "/"
				+ this.getINI_YY();
		if (fechaIni.equals("//"))
			return "";
		else
			return fechaIni;
	}

	public String getEND_OPERATION() {
		String fechaFin = this.getFIN_DD() + "/" + this.getFIN_MM() + "/"
				+ this.getFIN_YY();
		if (fechaFin.equals("//"))
			return "";
		else
			return fechaFin;
	}

	public String getTYPE_OPERATION() {
		if ((this.getTIPO_PROG() != null) && (this.getTIPO_PROG().equals("0"))) {
			return "Mensual";
		} else if ((this.getTIPO_PROG() != null)
				&& (this.getTIPO_PROG().equals("1"))) {
			return "Por dia";
		} else {
			return "Inmediata";
		}
	}

	public String getTYPE_APO() {
		int tipoAp = Integer.parseInt(this.getTIPOAPO());
		if (tipoAp == 1) {
			return "Voluntarias";
		} else if (tipoAp == 2) {
			return "Complementarias de Retiro";
		} else if (tipoAp == 3) {
			return "De Ahorro a Largo Plazo";
		} else {
			return "Voluntarias con Perspectiva de inversión a Largo Plazo";
		}
	}

	/*
	 * public String getRefNum() { String rt =
	 * "<INPUT TYPE=RADIO NAME='AccNumber' CHECKED VALUE='" + this.getLOTE() +
	 * "'>"; return rt; }
	 */
	/**
	 * Sets the values.
	 */
	public void setNUMTRANS(int DATA) {
		this.NUMTRANS = DATA;
	}

	public void setDCIBS_REF(String DATA) {
		this.DCIBS_REF = DATA != null ? DATA.trim() : "";
	}

	public void setLOTE(String DATA) {
		this.LOTE = DATA != null ? DATA.trim() : "";
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

	public void setSIEFORE(String DATA) {
		this.SIEFORE = DATA != null ? DATA.trim() : "";
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

	public void setDEBACC(String DATA) {
		this.DEBACC = DATA != null ? DATA.trim() : "";
	}

	public void setNUMAPR(String DATA) {
		this.NUMAPR = DATA != null ? DATA.trim() : "";
	}

	public void setOUSER(String DATA) {
		this.OUSER = DATA != null ? DATA.trim() : "";
	}

	public void setVUSER(String DATA) {
		this.VUSER = DATA != null ? DATA.trim() : "";
	}

	public void setAUSER(String DATA) {
		this.AUSER = DATA != null ? DATA.trim() : "";
	}

	public void setODATE(String DATA) {
		this.ODATE = DATA != null ? DATA.trim() : "";
	}

	public void setVDATE(String DATA) {
		this.VDATE = DATA != null ? DATA.trim() : "";
	}

	public void setADATE(String DATA) {
		this.ADATE = DATA != null ? DATA.trim() : "";
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

	public void setID_PROG(int DATA) {
		this.ID_PROG = DATA;
	}

	public void setINI_DD(String DATA) {
		this.INI_DD = DATA != null ? DATA.trim() : "";
	}

	public void setINI_MM(String DATA) {
		this.INI_MM = DATA != null ? DATA.trim() : "";
	}

	public void setINI_YY(String DATA) {
		this.INI_YY = DATA != null ? DATA.trim() : "";
	}

	public void setFIN_DD(String DATA) {
		this.FIN_DD = DATA != null ? DATA.trim() : "";
	}

	public void setFIN_MM(String DATA) {
		this.FIN_MM = DATA != null ? DATA.trim() : "";
	}

	public void setFIN_YY(String DATA) {
		this.FIN_YY = DATA != null ? DATA.trim() : "";
	}

	public void setTIPO_PROG(String DATA) {
		this.TIPO_PROG = DATA != null ? DATA.trim() : "";
	}

	public void setTIPOCLIENTE(String DATA) {
		this.TIPOCLIENTE = DATA != null ? DATA.trim() : "";
	}

	public void setDAY1_HH(String DATA) {
		this.DAY1_HH = DATA != null ? DATA.trim() : "";
	}

	public void setDAY1_SS(String DATA) {
		this.DAY1_SS = DATA != null ? DATA.trim() : "";
	}

	public void setDAY2_HH(String DATA) {
		this.DAY2_HH = DATA != null ? DATA.trim() : "";
	}

	public void setDAY2_SS(String DATA) {
		this.DAY2_SS = DATA != null ? DATA.trim() : "";
	}

	public void setDAY3_HH(String DATA) {
		this.DAY3_HH = DATA != null ? DATA.trim() : "";
	}

	public void setDAY3_SS(String DATA) {
		this.DAY3_SS = DATA != null ? DATA.trim() : "";
	}

	public void setDAY4_HH(String DATA) {
		this.DAY4_HH = DATA != null ? DATA.trim() : "";
	}

	public void setDAY4_SS(String DATA) {
		this.DAY4_SS = DATA != null ? DATA.trim() : "";
	}

	public void setDAY5_HH(String DATA) {
		this.DAY5_HH = DATA != null ? DATA.trim() : "";
	}

	public void setDAY5_SS(String DATA) {
		this.DAY5_SS = DATA != null ? DATA.trim() : "";
	}

	public void setDAY6_HH(String DATA) {
		this.DAY6_HH = DATA != null ? DATA.trim() : "";
	}

	public void setDAY6_SS(String DATA) {
		this.DAY6_SS = DATA != null ? DATA.trim() : "";
	}

	public void setDAY7_HH(String DATA) {
		this.DAY7_HH = DATA != null ? DATA.trim() : "";
	}

	public void setDAY7_SS(String DATA) {
		this.DAY7_SS = DATA != null ? DATA.trim() : "";
	}

	public void setMONTHLY_HH(String DATA) {
		this.MONTHLY_HH = DATA != null ? DATA.trim() : "";
	}

	public void setMONTHLY_SS(String DATA) {
		this.MONTHLY_SS = DATA != null ? DATA.trim() : "";
	}

	public void setMONTHLY_DAY(int DATA) {
		this.MONTHLY_DAY = DATA;
	}

	public void setANTES_HABIL(int DATA) {
		this.ANTES_HABIL = DATA;
	}

	public void setESTATUS(String DATA) {
		this.ESTATUS = DATA != null ? DATA.trim() : "";
	}

	public void setCANCELDATE(String DATA) {
		this.CANCELDATE = DATA != null ? DATA.trim() : "";
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tNUMTRANS=" + NUMTRANS + "\n");
		results.append("\tDCIBS_REF=" + DCIBS_REF + "\n");
		results.append("\tLOTE    =" + LOTE + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tUSERID  =" + USERID + "\n");
		results.append("\tFOLIO   =" + FOLIO + "\n");
		results.append("\tNOMBRE  =" + NOMBRE + "\n");
		results.append("\tNSS     =" + NSS + "\n");
		results.append("\tRFC     =" + RFC + "\n");
		results.append("\tCURP    =" + CURP + "\n");
		results.append("\tTIPOAPO =" + TIPOAPO + "\n");
		results.append("\tSIEFORE =" + SIEFORE + "\n");
		results.append("\tMONEDA  =" + MONEDA + "\n");
		results.append("\tMONTO   =" + MONTO + "\n");
		results.append("\tDEDUCEI =" + DEDUCEI + "\n");
		results.append("\tSIEFORE1=" + SIEFORE1 + "\n");
		results.append("\tSIEFORE2=" + SIEFORE2 + "\n");
		results.append("\tSIEFORE3=" + SIEFORE3 + "\n");
		results.append("\tSIEFORE4=" + SIEFORE4 + "\n");
		results.append("\tDEBACC  =" + DEBACC + "\n");
		results.append("\tNUMAPR  =" + NUMAPR + "\n");
		results.append("\tOUSER   =" + OUSER + "\n");
		results.append("\tVUSER   =" + VUSER + "\n");
		results.append("\tAUSER   =" + AUSER + "\n");
		results.append("\tODATE   =" + ODATE + "\n");
		results.append("\tVDATE   =" + VDATE + "\n");
		results.append("\tADATE   =" + ADATE + "\n");
		results.append("\tVDD     =" + VDD + "\n");
		results.append("\tVMM     =" + VMM + "\n");
		results.append("\tVYY     =" + VYY + "\n");
		results.append("\tVHH     =" + VHH + "\n");
		results.append("\tVSS     =" + VSS + "\n");
		results.append("\tID_PROG =" + ID_PROG + "\n");
		results.append("\tINI_DD  =" + INI_DD + "\n");
		results.append("\tINI_MM  =" + INI_MM + "\n");
		results.append("\tINI_YY  =" + INI_YY + "\n");
		results.append("\tFIN_DD  =" + FIN_DD + "\n");
		results.append("\tFIN_MM  =" + FIN_MM + "\n");
		results.append("\tFIN_YY  =" + FIN_YY + "\n");
		results.append("\tTIPO_PROG=" + TIPO_PROG + "\n");
		results.append("\tTIPOCLIENTE=" + TIPOCLIENTE + "\n");

		return results.toString();
	}
}
