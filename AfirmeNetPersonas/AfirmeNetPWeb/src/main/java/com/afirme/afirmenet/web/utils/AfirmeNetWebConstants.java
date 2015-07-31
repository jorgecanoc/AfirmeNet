package com.afirme.afirmenet.web.utils;

import java.util.Arrays;
import java.util.List;

public class AfirmeNetWebConstants {
	// ### Definicion de JavaPath para Beans ###//
	public static final String JAVA_PATH = "com.afirme.afirmenet.ibs";
	// ### Inicia definicion de Paths ###//
	public static final String MODAL = "/base/include/modal";
	public static final String MV_LOGIN_AVISO_SEGURIDAD = "/site/acceso/avisoSeguridad";
	public static final String MV_LOGIN_USERINACTIVO = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_USERSUSPENDIDO = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_USERNUEVO = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_USERINACTIVIDAD = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_USERIVALIDO = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_ACCCANCELADA = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_AVISO_ACCCANCELADA = "/site/acceso/avisosLogin";
	public static final String MV_LOGIN_ACCPAGOPYME = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_AVISO_ACCPAGOPYME = "/site/acceso/avisosLogin";
	public static final String MV_LOGIN_DATOS_ACCESO = "/site/acceso/datosAcceso";
	public static final String MV_LOGIN = "site/acceso/login";
	public static final String MV_LOGIN_INVALIDPASS = "site/acceso/mensajesLogin";
	public static final String MV_LOGIN_FINDIA = "site/acceso/login";
	public static final String MV_LOGIN_INOUT = "/site/acceso/mensajesLogin";
	public static final String MV_LOGIN_BANCAMOVIL = "/site/acceso/mensajesLogin";
	public static final String MV_HOME = "site/comun/home";
	public static final String MV_HOME_TERMINOS = "site/comun/terminos";
	public static final String MV_PREG_SEGURIDAD = "site/acceso/preguntaSeguridad";
	public static final String MV_RECUPERA_PWD = "site/acceso/recuperaPwd";
	public static final String MV_RECUPERA_PREG_SEGU = "site/acceso/recuperaPregSeg";
	public static final String MV_SYNC_TOKEN = "site/acceso/sincronizarToken";
	public static final String MV_CONTROL_ACCESO_VALIDA_PASS = "site/comun/home";
	public static final String MV_ACTIVA_CONTRATO = "site/acceso/activaContrato";
	public static final String MV_CONTRATO = "site/acceso/contratoBanca";
	public static final String MV_ASIGNA_PWD = "site/acceso/asignaPwd";
	public static final String MV_ACTIVA_TOKEN = "site/acceso/activaToken";
	public static final String MV_ACTIVA_CONTRATOSINTOKEN = "site/acceso/activacion";
	// #CONSULTAS----Saldos y movimientos#//
	public static final String MV_CONSULTAS_SM_RESUMEN = "site/consultas/sm/resumen";
	public static final String MV_CONSULTAS_SM_DETALLE_ULTIMOS = "site/consultas/sm/detalle_ultimos";
	public static final String MV_CONSULTAS_SM_DETALLE_TODOS = "site/consultas/sm/detalle_todos";
	public static final String MV_CONSULTAS_SM_DETALLE_RETENIDOS = "site/consultas/sm/detalle_retenidos";
	public static final String MV_CONSULTAS_SM_BUSQUEDA_FILTROS = "site/consultas/sm/busqueda_filtros";
	public static final String MV_CONSULTAS_SM_BUSQUEDA_RESULTADO = "site/consultas/sm/busqueda_resultado";
	public static final String MV_CONSULTAS_EDO_CTA_ACTIVACION = "site/consultas/edocta/edocta_activacion";
	// #TRANSFERENCIAS----Cuentas Afirme - Cuentas Terceros#//
	public static final String MV_TRANSFERENCIAS_CTA_TERCEROS = "site/transferencias/terceros/terceros";
	public static final String MV_TRANSFERENCIAS_INGRESO_DATOS = "site/transferencias/terceros/terceros_datos";
	public static final String MV_TRANSFERENCIAS_CONFIRMACION = "site/transferencias/terceros/terceros_confirmacion";
	public static final String MV_TRANSFERENCIAS_COMPROBANTE = "site/transferencias/terceros/terceros_comprobante";
	public static final String MV_TRANSFERENCIAS_LISTA_GUARDADAS = "site/transferencias/terceros/terceros_lista";
	public static final String MV_TRANSFERENCIAS_LISTA_COMPROBANTES = "site/transferencias/terceros/terceros_listacomprobantes";
	public static final String MV_TRANSFERENCIAS_AGREGA_TRANSACCION = "/transferencias/terceros/agrega_transaccion";
	// #TRANSFERENCIAS----Cuentas Afirme - Cuentas Propias#//
	public static final String MV_TRANSFERENCIAS_PROPIAS_SELECCION = "site/transferencias/propias/propias_selecciona";
	public static final String MV_TRANSFERENCIAS_PROPIAS_CAPTURA = "site/transferencias/propias/propias_captura";
	public static final String MV_TRANSFERENCIAS_PROPIAS_CONFIRMAR = "site/transferencias/propias/propias_confirma";
	public static final String MV_TRANSFERENCIAS_PROPIAS_COMPROBANTE = "site/transferencias/propias/propias_comprobante";
	public static final String MV_TRANSFERENCIAS_PROPIAS_CONFGUARDADAS = "site/transferencias/propias/propias_guardadas";
	public static final String MV_TRANSFERENCIAS_PROPIAS_COMPFGUARDADAS = "site/transferencias/propias/propias_compguardadas";
	public static final String MV_TRANSFERENCIAS_PROPIAS_GUARDAR = "/transferencias/propias/guarda_propias.htm";
	// # TRANSFERENCIAS----Bancos Internacionales - Dolares Americanos #//
	public static final String MV_TRANSFERENCIAS_DOLARES = "site/transferencias/internacionales/dolares/dolares";
	public static final String MV_TRANSFERENCIAS_DOLARES_INGRESO_DATOS = "site/transferencias/internacionales/dolares/dolares_datos";
	public static final String MV_TRANSFERENCIAS_DOLARES_CONFIRMACION = "site/transferencias/internacionales/dolares/dolares_confirmacion";
	public static final String MV_TRANSFERENCIAS_DOLARES_COMPROBANTE = "site/transferencias/internacionales/dolares/dolares_comprobante";
	// # TRANSFERENCIAS----Bancos Internacionales - Multimoneda #//
	public static final String MV_TRANSFERENCIAS_MULTIMONEDA = "site/transferencias/internacionales/multimoneda/multimoneda";
	public static final String MV_TRANSFERENCIAS_MULTIMONEDA_INGRESO_DATOS = "site/transferencias/internacionales/multimoneda/multimoneda_datos";
	public static final String MV_TRANSFERENCIAS_MULTIMONEDA_CONFIRMACION = "site/transferencias/internacionales/multimoneda/multimoneda_confirmacion";
	public static final String MV_TRANSFERENCIAS_MULTIMONEDA_COMPROBANTE = "site/transferencias/internacionales/multimoneda/multimoneda_comprobante";
	// #TRANSFERENCIAS----Bancos Nacionaless#//
	public static final String MV_TRANSFERENCIAS_NACIONALES_SELECCION = "site/transferencias/nacionales/nacionales_selecciona";
	public static final String MV_TRANSFERENCIAS_NACIONALES_CAPTURA = "site/transferencias/nacionales/nacionales_captura";
	public static final String MV_TRANSFERENCIAS_NACIONALES_CONFIRMAR = "site/transferencias/nacionales/nacionales_confirma";
	public static final String MV_TRANSFERENCIAS_NACIONALES_COMPROBANTE = "site/transferencias/nacionales/nacionales_comprobante";
	public static final String MV_TRANSFERENCIAS_NACIONALES_LISTA_GUARDADAS = "site/transferencias/nacionales/nacionales_lista";
	public static final String MV_TRANSFERENCIAS_NACIONALES_LISTA_COMPROBANTES = "site/transferencias/nacionales/nacionales_listacomprobantes";
	public static final String MV_TRANSFERENCIAS_NACIONALES_AGREGA_TRANSACCION = "/transferencias/nacionales/nacionales_agrega_transaccion";

