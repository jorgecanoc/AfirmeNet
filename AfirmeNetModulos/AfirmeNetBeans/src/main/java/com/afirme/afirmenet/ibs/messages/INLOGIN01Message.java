package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from INLOGIN01 physical file
 * definition.
 * 
 * File level identifier is 1130325141418. Record format level identifier is
 * 4C95245D2F8DD.
 */
@SuppressWarnings("rawtypes")
public class INLOGIN01Message extends MessageRecord {
	final static String fldnames[] = { "PWDUSR", "PWDPWD", "PWDNPW", "PWDCPW",
			"PWDGRP", "PWDNCH", "PWDSTS", "PWDOPR", "PWDCFM", "PWDTRA",
			"PWDBPA", "PWDLCA", "PWDLNP", "PWDCCP", "PWDMAX", "PWDDTF",
			"PWDLGT", "PWDACL", "PWDCMP", "PWDINC", "PWDBUC", "PWDGEC",
			"PWDIAD", "PWDFAC", "PWDKID", "PWDEST", "PWDPAT", "PWDCUN",
			"PWDNME", "PWDSUC", "PWDALIAS", "PWDOFC", "PWDEML" };
	final static String tnames[] = { "PWDUSR", "PWDPWD", "PWDNPW", "PWDCPW",
			"PWDGRP", "PWDNCH", "PWDSTS", "PWDOPR", "PWDCFM", "PWDTRA",
			"PWDBPA", "PWDLCA", "PWDLNP", "PWDCCP", "PWDMAX", "PWDDTF",
			"PWDLGT", "PWDACL", "PWDCMP", "PWDINC", "PWDBUC", "PWDGEC",
			"PWDIAD", "PWDFAC", "PWDKID", "PWDEST", "PWDPAT", "PWDCUN",
			"PWDNME", "PWDSUC", "PWDALIAS", "PWDOFC", "PWDEML" };
	final static String fid = "1130325141418";
	final static String rid = "4C95245D2F8DD";
	final static String fmtname = "INLOGIN01";
	final int FIELDCOUNT = 33;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldPWDUSR = null;
	private CharacterField fieldPWDPWD = null;
	private CharacterField fieldPWDNPW = null;
	private CharacterField fieldPWDCPW = null;
	private CharacterField fieldPWDGRP = null;
	private CharacterField fieldPWDNCH = null;
	private CharacterField fieldPWDSTS = null;
	private CharacterField fieldPWDOPR = null;
	private CharacterField fieldPWDCFM = null;
	private CharacterField fieldPWDTRA = null;
	private CharacterField fieldPWDBPA = null;
	private CharacterField fieldPWDLCA = null;
	private CharacterField fieldPWDLNP = null;
	private CharacterField fieldPWDCCP = null;
	private DecimalField fieldPWDMAX = null;
	private CharacterField fieldPWDDTF = null;
	private CharacterField fieldPWDLGT = null;
	private CharacterField fieldPWDACL = null;
	private CharacterField fieldPWDCMP = null;
	private CharacterField fieldPWDINC = null;
	private CharacterField fieldPWDBUC = null;
	private CharacterField fieldPWDGEC = null;
	private CharacterField fieldPWDIAD = null;
	private CharacterField fieldPWDFAC = null;
	private CharacterField fieldPWDKID = null;
	private CharacterField fieldPWDEST = null;
	private CharacterField fieldPWDPAT = null;
	private DecimalField fieldPWDCUN = null;
	private CharacterField fieldPWDNME = null;
	private CharacterField fieldPWDSUC = null;
	private CharacterField fieldPWDALIAS = null;
	private CharacterField fieldPWDOFC = null;
	private CharacterField fieldPWDEML = null;

