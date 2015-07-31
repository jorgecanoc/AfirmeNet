package com.afirme.afirmenet.model.transferencia;

import java.math.BigDecimal;

import com.afirme.afirmenet.ibs.beans.JBSIC001PF;

public class TransferenciaCuentasPropias extends TransferenciaBase{
	
	private JBSIC001PF cambioDolares;
	private BigDecimal CURCCY = new BigDecimal("0");
	private BigDecimal AMTCCY = new BigDecimal("0");
	private BigDecimal AMTSOU = new BigDecimal("0");
	private String CUR = "";

	/**
	 * @return el cambioDolares
	 */
	public JBSIC001PF getCambioDolares() {
		return cambioDolares;
	}

	/**
	 * @param cambioDolares el cambioDolares a establecer
	 */
	public void setCambioDolares(JBSIC001PF cambioDolares) {
		this.cambioDolares = cambioDolares;
	}

	/**
	 * @return el cURCCY
	 */
	public BigDecimal getCURCCY() {
		return CURCCY;
	}

	/**
	 * @param cURCCY el cURCCY a establecer
	 */
	public void setCURCCY(BigDecimal cURCCY) {
		CURCCY = cURCCY;
	}

	/**
	 * @return el aMTCCY
	 */
	public BigDecimal getAMTCCY() {
		return AMTCCY;
	}

	/**
	 * @param aMTCCY el aMTCCY a establecer
	 */
	public void setAMTCCY(BigDecimal aMTCCY) {
		AMTCCY = aMTCCY;
	}

	/**
	 * @return el aMTSOU
	 */
	public BigDecimal getAMTSOU() {
		return AMTSOU;
	}

	/**
	 * @param aMTSOU el aMTSOU a establecer
	 */
	public void setAMTSOU(BigDecimal aMTSOU) {
		AMTSOU = aMTSOU;
	}

	/**
	 * @return el cUR
	 */
	public String getCUR() {
		return CUR;
	}

	/**
	 * @param cUR el cUR a establecer
	 */
	public void setCUR(String cUR) {
		CUR = cUR;
	}

	
	
}
