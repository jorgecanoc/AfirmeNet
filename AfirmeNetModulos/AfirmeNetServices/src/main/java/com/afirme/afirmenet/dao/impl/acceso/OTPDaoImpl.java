package com.afirme.afirmenet.dao.impl.acceso;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.acceso.OTPDao;

@Repository
public class OTPDaoImpl implements OTPDao {

	static final Logger LOG = LoggerFactory.getLogger(OTPDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;

	@Override
	public String obtenToken(String contrato) {
		LOG.debug("Obteniendo datos de Token del Contrato: " + contrato);
		
		String sql = 
				"SELECT NOSERIE " +
				"FROM OTP_TOKEN " +
				"WHERE CONTRATO = ? " +
				"AND USUARIO = ? " +
				"AND ESTATUS='C'";
		
		Object[] args = {
			contrato,
			contrato,
		};
		
		String token;
		try {
			token = db2Dao.getJdbcTemplate().queryForObject(sql, args, String.class);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return null;
		}
		
		LOG.debug("OTPDao - obtenToken() - No. Serie Token: " + token);
		return token;
	}
	
	@Override
	public boolean usaTokens(String contrato) {
		LOG.debug("Verificando si Contrato: " + contrato + " hace uso de Token.");

		String sql = "SELECT NOSERIE FROM OTP_TOKEN WHERE CONTRATO=? AND ESTATUS='C'";

		try{
			BigDecimal result = (BigDecimal) db2Dao.getJdbcTemplate().queryForObject(sql, new Object[] { contrato }, BigDecimal.class);
			return true;
		}catch(EmptyResultDataAccessException e){
			return false;						
		}

		
	}

	@Override
	public boolean validaTokenXActivar(String contrato, String usuario, int serialToken, String codigoActivacion) {
		LOG.debug("Validando estauts del Token: " + serialToken + ", Codigo de Activacion: " + codigoActivacion + " del Contrato: " + contrato + ", " +
				"de Usuario: " + usuario);
		String sql = 
				"SELECT NOSERIE " +
				"FROM OTP_TOKEN " +
				"WHERE NOSERIE = ? " +
				"AND CONTRATO = ? " +
				"AND USUARIO = ? " +
				"AND CODACTIVACION = ? " +
				"AND ESTATUS = 'C'";
		
		Object[] args = {
			serialToken,
			contrato,
			usuario,
			codigoActivacion
		};
		
		List<Map<String, Object>> result;
		try {
			result = db2Dao.getJdbcTemplate().queryForList(sql, args);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return false;
		}
		
		if (result.size() > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean setCodigoSeguridad(String contrato, String usuario, String codigoSegEncrypt) {
		LOG.debug("Actualizando código de seguridad del Contrato: " + contrato + ", del Usuario: " + usuario);
		
		String sql = 
				"UPDATE OTP_TOKEN " +
				"SET CODACTIVACION = ? " +
				"WHERE CONTRATO = ? " +
				"AND USUARIO = ? " +
				"AND ESTATUS = 'C'";
		
		Object[] args = {
			codigoSegEncrypt,
			contrato,
			usuario
		}; 
		
		int affectedRows;
		try {
			affectedRows = db2Dao.getJdbcTemplate().update(sql, args);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return false;
		}
		
		if (affectedRows > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean setFechaVencimiento(String serialToken, String fechaVencimiento) {
		LOG.debug("Estableicendo Fecha de Vencimiento del Token(No. de Serie): " + serialToken + ", Fecha de Vencimiento: " + fechaVencimiento);
		
		String sql = 
				"UPDATE OTP_TOKEN " +
				"SET FECVENCIMIENTO = ? " +
				"WHERE NOSERIE = ?";
		
		Object[] args = {
			fechaVencimiento,
			Integer.valueOf(serialToken)
		};
		
		int affectedRows;
		try {
			affectedRows = db2Dao.getJdbcTemplate().update(sql, args);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return false;
		}
		
		if (affectedRows > 0)
			return true;
		
		return false;
	}
}
