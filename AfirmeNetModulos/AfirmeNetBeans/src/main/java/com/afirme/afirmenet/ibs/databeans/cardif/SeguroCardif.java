package com.afirme.afirmenet.ibs.databeans.cardif;

import java.math.BigDecimal;

import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

public class SeguroCardif extends TransferenciaBase{
	private BigDecimal cliente;
	private String numeroPoliza;
	private String paquete;
	private String paqueteDescripcion;
	
	private BigDecimal fecha;
	private BigDecimal hora;
	private String poliza;
	
	public BigDecimal getCliente() {
		return cliente;
	}
	public void setCliente(BigDecimal cliente) {
		this.cliente = cliente;
	}
	public String getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	
	public String getPaqueteDescripcion() {
		return paqueteDescripcion;
	}
	public void setPaqueteDescripcion(String paqueteDescripcion) {
		this.paqueteDescripcion = paqueteDescripcion;
	}
	
	public BigDecimal getFecha() {
		return fecha;
	}
	public void setFecha(BigDecimal fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getHora() {
		return hora;
	}
	public void setHora(BigDecimal hora) {
		this.hora = hora;
	}
	
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getFechaS(){
		return Util.getFechaFormat(fecha.toString());
	}
	public String getHoraS(){
		return Util.getHoraFormat(hora.toString());
	}
	public String getCobertura(){
		String cobertura="";
		cobertura+="Fraude a tarjetas, chequeras y transferencias electrónicas no autorizadas hasta $"+this.getTransferencias()+". ";
		cobertura+="<br/>Compra protegida $"+this.getCompra()+" / robo de efectivo con cargo a las tarjetas amparado por $"+this.getCajero()+"";
		return cobertura;
	}
	public String getFechaA(){
		String sFecha=this.fecha.toString();
		String val=sFecha.substring(0, 4);
		return val;
	}
	public String getFechaA2(){
		String sFecha=this.fecha.toString();
		String val=sFecha.substring(2, 4);
		return val;
	}
	public String getFechaM(){
		String sFecha=this.fecha.toString();
		String val=sFecha.substring(4, 6);
		return val;
	}
	public String getFechaD(){
		String sFecha=this.fecha.toString();
		String val=sFecha.substring(6);
		return val;
	}
	public String getHoraH(){
		String sFecha=this.hora.toString();
		if(sFecha.length()<6)
			sFecha=" "+sFecha;
		String val=sFecha.substring(0,2);
		return val;
	}
	public String getHoraM(){
		String sFecha=this.hora.toString();
		if(sFecha.length()<6)
			sFecha=" "+sFecha;
		String val=sFecha.substring(2,4);
		return val;
	}
	public String getRadio(){
		return "<INPUT TYPE='radio'  NAME='rdoFolio'  ID='rdoFolio' VALUE='" + this.getReferenceNumber() + "' checked/>";
	}
	private String getTransferencias(){
		String tex="";
		if(this.paquete==null || this.paquete.trim().length()==0)
			return "";
		
		switch(Integer.valueOf(paquete)){
		case 1:
			tex="25,000.00";
			break;
		case 2:
			tex="50,000.00";
			break;
		case 3:
			tex="100,000.00";
			break;
		}
		return tex;
	}
	private String getCompra(){
		String tex="";
		if(this.paquete==null || this.paquete.trim().length()==0)
			return "";
		switch(Integer.valueOf(paquete)){
		case 1:
			tex="25,000.00";
			break;
		case 2:
			tex="50,000.00";
			break;
		case 3:
			tex="100,000.00";
			break;
		}
		return tex;
	}
	private String getCajero(){
		String tex="";
		if(this.paquete==null || this.paquete.trim().length()==0)
			return "";
		switch(Integer.valueOf(paquete)){
		case 1:
			tex="5,000.00";
			break;
		case 2:
			tex="5,000.00";
			break;
		case 3:
			tex="5,000.00";
			break;
		}
		return tex;
	}
}
