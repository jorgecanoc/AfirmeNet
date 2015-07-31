/*
 * Creado por:			Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Creacion:		18-Junio-2007
 * Modificado por:		Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Modificacion:	18-Junio-2007
 * */
package com.afirme.afirmenet.ibs.databeans;

public class VL_COMPRA {

	private String contrato = "";
	private String usuario = "";
	private String dcibs_REF = "";
	private String dcibs_REF_Cotizacion = "";
	private String contratoCompra = "";
	private String idFondoCompra = "";
	private String descFondoCompra = "";
	private String tipoCompra = "";
	private String montoCompra = "";
	private String titulosCompra = "";
	private String tipoPagoCompra = "";
	private String origenCompra = "";
	private int modoOperacion = 0;
	private String estatusBalanceCompra = "";
	private String estatusExcedenteCompra = "";
	private String mediaType = "";
	private String precioOperacion = "";
	private String comisionOperacion = "";
	private String ivaComisionOperacion = "";
	private String fondoOperacion = "";
	private String serieOperacion = "";
	private String titulosOperacion = "";
	private String montoOperacion = "";
	private String remanenteOperacion = "";
	private int estatusOperacion = -600;
	private String mensajeOperacion = "";
	private String confirmacionOperacion = "";
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
	private String idSerieCompra = "";
	private String mensajeLiquidez = "";
	private String descFondoCompraPosicion = "";
	private String fechaLiquidacion = "";

	public VL_COMPRA() {
	}

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
	public String getComisionOperacion() {
		return comisionOperacion;
	}

