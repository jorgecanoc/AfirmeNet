package com.afirme.afirmenet.helper.pagos;

import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.enums.ConceptoGDF;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.generics.ConvierteBase;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.ibs.messages.ECONFDSMessage;
import com.afirme.afirmenet.ibs.messages.ELEERRMessage;
import com.afirme.afirmenet.ibs.messages.INFORMU01Message;
import com.afirme.afirmenet.model.pagos.ImpuestoGDF;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

public class ImpuestosGDFHelper {
	
	static final Logger LOG = LoggerFactory.getLogger(ImpuestosGDFHelper.class);
	
	/**
	 * Obtiene el Modelo a partir de la Linea de Captura Base
	 * @param impuesto
	 * @return Modelo
	 */
	public static String getModelo(ImpuestoGDF impuesto) {
		try {
			String anio;
			switch (impuesto.getConceptoGDF()) {
				case TRAM_VEHICULAR: case MEDIO_AMB_VERFIC_EXTEMP: 
					anio = impuesto.getLineaCapturaBase().substring(16, 18);
				break;
				case MULTA_REV_VEHICULAR: case TENENCIA:
					anio = impuesto.getLineaCaptura().substring(3,5);
				break;
			default:
					anio = "";
				break;
			}
			if (Integer.parseInt(anio) < 40)
				return "20" + anio;
			else
				return "19" + anio;
		} catch (NumberFormatException e) {
			return "";
		}
	}
	
	/**
	 * Obtiene la Placa a partir de la Linea de Captura
	 * @param lineaCaptura
	 * @return Placa
	 */
	public static String getPlaca(String lineaCaptura) {
		String placa = lineaCaptura.substring(5,13);
		placa = placa.replaceAll("X", "");
		
		int placaLength = 0;
		for (int i = 0; i < placa.length(); i++) {
			if (Character.isDigit(placa.charAt(i)))
				placaLength++;
		}
		if (placaLength == 4)
			return "X" + placa;
		else
			return placa;
	}
	
	/**
	 * Obtiene el Folio Infraccion
	 * @param lineaCaptura
	 * @return Folio Infraccion
	 */
	public static Long getFolioInfraccion(String lineaCaptura) {
		String linea = lineaCaptura.substring(2,13);
		String[] arr = split(linea,'X');
		Long lineaFinal;
		try {
			lineaFinal = new Long(arr[1].toUpperCase());
		} catch (Exception e) {
			LOG.error("Error de conversion de datos." + e.getMessage());
			lineaFinal = new Long(0);
		} 
		return lineaFinal;
	}
	
	/**
	 * Remueve los caracteres especificados de un String 
	 * @author Luisa Rodriguez
	 */
	public static String[] split(String args, char comp) {
		String[] arr = new String[10];
		String letra = "";
		int cont = 0;

		for (int i = 0; i < args.length(); i++) {
			if (args.charAt(i) != comp) {
				letra += args.charAt(i);
			} else {
				arr[cont] = letra;
				cont++;
				letra = "";
			}
		}
		if (letra != "") {
			arr[cont] = letra;
		}
		return arr;
	}
	
	/**
	 * Obtiene la Clave de Verificacion
	 * @param lineaCaptura
	 * @return Clave de Verificacion
	 */
	public static int getClaveVerificacionCentro(String lineaCaptura) {
		String linea = lineaCaptura.substring(10, 12);
		boolean isNumber = false;
		int i;
		for (i = 0; i < linea.length(); i++) {
			if (Character.isDigit(linea.charAt(i))) {
				isNumber = true;
			} else {
				isNumber = false;
				break;
			}
		}
		if (isNumber) {
			int valorLinea = Integer.parseInt(linea);
			if (valorLinea > 0 && valorLinea < 99) {
				linea = "90" + linea;
			}
		} else {
			if (linea.equals("A1"))
				linea = "1069";
			if (linea.equals("A2"))
				linea = "1070";
			if (linea.equals("A3"))
				linea = "1071";
		}
		return Integer.parseInt(linea);
	}
	
