package com.afirme.afirmenet.dao.impl.pagos;

import java.math.BigDecimal;
import java.text.DateFormatSymbols;
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
import com.afirme.afirmenet.dao.pagos.ImpuestosGDFDao;
import com.afirme.afirmenet.helper.pagos.ImpuestosGDFHelper;
import com.afirme.afirmenet.ibs.generics.ConvierteBase;
import com.afirme.afirmenet.model.pagos.ImpuestoGDF;
import com.afirme.afirmenet.model.pagos.Tesoreria;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class ImpuestosGDFDaoImpl implements ImpuestosGDFDao {

	@Autowired
	private AS400Dao as400Dao;
	
	private ImpuestosGDFHelper helper;
	
	static final Logger LOG = LoggerFactory.getLogger(ImpuestosGDFDaoImpl.class);
	
	@Override
	public ImpuestoGDF getInfoImpuestoGDF(ImpuestoGDF impuesto) {
		
		String sql = 
			"SELECT g.grconcepto, c.dfgrupo, c.dfclave, c.dftipo, c.dfimporte, c.dfconcepto " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "tesgrupopf g, " +
			AfirmeNetConstants.AS400_LIBRARY + "tescptopf c " +
			"WHERE g.grgrupo = c.dfgrupo " +
			"AND c.dfclave = ?";
		
		Map<String, Object> mapResult;
		
		try {
			mapResult = as400Dao.getJdbcTemplate().queryForMap(sql, new Object[] {impuesto.getLineaCaptura().substring(0, 2)});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		int idGrupo = mapResult.get("dfgrupo") != null ? Integer.parseInt(mapResult.get("dfgrupo").toString()) : 0;
		int idClave = mapResult.get("dfclave").toString() != null ? Integer.parseInt(mapResult.get("dfclave").toString()) : 0;
		String concepto = mapResult.get("dfconcepto") != null ? mapResult.get("dfconcepto").toString().trim() : "";
		String nombreGrupo = mapResult.get("grconcepto") != null ? mapResult.get("grconcepto").toString().trim() : "";
		double importe = mapResult.get("dfimporte") != null ? Double.parseDouble(mapResult.get("dfimporte").toString()) : 0;
		
		impuesto.setIdGrupo(idGrupo);
		impuesto.setIdClave(idClave);
		impuesto.setConcepto(concepto);
		impuesto.setNombreGrupo(nombreGrupo);
		
		try {
			switch (impuesto.getConceptoGDF()) {
				case LICENCIA_CONDUCIR:
					impuesto.setImporte(importe);
					impuesto = setLicenciaConducir(impuesto);
					break;
				case TRAM_VEHICULAR:
					impuesto.setImporte(importe);
					impuesto = setInfoTramiteVehicular(impuesto);
					break;
				case MULTA_REV_VEHICULAR:
					impuesto.setImporte(importe);
					impuesto = setInfoMultaRevistaVehicular(impuesto);
					break;
				case MULTA_INFRACCION:
					impuesto.setImporte(importe);
					impuesto = setInfoMultaInfraccion(impuesto);
					break;
				case MEDIO_AMB_VERFIC_EXTEMP:
					impuesto.setImporte(importe);
					impuesto = setMedioAmbienteVerificacion(impuesto);
					break;
				case MEDIO_AMBIENTE_CONTAM:
					impuesto.setImporte(importe);
					impuesto = setMedioAmbienteContaminantes(impuesto);
					break;
				case MEDIO_AMBIENTE_HOLOGR:
					impuesto.setImporte(importe);
					impuesto = setMedioAmbienteHologramas(impuesto);
					break;
				case REGISTRO_CIVIL: 
				case REGISTRO_CIVIL_BUSQUEDA: 
					impuesto = setRegistroCivil(impuesto, importe);
					break;
				case SERVICIO_POLICIA:
					impuesto.setImporte(importe);
					impuesto = setServicioPolicia(impuesto);
					break;
				case IMP_PREDIAL:
					impuesto = setImpuestoPredial(impuesto);
					break;
				case SUMINISTRO_AGUA:
					impuesto.setImporte(importe);
					impuesto = setSuministroAgua(impuesto);
					break;
				case TENENCIA:
					impuesto.setPrecioUnitario(importe);
					impuesto = setTenenciaVehicular(impuesto);
					break;
				case IMP_NOMINA:
					impuesto.setImporte(importe);
					impuesto = setImpuestoSobreNomina(impuesto);
					break;
				case IMP_RIFAS:
					impuesto.setImporte(importe);
					impuesto = setImpuestoRifas(impuesto);
					break;
				case IMP_HOSPEDAJE:
					impuesto.setImporte(importe);
					impuesto = setImpuestoHospedaje(impuesto);
					break;
				case IMP_INMUEBLES:
					impuesto.setImporte(importe);
					impuesto = setImpuestoAdquisicionInmuebles(impuesto);
					break;
				case REGISTRO_PUBLICO:
					impuesto.setImporte(importe);
					impuesto = setRegistroPublico(impuesto);
					break;
				case AUTO_NUEVO:
					impuesto.setImporte(importe);
					impuesto = setImpuestoAutoNuevo(impuesto);
					break;
				case ISR_ENAJENACION:
					impuesto.setImporte(importe);
					impuesto = setImpuestoEnajenacion(impuesto);
					break;
				case PAGOS_TESORERIA:
					impuesto.setImporte(importe);
					impuesto = setPagoTesoreria(impuesto);
					break;
				default:
					LOG.error("Clave de Concepto no implementado " + impuesto.getConceptoGDF().getValor());
					LOG.error("Linea de Captura no soportada: " + impuesto.getLineaCaptura());
					return null;
			}
			// TODO revisar si ya esta linea esta duplicada
			impuesto.setAmount(new BigDecimal(importe));
			
		} catch (Exception e) {
			LOG.error("Error en la obtención de Información de ImpuestoGDF: " + e.getMessage());
			e.printStackTrace();
			impuesto.printOut();
		}
		
		return impuesto;
	}
	
	private ImpuestoGDF setLicenciaConducir(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		int idClave = Integer.parseInt(lineaCaptura.substring(0, 2));
		// Set periodo
		String periodo;
		Tesoreria tesoreria = getInfoTesoreria(idClave, "");
		if (tesoreria != null)
			periodo = tesoreria.getConcepto();
		else
			periodo = "";
		impuesto.setPeriodo(periodo);
		// Set TipoLicencia
		if (idClave >= 1 && idClave <= 14) {
			String tipo = lineaCaptura.substring(2, 3);
			if (tipo.equals("A") || tipo.equals("B") || tipo.equals("C") || tipo.equals("D") || tipo.equals("E"))
				impuesto.setTipoLicencia(tipo);
			else
				impuesto.setTipoLicencia("-");
		} else
			impuesto.setTipoLicencia(tesoreria.getSubClave());
		// Set RFC
		String rfc_aux = lineaCaptura.substring(3, 13);
		String rfc = "";
		// reemplazando los primeros 4 caracteres
		// 1 por & y 2 por Ñ
		for (int i = 0; i < 4; i++) {
			if (rfc_aux.charAt(i) == '1') {
				rfc += "&";
			} else if (rfc_aux.charAt(i) == '2') {
				rfc += "Ñ";
			} else
				rfc += rfc_aux.charAt(i);
		}
		rfc += rfc_aux.substring(4, rfc_aux.length());
		impuesto.setRfc(rfc);
		
		return impuesto;
	}
	
	private ImpuestoGDF setInfoTramiteVehicular(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		int idClave = Integer.parseInt(lineaCaptura.substring(0, 2)); 
		
		if (idClave >= 36 && idClave <= 45) {
			impuesto.setConcepto(impuesto.getConcepto().replaceAll("Tramites Vehiculares para ","").replaceAll("Trámites Vehiculares para ","").replaceAll("Trámites Vehiculares ","").replaceAll("Tramites Vehiculares ",""));
			impuesto.setClaveMarca(lineaCaptura.substring(4,5));
			// Set marca
			impuesto.setMarca("---");
			// verifica marca y actualiza el valor si es posible
			Tesoreria tesoreria;
			if (idClave > 0) {
				tesoreria = getInfoTesoreria(Integer.parseInt(lineaCaptura.substring(0,2)), lineaCaptura.substring(4,5));
				if (tesoreria != null)
					impuesto.setMarca(tesoreria.getConcepto());
			}
			// Set origenTramite
			if (Integer.valueOf(lineaCaptura.substring(2,3)).intValue() >= 0)
				impuesto.setOrigenTramite(lineaCaptura.substring(2,4));
			else
				impuesto.setOrigenTramite(lineaCaptura.substring(2,3));
			// Set origenTramiteDescripcion
			tesoreria = getInfoTesoreria(900, lineaCaptura.substring(2,3));
			if (tesoreria != null)
				impuesto.setOrigenTramiteDescripcion(tesoreria.getConcepto());
			else
				impuesto.setOrigenTramiteDescripcion("Otros");
			
		} else {
			impuesto.setClaveMarca(lineaCaptura.substring(2,3));
			// Set marca
			Tesoreria tesoreria = getInfoTesoreria(Integer.parseInt(lineaCaptura.substring(0,2)), lineaCaptura.substring(2,3));
			if (tesoreria != null)
				impuesto.setMarca(tesoreria.getConcepto());
		}
		// Set modelo
		impuesto.setModelo(ImpuestosGDFHelper.getModelo(impuesto));
		// Set placa
		impuesto.setPlaca(ImpuestosGDFHelper.getPlaca(lineaCaptura));
		
		return impuesto;
	}
	
	private ImpuestoGDF setInfoMultaRevistaVehicular(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		impuesto.setModelo(ImpuestosGDFHelper.getModelo(impuesto));
		impuesto.setPlaca(ImpuestosGDFHelper.getPlaca(lineaCaptura));
		impuesto.setFolioInfraccion(ImpuestosGDFHelper.getFolioInfraccion(lineaCaptura));
		// Set marca
		int idClave = Integer.parseInt(lineaCaptura.substring(0, 2));
		String marca = "";
		impuesto.setMarca(marca);
		if (idClave > 0) {
			Tesoreria tesoreria = getInfoTesoreria(idClave, lineaCaptura.substring(2,3));
			if (tesoreria != null)
				impuesto.setMarca(tesoreria.getConcepto());
		}
		// Set OrigenTramiteme
		impuesto.setOrigenTramite("");
		impuesto.setOrigenTramiteDescripcion("");
		
		return impuesto;
	}
	
	private ImpuestoGDF setInfoMultaInfraccion(ImpuestoGDF impuesto) {
		impuesto.setFolioInfraccion(ImpuestosGDFHelper.getFolioInfraccion(impuesto.getLineaCaptura()));
		return impuesto;
	}
	
	private ImpuestoGDF setMedioAmbienteVerificacion(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		int idClave = Integer.parseInt(lineaCaptura.substring(0, 2));
		// Set Marca
		if (idClave >= 36 && idClave <= 45) {
			Tesoreria tesoreria = getInfoTesoreria(Integer.parseInt(lineaCaptura.substring(0,2)), lineaCaptura.substring(4,5));
			if (tesoreria != null)
				impuesto.setMarca(tesoreria.getConcepto());
		} else {
			Tesoreria tesoreria = getInfoTesoreria(Integer.parseInt(lineaCaptura.substring(0,2)), lineaCaptura.substring(2,3));
			if (tesoreria != null)
				impuesto.setMarca(tesoreria.getConcepto());
		}

		impuesto.setModelo(ImpuestosGDFHelper.getModelo(impuesto));
		impuesto.setPlaca(ImpuestosGDFHelper.getPlaca(lineaCaptura));
		
		// Set OrigenTramite
		impuesto.setOrigenTramite("");
		impuesto.setOrigenTramiteDescripcion("");
		
		return impuesto;
	}
	
	private ImpuestoGDF setMedioAmbienteContaminantes(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		impuesto.setFolioInfraccion(Long.parseLong(lineaCaptura.substring(5,13)));
		
		// Set anio
		String linea = lineaCaptura.substring(3, 5);
		int lineaNumero = Integer.parseInt(linea);
		
		if (lineaNumero < 50)
			impuesto.setAnioInfraccion(Integer.parseInt("20" + linea));
		else if (lineaNumero >= 50)
			impuesto.setAnioInfraccion(Integer.parseInt("19" + linea));
		
		return impuesto;
	}
	
	private ImpuestoGDF setMedioAmbienteHologramas(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		impuesto.setClaveVerificacion(ImpuestosGDFHelper.getClaveVerificacionCentro(lineaCaptura));
		impuesto.setCantidad(Integer.parseInt(lineaCaptura.substring(6,10)));
		impuesto.setFolio(Integer.parseInt(lineaCaptura.substring(2,6)));
		// Set holograma
		Tesoreria tesoreria = getInfoTesoreria(Integer.parseInt(lineaCaptura.substring(0,2)), lineaCaptura.substring(12, 13));
		if (tesoreria != null)
			impuesto.setTipoHolograma(tesoreria.getConcepto());
		
		return impuesto;
	}
	
	private ImpuestoGDF setRegistroCivil(ImpuestoGDF impuesto, double importe) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		
		Long folio = new Long(0);
		try {
			folio = Long.valueOf(lineaCaptura.substring(5,13));
			impuesto.setFolio(folio);
		} catch (NumberFormatException e) {
			impuesto.setFolio(folio);
		}
		
		int idClave = Integer.parseInt(lineaCaptura.substring(0, 2));
		
		if (idClave == 54 || idClave == 55 || idClave == 56) {
			int numeroCopias = Integer.parseInt(lineaCaptura.substring(2,4));
			impuesto.setCantidad(numeroCopias);
			impuesto.setPrecioUnitario(impuesto.getImporte() / numeroCopias);
		} else {
			impuesto.setPrecioUnitario(importe);
			int cantidad = 0;
			try {
				cantidad = (int) (impuesto.getImporte() / impuesto.getPrecioUnitario());
				impuesto.setCantidad(cantidad);
			} catch (Exception e) {
				impuesto.setCantidad(cantidad);
			}
		}
		
		return impuesto;
	}
	
	private ImpuestoGDF setServicioPolicia(ImpuestoGDF impuesto) {
		impuesto.setFolioFactura(Long.valueOf(impuesto.getLineaCaptura().substring(5, 13)));
		return impuesto;
	}
	
	private ImpuestoGDF setImpuestoPredial(ImpuestoGDF impuesto) {
		impuesto.setCuentaPredial(ImpuestosGDFHelper.getCuentaPredial(impuesto.getLineaCaptura()));
		impuesto.setEjercicio(ImpuestosGDFHelper.getEjercicio(impuesto.getLineaCapturaBase()));
		impuesto.setBimestre(ImpuestosGDFHelper.getBimestre(impuesto.getLineaCapturaBase()));
		return impuesto;
	}
	
	private ImpuestoGDF setSuministroAgua(ImpuestoGDF impuesto) {
		impuesto.setEjercicio(ImpuestosGDFHelper.getEjercicio(impuesto.getLineaCapturaBase()));
		impuesto.setBimestre(impuesto.getLineaCapturaBase().substring(17,18));
		return impuesto;
	}
	
	private ImpuestoGDF setTenenciaVehicular(ImpuestoGDF impuesto) {
		impuesto.setPlaca(ImpuestosGDFHelper.getPlaca(impuesto.getLineaCaptura()));
		impuesto.setModelo(ImpuestosGDFHelper.getModelo(impuesto));
		impuesto.setEjercicio(ImpuestosGDFHelper.getEjercicio(impuesto.getLineaCapturaBase()));
		if (impuesto.getEjercicio() == 0)
			impuesto.setEjercicio(ImpuestosGDFHelper.getEjercicio(impuesto.getLineaCaptura()));
		return impuesto;
	}
	
	private ImpuestoGDF setImpuestoSobreNomina(ImpuestoGDF impuesto) {
		impuesto.setRfc(ImpuestosGDFHelper.getRfc(impuesto.getLineaCaptura()));
		impuesto.setEjercicio(ImpuestosGDFHelper.getEjercicio(impuesto.getLineaCapturaBase()));
		
		String linea = impuesto.getLineaCapturaBase().substring(17,18);
		int mes = (int) ConvierteBase.convertB36ToB10(linea);
		
		DateFormatSymbols dateFormat = new DateFormatSymbols();
		String mesNombre;
		String[] meses = dateFormat.getMonths(); 
		mesNombre = meses[mes-1];
		
		impuesto.setMes(mesNombre.toUpperCase());
		
		return impuesto;
	}
	
	private ImpuestoGDF setImpuestoRifas(ImpuestoGDF impuesto) {
		impuesto.setRfc(ImpuestosGDFHelper.getRfc(impuesto.getLineaCaptura()));
		impuesto.setEjercicio(ImpuestosGDFHelper.getEjercicio(impuesto.getLineaCapturaBase()));
		
		String linea = impuesto.getLineaCapturaBase().substring(17, 18);
		String result = "";
		if (linea.equals("0")) {
			result = "Por conclusión de actividades";
		} else if (linea.equals("X")) {
			result = "(No aplica)";
		} else {
			int mes = (int) ConvierteBase.convertB36ToB10(linea);
			
			DateFormatSymbols dateFormat = new DateFormatSymbols();
			String mesNombre;
			String[] meses = dateFormat.getMonths(); 
			mesNombre = meses[mes-1];
			result = mesNombre.toUpperCase();
		}
		
		impuesto.setMes(result);
		
		return impuesto;
	}
	
	private ImpuestoGDF setImpuestoHospedaje(ImpuestoGDF impuesto) {
		impuesto.setRfc(ImpuestosGDFHelper.getRfc(impuesto.getLineaCaptura()));
		impuesto.setEjercicio(ImpuestosGDFHelper.getEjercicio(impuesto.getLineaCapturaBase()));
		
		String linea = impuesto.getLineaCapturaBase().substring(17, 18);
		int mes = (int) ConvierteBase.convertB36ToB10(linea);
		
		DateFormatSymbols dateFormat = new DateFormatSymbols();
		String mesNombre;
		String[] meses = dateFormat.getMonths(); 
		mesNombre = meses[mes-1];
		
		impuesto.setMes(mesNombre.toUpperCase());
		
		return impuesto;
	}
	
	private ImpuestoGDF setImpuestoAdquisicionInmuebles(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		
		String cuentaPredial = lineaCaptura.substring(2,13);
		cuentaPredial = cuentaPredial + "-" + ImpuestosGDFHelper.getDigitoVerificador(lineaCaptura);
		impuesto.setCuentaPredial(cuentaPredial);
		
		String linea = impuesto.getLineaCapturaBase().substring(16, 17);
		String tipo = "";
		if (linea.equals("C"))
			tipo = "Compra-Venta";
		else if (linea.equals("A"))
			tipo = "Adjudicación";
		else if (linea.equals("D"))
			tipo = "Donacion";
		else if (linea.equals("T"))
			tipo = "Otros";
		else if (linea.equals("X"))
			tipo = "(No Aplica)";
		
		impuesto.setTipoOperacion(tipo);
		
		return impuesto;
	}
	
	private ImpuestoGDF setRegistroPublico(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		// Set Folio
		Long folio = new Long(0);
		try {
			folio = Long.valueOf(lineaCaptura.substring(6,13));
			impuesto.setFolio(folio);
		} catch (NumberFormatException e) {
			impuesto.setFolio(folio);
		}
		// Set Tramite
		String nombreTramite = "";
		String subClave = lineaCaptura.substring(2,6);
		if (!subClave.equals("90")) {
			Tesoreria tesoreria = getInfoTesoreria(Integer.parseInt(lineaCaptura.substring(0,2)), subClave);
			if (tesoreria != null)
				nombreTramite = tesoreria.getConcepto();
		} else {
			nombreTramite = "Solicitud de entrada y trámite ";
		}
		
		String leyenda = "";
		int numActosJuridicos = 0;
		try {
			String clave = lineaCaptura.substring(2, 4);
			if (clave.equals("90")) {
				numActosJuridicos = Integer.parseInt(lineaCaptura.substring(4, 6));
				leyenda = "con " + numActosJuridicos + " actos jurídicos";
			}
		} catch (NumberFormatException e) {
			leyenda = "";
		}
		
		impuesto.setTramite(leyenda.length() > 1 ? nombreTramite += " " + leyenda : nombreTramite);
		
		return impuesto;
	}
	
	private ImpuestoGDF setImpuestoAutoNuevo(ImpuestoGDF impuesto) {
		return setImpuestoHospedaje(impuesto);
	}
	
	private ImpuestoGDF setImpuestoEnajenacion(ImpuestoGDF impuesto) {
		
		String clave = impuesto.getLineaCapturaBase().substring(16, 17);
		
		String subConcepto = "";
		if (clave.equals("1"))
			subConcepto = "Impuesto sobre la Renta por Enajenación 5% (ISR)";
		if (clave.equals("2"))
			subConcepto = "I.E.P.S";
		impuesto.setSubConcepto(subConcepto);
		impuesto.setClaveSubConcepto(clave);
		
		String referencia = "";
		if (clave.equals("1"))
			referencia = impuesto.getLineaCapturaBase().substring(2, 12);
		if (clave.equals("2"))
			referencia = impuesto.getLineaCapturaBase().substring(4, 12);
		impuesto.setCuentaPredial(referencia);
		
		String claveTipo = impuesto.getLineaCapturaBase().substring(17,18);
		String tipo = "";
		if (claveTipo.equals("1"))
			tipo = "Vigente Normal";
		if (claveTipo.equals("2"))
			tipo = "Vigente Complementaria";
		if (claveTipo.equals("3"))
			tipo = "Vigente Autocorrección";
		if (claveTipo.equals("4"))
			tipo = "Vencida Normal";
		if (claveTipo.equals("5"))
			tipo = "Vencida Complementaria";
		if (claveTipo.equals("6"))
			tipo = "Vencida Autocorrección";
		if (claveTipo.equals("9"))
			tipo = "Otros";
		impuesto.setTipoDeclaracion(tipo);
		impuesto.setClaveTipoDeclaracion(claveTipo);
		impuesto.setVigencia("");
		
		return impuesto;
	}
	
	private ImpuestoGDF setPagoTesoreria(ImpuestoGDF impuesto) {
		
		String lineaCaptura = impuesto.getLineaCaptura();
		
		Long folio;
		try {
			folio = Long.valueOf(lineaCaptura.substring(8, 13));
		} catch (Exception e) {
			folio = new Long(0);
		}
		impuesto.setFolio(folio);
		
		impuesto.setReferenciaPago(lineaCaptura.substring(16,18) + lineaCaptura.substring(2,6));
		impuesto.setClaveAdminTributaria(lineaCaptura.substring(6,8));
		
		String adminTributaria;
		Tesoreria tesoreria = getInfoTesoreria(77, lineaCaptura.substring(6,8));
		if (tesoreria != null)
			adminTributaria = tesoreria.getConcepto();
		else
			adminTributaria = "";
		impuesto.setAdminTributaria(adminTributaria);
		
		String concepto = "";
		tesoreria = getInfoTesoreria(77, lineaCaptura.substring(2,6));
		if (tesoreria != null)
			concepto = tesoreria.getConcepto();
		else
			concepto = "";
		
		impuesto.setConceptoPagoTesoreria(concepto);
		
		return impuesto;
	}
	
	private Tesoreria getInfoTesoreria(int idClave, String subClave) {
		
		String sql = 
			"SELECT tbgrupo, tbclave, tbsubclave, tbconcepto " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY +  "TESTABLAPF " +
			"WHERE tbclave = ? ";
		
		List<Object> args = new ArrayList<Object>();
		args.add(idClave);
		
		if (!StringUtils.isEmpty(subClave)) {
			sql += "AND tbsubclave = ?";
			try {
				if (Integer.parseInt(subClave) == 0)
					args.add("");
				else
					args.add(subClave);
			} catch (NumberFormatException e) {
				args.add(subClave);
			}
		}
		
		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		
		try {
			listResult = as400Dao.getJdbcTemplate().queryForList(sql, args.toArray());
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		Set<Map<String, Object>> setResult = new HashSet<Map<String,Object>>(listResult);
		
		Tesoreria tesoreria = new Tesoreria();
		for (Map<String, Object> map : setResult) {
			tesoreria.setGrupo(Integer.parseInt(map.get("tbgrupo").toString()));
			tesoreria.setClave(Integer.parseInt(map.get("tbgrupo").toString()));
			tesoreria.setSubClave(map.get("tbsubclave").toString().trim());
			tesoreria.setConcepto(map.get("tbconcepto").toString().trim());
		}
			
		return tesoreria;
	}
}
