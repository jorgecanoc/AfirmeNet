package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;
@SuppressWarnings("rawtypes")
public class MQERROPFMessage extends MessageRecord {
	final static String fldnames[] = { "ERRNUM", "ERNU01", "ERNU02", "ERNU03",
			"ERNU04", "ERNU05", "ERNU06", "ERNU07", "ERNU08", "ERNU09",
			"ERNU10", "ERDS01", "ERDS02", "ERDS03", "ERDS04", "ERDS05",
			"ERDS06", "ERDS07", "ERDS08", "ERDS09", "ERDS10", "ERDF01",
			"ERDF02", "ERDF03", "ERDF04", "ERDF05", "ERDF06", "ERDF07",
			"ERDF08", "ERDF09", "ERDF10", "ERDR01", "ERDR02", "ERDR03",
			"ERDR04", "ERDR05", "ERDR06", "ERDR07", "ERDR08", "ERDR09",
			"ERDR10", "ERWRNG", "ERWF01", "ERWF02", "ERWF03", "ERWF04",
			"ERWF05", "ERWF06", "ERWF07", "ERWF08", "ERWF09", "ERWF10" };
	final static String tnames[] = { "ERRNUM", "ERNU01", "ERNU02", "ERNU03",
			"ERNU04", "ERNU05", "ERNU06", "ERNU07", "ERNU08", "ERNU09",
			"ERNU10", "ERDS01", "ERDS02", "ERDS03", "ERDS04", "ERDS05",
			"ERDS06", "ERDS07", "ERDS08", "ERDS09", "ERDS10", "ERDF01",
			"ERDF02", "ERDF03", "ERDF04", "ERDF05", "ERDF06", "ERDF07",
			"ERDF08", "ERDF09", "ERDF10", "ERDR01", "ERDR02", "ERDR03",
			"ERDR04", "ERDR05", "ERDR06", "ERDR07", "ERDR08", "ERDR09",
			"ERDR10", "ERWRNG", "ERWF01", "ERWF02", "ERWF03", "ERWF04",
			"ERWF05", "ERWF06", "ERWF07", "ERWF08", "ERWF09", "ERWF10" };
	final static String fid = "1131018135844";
	final static String rid = "2F9ED8A87DFD7";
	final static String fmtname = "MQERROPF";
	final int FIELDCOUNT = 52;
	private static Hashtable tlookup = new Hashtable();
	private DecimalField fieldERRNUM = null;
	private CharacterField fieldERNU01 = null;
	private CharacterField fieldERNU02 = null;
	private CharacterField fieldERNU03 = null;
	private CharacterField fieldERNU04 = null;
	private CharacterField fieldERNU05 = null;
	private CharacterField fieldERNU06 = null;
	private CharacterField fieldERNU07 = null;
	private CharacterField fieldERNU08 = null;
	private CharacterField fieldERNU09 = null;
	private CharacterField fieldERNU10 = null;
	private CharacterField fieldERDS01 = null;
	private CharacterField fieldERDS02 = null;
	private CharacterField fieldERDS03 = null;
	private CharacterField fieldERDS04 = null;
	private CharacterField fieldERDS05 = null;
	private CharacterField fieldERDS06 = null;
	private CharacterField fieldERDS07 = null;
	private CharacterField fieldERDS08 = null;
	private CharacterField fieldERDS09 = null;
	private CharacterField fieldERDS10 = null;
	private CharacterField fieldERDF01 = null;
	private CharacterField fieldERDF02 = null;
	private CharacterField fieldERDF03 = null;
	private CharacterField fieldERDF04 = null;
	private CharacterField fieldERDF05 = null;
	private CharacterField fieldERDF06 = null;
	private CharacterField fieldERDF07 = null;
	private CharacterField fieldERDF08 = null;
	private CharacterField fieldERDF09 = null;
	private CharacterField fieldERDF10 = null;
	private DecimalField fieldERDR01 = null;
	private DecimalField fieldERDR02 = null;
	private DecimalField fieldERDR03 = null;
	private DecimalField fieldERDR04 = null;
	private DecimalField fieldERDR05 = null;
	private DecimalField fieldERDR06 = null;
	private DecimalField fieldERDR07 = null;
	private DecimalField fieldERDR08 = null;
	private DecimalField fieldERDR09 = null;
	private DecimalField fieldERDR10 = null;
	private CharacterField fieldERWRNG = null;
	private CharacterField fieldERWF01 = null;
	private CharacterField fieldERWF02 = null;
	private CharacterField fieldERWF03 = null;
	private CharacterField fieldERWF04 = null;
	private CharacterField fieldERWF05 = null;
	private CharacterField fieldERWF06 = null;
	private CharacterField fieldERWF07 = null;
	private CharacterField fieldERWF08 = null;
	private CharacterField fieldERWF09 = null;
	private CharacterField fieldERWF10 = null;

