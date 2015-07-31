package com.afirme.afirmenet.helper.pagos.impuestos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.Normalizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.ibs.messages.ELEERRMessage;
import com.afirme.afirmenet.ibs.messages.FOLIODSJVMessage;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

public class ImpuestosHelper {
	static final Logger LOG = LoggerFactory.getLogger(ImpuestosHelper.class);
	long aTabla[] = new long[256];

	public String generaLlaveDePago(String sFecha, String sMes, String pNombre,
			String pTotal, String pNoOperacion) {
		// Declaracion de Variables
		String sLlave = "";
		int i = 0;
		long x = 0;
		char cTotal[];
		String sTotal = "";
		String sCadena1 = "";
		String sCadena2 = "";
		String sMesHex = "";
		String sCadena3 = "";
		char cResultadoDigito = ' ';

		// Prepara tabla para generar cadena
		doLlenaTabla();

		// En el total efectivamente pagado recibido eliminar los separadores de
		// miles (generalmente comas) y los decimales.
		cTotal = pTotal.toCharArray();
		for (i = 0; i < cTotal.length; i++) {
			if (cTotal[i] == ',' || cTotal[i] == '.') {
			} else {
				sTotal = sTotal + cTotal[i];
			}
			if (cTotal[i] == '.') {
				i = cTotal.length; // TRUNCAMOS EL PUNTO DECIMAL Y LO QUE SIGA
			}
		}

		// Concatenar los valores recibidos de la siguiente manera:
		// cadena1 = “S”+ numero de operación + nombre + ”T” + fecha +
		// total
		// efectivamente pagado + ”A”
		sCadena1 = "S" + pNoOperacion + pNombre + "T" + sFecha + sTotal + "A";

		// Convertir a mayúsculas las letras del nombre o razón social.
		String subjectString = sCadena1.toUpperCase();
		// Eliminar caracteres especiales
		subjectString = Normalizer
				.normalize(subjectString, Normalizer.Form.NFD);
		String resultString = subjectString.replaceAll("[^\\x00-\\x7F]", "");
		// Eliminar los espacios en blanco de cadena1
		sCadena1 = resultString.replaceAll("\\s+", "");

		x = this.doCalculaCrc32(sCadena1);

		// cadena2 = convertir_a_cadena(convertir_a_hexadecimal(x))
		sCadena2 = Long.toHexString(x);

		// Si en la conversion a hexadecimal de x, hay letras minusculas
		// contenidas en el resultado, convertir la cadena a letras mayusculas.
		sCadena2 = sCadena2.toUpperCase();

		// Si la longitud de cadena2 es menor a 8 caracteres, colocar ceros (0)
		// a la izquierda hasta alcanzar la longitud de 8 caracteres.
		sCadena2 = ("00000000" + sCadena2).substring(
				("00000000" + sCadena2).length() - 8,
				("00000000" + sCadena2).length());

		// if(sCadena2.length() < 8){
		// }
		// mes_hex = convertir_a_hexadecimal(x)
		// sMesHex = Long.toHexString((new
		// Long(sdfM.format(pFecha))).longValue()).toUpperCase();
		sMesHex = Long.toHexString((new Long(sMes)).longValue()).toUpperCase();

		// cadena3 = cadena2 + convertir_a_cadena(mes_hex)
		sCadena3 = sCadena2 + sMesHex;

		// resultado_digito = obtener_digitoverificador (cadena3)
		cResultadoDigito = this.getDigitoVerificador(sCadena3);

		// resultado_final = cadena2 + mes_hex + resultado_digito
		if (cResultadoDigito != (char) (209)) {
			sLlave = sCadena2 + sMesHex + cResultadoDigito;
		} else {
			sLlave = sCadena2 + sMesHex;
		}

		return sLlave;
	}

