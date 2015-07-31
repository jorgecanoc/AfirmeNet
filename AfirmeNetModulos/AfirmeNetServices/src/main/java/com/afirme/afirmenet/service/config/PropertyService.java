package com.afirme.afirmenet.service.config;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.model.DCProperty;

public interface PropertyService {

	public List<DCProperty> getConfiguraciones();
	public Map<String, Object> getConfiguracionesMap();
	
	/**
	 * Devuelve el tiempo de espera de alta de cuentas de terceros en segundos
	 * @param idPropiedad
	 * @return
	 */
	public String obtenerTiempoEsperaSegundos(ConfigProperties configuracion);
	
	/**
	 * Obtiene el tiempo de espera de la propiedad indicada, y regresa una
	 * cadena con el formato 'xx minutos' o 'xx horas'
	 * 
	 * @param idPropiedad
	 * @return
	 */
	public String obtenerTiempoEspera(ConfigProperties configuracion);
	
    /**
     * Devuelve el tiempo de espera de alta de cuentas de terceros en segundos
     * 
     * @param idPropiedad
     * @return
     */
    public void setTiempoEspera(ConfigProperties configuracion);
}
