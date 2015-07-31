package com.afirme.afirmenet.exception;

/**
 * Excepcion Generica para identificar las excepciones controladas en la capa
 * del contralador
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class AfirmeNetException extends AfirmeNetBaseException {
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
	public AfirmeNetException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

}
