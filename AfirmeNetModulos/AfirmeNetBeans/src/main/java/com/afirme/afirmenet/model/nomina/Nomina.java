package com.afirme.afirmenet.model.nomina;

import java.text.DecimalFormat;

import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

/**
 * @author 0cdcarguz
 *
 */
public class Nomina extends TransferenciaBase {

	private String clave; // Credito(C), Consulta Saldo(S), Abono(A)
	private String movimiento; // Obtener Numero de Credito(NC), Validacion(I), Confirmar Credito(V), Confirmar Abono(F), Ejecucion Abono(P), Ejecucion Credito(A)
	private double montoAutorizado;
	private double saldoCapital;
	private double creditoUtilizado;
	private double creditoDisponible;
	private double anticipoUtilizado;
	private String CAT;
	private String seguro;
	private String tasa;
	private String moratoria;
	private String plazo;
	private String fechaPago;
	private String totalDescuentos;
	private String totalCreditos;
	private double importeDescuento;
	private String folio;
	
	private static final String NUMBER_FORMAT = "###,###,###.00";
	
	public String getMontoAutorizadoFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(getMontoAutorizado());
	}
	
	public String getCreditoDisponibleFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(getCreditoDisponible());
	}
	
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * @return the movimiento
	 */
	public String getMovimiento() {
		return movimiento;
	}
	/**
	 * @param movimiento the movimiento to set
	 */
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	/**
	 * @return the montoAutorizado
	 */
	public double getMontoAutorizado() {
		return montoAutorizado;
	}
	/**
	 * @param montoAutorizado the montoAutorizado to set
	 */
	public void setMontoAutorizado(double montoAutorizado) {
		this.montoAutorizado = montoAutorizado;
	}
	/**
	 * @return the saldoCapital
	 */
	public double getSaldoCapital() {
		return saldoCapital;
	}
	/**
	 * @param saldoCapital the saldoCapital to set
	 */
	public void setSaldoCapital(double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}
	/**
	 * @return the creditoUtilizado
	 */
	public double getCreditoUtilizado() {
		return creditoUtilizado;
	}
	/**
	 * @param creditoUtilizado the creditoUtilizado to set
	 */
	public void setCreditoUtilizado(double creditoUtilizado) {
		this.creditoUtilizado = creditoUtilizado;
	}
	/**
	 * @return the creditoDisponible
	 */
	public double getCreditoDisponible() {
		return creditoDisponible;
	}
	/**
	 * @param creditoDisponible the creditoDisponible to set
	 */
	public void setCreditoDisponible(double creditoDisponible) {
		this.creditoDisponible = creditoDisponible;
	}
	/**
	 * @return the anticipoUtilizado
	 */
	public double getAnticipoUtilizado() {
		return anticipoUtilizado;
	}
	/**
	 * @param anticipoUtilizado the anticipoUtilizado to set
	 */
	public void setAnticipoUtilizado(double anticipoUtilizado) {
		this.anticipoUtilizado = anticipoUtilizado;
	}
	/**
	 * @return the cAT
	 */
	public String getCAT() {
		return CAT;
	}
	/**
	 * @param cAT the cAT to set
	 */
	public void setCAT(String cAT) {
		CAT = cAT;
	}
	/**
	 * @return the seguro
	 */
	public String getSeguro() {
		return seguro;
	}
	/**
	 * @param seguro the seguro to set
	 */
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}
	/**
	 * @return the tasa
	 */
	public String getTasa() {
		return tasa;
	}
	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}
	/**
	 * @return the moratoria
	 */
	public String getMoratoria() {
		return moratoria;
	}
	/**
	 * @param moratoria the moratoria to set
	 */
	public void setMoratoria(String moratoria) {
		this.moratoria = moratoria;
	}
	/**
	 * @return the plazo
	 */
	public String getPlazo() {
		return plazo;
	}
	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
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
	 * @return the totalDescuentos
	 */
	public String getTotalDescuentos() {
		return totalDescuentos;
	}
	/**
	 * @param totalDescuentos the totalDescuentos to set
	 */
	public void setTotalDescuentos(String totalDescuentos) {
		this.totalDescuentos = totalDescuentos;
	}
	/**
	 * @return the totalCreditos
	 */
	public String getTotalCreditos() {
		return totalCreditos;
	}
	/**
	 * @param totalCreditos the totalCreditos to set
	 */
	public void setTotalCreditos(String totalCreditos) {
		this.totalCreditos = totalCreditos;
	}
	/**
	 * @return the importeDescuento
	 */
	public double getImporteDescuento() {
		return importeDescuento;
	}
	/**
	 * @param importeDescuento the importeDescuento to set
	 */
	public void setImporteDescuento(double importeDescuento) {
		this.importeDescuento = importeDescuento;
	}
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
	
}
