/**
 *  This Class was created By Luis Velando
 *  Copyright Datapro Inc. 1999
 **/

package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from EWD0001R physical file
 * definition.
 */

public class EWD0001RMessage extends MessageRecord {
	final int FIELDCOUNT = 3;
	private CharacterField fieldRWDUSR = null;
	private CharacterField fieldRWDSHR = null;
	private DecimalField fieldRWDFRC = null;

	/**
	 * Constructor for EWD0001RMessage.
	 */
	public EWD0001RMessage() {
		createFields();
		initialize();
		setFormatNameBytes();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 38;
		message = new byte[getByteLength()];
		formatname = "EWD0001R";
		fieldnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "RWDUSR";
		fields[0] = fieldRWDUSR = new CharacterField(message, HEADERSIZE + 0,
				10);
		fieldnames[1] = "RWDSHR";
		fields[1] = fieldRWDSHR = new CharacterField(message, HEADERSIZE + 10,
				20);
		fieldnames[2] = "RWDFRC";
		fields[2] = fieldRWDFRC = new DecimalField(message, HEADERSIZE + 30, 8,
				0);
	}

	/**
	 * Return value of numeric field RWDFRC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRWDFRC() {
		return fieldRWDFRC.getBigDecimal();
	}

	/**
	 * Get value of field RWDFRC as a String.
	 */
	public String getRWDFRC() {
		return fieldRWDFRC.getString();
	}

	/**
	 * Get value of field RWDSHR as a String.
	 */
	public String getRWDSHR() {
		return fieldRWDSHR.getString();
	}

	/**
	 * Get value of field RWDUSR as a String.
	 */
	public String getRWDUSR() {
		return fieldRWDUSR.getString();
	}

	/**
	 * Set field RWDFRC using a String value.
	 */
	public void setRWDFRC(String newvalue) {
		fieldRWDFRC.setString(newvalue);
	}

	/**
	 * Set numeric field RWDFRC using a BigDecimal value.
	 */
	public void setRWDFRC(BigDecimal newvalue) {
		fieldRWDFRC.setBigDecimal(newvalue);
	}

	/**
	 * Set field RWDSHR using a String value.
	 */
	public void setRWDSHR(String newvalue) {
		fieldRWDSHR.setString(newvalue);
	}

	/**
	 * Set field RWDUSR using a String value.
	 */
	public void setRWDUSR(String newvalue) {
		fieldRWDUSR.setString(newvalue);
	}
}