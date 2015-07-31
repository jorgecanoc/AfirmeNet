package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from EDL030003 physical file
 * definition.
 * 
 * File level identifier is 1001020190654. Record format level identifier is
 * 3BD509F504439.
 */

public class EDL030003Message extends MessageRecord {
	final int FIELDCOUNT = 22;
	private CharacterField fieldH03USERID = null;
	private CharacterField fieldH03PROGRM = null;
	private CharacterField fieldH03TIMSYS = null;
	private CharacterField fieldH03SCRCOD = null;
	private CharacterField fieldH03OPECOD = null;
	private CharacterField fieldH03FLGMAS = null;
	private CharacterField fieldH03FLGWK1 = null;
	private CharacterField fieldH03FLGWK2 = null;
	private CharacterField fieldH03FLGWK3 = null;
	private DecimalField fieldE03NUMACC = null;
	private DecimalField fieldE03INIDT1 = null;
	private DecimalField fieldE03INIDT2 = null;
	private DecimalField fieldE03INIDT3 = null;
	private DecimalField fieldE03ENDDT1 = null;
	private DecimalField fieldE03ENDDT2 = null;
	private DecimalField fieldE03ENDDT3 = null;
	private CharacterField fieldE03TRACDE = null;
	private DecimalField fieldE03PRIAMN = null;
	private DecimalField fieldE03INTRTE = null;
	private DecimalField fieldE03NUMDYS = null;
	private DecimalField fieldE03INTAMN = null;
	private CharacterField fieldE03INDOPE = null;

