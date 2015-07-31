package com.afirme.afirmenet.service.impl.acceso;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.impl.acceso.OTPDaoImpl;
import com.afirme.afirmenet.service.acceso.OTPAdminService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

import rsa.ace.pso.admin.PsoAceAdmin;
import rsa.ace.pso.admin.PsoAceAdminException;

@Service
public class OTPAdminServiceImpl implements OTPAdminService {

	static final Logger LOG = LoggerFactory.getLogger(OTPDaoImpl.class);

	public OTPAdminServiceImpl() {
	}

	private synchronized ArrayList<Object> getAdmin() {
		
		int indice = 0;
		
		ArrayList<Object> datAdmin = new ArrayList<Object>();
		try {
			String adminLogin = (String) AfirmeNetConstants.OTP_USUARIOS_ADMIN.get(indice);
			String adminPwd = (String) AfirmeNetConstants.OTP_PASSWORDS_ADMIN.get(indice);
			datAdmin.add(adminLogin);
			datAdmin.add(adminPwd);
			
			LOG.debug("RSA AdminUser Index ==> " + (indice));
			LOG.debug("RSA AdminUser User ==> " + AfirmeNetConstants.OTP_USUARIOS_ADMIN.get((indice)));
			LOG.debug("RSA AdminUser Password ==> " + AfirmeNetConstants.OTP_PASSWORDS_ADMIN.get((indice)));
			
			indice++;
			if (indice > AfirmeNetConstants.OTP_NUMERO_USUARIOS - 1)
				indice = 0;
		} catch (Exception e) {
			LOG.error("Error en JBAdminOTP.getAdmin : " + e);
		}
		return datAdmin;
	}

	@SuppressWarnings("unchecked")
	private List<Object> inicializaSesion() {
		LOG.debug("OTPAdminService - Iniciando Sesión.");
		
		ArrayList<Object> datos = new ArrayList<Object>();
		boolean listo = false;
		String texto = "";
		PsoAceAdmin psoAdmin = null;
		String userAdminOTP = "";
		try {
			psoAdmin = new PsoAceAdmin();
			
			LOG.debug("ACE Server IP: " + AfirmeNetConstants.OTP_ACE_SERVER_IP);
			LOG.debug("Puerto : " + AfirmeNetConstants.OTP_PORT);
			LOG.debug("Config Path: " + AfirmeNetConstants.OTP_CONFIGPATH);
			LOG.debug("Verbose: " + AfirmeNetConstants.OTP_VERBOSE);
			
			psoAdmin.startAdminSession(
					AfirmeNetConstants.OTP_ACE_SERVER_IP,
					AfirmeNetConstants.OTP_PORT,
					AfirmeNetConstants.OTP_CONFIGPATH,
					AfirmeNetConstants.OTP_VERBOSE);

			ArrayList<Object> datAdmin = getAdmin();
			userAdminOTP = (String) datAdmin.get(0);

			psoAdmin.SD_Login(userAdminOTP);
			List<Object> respuesta = psoAdmin.SD_SendPasscode((String) datAdmin.get(1));
			
			if (respuesta.size() > 1) {
				int code = ((Integer) respuesta.get(0)).intValue();
				String mensaje = ((StringBuffer) respuesta.get(1)).toString();
				switch (code) {
				case PsoAceAdmin.ACE_ACCESSOK:
					listo = true;
					texto = "Login exitoso al Admin.";
					LOG.debug("Login exitoso.");
					break;
				case PsoAceAdmin.ACE_ACCESSDENIED:
					texto = "Acceso Denegado: " + mensaje;
					LOG.debug("Acceso Denegado" + mensaje);
					break;
				case 0:
					texto = "Error de comunicacion en login: " + mensaje;
					LOG.debug("Error de comunicacion en login: " + mensaje);
					break;
				default:
					texto = "Estatus no contemplado, mensaje: " + mensaje;
					LOG.debug("Estatus no contemplado, mensaje: " + mensaje);
					break;
				}
			} else {
				texto = "Login sin respuesta del tamaño correcto.";
				LOG.error("No se pudo inicializar la sesion del Admin de OTPs (" + userAdminOTP + "): " + texto);
				LOG.error("Tamaño Respuesta=" + respuesta.size());
				if (respuesta.size() == 1)
					LOG.error("Dato 1=" + ((Integer) respuesta.get(0)).intValue());
			}
		} catch (Exception e) {
			texto = "No se pudo inicializar la sesion del Admin de OTPs: " + e;
			LOG.error("JBAdminOTP.inicializaSesion:: No se pudo inicializar la sesion del Admin de OTPs (" + userAdminOTP + "): " + e);
		}
		datos.add(new Boolean(listo));
		datos.add(texto);
		LOG.debug("OTPAdminService - inicializaSesion(): " + texto);
		if (listo == true)
			datos.add(psoAdmin);
		return datos;
	}

