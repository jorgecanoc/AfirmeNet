package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.*;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from IDL030001 physical file
 * definition.
 * 
 * File level identifier is 1110624124109. Record format level identifier is
 * 353E09AE36EEC.
 */
@SuppressWarnings("rawtypes")
public class IDL030001Message extends MessageRecord {
	final static String fldnames[] = { "DL31USER", "DL31DEAACC", "DL31DEAPRO",
			"DL31DEATYP", "DL31DEACCY", "DL31DEAMEP", "DL31DEAMEI",
			"DL31DEAMEM", "DL31DEADED", "DL31DEARTE", "DL31DEAMAM",
			"DL31DEAMAD", "DL31DEAMAY", "DL31DEATRM", "DL31DEATRC",
			"DL31TRAVD1", "DL31TRAVD2", "DL31TRAVD3", "DL31TRABD1",
			"DL31TRABD2", "DL31TRABD3", "DL31TRAAMT", "DL31TRADCC",
			"DL31TRANAR", "DL31TRACDE", "DL31BALANC", "DL31TRAAPC" };
	final static String tnames[] = { "DL31USER", "DL31DEAACC", "DL31DEAPRO",
			"DL31DEATYP", "DL31DEACCY", "DL31DEAMEP", "DL31DEAMEI",
			"DL31DEAMEM", "DL31DEADED", "DL31DEARTE", "DL31DEAMAM",
			"DL31DEAMAD", "DL31DEAMAY", "DL31DEATRM", "DL31DEATRC",
			"DL31TRAVD1", "DL31TRAVD2", "DL31TRAVD3", "DL31TRABD1",
			"DL31TRABD2", "DL31TRABD3", "DL31TRAAMT", "DL31TRADCC",
			"DL31TRANAR", "DL31TRACDE", "DL31BALANC", "DL31TRAAPC" };
	final static String fid = "1110624124109";
	final static String rid = "353E09AE36EEC";
	final static String fmtname = "IDL030001";
	final int FIELDCOUNT = 27;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldDL31USER = null;
	private DecimalField fieldDL31DEAACC = null;
	private CharacterField fieldDL31DEAPRO = null;
	private CharacterField fieldDL31DEATYP = null;
	private CharacterField fieldDL31DEACCY = null;
	private DecimalField fieldDL31DEAMEP = null;
	private DecimalField fieldDL31DEAMEI = null;
	private DecimalField fieldDL31DEAMEM = null;
	private DecimalField fieldDL31DEADED = null;
	private DecimalField fieldDL31DEARTE = null;
	private DecimalField fieldDL31DEAMAM = null;
	private DecimalField fieldDL31DEAMAD = null;
	private DecimalField fieldDL31DEAMAY = null;
	private DecimalField fieldDL31DEATRM = null;
	private CharacterField fieldDL31DEATRC = null;
	private DecimalField fieldDL31TRAVD1 = null;
	private DecimalField fieldDL31TRAVD2 = null;
	private DecimalField fieldDL31TRAVD3 = null;
	private DecimalField fieldDL31TRABD1 = null;
	private DecimalField fieldDL31TRABD2 = null;
	private DecimalField fieldDL31TRABD3 = null;
	private DecimalField fieldDL31TRAAMT = null;
	private CharacterField fieldDL31TRADCC = null;
	private CharacterField fieldDL31TRANAR = null;
	private CharacterField fieldDL31TRACDE = null;
	private DecimalField fieldDL31BALANC = null;
	private CharacterField fieldDL31TRAAPC = null;

