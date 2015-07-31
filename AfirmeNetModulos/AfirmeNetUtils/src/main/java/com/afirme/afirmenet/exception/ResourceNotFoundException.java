package com.afirme.afirmenet.exception;

/**
 * 
 * Excepcion Custom generada para la identificacion de el error 404, esta
 * excepcion previene el codigo de estado de HTTP para que no se enviada a la
 * capa suoperior y se pueda realizar alguna accion o un manejo mas agradable
 * del error
 * 
 * @author jorge.canoc@gmail.com
 * @tag Start date: (23/03/15 11:03:39 AM)
 * 
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta variable esta definida para indicar el nombre del recurso que
	 * intento ser accedido via URL
	 * 
	 */
	private String resourceNotFound;

	/**
	 * Contructor que permite identificar el recurso que no fue encontrado
	 * 
	 * @param resource
	 */
	public ResourceNotFoundException(String resource) {
		this.resourceNotFound = resource;
	}

	/**
	 * @return the resourceNotFound
	 */
	public String getResourceNotFound() {
		return resourceNotFound;
	}

	/**
	 * @param resourceNotFound
	 *            the resourceNotFound to set
	 */
	public void setResourceNotFound(String resourceNotFound) {
		this.resourceNotFound = resourceNotFound;
	}

}
