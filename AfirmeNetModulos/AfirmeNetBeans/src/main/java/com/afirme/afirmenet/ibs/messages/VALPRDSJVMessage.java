package com.afirme.afirmenet.ibs.messages;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.DecimalField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
 * Class generated by AS/400 CRTCLASS command from VALPRDSJV physical file
 * definition.
 * 
 * File level identifier is 1031014173612. Record format level identifier is
 * 404CF2ACF3987.
 */

@SuppressWarnings("rawtypes")
public class VALPRDSJVMessage extends MessageRecord {
	final static String fldnames[] = { "VA_USER", "VA_TRNCDE", "VA_REVER",
			"VA_TIPREG", "VA_FOLIO", "VA_RFC", "VA_APEPAT", "VA_APEMAT",
			"VA_NOMBRE", "VA_RAZSOC", "VA_EFECTI", "VA_CHEQUE", "VA_MONTOT",
			"VA_CONCEP", "VA_SECENC", "VA_MONEDA", "VA_CTACAR", "VA_ERROR" };
	final static String tnames[] = { "VA_USER", "VA_TRNCDE", "VA_REVER",
			"VA_TIPREG", "VA_FOLIO", "VA_RFC", "VA_APEPAT", "VA_APEMAT",
			"VA_NOMBRE", "VA_RAZSOC", "VA_EFECTI", "VA_CHEQUE", "VA_MONTOT",
			"VA_CONCEP", "VA_SECENC", "VA_MONEDA", "VA_CTACAR", "VA_ERROR" };
	final static String fid = "1031014173612";
	final static String rid = "404CF2ACF3987";
	final static String fmtname = "VALPRDSJV";
	final int FIELDCOUNT = 18;
	private static Hashtable tlookup = new Hashtable();
	private CharacterField fieldVA_USER = null;
	private DecimalField fieldVA_TRNCDE = null;
	private CharacterField fieldVA_REVER = null;
	private CharacterField fieldVA_TIPREG = null;
	private DecimalField fieldVA_FOLIO = null;
	private CharacterField fieldVA_RFC = null;
	private CharacterField fieldVA_APEPAT = null;
	private CharacterField fieldVA_APEMAT = null;
	private CharacterField fieldVA_NOMBRE = null;
	private CharacterField fieldVA_RAZSOC = null;
	private DecimalField fieldVA_EFECTI = null;
	private DecimalField fieldVA_CHEQUE = null;
	private DecimalField fieldVA_MONTOT = null;
	private DecimalField fieldVA_CONCEP = null;
	private DecimalField fieldVA_SECENC = null;
	private CharacterField fieldVA_MONEDA = null;
	private DecimalField fieldVA_CTACAR = null;
	private DecimalField fieldVA_ERROR = null;

	/**
	 * Constructor for VALPRDSJVMessage.
	 */
	public VALPRDSJVMessage() {
		createFields();
		initialize();
	}

	/**
	 * Create fields for this message. This method implements the abstract
	 * method in the MessageRecord superclass.
	 */
	@SuppressWarnings("unchecked")
	protected void createFields() {
		recordsize = 210;
		fileid = fid;
		recordid = rid;
		message = new byte[getByteLength()];
		formatname = fmtname;
		fieldnames = fldnames;
		tagnames = tnames;
		fields = new MessageField[FIELDCOUNT];

		fields[0] = fieldVA_USER = new CharacterField(message, HEADERSIZE + 0,
				10, "VA_USER");
		fields[1] = fieldVA_TRNCDE = new DecimalField(message, HEADERSIZE + 10,
				5, 0, "VA_TRNCDE");
		fields[2] = fieldVA_REVER = new CharacterField(message,
				HEADERSIZE + 15, 1, "VA_REVER");
		fields[3] = fieldVA_TIPREG = new CharacterField(message,
				HEADERSIZE + 16, 1, "VA_TIPREG");
		fields[4] = fieldVA_FOLIO = new DecimalField(message, HEADERSIZE + 17,
				9, 0, "VA_FOLIO");
		fields[5] = fieldVA_RFC = new CharacterField(message, HEADERSIZE + 26,
				15, "VA_RFC");
		fields[6] = fieldVA_APEPAT = new CharacterField(message,
				HEADERSIZE + 41, 15, "VA_APEPAT");
		fields[7] = fieldVA_APEMAT = new CharacterField(message,
				HEADERSIZE + 56, 15, "VA_APEMAT");
		fields[8] = fieldVA_NOMBRE = new CharacterField(message,
				HEADERSIZE + 71, 15, "VA_NOMBRE");
		fields[9] = fieldVA_RAZSOC = new CharacterField(message,
				HEADERSIZE + 86, 45, "VA_RAZSOC");
		fields[10] = fieldVA_EFECTI = new DecimalField(message,
				HEADERSIZE + 131, 17, 2, "VA_EFECTI");
		fields[11] = fieldVA_CHEQUE = new DecimalField(message,
				HEADERSIZE + 148, 17, 2, "VA_CHEQUE");
		fields[12] = fieldVA_MONTOT = new DecimalField(message,
				HEADERSIZE + 165, 17, 2, "VA_MONTOT");
		fields[13] = fieldVA_CONCEP = new DecimalField(message,
				HEADERSIZE + 182, 3, 0, "VA_CONCEP");
		fields[14] = fieldVA_SECENC = new DecimalField(message,
				HEADERSIZE + 185, 5, 0, "VA_SECENC");
		fields[15] = fieldVA_MONEDA = new CharacterField(message,
				HEADERSIZE + 190, 3, "VA_MONEDA");
		fields[16] = fieldVA_CTACAR = new DecimalField(message,
				HEADERSIZE + 193, 13, 0, "VA_CTACAR");
		fields[17] = fieldVA_ERROR = new DecimalField(message,
				HEADERSIZE + 206, 4, 0, "VA_ERROR");

		synchronized (tlookup) {
			if (tlookup.isEmpty()) {
				for (int i = 0; i < tnames.length; i++)
					tlookup.put(tnames[i], new Integer(i));
			}
		}

		taglookup = tlookup;
	}

