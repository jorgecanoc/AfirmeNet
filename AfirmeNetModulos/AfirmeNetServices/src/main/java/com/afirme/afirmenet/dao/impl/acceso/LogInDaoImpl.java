package com.afirme.afirmenet.dao.impl.acceso;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.acceso.LogInDao;
import com.afirme.afirmenet.daoUtil.DaoUtil;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.ibs.beans.JBBMuser;
import com.afirme.afirmenet.ibs.beans.JBLogList;
import com.afirme.afirmenet.ibs.beans.JBProCode;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class LogInDaoImpl implements LogInDao{
	
	static final Logger LOG = LoggerFactory.getLogger(PreguntaSecretaDaoImpl.class);
	
	@Autowired
	private DB2Dao db2Dao;
	
	@Autowired
	private AS400Dao as400Dao;

	@Override
	public boolean verificarPrimerLoginConAlias(String UserIdJSP) {
		boolean usa = true;
		
		String sql = "SELECT ENTITYID FROM DC_ALIAS_INFO WHERE ENTITYID =? AND USERID=? AND ALIAS_UTILIZADO = 'N'";
		
		try{
			String result = (String) db2Dao.getJdbcTemplate().queryForObject(sql, new Object[] { UserIdJSP,UserIdJSP },String.class);
		}catch(EmptyResultDataAccessException e){
			usa = false;
						
		}
		
		return usa;
	}
	
	@Override
	public boolean actualizarPrimerLoginConAlias(String UserIdJSP) {
		int resultado = 0;
		String sql = "UPDATE DC_ALIAS_INFO SET ALIAS_UTILIZADO = 'Y' WHERE ENTITYID= =? ";

		resultado = db2Dao.getJdbcTemplate()
				.update(sql, new Object[] { UserIdJSP},
						BigDecimal.class);
		if (resultado != 0)
			return true;

		return false;
	}
	
	
	@Override
	public String getINOUT(String UserIdJSP) {
		
		String inout="";
		String sql ="SELECT INOUT FROM DC_INOUT WHERE ENTITYID=?";
		
		Object[] args = {UserIdJSP};
		try{
			inout = db2Dao.getJdbcTemplate().queryForObject(sql, args, String.class);
		 	return inout;
		}catch(EmptyResultDataAccessException e){
			return inout;
						
		}
		
	}
	
	@Override
	public boolean insertaINOUT(String UserIdJSP) {
		int resultado = 0;
		String sql = "INSERT INTO DC_INOUT VALUES(?,?) ";

		resultado = db2Dao.getJdbcTemplate()
				.update(sql, new Object[] { UserIdJSP,"Y"},
						BigDecimal.class);
		if (resultado != 0)
			return true;

		return false;
	}
	
	@Override
	public boolean updateINOUT(String UserIdJSP, String estatus) {
		int resultado = 0;
		String sql = "UPDATE DC_INOUT SET INOUT=? WHERE ENTITYID=? ";

		resultado = db2Dao.getJdbcTemplate()
				.update(sql, new Object[] {estatus,UserIdJSP});
		if (resultado != 0)
			return true;

		return false;
	}
	
	@Override
	public String getLTime(String UserIdJSP) {
		
		String inout ="";
		String sql ="SELECT DTTM from DC_LOGP where USERID = ? order by DTTM DESC FETCH FIRST 1 ROWS ONLY";
		
		Object[] args = {UserIdJSP};
		
		try{
			return inout = db2Dao.getJdbcTemplate().queryForObject(sql, args, String.class);
		}catch(EmptyResultDataAccessException e){
			return inout;
		}
	}
	
	@Override
	public String consultaIP(String contrato, String usuario) {
		
		String sql ="SELECT DIRECCION_IP FROM DC_DIRECCION_IP WHERE ENTITYID=? AND USERID=?";
		
		Object[] args = {contrato,usuario};
		
		String ip = db2Dao.getJdbcTemplate().queryForObject(sql, args, String.class);
		return ip;
	}
	
	@Override
	public boolean insertaIP(String contrato,String usuario,String ip) {
		int resultado = 0;
		String sql = "INSERT INTO DC_DIRECCION_IP VALUES(?,?,?,?) ";

		resultado = db2Dao.getJdbcTemplate()
				.update(sql, new Object[] {contrato,usuario,ip,"0"},
						BigDecimal.class);
		if (resultado != 0)
			return true;

		return false;
	}
	
	@Override
	public boolean actualizaIP(String contrato,String usuario,String ip,String estatus) {
		int resultado = 0;
		String sql = "UPDATE DC_DIRECCION_IP SET DIRECCION_IP=?, SEGUNDA_SESION=? WHERE ENTITYID=? AND USERID=? ";

		resultado = db2Dao.getJdbcTemplate()
				.update(sql, new Object[] {ip,estatus,contrato,usuario});
		if (resultado != 0)
			return true;

		return false;
	}
	
	@Override
	public JBBMuser getBMUser(String contrato) {
		
		JBBMuser bmuser = new JBBMuser();
		
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		
		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		String query = "SELECT usstsse, ussesio, usfeise, ushrise, usfetrn, ushrtrn " +
				"FROM " + schemaName + "BMUSERPF WHERE USUSRID=? AND UPPER(USSTSSR)<>'C'";
		try{
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, new Object[] { contrato });
	
			for (Map<String, Object> row : rows) {
				bmuser.setEstatus(DaoUtil.getString(row.get("usstsse")));
				bmuser.setSesion(DaoUtil.getString(row.get("ussesio")));
				bmuser.setFechaLogIn(DaoUtil.getBigDecimal(row.get("usfeise")).toString());
				bmuser.setHoraLogIn(Util.formatHora(DaoUtil.getBigDecimal(row.get("ushrise")).toString()));
				bmuser.setFechaTrx(DaoUtil.getBigDecimal(row.get("usfetrn")).toString());
				bmuser.setHoraTrx(Util.formatHora(DaoUtil.getBigDecimal(row.get("ushrtrn")).toString()));
				
				if(bmuser.getEstatus().equals("")) {
					bmuser.setEstatus((String) row.get("N"));
					}
			}
		}catch(EmptyResultDataAccessException e){
			
		}
		
		return bmuser;
	}
	
	@Override
	public boolean updateBMUser(String contrato, String estatus) {
		int resultado = 0;
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		String sql = "UPDATE " + schemaName + "bmuserpf SET USSTSSE=? WHERE USUSRID=?";

		resultado = as400Dao.getJdbcTemplate()
				.update(sql, new Object[] {estatus,contrato});
		if (resultado != 0)
			return true;

		return false;
	}
	
	@Override
	public boolean updateBMUser(String contrato) {
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		String sql = "UPDATE " + schemaName + "bmuserpf SET USSTSSE='S', USSESIO='', USFEISE=?, USHRISE=? WHERE USUSRID=?";

		try {
			    as400Dao.getJdbcTemplate().update(sql, new Object[] {Util.getCurrentYMD(),Util.getCurrentHMS(),contrato});
				return true;
			
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

	}
	
	@Override
	public int getSegundosSignOff() {
		
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		String sql ="SELECT pasgoff FROM " + schemaName + "BMPARMPF";
		
		Object[] args = {};
		
		int segundos = (Integer) as400Dao.getJdbcTemplate().queryForObject(sql, args, Integer.class);
		return segundos;
	}

	@Override
	public JBLogList getLastLoginPer(String contrato) {
		
		JBLogList loglistbean = new JBLogList();
		
		JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();

		String query  ="SELECT DTTM,USERID,LACTION,REMARK,ACCOUNT,AMOUNT,CURRENCY,TYP_TRAN,DCIBS_REF,"
				+ "days(current date) - days(date( '20' || SUBSTR(DTTM , 1, 2) || '-' || SUBSTR(DTTM, 3, 2) || '-' || SUBSTR(DTTM, 5, 2) )) as DOut"
				+ " from DC_LOGP where USERID=? and LACTION='LOGIN' and (TYP_TRAN='OKL' OR TYP_TRAN='')"
				+ " ORDER BY DTTM DESC FETCH FIRST 1 ROWS ONLY";
		try{
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, new Object[] { contrato });
	
			for (Map<String, Object> row : rows) {

				loglistbean.setDTTM(DaoUtil.getString(row.get("DTTM")));
				loglistbean.setENTITYID("");
				loglistbean.setUSERID(DaoUtil.getString(row.get("USERID")));
				loglistbean.setREMARK(DaoUtil.getString(row.get("REMARK")));
				loglistbean.setACCOUNT(DaoUtil.getString(row.get("ACCOUNT")));
				loglistbean.setAMOUNT(DaoUtil.getBigDecimal(row.get("AMOUNT")).toString());
				loglistbean.setCURRENCY(DaoUtil.getString(row.get("CURRENCY")));
				loglistbean.setDCIBS_REF(DaoUtil.getString(row.get("DCIBS_REF")));
				loglistbean.setLACTION(DaoUtil.getString(row.get("LACTION")));
				loglistbean.setTYP_TRAN(DaoUtil.getString(row.get("TYP_TRAN")));
				
			}
		}catch(EmptyResultDataAccessException e){
			
		}
		
		return loglistbean;
	}

	@Override
	public void getAddLogPer(String dTTM, String uSERID, String lACTION,
			String rEMARK, String aCCOUNT, String aMOUNT, String cURRENCY,
			String tYP_TRAN, String dCIBS_REF) {
		
		String sql = "insert into DC_LOGP(DTTM,USERID,LACTION,REMARK,ACCOUNT,AMOUNT,CURRENCY,TYP_TRAN,DCIBS_REF) values (?,?,?,?,?,?,?,?,?)";

		 db2Dao.getJdbcTemplate()
				.update(sql, new Object[] {dTTM, uSERID, lACTION,rEMARK, aCCOUNT, Double.parseDouble(aMOUNT), cURRENCY,	tYP_TRAN, dCIBS_REF});

	}

	@Override
	public List<JBProCode> getProcode(boolean bPaqueteSinToken) {
		
		List<JBProCode> lstProCode = new ArrayList<JBProCode>();
		
		JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT TRANSTYPE,TRANSDESC from DC_PROCODE");
		
		if(bPaqueteSinToken)
    	{
			sb.append(" WHERE TRANSTYPE IN ('36','02', '90')");
    	}
		
		sb.append(" order by TRANSDESC");
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sb.toString(), new Object[] {});

		try{
		
		for (Map<String, Object> row : rows) {
			JBProCode pc = new JBProCode();
			pc.setTRANSTYPE(DaoUtil.getString(row.get("TRANSTYPE")));
			pc.setTRANSDESC(DaoUtil.getString(row.get("TRANSDESC")));
			lstProCode.add(pc);
		}
		}catch(EmptyResultDataAccessException e){
			
		}
		
		return lstProCode;
		
		
	}

}
