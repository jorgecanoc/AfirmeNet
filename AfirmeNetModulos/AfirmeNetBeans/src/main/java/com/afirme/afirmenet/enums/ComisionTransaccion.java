package com.afirme.afirmenet.enums;

public enum ComisionTransaccion {
	TRANSFERENCIA_SPEI("7555"), PAGO_INTERBANCARIO(
			"7582");
	ComisionTransaccion(String value) {
		this.value = value;
	}

	private String value;

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public static ComisionTransaccion findByValue(String value) {

		for (ComisionTransaccion excepcion : values()) {
			if (excepcion.getValue().equals(value)) {
				return excepcion;
			}
		}
		return null;
	}

}
