package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.DecimalField;
import com.datapro.sockets.CharacterField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from BMINCTPF physical file
 * definition.
 * 
 * File level identifier is 1121213120518. Record format level identifier is
 * 432527B361387.
 */
@SuppressWarnings("rawtypes")
public class BMINCTPFMessage extends MessageRecord {
	final static String fldnames[] = { "INCOPE", "INCUSR", "INCREF", "INCMRE",
			"INCXPMTV", "INCFECHA", "INCHORA", "INCLIEN", "INCUENTA",
			"INALIAS", "INNAMES", "INNOCEL", "INTICEL", "ININDAL", "INAUTEP",
			"INPAQSR", "INSTSSR", "INCOMIS", "INCOSMS", "INIVACO", "INFETRN",
			"INHRTRN", "INTPTRN", "INIMPOR", "INSTSTR", "INLDTRP", "INADTRP",
			"INLMTRP", "INAMTRP", "INLDTIN", "INADTIN", "INLMTIN", "INAMTIN",
			"INLDPTC", "INADPTC", "INLMPTC", "INAMPTC", "INLDRCE", "INADRCE",
			"INLMRCE", "INAMRCE", "INSUCUR", "INUSERI", "INFEALT", "INHRALT",
			"INFECAN", "INHRCAN", "INESTAT", "INCORRE" };
	final static String tnames[] = { "INCOPE", "INCUSR", "INCREF", "INCMRE",
			"INCXPMTV", "INCFECHA", "INCHORA", "INCLIEN", "INCUENTA",
			"INALIAS", "INNAMES", "INNOCEL", "INTICEL", "ININDAL", "INAUTEP",
			"INPAQSR", "INSTSSR", "INCOMIS", "INCOSMS", "INIVACO", "INFETRN",
			"INHRTRN", "INTPTRN", "INIMPOR", "INSTSTR", "INLDTRP", "INADTRP",
			"INLMTRP", "INAMTRP", "INLDTIN", "INADTIN", "INLMTIN", "INAMTIN",
			"INLDPTC", "INADPTC", "INLMPTC", "INAMPTC", "INLDRCE", "INADRCE",
			"INLMRCE", "INAMRCE", "INSUCUR", "INUSERI", "INFEALT", "INHRALT",
			"INFECAN", "INHRCAN", "INESTAT", "INCORRE" };
	final static String fid = "1121213120518";
	final static String rid = "432527B361387";
	final static String fmtname = "BMINCTPF";
	final int FIELDCOUNT = 49;
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
	private CharacterField fieldINALIAS = null;
	private CharacterField fieldINNAMES = null;
	private DecimalField fieldINNOCEL = null;
	private CharacterField fieldINTICEL = null;
	private CharacterField fieldININDAL = null;
	private CharacterField fieldINAUTEP = null;
	private CharacterField fieldINPAQSR = null;
	private CharacterField fieldINSTSSR = null;
	private DecimalField fieldINCOMIS = null;
	private DecimalField fieldINCOSMS = null;
	private DecimalField fieldINIVACO = null;
	private DecimalField fieldINFETRN = null;
	private DecimalField fieldINHRTRN = null;
	private CharacterField fieldINTPTRN = null;
	private DecimalField fieldINIMPOR = null;
	private CharacterField fieldINSTSTR = null;
	private DecimalField fieldINLDTRP = null;
	private DecimalField fieldINADTRP = null;
	private DecimalField fieldINLMTRP = null;
	private DecimalField fieldINAMTRP = null;
	private DecimalField fieldINLDTIN = null;
	private DecimalField fieldINADTIN = null;
	private DecimalField fieldINLMTIN = null;
	private DecimalField fieldINAMTIN = null;
	private DecimalField fieldINLDPTC = null;
	private DecimalField fieldINADPTC = null;
	private DecimalField fieldINLMPTC = null;
	private DecimalField fieldINAMPTC = null;
	private DecimalField fieldINLDRCE = null;
	private DecimalField fieldINADRCE = null;
	private DecimalField fieldINLMRCE = null;
	private DecimalField fieldINAMRCE = null;
	private DecimalField fieldINSUCUR = null;
	private CharacterField fieldINUSERI = null;
	private DecimalField fieldINFEALT = null;
	private DecimalField fieldINHRALT = null;
	private DecimalField fieldINFECAN = null;
	private DecimalField fieldINHRCAN = null;
	private CharacterField fieldINESTAT = null;
	private CharacterField fieldINCORRE = null;

