package com.afirme.afirmenet.enums;

public enum ConfigLogIn {
	
	TIPO_EMPRESAS("1"),
	TIPO_PERSONAS("2"),	
	USER_ACTIVO("1"),
	USER_INACTIVO("2"),
	USER_SUSPENDIDO("3"),
	USER_PTEACTIVAR("4"),
	USER_NUEVO("5"),
	USER_INACTIVIDAD("6"),
	USER_CUENTA_CANCELADA("7"),
	USER_AVISO_CUENTA_CANCELADA("8"),
	USER_AVISO_PAQUETE_PYME("A"),
	USER_PAQUETE_PYME("9"),
	USER_400_INVALIDO("1"),
	USER_400_PASSINCORRECTO("2"),
	USER_400_INACTIVO("3"),
	USER_400_SUSPENDIDO("4"),
	USER_400_NUEVO("7"),
	
	;
	
	ConfigLogIn(String valor) {
		this.valor = valor;
	}

	private String valor;

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
}
