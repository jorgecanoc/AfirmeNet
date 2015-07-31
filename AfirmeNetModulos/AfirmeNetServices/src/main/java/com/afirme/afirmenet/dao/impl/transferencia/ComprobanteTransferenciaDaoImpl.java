package com.afirme.afirmenet.dao.impl.transferencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.transferencia.ComprobanteTransferenciaDao;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.transferencia.Comprobante;

@Repository
public class ComprobanteTransferenciaDaoImpl implements
		ComprobanteTransferenciaDao {

	static final Logger LOG = LoggerFactory
			.getLogger(ComprobanteTransferenciaDaoImpl.class);
	@Autowired
	private DB2Dao db2Dao;

	@Override
	public void insertaConfirmacionOperacion(Comprobante transferenciaBase) {
		String sql = "INSERT INTO DC_CONFMSG (TYPTRF, NARRA, DEBACC, CREACC, DESCRIP, ENTITYID,  USERID, PMM, PSS, "
				+ "PYY, VDD, BENEADD, VMM, VHH, SERVNUM, IVA, PLZRECPTOR, FEES,"
				+ "VSS, VYY, BNKRECPTOR, RFC, DCIBS_REF, AMOUNT, CCY, BENENAME, REFENUM,"
				+ "PDD, PHH, FEE_IVA, PSECONDS, REFUSR) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		Object[] params = new Object[] {
				transferenciaBase.getTipoTransferencia().getValor(),
				transferenciaBase.getNarrative(),
				transferenciaBase.getOrigen() != null ? transferenciaBase
						.getOrigen().getNumber() : transferenciaBase
						.getDebitAccount(),
				transferenciaBase.getDescription(),
				transferenciaBase.getContractId(),
				transferenciaBase.getUserId(),
				Util.getMM(),
				Util.getSS(),
				Util.getYY(),
				transferenciaBase.getValidationYear(),
				transferenciaBase.getBeneficiaryName(),
				transferenciaBase.getValidationMonth(),
				transferenciaBase.getServiceNumber(),
				transferenciaBase.getIva(),
				transferenciaBase.getPlazaReceiving(),
				"",// FEES
				transferenciaBase.getValidationMinute(),
				transferenciaBase.getValidationYear(),
				transferenciaBase.getBankReceiving(),
				transferenciaBase.getRfc(),
				transferenciaBase.getAfirmeNetReference(),
				transferenciaBase.getAmount(), transferenciaBase.getCurrency(),
				transferenciaBase.getBeneficiaryName(),
				transferenciaBase.getReferenceNumber(), Util.getDD(),
				Util.getHH(), "",// FEE_IVA
				"", // PSECONDS
				transferenciaBase.getUserReference() };
		
		db2Dao.getJdbcTemplate().update(sql, params);
	}

}
