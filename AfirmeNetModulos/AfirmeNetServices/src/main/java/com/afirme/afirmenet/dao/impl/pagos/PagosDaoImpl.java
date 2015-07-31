package com.afirme.afirmenet.dao.impl.pagos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.impl.pagos.rowmapper.ReferenciaServicioRowMapper;
import com.afirme.afirmenet.dao.pagos.PagosDao;
import com.afirme.afirmenet.daoUtil.DaoUtil;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.model.pagos.servicios.ReferenciaServicio;
import com.afirme.afirmenet.service.config.PropertyService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class PagosDaoImpl implements PagosDao {

	static final Logger LOG = LoggerFactory.getLogger(PagosDao.class);

	@Autowired
	private DB2Dao db2Dao;

	@Autowired
	private AS400Dao as400Dao;

	@Autowired
	private PropertyService propertyService;

	@Override
	public List<DC_CONVENIO> getConvenios(List<String> beanTDCAfirme,
			String contrato, String tipoPago) {
		List<DC_CONVENIO> convenios = new ArrayList<DC_CONVENIO>();
		JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();

		String STM = null;
		if (tipoPago.equals("1")) {
			String whereSQL = "";
			if (beanTDCAfirme != null) {
				if (beanTDCAfirme.size() > 0 && beanTDCAfirme.size() == 1) {
					whereSQL = " seracc like '" + beanTDCAfirme.get(0) + "%' ";
				} else if (beanTDCAfirme.size() > 1) {
					int cont = 0;
					while (cont < beanTDCAfirme.size()) {
						if (cont == 0) {
							whereSQL = " seracc not like '"
									+ beanTDCAfirme.get(cont) + "%' ";
						} else {
							whereSQL = whereSQL + " and seracc not like '"
									+ beanTDCAfirme.get(cont) + "%' ";
						}
						cont++;
					}
					whereSQL = "(" + whereSQL + ")";
				}
			}
			// TC Otros Bancos
			STM = "SELECT ENTITYID,SERTYP,SERCOM,SERACC,SERNOM,SERNAM,SERDS1,SERDS2,SERRTY ,SERMIN ,SERMAX ,SERFLG ,SERTAX,SERDTR,SERHLP,CONVNUM,FECHACREACION,TCNOMBRE from DC_CONVENIO WHERE ENTITYID='"
					+ contrato
					+ "' AND SERTYP = 2 AND LENGTH(RTRIM(LTRIM(SERACC))) = 16  and "
					+ whereSQL + "   ORDER BY SERCOM,SERTYP";
		} else if (tipoPago.equals("2")) {
			// TC American Express
			STM = "SELECT ENTITYID,SERTYP,SERCOM,SERACC,SERNOM,SERNAM,SERDS1,SERDS2,SERRTY ,SERMIN ,SERMAX ,SERFLG ,SERTAX,SERDTR,SERHLP,CONVNUM,FECHACREACION,TCNOMBRE from DC_CONVENIO WHERE ENTITYID='"
					+ contrato
					+ "' AND SERTYP = 2 AND LENGTH(RTRIM(LTRIM(SERACC))) = 15 ORDER BY SERCOM,SERTYP";
		} else if (tipoPago.equals("3")) {
			String whereSQL = "";
			if (beanTDCAfirme != null) {
				if (beanTDCAfirme.size() > 0 && beanTDCAfirme.size() == 1) {
					whereSQL = " seracc like '" + beanTDCAfirme.get(0) + "%' ";
				} else if (beanTDCAfirme.size() > 1) {
					int cont = 0;
					while (cont < beanTDCAfirme.size()) {
						if (cont == 0) {
							whereSQL = " seracc like '"
									+ beanTDCAfirme.get(cont) + "%' ";
						} else {
							whereSQL = whereSQL + " or seracc like '"
									+ beanTDCAfirme.get(cont) + "%' ";
						}
						cont++;
					}
					whereSQL = "(" + whereSQL + ")";
				}
			}
			STM = "SELECT ENTITYID,SERTYP,SERCOM,SERACC,SERNOM,SERNAM,SERDS1,SERDS2,SERRTY ,SERMIN ,SERMAX ,SERFLG ,SERTAX,SERDTR,SERHLP,CONVNUM,FECHACREACION,TCNOMBRE from DC_CONVENIO WHERE ENTITYID='"
					+ contrato
					+ "' AND SERTYP = 2 AND LENGTH(RTRIM(LTRIM(SERACC))) = 16  and "
					+ whereSQL + " ORDER BY SERCOM,SERTYP";
		}

		// Se obtiene la fecha de Validacion para mostrar las cuentas
		GregorianCalendar fechaValidacion = new GregorianCalendar();
		String tiempoEsperaCuentas = propertyService
				.obtenerTiempoEsperaSegundos(ConfigProperties.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
		fechaValidacion.add(Calendar.SECOND,
				1 + Integer.parseInt(tiempoEsperaCuentas) * -1);

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(STM,
				new Object[] {});

		try {

			for (Map<String, Object> row : rows) {
				DC_CONVENIO convenio = new DC_CONVENIO();
				convenio.setENTITYID(DaoUtil.getString(row.get("ENTITYID")));
				convenio.setSERTYP(DaoUtil.getInt(row.get("SERTYP")));
				convenio.setSERCOM(DaoUtil.getInt(row.get("SERCOM")));
				convenio.setSERACC(DaoUtil.getString(row.get("SERACC")));
				convenio.setSERNOM(DaoUtil.getString(row.get("SERNOM")));
				convenio.setSERNAM(DaoUtil.getString(row.get("SERNAM")));
				convenio.setSERDS1(DaoUtil.getString(row.get("SERDS1")));
				convenio.setSERDS2(DaoUtil.getString(row.get("SERDS2")));
				convenio.setSERRTY(DaoUtil.getString(row.get("SERRTY")));
				convenio.setSERMIN(DaoUtil.getInt(row.get("SERMIN")));
				convenio.setSERMAX(DaoUtil.getInt(row.get("SERMAX")));
				convenio.setSERFLG(DaoUtil.getString(row.get("SERFLG")));
				convenio.setSERTAX(DaoUtil.getString(row.get("SERTAX")));
				convenio.setSERDTR(DaoUtil.getInt(row.get("SERDTR")));
				convenio.setSERHLP(DaoUtil.getString(row.get("SERHLP")));
				convenio.setCONVNUM(DaoUtil.getBigDecimal(row.get("CONVNUM")));
				convenio.setFECHACREACION(DaoUtil.getString(row
						.get("FECHACREACION")));
				convenio.setTCNOMBRE(DaoUtil.getString(row.get("TCNOMBRE")));

				String tcNombre = convenio.getTCNOMBRE();
				if (tcNombre == null || tcNombre.trim().equals("")) {
					convenio.setTCNOMBRE(convenio.getSERNAM());
				}

				String fechaCreacion = convenio.getFECHACREACION();
				if (fechaCreacion == null)
					fechaCreacion = "20070301000000";
				convenio.setFECHACREACION(fechaCreacion);
				// Si la fecha de Creacion es antes de la fecha actual mas el
				// periodo de espera entonces se muestra
				GregorianCalendar fechaCreac = new GregorianCalendar();
				fechaCreac.set(Integer.parseInt(fechaCreacion.substring(0, 4)),
						Integer.parseInt(fechaCreacion.substring(4, 6)) - 1,
						Integer.parseInt(fechaCreacion.substring(6, 8)),
						Integer.parseInt(fechaCreacion.substring(8, 10)),
						Integer.parseInt(fechaCreacion.substring(10, 12)),
						Integer.parseInt(fechaCreacion.substring(12, 14)));
				// Se realiza un add para que recalcule todos los campos
				fechaCreac.add(Calendar.SECOND, 1);
				if (fechaCreac.before(fechaValidacion)) {
					if (tipoPago.equals("3")) {
						convenio.setSERNAM("TARJETA DE CREDITO AFIRME TERCEROS");
					}
					convenios.add(convenio);
				}
			}
		} catch (EmptyResultDataAccessException e) {
			return null;

		}
		return convenios;
	}

	@Override
	public boolean existeBIN(String numeroBIN) {

		String sql = "SELECT * from DC_BINES WHERE BIN = ? ";
		int count = db2Dao.getJdbcTemplate().queryForObject(sql,
				new Object[] { numeroBIN }, Integer.class);

		boolean result = false;

		if (count > 0) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean existeBIN400(String numeroBIN) {
		String sql = "SELECT * from "
				+ AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
				+ "TDRBINPF WHERE VABINS = ? ";
		int count = as400Dao.getJdbcTemplate().queryForObject(sql,
				new Object[] { numeroBIN }, Integer.class);

		boolean result = false;

		if (count > 0) {
			result = true;
		}

		return result;
	}

	@Override
	public ReferenciaServicio getReferenciaServicio(String servicio) {
		String sql = "SELECT DDVACC,DDVFIJ,DDVLON,DDVCAR,DDVSBR,DDVREF,DDVPPA,DDVPVN,DDVMPV,DDVPPV,DDVDPV,"
				+ "DDVFCC,DDVSRV FROM "
				+ AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
				+ "DDV001PF WHERE DDVSRV=? ORDER BY DDVREF";
		Object[] params = new Object[] { servicio };
		ReferenciaServicio referencia = as400Dao.getJdbcTemplate()
				.queryForObject(sql, new ReferenciaServicioRowMapper(), params);
		return referencia;
	}

	@Override
	public List<DC_CONVENIO> getConveniosSeg(String contrato) {

		List<DC_CONVENIO> convenios = new ArrayList<DC_CONVENIO>();
		JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();

		String STM = "SELECT * from DC_CONVENIO WHERE ENTITYID=? AND SERTYP = 6 ORDER BY SERCOM,SERTYP";

		// Se obtiene la fecha de Validacion para mostrar las cuentas
		GregorianCalendar fechaValidacion = new GregorianCalendar();
		String tiempoEsperaCuentas = propertyService
				.obtenerTiempoEsperaSegundos(ConfigProperties.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
		fechaValidacion.add(Calendar.SECOND,
				1 + Integer.parseInt(tiempoEsperaCuentas) * -1);

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(STM,
				new Object[] {contrato});

		try {

			for (Map<String, Object> row : rows) {
				DC_CONVENIO convenio = new DC_CONVENIO();
				convenio.setENTITYID(DaoUtil.getString(row.get("ENTITYID")));
				convenio.setSERTYP(DaoUtil.getInt(row.get("SERTYP")));
				convenio.setSERCOM(DaoUtil.getInt(row.get("SERCOM")));
				convenio.setSERACC(DaoUtil.getString(row.get("SERACC")));
				convenio.setSERNOM(DaoUtil.getString(row.get("SERNOM")));
				convenio.setSERNAM(DaoUtil.getString(row.get("SERNAM")));
				convenio.setSERDS1(DaoUtil.getString(row.get("SERDS1")));
				convenio.setSERDS2(DaoUtil.getString(row.get("SERDS2")));
				convenio.setSERRTY(DaoUtil.getString(row.get("SERRTY")));
				convenio.setSERMIN(DaoUtil.getInt(row.get("SERMIN")));
				convenio.setSERMAX(DaoUtil.getInt(row.get("SERMAX")));
				convenio.setSERFLG(DaoUtil.getString(row.get("SERFLG")));
				convenio.setSERTAX(DaoUtil.getString(row.get("SERTAX")));
				convenio.setSERDTR(DaoUtil.getInt(row.get("SERDTR")));
				convenio.setSERHLP(DaoUtil.getString(row.get("SERHLP")));
				convenio.setCONVNUM(DaoUtil.getBigDecimal(row.get("CONVNUM")));
				convenio.setFECHACREACION(DaoUtil.getString(row
						.get("FECHACREACION")));
				convenio.setTCNOMBRE(DaoUtil.getString(row.get("TCNOMBRE")));

				String tcNombre = convenio.getTCNOMBRE();
				if (tcNombre == null || tcNombre.trim().equals("")) {
					convenio.setTCNOMBRE(convenio.getSERNAM());
				}

				String fechaCreacion = convenio.getFECHACREACION();
				if (fechaCreacion == null)
					fechaCreacion = "20070301000000";
				convenio.setFECHACREACION(fechaCreacion);
				// Si la fecha de Creacion es antes de la fecha actual mas el
				// periodo de espera entonces se muestra
				GregorianCalendar fechaCreac = new GregorianCalendar();
				fechaCreac.set(Integer.parseInt(fechaCreacion.substring(0, 4)),
						Integer.parseInt(fechaCreacion.substring(4, 6)) - 1,
						Integer.parseInt(fechaCreacion.substring(6, 8)),
						Integer.parseInt(fechaCreacion.substring(8, 10)),
						Integer.parseInt(fechaCreacion.substring(10, 12)),
						Integer.parseInt(fechaCreacion.substring(12, 14)));
				// Se realiza un add para que recalcule todos los campos
				fechaCreac.add(Calendar.SECOND, 1);
				if (fechaCreac.before(fechaValidacion)) {
					convenios.add(convenio);
				}
			}
		} catch (EmptyResultDataAccessException e) {
			return null;

		}
		return convenios;
	}

}