	/**
	 * Método para obtener el número de cuenta predial
	 * @param lineaCaptura
	 * @return Cuenta Predial
	 */
	public static String getCuentaPredial(String lineaCaptura) {
		
		String cuenta = lineaCaptura.substring(2, 13);
		int digito = 0;
		int suma = 0;
		int[] ponderadores = { 2, 1 };
		// recorriendo cadenaValidar de derecha a izquierda
		// y multiplicando por los ponderadores, el resultado se suma
		for (int i = cuenta.length() - 1, j = 0; i >= 0; i--, j++) {
			j = j == ponderadores.length ? 0 : j;
			int multi = Character.getNumericValue(cuenta.charAt(i)) * ponderadores[j];
			String multi_aux = String.valueOf(multi);
			int m = 0;
			if (multi_aux.length() > 1) {
				for (int k = 0; k < multi_aux.length(); k++) {
					m += Character.getNumericValue(multi_aux.charAt(k));
				}
				multi = m;
			}
			suma += multi;
		}
		String aux_digito = (String.valueOf(suma));
		aux_digito = aux_digito.substring(aux_digito.length() - 1, aux_digito.length());
		digito = 10 - (Integer.valueOf(aux_digito)).intValue();
		digito = digito == 10 ? 0 : digito;
		cuenta += "-" + digito;
		
		return cuenta;
	}
	
	/**
	 * Regresa el año a partir de la línea de captura
	 * @param lineaCapturaBase
	 * @return Año de Ejercicio
	 */
	public static int getEjercicio(String lineaCapturaBase) {
		
		int ejercicio = 0;
		try {
			ejercicio = Integer.valueOf(lineaCapturaBase.substring(16, 17)).intValue();

			GregorianCalendar calendar = new GregorianCalendar();
			String anio = String.valueOf(calendar.get(GregorianCalendar.YEAR));

			int idClave = Integer.parseInt(lineaCapturaBase.substring(0, 2));

			if (idClave == 80) {
				ejercicio = calendar.get(GregorianCalendar.YEAR);
			} else {
				// otros conceptos
				if (ejercicio <= Integer.valueOf(anio.substring(3, 4)))
					ejercicio = Integer.valueOf(anio.substring(0, 3) + ejercicio).intValue();
				else {
					anio = (Integer.valueOf(anio).intValue() - 9) + "";
					ejercicio = Integer.valueOf(anio.substring(0, 3) + ejercicio).intValue();
				}
			}
		} catch (NumberFormatException nfe) {
		} catch (Exception e) {
		}

		return ejercicio;
	}
	
	/**
	 * Método para obtener bimestre, implícitamente determina y valida la fecha límite de pago
	 * @param lineaCapturaBase
	 * @return Bimestre
	 */
	public static String getBimestre(String lineaCapturaBase) {
		// Fecha limite
		GregorianCalendar fechaLimite = new GregorianCalendar();
		// Fecha de Pago
		GregorianCalendar gc = new GregorianCalendar();
		String bimestre = lineaCapturaBase.substring(17, 18);
		// Validación de pago adelantado
		if (bimestre.equals("0")) {
			switch (gc.get(Calendar.MONTH)) {
			case 0:
			case 1:
				bimestre = "1";
				fechaLimite = new GregorianCalendar(gc.get(Calendar.YEAR), Calendar.FEBRUARY, 28);
				if (gc.isLeapYear(gc.get(Calendar.YEAR)))
					fechaLimite.add(Calendar.DAY_OF_MONTH, 1);
				break;

			case 2:
			case 3:
				bimestre = "2";
				fechaLimite = new GregorianCalendar(gc.get(Calendar.YEAR), Calendar.APRIL, 30);
				break;

			case 4:
			case 5:
				bimestre = "3";
				fechaLimite = new GregorianCalendar(gc.get(Calendar.YEAR), Calendar.JUNE, 30);
				break;

			case 6:
			case 7:
				bimestre = "4";
				fechaLimite = new GregorianCalendar(gc.get(Calendar.YEAR), Calendar.AUGUST, 31);
				break;

			case 8:
			case 9:
				bimestre = "5";
				fechaLimite = new GregorianCalendar(gc.get(Calendar.YEAR), Calendar.OCTOBER, 31);
				break;

			case 10:
			case 11:
				bimestre = "6";
				fechaLimite = new GregorianCalendar(gc.get(Calendar.YEAR), Calendar.DECEMBER, 31);
				break;
			}
			
			bimestre = "Anticipado del " + bimestre + " al 6";
			fechaLimite = validaViSabDomAs(fechaLimite);
		}

		return bimestre;
	}

