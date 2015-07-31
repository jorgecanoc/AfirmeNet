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
	 * Método que realiza la sincronización de Tokens.
	 * @param Número de Serie del dispositivo Token
	 * @param 1er código generado por el Token
	 * @param 2o código generado por el Token
	 * @return Lista de 
	 * 
	 */
	public List<Object> sincronizaToken(String serial, String codigoToken1, String codigoToken2);
	
	/**
	 * Método que obtiene información del Token mediante
	 * la especificación del Número de Serie.
	 * @param Número de Serie del dispositivo Token
	 * @return Lista que contiene la información del Token.
	 */
	public List<Object> getInformacionToken(String serial);
	public List<Object> getEstadoToken(String serial);
}
