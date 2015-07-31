package com.afirme.afirmenet.model.pagos.impuestos;


public enum ConceptosImpuestosPagoDerechos {

	DEPENDENCIA("30005"),
	NOMBRE_DEL_CONCEPTO("14701"),
	PERIDO("14702"),
	EJERCICIO("14727"),
	IMPORTE("14704"),
	TOTAL_DE_CONTRIBUCIONES("14708"),
	CANTIDAD_PAGADA("14720"),
	CLAVE_DE_REFERENCIA_DPA("14733"),
	CADENA_DE_LA_DEPENDENCIA("14734");
	

	private String valor;

	ConceptosImpuestosPagoDerechos(String valor) {
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

	public static ConceptosImpuestosPagoDerechos getNameByValue(String value) {
		ConceptosImpuestosPagoDerechos obj = null;
		for (ConceptosImpuestosPagoDerechos item : ConceptosImpuestosPagoDerechos
				.values()) {
			if (value.equals(item.getValor())) {
				obj = item;
				break;
			}
		}
		return obj;
	}
}
