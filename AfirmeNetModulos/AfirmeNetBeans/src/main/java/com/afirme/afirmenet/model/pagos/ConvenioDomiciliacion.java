package com.afirme.afirmenet.model.pagos;

import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

public class ConvenioDomiciliacion extends TransferenciaBase {

	// INPARMPF
	private String folio; // PACONS, PCCONS
	private String acuerdo; // PAACUER
	private String servicio; // PADSCE
	private String descripcion; // PANARR, PCDSC1
	private String tipoMovimiento; // Alta (A), Modificacion (M), Cancelacion (D)
	// INCONTPF01
	private String referencia; // PCREFS
	private String fechaContratacion; // PCFEAC
	private String horaContratacion; // PCHOAC
	private String titular; // PCTITS
	private double pagoMin; // PCPAGMI
	private double pagoMax; // PCPAGMA
	// Historico
	private String fechaPago;
	private String horaPago;
	private String estatusPago;
	private String descEstatusPago;
	private String motivoRechazoPago;
	
	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}
	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}
	/**
	 * @return the acuerdo
	 */
	public String getAcuerdo() {
		return acuerdo;
	}
	/**
	 * @param acuerdo the acuerdo to set
	 */
	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}
	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	/**
	 * @return the fechaContratacion
	 */
	public String getFechaContratacion() {
		return fechaContratacion;
	}
	/**
	 * @param fechaContratacion the fechaContratacion to set
	 */
	public void setFechaContratacion(String fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	/**
	 * @return the horaContratacion
	 */
	public String getHoraContratacion() {
		return horaContratacion;
	}
	/**
	 * @param horaContratacion the horaContratacion to set
	 */
	public void setHoraContratacion(String horaContratacion) {
		this.horaContratacion = horaContratacion;
	}
	/**
	 * @return the titular
	 */
	public String getTitular() {
		return titular;
	}
	/**
	 * @param titular the titular to set
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}
	/**
	 * @return the pagoMin
	 */
	public double getPagoMin() {
		return pagoMin;
	}
	/**
	 * @param pagoMin the pagoMin to set
	 */
	public void setPagoMin(double pagoMin) {
		this.pagoMin = pagoMin;
	}
	/**
	 * @return the pagoMax
	 */
	public double getPagoMax() {
		return pagoMax;
	}
	/**
	 * @param pagoMax the pagoMax to set
	 */
	public void setPagoMax(double pagoMax) {
		this.pagoMax = pagoMax;
	}
	/**
	 * @return the tipoMovimiento
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	/**
	 * @param tipoMovimiento the tipoMovimiento to set
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	/**
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}
	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	/**
	 * @return the horaPago
	 */
	public String getHoraPago() {
		return horaPago;
	}
	/**
	 * @param horaPago the horaPago to set
	 */
	public void setHoraPago(String horaPago) {
		this.horaPago = horaPago;
	}
	/**
	 * @return the estatusPago
	 */
	public String getEstatusPago() {
		return estatusPago;
	}
	/**
	 * @param estatusPago the estatusPago to set
	 */
	public void setEstatusPago(String estatusPago) {
		this.estatusPago = estatusPago;
	}
	/**
	 * @return the motivoRechazoPago
	 */
	public String getMotivoRechazoPago() {
		return motivoRechazoPago;
	}
	/**
	 * @param motivoRechazoPago the motivoRechazoPago to set
	 */
	public void setMotivoRechazoPago(String motivoRechazoPago) {
		this.motivoRechazoPago = motivoRechazoPago;
	}
	/**
	 * @return the descEstatusPago
	 */
	public String getDescEstatusPago() {
		return descEstatusPago;
	}
	/**
	 * @param descEstatusPago the descEstatusPago to set
	 */
	public void setDescEstatusPago(String descEstatusPago) {
		this.descEstatusPago = descEstatusPago;
	}
}
