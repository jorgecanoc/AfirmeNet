package com.afirme.afirmenet.service.impl.transferencia;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.helper.pagos.ImpuestosGDFHelper;
import com.afirme.afirmenet.ibs.messages.INFORMU01Message;
import com.afirme.afirmenet.model.pagos.ImpuestoGDF;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.transferencia.TransferenciaAfirmeNet;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;

@Service("pagoImpuestosGDFServiceImpl")
public class PagoImpuestosGDFServiceImpl implements TransferenciaAfirmeNet {

	static final Logger LOG = LoggerFactory.getLogger(PagoImpuestosGDFServiceImpl.class);
	
	@Override
	public ComprobanteTransferencia ejecutaTransferencia(TransferenciaBase transferenciaBase) throws AfirmeNetException {
		// Declaracion de Variables
		Comprobante comprobante = null;
		INFORMU01Message afitrans = null;
		Socket socket = null;
		MessageContext messageContext = null;
		ImpuestosGDFHelper impuestoHelper = new ImpuestosGDFHelper();
		// Invocacion del Socket
		try {
			socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP, AfirmeNetConstants.SOCKET_PUERTO + 1);
			messageContext = MessageContextFactory.getContext(socket);
		} catch (SocketFactoryException e) {
			throw new AfirmeNetException("0000", "Por el momento no se puede ejecutar su operacion.");
		} catch (MessageContextFactoryException e) {
			throw new AfirmeNetException("0001", "Por el momento no se puede ejecutar su operacion.");
		}

		try {
			// Incializa Bean de operacion
			afitrans = (INFORMU01Message) messageContext.getMessageRecord("INFORMU01");
			// Setea informacion en el bean de operacion
			impuestoHelper.setAS400Data(afitrans, (ImpuestoGDF) transferenciaBase);
			// Envia peticion a AS400
			afitrans.send();
			afitrans.destroy();
			// Se evalua la respuesta de AS400
			comprobante = impuestoHelper.evaluaRespuestaAS400(messageContext, transferenciaBase);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AfirmeNetException("0003", "Por el momento no se puede ejecutar su operacion.");
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}

		return comprobante;
	}

	@Override
	public List<? extends ComprobanteTransferencia> ejecutaTransferencia(List<TransferenciaBase> transferencias) {
		
		List<ComprobanteTransferencia> comprobantes = new ArrayList<ComprobanteTransferencia>(0);
		for (TransferenciaBase tx : transferencias) {
			try {
				if (tx.getErrores() == null || tx.getErrores().isEmpty()) {
					comprobantes.add(ejecutaTransferencia(tx));
				} else {
					Comprobante comprobante = new Comprobante(tx);
					comprobantes.add(comprobante);
				}

			} catch (AfirmeNetException e) {
				Comprobante comprobante = new Comprobante(tx);
				Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(0);
				CodigoExcepcion error = CodigoExcepcion.findByValue(Integer.valueOf(e.getErrCode()));
				if (error == null) {
					// Error generico
					error = CodigoExcepcion.ERR_3000;
					errors.put(error, e.getMessage());
				} else {
					errors.put(error, e.getErrMsg());
				}
				comprobante.setErrores(errors);
				comprobantes.add(comprobante);
			}
		}
		return comprobantes;
	}

}
