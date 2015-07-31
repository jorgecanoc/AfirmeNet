package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 02/03/2004 09:15:44<br>
 * &nbsp;&nbsp;&nbsp; table = "DC_CONFMSGBean"
 * 
 * @author Generator
 */
public class DC_CONFMSG implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The AMOUNT attribute.
	 */
	protected java.lang.String AMOUNT = "";

	/**
	 * The BENEADD attribute.
	 */
	protected java.lang.String BENEADD = "";

	/**
	 * The BENENAME attribute.
	 */
	protected java.lang.String BENENAME = "";
	/**
	 * The BNKRECPTOR attribute.
	 */
	protected java.lang.String BNKRECPTOR = "";

	/**
	 * The CCY attribute.
	 */
	protected java.lang.String CCY = "";

	/**
	 * The CREACC attribute.
	 */
	protected java.lang.String CREACC = "";
	/**
	 * The DCIBS_REF attribute.
	 */
	protected java.lang.String DCIBS_REF = "";

	/**
	 * The DEBACC attribute.
	 */
	protected java.lang.String DEBACC = "";

	/**
	 * The DESCRIP attribute.
	 */
	protected java.lang.String DESCRIP = "";
	/**
	 * The ENTITYID attribute.
	 */
	protected java.lang.String ENTITYID = "";

	/**
	 * The FEES attribute.
	 */
	protected java.math.BigDecimal FEES = new BigDecimal("0");

	/**
	 * The FEES attribute.
	 */
	protected java.math.BigDecimal FEE_IVA = new BigDecimal("0");

	/**
	 * The IVA attribute.
	 */
	protected java.math.BigDecimal IVA = new BigDecimal("0");
	protected java.lang.String LDTE = "";

	protected java.lang.String MSSG = "";

	/**
	 * The NARRA attribute.
	 */
	protected java.lang.String NARRA = "";
	/**
	 * The PDD attribute.
	 */
	protected java.lang.String PDD = "";

	/**
	 * The PHH attribute.
	 */
	protected java.lang.String PHH = "";

	/**
	 * The PSECONDS attribute.
	 */
	protected java.lang.String PSECONDS = "";

	/**
	 * The PLZRECPTOR attribute.
	 */
	protected java.lang.String PLZRECPTOR = "";
	/**
	 * The PMM attribute.
	 */
	protected java.lang.String PMM = "";

	/**
	 * The PSS attribute.
	 */
	protected java.lang.String PSS = "";

	/**
	 * The PYY attribute.
	 */
	protected java.lang.String PYY = "";
	/**
	 * The REFENUM attribute.
	 */
	protected java.lang.String REFENUM = "";

	/**
	 * The referencia attribute.
	 */
	protected long REFUSR = 0;

	/**
	 * The RFC attribute.
	 */
	protected java.lang.String RFC = "";

	/**
	 * The SERVNUM attribute.
	 */
	protected java.lang.String SERVNUM = "";
	protected java.lang.String TPC = "";

	/**
	 * The TYPTRF attribute.
	 */
	protected java.lang.String TYPTRF = "";

	/**
	 * The USERID attribute.
	 */
	protected java.lang.String USERID = "";
	/**
	 * The VDD attribute.
	 */
	protected java.lang.String VDD = "";

	/**
	 * The VHH attribute.
	 */
	protected java.lang.String VHH = "";

	/**
	 * The VMM attribute.
	 */
	protected java.lang.String VMM = "";
	/**
	 * The VSS attribute.
	 */
	protected java.lang.String VSS = "";

	/**
	 * The VYY attribute.
	 */
	protected java.lang.String VYY = "";

	protected java.lang.String TCNOMBRE = "";

	protected java.lang.String OTRREF = "";

	/**
	 * Gets the AMOUNT value.
	 */
	public java.lang.String getAMOUNT() {
		// return
		// com.datapro.dibs.generics.Util.formatCCY(com.datapro.dibs.generics.Util.takeComa(AMOUNT.toUpperCase().trim()));
		return AMOUNT.toUpperCase().trim();
	}

	/**
	 * Gets the BENEADD value.
	 */
	public java.lang.String getBENEADD() {
		return BENEADD.toUpperCase().trim();
	}

	/**
	 * Gets the BENENAME value.
	 */
	public java.lang.String getBENENAME() {
		return BENENAME.toUpperCase().trim();
	}

	/**
	 * Gets the BNKRECPTOR value.
	 */
	public java.lang.String getBNKRECPTOR() {
		return BNKRECPTOR.toUpperCase().trim();
	}

	/**
	 * Gets the CCY value.
	 */
	public java.lang.String getCCY() {
		return CCY.toUpperCase().trim();
	}

	/**
	 * Gets the CREACC value.
	 */
	public java.lang.String getCREACC() {
		return CREACC.toUpperCase().trim();
	}

	/**
	 * Gets the DCIBS_REF value.
	 */
	public java.lang.String getDCIBS_REF() {
		return DCIBS_REF.toUpperCase().trim();
	}

	/**
	 * Gets the DEBACC value.
	 */
	public java.lang.String getDEBACC() {
		return DEBACC.toUpperCase().trim();
	}

	/**
	 * Gets the DESCRIP value.
	 */
	public java.lang.String getDESCRIP() {
		return DESCRIP.toUpperCase().trim();
	}

	/**
	 * Gets the ENTITYID value.
	 */
	public java.lang.String getENTITYID() {
		return ENTITYID.toUpperCase().trim();
	}

	/**
	 * Gets the FEES value.
	 */
	public java.math.BigDecimal getFEES() {
		return FEES;
	}

	public java.math.BigDecimal getFEE_IVA() {
		return FEE_IVA;
	}

	public void setFEE_IVA(java.math.BigDecimal fee_iva) {
		FEE_IVA = fee_iva;
	}

	/**
	 * Gets the IVA value.
	 */
	public java.math.BigDecimal getIVA() {
		return IVA;
	}

	/**
	 * Gets the LDTE value.
	 */
	public java.lang.String getLDTE() {
		return LDTE.toUpperCase().trim();
	}

	/**
	 * Gets the MSSG value.
	 */
	public java.lang.String getMSSG() {
		return MSSG.toUpperCase().trim();
	}

	/**
	 * Gets the NARRA value.
	 */
	public java.lang.String getNARRA() {
		return NARRA.toUpperCase().trim();
	}

	/**
	 * Gets the PDD value.
	 */
	public java.lang.String getPDD() {
		return PDD.toUpperCase().trim();
	}

	/**
	 * Gets the PHH value.
	 */
	public java.lang.String getPHH() {
		return PHH.toUpperCase().trim();
	}

	/**
	 * Gets the PLZRECPTOR value.
	 */
	public java.lang.String getPLZRECPTOR() {
		return PLZRECPTOR.toUpperCase().trim();
	}

	/**
	 * Gets the PMM value.
	 */
	public java.lang.String getPMM() {
		return PMM.toUpperCase().trim();
	}

	/**
	 * Gets the PSS value.
	 */
	public java.lang.String getPSS() {
		return PSS.toUpperCase().trim();
	}

	/**
	 * Gets the PYY value.
	 */
	public java.lang.String getPYY() {
		return PYY.toUpperCase().trim();
	}

	/**
	 * Gets the REFENUM value.
	 */
	public java.lang.String getREFENUM() {
		return REFENUM.toUpperCase().trim();
	}

	/**
	 * Gets the referencia value.
	 */
	public long getREFUSR() {
		return REFUSR;
	}

	/**
	 * Gets the RFC value.
	 */
	public java.lang.String getRFC() {
		return RFC.toUpperCase().trim();
	}

	/**
	 * Gets the SERVNUM value.
	 */
	public java.lang.String getSERVNUM() {
		return SERVNUM.toUpperCase().trim();
	}

	/**
	 * Gets the TPC value.
	 */
	public java.lang.String getTPC() {
		return TPC.toUpperCase().trim();
	}

	/**
	 * Gets the TYPTRF value.
	 */
	public java.lang.String getTYPTRF() {
		return TYPTRF.toUpperCase().trim();
	}

	/**
	 * Gets the USERID value.
	 */
	public java.lang.String getUSERID() {
		return USERID.toUpperCase().trim();
	}

	/**
	 * Gets the VDD value.
	 */
	public java.lang.String getVDD() {
		return VDD.toUpperCase().trim();
	}

	/**
	 * Gets the VHH value.
	 */
	public java.lang.String getVHH() {
		return VHH.toUpperCase().trim();
	}

	/**
	 * Gets the VMM value.
	 */
	public java.lang.String getVMM() {
		return VMM.toUpperCase().trim();
	}

	/**
	 * Gets the VSS value.
	 */
	public java.lang.String getVSS() {
		return VSS.toUpperCase().trim();
	}

	/**
	 * Gets the VYY value.
	 */
	public java.lang.String getVYY() {
		return VYY.toUpperCase().trim();
	}

	/**
	 * Sets the AMOUNT value.
	 */
	public void setAMOUNT(java.lang.String AMOUNT) {
		this.AMOUNT = AMOUNT;
	}

	/**
	 * Sets the BENEADD value.
	 */
	public void setBENEADD(java.lang.String BENEADD) {
		this.BENEADD = BENEADD;
	}

	/**
	 * Sets the BENENAME value.
	 */
	public void setBENENAME(java.lang.String BENENAME) {
		this.BENENAME = BENENAME;
	}

	/**
	 * Sets the BNKRECPTOR value.
	 */
	public void setBNKRECPTOR(java.lang.String BNKRECPTOR) {
		this.BNKRECPTOR = BNKRECPTOR;
	}

	/**
	 * Sets the CCY value.
	 */
	public void setCCY(java.lang.String CCY) {
		this.CCY = CCY;
	}

	/**
	 * Sets the CREACC value.
	 */
	public void setCREACC(java.lang.String CREACC) {
		this.CREACC = CREACC;
	}

	/**
	 * Sets the DCIBS_REF value.
	 */
	public void setDCIBS_REF(java.lang.String DCIBS_REF) {
		this.DCIBS_REF = DCIBS_REF;
	}

	/**
	 * Sets the DEBACC value.
	 */
	public void setDEBACC(java.lang.String DEBACC) {
		this.DEBACC = DEBACC;
	}

	/**
	 * Sets the DESCRIP value.
	 */
	public void setDESCRIP(java.lang.String DESCRIP) {
		if (DESCRIP != null && DESCRIP.length() > 40)
			this.DESCRIP = DESCRIP.substring(0, 39);
		else
			this.DESCRIP = DESCRIP;
	}

	/**
	 * Sets the ENTITYID value.
	 */
	public void setENTITYID(java.lang.String ENTITYID) {
		this.ENTITYID = ENTITYID;
	}

	/**
	 * Sets the FEES value.
	 */
	public void setFEES(java.math.BigDecimal FEES) {
		this.FEES = FEES;
	}

	/**
	 * Sets the IVA value.
	 */
	public void setIVA(java.math.BigDecimal IVA) {
		this.IVA = IVA;
	}

	/**
	 * Sets the LDTE value.
	 */
	public void setLDTE(java.lang.String LDTE) {
		this.LDTE = LDTE;
	}

	/**
	 * Sets the MSSG value.
	 */
	public void setMSSG(java.lang.String MSSG) {
		this.MSSG = MSSG;
	}

	/**
	 * Sets the NARRA value.
	 */
	public void setNARRA(java.lang.String NARRA) {
		this.NARRA = NARRA;
	}

	/**
	 * Sets the PDD value.
	 */
	public void setPDD(java.lang.String PDD) {
		this.PDD = PDD;
	}

	/**
	 * Sets the PHH value.
	 */
	public void setPHH(java.lang.String PHH) {
		this.PHH = PHH;
	}

	/**
	 * Sets the PLZRECPTOR value.
	 */
	public void setPLZRECPTOR(java.lang.String PLZRECPTOR) {
		this.PLZRECPTOR = PLZRECPTOR;
	}

	/**
	 * Sets the PMM value.
	 */
	public void setPMM(java.lang.String PMM) {
		this.PMM = PMM;
	}

	/**
	 * Sets the PSS value.
	 */
	public void setPSS(java.lang.String PSS) {
		this.PSS = PSS;
	}

	/**
	 * Sets the PYY value.
	 */
	public void setPYY(java.lang.String PYY) {
		this.PYY = PYY;
	}

	/**
	 * Sets the REFENUM value.
	 */
	public void setREFENUM(java.lang.String REFENUM) {
		this.REFENUM = REFENUM;
	}

	/**
	 * Sets the referencia value.
	 */
	public void setREFUSR(long REFUSR) {
		this.REFUSR = REFUSR;
	}

	/**
	 * Sets the RFC value.
	 */
	public void setRFC(java.lang.String RFC) {
		this.RFC = RFC;
	}

	/**
	 * Sets the SERVNUM value.
	 */
	public void setSERVNUM(java.lang.String SERVNUM) {
		this.SERVNUM = SERVNUM;
	}

	/**
	 * Sets the TPC value.
	 */
	public void setTPC(java.lang.String TPC) {
		this.TPC = TPC;
	}

	/**
	 * Sets the TYPTRF value.
	 */
	public void setTYPTRF(java.lang.String TYPTRF) {
		this.TYPTRF = TYPTRF;
	}

	/**
	 * Sets the USERID value.
	 */
	public void setUSERID(java.lang.String USERID) {
		this.USERID = USERID;
	}

	/**
	 * Sets the VDD value.
	 */
	public void setVDD(java.lang.String VDD) {
		this.VDD = VDD;
	}

	/**
	 * Sets the VHH value.
	 */
	public void setVHH(java.lang.String VHH) {
		this.VHH = VHH;
	}

	/**
	 * Sets the VMM value.
	 */
	public void setVMM(java.lang.String VMM) {
		this.VMM = VMM;
	}

	/**
	 * Sets the VSS value.
	 */
	public void setVSS(java.lang.String VSS) {
		this.VSS = VSS;
	}

	/**
	 * Sets the VYY value.
	 */
	public void setVYY(java.lang.String VYY) {
		this.VYY = VYY;
	}

	public java.lang.String getPSECONDS() {
		return PSECONDS;
	}

	public void setPSECONDS(java.lang.String pseconds) {
		PSECONDS = pseconds;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tUSERID=" + USERID + "\n");
		results.append("\tDEBACC=" + DEBACC + "\n");
		results.append("\tCREACC=" + CREACC + "\n");
		results.append("\tAMOUNT=" + AMOUNT + "\n");
		results.append("\tCCY=" + CCY + "\n");
		results.append("\tBNKRECPTOR=" + BNKRECPTOR + "\n");
		results.append("\tPLZRECPTOR=" + PLZRECPTOR + "\n");
		results.append("\tBENENAME=" + BENENAME + "\n");
		results.append("\tBENEADD=" + BENEADD + "\n");
		results.append("\tDESCRIP=" + DESCRIP + "\n");
		results.append("\tRFC=" + RFC + "\n");
		results.append("\tNARRA=" + NARRA + "\n");
		results.append("\tPDD=" + PDD + "\n");
		results.append("\tPMM=" + PMM + "\n");
		results.append("\tPYY=" + PYY + "\n");
		results.append("\tVDD=" + VDD + "\n");
		results.append("\tVMM=" + VMM + "\n");
		results.append("\tVYY=" + VYY + "\n");
		results.append("\tPHH=" + PHH + "\n");
		results.append("\tPSS=" + PSS + "\n");
		results.append("\tVHH=" + VHH + "\n");
		results.append("\tVSS=" + VSS + "\n");
		results.append("\tTYPTRF=" + TYPTRF + "\n");
		results.append("\tREFENUM=" + REFENUM + "\n");
		results.append("\tSERVNUM=" + SERVNUM + "\n");
		results.append("\tFEES=" + FEES + "\n");
		results.append("\tFEE_IVA=" + FEE_IVA + "\n");
		results.append("\tIVA=" + IVA + "\n");
		results.append("\tDCIBS_REF=" + DCIBS_REF + "\n");
		results.append("\tMSSG=" + MSSG + "\n");
		results.append("\tTPC=" + TPC + "\n");
		results.append("\tLDTE=" + LDTE + "\n");
		results.append("\tPSECONDS=" + PSECONDS + "\n");
		results.append("\tREFUSR=" + REFUSR + "\n");
		return results.toString();
	}

	public java.lang.String getTCNOMBRE() {
		return TCNOMBRE;
	}

	public void setTCNOMBRE(java.lang.String tcnombre) {
		TCNOMBRE = tcnombre;
	}

	public java.lang.String getOTRREF() {
		return OTRREF;
	}

	public void setOTRREF(java.lang.String oTRREF) {
		OTRREF = oTRREF;
	}

}