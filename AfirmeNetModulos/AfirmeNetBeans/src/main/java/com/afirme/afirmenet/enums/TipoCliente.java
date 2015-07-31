package com.afirme.afirmenet.enums;


public enum TipoCliente {
	PERSONAS(2), EMPRESAS(1), AMBOS(0);

	private int value;

	TipoCliente(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public static TipoCliente getNameByValue(String value) {
		TipoCliente obj = null;
		for (TipoCliente item : TipoCliente.values()) {
			if (value.equals(item.getValue())) {
				obj = item;
				break;
			}
		}
		return obj;
	}

}
