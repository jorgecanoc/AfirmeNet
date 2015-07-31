package com.afirme.afirmenet.dao.acceso;

import java.math.BigDecimal;

public interface UserDao {
	
	public String obtenerTipoRegimen(String contrato);
	public BigDecimal obtenerComisionEspecial(String numeroCliente, String codigoTransaccion, BigDecimal comision);
	public String obtenerNumeroClienteContrato(String contrato);
	public String obtenerContratoToken(String serialToken);
	public String getMailUsuario(String contrato);
	public int obtenerNumeroIntento(String contrato);
	public boolean verificarUsuarioRegistrado(String contrato);
	public boolean registrarUsuarioAlias(String contrato);
	public boolean actualizarPrimerLoginConAlias(String contrato);
	public boolean incrementarNumeroIntentos(String contrato);
	public boolean actualizarAlias(String contrato, String alias);
}
