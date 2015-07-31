package com.afirme.afirmenet.model.pagos.impuestos;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

public class Impuesto  extends TransferenciaBase{
	//variables que se llenan con el applet
	private String datosXML;
	private String datos;
	private String datosImpl;
	private String cadenaOriginal;
	
	//Variables que se utilizan en la captura
	private String fechaOperacion;
	private TipoImpuesto tipoImpuesto;
	private Cuenta origen;
	private String contratoId;
	private String nombreCliente;
		
	//variables que se generan en el proceso
	private String nombreORazonSocial;
	private String llavePago;
	private String folioPago;
	private String totalPagado;
	private String certificadoDigital;
	private String cadenaGenerada;
	
	//Diferentes tipos de impuestos
	private Ejercicio ejercicio;
	private Derechos derechos;
	
	//Variable general para todos los conceptos del pago de impuestos
	private List<Conceptos> conceptos;
	private Identificacion identificacion;
	
	
	
	
	private Map<CodigoExcepcion, String> errores;

	/**
	 * @return the datosXML
	 */
	public String getDatosXML() {
		return datosXML;
	}

	/**
	 * @param datosXML
	 *            the datosXML to set
	 */
	public void setDatosXML(String datosXML) {
		this.datosXML = datosXML;
	}

	/**
	 * @return the datos
	 */
	public String getDatos() {
		return datos;
	}

	/**
	 * @param datos
	 *            the datos to set
	 */
	public void setDatos(String datos) {
		this.datos = datos;
	}

	/**
	 * @return the datosImpl
	 */
	public String getDatosImpl() {
		return datosImpl;
	}

	/**
	 * @param datosImpl
	 *            the datosImpl to set
	 */
	public void setDatosImpl(String datosImpl) {
		this.datosImpl = datosImpl;
	}

	/**
	 * @return the cadenaOriginal
	 */
	public String getCadenaOriginal() {
		return cadenaOriginal;
	}

	/**
	 * @param cadenaOriginal
	 *            the cadenaOriginal to set
	 */
	public void setCadenaOriginal(String cadenaOriginal) {
		this.cadenaOriginal = cadenaOriginal;
	}

	/**
	 * @return the fechaOperacion
	 */
	public String getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * @param fechaOperacion
	 *            the fechaOperacion to set
	 */
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	/**
	 * @return the tipoImpuesto
	 */
	public TipoImpuesto getTipoImpuesto() {
		return tipoImpuesto;
	}

	/**
	 * @param tipoImpuesto
	 *            the tipoImpuesto to set
	 */
	public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}

	/**
	 * @return the errores
	 */
	public Map<CodigoExcepcion, String> getErrores() {
		return errores;
	}

	/**
	 * @param errores the errores to set
	 */
	public void setErrores(Map<CodigoExcepcion, String> errores) {
		this.errores = errores;
	}

	/**
	 * @return the origen
	 */
	public Cuenta getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}

	/**
	 * @return the contratoId
	 */
	public String getContratoId() {
		return contratoId;
	}

	/**
	 * @param contratoId the contratoId to set
	 */
	public void setContratoId(String contratoId) {
		this.contratoId = contratoId;
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the nombreORazonSocial
	 */
	public String getNombreORazonSocial() {
		return nombreORazonSocial;
	}

	/**
	 * @param nombreORazonSocial the nombreORazonSocial to set
	 */
	public void setNombreORazonSocial(String nombreORazonSocial) {
		this.nombreORazonSocial = nombreORazonSocial;
	}

	/**
	 * @return the llavePago
	 */
	public String getLlavePago() {
		return llavePago;
	}

	/**
	 * @param llavePago the llavePago to set
	 */
	public void setLlavePago(String llavePago) {
		this.llavePago = llavePago;
	}


	/**
	 * @return the totalPagado
	 */
	public String getTotalPagado() {
		return totalPagado;
	}

	/**
	 * @param totalPagado the totalPagado to set
	 */
	public void setTotalPagado(String totalPagado) {
		this.totalPagado = totalPagado;
	}

	/**
	 * @return the ejercicio
	 */
	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	/**
	 * @param ejercicio the ejercicio to set
	 */
	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	/**
	 * @return the derechos
	 */
	public Derechos getDerechos() {
		return derechos;
	}

	/**
	 * @param derechos the derechos to set
	 */
	public void setDerechos(Derechos derechos) {
		this.derechos = derechos;
	}

	/**
	 * @return the certificadoDigital
	 */
	public String getCertificadoDigital() {
		return certificadoDigital;
	}

	/**
	 * @param certificadoDigital the certificadoDigital to set
	 */
	public void setCertificadoDigital(String certificadoDigital) {
		this.certificadoDigital = certificadoDigital;
	}

	/**
	 * @return the folioPago
	 */
	public String getFolioPago() {
		return folioPago;
	}

	/**
	 * @param folioPago the folioPago to set
	 */
	public void setFolioPago(String folioPago) {
		this.folioPago = folioPago;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Impuesto [datosXML=");
		builder.append(datosXML);
		builder.append(", datos=");
		builder.append(datos);
		builder.append(", datosImpl=");
		builder.append(datosImpl);
		builder.append(", cadenaOriginal=");
		builder.append(cadenaOriginal);
		builder.append(", fechaOperacion=");
		builder.append(fechaOperacion);
		builder.append(", tipoImpuesto=");
		builder.append(tipoImpuesto);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", contratoId=");
		builder.append(contratoId);
		builder.append(", nombreCliente=");
		builder.append(nombreCliente);
		builder.append(", nombreORazonSocial=");
		builder.append(nombreORazonSocial);
		builder.append(", llavePago=");
		builder.append(llavePago);
		builder.append(", folioPago=");
		builder.append(folioPago);
		builder.append(", totalPagado=");
		builder.append(totalPagado);
		builder.append(", certificadoDigital=");
		builder.append(certificadoDigital);
		builder.append(", ejercicio=");
		builder.append(ejercicio);
		builder.append(", derechos=");
		builder.append(derechos);
		builder.append(", errores=");
		builder.append(errores);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the conceptos
	 */
	public List<Conceptos> getConceptos() {
		return conceptos;
	}

	/**
	 * @param conceptos the conceptos to set
	 */
	public void setConceptos(List<Conceptos> conceptos) {
		this.conceptos = conceptos;
	}

	/**
	 * @return the cadenaGenerada
	 */
	public String getCadenaGenerada() {
		return cadenaGenerada;
	}

	/**
	 * @param cadenaGenerada the cadenaGenerada to set
	 */
	public void setCadenaGenerada(String cadenaGenerada) {
		this.cadenaGenerada = cadenaGenerada;
	}

	/**
	 * @return the identificacion
	 */
	public Identificacion getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}


}
