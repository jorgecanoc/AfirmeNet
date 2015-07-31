package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from IN036801 physical file
 * definition.
 * 
 * File level identifier is 1030507170636. Record format level identifier is
 * 5EE8AEE82442F.
 */
@SuppressWarnings("rawtypes")
public class IN036801Message extends MessageRecord {
	final static String fldnames[] = { "H68USERID", "H68PROGRM", "H68TIMSYS",
			"H68SCRCOD", "H68OPECOD", "H68FLGMAS", "H68FLGWK1", "H68FLGWK2",
			"H68FLGWK3", "E68RTRCCY", "E68RTRDTE", "E68RTRMUD", "E68RTREXR",
			"E68RTRKPR", "E68RTRKSR" };
	final static String tnames[] = { "H68USERID", "H68PROGRM", "H68TIMSYS",
			"H68SCRCOD", "H68OPECOD", "H68FLGMAS", "H68FLGWK1", "H68FLGWK2",
			"H68FLGWK3", "E68RTRCCY", "E68RTRDTE", "E68RTRMUD", "E68RTREXR",
			"E68RTRKPR", "E68RTRKSR" };
	final static String fid = "1030507170636";
	final static String rid = "5EE8AEE82442F";
	final static String fmtname = "IN036801";
	final int FIELDCOUNT = 15;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldH68USERID = null;
	private CharacterField fieldH68PROGRM = null;
	private CharacterField fieldH68TIMSYS = null;
	private CharacterField fieldH68SCRCOD = null;
	private CharacterField fieldH68OPECOD = null;
	private CharacterField fieldH68FLGMAS = null;
	private CharacterField fieldH68FLGWK1 = null;
	private CharacterField fieldH68FLGWK2 = null;
	private CharacterField fieldH68FLGWK3 = null;
	private CharacterField fieldE68RTRCCY = null;
	private CharacterField fieldE68RTRDTE = null;
	private CharacterField fieldE68RTRMUD = null;
	private DecimalField fieldE68RTREXR = null;
	private DecimalField fieldE68RTRKPR = null;
	private DecimalField fieldE68RTRKSR = null;

	/**
	 * Constructor for IN036801Message.
	 */
	public IN036801Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 95;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldH68USERID = new CharacterField(message,
				HEADERSIZE + 0, 10, "H68USERID");
		fields[1] = fieldH68PROGRM = new CharacterField(message,
				HEADERSIZE + 10, 10, "H68PROGRM");
		fields[2] = fieldH68TIMSYS = new CharacterField(message,
				HEADERSIZE + 20, 12, "H68TIMSYS");
		fields[3] = fieldH68SCRCOD = new CharacterField(message,
				HEADERSIZE + 32, 2, "H68SCRCOD");
		fields[4] = fieldH68OPECOD = new CharacterField(message,
				HEADERSIZE + 34, 4, "H68OPECOD");
		fields[5] = fieldH68FLGMAS = new CharacterField(message,
				HEADERSIZE + 38, 1, "H68FLGMAS");
		fields[6] = fieldH68FLGWK1 = new CharacterField(message,
				HEADERSIZE + 39, 1, "H68FLGWK1");
		fields[7] = fieldH68FLGWK2 = new CharacterField(message,
				HEADERSIZE + 40, 1, "H68FLGWK2");
		fields[8] = fieldH68FLGWK3 = new CharacterField(message,
				HEADERSIZE + 41, 1, "H68FLGWK3");
		fields[9] = fieldE68RTRCCY = new CharacterField(message,
				HEADERSIZE + 42, 3, "E68RTRCCY");
		fields[10] = fieldE68RTRDTE = new CharacterField(message,
				HEADERSIZE + 45, 8, "E68RTRDTE");
		fields[11] = fieldE68RTRMUD = new CharacterField(message,
				HEADERSIZE + 53, 3, "E68RTRMUD");
		fields[12] = fieldE68RTREXR = new DecimalField(message,
				HEADERSIZE + 56, 13, 6, "E68RTREXR");
		fields[13] = fieldE68RTRKPR = new DecimalField(message,
				HEADERSIZE + 69, 13, 6, "E68RTRKPR");
		fields[14] = fieldE68RTRKSR = new DecimalField(message,
				HEADERSIZE + 82, 13, 6, "E68RTRKSR");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field H68USERID using a String value.
	 */
	public void setH68USERID(String newvalue) {
		fieldH68USERID.setString(newvalue);
	}

	/**
	 * Get value of field H68USERID as a String.
	 */
	public String getH68USERID() {
		return fieldH68USERID.getString();
	}

	/**
	 * Set field H68PROGRM using a String value.
	 */
	public void setH68PROGRM(String newvalue) {
		fieldH68PROGRM.setString(newvalue);
	}

	/**
	 * Get value of field H68PROGRM as a String.
	 */
	public String getH68PROGRM() {
		return fieldH68PROGRM.getString();
	}

	/**
	 * Set field H68TIMSYS using a String value.
	 */
	public void setH68TIMSYS(String newvalue) {
		fieldH68TIMSYS.setString(newvalue);
	}

