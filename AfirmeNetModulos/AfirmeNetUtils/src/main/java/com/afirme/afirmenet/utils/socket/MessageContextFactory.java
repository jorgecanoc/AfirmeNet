package com.afirme.afirmenet.utils.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.datapro.sockets.MessageContext;

/**
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class MessageContextFactory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Logger LOG = LoggerFactory
			.getLogger(MessageContextFactory.class);

	public static String IO_EXCEPTION = "E003";
	public static String NULL_CONTEX = "E004";

	public static MessageContext getContext(Socket socket)
			throws MessageContextFactoryException {
		MessageContext mc = null;

		String errorCode = null;

		try {
			mc = new MessageContext(new DataInputStream(
					new BufferedInputStream(socket.getInputStream())),
					new DataOutputStream(new BufferedOutputStream(socket
							.getOutputStream())), AfirmeNetConstants.JAVA_PATH
							+ ".messages");
		} catch (IOException e) {
			LOG.error("Error al generar el MessageContext ==>", e);
			errorCode = IO_EXCEPTION;
		}
		if (mc == null) {
			throw new MessageContextFactoryException(
					"Error al generar el  MessageContext, el  MessageContext retorno nulo",
					errorCode);
		}

		if (errorCode != null) {
			throw new MessageContextFactoryException(
					"Error al generar el  MessageContext", errorCode);
		}
		return mc;
	}

}
