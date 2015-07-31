package com.afirme.afirmenet.dao.convenios;

import java.util.List;

import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.model.DCPermisoServicio;

public interface ConveniosDao {

	public String CONVENIOS_LOGIN = "20,21,22,23";
	public String CONVENIOS_PAGOS = "20,21,22,23,15,2,5,6";
	public String CONVENIOS_SEGUROS = "6";

	/**
	 * Obtiene todos los servicios, excepto los que son propiamente del IVR.
	 * 
	 * @param as400libname
	 *            El nombre del ambienten de AS400 de donde se obtiene la
	 *            información.
	 * @return Los servicios básicos, excepto los que son de IVR.
	 * @author vmpermad
	 */
	public List<INSER> getConvListAS400(String filtro);

	/**
	 * Cargar listado de convenios solo tc otros bancos 400 01 Otros Bancos 02
	 * American 03 Terceros Afirme
	 * 
	 * @param contrato
	 * @param tipoPago
	 * @return
	 */
	List<INSER> getConvenios400TDC();

	/**
	 * Cargar listado de convenios solo tc otros bancos (no hay uno para afirme
	 * terceros) 01 Otros Bancos 02 American 03 Terceros Afirme
	 * 
	 * @param contrato
	 * @param tipoPago
	 * @return
	 */
	List<INSER> getConvenios400TDCPropias();

	/**
	 * Metodo que permite activar el servicio de pagos de servicio por tipo de
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

	/**
	 * Metodo que obtiene un convenio o servicio disponible por su identificador
	 * SERCOM
	 * 
	 * @return
	 */
	public INSER getConvenio(String sercom);

}
