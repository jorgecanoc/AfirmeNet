package com.afirme.afirmenet.dao.tarjetas;

import java.util.List;

import com.afirme.afirmenet.ibs.beans.tarjetas.DatosTDC;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.TC5000PF;

public interface TDCDao {
	
	/**
	 * Obtiene la lista de tarjetas de credito activas del cliente
	 * @param numcliente
	 * @return
	 */
	List<TC5000PF> getListaTDC(String numcliente);

	/**
	 * Obtiene el pago para no generar intereses
	 * @param numcliente
	 * @return
	 */
	double getPagoNoIntereses(DatosTDC datosTDC);
	
	/**
	 * obtiene los bean de las tdc afirme para identificarlas.
	 * @param numcliente
	 * @return
	 */
	List<String> getListaBeanTDCAfirme();

}
