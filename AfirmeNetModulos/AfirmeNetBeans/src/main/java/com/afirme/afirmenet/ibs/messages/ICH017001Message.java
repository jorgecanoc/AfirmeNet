package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from ICH017001 physical file
 * definition.
 * 
 * File level identifier is 1010921114936. Record format level identifier is
 * 42BFEB4C93A15.
 */

public class ICH017001Message extends MessageRecord {
	final int FIELDCOUNT = 5;
	private CharacterField fieldICH170USR = null;
	private DecimalField fieldICH170ACC = null;
	private DecimalField fieldICH170INC = null;
	private DecimalField fieldICH170FIN = null;
	private CharacterField fieldICH170STA = null;

	/**
	 * Constructor for ICH017001Message.
	 */
	public ICH017001Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 44;
		fileid = "1010921114936";
		recordid = "42BFEB4C93A15";
		message = new byte[getByteLength()];
		formatname = "ICH017001";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "ICH170USR";
		tagnames[0] = "ICH170USR";
		fields[0] = fieldICH170USR = new CharacterField(message,
				HEADERSIZE + 0, 10, "ICH170USR");
		fieldnames[1] = "ICH170ACC";
		tagnames[1] = "ICH170ACC";
		fields[1] = fieldICH170ACC = new DecimalField(message, HEADERSIZE + 10,
				13, 0, "ICH170ACC");
		fieldnames[2] = "ICH170INC";
		tagnames[2] = "ICH170INC";
		fields[2] = fieldICH170INC = new DecimalField(message, HEADERSIZE + 23,
				10, 0, "ICH170INC");
		fieldnames[3] = "ICH170FIN";
		tagnames[3] = "ICH170FIN";
		fields[3] = fieldICH170FIN = new DecimalField(message, HEADERSIZE + 33,
				10, 0, "ICH170FIN");
		fieldnames[4] = "ICH170STA";
		tagnames[4] = "ICH170STA";
		fields[4] = fieldICH170STA = new CharacterField(message,
				HEADERSIZE + 43, 1, "ICH170STA");
	}

	/**
	 * Set field ICH170USR using a String value.
	 */
	public void setICH170USR(String newvalue) {
		fieldICH170USR.setString(newvalue);
	}

	/**
	 * Get value of field ICH170USR as a String.
	 */
	public String getICH170USR() {
		return fieldICH170USR.getString();
	}

	/**
	 * Set field ICH170ACC using a String value.
	 */
	public void setICH170ACC(String newvalue) {
		fieldICH170ACC.setString(newvalue);
	}

	/**
	 * Get value of field ICH170ACC as a String.
	 */
	public String getICH170ACC() {
		return fieldICH170ACC.getString();
	}

	/**
	 * Set numeric field ICH170ACC using a BigDecimal value.
	 */
	public void setICH170ACC(BigDecimal newvalue) {
		fieldICH170ACC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ICH170ACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalICH170ACC() {
		return fieldICH170ACC.getBigDecimal();
	}

	/**
	 * Set field ICH170INC using a String value.
	 */
	public void setICH170INC(String newvalue) {
		fieldICH170INC.setString(newvalue);
	}

	/**
	 * Get value of field ICH170INC as a String.
	 */
	public String getICH170INC() {
		return fieldICH170INC.getString();
	}

	/**
	 * Set numeric field ICH170INC using a BigDecimal value.
	 */
	public void setICH170INC(BigDecimal newvalue) {
		fieldICH170INC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ICH170INC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalICH170INC() {
		return fieldICH170INC.getBigDecimal();
	}

	/**
	 * Set field ICH170FIN using a String value.
	 */
	public void setICH170FIN(String newvalue) {
		fieldICH170FIN.setString(newvalue);
	}

	/**
	 * Get value of field ICH170FIN as a String.
	 */
	public String getICH170FIN() {
		return fieldICH170FIN.getString();
	}

	/**
	 * Set numeric field ICH170FIN using a BigDecimal value.
	 */
	public void setICH170FIN(BigDecimal newvalue) {
		fieldICH170FIN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ICH170FIN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalICH170FIN() {
		return fieldICH170FIN.getBigDecimal();
	}

	/**
	 * Set field ICH170STA using a String value.
	 */
	public void setICH170STA(String newvalue) {
		fieldICH170STA.setString(newvalue);
	}

	/**
	 * Get value of field ICH170STA as a String.
	 */
	public String getICH170STA() {
		return fieldICH170STA.getString();
	}

}