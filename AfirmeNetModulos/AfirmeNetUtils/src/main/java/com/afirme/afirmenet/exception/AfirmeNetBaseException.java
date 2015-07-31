package com.afirme.afirmenet.exception;

/**
 * Clase abtracta que define los atributos minimos para la creacion de excepcion
 * custom
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public abstract class AfirmeNetBaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMsg;

	/**
	 * Contructor que permite indicar el error y mensaje de la excepcion
	 * generada
	 * 
	 * @param errCode
	 * @param errMsg
	 */
	public AfirmeNetBaseException(String errCode, String errMsg) {
		super(errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	/**
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode
	 *            the errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg
	 *            the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
