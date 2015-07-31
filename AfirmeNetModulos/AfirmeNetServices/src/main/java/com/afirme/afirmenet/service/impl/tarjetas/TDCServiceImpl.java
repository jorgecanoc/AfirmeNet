package com.afirme.afirmenet.service.impl.tarjetas;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.tarjetas.TDCDao;
import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.ibs.beans.tarjetas.DatosTDC;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.TC5000PF;
import com.afirme.afirmenet.ibs.messages.MQERROPFMessage;
import com.afirme.afirmenet.ibs.messages.MQTSYC01PFMessage;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.service.tarjetas.TDCService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

@Service
public class TDCServiceImpl implements TDCService{
	
	@Autowired
	private TDCDao tdcDao;
	
	@Override
	public List<TC5000PF> getListaTDC(String numcliente) {
		return tdcDao.getListaTDC(numcliente);
	}

	@Override
	public List<TC5000PF> getListaTDCNoAdicional(List<TC5000PF> tarjetas) {
		List<TC5000PF> tarjetasValidas=new ArrayList<TC5000PF>();
		for (TC5000PF tarjeta : tarjetas) {
			if(!tarjeta.getTCCLTA().equals("Adicional"))
				tarjetasValidas.add(tarjeta);
		}
		return tarjetasValidas;
	}

	@Override
	public DatosTDC getDatosMQ(DatosTDC datosTDC) throws AfirmeNetException {
		
		Comprobante comprobante = null;
		MQTSYC01PFMessage afitrans = null;

//        Valida Fin de Dia
//
//	      String eoderror = eodbean.getEOD();
//
//	      if(eoderror.equals("1"))
//	      {
//	         sqlerror = "1";
//	         return sqlerror;
//	      }
//	      if(eoderror.equals("2"))
//	      {
//	         sqlerror = "2";
//	         return sqlerror;
//	      }

		
		//Invocacion del Socket
		Socket socket = null;
		MessageContext messageContext = null;
		MessageRecord messageRecord = null;
		boolean goHead = false;
		String errorNumber= "";
		String errorMessage= "";
		try {
			socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP, AfirmeNetConstants.SOCKET_PUERTO+16, 0);
			messageContext = MessageContextFactory.getContext(socket); 
			
		} catch (SocketFactoryException e) {
			throw new AfirmeNetException("0000","Por el momento no se puede ejecutar su operacion.");
		} catch (MessageContextFactoryException e) {
			throw new AfirmeNetException("0001","Por el momento no se puede ejecutar su operacion.");
		}
		
		//No se por que se hace esto
//        if(transbean.getVHH().equals("99"))
//        {
//           transbean.setVHH("00");
//        }
//        if(transbean.getVSS().equals("99"))
//        {
//           transbean.setVSS("00");
//        }
		
        try {
			  afitrans = (MQTSYC01PFMessage) messageContext.getMessageRecord("MQTSYC01PF");		
			  afitrans.setMQSUCO(datosTDC.getTdcSUCO());
		      afitrans.setMQTRNM(datosTDC.getTdcTRNM());
		      afitrans.setMQCTO(datosTDC.getTdcCTO());
		      afitrans.setMQUSER(datosTDC.getTdcUSER());
		      afitrans.setMQCLIE(datosTDC.getTdcCLIE());
		      afitrans.setMQTDCC(datosTDC.getTdcTDCC());
			
		      afitrans.send();
		      afitrans.destroy();			
			
		} catch (Exception e) {
			throw new AfirmeNetException("0003","Por el momento no se puede ejecutar su operacion.");
		} 
        
