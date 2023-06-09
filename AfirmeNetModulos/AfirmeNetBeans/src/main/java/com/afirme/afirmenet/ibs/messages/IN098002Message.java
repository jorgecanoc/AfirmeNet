package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from IN098002 physical file
 * definition.
 * 
 * File level identifier is 1001005130855. Record format level identifier is
 * 4F240902BCCBE.
 */

public class IN098002Message extends MessageRecord {
	final int FIELDCOUNT = 18;
	private CharacterField fieldH02USERID = null;
	private CharacterField fieldH02PROGRM = null;
	private CharacterField fieldH02TIMSYS = null;
	private CharacterField fieldH02SCRCOD = null;
	private CharacterField fieldH02OPECOD = null;
	private CharacterField fieldH02FLGMAS = null;
	private CharacterField fieldH02FLGWK1 = null;
	private CharacterField fieldH02FLGWK2 = null;
	private CharacterField fieldH02FLGWK3 = null;
	private DecimalField fieldE02DEAACC = null;
	private DecimalField fieldE02PYMDT1 = null;
	private DecimalField fieldE02PYMDT2 = null;
	private DecimalField fieldE02PYMDT3 = null;
	private DecimalField fieldE02DLPPRI = null;
	private DecimalField fieldE02DLPINT = null;
	private DecimalField fieldE02DLPMOR = null;
	private DecimalField fieldE02DLPDED = null;
	private CharacterField fieldE02PYMSTS = null;

