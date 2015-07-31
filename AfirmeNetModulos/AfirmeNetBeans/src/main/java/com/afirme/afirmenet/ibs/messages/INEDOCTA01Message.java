package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from INEDOCTA01 physical file
 * definition.
 * 
 * File level identifier is 1101028154708. Record format level identifier is
 * 50264710D46CF.
 */
@SuppressWarnings("rawtypes")
public class INEDOCTA01Message extends MessageRecord {
	final static String fldnames[] = { "INTOPE", "INTUSR", "INTREF",
			"INTXPMTV", "INTFECHA", "INTHORA", "INTUSUARIO", "INTTIPO",
			"INTCUENTA", "INTPROD", "INTESTATUS", "INTNUMIMP", "INTFECALTA",
			"INTHORALTA", "INTUSUALTA", "INTFECCANC", "INTHORCANC",
			"INTUSUCANC" };
	final static String tnames[] = { "INTOPE", "INTUSR", "INTREF", "INTXPMTV",
			"INTFECHA", "INTHORA", "INTUSUARIO", "INTTIPO", "INTCUENTA",
			"INTPROD", "INTESTATUS", "INTNUMIMP", "INTFECALTA", "INTHORALTA",
			"INTUSUALTA", "INTFECCANC", "INTHORCANC", "INTUSUCANC" };
	final static String fid = "1101028154708";
	final static String rid = "50264710D46CF";
	final static String fmtname = "INEDOCTA01";
	final int FIELDCOUNT = 18;

	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldINTOPE = null;
	private CharacterField fieldINTUSR = null;
	private CharacterField fieldINTREF = null;
	private CharacterField fieldINTXPMTV = null;
	private DecimalField fieldINTFECHA = null;
	private DecimalField fieldINTHORA = null;
	private CharacterField fieldINTUSUARIO = null;
	private CharacterField fieldINTTIPO = null;
	private CharacterField fieldINTCUENTA = null;
	private CharacterField fieldINTPROD = null;
	private CharacterField fieldINTESTATUS = null;
	private DecimalField fieldINTNUMIMP = null;
	private DecimalField fieldINTFECALTA = null;
	private DecimalField fieldINTHORALTA = null;
	private CharacterField fieldINTUSUALTA = null;
	private DecimalField fieldINTFECCANC = null;
	private DecimalField fieldINTHORCANC = null;
	private CharacterField fieldINTUSUCANC = null;

	/**
	 * Constructor for INEDOCTA01Message.
	 */
	public INEDOCTA01Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 133;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldINTOPE = new CharacterField(message, HEADERSIZE + 0,
				1, "INTOPE");
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
		fields[6] = fieldINTUSUARIO = new CharacterField(message,
				HEADERSIZE + 41, 10, "INTUSUARIO");
		fields[7] = fieldINTTIPO = new CharacterField(message, HEADERSIZE + 51,
				1, "INTTIPO");
		fields[8] = fieldINTCUENTA = new CharacterField(message,
				HEADERSIZE + 52, 20, "INTCUENTA");
		fields[9] = fieldINTPROD = new CharacterField(message, HEADERSIZE + 72,
				2, "INTPROD");
		fields[10] = fieldINTESTATUS = new CharacterField(message,
				HEADERSIZE + 74, 1, "INTESTATUS");
		fields[11] = fieldINTNUMIMP = new DecimalField(message,
				HEADERSIZE + 75, 6, 0, "INTNUMIMP");
		fields[12] = fieldINTFECALTA = new DecimalField(message,
				HEADERSIZE + 81, 9, 0, "INTFECALTA");
		fields[13] = fieldINTHORALTA = new DecimalField(message,
				HEADERSIZE + 90, 7, 0, "INTHORALTA");
		fields[14] = fieldINTUSUALTA = new CharacterField(message,
				HEADERSIZE + 97, 10, "INTUSUALTA");
		fields[15] = fieldINTFECCANC = new DecimalField(message,
				HEADERSIZE + 107, 9, 0, "INTFECCANC");
		fields[16] = fieldINTHORCANC = new DecimalField(message,
				HEADERSIZE + 116, 7, 0, "INTHORCANC");
		fields[17] = fieldINTUSUCANC = new CharacterField(message,
				HEADERSIZE + 123, 10, "INTUSUCANC");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field INTOPE using a String value.
	 */
	public void setINTOPE(String newvalue) {
		fieldINTOPE.setString(newvalue);
	}

