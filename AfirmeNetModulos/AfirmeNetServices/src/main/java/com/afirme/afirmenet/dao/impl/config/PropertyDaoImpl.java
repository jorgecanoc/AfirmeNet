package com.afirme.afirmenet.dao.impl.config;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.config.PropertyDao;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.model.DCConfig.Aplicacion;
import com.afirme.afirmenet.model.DCProperty;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class PropertyDaoImpl implements PropertyDao {

	static final Logger LOG = LoggerFactory.getLogger(PropertyDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;
	
	@Override
	public List<DCProperty> getConfiguraciones() {
		return this.getConfiguracion();
	}
	
	@Override
	public DCProperty getConfiguraciones(long id, int legalType, int propertyType) {
		return this.getConfiguracion(id,legalType,propertyType);
	}
	
	@Override
	public Map<String, Object> getConfiguracionesMap() {
		return this.poblarMap(this.getConfiguraciones());
	}
	
	/**
	 * Metodo que permite poblar un Map con la informacion de las
	 * configuraciones almacenadas en la BD
	 * 
	 * @param configuracionesList
	 * @return mapa de configuraciones
	 */
	private Map<String, Object> poblarMap(List<DCProperty> configuracionesList) {
		Map<String, Object> configuracionesMap = new HashMap<String, Object>();
		for (DCProperty row : configuracionesList) {
			configuracionesMap.put(String.valueOf(row.getPropertyId()), row.getValue());
		}
		return configuracionesMap;
	}
	
	/**
	 * Metodo que obtiene los valores almacenados en la tabla de configuracion,
	 * dada una aplicacion {@link Aplicacion} si la aplicacion es nula retornara
	 * todas las configuraciones encontradas
	 * 
	 * @param aplicacion
	 * @return
	 */
	private List<DCProperty> getConfiguracion() {
		
		String sql = 
				"SELECT PROPERTYID, NAME, DESCRIPTION, VALUE, LEGAL_TYPE, PROPERTY_TYPE, OPDATE, OPUSER, MODATE, MOUSER " +
				"FROM DC_PROPERTIES";

		List<Map<String, Object>> resultList;
		
		try {
			resultList = db2Dao.getJdbcTemplate().queryForList(sql);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		List<DCProperty> propertyList = new ArrayList<DCProperty>();
		
		for (Map<String, Object> map : resultList) {
			DCProperty property = new DCProperty();
			property.setPropertyId(map.get("PROPERTYID") != null ? Integer.valueOf(map.get("PROPERTYID").toString()) : null);
			property.setName(map.get("NAME") != null ? map.get("NAME").toString() : null);
			property.setDescription(map.get("DESCRIPTION") != null ? map.get("DESCRIPTION").toString() : null);
			property.setValue(map.get("VALUE") != null ? map.get("VALUE").toString() : null);
			property.setLegalType(map.get("LEGAL_TYPE") != null ? Integer.valueOf(map.get("LEGAL_TYPE").toString()) : null);
			property.setPropertyType(map.get("PROPERTY_TYPE") != null ? Integer.valueOf(map.get("PROPERTY_TYPE").toString()) : null);
			property.setOpdate(map.get("OPDATE") != null ? Timestamp.valueOf(map.get("OPDATE").toString()) : null);
			property.setOpuser(map.get("OPUSER") != null ? map.get("OPUSER").toString() : null);
			property.setModate(map.get("MODATE") != null ? Timestamp.valueOf(map.get("MODATE").toString()) : null);
			property.setMouser(map.get("MOUSER") != null ? map.get("MODATE").toString() : null);
			propertyList.add(property);
		}

		return propertyList;
	}
	
	private DCProperty getConfiguracion(long id, int legalType, int propertyType) {
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT PROPERTYID, NAME, DESCRIPTION, VALUE, LEGAL_TYPE, PROPERTY_TYPE, OPDATE, OPUSER, MODATE, MOUSER  ");
		sb.append("FROM DC_PROPERTIES");
		
		if (id <= 0 && legalType <= 0 && propertyType > 0) // PropertyType 
			sb.append(" WHERE PROPERTY_TYPE = ").append(propertyType)
			  .append(" OR PROPERTY_TYPE = ").append(AfirmeNetConstants.getValorConfigProperties(ConfigProperties.PROPERTY_TYPE_BOTH, String.class));
			
		if (id <= 0 && legalType > 0 && propertyType <= 0) // LegalType
			sb.append(" WHERE LEGAL_TYPE = ").append(legalType);
			
		if (id <= 0 && legalType > 0 && propertyType > 0) //LegalType y Propertytype
			sb.append(" WHERE LEGAL_TYPE = ").append(legalType).append( " AND (PROPERTY_TYPE = ").append(propertyType)
			  .append(" OR PROPERTY_TYPE = ").append(AfirmeNetConstants.getValorConfigProperties(ConfigProperties.PROPERTY_TYPE_BOTH, String.class)).append(") ");
			
		if (id > 0 && legalType <= 0 && propertyType <= 0) // ID
			sb.append(" WHERE PROPERTYID = ").append(id);
		
		if (id > 0 && legalType <= 0 && propertyType > 0) // id y PropertyType
			sb.append(" WHERE PROPERTYID = ").append(id).append( " AND (PROPERTY_TYPE = ").append(propertyType)
			.append(" OR PROPERTY_TYPE = ").append(AfirmeNetConstants.getValorConfigProperties(ConfigProperties.PROPERTY_TYPE_BOTH, String.class)).append(") ");
		
		if (id > 0 && legalType > 0 && propertyType <= 0) // id y legalType	
			sb.append(" WHERE PROPERTYID = ").append(id).append( " AND LEGAL_TYPE = ").append(legalType);
		
		if (id > 0 && legalType > 0 && propertyType > 0) // id, legalType y PropertyType
			sb.append(" WHERE PROPERTYID = ").append(id).append( " AND LEGAL_TYPE = ").append(legalType)
			.append( " AND (PROPERTY_TYPE = ").append(propertyType)
			.append(" OR PROPERTY_TYPE = ").append(AfirmeNetConstants.getValorConfigProperties(ConfigProperties.PROPERTY_TYPE_BOTH, String.class)).append(") ");
			

		List<Map<String, Object>> resultList;
		
		try {
			resultList = db2Dao.getJdbcTemplate().queryForList(sb.toString());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		DCProperty property = new DCProperty();
		
		for (Map<String, Object> map : resultList) {
			property.setPropertyId(map.get("PROPERTYID") != null ? Integer.valueOf(map.get("PROPERTYID").toString()) : null);
			property.setName(map.get("NAME") != null ? map.get("NAME").toString() : null);
			property.setDescription(map.get("DESCRIPTION") != null ? map.get("DESCRIPTION").toString() : null);
			property.setValue(map.get("VALUE") != null ? map.get("VALUE").toString() : null);
			property.setLegalType(map.get("LEGAL_TYPE") != null ? Integer.valueOf(map.get("LEGAL_TYPE").toString()) : null);
			property.setPropertyType(map.get("PROPERTY_TYPE") != null ? Integer.valueOf(map.get("PROPERTY_TYPE").toString()) : null);
			property.setOpdate(map.get("OPDATE") != null ? Timestamp.valueOf(map.get("OPDATE").toString()) : null);
			property.setOpuser(map.get("OPUSER") != null ? map.get("OPUSER").toString() : null);
			property.setModate(map.get("MODATE") != null ? Timestamp.valueOf(map.get("MODATE").toString()) : null);
			property.setMouser(map.get("MOUSER") != null ? map.get("MODATE").toString() : null);
			
		}

		return property;
	}
}
