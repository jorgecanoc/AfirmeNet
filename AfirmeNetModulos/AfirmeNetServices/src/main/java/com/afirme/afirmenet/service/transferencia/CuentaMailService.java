package com.afirme.afirmenet.service.transferencia;

import java.util.Map;

public interface CuentaMailService {

	/**
	 * Servicio que retorna un mapa conteniendo todos los correos
	 * de cuentas de terceros asociados a la cuenta especificada 
	 * @param idContrato
	 * @return Mapa de valores <Contrato Tercero, Email Contacto>
	 */
	public Map<String, String> getEmailReferences(String idContrato);
	
	/**
	 * Servicio que obtiene el correo electronico relacionado a la cuenta seleccionada
	 *  
	 */
	public String getCorreoCuenta(String contrato,String cuenta);

	/**
	 * Servicio que guarda el correo electronito de la cuenta
	 *  
	 */
	public boolean setCorreoCuenta(String contrato, String cuenta, String correo);
	
	/**
	 * Servicio que valida las cuentas de email actualiza o inserta segun sea el caso
	 * 
	 */
	
	public void guardaCorreoCuenta(String contrato, String cuenta, String correo);
}
