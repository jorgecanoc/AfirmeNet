package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from ECLI00101 physical file
 * definition.
 */

public class ECLI00101Message extends MessageRecord {
	final int FIELDCOUNT = 16;
	private CharacterField fieldH01USR = null;
	private CharacterField fieldH01PGM = null;
	private CharacterField fieldH01TIM = null;
	private CharacterField fieldH01SCR = null;
	private CharacterField fieldH01OPE = null;
	private CharacterField fieldH01MAS = null;
	private CharacterField fieldH01WK1 = null;
	private CharacterField fieldH01WK2 = null;
	private CharacterField fieldH01WK3 = null;
	private DecimalField fieldE01CUN = null;
	private CharacterField fieldE01NA1 = null;
	private CharacterField fieldE01NA2 = null;
	private CharacterField fieldE01NA3 = null;
	private CharacterField fieldE01NA4 = null;
	private CharacterField fieldE01CTY = null;
	private CharacterField fieldE01CTR = null;

	/**
	 * Constructor for ECLI00101Message.
	 */
	public ECLI00101Message() {
		createFields();
		initialize();
		setFormatNameBytes();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */

	protected void createFields() {
		recordsize = 252;
		message = new byte[getByteLength()];
		formatname = "ECLI00101";
		fieldnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "H01USR";
		fields[0] = fieldH01USR = new CharacterField(message, HEADERSIZE + 0,
				10);
		fieldnames[1] = "H01PGM";
		fields[1] = fieldH01PGM = new CharacterField(message, HEADERSIZE + 10,
				10);
		fieldnames[2] = "H01TIM";
		fields[2] = fieldH01TIM = new CharacterField(message, HEADERSIZE + 20,
				12);
		fieldnames[3] = "H01SCR";
		fields[3] = fieldH01SCR = new CharacterField(message, HEADERSIZE + 32,
				2);
		fieldnames[4] = "H01OPE";
		fields[4] = fieldH01OPE = new CharacterField(message, HEADERSIZE + 34,
				4);
		fieldnames[5] = "H01MAS";
		fields[5] = fieldH01MAS = new CharacterField(message, HEADERSIZE + 38,
				1);
		fieldnames[6] = "H01WK1";
		fields[6] = fieldH01WK1 = new CharacterField(message, HEADERSIZE + 39,
				1);
		fieldnames[7] = "H01WK2";
		fields[7] = fieldH01WK2 = new CharacterField(message, HEADERSIZE + 40,
				1);
		fieldnames[8] = "H01WK3";
		fields[8] = fieldH01WK3 = new CharacterField(message, HEADERSIZE + 41,
				1);
		fieldnames[9] = "E01CUN";
		fields[9] = fieldE01CUN = new DecimalField(message, HEADERSIZE + 42,
				10, 0);
		fieldnames[10] = "E01NA1";
		fields[10] = fieldE01NA1 = new CharacterField(message, HEADERSIZE + 52,
				45);
		fieldnames[11] = "E01NA2";
		fields[11] = fieldE01NA2 = new CharacterField(message, HEADERSIZE + 97,
				35);
		fieldnames[12] = "E01NA3";
		fields[12] = fieldE01NA3 = new CharacterField(message,
				HEADERSIZE + 132, 35);
		fieldnames[13] = "E01NA4";
		fields[13] = fieldE01NA4 = new CharacterField(message,
				HEADERSIZE + 167, 35);
		fieldnames[14] = "E01CTY";
		fields[14] = fieldE01CTY = new CharacterField(message,
				HEADERSIZE + 202, 30);
		fieldnames[15] = "E01CTR";
		fields[15] = fieldE01CTR = new CharacterField(message,
				HEADERSIZE + 232, 20);
	}

	/**
	 * Return value of numeric field E01CUN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE01CUN() {
		return fieldE01CUN.getBigDecimal();
	}

	/**
	 * Get value of field E01CTR as a String.
	 */
	public String getE01CTR() {
		return fieldE01CTR.getString();
	}

	/**
	 * Get value of field E01CTY as a String.
	 */
	public String getE01CTY() {
		return fieldE01CTY.getString();
	}

	/**
	 * Get value of field E01CUN as a String.
	 */
	public String getE01CUN() {
		return fieldE01CUN.getString();
	}

	/**
	 * Get value of field E01NA1 as a String.
	 */
	public String getE01NA1() {
		return fieldE01NA1.getString();
	}

	/**
	 * Get value of field E01NA2 as a String.
	 */
	public String getE01NA2() {
		return fieldE01NA2.getString();
	}

	/**
	 * Get value of field E01NA3 as a String.
	 */
	public String getE01NA3() {
		return fieldE01NA3.getString();
	}

	/**
	 * Get value of field E01NA4 as a String.
	 */
	public String getE01NA4() {
		return fieldE01NA4.getString();
	}

	/**
	 * Get value of field H01MAS as a String.
	 */
	public String getH01MAS() {
		return fieldH01MAS.getString();
	}

	/**
	 * Get value of field H01OPE as a String.
	 */
	public String getH01OPE() {
		return fieldH01OPE.getString();
	}

	/**
	 * Get value of field H01PGM as a String.
	 */
	public String getH01PGM() {
		return fieldH01PGM.getString();
	}

	/**
	 * Get value of field H01SCR as a String.
	 */
	public String getH01SCR() {
		return fieldH01SCR.getString();
	}

	/**
	 * Get value of field H01TIM as a String.
	 */
	public String getH01TIM() {
		return fieldH01TIM.getString();
	}

	/**
	 * Get value of field H01USR as a String.
	 */
	public String getH01USR() {
		return fieldH01USR.getString();
	}

	/**
	 * Get value of field H01WK1 as a String.
	 */
	public String getH01WK1() {
		return fieldH01WK1.getString();
	}

	/**
	 * Get value of field H01WK2 as a String.
	 */
	public String getH01WK2() {
		return fieldH01WK2.getString();
	}

	/**
	 * Get value of field H01WK3 as a String.
	 */
	public String getH01WK3() {
		return fieldH01WK3.getString();
	}

	/**
	 * Set field E01CTR using a String value.
	 */
	public void setE01CTR(String newvalue) {
		fieldE01CTR.setString(newvalue);
	}

	/**
	 * Set field E01CTY using a String value.
	 */
	public void setE01CTY(String newvalue) {
		fieldE01CTY.setString(newvalue);
	}

	/**
	 * Set field E01CUN using a String value.
	 */
	public void setE01CUN(String newvalue) {
		fieldE01CUN.setString(newvalue);
	}

	/**
	 * Set numeric field E01CUN using a BigDecimal value.
	 */
	public void setE01CUN(BigDecimal newvalue) {
		fieldE01CUN.setBigDecimal(newvalue);
	}

	/**
	 * Set field E01NA1 using a String value.
	 */
	public void setE01NA1(String newvalue) {
		fieldE01NA1.setString(newvalue);
	}

	/**
	 * Set field E01NA2 using a String value.
	 */
	public void setE01NA2(String newvalue) {
		fieldE01NA2.setString(newvalue);
	}

	/**
	 * Set field E01NA3 using a String value.
	 */
	public void setE01NA3(String newvalue) {
		fieldE01NA3.setString(newvalue);
	}

	/**
	 * Set field E01NA4 using a String value.
	 */
	public void setE01NA4(String newvalue) {
		fieldE01NA4.setString(newvalue);
	}

	/**
	 * Set field H01MAS using a String value.
	 */
	public void setH01MAS(String newvalue) {
		fieldH01MAS.setString(newvalue);
	}

	/**
	 * Set field H01OPE using a String value.
	 */
	public void setH01OPE(String newvalue) {
		fieldH01OPE.setString(newvalue);
	}

	/**
	 * Set field H01PGM using a String value.
	 */
	public void setH01PGM(String newvalue) {
		fieldH01PGM.setString(newvalue);
	}

	/**
	 * Set field H01SCR using a String value.
	 */
	public void setH01SCR(String newvalue) {
		fieldH01SCR.setString(newvalue);
	}

	/**
	 * Set field H01TIM using a String value.
	 */
	public void setH01TIM(String newvalue) {
		fieldH01TIM.setString(newvalue);
	}

	/**
	 * Set field H01USR using a String value.
	 */
	public void setH01USR(String newvalue) {
		fieldH01USR.setString(newvalue);
	}

	/**
	 * Set field H01WK1 using a String value.
	 */
	public void setH01WK1(String newvalue) {
		fieldH01WK1.setString(newvalue);
	}

	/**
	 * Set field H01WK2 using a String value.
	 */
	public void setH01WK2(String newvalue) {
		fieldH01WK2.setString(newvalue);
	}

	/**
	 * Set field H01WK3 using a String value.
	 */
	public void setH01WK3(String newvalue) {
		fieldH01WK3.setString(newvalue);
	}
}