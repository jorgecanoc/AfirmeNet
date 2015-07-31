package com.afirme.afirmenet.dao.impl.transferencia;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.transferencia.ParametricasUsuarioDao;
import com.afirme.afirmenet.ibs.objects.parameter.JOParamAccumAcc;
import com.afirme.afirmenet.ibs.objects.parameter.JOParamOwnAcc;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.utils.time.TimeUtils;

@Repository
public class ParametricasUsuarioDaoImpl implements ParametricasUsuarioDao {
	static final Logger LOG = LoggerFactory
			.getLogger(ParametricasUsuarioDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;

	@Override
	public void insert(Comprobante comprobante) throws SQLException {
		// Se crea Objeto de Trasnporte
		String debitAccount = comprobante.getDebitAccount();
		if (comprobante.getOrigen() != null) {
			debitAccount = comprobante.getOrigen().getNumber();
		}

		JOParamAccumAcc param = new JOParamAccumAcc(
				comprobante.getContractId(), debitAccount, comprobante
						.getTipoTransferencia().getValor(),
				comprobante.getInterType(), comprobante.getServiceType(),
				comprobante.getAmount().doubleValue(),
				comprobante.getValidationYear(),
				comprobante.getValidationMonth(),
				comprobante.getValidationDay());

		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO DC_ACCUM_ORIGIN_ACC_PERSON (BXIREF, CONTRACT, ACCOUNT, TRANSTYPE, SERVICETYPE, INTERTYPE, TRANSNAME, OPDATE, DAILYTRANSNUM, DAILYAMOUNT) ");
		sql.append(" VALUES ('").append(comprobante.getAfirmeNetReference())
				.append("', ").append(comprobante.getContractId()).append(", ")
				.append(debitAccount).append(", '");
		sql.append(comprobante.getTipoTransferencia().getValor()).append("', ");
		sql.append(param.getSertyp()).append(", ").append(param.getIntertype())
				.append(", '")
				.append(comprobante.getTipoTransferencia().name())
				.append("', '");
		sql.append(TimeUtils.getDateFormat(new Date(), "yyyy-MM-dd"))
				.append("', ").append(param.getDailytransnum()).append(", ")
				.append(comprobante.getAmount()).append(")");

		db2Dao.getJdbcTemplate().update(sql.toString());
	}

	@Override
	public void delete(long contract, String bxiRef) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<JOParamOwnAcc> getParameters(long contract, long account,
			String transtype, int serviceType, int intertype) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * FROM DC_PARAM_ORIGIN_ACC_PERSON");
		sb.append(" WHERE CONTRACT = ").append(contract);
		if (account > 0)
			sb.append(" AND ACCOUNT = ").append(account);
		if (transtype != null)
			sb.append(" AND TRANSTYPE = '").append(transtype).append("'");
		if (serviceType > 0)
			sb.append(" AND SERVICETYPE = ").append(serviceType);
		if (intertype > 0)
			sb.append(" AND INTERTYPE = ").append(intertype);

		List<Map<String, Object>> rows;
		JOParamOwnAcc bean = null;
		List<JOParamOwnAcc> beanList = new ArrayList<JOParamOwnAcc>(0);
		try {
			rows = db2Dao.getJdbcTemplate().queryForList(sb.toString());
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return null;
		}
		for (Map<String, Object> row : rows) {
			bean = new JOParamOwnAcc();
			bean.setContract(((BigDecimal) row.get("CONTRACT")).longValue());
			bean.setAccount(((BigDecimal) row.get("ACCOUNT")).longValue());
			bean.setCurrency((String) row.get("CURRENCY"));
			bean.setTranstype((String) row.get("TRANSTYPE"));
			bean.setSertyp((Integer) row.get("SERVICETYPE"));
			bean.setIntertype((Integer) row.get("INTERTYPE"));
			bean.setTransname((String) row.get("TRANSNAME"));
			bean.setDailytransnum((Integer) row.get("DAILYTRANSNUM"));
			bean.setDailyamount(((BigDecimal) row.get("DAILYAMOUNT"))
					.doubleValue());
			bean.setMonthlytransnum((Integer) row.get("MONTHLYTRANSNUM"));
			bean.setMonthlyamount(((BigDecimal) row.get("MONTHLYAMOUNT"))
					.doubleValue());
			bean.setDailytransnum_c((Integer) row.get("DAILYTRANSNUM_C"));
			bean.setDailyamount_c(((BigDecimal) row.get("DAILYAMOUNT_C"))
					.doubleValue());
			bean.setMonthlytransnum_c((Integer) row.get("MONTHLYTRANSNUM_C"));
			bean.setMonthlyamount_c(((BigDecimal) row.get("MONTHLYAMOUNT_C"))
					.doubleValue());
			bean.setOpdate((Date) row.get("FDATE"));
			bean.setStatus((Integer) row.get("STATUS"));
			beanList.add(bean);
		}
		return beanList;
	}