	/**
	 * Constructor for MQERROPFMessage.
	 */
	public MQERROPFMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 904;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldERRNUM = new DecimalField(message, HEADERSIZE + 0, 3,
				0, "ERRNUM");
		fields[1] = fieldERNU01 = new CharacterField(message, HEADERSIZE + 3,
				4, "ERNU01");
		fields[2] = fieldERNU02 = new CharacterField(message, HEADERSIZE + 7,
				4, "ERNU02");
		fields[3] = fieldERNU03 = new CharacterField(message, HEADERSIZE + 11,
				4, "ERNU03");
		fields[4] = fieldERNU04 = new CharacterField(message, HEADERSIZE + 15,
				4, "ERNU04");
		fields[5] = fieldERNU05 = new CharacterField(message, HEADERSIZE + 19,
				4, "ERNU05");
		fields[6] = fieldERNU06 = new CharacterField(message, HEADERSIZE + 23,
				4, "ERNU06");
		fields[7] = fieldERNU07 = new CharacterField(message, HEADERSIZE + 27,
				4, "ERNU07");
		fields[8] = fieldERNU08 = new CharacterField(message, HEADERSIZE + 31,
				4, "ERNU08");
		fields[9] = fieldERNU09 = new CharacterField(message, HEADERSIZE + 35,
				4, "ERNU09");
		fields[10] = fieldERNU10 = new CharacterField(message, HEADERSIZE + 39,
				4, "ERNU10");
		fields[11] = fieldERDS01 = new CharacterField(message, HEADERSIZE + 43,
				70, "ERDS01");
		fields[12] = fieldERDS02 = new CharacterField(message,
				HEADERSIZE + 113, 70, "ERDS02");
		fields[13] = fieldERDS03 = new CharacterField(message,
				HEADERSIZE + 183, 70, "ERDS03");
		fields[14] = fieldERDS04 = new CharacterField(message,
				HEADERSIZE + 253, 70, "ERDS04");
		fields[15] = fieldERDS05 = new CharacterField(message,
				HEADERSIZE + 323, 70, "ERDS05");
		fields[16] = fieldERDS06 = new CharacterField(message,
				HEADERSIZE + 393, 70, "ERDS06");
		fields[17] = fieldERDS07 = new CharacterField(message,
				HEADERSIZE + 463, 70, "ERDS07");
		fields[18] = fieldERDS08 = new CharacterField(message,
				HEADERSIZE + 533, 70, "ERDS08");
		fields[19] = fieldERDS09 = new CharacterField(message,
				HEADERSIZE + 603, 70, "ERDS09");
		fields[20] = fieldERDS10 = new CharacterField(message,
				HEADERSIZE + 673, 70, "ERDS10");
		fields[21] = fieldERDF01 = new CharacterField(message,
				HEADERSIZE + 743, 10, "ERDF01");
		fields[22] = fieldERDF02 = new CharacterField(message,
				HEADERSIZE + 753, 10, "ERDF02");
		fields[23] = fieldERDF03 = new CharacterField(message,
				HEADERSIZE + 763, 10, "ERDF03");
		fields[24] = fieldERDF04 = new CharacterField(message,
				HEADERSIZE + 773, 10, "ERDF04");
		fields[25] = fieldERDF05 = new CharacterField(message,
				HEADERSIZE + 783, 10, "ERDF05");
		fields[26] = fieldERDF06 = new CharacterField(message,
				HEADERSIZE + 793, 10, "ERDF06");
		fields[27] = fieldERDF07 = new CharacterField(message,
				HEADERSIZE + 803, 10, "ERDF07");
		fields[28] = fieldERDF08 = new CharacterField(message,
				HEADERSIZE + 813, 10, "ERDF08");
		fields[29] = fieldERDF09 = new CharacterField(message,
				HEADERSIZE + 823, 10, "ERDF09");
		fields[30] = fieldERDF10 = new CharacterField(message,
				HEADERSIZE + 833, 10, "ERDF10");
		fields[31] = fieldERDR01 = new DecimalField(message, HEADERSIZE + 843,
				5, 0, "ERDR01");
		fields[32] = fieldERDR02 = new DecimalField(message, HEADERSIZE + 848,
				5, 0, "ERDR02");
		fields[33] = fieldERDR03 = new DecimalField(message, HEADERSIZE + 853,
				5, 0, "ERDR03");
		fields[34] = fieldERDR04 = new DecimalField(message, HEADERSIZE + 858,
				5, 0, "ERDR04");
		fields[35] = fieldERDR05 = new DecimalField(message, HEADERSIZE + 863,
				5, 0, "ERDR05");
		fields[36] = fieldERDR06 = new DecimalField(message, HEADERSIZE + 868,
				5, 0, "ERDR06");
		fields[37] = fieldERDR07 = new DecimalField(message, HEADERSIZE + 873,
				5, 0, "ERDR07");
		fields[38] = fieldERDR08 = new DecimalField(message, HEADERSIZE + 878,
				5, 0, "ERDR08");
		fields[39] = fieldERDR09 = new DecimalField(message, HEADERSIZE + 883,
				5, 0, "ERDR09");
		fields[40] = fieldERDR10 = new DecimalField(message, HEADERSIZE + 888,
				5, 0, "ERDR10");
		fields[41] = fieldERWRNG = new CharacterField(message,
				HEADERSIZE + 893, 1, "ERWRNG");
		fields[42] = fieldERWF01 = new CharacterField(message,
				HEADERSIZE + 894, 1, "ERWF01");
		fields[43] = fieldERWF02 = new CharacterField(message,
				HEADERSIZE + 895, 1, "ERWF02");
		fields[44] = fieldERWF03 = new CharacterField(message,
				HEADERSIZE + 896, 1, "ERWF03");
		fields[45] = fieldERWF04 = new CharacterField(message,
				HEADERSIZE + 897, 1, "ERWF04");
		fields[46] = fieldERWF05 = new CharacterField(message,
				HEADERSIZE + 898, 1, "ERWF05");
		fields[47] = fieldERWF06 = new CharacterField(message,
				HEADERSIZE + 899, 1, "ERWF06");
		fields[48] = fieldERWF07 = new CharacterField(message,
				HEADERSIZE + 900, 1, "ERWF07");
		fields[49] = fieldERWF08 = new CharacterField(message,
				HEADERSIZE + 901, 1, "ERWF08");
		fields[50] = fieldERWF09 = new CharacterField(message,
				HEADERSIZE + 902, 1, "ERWF09");
		fields[51] = fieldERWF10 = new CharacterField(message,
				HEADERSIZE + 903, 1, "ERWF10");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field ERRNUM using a String value.
	 */
	public void setERRNUM(String newvalue) {
		fieldERRNUM.setString(newvalue);
	}

