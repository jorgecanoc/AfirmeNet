package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from IIV031101 physical file
 * definition.
 * 
 * File level identifier is 1010119191539. Record format level identifier is
 * 3314E263FFFE1.
 */

public class IIV031101Message extends MessageRecord {
	final int FIELDCOUNT = 10;
	private CharacterField fieldIV31USER = null;
	private DecimalField fieldIV31IVSCUN = null;
	private CharacterField fieldIV31TYPE = null;
	private CharacterField fieldIV31ISIN = null;
	private DecimalField fieldIV31AVPUP = null;
	private DecimalField fieldIV31QTY = null;
	private DecimalField fieldIV31MKPRI = null;
	private DecimalField fieldIV31PANDL = null;
	private DecimalField fieldIV31PURPR = null;
	private DecimalField fieldIV31FVALUE = null;

	/**
	 * Constructor for IIV031101Message.
	 */
	public IIV031101Message() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	protected void createFields() {
		recordsize = 124;
		fileid = "1010119191539";
		recordid = "3314E263FFFE1";
		message = new byte[getByteLength()];
		formatname = "IIV031101";
		fieldnames = new String[FIELDCOUNT];
		tagnames = new String[FIELDCOUNT];
		fields = new MessageField[FIELDCOUNT];

		fieldnames[0] = "IV31USER";
		tagnames[0] = "IV31USER";
		fields[0] = fieldIV31USER = new CharacterField(message, HEADERSIZE + 0,
				10, "IV31USER");
		fieldnames[1] = "IV31IVSCUN";
		tagnames[1] = "IV31IVSCUN";
		fields[1] = fieldIV31IVSCUN = new DecimalField(message,
				HEADERSIZE + 10, 10, 0, "IV31IVSCUN");
		fieldnames[2] = "IV31TYPE";
		tagnames[2] = "IV31TYPE";
		fields[2] = fieldIV31TYPE = new CharacterField(message,
				HEADERSIZE + 20, 1, "IV31TYPE");
		fieldnames[3] = "IV31ISIN";
		tagnames[3] = "IV31ISIN";
		fields[3] = fieldIV31ISIN = new CharacterField(message,
				HEADERSIZE + 21, 12, "IV31ISIN");
		fieldnames[4] = "IV31AVPUP";
		tagnames[4] = "IV31AVPUP";
		fields[4] = fieldIV31AVPUP = new DecimalField(message, HEADERSIZE + 33,
				17, 2, "IV31AVPUP");
		fieldnames[5] = "IV31QTY";
		tagnames[5] = "IV31QTY";
		fields[5] = fieldIV31QTY = new DecimalField(message, HEADERSIZE + 50,
				6, 0, "IV31QTY");
		fieldnames[6] = "IV31MKPRI";
		tagnames[6] = "IV31MKPRI";
		fields[6] = fieldIV31MKPRI = new DecimalField(message, HEADERSIZE + 56,
				17, 2, "IV31MKPRI");
		fieldnames[7] = "IV31PANDL";
		tagnames[7] = "IV31PANDL";
		fields[7] = fieldIV31PANDL = new DecimalField(message, HEADERSIZE + 73,
				17, 2, "IV31PANDL");
		fieldnames[8] = "IV31PURPR";
		tagnames[8] = "IV31PURPR";
		fields[8] = fieldIV31PURPR = new DecimalField(message, HEADERSIZE + 90,
				17, 2, "IV31PURPR");
		fieldnames[9] = "IV31FVALUE";
		tagnames[9] = "IV31FVALUE";
		fields[9] = fieldIV31FVALUE = new DecimalField(message,
				HEADERSIZE + 107, 17, 2, "IV31FVALUE");
	}

	/**
	 * Return value of numeric field IV31AVPUP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIV31AVPUP() {
		return fieldIV31AVPUP.getBigDecimal();
	}

	/**
	 * Return value of numeric field IV31FVALUE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIV31FVALUE() {
		return fieldIV31FVALUE.getBigDecimal();
	}

	/**
	 * Return value of numeric field IV31IVSCUN as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIV31IVSCUN() {
		return fieldIV31IVSCUN.getBigDecimal();
	}

	/**
	 * Return value of numeric field IV31MKPRI as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIV31MKPRI() {
		return fieldIV31MKPRI.getBigDecimal();
	}

	/**
	 * Return value of numeric field IV31PANDL as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIV31PANDL() {
		return fieldIV31PANDL.getBigDecimal();
	}

	/**
	 * Return value of numeric field IV31PURPR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIV31PURPR() {
		return fieldIV31PURPR.getBigDecimal();
	}

	/**
	 * Return value of numeric field IV31QTY as a BigDecimal.
	 */
	public BigDecimal getBigDecimalIV31QTY() {
		return fieldIV31QTY.getBigDecimal();
	}

	/**
	 * Get value of field IV31AVPUP as a String.
	 */
	public String getIV31AVPUP() {
		return fieldIV31AVPUP.getString();
	}

