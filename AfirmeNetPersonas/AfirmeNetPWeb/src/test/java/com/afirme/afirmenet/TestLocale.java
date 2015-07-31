package com.afirme.afirmenet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 */

/**
 * @author 0jacancue
 * 
 */
public class TestLocale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Locale Default==>" + Locale.getDefault());

		Locale[] thaiLocale = { new Locale("de", "DE"), new Locale("fr", "FR"),
				new Locale("en", "US"), new Locale("en", "GB"),
				new Locale("es", "MX"), new Locale("es"),new Locale("ar","SA") };

		for (Locale locale : thaiLocale) {
			NumberFormat nf = NumberFormat.getNumberInstance(locale);
			DecimalFormat df = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
			StringBuffer msgBuff = new StringBuffer();
			msgBuff.append(locale.toString() + ": ");
			msgBuff.append(nf.format(573.34));
			msgBuff.append("  Con Simbolo: " +df.format(573.34));
			System.out.println(msgBuff.toString() + "\n");
		}

	}

}
