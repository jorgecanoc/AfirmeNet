package com.afirme.afirmenet.dao.impl.transferencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.transferencia.TransferenciaDao;
import com.afirme.afirmenet.ibs.databeans.GRPUSR;
import com.afirme.afirmenet.model.transferencia.DomingoElectronico;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;

@Repository
public class TransferenciaDaoImpl implements TransferenciaDao {

	static final Logger LOG = LoggerFactory
			.getLogger(TransferenciaDaoImpl.class);

	@Autowired
	private AS400Dao as400Dao;
	@Autowired
	private DB2Dao db2Dao;

	@Override
	public GRPUSR getGroupCosts(String idGrupo, String tipoRegimen) {
		LOG.debug("Obtención de Costos del Paquete: " + idGrupo + ", Régimen: "
				+ tipoRegimen);

		String comisionAnual, comisionMensual = "";

		// dependiendo del tipo de regimen fiscal del usuario, se seleccionan
		// las tarifas de distintos campos de la tabla.
		if (tipoRegimen.equals("1")) {
			// personaMoral
			comisionAnual = "EUSANUALPM";
			comisionMensual = "EUSMENSPM";
		} else {
			comisionAnual = "EUSANUALPF";
			comisionMensual = "EUSMENSPF";
		}

		String sql = "SELECT GRPUID, GRPLGT, GRPDSC, EUSANUCL, EUSMENCL, EUSSPECL, EUSSWFCL, EUSDOMCL, "
				+ "EUSTYACL, EUSTNACL, EUSNYACL, EUSNNACL, EUSIMPCL, "
				+ ""
				+ comisionAnual
				+ ", "
				+ comisionMensual
				+ ", EUSSPE, EUSSWF, EUSDOM, EUSTYA, "
				+ "EUSTNA, EUSNYA, EUSNNA, EUSIMP, EUSTXP "
				+ "FROM "
				+ AfirmeNetConstants.AS400_LIBRARY
				+ "GRPUSR "
				+ "WHERE GRPUID = ?";

		Map<String, Object> mapResult;
		try {
			mapResult = as400Dao.getJdbcTemplate().queryForMap(sql,
					new Object[] { idGrupo });
		} catch (EmptyResultDataAccessException e) {
			LOG.debug("Resultado vacio: " + e.getMessage());
			return null;
		}

		GRPUSR grpUsr = new GRPUSR();

		if (mapResult.size() > 0) {
			grpUsr.setGRPUID(mapResult.get("GRPUID") != null ? mapResult
					.get("GRPUID").toString().trim() : null);
			grpUsr.setGRPLGT(mapResult.get("GRPLGT") != null ? mapResult
					.get("GRPLGT").toString().trim() : null);
			grpUsr.setGRPDSC(mapResult.get("GRPDSC") != null ? mapResult
					.get("GRPDSC").toString().trim() : null);
			grpUsr.setEUSANUCL(mapResult.get("EUSANUCL") != null ? (BigDecimal) mapResult
					.get("EUSANUCL") : null);
			grpUsr.setEUSMENCL(mapResult.get("EUSMENCL") != null ? (BigDecimal) mapResult
					.get("EUSMENCL") : null);
			grpUsr.setEUSSPECL(mapResult.get("EUSSPECL") != null ? (BigDecimal) mapResult
					.get("EUSSPECL") : null);
			grpUsr.setEUSSWFCL(mapResult.get("EUSSWFCL") != null ? (BigDecimal) mapResult
					.get("EUSSWFCL") : null);
			grpUsr.setEUSDOMCL(mapResult.get("EUSDOMCL") != null ? (BigDecimal) mapResult
					.get("EUSDOMCL") : null);
			grpUsr.setEUSTYACL(mapResult.get("EUSTYACL") != null ? (BigDecimal) mapResult
					.get("EUSTYACL") : null);
			grpUsr.setEUSTNACL(mapResult.get("EUSTNACL") != null ? (BigDecimal) mapResult
					.get("EUSTNACL") : null);
			grpUsr.setEUSNYACL(mapResult.get("EUSNYACL") != null ? (BigDecimal) mapResult
					.get("EUSNYACL") : null);
			grpUsr.setEUSNNACL(mapResult.get("EUSNNACL") != null ? (BigDecimal) mapResult
					.get("EUSNNACL") : null);
			grpUsr.setEUSIMPCL(mapResult.get("EUSIMPCL") != null ? (BigDecimal) mapResult
					.get("EUSIMPCL") : null);
			grpUsr.setEUSANU(mapResult.get(comisionAnual) != null ? (BigDecimal) mapResult
					.get(comisionAnual) : null);
			grpUsr.setEUSMEN(mapResult.get(comisionMensual) != null ? (BigDecimal) mapResult
					.get(comisionMensual) : null);
			grpUsr.setEUSSPE(mapResult.get("EUSSPE") != null ? (BigDecimal) mapResult
					.get("EUSSPE") : null);
			grpUsr.setEUSSWF(mapResult.get("EUSSWF") != null ? (BigDecimal) mapResult
					.get("EUSSWF") : null);
			grpUsr.setEUSDOM(mapResult.get("EUSDOM") != null ? (BigDecimal) mapResult
					.get("EUSDOM") : null);
			grpUsr.setEUSTYA(mapResult.get("EUSTYA") != null ? (BigDecimal) mapResult
					.get("EUSTYA") : null);
			grpUsr.setEUSTNA(mapResult.get("EUSTNA") != null ? (BigDecimal) mapResult
					.get("EUSTNA") : null);
			grpUsr.setEUSNYA(mapResult.get("EUSNYA") != null ? (BigDecimal) mapResult
					.get("EUSNYA") : null);
			grpUsr.setEUSNNA(mapResult.get("EUSNNA") != null ? (BigDecimal) mapResult
					.get("EUSNNA") : null);
			grpUsr.setEUSIMP(mapResult.get("EUSIMP") != null ? (BigDecimal) mapResult
					.get("EUSIMP") : null);
			grpUsr.setEUSTXP(mapResult.get("EUSTXP") != null ? (BigDecimal) mapResult
					.get("EUSTXP") : null);

			return grpUsr;
		}

		return null;
	}

