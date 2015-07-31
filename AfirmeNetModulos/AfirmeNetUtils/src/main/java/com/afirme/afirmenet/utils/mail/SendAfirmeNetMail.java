package com.afirme.afirmenet.utils.mail;

import java.io.StringWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

/**
 * Clase que permite realizar el envio de correos electronicos usando templates
 * definidos en Velocity
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class SendAfirmeNetMail {
	static final Logger LOG = LoggerFactory.getLogger(SendAfirmeNetMail.class);
	private VelocityEngine velocityEngine;
	private MessageSource emailSource;

	/**
	 * Metodo principal para realizar envio de correos electronicos
	 * 
	 * @param mailFrom
	 *            Mail aquien va dirigido el correo
	 * @param subject
	 *            el titulo del correo
	 * @param msg
	 *            contenido del correo, puede ser formato HTML o Texto
	 * @param mailAddressForCC
	 *            Lista de Destinatarios que se incluiran en copia
	 * @param mailAddressForTo
	 *            Lista de Destinatarios a quien va dirigido el correo
	 * @param attachment
	 *            si se requiere adjuntar un archivo se envia como arreglo de
	 *            bytes
	 * @param attachmentName
	 *            nombre del archivo adjunto
	 * @param contetTypeAttachment
	 *            tipo de contenido del archivo adjunto
	 * @throws AddressException
	 *             en caso de no proporciona una direccion valida de correo
	 * @throws MessagingException
	 *             en caso de que ocurra un error al realizar la conexion con el
	 *             servidor de correo
	 */
	public void sendMail(String mailFrom, String subject, String msg,
			Address[] mailAddressForCC, Address[] mailAddressForTo,
			byte[] attachment, String attachmentName,
			String contetTypeAttachment) throws AddressException,
			MessagingException {
		LOG.info("Sending Mail");
		Message message = new MimeMessage(initSession());

		LOG.debug("######   Mail Attributes   ######");
		LOG.debug(" 	mailFrom ===> " + mailFrom);
		LOG.debug(" 	subject ===> " + subject);
		LOG.debug(" 	mailAddressForCC ===> " + mailAddressForCC);
		LOG.debug(" 	mailAddressForTo ===> " + mailAddressForTo);
		LOG.debug(" 	attachmentName ===> " + attachmentName);
		LOG.debug(" 	contetTypeAttachment ===> " + contetTypeAttachment);
		LOG.debug("######   End Mail Attributes  ######");

		message.setFrom(new InternetAddress(mailFrom));
		message.addRecipients(Message.RecipientType.TO, mailAddressForTo);
		if (mailAddressForCC != null) {
			message.addRecipients(Message.RecipientType.CC, mailAddressForCC);
		}
		message.setSubject(subject);

		MimeMultipart content = new MimeMultipart("alternative");
		MimeBodyPart html = new MimeBodyPart();
		html.setContent(msg, "text/html");
		content.addBodyPart(html);
		if (StringUtils.isNotBlank(attachmentName) && attachment != null) {
			ByteArrayDataSource source = new ByteArrayDataSource(attachment,
					contetTypeAttachment);
			source.setName(attachmentName);
			html.setDataHandler(new DataHandler(source));
		}
		message.setContent(content);
		Transport.send(message);

		LOG.info("Sending Mail Done !!");
	}

	/**
	 * 
	 * @param mailFrom
	 *            Mail aquien va dirigido el correo
	 * @param subject
	 *            el titulo del correo
	 * @param msg
	 *            contenido del correo, puede ser formato HTML o Texto
	 * @param mailSeparedByCommaForTo
	 *            destinatarios separados por comma, puede ser 1 solo
	 *            destinatario
	 * @throws MessagingException
	 *             en caso de que ocurra un error al realizar la conexion con el
	 *             servidor de correo
	 */
	public void sendMail(String mailFrom, String subject, String msg,
			String mailSeparedByCommaForTo) throws MessagingException {
		this.sendMail(mailFrom, subject, msg, null, mailSeparedByCommaForTo);
	}

	/**
	 * 
	 * @param mailFrom
	 *            Mail aquien va dirigido el correo
	 * @param subject
	 *            el titulo del correo
	 * @param msg
	 *            contenido del correo, puede ser formato HTML o Texto
	 * @param mailSeparedByCommaForTo
	 *            destinatarios separados por comma, puede ser 1 solo
	 *            destinatario
	 * @param mailSeparedByCommaForCC
	 *            destinatarios separados por comma incluidos como copiados,
	 *            puede ser 1 solo destinatario
	 * @throws MessagingException
	 *             en caso de que ocurra un error al realizar la conexion con el
	 *             servidor de correo
	 */
	public void sendMail(String mailFrom, String subject, String msg,
			String mailSeparedByCommaForCC, String mailSeparedByCommaForTo)
			throws MessagingException {
		this.sendMail(mailFrom, subject, msg, mailSeparedByCommaForCC,
				mailSeparedByCommaForTo, null, null, null);
	}

	/**
	 * 
	 * @param mailFrom
	 *            Mail aquien va dirigido el correo
	 * @param subject
	 *            el titulo del correo
	 * @param msg
	 *            contenido del correo, puede ser formato HTML o Texto
	 * @param mailSeparedByCommaForTo
	 *            destinatarios separados por comma, puede ser 1 solo
	 *            destinatario
	 * @param mailSeparedByCommaForCC
	 *            destinatarios separados por comma incluidos como copiados,
	 *            puede ser 1 solo destinatario
	 * @param attachment
	 *            si se requiere adjuntar un archivo se envia como arreglo de
	 *            bytes
	 * @param attachmentName
	 *            nombre del archivo adjunto
	 * @param contetTypeAttachment
	 *            tipo de contenido del archivo adjunto
	 * @throws MessagingException
	 *             en caso de que ocurra un error al realizar la conexion con el
	 *             servidor de correo
	 */
	public void sendMail(String mailFrom, String subject, String msg,
			String mailSeparedByCommaForCC, String mailSeparedByCommaForTo,
			byte[] attachment, String attachmentName,
			String contetTypeAttachment) throws MessagingException {
		Address[] cc = null;

		if (mailSeparedByCommaForTo == null
				|| StringUtils.isEmpty(mailSeparedByCommaForTo)) {
			throw new IllegalArgumentException(
					"mailSeparedByCommaForTo no debe ser nulo");
		}
		if (mailFrom == null || StringUtils.isEmpty(mailFrom)) {
			throw new IllegalArgumentException("mailFrom no debe ser nulo");
		}
		if (!StringUtils.isEmpty(mailSeparedByCommaForCC)) {
			cc = InternetAddress.parse(mailSeparedByCommaForCC);
		}
		Address[] to = InternetAddress.parse(mailSeparedByCommaForTo);

		this.sendMail(mailFrom, subject, msg, cc, to, attachment,
				attachmentName, contetTypeAttachment);
	}

	/**
	 * Metodo que permite enviar un correo electronico mediante el uso de un
	 * objeto Wrapper {@link AfirmeNetMail} que contiene los atributos
	 * necesarios para el envio de un correo electronico mediante esta clase de
	 * utileria los campos que son requeridos y validados para el envio de un
	 * correo electronico son los siguientes:
	 * <ul>
	 * <li>mailTo: la direccion de correo a quien va dirigido el correo
	 * electronico</li>
	 * <li>mailContent: el contenido del correo electronico</li>
	 * <li>mailTemplate: el template del correo electronico {@link MailTemplate}
	 * <>
	 * <li>velocityAttributes: cada template provee una lista de atributos que
	 * debe llenarse para posteriormente elejir el template indicado y hacer un
	 * reemplazamiento de estos atributos con los valores proporcionados</li>
	 * </ul>
	 * 
	 * Para ver la prueba unitaria de este metodo ver
	 * {@link TestSendAfirmeNetMail}
	 * 
	 * @param mail
	 *            Objeto contenedor de atributos necesarios para el envio de un
	 *            correo electronico
	 * @throws MessagingException
	 *             en caso de que ocurra un error al realizar la conexion con el
	 *             servidor de correo
	 */
	public void sendMail(AfirmeNetMail mail) throws MessagingException {

		// Valida informacion basica del correo
		validate(mail);

		String message = "";
		if (!mail.getMailTemplate().equals(MailTemplate.PLAIN_TEXT)) {
			Template template = velocityEngine.getTemplate("templates/"
					+ mail.getMailTemplate().getNameTemplate() + ".vm");

			VelocityContext velocityContext = new VelocityContext(
					mail.getVelocityAttributes());
			StringWriter stringWriter = new StringWriter();
			template.merge(velocityContext, stringWriter);
			message = stringWriter.toString();
		} else {
			message = mail.getMailContent();
		}

		this.sendMail(mail.getMailFrom(), mail.getMailSubject(), message,
				mail.getMailTo());
	}

	/**
	 * Metodo que se ejecuta al iniciar el envio de un correo electronico y nos
	 * permite generar una session en el servidor outlook o Exchange
	 * 
	 * @return la session activa del servidor de correo
	 */
	private Session initSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host",
				emailSource.getMessage("hostName", null, null));
		props.put("mail.smtp.auth",
				emailSource.getMessage("smtpAut", null, null));
		props.put("mail.smtp.port", emailSource.getMessage("port", null, null));
		props.put("mail.smtp.socketFactory.port",
				emailSource.getMessage("port", null, null));
		props.put("mail.smtp.socketFactory.fallback",
				emailSource.getMessage("smtpAut", null, null));

		Session session = javax.mail.Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailSource
								.getMessage("userName", null, null),
								emailSource.getMessage("password", null, null));
					}
				});
		session.setDebug(false);
		return session;
	}

	/**
	 * Metodo que permite validar los elementos necesarios para el envio de un
	 * correo electronico
	 * 
	 * @param mail
	 *            El objeto que contiene la informacion para realizar el envio
	 *            de un correo electronico
	 */
	private void validate(AfirmeNetMail mail) {
		if (mail == null) {
			throw new IllegalArgumentException(
					"El objeto es nulo, el correo no puede ser enviado");
		}

		if (mail.getMailTo() == null || StringUtils.isEmpty(mail.getMailTo())) {
			throw new IllegalArgumentException(
					"El destinatario es nulo o vacio , el correo no puede ser enviado");
		}

		if (mail.getMailContent() == null
				|| StringUtils.isEmpty(mail.getMailContent())) {
			throw new IllegalArgumentException(
					"El contenido es nulo o vacio , el correo no puede ser enviado");
		}

		for (String attribute : mail.getMailTemplate().getAttributes()) {
			if (!mail.getVelocityAttributes().containsKey(attribute)) {
				throw new IllegalArgumentException(
						"Es necesario indicar el valor de cada atributo definido para el template seleccionado, falta el atributo:"
								+ attribute
								+ " , el correo no puede ser enviado");
			}
		}

	}

	/**
	 * @param velocityEngine
	 *            the velocityEngine to set
	 */
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	/**
	 * @param emailSource
	 *            the emailSource to set
	 */
	public void setEmailSource(MessageSource emailSource) {
		this.emailSource = emailSource;
	}

}