	/**
	 * Constructor for INLOGIN01Message.
	 */
	public INLOGIN01Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 347;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldPWDUSR = new CharacterField(message, HEADERSIZE + 0,
				10, "PWDUSR");
		fields[1] = fieldPWDPWD = new CharacterField(message, HEADERSIZE + 10,
				10, "PWDPWD");
		fields[2] = fieldPWDNPW = new CharacterField(message, HEADERSIZE + 20,
				10, "PWDNPW");
		fields[3] = fieldPWDCPW = new CharacterField(message, HEADERSIZE + 30,
				10, "PWDCPW");
		fields[4] = fieldPWDGRP = new CharacterField(message, HEADERSIZE + 40,
				4, "PWDGRP");
		fields[5] = fieldPWDNCH = new CharacterField(message, HEADERSIZE + 44,
				2, "PWDNCH");
		fields[6] = fieldPWDSTS = new CharacterField(message, HEADERSIZE + 46,
				1, "PWDSTS");
		fields[7] = fieldPWDOPR = new CharacterField(message, HEADERSIZE + 47,
				1, "PWDOPR");
		fields[8] = fieldPWDCFM = new CharacterField(message, HEADERSIZE + 48,
				1, "PWDCFM");
		fields[9] = fieldPWDTRA = new CharacterField(message, HEADERSIZE + 49,
				1, "PWDTRA");
		fields[10] = fieldPWDBPA = new CharacterField(message, HEADERSIZE + 50,
				1, "PWDBPA");
		fields[11] = fieldPWDLCA = new CharacterField(message, HEADERSIZE + 51,
				1, "PWDLCA");
		fields[12] = fieldPWDLNP = new CharacterField(message, HEADERSIZE + 52,
				1, "PWDLNP");
		fields[13] = fieldPWDCCP = new CharacterField(message, HEADERSIZE + 53,
				1, "PWDCCP");
		fields[14] = fieldPWDMAX = new DecimalField(message, HEADERSIZE + 54,
				15, 2, "PWDMAX");
		fields[15] = fieldPWDDTF = new CharacterField(message, HEADERSIZE + 69,
				1, "PWDDTF");
		fields[16] = fieldPWDLGT = new CharacterField(message, HEADERSIZE + 70,
				1, "PWDLGT");
		fields[17] = fieldPWDACL = new CharacterField(message, HEADERSIZE + 71,
				2, "PWDACL");
		fields[18] = fieldPWDCMP = new CharacterField(message, HEADERSIZE + 73,
				10, "PWDCMP");
		fields[19] = fieldPWDINC = new CharacterField(message, HEADERSIZE + 83,
				4, "PWDINC");
		fields[20] = fieldPWDBUC = new CharacterField(message, HEADERSIZE + 87,
				4, "PWDBUC");
		fields[21] = fieldPWDGEC = new CharacterField(message, HEADERSIZE + 91,
				4, "PWDGEC");
		fields[22] = fieldPWDIAD = new CharacterField(message, HEADERSIZE + 95,
				40, "PWDIAD");
		fields[23] = fieldPWDFAC = new CharacterField(message,
				HEADERSIZE + 135, 1, "PWDFAC");
		fields[24] = fieldPWDKID = new CharacterField(message,
				HEADERSIZE + 136, 10, "PWDKID");
		fields[25] = fieldPWDEST = new CharacterField(message,
				HEADERSIZE + 146, 1, "PWDEST");
		fields[26] = fieldPWDPAT = new CharacterField(message,
				HEADERSIZE + 147, 1, "PWDPAT");
		fields[27] = fieldPWDCUN = new DecimalField(message, HEADERSIZE + 148,
				10, 0, "PWDCUN");
		fields[28] = fieldPWDNME = new CharacterField(message,
				HEADERSIZE + 158, 80, "PWDNME");
		fields[29] = fieldPWDSUC = new CharacterField(message,
				HEADERSIZE + 238, 4, "PWDSUC");
		fields[30] = fieldPWDALIAS = new CharacterField(message,
				HEADERSIZE + 242, 30, "PWDALIAS");
		fields[31] = fieldPWDOFC = new CharacterField(message,
				HEADERSIZE + 272, 35, "PWDOFC");
		fields[32] = fieldPWDEML = new CharacterField(message,
				HEADERSIZE + 307, 40, "PWDEML");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field PWDUSR using a String value.
	 */
	public void setPWDUSR(String newvalue) {
		fieldPWDUSR.setString(newvalue);
	}

	/**
	 * Get value of field PWDUSR as a String.
	 */
	public String getPWDUSR() {
		return fieldPWDUSR.getString();
	}

	/**
	 * Set field PWDPWD using a String value.
	 */
	public void setPWDPWD(String newvalue) {
		fieldPWDPWD.setString(newvalue);
	}

	/**
	 * Get value of field PWDPWD as a String.
	 */
	public String getPWDPWD() {
		return fieldPWDPWD.getString();
	}

	/**
	 * Set field PWDNPW using a String value.
	 */
	public void setPWDNPW(String newvalue) {
		fieldPWDNPW.setString(newvalue);
	}

	/**
	 * Get value of field PWDNPW as a String.
	 */
	public String getPWDNPW() {
		return fieldPWDNPW.getString();
	}

	/**
	 * Set field PWDCPW using a String value.
	 */
	public void setPWDCPW(String newvalue) {
		fieldPWDCPW.setString(newvalue);
	}

	/**
	 * Get value of field PWDCPW as a String.
	 */
	public String getPWDCPW() {
		return fieldPWDCPW.getString();
	}

	/**
	 * Set field PWDGRP using a String value.
	 */
	public void setPWDGRP(String newvalue) {
		fieldPWDGRP.setString(newvalue);
	}

