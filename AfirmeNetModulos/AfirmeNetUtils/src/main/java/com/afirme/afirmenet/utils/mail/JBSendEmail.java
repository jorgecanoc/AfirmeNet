package com.afirme.afirmenet.utils.mail;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBSendEmail {
	static final Logger LOG = LoggerFactory
			.getLogger(JBSendEmail.class);	

	public JBSendEmail() {}

	public String getSendEmail(String host, String to, String from, String sub, String msg, String CC) {
		String senderror = "";
		// Get system properties
		Properties props = System.getProperties();
		// Setup mail server
		props.put("mail.smtp.host", host);
		// Get session
		Session sessionM = Session.getDefaultInstance(props, null);
		// Define message
		MimeMessage message = new MimeMessage(sessionM);
		try {
			// Set the from address
			message.setFrom(new InternetAddress(from));
			// Set the to address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set the CC address
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(CC));
			// Set the subject
			message.setSubject(sub);
			// Set the content
			message.setText(msg);
			// Send message
			Transport.send(message);
		} catch (Exception e) {
			senderror = "Error DIBS.JBSendEmail.getSendEmail(con CC) ==> " + e;
			LOG.debug(senderror);
			LOG.debug("El StackTrace del error en DIBS.JBSendEmail.getSendEmail(con CC) es el siguiente:");
			e.printStackTrace(System.out);
		}
		return (senderror);
	}

	public String getSendEmail(String host, String to, String from, String sub, String msg) {
		String senderror = "";
		// Get system properties
		Properties props = System.getProperties();
		// Setup mail server
		props.put("mail.smtp.host", host);
		// Get session
		Session sessionM = Session.getDefaultInstance(props, null);
		// Define message
		MimeMessage message = new MimeMessage(sessionM);
		try {
			// Set the from address
			message.setFrom(new InternetAddress(from));
			// Set the to address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set the subject
			message.setSubject(sub);
			// Set the content
			message.setText(msg);
			// Send message
			Transport.send(message);
		} catch (Exception e) {
			senderror = "Error DIBS.JBSendEmail.getSendEmail ==> " + e;
			LOG.debug(senderror);
			LOG.debug("El StackTrace del error en DIBS.JBSendEmail.getSendEmail es el siguiente:");
			e.printStackTrace(System.out);
		}
		return (senderror);
	}

	public String getSendEmailMultipart(String host, String to, String from, String sub, MimeMultipart multipart) {
		String senderror = "";
		// Get system properties
		Properties props = System.getProperties();
		// Setup mail server
		props.put("mail.smtp.host", host);
		// Get session
		Session sessionM = Session.getDefaultInstance(props, null);
		// Define message
		MimeMessage message = new MimeMessage(sessionM);
		try {
			// Set the from address
			message.setFrom(new InternetAddress(from));
			// Set the to address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set the subject
			message.setSubject(sub);
			// /Content
			message.setContent(multipart);
			// Send message
			Transport.send(message);
		} catch (Exception e) {
			senderror = "Error DIBS.JBSendEmail.getSendEmail ==> " + e;
			LOG.debug(senderror);
			System.out
					.println("El StackTrace del error en DIBS.JBSendEmail.getSendEmail es el siguiente:");
			e.printStackTrace(System.out);
		}
		return (senderror);
	}

	public String getSendEmailMassive(String host, ArrayList<String> to, String from, String sub, String msg) {
		String senderror = "";
		// Get system properties
		Properties props = System.getProperties();
		// Setup mail server
		props.put("mail.smtp.host", host);
		// Get session
		Session sessionM = Session.getDefaultInstance(props, null);
		// Define message
		MimeMessage message = new MimeMessage(sessionM);
		try {
			// Set the from address
			message.setFrom(new InternetAddress(from));
			// Set the to address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.get(0)));
			for (int i = 1; i < to.size(); i++) {
				message.addRecipient(Message.RecipientType.CC, new InternetAddress(to.get(i)));
			}
			// Set the subject
			message.setSubject(sub);
			// Set the content
			message.setText(msg);
			// Send message
			Transport.send(message);
		} catch (Exception e) {
			senderror = "Error DCIBS.JBSendEmail.getSendEmail ==> " + e;
			LOG.debug(senderror);
			LOG.debug("El StackTrace del error en DCIBS.JBSendEmail.getSendEmail es el siguiente:");
			e.printStackTrace(System.out);
		}
		return (senderror);
	}
}
