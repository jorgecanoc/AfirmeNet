package com.afirme.afirmenet.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.junit.Test;

import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.ibs.messages.EODDSJVMessage;
import com.afirme.afirmenet.ibs.messages.SUMDSJVMessage;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

public class TestSocketFactory {
	@Test
	public void testSocket() throws SocketFactoryException,
			IOException, MessageContextFactoryException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		init();
		byte[] _bytes = {83, 85, 77, 68, 83, 74, 86, 32, 32, 32, 49, 51, 49, 49, 50, 54, 54, 48, 48, 49, 32, 48, 48, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 32, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 46, 48, 48, 32, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 46, 48, 48, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 48, 32, 48, 48, 32, 48, 48, 32, 48, 48, 32, 48, 48, 32, 48, 48, 32, 48, 48, 46, 48, 48, 48, 48};
		String str = new String(_bytes, "UTF-8");
		System.out.println("str========>" + str);
		Socket socket3 = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP, AfirmeNetConstants.SOCKET_PUERTO, AfirmeNetConstants.SOCKET_PORT_SUMARY);
		MessageContext messageContext = MessageContextFactory.getContext(socket3); 
				
//				new MessageContext(new DataInputStream(
//				new BufferedInputStream(socket3.getInputStream())),
//				new DataOutputStream(new BufferedOutputStream(socket3
//						.getOutputStream())), AfirmeNetConstants.JAVA_PATH + ".messages");
		SUMDSJVMessage summary = (SUMDSJVMessage) messageContext.getMessageRecord("SUMDSJV");
		summary.setSUMUSR("1311266001");
		summary.send();
		summary.destroy();
		MessageRecord newMessage = messageContext.receiveMessage();
		System.out.println(newMessage.getFormatName());

		
	}

	private static void init() {
		AfirmeNetConstants.JAVA_PATH = "com.afirme.afirmenet.ibs";
		AfirmeNetConstants.SOCKET_PUERTO= 7300;
		AfirmeNetConstants.SOCKET_IP = "172.20.70.96";
		AfirmeNetConstants.SOCKET_PORT_SUMARY = 14;
		AfirmeNetConstants.SOCKET_TIMEOUT = 10000;		
	}
}