	/**
	 * Get value of field PWDGRP as a String.
	 */
	public String getPWDGRP() {
		return fieldPWDGRP.getString();
	}

	/**
	 * Set field PWDNCH using a String value.
	 */
	public void setPWDNCH(String newvalue) {
		fieldPWDNCH.setString(newvalue);
	}

	/**
	 * Get value of field PWDNCH as a String.
	 */
	public String getPWDNCH() {
		return fieldPWDNCH.getString();
	}

	/**
	 * Set field PWDSTS using a String value.
	 */
	public void setPWDSTS(String newvalue) {
		fieldPWDSTS.setString(newvalue);
	}

	/**
	 * Get value of field PWDSTS as a String.
	 */
	public String getPWDSTS() {
		return fieldPWDSTS.getString();
	}

	/**
	 * Set field PWDOPR using a String value.
	 */
	public void setPWDOPR(String newvalue) {
		fieldPWDOPR.setString(newvalue);
	}

	/**
	 * Get value of field PWDOPR as a String.
	 */
	public String getPWDOPR() {
		return fieldPWDOPR.getString();
	}

	/**
	 * Set field PWDCFM using a String value.
	 */
	public void setPWDCFM(String newvalue) {
		fieldPWDCFM.setString(newvalue);
	}

	/**
	 * Get value of field PWDCFM as a String.
	 */
	public String getPWDCFM() {
		return fieldPWDCFM.getString();
	}

	/**
	 * Set field PWDTRA using a String value.
	 */
	public void setPWDTRA(String newvalue) {
		fieldPWDTRA.setString(newvalue);
	}

	/**
	 * Get value of field PWDTRA as a String.
	 */
	public String getPWDTRA() {
		return fieldPWDTRA.getString();
	}

	/**
	 * Set field PWDBPA using a String value.
	 */
	public void setPWDBPA(String newvalue) {
		fieldPWDBPA.setString(newvalue);
	}

	/**
	 * Get value of field PWDBPA as a String.
	 */
	public String getPWDBPA() {
		return fieldPWDBPA.getString();
	}

	/**
	 * Set field PWDLCA using a String value.
	 */
	public void setPWDLCA(String newvalue) {
		fieldPWDLCA.setString(newvalue);
	}

	/**
	 * Get value of field PWDLCA as a String.
	 */
	public String getPWDLCA() {
		return fieldPWDLCA.getString();
	}

	/**
	 * Set field PWDLNP using a String value.
	 */
	public void setPWDLNP(String newvalue) {
		fieldPWDLNP.setString(newvalue);
	}

	/**
	 * Get value of field PWDLNP as a String.
	 */
	public String getPWDLNP() {
		return fieldPWDLNP.getString();
	}

	/**
	 * Set field PWDCCP using a String value.
	 */
	public void setPWDCCP(String newvalue) {
		fieldPWDCCP.setString(newvalue);
	}

	/**
	 * Get value of field PWDCCP as a String.
	 */
	public String getPWDCCP() {
		return fieldPWDCCP.getString();
	}

	/**
	 * Set field PWDMAX using a String value.
	 */
	public void setPWDMAX(String newvalue) {
		fieldPWDMAX.setString(newvalue);
	}

	/**
	 * Get value of field PWDMAX as a String.
	 */
	public String getPWDMAX() {
		return fieldPWDMAX.getString();
	}

