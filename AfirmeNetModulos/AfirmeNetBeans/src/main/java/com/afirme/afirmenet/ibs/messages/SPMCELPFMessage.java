package com.afirme.afirmenet.ibs.messages;

//import datapro.eibs.sockets.*;
import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

@SuppressWarnings("rawtypes")
public class SPMCELPFMessage extends MessageRecord {
	final static String fldnames[] = { "INCOPE", "INCUSR", "INCREF", "INCMRE",
			"INCXPMTV", "INCFECHA", "INCHORA", "INCLIEN", "INCUENTA",
			"INNOCEL", "INTICEL", "INSUCUR", "INUSEOPE", "INUSAUT1",
			"INUSAUT2", "INFEALT", "INHRALT", "INFECAN", "INHRCAN", "INESTAT",
			"INCORREO", "INNOCELA" };
	final static String tnames[] = { "INCOPE", "INCUSR", "INCREF", "INCMRE",
			"INCXPMTV", "INCFECHA", "INCHORA", "INCLIEN", "INCUENTA",
			"INNOCEL", "INTICEL", "INSUCUR", "INUSEOPE", "INUSAUT1",
			"INUSAUT2", "INFEALT", "INHRALT", "INFECAN", "INHRCAN", "INESTAT",
			"INCORREO", "INNOCELA" };
	final static String fid = "1141024110458";
	final static String rid = "420016AE75781";
	final static String fmtname = "SPMCELPF";
	final int FIELDCOUNT = 22;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldINCOPE = null;
	private CharacterField fieldINCUSR = null;
	private CharacterField fieldINCREF = null;
	private CharacterField fieldINCMRE = null;
	private CharacterField fieldINCXPMTV = null;
	private DecimalField fieldINCFECHA = null;
	private DecimalField fieldINCHORA = null;
	private DecimalField fieldINCLIEN = null;
	private DecimalField fieldINCUENTA = null;
	private DecimalField fieldINNOCEL = null;
	private DecimalField fieldINTICEL = null;
	private DecimalField fieldINSUCUR = null;
	private CharacterField fieldINUSEOPE = null;
	private CharacterField fieldINUSAUT1 = null;
	private CharacterField fieldINUSAUT2 = null;
	private DecimalField fieldINFEALT = null;
	private DecimalField fieldINHRALT = null;
	private DecimalField fieldINFECAN = null;
	private DecimalField fieldINHRCAN = null;
	private CharacterField fieldINESTAT = null;
	private CharacterField fieldINCORREO = null;
	private DecimalField fieldINNOCELA = null;

	/**
	 * Constructor for SPMCELPFMessage.
	 */
	public SPMCELPFMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 229;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldINCOPE = new CharacterField(message, HEADERSIZE + 0,
				1, "INCOPE");
		fields[1] = fieldINCUSR = new CharacterField(message, HEADERSIZE + 1,
				10, "INCUSR");
		fields[2] = fieldINCREF = new CharacterField(message, HEADERSIZE + 11,
				12, "INCREF");
		fields[3] = fieldINCMRE = new CharacterField(message, HEADERSIZE + 23,
				12, "INCMRE");
		fields[4] = fieldINCXPMTV = new CharacterField(message,
				HEADERSIZE + 35, 2, "INCXPMTV");
		fields[5] = fieldINCFECHA = new DecimalField(message, HEADERSIZE + 37,
				9, 0, "INCFECHA");
		fields[6] = fieldINCHORA = new DecimalField(message, HEADERSIZE + 46,
				7, 0, "INCHORA");
		fields[7] = fieldINCLIEN = new DecimalField(message, HEADERSIZE + 53,
				10, 0, "INCLIEN");
		fields[8] = fieldINCUENTA = new DecimalField(message, HEADERSIZE + 63,
				13, 0, "INCUENTA");
		fields[9] = fieldINNOCEL = new DecimalField(message, HEADERSIZE + 76,
				11, 0, "INNOCEL");
		fields[10] = fieldINTICEL = new DecimalField(message, HEADERSIZE + 87,
				4, 0, "INTICEL");
		fields[11] = fieldINSUCUR = new DecimalField(message, HEADERSIZE + 91,
				4, 0, "INSUCUR");
		fields[12] = fieldINUSEOPE = new CharacterField(message,
				HEADERSIZE + 95, 10, "INUSEOPE");
		fields[13] = fieldINUSAUT1 = new CharacterField(message,
				HEADERSIZE + 105, 10, "INUSAUT1");
		fields[14] = fieldINUSAUT2 = new CharacterField(message,
				HEADERSIZE + 115, 10, "INUSAUT2");
		fields[15] = fieldINFEALT = new DecimalField(message, HEADERSIZE + 125,
				9, 0, "INFEALT");
		fields[16] = fieldINHRALT = new DecimalField(message, HEADERSIZE + 134,
				7, 0, "INHRALT");
		fields[17] = fieldINFECAN = new DecimalField(message, HEADERSIZE + 141,
				9, 0, "INFECAN");
		fields[18] = fieldINHRCAN = new DecimalField(message, HEADERSIZE + 150,
				7, 0, "INHRCAN");
		fields[19] = fieldINESTAT = new CharacterField(message,
				HEADERSIZE + 157, 1, "INESTAT");
		fields[20] = fieldINCORREO = new CharacterField(message,
				HEADERSIZE + 158, 60, "INCORREO");
		fields[21] = fieldINNOCELA = new DecimalField(message,
				HEADERSIZE + 218, 11, 0, "INNOCELA");

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
	 * Set field INCUSR using a String value.
	 */
	public void setINCUSR(String newvalue) {
		fieldINCUSR.setString(newvalue);
	}

