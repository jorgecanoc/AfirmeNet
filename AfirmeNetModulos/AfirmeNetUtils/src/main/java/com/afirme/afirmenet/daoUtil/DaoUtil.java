package com.afirme.afirmenet.daoUtil;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afirme.afirmenet.enums.ConfigPersonas;

public class DaoUtil {
	
	static final Logger LOG = LoggerFactory.getLogger(DaoUtil.class);
	
	public DaoUtil() {
		super();
	}
	
	public static String getString(Object campo){
		
		if(campo!=null){
			return (String) campo;
		}				
		
		return "";
		
	}
	
	public static BigDecimal getBigDecimal(Object campo){
		
		if(campo!=null){
			return (BigDecimal) campo;
		}				
		
		return null;		
	}
	
	public static Integer getInt(Object campo){
		
		if(campo!=null){
			return (Integer) campo;
		}				
		
		return 0;		
	}
	
	public static <T> T getValor(Object campo,
			Class<T> type) {
		LOG.debug("Obteniendo valor del campo: " + campo + " de tipo: " + type.getName());
		try {			
				if (!campo.equals(null)) {					
					return type.cast(campo);
				}			
		} catch (Exception e) {
			LOG.error("Error al tratar de obtener el valor del campo: "
					+ campo + " de tipo: " + type.getName());
		}
		return null;

	}


}
