package com.afirme.afirmenet.service.acceso;

import java.math.BigDecimal;

public interface UserService {
	
	/**
	 * Obtiene el tipo de regimen fiscal ante Hacienda del contrato especificado.
	 * @param contrato Numero de contrato de AfirmeNet
	 * @return String Tipo de regimen del usuario de AfirmeNet 1-Persona Moral 2-Persona Fisica
	 */
	public String obtenerTipoRegimen(String contrato);
	
	/**
	 * Obtiene la comision especial para la transaccion y el cliente indicados.
	 * @param numeroCliente
	 * @param codigoTransaccion
	 * @param comision
	 * @return
	 */
	public BigDecimal obtenerComisionEspecial(String numeroCliente, String codigoTransaccion, BigDecimal comision);
	
	/**
	 * Método que obtiene el Número de Cliente a partir del Contrato especificado.
	 * @param contrato del Cliente
	 * @return Numero de Cliente
	 */
	public String obtenerNumeroClienteContrato(String contrato);
	
	/**
	 * Método para obtener Contrato asociado al 
	 * número de Serie del Token definido.
	 * @param serialToken
	 * @return Contrato asociado al número de serie del Token.
	 */
	public String obtenerContratoToken(String serialToken);
	
	/**
	 * Método que obtiene el mail del Usuario mediante su Contrato.
	 * @param contrato
	 * @return Mail del contrato.
	 */
	public String getMailUsuario(String contrato);
	
	/**
	 * @param contrato
	 * @return
	 */
	public int obtenerNumeroIntento(String contrato);
	
	/**
	 * Revisa si el usuario esta dado de alta en la tabla de informacion de alias
	 * @param contrato
	 * @return TRUE si el usuario existe
	 */
	public boolean verificarUsuarioRegistrado(String contrato);
	
	/**
	 * Se registra al usuario de afirmenet para determinar si ya definio su alias y cuantos intentos tiene disponibles.
	 * @param contrato
	 * @return TRUE si el registro fue exitoso
	 */
	public boolean registrarUsuarioAlias(String contrato);
	
	/**
	 * Actualiza la tabla de informacion de alias cuando el usuario ingresa por primera vez con su alias definido.
	 * @param contrato
	 * @return TRUE si la actualizacion fue exitosa
	 */
	public boolean actualizarPrimerLoginConAlias(String contrato);
	
	/**
	 * Incrementa el numero de intentos que tiene disponibles el usuario para no definir el alias al inicio de sesion.
	 * @param contrato
	 * @return TRUE si la actualizacion fue exitosa
	 */
	public boolean incrementarNumeroIntentos(String contrato);
	
	/**
	 * Actualiza (en as400) el alias del usuario de afirmenet
	 * @param contrato
	 * @param alias
	 * @return TRUE si la actualizacion fue exitosa
	 */
	public boolean actualizarAlias(String contrato, String alias);
}
