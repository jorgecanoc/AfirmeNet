package com.afirme.afirmenet.service.impl.acceso;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.OTPDao;
import com.afirme.afirmenet.dao.acceso.UserDao;
import com.afirme.afirmenet.dao.impl.acceso.OTPDaoImpl;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.service.acceso.OTPAdminService;
import com.afirme.afirmenet.service.acceso.OTPAgenteService;
import com.afirme.afirmenet.service.mail.MailService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.rsa.authagent.authapi.AuthAgentException;
import com.rsa.authagent.authapi.AuthSession;
import com.rsa.authagent.authapi.AuthSessionFactory;

@Service
public class OTPAgenteServiceImpl implements OTPAgenteService {
	
	static final Logger LOG = LoggerFactory.getLogger(OTPDaoImpl.class);

	@Autowired
	private OTPDao otpDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OTPAdminService adminOTP;
	@Autowired
	private MailService mailService;

	public OTPAgenteServiceImpl() {}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Object> verificaPasscode(String userID, String codigoToken) {
		LOG.debug("Validando codigo: " + codigoToken + " de Token del Usuario: " + userID);
		ArrayList resultados = new ArrayList();
		boolean listo = false;
		String errorDebug = "";
		String errorUsuario = "";
		String mail = null;

		String[] contratoUsuario = userID.split("_");
		String contrato = contratoUsuario[0];
		
		try {
			String configPath = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.RSA_OTP_RUTA_CONFIG, String.class) + "rsa_api.properties";
			LOG.debug("Usando CONFIG_PATH ==> " + configPath);
			
			AuthSessionFactory api = AuthSessionFactory.getInstance(configPath);
			AuthSession authSession = api.createUserSession();
			int status = authSession.check(userID, codigoToken);
			
			switch (status) {
			case AuthSession.ACCESS_OK:
				listo = true;
				break;
			case AuthSession.ACCESS_DENIED:
				
				errorDebug = "ACCESS_DENIED";
				errorUsuario = "Acceso negado, verifique que escriba correctamente su Clave Dinámica y que está usando el Token correcto, intente de nuevo por favor.";
				
				String serial = otpDao.obtenToken(contrato);
				// se vuelve a checar el token para el envio del mail
				ArrayList result = (ArrayList) adminOTP.getInformacionToken(serial);
				if (((Boolean) result.get(0)).booleanValue() == true) {
					if (result.get(3) != null) {
						// se asigna la lista
						List tokenInfo = (List) result.get(3);
						// si es 15 entonces el token esta bloqueado
						String bloqueado = tokenInfo.get(15).toString();
						if (!bloqueado.equals("0")) {
							LOG.error("Su Token se encuentra bloqueado, sincronize su Token para poder usarlo con normalidad.");
							mail = userDao.getMailUsuario(contrato);
							enviarCorreoTokenBloq(mail, contrato, serial);
							LOG.error("verificaPasscode::envioMailTokenBloqueado");
						}
					}
				}
				break;
			case AuthSession.NEW_PIN_REQUIRED:
				errorDebug = "NEW_PIN_REQUIRED";
				errorUsuario = "Su Token se encuentra en una modalidad incorrecta (PINREQ), repórtelo al Call Center";
				break;
			case AuthSession.NEXT_CODE_REQUIRED:
				errorDebug = "NEXT_CODE_REQUIRED";
				errorUsuario = "Su Token se encuentra bloqueado, sincronize su Token para poder usarlo con normalidad.";
				break;
			default:
				errorDebug = "Estatus no validado";
				errorUsuario = "Su Clave Dinámica no puede ser validada debido a un estatus inválido del Token, repórtelo al Call Center.";
				break;
			}

			authSession.close();
			api.shutdown();

		} catch (AuthAgentException ex) {
			errorDebug = ex.getMessage();
			errorUsuario = "Existe un error de comunicación al intentar validar el token, repórtelo al Call Center.";
			LOG.error("Error Agente en JBAgenteOTP.verificaPasscode : " + errorDebug);
			ex.printStackTrace();
		} catch (Exception e) {
			errorDebug = e.getMessage();
			errorUsuario = "La validación de su Clave Dinámica tuvo un error, repórtelo al Call Center.";
			LOG.error("Error en JBAgenteOTP.verificaPasscode : " + errorDebug);
		}
		// listo=true;
		resultados.add(new Boolean(listo));
		resultados.add(errorDebug);
		resultados.add(errorUsuario);
		
		LOG.error("OTPAgenteService - Error: " + errorDebug);
		LOG.error("OTPAgenteService - Descripcion Error: " + errorUsuario);
		
		return resultados;
	}
	
	private void enviarCorreoTokenBloq(String mailDestino, String contrato, String serial) {
		try {
			mailService.sendAlertaTokenBloq(mailDestino, contrato, serial);
		} catch (MessagingException e) {
			LOG.error("Error al enviar el correo - JSPEmailChange.java " + e);
		}
	}

}
