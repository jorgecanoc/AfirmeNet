package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from STMRDSJV01 physical file
 * definition.
 * 
 * File level identifier is 1090928115913. Record format level identifier is
 * 428723E1DBE71.
 */
@SuppressWarnings("rawtypes")
public class STMRDSJV01Message extends MessageRecord {
	final static String fldnames[] = { "RSTUSR", "RSTACC", "RSTCAF", "RSTFD1",
			"RSTFD2", "RSTFD3", "RSTTD1", "RSTTD2", "RSTTD3", "RSTFCK",
			"RSTTCK", "RSTFAM", "RSTTAM", "RSTFRC", "RSTFBL" };
	final static String tnames[] = { "RSTUSR", "RSTACC", "RSTCAF", "RSTFD1",
			"RSTFD2", "RSTFD3", "RSTTD1", "RSTTD2", "RSTTD3", "RSTFCK",
			"RSTTCK", "RSTFAM", "RSTTAM", "RSTFRC", "RSTFBL" };
	final static String fid = "1090928115913";
	final static String rid = "428723E1DBE71";
	final static String fmtname = "STMRDSJV01";
	final int FIELDCOUNT = 15;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldRSTUSR = null;
	private DecimalField fieldRSTACC = null;
	private CharacterField fieldRSTCAF = null;
	private DecimalField fieldRSTFD1 = null;
	private DecimalField fieldRSTFD2 = null;
	private DecimalField fieldRSTFD3 = null;
	private DecimalField fieldRSTTD1 = null;
	private DecimalField fieldRSTTD2 = null;
	private DecimalField fieldRSTTD3 = null;
	private DecimalField fieldRSTFCK = null;
	private DecimalField fieldRSTTCK = null;
	private DecimalField fieldRSTFAM = null;
	private DecimalField fieldRSTTAM = null;
	private DecimalField fieldRSTFRC = null;
	private DecimalField fieldRSTFBL = null;

	/**
	 * Constructor for STMRDSJV01Message.
	 */
	public STMRDSJV01Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 121;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldRSTUSR = new CharacterField(message, HEADERSIZE + 0,
				10, "RSTUSR");
		fields[1] = fieldRSTACC = new DecimalField(message, HEADERSIZE + 10,
				13, 0, "RSTACC");
		fields[2] = fieldRSTCAF = new CharacterField(message, HEADERSIZE + 23,
				1, "RSTCAF");
		fields[3] = fieldRSTFD1 = new DecimalField(message, HEADERSIZE + 24, 3,
				0, "RSTFD1");
		fields[4] = fieldRSTFD2 = new DecimalField(message, HEADERSIZE + 27, 3,
				0, "RSTFD2");
		fields[5] = fieldRSTFD3 = new DecimalField(message, HEADERSIZE + 30, 3,
				0, "RSTFD3");
		fields[6] = fieldRSTTD1 = new DecimalField(message, HEADERSIZE + 33, 3,
				0, "RSTTD1");
		fields[7] = fieldRSTTD2 = new DecimalField(message, HEADERSIZE + 36, 3,
				0, "RSTTD2");
		fields[8] = fieldRSTTD3 = new DecimalField(message, HEADERSIZE + 39, 3,
				0, "RSTTD3");
		fields[9] = fieldRSTFCK = new DecimalField(message, HEADERSIZE + 42,
				10, 0, "RSTFCK");
		fields[10] = fieldRSTTCK = new DecimalField(message, HEADERSIZE + 52,
				10, 0, "RSTTCK");
		fields[11] = fieldRSTFAM = new DecimalField(message, HEADERSIZE + 62,
				17, 2, "RSTFAM");
		fields[12] = fieldRSTTAM = new DecimalField(message, HEADERSIZE + 79,
				17, 2, "RSTTAM");
		fields[13] = fieldRSTFRC = new DecimalField(message, HEADERSIZE + 96,
				8, 0, "RSTFRC");
		fields[14] = fieldRSTFBL = new DecimalField(message, HEADERSIZE + 104,
				17, 2, "RSTFBL");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field RSTUSR using a String value.
	 */
	public void setRSTUSR(String newvalue) {
		fieldRSTUSR.setString(newvalue);
	}