	/**
	 * Set field VA_USER using a String value.
	 */
	public void setVA_USER(String newvalue) {
		fieldVA_USER.setString(newvalue);
	}

	/**
	 * Get value of field VA_USER as a String.
	 */
	public String getVA_USER() {
		return fieldVA_USER.getString();
	}

	/**
	 * Set field VA_TRNCDE using a String value.
	 */
	public void setVA_TRNCDE(String newvalue) {
		fieldVA_TRNCDE.setString(newvalue);
	}

	/**
	 * Get value of field VA_TRNCDE as a String.
	 */
	public String getVA_TRNCDE() {
		return fieldVA_TRNCDE.getString();
	}

	/**
	 * Set numeric field VA_TRNCDE using a BigDecimal value.
	 */
	public void setVA_TRNCDE(BigDecimal newvalue) {
		fieldVA_TRNCDE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_TRNCDE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_TRNCDE() {
		return fieldVA_TRNCDE.getBigDecimal();
	}

	/**
	 * Set field VA_REVER using a String value.
	 */
	public void setVA_REVER(String newvalue) {
		fieldVA_REVER.setString(newvalue);
	}

	/**
	 * Get value of field VA_REVER as a String.
	 */
	public String getVA_REVER() {
		return fieldVA_REVER.getString();
	}

	/**
	 * Set field VA_TIPREG using a String value.
	 */
	public void setVA_TIPREG(String newvalue) {
		fieldVA_TIPREG.setString(newvalue);
	}

	/**
	 * Get value of field VA_TIPREG as a String.
	 */
	public String getVA_TIPREG() {
		return fieldVA_TIPREG.getString();
	}

	/**
	 * Set field VA_FOLIO using a String value.
	 */
	public void setVA_FOLIO(String newvalue) {
		fieldVA_FOLIO.setString(newvalue);
	}

	/**
	 * Get value of field VA_FOLIO as a String.
	 */
	public String getVA_FOLIO() {
		return fieldVA_FOLIO.getString();
	}

	/**
	 * Set numeric field VA_FOLIO using a BigDecimal value.
	 */
	public void setVA_FOLIO(BigDecimal newvalue) {
		fieldVA_FOLIO.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_FOLIO as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_FOLIO() {
		return fieldVA_FOLIO.getBigDecimal();
	}

	/**
	 * Set field VA_RFC using a String value.
	 */
	public void setVA_RFC(String newvalue) {
		fieldVA_RFC.setString(newvalue);
	}

	/**
	 * Get value of field VA_RFC as a String.
	 */
	public String getVA_RFC() {
		return fieldVA_RFC.getString();
	}

	/**
	 * Set field VA_APEPAT using a String value.
	 */
	public void setVA_APEPAT(String newvalue) {
		fieldVA_APEPAT.setString(newvalue);
	}

	/**
	 * Get value of field VA_APEPAT as a String.
	 */
	public String getVA_APEPAT() {
		return fieldVA_APEPAT.getString();
	}

	/**
	 * Set field VA_APEMAT using a String value.
	 */
	public void setVA_APEMAT(String newvalue) {
		fieldVA_APEMAT.setString(newvalue);
	}

	/**
	 * Get value of field VA_APEMAT as a String.
	 */
	public String getVA_APEMAT() {
		return fieldVA_APEMAT.getString();
	}

	/**
	 * Set field VA_NOMBRE using a String value.
	 */
	public void setVA_NOMBRE(String newvalue) {
		fieldVA_NOMBRE.setString(newvalue);
	}

	/**
	 * Get value of field VA_NOMBRE as a String.
	 */
	public String getVA_NOMBRE() {
		return fieldVA_NOMBRE.getString();
	}

	/**
	 * Set field VA_RAZSOC using a String value.
	 */
	public void setVA_RAZSOC(String newvalue) {
		fieldVA_RAZSOC.setString(newvalue);
	}

	/**
	 * Get value of field VA_RAZSOC as a String.
	 */
	public String getVA_RAZSOC() {
		return fieldVA_RAZSOC.getString();
	}

	/**
	 * Set field VA_EFECTI using a String value.
	 */
	public void setVA_EFECTI(String newvalue) {
		fieldVA_EFECTI.setString(newvalue);
	}

	/**
	 * Get value of field VA_EFECTI as a String.
	 */
	public String getVA_EFECTI() {
		return fieldVA_EFECTI.getString();
	}

	/**
	 * Set numeric field VA_EFECTI using a BigDecimal value.
	 */
	public void setVA_EFECTI(BigDecimal newvalue) {
		fieldVA_EFECTI.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_EFECTI as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_EFECTI() {
		return fieldVA_EFECTI.getBigDecimal();
	}

	/**
	 * Set field VA_CHEQUE using a String value.
	 */
	public void setVA_CHEQUE(String newvalue) {
		fieldVA_CHEQUE.setString(newvalue);
	}

	/**
	 * Get value of field VA_CHEQUE as a String.
	 */
	public String getVA_CHEQUE() {
		return fieldVA_CHEQUE.getString();
	}

	/**
	 * Set numeric field VA_CHEQUE using a BigDecimal value.
	 */
	public void setVA_CHEQUE(BigDecimal newvalue) {
		fieldVA_CHEQUE.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_CHEQUE as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_CHEQUE() {
		return fieldVA_CHEQUE.getBigDecimal();
	}

	/**
	 * Set field VA_MONTOT using a String value.
	 */
	public void setVA_MONTOT(String newvalue) {
		fieldVA_MONTOT.setString(newvalue);
	}

	/**
	 * Get value of field VA_MONTOT as a String.
	 */
	public String getVA_MONTOT() {
		return fieldVA_MONTOT.getString();
	}

	/**
	 * Set numeric field VA_MONTOT using a BigDecimal value.
	 */
	public void setVA_MONTOT(BigDecimal newvalue) {
		fieldVA_MONTOT.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_MONTOT as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_MONTOT() {
		return fieldVA_MONTOT.getBigDecimal();
	}

	/**
	 * Set field VA_CONCEP using a String value.
	 */
	public void setVA_CONCEP(String newvalue) {
		fieldVA_CONCEP.setString(newvalue);
	}

	/**
	 * Get value of field VA_CONCEP as a String.
	 */
	public String getVA_CONCEP() {
		return fieldVA_CONCEP.getString();
	}

	/**
	 * Set numeric field VA_CONCEP using a BigDecimal value.
	 */
	public void setVA_CONCEP(BigDecimal newvalue) {
		fieldVA_CONCEP.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_CONCEP as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_CONCEP() {
		return fieldVA_CONCEP.getBigDecimal();
	}

	/**
	 * Set field VA_SECENC using a String value.
	 */
	public void setVA_SECENC(String newvalue) {
		fieldVA_SECENC.setString(newvalue);
	}

	/**
	 * Get value of field VA_SECENC as a String.
	 */
	public String getVA_SECENC() {
		return fieldVA_SECENC.getString();
	}

	/**
	 * Set numeric field VA_SECENC using a BigDecimal value.
	 */
	public void setVA_SECENC(BigDecimal newvalue) {
		fieldVA_SECENC.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_SECENC as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_SECENC() {
		return fieldVA_SECENC.getBigDecimal();
	}

	/**
	 * Set field VA_MONEDA using a String value.
	 */
	public void setVA_MONEDA(String newvalue) {
		fieldVA_MONEDA.setString(newvalue);
	}

	/**
	 * Get value of field VA_MONEDA as a String.
	 */
	public String getVA_MONEDA() {
		return fieldVA_MONEDA.getString();
	}

	/**
	 * Set field VA_CTACAR using a String value.
	 */
	public void setVA_CTACAR(String newvalue) {
		fieldVA_CTACAR.setString(newvalue);
	}

	/**
	 * Get value of field VA_CTACAR as a String.
	 */
	public String getVA_CTACAR() {
		return fieldVA_CTACAR.getString();
	}

	/**
	 * Set numeric field VA_CTACAR using a BigDecimal value.
	 */
	public void setVA_CTACAR(BigDecimal newvalue) {
		fieldVA_CTACAR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_CTACAR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_CTACAR() {
		return fieldVA_CTACAR.getBigDecimal();
	}

	/**
	 * Set field VA_ERROR using a String value.
	 */
	public void setVA_ERROR(String newvalue) {
		fieldVA_ERROR.setString(newvalue);
	}

	/**
	 * Get value of field VA_ERROR as a String.
	 */
	public String getVA_ERROR() {
		return fieldVA_ERROR.getString();
	}

	/**
	 * Set numeric field VA_ERROR using a BigDecimal value.
	 */
	public void setVA_ERROR(BigDecimal newvalue) {
		fieldVA_ERROR.setBigDecimal(newvalue);
	}

	/**
	 * Return value of numeric field VA_ERROR as a BigDecimal.
	 */
	public BigDecimal getBigDecimalVA_ERROR() {
		return fieldVA_ERROR.getBigDecimal();
	}

}
