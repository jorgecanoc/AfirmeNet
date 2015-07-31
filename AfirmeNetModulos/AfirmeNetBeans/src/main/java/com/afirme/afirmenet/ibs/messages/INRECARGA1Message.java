package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;
import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from INRECARGA1 physical file
 * definition.
 * 
 * File level identifier is 1091109162745. Record format level identifier is
 * 4919984E9B79A.
 */
@SuppressWarnings("rawtypes")
public class INRECARGA1Message extends MessageRecord {
	final static String fldnames[] = { "INCOPE", "INTUSR", "INTREF",
			"INTXPMTV", "INTFECHA", "INTHORA", "INTCTACGO", "INTMONEDA",
			"INTIMPORTE", "INCELULAR", "INEMPRESA", "INTTIN", "INTTIF",
			"INTSTS" };
	final static String tnames[] = { "INCOPE", "INTUSR", "INTREF", "INTXPMTV",
			"INTFECHA", "INTHORA", "INTCTACGO", "INTMONEDA", "INTIMPORTE",
			"INCELULAR", "INEMPRESA", "INTTIN", "INTTIF", "INTSTS" };
	final static String fid = "1091109162745";
	final static String rid = "4919984E9B79A";
	final static String fmtname = "INRECARGA1";
	final int FIELDCOUNT = 14;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldINCOPE = null;
	private CharacterField fieldINTUSR = null;
	private CharacterField fieldINTREF = null;
	private CharacterField fieldINTXPMTV = null;
	private DecimalField fieldINTFECHA = null;
	private DecimalField fieldINTHORA = null;
	private DecimalField fieldINTCTACGO = null;
	private CharacterField fieldINTMONEDA = null;
	private DecimalField fieldINTIMPORTE = null;
	private DecimalField fieldINCELULAR = null;
	private DecimalField fieldINEMPRESA = null;
	private DecimalField fieldINTTIN = null;
	private DecimalField fieldINTTIF = null;
	private CharacterField fieldINTSTS = null;

	/**
	 * Constructor for INRECARGA1Message.
	 */
	public INRECARGA1Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 113;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldINCOPE = new CharacterField(message, HEADERSIZE + 0,
				1, "INCOPE");
		fields[1] = fieldINTUSR = new CharacterField(message, HEADERSIZE + 1,
				10, "INTUSR");
		fields[2] = fieldINTREF = new CharacterField(message, HEADERSIZE + 11,
				12, "INTREF");
		fields[3] = fieldINTXPMTV = new CharacterField(message,
				HEADERSIZE + 23, 2, "INTXPMTV");
		fields[4] = fieldINTFECHA = new DecimalField(message, HEADERSIZE + 25,
				9, 0, "INTFECHA");
		fields[5] = fieldINTHORA = new DecimalField(message, HEADERSIZE + 34,
				7, 0, "INTHORA");
		fields[6] = fieldINTCTACGO = new DecimalField(message, HEADERSIZE + 41,
				13, 0, "INTCTACGO");
		fields[7] = fieldINTMONEDA = new CharacterField(message,
				HEADERSIZE + 54, 3, "INTMONEDA");
		fields[8] = fieldINTIMPORTE = new DecimalField(message,
				HEADERSIZE + 57, 17, 2, "INTIMPORTE");
		fields[9] = fieldINCELULAR = new DecimalField(message, HEADERSIZE + 74,
				21, 0, "INCELULAR");
		fields[10] = fieldINEMPRESA = new DecimalField(message,
				HEADERSIZE + 95, 3, 0, "INEMPRESA");
		fields[11] = fieldINTTIN = new DecimalField(message, HEADERSIZE + 98,
				7, 0, "INTTIN");
		fields[12] = fieldINTTIF = new DecimalField(message, HEADERSIZE + 105,
				7, 0, "INTTIF");
		fields[13] = fieldINTSTS = new CharacterField(message,
				HEADERSIZE + 112, 1, "INTSTS");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field INCOPE using a String value.
	 */
	public void setINCOPE(String newvalue) {
		fieldINCOPE.setString(newvalue);
	}

	/**
	 * Get value of field INCOPE as a String.
	 */
	public String getINCOPE() {
		return fieldINCOPE.getString();
	}

	/**
	 * Set field INTUSR using a String value.
	 */
	public void setINTUSR(String newvalue) {
		fieldINTUSR.setString(newvalue);
	}

	/**
	 * Get value of field INTUSR as a String.
	 */
	public String getINTUSR() {
		return fieldINTUSR.getString();
	}

	/**
	 * Set field INTREF using a String value.
	 */
	public void setINTREF(String newvalue) {
		fieldINTREF.setString(newvalue);
	}

	/**
	 * Get value of field INTREF as a String.
	 */
	public String getINTREF() {
		return fieldINTREF.getString();
	}

	/**
	 * Set field INTXPMTV using a String value.
	 */
	public void setINTXPMTV(String newvalue) {
		fieldINTXPMTV.setString(newvalue);
	}

	/**
	 * Get value of field INTXPMTV as a String.
	 */
	public String getINTXPMTV() {
		return fieldINTXPMTV.getString();
	}

	/**
	 * Set field INTFECHA using a String value.
	 */
	public void setINTFECHA(String newvalue) {
		fieldINTFECHA.setString(newvalue);
	}

