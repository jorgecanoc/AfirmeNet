package com.afirme.afirmenet.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.model.DCConfig.Aplicacion;
import com.afirme.afirmenet.service.config.ConfiguracionService;
import com.afirme.afirmenet.service.config.PropertyService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.web.controller.base.GlobalExceptionController;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

/**
 * Clase de configuracion que se ejecuta al iniciar el contexto de Spring, esta
 * clase configura todos los atributos estaticos de {@link AfirmeNetConstants}
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Component
public class InitConfig {
	static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionController.class);
	@Autowired
	private ConfiguracionService configuracionService;
	@Autowired
	private PropertyService propertyService;

	/**
	 * Metodo que ejecuta la configuracion de las constantes que utilizara
	 * afirmenet
	 */
	public void onInit() {
		LOG.debug("========> Iniciando Configuracion Afirme NET <========");
		try{
			configuraConstantes();
		}catch(Exception e){
			LOG.debug("Ocurrio un error al inciar la configuracion de afirmenet: " + e.getMessage());
			LOG.error("Ocurrio un error al inciar la configuracion ", e);
		}
		LOG.debug("========> Termina Configuracion Afirme NET <========");
	}

	/**
	 * Metodo auxiliar de configuracion
	 */
	private void configuraConstantes() throws Exception{

		AfirmeNetConstants.setPersonasConfig(configuracionService.getConfiguracionesMap(Aplicacion.AFIRMENET_PERSONAS));
		AfirmeNetConstants.setPropertiesConfig(propertyService.getConfiguracionesMap());
		AfirmeNetConstants.holidayList = configuracionService.getDiasFeriados();
		AfirmeNetConstants.errores = configuracionService.getErrores();
		AfirmeNetConstants.bankList = configuracionService.getBANList();
		AfirmeNetConstants.plazaList = configuracionService.getPlazas();
		AfirmeNetConstants.horarios = configuracionService.getHorarios();
		
		LOG.debug("Total de configuracionesencontradas ========>"
				+ AfirmeNetConstants.getPersonasConfig().size());
		LOG.debug("<======== Inicia Configuracion de Constantes de Socktes ========>");
		LOG.debug("IP ========>"
				+ AfirmeNetConstants.getValorConfigPersonas(
						ConfigPersonas.SOCKET_IP, String.class));
		LOG.debug("PUERTO ====>"
				+ AfirmeNetConstants.getValorConfigPersonas(
						ConfigPersonas.SOCKET_PUERTO, Integer.class));
		LOG.debug("PUERTO_E ==>"
				+ AfirmeNetConstants.getValorConfigPersonas(
						ConfigPersonas.SOCKET_PUERTO_E, Integer.class));
		LOG.debug("SUMARY ====>"
				+ AfirmeNetConstants.getValorConfigPersonas(
						ConfigPersonas.SOCKET_PORT_SUMARY, Integer.class));
		LOG.debug("TIMEOUT ===>"
				+ AfirmeNetConstants.getValorConfigPersonas(
						ConfigPersonas.SOCKET_TIMEOUT, Integer.class));

		AfirmeNetConstants.SOCKET_IP = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.SOCKET_IP, String.class);
		AfirmeNetConstants.SOCKET_PUERTO = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.SOCKET_PUERTO,
						Integer.class);
		AfirmeNetConstants.SOCKET_PUERTO_E = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.SOCKET_PUERTO_E,
						Integer.class);
		AfirmeNetConstants.SOCKET_PORT_SUMARY = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.SOCKET_PORT_SUMARY,
						Integer.class);
		AfirmeNetConstants.SOCKET_TIMEOUT = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.SOCKET_TIMEOUT,
						Integer.class);
		
		AfirmeNetConstants.SSL_SOCKET_IP = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.SSL_SOCKET_IP,String.class);
		AfirmeNetConstants.SSL_SOCKET_PUERTO = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.SSL_SOCKET_PUERTO, Integer.class);
		AfirmeNetConstants.SSL_CERNUM = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.SSL_CERNUM, String.class);
		
		LOG.debug("<======== Termina Configuracion de Constantes de Socktes ========>");
		LOG.debug("<======== Inicia Configuracion de Constantes de OTP ========>");
		AfirmeNetConstants.OTP_ACE_SERVER_IP = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.RSA_OTP_IP);
		AfirmeNetConstants.OTP_PORT = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.RSA_OTP_PORT,
						Integer.class);
		AfirmeNetConstants.OTP_CONFIGPATH = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.RSA_OTP_RUTA_CONFIG);
		AfirmeNetConstants.OTP_VERBOSE = Boolean.valueOf(AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.RSA_OTP_VERBOSE));

		LOG.debug("OTP_ACE_SERVER_IP ===>"
				+ AfirmeNetConstants.OTP_ACE_SERVER_IP);
		LOG.debug("OTP_PORT ===>" + AfirmeNetConstants.OTP_PORT);
		LOG.debug("OTP_VERBOSE ===>" + AfirmeNetConstants.OTP_VERBOSE);
		LOG.debug("OTP_CONFIGPATH ===>" + AfirmeNetConstants.OTP_CONFIGPATH);
		LOG.debug("OTP_USUARIOS_ADMIN ===>"
				+ AfirmeNetConstants.OTP_USUARIOS_ADMIN.size());
		LOG.debug("OTP_PASSWORDS_ADMIN ===>"
				+ AfirmeNetConstants.OTP_PASSWORDS_ADMIN.size());

		AfirmeNetConstants.OTP_NUMERO_USUARIOS = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.RSA_OTP_NUM_USUARIOS,
						Integer.class);
		configuraUsuariosOTP();

		LOG.debug("<======== Termina Configuracion de Constantes de OTP ========>");
		AfirmeNetConstants.JAVA_PATH = AfirmeNetWebConstants.JAVA_PATH;
		LOG.debug("JAVA_PATH ===>" + AfirmeNetConstants.JAVA_PATH);
		AfirmeNetConstants.configuracionCargada = true;
	}

	private void configuraUsuariosOTP() {
		for (int i = 1; i <= AfirmeNetConstants.OTP_NUMERO_USUARIOS; i++) {

			String rsaUsr = "RSA_OTP_USR_ADMIN".concat(String.valueOf(i));
			AfirmeNetConstants.OTP_USUARIOS_ADMIN.add(AfirmeNetConstants
					.getValorConfigPersonas(ConfigPersonas.valueOf(rsaUsr)));

			String rsaPwd = "RSA_OTP_PWD_ADMIN".concat(String.valueOf(i));
			AfirmeNetConstants.OTP_PASSWORDS_ADMIN.add(AfirmeNetConstants
					.getValorConfigPersonas(ConfigPersonas.valueOf(rsaPwd)));
		}
	}
}
