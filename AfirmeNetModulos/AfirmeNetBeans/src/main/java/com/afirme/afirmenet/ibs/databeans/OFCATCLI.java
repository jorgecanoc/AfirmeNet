/*
 * Creado el 3/03/2006
 * Modificado por:	Christian Antonio Gómez Flores
 * Empresa:			Consiss
 * Fecha:			19-Junio-2007
 */
package com.afirme.afirmenet.ibs.databeans;

/**
 * @author Omar
 * 
 *         Para cambiar la plantilla para este comentario de tipo generado vaya
 *         a Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y
 *         comentarios
 * 
 * 
 *         This class represents a Valores contract and is an implementation of
 *         the transfer object pattern for data transference among the model,
 *         view and controller of the Valores related program options.
 * 
 */
public class OFCATCLI {

	// Number of the contract represented by the object
	private String CVEC;

	// Name of the owner of the contract
	private String clientName;

	// Name of the sciety
	private String EMISORA;

	// Titles
	private String TITULOS;

	// Serie
	private String SERIE;

	// Precio
	private String PRECIO;

	// Total
	private String TOTAL;
	private String monto = "";
	private String remanente = "";

	private String saldoCobrar = "";
	private String saldoPagar = "";
	private String saldoPagarNoConsiderar = "";
	private String saldoCobrarNoConsiderar = "";

	private int CNNCLI;
	private String CUSNA;

	/**
	 * @return
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @return
	 */
	public String getCVEC() {
		return CVEC;
	}

	/**
	 * @param string
	 */
	public void setClientName(String string) {
		clientName = string;
	}

	/**
	 * @param string
	 */
	public void setCVEC(String string) {
		CVEC = string;
	}

	/**
	 * @return
	 */
	public String getEMISORA() {
		return EMISORA;
	}

	/**
	 * @return
	 */
	public String getPRECIO() {
		return PRECIO;
	}

	/**
	 * @return
	 */
	public String getSERIE() {
		return SERIE;
	}

	/**
	 * @return
	 */
	public String getTITULOS() {
		return TITULOS;
	}

	/**
	 * @return
	 */
	public String getTOTAL() {
		return TOTAL;
	}

	/**
	 * @param string
	 */
	public void setEMISORA(String string) {
		EMISORA = string;
	}

	/**
	 * @param string
	 */
	public void setPRECIO(String string) {
		PRECIO = string;
	}

	/**
	 * @param string
	 */
	public void setSERIE(String string) {
		SERIE = string;
	}

	/**
	 * @param string
	 */
	public void setTITULOS(String string) {
		TITULOS = string;
	}

	/**
	 * @param string
	 */
	public void setTOTAL(String string) {
		TOTAL = string;
	}

	// The equals method is overriden: two objects represent the same contract
	// (are meaningly equivalent) if
	// both have de same value for the contractNumber property.
	public boolean equals(Object obj) {

		if (obj != null && obj instanceof OFCATCLI
				&& ((OFCATCLI) obj).getCVEC().equals(this.getCVEC())) {

			return true;
		} else {

			return false;
		}

	}

	/**
	 * @return
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * @return
	 */
	public String getRemanente() {
		return remanente;
	}

	/**
	 * @param string
	 */
	public void setMonto(String string) {
		monto = string;
	}

	/**
	 * @param string
	 */
	public void setRemanente(String string) {
		remanente = string;
	}

	/**
	 * @return
	 */
	public int getCNNCLI() {
		return CNNCLI;
	}

	/**
	 * @return
	 */
	public String getCUSNA() {
		return CUSNA;
	}

	/**
	 * @param i
	 */
	public void setCNNCLI(int i) {
		CNNCLI = i;
	}

	/**
	 * @param string
	 */
	public void setCUSNA(String string) {
		CUSNA = string;
	}

	public String getSaldoCobrar() {
		return saldoCobrar;
	}

	public void setSaldoCobrar(String saldoCobrar) {
		this.saldoCobrar = saldoCobrar;
	}

	public String getSaldoPagar() {
		return saldoPagar;
	}

	public void setSaldoPagar(String saldoPagar) {
		this.saldoPagar = saldoPagar;
	}

	public String getSaldoPagarNoConsiderar() {
		return saldoPagarNoConsiderar;
	}

	public void setSaldoPagarNoConsiderar(String saldoPagarNoConsiderar) {
		this.saldoPagarNoConsiderar = saldoPagarNoConsiderar;
	}

	public String getSaldoCobrarNoConsiderar() {
		return saldoCobrarNoConsiderar;
	}

	public void setSaldoCobrarNoConsiderar(String saldoCobrarNoConsiderar) {
		this.saldoCobrarNoConsiderar = saldoCobrarNoConsiderar;
	}

}
