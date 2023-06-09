package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from CDSDSJVBIC physical file
 * definition.
 * 
 * File level identifier is 1010315171100. Record format level identifier is
 * 49BEF4962DFAC.
 */

public class CDSDSJVBICMessage extends MessageRecord {
	final int FIELDCOUNT = 12;
	private CharacterField fieldCDSCERUSER = null;
	private DecimalField fieldCDSCERCRT = null;
	private CharacterField fieldCDSCERMDA = null;
	private DecimalField fieldCDSCERMNT = null;
	private DecimalField fieldCDSCERSAL = null;
	private DecimalField fieldCDSCERACM = null;
	private DecimalField fieldCDSCERAMM = null;
	private DecimalField fieldCDSCERFEM = null;
	private DecimalField fieldCDSCERFVL = null;
	private DecimalField fieldCDSCERFVN = null;
	private DecimalField fieldCDSCERTBS = null;
	private CharacterField fieldCDSCERNME = null;

	/**
	 * Constructor for CDSDSJVBICMessage.
	 */
	public CDSDSJVBICMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 187;
		fileid = "1010315171100";
		recordid = "49BEF4962DFAC";
		message = new byte[getByteLength()];
		formatname = "CDSDSJVBIC";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "CDSCERUSER";
		tagnames[0] = "CDSCERUSER";
		fields[0] = fieldCDSCERUSER = new CharacterField(message,
				HEADERSIZE + 0, 10, "CDSCERUSER");
		fieldnames[1] = "CDSCERCRT";
		tagnames[1] = "CDSCERCRT";
		fields[1] = fieldCDSCERCRT = new DecimalField(message, HEADERSIZE + 10,
				13, 0, "CDSCERCRT");
		fieldnames[2] = "CDSCERMDA";
		tagnames[2] = "CDSCERMDA";
		fields[2] = fieldCDSCERMDA = new CharacterField(message,
				HEADERSIZE + 23, 3, "CDSCERMDA");
		fieldnames[3] = "CDSCERMNT";
		tagnames[3] = "CDSCERMNT";
		fields[3] = fieldCDSCERMNT = new DecimalField(message, HEADERSIZE + 26,
				15, 2, "CDSCERMNT");
		fieldnames[4] = "CDSCERSAL";
		tagnames[4] = "CDSCERSAL";
		fields[4] = fieldCDSCERSAL = new DecimalField(message, HEADERSIZE + 41,
				15, 2, "CDSCERSAL");
		fieldnames[5] = "CDSCERACM";
		tagnames[5] = "CDSCERACM";
		fields[5] = fieldCDSCERACM = new DecimalField(message, HEADERSIZE + 56,
				15, 2, "CDSCERACM");
		fieldnames[6] = "CDSCERAMM";
		tagnames[6] = "CDSCERAMM";
		fields[6] = fieldCDSCERAMM = new DecimalField(message, HEADERSIZE + 71,
				15, 2, "CDSCERAMM");
		fieldnames[7] = "CDSCERFEM";
		tagnames[7] = "CDSCERFEM";
		fields[7] = fieldCDSCERFEM = new DecimalField(message, HEADERSIZE + 86,
				9, 0, "CDSCERFEM");
		fieldnames[8] = "CDSCERFVL";
		tagnames[8] = "CDSCERFVL";
		fields[8] = fieldCDSCERFVL = new DecimalField(message, HEADERSIZE + 95,
				9, 0, "CDSCERFVL");
		fieldnames[9] = "CDSCERFVN";
		tagnames[9] = "CDSCERFVN";
		fields[9] = fieldCDSCERFVN = new DecimalField(message,
				HEADERSIZE + 104, 9, 0, "CDSCERFVN");
		fieldnames[10] = "CDSCERTBS";
		tagnames[10] = "CDSCERTBS";
		fields[10] = fieldCDSCERTBS = new DecimalField(message,
				HEADERSIZE + 113, 11, 6, "CDSCERTBS");
		fieldnames[11] = "CDSCERNME";
		tagnames[11] = "CDSCERNME";
		fields[11] = fieldCDSCERNME = new CharacterField(message,
				HEADERSIZE + 124, 63, "CDSCERNME");
	}

	/**
	 * Set field CDSCERUSER using a String value.
	 */
	public void setCDSCERUSER(String newvalue) {
		fieldCDSCERUSER.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERUSER as a String.
	 */
	public String getCDSCERUSER() {
		return fieldCDSCERUSER.getString();
	}

	/**
	 * Set field CDSCERCRT using a String value.
	 */
	public void setCDSCERCRT(String newvalue) {
		fieldCDSCERCRT.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERCRT as a String.
	 */
	public String getCDSCERCRT() {
		return fieldCDSCERCRT.getString();
	}

	/**
	 * Set numeric field CDSCERCRT using a BigDecimal value.
	 */
	public void setCDSCERCRT(BigDecimal newvalue) {
		fieldCDSCERCRT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERCRT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERCRT() {
		return fieldCDSCERCRT.getBigDecimal();
	}

	/**
	 * Set field CDSCERMDA using a String value.
	 */
	public void setCDSCERMDA(String newvalue) {
		fieldCDSCERMDA.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERMDA as a String.
	 */
	public String getCDSCERMDA() {
		return fieldCDSCERMDA.getString();
	}

	/**
	 * Set field CDSCERMNT using a String value.
	 */
	public void setCDSCERMNT(String newvalue) {
		fieldCDSCERMNT.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERMNT as a String.
	 */
	public String getCDSCERMNT() {
		return fieldCDSCERMNT.getString();
	}

	/**
	 * Set numeric field CDSCERMNT using a BigDecimal value.
	 */
	public void setCDSCERMNT(BigDecimal newvalue) {
		fieldCDSCERMNT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERMNT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERMNT() {
		return fieldCDSCERMNT.getBigDecimal();
	}

	/**
	 * Set field CDSCERSAL using a String value.
	 */
	public void setCDSCERSAL(String newvalue) {
		fieldCDSCERSAL.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERSAL as a String.
	 */
	public String getCDSCERSAL() {
		return fieldCDSCERSAL.getString();
	}

	/**
	 * Set numeric field CDSCERSAL using a BigDecimal value.
	 */
	public void setCDSCERSAL(BigDecimal newvalue) {
		fieldCDSCERSAL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERSAL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERSAL() {
		return fieldCDSCERSAL.getBigDecimal();
	}

	/**
	 * Set field CDSCERACM using a String value.
	 */
	public void setCDSCERACM(String newvalue) {
		fieldCDSCERACM.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERACM as a String.
	 */
	public String getCDSCERACM() {
		return fieldCDSCERACM.getString();
	}

	/**
	 * Set numeric field CDSCERACM using a BigDecimal value.
	 */
	public void setCDSCERACM(BigDecimal newvalue) {
		fieldCDSCERACM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERACM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERACM() {
		return fieldCDSCERACM.getBigDecimal();
	}

	/**
	 * Set field CDSCERAMM using a String value.
	 */
	public void setCDSCERAMM(String newvalue) {
		fieldCDSCERAMM.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERAMM as a String.
	 */
	public String getCDSCERAMM() {
		return fieldCDSCERAMM.getString();
	}

	/**
	 * Set numeric field CDSCERAMM using a BigDecimal value.
	 */
	public void setCDSCERAMM(BigDecimal newvalue) {
		fieldCDSCERAMM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERAMM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERAMM() {
		return fieldCDSCERAMM.getBigDecimal();
	}

	/**
	 * Set field CDSCERFEM using a String value.
	 */
	public void setCDSCERFEM(String newvalue) {
		fieldCDSCERFEM.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERFEM as a String.
	 */
	public String getCDSCERFEM() {
		return fieldCDSCERFEM.getString();
	}

	/**
	 * Set numeric field CDSCERFEM using a BigDecimal value.
	 */
	public void setCDSCERFEM(BigDecimal newvalue) {
		fieldCDSCERFEM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERFEM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERFEM() {
		return fieldCDSCERFEM.getBigDecimal();
	}

	/**
	 * Set field CDSCERFVL using a String value.
	 */
	public void setCDSCERFVL(String newvalue) {
		fieldCDSCERFVL.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERFVL as a String.
	 */
	public String getCDSCERFVL() {
		return fieldCDSCERFVL.getString();
	}

	/**
	 * Set numeric field CDSCERFVL using a BigDecimal value.
	 */
	public void setCDSCERFVL(BigDecimal newvalue) {
		fieldCDSCERFVL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERFVL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERFVL() {
		return fieldCDSCERFVL.getBigDecimal();
	}

	/**
	 * Set field CDSCERFVN using a String value.
	 */
	public void setCDSCERFVN(String newvalue) {
		fieldCDSCERFVN.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERFVN as a String.
	 */
	public String getCDSCERFVN() {
		return fieldCDSCERFVN.getString();
	}

	/**
	 * Set numeric field CDSCERFVN using a BigDecimal value.
	 */
	public void setCDSCERFVN(BigDecimal newvalue) {
		fieldCDSCERFVN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERFVN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERFVN() {
		return fieldCDSCERFVN.getBigDecimal();
	}

	/**
	 * Set field CDSCERTBS using a String value.
	 */
	public void setCDSCERTBS(String newvalue) {
		fieldCDSCERTBS.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERTBS as a String.
	 */
	public String getCDSCERTBS() {
		return fieldCDSCERTBS.getString();
	}

	/**
	 * Set numeric field CDSCERTBS using a BigDecimal value.
	 */
	public void setCDSCERTBS(BigDecimal newvalue) {
		fieldCDSCERTBS.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field CDSCERTBS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalCDSCERTBS() {
		return fieldCDSCERTBS.getBigDecimal();
	}

	/**
	 * Set field CDSCERNME using a String value.
	 */
	public void setCDSCERNME(String newvalue) {
		fieldCDSCERNME.setString(newvalue);
	}

	/**
	 * Get value of field CDSCERNME as a String.
	 */
	public String getCDSCERNME() {
		return fieldCDSCERNME.getString();
	}

}