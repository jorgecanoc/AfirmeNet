package com.afirme.afirmenet.service.acceso;

public interface OTPService {

	/**
	 * Valida la existencia del Token y que su estatus sea 'C'
	 * @param contrato
	 * @param usuario
	 * @param serial
	 * @param codSegur
	 * @return TRUE si el Token asociado al contrato existe y su estatus es 'C'
	 */
	public boolean validaTokenXActivar(String contrato, String usuario, int serialToken, String codigoActivacion);
	
	/**
	 * Se obtienen el no. Serie del Token a partir del Usuario y Contrato
	 * @param contrato
	 * @return No.Serie del Token
	 */
	public String obtenToken(String contrato);
	
	/**
	 * Verifica si el contrato tiene asociado un Token
	 * @param contrato
	 * @return TRUE si el contrato tiene asociado un Token
	 */
	public boolean usaTokens(String contrato);
	
	/**
	 * Metodo que envia mail de solicitud de regeneracion de codigo de seguridad.
	 * @param contrato
	 * @param usuario
	 * @param libreria
	 * @param host
	 * @param from
	 * @return TRUE si el proceso no presento problemas.
	 */
	public boolean enviaMailCodigoSeguridad(String contrato);
	public boolean setCodigoSeguridad(String contrato, String usuario, String codigoSegEnc);
	
	/**
	 * Método que establece la Fecha de Vencimiento del Token determinado
	 * por el Número de Serie.
	 * @param serialToken
	 * @param fechaVencimiento
	 * @return TRUE si la actualización fue exitosa.
	 */
	public boolean setFechaVencimiento(String serialToken, String fechaVencimiento);
}