	public void actualizaRegistroPagoConcentrado(
			DomingoElectronico domingoElectronico) {
		String sql = "update dc_progconcen set lote = ? where id = ?";
		db2Dao.getJdbcTemplate().update(
				sql,
				new Object[] { domingoElectronico.getReferenceNumber(),
						domingoElectronico.getId() });
	}
	@Override
	public void generaRegistroPagoConcentrado(
			DomingoElectronico domingoElectronico) {
		// Se incializan variables;
		String day1_hh = null, day1_ss = null, day2_hh = null, day2_ss = null, day3_hh = null, day3_ss = null, day4_hh = null, day4_ss = null, day5_hh = null, day5_ss = null, day6_hh = null, day6_ss = null, day7_hh = null, day7_ss = null, monthly_hh = null, monthly_ss = null;
		Integer monthly_day = null;
		String diaHabilDespuesDeFechaProgramada = "1";

		Date fechaFinProgramacion = TimeUtils.getDate(
				domingoElectronico.getFinProgramacion() + " "
						+ domingoElectronico.getHoraProgramacion(),
				"dd/MMMM/yyyy HH:mm");

		DateTime fechaFinal = new DateTime(fechaFinProgramacion);

		// Se obtiene el maximo para que sea el nuevo ID
		String sql = "select max(id) from dc_progconcen";
		Integer newId = db2Dao.getJdbcTemplate().queryForObject(sql,
				Integer.class);

		// Se incrementa en 1 el valor obtenido
		newId++;
		domingoElectronico.setId(newId);
		// Se inserta la programacion
		// 1 diaria o semanal
		// 0 mensual

		Integer tipoProgramacion = 0;
		if (domingoElectronico.getProgramacion().equals("SEMANAL")) {
			tipoProgramacion = 1;
			// Por default se define el domingo como el dia de dispersion
			day7_hh = domingoElectronico.getValidationHour();
			day7_ss = domingoElectronico.getValidationMinute();
		} else if (domingoElectronico.getProgramacion().equals("DIARIA")) {
			// Se marcan los dias de dispersion
		} else {
			// Se setea la informacion de dispersion
			monthly_hh = TimeUtils.getDateFormat(fechaFinal.toDate(), "HH");
			monthly_ss = TimeUtils.getDateFormat(fechaFinal.toDate(), "mm");
			monthly_day = Integer.valueOf(TimeUtils.getDateFormat(
					fechaFinal.toDate(), "dd"));

		}

		sql = "insert into dc_progconcen(id, lote, entityid, acc, desc, tipo_prog,day1_hh,day1_ss, day2_hh, day2_ss, " +
				"day3_hh, day3_ss, day4_hh, day4_ss, day5_hh,day5_ss, day6_hh, day6_ss, day7_hh, day7_ss, " +
				"ini_dd, ini_mm, ini_yy, fin_dd,fin_mm, fin_yy, monthly_hh, monthly_ss, monthly_day, antes_habil, " +
				"creacc, amount, transtype, ouser ,odate, vuser, vdate, auser, adate, tipocuenta) values "
				+ "(?,?,?,?,?,?,?,?,?,?," +
				   "?,?,?,?,?,?,?,?,?,?," +
				   "?,?,?,?,?,?,?,?,?,?," +
				   "?,?,?,?,?,?,?,?,?,?)";

		db2Dao.getJdbcTemplate().update(
				sql,
				new Object[] {
						newId,
						domingoElectronico.getReferenceNumber(),
						domingoElectronico.getContractId(),
						domingoElectronico.getDestino().getNumber(),
						domingoElectronico.getDescription(),
						tipoProgramacion,
						day1_hh,
						day1_ss,
						day2_hh,
						day2_ss,
						day3_hh,
						day3_ss,
						day4_hh,
						day4_ss,
						day5_hh,
						day5_ss,
						day6_hh,
						day6_ss,
						day7_hh,
						day7_ss,
						domingoElectronico.getValidationDay(),
						domingoElectronico.getValidationMonth(),
						domingoElectronico.getValidationYear(),
						TimeUtils.getDateFormat(fechaFinal.toDate(), "dd"),
						TimeUtils.getDateFormat(fechaFinal.toDate(), "MM"),
						TimeUtils.getDateFormat(fechaFinal.toDate(), "YY"),
						monthly_hh,
						monthly_ss,
						monthly_day,
						diaHabilDespuesDeFechaProgramada,
						domingoElectronico.getDestino().getNumber(),
						domingoElectronico.getAmount(),
						domingoElectronico.getTipoTransferencia().getValor(),
						domingoElectronico.getContractId(),
						TimeUtils.getDateFormat(DateTime.now().toDate(),
								"dd/MM/yy"),
						domingoElectronico.getContractId(),
						TimeUtils.getDateFormat(DateTime.now().toDate(),
								"dd/MM/yy"),
						domingoElectronico.getContractId(),
						TimeUtils.getDateFormat(DateTime.now().toDate(),
								"dd/MM/yy"),
						domingoElectronico.getAccountType() });

	}