	/**
	 * Constructor for EDL030003Message.
	 */
	public EDL030003Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 126;
		fileid = "1001020190654";
		recordid = "3BD509F504439";
		message = new byte[getByteLength()];
		formatname = "EDL030003";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "H03USERID";
		tagnames[0] = "H03USERID";
		fields[0] = fieldH03USERID = new CharacterField(message,
				HEADERSIZE + 0, 10, "H03USERID");
		fieldnames[1] = "H03PROGRM";
		tagnames[1] = "H03PROGRM";
		fields[1] = fieldH03PROGRM = new CharacterField(message,
				HEADERSIZE + 10, 10, "H03PROGRM");
		fieldnames[2] = "H03TIMSYS";
		tagnames[2] = "H03TIMSYS";
		fields[2] = fieldH03TIMSYS = new CharacterField(message,
				HEADERSIZE + 20, 12, "H03TIMSYS");
		fieldnames[3] = "H03SCRCOD";
		tagnames[3] = "H03SCRCOD";
		fields[3] = fieldH03SCRCOD = new CharacterField(message,
				HEADERSIZE + 32, 2, "H03SCRCOD");
		fieldnames[4] = "H03OPECOD";
		tagnames[4] = "H03OPECOD";
		fields[4] = fieldH03OPECOD = new CharacterField(message,
				HEADERSIZE + 34, 4, "H03OPECOD");
		fieldnames[5] = "H03FLGMAS";
		tagnames[5] = "H03FLGMAS";
		fields[5] = fieldH03FLGMAS = new CharacterField(message,
				HEADERSIZE + 38, 1, "H03FLGMAS");
		fieldnames[6] = "H03FLGWK1";
		tagnames[6] = "H03FLGWK1";
		fields[6] = fieldH03FLGWK1 = new CharacterField(message,
				HEADERSIZE + 39, 1, "H03FLGWK1");
		fieldnames[7] = "H03FLGWK2";
		tagnames[7] = "H03FLGWK2";
		fields[7] = fieldH03FLGWK2 = new CharacterField(message,
				HEADERSIZE + 40, 1, "H03FLGWK2");
		fieldnames[8] = "H03FLGWK3";
		tagnames[8] = "H03FLGWK3";
		fields[8] = fieldH03FLGWK3 = new CharacterField(message,
				HEADERSIZE + 41, 1, "H03FLGWK3");
		fieldnames[9] = "E03NUMACC";
		tagnames[9] = "E03NUMACC";
		fields[9] = fieldE03NUMACC = new DecimalField(message, HEADERSIZE + 42,
				13, 0, "E03NUMACC");
		fieldnames[10] = "E03INIDT1";
		tagnames[10] = "E03INIDT1";
		fields[10] = fieldE03INIDT1 = new DecimalField(message,
				HEADERSIZE + 55, 3, 0, "E03INIDT1");
		fieldnames[11] = "E03INIDT2";
		tagnames[11] = "E03INIDT2";
		fields[11] = fieldE03INIDT2 = new DecimalField(message,
				HEADERSIZE + 58, 3, 0, "E03INIDT2");
		fieldnames[12] = "E03INIDT3";
		tagnames[12] = "E03INIDT3";
		fields[12] = fieldE03INIDT3 = new DecimalField(message,
				HEADERSIZE + 61, 3, 0, "E03INIDT3");
		fieldnames[13] = "E03ENDDT1";
		tagnames[13] = "E03ENDDT1";
		fields[13] = fieldE03ENDDT1 = new DecimalField(message,
				HEADERSIZE + 64, 3, 0, "E03ENDDT1");
		fieldnames[14] = "E03ENDDT2";
		tagnames[14] = "E03ENDDT2";
		fields[14] = fieldE03ENDDT2 = new DecimalField(message,
				HEADERSIZE + 67, 3, 0, "E03ENDDT2");
		fieldnames[15] = "E03ENDDT3";
		tagnames[15] = "E03ENDDT3";
		fields[15] = fieldE03ENDDT3 = new DecimalField(message,
				HEADERSIZE + 70, 3, 0, "E03ENDDT3");
		fieldnames[16] = "E03TRACDE";
		tagnames[16] = "E03TRACDE";
		fields[16] = fieldE03TRACDE = new CharacterField(message,
				HEADERSIZE + 73, 2, "E03TRACDE");
		fieldnames[17] = "E03PRIAMN";
		tagnames[17] = "E03PRIAMN";
		fields[17] = fieldE03PRIAMN = new DecimalField(message,
				HEADERSIZE + 75, 17, 2, "E03PRIAMN");
		fieldnames[18] = "E03INTRTE";
		tagnames[18] = "E03INTRTE";
		fields[18] = fieldE03INTRTE = new DecimalField(message,
				HEADERSIZE + 92, 11, 6, "E03INTRTE");
		fieldnames[19] = "E03NUMDYS";
		tagnames[19] = "E03NUMDYS";
		fields[19] = fieldE03NUMDYS = new DecimalField(message,
				HEADERSIZE + 103, 5, 0, "E03NUMDYS");
		fieldnames[20] = "E03INTAMN";
		tagnames[20] = "E03INTAMN";
		fields[20] = fieldE03INTAMN = new DecimalField(message,
				HEADERSIZE + 108, 17, 2, "E03INTAMN");
		fieldnames[21] = "E03INDOPE";
		tagnames[21] = "E03INDOPE";
		fields[21] = fieldE03INDOPE = new CharacterField(message,
				HEADERSIZE + 125, 1, "E03INDOPE");
	}

	/**
	 * Set field H03USERID using a String value.
	 */
	public void setH03USERID(String newvalue) {
		fieldH03USERID.setString(newvalue);
	}

	/**
	 * Get value of field H03USERID as a String.
	 */
	public String getH03USERID() {
		return fieldH03USERID.getString();
	}

	/**
	 * Set field H03PROGRM using a String value.
	 */
	public void setH03PROGRM(String newvalue) {
		fieldH03PROGRM.setString(newvalue);
	}

	/**
	 * Get value of field H03PROGRM as a String.
	 */
	public String getH03PROGRM() {
		return fieldH03PROGRM.getString();
	}

	/**
	 * Set field H03TIMSYS using a String value.
	 */
	public void setH03TIMSYS(String newvalue) {
		fieldH03TIMSYS.setString(newvalue);
	}

	/**
	 * Get value of field H03TIMSYS as a String.
	 */
	public String getH03TIMSYS() {
		return fieldH03TIMSYS.getString();
	}

	/**
	 * Set field H03SCRCOD using a String value.
	 */
	public void setH03SCRCOD(String newvalue) {
		fieldH03SCRCOD.setString(newvalue);
	}

	/**
	 * Get value of field H03SCRCOD as a String.
	 */
	public String getH03SCRCOD() {
		return fieldH03SCRCOD.getString();
	}

	/**
	 * Set field H03OPECOD using a String value.
	 */
	public void setH03OPECOD(String newvalue) {
		fieldH03OPECOD.setString(newvalue);
	}

	/**
	 * Get value of field H03OPECOD as a String.
	 */
	public String getH03OPECOD() {
		return fieldH03OPECOD.getString();
	}

	/**
	 * Set field H03FLGMAS using a String value.
	 */
	public void setH03FLGMAS(String newvalue) {
		fieldH03FLGMAS.setString(newvalue);
	}

	/**
	 * Get value of field H03FLGMAS as a String.
	 */
	public String getH03FLGMAS() {
		return fieldH03FLGMAS.getString();
	}

	/**
	 * Set field H03FLGWK1 using a String value.
	 */
	public void setH03FLGWK1(String newvalue) {
		fieldH03FLGWK1.setString(newvalue);
	}

	/**
	 * Get value of field H03FLGWK1 as a String.
	 */
	public String getH03FLGWK1() {
		return fieldH03FLGWK1.getString();
	}

	/**
	 * Set field H03FLGWK2 using a String value.
	 */
	public void setH03FLGWK2(String newvalue) {
		fieldH03FLGWK2.setString(newvalue);
	}

	/**
	 * Get value of field H03FLGWK2 as a String.
	 */
	public String getH03FLGWK2() {
		return fieldH03FLGWK2.getString();
	}

	/**
	 * Set field H03FLGWK3 using a String value.
	 */
	public void setH03FLGWK3(String newvalue) {
		fieldH03FLGWK3.setString(newvalue);
	}

	/**
	 * Get value of field H03FLGWK3 as a String.
	 */
	public String getH03FLGWK3() {
		return fieldH03FLGWK3.getString();
	}

	/**
	 * Set field E03NUMACC using a String value.
	 */
	public void setE03NUMACC(String newvalue) {
		fieldE03NUMACC.setString(newvalue);
	}

	/**
	 * Get value of field E03NUMACC as a String.
	 */
	public String getE03NUMACC() {
		return fieldE03NUMACC.getString();
	}

	/**
	 * Set numeric field E03NUMACC using a BigDecimal value.
	 */
	public void setE03NUMACC(BigDecimal newvalue) {
		fieldE03NUMACC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03NUMACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03NUMACC() {
		return fieldE03NUMACC.getBigDecimal();
	}

	/**
	 * Set field E03INIDT1 using a String value.
	 */
	public void setE03INIDT1(String newvalue) {
		fieldE03INIDT1.setString(newvalue);
	}

	/**
	 * Get value of field E03INIDT1 as a String.
	 */
	public String getE03INIDT1() {
		return fieldE03INIDT1.getString();
	}

	/**
	 * Set numeric field E03INIDT1 using a BigDecimal value.
	 */
	public void setE03INIDT1(BigDecimal newvalue) {
		fieldE03INIDT1.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03INIDT1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03INIDT1() {
		return fieldE03INIDT1.getBigDecimal();
	}

	/**
	 * Set field E03INIDT2 using a String value.
	 */
	public void setE03INIDT2(String newvalue) {
		fieldE03INIDT2.setString(newvalue);
	}

	/**
	 * Get value of field E03INIDT2 as a String.
	 */
	public String getE03INIDT2() {
		return fieldE03INIDT2.getString();
	}

	/**
	 * Set numeric field E03INIDT2 using a BigDecimal value.
	 */
	public void setE03INIDT2(BigDecimal newvalue) {
		fieldE03INIDT2.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03INIDT2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03INIDT2() {
		return fieldE03INIDT2.getBigDecimal();
	}

	/**
	 * Set field E03INIDT3 using a String value.
	 */
	public void setE03INIDT3(String newvalue) {
		fieldE03INIDT3.setString(newvalue);
	}

	/**
	 * Get value of field E03INIDT3 as a String.
	 */
	public String getE03INIDT3() {
		return fieldE03INIDT3.getString();
	}

	/**
	 * Set numeric field E03INIDT3 using a BigDecimal value.
	 */
	public void setE03INIDT3(BigDecimal newvalue) {
		fieldE03INIDT3.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03INIDT3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03INIDT3() {
		return fieldE03INIDT3.getBigDecimal();
	}

	/**
	 * Set field E03ENDDT1 using a String value.
	 */
	public void setE03ENDDT1(String newvalue) {
		fieldE03ENDDT1.setString(newvalue);
	}

	/**
	 * Get value of field E03ENDDT1 as a String.
	 */
	public String getE03ENDDT1() {
		return fieldE03ENDDT1.getString();
	}

	/**
	 * Set numeric field E03ENDDT1 using a BigDecimal value.
	 */
	public void setE03ENDDT1(BigDecimal newvalue) {
		fieldE03ENDDT1.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03ENDDT1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03ENDDT1() {
		return fieldE03ENDDT1.getBigDecimal();
	}

	/**
	 * Set field E03ENDDT2 using a String value.
	 */
	public void setE03ENDDT2(String newvalue) {
		fieldE03ENDDT2.setString(newvalue);
	}

	/**
	 * Get value of field E03ENDDT2 as a String.
	 */
	public String getE03ENDDT2() {
		return fieldE03ENDDT2.getString();
	}

	/**
	 * Set numeric field E03ENDDT2 using a BigDecimal value.
	 */
	public void setE03ENDDT2(BigDecimal newvalue) {
		fieldE03ENDDT2.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03ENDDT2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03ENDDT2() {
		return fieldE03ENDDT2.getBigDecimal();
	}

	/**
	 * Set field E03ENDDT3 using a String value.
	 */
	public void setE03ENDDT3(String newvalue) {
		fieldE03ENDDT3.setString(newvalue);
	}

	/**
	 * Get value of field E03ENDDT3 as a String.
	 */
	public String getE03ENDDT3() {
		return fieldE03ENDDT3.getString();
	}

	/**
	 * Set numeric field E03ENDDT3 using a BigDecimal value.
	 */
	public void setE03ENDDT3(BigDecimal newvalue) {
		fieldE03ENDDT3.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03ENDDT3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03ENDDT3() {
		return fieldE03ENDDT3.getBigDecimal();
	}

	/**
	 * Set field E03TRACDE using a String value.
	 */
	public void setE03TRACDE(String newvalue) {
		fieldE03TRACDE.setString(newvalue);
	}

	/**
	 * Get value of field E03TRACDE as a String.
	 */
	public String getE03TRACDE() {
		return fieldE03TRACDE.getString();
	}

	/**
	 * Set field E03PRIAMN using a String value.
	 */
	public void setE03PRIAMN(String newvalue) {
		fieldE03PRIAMN.setString(newvalue);
	}

	/**
	 * Get value of field E03PRIAMN as a String.
	 */
	public String getE03PRIAMN() {
		return fieldE03PRIAMN.getString();
	}

	/**
	 * Set numeric field E03PRIAMN using a BigDecimal value.
	 */
	public void setE03PRIAMN(BigDecimal newvalue) {
		fieldE03PRIAMN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03PRIAMN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03PRIAMN() {
		return fieldE03PRIAMN.getBigDecimal();
	}

	/**
	 * Set field E03INTRTE using a String value.
	 */
	public void setE03INTRTE(String newvalue) {
		fieldE03INTRTE.setString(newvalue);
	}

	/**
	 * Get value of field E03INTRTE as a String.
	 */
	public String getE03INTRTE() {
		return fieldE03INTRTE.getString();
	}

	/**
	 * Set numeric field E03INTRTE using a BigDecimal value.
	 */
	public void setE03INTRTE(BigDecimal newvalue) {
		fieldE03INTRTE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03INTRTE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03INTRTE() {
		return fieldE03INTRTE.getBigDecimal();
	}

	/**
	 * Set field E03NUMDYS using a String value.
	 */
	public void setE03NUMDYS(String newvalue) {
		fieldE03NUMDYS.setString(newvalue);
	}

	/**
	 * Get value of field E03NUMDYS as a String.
	 */
	public String getE03NUMDYS() {
		return fieldE03NUMDYS.getString();
	}

	/**
	 * Set numeric field E03NUMDYS using a BigDecimal value.
	 */
	public void setE03NUMDYS(BigDecimal newvalue) {
		fieldE03NUMDYS.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03NUMDYS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03NUMDYS() {
		return fieldE03NUMDYS.getBigDecimal();
	}

	/**
	 * Set field E03INTAMN using a String value.
	 */
	public void setE03INTAMN(String newvalue) {
		fieldE03INTAMN.setString(newvalue);
	}

	/**
	 * Get value of field E03INTAMN as a String.
	 */
	public String getE03INTAMN() {
		return fieldE03INTAMN.getString();
	}

	/**
	 * Set numeric field E03INTAMN using a BigDecimal value.
	 */
	public void setE03INTAMN(BigDecimal newvalue) {
		fieldE03INTAMN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E03INTAMN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE03INTAMN() {
		return fieldE03INTAMN.getBigDecimal();
	}

	/**
	 * Set field E03INDOPE using a String value.
	 */
	public void setE03INDOPE(String newvalue) {
		fieldE03INDOPE.setString(newvalue);
	}

	/**
	 * Get value of field E03INDOPE as a String.
	 */
	public String getE03INDOPE() {
		return fieldE03INDOPE.getString();
	}

}