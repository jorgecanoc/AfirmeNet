package com.afirme.afirmenet.service.impl.config;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.config.PropertyDao;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.model.DCProperty;
import com.afirme.afirmenet.service.config.PropertyService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyDao propertyDao;

	@Override
	public List<DCProperty> getConfiguraciones() {
		return propertyDao.getConfiguraciones();
	}

	@Override
	public Map<String, Object> getConfiguracionesMap() {
		return propertyDao.getConfiguracionesMap();
	}
	
	@Override
	public String obtenerTiempoEsperaSegundos(ConfigProperties configuracion) {

		String tiempoEspera = "";
		try {
			int tiempo = AfirmeNetConstants.getValorConfigProperties(configuracion, Integer.class);
			tiempo = tiempo * 60;
			tiempoEspera = Integer.toString(tiempo);
		} catch (Exception e) {
			// En caso de error mandamos 60 minutos
			tiempoEspera = "3600";
		}

		return tiempoEspera;
	}
	
	@SuppressWarnings("static-access")
	@Override
    public void setTiempoEspera(ConfigProperties configuracion) {
                   String tiempoEspera = "";
                   try {           
                	               DCProperty propiedad = propertyDao.getConfiguraciones(Long.parseLong(configuracion.PROPERTYID_THIRD_ACCOUNT_TIME_PER.getValor()), 
                                		   Integer.parseInt(ConfigProperties.LEGAL_TYPE_PERSONA.getValor()), 0);
                                   int tiempo = Integer.parseInt(propiedad.getValue());
                                   tiempoEspera = Integer.toString(tiempo);
                   } catch (Exception e) {
                                   // En caso de error mandamos 60 minutos
                                   tiempoEspera = "60";
                   }

                   if(AfirmeNetConstants.getPropertiesConfig().containsKey(configuracion.PROPERTYID_THIRD_ACCOUNT_TIME_PER.getValor()))
                   {
                	   AfirmeNetConstants.getPropertiesConfig().put(configuracion.PROPERTYID_THIRD_ACCOUNT_TIME_PER.getValor(),tiempoEspera);
                   }
    }
	
	public String obtenerTiempoEspera(ConfigProperties configuracion) {
		
		String tiempoEspera = "";
		
		try {
			int tiempo = AfirmeNetConstants.getValorConfigProperties(configuracion, Integer.class);

			if (tiempo <= 60) {
				tiempoEspera = tiempo + " minutos";
			} else {
				int horas = tiempo / 60;
				int minutos = tiempo % 60;

				tiempoEspera = horas == 1 ? horas + " hora" : horas + " horas";

				if (minutos != 0) {
					tiempoEspera += " " + minutos + " minutos";
				}
			}
		} catch (Exception e) {
			tiempoEspera = "0 minutos";
		}

		return tiempoEspera;
	}
	
}
