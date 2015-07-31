package com.afirme.afirmenet.service.acceso;

import java.util.List;

public interface OTPAgenteService {
	
	/**
	 * Método que verifica el código generado por el Token  y su relación con el contrato
	 * para verificar su estado.
	 * @param userID
	 * @param codigoToken
	 * @return Lista con 3 items: [0] Estado TRUE o FALSE, 
	 * [1] StackTrace si se generó algun Exception.
	 * [2] Descripción del error.
	 */
	public List verificaPasscode(String userID, String codigoToken);
}
