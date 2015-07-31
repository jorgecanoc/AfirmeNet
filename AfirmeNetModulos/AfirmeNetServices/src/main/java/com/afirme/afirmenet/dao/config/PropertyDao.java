package com.afirme.afirmenet.dao.config;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.model.DCProperty;

/**
 * Métodos que accesan la tabla de propiedades (DC_PROPERTIES)
 */
public interface PropertyDao {
	
	public List<DCProperty> getConfiguraciones();
	public Map<String, Object> getConfiguracionesMap();
	public DCProperty getConfiguraciones(long id, int legalType, int propertyType);
}