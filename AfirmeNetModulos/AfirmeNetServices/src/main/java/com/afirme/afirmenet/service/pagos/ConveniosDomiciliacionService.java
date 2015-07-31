package com.afirme.afirmenet.service.pagos;

import java.util.List;

import com.afirme.afirmenet.model.pagos.ConvenioDomiciliacion;

public interface ConveniosDomiciliacionService {

	/**
	 * Servicio para obtener la Lista de Servicios con los que AFIRME
	 * cuenta para pagos domiciliados
	 * @return Lista de Convenios
	 */
	public List<ConvenioDomiciliacion> getServiciosBasicos400();
	
	/**
	 * Servicio que obtiene los Convenios Aprobados de un contrato especifico
	 * @param contrato
	 * @return Convenio con estatus Aprobado, si existe
	 */
	public List<ConvenioDomiciliacion> getContratoServicioDomiciliacion(String contrato);
	
	/**
	 * Servicio para obtener la informacion de un Servicio Domiciliado
	 * @param folio del Servicio a buscar
	 * @return informacion del Servicio correspondiente
	 */
	public ConvenioDomiciliacion getInfoServicioDomiciliacion(int folio);
	
	/**
	 * SErvicio para obtener la lista de movimientos efectuados por la Domiciliacion de Servicio
	 * @param convenio
	 * @param fechaInicio
	 * @param fechaFin
	 * @return Lista de movimientos
	 */
	public List<ConvenioDomiciliacion> getHistorialMovimientos(ConvenioDomiciliacion convenio, String fechaInicio, String fechaFin);
}
