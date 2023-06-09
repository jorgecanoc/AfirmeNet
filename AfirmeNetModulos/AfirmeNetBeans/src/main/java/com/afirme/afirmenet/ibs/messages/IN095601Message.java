package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from IN095601 physical file
 * definition.
 * 
 * File level identifier is 1000907131747. Record format level identifier is
 * 3E03A65794938.
 */

public class IN095601Message extends MessageRecord {
	final int FIELDCOUNT = 15;
	private CharacterField fieldIN956EUSR = null;
	private DecimalField fieldIN956VNUM = null;
	private CharacterField fieldIN956VNME = null;
	private DecimalField fieldIN956DRAC = null;
	private DecimalField fieldIN956PYMT = null;
	private CharacterField fieldIN956PCCY = null;
	private DecimalField fieldIN956DAT1 = null;
	private DecimalField fieldIN956DAT2 = null;
	private DecimalField fieldIN956DAT3 = null;
	private CharacterField fieldIN956DSV1 = null;
	private CharacterField fieldIN956DSV2 = null;
	private CharacterField fieldIN956DSV3 = null;
	private CharacterField fieldIN956DSV4 = null;
	private CharacterField fieldIN956DSV5 = null;
	private CharacterField fieldIN956DSV6 = null;

	/**
	 * Constructor for IN095601Message.
	 */
	public IN095601Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 217;
		fileid = "1000907131747";
		recordid = "3E03A65794938";
		message = new byte[getByteLength()];
		formatname = "IN095601";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "IN956EUSR";
		tagnames[0] = "IN956EUSR";
		fields[0] = fieldIN956EUSR = new CharacterField(message,
				HEADERSIZE + 0, 10, "IN956EUSR");
		fieldnames[1] = "IN956VNUM";
		tagnames[1] = "IN956VNUM";
		fields[1] = fieldIN956VNUM = new DecimalField(message, HEADERSIZE + 10,
				10, 0, "IN956VNUM");
		fieldnames[2] = "IN956VNME";
		tagnames[2] = "IN956VNME";
		fields[2] = fieldIN956VNME = new CharacterField(message,
				HEADERSIZE + 20, 35, "IN956VNME");
		fieldnames[3] = "IN956DRAC";
		tagnames[3] = "IN956DRAC";
		fields[3] = fieldIN956DRAC = new DecimalField(message, HEADERSIZE + 55,
				13, 0, "IN956DRAC");
		fieldnames[4] = "IN956PYMT";
		tagnames[4] = "IN956PYMT";
		fields[4] = fieldIN956PYMT = new DecimalField(message, HEADERSIZE + 68,
				17, 2, "IN956PYMT");
		fieldnames[5] = "IN956PCCY";
		tagnames[5] = "IN956PCCY";
		fields[5] = fieldIN956PCCY = new CharacterField(message,
				HEADERSIZE + 85, 3, "IN956PCCY");
		fieldnames[6] = "IN956DAT1";
		tagnames[6] = "IN956DAT1";
		fields[6] = fieldIN956DAT1 = new DecimalField(message, HEADERSIZE + 88,
				3, 0, "IN956DAT1");
		fieldnames[7] = "IN956DAT2";
		tagnames[7] = "IN956DAT2";
		fields[7] = fieldIN956DAT2 = new DecimalField(message, HEADERSIZE + 91,
				3, 0, "IN956DAT2");
		fieldnames[8] = "IN956DAT3";
		tagnames[8] = "IN956DAT3";
		fields[8] = fieldIN956DAT3 = new DecimalField(message, HEADERSIZE + 94,
				3, 0, "IN956DAT3");
		fieldnames[9] = "IN956DSV1";
		tagnames[9] = "IN956DSV1";
		fields[9] = fieldIN956DSV1 = new CharacterField(message,
				HEADERSIZE + 97, 20, "IN956DSV1");
		fieldnames[10] = "IN956DSV2";
		tagnames[10] = "IN956DSV2";
		fields[10] = fieldIN956DSV2 = new CharacterField(message,
				HEADERSIZE + 117, 20, "IN956DSV2");
		fieldnames[11] = "IN956DSV3";
		tagnames[11] = "IN956DSV3";
		fields[11] = fieldIN956DSV3 = new CharacterField(message,
				HEADERSIZE + 137, 20, "IN956DSV3");
		fieldnames[12] = "IN956DSV4";
		tagnames[12] = "IN956DSV4";
		fields[12] = fieldIN956DSV4 = new CharacterField(message,
				HEADERSIZE + 157, 20, "IN956DSV4");
		fieldnames[13] = "IN956DSV5";
		tagnames[13] = "IN956DSV5";
		fields[13] = fieldIN956DSV5 = new CharacterField(message,
				HEADERSIZE + 177, 20, "IN956DSV5");
		fieldnames[14] = "IN956DSV6";
		tagnames[14] = "IN956DSV6";
		fields[14] = fieldIN956DSV6 = new CharacterField(message,
				HEADERSIZE + 197, 20, "IN956DSV6");
	}

	/**
	 * Return value of numeric field IN956DAT1 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN956DAT1() {
		return fieldIN956DAT1.getBigDecimal();
	}

	/**
	 * Return value of numeric field IN956DAT2 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN956DAT2() {
		return fieldIN956DAT2.getBigDecimal();
	}

	/**
	 * Return value of numeric field IN956DAT3 as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN956DAT3() {
		return fieldIN956DAT3.getBigDecimal();
	}

	/**
	 * Return value of numeric field IN956DRAC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN956DRAC() {
		return fieldIN956DRAC.getBigDecimal();
	}

	/**
	 * Return value of numeric field IN956PYMT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN956PYMT() {
		return fieldIN956PYMT.getBigDecimal();
	}

	/**
	 * Return value of numeric field IN956VNUM as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIN956VNUM() {
		return fieldIN956VNUM.getBigDecimal();
	}

	/**
	 * Get value of field IN956DAT1 as a String.
	 */
	public String getIN956DAT1() {
		return fieldIN956DAT1.getString();
	}

	/**
	 * Get value of field IN956DAT2 as a String.
	 */
	public String getIN956DAT2() {
		return fieldIN956DAT2.getString();
	}

	/**
	 * Get value of field IN956DAT3 as a String.
	 */
	public String getIN956DAT3() {
		return fieldIN956DAT3.getString();
	}

	/**
	 * Get value of field IN956DRAC as a String.
	 */
	public String getIN956DRAC() {
		return fieldIN956DRAC.getString();
	}

	/**
	 * Get value of field IN956DSV1 as a String.
	 */
	public String getIN956DSV1() {
		return fieldIN956DSV1.getString();
	}

	/**
	 * Get value of field IN956DSV2 as a String.
	 */
	public String getIN956DSV2() {
		return fieldIN956DSV2.getString();
	}

	/**
	 * Get value of field IN956DSV3 as a String.
	 */
	public String getIN956DSV3() {
		return fieldIN956DSV3.getString();
	}

	/**
	 * Get value of field IN956DSV4 as a String.
	 */
	public String getIN956DSV4() {
		return fieldIN956DSV4.getString();
	}

	/**
	 * Get value of field IN956DSV5 as a String.
	 */
	public String getIN956DSV5() {
		return fieldIN956DSV5.getString();
	}

	/**
	 * Get value of field IN956DSV6 as a String.
	 */
	public String getIN956DSV6() {
		return fieldIN956DSV6.getString();
	}

	/**
	 * Get value of field IN956EUSR as a String.
	 */
	public String getIN956EUSR() {
		return fieldIN956EUSR.getString();
	}

	/**
	 * Get value of field IN956PCCY as a String.
	 */
	public String getIN956PCCY() {
		return fieldIN956PCCY.getString();
	}

	/**
	 * Get value of field IN956PYMT as a String.
	 */
	public String getIN956PYMT() {
		return fieldIN956PYMT.getString();
	}

	/**
	 * Get value of field IN956VNME as a String.
	 */
	public String getIN956VNME() {
		return fieldIN956VNME.getString();
	}

	/**
	 * Get value of field IN956VNUM as a String.
	 */
	public String getIN956VNUM() {
		return fieldIN956VNUM.getString();
	}

	/**
	 * Set field IN956DAT1 using a String value.
	 */
	public void setIN956DAT1(String newvalue) {
		fieldIN956DAT1.setString(newvalue);
	}

	/**
	 * Set numeric field IN956DAT1 using a BigDecimal value.
	 */
	public void setIN956DAT1(BigDecimal newvalue) {
		fieldIN956DAT1.setBigDecimal(newvalue);
	}

	/**
	 * Set field IN956DAT2 using a String value.
	 */
	public void setIN956DAT2(String newvalue) {
		fieldIN956DAT2.setString(newvalue);
	}

	/**
	 * Set numeric field IN956DAT2 using a BigDecimal value.
	 */
	public void setIN956DAT2(BigDecimal newvalue) {
		fieldIN956DAT2.setBigDecimal(newvalue);
	}

	/**
	 * Set field IN956DAT3 using a String value.
	 */
	public void setIN956DAT3(String newvalue) {
		fieldIN956DAT3.setString(newvalue);
	}

	/**
	 * Set numeric field IN956DAT3 using a BigDecimal value.
	 */
	public void setIN956DAT3(BigDecimal newvalue) {
		fieldIN956DAT3.setBigDecimal(newvalue);
	}

	/**
	 * Set field IN956DRAC using a String value.
	 */
	public void setIN956DRAC(String newvalue) {
		fieldIN956DRAC.setString(newvalue);
	}

	/**
	 * Set numeric field IN956DRAC using a BigDecimal value.
	 */
	public void setIN956DRAC(BigDecimal newvalue) {
		fieldIN956DRAC.setBigDecimal(newvalue);
	}

	/**
	 * Set field IN956DSV1 using a String value.
	 */
	public void setIN956DSV1(String newvalue) {
		fieldIN956DSV1.setString(newvalue);
	}

	/**
	 * Set field IN956DSV2 using a String value.
	 */
	public void setIN956DSV2(String newvalue) {
		fieldIN956DSV2.setString(newvalue);
	}

	/**
	 * Set field IN956DSV3 using a String value.
	 */
	public void setIN956DSV3(String newvalue) {
		fieldIN956DSV3.setString(newvalue);
	}

	/**
	 * Set field IN956DSV4 using a String value.
	 */
	public void setIN956DSV4(String newvalue) {
		fieldIN956DSV4.setString(newvalue);
	}

	/**
	 * Set field IN956DSV5 using a String value.
	 */
	public void setIN956DSV5(String newvalue) {
		fieldIN956DSV5.setString(newvalue);
	}

	/**
	 * Set field IN956DSV6 using a String value.
	 */
	public void setIN956DSV6(String newvalue) {
		fieldIN956DSV6.setString(newvalue);
	}

	/**
	 * Set field IN956EUSR using a String value.
	 */
	public void setIN956EUSR(String newvalue) {
		fieldIN956EUSR.setString(newvalue);
	}

	/**
	 * Set field IN956PCCY using a String value.
	 */
	public void setIN956PCCY(String newvalue) {
		fieldIN956PCCY.setString(newvalue);
	}

	/**
	 * Set field IN956PYMT using a String value.
	 */
	public void setIN956PYMT(String newvalue) {
		fieldIN956PYMT.setString(newvalue);
	}

	/**
	 * Set numeric field IN956PYMT using a BigDecimal value.
	 */
	public void setIN956PYMT(BigDecimal newvalue) {
		fieldIN956PYMT.setBigDecimal(newvalue);
	}

	/**
	 * Set field IN956VNME using a String value.
	 */
	public void setIN956VNME(String newvalue) {
		fieldIN956VNME.setString(newvalue);
	}

	/**
	 * Set field IN956VNUM using a String value.
	 */
	public void setIN956VNUM(String newvalue) {
		fieldIN956VNUM.setString(newvalue);
	}

	/**
	 * Set numeric field IN956VNUM using a BigDecimal value.
	 */
	public void setIN956VNUM(BigDecimal newvalue) {
		fieldIN956VNUM.setBigDecimal(newvalue);
	}
}