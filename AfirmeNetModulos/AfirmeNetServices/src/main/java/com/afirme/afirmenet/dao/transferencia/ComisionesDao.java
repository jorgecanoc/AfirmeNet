package com.afirme.afirmenet.dao.transferencia;

import java.math.BigDecimal;

import com.afirme.afirmenet.enums.ComisionTransaccion;
import com.afirme.afirmenet.ibs.beans.transferencia.Comision;

public interface ComisionesDao {
	public BigDecimal getNationalFee(ComisionTransaccion transaccion, BigDecimal monto);
	public BigDecimal getGeneralPIFee(String paqueteAfirmeNet);
	public Comision getEspecialPIFee(ComisionTransaccion transaccion, String numeroCliente);
}
