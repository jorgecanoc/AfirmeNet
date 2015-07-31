package com.afirme.afirmenet.dao.impl.transferencia;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.transferencia.FavoritaDao;
import com.afirme.afirmenet.dao.transferencia.rowmapper.FavoritaRowMapper;
import com.afirme.afirmenet.model.transferencia.Favorita;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;

@Repository
public class FavoritaDaoImpl implements FavoritaDao {

	static final Logger LOG = LoggerFactory.getLogger(FavoritaDaoImpl.class);
	@Autowired
	private DB2Dao db2Dao;

	@Override
	public void agregar(Favorita favorita) {

		// Valida si existe favorita
		if (!existeFavorita(favorita)) {
			// Consulta no. de ultima transaccion registrada

			Integer newId = getSecuenciaFavoritas(favorita.getContractId());
			if (newId.intValue() == 16) {
				// Elimina la ultima transferencia favorita
				eliminar(favorita.getContractId(), 15);
			}
			newId = 1;

			// Se recorre el orden de las favoritas
			String sql = "UPDATE DC_TRANSFAV SET NTRANSC=NTRANSC+1 WHERE ENTITYID=?";
			db2Dao.getJdbcTemplate().update(sql,
					new Object[] { favorita.getContractId() });

			sql = "INSERT INTO DC_TRANSFAV(ENTITYID,NTRANSC,CORIGEN,CDESTINO,CDACCTYPE,BENEFICIARIO,TRANSTYPE,"
					+ "SUBTYPE,NOSERVICIO,INSTPAGO,EMAILBENEF,BNKRECEPT,RFC,IVA,AMOUNT, REFNUM, BANKNAME, MONEDAORIGEN,MONEDADESTINO) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = new Object[] {
					favorita.getContractId(), //ENTITYID
					newId,//NTRANSC
					favorita.getOrigen().getNumber(),//CORIGEN
					favorita.getTransactionCode().equals(TipoTransferencia.PAGO_DE_SERVICIOS.getValor())? null:favorita.getDestino().getNumber(),//CDESTINO
					favorita.getOrigen().getFlg(),//CDACCTYPE
					favorita.getBeneficiaryName(),//BENEFICIARIO
					favorita.getTipoTransferencia().getValor(),//TRANSTYPE
					favorita.getTipoServicio() != null ? favorita.getTipoServicio().getValor() : null,//SUBTYPE
					favorita.getServiceNumber(),//NOSERVICIO 
					favorita.getDescription(),//INSTPAGO
					favorita.getEmailBeneficiary(),//EMAILBENEF
					favorita.getDestino() != null ?favorita.getDestino().getBankCode():"62", //BNKRECEPT
					favorita.getRfc(),//RFC
					favorita.getIva(),//IVA 
					favorita.getAmount(),//AMOUNT
					favorita.getTipoServicio() != null? favorita.getServiceNumber():favorita.getReferenceNumber(),//REFNUM
					favorita.getDestino() != null ?favorita.getDestino().getBankName():null,//BANKNAME
					favorita.getOrigen().getCcy(),//MONEDAORIGEN
					favorita.getDestino() != null ?favorita.getDestino().getCcy():null }; //MONEDADESTINO

			db2Dao.getJdbcTemplate().update(sql, params);
		}

	}

	@Override
	public boolean existeFavorita(Favorita favorita) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) AS NUM FROM DC_TRANSFAV WHERE ENTITYID = ? AND CORIGEN = ? AND TRANSTYPE= ? ";

		Object[] params = null;

		if (favorita.getTransactionCode().equals(TipoTransferencia.PAGO_DE_SERVICIOS.getValor())) {
			sql += " AND NOSERVICIO = ?";
			params = new Object[] { favorita.getContractId(),
					favorita.getOrigen().getNumber(),
					favorita.getTipoTransferencia().getValor(),
					favorita.getNumeroServicio()};

		} else if (favorita.getTransactionCode().equals(TipoTransferencia.PAGO_TESORERIA_GOBIERNO_DISTRITO_FEDERAL.getValor()) || 
				favorita.getTransactionCode().equals(TipoTransferencia.DOMICILIACION_DE_SERVICIOS_BASICOS.getValor())) {
			params = new Object[] { 
					favorita.getContractId(),
					favorita.getOrigen().getNumber(),
					favorita.getTipoTransferencia().getValor() };
			
		} else {
			sql += " AND CDESTINO = ?";
			params = new Object[] { favorita.getContractId(),
					favorita.getOrigen().getNumber(),
					favorita.getDestino().getNumber(),
					favorita.getTipoTransferencia().getValor() };
			
		}

		Integer newId = db2Dao.getJdbcTemplate().queryForObject(sql, params,
				Integer.class);
		if (newId != null && newId.intValue() >= 1) {
			existe = true;
		}
		return existe;
	}

	private Integer getSecuenciaFavoritas(String contractId) {
		// Consulta no. de ultima transaccion registrada
		String sql = "SELECT MAX(NTRANSC) AS NUM  FROM DC_TRANSFAV WHERE ENTITYID= ?";
		Integer newId = db2Dao.getJdbcTemplate().queryForObject(sql,
				new Object[] { contractId }, Integer.class);
		if (newId == null) {
			newId = 0;
		}
		newId++;

		return newId;
	}

	@Override
	public List<Favorita> listar(String contractId) {
		String sql = "SELECT * FROM DC_TRANSFAV WHERE ENTITYID=? ORDER BY NTRANSC";
		Object[] params = new Object[] { contractId };
		List<Favorita> favoritas = db2Dao.getJdbcTemplate().query(sql,
				new FavoritaRowMapper(), params);
		return favoritas;
	}

	@Override
	public void modificar(Favorita favorita) {
		if (existeFavorita(favorita)) {
			String sql = "UPDATE DC_TRANSFAV SET AMOUNT=?, REFNUM = ?, INSTPAGO = ?  WHERE ENTITYID=? AND NTRANSC= ?";
			Object[] params = new Object[] { favorita.getAmount(),
					favorita.getReferenceNumber(), favorita.getDescription(),
					favorita.getContractId(), favorita.getOrdenFavorito() };
			db2Dao.getJdbcTemplate().update(sql, params);
		}

	}

	@Override
	public void eliminar(String contractId, Integer orden) {

		String sql = "DELETE FROM DC_TRANSFAV WHERE ENTITYID=? AND NTRANSC= ?";
		Object[] params = new Object[] { contractId, orden };
		db2Dao.getJdbcTemplate().update(sql, params);

		// RECORRE REGISTROS
		sql = "UPDATE DC_TRANSFAV SET NTRANSC=NTRANSC-1 WHERE ENTITYID=? AND NTRANSC >?";
		db2Dao.getJdbcTemplate().update(sql, params);

	}

	@Override
	public Favorita consulta(String contractId, Integer orden) {
		String sql = "SELECT * FROM DC_TRANSFAV WHERE ENTITYID=? AND NTRANSC= ?";
		Object[] params = new Object[] { contractId, orden };
		Favorita favorita = db2Dao.getJdbcTemplate().queryForObject(sql,
				params, new FavoritaRowMapper());
		return favorita;
	}

}
