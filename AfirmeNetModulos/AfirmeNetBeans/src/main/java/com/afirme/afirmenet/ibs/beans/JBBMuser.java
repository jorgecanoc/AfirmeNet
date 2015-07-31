package com.afirme.afirmenet.ibs.beans;

public class JBBMuser {

	private String estatus = "";
	private String sesion;
	private String fechaLogIn;
	private String horaLogIn;
	private String fechaTrx;
	private String horaTrx;
	private int espera;
	private boolean activo;
	
	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getSesion() {
		return sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public String getFechaLogIn() {
		return fechaLogIn;
	}

	public void setFechaLogIn(String fechaLogIn) {
		this.fechaLogIn = fechaLogIn;
	}

	public String getHoraLogIn() {
		return horaLogIn;
	}

	public void setHoraLogIn(String horaLogIn) {
		this.horaLogIn = horaLogIn;
	}

	public String getFechaTrx() {
		return fechaTrx;
	}

	public void setFechaTrx(String fechaTrx) {
		this.fechaTrx = fechaTrx;
	}

	public String getHoraTrx() {
		return horaTrx;
	}

	public void setHoraTrx(String horaTrx) {
		this.horaTrx = horaTrx;
	}

	public int getEspera() {
		return espera;
	}

	public void setEspera(int espera) {
		this.espera = espera;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
