package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from IIN098600 physical file
 * definition.
 * 
 * File level identifier is 1010302132616. Record format level identifier is
 * 41A853C7C585C.
 */

public class IIN098600Message extends MessageRecord {
	final int FIELDCOUNT = 6;
	private CharacterField fieldIN9860USR = null;
	private CharacterField fieldIN9860CCN = null;
	private CharacterField fieldIN9860END = null;
	private CharacterField fieldIN9860FEC = null;
	private DecimalField fieldIN9860INI = null;
	private DecimalField fieldIN9860FIN = null;

	/**
	 * Constructor for IIN098600Message.
	 */
	public IIN098600Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 58;
		fileid = "1010302132616";
		recordid = "41A853C7C585C";
		message = new byte[getByteLength()];
		formatname = "IIN098600";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "IN9860USR";
		tagnames[0] = "IN9860USR";
		fields[0] = fieldIN9860USR = new CharacterField(message,
				HEADERSIZE + 0, 10, "IN9860USR");
		fieldnames[1] = "IN9860CCN";
		tagnames[1] = "IN9860CCN";
		fields[1] = fieldIN9860CCN = new CharacterField(message,
				HEADERSIZE + 10, 19, "IN9860CCN");
		fieldnames[2] = "IN9860END";
		tagnames[2] = "IN9860END";
		fields[2] = fieldIN9860END = new CharacterField(message,
				HEADERSIZE + 29, 1, "IN9860END");
		fieldnames[3] = "IN9860FEC";
		tagnames[3] = "IN9860FEC";
		fields[3] = fieldIN9860FEC = new CharacterField(message,
				HEADERSIZE + 30, 10, "IN9860FEC");
		fieldnames[4] = "IN9860INI";
		tagnames[4] = "IN9860INI";
		fields[4] = fieldIN9860INI = new DecimalField(message, HEADERSIZE + 40,
				9, 0, "IN9860INI");
		fieldnames[5] = "IN9860FIN";
		tagnames[5] = "IN9860FIN";
		fields[5] = fieldIN9860FIN = new DecimalField(message, HEADERSIZE + 49,
				9, 0, "IN9860FIN");
	}

	/**
	 * Return value of numeric field IN9860FIN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN9860FIN() {
		return fieldIN9860FIN.getBigDecimal();
	}

	/**
	 * Return value of numeric field IN9860INI as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN9860INI() {
		return fieldIN9860INI.getBigDecimal();
	}

	/**
	 * Get value of field IN9860CCN as a String.
	 */
	public String getIN9860CCN() {
		return fieldIN9860CCN.getString();
	}

	/**
	 * Get value of field IN9860END as a String.
	 */
	public String getIN9860END() {
		return fieldIN9860END.getString();
	}

	/**
	 * Get value of field IN9860FEC as a String.
	 */
	public String getIN9860FEC() {
		return fieldIN9860FEC.getString();
	}

	/**
	 * Get value of field IN9860FIN as a String.
	 */
	public String getIN9860FIN() {
		return fieldIN9860FIN.getString();
	}

	/**
	 * Get value of field IN9860INI as a String.
	 */
	public String getIN9860INI() {
		return fieldIN9860INI.getString();
	}

	/**
	 * Get value of field IN9860USR as a String.
	 */
	public String getIN9860USR() {
		return fieldIN9860USR.getString();
	}

	/**
	 * Set field IN9860CCN using a String value.
	 */
	public void setIN9860CCN(String newvalue) {
		fieldIN9860CCN.setString(newvalue);
	}

	/**
	 * Set field IN9860END using a String value.
	 */
	public void setIN9860END(String newvalue) {
		fieldIN9860END.setString(newvalue);
	}

	/**
	 * Set field IN9860FEC using a String value.
	 */
	public void setIN9860FEC(String newvalue) {
		fieldIN9860FEC.setString(newvalue);
	}

	/**
	 * Set field IN9860FIN using a String value.
	 */
	public void setIN9860FIN(String newvalue) {
		fieldIN9860FIN.setString(newvalue);
	}

	/**
	 * Set numeric field IN9860FIN using a BigDecimal value.
	 */
	public void setIN9860FIN(BigDecimal newvalue) {
		fieldIN9860FIN.setBigDecimal(newvalue);
	}

	/**
	 * Set field IN9860INI using a String value.
	 */
	public void setIN9860INI(String newvalue) {
		fieldIN9860INI.setString(newvalue);
	}

	/**
	 * Set numeric field IN9860INI using a BigDecimal value.
	 */
	public void setIN9860INI(BigDecimal newvalue) {
		fieldIN9860INI.setBigDecimal(newvalue);
	}

	/**
	 * Set field IN9860USR using a String value.
	 */
	public void setIN9860USR(String newvalue) {
		fieldIN9860USR.setString(newvalue);
	}
}