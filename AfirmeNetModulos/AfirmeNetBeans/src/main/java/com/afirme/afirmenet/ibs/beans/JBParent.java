/*
 * Esta clase provee atributos comunes a las clases que hereden de esta.
 */
package com.afirme.afirmenet.ibs.beans;

import java.math.BigDecimal;

public class JBParent
{

	protected BigDecimal AMOUNT = new BigDecimal("0");
	protected String ENTITYID = "";
	protected String DEBACC = "";
	protected String VDD = "";
	protected String VMM = "";
	protected String VYY = "";

	public BigDecimal getAMOUNT()
	{
		return AMOUNT;
	}

	public void setAMOUNT(BigDecimal AMOUNT)
	{
		this.AMOUNT = AMOUNT;
	}

	public String getVDD()
	{
		return VDD.toUpperCase().trim();
	}

	public void setVDD(String VDD)
	{
		this.VDD = VDD;
	}

	public String getVMM()
	{
		return VMM.toUpperCase().trim();
	}

	public void setVMM(String VMM)
	{
		this.VMM = VMM;
	}

	public String getVYY()
	{
		return VYY.toUpperCase().trim();
	}

	public void setVYY(String VYY)
	{
		this.VYY = VYY;
	}

	public String getDEBACC()
	{
		return DEBACC;
	}

	public String getENTITYID()
	{
		return ENTITYID;
	}

	public void setDEBACC(String string)
	{
		DEBACC = string;
	}

	public void setENTITYID(String string)
	{
		ENTITYID = string;
	}

}