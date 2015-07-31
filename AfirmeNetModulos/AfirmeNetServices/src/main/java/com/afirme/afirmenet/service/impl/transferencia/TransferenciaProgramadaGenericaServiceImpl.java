package com.afirme.afirmenet.service.impl.transferencia;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.helper.transferencia.TransferenciaHelper;
import com.afirme.afirmenet.ibs.messages.IN095701Message;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.transferencia.TransferenciaAfirmeNet;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;

@Service("transferenciaProgramadaGenericaServiceImpl")
public class TransferenciaProgramadaGenericaServiceImpl implements
		TransferenciaAfirmeNet {

	@Override
	public ComprobanteTransferencia ejecutaTransferencia(
			TransferenciaBase transferenciaBase) throws AfirmeNetException {
		return null;
	}

	@Override
	public List<? extends ComprobanteTransferencia> ejecutaTransferencia(
			List<TransferenciaBase> transferencias) {
		List<ComprobanteTransferencia> comprobantes = new ArrayList<ComprobanteTransferencia>(
				0);
   	    // Declaracion de Variables
		Comprobante comprobante = null;
		IN095701Message afitrans = null;
		Socket socket = null;
		MessageContext messageContext = null;
		TransferenciaHelper helper = new TransferenciaHelper();
		try {
			
			try {
				socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP,
						AfirmeNetConstants.SOCKET_PUERTO + 1);
				messageContext = MessageContextFactory.getContext(socket);
	
			} catch (SocketFactoryException e) {
				throw new AfirmeNetException("0000",
						"Por el momento no se puede ejecutar su operacion.");
			} catch (MessageContextFactoryException e) {
				throw new AfirmeNetException("0001",
						"Por el momento no se puede ejecutar su operacion.");
			}
			
			for (TransferenciaBase tx : transferencias) {
				if(tx.getErrores() == null || tx.getErrores().isEmpty()){
					// Incializa Bean de operacion
					afitrans = (IN095701Message) messageContext.getMessageRecord("IN095701");
					// Setea informacion en el bean de operacion
					helper.setAS400Data(afitrans, tx);
					// Evia peticion a AS400
					afitrans.send();
					afitrans.destroy();				
				}			
			}
			//Envia mensaje fin de programaciones
			//Sends to as400 a "*" identifying that transaction's request has been finished
			afitrans = (IN095701Message) messageContext.getMessageRecord("IN095701");
			afitrans.setINEUSR(transferencias.get(0).getUserId());// UserIdJSP
			afitrans.setINEFRMACC(transferencias.get(0).getDebitAccount());// transbean.getDEBACC()
			afitrans.setINEBNFACC(transferencias.get(0).getCreditAccount());// transbean.getCREACC()
			afitrans.setINEAMT(transferencias.get(0).getAmount());// transbean.getAMOUNT()
			afitrans.setINEOPE("*");
			afitrans.send();
			afitrans.destroy();		
			comprobante = helper.evaluaRespuestaAS400(messageContext, transferencias.get(0));
			comprobantes.add(comprobante);
		} catch (Exception e) {
			throw new AfirmeNetException("0003",
					"Por el momento no se puede ejecutar su operacion.");
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		
		return comprobantes;
	}


}
