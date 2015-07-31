package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.DecimalField;
import com.datapro.sockets.CharacterField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

@SuppressWarnings("rawtypes")
public class INCONTPFMessage extends MessageRecord {

	final static String fldnames[] = { "PCSUCO", "PCCONI", "PCUSUA", "PSFOLI",
			"PCREFI", "PCCONS", "PCREFS", "PCTIPTI", "PCCLIE", "PCCTAC",
			"PCDSC1", "PCESTP", "PCEMAD", "PCPAGMI", "PCPAGMA", "PCFEINC",
			"PCFEFNC", "PCTOTP", "PCIMCO", "PCFEAC", "PCHOAC", "PCFECA",
			"PCHOCA", "PCFMOD", "PCHMOD", "PCFULT", "PCHULT", "PCTITS" };
	final static String tnames[] = { "PCSUCO", "PCCONI", "PCUSUA", "PSFOLI",
			"PCREFI", "PCCONS", "PCREFS", "PCTIPTI", "PCCLIE", "PCCTAC",
			"PCDSC1", "PCESTP", "PCEMAD", "PCPAGMI", "PCPAGMA", "PCFEINC",
			"PCFEFNC", "PCTOTP", "PCIMCO", "PCFEAC", "PCHOAC", "PCFECA",
			"PCHOCA", "PCFMOD", "PCHMOD", "PCFULT", "PCHULT", "PCTITS" };
	final static String fid = "1131021123535";
	final static String rid = "48D7C26D30DCB";
	final static String fmtname = "INCONTPF";
	final int FIELDCOUNT = 28;
	private static Hashtable tlookup = new Hashtable();
	private DecimalField fieldPCSUCO = null;
	private CharacterField fieldPCCONI = null;
	private CharacterField fieldPCUSUA = null;
	private CharacterField fieldPSFOLI = null;
	private CharacterField fieldPCREFI = null;
	private DecimalField fieldPCCONS = null;
	private CharacterField fieldPCREFS = null;
	private CharacterField fieldPCTIPTI = null;
	private DecimalField fieldPCCLIE = null;
	private DecimalField fieldPCCTAC = null;
	private CharacterField fieldPCDSC1 = null;
	private CharacterField fieldPCESTP = null;
	private CharacterField fieldPCEMAD = null;
	private DecimalField fieldPCPAGMI = null;
	private DecimalField fieldPCPAGMA = null;
	private DecimalField fieldPCFEINC = null;
	private DecimalField fieldPCFEFNC = null;
	private DecimalField fieldPCTOTP = null;
	private DecimalField fieldPCIMCO = null;
	private DecimalField fieldPCFEAC = null;
	private DecimalField fieldPCHOAC = null;
	private DecimalField fieldPCFECA = null;
	private DecimalField fieldPCHOCA = null;
	private DecimalField fieldPCFMOD = null;
	private DecimalField fieldPCHMOD = null;
	private DecimalField fieldPCFULT = null;
	private DecimalField fieldPCHULT = null;
	private CharacterField fieldPCTITS = null;

