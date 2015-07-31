package com.afirme.afirmenet.ibs.databeans;


/**
 * Jdbc Bean Class
 * 
 * @author 0lgsauher
 * 
 */

public class DC_CONVENIO_LOG implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String CONVNUM = "";
	protected String STATUS = "";
	protected String FECHA_BORRADO = "";
	protected String TIPO_TRANSACCION = "";
	protected String ENTITYID = "";
	protected String CUENTA = "";
	protected String DESCRIPCION_TRANSACCION = "";
	protected String TIPO_EMPRESA = "";
	protected String NOMBRE_BANCO = "";
	protected String PROPIETARIO_CTA = "";
	protected String TITULAR_CTA = "";
	protected String ESTATUS_PT = "";

	// variables para almacenar los datos de Folios de Afore
	protected String USERID = "";
	protected String NSS = "";
	protected String RFC = "";
	protected String CURP = "";
	protected String SIEFORE1 = "";
	protected String SIEFORE2 = "";
	protected String SIEFORE3 = "";
	protected String SIEFORE4 = "";
	protected String TIPOCLIENTE = "";

	/**
	 * @return el cONVNUM
	 */
	public String getCONVNUM() {
		return CONVNUM;
	}

	/**
	 * @param convnum
	 *            el cONVNUM a establecer
	 */
	public void setCONVNUM(String convnum) {
		CONVNUM = convnum;
	}

	/**
	 * @return el sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}

	/**
	 * @param status
	 *            el sTATUS a establecer
	 */
	public void setSTATUS(String status) {
		STATUS = status;
	}

	/**
	 * @return el fECHA_BORRADO
	 */
	public String getFECHA_BORRADO() {
		return FECHA_BORRADO;
	}

	/**
	 * @param fecha_borrado
	 *            el fECHA_BORRADO a establecer
	 */
	public void setFECHA_BORRADO(String fecha_borrado) {
		FECHA_BORRADO = fecha_borrado;
	}

	/**
	 * @return el tIPO_TRANSACCION
	 */
	public String getTIPO_TRANSACCION() {
		return TIPO_TRANSACCION;
	}

	/**
	 * @param tipo_transaccion
	 *            el tIPO_TRANSACCION a establecer
	 */
	public void setTIPO_TRANSACCION(String tipo_transaccion) {
		TIPO_TRANSACCION = tipo_transaccion;
	}

	/**
	 * @return el eNTITYID
	 */
	public String getENTITYID() {
		return ENTITYID;
	}

	/**
	 * @param entityid
	 *            el eNTITYID a establecer
	 */
	public void setENTITYID(String entityid) {
		ENTITYID = entityid;
	}

	/**
	 * @return el cUENTA
	 */
	public String getCUENTA() {
		return CUENTA;
	}

	/**
	 * @param cuenta
	 *            el cUENTA a establecer
	 */
	public void setCUENTA(String cuenta) {
		CUENTA = cuenta;
	}

	/**
	 * @return el dESCRIPCION_TRANSACCION
	 */
	public String getDESCRIPCION_TRANSACCION() {
		return DESCRIPCION_TRANSACCION;
	}

	/**
	 * @param descripcion_transaccion
	 *            el dESCRIPCION_TRANSACCION a establecer
	 */
	public void setDESCRIPCION_TRANSACCION(String descripcion_transaccion) {
		DESCRIPCION_TRANSACCION = descripcion_transaccion;
	}

	/**
	 * @return el tIPO_EMPRESA
	 */
	public String getTIPO_EMPRESA() {
		return TIPO_EMPRESA;
	}

	/**
	 * @param tipo_empresa
	 *            el tIPO_EMPRESA a establecer
	 */
	public void setTIPO_EMPRESA(String tipo_empresa) {
		TIPO_EMPRESA = tipo_empresa;
	}

	/**
	 * @return el nOMBRE_BANCO
	 */
	public String getNOMBRE_BANCO() {
		return NOMBRE_BANCO;
	}

	/**
	 * @param nombre_banco
	 *            el nOMBRE_BANCO a establecer
	 */
	public void setNOMBRE_BANCO(String nombre_banco) {
		NOMBRE_BANCO = nombre_banco;
	}

	/**
	 * @return el pROPIETARIO_CTA
	 */
	public String getPROPIETARIO_CTA() {
		return PROPIETARIO_CTA;
	}

	/**
	 * @param propietario_cta
	 *            el pROPIETARIO_CTA a establecer
	 */
	public void setPROPIETARIO_CTA(String propietario_cta) {
		PROPIETARIO_CTA = propietario_cta;
	}

	/**
	 * @return el tITULAR_CTA
	 */
	public String getTITULAR_CTA() {
		return TITULAR_CTA;
	}

	/**
	 * @param titular_cta
	 *            el tITULAR_CTA a establecer
	 */
	public void setTITULAR_CTA(String titular_cta) {
		TITULAR_CTA = titular_cta;
	}

	/**
	 * @return el eSTATUS_PT
	 */
	public String getESTATUS_PT() {
		return ESTATUS_PT;
	}

	/**
	 * @param estatus_pt
	 *            el eSTATUS_PT a establecer
	 */
	public void setESTATUS_PT(String estatus_pt) {
		ESTATUS_PT = estatus_pt;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tCONVNUM=" + CONVNUM + "\n");
		results.append("\tSTATUS=" + STATUS + "\n");
		results.append("\tFECHA_BORRADO=" + FECHA_BORRADO + "\n");
		results.append("\tTIPO_TRANSACCION=" + TIPO_TRANSACCION + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tCUENTA=" + CUENTA + "\n");
		results.append("\tDESCRIPCION_TRANSACCION=" + DESCRIPCION_TRANSACCION
				+ "\n");
		results.append("\tTIPO_EMPRESA=" + TIPO_EMPRESA + "\n");
		results.append("\tNOMBRE_BANCO=" + NOMBRE_BANCO + "\n");
		results.append("\tPROPIETARIO_CTA=" + PROPIETARIO_CTA + "\n");
		results.append("\tTITULAR_CTA=" + TITULAR_CTA + "\n");
		results.append("\tESTATUS_PT=" + ESTATUS_PT + "\n");
		return results.toString();
	}

	public String getStatus() {

		String rt = "";
		if (this.ESTATUS_PT.equals("P")) {
			rt = "Pendiente por Banco";
		}
		if (this.ESTATUS_PT.equals("A")) {
			rt = "Autorizada por Banco";
		}
		return rt;
	}

	public String getFechaOpe() {
		String rt = "";
		String date = this.FECHA_BORRADO;
		String DD = date.substring(8, 10);
		String MM = date.substring(5, 7);
		String YY = date.substring(0, 4);
		rt = DD + "/" + MM + "/" + YY;
		return rt;
	}

	/**
	 * @return el uSERID
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @param userid
	 *            el uSERID a establecer
	 */
	public void setUSERID(String userid) {
		USERID = userid;
	}

	/**
	 * @return el nSS
	 */
	public String getNSS() {
		return NSS;
	}

	/**
	 * @param nss
	 *            el nSS a establecer
	 */
	public void setNSS(String nss) {
		NSS = nss;
	}

	/**
	 * @return el rFC
	 */
	public String getRFC() {
		return RFC;
	}

	/**
	 * @param rfc
	 *            el rFC a establecer
	 */
	public void setRFC(String rfc) {
		RFC = rfc;
	}

	/**
	 * @return el cURP
	 */
	public String getCURP() {
		return CURP;
	}

	/**
	 * @param curp
	 *            el cURP a establecer
	 */
	public void setCURP(String curp) {
		CURP = curp;
	}

	/**
	 * @return el sIEFORE1
	 */
	public String getSIEFORE1() {
		return SIEFORE1;
	}

	/**
	 * @param siefore1
	 *            el sIEFORE1 a establecer
	 */
	public void setSIEFORE1(String siefore1) {
		SIEFORE1 = siefore1;
	}

	/**
	 * @return el sIEFORE2
	 */
	public String getSIEFORE2() {
		return SIEFORE2;
	}

	/**
	 * @param siefore2
	 *            el sIEFORE2 a establecer
	 */
	public void setSIEFORE2(String siefore2) {
		SIEFORE2 = siefore2;
	}

	/**
	 * @return el sIEFORE3
	 */
	public String getSIEFORE3() {
		return SIEFORE3;
	}

	/**
	 * @param siefore3
	 *            el sIEFORE3 a establecer
	 */
	public void setSIEFORE3(String siefore3) {
		SIEFORE3 = siefore3;
	}

	/**
	 * @return el sIEFORE4
	 */
	public String getSIEFORE4() {
		return SIEFORE4;
	}

	/**
	 * @param siefore4
	 *            el sIEFORE4 a establecer
	 */
	public void setSIEFORE4(String siefore4) {
		SIEFORE4 = siefore4;
	}

	/**
	 * @return el tIPOCLIENTE
	 */
	public String getTIPOCLIENTE() {
		return TIPOCLIENTE;
	}

	/**
	 * @param tipocliente
	 *            el tIPOCLIENTE a establecer
	 */
	public void setTIPOCLIENTE(String tipocliente) {
		TIPOCLIENTE = tipocliente;
	}

}
