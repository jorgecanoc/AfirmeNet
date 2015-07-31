package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from STOPDSJV physical file
 * definition.
 * 
 * File level identifier is 1000802211916. Record format level identifier is
 * 52C56450AFA0A.
 */

public class STOPDSJVMessage extends MessageRecord {
	final int FIELDCOUNT = 11;
	private CharacterField fieldSTOSTPUSER = null;
	private DecimalField fieldSTOSTPACC = null;
	private CharacterField fieldSTOSTPRMK = null;
	private DecimalField fieldSTOSTPDT1 = null;
	private DecimalField fieldSTOSTPDT2 = null;
	private DecimalField fieldSTOSTPDT3 = null;
	private DecimalField fieldSTOSTPFCK = null;
	private DecimalField fieldSTOSTPTCK = null;
	private DecimalField fieldSTOSTPAMT = null;
	private DecimalField fieldSTOSTPPTS = null;
	private CharacterField fieldSTOSTPFLG = null;

	/**
	 * Constructor for STOPDSJVMessage.
	 */
	public STOPDSJVMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */

	protected void createFields() {
		recordsize = 104;
		fileid = "1000802211916";
		recordid = "52C56450AFA0A";
		message = new byte[getByteLength()];
		formatname = "STOPDSJV";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "STOSTPUSER";
		tagnames[0] = "STOSTPUSER";
		fields[0] = fieldSTOSTPUSER = new CharacterField(message,
				HEADERSIZE + 0, 10, "STOSTPUSER");
		fieldnames[1] = "STOSTPACC";
		tagnames[1] = "STOSTPACC";
		fields[1] = fieldSTOSTPACC = new DecimalField(message, HEADERSIZE + 10,
				13, 0, "STOSTPACC");
		fieldnames[2] = "STOSTPRMK";
		tagnames[2] = "STOSTPRMK";
		fields[2] = fieldSTOSTPRMK = new CharacterField(message,
				HEADERSIZE + 23, 30, "STOSTPRMK");
		fieldnames[3] = "STOSTPDT1";
		tagnames[3] = "STOSTPDT1";
		fields[3] = fieldSTOSTPDT1 = new DecimalField(message, HEADERSIZE + 53,
				3, 0, "STOSTPDT1");
		fieldnames[4] = "STOSTPDT2";
		tagnames[4] = "STOSTPDT2";
		fields[4] = fieldSTOSTPDT2 = new DecimalField(message, HEADERSIZE + 56,
				3, 0, "STOSTPDT2");
		fieldnames[5] = "STOSTPDT3";
		tagnames[5] = "STOSTPDT3";
		fields[5] = fieldSTOSTPDT3 = new DecimalField(message, HEADERSIZE + 59,
				3, 0, "STOSTPDT3");
		fieldnames[6] = "STOSTPFCK";
		tagnames[6] = "STOSTPFCK";
		fields[6] = fieldSTOSTPFCK = new DecimalField(message, HEADERSIZE + 62,
				10, 0, "STOSTPFCK");
		fieldnames[7] = "STOSTPTCK";
		tagnames[7] = "STOSTPTCK";
		fields[7] = fieldSTOSTPTCK = new DecimalField(message, HEADERSIZE + 72,
				10, 0, "STOSTPTCK");
		fieldnames[8] = "STOSTPAMT";
		tagnames[8] = "STOSTPAMT";
		fields[8] = fieldSTOSTPAMT = new DecimalField(message, HEADERSIZE + 82,
				15, 2, "STOSTPAMT");
		fieldnames[9] = "STOSTPPTS";
		tagnames[9] = "STOSTPPTS";
		fields[9] = fieldSTOSTPPTS = new DecimalField(message, HEADERSIZE + 97,
				6, 0, "STOSTPPTS");
		fieldnames[10] = "STOSTPFLG";
		tagnames[10] = "STOSTPFLG";
		fields[10] = fieldSTOSTPFLG = new CharacterField(message,
				HEADERSIZE + 103, 1, "STOSTPFLG");
	}

	/**
	 * Return value of numeric field STOSTPACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPACC() {
		return fieldSTOSTPACC.getBigDecimal();
	}

	/**
	 * Return value of numeric field STOSTPAMT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPAMT() {
		return fieldSTOSTPAMT.getBigDecimal();
	}

	/**
	 * Return value of numeric field STOSTPDT1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPDT1() {
		return fieldSTOSTPDT1.getBigDecimal();
	}

	/**
	 * Return value of numeric field STOSTPDT2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPDT2() {
		return fieldSTOSTPDT2.getBigDecimal();
	}

	/**
	 * Return value of numeric field STOSTPDT3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPDT3() {
		return fieldSTOSTPDT3.getBigDecimal();
	}

	/**
	 * Return value of numeric field STOSTPFCK as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPFCK() {
		return fieldSTOSTPFCK.getBigDecimal();
	}

	/**
	 * Return value of numeric field STOSTPPTS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPPTS() {
		return fieldSTOSTPPTS.getBigDecimal();
	}

	/**
	 * Return value of numeric field STOSTPTCK as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTOSTPTCK() {
		return fieldSTOSTPTCK.getBigDecimal();
	}

	/**
	 * Get value of field STOSTPACC as a String.
	 */
	public String getSTOSTPACC() {
		return fieldSTOSTPACC.getString();
	}

