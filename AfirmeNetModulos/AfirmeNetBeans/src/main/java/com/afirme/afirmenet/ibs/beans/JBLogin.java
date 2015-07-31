package com.afirme.afirmenet.ibs.beans;

import com.afirme.afirmenet.ibs.messages.INLOGIN02Message;

public class JBLogin {
	
	private String tipo="0";
	private String patrimonial="N";
	private String paquete=""; //grupo
	private String alias="";  //alias
	private String estatus="";
	
	private String tCliente;    
	private String email;
	private String status;     
	private String eussts;
	private String UserMAXI;
	private String GroupID;
	private String kID;
	private String Suc2;
	private String cliente;
	private String GrpId;
	private String nombreCliente;
	private String officerName;
	private String officerEmail;
	private String esPatrimonial;
	private String FDate;
	private String FormatName;
	private String PWDUSR;
	/**
	 * @return el tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo el tipo a establecer
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return el patrimonial
	 */
	public String getPatrimonial() {
		return patrimonial;
	}
	/**
	 * @param patrimonial el patrimonial a establecer
	 */
	public void setPatrimonial(String patrimonial) {
		this.patrimonial = patrimonial;
	}
	/**
	 * @return el paquete
	 */
	public String getPaquete() {
		return paquete;
	}
	/**
	 * @param paquete el paquete a establecer
	 */
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	/**
	 * @return el alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param alias el alias a establecer
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @return el estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus el estatus a establecer
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return el tCliente
	 */
	public String gettCliente() {
		return tCliente;
	}
	/**
	 * @param tCliente el tCliente a establecer
	 */
	public void settCliente(String tCliente) {
		this.tCliente = tCliente;
	}
	/**
	 * @return el email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email el email a establecer
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return el status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status el status a establecer
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return el eussts
	 */
	public String getEussts() {
		return eussts;
	}
	/**
	 * @param eussts el eussts a establecer
	 */
	public void setEussts(String eussts) {
		this.eussts = eussts;
	}
	/**
	 * @return el userMAXI
	 */
	public String getUserMAXI() {
		return UserMAXI;
	}
	/**
	 * @param userMAXI el userMAXI a establecer
	 */
	public void setUserMAXI(String userMAXI) {
		UserMAXI = userMAXI;
	}
	/**
	 * @return el groupID
	 */
	public String getGroupID() {
		return GroupID;
	}
	/**
	 * @param groupID el groupID a establecer
	 */
	public void setGroupID(String groupID) {
		GroupID = groupID;
	}
	/**
	 * @return el kID
	 */
	public String getkID() {
		return kID;
	}
	/**
	 * @param kID el kID a establecer
	 */
	public void setkID(String kID) {
		this.kID = kID;
	}
	/**
	 * @return el suc2
	 */
	public String getSuc2() {
		return Suc2;
	}
	/**
	 * @param suc2 el suc2 a establecer
	 */
	public void setSuc2(String suc2) {
		Suc2 = suc2;
	}
	/**
	 * @return el cliente
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * @param cliente el cliente a establecer
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return el grpId
	 */
	public String getGrpId() {
		return GrpId;
	}
	/**
	 * @param grpId el grpId a establecer
	 */
	public void setGrpId(String grpId) {
		GrpId = grpId;
	}
	/**
	 * @return el nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente el nombreCliente a establecer
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return el officerName
	 */
	public String getOfficerName() {
		return officerName;
	}
	/**
	 * @param officerName el officerName a establecer
	 */
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	/**
	 * @return el officerEmail
	 */
	public String getOfficerEmail() {
		return officerEmail;
	}
	/**
	 * @param officerEmail el officerEmail a establecer
	 */
	public void setOfficerEmail(String officerEmail) {
		this.officerEmail = officerEmail;
	}
	/**
	 * @return el esPatrimonial
	 */
	public String getEsPatrimonial() {
		return esPatrimonial;
	}
	/**
	 * @param esPatrimonial el esPatrimonial a establecer
	 */
	public void setEsPatrimonial(String esPatrimonial) {
		this.esPatrimonial = esPatrimonial;
	}
	/**
	 * @return el fDate
	 */
	public String getFDate() {
		return FDate;
	}
	/**
	 * @param fDate el fDate a establecer
	 */
	public void setFDate(String fDate) {
		FDate = fDate;
	}
	/**
	 * @return el formatName
	 */
	public String getFormatName() {
		return FormatName;
	}
	/**
	 * @param formatName el formatName a establecer
	 */
	public void setFormatName(String formatName) {
		FormatName = formatName;
	}
	/**
	 * @return el pWDUSR
	 */
	public String getPWDUSR() {
		return PWDUSR;
	}
	/**
	 * @param pWDUSR el pWDUSR a establecer
	 */
	public void setPWDUSR(String pWDUSR) {
		PWDUSR = pWDUSR;
	}
	
	
	
}
