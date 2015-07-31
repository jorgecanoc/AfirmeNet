package com.afirme.afirmenet.dao.impl.transferencia;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.transferencia.ComisionesDao;
import com.afirme.afirmenet.enums.ComisionTransaccion;
import com.afirme.afirmenet.ibs.beans.transferencia.Comision;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
@Service
public class ComisionesDaoImpl implements ComisionesDao{
	
	@Autowired
	AS400Dao as400Dao;
	
	@Override
	public BigDecimal getNationalFee(ComisionTransaccion transaccion, BigDecimal monto) {
		BigDecimal fee= new BigDecimal(0);
		try {
			String sql="SELECT RANCOMIS FROM "+AfirmeNetConstants.AS400_LIBRARY+"INRANGOPF where RANTRAN=? AND RANGOCCY='MXP' AND RANGOINI<=? and RANGOFIN>=?";
			Map<String, Object> result = as400Dao.getJdbcTemplate().queryForMap(
					sql, new Object[] { transaccion.getValue(), monto, monto });
			if (result.size() > 0) {
				fee = new BigDecimal(result.get("RANCOMIS").toString());
			}
		} catch (EmptyResultDataAccessException ex) {}
		return fee;
	}

	@Override
	public BigDecimal getGeneralPIFee(String paqueteAfirmeNet) {
		BigDecimal fee= new BigDecimal(0);
		try {
			String sql="SELECT EUSTNA FROM "+AfirmeNetConstants.AS400_LIBRARY+"GRPUSR where GRPUID=?";
			Map<String, Object> result = as400Dao.getJdbcTemplate().queryForMap(
					sql, new Object[] { paqueteAfirmeNet });
			if (result.size() > 0) {
				fee = new BigDecimal(result.get("EUSTNA").toString());
			}
		} catch (EmptyResultDataAccessException ex) {}
		return fee;
	}

	@Override
	public Comision getEspecialPIFee(ComisionTransaccion transaccion,
			String numeroCliente) {
		Comision fee= null;
		try {
			String sql="SELECT ESPPOR, ESPFIJ FROM "+AfirmeNetConstants.AS400_LIBRARY+"coaesppf where ESPCUN=? and ESPCDE=?";
			Map<String, Object> result = as400Dao.getJdbcTemplate().queryForMap(
					sql, new Object[] { new BigDecimal(numeroCliente), new BigDecimal(transaccion.getValue()) });
			if (result.size() > 0) {
				fee= new Comision();
				fee.setFija(new BigDecimal(result.get("ESPFIJ").toString()));
				fee.setPorcentaje(new BigDecimal(result.get("ESPPOR").toString()));
			}
		} catch (EmptyResultDataAccessException ex) {}
		return fee;
	}

	
}
