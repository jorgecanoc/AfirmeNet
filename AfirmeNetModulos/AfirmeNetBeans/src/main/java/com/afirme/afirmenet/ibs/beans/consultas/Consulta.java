package com.afirme.afirmenet.ibs.beans.consultas;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import com.afirme.afirmenet.ibs.generics.Util;

public class Consulta implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2579818729303964371L;
	private String usuario;
	private BigDecimal cuenta;
	private int regXpagina;
	private BigDecimal fechaInicio;
	private BigDecimal fechaFin;
	private BigDecimal referenciaInicial;
	private BigDecimal referenciaFinal;
	private BigDecimal montoInicial;
	private BigDecimal montoFinal;
	private int registros;
	private int paginas;
	private int paginaActual;
	private BigDecimal saldoIncial;
	private BigDecimal saldoFinal;
	private int numCargos;
	private int numAbonos;
	private BigDecimal cargos;
	private BigDecimal abonos;
	private BigDecimal saldoDiferido;
	private BigDecimal saldoDisponible;
	private BigDecimal interesSobregiro;
	private BigDecimal interesPagar;
	private String clave;
	private String codigoError;
	private String descError;
	private List<Movimiento> movimientos;
	private String cuentaMoneda;
	private String cuentaNombre;
	private String cuentaClabe;
	private String cuentaDesc;
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
	 * @return el regXpagina
	 */
	public int getRegXpagina() {
		return regXpagina;
	}
	/**
	 * @param regXpagina el regXpagina a establecer
	 */
	public void setRegXpagina(int regXpagina) {
		this.regXpagina = regXpagina;
	}
	/**
	 * @return el fechaInicio
	 */
	public BigDecimal getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @return el fechaInicio
	 */
	public String getFechaInicioStr() {
		try{
		return Util.fechaLargaSinDia(fechaInicio);
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * @param fechaInicio el fechaInicio a establecer
	 */
	public void setFechaInicio(BigDecimal fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return el fechaFin
	 */
	public BigDecimal getFechaFin() {
		return fechaFin;
	}
	/**
	 * @return el fechaFin
	 */
	public String getFechaFinStr() {
		try{
			return Util.fechaLargaSinDia(fechaFin);
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * @param fechaFin el fechaFin a establecer
	 */
	public void setFechaFin(BigDecimal fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return el referenciaInicial
	 */
	public BigDecimal getReferenciaInicial() {
		if(referenciaInicial==null)
			return BigDecimal.ZERO;
		return referenciaInicial;
	}
	/**
	 * @param referenciaInicial el referenciaInicial a establecer
	 */
	public void setReferenciaInicial(BigDecimal referenciaInicial) {
		this.referenciaInicial = referenciaInicial;
	}
	/**
	 * @return el referenciaFinal
	 */
	public BigDecimal getReferenciaFinal() {
		if(referenciaFinal==null)
			return BigDecimal.ZERO;
		return referenciaFinal;
	}
	/**
	 * @param referenciaFinal el referenciaFinal a establecer
	 */
	public void setReferenciaFinal(BigDecimal referenciaFinal) {
		this.referenciaFinal = referenciaFinal;
	}
	/**
	 * @return el montoInicial
	 */
	public BigDecimal getMontoInicial() {
		if(montoInicial==null)
			return BigDecimal.ZERO;
		return montoInicial;
	}
	/**
	 * @return el montoInicial
	 */
	public String getMontoInicialStr() {
		return Util.formatCCY(montoInicial);
	}
	/**
	 * @param montoInicial el montoInicial a establecer
	 */
	public void setMontoInicial(BigDecimal montoInicial) {
		this.montoInicial = montoInicial;
	}
	/**
	 * @return el montoFinal
	 */
	public BigDecimal getMontoFinal() {
		if(montoFinal==null)
			return BigDecimal.ZERO;
		return montoFinal;
	}
	/**
	 * @return el montoFinal
	 */
	public String getMontoFinalStr() {
		return Util.formatCCY(montoFinal);
	}
	/**
	 * @param montoFinal el montoFinal a establecer
	 */
	public void setMontoFinal(BigDecimal montoFinal) {
		this.montoFinal = montoFinal;
	}
	/**
	 * @return el registros
	 */
	public int getRegistros() {
		return registros;
	}
	/**
	 * @param registros el registros a establecer
	 */
	public void setRegistros(int registros) {
		this.registros = registros;
	}
	/**
	 * @return el paginas
	 */
	public int getPaginas() {
		return paginas;
	}
	/**
	 * @param paginas el paginas a establecer
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	/**
	 * @return el paginaActual
	 */
	public int getPaginaActual() {
		return paginaActual;
	}
	/**
	 * @param paginaActual el paginaActual a establecer
	 */
	public void setPaginaActual(int paginaActual) {
		this.paginaActual = paginaActual;
	}
	/**
	 * @return el saldoIncial
	 */
	public BigDecimal getSaldoIncial() {
		return saldoIncial;
	}
	/**
	 * @return el saldoIncial en formato moneda
	 */
	public String getSaldoIncialStr() {
		return Util.formatCCY(saldoIncial);
	}
	/**
	 * @param saldoIncial el saldoIncial a establecer
	 */
	public void setSaldoIncial(BigDecimal saldoIncial) {
		this.saldoIncial = saldoIncial;
	}
	/**
	 * @return el saldoFinal
	 */
	public BigDecimal getSaldoFinal() {
		return saldoFinal;
	}
	/**
	 * @return el saldoFinal en formato moneda
	 */
	public String getSaldoFinalStr() {
		return Util.formatCCY(saldoFinal);
	}
	/**
	 * @param saldoFinal el saldoFinal a establecer
	 */
	public void setSaldoFinal(BigDecimal saldoFinal) {
		this.saldoFinal = saldoFinal;
	}
	/**
	 * @return el numCargos
	 */
	public int getNumCargos() {
		return numCargos;
	}
	/**
	 * @param numCargos el numCargos a establecer
	 */
	public void setNumCargos(int numCargos) {
		this.numCargos = numCargos;
	}
	/**
	 * @return el numAbonos
	 */
	public int getNumAbonos() {
		return numAbonos;
	}
	/**
	 * @param numAbonos el numAbonos a establecer
	 */
	public void setNumAbonos(int numAbonos) {
		this.numAbonos = numAbonos;
	}
	/**
	 * @return el cargos
	 */
	public BigDecimal getCargos() {
		return cargos;
	}
	/**
	 * @return el cargos en formato moneda
	 */
	public String getCargosStr() {
		return Util.formatCCY(cargos);
	}
	/**
	 * @param cargos el cargos a establecer
	 */
	public void setCargos(BigDecimal cargos) {
		this.cargos = cargos;
	}
	/**
	 * @return el abonos
	 */
	public BigDecimal getAbonos() {
		return abonos;
	}
	/**
	 * @return el abonos en formato moneda
	 */
	public String getAbonosStr() {
		return Util.formatCCY(abonos);
	}
	/**
	 * @param abonos el abonos a establecer
	 */
	public void setAbonos(BigDecimal abonos) {
		this.abonos = abonos;
	}
	/**
	 * @return el saldoDiferido
	 */
	public BigDecimal getSaldoDiferido() {
		return saldoDiferido;
	}
	/**
	 * @return el saldoDiferido en formato moneda
	 */
	public String getSaldoDiferidoStr() {
		return Util.formatCCY(saldoDiferido);
	}
	/**
	 * @param saldoDiferido el saldoDiferido a establecer
	 */
	public void setSaldoDiferido(BigDecimal saldoDiferido) {
		this.saldoDiferido = saldoDiferido;
	}
	/**
	 * @return el saldoDisponible
	 */
	public BigDecimal getSaldoDisponible() {
		return saldoDisponible;
	}
	/**
	 * @return el saldoDisponible con formato moneada
	 */
	public String getSaldoDisponibleStr() {
		return Util.formatCCY(saldoDisponible);
	}
	/**
	 * @param saldoDisponible el saldoDisponible a establecer
	 */
	public void setSaldoDisponible(BigDecimal saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	/**
	 * @return el interesSobregiro en formato moneada
	 */
	public String getInteresSobregiroStr() {
		return Util.formatCCY(interesSobregiro);
	}
	/**
	 * @return el interesSobregiro
	 */
	public BigDecimal getInteresSobregiro() {
		return interesSobregiro;
	}
	/**
	 * @param interesSobregiro el interesSobregiro a establecer
	 */
	public void setInteresSobregiro(BigDecimal interesSobregiro) {
		this.interesSobregiro = interesSobregiro;
	}
	/**
	 * @return el interesPagar
	 */
	public BigDecimal getInteresPagar() {
		return interesPagar;
	}
	/**
	 * @return el interesPagar en formato moneada
	 */
	public String getInteresPagarStr() {
		return Util.formatCCY(interesPagar);
	}
	/**
	 * @param interesPagar el interesPagar a establecer
	 */
	public void setInteresPagar(BigDecimal interesPagar) {
		this.interesPagar = interesPagar;
	}
	/**
	 * @return el clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave el clave a establecer
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * @return el codigoError
	 */
	public String getCodigoError() {
		return codigoError;
	}
	/**
	 * @param codigoError el codigoError a establecer
	 */
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	/**
	 * @return el descError
	 */
	public String getDescError() {
		return descError;
	}
	/**
	 * @param descError el descError a establecer
	 */
	public void setDescError(String descError) {
		this.descError = descError;
	}
	/**
	 * @return el movimientos
	 */
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	/**
	 * @param movimientos el movimientos a establecer
	 */
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public String getFechaTitulo(){
		try {
			return Util.fechaLargaSinDia();
		} catch (ParseException e) {
			return "";
		}
		
	}
	public String getFechaTituloMes(){
		try {
			return Util.fechaMesAgno(fechaInicio);
		} catch (ParseException e) {
			return "";
		}
		
	}
	/**
	 * @return el cuentaMoneda
	 */
	public String getCuentaMoneda() {
		return cuentaMoneda;
	}
	/**
	 * @param cuentaMoneda el cuentaMoneda a establecer
	 */
	public void setCuentaMoneda(String cuentaMoneda) {
		this.cuentaMoneda = cuentaMoneda;
	}
	/**
	 * @return el cuentaNombre
	 */
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	/**
	 * @param cuentaNombre el cuentaNombre a establecer
	 */
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	/**
	 * @return el cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}
	/**
	 * @param cuentaClabe el cuentaClabe a establecer
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}
	/**
	 * @return el cuentaDesc
	 */
	public String getCuentaDesc() {
		return cuentaDesc;
	}
	/**
	 * @param cuentaDesc el cuentaDesc a establecer
	 */
	public void setCuentaDesc(String cuentaDesc) {
		this.cuentaDesc = cuentaDesc;
	}
	/**
	 * @return variable boleana que define si es el mes actual o no
	 */
	public boolean getEsMesActual(){
		return " ".equalsIgnoreCase(clave);
	}
	
}
