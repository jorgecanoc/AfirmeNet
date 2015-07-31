package com.afirme.afirmenet.utils.mail;

/**
 * Enum que permite identificar el tipo de template que se utilizara al momento
 * de enviarse un correo electronico
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public enum MailTemplate {
	PLAIN_TEXT("afirmenetbasicemailtemplate", new String[] { "title",
			"fullName", "message", "afirmeNetURL" }), HTML(
			"afirmenethtmlemailtemplate", new String[] { "title", "fullName",
					"message", "afirmeNetURL" }), HTML_IMAGES_IN_LINE(
			"afirmenethtmlplusemailtemplate", new String[] { "title",
					"fullName", "message", "afirmeNetURL" });

	private String nameTemplate;
	private String[] attributes;

	MailTemplate(String nameTemplate, String[] attributes) {
		this.nameTemplate = nameTemplate;
		this.attributes = attributes;
	}

	/**
	 * @return the nameTemplate
	 */
	public String getNameTemplate() {
		return nameTemplate;
	}

	/**
	 * @param nameTemplate
	 *            the nameTemplate to set
	 */
	public void setNameTemplate(String nameTemplate) {
		this.nameTemplate = nameTemplate;
	}

	/**
	 * @return the attributes
	 */
	public String[] getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
}
