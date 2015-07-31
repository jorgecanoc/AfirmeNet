package com.afirme.afirmenet.service.acceso;

import java.util.List;

public interface OTPAgenteService {
	
	/**
	 * M�todo que verifica el c�digo generado por el Token  y su relaci�n con el contrato
	 * para verificar su estado.
	 * @param userID
	 * @param codigoToken
	 * @return Lista con 3 items: [0] Estado TRUE o FALSE, 
	 * [1] StackTrace si se gener� algun Exception.
	 * [2] Descripci�n del error.
	 */
	public List verificaPasscode(String userID, String codigoToken);
}
