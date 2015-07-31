/**
 * 
 */
package com.afirme.afirmenet.dao.impl.config;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.config.ConfiguracionDao;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.JBTefbanpf;
import com.afirme.afirmenet.ibs.databeans.SPAPLAPF;
import com.afirme.afirmenet.model.DCConfig;
import com.afirme.afirmenet.model.DCConfig.Aplicacion;
import com.afirme.afirmenet.model.Holiday;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;

/**
 * Clase Reporsitory que permite acceder a la BD y obtener las configuraciones
 * definidas para las aplicaciones
 * 
 * @author jorge.canoc@gmail.com
 */
@Repository
public class ConfiguracionDaoImpl implements ConfiguracionDao {

	static final Logger LOG = LoggerFactory
			.getLogger(ConfiguracionDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;

	@Autowired
	private AS400Dao as400Dao;

	@Override
	public List<DCConfig> getConfiguraciones() {
		return this.getConfiguracion(null);
	}

	@Override
	public List<DCConfig> getConfiguraciones(Aplicacion aplicacion) {
		return this.getConfiguracion(aplicacion);
	}

	@Override
	public Map<String, Object> getConfiguracionesMap() {
		return this.poblarMap(this.getConfiguraciones());
	}

	@Override
	public Map<String, Object> getConfiguracionesMap(Aplicacion aplicacion) {
		return this.poblarMap(this.getConfiguraciones(aplicacion));
	}

	/**
	 * Metodo que permite poblar un Map con la informacion de las
	 * configuraciones almacenadas en la BD
	 * 
	 * @param configuracionesList
	 * @return mapa de configuraciones
	 */
	private Map<String, Object> poblarMap(List<DCConfig> configuracionesList) {
		Map<String, Object> configuracionesMap = new HashMap<String, Object>();
		for (DCConfig row : configuracionesList) {
			configuracionesMap.put(row.getPropiedad(), row.getValor());
		}
		return configuracionesMap;
	}

	/**
	 * Metodo que obtiene los valores almacenados en la tabla de configuracion,
	 * dada una aplicacion {@link Aplicacion} si la aplicacion es nula retornara
	 * todas las configuraciones encontradas
	 * 
	 * @param aplicacion
	 * @return
	 */
	private List<DCConfig> getConfiguracion(Aplicacion aplicacion) {
		List<DCConfig> configuraciones = new ArrayList<DCConfig>(0);
		DCConfig configuracion = null;
		String query = "SELECT APLICACION,DESCRIPCION,GRUPO,PROPIEDAD,VALOR   FROM DC_CONFIG ";

		Set<String> aplicaciones = new HashSet<String>();

		if (aplicacion != null) {
			aplicaciones.add(aplicacion.name());
			aplicaciones.add(Aplicacion.AMBAS.name());
		} else {
			aplicaciones.add(Aplicacion.AFIRMENET_EMPRESAS.name());
			aplicaciones.add(Aplicacion.AFIRMENET_PERSONAS.name());
			aplicaciones.add(Aplicacion.AMBAS.name());
		}

		query += " WHERE APLICACION IN (";
		for (String app : aplicaciones) {
			query += "'" + app + "',";
		}

		query = query.substring(0, query.length() - 1);

		query += ")";
		List<Map<String, Object>> rows = db2Dao.getJdbcTemplate().queryForList(
				query);
		for (Map<String, Object> row : rows) {
			configuracion = new DCConfig();
			configuracion.setAplicaccion(Aplicacion.valueOf(String.valueOf(row
					.get("APLICACION"))));
			configuracion
					.setDescripcion(String.valueOf(row.get("DESCRIPCION")));
			configuracion.setGrupo(String.valueOf(row.get("GRUPO")));
			configuracion.setPropiedad(String.valueOf(row.get("PROPIEDAD")));
			configuracion.setValor(String.valueOf(row.get("VALOR")));
			configuraciones.add(configuracion);
		}

		return configuraciones;
	}

	@Override
	public List<Holiday> getDiasFeriados() {
		int SY = Integer.parseInt(TimeUtils.getYY());
		int EY = SY + 1;
		String lib = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME).equals("null") ? "AFICYFILES." : AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		
		String query = "SELECT HOLDAY,HOLDAM, HOLDAD, HOLWKD FROM  " + lib
				+ "HOLYD where HOLDAY BETWEEN " + SY + " and " + EY

				+ " ORDER BY HOLDAY,HOLDAM,HOLDAD, HOLWKD";
		List<Map<String, Object>> rows;
		try {
			rows = as400Dao.getJdbcTemplate().queryForList(query);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return null;
		}
		Holiday holiday = null;
		List<Holiday> holidayList = new ArrayList<Holiday>(0);

		for (Map<String, Object> row : rows) {
			holiday = new Holiday();
			BigDecimal val = (BigDecimal) row.get("HOLDAY");
			holiday.setYear(val.toString());
			val = (BigDecimal) row.get("HOLDAM");
			holiday.setMonth(val.toString());
			holiday.setDay((String) row.get("HOLWKD"));
			val = (BigDecimal) row.get("HOLDAD");
			holiday.setDayOfMonth(val.toString());
			holidayList.add(holiday);
		}
		return holidayList;
	}

