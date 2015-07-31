package com.afirme.afirmenet.service.pagos;

import java.util.List;

import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.model.DCPermisoServicio;

public interface PagosService {

	/**
	 * obtiene la lista de convenios segun el tipo de pago de tarjeta y el
	 * contrato 01 Otros Bancos 02 American 03 Terceros Afirme
	 * 
	 * @param contrato
	 * @param tipoPago
	 * @return
	 */
	public List<DC_CONVENIO> getConvenios(String contrato, String tipoPago);

	/**
	 * obtiene la lista de convenios para pago de seguros
	 * 
	 * @param contrato
	 * @param tipoPago
	 * @return
	 */
	public List<DC_CONVENIO> getConveniosSeg(String contrato);

	/**
	 * @return
	 */
	public List<INSER> getConveniosSeg400();

	/**
	 * Obtiene el listado de convenios o servicios disponibles que pueden ser
	 * pagados mediante afirmenet
	 * 
	 * @return
	 */
	public List<INSER> getConvenios400();

	/**
	 * Metodo que obtiene un convenio o servicio disponible por su identificador
	 * SERCOM
	 * 
	 * @return
	 */
	public INSER getConvenio(String sercom);

	/**
	 * Cargar listado de convenios solo tc otros bancos 400 - TIPO DE SERVICIO
	 * 01 Otros Bancos 02 American 03 Terceros Afirme
	 * 
	 * @param contrato
	 * @param tipoPago
	 * @return
	 */
	public List<INSER> getConvenios400TDC();

	/**
	 * Cargar listado de convenios solo tc otros bancos (no hay uno para afirme
	 * terceros) 01 Otros Bancos 02 American 03 Terceros Afirme
	 * 
	 * @param contrato
	 * @param tipoPago
	 * @return
	 */
	public List<INSER> getConvenios400_TDCPROPIAS();

	/**
	 * Metodo que permite activar el servicio de pago de servicios por tipo de
	 * cliente
	 * 
	 * @param contractId
	 * @param cliente
	 */
	public void activaServicios(String contractId, TipoCliente cliente);

	/**
	 * Metodo que obtiene el registro de activacion del servicio de pagos de
	 * servicios por tipo de cliente
	 * 
	 * @param contractId
	 * @param cliente
	 * @return
	 */
	public DCPermisoServicio getActivacionServicios(String contractId,
			TipoCliente cliente);
}
