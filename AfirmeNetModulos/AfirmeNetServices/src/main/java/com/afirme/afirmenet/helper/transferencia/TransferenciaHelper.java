package com.afirme.afirmenet.helper.transferencia;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.beans.JBTefbanpf;
import com.afirme.afirmenet.ibs.databeans.SPAPLAPF;
import com.afirme.afirmenet.ibs.messages.ECONFDSMessage;
import com.afirme.afirmenet.ibs.messages.ECONFDSPEIMessage;
import com.afirme.afirmenet.ibs.messages.ELEERRMessage;
import com.afirme.afirmenet.ibs.messages.IN095701Message;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Divisa;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

public class TransferenciaHelper {
	static final Logger LOG = LoggerFactory
			.getLogger(TransferenciaHelper.class);
	public static String PROCODE_SPEI_MOVIL = "93";
	
	@SuppressWarnings("unchecked")
	public static String getBankName(String bankcode) {
		String bankName = "";
		for (JBTefbanpf bank : (List<JBTefbanpf>) AfirmeNetConstants.bankList) {
			if (bank.getBANCVE().equals(bankcode)) {
				bankName = bank.getBANNOM();
				return bankName;
			}
		}
		return bankName;
	}

	@SuppressWarnings("unchecked")
	public static String getPlazaName(String plazacode) {
		String plazaName = "";
		for (SPAPLAPF plaza : (List<SPAPLAPF>) AfirmeNetConstants.plazaList) {
			if (plaza.getPLANUM().equals(plazacode)) {
				plazaName = plaza.getPLANOM();
				return plazaName;
			}
		}
		return plazaName;
	}

