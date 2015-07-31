package com.afirme.afirmenet.enums;

/**
 * Para ver mas informacion sobre los codigos ver la tabla de AS400
 * AFICYFILES.inser
 */
public enum TipoServicio {
	
	TELEFONOS_DE_MEXICO("1","101"),
	TARJETA_DE_CREDITO_BANCOS_RED("2", "201"),
	PAGO_REFERENCIADO_SAT("5","501"),
	SEGUROS_AFIRME("6","601"), 
	ARRENDADORA_AFIRME("7","701"),
	GAS_NATURAL_MEXICO("9","901"),
	CABLEVISION("10","801"),
	AGUA_Y_DRENAJE_DE_MONTERREY("12","121"),
	LUZ_CFE("13","131"),
	APORTACIONES_VOLUNTARIAS_EN_AFORE("15","151"),	
	COMISION_DIA_ACTUAL_FAX("20","110"), 
	COMISION_MES_ACTUAL_FAX("21","111"), 
	COMISION_MES_ANTERIOR_FAX("22","112"), 	
	PAGO_PEMEX("23","123"),
	AXTEL("24","124"),
	PAGO_COMAPA_AFIRMENET("25","125");

	TipoServicio(String valor) {
		this.valor = valor;
	}

	TipoServicio(String valor, String valorComercial) {
		this.valor = valor;
		this.valorComercial = valorComercial;
	}	
	private String valor;
	private String valorComercial;

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the value to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	public static TipoServicio findByValue(String valor) {

		for (TipoServicio enumObj : values()) {
			if (enumObj.getValor().equals(valor)) {
				return enumObj;
			}
		}
		return null;
	}
	
	public static TipoServicio findByValorComercial(String valor) {

		for (TipoServicio enumObj : values()) {
			if (enumObj.getValorComercial().equals(valor)) {
				return enumObj;
			}
		}
		return null;
	}

	/**
	 * @return the valorComercial
	 */
	public String getValorComercial() {
		return valorComercial;
	}

	/**
	 * @param valorComercial the valorComercial to set
	 */
	public void setValorComercial(String valorComercial) {
		this.valorComercial = valorComercial;
	}
}
