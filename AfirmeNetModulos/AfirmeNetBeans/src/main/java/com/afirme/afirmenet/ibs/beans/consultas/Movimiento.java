package com.afirme.afirmenet.ibs.beans.consultas;

import java.math.BigDecimal;

import com.afirme.afirmenet.ibs.generics.Util;

/**
 * @author Ivan Martinez
 * 
 */
public class Movimiento  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4482512717075401809L;
	private String usuario; // STMUSR
	private BigDecimal cuenta; // STMACC
	private String codigo; // STMCDE
	private String narrativa; // STMNAR
	private BigDecimal fecha; // STMFECHA
	private BigDecimal hora; // STMHORA
	private BigDecimal referencia; // STMCKN
	private BigDecimal saldoB; // STMBBL
	private BigDecimal monto; // STMAMT
	private String codigoDCC; // STMDCC
	private BigDecimal balance; // STMEBL
	private BigDecimal registro; // STMREC
	private String mem; // STMMEM
	private BigDecimal drr; // STMDRR
	private BigDecimal nnar; // STMNNAR
	/**
	 * @return el usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario el usuario a establecer
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return el cuenta
	 */
	public BigDecimal getCuenta() {
		return cuenta;
	}
	/**
	 * @param cuenta el cuenta a establecer
	 */
	public void setCuenta(BigDecimal cuenta) {
		this.cuenta = cuenta;
	}
	/**
	 * @return el codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo el codigo a establecer
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return el narrativa
	 */
	public String getNarrativa() {
		return narrativa.replaceAll("\\|", " ").trim();
	}
	/**
	 * @param narrativa el narrativa a establecer
	 */
	public void setNarrativa(String narrativa) {
		this.narrativa = narrativa;
	}
	/**
	 * @return el fecha
	 */
	public BigDecimal getFecha() {
		return fecha;
	}/**
	 * @return la fecha en formato Largo
	 */
	public String getFechaLarga() {
		String fLarga="";
		try{
			fLarga=Util.fechaLarga(fecha);
		}catch(Exception e){
			fLarga="";
		}
		return fLarga.toUpperCase();
	}
	/**
	 * @param fecha el fecha a establecer
	 */
	public void setFecha(BigDecimal fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return el hora
	 */
	public BigDecimal getHora() {
		return hora;
	}
	/**
	 * @param hora el hora a establecer
	 */
	public void setHora(BigDecimal hora) {
		this.hora = hora;
	}
	/**
	 * @return el referencia
	 */
	public BigDecimal getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia el referencia a establecer
	 */
	public void setReferencia(BigDecimal referencia) {
		this.referencia = referencia;
	}
	/**
	 * @return el saldoB
	 */
	public BigDecimal getSaldoB() {
		return saldoB;
	}
	/**
	 * @param saldoB el saldoB a establecer
	 */
	public void setSaldoB(BigDecimal saldoB) {
		this.saldoB = saldoB;
	}
	/**
	 * @return el monto
	 */
	public BigDecimal getMonto() {
		return monto;
	}
	/**
	 * @return el monto con formato numero
	 */
	public String getMontoStr() {
		return Util.formatCCY(monto);
	}
	/**
	 * @param monto el monto a establecer
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	/**
	 * @return el codigoDCC
	 */
	public String getCodigoDCC() {
		return codigoDCC;
	}
	/**
	 * @param codigoDCC el codigoDCC a establecer
	 */
	public void setCodigoDCC(String codigoDCC) {
		this.codigoDCC = codigoDCC;
	}
	/**
	 * @return el balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * @return el balance en formato moneda
	 */
	public String getBalanceStr() {
		return Util.formatCCY(balance);
	}
	/**
	 * @param balance el balance a establecer
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/**
	 * @return el registro
	 */
	public BigDecimal getRegistro() {
		return registro;
	}
	/**
	 * @param registro el registro a establecer
	 */
	public void setRegistro(BigDecimal registro) {
		this.registro = registro;
	}
	/**
	 * @return el mem
	 */
	public String getMem() {
		return mem;
	}
	/**
	 * @param mem el mem a establecer
	 */
	public void setMem(String mem) {
		this.mem = mem;
	}
	/**
	 * @return el drr
	 */
	public BigDecimal getDrr() {
		return drr;
	}
	/**
	 * @param drr el drr a establecer
	 */
	public void setDrr(BigDecimal drr) {
		this.drr = drr;
	}
	/**
	 * @return el nnar
	 */
	public BigDecimal getNnar() {
		return nnar;
	}
	/**
	 * @param nnar el nnar a establecer
	 */
	public void setNnar(BigDecimal nnar) {
		this.nnar = nnar;
	}

	public boolean getEsCredito(){
		return "5".equals(this.codigoDCC.trim());
	}
}