        try{
        	//Se recibe info si ocurrio un error o no
        	messageRecord = messageContext.receiveMessage();
	         
        	goHead = ((MQERROPFMessage) messageRecord).getERRNUM().equals("0");
        	errorNumber = ((MQERROPFMessage) messageRecord).getERNU01();
        	errorMessage = ((MQERROPFMessage) messageRecord).getERDS01();
        	if(!goHead){//Ocurrio un error
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
                throw new AfirmeNetException(errorNumber, errorMessage);
        	}else{
        		
        		messageRecord = messageContext.receiveMessage();
 
	            MQTSYC01PFMessage msjMQCREDITO = (MQTSYC01PFMessage) messageRecord;
           
	            datosTDC.setTdcTRNM(msjMQCREDITO.getMQTRNM());
	            datosTDC.setTdcCTO(msjMQCREDITO.getMQCTO());
	            datosTDC.setTdcUSER(msjMQCREDITO.getMQUSER());
	            datosTDC.setTdcCLIE(msjMQCREDITO.getMQCLIE());
	            datosTDC.setTdcTDCC(msjMQCREDITO.getMQTDCC());
	            datosTDC.setTdcTIPT(msjMQCREDITO.getMQTIPT());
	            datosTDC.setTdcTASC(msjMQCREDITO.getMQTASC());
	            datosTDC.setTdcTASD(msjMQCREDITO.getMQTASD());
	            datosTDC.setTdcLIMC(msjMQCREDITO.getMQLIMC());
	            datosTDC.setTdcSALA(msjMQCREDITO.getMQSALA());
	            datosTDC.setTdcSALD(msjMQCREDITO.getMQSALD());
	            datosTDC.setTdcSALC(msjMQCREDITO.getMQSALC());
	            datosTDC.setTdcFECC(msjMQCREDITO.getMQFECC());
	            datosTDC.setTdcPAGM(msjMQCREDITO.getMQPAGM());
	            datosTDC.setTdcFELP(msjMQCREDITO.getMQFELP());
	            datosTDC.setTdcLIMDE(msjMQCREDITO.getMQLIMDE());
	            datosTDC.setTdcDIPEF(msjMQCREDITO.getMQDIPEF());
	            datosTDC.setTdcDISPE(msjMQCREDITO.getMQDISPE());
	            datosTDC.setTdcPGYCR(msjMQCREDITO.getMQPGYCR());
	            datosTDC.setTdcPPAPL(msjMQCREDITO.getMQPPAPL());
	            datosTDC.setTdcNVCR(msjMQCREDITO.getMQNVCR());
	            datosTDC.setTdcPERI(msjMQCREDITO.getMQPERI());
	            datosTDC.setTdcDIASP(msjMQCREDITO.getMQDIASP());
	            datosTDC.setTdcINTER(msjMQCREDITO.getMQINTER());
	            datosTDC.setTdcPTOS(msjMQCREDITO.getMQPTOS());
	            datosTDC.setTdcPTOC(msjMQCREDITO.getMQPTOC());
	            datosTDC.setTdcPTPV(msjMQCREDITO.getMQPTPV());
	            datosTDC.setTdcFPTPV(msjMQCREDITO.getMQFPTPV());
	            datosTDC.setTdcRESP(msjMQCREDITO.getMQRESP());
	            datosTDC.setTdcDESR(msjMQCREDITO.getMQDESR());
	            datosTDC.setTdcCXOC(msjMQCREDITO.getMQCXOC());
	            datosTDC.setTdcMQPPOP(msjMQCREDITO.getMQPPOP());
	            
	            double pagNoIntereses=tdcDao.getPagoNoIntereses(datosTDC);
	            if(pagNoIntereses<=0.00)pagNoIntereses=0.00;
	            datosTDC.setTdcPANGI(datosTDC.addMoneyMask(pagNoIntereses));

	            if(!datosTDC.getTdcRESP().equals("")&&!datosTDC.getTdcRESP().equals("0")){
	            	datosTDC.setTdcSALC("");
	            	throw new AfirmeNetException("0003","Ha ocurrido un error al intentar validar la informacion. Por favor, intente dentro de 15 minutos.");
	            }
        		
        	}
        	
        }catch(SocketTimeoutException e){
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
		return datosTDC;

	}

	@Override
	public List<String> getListaBeanTDCAfirme() {
		return tdcDao.getListaBeanTDCAfirme();
	}

}
