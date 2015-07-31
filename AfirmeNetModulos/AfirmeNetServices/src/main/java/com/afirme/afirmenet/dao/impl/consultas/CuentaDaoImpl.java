package com.afirme.afirmenet.dao.impl.consultas;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.consultas.CuentaDao;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class CuentaDaoImpl implements CuentaDao {
	static final Logger LOG = LoggerFactory.getLogger(CuentaDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;
	@Autowired
	private AS400Dao as400Dao;

	@Override
	public String getNickName(String contrato, String cuenta) {
		LOG.debug("Obteniendo el nick de la cuenta: " + cuenta);
		String nick = "";
		try {
			String sql = "select NICKNAME from DC_NICK where entityid=? and accnum=?";
			Map<String, Object> result = db2Dao.getJdbcTemplate().queryForMap(
					sql, new Object[] { contrato, cuenta });
			if (result.size() > 0) {
				nick = result.get("NICKNAME").toString().trim();
			}
		} catch (Exception ex) {
			LOG.error("Error al obtener nick de la cuenta: " + ex.getMessage());
		}
		return nick;

	}

	@Override
	public boolean isComercio(String cuenta) {
		String sql = "SELECT TCTACH from " + AfirmeNetConstants.AS400_LIBRARY
				+ "TD0000PF WHERE TCTACH=?";
		boolean isComercio = false;
		try {
			Map<String, Object> result = as400Dao.getJdbcTemplate()
					.queryForMap(sql, new Object[] { cuenta });
			if (result.size() > 0) {
				isComercio = true;
			}
		} catch (Exception ex) {
			LOG.error("Error al revisar si es comercio: " + ex.getMessage());
		}
		return isComercio;
	}

	@Override
	public String getTitularCredito(String cliente) {
		String titular = "";
		LOG.debug("Obteniendo el titular del credito del cliente: " + cliente);
		try {
			String sql = "select (cusna1 || cusna2) as NOM from "
					+ AfirmeNetConstants.AS400_LIBRARY + "cumst where cuscun=?";
			Map<String, Object> result = as400Dao.getJdbcTemplate()
					.queryForMap(sql, new Object[] { cliente });
			if (result.size() > 0) {
				titular = result.get("NOM").toString().trim();
			}
		} catch (Exception ex) {
			LOG.error("Error al traer el titular: " + ex.getMessage());
		}
		return titular;
	}

	@Override
	public boolean esCuentasJunior(String cuenta) {
		String sql = "SELECT acmacc FROM " + AfirmeNetConstants.AS400_LIBRARY
				+ "acmst WHERE acmpro='ACOM' and "
				+ "acmaty='SAV' and ACMACD='04' and acmacc = ?";
		boolean isJr = false;
		try {
			Map<String, Object> result = as400Dao.getJdbcTemplate()
					.queryForMap(sql, new Object[] { cuenta });
			if (result.size() > 0) {
				isJr = true;
			}
		} catch (Exception ex) {
			LOG.error("Error al revisar si es comercio: " + ex.getMessage());
		}
		return isJr;
	}
}