	/**
	 * Set numeric field PWDMAX using a BigDecimal value.
	 */
	public void setPWDMAX(BigDecimal newvalue) {
		fieldPWDMAX.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PWDMAX as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPWDMAX() {
		return fieldPWDMAX.getBigDecimal();
	}

	/**
	 * Set field PWDDTF using a String value.
	 */
	public void setPWDDTF(String newvalue) {
		fieldPWDDTF.setString(newvalue);
	}

	/**
	 * Get value of field PWDDTF as a String.
	 */
	public String getPWDDTF() {
		return fieldPWDDTF.getString();
	}

	/**
	 * Set field PWDLGT using a String value.
	 */
	public void setPWDLGT(String newvalue) {
		fieldPWDLGT.setString(newvalue);
	}

	/**
	 * Get value of field PWDLGT as a String.
	 */
	public String getPWDLGT() {
		return fieldPWDLGT.getString();
	}

	/**
	 * Set field PWDACL using a String value.
	 */
	public void setPWDACL(String newvalue) {
		fieldPWDACL.setString(newvalue);
	}

	/**
	 * Get value of field PWDACL as a String.
	 */
	public String getPWDACL() {
		return fieldPWDACL.getString();
	}

	/**
	 * Set field PWDCMP using a String value.
	 */
	public void setPWDCMP(String newvalue) {
		fieldPWDCMP.setString(newvalue);
	}

	/**
	 * Get value of field PWDCMP as a String.
	 */
	public String getPWDCMP() {
		return fieldPWDCMP.getString();
	}

	/**
	 * Set field PWDINC using a String value.
	 */
	public void setPWDINC(String newvalue) {
		fieldPWDINC.setString(newvalue);
	}

	/**
	 * Get value of field PWDINC as a String.
	 */
	public String getPWDINC() {
		return fieldPWDINC.getString();
	}

	/**
	 * Set field PWDBUC using a String value.
	 */
	public void setPWDBUC(String newvalue) {
		fieldPWDBUC.setString(newvalue);
	}

	/**
	 * Get value of field PWDBUC as a String.
	 */
	public String getPWDBUC() {
		return fieldPWDBUC.getString();
	}

	/**
	 * Set field PWDGEC using a String value.
	 */
	public void setPWDGEC(String newvalue) {
		fieldPWDGEC.setString(newvalue);
	}

	/**
	 * Get value of field PWDGEC as a String.
	 */
	public String getPWDGEC() {
		return fieldPWDGEC.getString();
	}

	/**
	 * Set field PWDIAD using a String value.
	 */
	public void setPWDIAD(String newvalue) {
		fieldPWDIAD.setString(newvalue);
	}

	/**
	 * Get value of field PWDIAD as a String.
	 */
	public String getPWDIAD() {
		return fieldPWDIAD.getString();
	}

	/**
	 * Set field PWDFAC using a String value.
	 */
	public void setPWDFAC(String newvalue) {
		fieldPWDFAC.setString(newvalue);
	}

	/**
	 * Get value of field PWDFAC as a String.
	 */
	public String getPWDFAC() {
		return fieldPWDFAC.getString();
	}

	/**
	 * Set field PWDKID using a String value.
	 */
	public void setPWDKID(String newvalue) {
		fieldPWDKID.setString(newvalue);
	}

	/**
	 * Get value of field PWDKID as a String.
	 */
	public String getPWDKID() {
		return fieldPWDKID.getString();
	}

	/**
	 * Set field PWDEST using a String value.
	 */
	public void setPWDEST(String newvalue) {
		fieldPWDEST.setString(newvalue);
	}

	/**
	 * Get value of field PWDEST as a String.
	 */
	public String getPWDEST() {
		return fieldPWDEST.getString();
	}

	/**
	 * Set field PWDPAT using a String value.
	 */
	public void setPWDPAT(String newvalue) {
		fieldPWDPAT.setString(newvalue);
	}

	/**
	 * Get value of field PWDPAT as a String.
	 */
	public String getPWDPAT() {
		return fieldPWDPAT.getString();
	}

	/**
	 * Set field PWDCUN using a String value.
	 */
	public void setPWDCUN(String newvalue) {
		fieldPWDCUN.setString(newvalue);
	}

	/**
	 * Get value of field PWDCUN as a String.
	 */
	public String getPWDCUN() {
		return fieldPWDCUN.getString();
	}

	/**
	 * Set numeric field PWDCUN using a BigDecimal value.
	 */
	public void setPWDCUN(BigDecimal newvalue) {
		fieldPWDCUN.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field PWDCUN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalPWDCUN() {
		return fieldPWDCUN.getBigDecimal();
	}

	/**
	 * Set field PWDNME using a String value.
	 */
	public void setPWDNME(String newvalue) {
		fieldPWDNME.setString(newvalue);
	}

	/**
	 * Get value of field PWDNME as a String.
	 */
	public String getPWDNME() {
		return fieldPWDNME.getString();
	}

	/**
	 * Set field PWDSUC using a String value.
	 */
	public void setPWDSUC(String newvalue) {
		fieldPWDSUC.setString(newvalue);
	}

	/**
	 * Get value of field PWDSUC as a String.
	 */
	public String getPWDSUC() {
		return fieldPWDSUC.getString();
	}

	/**
	 * Set field PWDALIAS using a String value.
	 */
	public void setPWDALIAS(String newvalue) {
		fieldPWDALIAS.setString(newvalue);
	}

	/**
	 * Get value of field PWDALIAS as a String.
	 */
	public String getPWDALIAS() {
		return fieldPWDALIAS.getString();
	}

	/**
	 * Set field PWDOFC using a String value.
	 */
	public void setPWDOFC(String newvalue) {
		fieldPWDOFC.setString(newvalue);
	}

	/**
	 * Get value of field PWDOFC as a String.
	 */
	public String getPWDOFC() {
		return fieldPWDOFC.getString();
	}

	/**
	 * Set field PWDEML using a String value.
	 */
	public void setPWDEML(String newvalue) {
		fieldPWDEML.setString(newvalue);
	}

	/**
	 * Get value of field PWDEML as a String.
	 */
	public String getPWDEML() {
		return fieldPWDEML.getString();
	}

}