package com.afirme.afirmenet.ibs.databeans.servicePay;

import java.sql.Timestamp;
/**
 * Esta clase esta en deprecada, utilizar {@link DCPermisoServicio}
 * @author 0jacancue
 *
 */
@Deprecated
public class DC_PERMISOS_SERVICIOS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String ENTITYID;
	protected String USERID;
	protected String USERTYPE;
	protected int SERVICEID;
	protected int STATUS;
	protected Timestamp FECHACREACION;
	// jochoa
	protected String fechaString;
	protected String horaString;
	@SuppressWarnings("unused")
	private String radio;
	private String descripcion;
	private String empresa;

	public DC_PERMISOS_SERVICIOS() {
		super();
	}

	public DC_PERMISOS_SERVICIOS(String ENTITYID, String USERID,
			String USERTYPE, int SERVICEID, int STATUS, Timestamp FECHACREACION) {
		this.ENTITYID = ENTITYID;
		this.USERID = USERID;
		this.USERTYPE = USERTYPE;
		this.SERVICEID = SERVICEID;
		this.STATUS = STATUS;
		this.FECHACREACION = FECHACREACION;
	}

	public DC_PERMISOS_SERVICIOS(String ENTITYID, String USERID,
			String USERTYPE, int SERVICEID, int STATUS,
			Timestamp FECHACREACION, String DESCRIPCION, String EMPRESA) {
		this.ENTITYID = ENTITYID;
		this.USERID = USERID;
		this.USERTYPE = USERTYPE;
		this.SERVICEID = SERVICEID;
		this.STATUS = STATUS;
		this.FECHACREACION = FECHACREACION;
		this.descripcion = DESCRIPCION;
		this.empresa = EMPRESA;
	}

	public String getENTITYID() {
		return ENTITYID;
	}

	public Timestamp getFECHACREACION() {
		return FECHACREACION;
	}

	public int getSERVICEID() {
		return SERVICEID;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public String getUSERID() {
		return USERID;
	}

	public String getUSERTYPE() {
		return USERTYPE;
	}

	public void setENTITYID(String string) {
		ENTITYID = string;
	}

	public void setFECHACREACION(Timestamp string) {
		FECHACREACION = string;
	}

	public void setSERVICEID(int i) {
		SERVICEID = i;
	}

	public void setSTATUS(int string) {
		STATUS = string;
	}

	public void setUSERID(String string) {
		USERID = string;
	}

	public void setUSERTYPE(String string) {
		USERTYPE = string;
	}

	public String getFechaString() {
		return fechaString;
	}

	public String getHoraString() {
		return horaString;
	}

	public String getRadio() {

		return "<input type=\"radio\" name=\"ServiceId\" value=\""
				+ this.SERVICEID + "-" + this.USERID + "\" />";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	public void setHoraString(String horaString) {
		this.horaString = horaString;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}