package com.afirme.afirmenet.web.model;

import java.util.Date;

import com.afirme.afirmenet.model.DCMessageIni;
import com.afirme.afirmenet.utils.time.TimeUtils;

public class AfirmeNetUser {
	private int notificaciones;
	private String nombreLargo;
	private String nombreCompleto;
	private String nombreCorto;
	private String contrato;
	private String numCliente;
	private Date ultimoAcceso;
	private String cuentasExcluyentes;
	private DCMessageIni campania;
	private String correoElectronico;
	private String paqueteAfirmeNet;
	private boolean basicoSinToken;

	/**
	 * @return the notificaciones
	 */
	public int getNotificaciones() {
		return notificaciones;
	}

	/**
	 * @param notificaciones
	 *            the notificaciones to set
	 */
	public void setNotificaciones(int notificaciones) {
		this.notificaciones = notificaciones;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto
	 *            the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the nombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}

	/**
	 * @param nombreCorto
	 *            the nombreCorto to set
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato
	 *            the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the ultimoAcceso
	 */
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public String getUltimoAccesoStr() {
		return TimeUtils.customnCompleteDateFormat.format(ultimoAcceso);
	}

	/**
	 * @param ultimoAcceso
	 *            the ultimoAcceso to set
	 */
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	/**
	 * @return the nombreLargo
	 */
	public String getNombreLargo() {
		return nombreLargo;
	}

	/**
	 * @param nombreLargo
	 *            the nombreLargo to set
	 */
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	/**
	 * @return the campania
	 */
	public DCMessageIni getCampania() {
		return campania;
	}

	/**
	 * @param campania the campania to set
	 */
	public void setCampania(DCMessageIni campania) {
		this.campania = campania;
	}
	/**
	 * @return el cuentasExcluyentes
	 */
	public String getCuentasExcluyentes() {
		if(cuentasExcluyentes==null)
			return "";
		return cuentasExcluyentes;
	}

	/**
	 * @param cuentasExcluyentes el cuentasExcluyentes a establecer
	 */
	public void setCuentasExcluyentes(String cuentasExcluyentes) {
		this.cuentasExcluyentes = cuentasExcluyentes;
	}

	/**
	 * @return el correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico el correoElectronico a establecer
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return el numCliente
	 */
	public String getNumCliente() {
		return numCliente;
	}

	/**
	 * @param numCliente el numCliente a establecer
	 */
	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	/**
	 * @return el paqueteAfirmeNet
	 */
	public String getPaqueteAfirmeNet() {
		return paqueteAfirmeNet;
	}

	/**
	 * @param paqueteAfirmeNet el paqueteAfirmeNet a establecer
	 */
	public void setPaqueteAfirmeNet(String paqueteAfirmeNet) {
		this.paqueteAfirmeNet = paqueteAfirmeNet;
	}

	/**
	 * @return el basicoSinToken
	 */
	public boolean isBasicoSinToken() {
		return basicoSinToken;
	}

	/**
	 * @param basicoSinToken el basicoSinToken a establecer
	 */
	public void setBasicoSinToken(boolean basicoSinToken) {
		this.basicoSinToken = basicoSinToken;
	}

	
	
}