	public String generaTimbradoDigital(String cadena) {
		// Declaracion de variables
		Socket socket;
		BufferedWriter out = null;
		BufferedReader in = null;
		String timbreDigital = "";
		String digitoVerificador = "";

		// Invocacion del Socket
		try {
			socket = SocketFactory.getSocket(AfirmeNetConstants.SSL_SOCKET_IP,
					AfirmeNetConstants.SSL_SOCKET_PUERTO);
		} catch (SocketFactoryException e) {
			throw new AfirmeNetException("0000",
					"Por el momento no se puede ejecutar su operacion.");
		} catch (MessageContextFactoryException e) {
			throw new AfirmeNetException("0001",
					"Por el momento no se puede ejecutar su operacion.");
		}

		// Solicita timbrado
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// Envia la cadena a timbrar
			out.write(cadena);
			out.flush();

			// Solicita el timbrado
			timbreDigital = in.readLine();
			digitoVerificador = timbreDigital.substring(0, 4);

		} catch (Exception e) {
			throw new AfirmeNetException("0003",
					"Ocurrio un error al generar el sello digital del pago de impuestos: "
							+ e.getMessage());

		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				LOG.error(
						"Error al intentar cerrar el buffer del timbrado digital",
						e);
			}

		}

		// Valida el digito verificador
		if (digitoVerificador == null || !digitoVerificador.equals("0172")) {
			throw new AfirmeNetException("0004",
					"El sello digital generado es incorrecto.");
		}
		// Se elimina el digito verificador y se retorna la cadena
		return timbreDigital.substring(4, timbreDigital.length());
	}

	private void doLlenaTabla() {
		int i = 0;
		int j = 0;
		long x = 0;
		long x2 = 0;

		for (i = 0; i <= 255; i++) {
			x = i;
			for (j = 8; j >= 1; j--) {
				if ((x & 1) == 1) {
					x2 = (x >> 1);
					x = x2 ^ 0xEDB88320L;
				} else {
					x = (x >> 1);
				}
			}
			aTabla[i] = x;
		}
		return;
	}

	private long doCalculaCrc32(String sCadena) {
		int i;
		int t_cadena;
		long valor_decimal;
		long x;
		long x2;
		long x3;
		long x4;
		long x5;
		long resultado;
		char cDig;

		x = 0xFFFFFFFFL;// FFFFFFFF

		t_cadena = sCadena.length();

		for (i = 0; i < t_cadena; i++) {
			cDig = sCadena.charAt(i);
			valor_decimal = (long) cDig; // convierte a valor decimal cada
											// caracter de la cadena
			x2 = x ^ valor_decimal;
			x3 = x2 & 0xFFL;
			x4 = aTabla[(int) x3];
			x5 = x >> 8;
			x = x5 ^ x4;
		}

		resultado = x ^ 0xFFFFFFFFL;

		return resultado;
	}

	private char getDigitoVerificador(String sCadena) {
		int i;
		int valor_decimal;
		int y = 0;
		int result;
		int x1;
		char dv = '0';
		char cDig;

		for (i = 0; i <= 8; i++) {
			cDig = sCadena.charAt(i);
			valor_decimal = (int) cDig; // convierte a valor decimal cada
										// caracter de la cadena)
			y = y + valor_decimal * (14 - (i + 1));
		}

		result = y % 11;

		if (result == 0) {
			dv = '0';
		}

		if (result == 1) {
			dv = '1';
		}

		if (result != 0 && result != 1) {
			x1 = 48 + (11 - result);
			dv = getValorASCII(x1);
		}

		return dv;
	}

	private char getValorASCII(int iCodigo) {
		// char sC = (char) (209); // Es la Ñ (enie) aunque deberia ser
		// (char)(165)

		if (iCodigo >= 32 && iCodigo <= 127) {

			switch (iCodigo) {
			case 32:
				return ' ';
			case 33:
				return '!';
			case 34:
				return '"';
			case 35:
				return '#';
			case 36:
				return '$';
			case 37:
				return '%';
			case 38:
				return '&';
			case 39:
				return (char) (39);
			case 40:
				return '(';
			case 41:
				return ')';
			case 42:
				return '*';
			case 43:
				return '+';
			case 44:
				return ',';
			case 45:
				return '-';
			case 46:
				return '.';
			case 47:
				return '/';
			case 48:
				return '0';
			case 49:
				return '1';
			case 50:
				return '2';
			case 51:
				return '3';
			case 52:
				return '4';
			case 53:
				return '5';
			case 54:
				return '6';
			case 55:
				return '7';
			case 56:
				return '8';
			case 57:
				return '9';
			case 58:
				return ':';
			case 59:
				return ';';
			case 60:
				return '<';
			case 61:
				return '=';
			case 62:
				return '>';
			case 63:
				return '?';
			case 64:
				return '@';
			case 65:
				return 'A';
			case 66:
				return 'B';
			case 67:
				return 'C';
			case 68:
				return 'D';
			case 69:
				return 'E';
			case 70:
				return 'F';
			case 71:
				return 'G';
			case 72:
				return 'H';
			case 73:
				return 'I';
			case 74:
				return 'J';
			case 75:
				return 'K';
			case 76:
				return 'L';
			case 77:
				return 'M';
			case 78:
				return 'N';
			case 79:
				return '0';
			case 80:
				return 'P';
			case 81:
				return 'Q';
			case 82:
				return 'R';
			case 83:
				return 'S';
			case 84:
				return 'T';
			case 85:
				return 'U';
			case 86:
				return 'V';
			case 87:
				return 'W';
			case 88:
				return 'X';
			case 89:
				return 'Y';
			case 90:
				return 'Z';
			case 91:
				return '[';
			case 92:
				return '\\';
			case 93:
				return ']';
			case 94:
				return '^';
			case 95:
				return '_';
			case 96:
				return '`';
			case 97:
				return 'a';
			case 98:
				return 'b';
			case 99:
				return 'c';
			case 100:
				return 'd';
			case 101:
				return 'e';
			case 102:
				return 'f';
			case 103:
				return 'g';
			case 104:
				return 'h';
			case 105:
				return 'i';
			case 106:
				return 'j';
			case 107:
				return 'k';
			case 108:
				return 'l';
			case 109:
				return 'm';
			case 110:
				return 'n';
			case 111:
				return 'o';
			case 112:
				return 'p';
			case 113:
				return 'q';
			case 114:
				return 'r';
			case 115:
				return 's';
			case 116:
				return 't';
			case 117:
				return 'u';
			case 118:
				return 'v';
			case 119:
				return 'w';
			case 120:
				return 'x';
			case 121:
				return 'y';
			case 122:
				return 'z';
			case 123:
				return '{';
			case 124:
				return '|';
			case 125:
				return '}';
			case 126:
				return '~';
			case 127:
				return '&';
			default:
				return (char) (209);
			}
		} else {
			return (char) (209);
		}
	}

	public String generaFolioFiscal(String contratoId, String rfc) {
		// Declaracion de variables
		Socket socket = null;
		MessageContext messageContext = null;
		FOLIODSJVMessage folio = null;
		MessageRecord messageRecord = null;
		String folioFiscal = "";
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

		try {
			// Incializa Bean de operacion
			folio = (FOLIODSJVMessage) messageContext
					.getMessageRecord("FOLIODSJV");
			// Se envian los datos para la generacion del folio
			folio.setFOLUSR(contratoId);
			folio.setFOLRF1(rfc);
			// Evia peticion a AS400
			folio.send();
			folio.destroy();

			// Evalua la respuesta
			messageRecord = messageContext.receiveMessage();// ERROR
			boolean goHead = ((ELEERRMessage) messageRecord).getERRNUM()
					.equals("0");
			String error = "";
			if (!goHead) {

				error = ((ELEERRMessage) messageRecord).getERNU01() + " "
						+ ((ELEERRMessage) messageRecord).getERDS01()
						+ ((ELEERRMessage) messageRecord).getERNU02() + " "
						+ ((ELEERRMessage) messageRecord).getERDS02()
						+ ((ELEERRMessage) messageRecord).getERNU03() + " "
						+ ((ELEERRMessage) messageRecord).getERDS03()
						+ ((ELEERRMessage) messageRecord).getERNU04() + " "
						+ ((ELEERRMessage) messageRecord).getERDS04();
				LOG.error("Error al generar el folio de pago de impuestos==>"
						+ error);
				throw new AfirmeNetException(
						"0001",
						"Error al generar el folio de pago de impuestos, Por el momento no se puede ejecutar su operacion: "
								+ error);
			} else {
				messageRecord = messageContext.receiveMessage();// FOLIO
				if (messageRecord.getFormatName().equals("FOLIODSJV")) {
					folioFiscal = ((FOLIODSJVMessage) messageRecord)
							.getFOLNUM();
				}
			}

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
		return folioFiscal;
	}
}
