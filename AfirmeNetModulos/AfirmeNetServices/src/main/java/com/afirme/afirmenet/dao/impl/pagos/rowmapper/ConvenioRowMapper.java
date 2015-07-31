package com.afirme.afirmenet.dao.impl.pagos.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.afirme.afirmenet.ibs.databeans.INSER;

public class ConvenioRowMapper implements RowMapper<INSER> {
	boolean readFromRS = false;
	
	
	public ConvenioRowMapper(boolean readFromRS){
		this.readFromRS = readFromRS;
	}
	
	
	@Override
	public INSER mapRow(ResultSet rs, int rowNum) throws SQLException {
		INSER convenio = new INSER();
		convenio.setSERBNK(rs.getString("SERBNK"));
		convenio.setSERTYP(rs.getBigDecimal("SERTYP"));
		convenio.setSERCOM(rs.getBigDecimal("SERCOM"));
		convenio.setSERNAM(readFromRS ? rs.getString("SERNAM"):"TARJETA DE CREDITO AFIRME TERCEROS");
		convenio.setSERDS1(rs.getString("SERDS1"));
		convenio.setSERDS2(rs.getString("SERDS2"));
		convenio.setSERREF(rs.getBigDecimal("SERREF"));
		convenio.setSERACC(rs.getString("SERACC"));
		convenio.setSERVOU(rs.getBigDecimal("SERVOU"));
		convenio.setSERRTY(rs.getString("SERRTY"));
		convenio.setSERMIN(rs.getBigDecimal("SERMIN"));
		convenio.setSERMAX(rs.getBigDecimal("SERMAX"));
		convenio.setSERHLP(rs.getString("SERHLP"));
		convenio.setSERCTY(rs.getString("SERCTY"));
		convenio.setSERCMI(rs.getBigDecimal("SERCMI"));
		convenio.setSERCMA(rs.getBigDecimal("SERCMA"));
		convenio.setSERCHL(rs.getString("SERCHL"));
		convenio.setSERTAX(rs.getString("SERTAX"));
		convenio.setSERUTI(rs.getString("SERUTI"));
		convenio.setSERACT(rs.getString("SERACT"));
		convenio.setSERDTR(rs.getBigDecimal("SERDTR"));
		convenio.setSERFLG(rs.getString("SERFLG"));
		convenio.setSERNOM(rs.getString("CAMNOM"));
		convenio.setSERIMG(rs.getString("SERIMG").trim());
		convenio.setSERIMGH(rs.getString("SERIMGH").trim());
		convenio.setSERCOLOR(rs.getString("SERCOLOR").trim());
		return convenio;
	}

}
