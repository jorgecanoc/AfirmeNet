package com.afirme.afirmenet.ibs.beans;

import java.math.BigDecimal;

public class JBSIC001PF {
	private BigDecimal SICDAT;
	private BigDecimal SICBRN;
	private BigDecimal SICNUM;
	private String SICCVE;
	private BigDecimal SICAMT;
	private BigDecimal SICEXR;
	private BigDecimal SICOAM;
	private String SICOCY;
	private String SICDSC;
	private BigDecimal SICOTC;
	private String SICOPE;
	private String SICIBS;
	private String SICEST;
	
	private BigDecimal amountOrigin;
	private String ccyOrigin;
	
	public BigDecimal getSICDAT() {
		return SICDAT;
	}
	public void setSICDAT(BigDecimal sICDAT) {
		SICDAT = sICDAT;
	}
	public BigDecimal getSICBRN() {
		return SICBRN;
	}
	public void setSICBRN(BigDecimal sICBRN) {
		SICBRN = sICBRN;
	}
	public BigDecimal getSICNUM() {
		return SICNUM;
	}
	public void setSICNUM(BigDecimal sICNUM) {
		SICNUM = sICNUM;
	}
	public String getSICCVE() {
		return SICCVE;
	}
	public void setSICCVE(String sICCVE) {
		SICCVE = sICCVE;
	}
	public BigDecimal getSICAMT() {
		return SICAMT;
	}
	public void setSICAMT(BigDecimal sICAMT) {
		SICAMT = sICAMT;
	}
	public BigDecimal getSICEXR() {
		return SICEXR;
	}
	public void setSICEXR(BigDecimal sICEXR) {
		SICEXR = sICEXR;
	}
	public BigDecimal getSICOAM() {
		return SICOAM;
	}
	public void setSICOAM(BigDecimal sICOAM) {
		SICOAM = sICOAM;
	}
	public String getSICOCY() {
		return SICOCY;
	}
	public void setSICOCY(String sICOCY) {
		SICOCY = sICOCY;
	}
	public String getSICDSC() {
		return SICDSC;
	}
	public void setSICDSC(String sICDSC) {
		SICDSC = sICDSC;
	}
	public BigDecimal getSICOTC() {
		return SICOTC;
	}
	public void setSICOTC(BigDecimal sICOTC) {
		SICOTC = sICOTC;
	}
	public String getSICOPE() {
		return SICOPE;
	}
	public void setSICOPE(String sICOPE) {
		SICOPE = sICOPE;
	}
	public String getSICIBS() {
		return SICIBS;
	}
	public void setSICIBS(String sICIBS) {
		SICIBS = sICIBS;
	}
	public String getSICEST() {
		return SICEST;
	}
	public void setSICEST(String sICEST) {
		SICEST = sICEST;
	}
	public BigDecimal getAmountOrigin() {
		return amountOrigin;
	}
	public void setAmountOrigin(BigDecimal amountOrigin) {
		this.amountOrigin = amountOrigin;
	}
	public String getCcyOrigin() {
		return ccyOrigin;
	}
	public void setCcyOrigin(String ccyOrigin) {
		this.ccyOrigin = ccyOrigin;
	}
	
	public BigDecimal getOrigenAmt(){
		try{
		if(ccyOrigin.equalsIgnoreCase("USD"))
		 	return SICAMT.setScale(2, BigDecimal.ROUND_HALF_UP);
		 else
			 return SICAMT.multiply(SICEXR).setScale(2, BigDecimal.ROUND_HALF_UP);
		}catch(Exception e){return new BigDecimal("0");}
	}
	
	public String getFormattedAmount(){
		try{
			if(ccyOrigin.equalsIgnoreCase("USD"))
			 	return SICAMT.multiply(SICEXR).setScale(2, BigDecimal.ROUND_HALF_UP) + " MXP";
			 else
				 return SICAMT.setScale(2, BigDecimal.ROUND_HALF_UP) + " USD";
			}catch(Exception e){return "";}
	}
	
	public String getTRate(){
		try{
		 	return SICEXR.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
		}catch(Exception e){return "";}
	}

}

