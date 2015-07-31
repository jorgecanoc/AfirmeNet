package com.afirme.afirmenet.service.pagos.impuestos;

import com.afirme.afirmenet.model.pagos.impuestos.Impuesto;

public interface ImpuestosService {

	public String generaLlaveDePago(String sFecha, String sMes, String pNombre,
			String pTotal, String pNoOperacion);

	public String generaTimbradoDigital(String cadena);
	
	public String generaFolioFiscal(String contratoId, String rfc);
	
	public void insertaCertificadoDigital(Impuesto impuesto);
	
}
