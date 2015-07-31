package com.afirme.afirmenet.ibs.beans.consultas;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.afirme.afirmenet.ibs.generics.Util;

/**
 * @author Ivan Martinez
 * 
 */
public class Cuenta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4210153644118426236L;

	public static final String TIPO_CUENTA = "Cuentas";
	public static final String TIPO_CREDITO = "Cr&eacute;dito";
	public static final String TIPO_INVERSION = "Inversi&oacute;n";
	private String description;
	private String number;
	private BigDecimal balance;
	private BigDecimal available;
	private String ccy;
	private String nickname;
	private String lnickname;
	private String servlet;
	private String type;
	private String flg;
	private String clabe;
	private Date fechaApertura;
	private Date fechaVencimiento;
	private BigDecimal factorBonus;
	private String tipoEstadoCuenta;
	private String newNickName;
	private boolean comercio;
	private String htmlDetalle;
	private String tipoInterno;
	// private static java.text.SimpleDateFormat df=new
	// java.text.SimpleDateFormat("dd/MM/yyyy");
	// Datos de los creditos
	private String cusNumber;
	private String mDate;
	private String oDate;
	private String aPRAMT;
	private String aVAAMT;
	private String cOLAMT;
	private String cREAMT;
	private String cREDES;
	private String cRERTE;
	private String dEUAMT;
	private String tITCRD;
	
	//Atributos para favoritos
	private String bankCode ="62";
	private String bankName="AFIRME";
	   	   
	   
	/**
	 * @return el description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description el description a establecer
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return numero de cuenta con mascara
	 */
	public String getNumberMask() {
		if (!StringUtils.isEmpty(this.number)) {
			return (this.number.substring(0, this.number.length() - 4))
					.replaceAll(".", "*")
					.concat(this.number.substring(this.number.length() - 4));
		}
		return "************";
	}
	/**
	 * @return el number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number el number a establecer
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return el balance
	 */
	public String getBalanceFormatted() {
		return Util.formatCCY(balance);
	}
	/**
	 * @return el balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * @param balance el balance a establecer
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	/**
	 * @return el available
	 */
	public BigDecimal getAvailable() {
		return available;
	}
	/**
	 * @param available el available a establecer
	 */
	public void setAvailable(BigDecimal available) {
		this.available = available;
	}
	/**
	 * @return el ccy
	 */
	public String getCcy() {
		return ccy;
	}
	/**
	 * @param ccy el ccy a establecer
	 */
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	/**
	 * @return el nickname
	 */
	public String getNickname() {
		if(newNickName!=null && newNickName.trim().length()>0)
			return newNickName;
		return nickname;
	}
	/**
	 * @param nickname el nickname a establecer
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return el lnickname
	 */
	public String getLnickname() {
		return lnickname;
	}
	/**
	 * @param lnickname el lnickname a establecer
	 */
	public void setLnickname(String lnickname) {
		this.lnickname = lnickname;
	}
	/**
	 * @return el servlet
	 */
	public String getServlet() {
		return servlet;
	}
	/**
	 * @param servlet el servlet a establecer
	 */
	public void setServlet(String servlet) {
		this.servlet = servlet;
	}
	/**
	 * @return el type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type el type a establecer
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return el flg
	 */
	public String getFlg() {
		return flg;
	}
	/**
	 * @param flg el flg a establecer
	 */
	public void setFlg(String flg) {
		this.flg = flg;
	}
	/**
	 * @return el clabe
	 */
	public String getClabe() {
		if(clabe==null)
			return "";
		return clabe;
		
	}
	/**
	 * @param clabe el clabe a establecer
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}
	/**
	 * @return el fechaApertura
	 */
	public Date getFechaApertura() {
		return fechaApertura;
	}
	/**
	 * @param fechaApertura el fechaApertura a establecer
	 */
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	/**
	 * @return el fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	/**
	 * @param fechaVencimiento el fechaVencimiento a establecer
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	/**
	 * @return el factorBonus
	 */
	public BigDecimal getFactorBonus() {
		return factorBonus;
	}
	/**
	 * @param factorBonus el factorBonus a establecer
	 */
	public void setFactorBonus(BigDecimal factorBonus) {
		this.factorBonus = factorBonus;
	}
	/**
	 * @param factorBonus el factorBonus a establecer en String sin formato
	 */
	public void setFactorBonusEspecial(String factor) {
		//gisela lee : factor bonus
		BigDecimal _factorBonus = new BigDecimal(1);
		try {
			_factorBonus = new BigDecimal(factor);
			_factorBonus = _factorBonus.setScale(4, BigDecimal.ROUND_HALF_UP);
		} catch (Exception e) {
			_factorBonus = new BigDecimal(0.1);
		}
		this.factorBonus = _factorBonus;
	}
	/**
	 * @return el tipoEstadoCuenta
	 */
	public String getTipoEstadoCuenta() {
		return tipoEstadoCuenta;
	}
	/**
	 * @param tipoEstadoCuenta el tipoEstadoCuenta a establecer
	 */
	public void setTipoEstadoCuenta(String tipoEstadoCuenta) {
		this.tipoEstadoCuenta = tipoEstadoCuenta;
	}
	/**
	 * @return el newNickName
	 */
	public String getNewNickName() {
		return newNickName;
	}
	/**
	 * @param newNickName el newNickName a establecer
	 */
	public void setNewNickName(String newNickName) {
		this.newNickName = newNickName;
	}
	/**
	 * @return el comercio
	 */
	public boolean isComercio() {
		return comercio;
	}
	/**
	 * @param comercio el comercio a establecer
	 */
	public void setComercio(boolean comercio) {
		this.comercio = comercio;
	}
	/**
	 * @return el htmlDetalle
	 */
	public String getHtmlDetalle() {
		return htmlDetalle;
	}
	/**
	 * @param htmlDetalle el htmlDetalle a establecer
	 */
	public void setHtmlDetalle(String htmlDetalle) {
		this.htmlDetalle = htmlDetalle;
	}
	/**
	 * @return el tipoInterno
	 */
	public String getTipoInterno() {
		return tipoInterno;
	}
	/**
	 * @param tipoInterno el tipoInterno a establecer
	 */
	public void setTipoInterno(String tipoInterno) {
		this.tipoInterno = tipoInterno;
	}
	/**
	 * @return el cusNumber
	 */
	public String getCusNumber() {
		return cusNumber;
	}
	/**
	 * @param cusNumber el cusNumber a establecer
	 */
	public void setCusNumber(String cusNumber) {
		this.cusNumber = cusNumber;
	}
	/**
	 * @return el mDate
	 */
	public String getmDate() {
		return mDate;
	}
	/**
	 * @param mDate el mDate a establecer
	 */
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	/**
	 * @return el oDate
	 */
	public String getoDate() {
		return oDate;
	}
	/**
	 * @param oDate el oDate a establecer
	 */
	public void setoDate(String oDate) {
		this.oDate = oDate;
	}
	/**
	 * @return el aPRAMT
	 */
	public String getaPRAMT() {
		return aPRAMT;
	}
	/**
	 * @param aPRAMT el aPRAMT a establecer
	 */
	public void setaPRAMT(String aPRAMT) {
		this.aPRAMT = aPRAMT;
	}
	/**
	 * @return el aVAAMT
	 */
	public String getaVAAMT() {
		return aVAAMT;
	}
	/**
	 * @param aVAAMT el aVAAMT a establecer
	 */
	public void setaVAAMT(String aVAAMT) {
		this.aVAAMT = aVAAMT;
	}
	/**
	 * @return el cOLAMT
	 */
	public String getcOLAMT() {
		return cOLAMT;
	}
	/**
	 * @param cOLAMT el cOLAMT a establecer
	 */
	public void setcOLAMT(String cOLAMT) {
		this.cOLAMT = cOLAMT;
	}
	/**
	 * @return el cREAMT
	 */
	public String getcREAMT() {
		return cREAMT;
	}
	/**
	 * @param cREAMT el cREAMT a establecer
	 */
	public void setcREAMT(String cREAMT) {
		this.cREAMT = cREAMT;
	}
	/**
	 * @return el cREDES
	 */
	public String getcREDES() {
		return cREDES;
	}
	/**
	 * @param cREDES el cREDES a establecer
	 */
	public void setcREDES(String cREDES) {
		this.cREDES = cREDES;
	}
	/**
	 * @return el cRERTE
	 */
	public String getcRERTE() {
		return cRERTE;
	}
	/**
	 * @param cRERTE el cRERTE a establecer
	 */
	public void setcRERTE(String cRERTE) {
		this.cRERTE = cRERTE;
	}
	/**
	 * @return el dEUAMT
	 */
	public String getdEUAMT() {
		return dEUAMT;
	}
	/**
	 * @param dEUAMT el dEUAMT a establecer
	 */
	public void setdEUAMT(String dEUAMT) {
		this.dEUAMT = dEUAMT;
	}
	/**
	 * @return el tITCRD
	 */
	public String gettITCRD() {
		return tITCRD;
	}
	/**
	 * @param tITCRD el tITCRD a establecer
	 */
	public void settITCRD(String tITCRD) {
		this.tITCRD = tITCRD;
	}
	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getConsTipoCredito(){
		return TIPO_CREDITO;
	}
	public String getConsTipoCuenta(){
		return TIPO_CUENTA;
	}
	public String getConsTipoInversion(){
		return TIPO_INVERSION;
	}
	   
}
