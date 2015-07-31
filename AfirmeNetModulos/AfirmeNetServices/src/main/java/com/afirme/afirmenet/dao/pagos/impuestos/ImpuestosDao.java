package com.afirme.afirmenet.dao.pagos.impuestos;

import com.afirme.afirmenet.model.pagos.impuestos.Impuesto;

public interface ImpuestosDao {
	public void insertaCertificadoDigital(Impuesto impuesto);
	public void insertaImpuesto(Impuesto impuesto);
}
