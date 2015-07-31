package com.afirme.afirmenet.dao.pagos;

import java.math.BigDecimal;
import java.util.List;

import com.afirme.afirmenet.ibs.databeans.cardif.PagoCardif;
import com.afirme.afirmenet.ibs.databeans.cardif.SeguroCardif;

public interface SegurosPagoDao {

	public SeguroCardif tienePoliza(BigDecimal cliente);
	public List<PagoCardif> consultaCobranza(SeguroCardif oBeanCardif);
	public List<SeguroCardif> consultaComprobantes(String procodeCardif, String contrato, String fechaIni, String fechaFin);
}
