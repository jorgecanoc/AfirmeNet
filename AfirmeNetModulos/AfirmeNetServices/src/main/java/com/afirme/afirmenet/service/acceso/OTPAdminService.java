package com.afirme.afirmenet.service.acceso;

import java.util.List;

public interface OTPAdminService {
	public List<Object> creaUsuario(String nombre, String apellido, String userID);
	public List<Object> eliminaUsuario(String userID);
	public List<Object> asignaTokenUsuario(String serial, String userID);
	public List<Object> desasignaTokenUsuario(String serial);
	public List<Object> habilitaToken(String serial);
	public List<Object> deshabilitaToken(String serial);
	
	/**
	 * M�todo que realiza la sincronizaci�n de Tokens.
	 * @param N�mero de Serie del dispositivo Token
	 * @param 1er c�digo generado por el Token
	 * @param 2o c�digo generado por el Token
	 * @return Lista de 
	 * 
	 */
	public List<Object> sincronizaToken(String serial, String codigoToken1, String codigoToken2);
	
	/**
	 * M�todo que obtiene informaci�n del Token mediante
	 * la especificaci�n del N�mero de Serie.
	 * @param N�mero de Serie del dispositivo Token
	 * @return Lista que contiene la informaci�n del Token.
	 */
	public List<Object> getInformacionToken(String serial);
	public List<Object> getEstadoToken(String serial);
}
