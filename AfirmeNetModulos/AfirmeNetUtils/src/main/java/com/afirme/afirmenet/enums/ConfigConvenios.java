package com.afirme.afirmenet.enums;

public enum ConfigConvenios {
	// Constante interna para pago TDC
	TDC(2),
	TDC_AFIRME(1),
	TDC_OTROS_BANCOS(2),
	TDC_AMERICAN_EXPRESS(3),
	
	// Constante interna para Pago Impuesto 
	PAGO_IMPUESTO_PROVISIONAL(1),
	PAGO_IMPUESTO_ANUAL(2),
	PAGO_IMPUESTO_CREDITO_FISCAL (3),	
	PAGO_IMPUESTO_ENTIDAD_FEDERATIVA (4),
	PAGO_IMPUESTO_ANTERIOR(5),
	PAGO_IMPUESTO_PRODUCTO_APROVECHAMIENTO (6),
	PAGO_IMPUESTO_REFERENCIADO(7),
	
	// Contantes internas para pago de servicio
	PAGO_SERVICIO_COLEGIOS (1),
	PAGO_SERVICIO_REFERENCIADO(2),
	
	// Constantes de los servicios de AS400
	NO_SERVICIO(0),
	SERVICIO_TDC(2),
	SERVICIO_PAGO_REFERENCIADO_SAT(5),
	SERVICIO_SEGUROS_AFIRME(6),	
	SERVICIO_APORTACION_VOLUNTARIA_AFORE(15);
	;
	
	
	
	ConfigConvenios(int valor) {
		this.valor = valor;
	}

	private int valor;

	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

}
