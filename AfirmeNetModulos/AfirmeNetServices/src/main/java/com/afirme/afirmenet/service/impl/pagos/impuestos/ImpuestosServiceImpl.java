package com.afirme.afirmenet.service.impl.pagos.impuestos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.pagos.impuestos.ImpuestosDao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.helper.pagos.impuestos.ImpuestosHelper;
import com.afirme.afirmenet.model.pagos.impuestos.Concepto;
import com.afirme.afirmenet.model.pagos.impuestos.Conceptos;
import com.afirme.afirmenet.model.pagos.impuestos.Impuesto;
import com.afirme.afirmenet.service.pagos.impuestos.ImpuestosService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.SocketFactory;

@Service
public class ImpuestosServiceImpl implements ImpuestosService {
	static final Logger LOG = LoggerFactory
			.getLogger(ImpuestosServiceImpl.class);


	
	@Autowired
	protected ImpuestosDao impuestosDao;

	@Override
	public String generaLlaveDePago(String sFecha, String sMes, String pNombre,
			String pTotal, String pNoOperacion) {
		ImpuestosHelper helper = new ImpuestosHelper();
		return helper.generaLlaveDePago(sFecha, sMes, pNombre, pTotal,
				pNoOperacion);
	}

	@Override
	public String generaTimbradoDigital(String cadena) {
		ImpuestosHelper helper = new ImpuestosHelper();
		return helper.generaTimbradoDigital(cadena);
	}

	@Override
	public String generaFolioFiscal(String contratoId, String rfc) {
		ImpuestosHelper helper = new ImpuestosHelper();
		return helper.generaFolioFiscal(contratoId, rfc);
	}

	@Override
	public void insertaCertificadoDigital(Impuesto impuesto) {
		// Genera la cadena de certificacion
		String certificado = generaCertificadoDigital(
				impuesto.getCadenaOriginal(), impuesto.getFolioPago(),
				impuesto.getValidationDate(), impuesto.getValidationHour()
						+ ":" + impuesto.getValidationMinute(),
				impuesto.getLlavePago(), impuesto.getConceptos());
		
		String sello = sellaCertificado(certificado);
		impuesto.setCertificadoDigital(sello);
		impuesto.setCadenaGenerada(certificado);
		
		impuestosDao.insertaCertificadoDigital(impuesto);
	}
	
	private String sellaCertificado(String certificado){
		Socket socket = null;
		BufferedWriter out = null;
		BufferedReader in = null;		
		String codigoCertificado = null;
		String codigoValidacion = null; 
		// Invocacion del Socket
		try {
			socket = SocketFactory.getSocket(AfirmeNetConstants.SSL_SOCKET_IP,
					AfirmeNetConstants.SSL_SOCKET_PUERTO);
			out = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			//Envia la Cadena
			out.write(certificado);
			out.flush();	
			//Espera la respuesta
			codigoCertificado = in.readLine();
			//Lee la respuesta y asigna el codigo de validacion 
			codigoValidacion = codigoCertificado.substring(0, 4);
			
			if (!codigoValidacion.equals("0172")) {//Codigo invalido
				throw new AfirmeNetException("0000",
						"Por el momento no se puede ejecutar su operacion. No puede generarse el certificado digital");				
			}else{
				codigoCertificado = codigoCertificado.substring(4, codigoCertificado.length());
			}
		} catch (SocketFactoryException e) {
			throw new AfirmeNetException("0000",
					"Por el momento no se puede ejecutar su operacion. No puede generarse el certificado digital");
		} catch (IOException e) {
			throw new AfirmeNetException("0000",
					"Por el momento no se puede ejecutar su operacion. No puede generarse el certificado digital");
		}finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		return codigoCertificado;
	}

	private String generaCertificadoDigital(String cadenaOriginal,
			String folioPago, String fechaOperacion, String horaPago,
			String llavePago, List<Conceptos> conceptosList) {
		//Declaracion de variables
		String INICIO_FIN_CADENA ="||";
		String INICIO_FIN_CAMPO ="|";		
		StringBuilder cadenaFinal = new StringBuilder();
		//Se remueven incio y fin de cadena  
		cadenaOriginal = cadenaOriginal.substring(2, cadenaOriginal.length() - 2);	
		
		//Se inicializa el builder
		cadenaFinal.append(INICIO_FIN_CADENA);
		
		String[] tokens =  cadenaOriginal.trim().split("\\|");
		for (String token : tokens) {
			String[] parValue = token.split("=");
			if(parValue.length ==1 || parValue[1] == null || StringUtils.isEmpty(parValue[1])){
				//Valida si son codigos Default
				if(parValue[0].equals("20001")){ //Codigo de Banco va Fijo
					cadenaFinal.append(token.trim()+ "40062");
				}else if(parValue[0].equals("20002")){//Folio de Pago
					cadenaFinal.append(token.trim()+ folioPago);
				}else if(parValue[0].equals("40002")){//Fecha Operacion
					cadenaFinal.append(token.trim()+ fechaOperacion);
				}else if(parValue[0].equals("40003")){ //Hora del pago
					cadenaFinal.append(token.trim()+ horaPago);
				}else if(parValue[0].equals("40008")){ //Llave del Pago 
					cadenaFinal.append(token.trim()+ llavePago);
				}else if(parValue[0].equals("30003")){ //Certificado
					cadenaFinal.append(token.trim()+ AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.SSL_CERNUM, String.class));
				}else if(parValue[0].equals("30004")){ //Blanco (No se incluye)	NA
					continue;					
				}else{ //Busca Valor en Conceptos
					Concepto concepto = null;
					for(Conceptos conceptos : conceptosList){
						concepto = Concepto.getConcepto(conceptos.getConceptos(), parValue[0].trim());
						if(concepto != null){
							break;
						}
					}
					cadenaFinal.append(token.trim()+ concepto != null ? concepto.getValor():"0");					
				}
				
			}else{
				cadenaFinal.append(token);
			}

			cadenaFinal.append(INICIO_FIN_CAMPO);
			
			LOG.debug("Cadena Generada ===> " + cadenaFinal.length()+ cadenaFinal.toString());
		}
		//Remueve ultimo caracter
		String cadenaSello = cadenaFinal.substring(0, cadenaFinal.length() -1) + INICIO_FIN_CADENA;
		
		return String.format("%04d", cadenaSello.length()) + cadenaSello.toString();
	}

}
