package com.afirme.afirmenet.enums;

public enum ConfigProperties {
	
	// Contantes del tipo de banca
	LEGAL_TYPE_EMPRESA("1"),
	LEGAL_TYPE_PERSONA("2"),
	LEGAL_TYPE_EMPRESA_STR("Empresa"),
	LEGAL_TYPE_PERSONA_STR("Persona"),
	
	// Costantes Tipo Propiedad
	PROPERTY_TYPE_ADMINISTRATIVE("1"),
	PROPERTY_TYPE_SYSTEMS("2"),
	PROPERTY_TYPE_BOTH("3"),
	PROPERTY_TYPE_ADMINISTRATIVE_STR("Aministrativo"),
	PROPERTY_TYPE_SYSTEMS_STR("Sistemas"),
	PROPERTY_TYPE_BOTH_STR("Ambos"),

	// Constantes de Propieades
	PROPERTYID_TRANSFER_LIMIT_TIME("1"),
	PROPERTYID_ACTIVE_LIMIT_TRANSFER("2"),
	PROPERTYID_ACTIVATE_SERVICE_PER("3"), // Tiempo espera activacion de servicios basicos Afirmenet Personas
	PROPERTYID_ACTIVATE_SERVICE_EMP("4"), // Tiempo espera activacion de servicios basicos Afirmenet Empresas
	PROPERTYID_THIRD_ACCOUNT_TIME_PER("5"), // Tiempo espera alta de cuentas terceros Afirmenet Personas
	PROPERTYID_THIRD_ACCOUNT_TIME_EMP("6"), // Tiempo espera alta de cuentas terceros Afirmenet Empresas
	PROPERTYID_TRANSFER_LIMIT_PAYROLL("7"), // habilita o inhabilita los límites de transferencia para el pago de nómina.
	PROPERTYID_EMAIL_CHANGE("8"), // Tiempo espera en cambio correo electronico de Afirmenet Personas.
	   
	//::AIMM::
	PROPERTYID_INV_PERFECTA_60("17"), // Meses de regalo para inversion perfecta en 360 dias de Afirmenet Personas.
	PROPERTYID_INV_PERFECTA_90("10"), // Meses de regalo para inversion perfecta en 90 dias de Afirmenet Personas.
	PROPERTYID_INV_PERFECTA_180("11"), // Meses de regalo para inversion perfecta en 180 dias de Afirmenet Personas.
	PROPERTYID_INV_PERFECTA_360("12"), // Meses de regalo para inversion perfecta en 360 dias de Afirmenet Personas.
		
	//GGLEEGON
	PROPERTYID_CLAVE_VIGENCIA("20"), // Vigencia en horas de clave de activacion en alta de cuentas de Afirmenet Personas.
	PROPERTYID_CLAVE_INTENTOS("21"); // Numero de intentos fallidos en captura de clave de activacion en alta de cuentas de Afirmenet Personas.

	ConfigProperties(String valor) {
		this.valor = valor;
	}

	private String valor;

	/**
	 * @return valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
}