	/**
	 * Get value of field H68TIMSYS as a String.
	 */
	public String getH68TIMSYS() {
		return fieldH68TIMSYS.getString();
	}

	/**
	 * Set field H68SCRCOD using a String value.
	 */
	public void setH68SCRCOD(String newvalue) {
		fieldH68SCRCOD.setString(newvalue);
	}

	/**
	 * Get value of field H68SCRCOD as a String.
	 */
	public String getH68SCRCOD() {
		return fieldH68SCRCOD.getString();
	}

	/**
	 * Set field H68OPECOD using a String value.
	 */
	public void setH68OPECOD(String newvalue) {
		fieldH68OPECOD.setString(newvalue);
	}

	/**
	 * Get value of field H68OPECOD as a String.
	 */
	public String getH68OPECOD() {
		return fieldH68OPECOD.getString();
	}

	/**
	 * Set field H68FLGMAS using a String value.
	 */
	public void setH68FLGMAS(String newvalue) {
		fieldH68FLGMAS.setString(newvalue);
	}

	/**
	 * Get value of field H68FLGMAS as a String.
	 */
	public String getH68FLGMAS() {
		return fieldH68FLGMAS.getString();
	}

	/**
	 * Set field H68FLGWK1 using a String value.
	 */
	public void setH68FLGWK1(String newvalue) {
		fieldH68FLGWK1.setString(newvalue);
	}

	/**
	 * Get value of field H68FLGWK1 as a String.
	 */
	public String getH68FLGWK1() {
		return fieldH68FLGWK1.getString();
	}

	/**
	 * Set field H68FLGWK2 using a String value.
	 */
	public void setH68FLGWK2(String newvalue) {
		fieldH68FLGWK2.setString(newvalue);
	}

	/**
	 * Get value of field H68FLGWK2 as a String.
	 */
	public String getH68FLGWK2() {
		return fieldH68FLGWK2.getString();
	}

	/**
	 * Set field H68FLGWK3 using a String value.
	 */
	public void setH68FLGWK3(String newvalue) {
		fieldH68FLGWK3.setString(newvalue);
	}

	/**
	 * Get value of field H68FLGWK3 as a String.
	 */
	public String getH68FLGWK3() {
		return fieldH68FLGWK3.getString();
	}

	/**
	 * Set field E68RTRCCY using a String value.
	 */
	public void setE68RTRCCY(String newvalue) {
		fieldE68RTRCCY.setString(newvalue);
	}

	/**
	 * Get value of field E68RTRCCY as a String.
	 */
	public String getE68RTRCCY() {
		return fieldE68RTRCCY.getString();
	}

	/**
	 * Set field E68RTRDTE using a String value.
	 */
	public void setE68RTRDTE(String newvalue) {
		fieldE68RTRDTE.setString(newvalue);
	}

	/**
	 * Get value of field E68RTRDTE as a String.
	 */
	public String getE68RTRDTE() {
		return fieldE68RTRDTE.getString();
	}

	/**
	 * Set field E68RTRMUD using a String value.
	 */
	public void setE68RTRMUD(String newvalue) {
		fieldE68RTRMUD.setString(newvalue);
	}

	/**
	 * Get value of field E68RTRMUD as a String.
	 */
	public String getE68RTRMUD() {
		return fieldE68RTRMUD.getString();
	}

	/**
	 * Set field E68RTREXR using a String value.
	 */
	public void setE68RTREXR(String newvalue) {
		fieldE68RTREXR.setString(newvalue);
	}

	/**
	 * Get value of field E68RTREXR as a String.
	 */
	public String getE68RTREXR() {
		return fieldE68RTREXR.getString();
	}

	/**
	 * Set numeric field E68RTREXR using a BigDecimal value.
	 */
	public void setE68RTREXR(BigDecimal newvalue) {
		fieldE68RTREXR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E68RTREXR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE68RTREXR() {
		return fieldE68RTREXR.getBigDecimal();
	}

	/**
	 * Set field E68RTRKPR using a String value.
	 */
	public void setE68RTRKPR(String newvalue) {
		fieldE68RTRKPR.setString(newvalue);
	}

	/**
	 * Get value of field E68RTRKPR as a String.
	 */
	public String getE68RTRKPR() {
		return fieldE68RTRKPR.getString();
	}

	/**
	 * Set numeric field E68RTRKPR using a BigDecimal value.
	 */
	public void setE68RTRKPR(BigDecimal newvalue) {
		fieldE68RTRKPR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E68RTRKPR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE68RTRKPR() {
		return fieldE68RTRKPR.getBigDecimal();
	}

	/**
	 * Set field E68RTRKSR using a String value.
	 */
	public void setE68RTRKSR(String newvalue) {
		fieldE68RTRKSR.setString(newvalue);
	}

	/**
	 * Get value of field E68RTRKSR as a String.
	 */
	public String getE68RTRKSR() {
		return fieldE68RTRKSR.getString();
	}

	/**
	 * Set numeric field E68RTRKSR using a BigDecimal value.
	 */
	public void setE68RTRKSR(BigDecimal newvalue) {
		fieldE68RTRKSR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field E68RTRKSR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalE68RTRKSR() {
		return fieldE68RTRKSR.getBigDecimal();
	}

}