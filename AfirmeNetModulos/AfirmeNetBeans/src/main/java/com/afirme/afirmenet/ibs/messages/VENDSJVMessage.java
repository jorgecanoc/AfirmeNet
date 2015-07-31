package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from VENDSJV physical file
 * definition.
 * 
 * File level identifier is 1000802211923. Record format level identifier is
 * 4739F1C0604AA.
 */

public class VENDSJVMessage extends MessageRecord {
	final int FIELDCOUNT = 13;
	private CharacterField fieldVENUSR = null;
	private DecimalField fieldVENNUM = null;
	private CharacterField fieldVENNMA = null;
	private CharacterField fieldVENAD1 = null;
	private CharacterField fieldVENAD2 = null;
	private CharacterField fieldVENAD3 = null;
	private CharacterField fieldVENAD4 = null;
	private CharacterField fieldVENSTT = null;
	private CharacterField fieldVENZPC = null;
	private CharacterField fieldVENMEM = null;
	private CharacterField fieldVENABA = null;
	private CharacterField fieldVENSHM = null;
	private CharacterField fieldVENFLG = null;

	/**
	 * Constructor for VENDSJVMessage.
	 */
	public VENDSJVMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 275;
		fileid = "1000802211923";
		recordid = "4739F1C0604AA";
		message = new byte[getByteLength()];
		formatname = "VENDSJV";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "VENUSR";
		tagnames[0] = "VENUSR";
		fields[0] = fieldVENUSR = new CharacterField(message, HEADERSIZE + 0,
				10, "VENUSR");
		fieldnames[1] = "VENNUM";
		tagnames[1] = "VENNUM";
		fields[1] = fieldVENNUM = new DecimalField(message, HEADERSIZE + 10,
				10, 0, "VENNUM");
		fieldnames[2] = "VENNMA";
		tagnames[2] = "VENNMA";
		fields[2] = fieldVENNMA = new CharacterField(message, HEADERSIZE + 20,
				35, "VENNMA");
		fieldnames[3] = "VENAD1";
		tagnames[3] = "VENAD1";
		fields[3] = fieldVENAD1 = new CharacterField(message, HEADERSIZE + 55,
				35, "VENAD1");
		fieldnames[4] = "VENAD2";
		tagnames[4] = "VENAD2";
		fields[4] = fieldVENAD2 = new CharacterField(message, HEADERSIZE + 90,
				35, "VENAD2");
		fieldnames[5] = "VENAD3";
		tagnames[5] = "VENAD3";
		fields[5] = fieldVENAD3 = new CharacterField(message, HEADERSIZE + 125,
				35, "VENAD3");
		fieldnames[6] = "VENAD4";
		tagnames[6] = "VENAD4";
		fields[6] = fieldVENAD4 = new CharacterField(message, HEADERSIZE + 160,
				35, "VENAD4");
		fieldnames[7] = "VENSTT";
		tagnames[7] = "VENSTT";
		fields[7] = fieldVENSTT = new CharacterField(message, HEADERSIZE + 195,
				2, "VENSTT");
		fieldnames[8] = "VENZPC";
		tagnames[8] = "VENZPC";
		fields[8] = fieldVENZPC = new CharacterField(message, HEADERSIZE + 197,
				10, "VENZPC");
		fieldnames[9] = "VENMEM";
		tagnames[9] = "VENMEM";
		fields[9] = fieldVENMEM = new CharacterField(message, HEADERSIZE + 207,
				40, "VENMEM");
		fieldnames[10] = "VENABA";
		tagnames[10] = "VENABA";
		fields[10] = fieldVENABA = new CharacterField(message,
				HEADERSIZE + 247, 9, "VENABA");
		fieldnames[11] = "VENSHM";
		tagnames[11] = "VENSHM";
		fields[11] = fieldVENSHM = new CharacterField(message,
				HEADERSIZE + 256, 18, "VENSHM");
		fieldnames[12] = "VENFLG";
		tagnames[12] = "VENFLG";
		fields[12] = fieldVENFLG = new CharacterField(message,
				HEADERSIZE + 274, 1, "VENFLG");
	}

	/**
	 * Return value of numeric field VENNUM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVENNUM() {
		return fieldVENNUM.getBigDecimal();
	}

	/**
	 * Get value of field VENABA as a String.
	 */
	public String getVENABA() {
		return fieldVENABA.getString();
	}

	/**
	 * Get value of field VENAD1 as a String.
	 */
	public String getVENAD1() {
		return fieldVENAD1.getString();
	}

	/**
	 * Get value of field VENAD2 as a String.
	 */
	public String getVENAD2() {
		return fieldVENAD2.getString();
	}

	/**
	 * Get value of field VENAD3 as a String.
	 */
	public String getVENAD3() {
		return fieldVENAD3.getString();
	}

	/**
	 * Get value of field VENAD4 as a String.
	 */
	public String getVENAD4() {
		return fieldVENAD4.getString();
	}

	/**
	 * Get value of field VENFLG as a String.
	 */
	public String getVENFLG() {
		return fieldVENFLG.getString();
	}

	/**
	 * Get value of field VENMEM as a String.
	 */
	public String getVENMEM() {
		return fieldVENMEM.getString();
	}

	/**
	 * Get value of field VENNMA as a String.
	 */
	public String getVENNMA() {
		return fieldVENNMA.getString();
	}

	/**
	 * Get value of field VENNUM as a String.
	 */
	public String getVENNUM() {
		return fieldVENNUM.getString();
	}

	/**
	 * Get value of field VENSHM as a String.
	 */
	public String getVENSHM() {
		return fieldVENSHM.getString();
	}

	/**
	 * Get value of field VENSTT as a String.
	 */
	public String getVENSTT() {
		return fieldVENSTT.getString();
	}

	/**
	 * Get value of field VENUSR as a String.
	 */
	public String getVENUSR() {
		return fieldVENUSR.getString();
	}

	/**
	 * Get value of field VENZPC as a String.
	 */
	public String getVENZPC() {
		return fieldVENZPC.getString();
	}

	/**
	 * Set field VENABA using a String value.
	 */
	public void setVENABA(String newvalue) {
		fieldVENABA.setString(newvalue);
	}

	/**
	 * Set field VENAD1 using a String value.
	 */
	public void setVENAD1(String newvalue) {
		fieldVENAD1.setString(newvalue);
	}

	/**
	 * Set field VENAD2 using a String value.
	 */
	public void setVENAD2(String newvalue) {
		fieldVENAD2.setString(newvalue);
	}

	/**
	 * Set field VENAD3 using a String value.
	 */
	public void setVENAD3(String newvalue) {
		fieldVENAD3.setString(newvalue);
	}

	/**
	 * Set field VENAD4 using a String value.
	 */
	public void setVENAD4(String newvalue) {
		fieldVENAD4.setString(newvalue);
	}

	/**
	 * Set field VENFLG using a String value.
	 */
	public void setVENFLG(String newvalue) {
		fieldVENFLG.setString(newvalue);
	}

	/**
	 * Set field VENMEM using a String value.
	 */
	public void setVENMEM(String newvalue) {
		fieldVENMEM.setString(newvalue);
	}

	/**
	 * Set field VENNMA using a String value.
	 */
	public void setVENNMA(String newvalue) {
		fieldVENNMA.setString(newvalue);
	}

	/**
	 * Set field VENNUM using a String value.
	 */
	public void setVENNUM(String newvalue) {
		fieldVENNUM.setString(newvalue);
	}

	/**
	 * Set numeric field VENNUM using a BigDecimal value.
	 */
	public void setVENNUM(BigDecimal newvalue) {
		fieldVENNUM.setBigDecimal(newvalue);
	}

	/**
	 * Set field VENSHM using a String value.
	 */
	public void setVENSHM(String newvalue) {
		fieldVENSHM.setString(newvalue);
	}

	/**
	 * Set field VENSTT using a String value.
	 */
	public void setVENSTT(String newvalue) {
		fieldVENSTT.setString(newvalue);
	}

	/**
	 * Set field VENUSR using a String value.
	 */
	public void setVENUSR(String newvalue) {
		fieldVENUSR.setString(newvalue);
	}

	/**
	 * Set field VENZPC using a String value.
	 */
	public void setVENZPC(String newvalue) {
		fieldVENZPC.setString(newvalue);
	}
}