package com.afirme.afirmenet.model.transferencia;


public enum TipoTransferencia {
	TRASPASO_PROPIAS                             	("02"),
	TRASPASO_TERCEROS                            	("03"),
	CHEQUES_EXTRAVIADOS                          	("40"),
	TRANSFERENCIA_SPEI                           	("05"),
	DOMICILIACION                                	("06"),
	NOMINA                                       	("07"),
	PAGO_INTERBANCARIO                           	("09"),
	PAGO_DE_IMPUESTOS                            	("12"),
	PROTECCION_DE_CHEQUES                        	("41"),
	SOLICITUD_DE_CHEQUERAS                      	("42"),
	CREDITO_REVOLVENTES                          	("43"),
	APERTURA_DE_CARTAS_DE_CREDITO                	("17"),
	PAGO_DE_SERVICIOS                            	("28"),
	TARJETAS_DE_DEBITO                           	("31"),
	ENMIENDA_DE_CARTAS_DE_CREDITO                	("18"),
	PAGO_IMSS_SIPARE                           	("56"),
	PAGO_TESORERIA_GOBIERNO_DISTRITO_FEDERAL     	("49"),
	INVERSION_DIARIA                             	("36"),
	CONSULTAS                                    	("01"),
	DOMINGO_ELECTRONICO                          	("37"),
	COMPRA_VALORES                               	("44"),
	VENTA_VALORES                                	("45"),
	PAGO_REFERENCIADO                            	("47"),
	AHORRO_VOLUNTARIO_AFORE                      	("46"),
	PAGO_PEMEX                                   	("48"),
	TRASPASO_TERCEROS_MASIVO                     	("50"),
	PAGO_IDE                                     	("53"),
	TRANSFERENCIAS_INTERNACIONALES_DOLARES       	("04"),
	TRANSFERENCIAS_INTERNACIONALES_MULTIMONEDA   	("51"),
	PROGRAMACION_DE_PAGO_AUTOMATICO_TDC          	("52"),
	DEPOSITO_DIGITAL                             	("54"),
	BAJA_DE_EMPLEADOS                            	("55"),
	RECARGA_DE_TIEMPO_AIRE_TELCEL                	("57"),
	PAGO_DE_NOMINA_IMSS                          	("58"),
	DISPOSICION_CREDITO_EDUCATIVO_CREDI100       	("59"),
	TERMINAL_PUNTO_DE_VENTA                      	("61"),
	INVERSION_PERFECTA                           	("65"),
	PAGO_DE_IMPUESTOS_DEPOSITO_REFERENCIADO      	("66"),
	EMISION_DE_ESTADO_DE_CUENTA                  	("60"),
	PAGO_SUA_ELECTRONICO                         	("62"),
	ACTIVACION_DE_SERVICIOS                      	("67"),
	PAGARE_AHORRAFIRME                           	("68"),
	ANTICIPO_DE_NOMINA                           	("70"),
	CREDITO_DE_NOMINA                            	("72"),
	AFIRME_MOVIL                                 	("69"),
	REPOSICION_DE_TARJETAS                       	("74"),
	TRASPASO_PROPIAS_MASIVO                      	("75"),
	RECARGA_DE_TIEMPO_AIRE_MOVISTAR              	("78"),
	ORDENES_DE_PAGO_O_ENVIO_DE_DINERO            	("80"),
	TRASPASO_PUNTOS_BONUS                        	("81"),
	LINEA_DE_CAPTURA_TESOFE                      	("79"),
	DISPOSICION_DE_TARJETA_DE_CREDITO_PYME       	("83"),
	DOMICILIACION_DE_SERVICIOS_BASICOS           	("82"),
	APORTACION_AFORE_POST                        	("76"),
	CONTRATACION_SERVICIOS_AFORE                 	("77"),
	ANTICIPO_POR_IVR                             	("84"),
	DISPOSICION_DE_LINEA_DE_CREDITO_POR_IVR      	("85"),
	AVISO_DE_VIAJE                               	("86"),
	MIS_CREDITOS_AFIRME                          	("87"),
	PAGARE_GRADUAL                               	("88"),
	PAGARE_MULTIPLE                              	("89"),
	FACTURACION_ELECTRONICA                      	("92"),
	ALERTAS_AFIRME                               	("91"),
	VENTA_DE_SEGUROS_ANTIFRAUDE                  	("90"),
	SPEI_BANCA_MOVIL                             	("93"),
	ASOCIACION_DE_CUENTA_A_NUMERO_MOVIL          	("94"),
	DISPOSICION_DE_EFECTIVO_TDC                  	("95"),
	ACTIVACION_DE_TARJETA_DE_CREDITO             	("96"),
	CAMBIO_DE_LIMITES_TARJETA_CREDITO_ADICIONAL  	("97"),
	BLOQUEO_DESBLOQUEO_TARJETA_DE_CREDITO        	("98"),
	FAVORITAS        								("00");
	
	TipoTransferencia(String valor){
		this.valor = valor;
	}
	
	private String valor;

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the value to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public static TipoTransferencia findByValue(String value) {

		for (TipoTransferencia enumObj : values()) {
			if (enumObj.getValor().equals(value)) {
				return enumObj;
			}
		}
		return null;
	}

}
