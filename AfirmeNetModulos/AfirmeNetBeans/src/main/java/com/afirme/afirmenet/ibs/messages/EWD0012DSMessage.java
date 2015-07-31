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
 * Class generated by AS/400 CRTCLASS command from EWD0012DS physical file
 * definition.
 * 
 * File level identifier is 1000310114501. Record format level identifier is
 * 37533BD2B1C1D.
 */

public class EWD0012DSMessage extends MessageRecord {
	final int FIELDCOUNT = 5;
	private CharacterField fieldEWDSHR = null;
	private CharacterField fieldEWDCCY = null;
	private CharacterField fieldEWDDSC = null;
	private DecimalField fieldEWDEXR = null;
	private CharacterField fieldEWDOPE = null;

	/**
	 * Constructor for EWD0012DSMessage.
	 */
	public EWD0012DSMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 54;
		fileid = "1000310114501";
		recordid = "37533BD2B1C1D";
		message = new byte[getByteLength()];
		formatname = "EWD0012DS";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "EWDSHR";
		tagnames[0] = "EWDSHR";
		fields[0] = fieldEWDSHR = new CharacterField(message, HEADERSIZE + 0,
				2, "EWDSHR");
		fieldnames[1] = "EWDCCY";
		tagnames[1] = "EWDCCY";
		fields[1] = fieldEWDCCY = new CharacterField(message, HEADERSIZE + 2,
				3, "EWDCCY");
		fieldnames[2] = "EWDDSC";
		tagnames[2] = "EWDDSC";
		fields[2] = fieldEWDDSC = new CharacterField(message, HEADERSIZE + 5,
				35, "EWDDSC");
		fieldnames[3] = "EWDEXR";
		tagnames[3] = "EWDEXR";
		fields[3] = fieldEWDEXR = new DecimalField(message, HEADERSIZE + 40,
				13, 6, "EWDEXR");
		fieldnames[4] = "EWDOPE";
		tagnames[4] = "EWDOPE";
		fields[4] = fieldEWDOPE = new CharacterField(message, HEADERSIZE + 53,
				1, "EWDOPE");
	}

	/**
	 * Return value of numeric field EWDEXR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalEWDEXR() {
		return fieldEWDEXR.getBigDecimal();
	}

	/**
	 * Get value of field EWDCCY as a String.
	 */
	public String getEWDCCY() {
		return fieldEWDCCY.getString();
	}

	/**
	 * Get value of field EWDDSC as a String.
	 */
	public String getEWDDSC() {
		return fieldEWDDSC.getString();
	}

	/**
	 * Get value of field EWDEXR as a String.
	 */
	public String getEWDEXR() {
		return fieldEWDEXR.getString();
	}

	/**
	 * Get value of field EWDOPE as a String.
	 */
	public String getEWDOPE() {
		return fieldEWDOPE.getString();
	}

	/**
	 * Get value of field EWDSHR as a String.
	 */
	public String getEWDSHR() {
		return fieldEWDSHR.getString();
	}

	/**
	 * Set field EWDCCY using a String value.
	 */
	public void setEWDCCY(String newvalue) {
		fieldEWDCCY.setString(newvalue);
	}

	/**
	 * Set field EWDDSC using a String value.
	 */
	public void setEWDDSC(String newvalue) {
		fieldEWDDSC.setString(newvalue);
	}

	/**
	 * Set field EWDEXR using a String value.
	 */
	public void setEWDEXR(String newvalue) {
		fieldEWDEXR.setString(newvalue);
	}

	/**
	 * Set numeric field EWDEXR using a BigDecimal value.
	 */
	public void setEWDEXR(BigDecimal newvalue) {
		fieldEWDEXR.setBigDecimal(newvalue);
	}

	/**
	 * Set field EWDOPE using a String value.
	 */
	public void setEWDOPE(String newvalue) {
		fieldEWDOPE.setString(newvalue);
	}

	/**
	 * Set field EWDSHR using a String value.
	 */
	public void setEWDSHR(String newvalue) {
		fieldEWDSHR.setString(newvalue);
	}
}