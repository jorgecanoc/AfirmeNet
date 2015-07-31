package com.afirme.afirmenet.helper.nomina;

import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.ibs.messages.CRNNOMI01Message;
import com.afirme.afirmenet.ibs.messages.ELEERRMessage;
import com.afirme.afirmenet.model.nomina.Nomina;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

public class NominaHelper {

	static final Logger LOG = LoggerFactory.getLogger(NominaHelper.class);
	
	public void setAS400Data(CRNNOMI01Message message, Nomina nomina) {
		
		String movimiento = nomina.getMovimiento();
		
		message.setINTUSR(nomina.getContractId());
		message.setINTXPMTV(nomina.getTransactionCode());
		message.setINTFECHA(Util.getCurrentYMD());
		message.setINCLIENTE(nomina.getAccountNumber()); // Numero de Cuenta Usuario
		message.setINCUENTA(nomina.getCreditAccount());
		message.setINCOMIS(nomina.getCommision());
		message.setINIVACOM(nomina.getIva());
		
		// Numero de credito
		if (movimiento.equalsIgnoreCase("NC")) 
			message.setINTOPE("I");
		else
			message.setINTOPE(movimiento);
		
		// enviar 0 en anticipo cuando es la primera validacion
		if (movimiento.equalsIgnoreCase("I") || movimiento.equalsIgnoreCase("NC"))
			message.setINIMPORTE("0");
		else
			message.setINIMPORTE(String.valueOf(nomina.getAmount()));
	}
	
	public TransferenciaBase evaluaRespuestaAS400(MessageContext messageContext, Nomina nomina) {
		MessageRecord messageRecord = null;
		//Comprobante comprobante = null;
		boolean goHead = false;
		String errorNumber = "";
		String errorMessage = "";
		try {
			// Se recibe info si ocurrio un error o no
			messageRecord = messageContext.receiveMessage();

			if (messageRecord instanceof ELEERRMessage) {
				goHead = ((ELEERRMessage) messageRecord).getERRNUM().equals("0");
				errorNumber = ((ELEERRMessage) messageRecord).getERNU01();
				errorMessage = ((ELEERRMessage) messageRecord).getERDS01();
			}

			if (!goHead) {// Ocurrio un error
				// Llenar el comprobante con los errores detectados con 400
				//comprobante = new Comprobante(transferenciaBase);
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
				
				nomina.setErrores(errors);
				return nomina;
				
			} else {
				// Se recibe la informacion de la operacion si no se genero un error previo
				messageRecord = messageContext.receiveMessage();

				if (messageRecord instanceof CRNNOMI01Message) {
					
					if (!nomina.getClave().equals("A"))
						nomina.setCreditAccount(((CRNNOMI01Message) messageRecord).getINCUENTA());
					
					if (!nomina.getMovimiento().equals("NC")) {
						nomina.setMontoAutorizado(Double.parseDouble(Util.takeComa(((CRNNOMI01Message) messageRecord).getINLINAUT())));
						nomina.setSaldoCapital(Double.parseDouble(Util.takeComa(((CRNNOMI01Message) messageRecord).getINSALDCAP())));
						
						if (!nomina.getMovimiento().equals("F"))
							nomina.setCreditoUtilizado(Double.parseDouble(Util.takeComa(((CRNNOMI01Message) messageRecord).getINCREDOTOR())));
						else
							nomina.setCreditoUtilizado(nomina.getSaldoCapital());
						
						nomina.setCreditoDisponible(Double.parseDouble(Util.takeComa(((CRNNOMI01Message) messageRecord).getINCREDISP())));
						nomina.setAnticipoUtilizado(Double.parseDouble(Util.takeComa(((CRNNOMI01Message) messageRecord).getINSALDANT())));
						nomina.setCAT(((CRNNOMI01Message) messageRecord).getINCAT());
						nomina.setSeguro(((CRNNOMI01Message) messageRecord).getINSEGURO());
						
						if (!nomina.getMovimiento().equals("I")) {
							nomina.setCommision(new BigDecimal(((CRNNOMI01Message) messageRecord).getINCOMIS()));
							nomina.setIva(new BigDecimal(((CRNNOMI01Message) messageRecord).getINIVACOM()));
						}
					}
					
					nomina.setTasa(((CRNNOMI01Message) messageRecord).getINTASA());
					nomina.setMoratoria(((CRNNOMI01Message) messageRecord).getINMORA());
		           	nomina.setPlazo(((CRNNOMI01Message) messageRecord).getINPLAZO());
		           	nomina.setFechaPago(((CRNNOMI01Message) messageRecord).getINFECPAGO());
		           	nomina.setTotalDescuentos(((CRNNOMI01Message) messageRecord).getINPAGPEND());
		           	nomina.setTotalCreditos(((CRNNOMI01Message) messageRecord).getINCREDITO());
		           	nomina.setImporteDescuento(Double.parseDouble(Util.takeComa(((CRNNOMI01Message) messageRecord).getINCUOTA())));
		           	nomina.setFolio(((CRNNOMI01Message) messageRecord).getINFOLAUD());
					
					/*
					String referenceNumber = (((ECONFDSMessage) messageRecord).getECNFREF());
					String userReference = (((ECONFDSMessage) messageRecord).getECNFUSER());
					if (StringUtils.isEmpty(userReference) || userReference.equals("0")) {
						userReference = "";
					}
					*/
					// Llenar el comprobante con la operacion efectuada
					/*
					comprobante = new Comprobante(transferenciaBase);
					comprobante.setAfirmeNetReference(referenceNumber);
					comprobante.setReferenceNumber(referenceNumber);
					comprobante.setSpeiReference(userReference);
					*/
				} 
				/*
				else if (messageRecord instanceof INFORMU01Message) {
					String referenceNumber = (((INFORMU01Message) messageRecord).getINTREF());
					// Llenar el comprobante con la operacion efectuada
					/*
					comprobante = new Comprobante(transferenciaBase);
					comprobante.setAfirmeNetReference(referenceNumber);
					comprobante.setReferenceNumber(referenceNumber);
					*/
				//}
			}
		} catch (SocketTimeoutException e) {
			throw new AfirmeNetException("0003", "Ha ocurrido un error al intentar validar la informacion. Por favor, intente dentro de 15 minutos.");
		} catch (Exception e) {
			throw new AfirmeNetException("0003", "Por el momento no se puede ejecutar su operacion." + e.getMessage());
		}
		//return comprobante;
		return nomina;
	}
}
