package com.afirme.afirmenet.utils.mail;

import javax.mail.MessagingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSendAfirmeNetMail {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws MessagingException {
		AfirmeNetMail mail = new AfirmeNetMail();
		mail.setMailFrom("0jorge.cano@afirme.com");
		mail.setMailTo("0jorge.cano@afirme.com");
		mail.setMailSubject("Correo Importante");
		mail.setMailContent("lol");
		mail.setMailTemplate(MailTemplate.HTML);
		mail.getVelocityAttributes().put("title", "Notificacion de Deposito en Cuenta");
		mail.getVelocityAttributes().put("fullName", "Jorge A. Cano Cuevas");
		mail.getVelocityAttributes().put("message", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.");
		mail.getVelocityAttributes().put("afirmeNetURL", "https://www.afirme.com.mx/Portal/Portal.do");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"utils-config.xml");
		SendAfirmeNetMail sender = (SendAfirmeNetMail) context
				.getBean("sendAfirmeNetMail");
		sender.sendMail(mail);
	}
}