	/**
	 * Get value of field INCUSR as a String.
	 */
	public String getINCUSR() {
		return fieldINCUSR.getString();
	}

	/**
	 * Set field INCREF using a String value.
	 */
	public void setINCREF(String newvalue) {
		fieldINCREF.setString(newvalue);
	}

	/**
	 * Get value of field INCREF as a String.
	 */
	public String getINCREF() {
		return fieldINCREF.getString();
	}

	/**
	 * Set field INCMRE using a String value.
	 */
	public void setINCMRE(String newvalue) {
		fieldINCMRE.setString(newvalue);
	}

	/**
	 * Get value of field INCMRE as a String.
	 */
	public String getINCMRE() {
		return fieldINCMRE.getString();
	}

	/**
	 * Set field INCXPMTV using a String value.
	 */
	public void setINCXPMTV(String newvalue) {
		fieldINCXPMTV.setString(newvalue);
	}

	/**
	 * Get value of field INCXPMTV as a String.
	 */
	public String getINCXPMTV() {
		return fieldINCXPMTV.getString();
	}

	/**
	 * Set field INCFECHA using a String value.
	 */
	public void setINCFECHA(String newvalue) {
		fieldINCFECHA.setString(newvalue);
	}

	/**
	 * Get value of field INCFECHA as a String.
	 */
	public String getINCFECHA() {
		return fieldINCFECHA.getString();
	}

