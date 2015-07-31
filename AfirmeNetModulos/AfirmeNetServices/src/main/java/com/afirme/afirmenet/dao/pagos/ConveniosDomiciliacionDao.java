package com.afirme.afirmenet.dao.pagos;

import java.util.List;

import com.afirme.afirmenet.model.pagos.ConvenioDomiciliacion;

public interface ConveniosDomiciliacionDao {

	/**
	 * Extrae una lista de servicios con los que AFIRME tiene convenio
	 * para realizar pagos domiciliados
	 * @return Listado de Servicios Basicos para Domiciliacion de Pagos
	 */
	public List<ConvenioDomiciliacion> getServiciosBasicos400();
	
	/**
	 * Extrae la lista de Convenios de Domiciliacion si existen
	 * un contrato con estatus de Aprobado establecido
	 * @return Convenio de Domiciliacion e Informacion si existe el contrato
	 */
	public List<ConvenioDomiciliacion> getContratoServicioDomiciliacion(String contrato);
	
	/**
	 * Extrae la informacion de un Servicio Domiciliado a partir del folio
	 * @param folio del Servicio Domiciliado
	 * @return informacion del Servicio
	 */
	public ConvenioDomiciliacion getInfoServicioDomiciliacion(int folio);
	
	/**
	 * Recopila los movimientos realizados por la Domiciliacion de Servicios a partir de
	 * una fecha inicio y una fecha fin
	 * @param convenio
	 * @param fechaInicio
	 * @param fechaFin
	 * @return Lista de Movimientos
	 */
	public List<ConvenioDomiciliacion> getHistorialMovimientos(ConvenioDomiciliacion convenio, String fechaInicio, String fechaFin);
	
}
