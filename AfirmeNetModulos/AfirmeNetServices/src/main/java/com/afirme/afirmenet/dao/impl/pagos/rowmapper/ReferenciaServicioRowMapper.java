package com.afirme.afirmenet.dao.impl.pagos.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.afirme.afirmenet.model.pagos.servicios.ReferenciaServicio;

public class ReferenciaServicioRowMapper implements
		RowMapper<ReferenciaServicio> {

	@Override
	public ReferenciaServicio mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ReferenciaServicio ref = new ReferenciaServicio();

		ref.setCuentaRef(rs.getString("DDVACC").trim());
		ref.setLongitudFija(rs.getString("DDVFIJ").trim());
		ref.setLongitud(rs.getInt("DDVLON"));
		ref.setAceptaCaracteres(rs.getString("DDVCAR").trim());
		ref.setAlgoritmo(rs.getString("DDVSBR").trim());
		ref.setNumeroRef(rs.getString("DDVREF").trim());
		ref.setAceptaPagosParciales(rs.getString("DDVPPA").trim());
		ref.setAceptaPagosVencidos(rs.getString("DDVPVN").trim());
		ref.setMontoPagoVencido(rs.getString("DDVMPV").trim());
		ref.setPorcentajePagoVencido(rs.getString("DDVPPV").trim());
		ref.setDiasGracia(rs.getInt("DDVDPV"));
		ref.setFrecuenciaComision(rs.getString("DDVFCC").trim());
		ref.setNombreServicio(rs.getString("DDVSRV").trim());

		return ref;
	}

}
