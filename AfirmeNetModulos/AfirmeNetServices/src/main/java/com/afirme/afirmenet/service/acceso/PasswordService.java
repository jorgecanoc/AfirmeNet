package com.afirme.afirmenet.service.acceso;

import java.util.Map;

import com.afirme.afirmenet.security.JBFirmaDigital;

/**
 * @author 0cdcarguz
 *
 */
public interface PasswordService {

	/**
	 * Método que realiza el cambio de Password, especificando el ID Contrato,
	 * Password actual y nuevo Password.
	 * @param idContrato
	 * @param password
	 * @param nuevoPassword
	 * @return Mapa<Estatus, Número Digitos>, Estatus y Número de Digitos se refieren
	 * al código de error y al número de digitos incorrectos al proporcionar el nuevo password.
	 * Si no existen errores, el Estatus retornará como (" ").
	 */
	public Map<String, String> updatePassword(String idContrato, String password, String nuevoPassword);
	
	/**
	 * Método que establece el Password a un Contrato definido.
	 * @param idContrato
	 * @param password
	 * @return TRUE si la operación resultó exitosa.
	 */
	public boolean setPassword(String idContrato, String password);
	
	/**
	 * Método que envía un mail de notificación de cambio de Password.
	 * @param idContrato
	 */
	public void mailNotificacionCambioPwd(String idContrato);
	
	/**
	 * Método que establece el Password actual de un Contrato como PENDIENTE. 
	 * @param idContrato
	 * @param nuevoPassword
	 * @return Mapa<Estatus, Número Digitos>, Estatus y Número de Digitos se refieren
	 * al código de error y al número de digitos incorrectos al proporcionar el nuevo password.
	 * Si no existen errores, el Estatus retornará como (" ").
	 */
	public Map<String, String> solicitudCambioPwd(String idContrato, String nuevoPassword);
	
	/**
	 * Metodo que realiza la validación de Password de un Contrato por primera vez.
	 * @param idContrato
	 * @param codigoToken
	 * @return Status de la validación de Password de Contrato.
	 */
	public String validaPassword(String idContrato, String codigoToken);
}
