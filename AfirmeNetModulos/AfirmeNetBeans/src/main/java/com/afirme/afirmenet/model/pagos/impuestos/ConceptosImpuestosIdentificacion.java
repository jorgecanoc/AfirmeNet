package com.afirme.afirmenet.model.pagos.impuestos;

public enum ConceptosImpuestosIdentificacion {
	RFC("10001"), 
	CURP("10002"),
	APELLIDO_PATERNO("10003"),
	APELLIDO_MATERNO("10004"),
	NOMBRE("10005"),
	DENOMINACION("10006"),
	TOTAL_EFECTIVAMENTE_PAGADO("10017");
	private String valor;

	ConceptosImpuestosIdentificacion(String valor) {
		this.valor = valor;
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

	public static ConceptosImpuestosIdentificacion getNameByValue(String value) {
		ConceptosImpuestosIdentificacion obj = null;
		for (ConceptosImpuestosIdentificacion item : ConceptosImpuestosIdentificacion
				.values()) {
			if (value.equals(item.getValor())) {
				obj = item;
				break;
			}
		}
		return obj;
	}	
}