	/**
	 * Valida viernes, sábados, domingos y asuetos
	 * @param fechaLimite
	 * @return Fecha Limite
	 */
	public static GregorianCalendar validaViSabDomAs(GregorianCalendar fechaLimite) {

		while (fechaLimite.get(Calendar.DAY_OF_WEEK) == 6
				|| fechaLimite.get(Calendar.DAY_OF_WEEK) == 7
				|| fechaLimite.get(Calendar.DAY_OF_WEEK) == 1
				|| (fechaLimite.get(Calendar.YEAR) == 2008
						&& fechaLimite.get(Calendar.MONTH) == 2 && fechaLimite
						.get(Calendar.DAY_OF_MONTH) == 3)) {
			
			fechaLimite.add(Calendar.DAY_OF_MONTH, 1);
		}
		return fechaLimite;
	}
	
	/**
	 * Obtiene el RFC
	 * @param lineaCaptura
	 * @return RFC
	 */
	public static String getRfc(String lineaCaptura) {
		// Descarta la homo clave
		String lineaRFC = lineaCaptura.substring(2, 10);
		char[] arr;
		StringBuffer datos = new StringBuffer("");
		StringBuffer resultado = new StringBuffer("");
		boolean moral = false;
		char diaC;
		char mesC;
		int dia = 0;
		int mes = 0;
		int limite = 0;
		int revisar = 0;

		if (lineaCaptura.charAt(9) == 'X') {
			moral = true;
			limite = 5;
			revisar = 3;
			dia = 8;
			mes = 7;
		} else {
			limite = 6;
			revisar = 4;
			dia = 9;
			mes = 8;
		}

		String tipo = (moral ? "moral" : "fisica");
		System.out.println("Evaluando persona " + tipo);

		arr = lineaRFC.substring(0, limite).toCharArray();// limite
		for (int i = 0; i < revisar; i++) {// revisar
			if (Character.isDigit(arr[i])) {
				if (Character.getNumericValue(arr[i]) == 1)
					arr[i] = '&';
				if (Character.getNumericValue(arr[i]) == 2)
					arr[i] = 'Ñ';
			}
		}
		for (int i = 0; i < arr.length; i++)
			datos.append(arr[i]);
		resultado.append(datos.toString());

		diaC = lineaCaptura.charAt(dia);// diaNum
		mesC = lineaCaptura.charAt(mes);// mesNum
		dia = (int) ConvierteBase.convertB36ToB10(String.valueOf(diaC));
		mes = (int) ConvierteBase.convertB36ToB10(String.valueOf(mesC));
		if (mes < 10)
			resultado.append("0" + String.valueOf(mes));
		else
			resultado.append(String.valueOf(mes));
		if (dia < 10)
			resultado.append("0" + String.valueOf(dia));
		else
			resultado.append(String.valueOf(dia));
		
		resultado.append(lineaCaptura.substring(10, 13));

		return resultado.toString();
	}
	
	/**
	 * Obtiene el Digito Verificador de la Linea de Captura
	 * @param lineaCaptura
	 * @return Digito Verificador
	 */
	public static String getDigitoVerificador(String lineaCaptura) {
		String linea = lineaCaptura.substring(2, 13);
		int suma = 0;
		int mult = 0;
		int resultado = 0;
		String num = "";
		for (int i = 0; i < linea.length(); i++) {
			if (Character.isDigit(linea.charAt(i))) {
				if (i == 0 || i % 2 == 0) {
					mult = Character.getNumericValue(linea.charAt(i)) * 2;
					if (String.valueOf(mult).length() == 2) {
						num = String.valueOf(mult);
						mult = Character.getNumericValue(num.charAt(0)) + Character.getNumericValue(num.charAt(1));
					}
				} else {
					mult = Character.getNumericValue(linea.charAt(i)) * 1;
				}
				suma += mult;
				mult = 0;
				num = "";
			}
		}
		num = String.valueOf(suma);
		mult = Character.getNumericValue(num.charAt(num.length() - 1));
		if (mult == 0)
			resultado = 0;
		else
			resultado = 10 - mult;
		
		return String.valueOf(resultado);
	}
	