	@Override
	public Map<Integer, String> getErrores() {
		Map<Integer, String> errores = new HashMap<Integer, String>();
		String query = "SELECT MSSNUM,MSSTXT FROM IBSR04M07.MSSGS where MSSLAN = 'S' and MSSNUM > 2899 and MSSNUM < 3000 ORDER BY MSSNUM";
		List<Map<String, Object>> rows;
		try {
			rows = as400Dao.getJdbcTemplate().queryForList(query);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("No existen registros." + e.getLocalizedMessage());
			return null;
		}
		for (Map<String, Object> row : rows) {
			errores.put(((BigDecimal) row.get("MSSNUM")).intValue(),
					(String) row.get("MSSTXT"));
		}

		return errores;
	}

	@Override
	public List<JBTefbanpf> getBANList() {

		String lib = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME).equals("null") ? "AFICYFILES." : AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		
		String sql = "SELECT BANCVE, BANNOM, BANCEM, BANCRE "
				+ "FROM "
				+ lib
				+ "TEFBANPF " + "ORDER BY BANNOM";

		List<Map<String, Object>> listResultBank;
		try {
			listResultBank = as400Dao.getJdbcTemplate().queryForList(sql);
		} catch (EmptyResultDataAccessException e) {
			LOG.debug("Resultado vacio: " + e.getMessage());
			return null;
		}

		List<JBTefbanpf> bankList = new ArrayList<JBTefbanpf>();

		for (Map<String, Object> map : listResultBank) {

			JBTefbanpf bank = new JBTefbanpf();
			bank.setBANCVE(map.get("BANCVE") != null ? (BigDecimal) map
					.get("BANCVE") : null);
			bank.setBANNOM(map.get("BANNOM") != null ? map.get("BANNOM")
					.toString() : null);
			bank.setBANCEM(map.get("BANCEM") != null ? map.get("BANCEM")
					.toString() : null);
			bank.setBANCRE(map.get("BANCRE") != null ? map.get("BANCRE")
					.toString() : null);
			LOG.debug(bank.getBANNOM());
			bankList.add(bank);
		}