	/**
	 * Get value of field ERRNUM as a String.
	 */
	public String getERRNUM() {
		return fieldERRNUM.getString();
	}

	/**
	 * Set numeric field ERRNUM using a BigDecimal value.
	 */
	public void setERRNUM(BigDecimal newvalue) {
		fieldERRNUM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERRNUM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERRNUM() {
		return fieldERRNUM.getBigDecimal();
	}

	/**
	 * Set field ERNU01 using a String value.
	 */
	public void setERNU01(String newvalue) {
		fieldERNU01.setString(newvalue);
	}

	/**
	 * Get value of field ERNU01 as a String.
	 */
	public String getERNU01() {
		return fieldERNU01.getString();
	}

	/**
	 * Set field ERNU02 using a String value.
	 */
	public void setERNU02(String newvalue) {
		fieldERNU02.setString(newvalue);
	}

	/**
	 * Get value of field ERNU02 as a String.
	 */
	public String getERNU02() {
		return fieldERNU02.getString();
	}

	/**
	 * Set field ERNU03 using a String value.
	 */
	public void setERNU03(String newvalue) {
		fieldERNU03.setString(newvalue);
	}

	/**
	 * Get value of field ERNU03 as a String.
	 */
	public String getERNU03() {
		return fieldERNU03.getString();
	}

	/**
	 * Set field ERNU04 using a String value.
	 */
	public void setERNU04(String newvalue) {
		fieldERNU04.setString(newvalue);
	}

	/**
	 * Get value of field ERNU04 as a String.
	 */
	public String getERNU04() {
		return fieldERNU04.getString();
	}

	/**
	 * Set field ERNU05 using a String value.
	 */
	public void setERNU05(String newvalue) {
		fieldERNU05.setString(newvalue);
	}

	/**
	 * Get value of field ERNU05 as a String.
	 */
	public String getERNU05() {
		return fieldERNU05.getString();
	}

	/**
	 * Set field ERNU06 using a String value.
	 */
	public void setERNU06(String newvalue) {
		fieldERNU06.setString(newvalue);
	}

	/**
	 * Get value of field ERNU06 as a String.
	 */
	public String getERNU06() {
		return fieldERNU06.getString();
	}

	/**
	 * Set field ERNU07 using a String value.
	 */
	public void setERNU07(String newvalue) {
		fieldERNU07.setString(newvalue);
	}

	/**
	 * Get value of field ERNU07 as a String.
	 */
	public String getERNU07() {
		return fieldERNU07.getString();
	}

	/**
	 * Set field ERNU08 using a String value.
	 */
	public void setERNU08(String newvalue) {
		fieldERNU08.setString(newvalue);
	}

	/**
	 * Get value of field ERNU08 as a String.
	 */
	public String getERNU08() {
		return fieldERNU08.getString();
	}

	/**
	 * Set field ERNU09 using a String value.
	 */
	public void setERNU09(String newvalue) {
		fieldERNU09.setString(newvalue);
	}

	/**
	 * Get value of field ERNU09 as a String.
	 */
	public String getERNU09() {
		return fieldERNU09.getString();
	}

	/**
	 * Set field ERNU10 using a String value.
	 */
	public void setERNU10(String newvalue) {
		fieldERNU10.setString(newvalue);
	}

	/**
	 * Get value of field ERNU10 as a String.
	 */
	public String getERNU10() {
		return fieldERNU10.getString();
	}

	/**
	 * Set field ERDS01 using a String value.
	 */
	public void setERDS01(String newvalue) {
		fieldERDS01.setString(newvalue);
	}

	/**
	 * Get value of field ERDS01 as a String.
	 */
	public String getERDS01() {
		return fieldERDS01.getString();
	}

	/**
	 * Set field ERDS02 using a String value.
	 */
	public void setERDS02(String newvalue) {
		fieldERDS02.setString(newvalue);
	}

	/**
	 * Get value of field ERDS02 as a String.
	 */
	public String getERDS02() {
		return fieldERDS02.getString();
	}

	/**
	 * Set field ERDS03 using a String value.
	 */
	public void setERDS03(String newvalue) {
		fieldERDS03.setString(newvalue);
	}

	/**
	 * Get value of field ERDS03 as a String.
	 */
	public String getERDS03() {
		return fieldERDS03.getString();
	}

	/**
	 * Set field ERDS04 using a String value.
	 */
	public void setERDS04(String newvalue) {
		fieldERDS04.setString(newvalue);
	}

	/**
	 * Get value of field ERDS04 as a String.
	 */
	public String getERDS04() {
		return fieldERDS04.getString();
	}

	/**
	 * Set field ERDS05 using a String value.
	 */
	public void setERDS05(String newvalue) {
		fieldERDS05.setString(newvalue);
	}

	/**
	 * Get value of field ERDS05 as a String.
	 */
	public String getERDS05() {
		return fieldERDS05.getString();
	}

	/**
	 * Set field ERDS06 using a String value.
	 */
	public void setERDS06(String newvalue) {
		fieldERDS06.setString(newvalue);
	}

	/**
	 * Get value of field ERDS06 as a String.
	 */
	public String getERDS06() {
		return fieldERDS06.getString();
	}

	/**
	 * Set field ERDS07 using a String value.
	 */
	public void setERDS07(String newvalue) {
		fieldERDS07.setString(newvalue);
	}

	/**
	 * Get value of field ERDS07 as a String.
	 */
	public String getERDS07() {
		return fieldERDS07.getString();
	}

	/**
	 * Set field ERDS08 using a String value.
	 */
	public void setERDS08(String newvalue) {
		fieldERDS08.setString(newvalue);
	}

	/**
	 * Get value of field ERDS08 as a String.
	 */
	public String getERDS08() {
		return fieldERDS08.getString();
	}

	/**
	 * Set field ERDS09 using a String value.
	 */
	public void setERDS09(String newvalue) {
		fieldERDS09.setString(newvalue);
	}

	/**
	 * Get value of field ERDS09 as a String.
	 */
	public String getERDS09() {
		return fieldERDS09.getString();
	}

	/**
	 * Set field ERDS10 using a String value.
	 */
	public void setERDS10(String newvalue) {
		fieldERDS10.setString(newvalue);
	}

	/**
	 * Get value of field ERDS10 as a String.
	 */
	public String getERDS10() {
		return fieldERDS10.getString();
	}

	/**
	 * Set field ERDF01 using a String value.
	 */
	public void setERDF01(String newvalue) {
		fieldERDF01.setString(newvalue);
	}

	/**
	 * Get value of field ERDF01 as a String.
	 */
	public String getERDF01() {
		return fieldERDF01.getString();
	}

	/**
	 * Set field ERDF02 using a String value.
	 */
	public void setERDF02(String newvalue) {
		fieldERDF02.setString(newvalue);
	}

	/**
	 * Get value of field ERDF02 as a String.
	 */
	public String getERDF02() {
		return fieldERDF02.getString();
	}

	/**
	 * Set field ERDF03 using a String value.
	 */
	public void setERDF03(String newvalue) {
		fieldERDF03.setString(newvalue);
	}

	/**
	 * Get value of field ERDF03 as a String.
	 */
	public String getERDF03() {
		return fieldERDF03.getString();
	}

	/**
	 * Set field ERDF04 using a String value.
	 */
	public void setERDF04(String newvalue) {
		fieldERDF04.setString(newvalue);
	}

	/**
	 * Get value of field ERDF04 as a String.
	 */
	public String getERDF04() {
		return fieldERDF04.getString();
	}

	/**
	 * Set field ERDF05 using a String value.
	 */
	public void setERDF05(String newvalue) {
		fieldERDF05.setString(newvalue);
	}

	/**
	 * Get value of field ERDF05 as a String.
	 */
	public String getERDF05() {
		return fieldERDF05.getString();
	}

	/**
	 * Set field ERDF06 using a String value.
	 */
	public void setERDF06(String newvalue) {
		fieldERDF06.setString(newvalue);
	}

	/**
	 * Get value of field ERDF06 as a String.
	 */
	public String getERDF06() {
		return fieldERDF06.getString();
	}

	/**
	 * Set field ERDF07 using a String value.
	 */
	public void setERDF07(String newvalue) {
		fieldERDF07.setString(newvalue);
	}

	/**
	 * Get value of field ERDF07 as a String.
	 */
	public String getERDF07() {
		return fieldERDF07.getString();
	}

	/**
	 * Set field ERDF08 using a String value.
	 */
	public void setERDF08(String newvalue) {
		fieldERDF08.setString(newvalue);
	}

	/**
	 * Get value of field ERDF08 as a String.
	 */
	public String getERDF08() {
		return fieldERDF08.getString();
	}

	/**
	 * Set field ERDF09 using a String value.
	 */
	public void setERDF09(String newvalue) {
		fieldERDF09.setString(newvalue);
	}

	/**
	 * Get value of field ERDF09 as a String.
	 */
	public String getERDF09() {
		return fieldERDF09.getString();
	}

	/**
	 * Set field ERDF10 using a String value.
	 */
	public void setERDF10(String newvalue) {
		fieldERDF10.setString(newvalue);
	}

	/**
	 * Get value of field ERDF10 as a String.
	 */
	public String getERDF10() {
		return fieldERDF10.getString();
	}

	/**
	 * Set field ERDR01 using a String value.
	 */
	public void setERDR01(String newvalue) {
		fieldERDR01.setString(newvalue);
	}

	/**
	 * Get value of field ERDR01 as a String.
	 */
	public String getERDR01() {
		return fieldERDR01.getString();
	}

	/**
	 * Set numeric field ERDR01 using a BigDecimal value.
	 */
	public void setERDR01(BigDecimal newvalue) {
		fieldERDR01.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR01 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR01() {
		return fieldERDR01.getBigDecimal();
	}

	/**
	 * Set field ERDR02 using a String value.
	 */
	public void setERDR02(String newvalue) {
		fieldERDR02.setString(newvalue);
	}

	/**
	 * Get value of field ERDR02 as a String.
	 */
	public String getERDR02() {
		return fieldERDR02.getString();
	}

	/**
	 * Set numeric field ERDR02 using a BigDecimal value.
	 */
	public void setERDR02(BigDecimal newvalue) {
		fieldERDR02.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR02 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR02() {
		return fieldERDR02.getBigDecimal();
	}

	/**
	 * Set field ERDR03 using a String value.
	 */
	public void setERDR03(String newvalue) {
		fieldERDR03.setString(newvalue);
	}

	/**
	 * Get value of field ERDR03 as a String.
	 */
	public String getERDR03() {
		return fieldERDR03.getString();
	}

	/**
	 * Set numeric field ERDR03 using a BigDecimal value.
	 */
	public void setERDR03(BigDecimal newvalue) {
		fieldERDR03.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR03 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR03() {
		return fieldERDR03.getBigDecimal();
	}

	/**
	 * Set field ERDR04 using a String value.
	 */
	public void setERDR04(String newvalue) {
		fieldERDR04.setString(newvalue);
	}

	/**
	 * Get value of field ERDR04 as a String.
	 */
	public String getERDR04() {
		return fieldERDR04.getString();
	}

	/**
	 * Set numeric field ERDR04 using a BigDecimal value.
	 */
	public void setERDR04(BigDecimal newvalue) {
		fieldERDR04.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR04 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR04() {
		return fieldERDR04.getBigDecimal();
	}

	/**
	 * Set field ERDR05 using a String value.
	 */
	public void setERDR05(String newvalue) {
		fieldERDR05.setString(newvalue);
	}

	/**
	 * Get value of field ERDR05 as a String.
	 */
	public String getERDR05() {
		return fieldERDR05.getString();
	}

	/**
	 * Set numeric field ERDR05 using a BigDecimal value.
	 */
	public void setERDR05(BigDecimal newvalue) {
		fieldERDR05.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR05 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR05() {
		return fieldERDR05.getBigDecimal();
	}

	/**
	 * Set field ERDR06 using a String value.
	 */
	public void setERDR06(String newvalue) {
		fieldERDR06.setString(newvalue);
	}

	/**
	 * Get value of field ERDR06 as a String.
	 */
	public String getERDR06() {
		return fieldERDR06.getString();
	}

	/**
	 * Set numeric field ERDR06 using a BigDecimal value.
	 */
	public void setERDR06(BigDecimal newvalue) {
		fieldERDR06.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR06 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR06() {
		return fieldERDR06.getBigDecimal();
	}

	/**
	 * Set field ERDR07 using a String value.
	 */
	public void setERDR07(String newvalue) {
		fieldERDR07.setString(newvalue);
	}

	/**
	 * Get value of field ERDR07 as a String.
	 */
	public String getERDR07() {
		return fieldERDR07.getString();
	}

	/**
	 * Set numeric field ERDR07 using a BigDecimal value.
	 */
	public void setERDR07(BigDecimal newvalue) {
		fieldERDR07.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR07 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR07() {
		return fieldERDR07.getBigDecimal();
	}

	/**
	 * Set field ERDR08 using a String value.
	 */
	public void setERDR08(String newvalue) {
		fieldERDR08.setString(newvalue);
	}

	/**
	 * Get value of field ERDR08 as a String.
	 */
	public String getERDR08() {
		return fieldERDR08.getString();
	}

	/**
	 * Set numeric field ERDR08 using a BigDecimal value.
	 */
	public void setERDR08(BigDecimal newvalue) {
		fieldERDR08.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR08 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR08() {
		return fieldERDR08.getBigDecimal();
	}

	/**
	 * Set field ERDR09 using a String value.
	 */
	public void setERDR09(String newvalue) {
		fieldERDR09.setString(newvalue);
	}

	/**
	 * Get value of field ERDR09 as a String.
	 */
	public String getERDR09() {
		return fieldERDR09.getString();
	}

	/**
	 * Set numeric field ERDR09 using a BigDecimal value.
	 */
	public void setERDR09(BigDecimal newvalue) {
		fieldERDR09.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR09 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR09() {
		return fieldERDR09.getBigDecimal();
	}

	/**
	 * Set field ERDR10 using a String value.
	 */
	public void setERDR10(String newvalue) {
		fieldERDR10.setString(newvalue);
	}

	/**
	 * Get value of field ERDR10 as a String.
	 */
	public String getERDR10() {
		return fieldERDR10.getString();
	}

	/**
	 * Set numeric field ERDR10 using a BigDecimal value.
	 */
	public void setERDR10(BigDecimal newvalue) {
		fieldERDR10.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field ERDR10 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalERDR10() {
		return fieldERDR10.getBigDecimal();
	}

	/**
	 * Set field ERWRNG using a String value.
	 */
	public void setERWRNG(String newvalue) {
		fieldERWRNG.setString(newvalue);
	}

	/**
	 * Get value of field ERWRNG as a String.
	 */
	public String getERWRNG() {
		return fieldERWRNG.getString();
	}

	/**
	 * Set field ERWF01 using a String value.
	 */
	public void setERWF01(String newvalue) {
		fieldERWF01.setString(newvalue);
	}

	/**
	 * Get value of field ERWF01 as a String.
	 */
	public String getERWF01() {
		return fieldERWF01.getString();
	}

	/**
	 * Set field ERWF02 using a String value.
	 */
	public void setERWF02(String newvalue) {
		fieldERWF02.setString(newvalue);
	}

	/**
	 * Get value of field ERWF02 as a String.
	 */
	public String getERWF02() {
		return fieldERWF02.getString();
	}

	/**
	 * Set field ERWF03 using a String value.
	 */
	public void setERWF03(String newvalue) {
		fieldERWF03.setString(newvalue);
	}

	/**
	 * Get value of field ERWF03 as a String.
	 */
	public String getERWF03() {
		return fieldERWF03.getString();
	}

	/**
	 * Set field ERWF04 using a String value.
	 */
	public void setERWF04(String newvalue) {
		fieldERWF04.setString(newvalue);
	}

	/**
	 * Get value of field ERWF04 as a String.
	 */
	public String getERWF04() {
		return fieldERWF04.getString();
	}

	/**
	 * Set field ERWF05 using a String value.
	 */
	public void setERWF05(String newvalue) {
		fieldERWF05.setString(newvalue);
	}

	/**
	 * Get value of field ERWF05 as a String.
	 */
	public String getERWF05() {
		return fieldERWF05.getString();
	}

	/**
	 * Set field ERWF06 using a String value.
	 */
	public void setERWF06(String newvalue) {
		fieldERWF06.setString(newvalue);
	}

	/**
	 * Get value of field ERWF06 as a String.
	 */
	public String getERWF06() {
		return fieldERWF06.getString();
	}

	/**
	 * Set field ERWF07 using a String value.
	 */
	public void setERWF07(String newvalue) {
		fieldERWF07.setString(newvalue);
	}

	/**
	 * Get value of field ERWF07 as a String.
	 */
	public String getERWF07() {
		return fieldERWF07.getString();
	}

	/**
	 * Set field ERWF08 using a String value.
	 */
	public void setERWF08(String newvalue) {
		fieldERWF08.setString(newvalue);
	}

	/**
	 * Get value of field ERWF08 as a String.
	 */
	public String getERWF08() {
		return fieldERWF08.getString();
	}

	/**
	 * Set field ERWF09 using a String value.
	 */
	public void setERWF09(String newvalue) {
		fieldERWF09.setString(newvalue);
	}

	/**
	 * Get value of field ERWF09 as a String.
	 */
	public String getERWF09() {
		return fieldERWF09.getString();
	}

	/**
	 * Set field ERWF10 using a String value.
	 */
	public void setERWF10(String newvalue) {
		fieldERWF10.setString(newvalue);
	}

	/**
	 * Get value of field ERWF10 as a String.
	 */
	public String getERWF10() {
		return fieldERWF10.getString();
	}

}
