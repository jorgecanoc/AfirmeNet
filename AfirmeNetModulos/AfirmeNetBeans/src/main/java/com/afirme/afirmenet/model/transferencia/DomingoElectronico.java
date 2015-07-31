package com.afirme.afirmenet.model.transferencia;

import java.util.Date;


public class DomingoElectronico extends TransferenciaBase{
	
	private String programacion;
	private String inicioProgramacion;
	private String finProgramacion;
	private String horaProgramacion;
	private Integer id;	
	private Date fechaOperacion;
	
	
	/**
	 * @return the programacion
	 */
	public String getProgramacion() {
		return programacion;
	}
	/**
	 * @param programacion the programacion to set
	 */
	public void setProgramacion(String programacion) {
		this.programacion = programacion;
	}
	/**
	 * @return the finProgramacion
	 */
	public String getFinProgramacion() {
		return finProgramacion;
	}
	/**
	 * @param finProgramacion the finProgramacion to set
	 */
	public void setFinProgramacion(String finProgramacion) {
		this.finProgramacion = finProgramacion;
	}
	/**
	 * @return the horaProgramacion
	 */
	public String getHoraProgramacion() {
		return horaProgramacion;
	}
	/**
	 * @param horaProgramacion the horaProgramacion to set
	 */
	public void setHoraProgramacion(String horaProgramacion) {
		this.horaProgramacion = horaProgramacion;
	}
	/**
	 * @return the inicioProgramacion
	 */
	public String getInicioProgramacion() {
		return inicioProgramacion;
	}
	/**
	 * @param inicioProgramacion the inicioProgramacion to set
	 */
	public void setInicioProgramacion(String inicioProgramacion) {
		this.inicioProgramacion = inicioProgramacion;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the fechaOperacion
	 */
	public Date getFechaOperacion() {
		return fechaOperacion;
	}
	/**
	 * @param fechaOperacion the fechaOperacion to set
	 */
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	
	
}
