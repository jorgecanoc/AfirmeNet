package com.afirme.afirmenet.service.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;

public interface MailService {
	
	public void sendAlertaSincrTok(String mailDestino, String contrato, String noserie) throws MessagingException;
	public MimeMultipart getMultipart(StringBuffer sb, String path);
	public void sendAlertaTokenBloq(String mailDestino, String contrato, String serial) throws MessagingException;
}
