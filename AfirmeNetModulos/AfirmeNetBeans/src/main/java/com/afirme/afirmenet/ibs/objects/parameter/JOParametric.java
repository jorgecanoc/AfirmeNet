/*
 * vmpermad
 * Sep 3, 2009
 * Afirme Grupo Financiero
 */
package com.afirme.afirmenet.ibs.objects.parameter;

import java.util.Date;


public class JOParametric 
{
	public static final String TRANSTYPE_PAGO_SERVICIOS = "28";
	public static final String TRANSTYPE_PROGRAMACION_TDC = "52";
	public static final String TRANSTYPE_INTERNACIONLES_USD = "04";
	public static final String TRANSTYPE_SPEI = "05";
	public static final String TRANSTYPE_INTERNACIONLES_MM = "51";
	public static final String TRANSTYPE_DOMICILIACION = "06";
	public static final String TRANSTYPE_TEF = "09";
	public static final String TRANSTYPE_PAGO_IMPUESTO = "12";
	public static final String TRANSTYPE_TRASPASO_TERCERO = "03";
	public static final String TRANSTYPE_DOMINGO_ELECTRONICO = "37";
	public static final String TRANSTYPE_AHORRO_VOLUNTARIO_AFORE = "46";
	public static final String TRANSTYPE_PAGO_REFERENCIADO = "47";
	public static final String TRANSTYPE_RECARGA_TIEMPO_AIRE = "57";
	public static final String TRANSTYPE_NOMINA = "07";
	public static final String TRANSTYPE_TESORERIA_DF = "49";

	
	private long contract;
	private long account;
	private String transtype;
	private int sertyp;
	private int intertype;
	private String transname;
	private int dailytransnum;
	private double dailyamount;
	private Date opdate;
	
	
	

	/**
	 * @return
	 * @author vmpermad
	 */
	public long getAccount() {
		return account;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public long getContract() {
		return contract;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public double getDailyamount() {
		return dailyamount;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public int getDailytransnum() {
		return dailytransnum;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public int getIntertype() {
		return intertype;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public Date getOpdate() {
		return opdate;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public int getSertyp() {
		return sertyp;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public String getTransname() {
		return transname;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public String getTranstype() {
		return transtype;
	}

	/**
	 * @param l
	 * @author vmpermad
	 */
	public void setAccount(long l) {
		account = l;
	}

	/**
	 * @param l
	 * @author vmpermad
	 */
	public void setContract(long l) {
		contract = l;
	}

	/**
	 * @param d
	 * @author vmpermad
	 */
	public void setDailyamount(double d) {
		dailyamount = d;
	}

	/**
	 * @param i
	 * @author vmpermad
	 */
	public void setDailytransnum(int i) {
		dailytransnum = i;
	}

	/**
	 * @param i
	 * @author vmpermad
	 */
	public void setIntertype(int i) {
		intertype = i;
	}

	/**
	 * @param date
	 * @author vmpermad
	 */
	public void setOpdate(Date date) {
		opdate = date;
	}

	/**
	 * @param i
	 * @author vmpermad
	 */
	public void setSertyp(int i) {
		sertyp = i;
	}

	/**
	 * @param string
	 * @author vmpermad
	 */
	public void setTransname(String string) {
		transname = string;
	}

	/**
	 * @param string
	 * @author vmpermad
	 */
	public void setTranstype(String string) {
		transtype = string;
	}

}
