package com.afirme.afirmenet.service.impl.pagos;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.pagos.ImpuestosGDFDao;
import com.afirme.afirmenet.enums.ConceptoGDF;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.ibs.generics.ConvierteBase;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.pagos.ImpuestoGDF;
import com.afirme.afirmenet.service.pagos.ImpuestosGDFService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Service
public class ImpuestosGDFServiceImpl implements ImpuestosGDFService {
	
	@Autowired
	private ImpuestosGDFDao impuestoGDFDao;

	@Override
	public boolean validaLineaCaptura(String lineaCaptura, double importe) {
		
		int capturaLength = lineaCaptura.length();
		// Valida longitud (20)
		if (!StringUtils.isEmpty(lineaCaptura) && capturaLength == 20) {
			
			int claveCaptura;
			try {
				claveCaptura = Integer.parseInt(lineaCaptura.substring(0, 2));
			} catch (Exception e) {
				return false;
			}
			
			if (claveCaptura != 0) {
				String baseCaptura = getBaseLineaCaptura(lineaCaptura, importe);
				
				if (validaDigitoVerificador(baseCaptura, Util.getYear4())) {
					return true;
				} 
				// Se realiza validacion con el año siguiente como parametro
				else if (Util.getMonth() == Calendar.DECEMBER + 1) {
					if (validaDigitoVerificador(baseCaptura, Util.getYear4() + 1))
						return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public ImpuestoGDF getInfoImpuestoGDF(String lineaCaptura, double importe) {
		
		ImpuestoGDF impuestoGDF = new ImpuestoGDF();
		impuestoGDF.setLineaCaptura(lineaCaptura);
		impuestoGDF.setImporte(importe);
		
		int claveCaptura = Integer.parseInt(lineaCaptura.substring(0, 2));
		impuestoGDF.setConceptoGDF(getConcepto(claveCaptura));
		
		impuestoGDF.setLineaCapturaBase(getBaseLineaCaptura(lineaCaptura, importe));
		
		return impuestoGDFDao.getInfoImpuestoGDF(impuestoGDF);
	}
	
	@Override
	public boolean validaFechaLineaCaptura(String lineaCaptura) {
		
		String diaActual = Util.getDay() < 10 ? "0" + Util.getDay() : String.valueOf(Util.getDay());
		String mesActual = Util.getMonth() < 10 ? "0" + Util.getMonth() : String.valueOf(Util.getMonth());
		
		String clave = lineaCaptura.substring(13, 15);
		clave = ConvierteBase.decodeB20(clave);
		
		int asciiClaveX = clave.charAt(0) - 65;
		int asciiClaveY = clave.charAt(1) - 65;
		
		String [][] matrix= new String[24][25];

		matrix[0][0] = "0101";  matrix[0][1] = "0102";  matrix[0][2] = "0103";  matrix[0][3] = "0104";
		matrix[0][4] = "0105";  matrix[0][5] = "0106";  matrix[0][7] = "0107";  matrix[0][9] = "0108";
		matrix[0][10] = "0109"; matrix[0][12] = "0110"; matrix[0][13] = "0111"; matrix[0][15] = "0112";
		matrix[0][16] = "0113"; matrix[0][17] = "0114"; matrix[0][19] = "0115"; matrix[0][20] = "0116";
		matrix[0][21] = "0117"; matrix[0][22] = "0118"; matrix[0][23] = "0119"; matrix[0][24] = "0120";

		matrix[1][0] = "0121";  matrix[1][1] = "0122";  matrix[1][2] = "0123";  matrix[1][3] = "0124";
		matrix[1][4] = "0125";  matrix[1][5] = "0126";  matrix[1][7] = "0127";  matrix[1][9] = "0128";
		matrix[1][10] = "0129"; matrix[1][12] = "0130"; matrix[1][13] = "0131"; matrix[1][15] = "0201";
		matrix[1][16] = "0202"; matrix[1][17] = "0203"; matrix[1][19] = "0204"; matrix[1][20] = "0205";
		matrix[1][21] = "0206"; matrix[1][22] = "0207"; matrix[1][23] = "0208"; matrix[1][24] = "0209";

		matrix[2][0] = "0210";  matrix[2][1] = "0211";  matrix[2][2] = "0212";  matrix[2][3] = "0213";
		matrix[2][4] = "0214";  matrix[2][5] = "0215";  matrix[2][7] = "0216";  matrix[2][9] = "0217";
		matrix[2][10] = "0218"; matrix[2][12] = "0219"; matrix[2][13] = "0220"; matrix[2][15] = "0221";
		matrix[2][16] = "0222"; matrix[2][17] = "0223"; matrix[2][19] = "0224"; matrix[2][20] = "0225";
		matrix[2][21] = "0226"; matrix[2][22] = "0227"; matrix[2][23] = "0228"; matrix[2][24] = "0229";

		matrix[3][2] = "0301";  matrix[3][3] = "0302";  matrix[3][4] = "0303";  matrix[3][5] = "0304";
		matrix[3][7] = "0305";  matrix[3][9] = "0306";  matrix[3][10] = "0307"; matrix[3][12] = "0308";
		matrix[3][13] = "0309"; matrix[3][15] = "0310"; matrix[3][16] = "0311"; matrix[3][17] = "0312";
		matrix[3][19] = "0313"; matrix[3][20] = "0314"; matrix[3][21] = "0315"; matrix[3][22] = "0316";
		matrix[3][23] = "0317"; matrix[3][24] = "0318";

		matrix[4][0] = "0319";  matrix[4][1] = "0320";  matrix[4][2] = "0321";  matrix[4][3] = "0322";
		matrix[4][4] = "0323";  matrix[4][5] = "0324";  matrix[4][7] = "0325";  matrix[4][9] = "0326";
		matrix[4][10] = "0327"; matrix[4][12] = "0328"; matrix[4][13] = "0329"; matrix[4][15] = "0330";
		matrix[4][16] = "0331"; matrix[4][17] = "0401"; matrix[4][19] = "0402"; matrix[4][20] = "0403";
		matrix[4][21] = "0404"; matrix[4][22] = "0405"; matrix[4][23] = "0406"; matrix[4][24] = "0407";

		matrix[5][0] = "0408";  matrix[5][1] = "0409";  matrix[5][2] = "0410";  matrix[5][3] = "0411";
		matrix[5][4] = "0412";  matrix[5][5] = "0413";  matrix[5][7] = "0414";  matrix[5][9] = "0415";
		matrix[5][10] = "0416"; matrix[5][12] = "0417"; matrix[5][13] = "0418"; matrix[5][15] = "0419";
		matrix[5][16] = "0420"; matrix[5][17] = "0421"; matrix[5][19] = "0422"; matrix[5][20] = "0423";
		matrix[5][21] = "0424"; matrix[5][22] = "0425"; matrix[5][23] = "0426"; matrix[5][24] = "0427";
		
		matrix[7][0] = "0428";  matrix[7][1] = "0429";  matrix[7][2] = "0430";  matrix[7][4] = "0501";
		matrix[7][5] = "0502";  matrix[7][7] = "0503";  matrix[7][9] = "0504";  matrix[7][10] = "0505";
		matrix[7][12] = "0506"; matrix[7][13] = "0507"; matrix[7][15] = "0508"; matrix[7][16] = "0509";
		matrix[7][17] = "0510"; matrix[7][19] = "0511"; matrix[7][20] = "0512"; matrix[7][21] = "0513";
		matrix[7][22] = "0514"; matrix[7][23] = "0515"; matrix[7][24] = "0516";

		matrix[9][0] = "0517";  matrix[9][1] = "0518";  matrix[9][2] = "0519";  matrix[9][3] = "0520";
		matrix[9][4] = "0521";  matrix[9][5] = "0522";  matrix[9][7] = "0523";  matrix[9][9] = "0524";
		matrix[9][10] = "0525"; matrix[9][12] = "0526"; matrix[9][13] = "0527"; matrix[9][15] = "0528";
		matrix[9][16] = "0529"; matrix[9][17] = "0530"; matrix[9][19] = "0531"; matrix[9][20] = "0601";
		matrix[9][21] = "0602"; matrix[9][22] = "0603"; matrix[9][23] = "0604"; matrix[9][24] = "0605";

		matrix[10][0] = "0606"; matrix[10][1] = "0607"; matrix[10][2] = "0608"; matrix[10][3] = "0609";
		matrix[10][4] = "0610"; matrix[10][5] = "0611"; matrix[10][7] = "0612"; matrix[10][9] = "0613";
		matrix[10][10] = "0614";matrix[10][12] = "0615";matrix[10][13] = "0616";matrix[10][15] = "0617";
		matrix[10][16] = "0618";matrix[10][17] = "0619";matrix[10][19] = "0620";matrix[10][20] = "0621";
		matrix[10][21] = "0622";matrix[10][22] = "0623";matrix[10][23] = "0624";matrix[10][24] = "0625";
		
		matrix[12][0] = "0626"; matrix[12][1] = "0627"; matrix[12][2] = "0628"; matrix[12][3] = "0629";
		matrix[12][4] = "0630"; matrix[12][7] = "0701"; matrix[12][9] = "0702"; matrix[12][10] = "0703";
		matrix[12][12] = "0704";matrix[12][13] = "0705";matrix[12][15] = "0706";matrix[12][16] = "0707";
		matrix[12][17] = "0708";matrix[12][19] = "0709";matrix[12][20] = "0710";matrix[12][21] = "0711";
		matrix[12][22] = "0712";matrix[12][23] = "0713";matrix[12][24] = "0714";

		matrix[13][0] = "0715"; matrix[13][1] = "0716"; matrix[13][2] = "0717"; matrix[13][3] = "0718";
		matrix[13][4] = "0719"; matrix[13][5] = "0720"; matrix[13][7] = "0721"; matrix[13][9] = "0722";
		matrix[13][10] = "0723";matrix[13][12] = "0724";matrix[13][13] = "0725";matrix[13][15] = "0726";
		matrix[13][16] = "0727";matrix[13][17] = "0728";matrix[13][19] = "0729";matrix[13][20] = "0730";
		matrix[13][21] = "0731";matrix[13][22] = "0801";matrix[13][23] = "0802";matrix[13][24] = "0803";

		matrix[15][0] = "0804"; matrix[15][1] = "0805"; matrix[15][2] = "0806"; matrix[15][3] = "0807";
		matrix[15][4] = "0808"; matrix[15][5] = "0809"; matrix[15][7] = "0810"; matrix[15][9] = "0811";
		matrix[15][10] = "0812";matrix[15][12] = "0813";matrix[15][13] = "0814";matrix[15][15] = "0815";
		matrix[15][16] = "0816";matrix[15][17] = "0817";matrix[15][19] = "0818";matrix[15][20] = "0819";
		matrix[15][21] = "0820";matrix[15][22] = "0821";matrix[15][23] = "0822";matrix[15][24] = "0823";

		matrix[16][0] = "0824"; matrix[16][1] = "0825"; matrix[16][2] = "0826"; matrix[16][3] = "0827";
		matrix[16][4] = "0828"; matrix[16][5] = "0829"; matrix[16][7] = "0830"; matrix[16][9] = "0831";
		matrix[16][10] = "0901";matrix[16][12] = "0902";matrix[16][13] = "0903";matrix[16][15] = "0904";
		matrix[16][16] = "0905";matrix[16][17] = "0906";matrix[16][19] = "0907";matrix[16][20] = "0908";
		matrix[16][21] = "0909";matrix[16][22] = "0910";matrix[16][23] = "0911";matrix[16][24] = "0912";

		matrix[17][0] = "0913"; matrix[17][1] = "0914"; matrix[17][2] = "0915"; matrix[17][3] = "0916";
		matrix[17][4] = "0917"; matrix[17][5] = "0918"; matrix[17][7] = "0919"; matrix[17][9] = "0920";
		matrix[17][10] = "0921";matrix[17][12] = "0922";matrix[17][13] = "0923";matrix[17][15] = "0924";
		matrix[17][16] = "0925";matrix[17][17] = "0926";matrix[17][19] = "0927";matrix[17][20] = "0928";
		matrix[17][21] = "0929";matrix[17][22] = "0930";matrix[17][24] = "1001";

		matrix[19][0] = "1002"; matrix[19][1] = "1003"; matrix[19][2] = "1004"; matrix[19][3] = "1005";
		matrix[19][4] = "1006"; matrix[19][5] = "1007"; matrix[19][7] = "1008"; matrix[19][9] = "1009";
		matrix[19][10] = "1010";matrix[19][12] = "1011";matrix[19][13] = "1012";matrix[19][15] = "1013";
		matrix[19][16] = "1014";matrix[19][17] = "1015";matrix[19][19] = "1016";matrix[19][20] = "1017";
		matrix[19][21] = "1018";matrix[19][22] = "1019";matrix[19][23] = "1020";matrix[19][24] = "1021";
		
		matrix[20][0] = "1022"; matrix[20][1] = "1023"; matrix[20][2] = "1024"; matrix[20][3] = "1025";
		matrix[20][4] = "1026"; matrix[20][5] = "1027"; matrix[20][7] = "1028"; matrix[20][9] = "1029";
		matrix[20][10] = "1030";matrix[20][12] = "1031";matrix[20][13] = "1101";matrix[20][15] = "1102";
		matrix[20][16] = "1103";matrix[20][17] = "1104";matrix[20][19] = "1105";matrix[20][20] = "1106";
		matrix[20][21] = "1107";matrix[20][22] = "1108";matrix[20][23] = "1109";matrix[20][24] = "1110";
		
		matrix[21][0] = "1111"; matrix[21][1] = "1112"; matrix[21][2] = "1113"; matrix[21][3] = "1114";
		matrix[21][4] = "1115"; matrix[21][5] = "1116"; matrix[21][7] = "1117"; matrix[21][9] = "1118";
		matrix[21][10] = "1119";matrix[21][12] = "1120";matrix[21][13] = "1121";matrix[21][15] = "1122";
		matrix[21][16] = "1123";matrix[21][17] = "1124";matrix[21][19] = "1125";matrix[21][20] = "1126";
		matrix[21][21] = "1127";matrix[21][22] = "1128";matrix[21][23] = "1129";matrix[21][24] = "1130";

		matrix[22][1] = "1201"; matrix[22][2] = "1202"; matrix[22][3] = "1203"; matrix[22][4] = "1204";
		matrix[22][5] = "1205"; matrix[22][7] = "1206"; matrix[22][9] = "1207"; matrix[22][10] = "1208";
		matrix[22][12] = "1209";matrix[22][13] = "1210";matrix[22][15] = "1211";matrix[22][16] = "1212";
		matrix[22][17] = "1213";matrix[22][19] = "1214";matrix[22][20] = "1215";matrix[22][21] = "1216";
		matrix[22][22] = "1217";matrix[22][23] = "1218";matrix[22][24] = "1219";
		
		matrix[23][0] = "1220"; matrix[23][1] = "1221"; matrix[23][2] = "1222"; matrix[23][3] = "1223";
		matrix[23][4] = "1224"; matrix[23][5] = "1225"; matrix[23][7] = "1226"; matrix[23][9] = "1227";
		matrix[23][10] = "1228";matrix[23][12] = "1229";matrix[23][13] = "1230";matrix[23][15] = "1231";
		
		int lineaCapturaDate = Integer.parseInt(mesActual + diaActual);
		int matrixValue = Integer.parseInt(matrix[asciiClaveX][asciiClaveY]);
		
		return  lineaCapturaDate <= matrixValue;
	}
	
	private String getBaseLineaCaptura(String lineaCaptura, double importe) {
		
		importe = (int) importe;
		String subcadena = lineaCaptura.substring(13, 18);
		
		int base10 = (int) ConvierteBase.convertB30ToB10(subcadena);
		
		int llaveBanco = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.KEY_BANCO, Integer.class);
		int sumaAux = (int) (base10 - importe - llaveBanco);
		
		do {
			sumaAux = sumaAux < 0 ? (int) (sumaAux + Math.pow(30, 5)) : sumaAux;
		} while (sumaAux < 0);
		
		int procedimiento = (int) (sumaAux % (Math.pow(30, 5)));
		
		String base30 = ConvierteBase.convertB10ToB30(procedimiento);
		
		lineaCaptura = lineaCaptura.substring(0, 13) + base30 + lineaCaptura.substring(18, 20);
		return lineaCaptura;
	}
	
	private boolean validaDigitoVerificador(String baseCaptura, int year) {
		
		String cadenaValidar = baseCaptura.substring(0, 18);
		String digitoVerificador = baseCaptura.substring(baseCaptura.length() - 2, baseCaptura.length());
		
		int[] base10 = new int[18];
		// Convirtiendo de base 36 a base 10
		for (int i = 0; i < cadenaValidar.length(); i++) {
			base10[i] = ConvierteBase.vbase36.indexOf("" + cadenaValidar.charAt(i));
		}

		int suma = 0;
		int[] ponderadores = { 11, 13, 17, 19, 23 };
		// Recorriendo base10[i] de derecha a izquierda
		// y multiplicando por los ponderadores, el resultado se suma
		for (int i = base10.length - 1, j = 0; i >= 0; i--, j++) {
			j = j == ponderadores.length ? 0 : j;
			suma += base10[i] * ponderadores[j];
		}
		// Sumando al resultado anterior el año actual
		suma += year;
		// Aplicando al resultado el módulo 887
		suma = suma % 887;
		
		String digitos = ConvierteBase.convertB10ToB30(suma);
		
		if (digitos.length() == 1)
			digitos = "0" + digitos;
		
		if (digitos.length() == 0)
			digitos = "00";
		
		return digitoVerificador.equals(digitos);
	}
	
	private ConceptoGDF getConcepto(int idClave) {
		// Licencia de Conducir
		if (idClave > 0 && idClave <= 14)
			return ConceptoGDF.LICENCIA_CONDUCIR;
		// Trámites vehiculares
		if (idClave >= 33 && idClave <= 45)
			return ConceptoGDF.TRAM_VEHICULAR;
		// Multa Revista Vehicular
		if (idClave == 46)
			return ConceptoGDF.MULTA_REV_VEHICULAR;
		// Multas Vehiculares Infraccion
		if (idClave == 49)
			return ConceptoGDF.MULTA_INFRACCION;
		// Medio Ambiente Verificacion
		if (idClave == 50)
			return ConceptoGDF.MEDIO_AMB_VERFIC_EXTEMP;
		// Medio Ambiente Contaminantes
		if (idClave == 51)
			return ConceptoGDF.MEDIO_AMBIENTE_CONTAM;
		// Medio Ambiente Hologramas
		if (idClave == 52)
			return ConceptoGDF.MEDIO_AMBIENTE_HOLOGR;
		// Registro Civil Busqueda
		if (idClave >= 57 && idClave <= 76)
			return ConceptoGDF.REGISTRO_CIVIL_BUSQUEDA;
		// REGISTRO_CIVIL / Registro Civil - COPIAS
		if (idClave == 54)
			return ConceptoGDF.REGISTRO_CIVIL;
		// Servicio Policia
		if (idClave == 78 || idClave == 79)
			return ConceptoGDF.SERVICIO_POLICIA;
		// Impuesto Predial
		if (idClave == 80 || idClave == 81)
			return ConceptoGDF.IMP_PREDIAL;
		// Suministro Agua
		if (idClave == 82 || idClave == 83)
			return ConceptoGDF.SUMINISTRO_AGUA;
		// Tenencia y Derechos
		if ((idClave >= 20 && idClave <= 27) || (idClave >= 84 && idClave <= 87))
			return ConceptoGDF.TENENCIA;
		// Impuesto Sobre Nomina
		if (idClave == 88 || idClave == 96)
			return ConceptoGDF.IMP_NOMINA;
		// Impuesto Rifa Sorteos
		if (idClave == 89 || idClave == 90)
			return ConceptoGDF.IMP_RIFAS;
		// Impuesto Hospedaje
		if (idClave == 91)
			return ConceptoGDF.IMP_HOSPEDAJE;
		// Impuesto Adquisicion Inmuebles
		if (idClave == 92)
			return ConceptoGDF.IMP_INMUEBLES;
		// Registro Publico de la Propiedad
		if (idClave == 93)
			return ConceptoGDF.REGISTRO_PUBLICO;
		// Auto Nuevo
		if (idClave == 97) 
			return ConceptoGDF.AUTO_NUEVO;
		// Enajenacion
		if (idClave == 98)
			return ConceptoGDF.ISR_ENAJENACION;
		// Pagos Tesoreria
		if (idClave == 77)
			return ConceptoGDF.PAGOS_TESORERIA;

		return null;
	}
	
}
