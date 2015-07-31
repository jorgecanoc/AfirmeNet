package com.afirme.afirmenet.exception;

/**
 * Excepcion custom que permite identificar los errores ocacionados al realizar
 * una conexion via Socket por la clase {@link SocketFactory}
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class SocketFactoryException extends Exception {

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
	public SocketFactoryException(String errMsg, String errCode) {
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
