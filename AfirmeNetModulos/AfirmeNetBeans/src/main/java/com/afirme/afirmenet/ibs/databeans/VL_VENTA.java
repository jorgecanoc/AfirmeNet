/*
 * Creado por:			Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Creacion:		18-Junio-2007
 * Modificado por:		Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Modificacion:	18-Junio-2007
 * */
package com.afirme.afirmenet.ibs.databeans;

public class VL_VENTA {

	private String contrato = "";
	private String usuario = "";
	private String dcibs_REF = "";
	private String dcibs_REF_Cotizacion = "";
	private String contratoVenta = "";
	private String idFondoVenta = "";
	private String descFondoVenta = "";
	private String tipoVenta = "";
	private String montoVenta = "";
	private String titulosVenta = "";
	private String tipoPagoVenta = "";
	private String origenVenta = "";
	private int modoOperacion = 0;
	private String cancelacionLiquidezVenta = "";
	private String estatusExcedenteVenta = "";
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
	private String idSerieVenta = "";
	private String descSerieVenta = "";
	private String mensajeLiquidez = "";

	private String fechaLiquidacion = "";

	public VL_VENTA() {
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
	public String getContratoVenta() {
		return contratoVenta;
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
	public String getDescFondoVenta() {
		return descFondoVenta;
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
	public String getIdFondoVenta() {
		return idFondoVenta;
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
	public String getMontoVenta() {
		return montoVenta;
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
	public String getOrigenVenta() {
		return origenVenta;
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
	public String getTipoVenta() {
		return tipoVenta;
	}

	/**
	 * @return
	 */
	public String getTipoPagoVenta() {
		return tipoPagoVenta;
	}

	/**
	 * @return
	 */
	public String getTitulosVenta() {
		return titulosVenta;
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
	public void setContratoVenta(String string) {
		contratoVenta = string;
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
	public void setDescFondoVenta(String string) {
		descFondoVenta = string;
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
	public void setIdFondoVenta(String string) {
		idFondoVenta = string;
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
	public void setMontoVenta(String string) {
		montoVenta = string;
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
	public void setOrigenVenta(String string) {
		origenVenta = string;
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
	public void setTipoVenta(String string) {
		tipoVenta = string;
	}

	/**
	 * @param string
	 */
	public void setTipoPagoVenta(String string) {
		tipoPagoVenta = string;
	}

	/**
	 * @param string
	 */
	public void setTitulosVenta(String string) {
		titulosVenta = string;
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
	public String getCancelacionLiquidezVenta() {
		return cancelacionLiquidezVenta;
	}

	/**
	 * @return
	 */
	public String getEstatusExcedenteVenta() {
		return estatusExcedenteVenta;
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
	public void setCancelacionLiquidezVenta(String string) {
		cancelacionLiquidezVenta = string;
	}

	/**
	 * @param string
	 */
	public void setEstatusExcedenteVenta(String string) {
		estatusExcedenteVenta = string;
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
	public String getIdSerieVenta() {
		return idSerieVenta;
	}

	/**
	 * @return
	 */
	public String getDescSerieVenta() {
		return descSerieVenta;
	}

	/**
	 * @param string
	 */
	public void setIdSerieVenta(String string) {
		idSerieVenta = string;
	}

	/**
	 * @param string
	 */
	public void setDescSerieVenta(String string) {
		descSerieVenta = string;
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