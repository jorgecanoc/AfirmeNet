package com.afirme.afirmenet.utils.socket;

import java.io.IOException;
import java.net.Socket;

import org.junit.Test;

import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

public class TestSocketFactory {
	@Test
	public void testSocket() throws SocketFactoryException,
			IOException, MessageContextFactoryException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		init();
		Socket socket = SocketFactory.getDefaultSocket();
		System.out.println("Instancia de Socket===>"+socket.toString());
		System.out.println("Direccion Local del Socket?===>"+socket.getLocalAddress());
		

		Socket socket2 = SocketFactory.getDefaultSocket();
		System.out.println("Instancia de Socket===>"+socket2.toString());
		System.out.println("Direccion Local del Socket?===>"+socket2.getLocalAddress());
		

		socket.close();
		socket2.close();
		System.out.println("Socket Cerrado? ==>"+socket.isClosed());
		System.out.println("Socket Cerrado? ==>"+socket2.isClosed());
		
		socket = SocketFactory.getDefaultSocket();
		System.out.println("Instancia de Socket===>"+socket.toString());
		System.out.println("Direccion Local del Socket?===>"+socket.getLocalAddress());
		socket.close();
		System.out.println("Socket Cerrado? ==>"+socket.isClosed());
		
	}

	private static void init() {
		AfirmeNetConstants.SOCKET_PUERTO= 7300;
		AfirmeNetConstants.SOCKET_IP = "172.20.70.96";
		AfirmeNetConstants.SOCKET_PORT_SUMARY = 1;
		AfirmeNetConstants.SOCKET_TIMEOUT = 30000;		
	}
}
