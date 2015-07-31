package com.afirme.afirmenet.service.acceso;

import java.util.Map;

import com.afirme.afirmenet.security.JBFirmaDigital;

/**
 * @author 0cdcarguz
 *
 */
public interface PasswordService {

	/**
	 * M�todo que realiza el cambio de Password, especificando el ID Contrato,
	 * Password actual y nuevo Password.
	 * @param idContrato
	 * @param password
	 * @param nuevoPassword
	 * @return Mapa<Estatus, N�mero Digitos>, Estatus y N�mero de Digitos se refieren
	 * al c�digo de error y al n�mero de digitos incorrectos al proporcionar el nuevo password.
	 * Si no existen errores, el Estatus retornar� como (" ").
	 */
	public Map<String, String> updatePassword(String idContrato, String password, String nuevoPassword);
	
	/**
	 * M�todo que establece el Password a un Contrato definido.
	 * @param idContrato
	 * @param password
	 * @return TRUE si la operaci�n result� exitosa.
	 */
	public boolean setPassword(String idContrato, String password);
	
	/**
	 * M�todo que env�a un mail de notificaci�n de cambio de Password.
	 * @param idContrato
	 */
	public void mailNotificacionCambioPwd(String idContrato);
	
	/**
	 * M�todo que establece el Password actual de un Contrato como PENDIENTE. 
	 * @param idContrato
	 * @param nuevoPassword
	 * @return Mapa<Estatus, N�mero Digitos>, Estatus y N�mero de Digitos se refieren
	 * al c�digo de error y al n�mero de digitos incorrectos al proporcionar el nuevo password.
	 * Si no existen errores, el Estatus retornar� como (" ").
	 */
	public Map<String, String> solicitudCambioPwd(String idContrato, String nuevoPassword);
	
	/**
	 * Metodo que realiza la validaci�n de Password de un Contrato por primera vez.
	 * @param idContrato
	 * @param codigoToken
	 * @return Status de la validaci�n de Password de Contrato.
	 */
	public String validaPassword(String idContrato, String codigoToken);
}
