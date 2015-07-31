package com.afirme.afirmenet.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.enums.ConfigProperties;

/**
 * Clase que agrupa las contantes a utilizar por afirmenet
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class AfirmeNetConstants {

	static final Logger LOG = LoggerFactory.getLogger(AfirmeNetConstants.class);

	public static boolean configuracionCargada = false;
	public static final String customnCompleteDateFormat = null;

	private static Map<String, Object> personasConfig = new HashMap<String, Object>();
	private static Map<String, Object> empresasConfig = new HashMap<String, Object>();
	private static Map<String, Object> propertiesConfig = new HashMap<String, Object>();

	// Inicia constantes para Sockets;
	public static String SOCKET_IP = "";
	public static int SOCKET_PUERTO = 0;
	public static int SOCKET_PUERTO_E = 0;
	public static int SOCKET_PORT_SUMARY = 0;
	public static int SOCKET_TIMEOUT = 0;
	
	// Inicia constantes para Sockets de Timbrado ;
	public static String SSL_SOCKET_IP = "";
	public static int SSL_SOCKET_PUERTO = 0;
	public static String SSL_CERNUM = "";
	
	public static String AS400_LIBRARY="AFICYFILES.";

	// Termina constantes para Sockets;
	
	// Path de ubicacion para Beans
	public static String JAVA_PATH = "";
	
	// Inicia constantes para OTP;
	public static String OTP_ACE_SERVER_IP = "";
	public static int OTP_PORT = 0;
	public static String OTP_CONFIGPATH= "";
	public static boolean OTP_VERBOSE = false;
	public static List<String> OTP_USUARIOS_ADMIN = new ArrayList<String>(0);
	public static List<String> OTP_PASSWORDS_ADMIN = new ArrayList<String>(0);	
	public static int OTP_NUMERO_USUARIOS = 0;
	
	//Lista Constante de Dias Feriados
	public static List<?> holidayList;
	//Mapa de codigos de error y descripciones
	public static Map<Integer, String> errores = new HashMap<Integer, String>();
	//Lista de Bancos
	public static List<?> bankList;
	//Lista de Plazas
	public static List<?> plazaList;	
	
	@SuppressWarnings("rawtypes")
	public static Map horarios = new HashMap();
	
	/**
	 * Metodo que obtiene el valor definido en el mapa personasConfig de acuerdo
	 * a la llave proporcionada, si no encuentra valor retornara null
	 * 
	 * @param key
	 *            la llave a localizar
	 * @return
	 * @return el valor encontrado
	 */
	public static <T> T getValorConfigPersonas(ConfigPersonas configuracion,
			Class<T> type) {
		LOG.debug("Obteniendo valor de Configuracion: " + configuracion
				+ " de tipo: " + type.getName());
		try {
			if (personasConfig.containsKey(configuracion.getValor())) {
				if (type.getName().equals("java.lang.Integer")) {
					return type.cast(Integer.parseInt(String
							.valueOf(personasConfig.get(configuracion
									.getValor()))));
				} else {
					return type.cast(personasConfig.get(configuracion
							.getValor()));
				}

			}
		} catch (Exception e) {
			LOG.error("Error al tratar de obtener la configuracion: "
					+ configuracion + " de tipo: " + type.getName());
		}
		return null;

	}

	/**
	 * Metodo que obtiene el valor definido en el mapa personasConfig de acuerdo
	 * a la llave proporcionada, si no encuentra valor retornara null
	 * 
	 * @param key
	 *            la llave a localizar
	 * @return el valor encontrado
	 */
	public static String getValorConfigPersonas(ConfigPersonas config) {
		return getValorConfigPersonas(config, String.class);
	}

	/**
	 * @return the personasConfig
	 */
	public static Map<String, Object> getPersonasConfig() {
		return personasConfig;
	}

	/**
	 * @param personasConfig
	 *            the personasConfig to set
	 */
	public static void setPersonasConfig(Map<String, Object> personasConfig) {
		AfirmeNetConstants.personasConfig = personasConfig;
	}

	/**
	 * @return the empresasConfig
	 */
	public static Map<String, Object> getEmpresasConfig() {
		return empresasConfig;
	}

	/**
	 * @param empresasConfig
	 *            the empresasConfig to set
	 */
	public static void setEmpresasConfig(Map<String, Object> empresasConfig) {
		AfirmeNetConstants.empresasConfig = empresasConfig;
	}
	
	/**
	 * @return the propertiesConfig
	 */
	public static Map<String, Object> getPropertiesConfig() {
		return propertiesConfig;
	}

	/**
	 * @param propertiesConfig the propertiesConfig to set
	 */
	public static void setPropertiesConfig(Map<String, Object> propertiesConfig) {
		AfirmeNetConstants.propertiesConfig = propertiesConfig;
	}
	
	/**
	 * Overload del metodo que obtiene el valor definido en el mapa personasProperties 
	 * de acuerdo a la llave proporcionada, si no encuentra valor retornara null
	 * 
	 * @param key la llave a localizar
	 * @return
	 * @return el valor encontrado
	 */
	public static <T> T getValorConfigProperties(ConfigProperties configuracion, Class<T> type) {
		LOG.debug("Obteniendo valor de ConfigProperties: " + configuracion + " de tipo: " + type.getName());
		try {
			if (propertiesConfig.containsKey(configuracion.getValor())) {
				if (type.getName().equals("java.lang.Integer")) {
					return type.cast(Integer.parseInt(String.valueOf(propertiesConfig.get(configuracion.getValor()))));
				} else {
					return type.cast(propertiesConfig.get(configuracion.getValor()));
				}
			}
		} catch (Exception e) {
			LOG.error("Error al tratar de obtener la configuracion: " + configuracion + " de tipo: " + type.getName());
		}
		return null;

	}

	/**
	 * Overload del metodo que obtiene el valor definido en el mapa personasConfig 
	 * de acuerdo a la llave proporcionada, si no encuentra valor retornara null
	 * 
	 * @param key la llave a localizar
	 * @return el valor encontrado
	 */
	public static String getValorConfigProperties(ConfigProperties config) {
		return getValorConfigProperties(config, String.class);
	}

}