	/**
	 * Get value of field RSTUSR as a String.
	 */
	public String getRSTUSR() {
		return fieldRSTUSR.getString();
	}

	/**
	 * Set field RSTACC using a String value.
	 */
	public void setRSTACC(String newvalue) {
		fieldRSTACC.setString(newvalue);
	}

	/**
	 * Get value of field RSTACC as a String.
	 */
	public String getRSTACC() {
		return fieldRSTACC.getString();
	}

	/**
	 * Set numeric field RSTACC using a BigDecimal value.
	 */
	public void setRSTACC(BigDecimal newvalue) {
		fieldRSTACC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTACC() {
		return fieldRSTACC.getBigDecimal();
	}

	/**
	 * Set field RSTCAF using a String value.
	 */
	public void setRSTCAF(String newvalue) {
		fieldRSTCAF.setString(newvalue);
	}

	/**
	 * Get value of field RSTCAF as a String.
	 */
	public String getRSTCAF() {
		return fieldRSTCAF.getString();
	}

	/**
	 * Set field RSTFD1 using a String value.
	 */
	public void setRSTFD1(String newvalue) {
		fieldRSTFD1.setString(newvalue);
	}

	/**
	 * Get value of field RSTFD1 as a String.
	 */
	public String getRSTFD1() {
		return fieldRSTFD1.getString();
	}

	/**
	 * Set numeric field RSTFD1 using a BigDecimal value.
	 */
	public void setRSTFD1(BigDecimal newvalue) {
		fieldRSTFD1.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTFD1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTFD1() {
		return fieldRSTFD1.getBigDecimal();
	}

	/**
	 * Set field RSTFD2 using a String value.
	 */
	public void setRSTFD2(String newvalue) {
		fieldRSTFD2.setString(newvalue);
	}

	/**
	 * Get value of field RSTFD2 as a String.
	 */
	public String getRSTFD2() {
		return fieldRSTFD2.getString();
	}

	/**
	 * Set numeric field RSTFD2 using a BigDecimal value.
	 */
	public void setRSTFD2(BigDecimal newvalue) {
		fieldRSTFD2.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTFD2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTFD2() {
		return fieldRSTFD2.getBigDecimal();
	}

	/**
	 * Set field RSTFD3 using a String value.
	 */
	public void setRSTFD3(String newvalue) {
		fieldRSTFD3.setString(newvalue);
	}

	/**
	 * Get value of field RSTFD3 as a String.
	 */
	public String getRSTFD3() {
		return fieldRSTFD3.getString();
	}

	/**
	 * Set numeric field RSTFD3 using a BigDecimal value.
	 */
	public void setRSTFD3(BigDecimal newvalue) {
		fieldRSTFD3.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTFD3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTFD3() {
		return fieldRSTFD3.getBigDecimal();
	}

	/**
	 * Set field RSTTD1 using a String value.
	 */
	public void setRSTTD1(String newvalue) {
		fieldRSTTD1.setString(newvalue);
	}

	/**
	 * Get value of field RSTTD1 as a String.
	 */
	public String getRSTTD1() {
		return fieldRSTTD1.getString();
	}

	/**
	 * Set numeric field RSTTD1 using a BigDecimal value.
	 */
	public void setRSTTD1(BigDecimal newvalue) {
		fieldRSTTD1.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTTD1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTTD1() {
		return fieldRSTTD1.getBigDecimal();
	}

	/**
	 * Set field RSTTD2 using a String value.
	 */
	public void setRSTTD2(String newvalue) {
		fieldRSTTD2.setString(newvalue);
	}

	/**
	 * Get value of field RSTTD2 as a String.
	 */
	public String getRSTTD2() {
		return fieldRSTTD2.getString();
	}

	/**
	 * Set numeric field RSTTD2 using a BigDecimal value.
	 */
	public void setRSTTD2(BigDecimal newvalue) {
		fieldRSTTD2.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTTD2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTTD2() {
		return fieldRSTTD2.getBigDecimal();
	}

	/**
	 * Set field RSTTD3 using a String value.
	 */
	public void setRSTTD3(String newvalue) {
		fieldRSTTD3.setString(newvalue);
	}

	/**
	 * Get value of field RSTTD3 as a String.
	 */
	public String getRSTTD3() {
		return fieldRSTTD3.getString();
	}

	/**
	 * Set numeric field RSTTD3 using a BigDecimal value.
	 */
	public void setRSTTD3(BigDecimal newvalue) {
		fieldRSTTD3.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTTD3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTTD3() {
		return fieldRSTTD3.getBigDecimal();
	}

	/**
	 * Set field RSTFCK using a String value.
	 */
	public void setRSTFCK(String newvalue) {
		fieldRSTFCK.setString(newvalue);
	}

	/**
	 * Get value of field RSTFCK as a String.
	 */
	public String getRSTFCK() {
		return fieldRSTFCK.getString();
	}

	/**
	 * Set numeric field RSTFCK using a BigDecimal value.
	 */
	public void setRSTFCK(BigDecimal newvalue) {
		fieldRSTFCK.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTFCK as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTFCK() {
		return fieldRSTFCK.getBigDecimal();
	}

	/**
	 * Set field RSTTCK using a String value.
	 */
	public void setRSTTCK(String newvalue) {
		fieldRSTTCK.setString(newvalue);
	}

	/**
	 * Get value of field RSTTCK as a String.
	 */
	public String getRSTTCK() {
		return fieldRSTTCK.getString();
	}

	/**
	 * Set numeric field RSTTCK using a BigDecimal value.
	 */
	public void setRSTTCK(BigDecimal newvalue) {
		fieldRSTTCK.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTTCK as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTTCK() {
		return fieldRSTTCK.getBigDecimal();
	}

	/**
	 * Set field RSTFAM using a String value.
	 */
	public void setRSTFAM(String newvalue) {
		fieldRSTFAM.setString(newvalue);
	}

	/**
	 * Get value of field RSTFAM as a String.
	 */
	public String getRSTFAM() {
		return fieldRSTFAM.getString();
	}

	/**
	 * Set numeric field RSTFAM using a BigDecimal value.
	 */
	public void setRSTFAM(BigDecimal newvalue) {
		fieldRSTFAM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTFAM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTFAM() {
		return fieldRSTFAM.getBigDecimal();
	}

	/**
	 * Set field RSTTAM using a String value.
	 */
	public void setRSTTAM(String newvalue) {
		fieldRSTTAM.setString(newvalue);
	}

	/**
	 * Get value of field RSTTAM as a String.
	 */
	public String getRSTTAM() {
		return fieldRSTTAM.getString();
	}

	/**
	 * Set numeric field RSTTAM using a BigDecimal value.
	 */
	public void setRSTTAM(BigDecimal newvalue) {
		fieldRSTTAM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTTAM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTTAM() {
		return fieldRSTTAM.getBigDecimal();
	}

	/**
	 * Set field RSTFRC using a String value.
	 */
	public void setRSTFRC(String newvalue) {
		fieldRSTFRC.setString(newvalue);
	}

	/**
	 * Get value of field RSTFRC as a String.
	 */
	public String getRSTFRC() {
		return fieldRSTFRC.getString();
	}

	/**
	 * Set numeric field RSTFRC using a BigDecimal value.
	 */
	public void setRSTFRC(BigDecimal newvalue) {
		fieldRSTFRC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTFRC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTFRC() {
		return fieldRSTFRC.getBigDecimal();
	}

	/**
	 * Set field RSTFBL using a String value.
	 */
	public void setRSTFBL(String newvalue) {
		fieldRSTFBL.setString(newvalue);
	}

	/**
	 * Get value of field RSTFBL as a String.
	 */
	public String getRSTFBL() {
		return fieldRSTFBL.getString();
	}

	/**
	 * Set numeric field RSTFBL using a BigDecimal value.
	 */
	public void setRSTFBL(BigDecimal newvalue) {
		fieldRSTFBL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field RSTFBL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalRSTFBL() {
		return fieldRSTFBL.getBigDecimal();
	}

}