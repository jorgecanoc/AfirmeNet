package com.afirme.afirmenet.ibs.databeans.nominaMasiva;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pago_Nomina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int id;
	private String nombre;
	private String tipoCuenta;
	private String cuenta;
	private String banco;
	private String idBanco;
	private String noClienteEmpresa;
	private String fechaAplicacion;
	private String tarjeta;

	/**
	 * @return el idBanco
	 */
	public String getIdBanco() {
		return idBanco;
	}

	/**
	 * @param idBanco
	 *            el idBanco a establecer
	 */
	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}

	private BigDecimal monto;
	private boolean nuevo;

	/**
	 * @return el id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            el id a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta
	 *            la cuenta a establecer
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return el banco
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * @param banco
	 *            el banco a establecer
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * @return el monto
	 */
	public BigDecimal getMonto() {
		return monto;
	}

	/**
	 * @param monto
	 *            el monto a establecer
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	/**
	 * @return el nuevo
	 */
	public boolean isNuevo() {
		return nuevo;
	}

	/**
	 * @param nuevo
	 *            el nuevo a establecer
	 */
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

	/**
	 * @return el tipoCuenta
	 */
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	/**
	 * @param tipoCuenta
	 *            el tipoCuenta a establecer
	 */
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	/**
	 * @return el noClienteEmpresa
	 */
	public String getNoClienteEmpresa() {
		return noClienteEmpresa;
	}

	/**
	 * @param noClienteEmpresa
	 *            el noClienteEmpresa a establecer
	 */
	public void setNoClienteEmpresa(String noClienteEmpresa) {
		this.noClienteEmpresa = noClienteEmpresa;
	}

	/**
	 * @return el fechaAplicacion
	 */
	public String getFechaAplicacion() {
		return fechaAplicacion;
	}

	/**
	 * @param fechaAplicacion
	 *            el fechaAplicacion a establecer
	 */
	public void setFechaAplicacion(String fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	/**
	 * @return el tarjeta
	 */
	public String getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta
	 *            el tarjeta a establecer
	 */
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
}
