package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from STMSDSJV physical file
 * definition.
 * 
 * File level identifier is 1030723105757. Record format level identifier is
 * 3A7D45C35595A.
 */
@SuppressWarnings("rawtypes")
public class STMSDSJVMessage extends MessageRecord {
	final static String fldnames[] = { "STMUSR", "STMACC", "STMCDE", "STMNAR",
			"STMBD1", "STMBD2", "STMBD3", "STMCKN", "STMBBL", "STMAMT",
			"STMDCC", "STMEBL", "STMREC", "STMMEM", "STMEND", "STMDRR",
			"STMNNAR", "STMNA1", "STMNA2", "STMNA3", "STMNA4", "STMNA5",
			"STMNA6", "STMNA7", "STMNA8", "STMNA9" };
	final static String tnames[] = { "STMUSR", "STMACC", "STMCDE", "STMNAR",
			"STMBD1", "STMBD2", "STMBD3", "STMCKN", "STMBBL", "STMAMT",
			"STMDCC", "STMEBL", "STMREC", "STMMEM", "STMEND", "STMDRR",
			"STMNNAR", "STMNA1", "STMNA2", "STMNA3", "STMNA4", "STMNA5",
			"STMNA6", "STMNA7", "STMNA8", "STMNA9" };
	final static String fid = "1030723105757";
	final static String rid = "3A7D45C35595A";
	final static String fmtname = "STMSDSJV";
	final int FIELDCOUNT = 26;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldSTMUSR = null;
	private DecimalField fieldSTMACC = null;
	private CharacterField fieldSTMCDE = null;
	private CharacterField fieldSTMNAR = null;
	private DecimalField fieldSTMBD1 = null;
	private DecimalField fieldSTMBD2 = null;
	private DecimalField fieldSTMBD3 = null;
	private DecimalField fieldSTMCKN = null;
	private DecimalField fieldSTMBBL = null;
	private DecimalField fieldSTMAMT = null;
	private CharacterField fieldSTMDCC = null;
	private DecimalField fieldSTMEBL = null;
	private DecimalField fieldSTMREC = null;
	private CharacterField fieldSTMMEM = null;
	private CharacterField fieldSTMEND = null;
	private DecimalField fieldSTMDRR = null;
	private DecimalField fieldSTMNNAR = null;
	private CharacterField fieldSTMNA1 = null;
	private CharacterField fieldSTMNA2 = null;
	private CharacterField fieldSTMNA3 = null;
	private CharacterField fieldSTMNA4 = null;
	private CharacterField fieldSTMNA5 = null;
	private CharacterField fieldSTMNA6 = null;
	private CharacterField fieldSTMNA7 = null;
	private CharacterField fieldSTMNA8 = null;
	private CharacterField fieldSTMNA9 = null;

