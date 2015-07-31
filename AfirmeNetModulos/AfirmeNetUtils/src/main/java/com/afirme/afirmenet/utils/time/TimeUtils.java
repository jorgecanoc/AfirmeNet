package com.afirme.afirmenet.utils.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase utilireia para manejar todo lo relacionado con tiempo y fecha
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class TimeUtils {
	static final Logger LOG = LoggerFactory.getLogger(TimeUtils.class);
	public static final String COMPLETE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String CUSTOM_COMPLETE_DATE_FORMAT = "dd-MMM-yy',' HH:mm 'hrs.'";
	public static final SimpleDateFormat completeDateFormat = new SimpleDateFormat(
			COMPLETE_DATE_FORMAT);
	public static final SimpleDateFormat customnCompleteDateFormat = new SimpleDateFormat(
			CUSTOM_COMPLETE_DATE_FORMAT);
	public static final String DB2_DATE_FORMAT = "yyyyMMdd";
	public static final SimpleDateFormat db2DateFormat = new SimpleDateFormat(
			DB2_DATE_FORMAT);
	public static final SimpleDateFormat defaultDateFormat = new SimpleDateFormat(
			DEFAULT_DATE_FORMAT);
	/**
	 * Este formato es para las fechas de 400
	 */
	public static final String AS400_DATE_FORMAT = "yyMMddHHmmss";

	
	public static String getDateFormat(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * Retorna un objeto de tipo fecha dado un valor string y un formateador
	 * para la fecha {@link SimpleDateFormat}, previene la excepcion
	 * {@link ParseException}
	 * 
	 * @param value
	 * @param simpleDateFormat
	 * @return
	 */
	public static Date getDate(String value, SimpleDateFormat simpleDateFormat) {
		Date date = null;
		if (value == null) {
			return null;
		}
		try {
			date = simpleDateFormat.parse(value);

		} catch (ParseException e) {
			LOG.debug("Error al formatear la fecha " + value);
			LOG.error("Error al formatear la fecha " + value, e);
		}
		return date;
	}

	/**
	 * Retorna un objeto de tipo fecha dado un valor en string y un patron de
	 * fecha, previene la excepcion {@link ParseException}
	 * 
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static Date getDate(String value, String pattern) {
		return getDate(value, new SimpleDateFormat(pattern));
	}

	/**
	 * Retorna un objeto de tipo fecha dado un valor en string, previene la
	 * excepcion {@link ParseException}
	 * 
	 * @param value
	 * @return
	 */
	public static Date getDate(String value) {
		return getDate(value, DEFAULT_DATE_FORMAT);
	}

	/**
	 * Metodo que retorna el año del calendario en curso en 2 digitos, este
	 * metodo es invocado desde la validacion de fechas para las transferencias
	 * 
	 * 
	 * @return el año en curso
	 */
	public static String getYY() {
		Calendar calendar = Calendar.getInstance();
		String year = "" + calendar.get(Calendar.YEAR);
		year = year.substring(2);
		return (year);
	}

	/**
	 * Metodo que compara una fecha segmentada contra la actual, este metodo es
	 * invocado desde la validacion de fechas para las transferencias
	 * 
	 * @param YY
	 * @param DD
	 * @param MM
	 * @return
	 */
	public static boolean compareYYMMDD(String YY, String DD, String MM) {

		boolean rerror = false;

		int VYY = Integer.parseInt(YY);
		int VMM = Integer.parseInt(MM);
		int VDD = Integer.parseInt(DD);

		int CYY = Integer.parseInt(getYY());
		int CMM = Integer.parseInt(getMM());
		int CDD = Integer.parseInt(getDD());

		if (CYY > VYY) {
			rerror = true;
		}
		if (CMM > VMM && (CYY > VYY || CYY == VYY)) {
			rerror = true;
		}
		if (CDD > VDD && (CMM > VMM || CMM == VMM) && (CYY > VYY || CYY == VYY)) {
			rerror = true;
		}

		if (VDD == CDD && VMM == CMM && CYY == VYY) {
			rerror = false;
		}

		return (rerror);
	}

	/**
	 * Metodo que retorna el dia del calendario en curso en 2 digitos, este
	 * metodo es invocado desde la validacion de fechas para las transferencias
	 * 
	 * 
	 * @return el año en curso
	 */
	public static String getDD() {

		Calendar calendar = Calendar.getInstance();
		String day = "" + calendar.get(Calendar.DAY_OF_MONTH);

		day = day.length() == 1 ? "0" + day : day;

		return (day);

	}

	/**
	 * Metodo que retorna el mes del calendario en curso en 2 digitos, este
	 * metodo es invocado desde la validacion de fechas para las transferencias
	 * 
	 * 
	 * @return el año en curso
	 */
	public static String getMM() {

		Calendar calendar = Calendar.getInstance();
		String month = "" + (calendar.get(Calendar.MONTH) + 1);

		month = month.length() == 1 ? "0" + month : month;

		return (month);

	}

	/**
	 * Metodo que retorna el minuto en curso
	 * 
	 * @return
	 */
	public static String getSS() {

		Calendar calendar = Calendar.getInstance();
		String minute = "" + calendar.get(Calendar.MINUTE);

		minute = minute.length() == 1 ? "0" + minute : minute;

		return (minute);

	}

	/**
	 * Metodo que retorna la hora en curso
	 * 
	 * @return
	 */
	public static String getHH() {

		Calendar calendar = Calendar.getInstance();
		String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);

		hour = hour.length() == 1 ? "0" + hour : hour;

		return (hour);

	}

	/**
	 * Metodo que retorna el dia de la semana dada una fecha
	 * 
	 * @param m
	 *            mes
	 * @param d
	 *            dia
	 * @param y
	 *            año
	 * @return
	 */
	public static String getDayofWeek(int m, int d, int y) {
		// return an int for any given date (0 for Sunday, ..., 6 for Saturday)

		m -= 2;
		if (m < 1) {
			m += 12;
			y--;
		}
		int cc = y / 100;
		int yy = y % 100;
		int dow = (d + (int) Math.floor(2.6 * m - 0.2) - 2 * cc + yy + yy / 4 + cc / 4) % 7;
		if (dow < 0)
			dow += 7;

		return String.valueOf(dow);
	}

	/**
	 * Metodo que compra una fecha contra la fecha actual
	 * 
	 * @param YY
	 * @param DD
	 * @param MM
	 * @param HH
	 * @param SS
	 * @return
	 */
	public static boolean compareDate(String YY, String DD, String MM,
			String HH, String SS) {

		boolean rerror = false;

		int VYY = Integer.parseInt(YY);
		int VMM = Integer.parseInt(MM);
		int VDD = Integer.parseInt(DD);
		int VHH = Integer.parseInt(HH);
		int VSS = Integer.parseInt(SS);
		int CYY = Integer.parseInt(getYY());
		int CMM = Integer.parseInt(getMM());
		int CDD = Integer.parseInt(getDD());
		int CHH = Integer.parseInt(getHH());
		int CSS = Integer.parseInt(getSS());

		if ((HH.equals("99") && SS.equals("99"))
				|| (HH.equals("00") && SS.equals("00"))) {
			VHH = Integer.parseInt(HH);
			VSS = Integer.parseInt(SS);
			CHH = Integer.parseInt(HH);
			CSS = Integer.parseInt(SS);
		}

		if (CYY > VYY) {
			rerror = true;
		}
		if (CMM > VMM && (CYY > VYY || CYY == VYY)) {
			rerror = true;
		}
		if (CDD > VDD && (CMM > VMM || CMM == VMM) && (CYY > VYY || CYY == VYY)) {
			rerror = true;
		}

		Calendar CDate = new GregorianCalendar(CMM, CDD, CYY);
		Calendar VDate = new GregorianCalendar(VMM, VDD, VYY);

		int VTime = VHH * 100 + VSS;
		int CTime = CHH * 100 + CSS;

		if ((HH.equals("99") && SS.equals("99"))
				|| (HH.equals("00") && SS.equals("00"))) {
			VTime = VHH * 100 + VSS;
			CTime = CHH * 100 + CSS;
		}

		boolean beforeerror = VDate.before(CDate);
		if (beforeerror) {
			// rerror = true;
		}

		boolean equalerror = false;

		// equalerror = VDate.equals(CDate);

		if (VDD == CDD && VMM == CMM && CYY == VYY) {
			equalerror = true;
		}

		if (VTime != 0) {

			if (equalerror && CTime > VTime) {
				rerror = true;
			}
		}

		return (rerror);
	}
}