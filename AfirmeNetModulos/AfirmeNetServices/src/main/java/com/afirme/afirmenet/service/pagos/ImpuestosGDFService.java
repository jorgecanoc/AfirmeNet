package com.afirme.afirmenet.service.pagos;

import com.afirme.afirmenet.model.pagos.ImpuestoGDF;

public interface ImpuestosGDFService {

	public boolean validaLineaCaptura(String lineaCaptura, double importe);
	
	public boolean validaFechaLineaCaptura(String lineaCaptura);
	
	public ImpuestoGDF getInfoImpuestoGDF(String lineaCaptura, double importe);
}
