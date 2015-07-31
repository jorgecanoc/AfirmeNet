/*
 * vmpermad
 * Sep 3, 2009
 * Afirme Grupo Financiero
 */
package com.afirme.afirmenet.ibs.objects.parameter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;


public class JOParamOwnAcc extends JOParametric 
{
	private NumberFormat moneyFormatter = new DecimalFormat("'$'###,###,###.00");
	
	// Constantes para el estatus de un registro
	public static final int ESTATUS_ACTIVO = 1;
	public static final int ESTATUS_INACTIVO_SISTEMA = 0;
	public static final int ESTATUS_INACTIVO_USUARIO = 2;
	public static final int ESTATUS_CANCELADO = -1;	
	
	private String currency;
	private int monthlytransnum;
	private double monthlyamount;
	private int dailytransnum_c;
	private double dailyamount_c;
	private int monthlytransnum_c;
	private double monthlyamount_c;
	private int status;
	
	

	/**
	 * @return
	 * @author vmpermad
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public double getMonthlyamount() {
		return monthlyamount;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public int getMonthlytransnum() {
		return monthlytransnum;
	}

	/**
	 * @param string
	 * @author vmpermad
	 */
	public void setCurrency(String string) {
		currency = string;
	}

	/**
	 * @param i
	 * @author vmpermad
	 */
	public void setStatus(int i) {
		status = i;
	}

	/**
	 * @param d
	 * @author vmpermad
	 */
	public void setMonthlyamount(double d) {
		monthlyamount = d;
	}

	/**
	 * @param i
	 * @author vmpermad
	 */
	public void setMonthlytransnum(int i) {
		monthlytransnum = i;
	}
	
	
	public String addMoneyMask (double d)
	{
		String s = moneyFormatter.format(d);
		return s;
	}
	
	public double removeMoneyMask (String money) throws ParseException
	{
		double s = moneyFormatter.parse(money).doubleValue();
		return s;
	}
	
	

	/**
	 * @return
	 * @author vmpermad
	 */
	public double getDailyamount_c() {
		return dailyamount_c;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public int getDailytransnum_c() {
		return dailytransnum_c;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public double getMonthlyamount_c() {
		return monthlyamount_c;
	}

	/**
	 * @return
	 * @author vmpermad
	 */
	public int getMonthlytransnum_c() {
		return monthlytransnum_c;
	}

	/**
	 * @param d
	 * @author vmpermad
	 */
	public void setDailyamount_c(double d) {
		dailyamount_c = d;
	}

	/**
	 * @param i
	 * @author vmpermad
	 */
	public void setDailytransnum_c(int i) {
		dailytransnum_c = i;
	}

	/**
	 * @param d
	 * @author vmpermad
	 */
	public void setMonthlyamount_c(double d) {
		monthlyamount_c = d;
	}

	/**
	 * @param i
	 * @author vmpermad
	 */
	public void setMonthlytransnum_c(int i) {
		monthlytransnum_c = i;
	}

}