	@Override
	public List<DomingoElectronico> getDomingosProgramados(String contract) {

		String sql = "select ID, ACC,DESC,LOTE,TIPO_PROG,"
				+ " INI_DD,INI_MM,INI_YY,FIN_DD,FIN_MM,FIN_YY,"
				+ " AMOUNT,OUSER,ODATE,VUSER,VDATE,AUSER,ADATE,TIPOCUENTA "
				+ " from dc_progconcen where entityid = ? and transtype = ? "
				+ " and vuser != '' and auser != '' "
				+ " and status is null order by id";

		List<Map<String, Object>> rows = db2Dao.getJdbcTemplate().queryForList(
				sql,
				new Object[] { contract,
						TipoTransferencia.DOMINGO_ELECTRONICO.getValor() });
		DomingoElectronico domingo = null;
		for (Map<String, Object> row : rows) {
			domingo = new DomingoElectronico();
			domingo.setId((Integer)row.get("ID"));
			domingo.setReferenceNumber((String)row.get("LOTE"));
			domingo.setCreditAccount((String)row.get("ACC"));
			domingo.setDescription((String)row.get("DESC"));
			Integer tipo = (Integer)row.get("TIPO_PROG");
			
			if(tipo.intValue()==1){
				domingo.setProgramacion("SEMANAL");
			}else if(tipo.intValue()==0){
				domingo.setProgramacion("DIARIA");
			}else{
				domingo.setProgramacion("MENSUAL");
			}
			
			domingo.setValidationDay((String)row.get("INI_DD"));
			domingo.setValidationMonth((String)row.get("INI_MM"));
			domingo.setValidationYear((String)row.get("INI_YY"));
			
			domingo.setFinProgramacion((String)row.get("FIN_DD") + "/" +(String)row.get("FIN_MM")+ "/"+ (String)row.get("FIN_YY"));
			domingo.setAmount((BigDecimal) row.get("AMOUNT"));
			domingo.setFechaOperacion((Date) row.get("ODATE"));
			
			
			
		}

		return null;
	}

}
