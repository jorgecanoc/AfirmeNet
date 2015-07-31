/**
 * 
 */
package com.afirme.afirmenet.model.pagos.servicios;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import com.afirme.afirmenet.ibs.beans.tarjetas.DatosTDC;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

/**
 * @author 0jacancue
 * 
 */
public class Servicio extends TransferenciaBase {

	private DecimalFormat dec = new DecimalFormat("#,###.00");

	private Integer idServicio;
	private Integer idComercio;
	private String nombre;
	private String numeroServicio;
	private String propietario;
	private String ayuda;
	private String imagen;
	private String inicioProgramacion;
	private String fechaVencimiento;
	private String horaProgramacion;
	private Integer idServicio400;
	private String montoStr;

	// Campos para validacion de servicios
	private int anioVencimiento = 0;
	private int mesVencimiento = 0;
	private int diaVencimiento = 0;

	// Campo para la validacion de cuentas referenciadas
	private String cuentaReferenciada;
	private BigDecimal recargos = BigDecimal.ZERO;

	// Campo para numero telefonico en pago de telmex
	private String lada;
	private String numeroTelefonico;

	// Bean para los datos de pago TDC
	private DatosTDC datosTDC;

	// Bean para los datos de pago TDC TERCEROS, OTROS BANCOS, AMERICAN Y
	// SEGUROS
	private DC_CONVENIO convenio;

	/**
	 * @return the idServicio
	 */
	public Integer getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio
	 *            the idServicio to set
	 */
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the idComercio
	 */
	public Integer getIdComercio() {
		return idComercio;
	}

	/**
	 * @param idComercio
	 *            the idComercio to set
	 */
	public void setIdComercio(Integer idComercio) {
		this.idComercio = idComercio;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numeroServicio
	 */
	public String getNumeroServicio() {
		return numeroServicio;
	}

	/**
	 * @param numeroServicio
	 *            the numeroServicio to set
	 */
	public void setNumeroServicio(String numeroServicio) {
		this.numeroServicio = numeroServicio;
	}

	/**
	 * @return the propietario
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario
	 *            the propietario to set
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	/**
	 * @return the ayuda
	 */
	public String getAyuda() {
		return ayuda;
	}

	/**
	 * @param ayuda
	 *            the ayuda to set
	 */
	public void setAyuda(String ayuda) {
		this.ayuda = ayuda;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the inicioProgramacion
	 */
	public String getInicioProgramacion() {
		return inicioProgramacion;
	}

	/**
	 * @param inicioProgramacion
	 *            the inicioProgramacion to set
	 */
	public void setInicioProgramacion(String inicioProgramacion) {
		this.inicioProgramacion = inicioProgramacion;
	}

	/**
	 * @return the horaProgramacion
	 */
	public String getHoraProgramacion() {
		return horaProgramacion;
	}

	/**
	 * @param horaProgramacion
	 *            the horaProgramacion to set
	 */
	public void setHoraProgramacion(String horaProgramacion) {
		this.horaProgramacion = horaProgramacion;
	}

	/**
	 * @return the anioVencimiento
	 */
	public int getAnioVencimiento() {
		return anioVencimiento;
	}

	/**
	 * @param anioVencimiento
	 *            the anioVencimiento to set
	 */
	public void setAnioVencimiento(int anioVencimiento) {
		this.anioVencimiento = anioVencimiento;
	}

	/**
	 * @return the mesVencimiento
	 */
	public int getMesVencimiento() {
		return mesVencimiento;
	}

	/**
	 * @param mesVencimiento
	 *            the mesVencimiento to set
	 */
	public void setMesVencimiento(int mesVencimiento) {
		this.mesVencimiento = mesVencimiento;
	}

	/**
	 * @return the diaVencimiento
	 */
	public int getDiaVencimiento() {
		return diaVencimiento;
	}

	/**
	 * @param diaVencimiento
	 *            the diaVencimiento to set
	 */
	public void setDiaVencimiento(int diaVencimiento) {
		this.diaVencimiento = diaVencimiento;
	}

	/**
	 * @return the cuentaReferenciada
	 */
	public String getCuentaReferenciada() {
		return cuentaReferenciada;
	}

	/**
	 * @param cuentaReferenciada
	 *            the cuentaReferenciada to set
	 */
	public void setCuentaReferenciada(String cuentaReferenciada) {
		this.cuentaReferenciada = cuentaReferenciada;
	}

	/**
	 * @return the recargos
	 */
	public BigDecimal getRecargos() {
		return recargos;
	}

	/**
	 * @param recargos
	 *            the recargos to set
	 */
	public void setRecargos(BigDecimal recargos) {
		this.recargos = recargos;
	}

	/**
	 * @return the lada
	 */
	public String getLada() {
		return lada;
	}

	/**
	 * @param lada
	 *            the lada to set
	 */
	public void setLada(String lada) {
		this.lada = lada;
	}

	/**
	 * @return the numeroTelefonico
	 */
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	/**
	 * @param numeroTelefonico
	 *            the numeroTelefonico to set
	 */
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	/**
	 * @return el datosTDC
	 */
	public DatosTDC getDatosTDC() {
		return datosTDC;
	}

	/**
	 * @param datosTDC
	 *            el datosTDC a establecer
	 */
	public void setDatosTDC(DatosTDC datosTDC) {
		this.datosTDC = datosTDC;
	}

	/**
	 * @return el convenios
	 */
	public DC_CONVENIO getConvenio() {
		return convenio;
	}

	/**
	 * @param convenios
	 *            el convenios a establecer
	 */
	public void setConvenio(DC_CONVENIO convenio) {
		this.convenio = convenio;
	}

	/**
	 * @return the idServicio400
	 */
	public Integer getIdServicio400() {
		return idServicio400;
	}

	/**
	 * @param idServicio400
	 *            the idServicio400 to set
	 */
	public void setIdServicio400(Integer idServicio400) {
		this.idServicio400 = idServicio400;
	}

	/**
	 * @return the montoStr
	 */
	public String getMontoStr() {

		return montoStr;
	}

	/**
	 * @param montoStr
	 *            the montoStr to set
	 * @throws ParseException 
	 */
	public void setMontoStr(String montoStr) throws ParseException {
		super.setAmount(BigDecimal.valueOf(dec.parse(montoStr).doubleValue()));
		this.montoStr = montoStr;
	}

	/**
	 * @return the fechaVencimiento
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	
}