	/**
	 * Get value of field IV31FVALUE as a String.
	 */
	public String getIV31FVALUE() {
		return fieldIV31FVALUE.getString();
	}

	/**
	 * Get value of field IV31ISIN as a String.
	 */
	public String getIV31ISIN() {
		return fieldIV31ISIN.getString();
	}

	/**
	 * Get value of field IV31IVSCUN as a String.
	 */
	public String getIV31IVSCUN() {
		return fieldIV31IVSCUN.getString();
	}

	/**
	 * Get value of field IV31MKPRI as a String.
	 */
	public String getIV31MKPRI() {
		return fieldIV31MKPRI.getString();
	}

	/**
	 * Get value of field IV31PANDL as a String.
	 */
	public String getIV31PANDL() {
		return fieldIV31PANDL.getString();
	}

	/**
	 * Get value of field IV31PURPR as a String.
	 */
	public String getIV31PURPR() {
		return fieldIV31PURPR.getString();
	}

	/**
	 * Get value of field IV31QTY as a String.
	 */
	public String getIV31QTY() {
		return fieldIV31QTY.getString();
	}

	/**
	 * Get value of field IV31TYPE as a String.
	 */
	public String getIV31TYPE() {
		return fieldIV31TYPE.getString();
	}

	/**
	 * Get value of field IV31USER as a String.
	 */
	public String getIV31USER() {
		return fieldIV31USER.getString();
	}

	/**
	 * Set field IV31AVPUP using a String value.
	 */
	public void setIV31AVPUP(String newvalue) {
		fieldIV31AVPUP.setString(newvalue);
	}

	/**
	 * Set numeric field IV31AVPUP using a BigDecimal value.
	 */
	public void setIV31AVPUP(BigDecimal newvalue) {
		fieldIV31AVPUP.setBigDecimal(newvalue);
	}

	/**
	 * Set field IV31FVALUE using a String value.
	 */
	public void setIV31FVALUE(String newvalue) {
		fieldIV31FVALUE.setString(newvalue);
	}

	/**
	 * Set numeric field IV31FVALUE using a BigDecimal value.
	 */
	public void setIV31FVALUE(BigDecimal newvalue) {
		fieldIV31FVALUE.setBigDecimal(newvalue);
	}

	/**
	 * Set field IV31ISIN using a String value.
	 */
	public void setIV31ISIN(String newvalue) {
		fieldIV31ISIN.setString(newvalue);
	}

	/**
	 * Set field IV31IVSCUN using a String value.
	 */
	public void setIV31IVSCUN(String newvalue) {
		fieldIV31IVSCUN.setString(newvalue);
	}

	/**
	 * Set numeric field IV31IVSCUN using a BigDecimal value.
	 */
	public void setIV31IVSCUN(BigDecimal newvalue) {
		fieldIV31IVSCUN.setBigDecimal(newvalue);
	}

	/**
	 * Set field IV31MKPRI using a String value.
	 */
	public void setIV31MKPRI(String newvalue) {
		fieldIV31MKPRI.setString(newvalue);
	}

	/**
	 * Set numeric field IV31MKPRI using a BigDecimal value.
	 */
	public void setIV31MKPRI(BigDecimal newvalue) {
		fieldIV31MKPRI.setBigDecimal(newvalue);
	}

	/**
	 * Set field IV31PANDL using a String value.
	 */
	public void setIV31PANDL(String newvalue) {
		fieldIV31PANDL.setString(newvalue);
	}

	/**
	 * Set numeric field IV31PANDL using a BigDecimal value.
	 */
	public void setIV31PANDL(BigDecimal newvalue) {
		fieldIV31PANDL.setBigDecimal(newvalue);
	}

	/**
	 * Set field IV31PURPR using a String value.
	 */
	public void setIV31PURPR(String newvalue) {
		fieldIV31PURPR.setString(newvalue);
	}

	/**
	 * Set numeric field IV31PURPR using a BigDecimal value.
	 */
	public void setIV31PURPR(BigDecimal newvalue) {
		fieldIV31PURPR.setBigDecimal(newvalue);
	}

	/**
	 * Set field IV31QTY using a String value.
	 */
	public void setIV31QTY(String newvalue) {
		fieldIV31QTY.setString(newvalue);
	}

	/**
	 * Set numeric field IV31QTY using a BigDecimal value.
	 */
	public void setIV31QTY(BigDecimal newvalue) {
		fieldIV31QTY.setBigDecimal(newvalue);
	}

	/**
	 * Set field IV31TYPE using a String value.
	 */
	public void setIV31TYPE(String newvalue) {
		fieldIV31TYPE.setString(newvalue);
	}

	/**
	 * Set field IV31USER using a String value.
	 */
	public void setIV31USER(String newvalue) {
		fieldIV31USER.setString(newvalue);
	}
}