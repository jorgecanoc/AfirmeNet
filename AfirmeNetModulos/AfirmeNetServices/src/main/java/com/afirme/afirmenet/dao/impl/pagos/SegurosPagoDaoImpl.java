package com.afirme.afirmenet.dao.impl.pagos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.pagos.SegurosPagoDao;
import com.afirme.afirmenet.ibs.databeans.cardif.PagoCardif;
import com.afirme.afirmenet.ibs.databeans.cardif.SeguroCardif;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
@Repository
public class SegurosPagoDaoImpl implements SegurosPagoDao{

	static final Logger LOG = LoggerFactory.getLogger(SegurosPagoDaoImpl.class);

	@Autowired
	private DB2Dao db2Dao;
	@Autowired
	private AS400Dao as400Dao;
	
	@Override
	public SeguroCardif tienePoliza(BigDecimal cliente) {
		SeguroCardif oBeanCardif= null;
		try {
			String sql = "Call "+ AfirmeNetConstants.AS400_LIBRARY + "CONSUL_VSAFIRME(?)";
			Map<String, Object> result = as400Dao.getJdbcTemplate().queryForMap(
					sql, new Object[] { cliente });
			if (result.size() > 0) {
				oBeanCardif= new SeguroCardif();
				oBeanCardif.setPoliza(result.get("SEPOLI").toString());
				oBeanCardif.setCliente(cliente);
				oBeanCardif.setPaquete(result.get("SEPAQ").toString());
				oBeanCardif.setPaqueteDescripcion(result.get("IDDESC").toString());
			}
		} catch (Exception ex) {
			LOG.error("Error al obtener nick de la cuenta: " + ex.getMessage());
		}
		return oBeanCardif;
	}

	@Override
	public List<PagoCardif> consultaCobranza(SeguroCardif oBeanCardif) {
		
		String sql = "Call "+ AfirmeNetConstants.AS400_LIBRARY + "CONCOB_VSAFIRME (?, ?)";
		List<Map<String, Object>> listResultado;
		
		try {
			listResultado = as400Dao.getJdbcTemplate().queryForList(sql, new Object[] {oBeanCardif.getCliente(), oBeanCardif.getPoliza()});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		
		List<PagoCardif> oCobranza= new ArrayList<PagoCardif>();
		
		for (Map<String, Object> map : listResultado) {
			PagoCardif oPago=new PagoCardif();
			oPago.setComentario(map.get("BCDSC").toString());
			oPago.setCuenta(map.get("BCCUEN").toString());
			//oPago.setEstado(rs.getString("SEPOLI"));
			oPago.setFecha(new BigDecimal(map.get("BCFSIS").toString()));
			//oPago.setFecha(rs.getBigDecimal("BCFCOB"));
			oPago.setHora(new BigDecimal(map.get("BCHCOB").toString()));
			oPago.setImporte(new BigDecimal(map.get("BCMONT").toString()));
			oPago.setPoliza(map.get("BCPOLI").toString());
			oCobranza.add(oPago);
		}
		return oCobranza;
	}

	@Override
	public List<SeguroCardif> consultaComprobantes(String procodeCardif, String contrato,
			String fechaIni, String fechaFin) {
		List<SeguroCardif> oBeanCardifList= new ArrayList<SeguroCardif>();
		String sql = "select * from DC_CONFMSG where entityid=? and typtrf=? and integer('20' || pyy || pmm || pdd)>=? and  integer('20' || pyy || pmm || pdd)<=?";
		
		List<Map<String, Object>> listResultado;
		
		try {
			listResultado = db2Dao.getJdbcTemplate().queryForList(sql, new Object[] {contrato, procodeCardif, fechaIni, fechaFin});
		} catch (EmptyResultDataAccessException e) {
			LOG.error("Resultado vacio: " + e.getMessage());
			return null;
		}
		for (Map<String, Object> map : listResultado) {
			SeguroCardif oBeanCardif=new SeguroCardif();
			
			
			oBeanCardifList.add(oBeanCardif);
		}

		return oBeanCardifList;
	}

}