	// #TRANSFERENCIAS----Cuentas Afirme - Domingo electronico#//
	public static final String MV_DOMINGO_ELEC_CTAS = "site/transferencias/domingo/seleccion";
	public static final String MV_DOMINGO_ELEC_DATOS = "site/transferencias/domingo/datos";
	public static final String MV_DOMINGO_ELEC_CONFIRMACION = "site/transferencias/domingo/confirmacion";
	public static final String MV_DOMINGO_ELEC_COMPROBANTE = "site/transferencias/domingo/comprobante";
	public static final String MV_DOMINGO_ELEC_EJECUTAR= "/transferencias/domingo/ejecutar";
	
	// #--------------FAVORITAS--------------# //
	public static final String MV_FAVORITAS_SELECCIONA = "site/transferencias/favoritas/seleccion";
	public static final String MV_FAVORITAS_CONFIRMA = "site/transferencias/favoritas/confirma";
	public static final String MV_FAVORITAS_EJECUTAR = "/transferencias/favoritas/ejecutar";
	public static final String MV_FAVORITAS_COMPROBANTE = "site/transferencias/favoritas/comprobante";
		
	// #PAGOS--- TDC PROPIA S# //
	public static final String MV_PAGOS_TDCPROPIAS = "site/pagos/tdcPropias/tdc_selecciona";
	public static final String MV_PAGOS_TDCPROPIAS_CAPTURA = "site/pagos/tdcPropias/tdc_captura";
	public static final String MV_PAGOS_TDCPROPIAS_CONFIRMA = "site/pagos/tdcPropias/tdc_confirma";
	public static final String MV_PAGOS_TDCPROPIAS_COMPROBANTE = "site/pagos/tdcPropias/tdc_comprobante";
	
