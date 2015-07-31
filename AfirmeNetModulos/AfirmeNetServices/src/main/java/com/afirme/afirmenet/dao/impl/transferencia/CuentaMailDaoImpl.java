package com.afirme.afirmenet.dao.impl.transferencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.transferencia.CuentaMailDao;

@Repository
public class CuentaMailDaoImpl implements CuentaMailDao {

static final Logger LOG = LoggerFactory.getLogger(CuentaTercerosDaoImpl.class);
	
	@Autowired
	DB2Dao db2Dao;
	
	@Override
	public Map<String, String> getEmailReferences(String idContrato) {
		
		String sql = 
			"SELECT EMAIL, ACC " +
			"FROM DC_ACCOUNTMAIL " +
			"WHERE ENTITYID = ? " +
			"ORDER BY ACC";
		
		List<Map<String, Object>> listResult;
		
		try {
			listResult =  db2Dao.getJdbcTemplate().queryForList(sql, new Object[] {idContrato});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		Map<String, String> mapReferences = new HashMap<String, String>();
		
		for (Map<String, Object> map : listResult) {
			
			String account = map.get("ACC") != null ? map.get("ACC").toString() : "";
			String email = map.get("EMAIL") != null ? map.get("EMAIL").toString() : "";
			
			mapReferences.put(account, email);
		}
		
		return mapReferences;
	}

	@Override
	public String getCorreoCuenta(String contrato, String cuenta) {
		String sql ="select EMAIL from dc_accountmail where ENTITYID = ? and ACC=?";		
		Object[] args = {contrato,cuenta};
		try{
			return db2Dao.getJdbcTemplate().queryForObject(sql, args, String.class);
		}catch(EmptyResultDataAccessException e){
			return "";
		}
	}
	
	@Override
	public boolean updateCorreoCuenta(String contrato, String cuenta, String correo) {
		int resultado = 0;
		String sql ="update dc_accountmail set EMAIL = ? where ENTITYID = ? and ACC=?";		
		Object[] args = {correo,contrato,cuenta};
		
			resultado= db2Dao.getJdbcTemplate().update(sql, args);
			
			if (resultado != 0)
				return true;

			return false;
		
	}

	@Override
	public boolean tieneCorreo(String contrato, String cuenta) {
		String sql ="select EMAIL from dc_accountmail where ENTITYID = ? and ACC=?";		
		Object[] args = {contrato,cuenta};
		try{
			String email= db2Dao.getJdbcTemplate().queryForObject(sql, args, String.class);
			
			if(email==null||email.equals(""))
				return true;
			else 
				return true;
			
		}catch(EmptyResultDataAccessException e){
			return false;
		}
	}

	@Override
	public boolean setCorreoCuenta(String contrato, String cuenta, String correo) {
		String sql = "insert into dc_accountmail (ENTITYID, ACC, EMAIL) values(?,?,?)";
		int resultado;
		
		try {
			resultado=db2Dao.getJdbcTemplate().update(sql, new Object[] {contrato,cuenta,correo});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros.");
			return false;
		}
		
		if (resultado != 0)
			return true;
		
		return true;

	}


}
