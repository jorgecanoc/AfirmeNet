package com.afirme.afirmenet.service.impl.pagos.impuestos;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.helper.transferencia.TransferenciaHelper;
import com.afirme.afirmenet.ibs.messages.DTLPRDSJVMessage;
import com.afirme.afirmenet.ibs.messages.ELEERRMessage;
import com.afirme.afirmenet.ibs.messages.HDRPRDSJVMessage;
import com.afirme.afirmenet.ibs.messages.SUMPRDSJVMessage;
import com.afirme.afirmenet.model.pagos.impuestos.Concepto;
import com.afirme.afirmenet.model.pagos.impuestos.Conceptos;
import com.afirme.afirmenet.model.pagos.impuestos.ConceptosImpuestosIdentificacion;
import com.afirme.afirmenet.model.pagos.impuestos.Impuesto;
import com.afirme.afirmenet.model.pagos.impuestos.TipoImpuesto;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.FinDiaService;
import com.afirme.afirmenet.service.pagos.impuestos.ImpuestosService;
import com.afirme.afirmenet.service.transferencia.TransferenciaAfirmeNet;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

@Service("pagoImpuestosServiceImpl")
public class PagoImpuestosServiceImpl implements TransferenciaAfirmeNet {
	
	static final Logger LOG = LoggerFactory.getLogger(PagoImpuestosServiceImpl.class);
	@Autowired
	protected FinDiaService finDiaService;
	
	@Autowired
	protected ImpuestosService service;
	
