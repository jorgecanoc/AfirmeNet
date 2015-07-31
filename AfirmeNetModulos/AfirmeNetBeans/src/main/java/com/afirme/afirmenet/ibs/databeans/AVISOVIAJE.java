package com.afirme.afirmenet.ibs.databeans;

import java.util.Vector;

@SuppressWarnings("rawtypes")
public class AVISOVIAJE {

	private int row;
	private int currentRow;
	private Vector noTarjeta;
	private Vector tarjetaHabiente;
	private Vector tipoTarjeta;
	private String pais;
	private String ciudad;
	private String fechaInicio;
	private String fechaFinal;
	private String telefono;
	private String comentarios;
	private String tarjetas;
	private String fechaReg;
	private String horaReg;
	private String refNum;
	private String contrato;
	private String usuario;

	public AVISOVIAJE() {
	}

	@SuppressWarnings("unchecked")
	public void addRowC(String pnoTarjeta, String ptarjetaHabiente,
			String ptipoTarjeta) {

		noTarjeta.addElement(pnoTarjeta);
		tarjetaHabiente.addElement(ptarjetaHabiente);
		tipoTarjeta.addElement(ptipoTarjeta);

		// System.out.println("Rowa:"+row);
		row++;

	}

	public boolean getNextRowC() {
		currentRow++;
		return (currentRow < row);
	}

	public void initC() {

		this.noTarjeta = new Vector();
		this.tarjetaHabiente = new Vector();
		this.tipoTarjeta = new Vector();

		row = 0;
	}

	public void initRowC() {
		currentRow = -1;
	}

	public int getRow() {
		return row;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public Vector getNoTarjeta() {
		return noTarjeta;
	}

	public void setNoTarjeta(Vector noTarjeta) {
		this.noTarjeta = noTarjeta;
	}

	public Vector getTarjetaHabiente() {
		return tarjetaHabiente;
	}

	public void setTarjetaHabiente(Vector tarjetaHabiente) {
		this.tarjetaHabiente = tarjetaHabiente;
	}

	public Vector getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(Vector tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(String tarjetas) {
		this.tarjetas = tarjetas;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getHoraReg() {
		return horaReg;
	}

	public void setHoraReg(String horaReg) {
		this.horaReg = horaReg;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
