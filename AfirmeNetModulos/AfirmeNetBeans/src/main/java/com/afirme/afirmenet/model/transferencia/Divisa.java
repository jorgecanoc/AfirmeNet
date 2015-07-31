/**
 * 
 */
package com.afirme.afirmenet.model.transferencia;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author 0cdcarguz
 * 
 */
public class Divisa extends TransferenciaBase {

	private String codigoSWIFT;
	private String codigoABA;
	private BigDecimal divisaCompra;
	private BigDecimal divisaVenta;
	private String tipoMoneda; // Especifica la moneda de la divisa (USD, EUR, MXP, etc)
	private String descMoneda; // Descripcion de la moneda (Dolares, Euros, etc)
	private BigDecimal tipoCambio;
	private BigDecimal montoUSD;
	private BigDecimal montoConversion;
	private String tipoCodigo; // Determina si el codigo es SWIFT(S) o ABA(F)
	private String claveTransferencia; // Clave para Transferencias Multimoneda
	private String bankCiudad;
	private String bankEstado;
	private String bankPais;
	private String bankArea;
	private String bankDireccion;
	private String intermediarioCuenta;
	private String intermediarioCodigo; // Codigo SWIFT o ABA para Intermediario
	private String intermediarioTipoCodigo; // Tipo de Codigo S(Swift) o F(ABA)
	private String intermediarioNombre;
	private String intermediarioPlaza;
	private BigDecimal commisionConversion;
	private BigDecimal taxCommisionConversion;
	
	private static final String NUMBER_FORMAT = "###,###,###.00";
	
