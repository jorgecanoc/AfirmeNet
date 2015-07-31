package com.afirme.afirmenet.dao.impl.pagos.impuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.pagos.impuestos.ImpuestosDao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.model.pagos.impuestos.Impuesto;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class ImpuestosDaoImpl implements ImpuestosDao {

	@Autowired
	protected AS400Dao as400Dao;

	@Override
	public void insertaCertificadoDigital(Impuesto impuesto) {
		Object[] params = new Object[] { impuesto.getFolioPago(),
				impuesto.getRfc(), impuesto.getCadenaGenerada().substring(4,impuesto.getCadenaGenerada().length()),
				impuesto.getCertificadoDigital() };
		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO "
				+ AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
				+ "SATCERPF ( ");
		sql.append("CEFOL,CERFC,CECADE,CESELL");
		sql.append(") ");
		sql.append(" VALUES ( ?, ?, ?, ? )");

		as400Dao.getJdbcTemplate().update(sql.toString(), params);
	}

	@Override
	public void insertaImpuesto(Impuesto impuesto) {

		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO DC_TAXMSG (");
		sql.append("ENTITYID, DEBACC,DIGICODE,AMOUNT,PDD,PMM,PYY,VDD,VMM,VYY,VHH,VSS,PHH,PSS,");
		sql.append("TYPTRF,OUSER,VUSER,	AUSER,ODATE,VDATE,	ADATE,STS,NUMAPR,DCIBS_REF,FOLIO,APELLIDOP,");
		sql.append("APELLIDOM,NOMBRE,CIANAME,RFC,FLG,PDATE,");
		sql.append("PTIME, BNKCODE,CERNUM,BLANK,TAXCER,TAX11,TAX12,TAX13,TAX14,TAX15,");
		sql.append("CODE1,CODE2,CODE3,CODE4,CODE5,TAXNUM,CONFNUM,DIGITALSIGNATURE,CODE1N,CODE2N,CODE3N,CODE4N,CODE5N,");
		sql.append("CURP,HD_CAMPO1,HD_CAMPO2,HD_CAMPO3,HD_CAMPO4,HD_CAMPO5,ENT,DEP,CONTA,CADENA,DPA,DT_CAMPO1,DT_CAMPO2,DT_CAMPO3,");
		sql.append("DT_CAMPO4,DT_CAMPO5,LLAVEPAGO,TAX16,TAX17,TAX18,TAX19,TAX20");
		sql.append(") VALUES (");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?");
		sql.append(")");

	}

}
