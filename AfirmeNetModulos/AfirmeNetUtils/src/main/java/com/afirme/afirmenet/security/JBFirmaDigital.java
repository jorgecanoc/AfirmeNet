package com.afirme.afirmenet.security;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

public class JBFirmaDigital {

	static final Logger LOG = LoggerFactory
			.getLogger(JBFirmaDigital.class);
	
	private String rutaLLavePrivada = "";
	private String rutaLLavePublica = "";
	private PrivateKey privada;
	private PublicKey publica;
	private Signature verificador;

	public JBFirmaDigital() {
	}

	public boolean inicializaLlaves() {
		
		boolean listo = false;
		
		FileInputStream fprivis = null;
		FileInputStream fpublis = null;
		
		try {
			rutaLLavePrivada = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.KEY_PRIVADA, String.class);
			rutaLLavePublica = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.KEY_PUBLICA, String.class);
			
			LOG.debug(rutaLLavePrivada);
			LOG.debug(rutaLLavePublica);
			
			KeyFactory keyFactory = KeyFactory.getInstance("DSA");
			// Se regenera la llave privada
			File fpriv = new File(rutaLLavePrivada);
			fprivis = new FileInputStream(fpriv);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int b = 0;
			while (b != -1) {
				b = fprivis.read();
				if (b != -1)
					baos.write(b);
			}
			byte[] privEncode = baos.toByteArray();
			PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(privEncode);
			privada = keyFactory.generatePrivate(privKeySpec);
			// Se regenera la llave publica
			File fpubl = new File(rutaLLavePublica);
			fpublis = new FileInputStream(fpubl);
			ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
			b = 0;
			while (b != -1) {
				b = fpublis.read();
				if (b != -1)
					baos2.write(b);
			}
			byte[] publEncode = baos2.toByteArray();
			X509EncodedKeySpec publKeySpec = new X509EncodedKeySpec(publEncode);
			publica = keyFactory.generatePublic(publKeySpec);
			// Llaves regeneradas con exito
			listo = true;
		} catch (Exception e) {
			LOG.debug("No se pueden cargar las llaves para la firma digital de logs " + e);
		} finally {
			try {
				fprivis.close();
				fpublis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listo;
	}

	public String firmaTexto(String texto) {
		String firma = "";
		try {
			Signature dsa = Signature.getInstance("SHA1withDSA");
			dsa.initSign(privada);
			byte[] data = texto.getBytes();
			dsa.update(data);
			byte[] sig = dsa.sign();
			byte[] sig64 = Base64.encodeBase64(sig);
			firma = new String(sig64, "ISO-8859-1");
		} catch (Exception e) {
			LOG.debug("Error en JBFirmaDigital.firmaTexto " + e);
		}
		return firma;
	}

	public boolean setVerificador() {
		boolean exito = false;
		try {
			verificador = Signature.getInstance("SHA1withDSA");
			verificador.initVerify(publica);
			exito = true;
		} catch (Exception e) {
			LOG.debug("Error en JBFirmaDigital.setVerificador " + e);
		}
		return exito;
	}

	public boolean verificaFirma(String texto, String firma) {
		boolean igual = false;
		try {
			byte[] data = texto.getBytes();
			verificador.update(data);
			igual = verificador.verify(Base64.decodeBase64(firma.getBytes("ISO-8859-1")));
		} catch (Exception e) {
			LOG.debug("Error en JBFirmaDigital.verificaFirma " + e);
		}
		return igual;
	}

}