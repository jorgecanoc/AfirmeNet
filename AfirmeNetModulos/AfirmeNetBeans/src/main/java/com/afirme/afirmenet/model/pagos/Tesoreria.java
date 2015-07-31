package com.afirme.afirmenet.model.pagos;

public class Tesoreria {

	private int grupo;
	private int clave;
	private String subClave;
	private String concepto;
	
	/**
	 * @return the grupo
	 */
	public int getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	/**
	 * @return the clave
	 */
	public int getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(int clave) {
		this.clave = clave;
	}
	/**
	 * @return the subclave
	 */
	public String getSubClave() {
		return subClave;
	}
	/**
	 * @param subclave the subclave to set
	 */
	public void setSubClave(String subclave) {
		this.subClave = subclave;
	}
	/**
	 * @return the concepto
	 */
	public String getConcepto() {
		return concepto;
	}
	/**
	 * @param concepto the concepto to set
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
}
