package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

@SuppressWarnings("rawtypes")
public class MQTSYC01PFMessage extends MessageRecord {

	final static String fldnames[] = { "MQSUCO", "MQTRNM", "MQCTO", "MQUSER",
			"MQCLIE", "MQTDCC", "MQTIPT", "MQTASC", "MQTASD", "MQLIMC",
			"MQSALA", "MQSALD", "MQSALC", "MQFECC", "MQPANGI", "MQPAGM",
			"MQFELP", "MQLIMDE", "MQDIPEF", "MQDISPE", "MQPGYCR", "MQPPAPL",
			"MQNVCR", "MQPERI", "MQDIASP", "MQINTER", "MQPTOS", "MQPTOC",
			"MQPTPV", "MQFPTPV", "MQRESP", "MQDESR", "MQCXOC", "MQPPOP" };
	final static String tnames[] = { "MQSUCO", "MQTRNM", "MQCTO", "MQUSER",
			"MQCLIE", "MQTDCC", "MQTIPT", "MQTASC", "MQTASD", "MQLIMC",
			"MQSALA", "MQSALD", "MQSALC", "MQFECC", "MQPANGI", "MQPAGM",
			"MQFELP", "MQLIMDE", "MQDIPEF", "MQDISPE", "MQPGYCR", "MQPPAPL",
			"MQNVCR", "MQPERI", "MQDIASP", "MQINTER", "MQPTOS", "MQPTOC",
			"MQPTPV", "MQFPTPV", "MQRESP", "MQDESR", "MQCXOC", "MQPPOP" };
	final static String fid = "1140127085019";
	final static String rid = "4B0452E43CA8B";
	final static String fmtname = "MQTSYC01PF";
	final int FIELDCOUNT = 34;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldMQSUCO = null;
	private CharacterField fieldMQTRNM = null;
	private CharacterField fieldMQCTO = null;
	private CharacterField fieldMQUSER = null;
	private DecimalField fieldMQCLIE = null;
	private DecimalField fieldMQTDCC = null;
	private CharacterField fieldMQTIPT = null;
	private DecimalField fieldMQTASC = null;
	private DecimalField fieldMQTASD = null;
	private DecimalField fieldMQLIMC = null;
	private DecimalField fieldMQSALA = null;
	private DecimalField fieldMQSALD = null;
	private DecimalField fieldMQSALC = null;
	private DecimalField fieldMQFECC = null;
	private DecimalField fieldMQPANGI = null;
	private DecimalField fieldMQPAGM = null;
	private DecimalField fieldMQFELP = null;
	private DecimalField fieldMQLIMDE = null;
	private DecimalField fieldMQDIPEF = null;
	private DecimalField fieldMQDISPE = null;
	private DecimalField fieldMQPGYCR = null;
	private DecimalField fieldMQPPAPL = null;
	private DecimalField fieldMQNVCR = null;
	private CharacterField fieldMQPERI = null;
	private DecimalField fieldMQDIASP = null;
	private DecimalField fieldMQINTER = null;
	private DecimalField fieldMQPTOS = null;
	private DecimalField fieldMQPTOC = null;
	private DecimalField fieldMQPTPV = null;
	private DecimalField fieldMQFPTPV = null;
	private DecimalField fieldMQRESP = null;
	private CharacterField fieldMQDESR = null;
	private DecimalField fieldMQCXOC = null;
	private DecimalField fieldMQPPOP = null;

