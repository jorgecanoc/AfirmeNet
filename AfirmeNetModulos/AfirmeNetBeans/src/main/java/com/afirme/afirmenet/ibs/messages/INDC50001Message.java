package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

@SuppressWarnings("rawtypes")
public class INDC50001Message extends MessageRecord {
	final static String fldnames[] = { "INTOPE", "INTUSR", "INTREF",
			"INTXPMTV", "INTFECHA", "INTHORA", "INCUENTA", "INCLIENTE",
			"INLINAUT", "INIMPORTE", "INTASA", "INMORA", "INSEGVIDA",
			"INSEGDANOS", "INPLAZO", "INCUOTA", "INFECPAGO", "INPAGPEND",
			"INCREDITO", "INSALDCAP", "INFECONT", "INFEULTPAG", "INIMULTPAG",
			"INSALDTOT", "INSALDVENC", "INCAPVENC", "ININTVENC", "INMORAVENC",
			"INIVAVENC", "INCUOTVENC", "INFOLAUD", "INCORRE" };
	final static String tnames[] = { "INTOPE", "INTUSR", "INTREF", "INTXPMTV",
			"INTFECHA", "INTHORA", "INCUENTA", "INCLIENTE", "INLINAUT",
			"INIMPORTE", "INTASA", "INMORA", "INSEGVIDA", "INSEGDANOS",
			"INPLAZO", "INCUOTA", "INFECPAGO", "INPAGPEND", "INCREDITO",
			"INSALDCAP", "INFECONT", "INFEULTPAG", "INIMULTPAG", "INSALDTOT",
			"INSALDVENC", "INCAPVENC", "ININTVENC", "INMORAVENC", "INIVAVENC",
			"INCUOTVENC", "INFOLAUD", "INCORRE" };
	final static String fid = "1131004130003";
	final static String rid = "51460C10898B5";
	final static String fmtname = "INDC50001";
	final int FIELDCOUNT = 32;

	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldINTOPE = null;
	private CharacterField fieldINTUSR = null;
	private CharacterField fieldINTREF = null;
	private CharacterField fieldINTXPMTV = null;
	private DecimalField fieldINTFECHA = null;
	private DecimalField fieldINTHORA = null;
	private DecimalField fieldINCUENTA = null;
	private DecimalField fieldINCLIENTE = null;
	private DecimalField fieldINLINAUT = null;
	private DecimalField fieldINIMPORTE = null;
	private DecimalField fieldINTASA = null;
	private DecimalField fieldINMORA = null;
	private DecimalField fieldINSEGVIDA = null;
	private DecimalField fieldINSEGDANOS = null;
	private DecimalField fieldINPLAZO = null;
	private DecimalField fieldINCUOTA = null;
	private DecimalField fieldINFECPAGO = null;
	private DecimalField fieldINPAGPEND = null;
	private DecimalField fieldINCREDITO = null;
	private DecimalField fieldINSALDCAP = null;
	private DecimalField fieldINFECONT = null;
	private DecimalField fieldINFEULTPAG = null;
	private DecimalField fieldINIMULTPAG = null;
	private DecimalField fieldINSALDTOT = null;
	private DecimalField fieldINSALDVENC = null;
	private DecimalField fieldINCAPVENC = null;
	private DecimalField fieldININTVENC = null;
	private DecimalField fieldINMORAVENC = null;
	private DecimalField fieldINIVAVENC = null;
	private DecimalField fieldINCUOTVENC = null;
	private DecimalField fieldINFOLAUD = null;
	private CharacterField fieldINCORRE = null;