	/**
	 * Constructor for IN098002Message.
	 */
	public IN098002Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 142;
		fileid = "1001005130855";
		recordid = "4F240902BCCBE";
		message = new byte[getByteLength()];
		formatname = "IN098002";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "H02USERID";
		tagnames[0] = "H02USERID";
		fields[0] = fieldH02USERID = new CharacterField(message,
				HEADERSIZE + 0, 10, "H02USERID");
		fieldnames[1] = "H02PROGRM";
		tagnames[1] = "H02PROGRM";
		fields[1] = fieldH02PROGRM = new CharacterField(message,
				HEADERSIZE + 10, 10, "H02PROGRM");
		fieldnames[2] = "H02TIMSYS";
		tagnames[2] = "H02TIMSYS";
		fields[2] = fieldH02TIMSYS = new CharacterField(message,
				HEADERSIZE + 20, 12, "H02TIMSYS");
		fieldnames[3] = "H02SCRCOD";
		tagnames[3] = "H02SCRCOD";
		fields[3] = fieldH02SCRCOD = new CharacterField(message,
				HEADERSIZE + 32, 2, "H02SCRCOD");
		fieldnames[4] = "H02OPECOD";
		tagnames[4] = "H02OPECOD";
		fields[4] = fieldH02OPECOD = new CharacterField(message,
				HEADERSIZE + 34, 4, "H02OPECOD");
		fieldnames[5] = "H02FLGMAS";
		tagnames[5] = "H02FLGMAS";
		fields[5] = fieldH02FLGMAS = new CharacterField(message,
				HEADERSIZE + 38, 1, "H02FLGMAS");
		fieldnames[6] = "H02FLGWK1";
		tagnames[6] = "H02FLGWK1";
		fields[6] = fieldH02FLGWK1 = new CharacterField(message,
				HEADERSIZE + 39, 1, "H02FLGWK1");
		fieldnames[7] = "H02FLGWK2";
		tagnames[7] = "H02FLGWK2";
		fields[7] = fieldH02FLGWK2 = new CharacterField(message,
				HEADERSIZE + 40, 1, "H02FLGWK2");
		fieldnames[8] = "H02FLGWK3";
		tagnames[8] = "H02FLGWK3";
		fields[8] = fieldH02FLGWK3 = new CharacterField(message,
				HEADERSIZE + 41, 1, "H02FLGWK3");
		fieldnames[9] = "E02DEAACC";
		tagnames[9] = "E02DEAACC";
		fields[9] = fieldE02DEAACC = new DecimalField(message, HEADERSIZE + 42,
				13, 0, "E02DEAACC");
		fieldnames[10] = "E02PYMDT1";
		tagnames[10] = "E02PYMDT1";
		fields[10] = fieldE02PYMDT1 = new DecimalField(message,
				HEADERSIZE + 55, 3, 0, "E02PYMDT1");
		fieldnames[11] = "E02PYMDT2";
		tagnames[11] = "E02PYMDT2";
		fields[11] = fieldE02PYMDT2 = new DecimalField(message,
				HEADERSIZE + 58, 3, 0, "E02PYMDT2");
		fieldnames[12] = "E02PYMDT3";
		tagnames[12] = "E02PYMDT3";
		fields[12] = fieldE02PYMDT3 = new DecimalField(message,
				HEADERSIZE + 61, 3, 0, "E02PYMDT3");
		fieldnames[13] = "E02DLPPRI";
		tagnames[13] = "E02DLPPRI";
		fields[13] = fieldE02DLPPRI = new DecimalField(message,
				HEADERSIZE + 64, 17, 2, "E02DLPPRI");
		fieldnames[14] = "E02DLPINT";
		tagnames[14] = "E02DLPINT";
		fields[14] = fieldE02DLPINT = new DecimalField(message,
				HEADERSIZE + 81, 17, 2, "E02DLPINT");
		fieldnames[15] = "E02DLPMOR";
		tagnames[15] = "E02DLPMOR";
		fields[15] = fieldE02DLPMOR = new DecimalField(message,
				HEADERSIZE + 98, 17, 2, "E02DLPMOR");
		fieldnames[16] = "E02DLPDED";
		tagnames[16] = "E02DLPDED";
		fields[16] = fieldE02DLPDED = new DecimalField(message,
				HEADERSIZE + 115, 17, 2, "E02DLPDED");
		fieldnames[17] = "E02PYMSTS";
		tagnames[17] = "E02PYMSTS";
		fields[17] = fieldE02PYMSTS = new CharacterField(message,
				HEADERSIZE + 132, 10, "E02PYMSTS");
	}

	/**
	 * Return value of numeric field E02DEAACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02DEAACC() {
		return fieldE02DEAACC.getBigDecimal();
	}

	/**
	 * Return value of numeric field E02DLPDED as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02DLPDED() {
		return fieldE02DLPDED.getBigDecimal();
	}

	/**
	 * Return value of numeric field E02DLPINT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02DLPINT() {
		return fieldE02DLPINT.getBigDecimal();
	}

	/**
	 * Return value of numeric field E02DLPMOR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02DLPMOR() {
		return fieldE02DLPMOR.getBigDecimal();
	}

	/**
	 * Return value of numeric field E02DLPPRI as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02DLPPRI() {
		return fieldE02DLPPRI.getBigDecimal();
	}

	/**
	 * Return value of numeric field E02PYMDT1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02PYMDT1() {
		return fieldE02PYMDT1.getBigDecimal();
	}

	/**
	 * Return value of numeric field E02PYMDT2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02PYMDT2() {
		return fieldE02PYMDT2.getBigDecimal();
	}

	/**
	 * Return value of numeric field E02PYMDT3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02PYMDT3() {
		return fieldE02PYMDT3.getBigDecimal();
	}

	/**
	 * Get value of field E02DEAACC as a String.
	 */
	public String getE02DEAACC() {
		return fieldE02DEAACC.getString();
	}

	/**
	 * Get value of field E02DLPDED as a String.
	 */
	public String getE02DLPDED() {
		return fieldE02DLPDED.getString();
	}

	/**
	 * Get value of field E02DLPINT as a String.
	 */
	public String getE02DLPINT() {
		return fieldE02DLPINT.getString();
	}

	/**
	 * Get value of field E02DLPMOR as a String.
	 */
	public String getE02DLPMOR() {
		return fieldE02DLPMOR.getString();
	}

	/**
	 * Get value of field E02DLPPRI as a String.
	 */
	public String getE02DLPPRI() {
		return fieldE02DLPPRI.getString();
	}

	/**
	 * Get value of field E02PYMDT1 as a String.
	 */
	public String getE02PYMDT1() {
		return fieldE02PYMDT1.getString();
	}

	/**
	 * Get value of field E02PYMDT2 as a String.
	 */
	public String getE02PYMDT2() {
		return fieldE02PYMDT2.getString();
	}

	/**
	 * Get value of field E02PYMDT3 as a String.
	 */
	public String getE02PYMDT3() {
		return fieldE02PYMDT3.getString();
	}

	/**
	 * Get value of field E02PYMSTS as a String.
	 */
	public String getE02PYMSTS() {
		return fieldE02PYMSTS.getString();
	}

	/**
	 * Get value of field H02FLGMAS as a String.
	 */
	public String getH02FLGMAS() {
		return fieldH02FLGMAS.getString();
	}

	/**
	 * Get value of field H02FLGWK1 as a String.
	 */
	public String getH02FLGWK1() {
		return fieldH02FLGWK1.getString();
	}

	/**
	 * Get value of field H02FLGWK2 as a String.
	 */
	public String getH02FLGWK2() {
		return fieldH02FLGWK2.getString();
	}

	/**
	 * Get value of field H02FLGWK3 as a String.
	 */
	public String getH02FLGWK3() {
		return fieldH02FLGWK3.getString();
	}

	/**
	 * Get value of field H02OPECOD as a String.
	 */
	public String getH02OPECOD() {
		return fieldH02OPECOD.getString();
	}

	/**
	 * Get value of field H02PROGRM as a String.
	 */
	public String getH02PROGRM() {
		return fieldH02PROGRM.getString();
	}

	/**
	 * Get value of field H02SCRCOD as a String.
	 */
	public String getH02SCRCOD() {
		return fieldH02SCRCOD.getString();
	}

	/**
	 * Get value of field H02TIMSYS as a String.
	 */
	public String getH02TIMSYS() {
		return fieldH02TIMSYS.getString();
	}

	/**
	 * Get value of field H02USERID as a String.
	 */
	public String getH02USERID() {
		return fieldH02USERID.getString();
	}

	/**
	 * Set field E02DEAACC using a String value.
	 */
	public void setE02DEAACC(String newvalue) {
		fieldE02DEAACC.setString(newvalue);
	}

	/**
	 * Set numeric field E02DEAACC using a BigDecimal value.
	 */
	public void setE02DEAACC(BigDecimal newvalue) {
		fieldE02DEAACC.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02DLPDED using a String value.
	 */
	public void setE02DLPDED(String newvalue) {
		fieldE02DLPDED.setString(newvalue);
	}

	/**
	 * Set numeric field E02DLPDED using a BigDecimal value.
	 */
	public void setE02DLPDED(BigDecimal newvalue) {
		fieldE02DLPDED.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02DLPINT using a String value.
	 */
	public void setE02DLPINT(String newvalue) {
		fieldE02DLPINT.setString(newvalue);
	}

	/**
	 * Set numeric field E02DLPINT using a BigDecimal value.
	 */
	public void setE02DLPINT(BigDecimal newvalue) {
		fieldE02DLPINT.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02DLPMOR using a String value.
	 */
	public void setE02DLPMOR(String newvalue) {
		fieldE02DLPMOR.setString(newvalue);
	}

	/**
	 * Set numeric field E02DLPMOR using a BigDecimal value.
	 */
	public void setE02DLPMOR(BigDecimal newvalue) {
		fieldE02DLPMOR.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02DLPPRI using a String value.
	 */
	public void setE02DLPPRI(String newvalue) {
		fieldE02DLPPRI.setString(newvalue);
	}

	/**
	 * Set numeric field E02DLPPRI using a BigDecimal value.
	 */
	public void setE02DLPPRI(BigDecimal newvalue) {
		fieldE02DLPPRI.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02PYMDT1 using a String value.
	 */
	public void setE02PYMDT1(String newvalue) {
		fieldE02PYMDT1.setString(newvalue);
	}

	/**
	 * Set numeric field E02PYMDT1 using a BigDecimal value.
	 */
	public void setE02PYMDT1(BigDecimal newvalue) {
		fieldE02PYMDT1.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02PYMDT2 using a String value.
	 */
	public void setE02PYMDT2(String newvalue) {
		fieldE02PYMDT2.setString(newvalue);
	}

	/**
	 * Set numeric field E02PYMDT2 using a BigDecimal value.
	 */
	public void setE02PYMDT2(BigDecimal newvalue) {
		fieldE02PYMDT2.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02PYMDT3 using a String value.
	 */
	public void setE02PYMDT3(String newvalue) {
		fieldE02PYMDT3.setString(newvalue);
	}

	/**
	 * Set numeric field E02PYMDT3 using a BigDecimal value.
	 */
	public void setE02PYMDT3(BigDecimal newvalue) {
		fieldE02PYMDT3.setBigDecimal(newvalue);
	}

	/**
	 * Set field E02PYMSTS using a String value.
	 */
	public void setE02PYMSTS(String newvalue) {
		fieldE02PYMSTS.setString(newvalue);
	}

	/**
	 * Set field H02FLGMAS using a String value.
	 */
	public void setH02FLGMAS(String newvalue) {
		fieldH02FLGMAS.setString(newvalue);
	}

	/**
	 * Set field H02FLGWK1 using a String value.
	 */
	public void setH02FLGWK1(String newvalue) {
		fieldH02FLGWK1.setString(newvalue);
	}

	/**
	 * Set field H02FLGWK2 using a String value.
	 */
	public void setH02FLGWK2(String newvalue) {
		fieldH02FLGWK2.setString(newvalue);
	}

	/**
	 * Set field H02FLGWK3 using a String value.
	 */
	public void setH02FLGWK3(String newvalue) {
		fieldH02FLGWK3.setString(newvalue);
	}

	/**
	 * Set field H02OPECOD using a String value.
	 */
	public void setH02OPECOD(String newvalue) {
		fieldH02OPECOD.setString(newvalue);
	}

	/**
	 * Set field H02PROGRM using a String value.
	 */
	public void setH02PROGRM(String newvalue) {
		fieldH02PROGRM.setString(newvalue);
	}

	/**
	 * Set field H02SCRCOD using a String value.
	 */
	public void setH02SCRCOD(String newvalue) {
		fieldH02SCRCOD.setString(newvalue);
	}

	/**
	 * Set field H02TIMSYS using a String value.
	 */
	public void setH02TIMSYS(String newvalue) {
		fieldH02TIMSYS.setString(newvalue);
	}

	/**
	 * Set field H02USERID using a String value.
	 */
	public void setH02USERID(String newvalue) {
		fieldH02USERID.setString(newvalue);
	}
}