	/**
	 * Constructor for MQTSYC01PFMessage.
	 */
	public MQTSYC01PFMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 449;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldMQSUCO = new CharacterField(message, HEADERSIZE + 0,
				3, "MQSUCO");
		fields[1] = fieldMQTRNM = new CharacterField(message, HEADERSIZE + 3,
				4, "MQTRNM");
		fields[2] = fieldMQCTO = new CharacterField(message, HEADERSIZE + 7,
				10, "MQCTO");
		fields[3] = fieldMQUSER = new CharacterField(message, HEADERSIZE + 17,
				10, "MQUSER");
		fields[4] = fieldMQCLIE = new DecimalField(message, HEADERSIZE + 27,
				10, 0, "MQCLIE");
		fields[5] = fieldMQTDCC = new DecimalField(message, HEADERSIZE + 37,
				17, 0, "MQTDCC");
		fields[6] = fieldMQTIPT = new CharacterField(message, HEADERSIZE + 54,
				25, "MQTIPT");
		fields[7] = fieldMQTASC = new DecimalField(message, HEADERSIZE + 79,
				11, 6, "MQTASC");
		fields[8] = fieldMQTASD = new DecimalField(message, HEADERSIZE + 90,
				11, 6, "MQTASD");
		fields[9] = fieldMQLIMC = new DecimalField(message, HEADERSIZE + 101,
				13, 2, "MQLIMC");
		fields[10] = fieldMQSALA = new DecimalField(message, HEADERSIZE + 114,
				13, 2, "MQSALA");
		fields[11] = fieldMQSALD = new DecimalField(message, HEADERSIZE + 127,
				13, 2, "MQSALD");
		fields[12] = fieldMQSALC = new DecimalField(message, HEADERSIZE + 140,
				13, 2, "MQSALC");
		fields[13] = fieldMQFECC = new DecimalField(message, HEADERSIZE + 153,
				9, 0, "MQFECC");
		fields[14] = fieldMQPANGI = new DecimalField(message, HEADERSIZE + 162,
				13, 2, "MQPANGI");
		fields[15] = fieldMQPAGM = new DecimalField(message, HEADERSIZE + 175,
				13, 2, "MQPAGM");
		fields[16] = fieldMQFELP = new DecimalField(message, HEADERSIZE + 188,
				9, 0, "MQFELP");
		fields[17] = fieldMQLIMDE = new DecimalField(message, HEADERSIZE + 197,
				13, 2, "MQLIMDE");
		fields[18] = fieldMQDIPEF = new DecimalField(message, HEADERSIZE + 210,
				13, 2, "MQDIPEF");
		fields[19] = fieldMQDISPE = new DecimalField(message, HEADERSIZE + 223,
				13, 2, "MQDISPE");
		fields[20] = fieldMQPGYCR = new DecimalField(message, HEADERSIZE + 236,
				13, 2, "MQPGYCR");
		fields[21] = fieldMQPPAPL = new DecimalField(message, HEADERSIZE + 249,
				13, 2, "MQPPAPL");
		fields[22] = fieldMQNVCR = new DecimalField(message, HEADERSIZE + 262,
				13, 2, "MQNVCR");
		fields[23] = fieldMQPERI = new CharacterField(message,
				HEADERSIZE + 275, 30, "MQPERI");
		fields[24] = fieldMQDIASP = new DecimalField(message, HEADERSIZE + 305,
				6, 0, "MQDIASP");
		fields[25] = fieldMQINTER = new DecimalField(message, HEADERSIZE + 311,
				13, 2, "MQINTER");
		fields[26] = fieldMQPTOS = new DecimalField(message, HEADERSIZE + 324,
				13, 2, "MQPTOS");
		fields[27] = fieldMQPTOC = new DecimalField(message, HEADERSIZE + 337,
				13, 2, "MQPTOC");
		fields[28] = fieldMQPTPV = new DecimalField(message, HEADERSIZE + 350,
				13, 2, "MQPTPV");
		fields[29] = fieldMQFPTPV = new DecimalField(message, HEADERSIZE + 363,
				9, 0, "MQFPTPV");
		fields[30] = fieldMQRESP = new DecimalField(message, HEADERSIZE + 372,
				6, 0, "MQRESP");
		fields[31] = fieldMQDESR = new CharacterField(message,
				HEADERSIZE + 378, 45, "MQDESR");
		fields[32] = fieldMQCXOC = new DecimalField(message, HEADERSIZE + 423,
				13, 2, "MQCXOC");
		fields[33] = fieldMQPPOP = new DecimalField(message, HEADERSIZE + 436,
				13, 2, "MQPPOP");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field MQSUCO using a String value.
	 */
	public void setMQSUCO(String newvalue) {
		fieldMQSUCO.setString(newvalue);
	}

	/**
	 * Get value of field MQSUCO as a String.
	 */
	public String getMQSUCO() {
		return fieldMQSUCO.getString();
	}

	/**
	 * Set field MQTRNM using a String value.
	 */
	public void setMQTRNM(String newvalue) {
		fieldMQTRNM.setString(newvalue);
	}

	/**
	 * Get value of field MQTRNM as a String.
	 */
	public String getMQTRNM() {
		return fieldMQTRNM.getString();
	}

