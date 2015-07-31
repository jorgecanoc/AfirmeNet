package com.afirme.afirmenet.ibs.databeans;

/**
 * Jdbc Bean Class 
 * @author 0lgsauher
 *
 */

public class DC_CHEQUE_LOG implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Para Cheques Extraviados y Protegidos (Unicos y Masivos)*/
	protected String ENTITYID = "";
	protected String USERID = "";
	protected String CUENTA = "";
	protected String NUMCHKINI = "";
	protected String NUMCHKFIN = "";
	protected String MONTO = "";
	protected String MOTIVO = "";
	protected String TITULAR_CTA = "";
	protected String DCIBS_REF = "";
	protected String MASIVO = "";
	protected String ESTATUS = "";
	protected String NUMCHK = "";
	protected String FECHA_OPERACION = "";
	
	/*Para Solicitudes de Chequeras*/
	protected String PDD = "";
	protected String PMM = "";
	protected String PYY = "";
	protected String PHH = "";
	protected String PSS = "";
	protected String TYPTRF = "";
	protected String FEES = "";
	protected String IVA = "";
	protected String FEE_IVA = "";
	protected String REFENUM = "";
		
	/**
	 * @return el eNTITYID
	 */
	public String getENTITYID() {
		return ENTITYID;
	}
	/**
	 * @param entityid el eNTITYID a establecer
	 */
	public void setENTITYID(String entityid) {
		ENTITYID = entityid;
	}
	/**
	 * @return el uSERID
	 */
	public String getUSERID() {
		return USERID;
	}
	/**
	 * @param userid el uSERID a establecer
	 */
	public void setUSERID(String userid) {
		USERID = userid;
	}
	/**
	 * @return el cUENTA
	 */
	public String getCUENTA() {
		return CUENTA;
	}
	/**
	 * @param cuenta el cUENTA a establecer
	 */
	public void setCUENTA(String cuenta) {
		CUENTA = cuenta;
	}
	/**
	 * @return el nUMCHKINI
	 */
	public String getNUMCHKINI() {
		return NUMCHKINI;
	}
	/**
	 * @param numchkini el nUMCHKINI a establecer
	 */
	public void setNUMCHKINI(String numchkini) {
		NUMCHKINI = numchkini;
	}
	/**
	 * @return el nUMCHKFIN
	 */
	public String getNUMCHKFIN() {
		return NUMCHKFIN;
	}
	/**
	 * @param numchkfin el nUMCHKFIN a establecer
	 */
	public void setNUMCHKFIN(String numchkfin) {
		NUMCHKFIN = numchkfin;
	}
	/**
	 * @return el mONTO
	 */
	public String getMONTO() {
		return MONTO;
	}
	/**
	 * @param monto el mONTO a establecer
	 */
	public void setMONTO(String monto) {
		MONTO = monto;
	}
	/**
	 * @return el mOTIVO
	 */
	public String getMOTIVO() {
		return MOTIVO;
	}
	/**
	 * @param motivo el mOTIVO a establecer
	 */
	public void setMOTIVO(String motivo) {
		MOTIVO = motivo;
	}
	/**
	 * @return el tITULAR_CTA
	 */
	public String getTITULAR_CTA() {
		return TITULAR_CTA;
	}
	/**
	 * @param titular_cta el tITULAR_CTA a establecer
	 */
	public void setTITULAR_CTA(String titular_cta) {
		TITULAR_CTA = titular_cta;
	}
	/**
	 * @return el dCIBS_REF
	 */
	public String getDCIBS_REF() {
		return DCIBS_REF;
	}
	/**
	 * @param dcibs_ref el dCIBS_REF a establecer
	 */
	public void setDCIBS_REF(String dcibs_ref) {
		DCIBS_REF = dcibs_ref;
	}
	/**
	 * @return el mASIVO
	 */
	public String getMASIVO() {
		return MASIVO;
	}
	/**
	 * @param masivo el mASIVO a establecer
	 */
	public void setMASIVO(String masivo) {
		MASIVO = masivo;
	}
	/**
	 * @return el eSTATUS
	 */
	public String getESTATUS() {
		return ESTATUS;
	}
	/**
	 * @param estatus el eSTATUS a establecer
	 */
	public void setESTATUS(String estatus) {
		ESTATUS = estatus;
	}
	
	/**
	 * @return el pDD
	 */
	public String getPDD() {
		return PDD;
	}
	/**
	 * @param pdd el pDD a establecer
	 */
	public void setPDD(String pdd) {
		PDD = pdd;
	}
	/**
	 * @return el pMM
	 */
	public String getPMM() {
		return PMM;
	}
	/**
	 * @param pmm el pMM a establecer
	 */
	public void setPMM(String pmm) {
		PMM = pmm;
	}
	/**
	 * @return el pYY
	 */
	public String getPYY() {
		return PYY;
	}
	/**
	 * @param pyy el pYY a establecer
	 */
	public void setPYY(String pyy) {
		PYY = pyy;
	}
	/**
	 * @return el pHH
	 */
	public String getPHH() {
		return PHH;
	}
	/**
	 * @param phh el pHH a establecer
	 */
	public void setPHH(String phh) {
		PHH = phh;
	}
	/**
	 * @return el pSS
	 */
	public String getPSS() {
		return PSS;
	}
	/**
	 * @param pss el pSS a establecer
	 */
	public void setPSS(String pss) {
		PSS = pss;
	}
	/**
	 * @return el tYPTRF
	 */
	public String getTYPTRF() {
		return TYPTRF;
	}
	/**
	 * @param typtrf el tYPTRF a establecer
	 */
	public void setTYPTRF(String typtrf) {
		TYPTRF = typtrf;
	}
	/**
	 * @return el fEES
	 */
	public String getFEES() {
		return FEES;
	}
	/**
	 * @param fees el fEES a establecer
	 */
	public void setFEES(String fees) {
		FEES = fees;
	}
	/**
	 * @return el iVA
	 */
	public String getIVA() {
		return IVA;
	}
	/**
	 * @param iva el iVA a establecer
	 */
	public void setIVA(String iva) {
		IVA = iva;
	}
	/**
	 * @return el fEE_IVA
	 */
	public String getFEE_IVA() {
		return FEE_IVA;
	}
	/**
	 * @param fee_iva el fEE_IVA a establecer
	 */
	public void setFEE_IVA(String fee_iva) {
		FEE_IVA = fee_iva;
	}
	/**
	 * @return el rEFENUM
	 */
	public String getREFENUM() {
		return REFENUM;
	}
	/**
	 * @param refenum el rEFENUM a establecer
	 */
	public void setREFENUM(String refenum) {
		REFENUM = refenum;
	}
	/**
	 * @return el nUMCHK
	 */
	public String getNUMCHK() {
		return NUMCHK;
	}
	/**
	 * @param numchk el nUMCHK a establecer
	 */
	public void setNUMCHK(String numchk) {
		NUMCHK = numchk;
	}
	/**
	 * @return el fECHA_OPERACION
	 */
	public String getFECHA_OPERACION() {
		return FECHA_OPERACION;
	}
	/**
	 * @param fecha_operacion el fECHA_OPERACION a establecer
	 */
	public void setFECHA_OPERACION(String fecha_operacion) {
		FECHA_OPERACION = fecha_operacion;
	}
	
	public String toString()
	{
		StringBuffer results = new StringBuffer();
		
		results.append(getClass().getName() + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tUSERID=" + USERID + "\n");
		results.append("\tCUENTA=" + CUENTA + "\n");
		results.append("\tNUMCHKINI=" + NUMCHKINI + "\n");
		results.append("\tNUMCHKFIN=" + NUMCHKFIN + "\n");
		results.append("\tMONTO=" + MONTO + "\n");
		results.append("\tMOTIVO=" + MOTIVO + "\n");
		results.append("\tTITULAR_CTA=" + TITULAR_CTA + "\n");
		results.append("\tDCIBS_REF=" + DCIBS_REF + "\n");
		results.append("\tMASIVO=" + MASIVO + "\n");
		results.append("\tESTATUS=" + ESTATUS + "\n");
		
		results.append("\tPDD=" + PDD + "\n");
		results.append("\tPMM=" + PMM + "\n");
		results.append("\tPYY=" + PYY + "\n");
		results.append("\tPHH=" + PHH + "\n");
		results.append("\tPSS=" + PSS + "\n");
		results.append("\tTYPTRF=" + TYPTRF + "\n");
		results.append("\tFEES=" + FEES + "\n");
		results.append("\tIVA=" + IVA + "\n");
		results.append("\tFEE_IVA=" + FEE_IVA + "\n");
		results.append("\tREFENUM=" + REFENUM + "\n");
		return results.toString();
	}
	
	public String getStatus()
	{
		String rt = "";
		if(this.ESTATUS.equals("P")){
			rt = "Cheque Protegido";
		}
		if(this.ESTATUS.equals("B")){
			rt = "Cheque Reportado";
		}
		return rt;
	}
	
	public String getFechaOpe()
	{
		String rt = "";
		String date = this.DCIBS_REF;
		String YY = date.substring(0, 2);
		String MM = date.substring(2, 4);
		String DD = date.substring(4, 6);
		rt = DD + "/" + MM + "/" + YY;
		return rt;
	}
	
	public String getHoraOpe()
	{
		String rt = "";
		String date = this.DCIBS_REF;
		String HH = date.substring(6, 8);
		String MM = date.substring(8, 10);
		rt = HH + ":" + MM;
		return rt;
	}

}
