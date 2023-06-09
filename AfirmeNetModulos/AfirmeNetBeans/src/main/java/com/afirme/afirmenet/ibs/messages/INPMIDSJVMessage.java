package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from INPMIDSJV physical file
 * definition.
 * 
 * File level identifier is 1001004210232. Record format level identifier is
 * 4E0EFFBA023DF.
 */

public class INPMIDSJVMessage extends MessageRecord {
	final int FIELDCOUNT = 20;
	private CharacterField fieldDSJINPUSR = null;
	private DecimalField fieldDSJINPACC = null;
	private CharacterField fieldDSJINPNM1 = null;
	private DecimalField fieldDSJINPVNO = null;
	private CharacterField fieldDSJINPPMT = null;
	private DecimalField fieldDSJINPIAM = null;
	private CharacterField fieldDSJINPCCY = null;
	private DecimalField fieldDSJINPPDM = null;
	private DecimalField fieldDSJINPPDD = null;
	private DecimalField fieldDSJINPPDY = null;
	private CharacterField fieldDSJINPPFR = null;
	private DecimalField fieldDSJINPTOT = null;
	private CharacterField fieldDSJINPREF = null;
	private CharacterField fieldDSJINPRMK = null;
	private CharacterField fieldDSJINPOPT = null;
	private CharacterField fieldDSJINPFIN = null;
	private DecimalField fieldDSJINPSQN = null;
	private DecimalField fieldDSJINPRCM = null;
	private DecimalField fieldDSJINPRCD = null;
	private DecimalField fieldDSJINPRCY = null;

