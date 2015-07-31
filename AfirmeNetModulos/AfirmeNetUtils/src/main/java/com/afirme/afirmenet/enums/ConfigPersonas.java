package com.afirme.afirmenet.enums;

/**
 * Enumerador que almacena todas las configuraciones validas y almacenadas en el
 * mapa de configuraciones por aplicacion
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public enum ConfigPersonas {
	SOCKET_IP("ip"), 
	SOCKET_PUERTO("port1"), 
	SOCKET_PORT_SUMARY("portSummary"), 
	SOCKET_PUERTO_E("portE"), 
	SOCKET_TIMEOUT("timeout"),
	KEY_PRIVADA("rutaLLavePrivada"),
	KEY_PUBLICA("rutaLLavePublica"),
	KEY_BANCO("llaveBancaria"),
	KEY_BANCO_MD5("llaveBancoMD5"),
	JDBC_LIBNAME("libname"),
	CAMPANIAS_IMG_URL("urlForImages"),
	GENERAL_PAQ_SIN_TOKEN("paquetesSinToken"),
	RSA_OTP_IP("ACEServerIP"),
	RSA_OTP_PORT("ACEServerPort"),
	RSA_OTP_RUTA_CONFIG("OTPRutaConfig"),
	RSA_OTP_VERBOSE("OTPVerbose"),
	RSA_OTP_NUM_USUARIOS("OTPnumUsuariosPasswords"),
	RSA_OTP_USR_ADMIN1("OTPLoginAdmin1"),
	RSA_OTP_PWD_ADMIN1("OTPPWDAdmin1"),
	RSA_OTP_USR_ADMIN2("OTPLoginAdmin2"),
	RSA_OTP_PWD_ADMIN2("OTPPWDAdmin2"),
	RSA_OTP_USR_ADMIN3("OTPLoginAdmin3"),
	RSA_OTP_PWD_ADMIN3("OTPPWDAdmin3"),
	RSA_OTP_USR_ADMIN4("OTPLoginAdmin4"),
	RSA_OTP_PWD_ADMIN4("OTPPWDAdmin4"),
	RSA_OTP_USR_ADMIN5("OTPLoginAdmin5"),
	RSA_OTP_PWD_ADMIN5("OTPPWDAdmin5"),
	RSA_OTP_USR_ADMIN6("OTPLoginAdmin6"),
	RSA_OTP_PWD_ADMIN6("OTPPWDAdmin6"),
	RSA_OTP_USR_ADMIN7("OTPLoginAdmin7"),
	RSA_OTP_PWD_ADMIN7("OTPPWDAdmin7"),
	RSA_OTP_USR_ADMIN8("OTPLoginAdmin8"),
	RSA_OTP_PWD_ADMIN8("OTPPWDAdmin8"),
	RSA_OTP_USR_ADMIN9("OTPLoginAdmin9"),
	RSA_OTP_PWD_ADMIN9("OTPPWDAdmin9"),
	RSA_OTP_USR_ADMIN10("OTPLoginAdmin10"),
	RSA_OTP_PWD_ADMIN10("OTPPWDAdmin10"),
	RSA_OTP_USR_ADMIN11("OTPLoginAdmin11"),
	RSA_OTP_PWD_ADMIN11("OTPPWDAdmin11"),
	RSA_OTP_USR_ADMIN12("OTPLoginAdmin12"),
	RSA_OTP_PWD_ADMIN12("OTPPWDAdmin12"),
	RSA_OTP_USR_ADMIN13("OTPLoginAdmin13"),
	RSA_OTP_PWD_ADMIN13("OTPPWDAdmin13"),
	RSA_OTP_USR_ADMIN14("OTPLoginAdmin14"),
	RSA_OTP_PWD_ADMIN14("OTPPWDAdmin14"),
	RSA_OTP_USR_ADMIN15("OTPLoginAdmin15"),
	RSA_OTP_PWD_ADMIN15("OTPPWDAdmin15"),
	RSA_OTP_USR_ADMIN16("OTPLoginAdmin16"),
	RSA_OTP_PWD_ADMIN16("OTPPWDAdmin16"),
	RSA_OTP_USR_ADMIN17("OTPLoginAdmin17"),
	RSA_OTP_PWD_ADMIN17("OTPPWDAdmin17"),
	RSA_OTP_USR_ADMIN18("OTPLoginAdmin18"),
	RSA_OTP_PWD_ADMIN18("OTPPWDAdmin18"),
	RSA_OTP_USR_ADMIN19("OTPLoginAdmin19"),
	RSA_OTP_PWD_ADMIN19("OTPPWDAdmin19"),
	RSA_OTP_USR_ADMIN20("OTPLoginAdmin20"),
	RSA_OTP_PWD_ADMIN20("OTPPWDAdmin20"),
	INOUT("N"),
	EMAIL_SERVER("emailserver"),
	EMAIL_MUEMAIL("muemail"),
	EMAIL_CCEMAIL("ccemail"),
	SSL_SOCKET_IP("sgip"), 
	SSL_SOCKET_PUERTO("sdPort"), 	
	SSL_CERNUM("cernum")
	;

	ConfigPersonas(String valor) {
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
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
}
