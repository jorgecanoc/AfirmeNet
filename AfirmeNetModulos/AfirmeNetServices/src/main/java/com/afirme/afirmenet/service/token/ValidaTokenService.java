package com.afirme.afirmenet.service.token;


public interface ValidaTokenService {
	
	/**
	 * Metodo que evalua la clave dinamica o password segun el tipo de contrato
	 * 
	 * @param passCode
	 * @param contrato
	 * @param usuario
	 * @param basicoSinToken
	 */
	public boolean validaClave(String passCode, String contrato, 
			String usuario, boolean basicoSinToken);

}