	/**
	 * Constructor for BMINCTPFMessage.
	 */
	public BMINCTPFMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 566;
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
		fields[9] = fieldINALIAS = new CharacterField(message, HEADERSIZE + 76,
				15, "INALIAS");
		fields[10] = fieldINNAMES = new CharacterField(message,
				HEADERSIZE + 91, 15, "INNAMES");
		fields[11] = fieldINNOCEL = new DecimalField(message, HEADERSIZE + 106,
				11, 0, "INNOCEL");
		fields[12] = fieldINTICEL = new CharacterField(message,
				HEADERSIZE + 117, 2, "INTICEL");
		fields[13] = fieldININDAL = new CharacterField(message,
				HEADERSIZE + 119, 1, "ININDAL");
		fields[14] = fieldINAUTEP = new CharacterField(message,
				HEADERSIZE + 120, 1, "INAUTEP");
		fields[15] = fieldINPAQSR = new CharacterField(message,
				HEADERSIZE + 121, 4, "INPAQSR");
		fields[16] = fieldINSTSSR = new CharacterField(message,
				HEADERSIZE + 125, 1, "INSTSSR");
		fields[17] = fieldINCOMIS = new DecimalField(message, HEADERSIZE + 126,
				14, 2, "INCOMIS");
		fields[18] = fieldINCOSMS = new DecimalField(message, HEADERSIZE + 140,
				14, 2, "INCOSMS");
		fields[19] = fieldINIVACO = new DecimalField(message, HEADERSIZE + 154,
				8, 2, "INIVACO");
		fields[20] = fieldINFETRN = new DecimalField(message, HEADERSIZE + 162,
				9, 0, "INFETRN");
		fields[21] = fieldINHRTRN = new DecimalField(message, HEADERSIZE + 171,
				7, 0, "INHRTRN");
		fields[22] = fieldINTPTRN = new CharacterField(message,
				HEADERSIZE + 178, 4, "INTPTRN");
		fields[23] = fieldINIMPOR = new DecimalField(message, HEADERSIZE + 182,
				17, 2, "INIMPOR");
		fields[24] = fieldINSTSTR = new CharacterField(message,
				HEADERSIZE + 199, 2, "INSTSTR");
		fields[25] = fieldINLDTRP = new DecimalField(message, HEADERSIZE + 201,
				17, 2, "INLDTRP");
		fields[26] = fieldINADTRP = new DecimalField(message, HEADERSIZE + 218,
				17, 2, "INADTRP");
		fields[27] = fieldINLMTRP = new DecimalField(message, HEADERSIZE + 235,
				17, 2, "INLMTRP");
		fields[28] = fieldINAMTRP = new DecimalField(message, HEADERSIZE + 252,
				17, 2, "INAMTRP");
		fields[29] = fieldINLDTIN = new DecimalField(message, HEADERSIZE + 269,
				17, 2, "INLDTIN");
		fields[30] = fieldINADTIN = new DecimalField(message, HEADERSIZE + 286,
				17, 2, "INADTIN");
		fields[31] = fieldINLMTIN = new DecimalField(message, HEADERSIZE + 303,
				17, 2, "INLMTIN");
		fields[32] = fieldINAMTIN = new DecimalField(message, HEADERSIZE + 320,
				17, 2, "INAMTIN");
		fields[33] = fieldINLDPTC = new DecimalField(message, HEADERSIZE + 337,
				17, 2, "INLDPTC");
		fields[34] = fieldINADPTC = new DecimalField(message, HEADERSIZE + 354,
				17, 2, "INADPTC");
		fields[35] = fieldINLMPTC = new DecimalField(message, HEADERSIZE + 371,
				17, 2, "INLMPTC");
		fields[36] = fieldINAMPTC = new DecimalField(message, HEADERSIZE + 388,
				17, 2, "INAMPTC");
		fields[37] = fieldINLDRCE = new DecimalField(message, HEADERSIZE + 405,
				17, 2, "INLDRCE");
		fields[38] = fieldINADRCE = new DecimalField(message, HEADERSIZE + 422,
				17, 2, "INADRCE");
		fields[39] = fieldINLMRCE = new DecimalField(message, HEADERSIZE + 439,
				17, 2, "INLMRCE");
		fields[40] = fieldINAMRCE = new DecimalField(message, HEADERSIZE + 456,
				17, 2, "INAMRCE");
		fields[41] = fieldINSUCUR = new DecimalField(message, HEADERSIZE + 473,
				5, 0, "INSUCUR");
		fields[42] = fieldINUSERI = new CharacterField(message,
				HEADERSIZE + 478, 10, "INUSERI");
		fields[43] = fieldINFEALT = new DecimalField(message, HEADERSIZE + 488,
				9, 0, "INFEALT");
		fields[44] = fieldINHRALT = new DecimalField(message, HEADERSIZE + 497,
				7, 0, "INHRALT");
		fields[45] = fieldINFECAN = new DecimalField(message, HEADERSIZE + 504,
				9, 0, "INFECAN");
		fields[46] = fieldINHRCAN = new DecimalField(message, HEADERSIZE + 513,
				7, 0, "INHRCAN");
		fields[47] = fieldINESTAT = new CharacterField(message,
				HEADERSIZE + 520, 1, "INESTAT");
		fields[48] = fieldINCORRE = new CharacterField(message,
				HEADERSIZE + 521, 45, "INCORRE");

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
	 * Set field INALIAS using a String value.
	 */
	public void setINALIAS(String newvalue) {
		fieldINALIAS.setString(newvalue);
	}

