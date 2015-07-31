/*
 * Modificado por:	Christian Antonio Gómez Flores
 * Empresa:			Consiss
 * Fecha:			28-Mayo-2007
 * */
package com.afirme.afirmenet.ibs.generics.gdf;


import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class UtilGdf {
	public UtilGdf() {
		super();
	}
	


	public static String toMD5C(byte bytes2[]) {
	//String firma="";
	String r = null;
	try {
	//if (s != null) {

	MessageDigest algorithm =MessageDigest.getInstance("MD5");
	algorithm.reset();
	algorithm.update(bytes2);

	byte bytes[] = algorithm.digest();

	//BASE64Encoder encoder = new BASE64Encoder();
	//String base64 = encoder.encode(bytes);
	byte[] sig64=Base64.encodeBase64(bytes);
	r=new String(sig64,"ISO-8859-1");
	
	} catch (Exception e) {
	}
	
	return r;

	}
	public static String firmarMD5(String llaveBancoMD5, String claveBanco,String	noAutorizacion,String fechaPago, String	lineaCaptura, String importe) {
	String cadenaDePago="";
	
	cadenaDePago= fillLength(claveBanco,3,false,"0")+ fillLength(noAutorizacion,12,false,"0") + fillLength(cambiarFormatoFechaYYYYMMDDaDDMMYYYY(fechaPago),8,false,"") + fillLength(lineaCaptura,20,false,"") + fillLength(quitarPuntoDecimales(importe)+ "00",15,false,"0")+ fillLength("1234567890123456",16,false,""); 

	byte[] vector = cadenaDePago.getBytes();

		
	vector[58]=new BigInteger(llaveBancoMD5.substring(0,2), 16).byteValue();
	vector[59]=new BigInteger(llaveBancoMD5.substring(2,4), 16).byteValue();
	vector[60]=new BigInteger(llaveBancoMD5.substring(4,6), 16).byteValue();
	vector[61]=new BigInteger(llaveBancoMD5.substring(6,8), 16).byteValue();
	vector[62]=new BigInteger(llaveBancoMD5.substring(8,10), 16).byteValue();
	vector[63]=new BigInteger(llaveBancoMD5.substring(10,12), 16).byteValue();
	vector[64]=new BigInteger(llaveBancoMD5.substring(12,14), 16).byteValue();
	vector[65]=new BigInteger(llaveBancoMD5.substring(14,16), 16).byteValue();
	vector[66]=new BigInteger(llaveBancoMD5.substring(16,18), 16).byteValue();
	vector[67]=new BigInteger(llaveBancoMD5.substring(18,20), 16).byteValue();
	vector[68]=new BigInteger(llaveBancoMD5.substring(20,22), 16).byteValue();
	vector[69]=new BigInteger(llaveBancoMD5.substring(22,24), 16).byteValue();
	vector[70]=new BigInteger(llaveBancoMD5.substring(24,26), 16).byteValue();
	vector[71]=new BigInteger(llaveBancoMD5.substring(26,28), 16).byteValue();
	vector[72]=new BigInteger(llaveBancoMD5.substring(28,30), 16).byteValue();
	vector[73]=new BigInteger(llaveBancoMD5.substring(30,32), 16).byteValue();
	
	
	vector[58]=123;
	vector[59]=-15;
	vector[60]=3;
	vector[61]=127;
	vector[62]=72;
	vector[63]=106;
	vector[64]=-91;
	vector[65]=118;
	vector[66]=37;
	vector[67]=120;
	vector[68]=-48;
	vector[69]=28;
	vector[70]=94;
	vector[71]=-11;
	vector[72]=72;
	vector[73]=-26;
	
	//123 , -15 , 3 , 127 , 72 , 106 , -91 , 118 , 37 , 120 , -48 , 28 , 94 , -11 , 72 , -26 
	
	
	
	
	
	
	
	
	
	
	

	
	return toMD5C(vector);

	}
	
	/**
	 * Recibe una cadena de texto y la rellena con el caracter proporcionado hasta alcanzar la longitud
	 * especificada, el contenido original de la cadena lo alinea hacia la derecha o a la izquierda
	 * segun se especifique
	 * @param cad La cadena de texto original que se desea rellenar
	 * @param length La nueva longitud que deseamos tenga la cadena
	 * @param isLeftAlign Un valor booleano que indica si el contenido original se alinea a la izquierda
	 * en caso falso se alineara a la derecha
	 * @param charFiller El caracter con el cual se rellenara la cadena
	 * @return La cadena con la nueva longitud rellenada y alineada
	 */
	public static final String fillLength(String cad, int length, boolean isLeftAlign, String charFiller){
		if (cad != null)
			if(cad.length() < length)
			{
			
				if(isLeftAlign)
					for(int i = cad.length(); i < length; i++)
						cad = cad + charFiller;
				else
					for(int i = cad.length(); i < length; i++)
						cad = charFiller + cad;
			}
			else
			{	cad = cad.substring(0, length);	}
		return cad;
	}
	
	public static String quitarPuntoDecimales(String number) {
		String result = "";
		int posi = number.indexOf(".");
		if (posi > -1) {
			result = number.substring(0, posi);
		}
		else {
			result = number;
		}
		return (result);
	}
	
	public static String cambiarFormatoFechaYYYYMMDDaDDMMYYYY(String fecha) {

		return (fecha.substring(6,8)+fecha.substring(4,6)+fecha.substring(0,4));
	}
	
}