	/**
	 * Constructor for IDL030001Message.
	 */
	public IDL030001Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 214;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldDL31USER = new CharacterField(message, HEADERSIZE + 0,
				10, "DL31USER");
		fields[1] = fieldDL31DEAACC = new DecimalField(message,
				HEADERSIZE + 10, 13, 0, "DL31DEAACC");
		fields[2] = fieldDL31DEAPRO = new CharacterField(message,
				HEADERSIZE + 23, 4, "DL31DEAPRO");
		fields[3] = fieldDL31DEATYP = new CharacterField(message,
				HEADERSIZE + 27, 4, "DL31DEATYP");
		fields[4] = fieldDL31DEACCY = new CharacterField(message,
				HEADERSIZE + 31, 3, "DL31DEACCY");
		fields[5] = fieldDL31DEAMEP = new DecimalField(message,
				HEADERSIZE + 34, 17, 2, "DL31DEAMEP");
		fields[6] = fieldDL31DEAMEI = new DecimalField(message,
				HEADERSIZE + 51, 17, 2, "DL31DEAMEI");
		fields[7] = fieldDL31DEAMEM = new DecimalField(message,
				HEADERSIZE + 68, 17, 2, "DL31DEAMEM");
		fields[8] = fieldDL31DEADED = new DecimalField(message,
				HEADERSIZE + 85, 17, 2, "DL31DEADED");
		fields[9] = fieldDL31DEARTE = new DecimalField(message,
				HEADERSIZE + 102, 11, 6, "DL31DEARTE");
		fields[10] = fieldDL31DEAMAM = new DecimalField(message,
				HEADERSIZE + 113, 3, 0, "DL31DEAMAM");
		fields[11] = fieldDL31DEAMAD = new DecimalField(message,
				HEADERSIZE + 116, 3, 0, "DL31DEAMAD");
		fields[12] = fieldDL31DEAMAY = new DecimalField(message,
				HEADERSIZE + 119, 3, 0, "DL31DEAMAY");
		fields[13] = fieldDL31DEATRM = new DecimalField(message,
				HEADERSIZE + 122, 5, 0, "DL31DEATRM");
		fields[14] = fieldDL31DEATRC = new CharacterField(message,
				HEADERSIZE + 127, 1, "DL31DEATRC");
		fields[15] = fieldDL31TRAVD1 = new DecimalField(message,
				HEADERSIZE + 128, 3, 0, "DL31TRAVD1");
		fields[16] = fieldDL31TRAVD2 = new DecimalField(message,
				HEADERSIZE + 131, 3, 0, "DL31TRAVD2");
		fields[17] = fieldDL31TRAVD3 = new DecimalField(message,
				HEADERSIZE + 134, 3, 0, "DL31TRAVD3");
		fields[18] = fieldDL31TRABD1 = new DecimalField(message,
				HEADERSIZE + 137, 3, 0, "DL31TRABD1");
		fields[19] = fieldDL31TRABD2 = new DecimalField(message,
				HEADERSIZE + 140, 3, 0, "DL31TRABD2");
		fields[20] = fieldDL31TRABD3 = new DecimalField(message,
				HEADERSIZE + 143, 3, 0, "DL31TRABD3");
		fields[21] = fieldDL31TRAAMT = new DecimalField(message,
				HEADERSIZE + 146, 17, 2, "DL31TRAAMT");
		fields[22] = fieldDL31TRADCC = new CharacterField(message,
				HEADERSIZE + 163, 1, "DL31TRADCC");
		fields[23] = fieldDL31TRANAR = new CharacterField(message,
				HEADERSIZE + 164, 30, "DL31TRANAR");
		fields[24] = fieldDL31TRACDE = new CharacterField(message,
				HEADERSIZE + 194, 2, "DL31TRACDE");
		fields[25] = fieldDL31BALANC = new DecimalField(message,
				HEADERSIZE + 196, 17, 2, "DL31BALANC");
		fields[26] = fieldDL31TRAAPC = new CharacterField(message,
				HEADERSIZE + 213, 1, "DL31TRAAPC");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field DL31USER using a String value.
	 */
	public void setDL31USER(String newvalue) {
		fieldDL31USER.setString(newvalue);
	}

	/**
	 * Get value of field DL31USER as a String.
	 */
	public String getDL31USER() {
		return fieldDL31USER.getString();
	}

