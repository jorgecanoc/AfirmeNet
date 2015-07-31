package com.afirme.afirmenet.utils.string;

import java.util.StringTokenizer;

/**
 * Clase de utileria que ofrece metodos diversos para el manejo de cadenas de
 * forma muy particular como lo requiere la aplicacion de AfirmeNet
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class StringUtils {
	private static final String ESPACE = "&#32;";

	public static String formateaMensaje(String mensaje, String patronAbuscar,
			String remplazarCon) {
		return null;
	}

	public static String formateaMensaje(String mensaje, String patronAbuscar,
			String reemplazarCon, String pre, String post,
			boolean conservarPatronEncontrado) {
		StringTokenizer tokens = new StringTokenizer(mensaje);
		StringBuilder builder = new StringBuilder();
		String token = "";
		while (tokens.hasMoreElements()) {
			token = tokens.nextToken();
			token = token + ESPACE;
			if (org.apache.commons.lang.StringUtils.isNotEmpty(token)) {
				if (token.contains(patronAbuscar)) {
					// Toma como prioridad el reemplazo
					if (org.apache.commons.lang.StringUtils
							.isNotEmpty(reemplazarCon)) {
						if (conservarPatronEncontrado) {
							builder.append(token.replace(token, reemplazarCon));
						} else {
							builder.append(reemplazarCon);
						}

					} else if (org.apache.commons.lang.StringUtils
							.isNotEmpty(pre)
							&& org.apache.commons.lang.StringUtils
									.isNotEmpty(post)) {
						if (conservarPatronEncontrado) {
							builder.append(pre);
							builder.append(token);
							builder.append(post);
						} else {
							builder.append(pre);
							builder.append(token.replace(patronAbuscar, "")
									.trim());
							builder.append(post);
						}
					} else {
						builder.append(token);
					}

				} else {
					builder.append(token);
				}
			}
		}
		return builder.toString();
	}

	public static String takeDot(String number) {
		String result = "";
		String finalStr = "";
		int posi = number.indexOf(".");
		if (posi > -1) {
			result = number.substring(0, posi);
			result = result + number.substring(posi + 1);
		} else {
			result = number + "00";
		}
		//Remove comma
		posi = result.indexOf(",");
		if(posi>-1){
			finalStr = result.substring(0, posi);
			finalStr = finalStr + result.substring(posi + 1);
		}else{
			finalStr = result;
		}
		return (finalStr);
	}
}