	public String getAmountFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(super.getAmount().doubleValue());
	}
	public String getCommissionFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(super.getCommision().doubleValue());
	}
	public String getDivisaVentaFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(divisaVenta.doubleValue());
	}
	public String getMontoUSDFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(montoUSD.doubleValue());
	}
	public String getMontoConversionFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(montoConversion.doubleValue());
	}
	public String getTipoCambioFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(tipoCambio.doubleValue());
	}
	public String getConversionFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format((this.getAmount().multiply(this.getDivisaVenta())).doubleValue());
	}
	/**
	 * @return the codigoSWIFT
	 */
	public String getCodigoSWIFT() {
		return codigoSWIFT;
	}
	/**
	 * @param codigoSWIFT the codigoSWIFT to set
	 */
	public void setCodigoSWIFT(String codigoSWIFT) {
		this.codigoSWIFT = codigoSWIFT;
	}
	/**
	 * @return the codigoABA
	 */
	public String getCodigoABA() {
		return codigoABA;
	}
	/**
	 * @param codigoABA the codigoABA to set
	 */
	public void setCodigoABA(String codigoABA) {
		this.codigoABA = codigoABA;
	}
	/**
	 * @return the divisaCompra
	 */
	public BigDecimal getDivisaCompra() {
		return divisaCompra;
	}
	/**
	 * @param divisaCompra the divisaCompra to set
	 */
	public void setDivisaCompra(BigDecimal divisaCompra) {
		this.divisaCompra = divisaCompra;
	}
	/**
	 * @return the divisaVenta
	 */
	public BigDecimal getDivisaVenta() {
		return divisaVenta;
	}
	/**
	 * @param divisaVenta the divisaVenta to set
	 */
	public void setDivisaVenta(BigDecimal divisaVenta) {
		this.divisaVenta = divisaVenta;
	}
	/**
	 * @return the descMoneda
	 */
	public String getDescMoneda() {
		return descMoneda;
	}
	/**
	 * @param descMoneda the descMoneda to set
	 */
	public void setDescMoneda(String descMoneda) {
		this.descMoneda = descMoneda;
	}
	/**
	 * @return the montoConversion
	 */
	public BigDecimal getMontoConversion() {
		return montoConversion;
	}
	/**
	 * @param montoConversion the montoConversion to set
	 */
	public void setMontoConversion(BigDecimal montoConversion) {
		this.montoConversion = montoConversion;
	}
	/**
	 * @return the bankCiudad
	 */
	public String getBankCiudad() {
		return bankCiudad;
	}

	/**
	 * @param bankCiudad the bankCiudad to set
	 */
	public void setBankCiudad(String bankCiudad) {
		this.bankCiudad = bankCiudad;
	}

	/**
	 * @return the bankEstado
	 */
	public String getBankEstado() {
		return bankEstado;
	}

	/**
	 * @param bankEstado the bankEstado to set
	 */
	public void setBankEstado(String bankEstado) {
		this.bankEstado = bankEstado;
	}

	/**
	 * @return the bankPais
	 */
	public String getBankPais() {
		return bankPais;
	}

	/**
	 * @param bankPais the bankPais to set
	 */
	public void setBankPais(String bankPais) {
		this.bankPais = bankPais;
	}

	/**
	 * @return the bankArea
	 */
	public String getBankArea() {
		return bankArea;
	}

	/**
	 * @param bankArea the bankArea to set
	 */
	public void setBankArea(String bankArea) {
		this.bankArea = bankArea;
	}

	/**
	 * @return the bankDireccion
	 */
	public String getBankDireccion() {
		return bankDireccion;
	}

	/**
	 * @param bankDireccion the bankDireccion to set
	 */
	public void setBankDireccion(String bankDireccion) {
		this.bankDireccion = bankDireccion;
	}

	/**
	 * @return the tipoCambio
	 */
	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	/**
	 * @param tipoCambio the tipoCambio to set
	 */
	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	/**
	 * @return the montoUSD
	 */
	public BigDecimal getMontoUSD() {
		return montoUSD;
	}

	/**
	 * @param montoUSD the montoUSD to set
	 */
	public void setMontoUSD(BigDecimal montoUSD) {
		this.montoUSD = montoUSD;
	}
	/**
	 * @return the tipoMoneda
	 */
	public String getTipoMoneda() {
		return tipoMoneda;
	}
	/**
	 * @param tipoMoneda the tipoMoneda to set
	 */
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	/**
	 * @return the intermediarioCuenta
	 */
	public String getIntermediarioCuenta() {
		return intermediarioCuenta;
	}
	/**
	 * @param intermediarioCuenta the intermediarioCuenta to set
	 */
	public void setIntermediarioCuenta(String intermediarioCuenta) {
		this.intermediarioCuenta = intermediarioCuenta;
	}
	/**
	 * @return the intermediarioCodigo
	 */
	public String getIntermediarioCodigo() {
		return intermediarioCodigo;
	}
	/**
	 * @param intermediarioCodigo the intermediarioCodigo to set
	 */
	public void setIntermediarioCodigo(String intermediarioCodigo) {
		this.intermediarioCodigo = intermediarioCodigo;
	}
	/**
	 * @return the intermediarioNombre
	 */
	public String getIntermediarioNombre() {
		return intermediarioNombre;
	}
	/**
	 * @param intermediarioNombre the intermediarioNombre to set
	 */
	public void setIntermediarioNombre(String intermediarioNombre) {
		this.intermediarioNombre = intermediarioNombre;
	}
	/**
	 * @return the intermediarioPlaza
	 */
	public String getIntermediarioPlaza() {
		return intermediarioPlaza;
	}
	/**
	 * @param intermediarioPlaza the intermediarioPlaza to set
	 */
	public void setIntermediarioPlaza(String intermediarioPlaza) {
		this.intermediarioPlaza = intermediarioPlaza;
	}
	/**
	 * @return the tipoCodigo
	 */
	public String getTipoCodigo() {
		return tipoCodigo;
	}
	/**
	 * @param tipoCodigo the tipoCodigo to set
	 */
	public void setTipoCodigo(String tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}
	/**
	 * @return the claveTransferencia
	 */
	public String getClaveTransferencia() {
		return claveTransferencia;
	}
	/**
	 * @param claveTransferencia the claveTransferencia to set
	 */
	public void setClaveTransferencia(String claveTransferencia) {
		this.claveTransferencia = claveTransferencia;
	}
	/**
	 * @return the commisionConversion
	 */
	public BigDecimal getCommisionConversion() {
		return commisionConversion;
	}
	/**
	 * @param commisionConversion the commisionConversion to set
	 */
	public void setCommisionConversion(BigDecimal commisionConversion) {
		this.commisionConversion = commisionConversion;
	}
	/**
	 * @return the taxCommisionConversion
	 */
	public BigDecimal getTaxCommisionConversion() {
		return taxCommisionConversion;
	}
	/**
	 * @param taxCommisionConversion the taxCommisionConversion to set
	 */
	public void setTaxCommisionConversion(BigDecimal taxCommisionConversion) {
		this.taxCommisionConversion = taxCommisionConversion;
	}
	/**
	 * @return the intermediarioTipoCodigo
	 */
	public String getIntermediarioTipoCodigo() {
		return intermediarioTipoCodigo;
	}
	/**
	 * @param intermediarioTipoCodigo the intermediarioTipoCodigo to set
	 */
	public void setIntermediarioTipoCodigo(String intermediarioTipoCodigo) {
		this.intermediarioTipoCodigo = intermediarioTipoCodigo;
	}
}