	public void setAS400Data(IN095701Message afitrans, TransferenciaBase transferenciaBase) {
		
		afitrans.setINEUSR(transferenciaBase.getUserId());// UserIdJSP
		afitrans.setINEFRMACC(transferenciaBase.getDebitAccount());// transbean.getDEBACC()
		afitrans.setINEBNFACC(transferenciaBase.getCreditAccount());// transbean.getCREACC()
		afitrans.setINEAMT(transferenciaBase.getAmount());// transbean.getAMOUNT()
		afitrans.setINECCY(transferenciaBase.getCurrency());// transbean.getCCY()
		afitrans.setINEBNKCOD(transferenciaBase.getBankReceiving());// transbean.getBNKRECPTOR()
		afitrans.setINEBRNCOD(transferenciaBase.getPlazaReceiving());// transbean.getPLZRECPTOR()
		afitrans.setINEBNKFRM(transferenciaBase.getBankFrm());// transbean.getBNKFRM()
		afitrans.setINEDTP1(transferenciaBase.getNarrative());// transbean.getNARRA()
		afitrans.setINERFN(transferenciaBase.getUserReference());// transbean.getRefUsr()
		afitrans.setINEVDT1(transferenciaBase.getValidationMonth());// transbean.getVMM()
		afitrans.setINEVDT2(transferenciaBase.getValidationDay());// transbean.getVDD()
		afitrans.setINEVDT3(transferenciaBase.getValidationYear());// transbean.getVYY()
		afitrans.setINETIN(transferenciaBase.getValidationHour() + transferenciaBase.getValidationMinute() + "00");// transbean.getVHH() + transbean.getVSS() + "00"
		afitrans.setINEXPMTV(transferenciaBase.getTransactionCode());// transbean.getTYPTRF()
		afitrans.setINEIVA(transferenciaBase.getIva());// transbean.getIVA()
		afitrans.setINERFC(transferenciaBase.getRfc());// transbean.getRFC()
		afitrans.setINECOM(transferenciaBase.getCommision());// transbean.getFEES()
		afitrans.setINEDSC(transferenciaBase.getDescription());// transbean.getDESCRIP()
		afitrans.setINEMAILAD(transferenciaBase.getEmail());

		// Se define el tipo de cuenta
		String accountType = " ";
		int accountLength = transferenciaBase.getCreditAccount().length();
		if ("10".equals(transferenciaBase.getAccountType())) {
			accountType = transferenciaBase.getAccountType();
			afitrans.setINEXPMTV(PROCODE_SPEI_MOVIL);
		} else {
			if (accountLength == 9 || accountLength == 11) {
				accountType = "01";
			}
			if (accountLength == 16) {
				accountType = "03";
			}
			if (accountLength == 18) {
				accountType = "40";
			}
		}
		
		afitrans.setINEACCTYP(accountType);
		afitrans.setINEFRMATY("01");
		
		if (transferenciaBase.getTipoTransferencia().equals(TipoTransferencia.DOMINGO_ELECTRONICO)) {
			afitrans.setINEOPE("B");
			afitrans.setINEUS1(transferenciaBase.getUserId());
			afitrans.setINEBNFAD1("");// transbean.getBENENAME()
			afitrans.setINEBNFAD2("");// transbean.getBENEADD()
		} else {
			afitrans.setINEOPE("A");
			afitrans.setINEBNFAD1(transferenciaBase.getBeneficiaryName());// transbean.getBENENAME()
			afitrans.setINEBNFAD2(transferenciaBase.getEmailBeneficiary());// transbean.getBENEADD()			
		}
		
		if (transferenciaBase.getTipoTransferencia().equals(TipoTransferencia.TRANSFERENCIAS_INTERNACIONALES_DOLARES) || 
				transferenciaBase.getTipoTransferencia().equals(TipoTransferencia.TRANSFERENCIAS_INTERNACIONALES_MULTIMONEDA)) {
			
			if (transferenciaBase instanceof Divisa) {
				Divisa divisa = (Divisa) transferenciaBase;
				
				afitrans.setINEACCTYP("01");
				// Se usa el campo INEDSC (Descripcion) para especificar la cuenta destino
				afitrans.setINEDSC(divisa.getDestino().getNumber());
				// Si la transferencia es Multimoneda, se utiliza el monto en USD
				if (transferenciaBase.getTipoTransferencia().equals(TipoTransferencia.TRANSFERENCIAS_INTERNACIONALES_MULTIMONEDA))
					afitrans.setINEAMT(((Divisa) transferenciaBase).getMontoUSD());
				
				afitrans.setINEUS1(divisa.getContractId());
				afitrans.setINEUS2(divisa.getContractId());
				afitrans.setINEUS3(divisa.getContractId());
				afitrans.setINEBRNCOD("0");
				// Si se especificó intermediario
				if (!StringUtils.isEmpty(divisa.getIntermediarioCuenta())) {
					// Se concatena el no. de cuenta con la divisa
					afitrans.setINEDTP3(divisa.getTipoMoneda() + " " + divisa.getIntermediarioCuenta());
					// Si se determinó banco intermediario, se concatena el codigo SWIFT o ABA correspondiente concatenando Tipo de Codigo y Codigo
					afitrans.setINERFC(divisa.getProgrammingDate() + " " + divisa.getIntermediarioTipoCodigo() + "-" + divisa.getIntermediarioCodigo());
				} else {
					afitrans.setINEDTP3(divisa.getTipoMoneda());
					afitrans.setINERFC(divisa.getProgrammingDate());
				}
				// Description es usado como numero de cuenta destino
				afitrans.setINEDSC(divisa.getDestino().getNumber());
				
				if (transferenciaBase.getTipoTransferencia().equals(TipoTransferencia.TRANSFERENCIAS_INTERNACIONALES_DOLARES))
					afitrans.setINEDTP1(divisa.getNarrative());
			}
		}
		
		if(transferenciaBase.getTransactionCode().equals(TipoTransferencia.PAGO_DE_SERVICIOS.getValor())){

			//Valores especiales para pago de Servicios.			
			Servicio servicio =(Servicio)transferenciaBase;
			if(servicio.getTipoServicio().equals(TipoServicio.TELEFONOS_DE_MEXICO)){
				afitrans.setINEBNFACC(servicio.getLada()+servicio.getNumeroTelefonico());
				afitrans.setINEDTP1(servicio.getLada()+servicio.getNumeroTelefonico());
			}else if(servicio.getTipoServicio().equals(TipoServicio.LUZ_CFE)){
				afitrans.setINEBNFACC(servicio.getReferenceNumber().substring(0, 20));
				afitrans.setINEDTP1(servicio.getReferenceNumber());				
			}else{
				afitrans.setINEBNFACC(servicio.getReferenceNumber());
				afitrans.setINEDTP1(servicio.getReferenceNumber());
			}
			
			afitrans.setINEACCTYP("01");			
			afitrans.setINEMAILAD(servicio.getEmailBeneficiary());
			afitrans.setINEBNFAD1("");
			afitrans.setINEBNFAD2("");			
			afitrans.setINEBNFAD3(servicio.getTipoServicio().getValorComercial());
			afitrans.setINEDTP2(servicio.getIdServicio400().toString());
			afitrans.setINEDTP3(servicio.getTipoServicio().getValor());
			
			
			
		}

		LOG.info("<=====Cargo====>");
		LOG.info("Codigo Tx  ====>" + transferenciaBase.getTransactionCode());
		LOG.info("Monto      ====>" + transferenciaBase.getAmount());
		LOG.info("User       ====>" + transferenciaBase.getUserId());
		LOG.info("Cta Debit  ====>" + transferenciaBase.getDebitAccount());
		LOG.info("Cta Credit ====>" + transferenciaBase.getCreditAccount());
		LOG.info("Ref Num    ====>" + transferenciaBase.getReferenceNumber());
		LOG.info("Data       ====>" + afitrans.toString());
	}