	@Override
	public <T extends TransferenciaBase> ComprobanteTransferencia ejecutaTransferencia(
			T TransferenciaBase) throws AfirmeNetException {
		// Declaracion de Variables
		Impuesto impuesto = (Impuesto) TransferenciaBase;
		
		Comprobante comprobante = new Comprobante(impuesto);
		HDRPRDSJVMessage header = null;
		DTLPRDSJVMessage detail = null;
		SUMPRDSJVMessage summary = null;
		
		Socket socket = null;
		MessageContext messageContext = null;
		MessageRecord newmessage = null;
		
		//Validar fin de dia
		String finDiaError = finDiaService.getFinDia();
		if(finDiaError.equals("1") || finDiaError.equals("2")){
			throw new AfirmeNetException("0000",
					"Por el momento no se puede ejecutar su operacion. El horario no es valido");			
		}
		
		//Inserta el certificado generado 
		try{
			service.insertaCertificadoDigital(impuesto);
		}catch(Exception e){
			LOG.info("Error al insertar el certificado digital: " + impuesto);
			LOG.error("Error al insertar el certificado digital ",e);
		}
		
		// Invocacion del Socket
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

		//Se llena el header de la transaccion, detalles y summary
		
		try{
			//Informacion del Header
			header = (HDRPRDSJVMessage) messageContext.getMessageRecord("HDRPRDSJV");
			setHeaderInfo(header, impuesto);
			//Se envia la informacion a AS400
			header.send();
			header.destroy();			
			//Informacion de los detalles
			sendDetailInfo(detail, impuesto, messageContext);
			//Informacion Resumen
			summary = (SUMPRDSJVMessage) messageContext.getMessageRecord("SUMPRDSJV");
			summary.setSU_USER(impuesto.getContratoId());
			summary.setSU_TRNCDE("0");
			summary.setSU_TIPREG("S");
			summary.setSU_SECSUM(String.valueOf(impuesto.getConceptos().size() + 2));
			summary.setSU_FOLIO(impuesto.getFolioPago());
			summary.setSU_RFC(impuesto.getRfc());
			summary.setSU_CADENA(impuesto.getCadenaGenerada());
			summary.setSU_SELLO(impuesto.getCertificadoDigital());			
			summary.send();
			summary.destroy();
			
		} catch (Exception e) {
			throw new AfirmeNetException("0003","Por el momento no se puede ejecutar su operacion.");
		}
		
		boolean goHead = false;
		String errorNumber = "";
		String errorMessage = "";
		Map<CodigoExcepcion, String> errores = new HashMap<CodigoExcepcion, String>(0);
		//Se lee la respuesta de 400
		try{
			newmessage = messageContext.receiveMessage();
			goHead = ((ELEERRMessage) newmessage).getERRNUM().equals("0");
			errorNumber = ((ELEERRMessage) newmessage).getERNU01();
			if(errorNumber.equals("6223")){
				errorMessage="Sr. Contribuyente, el SAT le informa:<br>A partir de febrero del 2012 las Personas Morales están obligadas a utilizar el Servicio de Pago Referenciado para presentar sus pagos provisionales o definitivos de impuestos federales, no deben utilizar el esquema anterior de pagos electrónicos.";
			}else{
				errorMessage = ((ELEERRMessage) newmessage).getERDS01();
			}
			if(StringUtils.isEmpty(errorMessage)){
				errores.put(CodigoExcepcion.ERR_3000, errorMessage);	
			}
			errorNumber = ((ELEERRMessage) newmessage).getERNU02();
			if(!errorNumber.equals("6223")){
				errorMessage = ((ELEERRMessage) newmessage).getERDS02();
			}
			if(StringUtils.isEmpty(errorMessage)){
				errores.put(CodigoExcepcion.ERR_3000, errorMessage);	
			}
			
			errorNumber = ((ELEERRMessage) newmessage).getERNU03();
			if(!errorNumber.equals("6223")){
				errorMessage = ((ELEERRMessage) newmessage).getERDS03();
			}
			if(StringUtils.isEmpty(errorMessage)){
				errores.put(CodigoExcepcion.ERR_3000, errorMessage);	
			}

			errorNumber = ((ELEERRMessage) newmessage).getERNU04();
			if(!errorNumber.equals("6223")){
				errorMessage = ((ELEERRMessage) newmessage).getERDS04();
			}
			if(StringUtils.isEmpty(errorMessage)){
				errores.put(CodigoExcepcion.ERR_3000, errorMessage);	
			}
			if (!goHead) {
				comprobante.getErrores().putAll(errores);
			}else{
				
				comprobante.setBankName("AFIRME");
				comprobante.setPlazaReceiving(TransferenciaHelper.getPlazaName(comprobante
						.getPlazaReceiving()));
				comprobante.setAfirmeNetReference(impuesto.getAfirmeNetReference());
			
				//TODO: Pendiente insertar el impuesto
			}
			
        }catch(SocketTimeoutException e){
        	throw new AfirmeNetException("0003","Ha ocurrido un error al intentar validar la informacion. Por favor, intente dentro de 15 minutos.");
        }catch (Exception e) {
			throw new AfirmeNetException("0003",
					"Por el momento no se puede ejecutar su operacion."
							+ e.getMessage());
		}finally {

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		return comprobante;
	}
	private void sendDetailInfo(DTLPRDSJVMessage detail , Impuesto impuesto,MessageContext messageContext) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException{
		
		int secuencia = 2;
		String claveConcepto = "";
		for(int index=0; index< impuesto.getConceptos().size(); index++,secuencia++){
			
			Conceptos conceptos = impuesto.getConceptos().get(index);
			
			claveConcepto = conceptos.getConceptos().get(0).getClave().substring(0, 3);
			
			detail = (DTLPRDSJVMessage) messageContext.getMessageRecord("DTLPRDSJV");
			detail.setDT_USER(impuesto.getContratoId());
			if(impuesto.getTipoImpuesto().equals(TipoImpuesto.DERECHOS)){
				Conceptos conceptosTemp  = conceptos;
				if(claveConcepto.contains("120")){
					conceptosTemp = impuesto.getConceptos().get(index - 1);
				}

				
				detail.setDT_CADENA(Concepto.getValorConcepto(conceptosTemp.getConceptos(), "14734")); //14734 - Cadena de la dependencia				
				detail.setDT_CONTAB("0");
				detail.setDT_DEPEND(Concepto.getValorConcepto(conceptosTemp.getConceptos(), "30005"));//30005 - dependencia
				detail.setDT_DPA(Concepto.getValorConcepto(conceptosTemp.getConceptos(), "14733"));//14733 - Clave DPA				
			}	
			detail.setDT_TRNCDE("0");
			detail.setDT_TIPREG("D");
			detail.setDT_SECDET(String.valueOf(secuencia));
			detail.setDT_FOLIO(impuesto.getFolioPago());
			detail.setDT_RFC(impuesto.getRfc());	
			detail.setDT_CLAVE(claveConcepto);
			detail.setDT_FECPRE(impuesto.getValidationDate());
			detail.setDT_HORPRE(impuesto.getValidationHour() + ":" + impuesto.getValidationMinute());		
			

			detail.setDT_PERIOD(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "02"));
			detail.setDT_EJERCI(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "27"));
			detail.setDT_TIPPAG(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "22"));
			detail.setDT_FECPAG(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "23"));
			detail.setDT_AFAVOR(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "03"));
			detail.setDT_ACARGO(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "04"));
			detail.setDT_PARACT(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "05"));
			detail.setDT_RCARGO(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "06"));
			detail.setDT_MULTA(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "07"));
			detail.setDT_TOTCON(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "08"));
			detail.setDT_CRSALA(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "09"));
			detail.setDT_COMPEN(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "14"));
			detail.setDT_CRDIES(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "10"));
			detail.setDT_DIEAUT(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "24"));
			detail.setDT_CARRET(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "25"));
			detail.setDT_AGAVE(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "26"));
			detail.setDT_OTREST(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "12"));
			detail.setDT_CERTIF(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "13"));
			detail.setDT_MONANT(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "15"));
			detail.setDT_TOTAPL(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "16"));
			detail.setDT_CANCAR(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "17"));			
			detail.setDT_PARCIA(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "18"));
			detail.setDT_NOPARC(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "19"));
			detail.setDT_PAGEXC(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "21"));
			detail.setDT_CANPAG(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "20"));
			detail.setDT_UTILID(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "28"));
			detail.setDT_FECDEC(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "29"));			
			detail.setDT_NUMSAT(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "30"));			
			detail.setDT_NUMCRE(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "31"));
			detail.setDT_ENTIDA(Concepto.getValorConcepto(conceptos.getConceptos(), claveConcepto + "32"));
			
			detail.send();
			detail.destroy();
			
		}

	}
	
	private void setHeaderInfo(HDRPRDSJVMessage header, Impuesto impuesto){
		
		String apellidoPaterno="";
		String apellidoMaterno="";
		String nombre="";
		String cia="";
		String curp="";
		String totalPagado ="";

		Concepto conceptoCia = Concepto.getConcepto(impuesto.getIdentificacion().getConceptos(), ConceptosImpuestosIdentificacion.DENOMINACION.getValor()); 
		Concepto conceptoNombre = Concepto.getConcepto(impuesto.getIdentificacion().getConceptos(), ConceptosImpuestosIdentificacion.NOMBRE.getValor());
		Concepto conceptoPaterno = Concepto.getConcepto(impuesto.getIdentificacion().getConceptos(), ConceptosImpuestosIdentificacion.APELLIDO_PATERNO.getValor());
		Concepto conceptoMaterno = Concepto.getConcepto(impuesto.getIdentificacion().getConceptos(), ConceptosImpuestosIdentificacion.APELLIDO_MATERNO.getValor());
		Concepto conceptoCurp = Concepto.getConcepto(impuesto.getIdentificacion().getConceptos(), ConceptosImpuestosIdentificacion.CURP.getValor());
		Concepto conceptoTotal = Concepto.getConcepto(impuesto.getIdentificacion().getConceptos(),  ConceptosImpuestosIdentificacion.TOTAL_EFECTIVAMENTE_PAGADO.getValor());
		
		cia = conceptoCia != null ? conceptoCia.getValorImpresion() : "";
		nombre = conceptoNombre != null ? conceptoNombre.getValorImpresion(): "";
		apellidoPaterno = conceptoPaterno != null ? conceptoPaterno.getValorImpresion(): "";
		apellidoMaterno = conceptoMaterno != null ? conceptoMaterno.getValorImpresion():"";
		curp = conceptoCurp != null ? conceptoCurp.getValorImpresion():"";
		totalPagado = conceptoTotal != null ? conceptoTotal.getValor():"0";
		
		header.setHD_USER(impuesto.getContratoId());
		header.setHD_TRNCDE("0");
		header.setHD_TIPREG("E");
		header.setHD_SEC("1");
		header.setHD_FOLIO(impuesto.getFolioPago());
		header.setHD_MONEDA("MXP");
		header.setHD_CCARGO(impuesto.getOrigen().getNumber());
		header.setHD_CLTE("0");
		header.setHD_IMPORT(totalPagado);
		header.setHD_NUM(impuesto.getTipoImpuesto().getValor());
		header.setHD_RFC(impuesto.getRfc());
		header.setHD_APPA(apellidoPaterno);
		header.setHD_APMA(apellidoMaterno);
		header.setHD_NOMB(nombre);
		header.setHD_EMP(cia);
		header.setHD_APRE("20" + impuesto.getValidationYear());
		header.setHD_MPRE(impuesto.getValidationMonth());
		header.setHD_DPRE(impuesto.getValidationDay());
		header.setHD_CURP(curp);
		header.setHD_VER(impuesto.getTipoImpuesto().getVersion());		
	}
	@Override
	public List<? extends ComprobanteTransferencia> ejecutaTransferencia(
			List<TransferenciaBase> transferencias) {
		List<ComprobanteTransferencia> comprobantes = new ArrayList<ComprobanteTransferencia>(
				0);
		for (TransferenciaBase tx : transferencias) {
			try {
				if(tx.getErrores() == null || tx.getErrores().isEmpty()){
					comprobantes.add(ejecutaTransferencia(tx));
				}else{
					Comprobante comprobante = new Comprobante(tx);
					comprobantes.add(comprobante);
				}
				
			} catch (AfirmeNetException e) {
				Comprobante comprobante = new Comprobante(tx);
				Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
						0);
				CodigoExcepcion error = CodigoExcepcion.findByValue(Integer
						.valueOf(e.getErrCode()));
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