	/**
	 * @return
	 */
	public String getConfirmacionOperacion() {
		return confirmacionOperacion;
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
	public String getContratoCompra() {
		return contratoCompra;
	}

	/**
	 * @return
	 */
	public String getDcibs_REF() {
		return dcibs_REF;
	}

	/**
	 * @return
	 */
	public String getDcibs_REF_Cotizacion() {
		return dcibs_REF_Cotizacion;
	}

	/**
	 * @return
	 */
	public String getDescFondoCompra() {
		return descFondoCompra;
	}

	/**
	 * @return
	 */
	public int getEstatusOperacion() {
		return estatusOperacion;
	}

	/**
	 * @return
	 */
	public String getIdFondoCompra() {
		return idFondoCompra;
	}

	/**
	 * @return
	 */
	public String getIvaComisionOperacion() {
		return ivaComisionOperacion;
	}

	/**
	 * @return
	 */
	public String getMensajeOperacion() {
		return mensajeOperacion;
	}

	/**
	 * @return
	 */
	public String getMontoCompra() {
		return montoCompra;
	}

	/**
	 * @return
	 */
	public String getMontoOperacion() {
		return montoOperacion;
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
	public String getOrigenCompra() {
		return origenCompra;
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
	public String getPrecioOperacion() {
		return precioOperacion;
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
	public String getRemanenteOperacion() {
		return remanenteOperacion;
	}

	/**
	 * @return
	 */
	public String getSerieOperacion() {
		return serieOperacion;
	}

	/**
	 * @return
	 */
	public String getTipoCompra() {
		return tipoCompra;
	}

	/**
	 * @return
	 */
	public String getTipoPagoCompra() {
		return tipoPagoCompra;
	}

	/**
	 * @return
	 */
	public String getTitulosCompra() {
		return titulosCompra;
	}

	/**
	 * @return
	 */
	public String getTitulosOperacion() {
		return titulosOperacion;
	}

	/**
	 * @return
	 */
	public String getUsuario() {
		return usuario;
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
	public void setComisionOperacion(String string) {
		comisionOperacion = string;
	}

	/**
	 * @param string
	 */
	public void setConfirmacionOperacion(String string) {
		confirmacionOperacion = string;
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
	public void setContratoCompra(String string) {
		contratoCompra = string;
	}

	/**
	 * @param string
	 */
	public void setDcibs_REF(String string) {
		dcibs_REF = string;
	}

	/**
	 * @param string
	 */
	public void setDcibs_REF_Cotizacion(String string) {
		dcibs_REF_Cotizacion = string;
	}

	/**
	 * @param string
	 */
	public void setDescFondoCompra(String string) {
		descFondoCompra = string;
	}

	/**
	 * @param i
	 */
	public void setEstatusOperacion(int i) {
		estatusOperacion = i;
	}

	/**
	 * @param string
	 */
	public void setIdFondoCompra(String string) {
		idFondoCompra = string;
	}

	/**
	 * @param string
	 */
	public void setIvaComisionOperacion(String string) {
		ivaComisionOperacion = string;
	}

	/**
	 * @param string
	 */
	public void setMensajeOperacion(String string) {
		mensajeOperacion = string;
	}

	/**
	 * @param string
	 */
	public void setMontoCompra(String string) {
		montoCompra = string;
	}

	/**
	 * @param string
	 */
	public void setMontoOperacion(String string) {
		montoOperacion = string;
	}

	/**
	 * @param string
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
	public void setOrigenCompra(String string) {
		origenCompra = string;
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
	public void setPrecioOperacion(String string) {
		precioOperacion = string;
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
	public void setRemanenteOperacion(String string) {
		remanenteOperacion = string;
	}

	/**
	 * @param string
	 */
	public void setSerieOperacion(String string) {
		serieOperacion = string;
	}

	/**
	 * @param string
	 */
	public void setTipoCompra(String string) {
		tipoCompra = string;
	}

	/**
	 * @param string
	 */
	public void setTipoPagoCompra(String string) {
		tipoPagoCompra = string;
	}

	/**
	 * @param string
	 */
	public void setTitulosCompra(String string) {
		titulosCompra = string;
	}

	/**
	 * @param string
	 */
	public void setTitulosOperacion(String string) {
		titulosOperacion = string;
	}

	/**
	 * @param string
	 */
	public void setUsuario(String string) {
		usuario = string;
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
	public String getESTATUS() {
		return ESTATUS;
	}

	/**
	 * @param string
	 */
	public void setESTATUS(String string) {
		ESTATUS = string;
	}

	/**
	 * @return
	 */
	public String getEstatusBalanceCompra() {
		return estatusBalanceCompra;
	}

	/**
	 * @return
	 */
	public String getEstatusExcedenteCompra() {
		return estatusExcedenteCompra;
	}

	/**
	 * @return
	 */
	public String getFondoOperacion() {
		return fondoOperacion;
	}

	/**
	 * @return
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * @param string
	 */
	public void setEstatusBalanceCompra(String string) {
		estatusBalanceCompra = string;
	}

	/**
	 * @param string
	 */
	public void setEstatusExcedenteCompra(String string) {
		estatusExcedenteCompra = string;
	}

	/**
	 * @param string
	 */
	public void setFondoOperacion(String string) {
		fondoOperacion = string;
	}

	/**
	 * @param string
	 */
	public void setMediaType(String string) {
		mediaType = string;
	}

	/**
	 * @return
	 */
	public int getModoOperacion() {
		return modoOperacion;
	}

	/**
	 * @param i
	 */
	public void setModoOperacion(int i) {
		modoOperacion = i;
	}

	/**
	 * @return
	 */
	public String getIdSerieCompra() {
		return idSerieCompra;
	}

	/**
	 * @param String
	 */
	public void setIdSerieCompra(String String) {
		idSerieCompra = String;
	}

	/**
	 * @return
	 */
	public String getMensajeLiquidez() {
		return mensajeLiquidez;
	}

	/**
	 * @return
	 */
	public void setMensajeLiquidez(String string) {
		mensajeLiquidez = string;
	}

	/**
	 * @return
	 */
	public String getDescFondoCompraPosicion() {
		return descFondoCompraPosicion;
	}

	/**
	 * @param string
	 */
	public void setDescFondoCompraPosicion(String string) {
		descFondoCompraPosicion = string;
	}

	/**
	 * @return
	 */
	public String getFechaLiquidacion() {
		return fechaLiquidacion;
	}

	/**
	 * @param string
	 */
	public void setFechaLiquidacion(String string) {
		fechaLiquidacion = string;
	}
}