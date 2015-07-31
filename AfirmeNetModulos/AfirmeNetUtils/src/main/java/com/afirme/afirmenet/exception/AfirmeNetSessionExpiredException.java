package com.afirme.afirmenet.exception;

/**
 * Excepcion Generica para identificar las excepciones ocacionadas por la
 * expiracion de la session en afirmenet
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class AfirmeNetSessionExpiredException extends AfirmeNetBaseException {
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
	public AfirmeNetSessionExpiredException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

}