	/**
	 * Constructor for INCONTPFMessage.
	 */
	public INCONTPFMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 396;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldPCSUCO = new DecimalField(message, HEADERSIZE + 0, 6,
				0, "PCSUCO");
		fields[1] = fieldPCCONI = new CharacterField(message, HEADERSIZE + 6,
				10, "PCCONI");
		fields[2] = fieldPCUSUA = new CharacterField(message, HEADERSIZE + 16,
				10, "PCUSUA");
		fields[3] = fieldPSFOLI = new CharacterField(message, HEADERSIZE + 26,
				10, "PSFOLI");
		fields[4] = fieldPCREFI = new CharacterField(message, HEADERSIZE + 36,
				12, "PCREFI");
		fields[5] = fieldPCCONS = new DecimalField(message, HEADERSIZE + 48, 4,
				0, "PCCONS");
		fields[6] = fieldPCREFS = new CharacterField(message, HEADERSIZE + 52,
				32, "PCREFS");
		fields[7] = fieldPCTIPTI = new CharacterField(message, HEADERSIZE + 84,
				2, "PCTIPTI");
		fields[8] = fieldPCCLIE = new DecimalField(message, HEADERSIZE + 86,
				10, 0, "PCCLIE");
		fields[9] = fieldPCCTAC = new DecimalField(message, HEADERSIZE + 96,
				21, 0, "PCCTAC");
		fields[10] = fieldPCDSC1 = new CharacterField(message,
				HEADERSIZE + 117, 45, "PCDSC1");
		fields[11] = fieldPCESTP = new CharacterField(message,
				HEADERSIZE + 162, 2, "PCESTP");
		fields[12] = fieldPCEMAD = new CharacterField(message,
				HEADERSIZE + 164, 45, "PCEMAD");
		fields[13] = fieldPCPAGMI = new DecimalField(message, HEADERSIZE + 209,
				15, 2, "PCPAGMI");
		fields[14] = fieldPCPAGMA = new DecimalField(message, HEADERSIZE + 224,
				15, 2, "PCPAGMA");
		fields[15] = fieldPCFEINC = new DecimalField(message, HEADERSIZE + 239,
				9, 0, "PCFEINC");
		fields[16] = fieldPCFEFNC = new DecimalField(message, HEADERSIZE + 248,
				9, 0, "PCFEFNC");
		fields[17] = fieldPCTOTP = new DecimalField(message, HEADERSIZE + 257,
				15, 2, "PCTOTP");
		fields[18] = fieldPCIMCO = new DecimalField(message, HEADERSIZE + 272,
				15, 2, "PCIMCO");
		fields[19] = fieldPCFEAC = new DecimalField(message, HEADERSIZE + 287,
				9, 0, "PCFEAC");
		fields[20] = fieldPCHOAC = new DecimalField(message, HEADERSIZE + 296,
				7, 0, "PCHOAC");
		fields[21] = fieldPCFECA = new DecimalField(message, HEADERSIZE + 303,
				9, 0, "PCFECA");
		fields[22] = fieldPCHOCA = new DecimalField(message, HEADERSIZE + 312,
				7, 0, "PCHOCA");
		fields[23] = fieldPCFMOD = new DecimalField(message, HEADERSIZE + 319,
				9, 0, "PCFMOD");
		fields[24] = fieldPCHMOD = new DecimalField(message, HEADERSIZE + 328,
				7, 0, "PCHMOD");
		fields[25] = fieldPCFULT = new DecimalField(message, HEADERSIZE + 335,
				9, 0, "PCFULT");
		fields[26] = fieldPCHULT = new DecimalField(message, HEADERSIZE + 344,
				7, 0, "PCHULT");
		fields[27] = fieldPCTITS = new CharacterField(message,
				HEADERSIZE + 351, 45, "PCTITS");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field PCSUCO using a String value.
	 */
	public void setPCSUCO(String newvalue) {
		fieldPCSUCO.setString(newvalue);
	}

	/**
	 * Get value of field PCSUCO as a String.
	 */
	public String getPCSUCO() {
		return fieldPCSUCO.getString();
	}