	// #PAGOS--- TDC TERCEROS, OTROS BANCOS, AMERICAN EXPRESS  # //
	public static final String MV_PAGOS_TDC = "site/pagos/tdcPagos/tdc_selecciona";
	public static final String MV_PAGOS_TDC_CAPTURA = "site/pagos/tdcPagos/tdc_captura";
	public static final String MV_PAGOS_TDC_CONFIRMA = "site/pagos/tdcPagos/tdc_confirma";
	public static final String MV_PAGOS_TDC_COMPROBANTE = "site/pagos/tdcPagos/tdc_comprobante";
	
	// #PAGOS--- TDC DOMICILIAR  # //
	public static final String MV_TDCDOMI = "site/tdc/domiciliacion/tdc_selecciona";
	public static final String MV_TDCDOMI_CONTRATO = "site/tdc/domiciliacion/tdc_contrato";
	public static final String MV_TDCDOMI_CONFIRMA = "site/tdc/domiciliacion/tdc_confirma";
	public static final String MV_TDCDOMI_COMPROBANTE = "site/tdc/domiciliacion/tdc_comprobante";
	
	// #PAGOS--- SEGUROS ANTIFRAUDES  # //
	public static final String MV_PAGOS_SEGURO = "site/pagos/seguros/seg_selecciona";
	public static final String MV_PAGOS_SEGURO_PAGOS = "site/pagos/seguros/seg_pagos";
	public static final String MV_PAGOS_SEGURO_CONTRATO = "site/pagos/seguros/seg_contrato";
	public static final String MV_PAGOS_SEGURO_CONFIRMA = "site/pagos/seguros/seg_confirma";
	public static final String MV_PAGOS_SEGURO_COMPROBANTE = "site/pagos/seguros/seg_comprobante";
	
