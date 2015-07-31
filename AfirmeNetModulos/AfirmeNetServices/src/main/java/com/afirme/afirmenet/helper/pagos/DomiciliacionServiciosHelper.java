package com.afirme.afirmenet.helper.pagos;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.messages.D1ERROPFMessage;
import com.afirme.afirmenet.ibs.messages.INCONTPFMessage;
import com.afirme.afirmenet.model.pagos.ConvenioDomiciliacion;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

public class DomiciliacionServiciosHelper {

	/**
	 * Llena los parametros de un objeto mensaje de AS400 a partir de la informacion de un Convenio
	 * @param domiciliacion
	 * @param convenio
	 */
	public void setAS400Data(INCONTPFMessage domiciliacion, ConvenioDomiciliacion convenio) {
		
		domiciliacion.setPCCONI(String.valueOf(convenio.getContractId()));
		domiciliacion.setPCCONS(String.valueOf(convenio.getFolio()));
		domiciliacion.setPCREFS(String.valueOf(convenio.getReferencia()));
		domiciliacion.setPCCTAC(String.valueOf(convenio.getOrigen().getNumber()));
		domiciliacion.setPCCLIE(String.valueOf(convenio.getUserId()));
		domiciliacion.setPCDSC1(String.valueOf(convenio.getDescripcion()));
		domiciliacion.setPCSUCO(String.valueOf("501"));
		domiciliacion.setPCESTP(String.valueOf(convenio.getTipoMovimiento()));
		domiciliacion.setPCEMAD(String.valueOf(convenio.getEmail()));
		domiciliacion.setPCPAGMA(String.valueOf(convenio.getPagoMax()));
		domiciliacion.setPCTITS(String.valueOf(convenio.getTitular()));
		domiciliacion.setPCTIPTI(String.valueOf(convenio.getTipoTransferencia().getValor()));
	}
	
	/**
	 * Evalua los mensajes resultantes de la peticion a AS400
	 * @param messageContext
	 * @param transferenciaBase
	 * @return
	 */
	public Comprobante evaluaRespuestaAS400(MessageContext messageContext, TransferenciaBase transferenciaBase) {
		MessageRecord messageRecord = null;
		Comprobante comprobante = null;
		boolean goHead = false;
		String errorNumber = "";
		String errorMessage = "";
		try {
			// Se recibe info si ocurrio un error o no
			messageRecord = messageContext.receiveMessage();
			
			if (messageRecord instanceof D1ERROPFMessage){
				goHead = ((D1ERROPFMessage) messageRecord).getERRNUM().equals("0");
				errorNumber = ((D1ERROPFMessage) messageRecord).getERNU01();
				errorMessage = ((D1ERROPFMessage) messageRecord).getERDS01();
			}
			
			if (!goHead) {// Ocurrio un error
				// Llenar el comprobante con los errores detectados con 400
				comprobante = new Comprobante(transferenciaBase);
				Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(0);
				// Busca la Excepcion
				CodigoExcepcion error = CodigoExcepcion.findByValue(Integer.valueOf(errorNumber));
				if (error == null) {
					// Error generico
					error = CodigoExcepcion.ERR_3000;
					errors.put(error, errorMessage);
				} else {
					errors.put(error, errorMessage);
				}
				comprobante.setErrores(errors);
			} else {
				// Se recibe la informacion de la operacion si no se genero un error previo
				messageRecord = messageContext.receiveMessage();
				
				if (messageRecord instanceof INCONTPFMessage) {
					String referenceNumber = (((INCONTPFMessage) messageRecord).getPCREFI());
					// Llenar el comprobante con la operacion efectuada
					comprobante = new Comprobante(transferenciaBase);
					comprobante.setAfirmeNetReference(referenceNumber);
					comprobante.setReferenceNumber(referenceNumber);
				}
			}
        }catch(SocketTimeoutException e){
        	throw new AfirmeNetException("0003","Ha ocurrido un error al intentar validar la informacion. Por favor, intente dentro de 15 minutos.");
        }catch (Exception e) {
			throw new AfirmeNetException("0003", "Por el momento no se puede ejecutar su operacion." + e.getMessage());
		}
		return comprobante;
	}
}
