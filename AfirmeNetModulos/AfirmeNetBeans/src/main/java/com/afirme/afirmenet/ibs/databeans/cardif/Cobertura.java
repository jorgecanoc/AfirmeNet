package com.afirme.afirmenet.ibs.databeans.cardif;

import java.math.BigDecimal;

import com.afirme.afirmenet.enums.CoberturaCardif;

public class Cobertura {
	CoberturaCardif tipo;
	String nombre;
	BigDecimal costoMensual;
	BigDecimal tarjetas;
	BigDecimal cheques;
	BigDecimal internet;
	BigDecimal cajeros;
	BigDecimal compra;
	
	/**
	 * @return el tipo
	 */
	public CoberturaCardif getTipo() {
		return tipo;
	}
	/**
	 * @param tipo el tipo a establecer
	 */
	public void setTipo(CoberturaCardif tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return el costoMensual
	 */
	public BigDecimal getCostoMensual() {
		return costoMensual;
	}
	/**
	 * @param costoMensual el costoMensual a establecer
	 */
	public void setCostoMensual(BigDecimal costoMensual) {
		this.costoMensual = costoMensual;
	}
	/**
	 * @return el tarjetas
	 */
	public BigDecimal getTarjetas() {
		return tarjetas;
	}
	/**
	 * @param tarjetas el tarjetas a establecer
	 */
	public void setTarjetas(BigDecimal tarjetas) {
		this.tarjetas = tarjetas;
	}
	/**
	 * @return el cheques
	 */
	public BigDecimal getCheques() {
		return cheques;
	}
	/**
	 * @param cheques el cheques a establecer
	 */
	public void setCheques(BigDecimal cheques) {
		this.cheques = cheques;
	}
	/**
	 * @return el internet
	 */
	public BigDecimal getInternet() {
		return internet;
	}
	/**
	 * @param internet el internet a establecer
	 */
	public void setInternet(BigDecimal internet) {
		this.internet = internet;
	}
	/**
	 * @return el cajeros
	 */
	public BigDecimal getCajeros() {
		return cajeros;
	}
	/**
	 * @param cajeros el cajeros a establecer
	 */
	public void setCajeros(BigDecimal cajeros) {
		this.cajeros = cajeros;
	}
	/**
	 * @return el compra
	 */
	public BigDecimal getCompra() {
		return compra;
	}
	/**
	 * @param compra el compra a establecer
	 */
	public void setCompra(BigDecimal compra) {
		this.compra = compra;
	}
	
}
