package com.afirme.afirmenet.service.tarjetas;

import java.util.List;

import com.afirme.afirmenet.ibs.beans.tarjetas.DatosTDC;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.ibs.databeans.TC5000PF;

public interface TDCService {

	/**
	 * Obtiene la lista de tarjetas de credito activas del cliente
	 * @param numcliente
	 * @return
	 */
	List<TC5000PF> getListaTDC(String numcliente);
	
	/**
	 * Obtiene la lista de tarjetas de credito activas del cliente no adicionales
	 * @param numcliente
	 * @return
	 */
	List<TC5000PF> getListaTDCNoAdicional(List<TC5000PF> tarjetas);
	
	/**
	 * Obtiene los datos del cliente desde MQSeries
	 * @param numcliente
	 * @return
	 */
	DatosTDC getDatosMQ(DatosTDC datosTDC);
	
	/**
	 * obtiene los bean de las tdc afirme para identificarlas.
	 * @return
	 */
	List<String> getListaBeanTDCAfirme();
	
}
