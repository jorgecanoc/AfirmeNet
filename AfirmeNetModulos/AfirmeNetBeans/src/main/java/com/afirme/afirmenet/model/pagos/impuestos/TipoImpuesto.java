package com.afirme.afirmenet.model.pagos.impuestos;

public enum TipoImpuesto {
	PROVICIONAL("1","11005"), ANUAL("2","12005"), CREDITO("3","13002"), ENTIDADES("4","14003"), ANTERIOR("5",""), DERECHOS("6","15003");
	private String valor;
	private String version;

	TipoImpuesto(String valor, String version) {
		this.valor = valor;
		this.version = version;
	}

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

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}