	/**
	 * Set numeric field PCSUCO using a BigDecimal value.
	 */
	public void setPCSUCO(BigDecimal newvalue) {
		fieldPCSUCO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCSUCO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCSUCO() {
		return fieldPCSUCO.getBigDecimal();
	}

	/**
	 * Set field PCCONI using a String value.
	 */
	public void setPCCONI(String newvalue) {
		fieldPCCONI.setString(newvalue);
	}

	/**
	 * Get value of field PCCONI as a String.
	 */
	public String getPCCONI() {
		return fieldPCCONI.getString();
	}

	/**
	 * Set field PCUSUA using a String value.
	 */
	public void setPCUSUA(String newvalue) {
		fieldPCUSUA.setString(newvalue);
	}

	/**
	 * Get value of field PCUSUA as a String.
	 */
	public String getPCUSUA() {
		return fieldPCUSUA.getString();
	}

	/**
	 * Set field PSFOLI using a String value.
	 */
	public void setPSFOLI(String newvalue) {
		fieldPSFOLI.setString(newvalue);
	}

	/**
	 * Get value of field PSFOLI as a String.
	 */
	public String getPSFOLI() {
		return fieldPSFOLI.getString();
	}

	/**
	 * Set field PCREFI using a String value.
	 */
	public void setPCREFI(String newvalue) {
		fieldPCREFI.setString(newvalue);
	}

	/**
	 * Get value of field PCREFI as a String.
	 */
	public String getPCREFI() {
		return fieldPCREFI.getString();
	}

	/**
	 * Set field PCCONS using a String value.
	 */
	public void setPCCONS(String newvalue) {
		fieldPCCONS.setString(newvalue);
	}

	/**
	 * Get value of field PCCONS as a String.
	 */
	public String getPCCONS() {
		return fieldPCCONS.getString();
	}

	/**
	 * Set numeric field PCCONS using a BigDecimal value.
	 */
	public void setPCCONS(BigDecimal newvalue) {
		fieldPCCONS.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCCONS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCCONS() {
		return fieldPCCONS.getBigDecimal();
	}

	/**
	 * Set field PCREFS using a String value.
	 */
	public void setPCREFS(String newvalue) {
		fieldPCREFS.setString(newvalue);
	}

	/**
	 * Get value of field PCREFS as a String.
	 */
	public String getPCREFS() {
		return fieldPCREFS.getString();
	}

	/**
	 * Set field PCTIPTI using a String value.
	 */
	public void setPCTIPTI(String newvalue) {
		fieldPCTIPTI.setString(newvalue);
	}

	/**
	 * Get value of field PCTIPTI as a String.
	 */
	public String getPCTIPTI() {
		return fieldPCTIPTI.getString();
	}

	/**
	 * Set field PCCLIE using a String value.
	 */
	public void setPCCLIE(String newvalue) {
		fieldPCCLIE.setString(newvalue);
	}

	/**
	 * Get value of field PCCLIE as a String.
	 */
	public String getPCCLIE() {
		return fieldPCCLIE.getString();
	}

	/**
	 * Set numeric field PCCLIE using a BigDecimal value.
	 */
	public void setPCCLIE(BigDecimal newvalue) {
		fieldPCCLIE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCCLIE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCCLIE() {
		return fieldPCCLIE.getBigDecimal();
	}

	/**
	 * Set field PCCTAC using a String value.
	 */
	public void setPCCTAC(String newvalue) {
		fieldPCCTAC.setString(newvalue);
	}

	/**
	 * Get value of field PCCTAC as a String.
	 */
	public String getPCCTAC() {
		return fieldPCCTAC.getString();
	}

	/**
	 * Set numeric field PCCTAC using a BigDecimal value.
	 */
	public void setPCCTAC(BigDecimal newvalue) {
		fieldPCCTAC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCCTAC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCCTAC() {
		return fieldPCCTAC.getBigDecimal();
	}

	/**
	 * Set field PCDSC1 using a String value.
	 */
	public void setPCDSC1(String newvalue) {
		fieldPCDSC1.setString(newvalue);
	}

	/**
	 * Get value of field PCDSC1 as a String.
	 */
	public String getPCDSC1() {
		return fieldPCDSC1.getString();
	}

	/**
	 * Set field PCESTP using a String value.
	 */
	public void setPCESTP(String newvalue) {
		fieldPCESTP.setString(newvalue);
	}

	/**
	 * Get value of field PCESTP as a String.
	 */
	public String getPCESTP() {
		return fieldPCESTP.getString();
	}

	/**
	 * Set field PCEMAD using a String value.
	 */
	public void setPCEMAD(String newvalue) {
		fieldPCEMAD.setString(newvalue);
	}

	/**
	 * Get value of field PCEMAD as a String.
	 */
	public String getPCEMAD() {
		return fieldPCEMAD.getString();
	}

	/**
	 * Set field PCPAGMI using a String value.
	 */
	public void setPCPAGMI(String newvalue) {
		fieldPCPAGMI.setString(newvalue);
	}

	/**
	 * Get value of field PCPAGMI as a String.
	 */
	public String getPCPAGMI() {
		return fieldPCPAGMI.getString();
	}

	/**
	 * Set numeric field PCPAGMI using a BigDecimal value.
	 */
	public void setPCPAGMI(BigDecimal newvalue) {
		fieldPCPAGMI.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCPAGMI as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCPAGMI() {
		return fieldPCPAGMI.getBigDecimal();
	}

	/**
	 * Set field PCPAGMA using a String value.
	 */
	public void setPCPAGMA(String newvalue) {
		fieldPCPAGMA.setString(newvalue);
	}

	/**
	 * Get value of field PCPAGMA as a String.
	 */
	public String getPCPAGMA() {
		return fieldPCPAGMA.getString();
	}

	/**
	 * Set numeric field PCPAGMA using a BigDecimal value.
	 */
	public void setPCPAGMA(BigDecimal newvalue) {
		fieldPCPAGMA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCPAGMA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCPAGMA() {
		return fieldPCPAGMA.getBigDecimal();
	}

	/**
	 * Set field PCFEINC using a String value.
	 */
	public void setPCFEINC(String newvalue) {
		fieldPCFEINC.setString(newvalue);
	}

	/**
	 * Get value of field PCFEINC as a String.
	 */
	public String getPCFEINC() {
		return fieldPCFEINC.getString();
	}

	/**
	 * Set numeric field PCFEINC using a BigDecimal value.
	 */
	public void setPCFEINC(BigDecimal newvalue) {
		fieldPCFEINC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCFEINC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCFEINC() {
		return fieldPCFEINC.getBigDecimal();
	}

	/**
	 * Set field PCFEFNC using a String value.
	 */
	public void setPCFEFNC(String newvalue) {
		fieldPCFEFNC.setString(newvalue);
	}

	/**
	 * Get value of field PCFEFNC as a String.
	 */
	public String getPCFEFNC() {
		return fieldPCFEFNC.getString();
	}

	/**
	 * Set numeric field PCFEFNC using a BigDecimal value.
	 */
	public void setPCFEFNC(BigDecimal newvalue) {
		fieldPCFEFNC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCFEFNC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCFEFNC() {
		return fieldPCFEFNC.getBigDecimal();
	}

	/**
	 * Set field PCTOTP using a String value.
	 */
	public void setPCTOTP(String newvalue) {
		fieldPCTOTP.setString(newvalue);
	}

	/**
	 * Get value of field PCTOTP as a String.
	 */
	public String getPCTOTP() {
		return fieldPCTOTP.getString();
	}

	/**
	 * Set numeric field PCTOTP using a BigDecimal value.
	 */
	public void setPCTOTP(BigDecimal newvalue) {
		fieldPCTOTP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCTOTP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCTOTP() {
		return fieldPCTOTP.getBigDecimal();
	}

	/**
	 * Set field PCIMCO using a String value.
	 */
	public void setPCIMCO(String newvalue) {
		fieldPCIMCO.setString(newvalue);
	}

	/**
	 * Get value of field PCIMCO as a String.
	 */
	public String getPCIMCO() {
		return fieldPCIMCO.getString();
	}

	/**
	 * Set numeric field PCIMCO using a BigDecimal value.
	 */
	public void setPCIMCO(BigDecimal newvalue) {
		fieldPCIMCO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCIMCO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCIMCO() {
		return fieldPCIMCO.getBigDecimal();
	}

	/**
	 * Set field PCFEAC using a String value.
	 */
	public void setPCFEAC(String newvalue) {
		fieldPCFEAC.setString(newvalue);
	}

	/**
	 * Get value of field PCFEAC as a String.
	 */
	public String getPCFEAC() {
		return fieldPCFEAC.getString();
	}

	/**
	 * Set numeric field PCFEAC using a BigDecimal value.
	 */
	public void setPCFEAC(BigDecimal newvalue) {
		fieldPCFEAC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCFEAC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCFEAC() {
		return fieldPCFEAC.getBigDecimal();
	}

	/**
	 * Set field PCHOAC using a String value.
	 */
	public void setPCHOAC(String newvalue) {
		fieldPCHOAC.setString(newvalue);
	}

	/**
	 * Get value of field PCHOAC as a String.
	 */
	public String getPCHOAC() {
		return fieldPCHOAC.getString();
	}

	/**
	 * Set numeric field PCHOAC using a BigDecimal value.
	 */
	public void setPCHOAC(BigDecimal newvalue) {
		fieldPCHOAC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCHOAC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCHOAC() {
		return fieldPCHOAC.getBigDecimal();
	}

	/**
	 * Set field PCFECA using a String value.
	 */
	public void setPCFECA(String newvalue) {
		fieldPCFECA.setString(newvalue);
	}

	/**
	 * Get value of field PCFECA as a String.
	 */
	public String getPCFECA() {
		return fieldPCFECA.getString();
	}

	/**
	 * Set numeric field PCFECA using a BigDecimal value.
	 */
	public void setPCFECA(BigDecimal newvalue) {
		fieldPCFECA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCFECA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCFECA() {
		return fieldPCFECA.getBigDecimal();
	}

	/**
	 * Set field PCHOCA using a String value.
	 */
	public void setPCHOCA(String newvalue) {
		fieldPCHOCA.setString(newvalue);
	}

	/**
	 * Get value of field PCHOCA as a String.
	 */
	public String getPCHOCA() {
		return fieldPCHOCA.getString();
	}

	/**
	 * Set numeric field PCHOCA using a BigDecimal value.
	 */
	public void setPCHOCA(BigDecimal newvalue) {
		fieldPCHOCA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCHOCA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCHOCA() {
		return fieldPCHOCA.getBigDecimal();
	}

	/**
	 * Set field PCFMOD using a String value.
	 */
	public void setPCFMOD(String newvalue) {
		fieldPCFMOD.setString(newvalue);
	}

	/**
	 * Get value of field PCFMOD as a String.
	 */
	public String getPCFMOD() {
		return fieldPCFMOD.getString();
	}

	/**
	 * Set numeric field PCFMOD using a BigDecimal value.
	 */
	public void setPCFMOD(BigDecimal newvalue) {
		fieldPCFMOD.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCFMOD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCFMOD() {
		return fieldPCFMOD.getBigDecimal();
	}

	/**
	 * Set field PCHMOD using a String value.
	 */
	public void setPCHMOD(String newvalue) {
		fieldPCHMOD.setString(newvalue);
	}

	/**
	 * Get value of field PCHMOD as a String.
	 */
	public String getPCHMOD() {
		return fieldPCHMOD.getString();
	}

	/**
	 * Set numeric field PCHMOD using a BigDecimal value.
	 */
	public void setPCHMOD(BigDecimal newvalue) {
		fieldPCHMOD.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCHMOD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCHMOD() {
		return fieldPCHMOD.getBigDecimal();
	}

	/**
	 * Set field PCFULT using a String value.
	 */
	public void setPCFULT(String newvalue) {
		fieldPCFULT.setString(newvalue);
	}

	/**
	 * Get value of field PCFULT as a String.
	 */
	public String getPCFULT() {
		return fieldPCFULT.getString();
	}

	/**
	 * Set numeric field PCFULT using a BigDecimal value.
	 */
	public void setPCFULT(BigDecimal newvalue) {
		fieldPCFULT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCFULT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCFULT() {
		return fieldPCFULT.getBigDecimal();
	}

	/**
	 * Set field PCHULT using a String value.
	 */
	public void setPCHULT(String newvalue) {
		fieldPCHULT.setString(newvalue);
	}

	/**
	 * Get value of field PCHULT as a String.
	 */
	public String getPCHULT() {
		return fieldPCHULT.getString();
	}

	/**
	 * Set numeric field PCHULT using a BigDecimal value.
	 */
	public void setPCHULT(BigDecimal newvalue) {
		fieldPCHULT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PCHULT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPCHULT() {
		return fieldPCHULT.getBigDecimal();
	}

	/**
	 * Set field PCTITS using a String value.
	 */
	public void setPCTITS(String newvalue) {
		fieldPCTITS.setString(newvalue);
	}

	/**
	 * Get value of field PCTITS as a String.
	 */
	public String getPCTITS() {
		return fieldPCTITS.getString();
	}

}
