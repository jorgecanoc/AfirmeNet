package com.afirme.afirmenet.enums;

public enum CoberturaCardif {
	BASICO(0), ORO(1), PLATINO(2);

	private int value;

	CoberturaCardif(int value) {
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

	public static CoberturaCardif getNameByValue(String value) {
		CoberturaCardif obj = null;
		for (CoberturaCardif item : CoberturaCardif.values()) {
			if (value.equals(item.getValue())) {
				obj = item;
				break;
			}
		}
		return obj;
	}


}
