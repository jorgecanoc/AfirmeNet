package com.afirme.afirmenet.dao.impl.acceso;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.acceso.ContratoDao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.ibs.beans.Contrato;
import com.afirme.afirmenet.ibs.beans.JBLogin;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class ContratoDaoImpl implements ContratoDao {

	static final Logger LOG = LoggerFactory.getLogger(ContratoDaoImpl.class);
	
	@Autowired
	private AS400Dao as400Dao;
	
	@Autowired
	private MessageSource dibsSource;
	
	@Override
	public Contrato getDatosContrato(String idContrato) {
		LOG.debug("Obteniendo datos de Contrato: " + idContrato);

		String query = 
				"select EUSAM1,EUSUSR,EUSNAM,EUSPAS,EUSIAD,EUSMAX,EUSAMX,EUSMXT,EUSSTS,EUSSPENT,EUSSWFNT,EUSDOMNT,EUSTYANT,EUSTNANT,"
				+ "EUSNYANT,EUSNNANT,EUSIMPNT,EUSLMU,EUSSCD,EUSRJC,EUSFDA,EUSGID,EUSFAC,EUSCUN,EUSLGT,EUSALIAS,EUSKID,EUSUC2 "
				+ "from " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)+ "EUSER " + 
				"where EUSUSR = ?";

		Map<String, Object> row;
		try {
			row = as400Dao.getJdbcTemplate().queryForMap(query, new Object[] { idContrato });
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return null;
		}

		Contrato contrato = new Contrato();

		contrato.setCMENSUAL(Util.formatCCY(row.get("EUSAM1").toString().trim()));
		contrato.setENTITYID(row.get("EUSUSR").toString().trim());
		contrato.setNAME(row.get("EUSNAM").toString().trim());
		contrato.setPASSWORD(row.get("EUSPAS").toString().trim());
		contrato.setEMAIL(row.get("EUSIAD").toString().trim());
		contrato.setDLIMIT(Util.formatCCY(row.get("EUSMAX").toString().trim()));
		contrato.setALIMIT(Util.formatCCY(row.get("EUSAMX").toString().trim()));
		contrato.setTLIMIT(row.get("EUSMXT").toString().trim());
		contrato.setSTS(row.get("EUSSTS").toString().trim());
		contrato.setNSPEUA(row.get("EUSSPENT").toString().trim());
		contrato.setNSWIFT(row.get("EUSSWFNT").toString().trim());
		contrato.setNDOM(row.get("EUSDOMNT").toString().trim());
		contrato.setNTEFAFIRME(row.get("EUSTYANT").toString().trim());
		contrato.setNTEFNOAFIRME(row.get("EUSTNANT").toString().trim());
		contrato.setNNOMAFIRME(row.get("EUSNYANT").toString().trim());
		contrato.setNNOMNOAFIRME(row.get("EUSNNANT").toString().trim());
		contrato.setNIMPUESTOS(row.get("EUSIMPNT").toString().trim());
		contrato.setOUSER(row.get("EUSLMU").toString().trim());
		contrato.setODATE(row.get("EUSSCD").toString().trim());
		contrato.setINVALID(row.get("EUSRJC").toString().trim());
		contrato.setFDATE(row.get("EUSFDA").toString().trim());
		contrato.setGRPID(Integer.valueOf(row.get("EUSGID").toString().trim()));
		contrato.setENTFAC(row.get("EUSFAC").toString().trim());
		contrato.setCUSCUN(row.get("EUSCUN").toString().trim());
		contrato.setEUSLGT(row.get("EUSLGT").toString().trim());
		contrato.setEUSALIAS(row.get("EUSALIAS").toString().trim());
		contrato.setUserKeyID(row.get("EUSKID").toString().trim());
		try {
			contrato.setEntityBRN(row.get("EUSUC2").toString().trim());
		} catch (Exception e1) {
			contrato.setEntityBRN("0");
		}

		return contrato;
	}

	@Override
	public boolean updateContrato(Contrato contrato, String idContrato) {
		LOG.debug("Actualizando datos de Contrato: " + idContrato);
		
		String query = 
				"update " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME) + "EUSER " +
				"set EUSNAM = ?, " +
				"EUSIAD = ?, " +
				"EUSMAX = ?, " +
				"EUSAMX = ?, " +
				"EUSMXT = ?, " +
				"EUSSTS = ?, " +
				"EUSANU = ?, " +
				"EUSMEN = ?, " +
				"EUSSPE = ?, " +
				"EUSSWF = ?, " +
				"EUSDOM = ?, " +
				"EUSTYA = ?, " +
				"EUSTNA = ?, " +
				"EUSNYA = ?, " +
				"EUSNNA = ?, " +
				"EUSIMP = ?, " +
				"EUSSPENT = ?, " +
				"EUSSWFNT = ?, " +
				"EUSDOMNT = ?, " +
				"EUSTYANT = ?, " +
				"EUSTNANT = ?, " +
				"EUSNYANT = ?, " +
				"EUSNNANT = ?, " +
				"EUSIMPNT = ?, " +
				"EUSLMU = ?, " +
				"EUSSCD = ?, " +
				"EUSGID = ?, " +
				"EUSFAC = ?, " +
				"EUSCUN = ? " +
				"where EUSUSR = '" + idContrato;
		
		Object[] args = {
			contrato.getNAME(),
			contrato.getEMAIL(),
			contrato.getDLIMIT(),
			contrato.getALIMIT(),
			contrato.getTLIMIT(),
			contrato.getSTS(),
			contrato.getCANUAL(),
			contrato.getCMENSUAL(),
			contrato.getCSPEUA(),
			contrato.getCSWIFT(),
			contrato.getCDOM(),
			contrato.getCTEFAFIRME(),
			contrato.getCTEFNOAFIRME(),
			contrato.getCNOMAFIRME(),
			contrato.getCNOMNOAFIRME(),
			contrato.getCIMPUESTOS(),
			contrato.getNSPEUA(),
			contrato.getNSWIFT(),
			contrato.getNDOM(),
			contrato.getNTEFAFIRME(),
			contrato.getNTEFNOAFIRME(),
			contrato.getNNOMAFIRME(),
			contrato.getNNOMNOAFIRME(),
			contrato.getNIMPUESTOS(),
			contrato.getOUSER(),
			contrato.getODATE(),
			contrato.getGRPID(),
			contrato.getENTFAC(),
			contrato.getCUSCUN(),
			contrato.getENTITYID()
		};
		
		int totalUpdRows = 0;
		
		try {
			totalUpdRows = as400Dao.getJdbcTemplate().update(query, args);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return false;
		}
		
		if (totalUpdRows > 0)
			return true;
		
		return false;
	}

	@Override
	public boolean setPassword(String idContrato, String password, String status) {
		LOG.debug("Actualizando password de Contrato: " + idContrato + " por: " + password + " y estatus: " + status);
		
		String query = 
				"update " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME) + "EUSER " + 
				"set EUSPAS = ?, " +
				"EUSSTS = ? " +
				"where EUSUSR = ?";
		
		Object[] args = {
			password,
			status,
			idContrato
		};
		
		int totalUpdRows = 0;
		try {
			totalUpdRows = as400Dao.getJdbcTemplate().update(query, args);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return false;
		}
		
		if (totalUpdRows > 0)
			return true;
		
		return false;
	}
	
	public boolean setStatus(String idContrato, String status) {
		LOG.debug("Actualizando status de Contrato: " + idContrato + " por estatus: " + status);
		
		String query = "update " + AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME) + "EUSER " +
				"set EUSSTS = ? " +
				"where EUSUSR = ?";
		
		Object[] args = {
			status,
			idContrato
		};
		
		int totalUpdRows = 0;
		try {
			totalUpdRows = as400Dao.getJdbcTemplate().update(query, args);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return false;
		}
		
		if (totalUpdRows > 0)
			return true;
		
		return false;
	}
	
	@Override
	public JBLogin getDatosLogIn(String idContrato) throws SQLException {
		LOG.debug("Obteniendo datos del LogIn: " + idContrato);

		JBLogin login = new JBLogin();		

		Connection cnx = null;

		try {
			cnx = as400Dao.getAs400DataSource().getConnection();
			CallableStatement proc400 = null;
			proc400 = cnx
					.prepareCall("{ call "
							+ AfirmeNetConstants
									.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
							+ "ACCESOINT(?,?,?,?,?,?) }");

			 proc400.setString(1, idContrato);
	         proc400.registerOutParameter(2, java.sql.Types.VARCHAR);
	         proc400.registerOutParameter(3, java.sql.Types.VARCHAR);
	         proc400.registerOutParameter(4, java.sql.Types.VARCHAR);
	         proc400.registerOutParameter(5, java.sql.Types.VARCHAR);
	         proc400.registerOutParameter(6, java.sql.Types.VARCHAR);

			proc400.executeUpdate();
			
			login.setTipo(proc400.getString(2).trim());
			login.setPatrimonial(proc400.getString(3).trim());
			login.setPaquete(proc400.getString(4).trim());
			login.setAlias(proc400.getString(5).trim());
			login.setEstatus(proc400.getString(6).trim());
			
			proc400.close();
		} finally {
			try {
				cnx.close();
			} catch (Exception e) {
			}
		}

		return login;
	}
	
}














