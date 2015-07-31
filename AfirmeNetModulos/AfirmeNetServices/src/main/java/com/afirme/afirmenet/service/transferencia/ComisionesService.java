package com.afirme.afirmenet.service.transferencia;

import java.math.BigDecimal;

import com.afirme.afirmenet.enums.ComisionTransaccion;

public interface ComisionesService {
	public BigDecimal getFee(ComisionTransaccion transaccion, BigDecimal monto, String paqueteAfirmeNet, String numeroCliente);
}