	/**
	 * Set field DL31DEAACC using a String value.
	 */
	public void setDL31DEAACC(String newvalue) {
		fieldDL31DEAACC.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAACC as a String.
	 */
	public String getDL31DEAACC() {
		return fieldDL31DEAACC.getString();
	}

	/**
	 * Set numeric field DL31DEAACC using a BigDecimal value.
	 */
	public void setDL31DEAACC(BigDecimal newvalue) {
		fieldDL31DEAACC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEAACC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEAACC() {
		return fieldDL31DEAACC.getBigDecimal();
	}

	/**
	 * Set field DL31DEAPRO using a String value.
	 */
	public void setDL31DEAPRO(String newvalue) {
		fieldDL31DEAPRO.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAPRO as a String.
	 */
	public String getDL31DEAPRO() {
		return fieldDL31DEAPRO.getString();
	}

	/**
	 * Set field DL31DEATYP using a String value.
	 */
	public void setDL31DEATYP(String newvalue) {
		fieldDL31DEATYP.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEATYP as a String.
	 */
	public String getDL31DEATYP() {
		return fieldDL31DEATYP.getString();
	}

	/**
	 * Set field DL31DEACCY using a String value.
	 */
	public void setDL31DEACCY(String newvalue) {
		fieldDL31DEACCY.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEACCY as a String.
	 */
	public String getDL31DEACCY() {
		return fieldDL31DEACCY.getString();
	}

	/**
	 * Set field DL31DEAMEP using a String value.
	 */
	public void setDL31DEAMEP(String newvalue) {
		fieldDL31DEAMEP.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAMEP as a String.
	 */
	public String getDL31DEAMEP() {
		return fieldDL31DEAMEP.getString();
	}

	/**
	 * Set numeric field DL31DEAMEP using a BigDecimal value.
	 */
	public void setDL31DEAMEP(BigDecimal newvalue) {
		fieldDL31DEAMEP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEAMEP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEAMEP() {
		return fieldDL31DEAMEP.getBigDecimal();
	}

	/**
	 * Set field DL31DEAMEI using a String value.
	 */
	public void setDL31DEAMEI(String newvalue) {
		fieldDL31DEAMEI.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAMEI as a String.
	 */
	public String getDL31DEAMEI() {
		return fieldDL31DEAMEI.getString();
	}

	/**
	 * Set numeric field DL31DEAMEI using a BigDecimal value.
	 */
	public void setDL31DEAMEI(BigDecimal newvalue) {
		fieldDL31DEAMEI.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEAMEI as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEAMEI() {
		return fieldDL31DEAMEI.getBigDecimal();
	}

	/**
	 * Set field DL31DEAMEM using a String value.
	 */
	public void setDL31DEAMEM(String newvalue) {
		fieldDL31DEAMEM.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAMEM as a String.
	 */
	public String getDL31DEAMEM() {
		return fieldDL31DEAMEM.getString();
	}

	/**
	 * Set numeric field DL31DEAMEM using a BigDecimal value.
	 */
	public void setDL31DEAMEM(BigDecimal newvalue) {
		fieldDL31DEAMEM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEAMEM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEAMEM() {
		return fieldDL31DEAMEM.getBigDecimal();
	}

	/**
	 * Set field DL31DEADED using a String value.
	 */
	public void setDL31DEADED(String newvalue) {
		fieldDL31DEADED.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEADED as a String.
	 */
	public String getDL31DEADED() {
		return fieldDL31DEADED.getString();
	}

	/**
	 * Set numeric field DL31DEADED using a BigDecimal value.
	 */
	public void setDL31DEADED(BigDecimal newvalue) {
		fieldDL31DEADED.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEADED as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEADED() {
		return fieldDL31DEADED.getBigDecimal();
	}

	/**
	 * Set field DL31DEARTE using a String value.
	 */
	public void setDL31DEARTE(String newvalue) {
		fieldDL31DEARTE.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEARTE as a String.
	 */
	public String getDL31DEARTE() {
		return fieldDL31DEARTE.getString();
	}

	/**
	 * Set numeric field DL31DEARTE using a BigDecimal value.
	 */
	public void setDL31DEARTE(BigDecimal newvalue) {
		fieldDL31DEARTE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEARTE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEARTE() {
		return fieldDL31DEARTE.getBigDecimal();
	}

	/**
	 * Set field DL31DEAMAM using a String value.
	 */
	public void setDL31DEAMAM(String newvalue) {
		fieldDL31DEAMAM.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAMAM as a String.
	 */
	public String getDL31DEAMAM() {
		return fieldDL31DEAMAM.getString();
	}

	/**
	 * Set numeric field DL31DEAMAM using a BigDecimal value.
	 */
	public void setDL31DEAMAM(BigDecimal newvalue) {
		fieldDL31DEAMAM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEAMAM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEAMAM() {
		return fieldDL31DEAMAM.getBigDecimal();
	}

	/**
	 * Set field DL31DEAMAD using a String value.
	 */
	public void setDL31DEAMAD(String newvalue) {
		fieldDL31DEAMAD.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAMAD as a String.
	 */
	public String getDL31DEAMAD() {
		return fieldDL31DEAMAD.getString();
	}

	/**
	 * Set numeric field DL31DEAMAD using a BigDecimal value.
	 */
	public void setDL31DEAMAD(BigDecimal newvalue) {
		fieldDL31DEAMAD.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEAMAD as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEAMAD() {
		return fieldDL31DEAMAD.getBigDecimal();
	}

	/**
	 * Set field DL31DEAMAY using a String value.
	 */
	public void setDL31DEAMAY(String newvalue) {
		fieldDL31DEAMAY.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEAMAY as a String.
	 */
	public String getDL31DEAMAY() {
		return fieldDL31DEAMAY.getString();
	}

	/**
	 * Set numeric field DL31DEAMAY using a BigDecimal value.
	 */
	public void setDL31DEAMAY(BigDecimal newvalue) {
		fieldDL31DEAMAY.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEAMAY as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEAMAY() {
		return fieldDL31DEAMAY.getBigDecimal();
	}

	/**
	 * Set field DL31DEATRM using a String value.
	 */
	public void setDL31DEATRM(String newvalue) {
		fieldDL31DEATRM.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEATRM as a String.
	 */
	public String getDL31DEATRM() {
		return fieldDL31DEATRM.getString();
	}

	/**
	 * Set numeric field DL31DEATRM using a BigDecimal value.
	 */
	public void setDL31DEATRM(BigDecimal newvalue) {
		fieldDL31DEATRM.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31DEATRM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31DEATRM() {
		return fieldDL31DEATRM.getBigDecimal();
	}

	/**
	 * Set field DL31DEATRC using a String value.
	 */
	public void setDL31DEATRC(String newvalue) {
		fieldDL31DEATRC.setString(newvalue);
	}

	/**
	 * Get value of field DL31DEATRC as a String.
	 */
	public String getDL31DEATRC() {
		return fieldDL31DEATRC.getString();
	}

	/**
	 * Set field DL31TRAVD1 using a String value.
	 */
	public void setDL31TRAVD1(String newvalue) {
		fieldDL31TRAVD1.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRAVD1 as a String.
	 */
	public String getDL31TRAVD1() {
		return fieldDL31TRAVD1.getString();
	}

	/**
	 * Set numeric field DL31TRAVD1 using a BigDecimal value.
	 */
	public void setDL31TRAVD1(BigDecimal newvalue) {
		fieldDL31TRAVD1.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31TRAVD1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31TRAVD1() {
		return fieldDL31TRAVD1.getBigDecimal();
	}

	/**
	 * Set field DL31TRAVD2 using a String value.
	 */
	public void setDL31TRAVD2(String newvalue) {
		fieldDL31TRAVD2.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRAVD2 as a String.
	 */
	public String getDL31TRAVD2() {
		return fieldDL31TRAVD2.getString();
	}

	/**
	 * Set numeric field DL31TRAVD2 using a BigDecimal value.
	 */
	public void setDL31TRAVD2(BigDecimal newvalue) {
		fieldDL31TRAVD2.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31TRAVD2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31TRAVD2() {
		return fieldDL31TRAVD2.getBigDecimal();
	}

	/**
	 * Set field DL31TRAVD3 using a String value.
	 */
	public void setDL31TRAVD3(String newvalue) {
		fieldDL31TRAVD3.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRAVD3 as a String.
	 */
	public String getDL31TRAVD3() {
		return fieldDL31TRAVD3.getString();
	}

	/**
	 * Set numeric field DL31TRAVD3 using a BigDecimal value.
	 */
	public void setDL31TRAVD3(BigDecimal newvalue) {
		fieldDL31TRAVD3.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31TRAVD3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31TRAVD3() {
		return fieldDL31TRAVD3.getBigDecimal();
	}

	/**
	 * Set field DL31TRABD1 using a String value.
	 */
	public void setDL31TRABD1(String newvalue) {
		fieldDL31TRABD1.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRABD1 as a String.
	 */
	public String getDL31TRABD1() {
		return fieldDL31TRABD1.getString();
	}

	/**
	 * Set numeric field DL31TRABD1 using a BigDecimal value.
	 */
	public void setDL31TRABD1(BigDecimal newvalue) {
		fieldDL31TRABD1.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31TRABD1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31TRABD1() {
		return fieldDL31TRABD1.getBigDecimal();
	}

	/**
	 * Set field DL31TRABD2 using a String value.
	 */
	public void setDL31TRABD2(String newvalue) {
		fieldDL31TRABD2.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRABD2 as a String.
	 */
	public String getDL31TRABD2() {
		return fieldDL31TRABD2.getString();
	}

	/**
	 * Set numeric field DL31TRABD2 using a BigDecimal value.
	 */
	public void setDL31TRABD2(BigDecimal newvalue) {
		fieldDL31TRABD2.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31TRABD2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31TRABD2() {
		return fieldDL31TRABD2.getBigDecimal();
	}

	/**
	 * Set field DL31TRABD3 using a String value.
	 */
	public void setDL31TRABD3(String newvalue) {
		fieldDL31TRABD3.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRABD3 as a String.
	 */
	public String getDL31TRABD3() {
		return fieldDL31TRABD3.getString();
	}

	/**
	 * Set numeric field DL31TRABD3 using a BigDecimal value.
	 */
	public void setDL31TRABD3(BigDecimal newvalue) {
		fieldDL31TRABD3.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31TRABD3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31TRABD3() {
		return fieldDL31TRABD3.getBigDecimal();
	}

	/**
	 * Set field DL31TRAAMT using a String value.
	 */
	public void setDL31TRAAMT(String newvalue) {
		fieldDL31TRAAMT.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRAAMT as a String.
	 */
	public String getDL31TRAAMT() {
		return fieldDL31TRAAMT.getString();
	}

	/**
	 * Set numeric field DL31TRAAMT using a BigDecimal value.
	 */
	public void setDL31TRAAMT(BigDecimal newvalue) {
		fieldDL31TRAAMT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31TRAAMT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31TRAAMT() {
		return fieldDL31TRAAMT.getBigDecimal();
	}

	/**
	 * Set field DL31TRADCC using a String value.
	 */
	public void setDL31TRADCC(String newvalue) {
		fieldDL31TRADCC.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRADCC as a String.
	 */
	public String getDL31TRADCC() {
		return fieldDL31TRADCC.getString();
	}

	/**
	 * Set field DL31TRANAR using a String value.
	 */
	public void setDL31TRANAR(String newvalue) {
		fieldDL31TRANAR.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRANAR as a String.
	 */
	public String getDL31TRANAR() {
		return fieldDL31TRANAR.getString();
	}

	/**
	 * Set field DL31TRACDE using a String value.
	 */
	public void setDL31TRACDE(String newvalue) {
		fieldDL31TRACDE.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRACDE as a String.
	 */
	public String getDL31TRACDE() {
		return fieldDL31TRACDE.getString();
	}

	/**
	 * Set field DL31BALANC using a String value.
	 */
	public void setDL31BALANC(String newvalue) {
		fieldDL31BALANC.setString(newvalue);
	}

	/**
	 * Get value of field DL31BALANC as a String.
	 */
	public String getDL31BALANC() {
		return fieldDL31BALANC.getString();
	}

	/**
	 * Set numeric field DL31BALANC using a BigDecimal value.
	 */
	public void setDL31BALANC(BigDecimal newvalue) {
		fieldDL31BALANC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field DL31BALANC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalDL31BALANC() {
		return fieldDL31BALANC.getBigDecimal();
	}

	/**
	 * Set field DL31TRAAPC using a String value.
	 */
	public void setDL31TRAAPC(String newvalue) {
		fieldDL31TRAAPC.setString(newvalue);
	}

	/**
	 * Get value of field DL31TRAAPC as a String.
	 */
	public String getDL31TRAAPC() {
		return fieldDL31TRAAPC.getString();
	}

}