	public Comprobante evaluaRespuestaAS400(MessageContext messageContext,
			TransferenciaBase transferenciaBase) {
		MessageRecord messageRecord = null;
		Comprobante comprobante = null;
		boolean goHead = false;
		String errorNumber = "";
		String errorMessage = "";
		try {
			// Se recibe info si ocurrio un error o no
			messageRecord = messageContext.receiveMessage();
			goHead = ((ELEERRMessage) messageRecord).getERRNUM().equals("0");
			errorNumber = ((ELEERRMessage) messageRecord).getERNU01();
			errorMessage = ((ELEERRMessage) messageRecord).getERDS01();
			if (!goHead) {// Ocurrio un error
				// Llenar el comprobante con los errores detectados con 400
				comprobante = new Comprobante(transferenciaBase);
				Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
						0);
				// Busca la Excepcion
				CodigoExcepcion error = CodigoExcepcion.findByValue(Integer
						.valueOf(errorNumber));
				if (error == null) {
					// Error generico
					error = CodigoExcepcion.ERR_3000;
					errors.put(error, errorMessage);
				} else {
					errors.put(error, errorMessage);
				}
				comprobante.setErrores(errors);
			} else {
				// Se recibe la informacion de la operacion si no se genero un
				// error previo
				messageRecord = messageContext.receiveMessage();
				// La transferencia puede ser SPEI o TEF
				if (messageRecord
						.getClass()
						.getName()
						.equals("com.afirme.afirmenet.ibs.messages.ECONFDSPEIMessage")) {
					String referenceNumber = (((ECONFDSPEIMessage) messageRecord)
							.getEXNFREF());
					String trackingCode = (((ECONFDSPEIMessage) messageRecord)
							.getEXCVRA());
					String speiReference = (((ECONFDSPEIMessage) messageRecord)
							.getEXREFER());
					if (speiReference.equals("0")) {
						speiReference = "";
					}
					// Actualiza DC_TAFIRME
					// valobj.procUPREFEAFI(REFENUM, transbean.getDCIBS_REF(),
					// transbean.getENTITYID());
					// Llenar el comprobante con la operacion efectuada
					comprobante = new Comprobante(transferenciaBase);
					if (comprobante.getBankReceiving().equals("62")) {
						comprobante.setBankName("AFIRME");
					} else {
						comprobante.setBankName(getBankName(comprobante
								.getBankReceiving()));
					}
					comprobante.setPlazaReceiving(getPlazaName(comprobante
							.getPlazaReceiving()));
					comprobante.setAfirmeNetReference(referenceNumber);
					comprobante.setTrackingCode(trackingCode);
					comprobante.setSpeiReference(speiReference);

				} else {
					String referenceNumber = (((ECONFDSMessage) messageRecord)
							.getECNFREF());
					// Actualiza DC_TAFIRME
					// valobj.procUPREFEAFI(REFENUM, transbean.getDCIBS_REF(),
					// transbean.getENTITYID());
					// Llenar el comprobante con la operacion efectuada
					comprobante = new Comprobante(transferenciaBase);
					if (comprobante.getBankReceiving().equals("62")) {
						comprobante.setBankName("AFIRME");
					} else {
						comprobante.setBankName(getBankName(comprobante
								.getBankReceiving()));
					}
					comprobante.setPlazaReceiving(getPlazaName(comprobante
							.getPlazaReceiving()));
					comprobante.setAfirmeNetReference(referenceNumber);
				}
			}
        }catch(SocketTimeoutException e){
        	throw new AfirmeNetException("0003","Ha ocurrido un error al intentar validar la informacion. Por favor, intente dentro de 15 minutos.");
        }catch (Exception e) {
			throw new AfirmeNetException("0003",
					"Por el momento no se puede ejecutar su operacion."
							+ e.getMessage());
		}
		return comprobante;
	}
}
