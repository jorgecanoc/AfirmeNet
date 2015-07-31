package com.afirme.afirmenet.dao.transferencia;

import java.util.List;
import java.util.Map;

public interface CuentaMailDao {
	// TODO cdcarguz implementar metodos restantes JBAccEmail
	
	/**
	 * Metodo que retorna un mapa que contiene el par de valores:
	 * idContrato y Mail correspondiente.
	 * @param idContrato
	 * @return Mapa de Llave, Valor: <Contrato Tercero, Email Contacto>
	 */
	public Map<String, String> getEmailReferences(String idContrato);
	
	/**
	 * Metodo que obtiene el correo electronito relacionado a la cuenta seleccionada
	 *  
	 */
	public String getCorreoCuenta(String contrato,String cuenta);
	
	/**
	 * Metodo que guarda el correo electronito de la cuenta
	 *  
	 */
	public boolean setCorreoCuenta(String contrato, String cuenta, String correo);

	/**
	 * Metodo que actualiza el correo electronito de la cuenta
	 *  
	 */
	public boolean updateCorreoCuenta(String contrato, String cuenta, String correo);
	
	/**
	 * Metodo que valida si tiene correo asignado a la cuenta
	 *  
	 */
	public boolean tieneCorreo(String contrato,String cuenta);
}
