package com.afirme.afirmenet.service.impl.acceso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.ContratoDao;
import com.afirme.afirmenet.dao.acceso.OTPDao;
import com.afirme.afirmenet.dao.acceso.UserDao;
import com.afirme.afirmenet.dao.impl.acceso.OTPDaoImpl;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.ibs.objects.JOEncrypt;
import com.afirme.afirmenet.service.acceso.OTPService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.mail.JBSendEmail;

@Service
public class OTPServiceImpl implements OTPService {

	static final Logger LOG = LoggerFactory.getLogger(OTPDaoImpl.class);
	
	@Autowired
	private OTPDao otpDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ContratoDao contratoDao;

	@Override
	public boolean validaTokenXActivar(String contrato, String usuario, int serialToken, String codigoActivacion) {
		JOEncrypt encrypt = new JOEncrypt();
		return otpDao.validaTokenXActivar(contrato, usuario, serialToken, encrypt.getEncrypt(codigoActivacion));
	}
	
	@Override
	public String obtenToken(String contrato) {
		return otpDao.obtenToken(contrato);
	}

	@Override
	public boolean usaTokens(String contrato) {
		return otpDao.usaTokens(contrato);
	}

	@Override
	public boolean setCodigoSeguridad(String contrato, String usuario, String codigoSegEnc) {
		return otpDao.setCodigoSeguridad(contrato, usuario, codigoSegEnc);
	}

	@Override
	public boolean enviaMailCodigoSeguridad(String contrato) {
		LOG.debug("Realizando envío de Código de Seguridad del Contrato: " + contrato);
		
		// se obtiene mail de usuario
		String mailContrato = userDao.getMailUsuario(contrato);
		// se genera nuevo codigo de seguridad y se encripta
		String codigoSeg = Util.getRandom(10);
		JOEncrypt encrypt = new JOEncrypt();
		String codigoSegEncr = encrypt.getEncrypt(codigoSeg);
		
		// se actualiza el estatus del contrato
		if (!contratoDao.setStatus(contrato, "4")) {
			
			LOG.debug("Problemas al actualizar el estatus del contrato");
			LOG.error("Error: No se pudo regenerar su codigo de seguridad, intente de nuevo por favor.");
			
		} else {
			// se sustituye el codigo de seguridad actual por el nuevo encriptado 
			if (!otpDao.setCodigoSeguridad(contrato, contrato, codigoSegEncr)) {
				
				LOG.debug("Problemas al actualizar el codigo en la tabla de tokens");
				LOG.error("Error: No se pudo regenerar su codigo de seguridad, intente de nuevo por favor.");
				
			} else {
				
				char ch = 13; // New Line
				String to = mailContrato;
				String subject = "Regeneracion de Codigo de Seguridad";
				String msg = 
						"Para brindarle un mejor servicio, hemos quitado los acentos de este mensaje. Por su comprension gracias. "
						+ ch
						+ ch
						+ "Estimado Cliente, "
						+ ch
						+ "La solicitud de Regeneracion del Codigo de Seguridad para su Token de su contrato: "
						+ contrato
						+ " del sistema AfirmeNet, ha sido generada al contestar su pregunta secreta"
						+ " , el nuevo Codigo de Seguridad es: "
						+ codigoSeg
						+ ch
						+ "Para accesar al sistema AfirmeNet ingrese a la direccion www.afirme.com seleccione la banca Personas. "
						+ ch
						+ "Posteriormente en la pagina inicial de AfirmeNet dar clic en la primera opcion de Activacion.";
				
				JBSendEmail mailSender = new JBSendEmail();
				
				String host = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.EMAIL_SERVER, String.class);
				String from = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.EMAIL_MUEMAIL, String.class);

				if (mailSender.getSendEmail(host, to, from, subject, msg).equals("")) {
					
					return true;
					
				} else {
					
					LOG.debug("Problemas al enviar el correo.");
					LOG.error("Error: No se pudo regenerar su codigo de seguridad, intente de nuevo por favor.");
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean setFechaVencimiento(String serialToken, String fechaVencimiento) {
		return otpDao.setFechaVencimiento(serialToken, fechaVencimiento);
	}
}
