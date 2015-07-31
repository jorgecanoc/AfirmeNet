package com.afirme.afirmenet.dao.impl.convenios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.convenios.ConveniosDao;
import com.afirme.afirmenet.dao.impl.pagos.rowmapper.ConvenioRowMapper;
import com.afirme.afirmenet.dao.impl.pagos.rowmapper.PermisoServicioRowMapper;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.model.DCPermisoServicio;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Service
public class ConveniosDaoImpl implements ConveniosDao {

	@Autowired
	private AS400Dao as400Dao;

	@Autowired
	private DB2Dao db2Dao;

	@Override
	public List<INSER> getConvListAS400(String filtro) {

		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT A.SERBNK,A.SERTYP,A.SERCOM,A.SERNAM,A.SERDS1,A.SERDS2,A.SERREF,A.SERACC,A.SERVOU, ");
		sb.append("A.SERRTY,A.SERMIN,A.SERMAX,A.SERHLP,A.SERCTY,A.SERCMI,A.SERCMA,A.SERCHL,A.SERTAX,A.SERUTI, ");
		sb.append("A.SERACT,A.SERDTR,A.SERFLG,B.CAMNOM, A.SERIMG,A.SERIMGH,A.SERCOLOR from "
				+ AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
				+ "INSER A,"
				+ AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
				+ "SERTIP B ");
		sb.append("WHERE A.SERTYP = B.CAMTIP AND SERTYP NOT IN (" + filtro
				+ ")  ORDER BY SERCOM");
		List<INSER> convenios = jdbcTemplate.query(sb.toString(),
				new ConvenioRowMapper(true), new Object[] {});

		return convenios;
	}

	@Override
	public List<INSER> getConvenios400TDC() {

		String schemaName = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		String STM = "SELECT A.SERBNK,A.SERTYP,A.SERCOM,A.SERNAM,A.SERDS1,A.SERDS2,A.SERREF,A.SERACC,A.SERVOU,"
				+ "A.SERRTY,A.SERMIN,A.SERMAX,A.SERHLP,A.SERCTY,A.SERCMI,A.SERCMA,A.SERCHL,A.SERTAX,A.SERUTI,"
				+ "A.SERACT,A.SERDTR,A.SERFLG,B.CAMNOM from "
				+ schemaName
				+ "INSER A,"
				+ schemaName
				+ "SERTIP B "
				+ "WHERE A.SERTYP = B.CAMTIP "
				+ "AND A.SERTYP = 2 "
				+ "ORDER BY SERCOM";

		List<INSER> convenios = jdbcTemplate.query(STM, new ConvenioRowMapper(
				true), new Object[] {});

		return convenios;
	}

	@Override
	public List<INSER> getConvenios400TDCPropias() {

		String schemaName = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		String STM = "SELECT A.SERBNK,A.SERTYP,A.SERCOM,A.SERNAM,A.SERDS1,A.SERDS2,A.SERREF,A.SERACC,A.SERVOU,"
				+ "A.SERRTY,A.SERMIN,A.SERMAX,A.SERHLP,A.SERCTY,A.SERCMI,A.SERCMA,A.SERCHL,A.SERTAX,A.SERUTI,"
				+ "A.SERACT,A.SERDTR,A.SERFLG,B.CAMNOM from "
				+ schemaName
				+ "INSER A,"
				+ schemaName
				+ "SERTIP B "
				+ "WHERE A.SERTYP = B.CAMTIP "
				+ "AND A.SERTYP = 2 "
				+ "ORDER BY SERCOM";

		List<INSER> convenios = jdbcTemplate.query(STM, new ConvenioRowMapper(
				false), new Object[] {});

		return convenios;
	}

	@Override
	public void activaServicios(String contractId, TipoCliente cliente) {
		String query = "INSERT INTO DC_PERMISOS_SERVICIOS("
				+ "ENTITYID, USERID, USERTYPE, SERVICEID, "
				+ "STATUS, FECHACREACION, DESCRIPCION, EMPRESA) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		String userType = "P";
		userType = cliente.equals(TipoCliente.EMPRESAS) ? "E" : "P";
		db2Dao.getJdbcTemplate().update(
				query,
				new Object[] { contractId, contractId, userType, "100", "1",
						new Date(), "", "" });
	}

	@Override
	public DCPermisoServicio getActivacionServicios(String contractId,
			TipoCliente cliente) {
		try {
			String query = "SELECT  * FROM DC_PERMISOS_SERVICIOS WHERE ENTITYID = ? AND USERTYPE = ? AND SERVICEID = ? ";
			String userType = "P";
			userType = cliente.equals(TipoCliente.EMPRESAS) ? "E" : "P";

			Object[] params = new Object[] { contractId, userType,
					Integer.valueOf(100) };
			DCPermisoServicio permisoActivacion = db2Dao.getJdbcTemplate()
					.queryForObject(query, params,
							new PermisoServicioRowMapper());
			return permisoActivacion;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public INSER getConvenio(String sercom) {
		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT A.SERBNK,A.SERTYP,A.SERCOM,A.SERNAM,A.SERDS1,A.SERDS2,A.SERREF,A.SERACC,A.SERVOU, ");
		sb.append("A.SERRTY,A.SERMIN,A.SERMAX,A.SERHLP,A.SERCTY,A.SERCMI,A.SERCMA,A.SERCHL,A.SERTAX,A.SERUTI, ");
		sb.append("A.SERACT,A.SERDTR,A.SERFLG,B.CAMNOM, A.SERIMG,A.SERIMGH,A.SERCOLOR from "
				+ AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
				+ "INSER A,"
				+ AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
				+ "SERTIP B ");
		sb.append("WHERE A.SERTYP = B.CAMTIP AND A.SERCOM = '" + sercom
				+ "'  ORDER BY SERCOM");

		INSER convenio = jdbcTemplate.queryForObject(sb.toString(),
				new ConvenioRowMapper(true));

		return convenio;
	}

}
