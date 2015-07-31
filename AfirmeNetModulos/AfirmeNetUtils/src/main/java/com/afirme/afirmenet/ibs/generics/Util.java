package com.afirme.afirmenet.ibs.generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	public Util() {
		super();
	}

	public static String addLeftChar(char ch, int len, String str) {

		for (int i = str.length(); i < len; i++) {
			str = ch + str;
		}

		return (str);
	}

	public static String colorCCY(String num) {

		if (num.startsWith("-"))
			num = "<FONT COLOR=RED>" + num + "</FONT>";
		return num;

	}

	public static String formatAdd(String s1, String s2, String s3) {
		String r = "";

		if (!s1.trim().equals("")) {
			r += s1.trim() + "<br>";
		}
		if (!s2.trim().equals("")) {
			r += s2.trim() + "<br>";
		}
		if (!s3.trim().equals("")) {
			r += s3.trim() + "<br>";
		}
		if (r.trim().equals("")) {
			r = "&nbsp;";
		}
		return r;
	}

	public static String formatBlank(String s) {
		String r = null;

		if (s.trim().equals("&nbsp;")) {
			r = "";
		} else {
			r = s.trim();
		}
		return r;
	}

	public static String formatCell(String s) {
		String r = null;
		String rs = null;
		String ls = null;
		int pos = 0;
		if (s.trim().equals("")) {
			r = "&nbsp;";
		} else {
			s = s.trim();
			while (s.indexOf("'") != -1) {
				pos = s.indexOf("'");
				ls = s.substring(0, pos);
				rs = s.substring(pos + 1, s.length());
				s = ls + "&#39;" + rs;
			}

			while (s.indexOf("\"") != -1) {
				pos = s.indexOf("\"");
				ls = s.substring(0, pos);
				rs = s.substring(pos + 1, s.length());
				s = ls + "&#34;" + rs;
			}
			r = s;
		}
		return r;
	}

	public static String formatDate(String d1, String d2, String d3) {

		d1 = d1.length() == 1 ? "0" + d1 : d1;
		d2 = d2.length() == 1 ? "0" + d2 : d2;
		d3 = d3.length() == 1 ? "0" + d3 : d3;

		if (d1.equals("00") && d2.equals("00") && d3.equals("00"))
			return "&nbsp;";
		else
			return (d1 + "/" + d2 + "/" + d3);

	}

	public static String formatID(String c, String l) {
		String fc = "";
		for (int i = 0; i < (9 - c.length()); i++) {
			fc += "0";
		}
		String fl = "";
		for (int i = 0; i < (4 - l.length()); i++) {
			fl += "0";
		}
		return (fc + c + fl + l);
	}

	public static String formatYear(int y) {

		return formatYear(Integer.toString(y));

	}

	public static String formatYear(String y) {

		if (y.length() < 4) {
			try {
				int aux = Integer.parseInt(y);
				if (aux == 0) {
					y = "2000";
				} else if (aux > 52) {
					y = "19" + y;
				} else {
					y = "20" + justifyRight(y, 2);
				}
			} catch (Exception e) {
				y = "";
			}
		}

		return y;

	}

	public static String justifyLeft(String c, int l) {
		String fc = "";
		for (int i = 0; i < (l - c.length()); i++) {
			fc += "0";
		}
		return (c + fc);
	}

	public static String justifyRight(String c, int l) {
		String fc = "";
		for (int i = 0; i < (l - c.length()); i++) {
			fc += "0";
		}
		return (fc + c);
	}

	public static String leftValue(String s) {

		int pos = 0;
		for (pos = 0; pos < s.length(); pos++) {
			if (s.charAt(pos) == '_')
				break;
		}
		return (s.substring(0, pos));

	}

	public static String rightValue(String s) {

		int pos = 0;
		for (pos = 0; pos < s.length(); pos++) {
			if (s.charAt(pos) == '_')
				break;
		}
		if (pos == s.length())
			return ("0");
		else
			return (s.substring(pos + 1));

	}

	public static String[] splitField(String field, int row, int col) {
		String[] result = new String[row];
		for (int i = 0; i < row; i++) {
			result[i] = "";
		}
		if (field.length() > 0) {
			if (field.length() <= col) {
				result[0] = field;
			} else {
				int enter = field.length() / col;
				double rest = field.length() % col;
				if (rest > 0) {
					enter++;
				}
				for (int i = 0; i < enter; i++) {
					if (i == enter - 1) {
						result[i] = field.substring(i * col, field.length());
					} else {
						result[i] = field.substring(i * col, i * col + col);
					}
				}
			}
		}

		return (result);
	}

	public static String addRightChar(char ch, int len, String str) {

		for (int i = str.length(); i < len; i++) {
			str = str + ch;
		}

		return (str);
	}

	public static String concat(String s[], String ch) {
		String r = "";

		int count = 0;
		while (true) {
			try {
				if (!r.equals("") && !s[count].trim().equals(""))
					r += ch + s[count].trim();
				else
					r += s[count].trim();
				count++;
			} catch (Exception e) {
				break;
			}
		}
		return r;
	}

	public static String concatBR(String s[]) {
		String r = "";

		int count = 0;
		while (true) {
			try {
				if (!r.equals("") && !s[count].trim().equals(""))
					r += "<BR>" + s[count].trim();
				else
					r += s[count].trim();
				count++;
			} catch (Exception e) {
				break;
			}
		}
		return r;
	}

	public static String fcolorDate(String d1, String d2, String d3,
			String mature) {

		d1 = d1.length() == 1 ? "0" + d1 : d1;
		d2 = d2.length() == 1 ? "0" + d2 : d2;
		d3 = d3.length() == 1 ? "0" + d3 : d3;

		String date = "";
		String fdate = "";

		if (d1.equals("00") && d2.equals("00") && d3.equals("00"))
			return "&nbsp;";
		else
			date = d1 + "/" + d2 + "/" + d3;
		if (mature == "R") {
			fdate = "<FONT COLOR=RED>" + date + "</FONT>";
		} else if (mature == "O") {
			fdate = "<FONT COLOR=ORANGE>" + date + "</FONT>";
		} else {
			fdate = d1 + "/" + d2 + "/" + d3;
		}

		return (fdate);

	}

	public static String formatDate(String d) {

		d = d.length() == 5 ? "0" + d : d;
		if (d.length() == 6) {
			String d1 = d.substring(0, 2);
			String d2 = d.substring(2, 4);
			String d3 = d.substring(4, 6);
			return (d1 + "/" + d2 + "/" + d3);
		} else {
			return "";
		}
	}

	public static String trim(String s) {
		return s.trim();
	}

	public static String getCurrentMMDDYY() {

		Calendar calendar = Calendar.getInstance();
		String year = "" + calendar.get(Calendar.YEAR);
		String month = "" + (calendar.get(Calendar.MONTH) + 1);
		String day = "" + calendar.get(Calendar.DAY_OF_MONTH);

		year = year.substring(2);
		month = month.length() == 1 ? "0" + month : month;
		day = day.length() == 1 ? "0" + day : day;

		return (month + "/" + day + "/" + year);

	}

	public static String getCurrentDDMMYY() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String getMM() {

		Calendar calendar = Calendar.getInstance();
		String month = "" + (calendar.get(Calendar.MONTH) + 1);

		month = month.length() == 1 ? "0" + month : month;

		return (month);

	}

	public static String getDD() {

		Calendar calendar = Calendar.getInstance();
		String day = "" + calendar.get(Calendar.DAY_OF_MONTH);

		day = day.length() == 1 ? "0" + day : day;

		return (day);

	}

	public static String getYY() {

		Calendar calendar = Calendar.getInstance();
		String year = "" + calendar.get(Calendar.YEAR);

		year = year.substring(2);

		return (year);

	}

	public static String getHH() {

		Calendar calendar = Calendar.getInstance();
		String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);

		hour = hour.length() == 1 ? "0" + hour : hour;

		return (hour);

	}

	public static String getSS() {

		Calendar calendar = Calendar.getInstance();
		String minute = "" + calendar.get(Calendar.MINUTE);

		minute = minute.length() == 1 ? "0" + minute : minute;

		return (minute);

	}

	public static String getSeconds() {
		Calendar calendar = Calendar.getInstance();

		String second = "" + calendar.get(Calendar.SECOND);

		second = second.length() == 1 ? "0" + second : second;

		return (second);
	}

	public static String getCurrentHHMMSS() {

		Calendar calendar = Calendar.getInstance();
		String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);
		String minute = "" + calendar.get(Calendar.MINUTE);
		String second = "" + calendar.get(Calendar.SECOND);

		hour = hour.length() == 1 ? "0" + hour : hour;
		minute = minute.length() == 1 ? "0" + minute : minute;
		second = second.length() == 1 ? "0" + second : second;

		return (hour + ":" + minute + ":" + second);

	}

	public static String getCurrentHHMMSS2() {
		SimpleDateFormat formatDate = new SimpleDateFormat("HHmmss");
		Date currentTime = new Date();
		String dateString = formatDate.format(currentTime);
		dateString = dateString.length() > 6 ? dateString.substring(0, 6)
				: dateString;
		return dateString;
	}

	public static int getMonth() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		return (month + 1);
	}

	public static int getYear() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		String yearstr = year + "";
		yearstr = yearstr.trim().substring(2);
		return (Integer.parseInt(yearstr.trim()));
	}

	public static int getYear4() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		return (year);
	}

	public static int getDay() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return (day);
	}

	public static int getHour() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return (hour);
	}

	public static int getMinute() {
		Calendar calendar = Calendar.getInstance();
		int min = calendar.get(Calendar.MINUTE);
		return (min);
	}

	public static int getSecond() {
		Calendar calendar = Calendar.getInstance();
		int sec = calendar.get(Calendar.SECOND);
		return (sec);
	}

	public static Timestamp getTimestamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return ts;
	}

	public static String getCurrentYMDHMSS() {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMddHHmmssSS");
		Date currentTime = new Date();
		String dateString = formatDate.format(currentTime);
		dateString = dateString.length() > 16 ? dateString.substring(0, 16)
				: dateString;
		return dateString;
	}

	public static String getCurrentYMD() {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		Date currentTime = new Date();
		String dateString = formatDate.format(currentTime);
		dateString = dateString.length() > 8 ? dateString.substring(0, 8)
				: dateString;
		return dateString;
	}

	public static String getCurrentHMS() {
		SimpleDateFormat formatDate = new SimpleDateFormat("HHmmss");
		Date currentTime = new Date();
		String dateString = formatDate.format(currentTime);
		dateString = dateString.length() > 6 ? dateString.substring(0, 6)
				: dateString;
		return dateString;
	}

	public static String formatStr(String mask, double value) {
		DecimalFormat fmt = new DecimalFormat(mask);
		return fmt.format(value);
	}

	public static String formatStr(String mask, String value) {
		double dv = Double.parseDouble(value);
		return formatStr(mask, dv);
	}

	public static int parseInt(String value) {
		int iv;
		try {
			iv = Integer.parseInt(value);
		} catch (Exception e) {
			iv = 0;
		}
		return iv;
	}

	/**
	 * Determina si una cadena es un numero entero de una cierta longitud de
	 * digitos
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNumber(String value) {
		boolean isNumber = true;

		String patron = "\\d+";

		Pattern pattern = Pattern.compile(patron);
		Matcher matcher = pattern.matcher(value);

		if (!matcher.matches()) {
			isNumber = false;
		}

		return isNumber;
	}

	/**
	 * Determina si una cadena es un numero entero de una cierta longitud de
	 * digitos
	 * 
	 * @param value
	 * @return
	 */
	public static boolean validarLongitud(String value, int longitud) {
		boolean longitudOK = true;

		if (value.length() != longitud) {
			longitudOK = false;
		}

		return longitudOK;
	}

	public static String addDot(String number) {
		String result = "";

		if (number.length() == 1) {
			number = number + "00";
		}
		result = number.substring(0, number.length() - 2) + "."
				+ number.substring(number.length() - 2);
		return (result);
	}

	public static String formatCCY(String num) {
		String num2 = "";
		String result = "";
		String sign = "";
		if (num.startsWith("-")) {
			sign = num.substring(0, 1);
			num = num.substring(1);
		}
		num = takeComa(num);

		int posi = num.indexOf(".");
		if (posi > -1) {
			int x = num.length();
			num2 = num.substring(posi, x);
			num2 = num2.length() < 3 ? (num2 + "0") : num2;
			num = num.substring(0, posi);
		} else {
			num2 = ".00";
		}
		int count = 0;
		int y = num.length() - 1;
		for (int x = y; x > -1; x--) {
			char nx = num.charAt(x);
			result = nx + result;
			++count;
			if (count == 3 || count == 6 || count == 9 || count == 12) {
				if (x > 0) {
					result = "," + result;
				} // add commas
			}
		}

		result = sign + result + num2;
		return (result);
	}

	/* FORMATEO DE CANTIDADES CON "N" DECIMALES */
	public static String formatCCY(String num, int N) {
		String num2 = "";
		String result = "";
		String sign = "";
		if (num.startsWith("-")) {
			sign = num.substring(0, 1);
			num = num.substring(1);
		}
		num = takeComa(num);

		int posi = num.indexOf(".");
		if (posi > -1) {
			int x = num.length();
			num2 = num.substring(posi, x);
			num2 = num2.length() < N + 1 ? (num2 + "00000").substring(0, N + 1)
					: num2;
			num = num.substring(0, posi);
		} else {
			num2 = ".00000";
		}
		num2 = num2.length() > N ? num2.substring(0, N + 1) : num2;

		int count = 0;
		int y = num.length() - 1;
		for (int x = y; x > -1; x--) {
			char nx = num.charAt(x);
			result = nx + result;
			++count;
			if (count == 3 || count == 6 || count == 9 || count == 12) {
				if (x > 0) {
					result = "," + result;
				} // add commas
			}
		}

		result = sign + result + num2;
		return (result);
	}

	public static String formatCCYint(String num) {
		String result = "";
		String sign = "";
		if (num.startsWith("-")) {
			sign = num.substring(0, 1);
			num = num.substring(1);
		}
		num = takeComa(num);

		int count = 0;
		int y = num.length() - 1;
		for (int x = y; x > -1; x--) {
			char nx = num.charAt(x);
			result = nx + result;
			++count;
			if (count == 3 || count == 6 || count == 9 || count == 12) {
				if (x > 0) {
					result = "," + result;
				} // add commas
			}
		}

		result = sign + result;
		return (result);
	}

	public static String getDate(String FDate) {
		String rdateString = "";

		if (FDate.equals("1")) {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date currentTime_1 = new Date();
			rdateString = formatter.format(currentTime_1);
		}
		if (FDate.equals("2")) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			Date currentTime_1 = new Date();
			rdateString = formatter.format(currentTime_1);
		}

		return rdateString;
	}

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

	public static boolean compareYYMMDDYYMMDD(String YY, String DD, String MM,
			String YY2, String DD2, String MM2) {

		boolean rerror = false;

		int VYY = Integer.parseInt(YY);
		int VMM = Integer.parseInt(MM);
		int VDD = Integer.parseInt(DD);

		int CYY = Integer.parseInt(YY2);
		int CMM = Integer.parseInt(MM2);
		int CDD = Integer.parseInt(DD2);

		if (CYY < VYY) {
			rerror = true;
		}
		if (CMM < VMM && (CYY < VYY || CYY == VYY)) {
			rerror = true;
		}
		if (CDD < VDD && (CMM < VMM || CMM == VMM) && (CYY < VYY || CYY == VYY)) {
			rerror = true;
		}

		if (VDD == CDD && VMM == CMM && CYY == VYY) {
			rerror = true;
		}

		return (rerror);
	}

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

	public static String takeCero(String number) {
		String result = "";
		boolean scero = false;
		int lgt = 0;

		scero = number.startsWith("0");
		result = number;
		lgt = number.length();
		while (scero) {
			result = result.substring(1, lgt);
			scero = result.startsWith("0");
			lgt = result.length();
		}
		return (result);
	}

	public static String takeALL(String number) {
		String result = "";
		int posi = 0;

		posi = number.indexOf("/");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf("/");
				number = result;
			}
		} else {
			result = number;
		}

		posi = number.indexOf("'");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf("'");
				number = result;
			}
		} else {
			result = number;
		}

		posi = number.indexOf("\"");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf("\"");
				number = result;
			}
		} else {
			result = number;
		}

		posi = number.indexOf("~");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf("~");
				number = result;
			}
		} else {
			result = number;
		}

		posi = number.indexOf(",");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf(",");
				number = result;
			}
		} else {
			result = number;
		}

		return (result);
	}

	public static String formatCCY(String num, String CCYS) {
		String num2 = "";
		String result = "";
		String sign = "";
		if (num.startsWith("-")) {
			sign = num.substring(0, 1);
			num = num.substring(1);
		}
		int posi = num.indexOf(".");
		if (posi > -1) {
			int x = num.length();
			num2 = num.substring(x - 3, x);
			num = num.substring(0, x - 3);
		} else {
			num2 = ".00";
		}
		int count = 0;
		int y = num.length() - 1;
		for (int x = y; x > -1; x--) {
			char nx = num.charAt(x);
			result = nx + result;
			++count;
			if (count == 3 || count == 6 || count == 9 || count == 12) {
				if (x > 0) {
					result = "," + result;
				} // add commas
			}
		}

		result = sign + result + num2 + " " + CCYS;
		return (result);
	}

	public static String formatTime(String t) {

		if (t.length() == 5)
			t = "0" + t;

		if (t.length() == 6) {
			String t1 = t.substring(0, 2);
			String t2 = t.substring(2, 4);
			String t3 = t.substring(4, 6);

			return (t1 + ":" + t2 + ":" + t3);
		} else
			return t;

	}

	public static String getRefNum() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
		Date currentTime_1 = new Date();
		String rdateString = formatter.format(currentTime_1);
		return rdateString;
	}

	public static String takeComa(String number) {
		String result = "";
		int posi = number.indexOf(",");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf(",");
				number = result;
			}
		} else {
			result = number;
		}
		return (result);
	}

	public static String takeCh(String number, String Ch) {
		String result = "";
		int posi = number.indexOf(Ch);
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf(Ch);
				number = result;
			}
		} else {
			result = number;
		}
		return (result);
	}

	public static String takeSS(String number) {
		String result = "";
		int posi = number.indexOf("/");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf("/");
				number = result;
			}
		} else {
			result = number;
		}
		return (result);
	}

	public static String takeBLANK(String number) {
		String result = "";
		int posi = number.indexOf(" ");
		if (posi > -1) {
			while (posi > -1) {
				result = number.substring(0, posi);
				result = result + number.substring(posi + 1);
				posi = result.indexOf(" ");
				number = result;
			}
		} else {
			result = number;
		}
		return (result);
	}

	public static String takeDot(String number) {
		String result = "";
		int posi = number.indexOf(".");
		if (posi > -1) {
			result = number.substring(0, posi);
			result = result + number.substring(posi + 1);
		} else {
			result = number + "00";
		}
		return (result);
	}

	public static String getData(String TAX, String VAL) {

		String result = "";

		int posi1 = TAX.indexOf(VAL);

		if (posi1 != -1) {

			posi1 = posi1 + VAL.length();

			int posi2 = TAX.indexOf("|", posi1);
			result = takeComa(TAX.substring(posi1, posi2));

		}
		return (result);
	}

	public static String getDataCero(String TAX, String VAL) {

		String result = "0";

		int posi1 = TAX.indexOf(VAL);

		if (posi1 != -1) {

			posi1 = posi1 + VAL.length();

			int posi2 = TAX.indexOf("|", posi1);
			result = takeComa(TAX.substring(posi1, posi2));

		}

		if (result.equals("")) {
			result = "0";
		}
		return (result);
	}

	public static String getYYYYMMDD() {
		String YYYY = String.valueOf(Util.getYear4());
		String MMMM = String.valueOf(Util.getMonth());
		while (MMMM.length() < 2) {
			MMMM = "0" + MMMM;
		}
		String DDDD = String.valueOf(Util.getDay());
		while (DDDD.length() < 2) {
			DDDD = "0" + DDDD;
		}
		String GDT = YYYY + MMMM + DDDD;

		return GDT;
	}

	public static String getKEYVAL(int KEYVAL) {

		String RTNVAL = "";

		switch (KEYVAL) {
		case 1:
			RTNVAL = "A";
			break;
		case 2:
			RTNVAL = "B";
			break;
		case 3:
			RTNVAL = "C";
			break;
		case 4:
			RTNVAL = "D";
			break;
		case 5:
			RTNVAL = "E";
			break;
		case 6:
			RTNVAL = "F";
			break;
		case 7:
			RTNVAL = "G";
			break;
		case 8:
			RTNVAL = "H";
			break;
		case 9:
			RTNVAL = "I";
			break;
		case 10:
			RTNVAL = "J";
			break;
		case 11:
			RTNVAL = "K";
			break;
		case 12:
			RTNVAL = "L";
			break;
		case 13:
			RTNVAL = "M";
			break;
		case 14:
			RTNVAL = "N";
			break;
		case 15:
			RTNVAL = "O";
			break;
		case 16:
			RTNVAL = "P";
			break;
		case 17:
			RTNVAL = "Q";
			break;
		case 18:
			RTNVAL = "R";
			break;
		case 19:
			RTNVAL = "S";
			break;
		case 20:
			RTNVAL = "T";
			break;
		case 21:
			RTNVAL = "U";
			break;
		case 22:
			RTNVAL = "V";
			break;
		case 23:
			RTNVAL = "W";
			break;
		case 24:
			RTNVAL = "X";
			break;
		case 25:
			RTNVAL = "Y";
			break;
		case 26:
			RTNVAL = "Z";
			break;
		case 27:
			RTNVAL = "1";
			break;
		case 28:
			RTNVAL = "2";
			break;
		case 29:
			RTNVAL = "3";
			break;
		case 30:
			RTNVAL = "4";
			break;
		case 31:
			RTNVAL = "5";
			break;
		case 32:
			RTNVAL = "6";
			break;
		case 33:
			RTNVAL = "7";
			break;
		case 34:
			RTNVAL = "8";
			break;
		case 35:
			RTNVAL = "9";
			break;
		}

		return (RTNVAL);
	}

	public static BigDecimal SumNum(String num) {

		BigDecimal rnum = new BigDecimal("0");

		for (int x = 0; x < num.length(); x++) {
			char nx = num.charAt(x);
			String nnum = nx + "";
			BigDecimal addn = new BigDecimal(nnum);
			rnum = rnum.add(addn);
		}

		return rnum;

	}

	public static String getRandom(int NCHAR) {
		String PASSWORD = "";
		String PASVAL = "";

		for (int i = 0; i < NCHAR; i++) {
			Random generator = new Random();
			int NUM = generator.nextInt(34) + 1; // random number for
													// letter(A-Z) and
													// numbers(1-9)
			PASVAL = getKEYVAL(NUM); // getting the letter or number for that
										// random number

			while (PASSWORD.indexOf(PASVAL) != -1) {
				NUM = generator.nextInt(34) + 1;
				PASVAL = getKEYVAL(NUM); // getting the letter or number for
											// that random number
			}

			PASSWORD = PASSWORD + PASVAL;
		}

		return PASSWORD;
	}

	public static String getDataTax(String TAX, String VAL) {

		String result = "";
		TAX = TAX.replace('"', '*');

		int posi1 = TAX.indexOf(VAL);

		if (posi1 != -1) {

			posi1 = posi1 + VAL.length();

			int posi2 = TAX.indexOf("|", posi1);
			// result = takeComa(TAX.substring(posi1, posi2));
			result = TAX.substring(posi1, posi2);

		}
		TAX = TAX.replace('*', '"');
		result = result.replace('*', '"');

		return (result);
	}

	public static String formatCCYD(String num, String CCYS) {
		String num2 = "";
		String result = "";
		String sign = "";
		if (num.startsWith("-")) {
			sign = num.substring(0, 1);
			num = num.substring(1);
		}
		int posi = num.indexOf(".");
		if (posi > -1) {
			int x = num.length();
			num2 = num.substring(x - 3, x);
			num = num.substring(0, x - 3);
		}
		// else {
		// num2 = ".00";
		// }
		int count = 0;
		int y = num.length() - 1;
		for (int x = y; x > -1; x--) {
			char nx = num.charAt(x);
			result = nx + result;
			++count;
			if (count == 3 || count == 6 || count == 9 || count == 12) {
				if (x > 0) {
					result = "," + result;
				} // add commas
			}
		}

		result = sign + result + num2 + " " + CCYS;
		return (result);
	}

	public static int[] getRandomKeys(int KEYS) {
		int[] PASSWORDAR = new int[KEYS];
		String PASSWORDREF = "";
		String PASVAL = "";

		for (int i = 0; i < KEYS; i++) {
			Random generator = new Random();
			int NUM = generator.nextInt(30) + 1;
			PASVAL = "" + NUM;

			while (PASSWORDREF.indexOf(PASVAL) != -1) {
				NUM = generator.nextInt(30) + 1;
				PASVAL = "" + NUM;
			}
			PASSWORDREF = PASSWORDREF + "-" + PASVAL;
			PASSWORDAR[i] = NUM;
		}

		return PASSWORDAR;
	}

	public static String getYYMDHMS() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentTime = new Date();
		String fechaHoy = formatter.format(currentTime);
		return fechaHoy;
	}

	public static String getYYMDHMsS() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");
		Date currentTime = new Date();
		String fechaHoy = formatter.format(currentTime);
		return fechaHoy;
	}

	public static String getHHMMSS() {

		Calendar calendar = Calendar.getInstance();
		String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);
		String minute = "" + calendar.get(Calendar.MINUTE);
		String second = "" + calendar.get(Calendar.SECOND);

		hour = hour.length() == 1 ? "0" + hour : hour;
		minute = minute.length() == 1 ? "0" + minute : minute;
		second = second.length() == 1 ? "0" + second : second;

		return (hour + minute + second);

	}

	private static String validNum = "0123456789"; // NUMERICOS
	private static String validNom = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÜÑ0123456789',.-#&() "; // NOMBRES
	private static String validNomC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789. "; // NOMBRE
																				// CORTO
																				// DE
																				// TARJETA

	public static boolean validStr(String Str, String N) {
		for (int i = 0; i < Str.length(); i++) {
			if (N.equals("1")) { // SOLO NUMEROS
				if (validNum.indexOf(Str.substring(i, i + 1)) < 0)
					return false;
			}
			if (N.equals("2")) { // DESCRIPCION
				if (validNom.indexOf(Str.substring(i, i + 1)) < 0)
					return false;
			}
		}
		return true;
	}

	public static String remInValStr(String Str, String N) {
		for (int i = 0; i < Str.length(); i++) {
			if (N.equals("3")) { // NOMBRE CORTO
				if (validNomC.indexOf(Str.substring(i, i + 1)) < 0) {
					char cI = Str.charAt(i);
					Str = Str.replace(cI, ' ');
				}
			}
		}
		Str = remStr2(Str);
		return Str;
	}

	public static String remStr2(String Str) {
		while (Str.indexOf("  ") > 0) {
			int iPos = Str.indexOf("  ");
			Str = Str.substring(0, iPos) + Str.substring(iPos + 1);
		}
		return Str;
	}

	public static String quitaCerosIzq(String number) {
		while (!number.equals("0") && number.startsWith("0"))
			number = number.substring(1);
		return number;
	}

	public static ArrayList validaCampoNumericoArchivo(String datoCampo) {
		boolean error = true;
		String datoCorregido = "";
		ArrayList resultado = new ArrayList();
		// Primero se eliminan los espacios en blanco
		datoCampo = datoCampo.trim();
		// Se valida que el campo sea numerico
		try {
			BigInteger bi = new BigInteger(datoCampo);
			// Se quitan los ceros a la izquierda
			datoCorregido = quitaCerosIzq(datoCampo);
			error = false;
		} catch (NumberFormatException nfe) {
		}
		resultado.add(new Boolean(error));
		resultado.add(datoCorregido);
		return resultado;
	}

	public static ArrayList validaCampoNumericoArchivoConCeros(String datoCampo) {
		boolean error = true;
		String datoCorregido = "";
		ArrayList resultado = new ArrayList();
		// Primero se eliminan los espacios en blanco
		datoCorregido = datoCampo.trim();
		// Se valida que el campo sea numerico
		try {
			BigInteger bi = new BigInteger(datoCorregido);
			error = false;
		} catch (NumberFormatException nfe) {
		}
		resultado.add(new Boolean(error));
		resultado.add(datoCorregido);
		return resultado;
	}

	public static String getRefNumMili() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssSSS");
		Date currentTime_1 = new Date();
		String rdateString = formatter.format(currentTime_1);
		return rdateString;
	}

	public static String getMes(String DATE) { // Consulta TC
		String rt = "";
		String MM = "";
		String DD = "";

		MM = DATE.substring(0, 2);
		int mes = Integer.parseInt(MM.trim());
		DD = DATE.substring(2, 4);

		switch (mes) {
		case 1:
			rt = "Enero";
			break;
		case 2:
			rt = "Febrero";
			break;
		case 3:
			rt = "Marzo";
			break;
		case 4:
			rt = "Abril";
			break;
		case 5:
			rt = "Mayo";
			break;
		case 6:
			rt = "Junio";
			break;
		case 7:
			rt = "Julio";
			break;
		case 8:
			rt = "Agosto";
			break;
		case 9:
			rt = "Septiembre";
			break;
		case 10:
			rt = "Octubre";
			break;
		case 11:
			rt = "Noviembre";
			break;
		case 12:
			rt = "Diciembre";
			break;
		}
		rt = rt + " " + DD;

		return rt;
	}

	/*
	 * 20080207.vmpm Método que quita el caracter especial indicado en regex
	 * (regular expressions), se reemplaza por el string indicado en replace,
	 * del string
	 */
	public static String dropSpecialCharacter(String regex, String replace,
			String data) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(data);
		data = m.replaceAll(replace);
		return data;
	}

	public static String getNombreMes(int numMes) {
		String rt = "";
		switch (numMes) {
		case 1:
			rt = "Enero";
			break;
		case 2:
			rt = "Febrero";
			break;
		case 3:
			rt = "Marzo";
			break;
		case 4:
			rt = "Abril";
			break;
		case 5:
			rt = "Mayo";
			break;
		case 6:
			rt = "Junio";
			break;
		case 7:
			rt = "Julio";
			break;
		case 8:
			rt = "Agosto";
			break;
		case 9:
			rt = "Septiembre";
			break;
		case 10:
			rt = "Octubre";
			break;
		case 11:
			rt = "Noviembre";
			break;
		case 12:
			rt = "Diciembre";
			break;
		default:
			rt = "";
		}

		return rt;
	}

	// Metodo que recibe una cadena (Domicilio), y separa la direccion en calle
	// - numero exterior - numero interior
	// Regresa arreglo de String de 3 posiciones , en la primera posicion la
	// calle, en la segunda el numero exterior , en la tercera el numero
	// interior.
	public static String[] splitAddress(String address) {
		// posicion 0 = indice del key
		// posicion 1 = indice del posible numero
		int exteriorIndexes[] = new int[2];
		int interiorIndexes[] = new int[2];
		String results[] = new String[3];

		// Preparacion de la cadena
		address = address.trim();
		address = address.toUpperCase();

		// Se remueven espacios en blanco contiguos
		Pattern pat = Pattern.compile(" +");
		Matcher mat = pat.matcher(address);
		address = mat.replaceAll(" ");

		// Iniciamos buscando el numero interior en la cadena original.
		interiorIndexes = findInteriorNumber(address);

		// Existe un numero interior
		if (interiorIndexes != null) {
			// Se almacena la direccion sin el key (int,int.,interior, etc)
			results[0] = address.substring(0, interiorIndexes[0]);

			// Obtenemos el indice del espacio en blanco posterior a la cadena
			// que representa al numero
			int indexOfSpace = address.indexOf(" ", interiorIndexes[1]);

			// Si no hay mas espacios en blanco, significa que 1- el key es la
			// ultima palabra o 2-El numero esta pegado al key y no hay mas
			// palabras.
			if (indexOfSpace == -1) {
				indexOfSpace = address.length();
			}

			// Almacenamos la cadena que le sigue al key encontrado
			String auxWord = address
					.substring(interiorIndexes[1], indexOfSpace);

			// Comprobamos si es un numero interior.
			if (Pattern.matches("[0-9]+", auxWord)
					|| Pattern.matches("[0-9]+-\\w+", auxWord)
					|| Pattern.matches("[0-9]+-\\w+-\\w+", auxWord)
					|| Pattern.matches("[0-9]+\\w+", auxWord)) {
				results[2] = address
						.substring(interiorIndexes[1], indexOfSpace);
			} else {
				results[0] = address;
				results[2] = "";
			}

			// Se almacena en la direccion lo que seguia del numero exterior.
			results[0] += address.substring(indexOfSpace, address.length());
		} else {
			results[0] = address;
			results[2] = "";
		}

		// Una vez que se elimina el key de numero interior y tenemos almacenado
		// el dato, la direccion se renueva
		address = new String(results[0]);

		// Buscamos el numero exterior.
		exteriorIndexes = findExteriorNumber(address);

		// Existe una referencia a numero exterior
		if (exteriorIndexes != null) {
			// Si la direccion incluye un numero
			if (exteriorIndexes[1] != -1) {
				// Se almacena la direccion sin el key
				results[0] = address.substring(0, exteriorIndexes[0]);

				// Obtenemos el indice del espacio en blanco posterior a la
				// cadena que representa al numero
				int indexOfSpace = address.indexOf(" ", exteriorIndexes[1]);

				// Si no hay un espacio en blanco, se toma como indice el final
				// de la cadena.
				if (indexOfSpace == -1) {
					indexOfSpace = address.length();
				}

				// Se almacena unicamente el numero
				results[1] = address
						.substring(exteriorIndexes[1], indexOfSpace);

				// Se almacena en la direccion lo que seguia del numero
				// exterior.
				results[0] += address.substring(indexOfSpace, address.length());
			} else {
				// En la direccion se especifica que no tiene numero (ejem
				// "Av Revolucion S/N"
				results[0] = address;
				results[1] = "SIN NUMERO";
			}
		} else {
			// La cadena no contiene referencia explicita al numero. Si aparecen
			// numeros, se toma el primero de la cadena y se termina la
			// busqueda.
			String[] words = address.split(" ");
			boolean numberFound = false;
			for (int i = 0; i < words.length; i++) {
				if (Pattern.matches("[0-9]+", words[i])
						|| Pattern.matches("[0-9]+-\\w+", words[i])
						|| Pattern.matches("[0-9]+-\\w+-\\w+", words[i])
						|| Pattern.matches("[0-9]+\\w+", words[i])) {
					int index = address.indexOf(words[i]);

					// El numero se encuentra en algun lugar de la cadena
					// excepto al inicio
					if (index != 0) {
						// Obtenemos la cadena hasta donde aparece el numero
						results[0] = address.substring(0, index - 1);
						// Obtenemos el indice del espacio en blanco posterior a
						// la cadena que representa al numero
						int indexOfSpace = address.indexOf(" ", index);
						// Si no hay un espacio en blanco, se toma como indice
						// el final de la cadena.
						if (indexOfSpace == -1) {
							indexOfSpace = address.length();
						}
						// Obtenemos el numero exterior.
						results[1] = address.substring(index, indexOfSpace);
						// Se almacena en la direccion lo que seguia del numero
						// exterior.
						results[0] += address.substring(indexOfSpace,
								address.length());
						numberFound = true;
						break;
					} else {
						// El numero esta en el inicio de la cadena
						int indexOfSpace = address.indexOf(" ", index);
						// Si no hay un espacio en blanco, se toma como indice
						// el final de la cadena.
						if (indexOfSpace == -1) {
							indexOfSpace = address.length();
						}
						// Obtenemos la direccion sin el numero
						results[0] = address.substring(indexOfSpace,
								address.length());
						// Obtenemos el numero exterior
						results[1] = address.substring(0, indexOfSpace);
						numberFound = true;
						break;
					}
				}
			}

			if (!numberFound) {
				// No se encontro un numero
				results[0] = address;
				results[1] = "";
			}

		}

		return results;
	}

	/**
	 * Funcion que regresa un arreglo de enteros de 2 posiciones, en donde se
	 * almacena: 1-El indice de la cadena donde aparece la referencia al numero
	 * (cadena '#','No.','num','numero',etc) 2-El indice de la cadena donde
	 * aparece el numero exterior. Si la direccion no tiene numero exterior
	 * (ejem: "Avenida Juarez PTE Sin Numero"),en el arreglo se almacena: 1-El
	 * indice de la cadena donde aparece la referencia al "no numero" ('sin
	 * numero','s/n','sin num',etc) 2-Un valor de -1 para indicar que no hay un
	 * numero exterior.
	 */
	public static int[] findExteriorNumber(String address) {
		int index;
		int indexes[] = new int[2];
		String[] missingNumberKeys = { "SIN NUMERO", "S/N", "SIN NUM", "S N ",
				" SN" };
		String[] normalNumberKeys = { "#", "NO.", "N°" };
		String[] recursiveNumberKeys = { " NO", "NUMERO", "NUM.", "NUM" };

		// Recorremos la lista de keys definidos para "sin numero", si se
		// encuentra uno,regresamos el arreglo y salimos del metodo.
		for (int i = 0; i < missingNumberKeys.length; i++) {
			index = address.indexOf(missingNumberKeys[i]);

			if (index != -1) {
				indexes[0] = index;
				indexes[1] = -1;
				return indexes;
			}
		}

		// Si la cadena no es "sin numero", buscamos el numero exterior con la
		// funcion checkNormal.
		for (int i = 0; i < normalNumberKeys.length; i++) {
			indexes = checkNormal(address, normalNumberKeys[i]);
			if (indexes != null) {
				return indexes;
			}
		}

		// Buscamos el numero exterior con la funcion recursiveSearch.
		for (int i = 0; i < recursiveNumberKeys.length; i++) {
			if (address.indexOf(recursiveNumberKeys[i]) != -1) {
				return recursiveSearch(address, recursiveNumberKeys[i]);
			}
		}

		// Si no se encontro un numero exterior, o no se indica que es
		// "sin numero", regresamos nulo.
		return null;
	}

	/**
	 * Funcion que regresa un arreglo de enteros de 2 posiciones, en donde se
	 * almacena: 1-El indice de la cadena donde aparece la referencia al numero
	 * (cadena int,interior,etc) 2-El indice de la cadena donde aparece el
	 * numero interior.
	 */
	public static int[] findInteriorNumber(String address) {
		int index;
		int indexes[] = new int[2];
		String[] normalNumberKeys = { "INTERIOR", "INT." };
		String[] recursiveNumberKeys = { " INT" };

		// Buscamos el numero interior con la funcion checkNormal.
		for (int i = 0; i < normalNumberKeys.length; i++) {
			indexes = checkNormal(address, normalNumberKeys[i]);
			if (indexes != null) {
				return indexes;
			}
		}

		// Buscamos el numero interior con la funcion recursiveSearch.
		for (int i = 0; i < recursiveNumberKeys.length; i++) {
			if (address.indexOf(recursiveNumberKeys[i]) != -1) {
				return recursiveSearch(address, recursiveNumberKeys[i]);
			}
		}

		return null;
	}

	/**
	 * Funcion que busca en la cadena address la primera aparicion del
	 * key.Regresa un arreglo de enteros que almacena: 1-La posicion en la
	 * cadena del key 2-La posicion de la cadena que le sigue al key (ignorando
	 * el espacio en blanco, si hubiera)
	 */
	public static int[] checkNormal(String address, String key) {
		int indexes[] = new int[2];
		char blankSpace = ' ';

		if (address.indexOf(key) != -1) {
			indexes[0] = address.indexOf(key);

			int afterKeyPosition = indexes[0] + key.length();

			if (!(afterKeyPosition == address.length())) {
				// Si tenemos un espacio despues del key,el indice se incrementa
				// en uno para obtener la posicion del numero
				if (address.charAt(afterKeyPosition) == ' ') {
					indexes[1] = afterKeyPosition + 1;
				} else {
					// Numero pegado al key
					indexes[1] = afterKeyPosition;
				}
			} else {
				return null;
			}
			return indexes;
		} else {
			return null;
		}
	}

	/**
   
   */
	public static int[] recursiveSearch(String address, String key) {
		int indexes[] = new int[2];
		int actualMatchIndex = -1;
		String addressNumber;

		// Buscamos en la cadena las apariciones del key
		Pattern pat = Pattern.compile(key);
		Matcher mat = pat.matcher(address);

		// Mientras haya palabras que contengan el key, se busca si es una
		// abreviatura
		while (mat.find()) {
			// Obtenemos el indice del key actual tomando como referencia la
			// posicion del key anterior (si es que lo hay)
			actualMatchIndex = address.indexOf(key, actualMatchIndex + 1);

			// Si despues del key no hay nada.
			if (actualMatchIndex + key.length() == address.length()) {
				return null;
			}

			// Si despues del key hay un espacio
			if (address.substring(actualMatchIndex + key.length(),
					actualMatchIndex + key.length() + 1).equals(" ")) {
				// Obtenemos el indice del espacio en blanco posterior a la
				// cadena que representa al numero
				int indexOfSpace = address.indexOf(" ",
						actualMatchIndex + key.length() + 1);

				// Si no hay un espacio en blanco, se toma como indice el final
				// de la cadena.
				if (indexOfSpace == -1) {
					indexOfSpace = address.length();
				}

				// Obtenemos la cadena posterior al key actual encontrado.
				addressNumber = address.substring(
						actualMatchIndex + key.length() + 1, indexOfSpace);

				// Si cumple el formato:
				// 1-solo numeros (1153) o
				// 2-numeros y letras (1153-A), entonces es el numero que
				// buscamos.
				if (Pattern.matches("[0-9]+", addressNumber)
						|| Pattern.matches("[0-9]+-\\w+", addressNumber)
						|| Pattern.matches("[0-9]+-\\w+-\\w+", addressNumber)
						|| Pattern.matches("[0-9]+\\w+", addressNumber)) {
					indexes[0] = actualMatchIndex;
					indexes[1] = actualMatchIndex + key.length() + 1;
					return indexes;
				}
			} else {
				// No hay un espacio en blanco despues del key,es posible que el
				// numero este pegado al key
				// usamos el indice actual +1 debido a que algunos key empiezan
				// con espacio en blanco.
				int indexOfSpace = address.indexOf(" ", actualMatchIndex + 1);

				if (indexOfSpace == -1) {
					indexOfSpace = address.length();
				}

				// Obtenemos la cadena que esta ´pegada al key y nos detenemos
				// en el siguiente espacio en blanco, o el final de la cadena.
				addressNumber = address.substring(
						actualMatchIndex + key.length(), indexOfSpace);

				// Si cumple el formato:
				// 1-solo numeros (1153) o
				// 2-numeros y letras (1153-A), entonces es el numero que
				// buscamos.
				if (Pattern.matches("[0-9]+", addressNumber)
						|| Pattern.matches("[0-9]+-\\w+", addressNumber)
						|| Pattern.matches("[0-9]+-\\w+-\\w+", addressNumber)
						|| Pattern.matches("[0-9]+\\w+", addressNumber)) {
					indexes[0] = actualMatchIndex;
					indexes[1] = actualMatchIndex + key.length();
					return indexes;
				}
			}
		}

		return null;
	}

	public static String formatHour(String hour, String second) {
		hour = hour.length() == 1 ? "0" + hour : hour;
		second = second.length() == 1 ? "0" + second : second;

		return (hour + ":" + second);
	}

	/*
	 * Obtiene los minutos actuales con este formato: 00 Si el valor es menor
	 * que 10, se agrega un cero. Si es mayor a 10, se regresa tal cual.
	 */
	public static String getMinuteStr() {
		Calendar calendar = Calendar.getInstance();
		int min = calendar.get(Calendar.MINUTE);

		if (min < 10) {
			return "0" + min;
		} else {
			return String.valueOf(min);
		}
	}

	/*
	 * Remueve los acentos de una cadena
	 */
	public static String removerAcentos(String cadena) {
		cadena = cadena.replaceAll("á", "a");
		cadena = cadena.replaceAll("é", "e");
		cadena = cadena.replaceAll("í", "i");
		cadena = cadena.replaceAll("ó", "o");
		cadena = cadena.replaceAll("ú", "u");
		return cadena;
	}

	/**
	 * Calcula el espacio faltan para completar el tamaño indicado.
	 * 
	 * @param size
	 *            El tamaño que indica la longitud que se debe de llenar con
	 *            espacios en blanco si el string no lo llena
	 * @param name
	 *            La palabra o frase que nos permite determinar cuando hace
	 *            falta para alcanzar la longitud indicada.
	 * @return Espacios en blanco necesario para rellenar la longitud indicada.
	 * @author vmpermad
	 */
	public static String fillBlankSpace(String name, int size) {
		StringBuffer sb = new StringBuffer();

		sb.append(name);

		for (int i = name.length(); i < size; i++) {
			sb.append(" ");
		}

		return sb.toString();
	}

	/**
	 * Da formato a un numero telefonico con LADA
	 * 
	 * @param claveLada
	 * @param numTelefono
	 * @return
	 */
	public static String formatearNumTelefono(String claveLada,
			String numTelefono) {
		String lada = "(" + claveLada + ")";

		return lada + " " + numTelefono;
	}

	/**
	 * Devuelve el tiempo de espera de alta de cuentas de terceros en segundos
	 * 
	 * @param idPropiedad
	 * @return
	 */
	// public static String obtenerTiempoEsperaSegundos(long idPropiedad) {
	// String tiempoEspera = "";
	// try {
	// JOProperty propiedad = PropertyBL.find(idPropiedad);
	// int tiempo = Integer.parseInt(propiedad.getValue());
	// tiempo = tiempo * 60;
	// tiempoEspera = Integer.toString(tiempo);
	// } catch (SQLException e) {
	// // En caso de error mandamos 60 minutos
	// tiempoEspera = "3600";
	// }
	//
	// return tiempoEspera;
	// }

	/**
	 * Obtiene el tiempo de espera de la propiedad indicada, y regresa una
	 * cadena con el formato 'xx minutos' o 'xx horas'
	 * 
	 * @param idPropiedad
	 * @return
	 */
	// public static String obtenerTiempoEspera(long idPropiedad) {
	// DecimalFormat money = new DecimalFormat("0.");
	// String tiempoEspera = "";
	// try {
	// JOProperty propiedad = PropertyBL.find(idPropiedad);
	// int tiempo = Integer.parseInt(propiedad.getValue());
	//
	// if (tiempo <= 60) {
	// tiempoEspera = tiempo + " minutos";
	// } else {
	// int horas = tiempo / 60;
	// int minutos = tiempo % 60;
	//
	// tiempoEspera = horas == 1 ? horas + " hora" : horas + " horas";
	//
	// if (minutos != 0) {
	// tiempoEspera += " " + minutos + " minutos";
	// }
	// }
	// } catch (SQLException e) {
	// tiempoEspera = "0 minutos";
	// }
	//
	// return tiempoEspera;
	// }

	/**
	 * Determina si el contrato tiene cuentas de cargo validas (cuentas
	 * corrientes y de ahorro)
	 * 
	 * @param summarybeanC
	 * @return true si el contrato tiene asociadas cuentas de cargo validas ,
	 *         false si el contrato no tiene cuentas de cargo validas
	 */
	// public static boolean tieneCuentasCargo(JBSummaryC summarybeanC) {
	// boolean tieneCuentasCargo = false;
	//
	// summarybeanC.initRowC();
	// while (summarybeanC.getNextRowC()) {
	// if (summarybeanC.gettypeC().equals("DDA")
	// || summarybeanC.gettypeC().equals("SAV")) {
	// tieneCuentasCargo = true;
	// break;
	// }
	// }
	//
	// return tieneCuentasCargo;
	// }

	/**
	 * Da formato a un numero celular de 10 posiciones xxx xxxxxxx
	 * 
	 * @param numTelefono
	 * @return
	 */
	public static String formatearNumCelular(String numTelefono) {
		String separador = " ";
		// return numTelefono.substring(0, 3) + separador +
		// numTelefono.substring(3, 6) + separador + numTelefono.substring(6,8)
		// + separador + numTelefono.substring(8, 10);
		return numTelefono.substring(0, 3) + separador
				+ numTelefono.substring(3, 10);
	}

	/**
	 * Muestra el mensaje de espera de tiempo al agregar una cuenta de terceros
	 * 
	 * @return
	 */
	// public static String mostrarMsjEsperaCuentas() {
	// ResourceBundle rb = ResourceBundle.getBundle("general");
	// String mensajeEspera = rb.getString("third.accounts.add.message");
	//
	// return mensajeEspera
	// + " "
	// + obtenerTiempoEspera(JOProperty.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
	// }

	/**
	 * Agrega al correo el mensaje de espera de tiempo al agregar una cuenta de
	 * terceros
	 * 
	 * @param puntoFinal
	 *            -Si se quiere un punto al final del mensaje o no
	 * @return
	 */
	// public static String mostrarMsjEsperaCuentasMail(boolean puntoFinal) {
	// ResourceBundle rb = ResourceBundle.getBundle("general");
	// String mensajeEspera = rb.getString("third.accounts.add.mail.message");
	//
	// String msj = mensajeEspera
	// + " "
	// + obtenerTiempoEspera(JOProperty.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
	// return puntoFinal ? msj + "." : msj;
	// }

	/**
	 * Agrega al correo el mensaje de espera de tiempo al agregar una cuenta de
	 * terceros
	 * 
	 * @param puntoFinal
	 *            -Si se quiere un punto al final del mensaje o no
	 * @return
	 */
	// public static String mostrarMsjEsperaCelularMail(boolean puntoFinal) {
	// ResourceBundle rb = ResourceBundle.getBundle("general");
	// String mensajeEspera =
	// rb.getString("asociacion.celular.activacion.aviso");
	//
	// String msj = mensajeEspera
	// + " "
	// + obtenerTiempoEspera(JOProperty.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
	// return puntoFinal ? msj + "." : msj;
	// }

	/**
	 * Read in a sequence of words from standard input and capitalize each one
	 * (make first letter uppercase; make rest lowercase). % java Capitalize
	 * esta es una cadena Esta Es Una Cadena
	 * 
	 * @param cadena
	 * @return
	 */
	public static String capitalizarCadena(String cadena) {
		String[] palabras = cadena.split("\\s");
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < palabras.length; ++i) {
			sb.append(capitalizaPalabra(palabras[i]));
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	/**
	 * @param s
	 * @return
	 */
	public static String capitalizaPalabra(String s) {
		if (s.length() == 0)
			return s;

		// Se validan cadenas que no se desea modificar (capitalizar o convertir
		// a minusculas)
		boolean modificar = !s.equals("TA");

		if (modificar) {
			// Estas son las palabras que no se deben capitalizar, si no que se
			// convierten a minusculas
			boolean capitalize = !s.equals("DE") && !s.equals("EL")
					&& !s.equals("LA") && !s.equals("SU");

			if (capitalize) {
				s = s.substring(0, 1).toUpperCase()
						+ s.substring(1).toLowerCase();
			} else {
				s = s.toLowerCase();
			}
		}

		return s;
	}

	/**
	 * Formatea un numero de tarjetao cuenta para que solo muestre los ultimos 4
	 * digitos ************XXXX
	 * 
	 * @param numeroTarjeta
	 * @return
	 */
	public static String ocultarNumeroCuentaTarjeta(String numeroCuentaTarjeta) {
		StringBuffer caracteres = new StringBuffer();
		String ultimos4Digitos = "";

		int digitosTarjeta = numeroCuentaTarjeta.length();

		if (digitosTarjeta >= 4) {
			for (int i = 0; i < digitosTarjeta - 4; ++i) {
				caracteres.append("*");
			}

			ultimos4Digitos = numeroCuentaTarjeta.substring(digitosTarjeta - 4,
					digitosTarjeta);
		}

		return caracteres.toString() + ultimos4Digitos;
	}

	public static boolean soloLetrasEspacio(String cadena) {

		boolean soloLetras = false;
		Pattern patron = Pattern.compile("[^A-Za-z .]");
		Matcher encaja = patron.matcher(cadena);

		if (encaja.find() == false) {
			soloLetras = true;
		}

		return soloLetras;
	}

	public static boolean validaNombre(String cadena) {

		boolean soloLetras = false;
		Pattern patron = Pattern.compile("[^A-Za-z .]");
		Matcher encaja = patron.matcher(cadena);

		if (encaja.find() == false) {
			soloLetras = true;
		}

		return soloLetras;
	}

	public static boolean soloLetrasNumerosEspacio(String cadena) {

		boolean soloLetras = false;
		Pattern patron = Pattern.compile("[^A-Za-z 0-9.]");
		Matcher encaja = patron.matcher(cadena);

		if (encaja.find() == false) {
			soloLetras = true;
		}

		return soloLetras;
	}

	public static boolean soloLetrasYNumeros(String cadena) {

		boolean soloLetras = false;
		Pattern patron = Pattern.compile("[^A-Za-z0-9]");
		Matcher encaja = patron.matcher(cadena);

		if (encaja.find() == false) {
			soloLetras = true;
		}

		return soloLetras;
	}

	public static boolean validaDireccion(String cadena) {

		boolean soloLetras = false;
		Pattern patron = Pattern.compile("[^A-Za-z0-9. #-()nÑ,]");
		Matcher encaja = patron.matcher(cadena);

		if (encaja.find() == false) {
			soloLetras = true;
		}

		return soloLetras;
	}

	public static String formatoTarjeta(String numero) {
		String digitos = "";
		if (!numero.equals("")) {
			digitos = numero.substring(0, 4) + "-" + numero.substring(4, 8)
					+ "-" + numero.substring(8, 12) + "-"
					+ numero.substring(12);
		}
		return digitos;
	}

	public static String formatoTarjetaSinGuion(String numero) {
		String digitos = "";
		if (!numero.equals("")) {
			digitos = numero.substring(0, 4) + " " + numero.substring(4, 8)
					+ " " + numero.substring(8, 12) + " "
					+ numero.substring(12);
		}
		return digitos;
	}

	public static String getCurrentYYYYMMDD() {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		Date currentTime = new Date();
		String dateString = formatDate.format(currentTime);
		dateString = dateString.length() > 8 ? dateString.substring(0, 8)
				: dateString;
		return dateString;
	}

	public static String formatCCY(BigDecimal num) {
		try {
			num.toString();
		} catch (Exception e) {
			return "0.00";
		}
		return formatCCY(num.toString());
	}

	public static String formatHora(String hora) {
		String ceros = "";
		if (hora == null)
			hora = "";
		if (hora.length() < 6) {
			// rellenar a ceros a la izquierda
			for (int i = hora.length(); i < 6; i++) {
				ceros += "0";
			}
		}
		return ceros + hora;
	}

	public static String getFechaFormat(String fechaYYYYMMDD) {
		String fFecha = "";
		try {
			fFecha += fechaYYYYMMDD.substring(6, 8);
			fFecha += "/";
			fFecha += fechaYYYYMMDD.substring(4, 6);
			fFecha += "/";
			fFecha += fechaYYYYMMDD.substring(0, 4);
		} catch (Exception ex) {
		}
		return fFecha;
	}

	public static String getHoraFormat(String horaHHMMSS) {

		String fHora = "";

		try {
			if (horaHHMMSS.trim().length() < 2)
				return fHora;
			if (horaHHMMSS.length() <= 5)
				horaHHMMSS = "0" + horaHHMMSS;
			fHora += horaHHMMSS.substring(0, 2);
			fHora += ":";
			fHora += horaHHMMSS.substring(2, 4);
		} catch (Exception ex) {

		}
		return fHora;

	}

	public static String getCurrentDDMMYYYY() {

		Calendar calendar = Calendar.getInstance();
		String year = "" + calendar.get(Calendar.YEAR);
		String month = "" + (calendar.get(Calendar.MONTH) + 1);
		String day = "" + calendar.get(Calendar.DAY_OF_MONTH);

		// year = year.substring(2);
		month = month.length() == 1 ? "0" + month : month;
		day = day.length() == 1 ? "0" + day : day;

		return (day + month + year);
	}

	public static String getStringMaxLen(String string, int len) {
		if (string == null)
			return "";
		if (string.length() > len) {
			return string.substring(len - 1);
		}
		return string;
	}

	public static String getDigitoVerificador(String tarjeta) {
		int d = 0, t = 0;
		String digitoVerificador = "X";
		if (tarjeta.length() == 15) {
			for (int i = 0; i < 15; i++) {
				d = new Integer(tarjeta.substring(i, i + 1));
				if ((i % 2) == 0) {
					d *= 2;
					if (d > 9)
						d -= 9;
				}
				t += d;
			}
			digitoVerificador = new Integer(t * 9).toString();
			digitoVerificador = digitoVerificador.substring(
					digitoVerificador.length() - 1, digitoVerificador.length());
		}
		return tarjeta + digitoVerificador;
	}

	/**
	 * Devuelve valor de la propiedad de la tabla de db2 DC_PROPERTIES
	 * 
	 * @param idPropiedad
	 * @return
	 */
	// public static String obtenerValorPropiedad(long idPropiedad,int tipo)
	// //Tipo 1 String 2 Numerico 3 Boleano
	// {
	// String valorPropiedad = "";
	//
	// switch(tipo)
	// {
	// case 1:valorPropiedad="";
	// case 2:valorPropiedad="0";
	// case 3:valorPropiedad="false";
	//
	// }
	//
	// try
	// {
	// JOProperty propiedad = PropertyBL.find(idPropiedad);
	// valorPropiedad = propiedad.getValue();
	// }
	// catch (SQLException e)
	// {
	// // En caso de error mandamos 60 minutos
	// valorPropiedad="|-1|";//Error
	// }
	//
	// return valorPropiedad;
	// }

	/**
	 * Devuelve el tiempo de espera de alta de cuentas de terceros en segundos
	 * 
	 * @param idPropiedad
	 * @return
	 */
	// public static String obtenerPropiedad(long idPropiedad) {
	// String tiempoEspera = "";
	// try {
	// JOProperty propiedad = PropertyBL.find(idPropiedad);
	// int tiempo = Integer.parseInt(propiedad.getValue());
	// //tiempo = tiempo * 60;
	// tiempoEspera = Integer.toString(tiempo);
	// } catch (SQLException e) {
	// // En caso de error mandamos 3
	// tiempoEspera = "3";
	// }
	//
	// return tiempoEspera;
	// }

	public static String getFechaFormatSaldos(String fechaYYYYMMDD) {
		String fFecha = "";
		try {
			fFecha += fechaYYYYMMDD.substring(6, 8);
			fFecha += "/";
			fFecha += fechaYYYYMMDD.substring(4, 6);
			fFecha += "/";
			fFecha += fechaYYYYMMDD.substring(2, 4);
		} catch (Exception ex) {
		}
		return fFecha;
	}

	public static String getRefNumTF() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssSSS");
		Date currentTime_1 = new Date();
		String rdateString = formatter.format(currentTime_1);
		rdateString = rdateString.substring(0, rdateString.length() - 1);
		return rdateString;
	}

	public static String getFechaFormat_ddMMyyy(String fechaYYYYMMDD) {
		String fFecha = "";
		try {
			fFecha += fechaYYYYMMDD.substring(6, 8);
			fFecha += " de ";
			fFecha += Util.getNombreMes(Integer.parseInt(fechaYYYYMMDD
					.substring(4, 6)));
			fFecha += " de ";
			fFecha += fechaYYYYMMDD.substring(0, 4);
		} catch (Exception ex) {
		}
		return fFecha;
	}
	public static Date getFechaSummary(int dia, int mes, int agno){
		Calendar calendarAux = Calendar.getInstance();
		int yearAux;
		
			calendarAux.set(Calendar.DAY_OF_MONTH,
					dia);
			calendarAux.set(Calendar.MONTH, mes - 1);
			 yearAux = agno;
			if (yearAux > 50)
				yearAux += 1900;
			else
				yearAux += 2000;
			calendarAux.set(Calendar.YEAR, yearAux);
		return calendarAux.getTime();
	}
	public static String nombreDia(int dia){
		String nombre="";
		switch(dia){
		case Calendar.SUNDAY:
			nombre ="Domingo";
			break;
		case Calendar.MONDAY:
			nombre ="Lunes";
			break;
		case Calendar.TUESDAY:
			nombre ="Martes";
			break;
		case Calendar.WEDNESDAY:
			nombre ="Miercoles";
			break;
		case Calendar.THURSDAY:
			nombre ="Jueves";
			break;
		case Calendar.FRIDAY:
			nombre ="Viernes";
			break;
		case Calendar.SATURDAY:
			nombre ="Sabado";
			break;
		}
		return nombre;
	}
	public static Calendar objetoCalendar(BigDecimal fecha) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		Date date = format.parse(fecha.toString());
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
	public static String fechaLarga(BigDecimal fecha) throws ParseException{
		String sFecha="";
		Calendar c=Util.objetoCalendar(fecha);
		int diaSemana=c.get(Calendar.DAY_OF_WEEK);
		int diaMes=c.get(Calendar.DAY_OF_MONTH);
	    int mes=c.get(Calendar.MONTH);
	    int year=c.get(Calendar.YEAR);
		sFecha+=Util.nombreDia(diaSemana);
		sFecha+=" ";
		sFecha+=diaMes<10?"0":"";
		sFecha+=diaMes;
		sFecha+=" ";
		sFecha+=Util.getNombreMes(mes+1);
		sFecha+=" ";
		sFecha+=year;
		return sFecha;
	}
	public static String fechaLargaSinDia(Calendar c) throws ParseException{
		String sFecha="";
		//int diaSemana=c.get(Calendar.DAY_OF_WEEK);
		int diaMes=c.get(Calendar.DAY_OF_MONTH);
	    int mes=c.get(Calendar.MONTH);
	    int year=c.get(Calendar.YEAR);
		//sFecha+=Util.nombreDia(diaSemana);
		//sFecha+=" ";
		sFecha+=diaMes<10?"0":"";
		sFecha+=diaMes;
		sFecha+=" ";
		sFecha+=Util.getNombreMes(mes+1);
		sFecha+=" ";
		sFecha+=year;
		return sFecha;
	}
	public static String fechaLargaSinDia() throws ParseException{
		return Util.fechaLargaSinDia(Calendar.getInstance()); 
	}
	public static String fechaLargaSinDia(BigDecimal fecha) throws ParseException{
		Calendar c=Util.objetoCalendar(fecha);
		return Util.fechaLargaSinDia(c); 
	}
	public static String fechaMesAgno(Calendar c) throws ParseException{
		String sFecha="";
	    int mes=c.get(Calendar.MONTH);
	    int year=c.get(Calendar.YEAR);
		sFecha+=Util.getNombreMes(mes+1);
		sFecha+=" ";
		sFecha+=year;
		return sFecha;
	}
	public static String fechaMesAgno(BigDecimal fecha) throws ParseException{
		Calendar c=Util.objetoCalendar(fecha);
		return Util.fechaMesAgno(c);
	}
	public static BigDecimal fechaDeDatePicker(String fechaStr){
		BigDecimal fecha=new BigDecimal(0);
		try{
			String[] s=fechaStr.split("-");
			int agno=Integer.parseInt(s[2].trim());
			int mes=Util.numeroMes(s[1].trim());
			int dia=Integer.parseInt(s[0].trim());
			fecha=new BigDecimal(dia+(mes*100)+(agno*10000));
		}catch(Exception ex){}
		return fecha;
	}
	public static int numeroMes(String mesStr){
		int numero=0;
		String mes=mesStr.trim().toUpperCase();
		if("ENERO".equalsIgnoreCase(mes))
			return 1;
		if("FEBRERO".equalsIgnoreCase(mes))
			return 2;
		if("MARZO".equalsIgnoreCase(mes))
			return 3;
		if("ABRIL".equalsIgnoreCase(mes))
			return 4;
		if("MAYO".equalsIgnoreCase(mes))
			return 5;
		if("JUNIO".equalsIgnoreCase(mes))
			return 6;
		if("JULIO".equalsIgnoreCase(mes))
			return 7;
		if("AGOSTO".equalsIgnoreCase(mes))
			return 8;
		if("SEPTIEMBRE".equalsIgnoreCase(mes))
			return 9;
		if("OCTUBRE".equalsIgnoreCase(mes))
			return 10;
		if("NOVIEMBRE".equalsIgnoreCase(mes))
			return 11;
		if("DICIEMBRE".equalsIgnoreCase(mes))
			return 12;
		return numero;
	}
}
