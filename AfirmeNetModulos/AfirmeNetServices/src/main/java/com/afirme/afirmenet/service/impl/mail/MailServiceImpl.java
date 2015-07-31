package com.afirme.afirmenet.service.impl.mail;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.config.PropertyDao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.service.mail.MailService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.mail.JBSendEmail;

@Service
public class MailServiceImpl implements MailService {
	
	static final Logger LOG = LoggerFactory
			.getLogger(MailServiceImpl.class);	
	@Autowired
	PropertyDao propertyDao;

	private JBSendEmail mailUtil = new JBSendEmail();

	private final String HEADER_CLIENT = "Estimado Cliente:";

	public MimeMultipart getMultipart(StringBuffer sb, String path) {
		MimeMultipart multipart = new MimeMultipart("related");
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		// String tagImgHTML = "<img src=\"cid:image\">";
		String htmlText = sb.toString();
		try {
			messageBodyPart.setContent(htmlText, "text/html; charset=ISO-8859-1");
			// add it
			multipart.addBodyPart(messageBodyPart);
			// second part (the image)
			// messageBodyPart = new MimeBodyPart();
			// DataSource fds = new FileDataSource(path);
			// messageBodyPart.setDataHandler(new DataHandler(fds));
			// messageBodyPart.setHeader("Content-ID","<image>");
			// add it
			// multipart.addBodyPart(messageBodyPart);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		// put everything together
		return multipart;
	}

	/**
	 * Envia un correo al usuario de AfirmeNet cuando se sincroniza exitosamente
	 * el token
	 */
	public void sendAlertaSincrTok(String mailDestino, String contrato, String noserie) throws MessagingException {
		try {
			
			String host = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.EMAIL_SERVER);
			String from = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.EMAIL_MUEMAIL);
			String to = mailDestino;

			String sub = "Notificacion Sincronizacion Token por AfirmeNet";
			StringBuffer sb = new StringBuffer();
			sb.append(HEADER_CLIENT);
			sb.append("<br>");
			sb.append("<br>");
			sb.append("Le informamos que su token con numero serial " + noserie + " del contrato ");
			sb.append(contrato);
			sb.append(" ha sido activado de forma correcta. Este se encontraba bloqueado de forma temporal por haber intentado ingresarlo con claves invalidas o por falta de uso.");
			sb.append("<br>");
			sb.append("<br>");
			sb.append("Esperamos esta informacion sea de su utilidad.");
			sb.append("<br>");
			sb.append("<br>");
			sb.append("Para facilitar la lectura del presente mensaje, se eliminaron los acentos.");

			MimeMultipart multipart = getMultipart(sb, "");
			String error = mailUtil.getSendEmailMultipart(host, to, from, sub, multipart);
			if (!error.equals(""))
				throw new MessagingException(error);
		} catch (MessagingException me) {
			LOG.debug(me.getMessage());
			throw new MessagingException(me.getMessage());
		}
	}

	/**
	 * Envia un correo al usuario de AfirmeNet cuando se bloquea el token por
	 * exceder el numero de intentos fallidos
	 */
	public void sendAlertaTokenBloq(String mailDestino, String contrato, String serial) throws MessagingException {
		try {
			
			String host = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.EMAIL_SERVER);
			String from = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.EMAIL_MUEMAIL);
			String to = mailDestino;

			String sub = "Notificacion Token Bloqueado por AfirmeNet";
			StringBuffer sb = new StringBuffer();
			sb.append(HEADER_CLIENT);
			sb.append("<br>");
			sb.append("<br>");
			sb.append("Le informamos que el token con serial ");
			sb.append(serial);
			sb.append(" de su contrato ");
			sb.append(contrato);
			sb.append(" ha sido bloqueado de forma temporal debido a que se intento utilizarlo con claves incorrectas.");
			sb.append("<br>");
			sb.append("<br>");
			sb.append("Para desbloquear su token, favor de ir a AfirmeNet y en la pagina de ingreso donde debe de seleccionar la opcion \"Sincronicelo Aqui\".");
			sb.append("<br>");
			sb.append("<br>");
			sb.append("Para cualquier duda favor de comunicarse al Call Center sin costo al telefono 01 800 2 234763 desde cualquier lugar de la Republica Mexicana o desde el area metropolitana de la Cd. de Monterrey al 8318-3990.");
			sb.append("Esperamos esta informacion sea de su utilidad.");
			sb.append("<br>");
			sb.append("<br>");
			sb.append("Para facilitar la lectura del presente mensaje, se eliminaron los acentos.");

			MimeMultipart multipart = getMultipart(sb, "");
			String error = mailUtil.getSendEmailMultipart(host, to, from, sub,
					multipart);
			if (!error.equals(""))
				throw new MessagingException(error);
		} catch (MessagingException me) {
			LOG.debug(me.getMessage());
			throw new MessagingException(me.getMessage());
		}
	}

	/**
	 * Agrega al correo el mensaje de espera de tiempo al agregar una cuenta de terceros
	 * @param puntoFinal - Si se quiere un punto al final del mensaje o no
	 * @return
	 */
	public static String mostrarMsjEsperaCuentasMail(boolean puntoFinal) {
		/*
		ResourceBundle rb = ResourceBundle.getBundle("general");
		String mensajeEspera = rb.getString("third.accounts.add.mail.message");

		String msj = mensajeEspera
				+ " "
				+ obtenerTiempoEspera(JOProperty.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
		return puntoFinal ? msj + "." : msj;
		*/
		return null;
	}
}
