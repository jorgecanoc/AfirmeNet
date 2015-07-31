package com.afirme.afirmenet.service.impl.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.config.ConfiguracionDao;
import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.JBTefbanpf;
import com.afirme.afirmenet.ibs.databeans.SPAPLAPF;
import com.afirme.afirmenet.model.DCConfig;
import com.afirme.afirmenet.model.DCConfig.Aplicacion;
import com.afirme.afirmenet.model.Holiday;
import com.afirme.afirmenet.service.config.ConfiguracionService;

/**
 * Clase de servicio que permite obtener las configuraciones necesarias de
 * ciertos atributos para que opere correctamente la aplicacion seleccionada
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

	@Autowired
	private ConfiguracionDao configuracionDao;

	@Override
	public List<DCConfig> getConfiguraciones() {
		return configuracionDao.getConfiguraciones();
	}

	@Override
	public List<DCConfig> getConfiguraciones(Aplicacion aplicacion) {
		return configuracionDao.getConfiguraciones(aplicacion);
	}

	@Override
	public Map<String, Object> getConfiguracionesMap() {
		return configuracionDao.getConfiguracionesMap();
	}

	@Override
	public Map<String, Object> getConfiguracionesMap(Aplicacion aplicacion) {
		return configuracionDao.getConfiguracionesMap(aplicacion);
	}

	@Override
	public List<Holiday> getDiasFeriados() {
		return configuracionDao.getDiasFeriados();
	}

	@Override
	public Map<Integer, String> getErrores() {
		return configuracionDao.getErrores();
	}

	@Override
	public List<JBTefbanpf> getBANList() {
		return configuracionDao.getBANList();
	}

	@Override
	public List<SPAPLAPF> getPlazas() {
		return configuracionDao.getPlazas();
	}

	@Override
	public Map<HorarioServicio, String> getHorarios() {
		return configuracionDao.getHorarios();
	}

}
