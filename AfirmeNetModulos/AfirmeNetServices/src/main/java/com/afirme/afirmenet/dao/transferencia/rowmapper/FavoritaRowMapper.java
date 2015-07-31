/**
 * 
 */
package com.afirme.afirmenet.dao.transferencia.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.model.transferencia.Favorita;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;

/**
 * @author jorge.canoc@gmail.com
 * 
 */
public class FavoritaRowMapper implements RowMapper<Favorita> {

	@Override
	public Favorita mapRow(ResultSet rs, int rowNum) throws SQLException {
		Favorita favorita = new Favorita();
		Cuenta origen = new Cuenta();
		Cuenta destino = new Cuenta();

		favorita.setContractId(rs.getString("ENTITYID"));
		favorita.setOrdenFavorito(rs.getInt("NTRANSC"));
		origen.setNumber(rs.getString("CORIGEN"));
		origen.setCcy(rs.getString("MONEDAORIGEN"));
		destino.setNumber(rs.getString("CDESTINO"));
		destino.setCcy(rs.getString("MONEDADESTINO"));

		favorita.setAccountType(rs.getString("CDACCTYPE"));
		favorita.setBeneficiaryName(rs.getString("BENEFICIARIO"));
		favorita.setTipoTransferencia(TipoTransferencia.findByValue(rs
				.getString("TRANSTYPE")));
		favorita.setTipoServicio(TipoServicio.findByValue(rs
				.getString("SUBTYPE")));
		favorita.setServiceNumber(rs.getString("NOSERVICIO"));
		favorita.setDescription(rs.getString("INSTPAGO"));
		favorita.setEmailBeneficiary(rs.getString("EMAILBENEF"));
		favorita.setBankReceiving(rs.getString("BNKRECEPT"));
		favorita.setRfc(rs.getString("RFC"));
		favorita.setIva(rs.getBigDecimal("IVA"));
		favorita.setAmount(rs.getBigDecimal("AMOUNT"));
		favorita.setReferenceNumber(rs.getString("REFNUM"));
		destino.setBankCode(rs.getString("BNKRECEPT"));
		destino.setBankName(rs.getString("BANKNAME"));
		favorita.setOrigen(origen);
		favorita.setDestino(destino);
		
		return favorita;
	}

}
