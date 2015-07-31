package com.afirme.afirmenet.dao.impl.acceso;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.acceso.CampaniaDao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.DCMessageIni;
import com.afirme.afirmenet.model.DCMessageIni.Estatus;
import com.afirme.afirmenet.model.DCMessageIni.TipoPublicidad;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;

/**
 * Implementacion de {@link CampaniaDao}
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Repository
public class CampaniaDaoImpl implements CampaniaDao {

	static final Logger LOG = LoggerFactory.getLogger(CampaniaDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;

	@Autowired
	private AS400Dao as400Dao;

	@Override
	public DCMessageIni getCampania(TipoCliente tipoCliente, String contrato,
			String usuarioId, String token) {
		LOG.debug("Obteniendo campaña para el userId:" + usuarioId);
		JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();
		String sDate = Util.getYYYYMMDD();
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		String query = " select ACCION,CUSTYPE,ESTATUS,FDATE,FRECUENCIA,IDMSG,"
				+ "IMAGEN,MESSAGE,SALUDO,SDATE,TERMINOS,TIPO_AVISO,TIPO_PROD,TIPO_PUBL,TITLE,TXTCONFIRM, URL "
				+ " from DC_MSGINI " + " where (CUSTYPE = '"
				+ tipoCliente.getValue() + "' OR CUSTYPE = '0') "
				+ " and SDATE <= '" + sDate + "' " + " and FDATE >= '" + sDate
				+ "' " + " and ESTATUS <> 'C' " + " and FRECUENCIA LIKE '%"
				+ dayOfWeek + "%' " + "and TIPO_PUBL = '"
				+ TipoPublicidad.AMBAS.getValue() + "'"
				+ " order by IDMSG DESC";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		DCMessageIni msgbean = null;
		for (Map<String, Object> row : rows) {
			msgbean = new DCMessageIni();
			msgbean.setTipoProducto((String) row.get("TIPO_PROD"));
			msgbean.setIdMsg(new BigDecimal((Integer) row.get("IDMSG")));

			if (permiteMostrarCampania(msgbean.getTipoProducto() + ","
					+ msgbean.getIdMsg() + ",", contrato, usuarioId, token)) {

				msgbean.setAccion((String) row.get("ACCION"));
				msgbean.setEstatus(Estatus.getNameByValue((String) row
						.get("ESTATUS")));
				msgbean.setFinalDate(TimeUtils.getDate(
						(String) row.get("FDATE"), TimeUtils.DB2_DATE_FORMAT));
				msgbean.setFrecuencia((String) row.get("FRECUENCIA"));
				msgbean.setImagen((String) row.get("IMAGEN"));
				msgbean.setMessage((String) row.get("MESSAGE"));
				msgbean.setSaludo((String) row.get("SALUDO"));
				msgbean.setStartDate(TimeUtils.getDate(
						(String) row.get("SDATE"), TimeUtils.DB2_DATE_FORMAT));
				msgbean.setTerminos((String) row.get("TERMINOS"));
				msgbean.setTextoAlConfirmar((String) row.get("TXTCONFIRM"));
				msgbean.setTipoCliente(TipoCliente.getNameByValue((String) row
						.get("CUSTYPE")));
				msgbean.setTipoPublicidad(TipoPublicidad
						.getNameByValue((String) row.get("TIPO_PUBL")));
				msgbean.setTitle((String) row.get("TITLE"));
				msgbean.setUrl((String) row.get("URL"));
				break;
			}

		}
		return msgbean;
	}

	/**
	 * Metodo que valida si una campaña pude mostrarse o no al usuario logeado
	 * en la aplicacion
	 * 
	 * @param campaigns
	 *            producto y id de la campaña almacenada
	 * @param contract
	 *            numero de contrato del usuario
	 * @param usuario
	 *            el identificador de usuario
	 * @param token
	 *            el token del usuario
	 * @return
	 */
	public boolean permiteMostrarCampania(String campaigns, String contract,
			String usuario, String token) {
		boolean permite = false;
		String schemaName = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		// Selimina el punto del esquema
		schemaName = schemaName.substring(0, schemaName.length() - 1);

		SimpleJdbcCall call = as400Dao.getSimpleJdbcCall()
				.withSchemaName(schemaName).withProcedureName("cons_ccom");

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("CONTRATO", contract).addValue("USUARIO", usuario)
				.addValue("TOKEN", token).addValue("DATOS", campaigns);

		String out = call.executeObject(String.class, in);
		if (StringUtils.isNotEmpty(out)) {
			permite = true;
		}
		return permite;

	}

}
