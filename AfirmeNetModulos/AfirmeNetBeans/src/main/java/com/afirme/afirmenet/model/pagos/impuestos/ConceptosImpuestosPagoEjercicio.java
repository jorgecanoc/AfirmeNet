package com.afirme.afirmenet.model.pagos.impuestos;


public enum ConceptosImpuestosPagoEjercicio{
	DEPENDENCIA("30005"),
	NOMBRE_DEL_CONCEPTO("11001"),
	PERIDO("11002"),
	EJERCICIO("11027"),
	TIPO_PAGO("11022"),
	A_CARGO("11004"),
	PARTE_ACTUALIZADA("11005"),
	RECARGOS("11006"),
	TOTAL_DE_CONTRIBUCIONES("11008"),
	TOTAL_DE_APLICACIONES("11016"),
	CANTIDAD_A_CARGO("11017"),
	CANTIDAD_PAGADA("11020");
	

	private String valor;

	ConceptosImpuestosPagoEjercicio(String valor) {
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

	public static ConceptosImpuestosPagoEjercicio getNameByValue(String value) {
		ConceptosImpuestosPagoEjercicio obj = null;
		for (ConceptosImpuestosPagoEjercicio item : ConceptosImpuestosPagoEjercicio
				.values()) {
			if (value.equals(item.getValor())) {
				obj = item;
				break;
			}
		}
		return obj;
	}
}
