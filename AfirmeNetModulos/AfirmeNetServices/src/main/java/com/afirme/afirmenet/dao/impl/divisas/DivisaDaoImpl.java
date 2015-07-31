package com.afirme.afirmenet.dao.impl.divisas;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.divisas.DivisaDao;
import com.afirme.afirmenet.dao.impl.config.ConfiguracionDaoImpl;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.transferencia.Divisa;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Service
public class DivisaDaoImpl implements DivisaDao {

	static final Logger LOG = LoggerFactory.getLogger(ConfiguracionDaoImpl.class);

	@Autowired
	private AS400Dao as400Dao;
	@Autowired
	private DB2Dao db2Dao;
	
	@Override
	public Divisa validaClaveMultimoneda(String claveTransferencia) {
		
		String sql = 
			"SELECT SICOAM, SICAMT ,SICOCY ,SICDSC, SICEXR, SICOTC, SICAMT * SICEXR AS TOTALPESOS " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "SIC001PF " +
			"WHERE SICCVE = ? " +
			"AND SICOPE = '2' " +
			"AND SICIBS = '0' " +
			"AND SICEST = '1' " +
			"AND SICOCY <> 'USD' " +
			"AND SICDSC <> '' " +
			"AND SICDAT = '" + getFechaActual() + "'";
		
		Map<String, Object> mapResult = null;
		
		try {
			mapResult = as400Dao.getJdbcTemplate().queryForMap(sql, new Object[] {claveTransferencia});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e);
			return null;
		}
		
		Divisa divisa = new Divisa();
		
		divisa.setDivisaVenta(new BigDecimal(mapResult.get("SICEXR").toString().trim()));
		divisa.setAmount(new BigDecimal(mapResult.get("SICOAM").toString().trim()));
		divisa.setMontoUSD(new BigDecimal(mapResult.get("SICAMT").toString().trim()));
		divisa.setTipoMoneda(mapResult.get("SICOCY").toString().trim());
		divisa.setDescMoneda(mapResult.get("SICDSC").toString().trim());
		divisa.setTipoCambio(new BigDecimal(mapResult.get("SICOTC").toString().trim()));
		divisa.setMontoConversion(new BigDecimal(mapResult.get("TOTALPESOS").toString().trim()));
		
