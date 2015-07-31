package com.afirme.afirmenet.dao.acceso;

public interface OTPDao {
	
	public String obtenToken(String contrato);
	public boolean usaTokens(String contrato);
	public boolean validaTokenXActivar(String contrato, String usuario, int serialToken, String codigoActivacion);
	public boolean setCodigoSeguridad(String contrato, String usuario, String codigoSegEncrypt);
	public boolean setFechaVencimiento(String serialToken, String fechaVencimiento);
}