	/**
	 * Settea los valores recopilados de ImpuestoGDF al Mensaje AS400
	 * @param INFORMU01Message pago
	 * @param ImpuestoGDF impuesto
	 */
	public void setAS400Data(INFORMU01Message pago, ImpuestoGDF impuesto) {
		// impuesto.printOut();
		pago.setINCOPE("A");
		pago.setINTXPMTV(impuesto.getTipoTransferencia().getValor()); // Numero de Transaccion
		pago.setINTUSR(impuesto.getUserId()); // Contrato
		pago.setINTFECPAGO(new BigDecimal(Util.getYYYYMMDD())); // Fecha de Pago
		pago.setINTHORA(new BigDecimal(impuesto.getValidationHour() + impuesto.getValidationMinute())); // Hora de Programacion/Transaccion
		pago.setINTFECHA(new BigDecimal(impuesto.getValidationYear() + impuesto.getValidationMonth() + impuesto.getValidationDay())); //Fecha de Programacion
		pago.setINTMONEDA("MXP"); // Moneda
		pago.setINTCTACGO(new BigDecimal(String.valueOf(impuesto.getOrigen().getNumber()))); // Cuenta de Cargo
		pago.setINTBANCO(new BigDecimal("062")); // Clave de Banco
		pago.setINTLCAPT(impuesto.getLineaCaptura()); // Linea de Captura
		pago.setINTIMPORTE(new BigDecimal(String.valueOf(impuesto.getAmount()))); // Importe
		pago.setINTNOMBRE(impuesto.getNombre()); // Nombre
		pago.setINTDIREC(impuesto.getDomicilio()); // Domicilio
		pago.setINTCOLONIA(impuesto.getColonia()); // Colonia
		pago.setINTCODPOS(impuesto.getCodigoPostal()); // Codigo Postal
		pago.setINTDELEGA(impuesto.getDelegacion()); // Delegacion
		pago.setINTESTADO(impuesto.getEstado()); // Estado
		pago.setINTGRUPO(new BigDecimal(String.valueOf(impuesto.getIdGrupo()))); // ID Grupo
		pago.setINTCLAVE(new BigDecimal(String.valueOf(impuesto.getIdClave()))); // Clave del Concepto a Pagar
		
		switch (impuesto.getConceptoGDF()) {
		case LICENCIA_CONDUCIR:
			pago.setINTTIPO(impuesto.getTipoLicencia()); // Tipo
			pago.setINPERIODO(impuesto.getPeriodo()); // Periodo
			pago.setINTRFC(impuesto.getRfc()); // RFC
			break;
		case TRAM_VEHICULAR: case MULTA_REV_VEHICULAR: case MEDIO_AMB_VERFIC_EXTEMP:
			pago.setINTPLACA(impuesto.getPlaca());
			pago.setINTMODELO(new BigDecimal(impuesto.getModelo()));
			pago.setINTMARCA(impuesto.getMarca());
			pago.setINTORIGEN(impuesto.getOrigenTramite());
			break;
		case MULTA_INFRACCION:
			pago.setINTFOLIO(new BigDecimal(impuesto.getFolioInfraccion().toString()));
			break;
		case MEDIO_AMBIENTE_CONTAM:
			pago.setINTFOLIO(new BigDecimal(impuesto.getFolioInfraccion().toString()));
			pago.setINTANOINF(String.valueOf(impuesto.getAnioInfraccion()));
			break;
		case MEDIO_AMBIENTE_HOLOGR:
			pago.setINTCVEVER(String.valueOf(impuesto.getClaveVerificacion()));
			pago.setINTHOLOGR(impuesto.getTipoHolograma());
			pago.setINTCANT(String.valueOf(impuesto.getCantidad()));
			pago.setINTFOLIO(String.valueOf(impuesto.getFolio()));
			break;
		case REGISTRO_CIVIL: case REGISTRO_CIVIL_BUSQUEDA:
			pago.setINTFOLIO(String.valueOf(impuesto.getFolio()));
			pago.setINTCANT( String.valueOf(impuesto.getCantidad()));
			pago.setINTPREUNI(String.valueOf(impuesto.getPrecioUnitario()));
			break;
		case SERVICIO_POLICIA:
			pago.setINTFOLFACT(String.valueOf(impuesto.getFolioFactura()));
			break;
		case IMP_PREDIAL: case SUMINISTRO_AGUA:
			pago.setINTEJEIMP(String.valueOf(impuesto.getEjercicio()));
			pago.setINTBIM(String.valueOf(impuesto.getBimestre()));
			
			if (impuesto.getConceptoGDF() == ConceptoGDF.IMP_PREDIAL)
				pago.setINTCUENTA(impuesto.getCuentaPredial());
			else
				pago.setINTCUENTA(impuesto.getCuentaAgua());
			break;
		case TENENCIA:
			pago.setINTPLACA(impuesto.getPlaca());
			pago.setINTMODELO(impuesto.getModelo());
			pago.setINTMARCA(impuesto.getMarca());
			pago.setINTEJEIMP(String.valueOf(impuesto.getEjercicio()));
			pago.setINSUBMARCA(impuesto.getSubMarca());
			pago.setINTVALFACT(String.valueOf(impuesto.getValorFactura()));
			pago.setINTNCILIND(String.valueOf(impuesto.getCilindros()));
			break;
		case IMP_NOMINA:
			pago.setINTRFC(impuesto.getRfc());
			pago.setINTEJEFIS(String.valueOf(impuesto.getEjercicio()));
			pago.setINTMESIMP(impuesto.getMes());
			pago.setINTTIPO(impuesto.getTipoDeclaracion());
			pago.setINTRENUM(String.valueOf(impuesto.getRemuneracionesPagadas()));
			pago.setINTNUMTRAB(String.valueOf(impuesto.getNumeroTrabajadores()));
			break;
		case IMP_RIFAS: case IMP_HOSPEDAJE:
			pago.setINTRFC(impuesto.getRfc());
			pago.setINTEJEFIS(String.valueOf(impuesto.getEjercicio()));
			pago.setINTMESIMP(impuesto.getMes());
			pago.setINTFECEVEN(impuesto.getFechaEvento().replace(" de ", " ").replace(" DE ", " ").replace("tiembre ", " ").replace("TIEMBRE ", " ").replace("iembre ", " ").replace("IEMBRE ", " "));
			break;
		case IMP_INMUEBLES:
			pago.setINTCUENTA(impuesto.getCuentaPredial());
			pago.setINTTIPO(impuesto.getTipoOperacion());
			pago.setINTFECESC(impuesto.getFechaEscrituras());
			break;
		case REGISTRO_PUBLICO:
			pago.setINTFOLIO(String.valueOf(impuesto.getFolio()));
			pago.setINTRAMITE(impuesto.getTramite());
			pago.setINTNUMESC(impuesto.getNumeroEscritura().toString());
			break;
		case AUTO_NUEVO:
			pago.setINTRFC(impuesto.getRfc());
			pago.setINTEJEFIS(String.valueOf(impuesto.getEjercicio()));
			pago.setINTMESIMP(impuesto.getMes());
			break;
		case ISR_ENAJENACION:
			pago.setINTCUENTA(impuesto.getCuentaPredial());
			pago.setINTTIPO(impuesto.getTipoDeclaracion());
			pago.setINTNOTARIO(String.valueOf(impuesto.getNumeroNotario()));
			pago.setINTNUMESC(impuesto.getNumeroEscritura().toString());
			pago.setINVIGENCIA(impuesto.getVigencia().equals("Vencido") ? "1" : "0");
			pago.setINTSUBCPTO(impuesto.getClaveSubConcepto());
			pago.setINTCVETIPO(impuesto.getClaveTipoDeclaracion());
			break;
		case PAGOS_TESORERIA:
			pago.setINTREFPAGO(impuesto.getReferenciaPago());
			pago.setINTFOLIO(impuesto.getFolio()+"");
			pago.setINTCVEADTR(impuesto.getClaveAdminTributaria());
			break;
		default:
			LOG.error("Concepto no Implementado.");
			break;
		}
		// System.out.println(pago.toString());
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
			
			if (messageRecord instanceof ELEERRMessage){
				goHead = ((ELEERRMessage) messageRecord).getERRNUM().equals("0");
				errorNumber = ((ELEERRMessage) messageRecord).getERNU01();
				errorMessage = ((ELEERRMessage) messageRecord).getERDS01();
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
				
				if (messageRecord instanceof ECONFDSMessage) {
					String referenceNumber = (((ECONFDSMessage) messageRecord).getECNFREF());
					String userReference = (((ECONFDSMessage) messageRecord).getECNFUSER());
					if (StringUtils.isEmpty(userReference) || userReference.equals("0")) {
						userReference = "";
					}
					// Llenar el comprobante con la operacion efectuada
					comprobante = new Comprobante(transferenciaBase);
					comprobante.setAfirmeNetReference(referenceNumber);
					comprobante.setReferenceNumber(referenceNumber);
					comprobante.setSpeiReference(userReference);

				} else if (messageRecord instanceof INFORMU01Message) {
					String referenceNumber = (((INFORMU01Message) messageRecord).getINTREF());
					// Llenar el comprobante con la operacion efectuada
					comprobante = new Comprobante(transferenciaBase);
					comprobante.setAfirmeNetReference(referenceNumber);
					comprobante.setReferenceNumber(referenceNumber);
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