	/**
	 * Constructor for INDC50001Message.
	 */
	public INDC50001Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 416;
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
		fields[6] = fieldINCUENTA = new DecimalField(message, HEADERSIZE + 41,
				13, 0, "INCUENTA");
		fields[7] = fieldINCLIENTE = new DecimalField(message, HEADERSIZE + 54,
				10, 0, "INCLIENTE");
		fields[8] = fieldINLINAUT = new DecimalField(message, HEADERSIZE + 64,
				17, 2, "INLINAUT");
		fields[9] = fieldINIMPORTE = new DecimalField(message, HEADERSIZE + 81,
				17, 2, "INIMPORTE");
		fields[10] = fieldINTASA = new DecimalField(message, HEADERSIZE + 98,
				11, 6, "INTASA");
		fields[11] = fieldINMORA = new DecimalField(message, HEADERSIZE + 109,
				11, 6, "INMORA");
		fields[12] = fieldINSEGVIDA = new DecimalField(message,
				HEADERSIZE + 120, 17, 2, "INSEGVIDA");
		fields[13] = fieldINSEGDANOS = new DecimalField(message,
				HEADERSIZE + 137, 17, 2, "INSEGDANOS");
		fields[14] = fieldINPLAZO = new DecimalField(message, HEADERSIZE + 154,
				5, 0, "INPLAZO");
		fields[15] = fieldINCUOTA = new DecimalField(message, HEADERSIZE + 159,
				17, 2, "INCUOTA");
		fields[16] = fieldINFECPAGO = new DecimalField(message,
				HEADERSIZE + 176, 9, 0, "INFECPAGO");
		fields[17] = fieldINPAGPEND = new DecimalField(message,
				HEADERSIZE + 185, 4, 0, "INPAGPEND");
		fields[18] = fieldINCREDITO = new DecimalField(message,
				HEADERSIZE + 189, 13, 0, "INCREDITO");
		fields[19] = fieldINSALDCAP = new DecimalField(message,
				HEADERSIZE + 202, 17, 2, "INSALDCAP");
		fields[20] = fieldINFECONT = new DecimalField(message,
				HEADERSIZE + 219, 9, 0, "INFECONT");
		fields[21] = fieldINFEULTPAG = new DecimalField(message,
				HEADERSIZE + 228, 9, 0, "INFEULTPAG");
		fields[22] = fieldINIMULTPAG = new DecimalField(message,
				HEADERSIZE + 237, 17, 2, "INIMULTPAG");
		fields[23] = fieldINSALDTOT = new DecimalField(message,
				HEADERSIZE + 254, 17, 2, "INSALDTOT");
		fields[24] = fieldINSALDVENC = new DecimalField(message,
				HEADERSIZE + 271, 17, 2, "INSALDVENC");
		fields[25] = fieldINCAPVENC = new DecimalField(message,
				HEADERSIZE + 288, 17, 2, "INCAPVENC");
		fields[26] = fieldININTVENC = new DecimalField(message,
				HEADERSIZE + 305, 17, 2, "ININTVENC");
		fields[27] = fieldINMORAVENC = new DecimalField(message,
				HEADERSIZE + 322, 17, 2, "INMORAVENC");
		fields[28] = fieldINIVAVENC = new DecimalField(message,
				HEADERSIZE + 339, 17, 2, "INIVAVENC");
		fields[29] = fieldINCUOTVENC = new DecimalField(message,
				HEADERSIZE + 356, 5, 0, "INCUOTVENC");
		fields[30] = fieldINFOLAUD = new DecimalField(message,
				HEADERSIZE + 361, 10, 0, "INFOLAUD");
		fields[31] = fieldINCORRE = new CharacterField(message,
				HEADERSIZE + 371, 45, "INCORRE");

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
	 * Set field INCLIENTE using a String value.
	 */
	public void setINCLIENTE(String newvalue) {
		fieldINCLIENTE.setString(newvalue);
	}

	/**
	 * Get value of field INCLIENTE as a String.
	 */
	public String getINCLIENTE() {
		return fieldINCLIENTE.getString();
	}