	/**
	 * Constructor for STMSDSJVMessage.
	 */
	public STMSDSJVMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 420;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldSTMUSR = new CharacterField(message, HEADERSIZE + 0,
				10, "STMUSR");
		fields[1] = fieldSTMACC = new DecimalField(message, HEADERSIZE + 10,
				13, 0, "STMACC");
		fields[2] = fieldSTMCDE = new CharacterField(message, HEADERSIZE + 23,
				2, "STMCDE");
		fields[3] = fieldSTMNAR = new CharacterField(message, HEADERSIZE + 25,
				30, "STMNAR");
		fields[4] = fieldSTMBD1 = new DecimalField(message, HEADERSIZE + 55, 3,
				0, "STMBD1");
		fields[5] = fieldSTMBD2 = new DecimalField(message, HEADERSIZE + 58, 3,
				0, "STMBD2");
		fields[6] = fieldSTMBD3 = new DecimalField(message, HEADERSIZE + 61, 3,
				0, "STMBD3");
		fields[7] = fieldSTMCKN = new DecimalField(message, HEADERSIZE + 64,
				10, 0, "STMCKN");
		fields[8] = fieldSTMBBL = new DecimalField(message, HEADERSIZE + 74,
				17, 2, "STMBBL");
		fields[9] = fieldSTMAMT = new DecimalField(message, HEADERSIZE + 91,
				17, 2, "STMAMT");
		fields[10] = fieldSTMDCC = new CharacterField(message,
				HEADERSIZE + 108, 1, "STMDCC");
		fields[11] = fieldSTMEBL = new DecimalField(message, HEADERSIZE + 109,
				17, 2, "STMEBL");
		fields[12] = fieldSTMREC = new DecimalField(message, HEADERSIZE + 126,
				8, 0, "STMREC");
		fields[13] = fieldSTMMEM = new CharacterField(message,
				HEADERSIZE + 134, 4, "STMMEM");
		fields[14] = fieldSTMEND = new CharacterField(message,
				HEADERSIZE + 138, 1, "STMEND");
		fields[15] = fieldSTMDRR = new DecimalField(message, HEADERSIZE + 139,
				8, 0, "STMDRR");
		fields[16] = fieldSTMNNAR = new DecimalField(message, HEADERSIZE + 147,
				3, 0, "STMNNAR");
		fields[17] = fieldSTMNA1 = new CharacterField(message,
				HEADERSIZE + 150, 30, "STMNA1");
		fields[18] = fieldSTMNA2 = new CharacterField(message,
				HEADERSIZE + 180, 30, "STMNA2");
		fields[19] = fieldSTMNA3 = new CharacterField(message,
				HEADERSIZE + 210, 30, "STMNA3");
		fields[20] = fieldSTMNA4 = new CharacterField(message,
				HEADERSIZE + 240, 30, "STMNA4");
		fields[21] = fieldSTMNA5 = new CharacterField(message,
				HEADERSIZE + 270, 30, "STMNA5");
		fields[22] = fieldSTMNA6 = new CharacterField(message,
				HEADERSIZE + 300, 30, "STMNA6");
		fields[23] = fieldSTMNA7 = new CharacterField(message,
				HEADERSIZE + 330, 30, "STMNA7");
		fields[24] = fieldSTMNA8 = new CharacterField(message,
				HEADERSIZE + 360, 30, "STMNA8");
		fields[25] = fieldSTMNA9 = new CharacterField(message,
				HEADERSIZE + 390, 30, "STMNA9");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field STMUSR using a String value.
	 */
	public void setSTMUSR(String newvalue) {
		fieldSTMUSR.setString(newvalue);
	}

	/**
	 * Get value of field STMUSR as a String.
	 */
	public String getSTMUSR() {
		return fieldSTMUSR.getString();
	}

	/**
	 * Set field STMACC using a String value.
	 */
	public void setSTMACC(String newvalue) {
		fieldSTMACC.setString(newvalue);
	}

	/**
	 * Get value of field STMACC as a String.
	 */
	public String getSTMACC() {
		return fieldSTMACC.getString();
	}

