package com.afirme.afirmenet.enums;

public enum ConceptoGDF {
	
	LICENCIA_CONDUCIR(1),
	TRAM_VEHICULAR(2),
	MULTA_REV_VEHICULAR(3),
	MULTA_INFRACCION(4),
	MEDIO_AMB_VERFIC_EXTEMP(5),
	MEDIO_AMBIENTE_CONTAM(6),
	MEDIO_AMBIENTE_HOLOGR(7),
	REGISTRO_CIVIL(8),
	SERVICIO_POLICIA(9),
	IMP_PREDIAL(10),
	IMP_NOMINA(11),
	TENENCIA(12),
	SUMINISTRO_AGUA(13),
	IMP_RIFAS(14),
	IMP_HOSPEDAJE(15),
	IMP_INMUEBLES(16),
	REGISTRO_PUBLICO(17),
	AUTO_NUEVO(18),
	ISR_ENAJENACION(19),
	REGISTRO_CIVIL_BUSQUEDA(20),
	PAGOS_TESORERIA(21);
	
	ConceptoGDF(int valor) {
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
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
}
