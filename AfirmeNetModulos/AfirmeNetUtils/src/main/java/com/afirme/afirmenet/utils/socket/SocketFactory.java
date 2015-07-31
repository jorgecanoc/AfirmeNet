package com.afirme.afirmenet.utils.socket;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

/**
 * Clase Factory que provee conexiones de tipo {@link Socket}, si ocurre un
 * error durante la generacion de la conexion se lanzara una {@link Exception}
 * de tipo {@link SocketFactoryException}.
 * 
 * 
 * @author jorge.canoc@gmail.com
 * 
 */

public class SocketFactory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Logger LOG = LoggerFactory.getLogger(SocketFactory.class);

	public static int TIME_OUT = 60000;
	public static String IP = "";
	public static int PORT = 0;
	public static int PORT_SUMMARY = 0;
	public static String UNKNOWNHOST = "E001";
	public static String NULL_SOCKET = "E002";

	public SocketFactory() {
		super();
	}

	static {
		TIME_OUT = AfirmeNetConstants.SOCKET_TIMEOUT;
		IP = AfirmeNetConstants.SOCKET_IP;
		PORT = AfirmeNetConstants.SOCKET_PUERTO;
		PORT_SUMMARY = AfirmeNetConstants.SOCKET_PORT_SUMARY;
	}

	/**
	 * Metodo estatico que provee una conexion de tipo {@link Socket}
	 * proporcionando atributos generales como IP, Puerto y Puerto summary
	 * 
	 * @param IP
	 * @param PORT
	 * @param PORT_SUMMARY
	 * @return
	 * @throws SocketFactoryException
	 */
	public static Socket getSocket(String IP, int PORT)
			throws SocketFactoryException {
		return getSocket(IP, PORT, 0, TIME_OUT);
	}

	/**
	 * Metodo estatico que provee una conexion de tipo {@link Socket}
	 * proporcionando atributos generales como IP, Puerto y Puerto summary
	 * 
	 * @param IP
	 * @param PORT
	 * @param PORT_SUMMARY
	 * @return
	 * @throws SocketFactoryException
	 */
	public static Socket getSocket(String IP, int PORT, int PORT_SUMMARY)
			throws SocketFactoryException {
		return getSocket(IP, PORT, PORT_SUMMARY, TIME_OUT);
	}

	/**
	 * Metodo estatico que provee una conexion de tipo {@link Socket} mediante
	 * la obtencion de atributos default
	 * 
	 * @throws SocketFactoryException
	 */
	public static Socket getDefaultSocket() throws SocketFactoryException {
		return getSocket(IP, PORT, PORT_SUMMARY);
	}

	/**
	 * Metodo estatico que provee una conexion de tipo {@link Socket}
	 * proporcionando atributos generales como IP, Puerto, Puerto summary y
	 * TimeOut
	 * 
	 * @param IP
	 * @param PORT
	 * @param PORT_SUMMARY
	 * @param TIME_OUT
	 * @return
	 * @throws SocketFactoryException
	 */
	public static Socket getSocket(String IP, int PORT, int PORT_SUMMARY,
			int TIME_OUT) throws SocketFactoryException {
		Socket socket = null;
		String errorCode = null;
		try {
			socket = new Socket(IP, PORT + PORT_SUMMARY);
			socket.setSoTimeout(TIME_OUT);
		} catch (UnknownHostException e) {
			LOG.error("Error al realizar la conexion via socket", e);
			errorCode = UNKNOWNHOST;
		} catch (IOException e) {
			LOG.error("Error al realizar la conexion via socket", e);
			errorCode = NULL_SOCKET;
		}

		if (socket == null) {
			throw new SocketFactoryException(
					"Error al generar la conexion con el socket, el socket retorno nulo",
					errorCode);
		}

		if (errorCode != null) {
			throw new SocketFactoryException(
					"Error al generar la conexion con el socket", errorCode);
		}

		return socket;

	}

}