	private boolean finalizaSesion(PsoAceAdmin psoAdmin) {
		boolean listo = false;
		try {
			psoAdmin.closeConnection();
			listo = true;
		} catch (Exception e) {
			LOG.error("No se pudo finalizar la sesion del Admin de OTPs " + e);
		}
		return listo;
	}

	public List<Object> creaUsuario(String nombre, String apellido, String userID) {
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				psoAdmin.SD_AddUser(nombre, apellido, userID, "");
				listo = true;
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_AddUser Error User already in db"))
				errorUsuario = "Error: El usuario ya existe.";
			else if (errorDebug.equals("Sd_AddUser Error Invalid login/last name"))
				errorUsuario = "Error: El apellido o el id de usuario no deben estar en blanco.";
			else
				errorUsuario = "Error al crear el usuario (PSO).";
			LOG.error("Error PSO en JBAdminOTP.creaUsuario : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Error genérico al crear el usuario.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.creaUsuario : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		return resultados;
	}

	public List<Object> eliminaUsuario(String userID) {
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				psoAdmin.SD_DeleteUser(userID, PsoAceAdmin.ID_USER_ID);
				listo = true;
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_DeleteUser Error Invalid user"))
				errorUsuario = "Error: El usuario no existe.";
			else
				errorUsuario = "Error al eliminar el usuario (PSO).";
			LOG.error("Error PSO en JBAdminOTP.eliminaUsuario : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Error genérico al eliminar el usuario.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.eliminaUsuario : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		return resultados;
	}

	public List<Object> asignaTokenUsuario(String serial, String userID) {
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				psoAdmin.SD_AssignToken(serial, userID, PsoAceAdmin.ID_USER_ID);
				listo = true;
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_AssignAnotherToken Error Invalid user"))
				errorUsuario = "Error: El usuario no existe.";
			else if (errorDebug.equals("Sd_AssignAnotherToken Error Invalid token"))
				errorUsuario = "Error: El Token no existe.";
			else if (errorDebug.equals("Sd_AssignAnotherToken Error Token is already assigned"))
				errorUsuario = "Error: El Token ya esta asignado a un usuario.";
			else
				errorUsuario = "Error al asignar el Token al usuario (PSO).";
			LOG.error("Error PSO en JBAdminOTP.asignaTokenUsuario : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Error genérico al asignar el Token al usuario.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.asignaTokenUsuario : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		return resultados;
	}

	public List<Object> desasignaTokenUsuario(String serial) {
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				psoAdmin.SD_UnassignToken(serial);
				listo = true;
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_RescindToken Error Invalid token"))
				errorUsuario = "Error: El Token no existe.";
			else
				errorUsuario = "Error al desasignar el Token al usuario (PSO).";
			LOG.error("Error PSO en JBAdminOTP.desasignaTokenUsuario : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Error genérico al desasignar el Token al usuario.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.desasignaTokenUsuario : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		return resultados;
	}

	public List<Object> habilitaToken(String serial) {
		LOG.debug("OTPAdminService - Habilitando Token");
		
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				psoAdmin.SD_EnableToken(serial);
				listo = true;
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_EnableToken Error Invalid token"))
				errorUsuario = "Su Token no pudo ser activado, el Token no existe.";
			else if (errorDebug.equals("Sd_EnableToken Error Token is not assigned"))
				errorUsuario = "Su Token no pudo ser activado, el Token no está asignado a un usuario.";
			else
				errorUsuario = "Su Token no pudo ser activado (PSO), por favor intente de nuevo.";
			LOG.error("Error PSO en JBAdminOTP.habilitaToken : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Su Token no pudo ser activado, por favor intente de nuevo.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.habilitaToken : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		return resultados;
	}

	public List<Object> deshabilitaToken(String serial) {
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				psoAdmin.SD_DisableToken(serial);
				listo = true;
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_DisableToken Error Invalid token"))
				errorUsuario = "Error: El Token no existe.";
			else if (errorDebug.equals("Sd_DisableToken Error Token is not assigned"))
				errorUsuario = "Error: El Token no esta asignado a un usuario.";
			else
				errorUsuario = "Error al deshabilitar el Token (PSO).";
			LOG.error("Error PSO en JBAdminOTP.deshabilitaToken : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Error genérico al deshabilitar el Token.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.deshabilitaToken : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		return resultados;
	}

	public List<Object> sincronizaToken(String serial, String codigoToken1, String codigoToken2) {
		LOG.debug("OTPAdminService - Sincronizando Token");
		
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				psoAdmin.SD_Resync(serial, codigoToken1, codigoToken2);
				listo = true;
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_Resync Error Failed to lock token"))
				errorUsuario = "Su Token no pudo ser sincronizado, el Token no existe, repórtelo al Call Center.";
			else if (errorDebug.equals("Sd_Resync Error Invalid token-code"))
				errorUsuario = "Su Token no pudo ser sincronizado, su primer Clave Dinámica es incorrecto, verifique que escriba correctamente su Clave Dinámica y que está usando el Token correcto, por favor intente de nuevo.";
			else if (errorDebug.startsWith("Failed to resync token"))
				errorUsuario = "Su Token no pudo ser sincronizado, su segundo Clave Dinámica es incorrecto, verifique que escriba correctamente su Clave Dinámica, por favor intente de nuevo.";
			else
				errorUsuario = "Su Token no pudo ser sincronizado (PSO), por favor intente de nuevo.";
			LOG.error("Error PSO en JBAdminOTP.sincronizaToken : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Su Token no pudo ser sincronizado, por favor intente de nuevo.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.sincronizaToken : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		
		LOG.debug("OTPAdminService - sincronizaToken / errores: " + errorDebug);
		LOG.debug("OTPAdminService - sincronizaToken / descripcion: " + errorUsuario);
		return resultados;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getInformacionToken(String serial) {
		LOG.debug("OTPAdminService - Obteniendo información de Token");
		
		ArrayList<Object> resultados = new ArrayList<Object>();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		boolean pso = false;
		PsoAceAdmin psoAdmin = null;
		List<Object> datosToken = null;
		try {
			ArrayList<Object> datos = (ArrayList<Object>) inicializaSesion();
			if (((Boolean) datos.get(0)).booleanValue() == true) {
				psoAdmin = (PsoAceAdmin) datos.get(2);
				pso = true;
				datosToken = psoAdmin.SD_ListTokenInfo(serial);
				listo = true;
				LOG.debug("OTPAdminService - Información recaudada exitosamente.");
			} else {
				errorDebug = (String) datos.get(1);
				errorUsuario = "Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.";
				LOG.debug("Error: Existe una falla de comunicación con el servidor de Tokens, favor de reportarlo al Call Center.");
			}
		} catch (PsoAceAdminException ex) {
			errorDebug = ex.getMessage().trim();
			if (errorDebug.equals("Sd_ListTokenInfo Error Invalid token"))
				errorUsuario = "Error: No se pudo obtener información del Token, el token no existe.";
			else
				errorUsuario = "Error al obtener información del Token (PSO).";
			LOG.error("Error PSO en JBAdminOTP.getInformacionToken : " + errorDebug);
		} catch (Exception e) {
			errorUsuario = "Error genérico al obtener información del Token.";
			errorDebug = e.getMessage();
			LOG.error("Error en JBAdminOTP.getInformacionToken : " + errorDebug);
		}
		if (pso == true)
			finalizaSesion(psoAdmin);
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		resultados.add(datosToken);
		
		LOG.error("OTPAdminService - getInformacionToken() / Errores: " + errorDebug);
		LOG.error("OTPAdminService - getInformacionToken() / Descripcion Errores: " + errorUsuario);
		return resultados;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> getEstadoToken(String serial) {
		ArrayList<Object> resultados = new ArrayList<Object>();
		resultados = (ArrayList<Object>) getInformacionToken(serial);
		if (((Boolean) resultados.get(0)).booleanValue() == true) {
			if (resultados.get(3) != null) {
				List<Object> tokenInfo = (List) resultados.get(3);
				String deshabilitado = tokenInfo.get(12).toString();
				if (deshabilitado.equals("0")) {
					resultados.clear();
					resultados.add(new Boolean(false));
					resultados.add("");
					resultados.add("Su Token esta deshabilitado, repórtelo al Call Center.");
				}
				String bloqueado = tokenInfo.get(15).toString();
				if (!bloqueado.equals("0")) {
					resultados.clear();
					resultados.add(new Boolean(false));
					resultados.add("");
					resultados.add("Su Token se encuentra bloqueado, sincronize su Token para poder usarlo con normalidad.");
				}
			}
		}
		return resultados;
	}

}