	/**
	 * Get value of field INALIAS as a String.
	 */
	public String getINALIAS() {
		return fieldINALIAS.getString();
	}

	/**
	 * Set field INNAMES using a String value.
	 */
	public void setINNAMES(String newvalue) {
		fieldINNAMES.setString(newvalue);
	}

	/**
	 * Get value of field INNAMES as a String.
	 */
	public String getINNAMES() {
		return fieldINNAMES.getString();
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
	 * Set field ININDAL using a String value.
	 */
	public void setININDAL(String newvalue) {
		fieldININDAL.setString(newvalue);
	}

	/**
	 * Get value of field ININDAL as a String.
	 */
	public String getININDAL() {
		return fieldININDAL.getString();
	}

	/**
	 * Set field INAUTEP using a String value.
	 */
	public void setINAUTEP(String newvalue) {
		fieldINAUTEP.setString(newvalue);
	}

	/**
	 * Get value of field INAUTEP as a String.
	 */
	public String getINAUTEP() {
		return fieldINAUTEP.getString();
	}

	/**
	 * Set field INPAQSR using a String value.
	 */
	public void setINPAQSR(String newvalue) {
		fieldINPAQSR.setString(newvalue);
	}

	/**
	 * Get value of field INPAQSR as a String.
	 */
	public String getINPAQSR() {
		return fieldINPAQSR.getString();
	}

	/**
	 * Set field INSTSSR using a String value.
	 */
	public void setINSTSSR(String newvalue) {
		fieldINSTSSR.setString(newvalue);
	}

	/**
	 * Get value of field INSTSSR as a String.
	 */
	public String getINSTSSR() {
		return fieldINSTSSR.getString();
	}

	/**
	 * Set field INCOMIS using a String value.
	 */
	public void setINCOMIS(String newvalue) {
		fieldINCOMIS.setString(newvalue);
	}

	/**
	 * Get value of field INCOMIS as a String.
	 */
	public String getINCOMIS() {
		return fieldINCOMIS.getString();
	}

	/**
	 * Set numeric field INCOMIS using a BigDecimal value.
	 */
	public void setINCOMIS(BigDecimal newvalue) {
		fieldINCOMIS.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCOMIS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCOMIS() {
		return fieldINCOMIS.getBigDecimal();
	}

	/**
	 * Set field INCOSMS using a String value.
	 */
	public void setINCOSMS(String newvalue) {
		fieldINCOSMS.setString(newvalue);
	}

	/**
	 * Get value of field INCOSMS as a String.
	 */
	public String getINCOSMS() {
		return fieldINCOSMS.getString();
	}

	/**
	 * Set numeric field INCOSMS using a BigDecimal value.
	 */
	public void setINCOSMS(BigDecimal newvalue) {
		fieldINCOSMS.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCOSMS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCOSMS() {
		return fieldINCOSMS.getBigDecimal();
	}

	/**
	 * Set field INIVACO using a String value.
	 */
	public void setINIVACO(String newvalue) {
		fieldINIVACO.setString(newvalue);
	}

	/**
	 * Get value of field INIVACO as a String.
	 */
	public String getINIVACO() {
		return fieldINIVACO.getString();
	}

	/**
	 * Set numeric field INIVACO using a BigDecimal value.
	 */
	public void setINIVACO(BigDecimal newvalue) {
		fieldINIVACO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INIVACO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINIVACO() {
		return fieldINIVACO.getBigDecimal();
	}

	/**
	 * Set field INFETRN using a String value.
	 */
	public void setINFETRN(String newvalue) {
		fieldINFETRN.setString(newvalue);
	}

	/**
	 * Get value of field INFETRN as a String.
	 */
	public String getINFETRN() {
		return fieldINFETRN.getString();
	}

	/**
	 * Set numeric field INFETRN using a BigDecimal value.
	 */
	public void setINFETRN(BigDecimal newvalue) {
		fieldINFETRN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INFETRN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINFETRN() {
		return fieldINFETRN.getBigDecimal();
	}

	/**
	 * Set field INHRTRN using a String value.
	 */
	public void setINHRTRN(String newvalue) {
		fieldINHRTRN.setString(newvalue);
	}

	/**
	 * Get value of field INHRTRN as a String.
	 */
	public String getINHRTRN() {
		return fieldINHRTRN.getString();
	}

	/**
	 * Set numeric field INHRTRN using a BigDecimal value.
	 */
	public void setINHRTRN(BigDecimal newvalue) {
		fieldINHRTRN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INHRTRN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINHRTRN() {
		return fieldINHRTRN.getBigDecimal();
	}

	/**
	 * Set field INTPTRN using a String value.
	 */
	public void setINTPTRN(String newvalue) {
		fieldINTPTRN.setString(newvalue);
	}

	/**
	 * Get value of field INTPTRN as a String.
	 */
	public String getINTPTRN() {
		return fieldINTPTRN.getString();
	}

	/**
	 * Set field INIMPOR using a String value.
	 */
	public void setINIMPOR(String newvalue) {
		fieldINIMPOR.setString(newvalue);
	}

	/**
	 * Get value of field INIMPOR as a String.
	 */
	public String getINIMPOR() {
		return fieldINIMPOR.getString();
	}

	/**
	 * Set numeric field INIMPOR using a BigDecimal value.
	 */
	public void setINIMPOR(BigDecimal newvalue) {
		fieldINIMPOR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INIMPOR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINIMPOR() {
		return fieldINIMPOR.getBigDecimal();
	}

	/**
	 * Set field INSTSTR using a String value.
	 */
	public void setINSTSTR(String newvalue) {
		fieldINSTSTR.setString(newvalue);
	}

	/**
	 * Get value of field INSTSTR as a String.
	 */
	public String getINSTSTR() {
		return fieldINSTSTR.getString();
	}

	/**
	 * Set field INLDTRP using a String value.
	 */
	public void setINLDTRP(String newvalue) {
		fieldINLDTRP.setString(newvalue);
	}

	/**
	 * Get value of field INLDTRP as a String.
	 */
	public String getINLDTRP() {
		return fieldINLDTRP.getString();
	}

	/**
	 * Set numeric field INLDTRP using a BigDecimal value.
	 */
	public void setINLDTRP(BigDecimal newvalue) {
		fieldINLDTRP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLDTRP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLDTRP() {
		return fieldINLDTRP.getBigDecimal();
	}

	/**
	 * Set field INADTRP using a String value.
	 */
	public void setINADTRP(String newvalue) {
		fieldINADTRP.setString(newvalue);
	}

	/**
	 * Get value of field INADTRP as a String.
	 */
	public String getINADTRP() {
		return fieldINADTRP.getString();
	}

	/**
	 * Set numeric field INADTRP using a BigDecimal value.
	 */
	public void setINADTRP(BigDecimal newvalue) {
		fieldINADTRP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INADTRP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINADTRP() {
		return fieldINADTRP.getBigDecimal();
	}

	/**
	 * Set field INLMTRP using a String value.
	 */
	public void setINLMTRP(String newvalue) {
		fieldINLMTRP.setString(newvalue);
	}

	/**
	 * Get value of field INLMTRP as a String.
	 */
	public String getINLMTRP() {
		return fieldINLMTRP.getString();
	}

	/**
	 * Set numeric field INLMTRP using a BigDecimal value.
	 */
	public void setINLMTRP(BigDecimal newvalue) {
		fieldINLMTRP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLMTRP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLMTRP() {
		return fieldINLMTRP.getBigDecimal();
	}

	/**
	 * Set field INAMTRP using a String value.
	 */
	public void setINAMTRP(String newvalue) {
		fieldINAMTRP.setString(newvalue);
	}

	/**
	 * Get value of field INAMTRP as a String.
	 */
	public String getINAMTRP() {
		return fieldINAMTRP.getString();
	}

	/**
	 * Set numeric field INAMTRP using a BigDecimal value.
	 */
	public void setINAMTRP(BigDecimal newvalue) {
		fieldINAMTRP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INAMTRP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINAMTRP() {
		return fieldINAMTRP.getBigDecimal();
	}

	/**
	 * Set field INLDTIN using a String value.
	 */
	public void setINLDTIN(String newvalue) {
		fieldINLDTIN.setString(newvalue);
	}

	/**
	 * Get value of field INLDTIN as a String.
	 */
	public String getINLDTIN() {
		return fieldINLDTIN.getString();
	}

	/**
	 * Set numeric field INLDTIN using a BigDecimal value.
	 */
	public void setINLDTIN(BigDecimal newvalue) {
		fieldINLDTIN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLDTIN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLDTIN() {
		return fieldINLDTIN.getBigDecimal();
	}

	/**
	 * Set field INADTIN using a String value.
	 */
	public void setINADTIN(String newvalue) {
		fieldINADTIN.setString(newvalue);
	}

	/**
	 * Get value of field INADTIN as a String.
	 */
	public String getINADTIN() {
		return fieldINADTIN.getString();
	}

	/**
	 * Set numeric field INADTIN using a BigDecimal value.
	 */
	public void setINADTIN(BigDecimal newvalue) {
		fieldINADTIN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INADTIN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINADTIN() {
		return fieldINADTIN.getBigDecimal();
	}

	/**
	 * Set field INLMTIN using a String value.
	 */
	public void setINLMTIN(String newvalue) {
		fieldINLMTIN.setString(newvalue);
	}

	/**
	 * Get value of field INLMTIN as a String.
	 */
	public String getINLMTIN() {
		return fieldINLMTIN.getString();
	}

	/**
	 * Set numeric field INLMTIN using a BigDecimal value.
	 */
	public void setINLMTIN(BigDecimal newvalue) {
		fieldINLMTIN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLMTIN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLMTIN() {
		return fieldINLMTIN.getBigDecimal();
	}

	/**
	 * Set field INAMTIN using a String value.
	 */
	public void setINAMTIN(String newvalue) {
		fieldINAMTIN.setString(newvalue);
	}

	/**
	 * Get value of field INAMTIN as a String.
	 */
	public String getINAMTIN() {
		return fieldINAMTIN.getString();
	}

	/**
	 * Set numeric field INAMTIN using a BigDecimal value.
	 */
	public void setINAMTIN(BigDecimal newvalue) {
		fieldINAMTIN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INAMTIN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINAMTIN() {
		return fieldINAMTIN.getBigDecimal();
	}

	/**
	 * Set field INLDPTC using a String value.
	 */
	public void setINLDPTC(String newvalue) {
		fieldINLDPTC.setString(newvalue);
	}

	/**
	 * Get value of field INLDPTC as a String.
	 */
	public String getINLDPTC() {
		return fieldINLDPTC.getString();
	}

	/**
	 * Set numeric field INLDPTC using a BigDecimal value.
	 */
	public void setINLDPTC(BigDecimal newvalue) {
		fieldINLDPTC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLDPTC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLDPTC() {
		return fieldINLDPTC.getBigDecimal();
	}

	/**
	 * Set field INADPTC using a String value.
	 */
	public void setINADPTC(String newvalue) {
		fieldINADPTC.setString(newvalue);
	}

	/**
	 * Get value of field INADPTC as a String.
	 */
	public String getINADPTC() {
		return fieldINADPTC.getString();
	}

	/**
	 * Set numeric field INADPTC using a BigDecimal value.
	 */
	public void setINADPTC(BigDecimal newvalue) {
		fieldINADPTC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INADPTC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINADPTC() {
		return fieldINADPTC.getBigDecimal();
	}

	/**
	 * Set field INLMPTC using a String value.
	 */
	public void setINLMPTC(String newvalue) {
		fieldINLMPTC.setString(newvalue);
	}

	/**
	 * Get value of field INLMPTC as a String.
	 */
	public String getINLMPTC() {
		return fieldINLMPTC.getString();
	}

	/**
	 * Set numeric field INLMPTC using a BigDecimal value.
	 */
	public void setINLMPTC(BigDecimal newvalue) {
		fieldINLMPTC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLMPTC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLMPTC() {
		return fieldINLMPTC.getBigDecimal();
	}

	/**
	 * Set field INAMPTC using a String value.
	 */
	public void setINAMPTC(String newvalue) {
		fieldINAMPTC.setString(newvalue);
	}

	/**
	 * Get value of field INAMPTC as a String.
	 */
	public String getINAMPTC() {
		return fieldINAMPTC.getString();
	}

	/**
	 * Set numeric field INAMPTC using a BigDecimal value.
	 */
	public void setINAMPTC(BigDecimal newvalue) {
		fieldINAMPTC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INAMPTC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINAMPTC() {
		return fieldINAMPTC.getBigDecimal();
	}

	/**
	 * Set field INLDRCE using a String value.
	 */
	public void setINLDRCE(String newvalue) {
		fieldINLDRCE.setString(newvalue);
	}

	/**
	 * Get value of field INLDRCE as a String.
	 */
	public String getINLDRCE() {
		return fieldINLDRCE.getString();
	}

	/**
	 * Set numeric field INLDRCE using a BigDecimal value.
	 */
	public void setINLDRCE(BigDecimal newvalue) {
		fieldINLDRCE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLDRCE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLDRCE() {
		return fieldINLDRCE.getBigDecimal();
	}

	/**
	 * Set field INADRCE using a String value.
	 */
	public void setINADRCE(String newvalue) {
		fieldINADRCE.setString(newvalue);
	}

	/**
	 * Get value of field INADRCE as a String.
	 */
	public String getINADRCE() {
		return fieldINADRCE.getString();
	}

	/**
	 * Set numeric field INADRCE using a BigDecimal value.
	 */
	public void setINADRCE(BigDecimal newvalue) {
		fieldINADRCE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INADRCE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINADRCE() {
		return fieldINADRCE.getBigDecimal();
	}

	/**
	 * Set field INLMRCE using a String value.
	 */
	public void setINLMRCE(String newvalue) {
		fieldINLMRCE.setString(newvalue);
	}

	/**
	 * Get value of field INLMRCE as a String.
	 */
	public String getINLMRCE() {
		return fieldINLMRCE.getString();
	}

	/**
	 * Set numeric field INLMRCE using a BigDecimal value.
	 */
	public void setINLMRCE(BigDecimal newvalue) {
		fieldINLMRCE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLMRCE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLMRCE() {
		return fieldINLMRCE.getBigDecimal();
	}

	/**
	 * Set field INAMRCE using a String value.
	 */
	public void setINAMRCE(String newvalue) {
		fieldINAMRCE.setString(newvalue);
	}

	/**
	 * Get value of field INAMRCE as a String.
	 */
	public String getINAMRCE() {
		return fieldINAMRCE.getString();
	}

	/**
	 * Set numeric field INAMRCE using a BigDecimal value.
	 */
	public void setINAMRCE(BigDecimal newvalue) {
		fieldINAMRCE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INAMRCE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINAMRCE() {
		return fieldINAMRCE.getBigDecimal();
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
	 * Set field INUSERI using a String value.
	 */
	public void setINUSERI(String newvalue) {
		fieldINUSERI.setString(newvalue);
	}

	/**
	 * Get value of field INUSERI as a String.
	 */
	public String getINUSERI() {
		return fieldINUSERI.getString();
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
	 * Set field INCORRE using a String value.
	 */
	public void setINCORRE(String newvalue) {
		fieldINCORRE.setString(newvalue);
	}

	/**
	 * Get value of field INCORRE as a String.
	 */
	public String getINCORRE() {
		return fieldINCORRE.getString();
	}

}