	/**
	 * Set numeric field INCFECHA using a BigDecimal value.
	 */
	public void setINCFECHA(BigDecimal newvalue) {
		fieldINCFECHA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCFECHA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCFECHA() {
		return fieldINCFECHA.getBigDecimal();
	}

	/**
	 * Set field INCHORA using a String value.
	 */
	public void setINCHORA(String newvalue) {
		fieldINCHORA.setString(newvalue);
	}

	/**
	 * Get value of field INCHORA as a String.
	 */
	public String getINCHORA() {
		return fieldINCHORA.getString();
	}

	/**
	 * Set numeric field INCHORA using a BigDecimal value.
	 */
	public void setINCHORA(BigDecimal newvalue) {
		fieldINCHORA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCHORA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCHORA() {
		return fieldINCHORA.getBigDecimal();
	}

	/**
	 * Set field INCLIEN using a String value.
	 */
	public void setINCLIEN(String newvalue) {
		fieldINCLIEN.setString(newvalue);
	}

	/**
	 * Get value of field INCLIEN as a String.
	 */
	public String getINCLIEN() {
		return fieldINCLIEN.getString();
	}

	/**
	 * Set numeric field INCLIEN using a BigDecimal value.
	 */
	public void setINCLIEN(BigDecimal newvalue) {
		fieldINCLIEN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCLIEN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCLIEN() {
		return fieldINCLIEN.getBigDecimal();
	}

	/**
	 * Set field INCUENTA using a String value.
	 */
	public void setINCUENTA(String newvalue) {
		fieldINCUENTA.setString(newvalue);
	}

	/**
	 * Get value of field INCUENTA as a String.
	 */
	public String getINCUENTA() {
		return fieldINCUENTA.getString();
	}

	/**
	 * Set numeric field INCUENTA using a BigDecimal value.
	 */
	public void setINCUENTA(BigDecimal newvalue) {
		fieldINCUENTA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCUENTA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCUENTA() {
		return fieldINCUENTA.getBigDecimal();
	}

	/**
	 * Set field INNOCEL using a String value.
	 */
	public void setINNOCEL(String newvalue) {
		fieldINNOCEL.setString(newvalue);
	}

	/**
	 * Get value of field INNOCEL as a String.
	 */
	public String getINNOCEL() {
		return fieldINNOCEL.getString();
	}

	/**
	 * Set numeric field INNOCEL using a BigDecimal value.
	 */
	public void setINNOCEL(BigDecimal newvalue) {
		fieldINNOCEL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INNOCEL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINNOCEL() {
		return fieldINNOCEL.getBigDecimal();
	}

	/**
	 * Set field INTICEL using a String value.
	 */
	public void setINTICEL(String newvalue) {
		fieldINTICEL.setString(newvalue);
	}

	/**
	 * Get value of field INTICEL as a String.
	 */
	public String getINTICEL() {
		return fieldINTICEL.getString();
	}

	/**
	 * Set numeric field INTICEL using a BigDecimal value.
	 */
	public void setINTICEL(BigDecimal newvalue) {
		fieldINTICEL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTICEL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTICEL() {
		return fieldINTICEL.getBigDecimal();
	}

	/**
	 * Set field INSUCUR using a String value.
	 */
	public void setINSUCUR(String newvalue) {
		fieldINSUCUR.setString(newvalue);
	}

	/**
	 * Get value of field INSUCUR as a String.
	 */
	public String getINSUCUR() {
		return fieldINSUCUR.getString();
	}

	/**
	 * Set numeric field INSUCUR using a BigDecimal value.
	 */
	public void setINSUCUR(BigDecimal newvalue) {
		fieldINSUCUR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INSUCUR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINSUCUR() {
		return fieldINSUCUR.getBigDecimal();
	}

	/**
	 * Set field INUSEOPE using a String value.
	 */
	public void setINUSEOPE(String newvalue) {
		fieldINUSEOPE.setString(newvalue);
	}

	/**
	 * Get value of field INUSEOPE as a String.
	 */
	public String getINUSEOPE() {
		return fieldINUSEOPE.getString();
	}

	/**
	 * Set field INUSAUT1 using a String value.
	 */
	public void setINUSAUT1(String newvalue) {
		fieldINUSAUT1.setString(newvalue);
	}

	/**
	 * Get value of field INUSAUT1 as a String.
	 */
	public String getINUSAUT1() {
		return fieldINUSAUT1.getString();
	}

	/**
	 * Set field INUSAUT2 using a String value.
	 */
	public void setINUSAUT2(String newvalue) {
		fieldINUSAUT2.setString(newvalue);
	}

	/**
	 * Get value of field INUSAUT2 as a String.
	 */
	public String getINUSAUT2() {
		return fieldINUSAUT2.getString();
	}

	/**
	 * Set field INFEALT using a String value.
	 */
	public void setINFEALT(String newvalue) {
		fieldINFEALT.setString(newvalue);
	}

	/**
	 * Get value of field INFEALT as a String.
	 */
	public String getINFEALT() {
		return fieldINFEALT.getString();
	}

	/**
	 * Set numeric field INFEALT using a BigDecimal value.
	 */
	public void setINFEALT(BigDecimal newvalue) {
		fieldINFEALT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INFEALT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINFEALT() {
		return fieldINFEALT.getBigDecimal();
	}

	/**
	 * Set field INHRALT using a String value.
	 */
	public void setINHRALT(String newvalue) {
		fieldINHRALT.setString(newvalue);
	}

	/**
	 * Get value of field INHRALT as a String.
	 */
	public String getINHRALT() {
		return fieldINHRALT.getString();
	}

	/**
	 * Set numeric field INHRALT using a BigDecimal value.
	 */
	public void setINHRALT(BigDecimal newvalue) {
		fieldINHRALT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INHRALT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINHRALT() {
		return fieldINHRALT.getBigDecimal();
	}

	/**
	 * Set field INFECAN using a String value.
	 */
	public void setINFECAN(String newvalue) {
		fieldINFECAN.setString(newvalue);
	}

	/**
	 * Get value of field INFECAN as a String.
	 */
	public String getINFECAN() {
		return fieldINFECAN.getString();
	}

	/**
	 * Set numeric field INFECAN using a BigDecimal value.
	 */
	public void setINFECAN(BigDecimal newvalue) {
		fieldINFECAN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INFECAN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINFECAN() {
		return fieldINFECAN.getBigDecimal();
	}

	/**
	 * Set field INHRCAN using a String value.
	 */
	public void setINHRCAN(String newvalue) {
		fieldINHRCAN.setString(newvalue);
	}

	/**
	 * Get value of field INHRCAN as a String.
	 */
	public String getINHRCAN() {
		return fieldINHRCAN.getString();
	}

	/**
	 * Set numeric field INHRCAN using a BigDecimal value.
	 */
	public void setINHRCAN(BigDecimal newvalue) {
		fieldINHRCAN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INHRCAN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINHRCAN() {
		return fieldINHRCAN.getBigDecimal();
	}

	/**
	 * Set field INESTAT using a String value.
	 */
	public void setINESTAT(String newvalue) {
		fieldINESTAT.setString(newvalue);
	}

	/**
	 * Get value of field INESTAT as a String.
	 */
	public String getINESTAT() {
		return fieldINESTAT.getString();
	}

	/**
	 * Set field INCORREO using a String value.
	 */
	public void setINCORREO(String newvalue) {
		fieldINCORREO.setString(newvalue);
	}

	/**
	 * Get value of field INCORREO as a String.
	 */
	public String getINCORREO() {
		return fieldINCORREO.getString();
	}

	/**
	 * Set field INNOCELA using a String value.
	 */
	public void setINNOCELA(String newvalue) {
		fieldINNOCELA.setString(newvalue);
	}

	/**
	 * Get value of field INNOCELA as a String.
	 */
	public String getINNOCELA() {
		return fieldINNOCELA.getString();
	}

	/**
	 * Set numeric field INNOCELA using a BigDecimal value.
	 */
	public void setINNOCELA(BigDecimal newvalue) {
		fieldINNOCELA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INNOCELA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINNOCELA() {
		return fieldINNOCELA.getBigDecimal();
	}
}