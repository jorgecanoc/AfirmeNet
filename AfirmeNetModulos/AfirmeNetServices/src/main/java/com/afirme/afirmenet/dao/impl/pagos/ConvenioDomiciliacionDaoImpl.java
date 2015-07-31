package com.afirme.afirmenet.dao.impl.pagos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.pagos.ConveniosDomiciliacionDao;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.pagos.ConvenioDomiciliacion;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class ConvenioDomiciliacionDaoImpl implements ConveniosDomiciliacionDao {

	@Autowired
	AS400Dao as400Dao;
	
	static final Logger LOG = LoggerFactory.getLogger(ConvenioDomiciliacionDaoImpl.class);
	
	@Override
	public List<ConvenioDomiciliacion> getServiciosBasicos400() {
		
		String sql = 
			"SELECT * " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "INPARMPF " +
			"WHERE PAESTA <> 'I' " +
			"ORDER BY PANARR";
		
		List<Map<String, Object>> listResult;
		
		try {
			listResult = as400Dao.getJdbcTemplate().queryForList(sql);
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado del Query vacio: " + e.getMessage());
			return null;
		}
		
		List<ConvenioDomiciliacion> listConvenios = new ArrayList<ConvenioDomiciliacion>();
		
		for (Map<String, Object> map : listResult) {
			
			ConvenioDomiciliacion convenio = new ConvenioDomiciliacion();
			convenio.setFolio(map.get("PACONS").toString());
			convenio.setAcuerdo(map.get("PAACUER").toString());
			convenio.setServicio(map.get("PADSCE").toString());
			
			listConvenios.add(convenio);
		}
		
		return listConvenios;
	}

	@Override
	public List<ConvenioDomiciliacion> getContratoServicioDomiciliacion(String contrato) {
		
		String sql = 
			"SELECT PCDSC1, PCREFS, PCCONS, PANARR, PADSCE, PACONS, PAACUER, PADSCE, PCFEAC, PCHOAC, PCCTAC, PCTITS, PCPAGMI, PCPAGMA " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "INCONTPF01, " + 
					AfirmeNetConstants.AS400_LIBRARY + "INPARMPF " +
			"WHERE UPPER(PCESTP) <> 'D' " +
			"AND UPPER(PCESTP) <> 'P' " +
			"AND PACONS = PCCONS " +
			"AND PCCONI = ? " +
			"ORDER BY PCCONS DESC";
		
		List<Map<String, Object>> listResult;
		
		try {
			listResult = as400Dao.getJdbcTemplate().queryForList(sql, new Object[] {contrato});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado de Query vacio: " + e.getMessage());
			return null;
		}
		
		Set<ConvenioDomiciliacion> convenioSet = new HashSet<ConvenioDomiciliacion>();
		
		for (Map<String, Object> map : listResult) {
			ConvenioDomiciliacion convenio = new ConvenioDomiciliacion();
			convenio.setDescripcion(map.get("PANARR") != null ? map.get("PANARR").toString().trim() : "");
			convenio.setReferencia(map.get("PCREFS") != null ? map.get("PCREFS").toString().trim() : "");
			convenio.setFolio(map.get("PACONS") != null ? map.get("PACONS").toString().trim() : "");
			convenio.setAcuerdo(map.get("PAACUER") != null ? map.get("PAACUER").toString().trim() : "");
			convenio.setServicio(map.get("PADSCE") != null ? map.get("PADSCE").toString().trim() : "");
			convenio.setFechaContratacion(map.get("PCFEAC") != null ? map.get("PCFEAC").toString().trim() : "");
			convenio.setHoraContratacion(map.get("PCHOAC") != null ? map.get("PCHOAC").toString().trim() : "");
			convenio.setTitular(map.get("PCTITS") != null ? map.get("PCTITS").toString().trim() : "");
			convenio.setPagoMin(map.get("PCPAGMI") != null ? Double.parseDouble(map.get("PCPAGMI").toString()) : new Double(0));
			convenio.setPagoMax(map.get("PCPAGMA") != null ? Double.valueOf(map.get("PCPAGMA").toString()) : new Double(0));
			
			Cuenta cuenta = new Cuenta();
			cuenta.setNumber(map.get("PCCTAC") != null ? map.get("PCCTAC").toString().trim() : "");
			convenio.setOrigen(cuenta);
			
			convenioSet.add(convenio);
		}
		
		return (new ArrayList<ConvenioDomiciliacion>(convenioSet));
	}

	@Override
	public ConvenioDomiciliacion getInfoServicioDomiciliacion(int folio) {
		
		String sql = 
			"SELECT PACONS, PAACUER, PADSCE, PANARR " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "INPARMPF " +
			"WHERE PACONS = ?";
		
		Map<String, Object> mapResult;
		try {
			mapResult = as400Dao.getJdbcTemplate().queryForMap(sql, new Object[] {folio});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		ConvenioDomiciliacion convenio = new ConvenioDomiciliacion();
		convenio.setFolio(mapResult.get("PACONS").toString().trim());
		convenio.setAcuerdo(mapResult.get("PAACUER").toString().trim());
		convenio.setServicio(mapResult.get("PADSCE").toString().trim());
		convenio.setDescripcion(mapResult.get("PANARR").toString().trim());
		
		return convenio;
	}
	
	public List<ConvenioDomiciliacion> getHistorialMovimientos(ConvenioDomiciliacion convenio, String fechaInicio, String fechaFin) {
		// From
		int FDD = Integer.parseInt(fechaInicio.substring(1,2));
		int FMM = Integer.parseInt(fechaInicio.substring(2,4));
		int FYY = Integer.parseInt(fechaInicio.substring(4,6));
		// To
		int TDD = Integer.parseInt(fechaFin.substring(1,2));
		int TMM = Integer.parseInt(fechaFin.substring(2,4));
		int TYY = Integer.parseInt(fechaFin.substring(4,6));
		
		String sfDate = (FYY < 10 ? ("200" + FYY) : (FYY >= 90 ? "19" + FYY
				: "20" + FYY))
				+ (FMM < 10 ? "0" + FMM : "" + FMM)
				+ (FDD < 10 ? "0" + FDD : "" + FDD);
		String stDate = (TYY < 10 ? ("200" + TYY) : (TYY >= 90 ? "19" + TYY
				: "20" + TYY))
				+ (TMM < 10 ? "0" + TMM : "" + TMM)
				+ (TDD < 10 ? "0" + TDD : "" + TDD);
		
			
		String sql = "call " + AfirmeNetConstants.AS400_LIBRARY + "DOMI_CBZHIS(?,?,?,?,?,?,?,?)";
		
		Object[] args = {
			convenio.getContractId(),
			convenio.getReferencia(),
			"0",
			"0",
			sfDate,
			stDate,
			"0",
			"0"
		};

		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		try {
			resultList = as400Dao.getJdbcTemplate().queryForList(sql, args);
		} catch (Exception e) {
			LOG.error("Error en Query: " + e.getMessage());
			e.printStackTrace();
		}
		
		List<ConvenioDomiciliacion> listConvenios = new ArrayList<ConvenioDomiciliacion>();
		
		for (Map<String, Object> map : resultList) {
			
			ConvenioDomiciliacion registroConvenio = new ConvenioDomiciliacion();
			
			Cuenta cuenta = new Cuenta();
			cuenta.setNumber(map.get("HCCONI") != null ? map.get("HCCONI").toString() : "");
			registroConvenio.setOrigen(cuenta);
			
			registroConvenio.setServicio(map.get("HCCONS") != null ? map.get("HCCONS").toString() : "");
			//beanMovtoDOM.setHCCONS(getDescServBasicos(rs.getString("HCCONS")));
			
			registroConvenio.setReferencia(map.get("HCREFS") != null ? map.get("HCREFS").toString() : "");
			registroConvenio.setAmount(new BigDecimal(map.get("HCMONT") != null ? map.get("HCMONT").toString() : "0"));
			
			String fecha = map.get("HCFEPA") != null ? map.get("HCFEPA").toString() : "";
			if (!StringUtils.isEmpty(fecha))
				registroConvenio.setFechaPago(fecha.substring(6) + "/" + fecha.substring(4, 6) + "/" + fecha.substring(0, 4));
			
			String hora = Util.formatHora(map.get("HCHOPA") != null ? map.get("HCHOPA").toString() : "");
			if (!StringUtils.isEmpty(hora))
				registroConvenio.setHoraPago(hora.substring(0, 2) + ":" + hora.substring(2, 4));
			
			registroConvenio.setEstatusPago(map.get("HCESTP") != null ? map.get("HCESTP").toString() : "");
			
			if (registroConvenio.getEstatusPago().equalsIgnoreCase("PA"))
				registroConvenio.setDescEstatusPago("Pago exitoso");
			else
				registroConvenio.setDescEstatusPago("No se pudo ejecutar pago");
			
			registroConvenio.setMotivoRechazoPago(map.get("HCDSC1") != null ? map.get("HCDSC1").toString() : "");
			
			listConvenios.add(registroConvenio);
		}
			
		return listConvenios;
	}

}
