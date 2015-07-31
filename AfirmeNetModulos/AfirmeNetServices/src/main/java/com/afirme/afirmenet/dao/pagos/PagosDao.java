package com.afirme.afirmenet.dao.pagos;

import java.util.List;

import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.model.pagos.servicios.ReferenciaServicio;

public interface PagosDao {

	/**
	 * obtiene la lista de convenios segun el tipo de pago de tarjeta u el
	 * contrato 01 Otros Bancos 02 American 03 Terceros Afirme
	 * 
	 * @param beanTDCAfirme
	 * @param contrato
	 * @param tipoPago
	 * @return
	 */
	List<DC_CONVENIO> getConvenios(List<String> beanTDCAfirme, String contrato,
			String tipoPago);
	
	/**
	 * obtiene la lista de convenios para el pago de servicios
	 * 
	 * @param contrato
	 * @return
	 */
	List<DC_CONVENIO> getConveniosSeg(String contrato);

	/**
	 * Metodo que valida sin un BIN existe en DB2
	 * 
	 * @param numeroBIN
	 * @return
	 */
	public boolean existeBIN(String numeroBIN);

	/**
	 * Metodo que valida si un BIN existe en AS400S
	 * 
	 * @param numeroBIN
	 * @return
	 */
	public boolean existeBIN400(String numeroBIN);
	
	
	public ReferenciaServicio getReferenciaServicio(String servicio);


	
}