	/**
	 * Set numeric field STMACC using a BigDecimal value.
	 */
	public void setSTMACC(BigDecimal newvalue) {
		fieldSTMACC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMACC() {
		return fieldSTMACC.getBigDecimal();
	}

	/**
	 * Set field STMCDE using a String value.
	 */
	public void setSTMCDE(String newvalue) {
		fieldSTMCDE.setString(newvalue);
	}

	/**
	 * Get value of field STMCDE as a String.
	 */
	public String getSTMCDE() {
		return fieldSTMCDE.getString();
	}

	/**
	 * Set field STMNAR using a String value.
	 */
	public void setSTMNAR(String newvalue) {
		fieldSTMNAR.setString(newvalue);
	}

	/**
	 * Get value of field STMNAR as a String.
	 */
	public String getSTMNAR() {
		return fieldSTMNAR.getString();
	}

	/**
	 * Set field STMBD1 using a String value.
	 */
	public void setSTMBD1(String newvalue) {
		fieldSTMBD1.setString(newvalue);
	}

	/**
	 * Get value of field STMBD1 as a String.
	 */
	public String getSTMBD1() {
		return fieldSTMBD1.getString();
	}

	/**
	 * Set numeric field STMBD1 using a BigDecimal value.
	 */
	public void setSTMBD1(BigDecimal newvalue) {
		fieldSTMBD1.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMBD1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMBD1() {
		return fieldSTMBD1.getBigDecimal();
	}

	/**
	 * Set field STMBD2 using a String value.
	 */
	public void setSTMBD2(String newvalue) {
		fieldSTMBD2.setString(newvalue);
	}

	/**
	 * Get value of field STMBD2 as a String.
	 */
	public String getSTMBD2() {
		return fieldSTMBD2.getString();
	}

	/**
	 * Set numeric field STMBD2 using a BigDecimal value.
	 */
	public void setSTMBD2(BigDecimal newvalue) {
		fieldSTMBD2.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMBD2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMBD2() {
		return fieldSTMBD2.getBigDecimal();
	}

	/**
	 * Set field STMBD3 using a String value.
	 */
	public void setSTMBD3(String newvalue) {
		fieldSTMBD3.setString(newvalue);
	}

	/**
	 * Get value of field STMBD3 as a String.
	 */
	public String getSTMBD3() {
		return fieldSTMBD3.getString();
	}

	/**
	 * Set numeric field STMBD3 using a BigDecimal value.
	 */
	public void setSTMBD3(BigDecimal newvalue) {
		fieldSTMBD3.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMBD3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMBD3() {
		return fieldSTMBD3.getBigDecimal();
	}

	/**
	 * Set field STMCKN using a String value.
	 */
	public void setSTMCKN(String newvalue) {
		fieldSTMCKN.setString(newvalue);
	}

	/**
	 * Get value of field STMCKN as a String.
	 */
	public String getSTMCKN() {
		return fieldSTMCKN.getString();
	}

	/**
	 * Set numeric field STMCKN using a BigDecimal value.
	 */
	public void setSTMCKN(BigDecimal newvalue) {
		fieldSTMCKN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMCKN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMCKN() {
		return fieldSTMCKN.getBigDecimal();
	}

	/**
	 * Set field STMBBL using a String value.
	 */
	public void setSTMBBL(String newvalue) {
		fieldSTMBBL.setString(newvalue);
	}

	/**
	 * Get value of field STMBBL as a String.
	 */
	public String getSTMBBL() {
		return fieldSTMBBL.getString();
	}

	/**
	 * Set numeric field STMBBL using a BigDecimal value.
	 */
	public void setSTMBBL(BigDecimal newvalue) {
		fieldSTMBBL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMBBL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMBBL() {
		return fieldSTMBBL.getBigDecimal();
	}

	/**
	 * Set field STMAMT using a String value.
	 */
	public void setSTMAMT(String newvalue) {
		fieldSTMAMT.setString(newvalue);
	}

	/**
	 * Get value of field STMAMT as a String.
	 */
	public String getSTMAMT() {
		return fieldSTMAMT.getString();
	}

	/**
	 * Set numeric field STMAMT using a BigDecimal value.
	 */
	public void setSTMAMT(BigDecimal newvalue) {
		fieldSTMAMT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMAMT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMAMT() {
		return fieldSTMAMT.getBigDecimal();
	}

	/**
	 * Set field STMDCC using a String value.
	 */
	public void setSTMDCC(String newvalue) {
		fieldSTMDCC.setString(newvalue);
	}

	/**
	 * Get value of field STMDCC as a String.
	 */
	public String getSTMDCC() {
		return fieldSTMDCC.getString();
	}

	/**
	 * Set field STMEBL using a String value.
	 */
	public void setSTMEBL(String newvalue) {
		fieldSTMEBL.setString(newvalue);
	}

	/**
	 * Get value of field STMEBL as a String.
	 */
	public String getSTMEBL() {
		return fieldSTMEBL.getString();
	}

	/**
	 * Set numeric field STMEBL using a BigDecimal value.
	 */
	public void setSTMEBL(BigDecimal newvalue) {
		fieldSTMEBL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMEBL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMEBL() {
		return fieldSTMEBL.getBigDecimal();
	}

	/**
	 * Set field STMREC using a String value.
	 */
	public void setSTMREC(String newvalue) {
		fieldSTMREC.setString(newvalue);
	}

	/**
	 * Get value of field STMREC as a String.
	 */
	public String getSTMREC() {
		return fieldSTMREC.getString();
	}

	/**
	 * Set numeric field STMREC using a BigDecimal value.
	 */
	public void setSTMREC(BigDecimal newvalue) {
		fieldSTMREC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMREC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMREC() {
		return fieldSTMREC.getBigDecimal();
	}

	/**
	 * Set field STMMEM using a String value.
	 */
	public void setSTMMEM(String newvalue) {
		fieldSTMMEM.setString(newvalue);
	}

	/**
	 * Get value of field STMMEM as a String.
	 */
	public String getSTMMEM() {
		return fieldSTMMEM.getString();
	}

	/**
	 * Set field STMEND using a String value.
	 */
	public void setSTMEND(String newvalue) {
		fieldSTMEND.setString(newvalue);
	}

	/**
	 * Get value of field STMEND as a String.
	 */
	public String getSTMEND() {
		return fieldSTMEND.getString();
	}

	/**
	 * Set field STMDRR using a String value.
	 */
	public void setSTMDRR(String newvalue) {
		fieldSTMDRR.setString(newvalue);
	}

	/**
	 * Get value of field STMDRR as a String.
	 */
	public String getSTMDRR() {
		return fieldSTMDRR.getString();
	}

	/**
	 * Set numeric field STMDRR using a BigDecimal value.
	 */
	public void setSTMDRR(BigDecimal newvalue) {
		fieldSTMDRR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMDRR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMDRR() {
		return fieldSTMDRR.getBigDecimal();
	}

	/**
	 * Set field STMNNAR using a String value.
	 */
	public void setSTMNNAR(String newvalue) {
		fieldSTMNNAR.setString(newvalue);
	}

	/**
	 * Get value of field STMNNAR as a String.
	 */
	public String getSTMNNAR() {
		return fieldSTMNNAR.getString();
	}

	/**
	 * Set numeric field STMNNAR using a BigDecimal value.
	 */
	public void setSTMNNAR(BigDecimal newvalue) {
		fieldSTMNNAR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field STMNNAR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalSTMNNAR() {
		return fieldSTMNNAR.getBigDecimal();
	}

	/**
	 * Set field STMNA1 using a String value.
	 */
	public void setSTMNA1(String newvalue) {
		fieldSTMNA1.setString(newvalue);
	}

	/**
	 * Get value of field STMNA1 as a String.
	 */
	public String getSTMNA1() {
		return fieldSTMNA1.getString();
	}

	/**
	 * Set field STMNA2 using a String value.
	 */
	public void setSTMNA2(String newvalue) {
		fieldSTMNA2.setString(newvalue);
	}

	/**
	 * Get value of field STMNA2 as a String.
	 */
	public String getSTMNA2() {
		return fieldSTMNA2.getString();
	}

	/**
	 * Set field STMNA3 using a String value.
	 */
	public void setSTMNA3(String newvalue) {
		fieldSTMNA3.setString(newvalue);
	}

	/**
	 * Get value of field STMNA3 as a String.
	 */
	public String getSTMNA3() {
		return fieldSTMNA3.getString();
	}

	/**
	 * Set field STMNA4 using a String value.
	 */
	public void setSTMNA4(String newvalue) {
		fieldSTMNA4.setString(newvalue);
	}

	/**
	 * Get value of field STMNA4 as a String.
	 */
	public String getSTMNA4() {
		return fieldSTMNA4.getString();
	}

	/**
	 * Set field STMNA5 using a String value.
	 */
	public void setSTMNA5(String newvalue) {
		fieldSTMNA5.setString(newvalue);
	}

	/**
	 * Get value of field STMNA5 as a String.
	 */
	public String getSTMNA5() {
		return fieldSTMNA5.getString();
	}

	/**
	 * Set field STMNA6 using a String value.
	 */
	public void setSTMNA6(String newvalue) {
		fieldSTMNA6.setString(newvalue);
	}

	/**
	 * Get value of field STMNA6 as a String.
	 */
	public String getSTMNA6() {
		return fieldSTMNA6.getString();
	}

	/**
	 * Set field STMNA7 using a String value.
	 */
	public void setSTMNA7(String newvalue) {
		fieldSTMNA7.setString(newvalue);
	}

	/**
	 * Get value of field STMNA7 as a String.
	 */
	public String getSTMNA7() {
		return fieldSTMNA7.getString();
	}

	/**
	 * Set field STMNA8 using a String value.
	 */
	public void setSTMNA8(String newvalue) {
		fieldSTMNA8.setString(newvalue);
	}

	/**
	 * Get value of field STMNA8 as a String.
	 */
	public String getSTMNA8() {
		return fieldSTMNA8.getString();
	}

	/**
	 * Set field STMNA9 using a String value.
	 */
	public void setSTMNA9(String newvalue) {
		fieldSTMNA9.setString(newvalue);
	}

	/**
	 * Get value of field STMNA9 as a String.
	 */
	public String getSTMNA9() {
		return fieldSTMNA9.getString();
	}

}