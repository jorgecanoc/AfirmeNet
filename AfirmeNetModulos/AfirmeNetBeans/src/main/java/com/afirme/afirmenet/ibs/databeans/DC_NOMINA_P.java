package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;


/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 01/28/2004 09:40:27<br>
 * &nbsp;&nbsp;&nbsp; table = "DC_NOMINA_PBean"
*
* @author Generator
*/
public class DC_NOMINA_P implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The ENTITYID attribute.
	*/
	protected java.lang.String ENTITYID = "";

	/**
	 * Gets the ENTITYID value.
	*/
	public java.lang.String getENTITYID() {
		return ENTITYID.toUpperCase().trim();
	}

	/**
	 * Sets the ENTITYID value.
	*/
	public void setENTITYID(java.lang.String ENTITYID) {
		this.ENTITYID = ENTITYID;
	}
	/**
	 * The NAME attribute.
	*/
	protected java.lang.String NAME = "";

	/**
	 * Gets the NAME value.
	*/
	public java.lang.String getNAME() {
		return NAME.toUpperCase().trim();
	}

	/**
	 * Sets the NAME value.
	*/
	public void setNAME(java.lang.String NAME) {
		this.NAME = NAME;
	}
	/**
	 * The BNKNAME attribute.
	*/
	protected java.lang.String BNKNAME = "";

	/**
	 * Gets the BNKNAME value.
	*/
	public java.lang.String getBNKNAME() {
		return BNKNAME.toUpperCase().trim();
	}

	/**
	 * Sets the BNKNAME value.
	*/
	public void setBNKNAME(java.lang.String BNKNAME) {
		this.BNKNAME = BNKNAME;
	}
	/**
	 * The BNKCODE attribute.
	*/
	protected java.lang.String BNKCODE = "";

	/**
	 * Gets the BNKCODE value.
	*/
	public java.lang.String getBNKCODE() {
		return BNKCODE.toUpperCase().trim();
	}

	/**
	 * Sets the BNKCODE value.
	*/
	public void setBNKCODE(java.lang.String BNKCODE) {
		this.BNKCODE = BNKCODE;
	}
	/**
	 * The ACC attribute.
	*/
	protected java.lang.String ACC = "";

	/**
	 * Gets the ACC value.
	*/
	public java.lang.String getACC() {
		return ACC.toUpperCase().trim();
	}

	/**
	 * Sets the ACC value.
	*/
	public void setACC(java.lang.String ACC) {
		this.ACC = ACC;
	}
	/**
	 * The ACCTYPE attribute.
	*/
	protected java.lang.String ACCTYPE = "";

	/**
	 * Gets the ACCTYPE value.
	*/
	public java.lang.String getACCTYPE() {
		return ACCTYPE.toUpperCase().trim();
	}

	/**
	 * Sets the ACCTYPE value.
	*/
	public void setACCTYPE(java.lang.String ACCTYPE) {
		this.ACCTYPE = ACCTYPE;
	}
	/**
	 * The CCY attribute.
	*/
	protected java.lang.String CCY = "";

	/**
	 * Gets the CCY value.
	*/
	public java.lang.String getCCY() {
		return CCY.toUpperCase().trim();
	}

	/**
	 * Sets the CCY value.
	*/
	public void setCCY(java.lang.String CCY) {
		this.CCY = CCY;
	}
	/**
	 * The REFENUM attribute.
	*/
	protected java.math.BigDecimal REFENUM = new BigDecimal("0");

	/**
	 * Gets the REFENUM value.
	*/
	public java.math.BigDecimal getREFENUM() {
		return REFENUM;
	}

	/**
	 * Sets the REFENUM value.
	*/
	public void setREFENUM(java.math.BigDecimal REFENUM) {
		this.REFENUM = REFENUM;
	}
	/**
	 * The AMOUNT attribute.
	*/
	protected java.math.BigDecimal AMOUNT = new BigDecimal("0");

	/**
	 * Gets the AMOUNT value.
	*/
	public java.math.BigDecimal getAMOUNT() {
		return AMOUNT;
	}

	/**
	 * Sets the AMOUNT value.
	*/
	public void setAMOUNT(java.math.BigDecimal AMOUNT) {
		this.AMOUNT = AMOUNT;
	}
	/**
	 * The FLAG attribute.
	*/
	protected java.lang.String FLAG = "";

	/**
	 * Gets the FLAG value.
	*/
	public java.lang.String getFLAG() {
		return FLAG.toUpperCase().trim();
	}

	/**
	 * Sets the FLAG value.
	*/
	public void setFLAG(java.lang.String FLAG) {
		this.FLAG = FLAG;
	}
	
	protected java.lang.String FechaCreacion = "";
	public java.lang.String getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(java.lang.String data) {
		FechaCreacion = data;
	}
	
	protected java.lang.String STS = "";
	public java.lang.String getSTS() {
		return STS;
	}
	public void setSTS(java.lang.String data) {
		STS = data;
	}
	
	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");
		results.append("\tENTITYID=" + ENTITYID + "\n");
		results.append("\tNAME=" + NAME + "\n");
		results.append("\tBNKNAME=" + BNKNAME + "\n");
		results.append("\tBNKCODE=" + BNKCODE + "\n");
		results.append("\tACC=" + ACC + "\n");
		results.append("\tACCTYPE=" + ACCTYPE + "\n");
		results.append("\tCCY=" + CCY + "\n");
		results.append("\tREFENUM=" + REFENUM + "\n");
		results.append("\tAMOUNT=" + AMOUNT + "\n");
		results.append("\tFLAG=" + FLAG + "\n");
		results.append("\tFechaCreacion=" + FechaCreacion + "\n");

		return results.toString();
	}
	
	public String getFechaOpe()
	   {
		   String rt="";
		   String date = this.FechaCreacion;
		   if(!date.equals(""))
		   {
			   String DD = date.substring(8, 10);
			   String MM = date.substring(5, 7);
			   String YY = date.substring(2, 4);
			   rt = DD + "/" + MM + "/" + YY;
		   }
		   return rt;
	   }
	   
	   public String getHoraOpe()
	   {
		   String rt = "";
		   String date = this.FechaCreacion;
		   if(!date.equals(""))
		   {
			   String HH = date.substring(11, 13);
			   String mm = date.substring(14, 16);
			   rt = HH + ":" + mm;
		   }
		   return rt;
	   }
	   
	   public String getStatus() {
			String rt = "";
			if (this.STS.equals("P")) {
				rt = "Pendiente por Banco";
			}
			if (this.STS.equals("A")) {
				rt = "Autorizada por Banco";
			}
			if (this.STS.equals("W")) {
				rt = "En espera de ser Activada en 3 minutos";
			}
			if (this.STS.equals("D")) {
				rt = "Eliminada";
			}
			return rt;
		}

}