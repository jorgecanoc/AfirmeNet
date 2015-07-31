package com.afirme.afirmenet.dao.impl.acceso;

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
import com.afirme.afirmenet.dao.acceso.PreguntaSecretaDao;
import com.afirme.afirmenet.ibs.beans.PreguntaSecreta;

@Repository
public class PreguntaSecretaDaoImpl implements PreguntaSecretaDao {

	static final Logger LOG = LoggerFactory.getLogger(PreguntaSecretaDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;
	
	@Override
	public List<String> getPregunta(String idContrato) {
		LOG.debug("Obteniendo pregunta secreta de Contrato: " + idContrato);
		
		String sql = 
				"SELECT PREGID, PREGUNTA " +
				"FROM DC_PERPREGSECRET " +
				"WHERE ENTITYID = ?";
		
		Map<String, Object> result;
		try {
			result = db2Dao.getJdbcTemplate().queryForMap(sql, new Object[] { idContrato });
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return null;
		}
		
		List<String> datosPregunta = null;
		
		if (result.size() > 0) {
			datosPregunta = new ArrayList<String>();
			datosPregunta.add(result.get("PREGID").toString().trim());
			datosPregunta.add(result.get("PREGUNTA").toString().trim());
			datosPregunta.add(idContrato);
		}
		return datosPregunta;
	}

	@Override
	public String getPreguntaSecretaEncrypt(String idContrato, int idPregunta) {
		LOG.debug("Obteniendo la Respuesta Encriptada de la Pregunta Secreta del Contrato: " + idContrato);
		
		String sql = 
				"SELECT RESPUESTA " +
				"FROM DC_PERPREGSECRET " +
				"WHERE ENTITYID = ? " +
				"AND PREGID = ?";
		
		String respuesta;
		try {
			respuesta = db2Dao.getJdbcTemplate().queryForObject(sql, new Object[] { idContrato, idPregunta }, String.class);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return null;
		}
		
		return respuesta.trim();
	}

	@Override
	public Map<String, String> getPregUsadas(String idContrato) {
		LOG.debug("Obteniendo Mapa de Preguntas Usadas del Contrato: " + idContrato);
		
		String sql = 
				"SELECT IDPREG " +
				"FROM DC_PREGUSADAS " +
				"WHERE ENTITYID = ?";
		
		List<Map<String, Object>> result;
		try {
			result = db2Dao.getJdbcTemplate().queryForList(sql, new Object[] { idContrato });
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return null;
		}
		
		Map<String, String> preguntasUsadas = new HashMap<String, String>();
		
		for (Map<String, Object> map : result) {
			preguntasUsadas.put(map.get("IDPREG").toString(), idContrato);
		}
		
		return preguntasUsadas;
	}

	@Override
	public List<PreguntaSecreta> getListadoPreguntas() {
		LOG.debug("Obteniendo Listado de Preguntas");
		
		String sql = 
				"SELECT PREGID,PREGUNTA, PALABRAS, VALIDAR " +
				"from DC_PREGSECRET";
		
		List<Map<String, Object>> result;
		try {
			result = db2Dao.getJdbcTemplate().queryForList(sql);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return null;
		}
		
		List<PreguntaSecreta> listadoPreguntas = new ArrayList<PreguntaSecreta>();
		
		for (Map<String, Object> map : result) {
			PreguntaSecreta pregSecreta = new PreguntaSecreta();
			pregSecreta.setIdPregunta(map.get("PREGID") != null ? map.get("PREGID").toString() : "");
			pregSecreta.setPregunta(map.get("PREGUNTA") != null ? map.get("PREGUNTA").toString() : "");
			pregSecreta.setPalabras(map.get("PALABRAS") != null ? map.get("PALABRAS").toString() : "");
			pregSecreta.setValidar(map.get("VALIDAR") != null ? map.get("VALIDAR").toString() : "");
			listadoPreguntas.add(pregSecreta);
		}
		
		return listadoPreguntas;
	}

	@Override
	public boolean setPreguntaSecreta(String idContrato, int idPregunta, String pregunta, String respuesta) {
		LOG.debug("Guardando/Actualizando Pregunta Secreta[" + idPregunta + "]: " + pregunta  + ", " +
				"con Respuesta: " + respuesta + ", del Contrato: " + idContrato);
		
		String sql = 
				"SELECT 1 " +
				"FROM DC_PERPREGSECRET " +
				"WHERE ENTITYID = ?"; 
		
		// verifica que el contrato ya tenga preguntas registradas
		String existenRegistros = null;
		try {
			existenRegistros = db2Dao.getJdbcTemplate().queryForObject(sql, new Object[] { idContrato }, String.class);
		} catch (Exception e) {
			LOG.debug("No existen registros de preguntas contestadas.");
		}
		
		int resultado = 0;
		
		// si el contrato tiene registros de preguntas, se actualizan, si no, se añade
		if (existenRegistros != null) {
			String updateSql = 
					"UPDATE DC_PERPREGSECRET " +
					"SET PREGID = ?, " +
					"PREGUNTA = ?, " +
					"RESPUESTA = ? " +
					"WHERE ENTITYID = ?";
			
			Object[] args = {
				idPregunta,
				pregunta,
				respuesta,
				idContrato
			};
			
			resultado = db2Dao.getJdbcTemplate().update(updateSql, args);
			
		} else {
			String insertSql = 
					"INSERT INTO DC_PERPREGSECRET " +
					"(ENTITYID, PREGID, PREGUNTA, RESPUESTA) " +
					"VALUES (?, ?, ?, ?)";
			
			Object[] args = {
				idContrato,
				idPregunta,
				pregunta,
				respuesta
			};
			
			resultado = db2Dao.getJdbcTemplate().update(insertSql, args);
		}
		
		if (resultado != 0)
			return true;
		
		return false;
	}

	@Override
	public boolean guardaPreguntaUsada(String idContrato, int idPregunta) {
		LOG.debug("Guardando Pregunta Usada[" + idPregunta + "], del Contrato: " + idContrato);
		
		String sql = 
				"INSERT INTO " +
				"DC_PREGUSADAS VALUES(?, ?)";
		
		int resultado;
		try {
			resultado = db2Dao.getJdbcTemplate().update(sql, new Object[] { idContrato, idPregunta });
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return false;
		}
		
		if (resultado != 0)
			return true;
		
		return true;
	}
	
}
