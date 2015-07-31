package com.afirme.afirmenet.utils.mail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.afirme.afirmenet.utils.time.TimeUtils;

/**
 * Clase que almacena la informacion de un correo electronico para ser enviado
 * por la clase {@link SendAfirmeNetMail}
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class AfirmeNetMail {
	private String mailFrom;
	private String mailTo;
	private String mailCc;
	private String mailBcc;
	private String mailSubject;
	private String mailContent;
	private MailTemplate mailTemplate;
	private String contentType;
	private Map<String,String> velocityAttributes = new HashMap<String, String>();

	public AfirmeNetMail() {
		contentType = "text/html";
	}

	/**
	 * @return the mailFrom
	 */
	public String getMailFrom() {
		return mailFrom;
	}

	/**
	 * @param mailFrom
	 *            the mailFrom to set
	 */
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	/**
	 * @return the mailTo
	 */
	public String getMailTo() {
		return mailTo;
	}

	/**
	 * @param mailTo
	 *            the mailTo to set
	 */
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	/**
	 * @return the mailCc
	 */
	public String getMailCc() {
		return mailCc;
	}

	/**
	 * @param mailCc
	 *            the mailCc to set
	 */
	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	/**
	 * @return the mailBcc
	 */
	public String getMailBcc() {
		return mailBcc;
	}

	/**
	 * @param mailBcc
	 *            the mailBcc to set
	 */
	public void setMailBcc(String mailBcc) {
		this.mailBcc = mailBcc;
	}

	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}

	/**
	 * @param mailSubject
	 *            the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	/**
	 * @return the mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}

	/**
	 * @param mailContent
	 *            the mailContent to set
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getMailSendDate() {
		return new Date();
	}

	/**
	 * @return the mailTemplate
	 */
	public MailTemplate getMailTemplate() {
		return mailTemplate;
	}

	/**
	 * @param mailTemplate
	 *            the mailTemplate to set
	 */
	public void setMailTemplate(MailTemplate mailTemplate) {
		this.mailTemplate = mailTemplate;
	}

	@Override
	public String toString() {
		StringBuilder lBuilder = new StringBuilder();
		lBuilder.append("AfirmeNetMail From:- ").append(getMailFrom());
		lBuilder.append("AfirmeNetMail To:- ").append(getMailTo());
		lBuilder.append("AfirmeNetMail Cc:- ").append(getMailCc());
		lBuilder.append("AfirmeNetMail Bcc:- ").append(getMailBcc());
		lBuilder.append("AfirmeNetMail Subject:- ").append(getMailSubject());
		lBuilder.append("AfirmeNetMail Create Date:- ")
				.append(TimeUtils.completeDateFormat
						.format(getMailSendDate()));
		lBuilder.append("AfirmeNetMail Content:- ").append(getMailContent());
		return lBuilder.toString();
	}

	/**
	 * @return the velocityAttributes
	 */
	public Map<String, String> getVelocityAttributes() {
		return velocityAttributes;
	}

	/**
	 * @param velocityAttributes the velocityAttributes to set
	 */
	public void setVelocityAttributes(Map<String, String> velocityAttributes) {
		this.velocityAttributes = velocityAttributes;
	}



}
