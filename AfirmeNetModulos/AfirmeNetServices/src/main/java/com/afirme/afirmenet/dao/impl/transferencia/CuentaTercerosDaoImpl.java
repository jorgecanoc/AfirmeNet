package com.afirme.afirmenet.dao.impl.transferencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.transferencia.CuentaTercerosDao;
import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;

@Repository
public class CuentaTercerosDaoImpl implements CuentaTercerosDao {

	static final Logger LOG = LoggerFactory.getLogger(CuentaTercerosDaoImpl.class);
	
	@Autowired
	DB2Dao db2Dao;
	
	private final String FECHA_CREACION = "20070301000000";
	
	@Override
	public List<ACCTHIRDUSER> getListaTerceros(String idContrato, String tipoContrato, String idUsuario, String tiempoEsperaCuentas) {
		LOG.info("Obteniendo cuentas de Terceros de: " + idContrato + ", tipo de Contrato: " + tipoContrato + ", idUsuario: " +
				"" + idUsuario + ", tiempoEsperaCuentas: " + tiempoEsperaCuentas);
		
		String sql = "";
		List<Object> args = new ArrayList<Object>();
		
		if (tipoContrato.equals("03")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.TRANSTYPE = '03' " +
				"AND STS = 'A' " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
		}
		// idUsuario
		if (tipoContrato.equals("10")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRDUSER A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.USERID = ? " +
				"ANDA.TRANSTYPE = '10' " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(idUsuario);
		}
		// idUsuario
		if (tipoContrato.equals("04")) {
			sql =
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRDUSER A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE AND A.ENTITYID = ? " +
				"AND A.USERID = ? " +
				"AND A.TRANSTYPE = '04' " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(idUsuario);
		}
		if (tipoContrato.equals("05")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND (A.TRANSTYPE = '09' " +
				"OR A.TRANSTYPE = '05') " +
				"AND A.STS = 'A' " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
		}
		// Para Domiciliacion
		if (tipoContrato.equals("06")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND (A.TRANSTYPE = '03' " +
				"OR A.TRANSTYPE = '05' " +
				"OR A.TRANSTYPE = '09') " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
		}
		if (tipoContrato.equals("09")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND (A.TRANSTYPE = '09' " +
				"OR A.TRANSTYPE = '05') " +
				"AND A.STS = 'A' " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
		}
		// idUsuario
		if (tipoContrato.equals("39")) {
			sql =
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRDUSER A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.USERID = ? " +
				"AND (A.TRANSTYPE = '03' " +
				"OR A.TRANSTYPE = '09') " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(idUsuario);
		}
		
		List<Map<String, Object>> usrList = new ArrayList<Map<String, Object>>();
		
		try {
			usrList = db2Dao.getJdbcTemplate().queryForList(sql, args.toArray());
		} catch (EmptyResultDataAccessException e) {
			LOG.debug("Resultado del query vacio. " + e.getMessage());
			return null;
		}
		
		if (usrList != null) {
			
			GregorianCalendar fechaValidacion = new GregorianCalendar();
			fechaValidacion.add(Calendar.SECOND, 1 + Integer.parseInt(tiempoEsperaCuentas) * -1);
			
			Set<ACCTHIRDUSER> setAccThirdUser = null;
			
			setAccThirdUser = new HashSet<ACCTHIRDUSER>();
			// al convertir la Lista a Set se remueven los duplicados
			Set<Map<String, Object>> usrSet = new HashSet<Map<String, Object>>(usrList);
			
			for (Map<String, Object> map : usrSet) {
				
				ACCTHIRDUSER accThird = new ACCTHIRDUSER();
				
				accThird.setENTITYID(map.get("ENTITYID") != null ? map.get("ENTITYID").toString() : null);
				accThird.setACCNUM(map.get("ACCNUM") != null ? map.get("ACCNUM").toString() : null);
				accThird.setACCTYPE(map.get("ACCTYPE") != null ? map.get("ACCTYPE").toString() : null);
				accThird.setACCOWNER(map.get("ACCOWNER") != null ? map.get("ACCOWNER").toString() : null);
				accThird.setNICKNAME(map.get("NICKNAME") != null ? map.get("NICKNAME").toString() : null);
				accThird.setSTS(map.get("STS") != null ? map.get("STS").toString() : null);
				accThird.setTRANSTYPE(map.get("TRANSTYPE") != null ? map.get("TRANSTYPE").toString() : null);
				accThird.setTRANSDESC(map.get("TRANSDESC") != null ? map.get("TRANSDESC").toString() : null);
				accThird.setBNKCODE(map.get("BNKCODE") != null ? map.get("BNKCODE").toString() : null);
				accThird.setBNKNAME(map.get("BNKNAME") != null ? map.get("BNKNAME").toString() : null);
				accThird.setCURRENCY(map.get("CURRENCY") != null ? map.get("CURRENCY").toString() : null);
				
				//String fechaCreacion = map.get("FECHACREACION").toString();
				String fechaCreacion = (String)map.get("FECHACREACION");
				
				if (fechaCreacion == null)
					fechaCreacion = FECHA_CREACION;
				
				GregorianCalendar fechaCreac=new GregorianCalendar();
				fechaCreac.set(Integer.parseInt(fechaCreacion.substring(0,4)),Integer.parseInt(fechaCreacion.substring(4,6))-1,Integer.parseInt(fechaCreacion.substring(6,8)),Integer.parseInt(fechaCreacion.substring(8,10)),Integer.parseInt(fechaCreacion.substring(10,12)),Integer.parseInt(fechaCreacion.substring(12,14)));
				
				fechaCreac.add(Calendar.SECOND,1);
				
				if (fechaCreac.before(fechaValidacion)) {
					//LOG.debug(accThird.getACCNUM());
					setAccThirdUser.add(accThird);
				}
			}
			
			List<ACCTHIRDUSER> listAccThirdUser = new ArrayList<ACCTHIRDUSER>(setAccThirdUser);
			return listAccThirdUser;
		}
		
		return null;
	}
	/*
	@Override
	public List<ACCTHIRD> getListaTercerosDeCuenta(String idContrato, String tipoContrato, String flag) {

		String sqlSelect = "";
		String sqlFrom = "";
		String sqlWhere = "";
		String sqlOrder = "";
		
		if (flag.equals("A")) {
			
			sqlSelect = 
				"SELECT A.RECNUM, A.ACCTYPE, A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.NICKNAME, A.STS, " +
				"A.TRANSTYPE, B.TRANSDESC, A.FECHACREACION, A.CURRENCY ";
			sqlFrom = 
				"FROM DC_ACCTHIRD A, DC_PROCODE B ";
			sqlWhere = 
				"WHERE A.TRANSTYPE = B.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.STS = 'A' ";
			
			if (tipoContrato.equals("1")) {
				sqlSelect += 
					", A.BNKCODE, A.BNKNAME ";
				sqlWhere +=
					"AND (A.TRANSTYPE = '03' " +
					"OR A.TRANSTYPE = '09') ";
				sqlOrder =
					"ORDER BY A.BNKNAME, A.ACCNUM";
			}
			if (tipoContrato.equals("2")) {
				sqlWhere += 
					"AND A.TRANSTYPE = '10' ";
				sqlOrder = 
					"ORDER BY A.TRANSTYPE, A.BNKCODE";
			}
			if (tipoContrato.equals("3")) {
				sqlWhere += 
					"AND A.TRANSTYPE = '04' ";
				sqlOrder = 
					"ORDER BY A.TRANSTYPE, A.BNKCODE";
			}
		}
		
		if (flag.equals("P")) {
			
			sqlSelect = 
				"SELECT A.RECNUM, A.ACCTYPE, A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.NICKNAME, A.STS, " +
				"A.TRANSTYPE, B.TRANSDESC, A.FECHACREACION, A.CURRENCY ";
			sqlFrom = 
				"FROM DC_ACCTHIRD A, DC_PROCODE B ";
			sqlWhere = 
				"WHERE A.TRANSTYPE = B.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.STS = 'P' ";
			
			if (tipoContrato.equals("1")) {
				sqlSelect += 
					", A.BNKCODE, A.BNKNAME ";
				sqlWhere +=
					"AND (A.TRANSTYPE = '03' " +
					"OR A.TRANSTYPE = '09') ";
				sqlOrder = 
					"ORDER BY A.BNKNAME, A.ACCNUM";
			}
			if (idContrato.equals("2")) {
				sqlWhere +=
					"AND A.TRANSTYPE = '10' ";
				sqlOrder = 
					"ORDER BY A.TRANSTYPE, A.BNKCODE";
			}
			if (idContrato.equals("3")) {
				sqlWhere +=
					"AND A.TRANSTYPE = '04' ";
				sqlOrder = 
					"ORDER BY A.TRANSTYPE, A.BNKCODE";
			}
		}
		if (flag.equals("")) {
			
			sqlSelect = 
				"SELECT A.RECNUM, A.ACCTYPE, A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.NICKNAME, A.STS, " +
				"A.TRANSTYPE, B.TRANSDESC, A.FECHACREACION, A.CURRENCY ";
			sqlFrom = 
				"FROM DC_ACCTHIRD A, DC_PROCODE B ";
			sqlWhere = 
				"WHERE A.TRANSTYPE = B.TRANSTYPE " +
				"AND A.ENTITYID = ? ";
			
			if (tipoContrato.equals("1")) {
				sqlSelect +=
					", A.BNKCODE, A.BNKNAME ";
				sqlWhere +=
					"AND (A.TRANSTYPE = '03' " +
					"OR A.TRANSTYPE = '05' " +
					"OR A.TRANSTYPE = '09' " +
					"OR A.TRANSTYPE = '37') ";
				sqlOrder =
					"ORDER BY A.BNKNAME, A.ACCNUM";
			}
			if (tipoContrato.equals("2")) {
				sqlWhere +=
					"AND A.TRANSTYPE = '10' ";
				sqlOrder =
					"ORDER BY A.TRANSTYPE, A.BNKCODE";
			}
			if (tipoContrato.equals("3")) {
				sqlWhere += 
					"AND A.TRANSTYPE = '04' ";
				sqlOrder = 
					"ORDER BY A.TRANSTYPE, A.BNKCODE";
			}
			if (tipoContrato.equals("4")) {
				sqlSelect +=
					", A.BNKCODE, A.BNKNAME ";
				sqlWhere +=
					"AND A.TRANSTYPE = '03'";
				sqlOrder = 
					"ORDER BY A.BNKNAME, A.ACCNUM";
			}
			if (tipoContrato.equals("9")) {
				sqlSelect +=
					", A.BNKCODE, A.BNKNAME ";
				sqlWhere +=
					"AND A.TRANSTYPE = '09'";
				sqlOrder =
					"ORDER BY A.BNKNAME, A.ACCNUM";
			}
			if (tipoContrato.equals("5")) {
				sqlSelect +=
					", A.BNKCODE, A.BNKNAME";
				sqlWhere +=
					"AND A.TRANSTYPE = '05'";
				sqlOrder =
					"ORDER BY A.BNKNAME, A.ACCNUM";
			}
		}

		String sql = sqlSelect + sqlFrom + sqlWhere + sqlOrder;
		
		List<Map<String, Object>> listTerceros;
		
		try {
			listTerceros =  db2Dao.getJdbcTemplate().queryForList(sql, new Object[] {idContrato});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		List<ACCTHIRD> listCuentaTerceros = new ArrayList<ACCTHIRD>(); 
		
		for (Map<String, Object> map : listTerceros) {
			
			ACCTHIRD accThird = new ACCTHIRD();
			
			accThird.setENTITYID(map.get("ENTITYID") != null ? map.get("ENTITYID").toString(): null);
			accThird.setACCNUM(map.get("ACCNUM") != null ? map.get("ACCNUM").toString() : null);
			accThird.setACCOWNER(map.get("ACCOWNER") != null ? map.get("ACCOWNER").toString() : null);
			accThird.setNICKNAME(map.get("NICKNAME") != null ? map.get("NICKNAME").toString() : null);
			accThird.setSTS(map.get("STS") != null ? map.get("STS").toString() : null);
			accThird.setTRANSTYPE(map.get("TRANSTYPE") != null ? map.get("TRANSTYPE").toString() : null);
			accThird.setTRANSDESC(map.get("TRANSDESC") != null ? map.get("TRANSDESC").toString() : null);
			accThird.setBNKCODE(map.get("BNKCODE") != null ? map.get("BNKCODE").toString() : null);
			accThird.setBNKNAME(map.get("BNKNAME") != null ? map.get("BNKNAME").toString() : null);
			accThird.setACCTYPE(map.get("ACCTYPE") != null ? map.get("ACCTYPE").toString() : null);
			accThird.setRECNUM(map.get("RECNUM") != null ? (BigDecimal) map.get("RECNUM") : null);
			accThird.setFechaCreacion(map.get("FECHACREACION") != null ? map.get("FECHACREACION").toString() : null);
			accThird.setCURRENCY(map.get("CURRENCY") != null ? map.get("CURRENCY").toString() : "");
			
			LOG.debug(accThird.getACCNUM());
			listCuentaTerceros.add(accThird);
		}
		
		return listCuentaTerceros;
	}
	*/

	@Override
	public ACCTHIRDUSER getCuentaTercero(String idContrato, String cuentaTercero, String tipoContrato, String idUsuario, String tiempoEsperaCuentas) {
		LOG.info("Obteniendo cuentas de Terceros: " + cuentaTercero + ", del Contrato: " + idContrato + "tipo de Contrato: " + tipoContrato + ", idUsuario: " +
				"" + idUsuario + ", tiempoEsperaCuentas: " + tiempoEsperaCuentas);
		
		String sql = "";
		List<Object> args = new ArrayList<Object>();
		
		if (tipoContrato.equals("03")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.TRANSTYPE = '03' " +
				"AND STS = 'A' " +
				"AND A.ACCNUM = ? " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(cuentaTercero);
		}
		// idUsuario
		if (tipoContrato.equals("10")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRDUSER A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.USERID = ? " +
				"ANDA.TRANSTYPE = '10' " +
				"AND A.ACCNUM = ? " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(idUsuario);
			args.add(cuentaTercero);
		}
		// idUsuario
		if (tipoContrato.equals("04")) {
			sql =
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRDUSER A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE AND A.ENTITYID = ? " +
				"AND A.USERID = ? " +
				"AND A.TRANSTYPE = '04' " +
				"AND A.ACCNUM = ? " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(idUsuario);
			args.add(cuentaTercero);
		}
		if (tipoContrato.equals("05")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND (A.TRANSTYPE = '09' " +
				"OR A.TRANSTYPE = '05') " +
				"AND A.STS = 'A' " +
				"AND A.ACCNUM = ? " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(cuentaTercero);
		}
		// Para Domiciliacion
		if (tipoContrato.equals("06")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND (A.TRANSTYPE = '03' " +
				"OR A.TRANSTYPE = '05' " +
				"OR A.TRANSTYPE = '09') " +
				"AND A.ACCNUM = ? " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(cuentaTercero);
		}
		if (tipoContrato.equals("09")) {
			sql = 
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRD A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND (A.TRANSTYPE = '09' " +
				"OR A.TRANSTYPE = '05') " +
				"AND A.STS = 'A' " +
				"AND A.ACCNUM = ? " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(cuentaTercero);
		}
		// idUsuario
		if (tipoContrato.equals("39")) {
			sql =
				"SELECT A.ENTITYID, A.ACCNUM, A.ACCOWNER, A.ACCTYPE, A.TRANSTYPE, A.NICKNAME, A.STS, " +
				"A.BNKCODE, A.BNKNAME, B.TRANSDESC, A.FECHACREACION, A.CURRENCY " +
				"FROM DC_ACCTHIRDUSER A, DC_PROCODE B " +
				"WHERE B.TRANSTYPE = A.TRANSTYPE " +
				"AND A.ENTITYID = ? " +
				"AND A.USERID = ? " +
				"AND (A.TRANSTYPE = '03' " +
				"OR A.TRANSTYPE = '09') " +
				"AND A.ACCNUM = ? " +
				"ORDER BY A.BNKNAME, A.ACCNUM";
			
			args.add(idContrato);
			args.add(idUsuario);
			args.add(cuentaTercero);
		}
		
		Map<String, Object> usrMap = new HashMap<String, Object>();
		
		try {
			usrMap = db2Dao.getJdbcTemplate().queryForMap(sql, args.toArray());
		} catch (EmptyResultDataAccessException e) {
			LOG.debug("Resultado del query vacio. " + e.getMessage());
			return null;
		}
		
		if (usrMap != null) {
			
			GregorianCalendar fechaValidacion = new GregorianCalendar();
			fechaValidacion.add(Calendar.SECOND, 1 + Integer.parseInt(tiempoEsperaCuentas) * -1);
			
			ACCTHIRDUSER accThird = new ACCTHIRDUSER();
			
			accThird.setENTITYID(usrMap.get("ENTITYID") != null ? usrMap.get("ENTITYID").toString() : null);
			accThird.setACCNUM(usrMap.get("ACCNUM") != null ? usrMap.get("ACCNUM").toString() : null);
			accThird.setACCTYPE(usrMap.get("ACCTYPE") != null ? usrMap.get("ACCTYPE").toString() : null);
			accThird.setACCOWNER(usrMap.get("ACCOWNER") != null ? usrMap.get("ACCOWNER").toString() : null);
			accThird.setNICKNAME(usrMap.get("NICKNAME") != null ? usrMap.get("NICKNAME").toString() : null);
			accThird.setSTS(usrMap.get("STS") != null ? usrMap.get("STS").toString() : null);
			accThird.setTRANSTYPE(usrMap.get("TRANSTYPE") != null ? usrMap.get("TRANSTYPE").toString() : null);
			accThird.setTRANSDESC(usrMap.get("TRANSDESC") != null ? usrMap.get("TRANSDESC").toString() : null);
			accThird.setBNKCODE(usrMap.get("BNKCODE") != null ? usrMap.get("BNKCODE").toString() : null);
			accThird.setBNKNAME(usrMap.get("BNKNAME") != null ? usrMap.get("BNKNAME").toString() : null);
			accThird.setCURRENCY(usrMap.get("CURRENCY") != null ? usrMap.get("CURRENCY").toString() : null);
			
			String fechaCreacion = usrMap.get("FECHACREACION").toString();
			
			if (fechaCreacion == null)
				fechaCreacion = FECHA_CREACION;
			
			GregorianCalendar fechaCreac=new GregorianCalendar();
			fechaCreac.set(Integer.parseInt(fechaCreacion.substring(0,4)),Integer.parseInt(fechaCreacion.substring(4,6))-1,Integer.parseInt(fechaCreacion.substring(6,8)),Integer.parseInt(fechaCreacion.substring(8,10)),Integer.parseInt(fechaCreacion.substring(10,12)),Integer.parseInt(fechaCreacion.substring(12,14)));
			
			fechaCreac.add(Calendar.SECOND,1);
			
			if (fechaCreac.before(fechaValidacion)) {
				LOG.debug(accThird.getACCNUM());
				return accThird;
			}
		}
		
		return null;
	}

}


