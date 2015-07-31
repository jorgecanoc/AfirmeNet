package com.afirme.afirmenet.service.config;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.JBTefbanpf;
import com.afirme.afirmenet.ibs.databeans.SPAPLAPF;
import com.afirme.afirmenet.model.DCConfig;
import com.afirme.afirmenet.model.DCConfig.Aplicacion;
import com.afirme.afirmenet.model.Holiday;

/**
 * Clase de servicio que permite obtener las configuraciones necesarias de
 * ciertos atributos para que opere correctamente la aplicacion seleccionada
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public interface ConfiguracionService {
	/**
	 * Metodo que obtiene todas las configuraciones
	 * 
	 * @return lista de todas las configuraciones almacenadas
	 */
	public List<DCConfig> getConfiguraciones();

	/**
	 * Metodo que obtiene todas las configuraciones especificas por aplicacion
	 * {@link Aplicacion}
	 * 
	 * @param aplicacion
	 * @return lista de las configuraciones encontradas por aplicacion
	 */
	public List<DCConfig> getConfiguraciones(Aplicacion aplicacion);

	/**
	 * Metodo que obtiene todas las configuraciones en un Mapa
	 * 
	 * @return mapa de todas las configuraciones almacenadas
	 */
	public Map<String, Object> getConfiguracionesMap();

	/**
	 * Metodo que obtiene todas especificas por aplicacion en un Mapa
	 * 
	 * @param aplicacion
	 * @return mapa de todas las configuraciones almacenadas
	 */
	public Map<String, Object> getConfiguracionesMap(Aplicacion aplicacion);

	/**
	 * Obtiene la Lista de dias feriados.
	 * 
	 * @return
	 */
	public List<Holiday> getDiasFeriados();

	/**
	 * Obtiene los codigos y descripciones de errores que el sistema muestra.
	 * 
	 * @return
	 */
	public Map<Integer, String> getErrores();
	
	/**
	 * Servicio que retorna la lista de bancos asociados.
	 * 
	 * @return Lista de bancos.
	 */
	public List<JBTefbanpf> getBANList();	
	
	/**
	 * Servicio que retorna la lista de plazas asociados.
	 * 
	 * @return Lista de plazas.
	 */	
	public List<SPAPLAPF> getPlazas();
	
	/**
	 * Servicio que retorna la lista de plazas asociados.
	 * 
	 * @return Lista el mapa de horarios.
	 */	
	public Map<HorarioServicio, String> getHorarios();
}
