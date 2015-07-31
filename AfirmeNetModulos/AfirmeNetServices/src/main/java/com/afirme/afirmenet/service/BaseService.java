package com.afirme.afirmenet.service;

import java.net.Socket;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.utils.socket.SocketFactory;

/***
 * Clase Service base que implementa los metodos mas comunes que seran
 * utilizados en la capa de servicios definidos en {@link BaseService}
 * 
 * @author jorge.canoc@gmail.com
 * 
 */

@Service
public class BaseService {

	@Autowired
	public MessageSource dibsSource;

	public Locale locale = LocaleContextHolder.getLocale();

	/***
	 * Metodo que provee una conexion {@link Socket} con parametros default
	 * 
	 * @return
	 * @throws SocketFactoryException
	 */
	public Socket getDefaultSocketConnection() throws SocketFactoryException {
		return SocketFactory.getDefaultSocket();
	}

	/**
	 * Metodo que permite la obtencion de los mensajes del archido de recursos
	 * en el idioma que corresponda, asi como el paso de valores cuando existan
	 * place holders en el mensaje.
	 * 
	 * @param properties
	 * @param values
	 * @return El mensaje correspondiente
	 */
	public String getMessage(String properties, Object[] values) {
		return dibsSource.getMessage(properties, values, locale);
	}

	/**
	 * Metodo que permite la obtencion de los mensajes del archido de recursos
	 * en el idioma que corresponda
	 * 
	 * @param properties
	 * @return El mensaje correspondiente
	 */
	public String getMessage(String properties) {
		return this.getMessage(properties, null);
	}
}