	@Override
	public List<JOParamAccumAcc> getAcumulado(long contract, long account,
			String transtype, int serviceType, int intertype, Date initialD,
			Date finalD) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT BXIREF, CONTRACT, ACCOUNT, TRANSTYPE, SERVICETYPE, INTERTYPE, TRANSNAME, OPDATE, SUM (DAILYAMOUNT) DAILYAMOUNT,  SUM (DAILYTRANSNUM) DAILYTRANSNUM");
		sb.append(" FROM DC_ACCUM_ORIGIN_ACC_PERSON");
		sb.append(" WHERE CONTRACT = ").append(contract);

		if (account > 0)
			sb.append(" AND ACCOUNT = ").append(account);

		if (transtype != null)
			sb.append(" AND TRANSTYPE = '").append(transtype).append("'");

		if (serviceType > 0)
			sb.append(" AND SERVICETYPE = ").append(serviceType);
		if (intertype > 0)
			sb.append(" AND INTERTYPE = ").append(intertype);

		if (finalD == null) {
			Calendar c = Calendar.getInstance();
			c.setTime(initialD);
			c.set(Calendar.DAY_OF_MONTH, 1);
			// Fecha Inicial
			initialD = c.getTime();
			LOG.debug(" Fecha Inicial: " + initialD);
			// Fecha Final
			int lastDate = c.getActualMaximum(Calendar.DATE);
			c.set(Calendar.DATE, lastDate);
			finalD = c.getTime();
			LOG.debug(" Fecha Final: " + finalD);

		}
		sb.append(" AND OPDATE >= '")
				.append(TimeUtils.defaultDateFormat.format(initialD))
				.append("'");
		sb.append(" AND OPDATE <= '")
				.append(TimeUtils.defaultDateFormat.format(finalD)).append("'");
		sb.append(" GROUP BY BXIREF, CONTRACT, ACCOUNT, TRANSTYPE, SERVICETYPE, INTERTYPE, OPDATE, TRANSNAME ");