	/**
	 * Get value of field INTOPE as a String.
	 */
	public String getINTOPE() {
		return fieldINTOPE.getString();
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
	 * Set field INTUSUARIO using a String value.
	 */
	public void setINTUSUARIO(String newvalue) {
		fieldINTUSUARIO.setString(newvalue);
	}

	/**
	 * Get value of field INTUSUARIO as a String.
	 */
	public String getINTUSUARIO() {
		return fieldINTUSUARIO.getString();
	}

	/**
	 * Set field INTTIPO using a String value.
	 */
	public void setINTTIPO(String newvalue) {
		fieldINTTIPO.setString(newvalue);
	}

	/**
	 * Get value of field INTTIPO as a String.
	 */
	public String getINTTIPO() {
		return fieldINTTIPO.getString();
	}

	/**
	 * Set field INTCUENTA using a String value.
	 */
	public void setINTCUENTA(String newvalue) {
		fieldINTCUENTA.setString(newvalue);
	}

	/**
	 * Get value of field INTCUENTA as a String.
	 */
	public String getINTCUENTA() {
		return fieldINTCUENTA.getString();
	}

	/**
	 * Set field INTPROD using a String value.
	 */
	public void setINTPROD(String newvalue) {
		fieldINTPROD.setString(newvalue);
	}

	/**
	 * Get value of field INTPROD as a String.
	 */
	public String getINTPROD() {
		return fieldINTPROD.getString();
	}

	/**
	 * Set field INTESTATUS using a String value.
	 */
	public void setINTESTATUS(String newvalue) {
		fieldINTESTATUS.setString(newvalue);
	}

	/**
	 * Get value of field INTESTATUS as a String.
	 */
	public String getINTESTATUS() {
		return fieldINTESTATUS.getString();
	}

	/**
	 * Set field INTNUMIMP using a String value.
	 */
	public void setINTNUMIMP(String newvalue) {
		fieldINTNUMIMP.setString(newvalue);
	}

	/**
	 * Get value of field INTNUMIMP as a String.
	 */
	public String getINTNUMIMP() {
		return fieldINTNUMIMP.getString();
	}

	/**
	 * Set numeric field INTNUMIMP using a BigDecimal value.
	 */
	public void setINTNUMIMP(BigDecimal newvalue) {
		fieldINTNUMIMP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTNUMIMP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTNUMIMP() {
		return fieldINTNUMIMP.getBigDecimal();
	}

	/**
	 * Set field INTFECALTA using a String value.
	 */
	public void setINTFECALTA(String newvalue) {
		fieldINTFECALTA.setString(newvalue);
	}

	/**
	 * Get value of field INTFECALTA as a String.
	 */
	public String getINTFECALTA() {
		return fieldINTFECALTA.getString();
	}

	/**
	 * Set numeric field INTFECALTA using a BigDecimal value.
	 */
	public void setINTFECALTA(BigDecimal newvalue) {
		fieldINTFECALTA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTFECALTA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTFECALTA() {
		return fieldINTFECALTA.getBigDecimal();
	}

	/**
	 * Set field INTHORALTA using a String value.
	 */
	public void setINTHORALTA(String newvalue) {
		fieldINTHORALTA.setString(newvalue);
	}

	/**
	 * Get value of field INTHORALTA as a String.
	 */
	public String getINTHORALTA() {
		return fieldINTHORALTA.getString();
	}

	/**
	 * Set numeric field INTHORALTA using a BigDecimal value.
	 */
	public void setINTHORALTA(BigDecimal newvalue) {
		fieldINTHORALTA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTHORALTA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTHORALTA() {
		return fieldINTHORALTA.getBigDecimal();
	}

	/**
	 * Set field INTUSUALTA using a String value.
	 */
	public void setINTUSUALTA(String newvalue) {
		fieldINTUSUALTA.setString(newvalue);
	}

	/**
	 * Get value of field INTUSUALTA as a String.
	 */
	public String getINTUSUALTA() {
		return fieldINTUSUALTA.getString();
	}

	/**
	 * Set field INTFECCANC using a String value.
	 */
	public void setINTFECCANC(String newvalue) {
		fieldINTFECCANC.setString(newvalue);
	}

	/**
	 * Get value of field INTFECCANC as a String.
	 */
	public String getINTFECCANC() {
		return fieldINTFECCANC.getString();
	}

	/**
	 * Set numeric field INTFECCANC using a BigDecimal value.
	 */
	public void setINTFECCANC(BigDecimal newvalue) {
		fieldINTFECCANC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTFECCANC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTFECCANC() {
		return fieldINTFECCANC.getBigDecimal();
	}

	/**
	 * Set field INTHORCANC using a String value.
	 */
	public void setINTHORCANC(String newvalue) {
		fieldINTHORCANC.setString(newvalue);
	}

	/**
	 * Get value of field INTHORCANC as a String.
	 */
	public String getINTHORCANC() {
		return fieldINTHORCANC.getString();
	}

	/**
	 * Set numeric field INTHORCANC using a BigDecimal value.
	 */
	public void setINTHORCANC(BigDecimal newvalue) {
		fieldINTHORCANC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTHORCANC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTHORCANC() {
		return fieldINTHORCANC.getBigDecimal();
	}

	/**
	 * Set field INTUSUCANC using a String value.
	 */
	public void setINTUSUCANC(String newvalue) {
		fieldINTUSUCANC.setString(newvalue);
	}

	/**
	 * Get value of field INTUSUCANC as a String.
	 */
	public String getINTUSUCANC() {
		return fieldINTUSUCANC.getString();
	}

}