	// # PAGOS --- IMPUESTOS GDF # //
	public static final String MV_PAGOS_IMPUESTOS_GDF = "site/pagos/gdf/gdf_seleccion";
	public static final String MV_PAGOS_IMPUESTOS_GDF_DATOS = "site/pagos/gdf/gdf_ingreso_datos";
	public static final String MV_PAGOS_IMPUESTOS_GDF_CONFIRMACION = "site/pagos/gdf/gdf_confirmacion";
	public static final String MV_PAGOS_IMPUESTOS_GDF_COMPROBANTE = "site/pagos/gdf/gdf_comprobante";
	
	// # PAGOS --- DOMICILIACION SERVICIOS # //
	public static final String MV_PAGOS_DOMICILIACION = "site/pagos/domiciliacion/domiciliacion_seleccion";
	public static final String MV_PAGOS_DOMICILIACION_CONTRATO = "site/pagos/domiciliacion/domiciliacion_contrato";
	public static final String MV_PAGOS_DOMICILIACION_DATOS = "site/pagos/domiciliacion/domiciliacion_datos";
	public static final String MV_PAGOS_DOMICILIACION_CONFIRMACION = "site/pagos/domiciliacion/domiciliacion_confirmacion";
	public static final String MV_PAGOS_DOMICILIACION_COMPROBANTE = "site/pagos/domiciliacion/domiciliacion_comprobante";
	public static final String MV_PAGOS_DOMICILIACION_HISTORICO = "site/pagos/domiciliacion/domiciliacion_historico";
	public static final String MV_PAGOS_DOMICILIACION_EDICION = "site/pagos/domiciliacion/domiciliacion_edicion";
	
	// #--------------SERVICIOS--------------# //
	public static final String MV_SERVICIOS_SELECCION_RD = "servicios/seleccion";
	public static final String MV_SERVICIOS_SELECCION = "site/pagos/servicios/seleccion";
	public static final String MV_SERVICIOS_CONTRATO = "site/pagos/servicios/contrato";
	public static final String MV_SERVICIOS_DATOS = "site/pagos/servicios/datos";
	public static final String MV_SERVICIOS_CONFIRMA = "site/pagos/servicios/confirma";
	public static final String MV_SERVICIOS_COMPROBANTE = "site/pagos/servicios/comprobante";

	// #PAGOS--- SEGUROS AFIRME  # //
	public static final String MV_PAGOS_SEGURO_AFIRME = "site/pagos/seguroAfirme/seg_afi_selecciona";
	public static final String MV_PAGOS_SEGURO_AFIRME_CAPTURA = "site/pagos/seguroAfirme/seg_afi_captura";
	public static final String MV_PAGOS_SEGURO_AFIRME_CONFIRMA = "site/pagos/seguroAfirme/seg_afi_confirma";
	public static final String MV_PAGOS_SEGURO_AFIRME_COMPROBANTE = "site/pagos/seguroAfirme/seg_afi_comprobante";

	// #PAGOS--- SERVICIOS --- COLEGIOS REFERENCIADO  # //
	public static final String MV_PAGOS_COLEGIO_REFERENCIADO= "site/pagos/servicios/colegios/colegios_selecciona";
	public static final String MV_PAGOS_COLEGIO_REFERENCIADO_CAPTURA = "site/pagos/servicios/colegios/colegios_captura";
	public static final String MV_PAGOS_COLEGIO_REFERENCIADO_CONFIRMA = "site/pagos/servicios/colegios/colegios_confirma";
	public static final String MV_PAGOS_COLEGIO_REFERENCIADO_COMPROBANTE = "site/pagos/servicios/colegios/colegios_comprobante";

	// #PAGOS--- SERVICIOS --- SERVICIOS REFERENCIADO  # //
	public static final String MV_PAGOS_SERVICIO_REFERENCIADO = "site/pagos/servicios/referenciado/servicios_selecciona";
	public static final String MV_PAGOS_SERVICIO_REFERENCIADO_CAPTURA = "site/pagos/servicios/referenciado/servicios_captura";
	public static final String MV_PAGOS_SERVICIO_REFERENCIADO_CONFIRMA = "site/pagos/servicios/referenciado/servicios_confirma";
	public static final String MV_PAGOS_SERVICIO_REFERENCIADO_COMPROBANTE = "site/pagos/servicios/referenciado/servicios_comprobante";