		return divisa;
	}
	
	private String getFechaActual() {
		
		String sql = 
			"SELECT CURRENT_DATE AS FECHA " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "SIC001PF " +
			"WHERE SICEST = '1'";
		
		List<Date> listResult = null;
		
		try {
			listResult = as400Dao.getJdbcTemplate().queryForList(sql, Date.class);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e);
			return null;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(listResult.get(0));
	}

	@Override
	public Map<String, String> getInfoCambioMoneda(String tipoMoneda) {
		
		String sql = 
			"SELECT RATCCY, RATDSC, RATFSR, RATUSD " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "RATES " +
			"WHERE RATBNK = '01' " +
			"AND RATCCY = ? " +
			"ORDER BY RATCCY";
		
		Map<String, Object> mapResult; 
		try {
			mapResult = as400Dao.getJdbcTemplate().queryForMap(sql, new Object[] {tipoMoneda});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		String moneda = mapResult.get("RATCCY") != null ? mapResult.get("RATCCY").toString() : "";
		String descripcion = mapResult.get("RATDSC") != null ? mapResult.get("RATDSC").toString() : "";
		String tarifa = mapResult.get("RATFSR") != null ? mapResult.get("RATFSR").toString() : "";
		
		Map<String, String> mapDivisa = new HashMap<String, String>();
		mapDivisa.put("moneda", moneda);
		mapDivisa.put("descripcion", descripcion);
		mapDivisa.put("tarifa", tarifa);
		
		return mapDivisa;
	}

	@Override
	public BigDecimal getComisionSWIFT(boolean transferenciaUSD) {
		
		String comisionKey;
		
		if (transferenciaUSD)
			comisionKey = "01PAR02";
		else
			comisionKey = "01PAR03";
		
		String sql = 
			"SELECT PRFFA1 " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "CNTRLPRF " +
			"WHERE PRFKEY = ?";
		
		BigDecimal comision;
		
		try {
			comision = as400Dao.getJdbcTemplate().queryForObject(sql, new Object[] {comisionKey}, BigDecimal.class);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		return comision;
	}

	@Override
	public BigDecimal getComisionSWIFT(BigDecimal monto) {
		
		String sql = 
			"SELECT RANCOMIS " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "INRANGOPF " +
			"WHERE RANTRAN = 7562 " +
			"AND RANGOCCY = 'USD' " +
			"AND RANGOINI <= ? " +
			"AND RANGOFIN >= ?";
		
		BigDecimal result; 
		
		try {
			result = as400Dao.getJdbcTemplate().queryForObject(sql, new Object[] {monto, monto}, BigDecimal.class);
		} catch (EmptyResultDataAccessException e) {
			LOG.debug("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		return result;
	}

	@Override
	public List<Divisa> getListaCuentasSWIFT(String idContrato, boolean intermediario) {
		
		String sql = 
			"SELECT ACCNUM, TIPOSWIFT, SWIFTCODE, BNKNAME, BNKCIUDAD, BNKESTADO, BNKPAIS, BNKAREA, PLAZA, INTER, DIRBENE " +
			"FROM DC_ACCSWIFTUSER " +
			"WHERE USERID = ? " +
			"AND SWIFTCODE <> 'AFIRMXMTXXX' ";
		
		if (intermediario)
			sql += "AND INTER = '1' ";
		else
			sql += "AND (INTER IS NULL OR INTER = '0') ";
		
		sql += "ORDER BY TIPOSWIFT, ACCNUM";
		
		List<Map<String, Object>> listResultado;
		
		try {
			listResultado = db2Dao.getJdbcTemplate().queryForList(sql, new Object[] {idContrato});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		List<Divisa> listDivisa = new ArrayList<Divisa>();
		
		for (Map<String, Object> map : listResultado) {
			Divisa divisa = new Divisa();
			
			divisa.setDebitAccount(idContrato);
			divisa.setCreditAccount(map.get("ACCNUM") != null ? map.get("ACCNUM").toString().trim() : null);
			String tipoCodigo = map.get("TIPOSWIFT") != null ? map.get("TIPOSWIFT").toString().trim() : null;
			
			if (tipoCodigo.equals("F"))
				divisa.setCodigoABA(map.get("SWIFTCODE") != null ? map.get("SWIFTCODE").toString().trim() : null);
			else
				divisa.setCodigoSWIFT(map.get("SWIFTCODE") != null ? map.get("SWIFTCODE").toString().trim() : null);
			
			divisa.setBankName(map.get("BNKNAME") != null ? map.get("BNKNAME").toString().trim() : null);
			divisa.setPlazaReceiving(map.get("PLAZA") != null ? map.get("PLAZA").toString().trim() : null);
			divisa.setBankCiudad(map.get("BNKCIUDAD") != null ? map.get("BNKCIUDAD").toString().trim() : null);
			divisa.setBankEstado(map.get("BNKESTADO") != null ? map.get("BNKESTADO").toString().trim() : null);
			divisa.setBankPais(map.get("BNKPAIS") != null ? map.get("BNKPAIS").toString().trim() : null);
			divisa.setBankArea(map.get("BNKAREA") != null ? map.get("BNKAREA").toString().trim() : null);
			divisa.setBankDireccion(map.get("DIRBENE") != null ? map.get("DIRBENE").toString().trim() : null);
			
			listDivisa.add(divisa);
		}
		
		return listDivisa;
	}

	@Override
	public Divisa getCuentaSWIFT(String idUsuario, String idContratoSWIFT, boolean intermediario) {
		
		String sql = 
			"SELECT ACCNUM, TIPOSWIFT, SWIFTCODE, BNKNAME, BNKCIUDAD, BNKESTADO, BNKPAIS, BNKAREA, PLAZA, INTER, DIRBENE " +
			"FROM DC_ACCSWIFTUSER " +
			"WHERE USERID = ? " +
			"AND ACCNUM = ? " + 
			"AND SWIFTCODE <> 'AFIRMXMTXXX' ";
		
		if (intermediario)
			sql += "AND INTER = '1' ";
		else
			sql += "AND (INTER IS NULL OR INTER = '0') ";
		
		sql += "ORDER BY TIPOSWIFT, ACCNUM";
		
		Map<String, Object> mapResult;
		
		try {
			mapResult = db2Dao.getJdbcTemplate().queryForMap(sql, new Object[] {idUsuario, idContratoSWIFT});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		Divisa divisa = new Divisa();
		
		divisa.setDebitAccount(idUsuario);
		divisa.setCreditAccount(mapResult.get("ACCNUM") != null ? mapResult.get("ACCNUM").toString().trim() : null);
		divisa.setTipoCodigo(mapResult.get("TIPOSWIFT") != null ? mapResult.get("TIPOSWIFT").toString().trim() : null);
		
		if (divisa.getTipoCodigo().equals("F"))
			divisa.setCodigoABA(mapResult.get("SWIFTCODE") != null ? mapResult.get("SWIFTCODE").toString().trim() : null);
		else
			divisa.setCodigoSWIFT(mapResult.get("SWIFTCODE") != null ? mapResult.get("SWIFTCODE").toString().trim() : null);
		
		divisa.setBankName(mapResult.get("BNKNAME") != null ? mapResult.get("BNKNAME").toString().trim() : null);
		divisa.setPlazaReceiving(mapResult.get("PLAZA") != null ? mapResult.get("PLAZA").toString().trim() : null);
		divisa.setBankCiudad(mapResult.get("BNKCIUDAD") != null ? mapResult.get("BNKCIUDAD").toString().trim() : null);
		divisa.setBankEstado(mapResult.get("BNKESTADO") != null ? mapResult.get("BNKESTADO").toString().trim() : null);
		divisa.setBankPais(mapResult.get("BNKPAIS") != null ? mapResult.get("BNKPAIS").toString().trim() : null);
		divisa.setBankArea(mapResult.get("BNKAREA") != null ? mapResult.get("BNKAREA").toString().trim() : null);
		divisa.setBankDireccion(mapResult.get("DIRBENE") != null ? mapResult.get("DIRBENE").toString().trim() : null);
		
		return divisa;
	}

	@Override
	public boolean guardaTransferenciaExitosa(Divisa divisa, String afirmeNetReference) {
		
		String sql = "INSERT INTO DC_SWIFTTRANS (" +
			"CONFNUM, DEBACC, CLAVE, AMOUNT, EXRATE, CCY, BENENAME, DESCRIP1, DESCRIP2, CREACC, BY_CODE, SWIFTACC_INTER, " +
			"SWIFTCOD_INTER, SWIFTNOM_INTER, SWIFTFULL_INTER, SWIFTNUM, SWIFTNOM, SWIFTFULL, INSTRUCCIONES1, INSTRUCCIONES2, " +
			"EMAIL, OUSER, VUSER, AUSER, ODATE, VDATE, ADATE, ES_SWIFT_DIVISAS, ENTITYID, USERID, DCIBS_REF, PMM, PDD, PYY, " +
			"PHH, PSS, CCYCONV, CCY_DSC, CONVERSION, MONTOUSD, EXRUSD, STATUS, FEESORI, FEE_IVAORI, FEESCON, FEE_IVACON) " +
			"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		List<Object> argsList = new ArrayList<Object>();
		
		argsList.add(afirmeNetReference);
		argsList.add(divisa.getOrigen().getNumber());
		argsList.add(divisa.getClaveTransferencia() != null ? divisa.getClaveTransferencia() : "");
		
		// Si es Transferencia Dolares se usa el campo Amount
		if (StringUtils.isEmpty(divisa.getClaveTransferencia()))
			argsList.add(divisa.getAmount());
		else
			argsList.add(divisa.getMontoUSD());
		
		// Si es Transferencia Dolares se usa el campo DivisaVenta
		if (StringUtils.isEmpty(divisa.getClaveTransferencia()))
			argsList.add(divisa.getDivisaVenta());
		else
			argsList.add(divisa.getTipoCambio());
		
		argsList.add(divisa.getTipoMoneda());
		argsList.add(divisa.getBeneficiaryName());
		argsList.add(""); //desc1
		argsList.add(""); //desc2
		argsList.add(divisa.getDestino().getNumber());
		argsList.add(divisa.getTipoCodigo());
		argsList.add(divisa.getIntermediarioCuenta() != null ? divisa.getIntermediarioCuenta() : "");
		argsList.add(divisa.getIntermediarioCodigo() != null ? divisa.getIntermediarioCodigo() : "");
		argsList.add(divisa.getIntermediarioNombre() != null ? divisa.getIntermediarioNombre() : "");
		argsList.add(divisa.getIntermediarioPlaza() != null ? divisa.getIntermediarioPlaza() : "");
		
		if (!StringUtils.isEmpty(divisa.getCodigoSWIFT()))
			argsList.add(divisa.getCodigoSWIFT());
		else if (!StringUtils.isEmpty(divisa.getCodigoABA()))
			argsList.add(divisa.getCodigoABA());
		
		argsList.add(divisa.getBankName());
		argsList.add(divisa.getBankArea()); // plazaReceiving
		argsList.add(divisa.getNarrative());
		argsList.add(""); // instruccionesA
		argsList.add(divisa.getEmail());
		argsList.add(divisa.getOperatorUser());
		argsList.add(divisa.getValidatorUser());
		argsList.add(divisa.getAuthorizationUser());
		argsList.add(divisa.getOperationDate());
		argsList.add(divisa.getValidationDate());
		argsList.add(divisa.getAuthorizationDate());
		argsList.add(1);
		argsList.add(divisa.getContractId());
		argsList.add(divisa.getUserId());
		argsList.add(Util.getRefNum());
		argsList.add(divisa.getProgrammingMonth());
		argsList.add(divisa.getProgrammingDay());
		argsList.add(divisa.getProgrammingYear());
		argsList.add(divisa.getProgrammingHour());
		argsList.add(divisa.getProgrammingMinute());
		argsList.add(divisa.getOrigen().getCcy());
		argsList.add(divisa.getDescMoneda());
		argsList.add(divisa.getMontoConversion());
		argsList.add(divisa.getAmount());
		argsList.add(divisa.getDivisaVenta());
		argsList.add("1"); // status
		argsList.add(divisa.getCommision());
		argsList.add(divisa.getTaxCommision());
		argsList.add(divisa.getCommisionConversion());
		argsList.add(divisa.getTaxCommisionConversion());
		
		int result = 0;
		try {
			result = db2Dao.getJdbcTemplate().update(sql, argsList.toArray());
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return false;
		}
		
		if (result > 0)
			return true;
		
		return false;
	}

}
