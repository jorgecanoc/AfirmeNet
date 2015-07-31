package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

@SuppressWarnings("rawtypes")
public class EDL014002Message extends MessageRecord {
	final static String fldnames[] = { "H02USERID", "H02PROGRM", "H02TIMSYS",
			"H02SCRCOD", "H02OPECOD", "H02FLGMAS", "H02FLGWK1", "H02FLGWK2",
			"H02FLGWK3", "E02DEAACC", "E02ACTION", "E02MSGTXT" };
	final static String tnames[] = { "H02USERID", "H02PROGRM", "H02TIMSYS",
			"H02SCRCOD", "H02OPECOD", "H02FLGMAS", "H02FLGWK1", "H02FLGWK2",
			"H02FLGWK3", "E02DEAACC", "E02ACTION", "E02MSGTXT" };
	final static String fid = "1010910133216";
	final static String rid = "5BB8A2B081886";
	final static String fmtname = "EDL014002";
	final int FIELDCOUNT = 12;
	private static Hashtable tlookup = new Hashtable();
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
	private CharacterField fieldE02ACTION = null;
	private CharacterField fieldE02MSGTXT = null;

	/**
	 * Constructor for EDL014002Message.
	 */
	public EDL014002Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 1056;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldH02USERID = new CharacterField(message,
				HEADERSIZE + 0, 10, "H02USERID");
		fields[1] = fieldH02PROGRM = new CharacterField(message,
				HEADERSIZE + 10, 10, "H02PROGRM");
		fields[2] = fieldH02TIMSYS = new CharacterField(message,
				HEADERSIZE + 20, 12, "H02TIMSYS");
		fields[3] = fieldH02SCRCOD = new CharacterField(message,
				HEADERSIZE + 32, 2, "H02SCRCOD");
		fields[4] = fieldH02OPECOD = new CharacterField(message,
				HEADERSIZE + 34, 4, "H02OPECOD");
		fields[5] = fieldH02FLGMAS = new CharacterField(message,
				HEADERSIZE + 38, 1, "H02FLGMAS");
		fields[6] = fieldH02FLGWK1 = new CharacterField(message,
				HEADERSIZE + 39, 1, "H02FLGWK1");
		fields[7] = fieldH02FLGWK2 = new CharacterField(message,
				HEADERSIZE + 40, 1, "H02FLGWK2");
		fields[8] = fieldH02FLGWK3 = new CharacterField(message,
				HEADERSIZE + 41, 1, "H02FLGWK3");
		fields[9] = fieldE02DEAACC = new DecimalField(message, HEADERSIZE + 42,
				13, 0, "E02DEAACC");
		fields[10] = fieldE02ACTION = new CharacterField(message,
				HEADERSIZE + 55, 1, "E02ACTION");
		fields[11] = fieldE02MSGTXT = new CharacterField(message,
				HEADERSIZE + 56, 1000, "E02MSGTXT");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field H02USERID using a String value.
	 */
	public void setH02USERID(String newvalue) {
		fieldH02USERID.setString(newvalue);
	}

	/**
	 * Get value of field H02USERID as a String.
	 */
	public String getH02USERID() {
		return fieldH02USERID.getString();
	}

	/**
	 * Set field H02PROGRM using a String value.
	 */
	public void setH02PROGRM(String newvalue) {
		fieldH02PROGRM.setString(newvalue);
	}

	/**
	 * Get value of field H02PROGRM as a String.
	 */
	public String getH02PROGRM() {
		return fieldH02PROGRM.getString();
	}

	/**
	 * Set field H02TIMSYS using a String value.
	 */
	public void setH02TIMSYS(String newvalue) {
		fieldH02TIMSYS.setString(newvalue);
	}

	/**
	 * Get value of field H02TIMSYS as a String.
	 */
	public String getH02TIMSYS() {
		return fieldH02TIMSYS.getString();
	}

