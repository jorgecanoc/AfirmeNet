package com.afirme.afirmenet.dao.impl.acceso;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.acceso.UserDao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class UserDaoImpl implements UserDao {

	static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private AS400Dao as400Dao;
	@Autowired
	private DB2Dao db2Dao;
	
	@Override
	public String obtenerTipoRegimen(String contrato) {
		LOG.debug("Obtenciónn de Régimen del contrato: " + contrato);
		
		String sql = 
			"SELECT cuslgt, cusinc " +
			"FROM " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME) + "CUMST " +
			"WHERE cuscun = (" +
				"SELECT euscun " +
				"FROM " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME) + "EUSER " +
				"WHERE eususr = ?" +
			")";
		
		Map<String, Object> mapResult;
		try {
			mapResult = as400Dao.getJdbcTemplate().queryForMap(sql, new Object[] { contrato });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		String tipoRegimen = mapResult.get("CUSLGT").toString();
		String cusinc = mapResult.get("CUSINC").toString();

		// En caso de que venga vacio, recurrimos a cusinc, en caso de que este
		// ultimo este vacio, ponemos por default "persona fisica"
		if (tipoRegimen == null) {
			tipoRegimen = "";
		}

		tipoRegimen = tipoRegimen.trim();

		if (tipoRegimen.equals("")) {
			if (cusinc == null) {
				cusinc = "";
			}

			cusinc = cusinc.trim();

			if (cusinc.equals("")) {
				cusinc = "32";
			}

			if (cusinc.equals("32")) {
				tipoRegimen = "2";
			} else {
				tipoRegimen = "1";
			}
		}
		
		return tipoRegimen;
	}

	@Override
	public BigDecimal obtenerComisionEspecial(String numeroCliente, String codigoTransaccion, BigDecimal comision) {
		LOG.debug("Otenciónn de Comisión Especial del Cliente: " + numeroCliente + ", Código de Transacción: " + codigoTransaccion + ", Comisión: " + comision);
		
		String sql = 
			"SELECT ESPPOR, ESPFIJ " +
			"FROM COAESPPF WHERE ESPCUN = ? " +
			"AND ESPCDE = ?";
		
		Map<String, Object> mapResult;
		try {
			mapResult = as400Dao.getJdbcTemplate().queryForMap(sql, new Object[] { numeroCliente, codigoTransaccion });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		BigDecimal porcentajeDescuento = mapResult.get("ESPPOR") != null ? (BigDecimal) mapResult.get("ESPPOR") : null;
		BigDecimal comisionFija = mapResult.get("ESPFIJ") != null ? (BigDecimal) mapResult.get("ESPFIJ") : null;
		
		// Si se encuentra una comision especial, se verifica cual de las dos
		// aplica: Porcentaje o Comision fija
		if (porcentajeDescuento != null && comisionFija != null) {
			if (porcentajeDescuento.intValue() != 0) {
				BigDecimal porcentaje = new BigDecimal(100);
				porcentaje = porcentajeDescuento.divide(porcentaje);
				comision = comision.subtract(comision.multiply(porcentaje));
			} else {
				comision = comisionFija;
			}
		}
		
		return comision;
	}
	
	@Override
	public String obtenerNumeroClienteContrato(String contrato) {
		LOG.debug("Obtención de Número de Cliente del Contrato: " + contrato);
		
		String sql = 
			"SELECT EUSCUN " +
			"FROM EUSER " +
			"WHERE EUSUSR = ?";
		
		String numeroCliente;
		try {
			numeroCliente = as400Dao.getJdbcTemplate().queryForObject(sql, new Object[] { contrato }, String.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		return numeroCliente;
	}
	
	public String obtenerContratoToken(String serialToken) {
		LOG.debug("Obtención de Contrato del Token: " + serialToken);
		
		String sql = 
				"SELECT CONTRATO " +
				"FROM OTP_TOKEN " +
				"WHERE NOSERIE = ?";
		
		String contrato;
		try {
			contrato = db2Dao.getJdbcTemplate().queryForObject(sql, new Object[] { Integer.valueOf(serialToken) }, String.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NumberFormatException e) {
			return null;
		}
		
		return contrato;
	}
	
	@Override
	public String getMailUsuario(String contrato) {
		LOG.debug("Obteniendo Mail de Contrato: " + contrato);

		String sql = 
				"SELECT EUSIAD " +
				"FROM " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME) + "EUSER " +
				"WHERE EUSUSR = ?";

		String mail;
		try {
			mail = as400Dao.getJdbcTemplate().queryForObject(sql, new Object[] { contrato }, String.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		return mail;
	}

	@Override
	public int obtenerNumeroIntento(String contrato) {
		
		String sql = 
			"SELECT NUMERO_INTENTO " +
			"FROM DC_ALIAS_INFO " +
			"WHERE ENTITYID = ? " +
			"AND USERID = ?";
		
		int numeroIntento;
		try {
			numeroIntento = db2Dao.getJdbcTemplate().queryForObject(sql, new Object[] { contrato }, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
		
		return numeroIntento;
	}

	@Override
	public boolean verificarUsuarioRegistrado(String contrato) {
		
		String sql = 
			"SELECT * " +
			"FROM DC_ALIAS_INFO " +
			"WHERE ENTITYID = ? " +
			"AND USERID = ?";
		
		Map<String, Object> mapResult;
		try {
			mapResult = db2Dao.getJdbcTemplate().queryForMap(sql, new Object[] { contrato });
		} catch (DataAccessException e) {
			return false;
		}
		
		if (mapResult.size() > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean registrarUsuarioAlias(String contrato) {
		
		String sql = 
			"INSERT INTO DC_ALIAS_INFO " +
			"VALUES (?, ?, 1, 'Y')";
		
		int affectedRows = db2Dao.getJdbcTemplate().update(sql, new Object[] { contrato });
		
		if (affectedRows > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean actualizarPrimerLoginConAlias(String contrato) {
		
		String sql = 
			"UPDATE DC_ALIAS_INFO " +
			"SET ALIAS_UTILIZADO = 'Y' " +
			"WHERE ENTITYID = ?";
		
		int affectedRows = db2Dao.getJdbcTemplate().update(sql, new Object[] { contrato });
		
		if (affectedRows > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean incrementarNumeroIntentos(String contrato) {
		
		String sql = 
			"UPDATE DC_ALIAS_INFO " +
			"SET NUMERO_INTENTO = NUMERO_INTENTO + 1 " +
			"WHERE ENTITYID = ?";
		
		int affectedRows = db2Dao.getJdbcTemplate().update(sql, new Object[] { contrato });
		
		if (affectedRows > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean actualizarAlias(String contrato, String alias) {
		
		String sql = 
			"UPDATE " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME) + "EUSER " +
			"SET EUSALIAS = ? " +
			"WHERE EUSUSR = ?";
		
		int affectedRows = as400Dao.getJdbcTemplate().update(sql, new Object[] { alias, contrato });
		
		if (affectedRows > 0)
			return true;
		
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
