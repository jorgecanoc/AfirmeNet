/**
 * 
 */
package com.afirme.afirmenet.dao.config;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.JBTefbanpf;
import com.afirme.afirmenet.ibs.databeans.SPAPLAPF;
import com.afirme.afirmenet.model.DCConfig;
import com.afirme.afirmenet.model.DCConfig.Aplicacion;
import com.afirme.afirmenet.model.Holiday;

/**
 * Clase que permite obtener de la BD las configuraciones necesarias de ciertos
 * atributos para que opere correctamente la aplicacion seleccionada
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public interface ConfiguracionDao {

	/**
	 * Metodo que obtiene todas las configuraciones almacenada en la BD,
	 * especificamente en la tabla DC_CONFIG
	 * 
	 * @return lista de todas las configuraciones almacenadas
	 */
	public List<DCConfig> getConfiguraciones();

	/**
	 * Metodo que obtiene todas especificas por aplicacion {@link Aplicacion} en
	 * la BD, especificamente en la tabla DC_CONFIG
	 * 
	 * @param aplicacion
	 * @return lista de las configuraciones encontradas por aplicacion
	 */
	public List<DCConfig> getConfiguraciones(Aplicacion aplicacion);

	/**
	 * Metodo que obtiene todas las configuraciones almacenada en la BD,
	 * especificamente en la tabla DC_CONFIG
	 * 
	 * @return mapa de todas las configuraciones almacenadas
	 */
	public Map<String, Object> getConfiguracionesMap();

	/**
	 * Metodo que obtiene todas especificas por aplicacion {@link Aplicacion} en
	 * la BD, especificamente en la tabla DC_CONFIG
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
	 * Metodo para extraer la lista completa de Instituciones bancarias
	 * asociadas.
	 * 
	 * @return Lista de bancos.
	 */
	public List<JBTefbanpf> getBANList();

	/**
	 * Metodo para extraer la lista completa de plazas asociadas.
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