	/**
	 * Set numeric field INCLIENTE using a BigDecimal value.
	 */
	public void setINCLIENTE(BigDecimal newvalue) {
		fieldINCLIENTE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCLIENTE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCLIENTE() {
		return fieldINCLIENTE.getBigDecimal();
	}

	/**
	 * Set field INLINAUT using a String value.
	 */
	public void setINLINAUT(String newvalue) {
		fieldINLINAUT.setString(newvalue);
	}

	/**
	 * Get value of field INLINAUT as a String.
	 */
	public String getINLINAUT() {
		return fieldINLINAUT.getString();
	}

	/**
	 * Set numeric field INLINAUT using a BigDecimal value.
	 */
	public void setINLINAUT(BigDecimal newvalue) {
		fieldINLINAUT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INLINAUT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINLINAUT() {
		return fieldINLINAUT.getBigDecimal();
	}

	/**
	 * Set field INIMPORTE using a String value.
	 */
	public void setINIMPORTE(String newvalue) {
		fieldINIMPORTE.setString(newvalue);
	}

	/**
	 * Get value of field INIMPORTE as a String.
	 */
	public String getINIMPORTE() {
		return fieldINIMPORTE.getString();
	}

	/**
	 * Set numeric field INIMPORTE using a BigDecimal value.
	 */
	public void setINIMPORTE(BigDecimal newvalue) {
		fieldINIMPORTE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INIMPORTE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINIMPORTE() {
		return fieldINIMPORTE.getBigDecimal();
	}

	/**
	 * Set field INTASA using a String value.
	 */
	public void setINTASA(String newvalue) {
		fieldINTASA.setString(newvalue);
	}

	/**
	 * Get value of field INTASA as a String.
	 */
	public String getINTASA() {
		return fieldINTASA.getString();
	}

	/**
	 * Set numeric field INTASA using a BigDecimal value.
	 */
	public void setINTASA(BigDecimal newvalue) {
		fieldINTASA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INTASA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINTASA() {
		return fieldINTASA.getBigDecimal();
	}

	/**
	 * Set field INMORA using a String value.
	 */
	public void setINMORA(String newvalue) {
		fieldINMORA.setString(newvalue);
	}

	/**
	 * Get value of field INMORA as a String.
	 */
	public String getINMORA() {
		return fieldINMORA.getString();
	}

	/**
	 * Set numeric field INMORA using a BigDecimal value.
	 */
	public void setINMORA(BigDecimal newvalue) {
		fieldINMORA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INMORA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINMORA() {
		return fieldINMORA.getBigDecimal();
	}

	/**
	 * Set field INSEGVIDA using a String value.
	 */
	public void setINSEGVIDA(String newvalue) {
		fieldINSEGVIDA.setString(newvalue);
	}

	/**
	 * Get value of field INSEGVIDA as a String.
	 */
	public String getINSEGVIDA() {
		return fieldINSEGVIDA.getString();
	}

	/**
	 * Set numeric field INSEGVIDA using a BigDecimal value.
	 */
	public void setINSEGVIDA(BigDecimal newvalue) {
		fieldINSEGVIDA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INSEGVIDA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINSEGVIDA() {
		return fieldINSEGVIDA.getBigDecimal();
	}

	/**
	 * Set field INSEGDANOS using a String value.
	 */
	public void setINSEGDANOS(String newvalue) {
		fieldINSEGDANOS.setString(newvalue);
	}

	/**
	 * Get value of field INSEGDANOS as a String.
	 */
	public String getINSEGDANOS() {
		return fieldINSEGDANOS.getString();
	}

	/**
	 * Set numeric field INSEGDANOS using a BigDecimal value.
	 */
	public void setINSEGDANOS(BigDecimal newvalue) {
		fieldINSEGDANOS.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INSEGDANOS as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINSEGDANOS() {
		return fieldINSEGDANOS.getBigDecimal();
	}

	/**
	 * Set field INPLAZO using a String value.
	 */
	public void setINPLAZO(String newvalue) {
		fieldINPLAZO.setString(newvalue);
	}

	/**
	 * Get value of field INPLAZO as a String.
	 */
	public String getINPLAZO() {
		return fieldINPLAZO.getString();
	}

	/**
	 * Set numeric field INPLAZO using a BigDecimal value.
	 */
	public void setINPLAZO(BigDecimal newvalue) {
		fieldINPLAZO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INPLAZO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINPLAZO() {
		return fieldINPLAZO.getBigDecimal();
	}

	/**
	 * Set field INCUOTA using a String value.
	 */
	public void setINCUOTA(String newvalue) {
		fieldINCUOTA.setString(newvalue);
	}

	/**
	 * Get value of field INCUOTA as a String.
	 */
	public String getINCUOTA() {
		return fieldINCUOTA.getString();
	}

	/**
	 * Set numeric field INCUOTA using a BigDecimal value.
	 */
	public void setINCUOTA(BigDecimal newvalue) {
		fieldINCUOTA.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCUOTA as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCUOTA() {
		return fieldINCUOTA.getBigDecimal();
	}

	/**
	 * Set field INFECPAGO using a String value.
	 */
	public void setINFECPAGO(String newvalue) {
		fieldINFECPAGO.setString(newvalue);
	}

	/**
	 * Get value of field INFECPAGO as a String.
	 */
	public String getINFECPAGO() {
		return fieldINFECPAGO.getString();
	}

	/**
	 * Set numeric field INFECPAGO using a BigDecimal value.
	 */
	public void setINFECPAGO(BigDecimal newvalue) {
		fieldINFECPAGO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INFECPAGO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINFECPAGO() {
		return fieldINFECPAGO.getBigDecimal();
	}

	/**
	 * Set field INPAGPEND using a String value.
	 */
	public void setINPAGPEND(String newvalue) {
		fieldINPAGPEND.setString(newvalue);
	}

	/**
	 * Get value of field INPAGPEND as a String.
	 */
	public String getINPAGPEND() {
		return fieldINPAGPEND.getString();
	}

	/**
	 * Set numeric field INPAGPEND using a BigDecimal value.
	 */
	public void setINPAGPEND(BigDecimal newvalue) {
		fieldINPAGPEND.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INPAGPEND as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINPAGPEND() {
		return fieldINPAGPEND.getBigDecimal();
	}

	/**
	 * Set field INCREDITO using a String value.
	 */
	public void setINCREDITO(String newvalue) {
		fieldINCREDITO.setString(newvalue);
	}

	/**
	 * Get value of field INCREDITO as a String.
	 */
	public String getINCREDITO() {
		return fieldINCREDITO.getString();
	}

	/**
	 * Set numeric field INCREDITO using a BigDecimal value.
	 */
	public void setINCREDITO(BigDecimal newvalue) {
		fieldINCREDITO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCREDITO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCREDITO() {
		return fieldINCREDITO.getBigDecimal();
	}

	/**
	 * Set field INSALDCAP using a String value.
	 */
	public void setINSALDCAP(String newvalue) {
		fieldINSALDCAP.setString(newvalue);
	}

	/**
	 * Get value of field INSALDCAP as a String.
	 */
	public String getINSALDCAP() {
		return fieldINSALDCAP.getString();
	}

	/**
	 * Set numeric field INSALDCAP using a BigDecimal value.
	 */
	public void setINSALDCAP(BigDecimal newvalue) {
		fieldINSALDCAP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INSALDCAP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINSALDCAP() {
		return fieldINSALDCAP.getBigDecimal();
	}

	/**
	 * Set field INFECONT using a String value.
	 */
	public void setINFECONT(String newvalue) {
		fieldINFECONT.setString(newvalue);
	}

	/**
	 * Get value of field INFECONT as a String.
	 */
	public String getINFECONT() {
		return fieldINFECONT.getString();
	}

	/**
	 * Set numeric field INFECONT using a BigDecimal value.
	 */
	public void setINFECONT(BigDecimal newvalue) {
		fieldINFECONT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INFECONT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINFECONT() {
		return fieldINFECONT.getBigDecimal();
	}

	/**
	 * Set field INFEULTPAG using a String value.
	 */
	public void setINFEULTPAG(String newvalue) {
		fieldINFEULTPAG.setString(newvalue);
	}

	/**
	 * Get value of field INFEULTPAG as a String.
	 */
	public String getINFEULTPAG() {
		return fieldINFEULTPAG.getString();
	}

	/**
	 * Set numeric field INFEULTPAG using a BigDecimal value.
	 */
	public void setINFEULTPAG(BigDecimal newvalue) {
		fieldINFEULTPAG.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INFEULTPAG as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINFEULTPAG() {
		return fieldINFEULTPAG.getBigDecimal();
	}

	/**
	 * Set field INIMULTPAG using a String value.
	 */
	public void setINIMULTPAG(String newvalue) {
		fieldINIMULTPAG.setString(newvalue);
	}

	/**
	 * Get value of field INIMULTPAG as a String.
	 */
	public String getINIMULTPAG() {
		return fieldINIMULTPAG.getString();
	}

	/**
	 * Set numeric field INIMULTPAG using a BigDecimal value.
	 */
	public void setINIMULTPAG(BigDecimal newvalue) {
		fieldINIMULTPAG.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INIMULTPAG as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINIMULTPAG() {
		return fieldINIMULTPAG.getBigDecimal();
	}

	/**
	 * Set field INSALDTOT using a String value.
	 */
	public void setINSALDTOT(String newvalue) {
		fieldINSALDTOT.setString(newvalue);
	}

	/**
	 * Get value of field INSALDTOT as a String.
	 */
	public String getINSALDTOT() {
		return fieldINSALDTOT.getString();
	}

	/**
	 * Set numeric field INSALDTOT using a BigDecimal value.
	 */
	public void setINSALDTOT(BigDecimal newvalue) {
		fieldINSALDTOT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INSALDTOT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINSALDTOT() {
		return fieldINSALDTOT.getBigDecimal();
	}

	/**
	 * Set field INSALDVENC using a String value.
	 */
	public void setINSALDVENC(String newvalue) {
		fieldINSALDVENC.setString(newvalue);
	}

	/**
	 * Get value of field INSALDVENC as a String.
	 */
	public String getINSALDVENC() {
		return fieldINSALDVENC.getString();
	}

	/**
	 * Set numeric field INSALDVENC using a BigDecimal value.
	 */
	public void setINSALDVENC(BigDecimal newvalue) {
		fieldINSALDVENC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INSALDVENC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINSALDVENC() {
		return fieldINSALDVENC.getBigDecimal();
	}

	/**
	 * Set field INCAPVENC using a String value.
	 */
	public void setINCAPVENC(String newvalue) {
		fieldINCAPVENC.setString(newvalue);
	}

	/**
	 * Get value of field INCAPVENC as a String.
	 */
	public String getINCAPVENC() {
		return fieldINCAPVENC.getString();
	}

	/**
	 * Set numeric field INCAPVENC using a BigDecimal value.
	 */
	public void setINCAPVENC(BigDecimal newvalue) {
		fieldINCAPVENC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCAPVENC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCAPVENC() {
		return fieldINCAPVENC.getBigDecimal();
	}

	/**
	 * Set field ININTVENC using a String value.
	 */
	public void setININTVENC(String newvalue) {
		fieldININTVENC.setString(newvalue);
	}

	/**
	 * Get value of field ININTVENC as a String.
	 */
	public String getININTVENC() {
		return fieldININTVENC.getString();
	}

	/**
	 * Set numeric field ININTVENC using a BigDecimal value.
	 */
	public void setININTVENC(BigDecimal newvalue) {
		fieldININTVENC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ININTVENC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalININTVENC() {
		return fieldININTVENC.getBigDecimal();
	}

	/**
	 * Set field INMORAVENC using a String value.
	 */
	public void setINMORAVENC(String newvalue) {
		fieldINMORAVENC.setString(newvalue);
	}

	/**
	 * Get value of field INMORAVENC as a String.
	 */
	public String getINMORAVENC() {
		return fieldINMORAVENC.getString();
	}

	/**
	 * Set numeric field INMORAVENC using a BigDecimal value.
	 */
	public void setINMORAVENC(BigDecimal newvalue) {
		fieldINMORAVENC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INMORAVENC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINMORAVENC() {
		return fieldINMORAVENC.getBigDecimal();
	}

	/**
	 * Set field INIVAVENC using a String value.
	 */
	public void setINIVAVENC(String newvalue) {
		fieldINIVAVENC.setString(newvalue);
	}

	/**
	 * Get value of field INIVAVENC as a String.
	 */
	public String getINIVAVENC() {
		return fieldINIVAVENC.getString();
	}

	/**
	 * Set numeric field INIVAVENC using a BigDecimal value.
	 */
	public void setINIVAVENC(BigDecimal newvalue) {
		fieldINIVAVENC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INIVAVENC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINIVAVENC() {
		return fieldINIVAVENC.getBigDecimal();
	}

	/**
	 * Set field INCUOTVENC using a String value.
	 */
	public void setINCUOTVENC(String newvalue) {
		fieldINCUOTVENC.setString(newvalue);
	}

	/**
	 * Get value of field INCUOTVENC as a String.
	 */
	public String getINCUOTVENC() {
		return fieldINCUOTVENC.getString();
	}

	/**
	 * Set numeric field INCUOTVENC using a BigDecimal value.
	 */
	public void setINCUOTVENC(BigDecimal newvalue) {
		fieldINCUOTVENC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INCUOTVENC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINCUOTVENC() {
		return fieldINCUOTVENC.getBigDecimal();
	}

	/**
	 * Set field INFOLAUD using a String value.
	 */
	public void setINFOLAUD(String newvalue) {
		fieldINFOLAUD.setString(newvalue);
	}

	/**
	 * Get value of field INFOLAUD as a String.
	 */
	public String getINFOLAUD() {
		return fieldINFOLAUD.getString();
	}

	/**
	 * Set numeric field INFOLAUD using a BigDecimal value.
	 */
	public void setINFOLAUD(BigDecimal newvalue) {
		fieldINFOLAUD.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field INFOLAUD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalINFOLAUD() {
		return fieldINFOLAUD.getBigDecimal();
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