	/**
	 * Get value of field STOSTPAMT as a String.
	 */
	public String getSTOSTPAMT() {
		return fieldSTOSTPAMT.getString();
	}

	/**
	 * Get value of field STOSTPDT1 as a String.
	 */
	public String getSTOSTPDT1() {
		return fieldSTOSTPDT1.getString();
	}

	/**
	 * Get value of field STOSTPDT2 as a String.
	 */
	public String getSTOSTPDT2() {
		return fieldSTOSTPDT2.getString();
	}

	/**
	 * Get value of field STOSTPDT3 as a String.
	 */
	public String getSTOSTPDT3() {
		return fieldSTOSTPDT3.getString();
	}

	/**
	 * Get value of field STOSTPFCK as a String.
	 */
	public String getSTOSTPFCK() {
		return fieldSTOSTPFCK.getString();
	}

	/**
	 * Get value of field STOSTPFLG as a String.
	 */
	public String getSTOSTPFLG() {
		return fieldSTOSTPFLG.getString();
	}

	/**
	 * Get value of field STOSTPPTS as a String.
	 */
	public String getSTOSTPPTS() {
		return fieldSTOSTPPTS.getString();
	}

	/**
	 * Get value of field STOSTPRMK as a String.
	 */
	public String getSTOSTPRMK() {
		return fieldSTOSTPRMK.getString();
	}

	/**
	 * Get value of field STOSTPTCK as a String.
	 */
	public String getSTOSTPTCK() {
		return fieldSTOSTPTCK.getString();
	}

	/**
	 * Get value of field STOSTPUSER as a String.
	 */
	public String getSTOSTPUSER() {
		return fieldSTOSTPUSER.getString();
	}

	/**
	 * Set field STOSTPACC using a String value.
	 */
	public void setSTOSTPACC(String newvalue) {
		fieldSTOSTPACC.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPACC using a BigDecimal value.
	 */
	public void setSTOSTPACC(BigDecimal newvalue) {
		fieldSTOSTPACC.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPAMT using a String value.
	 */
	public void setSTOSTPAMT(String newvalue) {
		fieldSTOSTPAMT.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPAMT using a BigDecimal value.
	 */
	public void setSTOSTPAMT(BigDecimal newvalue) {
		fieldSTOSTPAMT.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPDT1 using a String value.
	 */
	public void setSTOSTPDT1(String newvalue) {
		fieldSTOSTPDT1.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPDT1 using a BigDecimal value.
	 */
	public void setSTOSTPDT1(BigDecimal newvalue) {
		fieldSTOSTPDT1.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPDT2 using a String value.
	 */
	public void setSTOSTPDT2(String newvalue) {
		fieldSTOSTPDT2.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPDT2 using a BigDecimal value.
	 */
	public void setSTOSTPDT2(BigDecimal newvalue) {
		fieldSTOSTPDT2.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPDT3 using a String value.
	 */
	public void setSTOSTPDT3(String newvalue) {
		fieldSTOSTPDT3.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPDT3 using a BigDecimal value.
	 */
	public void setSTOSTPDT3(BigDecimal newvalue) {
		fieldSTOSTPDT3.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPFCK using a String value.
	 */
	public void setSTOSTPFCK(String newvalue) {
		fieldSTOSTPFCK.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPFCK using a BigDecimal value.
	 */
	public void setSTOSTPFCK(BigDecimal newvalue) {
		fieldSTOSTPFCK.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPFLG using a String value.
	 */
	public void setSTOSTPFLG(String newvalue) {
		fieldSTOSTPFLG.setString(newvalue);
	}

	/**
	 * Set field STOSTPPTS using a String value.
	 */
	public void setSTOSTPPTS(String newvalue) {
		fieldSTOSTPPTS.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPPTS using a BigDecimal value.
	 */
	public void setSTOSTPPTS(BigDecimal newvalue) {
		fieldSTOSTPPTS.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPRMK using a String value.
	 */
	public void setSTOSTPRMK(String newvalue) {
		fieldSTOSTPRMK.setString(newvalue);
	}

	/**
	 * Set field STOSTPTCK using a String value.
	 */
	public void setSTOSTPTCK(String newvalue) {
		fieldSTOSTPTCK.setString(newvalue);
	}

	/**
	 * Set numeric field STOSTPTCK using a BigDecimal value.
	 */
	public void setSTOSTPTCK(BigDecimal newvalue) {
		fieldSTOSTPTCK.setBigDecimal(newvalue);
	}

	/**
	 * Set field STOSTPUSER using a String value.
	 */
	public void setSTOSTPUSER(String newvalue) {
		fieldSTOSTPUSER.setString(newvalue);
	}
}