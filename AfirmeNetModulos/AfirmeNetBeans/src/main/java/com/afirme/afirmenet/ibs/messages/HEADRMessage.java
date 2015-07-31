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
 * Class generated by AS/400 CRTCLASS command from HEADR physical file
 * definition.
 * 
 * File level identifier is 1000803141332. Record format level identifier is
 * 388C4232BD8CC.
 */

public class HEADRMessage extends MessageRecord {
	final int FIELDCOUNT = 5;
	private CharacterField fieldHEAUSR = null;
	private CharacterField fieldHEAPGM = null;
	private DecimalField fieldHEATCD = null;
	private DecimalField fieldHEATIM = null;
	private CharacterField fieldHEAOPC = null;

	/**
	 * Constructor for HEADRMessage.
	 */
	public HEADRMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 41;
		fileid = "1000803141332";
		recordid = "388C4232BD8CC";
		message = new byte[getByteLength()];
		formatname = "HEADR";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "HEAUSR";
		tagnames[0] = "HEAUSR";
		fields[0] = fieldHEAUSR = new CharacterField(message, HEADERSIZE + 0,
				10, "HEAUSR");
		fieldnames[1] = "HEAPGM";
		tagnames[1] = "HEAPGM";
		fields[1] = fieldHEAPGM = new CharacterField(message, HEADERSIZE + 10,
				10, "HEAPGM");
		fieldnames[2] = "HEATCD";
		tagnames[2] = "HEATCD";
		fields[2] = fieldHEATCD = new DecimalField(message, HEADERSIZE + 20, 5,
				0, "HEATCD");
		fieldnames[3] = "HEATIM";
		tagnames[3] = "HEATIM";
		fields[3] = fieldHEATIM = new DecimalField(message, HEADERSIZE + 25,
				13, 0, "HEATIM");
		fieldnames[4] = "HEAOPC";
		tagnames[4] = "HEAOPC";
		fields[4] = fieldHEAOPC = new CharacterField(message, HEADERSIZE + 38,
				3, "HEAOPC");
	}

	/**
	 * Return value of numeric field HEATCD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalHEATCD() {
		return fieldHEATCD.getBigDecimal();
	}

	/**
	 * Return value of numeric field HEATIM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalHEATIM() {
		return fieldHEATIM.getBigDecimal();
	}

	/**
	 * Get value of field HEAOPC as a String.
	 */
	public String getHEAOPC() {
		return fieldHEAOPC.getString();
	}

	/**
	 * Get value of field HEAPGM as a String.
	 */
	public String getHEAPGM() {
		return fieldHEAPGM.getString();
	}

	/**
	 * Get value of field HEATCD as a String.
	 */
	public String getHEATCD() {
		return fieldHEATCD.getString();
	}

	/**
	 * Get value of field HEATIM as a String.
	 */
	public String getHEATIM() {
		return fieldHEATIM.getString();
	}

	/**
	 * Get value of field HEAUSR as a String.
	 */
	public String getHEAUSR() {
		return fieldHEAUSR.getString();
	}

	/**
	 * Set field HEAOPC using a String value.
	 */
	public void setHEAOPC(String newvalue) {
		fieldHEAOPC.setString(newvalue);
	}

	/**
	 * Set field HEAPGM using a String value.
	 */
	public void setHEAPGM(String newvalue) {
		fieldHEAPGM.setString(newvalue);
	}

	/**
	 * Set field HEATCD using a String value.
	 */
	public void setHEATCD(String newvalue) {
		fieldHEATCD.setString(newvalue);
	}

	/**
	 * Set numeric field HEATCD using a BigDecimal value.
	 */
	public void setHEATCD(BigDecimal newvalue) {
		fieldHEATCD.setBigDecimal(newvalue);
	}

	/**
	 * Set field HEATIM using a String value.
	 */
	public void setHEATIM(String newvalue) {
		fieldHEATIM.setString(newvalue);
	}

	/**
	 * Set numeric field HEATIM using a BigDecimal value.
	 */
	public void setHEATIM(BigDecimal newvalue) {
		fieldHEATIM.setBigDecimal(newvalue);
	}

	/**
	 * Set field HEAUSR using a String value.
	 */
	public void setHEAUSR(String newvalue) {
		fieldHEAUSR.setString(newvalue);
	}
}