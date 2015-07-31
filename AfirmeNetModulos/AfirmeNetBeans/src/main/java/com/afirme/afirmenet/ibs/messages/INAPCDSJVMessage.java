package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from INAPCDSJV physical file
 * definition.
 * 
 * File level identifier is 1001004210200. Record format level identifier is
 * 3BBBD1E235CD7.
 */

public class INAPCDSJVMessage extends MessageRecord {
	final int FIELDCOUNT = 19;
	private CharacterField fieldDSJINAUSR = null;
	private DecimalField fieldDSJINAACC = null;
	private CharacterField fieldDSJINANM1 = null;
	private DecimalField fieldDSJINAVNO = null;
	private CharacterField fieldDSJINAPMT = null;
	private DecimalField fieldDSJINAIAM = null;
	private CharacterField fieldDSJINACCY = null;
	private DecimalField fieldDSJINAPDM = null;
	private DecimalField fieldDSJINAPDD = null;
	private DecimalField fieldDSJINAPDY = null;
	private CharacterField fieldDSJINAPFR = null;
	private DecimalField fieldDSJINATOT = null;
	private CharacterField fieldDSJINAREF = null;
	private CharacterField fieldDSJINARMK = null;
	private CharacterField fieldDSJINAOPT = null;
	private DecimalField fieldDSJINASQN = null;
	private DecimalField fieldDSJINARCM = null;
	private DecimalField fieldDSJINARCD = null;
	private DecimalField fieldDSJINARCY = null;

