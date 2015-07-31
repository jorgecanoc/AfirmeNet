package com.afirme.afirmenet.dao.impl.transferencia;

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
import com.afirme.afirmenet.dao.impl.acceso.PreguntaSecretaDaoImpl;
import com.afirme.afirmenet.dao.transferencia.TasaCambioPreferencialDao;
import com.afirme.afirmenet.daoUtil.DaoUtil;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.ibs.beans.JBSIC001PF;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class TasaCambioPreferencialDaoImpl  implements TasaCambioPreferencialDao{
	
	static final Logger LOG = LoggerFactory.getLogger(PreguntaSecretaDaoImpl.class);
	
	@Autowired
	private DB2Dao db2Dao;
	
	@Autowired
	private AS400Dao as400Dao;

	@Override
	public JBSIC001PF validateCveTasaPreferencial(String cveTasaPref) {

		
		JBSIC001PF transferBean = new JBSIC001PF();
		
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		
		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		String query = "select SICDAT,SICCVE,SICOAM,SICAMT,SICOCY,SICDSC,SICEXR,SICOTC from "+schemaName+"sic001pf WHERE SICCVE = ? AND SICBRN = '501' AND SICEST = '1'";
		
		
		try{
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, new Object[] { cveTasaPref });
	
			if(rows.size()>0){
			for (Map<String, Object> row : rows) {
             	transferBean.setSICDAT(DaoUtil.getBigDecimal(row.get("SICDAT")));
             	transferBean.setSICCVE(DaoUtil.getString(row.get("SICCVE")));
             	transferBean.setSICOAM(DaoUtil.getBigDecimal(row.get("SICOAM")));
             	transferBean.setSICAMT(DaoUtil.getBigDecimal(row.get("SICAMT")));
             	transferBean.setSICOCY(DaoUtil.getString(row.get("SICOCY")));
             	transferBean.setSICDSC(DaoUtil.getString(row.get("SICDSC")));
             	transferBean.setSICEXR(DaoUtil.getBigDecimal(row.get("SICEXR")));
             	transferBean.setSICOTC(DaoUtil.getBigDecimal(row.get("SICOTC")));

			}
			}else{
				return null;
			}
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		
		return transferBean;
	}

}