	/**
	 * Get value of field INTFECHA as a String.
	 */
	public String getINTFECHA() {
		return fieldINTFECHA.getString();
	}

	/**
	 * Set numeric field INTFECHA using a BigDecimal value.
	 */
	public void setINTFECHA(BigDecimal newvalue) {
		fieldINTFECHA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTFECHA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTFECHA() {
		return fieldINTFECHA.getBigDecimal();
	}

	/**
	 * Set field INTHORA using a String value.
	 */
	public void setINTHORA(String newvalue) {
		fieldINTHORA.setString(newvalue);
	}

	/**
	 * Get value of field INTHORA as a String.
	 */
	public String getINTHORA() {
		return fieldINTHORA.getString();
	}

	/**
	 * Set numeric field INTHORA using a BigDecimal value.
	 */
	public void setINTHORA(BigDecimal newvalue) {
		fieldINTHORA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTHORA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTHORA() {
		return fieldINTHORA.getBigDecimal();
	}

	/**
	 * Set field INTCTACGO using a String value.
	 */
	public void setINTCTACGO(String newvalue) {
		fieldINTCTACGO.setString(newvalue);
	}

	/**
	 * Get value of field INTCTACGO as a String.
	 */
	public String getINTCTACGO() {
		return fieldINTCTACGO.getString();
	}

	/**
	 * Set numeric field INTCTACGO using a BigDecimal value.
	 */
	public void setINTCTACGO(BigDecimal newvalue) {
		fieldINTCTACGO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTCTACGO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTCTACGO() {
		return fieldINTCTACGO.getBigDecimal();
	}

	/**
	 * Set field INTMONEDA using a String value.
	 */
	public void setINTMONEDA(String newvalue) {
		fieldINTMONEDA.setString(newvalue);
	}

	/**
	 * Get value of field INTMONEDA as a String.
	 */
	public String getINTMONEDA() {
		return fieldINTMONEDA.getString();
	}

	/**
	 * Set field INTIMPORTE using a String value.
	 */
	public void setINTIMPORTE(String newvalue) {
		fieldINTIMPORTE.setString(newvalue);
	}

	/**
	 * Get value of field INTIMPORTE as a String.
	 */
	public String getINTIMPORTE() {
		return fieldINTIMPORTE.getString();
	}

	/**
	 * Set numeric field INTIMPORTE using a BigDecimal value.
	 */
	public void setINTIMPORTE(BigDecimal newvalue) {
		fieldINTIMPORTE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTIMPORTE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTIMPORTE() {
		return fieldINTIMPORTE.getBigDecimal();
	}

	/**
	 * Set field INCELULAR using a String value.
	 */
	public void setINCELULAR(String newvalue) {
		fieldINCELULAR.setString(newvalue);
	}

	/**
	 * Get value of field INCELULAR as a String.
	 */
	public String getINCELULAR() {
		return fieldINCELULAR.getString();
	}

	/**
	 * Set numeric field INCELULAR using a BigDecimal value.
	 */
	public void setINCELULAR(BigDecimal newvalue) {
		fieldINCELULAR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCELULAR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCELULAR() {
		return fieldINCELULAR.getBigDecimal();
	}

	/**
	 * Set field INEMPRESA using a String value.
	 */
	public void setINEMPRESA(String newvalue) {
		fieldINEMPRESA.setString(newvalue);
	}

	/**
	 * Get value of field INEMPRESA as a String.
	 */
	public String getINEMPRESA() {
		return fieldINEMPRESA.getString();
	}

	/**
	 * Set numeric field INEMPRESA using a BigDecimal value.
	 */
	public void setINEMPRESA(BigDecimal newvalue) {
		fieldINEMPRESA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INEMPRESA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINEMPRESA() {
		return fieldINEMPRESA.getBigDecimal();
	}

	/**
	 * Set field INTTIN using a String value.
	 */
	public void setINTTIN(String newvalue) {
		fieldINTTIN.setString(newvalue);
	}

	/**
	 * Get value of field INTTIN as a String.
	 */
	public String getINTTIN() {
		return fieldINTTIN.getString();
	}

	/**
	 * Set numeric field INTTIN using a BigDecimal value.
	 */
	public void setINTTIN(BigDecimal newvalue) {
		fieldINTTIN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTTIN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTTIN() {
		return fieldINTTIN.getBigDecimal();
	}

	/**
	 * Set field INTTIF using a String value.
	 */
	public void setINTTIF(String newvalue) {
		fieldINTTIF.setString(newvalue);
	}

	/**
	 * Get value of field INTTIF as a String.
	 */
	public String getINTTIF() {
		return fieldINTTIF.getString();
	}

	/**
	 * Set numeric field INTTIF using a BigDecimal value.
	 */
	public void setINTTIF(BigDecimal newvalue) {
		fieldINTTIF.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTTIF as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTTIF() {
		return fieldINTTIF.getBigDecimal();
	}

	/**
	 * Set field INTSTS using a String value.
	 */
	public void setINTSTS(String newvalue) {
		fieldINTSTS.setString(newvalue);
	}

	/**
	 * Get value of field INTSTS as a String.
	 */
	public String getINTSTS() {
		return fieldINTSTS.getString();
	}

}