	/**
	 * Constructor for INAPCDSJVMessage.
	 */
	public INAPCDSJVMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 193;
		fileid = "1001004210200";
		recordid = "3BBBD1E235CD7";
		message = new byte[getByteLength()];
		formatname = "INAPCDSJV";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "DSJINAUSR";
		tagnames[0] = "DSJINAUSR";
		fields[0] = fieldDSJINAUSR = new CharacterField(message,
				HEADERSIZE + 0, 10, "DSJINAUSR");
		fieldnames[1] = "DSJINAACC";
		tagnames[1] = "DSJINAACC";
		fields[1] = fieldDSJINAACC = new DecimalField(message, HEADERSIZE + 10,
				13, 0, "DSJINAACC");
		fieldnames[2] = "DSJINANM1";
		tagnames[2] = "DSJINANM1";
		fields[2] = fieldDSJINANM1 = new CharacterField(message,
				HEADERSIZE + 23, 35, "DSJINANM1");
		fieldnames[3] = "DSJINAVNO";
		tagnames[3] = "DSJINAVNO";
		fields[3] = fieldDSJINAVNO = new DecimalField(message, HEADERSIZE + 58,
				10, 0, "DSJINAVNO");
		fieldnames[4] = "DSJINAPMT";
		tagnames[4] = "DSJINAPMT";
		fields[4] = fieldDSJINAPMT = new CharacterField(message,
				HEADERSIZE + 68, 1, "DSJINAPMT");
		fieldnames[5] = "DSJINAIAM";
		tagnames[5] = "DSJINAIAM";
		fields[5] = fieldDSJINAIAM = new DecimalField(message, HEADERSIZE + 69,
				17, 2, "DSJINAIAM");
		fieldnames[6] = "DSJINACCY";
		tagnames[6] = "DSJINACCY";
		fields[6] = fieldDSJINACCY = new CharacterField(message,
				HEADERSIZE + 86, 3, "DSJINACCY");
		fieldnames[7] = "DSJINAPDM";
		tagnames[7] = "DSJINAPDM";
		fields[7] = fieldDSJINAPDM = new DecimalField(message, HEADERSIZE + 89,
				3, 0, "DSJINAPDM");
		fieldnames[8] = "DSJINAPDD";
		tagnames[8] = "DSJINAPDD";
		fields[8] = fieldDSJINAPDD = new DecimalField(message, HEADERSIZE + 92,
				3, 0, "DSJINAPDD");
		fieldnames[9] = "DSJINAPDY";
		tagnames[9] = "DSJINAPDY";
		fields[9] = fieldDSJINAPDY = new DecimalField(message, HEADERSIZE + 95,
				3, 0, "DSJINAPDY");
		fieldnames[10] = "DSJINAPFR";
		tagnames[10] = "DSJINAPFR";
		fields[10] = fieldDSJINAPFR = new CharacterField(message,
				HEADERSIZE + 98, 1, "DSJINAPFR");
		fieldnames[11] = "DSJINATOT";
		tagnames[11] = "DSJINATOT";
		fields[11] = fieldDSJINATOT = new DecimalField(message,
				HEADERSIZE + 99, 4, 0, "DSJINATOT");
		fieldnames[12] = "DSJINAREF";
		tagnames[12] = "DSJINAREF";
		fields[12] = fieldDSJINAREF = new CharacterField(message,
				HEADERSIZE + 103, 30, "DSJINAREF");
		fieldnames[13] = "DSJINARMK";
		tagnames[13] = "DSJINARMK";
		fields[13] = fieldDSJINARMK = new CharacterField(message,
				HEADERSIZE + 133, 40, "DSJINARMK");
		fieldnames[14] = "DSJINAOPT";
		tagnames[14] = "DSJINAOPT";
		fields[14] = fieldDSJINAOPT = new CharacterField(message,
				HEADERSIZE + 173, 1, "DSJINAOPT");
		fieldnames[15] = "DSJINASQN";
		tagnames[15] = "DSJINASQN";
		fields[15] = fieldDSJINASQN = new DecimalField(message,
				HEADERSIZE + 174, 10, 0, "DSJINASQN");
		fieldnames[16] = "DSJINARCM";
		tagnames[16] = "DSJINARCM";
		fields[16] = fieldDSJINARCM = new DecimalField(message,
				HEADERSIZE + 184, 3, 0, "DSJINARCM");
		fieldnames[17] = "DSJINARCD";
		tagnames[17] = "DSJINARCD";
		fields[17] = fieldDSJINARCD = new DecimalField(message,
				HEADERSIZE + 187, 3, 0, "DSJINARCD");
		fieldnames[18] = "DSJINARCY";
		tagnames[18] = "DSJINARCY";
		fields[18] = fieldDSJINARCY = new DecimalField(message,
				HEADERSIZE + 190, 3, 0, "DSJINARCY");
	}

	/**
	 * Return value of numeric field DSJINAACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINAACC() {
		return fieldDSJINAACC.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINAIAM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINAIAM() {
		return fieldDSJINAIAM.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINAPDD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINAPDD() {
		return fieldDSJINAPDD.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINAPDM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINAPDM() {
		return fieldDSJINAPDM.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINAPDY as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINAPDY() {
		return fieldDSJINAPDY.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINARCD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINARCD() {
		return fieldDSJINARCD.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINARCM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINARCM() {
		return fieldDSJINARCM.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINARCY as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINARCY() {
		return fieldDSJINARCY.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINASQN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINASQN() {
		return fieldDSJINASQN.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINATOT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINATOT() {
		return fieldDSJINATOT.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINAVNO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINAVNO() {
		return fieldDSJINAVNO.getBigDecimal();
	}

	/**
	 * Get value of field DSJINAACC as a String.
	 */
	public String getDSJINAACC() {
		return fieldDSJINAACC.getString();
	}

	/**
	 * Get value of field DSJINACCY as a String.
	 */
	public String getDSJINACCY() {
		return fieldDSJINACCY.getString();
	}

	/**
	 * Get value of field DSJINAIAM as a String.
	 */
	public String getDSJINAIAM() {
		return fieldDSJINAIAM.getString();
	}

	/**
	 * Get value of field DSJINANM1 as a String.
	 */
	public String getDSJINANM1() {
		return fieldDSJINANM1.getString();
	}

	/**
	 * Get value of field DSJINAOPT as a String.
	 */
	public String getDSJINAOPT() {
		return fieldDSJINAOPT.getString();
	}

	/**
	 * Get value of field DSJINAPDD as a String.
	 */
	public String getDSJINAPDD() {
		return fieldDSJINAPDD.getString();
	}

	/**
	 * Get value of field DSJINAPDM as a String.
	 */
	public String getDSJINAPDM() {
		return fieldDSJINAPDM.getString();
	}

	/**
	 * Get value of field DSJINAPDY as a String.
	 */
	public String getDSJINAPDY() {
		return fieldDSJINAPDY.getString();
	}

	/**
	 * Get value of field DSJINAPFR as a String.
	 */
	public String getDSJINAPFR() {
		return fieldDSJINAPFR.getString();
	}

	/**
	 * Get value of field DSJINAPMT as a String.
	 */
	public String getDSJINAPMT() {
		return fieldDSJINAPMT.getString();
	}

	/**
	 * Get value of field DSJINARCD as a String.
	 */
	public String getDSJINARCD() {
		return fieldDSJINARCD.getString();
	}

	/**
	 * Get value of field DSJINARCM as a String.
	 */
	public String getDSJINARCM() {
		return fieldDSJINARCM.getString();
	}

	/**
	 * Get value of field DSJINARCY as a String.
	 */
	public String getDSJINARCY() {
		return fieldDSJINARCY.getString();
	}

	/**
	 * Get value of field DSJINAREF as a String.
	 */
	public String getDSJINAREF() {
		return fieldDSJINAREF.getString();
	}

	/**
	 * Get value of field DSJINARMK as a String.
	 */
	public String getDSJINARMK() {
		return fieldDSJINARMK.getString();
	}

	/**
	 * Get value of field DSJINASQN as a String.
	 */
	public String getDSJINASQN() {
		return fieldDSJINASQN.getString();
	}

	/**
	 * Get value of field DSJINATOT as a String.
	 */
	public String getDSJINATOT() {
		return fieldDSJINATOT.getString();
	}

	/**
	 * Get value of field DSJINAUSR as a String.
	 */
	public String getDSJINAUSR() {
		return fieldDSJINAUSR.getString();
	}

	/**
	 * Get value of field DSJINAVNO as a String.
	 */
	public String getDSJINAVNO() {
		return fieldDSJINAVNO.getString();
	}

	/**
	 * Set field DSJINAACC using a String value.
	 */
	public void setDSJINAACC(String newvalue) {
		fieldDSJINAACC.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINAACC using a BigDecimal value.
	 */
	public void setDSJINAACC(BigDecimal newvalue) {
		fieldDSJINAACC.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINACCY using a String value.
	 */
	public void setDSJINACCY(String newvalue) {
		fieldDSJINACCY.setString(newvalue);
	}

	/**
	 * Set field DSJINAIAM using a String value.
	 */
	public void setDSJINAIAM(String newvalue) {
		fieldDSJINAIAM.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINAIAM using a BigDecimal value.
	 */
	public void setDSJINAIAM(BigDecimal newvalue) {
		fieldDSJINAIAM.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINANM1 using a String value.
	 */
	public void setDSJINANM1(String newvalue) {
		fieldDSJINANM1.setString(newvalue);
	}

	/**
	 * Set field DSJINAOPT using a String value.
	 */
	public void setDSJINAOPT(String newvalue) {
		fieldDSJINAOPT.setString(newvalue);
	}

	/**
	 * Set field DSJINAPDD using a String value.
	 */
	public void setDSJINAPDD(String newvalue) {
		fieldDSJINAPDD.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINAPDD using a BigDecimal value.
	 */
	public void setDSJINAPDD(BigDecimal newvalue) {
		fieldDSJINAPDD.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINAPDM using a String value.
	 */
	public void setDSJINAPDM(String newvalue) {
		fieldDSJINAPDM.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINAPDM using a BigDecimal value.
	 */
	public void setDSJINAPDM(BigDecimal newvalue) {
		fieldDSJINAPDM.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINAPDY using a String value.
	 */
	public void setDSJINAPDY(String newvalue) {
		fieldDSJINAPDY.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINAPDY using a BigDecimal value.
	 */
	public void setDSJINAPDY(BigDecimal newvalue) {
		fieldDSJINAPDY.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINAPFR using a String value.
	 */
	public void setDSJINAPFR(String newvalue) {
		fieldDSJINAPFR.setString(newvalue);
	}

	/**
	 * Set field DSJINAPMT using a String value.
	 */
	public void setDSJINAPMT(String newvalue) {
		fieldDSJINAPMT.setString(newvalue);
	}

	/**
	 * Set field DSJINARCD using a String value.
	 */
	public void setDSJINARCD(String newvalue) {
		fieldDSJINARCD.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINARCD using a BigDecimal value.
	 */
	public void setDSJINARCD(BigDecimal newvalue) {
		fieldDSJINARCD.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINARCM using a String value.
	 */
	public void setDSJINARCM(String newvalue) {
		fieldDSJINARCM.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINARCM using a BigDecimal value.
	 */
	public void setDSJINARCM(BigDecimal newvalue) {
		fieldDSJINARCM.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINARCY using a String value.
	 */
	public void setDSJINARCY(String newvalue) {
		fieldDSJINARCY.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINARCY using a BigDecimal value.
	 */
	public void setDSJINARCY(BigDecimal newvalue) {
		fieldDSJINARCY.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINAREF using a String value.
	 */
	public void setDSJINAREF(String newvalue) {
		fieldDSJINAREF.setString(newvalue);
	}

	/**
	 * Set field DSJINARMK using a String value.
	 */
	public void setDSJINARMK(String newvalue) {
		fieldDSJINARMK.setString(newvalue);
	}

	/**
	 * Set field DSJINASQN using a String value.
	 */
	public void setDSJINASQN(String newvalue) {
		fieldDSJINASQN.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINASQN using a BigDecimal value.
	 */
	public void setDSJINASQN(BigDecimal newvalue) {
		fieldDSJINASQN.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINATOT using a String value.
	 */
	public void setDSJINATOT(String newvalue) {
		fieldDSJINATOT.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINATOT using a BigDecimal value.
	 */
	public void setDSJINATOT(BigDecimal newvalue) {
		fieldDSJINATOT.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINAUSR using a String value.
	 */
	public void setDSJINAUSR(String newvalue) {
		fieldDSJINAUSR.setString(newvalue);
	}

	/**
	 * Set field DSJINAVNO using a String value.
	 */
	public void setDSJINAVNO(String newvalue) {
		fieldDSJINAVNO.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINAVNO using a BigDecimal value.
	 */
	public void setDSJINAVNO(BigDecimal newvalue) {
		fieldDSJINAVNO.setBigDecimal(newvalue);
	}
}