	// #PAGOS--- IMPUESTOS --- PAGO REFERENCIADO  # //
	public static final String MV_PAGOS_IMPUESTOS_REFERENCIADO = "site/pagos/impuestos/referenciado/imp_ref_selecciona";
	public static final String MV_PAGOS_IMPUESTOS_REFERENCIADO_CAPTURA = "site/pagos/impuestos/referenciado/imp_ref_captura";
	public static final String MV_PAGOS_IMPUESTOS_REFERENCIADO_CONFIRMA = "site/pagos/impuestos/referenciado/imp_ref_confirma";
	public static final String MV_PAGOS_IMPUESTOS_REFERENCIADO_COMPROBANTE = "site/pagos/impuestos/referenciado/imp_ref_comprobante";
	
	// #--------------INVERSIONES--------------# //
	// #INVERSIONES--- DIARIA  # //
	public static final String MV_INVERSIONES_DIARIA = "site/inversiones/diaria/diaria_selecciona";
	public static final String MV_INVERSIONES_DIARIA_CAPTURA = "site/inversiones/diaria/diaria_captura";
	public static final String MV_INVERSIONES_DIARIA_CONFIRMA = "site/inversiones/diaria/diaria_confirma";
	public static final String MV_INVERSIONES_DIARIA_COMPROBANTE = "site/inversiones/diaria/diaria_comprobante";
	
	// #INVERSIONES--- PERFECTA  # //
	public static final String MV_INVERSIONES_PERFECTA = "site/inversiones/perfecta/perfecta_selecciona";
	public static final String MV_INVERSIONES_PERFECTA_CAPTURA = "site/inversiones/perfecta/perfecta_captura";
	public static final String MV_INVERSIONES_PERFECTA_CONFIRMA = "site/inversiones/perfecta/perfecta_confirma";
	public static final String MV_INVERSIONES_PERFECTA_COMPROBANTE = "site/inversiones/perfecta/perfecta_comprobante";
	
	// #PAGOS--- IMPUESTOS --- FEDERALES ANUALES# //
	public static final String MV_PAGOS_IMPUESTOS_FED_CAPTURA_RD = "captura";
	public static final String MV_PAGOS_IMPUESTOS_FED_CAPTURA = "site/pagos/impuestos/federales/captura";
	public static final String MV_PAGOS_IMPUESTOS_FED_CONFIRMA = "site/pagos/impuestos/federales/confirma";
	public static final String MV_PAGOS_IMPUESTOS_FED_COMPROBANTE = "site/pagos/impuestos/federales/comprobante";
	
	// # NOMINA # //
	public static final String MV_NOMINA = "site/nomina/nomina";
	public static final String MV_NOMINA_DISPOSICION = "site/nomina/nomina_disposicion";
	public static final String MV_NOMINA_CONFIRMACION = "site/nomina/nomina_confirmacion";
	public static final String MV_NOMINA_ABONO = "site/nomina/nomina_abono";
	
	// ### Termina definicion de Paths ###//
	
	public static final String USUARIO_SESSION = "afirmeNetUser";
	public static final String CUENTAS_SESSION = "cuentas";
	public static final String CREDITOS_SESSION = "creditos";
	public static final String TIEMPO_CUENTAS_SESSION = "tiempoEsperaCuentas";
	public static final String INVERSIONES_SESSION = "inversiones";
	public static final String BACKGROUD_IMAGE = "backgroudImg";
	public static final String BACKGROUD_PATH_IMAGE = "/resources/img/stages/stage.jpg";

	// ### Constantes transferencias ###//
	public static final List<String> CUENTAS_PROPIAS = Arrays.asList("DDA",
			"SAV", "NOW");
	

	
}
