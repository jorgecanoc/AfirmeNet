package com.afirme.afirmenet.ibs.databeans;

import java.io.ByteArrayOutputStream;

public class ATSIGNATUR {

	private String account;
	private String numImag;
	private String dateCap;
	private String cliente;
	private String instruc;
	private ByteArrayOutputStream imagen;

	/**
	 * @return
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @return
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @return
	 */
	public String getDateCap() {
		return dateCap;
	}

	/**
	 * @return
	 */
	public ByteArrayOutputStream getImagen() {
		return imagen;
	}

	/**
	 * @return
	 */
	public String getInstruc() {
		return instruc;
	}

	/**
	 * @return
	 */
	public String getNumImag() {
		return numImag;
	}

	/**
	 * @param string
	 */
	public void setAccount(String string) {
		account = string;
	}

	/**
	 * @param string
	 */
	public void setCliente(String string) {
		cliente = string;
	}

	/**
	 * @param string
	 */
	public void setDateCap(String string) {
		dateCap = string;
	}

	/**
	 * @param stream
	 */
	public void setImagen(ByteArrayOutputStream stream) {
		imagen = stream;
	}

	/**
	 * @param string
	 */
	public void setInstruc(String string) {
		instruc = string;
	}

	/**
	 * @param string
	 */
	public void setNumImag(String string) {
		numImag = string;
	}

}