	/**
	 * Constructor for INPMIDSJVMessage.
	 */
	public INPMIDSJVMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 194;
		fileid = "1001004210232";
		recordid = "4E0EFFBA023DF";
		message = new byte[getByteLength()];
		formatname = "INPMIDSJV";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "DSJINPUSR";
		tagnames[0] = "DSJINPUSR";
		fields[0] = fieldDSJINPUSR = new CharacterField(message,
				HEADERSIZE + 0, 10, "DSJINPUSR");
		fieldnames[1] = "DSJINPACC";
		tagnames[1] = "DSJINPACC";
		fields[1] = fieldDSJINPACC = new DecimalField(message, HEADERSIZE + 10,
				13, 0, "DSJINPACC");
		fieldnames[2] = "DSJINPNM1";
		tagnames[2] = "DSJINPNM1";
		fields[2] = fieldDSJINPNM1 = new CharacterField(message,
				HEADERSIZE + 23, 35, "DSJINPNM1");
		fieldnames[3] = "DSJINPVNO";
		tagnames[3] = "DSJINPVNO";
		fields[3] = fieldDSJINPVNO = new DecimalField(message, HEADERSIZE + 58,
				10, 0, "DSJINPVNO");
		fieldnames[4] = "DSJINPPMT";
		tagnames[4] = "DSJINPPMT";
		fields[4] = fieldDSJINPPMT = new CharacterField(message,
				HEADERSIZE + 68, 1, "DSJINPPMT");
		fieldnames[5] = "DSJINPIAM";
		tagnames[5] = "DSJINPIAM";
		fields[5] = fieldDSJINPIAM = new DecimalField(message, HEADERSIZE + 69,
				17, 2, "DSJINPIAM");
		fieldnames[6] = "DSJINPCCY";
		tagnames[6] = "DSJINPCCY";
		fields[6] = fieldDSJINPCCY = new CharacterField(message,
				HEADERSIZE + 86, 3, "DSJINPCCY");
		fieldnames[7] = "DSJINPPDM";
		tagnames[7] = "DSJINPPDM";
		fields[7] = fieldDSJINPPDM = new DecimalField(message, HEADERSIZE + 89,
				3, 0, "DSJINPPDM");
		fieldnames[8] = "DSJINPPDD";
		tagnames[8] = "DSJINPPDD";
		fields[8] = fieldDSJINPPDD = new DecimalField(message, HEADERSIZE + 92,
				3, 0, "DSJINPPDD");
		fieldnames[9] = "DSJINPPDY";
		tagnames[9] = "DSJINPPDY";
		fields[9] = fieldDSJINPPDY = new DecimalField(message, HEADERSIZE + 95,
				3, 0, "DSJINPPDY");
		fieldnames[10] = "DSJINPPFR";
		tagnames[10] = "DSJINPPFR";
		fields[10] = fieldDSJINPPFR = new CharacterField(message,
				HEADERSIZE + 98, 1, "DSJINPPFR");
		fieldnames[11] = "DSJINPTOT";
		tagnames[11] = "DSJINPTOT";
		fields[11] = fieldDSJINPTOT = new DecimalField(message,
				HEADERSIZE + 99, 4, 0, "DSJINPTOT");
		fieldnames[12] = "DSJINPREF";
		tagnames[12] = "DSJINPREF";
		fields[12] = fieldDSJINPREF = new CharacterField(message,
				HEADERSIZE + 103, 30, "DSJINPREF");
		fieldnames[13] = "DSJINPRMK";
		tagnames[13] = "DSJINPRMK";
		fields[13] = fieldDSJINPRMK = new CharacterField(message,
				HEADERSIZE + 133, 40, "DSJINPRMK");
		fieldnames[14] = "DSJINPOPT";
		tagnames[14] = "DSJINPOPT";
		fields[14] = fieldDSJINPOPT = new CharacterField(message,
				HEADERSIZE + 173, 1, "DSJINPOPT");
		fieldnames[15] = "DSJINPFIN";
		tagnames[15] = "DSJINPFIN";
		fields[15] = fieldDSJINPFIN = new CharacterField(message,
				HEADERSIZE + 174, 1, "DSJINPFIN");
		fieldnames[16] = "DSJINPSQN";
		tagnames[16] = "DSJINPSQN";
		fields[16] = fieldDSJINPSQN = new DecimalField(message,
				HEADERSIZE + 175, 10, 0, "DSJINPSQN");
		fieldnames[17] = "DSJINPRCM";
		tagnames[17] = "DSJINPRCM";
		fields[17] = fieldDSJINPRCM = new DecimalField(message,
				HEADERSIZE + 185, 3, 0, "DSJINPRCM");
		fieldnames[18] = "DSJINPRCD";
		tagnames[18] = "DSJINPRCD";
		fields[18] = fieldDSJINPRCD = new DecimalField(message,
				HEADERSIZE + 188, 3, 0, "DSJINPRCD");
		fieldnames[19] = "DSJINPRCY";
		tagnames[19] = "DSJINPRCY";
		fields[19] = fieldDSJINPRCY = new DecimalField(message,
				HEADERSIZE + 191, 3, 0, "DSJINPRCY");
	}

	/**
	 * Return value of numeric field DSJINPACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPACC() {
		return fieldDSJINPACC.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPIAM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPIAM() {
		return fieldDSJINPIAM.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPPDD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPPDD() {
		return fieldDSJINPPDD.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPPDM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPPDM() {
		return fieldDSJINPPDM.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPPDY as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPPDY() {
		return fieldDSJINPPDY.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPRCD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPRCD() {
		return fieldDSJINPRCD.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPRCM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPRCM() {
		return fieldDSJINPRCM.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPRCY as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPRCY() {
		return fieldDSJINPRCY.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPSQN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPSQN() {
		return fieldDSJINPSQN.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPTOT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPTOT() {
		return fieldDSJINPTOT.getBigDecimal();
	}

	/**
	 * Return value of numeric field DSJINPVNO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDSJINPVNO() {
		return fieldDSJINPVNO.getBigDecimal();
	}

	/**
	 * Get value of field DSJINPACC as a String.
	 */
	public String getDSJINPACC() {
		return fieldDSJINPACC.getString();
	}

	/**
	 * Get value of field DSJINPCCY as a String.
	 */
	public String getDSJINPCCY() {
		return fieldDSJINPCCY.getString();
	}

	/**
	 * Get value of field DSJINPFIN as a String.
	 */
	public String getDSJINPFIN() {
		return fieldDSJINPFIN.getString();
	}

	/**
	 * Get value of field DSJINPIAM as a String.
	 */
	public String getDSJINPIAM() {
		return fieldDSJINPIAM.getString();
	}

	/**
	 * Get value of field DSJINPNM1 as a String.
	 */
	public String getDSJINPNM1() {
		return fieldDSJINPNM1.getString();
	}

	/**
	 * Get value of field DSJINPOPT as a String.
	 */
	public String getDSJINPOPT() {
		return fieldDSJINPOPT.getString();
	}

	/**
	 * Get value of field DSJINPPDD as a String.
	 */
	public String getDSJINPPDD() {
		return fieldDSJINPPDD.getString();
	}

	/**
	 * Get value of field DSJINPPDM as a String.
	 */
	public String getDSJINPPDM() {
		return fieldDSJINPPDM.getString();
	}

	/**
	 * Get value of field DSJINPPDY as a String.
	 */
	public String getDSJINPPDY() {
		return fieldDSJINPPDY.getString();
	}

	/**
	 * Get value of field DSJINPPFR as a String.
	 */
	public String getDSJINPPFR() {
		return fieldDSJINPPFR.getString();
	}

	/**
	 * Get value of field DSJINPPMT as a String.
	 */
	public String getDSJINPPMT() {
		return fieldDSJINPPMT.getString();
	}

	/**
	 * Get value of field DSJINPRCD as a String.
	 */
	public String getDSJINPRCD() {
		return fieldDSJINPRCD.getString();
	}

	/**
	 * Get value of field DSJINPRCM as a String.
	 */
	public String getDSJINPRCM() {
		return fieldDSJINPRCM.getString();
	}

	/**
	 * Get value of field DSJINPRCY as a String.
	 */
	public String getDSJINPRCY() {
		return fieldDSJINPRCY.getString();
	}

	/**
	 * Get value of field DSJINPREF as a String.
	 */
	public String getDSJINPREF() {
		return fieldDSJINPREF.getString();
	}

	/**
	 * Get value of field DSJINPRMK as a String.
	 */
	public String getDSJINPRMK() {
		return fieldDSJINPRMK.getString();
	}

	/**
	 * Get value of field DSJINPSQN as a String.
	 */
	public String getDSJINPSQN() {
		return fieldDSJINPSQN.getString();
	}

	/**
	 * Get value of field DSJINPTOT as a String.
	 */
	public String getDSJINPTOT() {
		return fieldDSJINPTOT.getString();
	}

	/**
	 * Get value of field DSJINPUSR as a String.
	 */
	public String getDSJINPUSR() {
		return fieldDSJINPUSR.getString();
	}

	/**
	 * Get value of field DSJINPVNO as a String.
	 */
	public String getDSJINPVNO() {
		return fieldDSJINPVNO.getString();
	}

	/**
	 * Set field DSJINPACC using a String value.
	 */
	public void setDSJINPACC(String newvalue) {
		fieldDSJINPACC.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPACC using a BigDecimal value.
	 */
	public void setDSJINPACC(BigDecimal newvalue) {
		fieldDSJINPACC.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPCCY using a String value.
	 */
	public void setDSJINPCCY(String newvalue) {
		fieldDSJINPCCY.setString(newvalue);
	}

	/**
	 * Set field DSJINPFIN using a String value.
	 */
	public void setDSJINPFIN(String newvalue) {
		fieldDSJINPFIN.setString(newvalue);
	}

	/**
	 * Set field DSJINPIAM using a String value.
	 */
	public void setDSJINPIAM(String newvalue) {
		fieldDSJINPIAM.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPIAM using a BigDecimal value.
	 */
	public void setDSJINPIAM(BigDecimal newvalue) {
		fieldDSJINPIAM.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPNM1 using a String value.
	 */
	public void setDSJINPNM1(String newvalue) {
		fieldDSJINPNM1.setString(newvalue);
	}

	/**
	 * Set field DSJINPOPT using a String value.
	 */
	public void setDSJINPOPT(String newvalue) {
		fieldDSJINPOPT.setString(newvalue);
	}

	/**
	 * Set field DSJINPPDD using a String value.
	 */
	public void setDSJINPPDD(String newvalue) {
		fieldDSJINPPDD.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPPDD using a BigDecimal value.
	 */
	public void setDSJINPPDD(BigDecimal newvalue) {
		fieldDSJINPPDD.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPPDM using a String value.
	 */
	public void setDSJINPPDM(String newvalue) {
		fieldDSJINPPDM.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPPDM using a BigDecimal value.
	 */
	public void setDSJINPPDM(BigDecimal newvalue) {
		fieldDSJINPPDM.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPPDY using a String value.
	 */
	public void setDSJINPPDY(String newvalue) {
		fieldDSJINPPDY.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPPDY using a BigDecimal value.
	 */
	public void setDSJINPPDY(BigDecimal newvalue) {
		fieldDSJINPPDY.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPPFR using a String value.
	 */
	public void setDSJINPPFR(String newvalue) {
		fieldDSJINPPFR.setString(newvalue);
	}

	/**
	 * Set field DSJINPPMT using a String value.
	 */
	public void setDSJINPPMT(String newvalue) {
		fieldDSJINPPMT.setString(newvalue);
	}

	/**
	 * Set field DSJINPRCD using a String value.
	 */
	public void setDSJINPRCD(String newvalue) {
		fieldDSJINPRCD.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPRCD using a BigDecimal value.
	 */
	public void setDSJINPRCD(BigDecimal newvalue) {
		fieldDSJINPRCD.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPRCM using a String value.
	 */
	public void setDSJINPRCM(String newvalue) {
		fieldDSJINPRCM.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPRCM using a BigDecimal value.
	 */
	public void setDSJINPRCM(BigDecimal newvalue) {
		fieldDSJINPRCM.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPRCY using a String value.
	 */
	public void setDSJINPRCY(String newvalue) {
		fieldDSJINPRCY.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPRCY using a BigDecimal value.
	 */
	public void setDSJINPRCY(BigDecimal newvalue) {
		fieldDSJINPRCY.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPREF using a String value.
	 */
	public void setDSJINPREF(String newvalue) {
		fieldDSJINPREF.setString(newvalue);
	}

	/**
	 * Set field DSJINPRMK using a String value.
	 */
	public void setDSJINPRMK(String newvalue) {
		fieldDSJINPRMK.setString(newvalue);
	}

	/**
	 * Set field DSJINPSQN using a String value.
	 */
	public void setDSJINPSQN(String newvalue) {
		fieldDSJINPSQN.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPSQN using a BigDecimal value.
	 */
	public void setDSJINPSQN(BigDecimal newvalue) {
		fieldDSJINPSQN.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPTOT using a String value.
	 */
	public void setDSJINPTOT(String newvalue) {
		fieldDSJINPTOT.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPTOT using a BigDecimal value.
	 */
	public void setDSJINPTOT(BigDecimal newvalue) {
		fieldDSJINPTOT.setBigDecimal(newvalue);
	}

	/**
	 * Set field DSJINPUSR using a String value.
	 */
	public void setDSJINPUSR(String newvalue) {
		fieldDSJINPUSR.setString(newvalue);
	}

	/**
	 * Set field DSJINPVNO using a String value.
	 */
	public void setDSJINPVNO(String newvalue) {
		fieldDSJINPVNO.setString(newvalue);
	}

	/**
	 * Set numeric field DSJINPVNO using a BigDecimal value.
	 */
	public void setDSJINPVNO(BigDecimal newvalue) {
		fieldDSJINPVNO.setBigDecimal(newvalue);
	}
}