package com.afirme.afirmenet.web.model;

import org.springframework.util.StringUtils;

public class Login {
	private String contrato;
	private String password;
	private String serialToken;
	private String codigoToken;
	private String codigoToken2;
	private String codigoActivacion;
	private boolean noMostrarAvisoSeg;
	private String alias;	
	private String aliasSinToken="";
	private String estatusSinToken="";
	private String clienteSinToken="";
	private String patrimonial="";
	
	private boolean bPaqueteSinToken;
	private boolean sPaqueteSinToken;
	

	private boolean paqSinToken;

	/**
	 * @return the contrato
	 */
	public String getContratoMask() {
		if (!StringUtils.isEmpty(this.contrato)) {
			return "&bull;&bull;&bull;&bull;&bull;&bull;"
					+ this.contrato.substring(this.contrato.length() - 4,
							this.contrato.length());
		}
		return "&bull;&bull;&bull;&bull;&bull;&bull;&bull;&bull;&bull;&bull;&bull;&bull;";
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the noMostrarAvisoSeg
	 */
	public boolean isNoMostrarAvisoSeg() {
		return noMostrarAvisoSeg;
	}

	/**
	 * @param noMostrarAvisoSeg
	 *            the noMostrarAvisoSeg to set
	 */
	public void setNoMostrarAvisoSeg(boolean noMostrarAvisoSeg) {
		this.noMostrarAvisoSeg = noMostrarAvisoSeg;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the serialToken
	 */
	public String getSerialToken() {
		return serialToken;
	}

	/**
	 * @param serialToken the serialToken to set
	 */
	public void setSerialToken(String serialToken) {
		this.serialToken = serialToken;
	}

	/**
	 * @return the codigoToken
	 */
	public String getCodigoToken() {
		return codigoToken;
	}

	/**
	 * @param codigoToken the codigoToken to set
	 */
	public void setCodigoToken(String codigoToken) {
		this.codigoToken = codigoToken;
	}


	/**
	 * @return the codigoToken2
	 */
	public String getCodigoToken2() {
		return codigoToken2;
	}

	/**
	 * @param codigoToken2 the codigoToken2 to set
	 */
	public void setCodigoToken2(String codigoToken2) {
		this.codigoToken2 = codigoToken2;
	}

	/**
	 * @return the paqSinToken
	 */
	public boolean isPaqSinToken() {
		return paqSinToken;
	}

	/**
	 * @param paqSinToken the paqSinToken to set
	 */
	public void setPaqSinToken(boolean paqSinToken) {
		this.paqSinToken = paqSinToken;
	}

	/**
	 * @return el aliasSinToken
	 */
	public String getAliasSinToken() {
		return aliasSinToken;
	}

	/**
	 * @param aliasSinToken el aliasSinToken a establecer
	 */
	public void setAliasSinToken(String aliasSinToken) {
		this.aliasSinToken = aliasSinToken;
	}

	/**
	 * @return el estatusSinToken
	 */
	public String getEstatusSinToken() {
		return estatusSinToken;
	}

	/**
	 * @param estatusSinToken el estatusSinToken a establecer
	 */
	public void setEstatusSinToken(String estatusSinToken) {
		this.estatusSinToken = estatusSinToken;
	}

	/**
	 * @return el clienteSinToken
	 */
	public String getClienteSinToken() {
		return clienteSinToken;
	}

	/**
	 * @param clienteSinToken el clienteSinToken a establecer
	 */
	public void setClienteSinToken(String clienteSinToken) {
		this.clienteSinToken = clienteSinToken;
	}

	/**
	 * @return el patrimonial
	 */
	public String getPatrimonial() {
		return patrimonial;
	}

	/**
	 * @param patrimonial el patrimonial a establecer
	 */
	public void setPatrimonial(String patrimonial) {
		this.patrimonial = patrimonial;
	}

	/**
	 * @return el bPaqueteSinToken
	 */
	public boolean isbPaqueteSinToken() {
		return bPaqueteSinToken;
	}

	/**
	 * @param bPaqueteSinToken el bPaqueteSinToken a establecer
	 */
	public void setbPaqueteSinToken(boolean bPaqueteSinToken) {
		this.bPaqueteSinToken = bPaqueteSinToken;
	}

	/**
	 * @return el sPaqueteSinToken
	 */
	public boolean issPaqueteSinToken() {
		return sPaqueteSinToken;
	}

	/**
	 * @param sPaqueteSinToken el sPaqueteSinToken a establecer
	 */
	public void setsPaqueteSinToken(boolean sPaqueteSinToken) {
		this.sPaqueteSinToken = sPaqueteSinToken;
	}


	/**
	 * @return the codigoActivacion
	 */
	public String getCodigoActivacion() {
		return codigoActivacion;
	}

	/**
	 * @param codigoActivacion the codigoActivacion to set
	 */
	public void setCodigoActivacion(String codigoActivacion) {
		this.codigoActivacion = codigoActivacion;
	}

}