		List<Map<String, Object>> rows;
		JOParamAccumAcc bean = null;
		List<JOParamAccumAcc> beanList = new ArrayList<JOParamAccumAcc>(0);
		try {
			rows = db2Dao.getJdbcTemplate().queryForList(sb.toString());
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return null;
		}
		for (Map<String, Object> row : rows) {
			bean = new JOParamAccumAcc();
			bean.setBxIRef((String) row.get("BXIREF"));
			bean.setContract(((BigDecimal) row.get("CONTRACT")).longValue());
			bean.setAccount(((BigDecimal) row.get("ACCOUNT")).longValue());
			bean.setTranstype((String) row.get("TRANSTYPE"));
			bean.setSertyp((Integer) row.get("SERVICETYPE"));
			bean.setIntertype((Integer) row.get("INTERTYPE"));
			bean.setTransname((String) row.get("TRANSNAME"));
			bean.setOpdate((Date) row.get("OPDATE"));
			bean.setDailytransnum((Integer) row.get("DAILYTRANSNUM"));
			bean.setDailyamount(((BigDecimal) row.get("DAILYAMOUNT"))
					.doubleValue());
			beanList.add(bean);
		}
		return beanList;
	}

	@Override
	public boolean trasnferenciaEnTiempo(TipoTransferencia tipo, int tiempo,
			String dia) {
		boolean esValida = false;

		String sql = "SELECT INITIME,ENDTIME,STS"
				+ " from DC_TIMETABLE where TRANSTYPE = '" + tipo.getValor()
				+ "' and DAYOFWEEK = '" + dia + "'";
		List<Map<String, Object>> rows;
		try {
			rows = db2Dao.getJdbcTemplate().queryForList(sql);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			esValida = true;
			return esValida;
		}

		if (rows != null) {
			Integer ini = (Integer) rows.get(0).get("INITIME");
			Integer fin = (Integer) rows.get(0).get("ENDTIME");
			if ((tiempo >= ini.intValue()) && (tiempo <= fin.intValue())) {
				esValida = true;
			}
			// if (STS.equals("N")) {
			// found = false;
			// }
		}

		return esValida;
	}

	@Override
	public int insertParamOwnAcc(List<JOParamOwnAcc> parametricas) {
		int resultado = 0;
		int count = 0;

		for (JOParamOwnAcc po : parametricas) {
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO ");
			sb.append(" DC_PARAM_ORIGIN_ACC_PERSON ");
			sb.append(" (CONTRACT, ACCOUNT, CURRENCY, TRANSTYPE, SERVICETYPE, INTERTYPE, TRANSNAME, DAILYTRANSNUM, DAILYAMOUNT,");
			sb.append(" MONTHLYTRANSNUM, MONTHLYAMOUNT, DAILYTRANSNUM_C, DAILYAMOUNT_C, MONTHLYTRANSNUM_C, MONTHLYAMOUNT_C, OPDATE, STATUS)");
			sb.append(" VALUES (").append(po.getContract()).append(", ")
					.append(po.getAccount()).append(", '");
			sb.append(po.getCurrency()).append("', '")
					.append(po.getTranstype()).append("', ")
					.append(po.getSertyp()).append(", ");
			sb.append(po.getIntertype()).append(", '")
					.append(po.getTransname()).append("', ");
			sb.append(po.getDailytransnum()).append(", ")
					.append(po.getDailyamount()).append(", ");
			sb.append(po.getMonthlytransnum()).append(", ")
					.append(po.getMonthlyamount()).append(", ");
			sb.append(po.getDailytransnum_c()).append(", ")
					.append(po.getDailyamount_c()).append(", ");
			sb.append(po.getMonthlytransnum_c()).append(", ")
					.append(po.getMonthlyamount_c()).append(", ");
			sb.append("CURRENT TIMESTAMP").append(", ").append(po.getStatus())
					.append(")");

			resultado = db2Dao.getJdbcTemplate().update(sb.toString());
			if (resultado != 0)
				count += resultado;
		}

		return count;
	}

	@Override
	public int updateParamOwnAcc(List<JOParamOwnAcc> parametricas) {
		int resultado = 0;
		int count = 0;

		// List<String> sql=new ArrayList<String>();
		for (JOParamOwnAcc po : parametricas) {
			StringBuffer sb = new StringBuffer();
			sb.append(" UPDATE ");
			sb.append(" DC_PARAM_ORIGIN_ACC_PERSON ");
			sb.append(" SET ");
			sb.append(" DAILYTRANSNUM = ").append(po.getDailytransnum())
					.append(", ");
			sb.append(" DAILYAMOUNT = ").append(po.getDailyamount())
					.append(", ");
			sb.append(" MONTHLYTRANSNUM = ").append(po.getMonthlytransnum())
					.append(", ");
			sb.append(" MONTHLYAMOUNT = ").append(po.getMonthlyamount())
					.append(", ");
			sb.append(" DAILYTRANSNUM_C = ").append(po.getDailytransnum_c())
					.append(", ");
			sb.append(" DAILYAMOUNT_C = ").append(po.getDailyamount_c())
					.append(", ");
			sb.append(" MONTHLYTRANSNUM_C = ")
					.append(po.getMonthlytransnum_c()).append(", ");
			sb.append(" MONTHLYAMOUNT_C = ").append(po.getMonthlyamount_c())
					.append(", ");
			sb.append(" STATUS = ").append(po.getStatus()).append(", ");
			sb.append(" TRANSNAME = '").append(po.getTransname()).append("'");
			sb.append(" WHERE CONTRACT = ").append(po.getContract());
			sb.append(" AND ACCOUNT = ").append(po.getAccount());
			sb.append(" AND TRANSTYPE = '").append(po.getTranstype())
					.append("'");
			if (po.getSertyp() > 0)
				sb.append(" AND SERVICETYPE = ").append(po.getSertyp());
			if (po.getIntertype() > 0)
				sb.append(" AND INTERTYPE = ").append(po.getIntertype());
			// sql.add(sb.toString());

			resultado = db2Dao.getJdbcTemplate().update(sb.toString());

			if (resultado != 0)
				count += resultado;
		}

		return count;
	}

	@Override
	public List<JOParamOwnAcc> findRegisterChanged(long contract) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * FROM ");
		sb.append(" DC_PARAM_ORIGIN_ACC_PERSON");
		sb.append(" WHERE CONTRACT = ").append(contract);
		sb.append(" AND (DAILYAMOUNT_C > 0.0 ");
		sb.append(" AND MONTHLYAMOUNT_C > 0.0 ");
		sb.append(" OR STATUS = ")
				.append(JOParamOwnAcc.ESTATUS_INACTIVO_USUARIO).append(")");

		List<Map<String, Object>> rows;
		List<JOParamOwnAcc> parametricas = new ArrayList<JOParamOwnAcc>(0);
		try {
			rows = db2Dao.getJdbcTemplate().queryForList(sb.toString());
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return null;
		}
		for (Map<String, Object> row : rows) {
			JOParamOwnAcc bean = new JOParamOwnAcc();
			bean.setContract(((BigDecimal) row.get("CONTRACT")).longValue());
			bean.setAccount(((BigDecimal) row.get("ACCOUNT")).longValue());
			bean.setCurrency((String) row.get("CURRENCY"));
			bean.setTranstype((String) row.get("TRANSTYPE"));
			bean.setSertyp((Integer) row.get("SERVICETYPE"));
			bean.setIntertype((Integer) row.get("INTERTYPE"));
			bean.setTransname((String) row.get("TRANSNAME"));
			bean.setDailytransnum((Integer) row.get("DAILYTRANSNUM"));
			bean.setDailyamount(((BigDecimal) row.get("DAILYAMOUNT"))
					.doubleValue());
			bean.setMonthlytransnum((Integer) row.get("MONTHLYTRANSNUM"));
			bean.setMonthlyamount(((BigDecimal) row.get("MONTHLYAMOUNT"))
					.doubleValue());
			bean.setDailytransnum_c((Integer) row.get("DAILYTRANSNUM_C"));
			bean.setDailyamount_c(((BigDecimal) row.get("DAILYAMOUNT_C"))
					.doubleValue());
			bean.setMonthlytransnum_c((Integer) row.get("MONTHLYTRANSNUM_C"));
			bean.setMonthlyamount_c(((BigDecimal) row.get("MONTHLYAMOUNT_C"))
					.doubleValue());
			bean.setOpdate(((Date) row.get("OPDATE")));
			bean.setStatus((Integer) row.get("STATUS"));
			parametricas.add(bean);

		}
		return parametricas;
	}

}