	/**
	 * Set field MQCTO using a String value.
	 */
	public void setMQCTO(String newvalue) {
		fieldMQCTO.setString(newvalue);
	}

	/**
	 * Get value of field MQCTO as a String.
	 */
	public String getMQCTO() {
		return fieldMQCTO.getString();
	}

	/**
	 * Set field MQUSER using a String value.
	 */
	public void setMQUSER(String newvalue) {
		fieldMQUSER.setString(newvalue);
	}

	/**
	 * Get value of field MQUSER as a String.
	 */
	public String getMQUSER() {
		return fieldMQUSER.getString();
	}

	/**
	 * Set field MQCLIE using a String value.
	 */
	public void setMQCLIE(String newvalue) {
		fieldMQCLIE.setString(newvalue);
	}

	/**
	 * Get value of field MQCLIE as a String.
	 */
	public String getMQCLIE() {
		return fieldMQCLIE.getString();
	}

	/**
	 * Set numeric field MQCLIE using a BigDecimal value.
	 */
	public void setMQCLIE(BigDecimal newvalue) {
		fieldMQCLIE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQCLIE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQCLIE() {
		return fieldMQCLIE.getBigDecimal();
	}

	/**
	 * Set field MQTDCC using a String value.
	 */
	public void setMQTDCC(String newvalue) {
		fieldMQTDCC.setString(newvalue);
	}

	/**
	 * Get value of field MQTDCC as a String.
	 */
	public String getMQTDCC() {
		return fieldMQTDCC.getString();
	}

	/**
	 * Set numeric field MQTDCC using a BigDecimal value.
	 */
	public void setMQTDCC(BigDecimal newvalue) {
		fieldMQTDCC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQTDCC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQTDCC() {
		return fieldMQTDCC.getBigDecimal();
	}

	/**
	 * Set field MQTIPT using a String value.
	 */
	public void setMQTIPT(String newvalue) {
		fieldMQTIPT.setString(newvalue);
	}

	/**
	 * Get value of field MQTIPT as a String.
	 */
	public String getMQTIPT() {
		return fieldMQTIPT.getString();
	}

	/**
	 * Set field MQTASC using a String value.
	 */
	public void setMQTASC(String newvalue) {
		fieldMQTASC.setString(newvalue);
	}

	/**
	 * Get value of field MQTASC as a String.
	 */
	public String getMQTASC() {
		return fieldMQTASC.getString();
	}

	/**
	 * Set numeric field MQTASC using a BigDecimal value.
	 */
	public void setMQTASC(BigDecimal newvalue) {
		fieldMQTASC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQTASC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQTASC() {
		return fieldMQTASC.getBigDecimal();
	}

	/**
	 * Set field MQTASD using a String value.
	 */
	public void setMQTASD(String newvalue) {
		fieldMQTASD.setString(newvalue);
	}

	/**
	 * Get value of field MQTASD as a String.
	 */
	public String getMQTASD() {
		return fieldMQTASD.getString();
	}

	/**
	 * Set numeric field MQTASD using a BigDecimal value.
	 */
	public void setMQTASD(BigDecimal newvalue) {
		fieldMQTASD.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQTASD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQTASD() {
		return fieldMQTASD.getBigDecimal();
	}

	/**
	 * Set field MQLIMC using a String value.
	 */
	public void setMQLIMC(String newvalue) {
		fieldMQLIMC.setString(newvalue);
	}

	/**
	 * Get value of field MQLIMC as a String.
	 */
	public String getMQLIMC() {
		return fieldMQLIMC.getString();
	}

	/**
	 * Set numeric field MQLIMC using a BigDecimal value.
	 */
	public void setMQLIMC(BigDecimal newvalue) {
		fieldMQLIMC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQLIMC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQLIMC() {
		return fieldMQLIMC.getBigDecimal();
	}

	/**
	 * Set field MQSALA using a String value.
	 */
	public void setMQSALA(String newvalue) {
		fieldMQSALA.setString(newvalue);
	}

	/**
	 * Get value of field MQSALA as a String.
	 */
	public String getMQSALA() {
		return fieldMQSALA.getString();
	}

	/**
	 * Set numeric field MQSALA using a BigDecimal value.
	 */
	public void setMQSALA(BigDecimal newvalue) {
		fieldMQSALA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQSALA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQSALA() {
		return fieldMQSALA.getBigDecimal();
	}

	/**
	 * Set field MQSALD using a String value.
	 */
	public void setMQSALD(String newvalue) {
		fieldMQSALD.setString(newvalue);
	}

	/**
	 * Get value of field MQSALD as a String.
	 */
	public String getMQSALD() {
		return fieldMQSALD.getString();
	}

	/**
	 * Set numeric field MQSALD using a BigDecimal value.
	 */
	public void setMQSALD(BigDecimal newvalue) {
		fieldMQSALD.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQSALD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQSALD() {
		return fieldMQSALD.getBigDecimal();
	}

	/**
	 * Set field MQSALC using a String value.
	 */
	public void setMQSALC(String newvalue) {
		fieldMQSALC.setString(newvalue);
	}

	/**
	 * Get value of field MQSALC as a String.
	 */
	public String getMQSALC() {
		return fieldMQSALC.getString();
	}

	/**
	 * Set numeric field MQSALC using a BigDecimal value.
	 */
	public void setMQSALC(BigDecimal newvalue) {
		fieldMQSALC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQSALC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQSALC() {
		return fieldMQSALC.getBigDecimal();
	}

	/**
	 * Set field MQFECC using a String value.
	 */
	public void setMQFECC(String newvalue) {
		fieldMQFECC.setString(newvalue);
	}

	/**
	 * Get value of field MQFECC as a String.
	 */
	public String getMQFECC() {
		return fieldMQFECC.getString();
	}

	/**
	 * Set numeric field MQFECC using a BigDecimal value.
	 */
	public void setMQFECC(BigDecimal newvalue) {
		fieldMQFECC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQFECC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQFECC() {
		return fieldMQFECC.getBigDecimal();
	}

	/**
	 * Set field MQPANGI using a String value.
	 */
	public void setMQPANGI(String newvalue) {
		fieldMQPANGI.setString(newvalue);
	}

	/**
	 * Get value of field MQPANGI as a String.
	 */
	public String getMQPANGI() {
		return fieldMQPANGI.getString();
	}

	/**
	 * Set numeric field MQPANGI using a BigDecimal value.
	 */
	public void setMQPANGI(BigDecimal newvalue) {
		fieldMQPANGI.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPANGI as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPANGI() {
		return fieldMQPANGI.getBigDecimal();
	}

	/**
	 * Set field MQPAGM using a String value.
	 */
	public void setMQPAGM(String newvalue) {
		fieldMQPAGM.setString(newvalue);
	}

	/**
	 * Get value of field MQPAGM as a String.
	 */
	public String getMQPAGM() {
		return fieldMQPAGM.getString();
	}

	/**
	 * Set numeric field MQPAGM using a BigDecimal value.
	 */
	public void setMQPAGM(BigDecimal newvalue) {
		fieldMQPAGM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPAGM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPAGM() {
		return fieldMQPAGM.getBigDecimal();
	}

	/**
	 * Set field MQFELP using a String value.
	 */
	public void setMQFELP(String newvalue) {
		fieldMQFELP.setString(newvalue);
	}

	/**
	 * Get value of field MQFELP as a String.
	 */
	public String getMQFELP() {
		return fieldMQFELP.getString();
	}

	/**
	 * Set numeric field MQFELP using a BigDecimal value.
	 */
	public void setMQFELP(BigDecimal newvalue) {
		fieldMQFELP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQFELP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQFELP() {
		return fieldMQFELP.getBigDecimal();
	}

	/**
	 * Set field MQLIMDE using a String value.
	 */
	public void setMQLIMDE(String newvalue) {
		fieldMQLIMDE.setString(newvalue);
	}

	/**
	 * Get value of field MQLIMDE as a String.
	 */
	public String getMQLIMDE() {
		return fieldMQLIMDE.getString();
	}

	/**
	 * Set numeric field MQLIMDE using a BigDecimal value.
	 */
	public void setMQLIMDE(BigDecimal newvalue) {
		fieldMQLIMDE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQLIMDE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQLIMDE() {
		return fieldMQLIMDE.getBigDecimal();
	}

	/**
	 * Set field MQDIPEF using a String value.
	 */
	public void setMQDIPEF(String newvalue) {
		fieldMQDIPEF.setString(newvalue);
	}

	/**
	 * Get value of field MQDIPEF as a String.
	 */
	public String getMQDIPEF() {
		return fieldMQDIPEF.getString();
	}

	/**
	 * Set numeric field MQDIPEF using a BigDecimal value.
	 */
	public void setMQDIPEF(BigDecimal newvalue) {
		fieldMQDIPEF.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQDIPEF as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQDIPEF() {
		return fieldMQDIPEF.getBigDecimal();
	}

	/**
	 * Set field MQDISPE using a String value.
	 */
	public void setMQDISPE(String newvalue) {
		fieldMQDISPE.setString(newvalue);
	}

	/**
	 * Get value of field MQDISPE as a String.
	 */
	public String getMQDISPE() {
		return fieldMQDISPE.getString();
	}

	/**
	 * Set numeric field MQDISPE using a BigDecimal value.
	 */
	public void setMQDISPE(BigDecimal newvalue) {
		fieldMQDISPE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQDISPE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQDISPE() {
		return fieldMQDISPE.getBigDecimal();
	}

	/**
	 * Set field MQPGYCR using a String value.
	 */
	public void setMQPGYCR(String newvalue) {
		fieldMQPGYCR.setString(newvalue);
	}

	/**
	 * Get value of field MQPGYCR as a String.
	 */
	public String getMQPGYCR() {
		return fieldMQPGYCR.getString();
	}

	/**
	 * Set numeric field MQPGYCR using a BigDecimal value.
	 */
	public void setMQPGYCR(BigDecimal newvalue) {
		fieldMQPGYCR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPGYCR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPGYCR() {
		return fieldMQPGYCR.getBigDecimal();
	}

	/**
	 * Set field MQPPAPL using a String value.
	 */
	public void setMQPPAPL(String newvalue) {
		fieldMQPPAPL.setString(newvalue);
	}

	/**
	 * Get value of field MQPPAPL as a String.
	 */
	public String getMQPPAPL() {
		return fieldMQPPAPL.getString();
	}

	/**
	 * Set numeric field MQPPAPL using a BigDecimal value.
	 */
	public void setMQPPAPL(BigDecimal newvalue) {
		fieldMQPPAPL.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPPAPL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPPAPL() {
		return fieldMQPPAPL.getBigDecimal();
	}

	/**
	 * Set field MQNVCR using a String value.
	 */
	public void setMQNVCR(String newvalue) {
		fieldMQNVCR.setString(newvalue);
	}

	/**
	 * Get value of field MQNVCR as a String.
	 */
	public String getMQNVCR() {
		return fieldMQNVCR.getString();
	}

	/**
	 * Set numeric field MQNVCR using a BigDecimal value.
	 */
	public void setMQNVCR(BigDecimal newvalue) {
		fieldMQNVCR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQNVCR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQNVCR() {
		return fieldMQNVCR.getBigDecimal();
	}

	/**
	 * Set field MQPERI using a String value.
	 */
	public void setMQPERI(String newvalue) {
		fieldMQPERI.setString(newvalue);
	}

	/**
	 * Get value of field MQPERI as a String.
	 */
	public String getMQPERI() {
		return fieldMQPERI.getString();
	}

	/**
	 * Set field MQDIASP using a String value.
	 */
	public void setMQDIASP(String newvalue) {
		fieldMQDIASP.setString(newvalue);
	}

	/**
	 * Get value of field MQDIASP as a String.
	 */
	public String getMQDIASP() {
		return fieldMQDIASP.getString();
	}

	/**
	 * Set numeric field MQDIASP using a BigDecimal value.
	 */
	public void setMQDIASP(BigDecimal newvalue) {
		fieldMQDIASP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQDIASP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQDIASP() {
		return fieldMQDIASP.getBigDecimal();
	}

	/**
	 * Set field MQINTER using a String value.
	 */
	public void setMQINTER(String newvalue) {
		fieldMQINTER.setString(newvalue);
	}

	/**
	 * Get value of field MQINTER as a String.
	 */
	public String getMQINTER() {
		return fieldMQINTER.getString();
	}

	/**
	 * Set numeric field MQINTER using a BigDecimal value.
	 */
	public void setMQINTER(BigDecimal newvalue) {
		fieldMQINTER.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQINTER as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQINTER() {
		return fieldMQINTER.getBigDecimal();
	}

	/**
	 * Set field MQPTOS using a String value.
	 */
	public void setMQPTOS(String newvalue) {
		fieldMQPTOS.setString(newvalue);
	}

	/**
	 * Get value of field MQPTOS as a String.
	 */
	public String getMQPTOS() {
		return fieldMQPTOS.getString();
	}

	/**
	 * Set numeric field MQPTOS using a BigDecimal value.
	 */
	public void setMQPTOS(BigDecimal newvalue) {
		fieldMQPTOS.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPTOS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPTOS() {
		return fieldMQPTOS.getBigDecimal();
	}

	/**
	 * Set field MQPTOC using a String value.
	 */
	public void setMQPTOC(String newvalue) {
		fieldMQPTOC.setString(newvalue);
	}

	/**
	 * Get value of field MQPTOC as a String.
	 */
	public String getMQPTOC() {
		return fieldMQPTOC.getString();
	}

	/**
	 * Set numeric field MQPTOC using a BigDecimal value.
	 */
	public void setMQPTOC(BigDecimal newvalue) {
		fieldMQPTOC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPTOC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPTOC() {
		return fieldMQPTOC.getBigDecimal();
	}

	/**
	 * Set field MQPTPV using a String value.
	 */
	public void setMQPTPV(String newvalue) {
		fieldMQPTPV.setString(newvalue);
	}

	/**
	 * Get value of field MQPTPV as a String.
	 */
	public String getMQPTPV() {
		return fieldMQPTPV.getString();
	}

	/**
	 * Set numeric field MQPTPV using a BigDecimal value.
	 */
	public void setMQPTPV(BigDecimal newvalue) {
		fieldMQPTPV.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPTPV as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPTPV() {
		return fieldMQPTPV.getBigDecimal();
	}

	/**
	 * Set field MQFPTPV using a String value.
	 */
	public void setMQFPTPV(String newvalue) {
		fieldMQFPTPV.setString(newvalue);
	}

	/**
	 * Get value of field MQFPTPV as a String.
	 */
	public String getMQFPTPV() {
		return fieldMQFPTPV.getString();
	}

	/**
	 * Set numeric field MQFPTPV using a BigDecimal value.
	 */
	public void setMQFPTPV(BigDecimal newvalue) {
		fieldMQFPTPV.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQFPTPV as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQFPTPV() {
		return fieldMQFPTPV.getBigDecimal();
	}

	/**
	 * Set field MQRESP using a String value.
	 */
	public void setMQRESP(String newvalue) {
		fieldMQRESP.setString(newvalue);
	}

	/**
	 * Get value of field MQRESP as a String.
	 */
	public String getMQRESP() {
		return fieldMQRESP.getString();
	}

	/**
	 * Set numeric field MQRESP using a BigDecimal value.
	 */
	public void setMQRESP(BigDecimal newvalue) {
		fieldMQRESP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQRESP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQRESP() {
		return fieldMQRESP.getBigDecimal();
	}

	/**
	 * Set field MQDESR using a String value.
	 */
	public void setMQDESR(String newvalue) {
		fieldMQDESR.setString(newvalue);
	}

	/**
	 * Get value of field MQDESR as a String.
	 */
	public String getMQDESR() {
		return fieldMQDESR.getString();
	}

	/**
	 * Set field MQCXOC using a String value.
	 */
	public void setMQCXOC(String newvalue) {
		fieldMQCXOC.setString(newvalue);
	}

	/**
	 * Get value of field MQCXOC as a String.
	 */
	public String getMQCXOC() {
		return fieldMQCXOC.getString();
	}

	/**
	 * Set numeric field MQCXOC using a BigDecimal value.
	 */
	public void setMQCXOC(BigDecimal newvalue) {
		fieldMQCXOC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQCXOC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQCXOC() {
		return fieldMQCXOC.getBigDecimal();
	}

	/**
	 * Set field MQPPOP using a String value.
	 */
	public void setMQPPOP(String newvalue) {
		fieldMQPPOP.setString(newvalue);
	}

	/**
	 * Get value of field MQPPOP as a String.
	 */
	public String getMQPPOP() {
		return fieldMQPPOP.getString();
	}

	/**
	 * Set numeric field MQPPOP using a BigDecimal value.
	 */
	public void setMQPPOP(BigDecimal newvalue) {
		fieldMQPPOP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field MQPPOP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalMQPPOP() {
		return fieldMQPPOP.getBigDecimal();
	}

}
