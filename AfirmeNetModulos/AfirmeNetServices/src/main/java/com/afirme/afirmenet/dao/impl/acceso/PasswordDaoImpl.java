package com.afirme.afirmenet.dao.impl.acceso;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.acceso.PasswordDao;
import com.afirme.afirmenet.ibs.messages.PWDDSJVMessage;
import com.afirme.afirmenet.security.JBFirmaDigital;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

@Repository
public class PasswordDaoImpl implements PasswordDao {

	static final Logger LOG = LoggerFactory.getLogger(PasswordDaoImpl.class);
	
	@Override
	public Map<String, String> updatePassword(String idContrato, String password, String nuevoPassword) {
		LOG.debug("Procede a realizar cambio de password del Contrato: " + idContrato + ", Password actual: " + password + 
				", nuevo Password: " + nuevoPassword);
		
		try {
			// establece conexion con socket
			Socket socket = SocketFactory.getDefaultSocket();
			// prepara el mensaje
			MessageContext messageContext = MessageContextFactory.getContext(socket);
			// prepara mensaje con nuevos parámetros
			try {
				PWDDSJVMessage pwdMsg = (PWDDSJVMessage) messageContext.getMessageRecord("PWDDSJV");
				
				pwdMsg.setPWDUSR(idContrato);
				pwdMsg.setPWDPWD(password);
				pwdMsg.setPWDNPW(nuevoPassword);
				pwdMsg.setPWDNCH("");
				pwdMsg.setPWDSTS("");
				
				LOG.debug("Ejecución de actualización de Password...");
				pwdMsg.send();
				pwdMsg.destroy();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			// se recibe respuesta (estatus y no. de digitos) de la petición a socket
			MessageRecord newMessage = messageContext.receiveMessage();
			
			LOG.debug("...Finalización de actualización de Password. Se obtienen datos de respuesta.");
			String status = ((PWDDSJVMessage) newMessage).getPWDSTS();
			String numDigitos = ((PWDDSJVMessage) newMessage).getPWDNCH();
			
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put(status, numDigitos);
			
			socket.close();
			
			return resultMap;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean setPassword(String idContrato, String password, JBFirmaDigital firmaDigital) {
		LOG.debug("Ejecución de establecimiento de Password.");
		
		Socket socket = null;
		try {
			// establece conexion con socket
			socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP, AfirmeNetConstants.SOCKET_PUERTO, 0);
			// prepara el mensaje
			MessageContext messageContext = MessageContextFactory.getContext(socket);

			try {
				PWDDSJVMessage pwdMsg = (PWDDSJVMessage) messageContext.getMessageRecord("PWDDSJV");
				
				pwdMsg.setPWDUSR(idContrato);
				pwdMsg.setPWDPWD(password);
				pwdMsg.setPWDSTS("N");
				
				pwdMsg.send();
				pwdMsg.destroy();
				
			} catch (Exception e) {
				e.printStackTrace();
				socket.close();
			}
			// se recibe respuesta (no. de digitos que presentaron errores) de la petición a socket
			MessageRecord newMessage = messageContext.receiveMessage();
			
			String numDigitos = ((PWDDSJVMessage) newMessage).getPWDNCH();
			
			socket.close();
			
			if (numDigitos.equals("0") || numDigitos.equals(""))
				return true;
			else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public void mailNotificacionCambioPwd(String idContrato) {
		
	}

	@Override
	public Map<String, String> solicitudCambioPwd(String idContrato, String nuevoPassword) {
		
		try {
			// establece conexion con socket
			Socket socket = SocketFactory.getDefaultSocket();
			// prepara el mensaje
			MessageContext messageContext = MessageContextFactory.getContext(socket);
			// prepara mensaje con nuevos parámetros
			PWDDSJVMessage pwdMsg = (PWDDSJVMessage) messageContext.getMessageRecord("PWDDSJV");
			
			pwdMsg.setPWDUSR(idContrato);
			pwdMsg.setPWDPWD("==PEND==");
			pwdMsg.setPWDNPW(nuevoPassword);
			pwdMsg.setPWDNCH("");
			pwdMsg.setPWDSTS("");
			
			LOG.debug("Ejecución de solicitud de cambio de Password...");
			pwdMsg.send();
			pwdMsg.destroy();
			
			// se recibe respuesta (estatus y no. de digitos) de la petición a socket
			MessageRecord newMessage = messageContext.receiveMessage();
			
			LOG.debug("...Finalización de solicitud de cambio de Password. Se obtienen datos de respuesta.");
			String status = ((PWDDSJVMessage) newMessage).getPWDSTS();
			String numDigitos = ((PWDDSJVMessage) newMessage).getPWDNCH();
			
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put(status, numDigitos);
			
			socket.close();
			
			return resultMap;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String validaPassword(String idContrato, String codigoToken) {
		LOG.debug("Ejecución de validación de Password.");
		
		try {
			// establece conexion con socket
			Socket socket = SocketFactory.getDefaultSocket();
			// prepara el mensaje
			MessageContext messageContext = MessageContextFactory.getContext(socket);
			
			// prepara mensaje con nuevos parámetros
			try {
				PWDDSJVMessage pwdMsg = (PWDDSJVMessage) messageContext.getMessageRecord("PWDDSJV");
				
				pwdMsg.setPWDUSR(idContrato);
				pwdMsg.setPWDPWD(codigoToken);
				pwdMsg.setPWDLGT("2");
				
				pwdMsg.send();
				pwdMsg.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// se recibe respuesta (no. de digitos que presentaron errores) de la petición a socket
			MessageRecord newMessage = null;
			try {
				newMessage = messageContext.receiveMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			LOG.debug("...Finalización de validación de Password");
			
			socket.close();
			
			String cliente = ((PWDDSJVMessage) newMessage).getPWDLGT().trim();
			
            if (cliente.equals("2"))
            	return null;
            else
            	return ((PWDDSJVMessage) newMessage).getPWDSTS().trim();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
