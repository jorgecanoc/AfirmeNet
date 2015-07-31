package com.afirme.afirmenet.service.impl.transferencia;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.service.transferencia.TipoCambioService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Service
public class TipoCambioServiceImpl implements TipoCambioService{
	
	@Autowired
	private AS400Dao as400Dao;

	@Override
	public BigDecimal getBuyCCY(String CCY) {
		BigDecimal buy = new BigDecimal("0");
		
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		String sql ="select  RATFPR  from " + schemaName + "RATES " + 
					" where ratccy = ? and ratbnk = '01' ";
		
		Object[] args = {CCY};
		try{
			buy = as400Dao.getJdbcTemplate().queryForObject(sql, args, BigDecimal.class);
		 	return buy;
		}catch(EmptyResultDataAccessException e){
			return buy;
						
		}
	}

	@Override
	public BigDecimal getSellCCY(String CCY) {
		BigDecimal sell = new BigDecimal("0");
		
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		String sql ="select  RATFSR  from " + schemaName + "RATES " + 
					" where ratccy = ? and ratbnk = '01' ";
		
		Object[] args = {CCY};
		try{
			sell = as400Dao.getJdbcTemplate().queryForObject(sql, args, BigDecimal.class);
		 	return sell;
		}catch(EmptyResultDataAccessException e){
			return sell;
						
		}
	}

}
