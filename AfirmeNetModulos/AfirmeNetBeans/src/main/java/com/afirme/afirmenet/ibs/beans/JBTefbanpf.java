/**
 * 
 */
package com.afirme.afirmenet.ibs.beans;

import java.math.BigDecimal;

/**
 * @author 0cdcarguz
 *
 */
public class JBTefbanpf {
	
	private BigDecimal BANCVE;
	private String BANNOM;
	private String BANCEM;
	private String BANCRE;
	
	/**
	 * @return the bANCVE
	 */
	public BigDecimal getBANCVE() {
		return BANCVE;
	}
	/**
	 * @param bANCVE the bANCVE to set
	 */
	public void setBANCVE(BigDecimal bANCVE) {
		BANCVE = bANCVE;
	}
	/**
	 * @return the bANNOM
	 */
	public String getBANNOM() {
		return BANNOM;
	}
	/**
	 * @param bANNOM the bANNOM to set
	 */
	public void setBANNOM(String bANNOM) {
		BANNOM = bANNOM;
	}
	/**
	 * @return the bANCEM
	 */
	public String getBANCEM() {
		return BANCEM;
	}
	/**
	 * @param bANCEM the bANCEM to set
	 */
	public void setBANCEM(String bANCEM) {
		BANCEM = bANCEM;
	}
	/**
	 * @return the bANCRE
	 */
	public String getBANCRE() {
		return BANCRE;
	}
	/**
	 * @param bANCRE the bANCRE to set
	 */
	public void setBANCRE(String bANCRE) {
		BANCRE = bANCRE;
	}
}
