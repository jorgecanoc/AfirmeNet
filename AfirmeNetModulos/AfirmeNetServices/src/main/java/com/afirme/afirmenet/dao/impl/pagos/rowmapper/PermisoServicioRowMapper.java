package com.afirme.afirmenet.dao.impl.pagos.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.afirme.afirmenet.model.DCPermisoServicio;

public class PermisoServicioRowMapper implements RowMapper<DCPermisoServicio> {

	@Override
	public DCPermisoServicio mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		DCPermisoServicio permisoServicio = new DCPermisoServicio();
		permisoServicio.setEntityId(rs.getString("ENTITYID"));
		permisoServicio.setUserId(rs.getString("USERID"));
		permisoServicio.setUserType(rs.getString("USERTYPE"));
		permisoServicio.setServiceId(rs.getInt("SERVICEID"));
		permisoServicio.setStatus(rs.getInt("STATUS"));
		permisoServicio.setFechaCreacion(rs.getTimestamp("FECHACREACION"));
		permisoServicio.setDescripcion(rs.getString("DESCRIPCION"));
		permisoServicio.setEmpresa(rs.getString("EMPRESA"));
		return permisoServicio;
	}

}
