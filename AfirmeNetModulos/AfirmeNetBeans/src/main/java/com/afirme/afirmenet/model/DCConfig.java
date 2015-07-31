/**
 * 
 */
package com.afirme.afirmenet.model;

import com.afirme.afirmenet.model.base.ModelBase;

/**
 * Clase de transporte que mapea la informacion de la tabla DC_CONFIG en la BD
 * de DB2
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class DCConfig implements ModelBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Aplicacion {
		AFIRMENET_PERSONAS, AFIRMENET_EMPRESAS, AMBAS;

	}

	private String grupo;
	private String propiedad;
	private String valor;
	private String descripcion;
	private Aplicacion aplicaccion;

	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the propiedad
	 */
	public String getPropiedad() {
		return propiedad;
	}

	/**
	 * @param propiedad
	 *            the propiedad to set
	 */
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the aplicaccion
	 */
	public Aplicacion getAplicaccion() {
		return aplicaccion;
	}

	/**
	 * @param aplicaccion
	 *            the aplicaccion to set
	 */
	public void setAplicaccion(Aplicacion aplicaccion) {
		this.aplicaccion = aplicaccion;
	}

}