	/**
	 * Set field H02SCRCOD using a String value.
	 */
	public void setH02SCRCOD(String newvalue) {
		fieldH02SCRCOD.setString(newvalue);
	}

	/**
	 * Get value of field H02SCRCOD as a String.
	 */
	public String getH02SCRCOD() {
		return fieldH02SCRCOD.getString();
	}

	/**
	 * Set field H02OPECOD using a String value.
	 */
	public void setH02OPECOD(String newvalue) {
		fieldH02OPECOD.setString(newvalue);
	}

	/**
	 * Get value of field H02OPECOD as a String.
	 */
	public String getH02OPECOD() {
		return fieldH02OPECOD.getString();
	}

	/**
	 * Set field H02FLGMAS using a String value.
	 */
	public void setH02FLGMAS(String newvalue) {
		fieldH02FLGMAS.setString(newvalue);
	}

	/**
	 * Get value of field H02FLGMAS as a String.
	 */
	public String getH02FLGMAS() {
		return fieldH02FLGMAS.getString();
	}

	/**
	 * Set field H02FLGWK1 using a String value.
	 */
	public void setH02FLGWK1(String newvalue) {
		fieldH02FLGWK1.setString(newvalue);
	}

	/**
	 * Get value of field H02FLGWK1 as a String.
	 */
	public String getH02FLGWK1() {
		return fieldH02FLGWK1.getString();
	}

	/**
	 * Set field H02FLGWK2 using a String value.
	 */
	public void setH02FLGWK2(String newvalue) {
		fieldH02FLGWK2.setString(newvalue);
	}

	/**
	 * Get value of field H02FLGWK2 as a String.
	 */
	public String getH02FLGWK2() {
		return fieldH02FLGWK2.getString();
	}

	/**
	 * Set field H02FLGWK3 using a String value.
	 */
	public void setH02FLGWK3(String newvalue) {
		fieldH02FLGWK3.setString(newvalue);
	}

	/**
	 * Get value of field H02FLGWK3 as a String.
	 */
	public String getH02FLGWK3() {
		return fieldH02FLGWK3.getString();
	}

	/**
	 * Set field E02DEAACC using a String value.
	 */
	public void setE02DEAACC(String newvalue) {
		fieldE02DEAACC.setString(newvalue);
	}

	/**
	 * Get value of field E02DEAACC as a String.
	 */
	public String getE02DEAACC() {
		return fieldE02DEAACC.getString();
	}

	/**
	 * Set numeric field E02DEAACC using a BigDecimal value.
	 */
	public void setE02DEAACC(BigDecimal newvalue) {
		fieldE02DEAACC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E02DEAACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE02DEAACC() {
		return fieldE02DEAACC.getBigDecimal();
	}

	/**
	 * Set field E02ACTION using a String value.
	 */
	public void setE02ACTION(String newvalue) {
		fieldE02ACTION.setString(newvalue);
	}

	/**
	 * Get value of field E02ACTION as a String.
	 */
	public String getE02ACTION() {
		return fieldE02ACTION.getString();
	}

	/**
	 * Set field E02MSGTXT using a String value.
	 */
	public void setE02MSGTXT(String newvalue) {
		fieldE02MSGTXT.setString(newvalue);
	}

	/**
	 * Get value of field E02MSGTXT as a String.
	 */
	public String getE02MSGTXT() {
		return fieldE02MSGTXT.getString();
	}

	public String getMessageNet() {
		return new String(message);
	}

	/**
	 * This method is used to assist in debug of applications. It returns a
	 * String that contains the contents of all the fields of this message.
	 * 
	 * @return a String that contains the format name and all field names and
	 *         values.
	 */
	public String toString2() {
		StringBuffer sb = new StringBuffer();

		sb.append(formatname);
		sb.append("Message");

		for (int i = 0; i < fields.length; i++) {
			sb.append(":\n");
			sb.append(fieldnames[i]);
			sb.append("=<");
			sb.append(fields[i].getString());
			sb.append(">");
		}

		return sb.toString();
	}
}
