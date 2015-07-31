package com.afirme.afirmenet.dao.consultas;

public interface CuentaDao {
	public String getNickName(String contrato, String cuenta);

	public boolean isComercio(String cuenta);

	public String getTitularCredito(String cliente);
	
	public boolean esCuentasJunior(String cuenta);
}
