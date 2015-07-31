package com.afirme.afirmenet.service.transferencia;

import java.math.BigDecimal;

public interface TipoCambioService {

	/**
	 * Regresa el tipo de cambio a la compra
	 * @param CCY
	 * @return
	 */
	public BigDecimal getBuyCCY(String CCY);
	
	/**
	 * Regresa el tipo de cambio a la venta
	 * @param CCY
	 * @return
	 */
	public BigDecimal getSellCCY(String CCY);
}
