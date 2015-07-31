package com.afirme.afirmenet.exception;

/**
 * Excepcion custom que permite identificar los errores ocacionados al abrir el
 * socket y generar el contexto de comunicacion via
 * {@link MessageContextFactory}
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class MessageContextFactoryException extends AfirmeNetBaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contructor que permite indicar el error y mensaje de la excepcion
	 * generada
	 * 
	 * @param errCode
	 * @param errMsg
	 */
	public MessageContextFactoryException(String errCode, String errMsg) {
		super(errCode, errMsg);

	}

}