		return bankList;
	}

	@Override
	public List<SPAPLAPF> getPlazas() {
		String lib = AfirmeNetConstants
				.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME).equals("null") ? "AFICYFILES." : AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		
		String sql = "SELECT PLANUM,PLANOM,PLALAR,PLABTD,PLABTM,PLABTY,PLACLS,PLASTS,PLAFLG from "
				+ lib
						+ "SPAPLAPF";

		List<Map<String, Object>> listResultPlazas;
		try {
			listResultPlazas = as400Dao.getJdbcTemplate().queryForList(sql);
		} catch (EmptyResultDataAccessException e) {
			LOG.debug("Resultado vacio: " + e.getMessage());
			return null;
		}

		List<SPAPLAPF> plazaList = new ArrayList<SPAPLAPF>(0);

		for (Map<String, Object> map : listResultPlazas) {
			SPAPLAPF plabean = new SPAPLAPF();

			plabean.setPLANUM((BigDecimal) map.get("PLANUM"));
			plabean.setPLANOM((String) map.get("PLANOM"));
			plabean.setPLALAR((String) map.get("PLALAR"));
			plabean.setPLABTD((BigDecimal) map.get("PLABTD"));
			plabean.setPLABTM((BigDecimal) map.get("PLABTM"));
			plabean.setPLABTY((BigDecimal) map.get("PLABTY"));
			plabean.setPLACLS((String) map.get("PLACLS"));
			plabean.setPLASTS((String) map.get("PLASTS"));
			plabean.setPLAFLG((String) map.get("PLAFLG"));
			plazaList.add(plabean);
		}
		return plazaList;
	}

	@SuppressWarnings("unused")
	@Override
	public Map<HorarioServicio, String> getHorarios() {
		String TRANSTYPE = "";

		String TRANSMESSAGE = "";
		String DAYSPAN = "";
		String HOURSPAN = "";
		int cdays = 0;
		int NewDAYOFWEEK = 0;
		int LASTDAYOFWEEK = 0;
		Map<HorarioServicio, String> simpletimetablelist = new HashMap<HorarioServicio, String>();

		// String[] DIASSEMANA = {"Domingo", "Lunes", "Martes", "Miércoles",
		// "Jueves", "Viernes", "Sábado" };
		String[] DIASSEMANA = { "Lunes", "Martes", "Miércoles", "Jueves",
				"Viernes", "Sábado", "Domingo" };

		boolean sqlerror = false;
		Connection cnx = null;
		String STM = "";
		try {
			cnx = db2Dao.getDb2DataSource().getConnection();

			Statement st = cnx.createStatement();
			STM = "SELECT A.TRANSTYPE,CASE WHEN A.DAYOFWEEK>'0' THEN CAST(A.DAYOFWEEK AS INTEGER)-1 ELSE 6 END DAYOFWEEK,CASE WHEN A.DAYOFWEEK>'0' THEN CAST(A.DAYOFWEEK AS INTEGER)-1 ELSE 6 END DAYOFWEEK2,A.INITIME,A.ENDTIME,A.STS,B.TRANSDESC"
					+ " from DC_TIMETABLE A, DC_PROCODE B where A.TRANSTYPE= B.TRANSTYPE  order by A.TRANSTYPE,DAYOFWEEK";
			ResultSet rs = st.executeQuery(STM);

			boolean GoIn = rs.next();

			while (GoIn) {
				boolean SAMETRANS = true;

				while (GoIn && SAMETRANS) {
					TRANSTYPE = rs.getString("TRANSTYPE").trim();
					int DAYOFWEEK = rs.getInt("DAYOFWEEK");
					String INITIME = rs.getString("INITIME");
					while (INITIME.length() < 4) {
						INITIME = "0" + INITIME;
					}
					String ENDTIME = rs.getString("ENDTIME");
					while (ENDTIME.length() < 4) {
						ENDTIME = "0" + ENDTIME;
					}
					int HORAINICIO = Integer.parseInt(INITIME.substring(0, 2));
					int HORAFIN = Integer.parseInt(ENDTIME.substring(0, 2));

					boolean ampmini = false;
					boolean ampmfin = false;

					if (HORAINICIO >= 12) {
						if (HORAINICIO != 12 && HORAINICIO != 24) {
							HORAINICIO = HORAINICIO - 12;
							ampmini = true;
						} else {
							if (HORAINICIO == 12) {
								HORAINICIO = 12;
								ampmini = true;
							} else {
								HORAINICIO = 12;
								ampmini = false;
							}
						}
					}

					if (HORAFIN >= 12) {
						if (HORAFIN != 12 && HORAFIN != 24) {
							HORAFIN = HORAFIN - 12;
							ampmfin = true;
						} else {
							if (HORAFIN == 12) {
								HORAFIN = 12;
								ampmfin = true;
							} else {
								HORAFIN = 12;
								ampmfin = false;
							}
						}
					}
					String STS = rs.getString("STS").trim();
					String THISDAY = DIASSEMANA[DAYOFWEEK];
					GoIn = rs.next();

					String NewTRANSTYPE = "";
					String NewINITIME = "";
					String NewENDTIME = "";

					if (GoIn) {
						NewTRANSTYPE = rs.getString("TRANSTYPE").trim();
						NewINITIME = rs.getString("INITIME");
						while (NewINITIME.length() < 4) {
							NewINITIME = "0" + NewINITIME;
						}
						NewENDTIME = rs.getString("ENDTIME");
						while (NewENDTIME.length() < 4) {
							NewENDTIME = "0" + NewENDTIME;
						}
						NewDAYOFWEEK = rs.getInt("DAYOFWEEK");
					}

					if (HOURSPAN.equals("") && STS.equals("Y")
							&& !(HORAINICIO == 0 && HORAFIN == 0)) {
						if (HORAINICIO == 0 && (HORAFIN == 12 && !ampmfin)) {
							HOURSPAN = " las 24 horas del día. ";
						} else {
							HOURSPAN = "de " + HORAINICIO + ":"
									+ INITIME.substring(2)
									+ (ampmini ? "pm" : "am") + " a " + HORAFIN
									+ ":" + ENDTIME.substring(2)
									+ (ampmfin ? "pm" : "am") + ". ";
						}
					}

					if (NewTRANSTYPE.equals(TRANSTYPE)) {
						SAMETRANS = true;
						// GoIn = rs.next();

						/*
						 * if (HOURSPAN.equals("") && STS.equals("Y") &&
						 * !(HORAINICIO == 0 && HORAFIN == 0)) { if (HORAINICIO
						 * == 0 && (HORAFIN == 12 && !ampmfin)) { HOURSPAN =
						 * " las 24 horas del día. "; } else { HOURSPAN = " de "
						 * + HORAINICIO + ":" + INITIME.substring(2) + (ampmini
						 * ? "pm" : "am") + " a " + HORAFIN + ":" +
						 * ENDTIME.substring(2) + (ampmfin ? "pm" : "am") +
						 * ". "; } }
						 */

						if (NewINITIME.equals(INITIME)
								&& NewENDTIME.equals(ENDTIME)) {
							if (DAYSPAN.equals("")
									&& !(HORAINICIO == 0 && HORAFIN == 0)) {
								DAYSPAN = THISDAY;
								if (DAYOFWEEK == 5)
									DAYSPAN += " y ";
								else
									DAYSPAN += " a ";
								cdays++;
								LASTDAYOFWEEK = DAYOFWEEK;
							} else

							if (NewDAYOFWEEK == 6) {
								DAYSPAN += "" + DIASSEMANA[NewDAYOFWEEK];
								LASTDAYOFWEEK = 6;
							}
						} else {
							if (STS.equals("Y")
									&& !(HORAINICIO == 0 && HORAFIN == 0)) {
								DAYSPAN += "" + THISDAY;
								cdays++;
							}
							TRANSMESSAGE += DAYSPAN + " " + HOURSPAN + " ";
							DAYSPAN = "";
							HOURSPAN = "";
						}
					} else {
						if (DAYSPAN.equals("")
								&& !(HORAINICIO == 0 && HORAFIN == 0)) {
							DAYSPAN = DIASSEMANA[DAYOFWEEK] + "";
							LASTDAYOFWEEK = DAYOFWEEK;
						}
						if (HOURSPAN.equals("") && STS.equals("Y")
								&& !(HORAINICIO == 0 && HORAFIN == 0)) {
							if (HORAINICIO == 0 && (HORAFIN == 12 && !ampmfin)) {
								HOURSPAN = " las 24 horas del día. ";
							} else {
								HOURSPAN = "de " + HORAINICIO + ":"
										+ INITIME.substring(2)
										+ (ampmini ? "pm" : "am") + " a "
										+ HORAFIN + ":" + ENDTIME.substring(2)
										+ (ampmfin ? "pm" : "am") + ". ";
							}
						}
						if (DAYOFWEEK == 6 && LASTDAYOFWEEK != 6) {
							DAYSPAN += "" + DIASSEMANA[DAYOFWEEK];
							LASTDAYOFWEEK = DAYOFWEEK;
						}

						if (!DAYSPAN.equals("") && !HOURSPAN.equals("")) {
							TRANSMESSAGE += DAYSPAN + " " + HOURSPAN;
						}

						SAMETRANS = false;
						if (TRANSMESSAGE.equals("")) {
							TRANSMESSAGE = "Este servicio no está disponible en ningun horario.";
						}

						simpletimetablelist.put(
								HorarioServicio.findByValue(TRANSTYPE),
								TRANSMESSAGE);
						TRANSMESSAGE = "";
						DAYSPAN = "";
						HOURSPAN = "";
					}
				}
			}

			rs.close();
		} catch (SQLException e) {
			LOG.debug("Exception e : " + e + " STM:" + STM);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e + " STM:" + STM);
				sqlerror = true;
			}
		}

		return (simpletimetablelist);
	}
}
