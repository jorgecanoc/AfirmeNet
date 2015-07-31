package com.afirme.afirmenet.ibs.databeans.cardif;

import java.math.BigDecimal;

import com.afirme.afirmenet.ibs.generics.Util;

public class PagoCardif {
	private BigDecimal fecha;
	private BigDecimal hora;
	private String cuenta;
	private BigDecimal importe;
	private String poliza;
	private String estado;
	private String comentario;
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
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFechaS(){
		return Util.getFechaFormat(fecha.toString());
	}
	public String getHoraS(){
		return Util.getHoraFormat(hora.toString());
	}
	public String getStatus(){
		if(comentario==null)
			return "";
		if("PAGO SEGURO FRAUDE".equals(comentario.trim())){
			return "Exitoso";
		}else{
			return "Rechazado";
		}
	}

}
