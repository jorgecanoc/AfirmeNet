package com.afirme.afirmenet.service.impl.transferencia;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.ibs.databeans.cardif.SeguroCardif;
import com.afirme.afirmenet.ibs.messages.ELEERRMessage;
import com.afirme.afirmenet.ibs.messages.INDC30601Message;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.transferencia.TransferenciaAfirmeNet;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

@Service("seguroCardifServiceImpl")
public class SeguroCardifServiceImpl  implements TransferenciaAfirmeNet{

	private final String OPE_VALIDACION = "V";
	private final String OPE_APLICACION = "A";
	public static final String ERROR_MSG_VAL = "Ha ocurrido un error al intentar validar la informacion. Por favor, intente dentro de 15 minutos.";
	@Override
	public ComprobanteTransferencia ejecutaTransferencia(
			TransferenciaBase transferencia) throws AfirmeNetException {
		SeguroCardif oBeanCardif = (SeguroCardif)transferencia;
		return this.aplicacion(oBeanCardif);
	}

	@Override
	public List<? extends ComprobanteTransferencia> ejecutaTransferencia(
			List<TransferenciaBase> transferencias) {
		List<ComprobanteTransferencia> comprobantes = new ArrayList<ComprobanteTransferencia>(0);
		for(TransferenciaBase tx: transferencias){
			try {
				if(tx.getErrores() == null || tx.getErrores().isEmpty()){
					comprobantes.add(ejecutaTransferencia(tx));
				}else{
					comprobantes.add(new Comprobante(tx));
				}
				
			} catch (AfirmeNetException e) {
				Comprobante comprobante = new Comprobante(tx);
				 Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(0);
				CodigoExcepcion error = CodigoExcepcion.findByValue(Integer.valueOf(e.getErrCode()));
                if(error == null){
                	//Error generico
                	error = CodigoExcepcion.ERR_3000;
                	errors.put(error, e.getMessage());
                }else{
                	errors.put(error, e.getMessage());
                }
                comprobante.setErrores(errors);
                comprobantes.add(comprobante);
			}
		}
		return comprobantes;
	}

	public Comprobante validacion(SeguroCardif oBeanCardif)  {
		return this.sendBeanToAS400(oBeanCardif, OPE_VALIDACION);
	}
	
	public Comprobante aplicacion(SeguroCardif oBeanCardif) {
		return this.sendBeanToAS400(oBeanCardif, OPE_APLICACION);
	}
	public Comprobante sendBeanToAS400(SeguroCardif oBeanCardif, String ope) throws AfirmeNetException{

		Socket socket = null;
		INDC30601Message afitrans = null;

		Comprobante comprobante = null;
		MessageContext messageContext = null;
		MessageRecord messageRecord = null;
		boolean goHead = false;
		String errorNumber= "";
		String errorMessage= "";
		try {
			socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP, AfirmeNetConstants.SOCKET_PUERTO, 16);
			messageContext = MessageContextFactory.getContext(socket); 
			
		} catch (SocketFactoryException e) {
			throw new AfirmeNetException("0000","Por el momento no se puede ejecutar su operacion.");
		} catch (MessageContextFactoryException e) {
			throw new AfirmeNetException("0001","Por el momento no se puede ejecutar su operacion.");
		}
		try {
			afitrans=(INDC30601Message) messageContext.getMessageRecord("INDC30601");
			afitrans = llenarAS400DeBeanCardif(oBeanCardif, afitrans, ope);
			afitrans.send();
			afitrans.destroy();
		} catch (Exception e) {
			throw new AfirmeNetException("0003","Por el momento no se puede ejecutar su operacion.");
		}

		try {
			// Mensaje de Error

        	messageRecord = messageContext.receiveMessage();
        	goHead = ((ELEERRMessage) messageRecord).getERRNUM().equals("0");
        	errorNumber = ((ELEERRMessage) messageRecord).getERNU01();
        	errorMessage = ((ELEERRMessage) messageRecord).getERDS01();
        	if(!goHead){//Ocurrio un error
        		//Llenar el comprobante con los errores detectados con 400
                comprobante = new Comprobante(oBeanCardif);
                Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(0);
                //Busca la Excepcion 
                CodigoExcepcion error = CodigoExcepcion.findByValue(Integer.valueOf(errorNumber));
                if(error == null){
                	//Error generico
                	error = CodigoExcepcion.ERR_3000;
                	errors.put(error, errorMessage);
                }else{
                	errors.put(error, errorMessage);
                }
                comprobante.setErrores(errors);
                
				oBeanCardif.setState(errorNumber + " " + errorMessage);
			} else {
				// Mensaje
				messageRecord = messageContext.receiveMessage();
				//newmessage = mc.receiveMessage();
				INDC30601Message msjRespuesta = (INDC30601Message) messageRecord;
				oBeanCardif = llenarBeanCardifDeAS400(oBeanCardif, msjRespuesta, ope);
			}
		} catch(SocketTimeoutException e){
        	throw new AfirmeNetException("0003","Ha ocurrido un error al intentar validar la informacion. Por favor, intente dentro de 15 minutos.");
        }catch(Exception e){
        	throw new AfirmeNetException("0003","Por el momento no se puede ejecutar su operacion.");
        }finally{
        	if(socket != null){
        		try {
					socket.close();
				} catch (IOException e) {
				}
        	}
         }

		return comprobante;
	}

	private INDC30601Message llenarAS400DeBeanCardif(SeguroCardif oBeanCardif, INDC30601Message afitrans, String ope) {
		afitrans.setVCONTRATO(oBeanCardif.getContractId());
		afitrans.setVCUENTA(oBeanCardif.getDebitAccount());
		afitrans.setVIAOPE(ope);
		afitrans.setVPAQUETE(oBeanCardif.getPaquete());
		//afitrans.setVCUENTA(oBeanCardif.getCuenta());
		afitrans.setVTIPOTRA(oBeanCardif.getTransactionCode());
		//afitrans.setVCUENTA(oBeanCardif.getCuenta());
		return afitrans;
	}
	private SeguroCardif llenarBeanCardifDeAS400(SeguroCardif oBeanCardif, INDC30601Message afitrans, String ope) {
		oBeanCardif.setFecha(afitrans.getBigDecimalVIAFECHA());
		oBeanCardif.setHora(afitrans.getBigDecimalVIAHORA());
		oBeanCardif.setAmount(afitrans.getBigDecimalVIMPORTE());
		if(OPE_APLICACION.equalsIgnoreCase(ope)){
			oBeanCardif.setPoliza(afitrans.getVPOLIZA());
			oBeanCardif.setReferenceNumber(afitrans.getVREFEREN());
		}
		return oBeanCardif;
	}

}

