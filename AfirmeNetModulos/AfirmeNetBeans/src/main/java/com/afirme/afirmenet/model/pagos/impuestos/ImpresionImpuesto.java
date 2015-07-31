package com.afirme.afirmenet.model.pagos.impuestos;

import java.util.List;

public class ImpresionImpuesto {
	// Variables de impresion
	private String contratoId;
	private String usuario;
	private String operacion;
	private String cuentaCargo;
	private String nombreCliente;
	private String companiaAPagar;
	private String rfc;
	private String nombreRazonSocial;
	private String fechaHoraPago;
	private String numeroOperacion;
	private String llavePago;
	private String totalEfectivamentePagado;
	private String dependencia;
	private List<Conceptos> conceptos;

	/**
	 * Constructor que permite generar una instancia de impresion en base a un
	 * pago del ejercicio
	 * 
	 * @param derechos
	 */
	public ImpresionImpuesto(Ejercicio ejercicio, String contratoId,
			String usuario, String cuentaCargo, String nombreCliente) {
		this.contratoId = contratoId;
		this.usuario = usuario;
		this.cuentaCargo = cuentaCargo;
		this.nombreCliente = nombreCliente;
		if (ejercicio != null) {

			Concepto nombre = Concepto.getConcepto(ejercicio
					.getIdentificacion().getConceptos(),
					ConceptosImpuestosIdentificacion.NOMBRE.getValor());
			Concepto paterno = Concepto
					.getConcepto(ejercicio.getIdentificacion().getConceptos(),
							ConceptosImpuestosIdentificacion.APELLIDO_PATERNO
									.getValor());
			Concepto materno = Concepto
					.getConcepto(ejercicio.getIdentificacion().getConceptos(),
							ConceptosImpuestosIdentificacion.APELLIDO_MATERNO
									.getValor());

			String nombreCompleto = paterno.getValorImpresion() + " "
					+ materno.getValorImpresion() + " "
					+ nombre.getValorImpresion();

			this.nombreRazonSocial = nombreCompleto;
			this.totalEfectivamentePagado = Concepto.getConcepto(
					ejercicio.getIdentificacion().getConceptos(),
					ConceptosImpuestosIdentificacion.TOTAL_EFECTIVAMENTE_PAGADO
							.getValor()).getValorImpresion();
			this.rfc = Concepto.getConcepto(
					ejercicio.getIdentificacion().getConceptos(),
					ConceptosImpuestosIdentificacion.RFC.getValor())
					.getValorImpresion();
			
			setConceptos(ejercicio.getConceptos());
		}
	}

	/**
	 * Constructor que permite generar una instancia de impresion en base a un
	 * pago de derechos
	 * 
	 * @param derechos
	 */
	public ImpresionImpuesto(Derechos derechos, String contratoId,
			String usuario, String cuentaCargo, String nombreCliente) {
		this.contratoId = contratoId;
		this.usuario = usuario;
		this.cuentaCargo = cuentaCargo;
		this.nombreCliente = nombreCliente;
		if (derechos != null) {
			// Se obtiene los datos del objeto de derechos
			this.totalEfectivamentePagado = Concepto.getConcepto(
					derechos.getIdentificacion().getConceptos(),
					ConceptosImpuestosIdentificacion.TOTAL_EFECTIVAMENTE_PAGADO
							.getValor()).getValorImpresion();
			this.dependencia = Concepto.getConcepto(
					derechos.getIdentificacion().getConceptos(),
					ConceptosImpuestosPagoDerechos.DEPENDENCIA.getValor())
					.getValorImpresion();
			this.nombreRazonSocial = Concepto.getConcepto(
					derechos.getIdentificacion().getConceptos(),
					ConceptosImpuestosIdentificacion.DENOMINACION.getValor())
					.getValorImpresion();
			this.rfc = Concepto.getConcepto(
					derechos.getIdentificacion().getConceptos(),
					ConceptosImpuestosIdentificacion.RFC.getValor())
					.getValorImpresion();
			setConceptos(derechos.getConceptos());
		}
	}

	/**
	 * @return the contratoId
	 */
	public String getContratoId() {
		return contratoId;
	}

	/**
	 * @param contratoId
	 *            the contratoId to set
	 */
	public void setContratoId(String contratoId) {
		this.contratoId = contratoId;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion
	 *            the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * @return the cuentaCargo
	 */
	public String getCuentaCargo() {
		return cuentaCargo;
	}

	/**
	 * @param cuentaCargo
	 *            the cuentaCargo to set
	 */
	public void setCuentaCargo(String cuentaCargo) {
		this.cuentaCargo = cuentaCargo;
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente
	 *            the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the companiaAPagar
	 */
	public String getCompaniaAPagar() {
		return companiaAPagar;
	}

	/**
	 * @param companiaAPagar
	 *            the companiaAPagar to set
	 */
	public void setCompaniaAPagar(String companiaAPagar) {
		this.companiaAPagar = companiaAPagar;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the nombreRazonSocial
	 */
	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}

	/**
	 * @param nombreRazonSocial
	 *            the nombreRazonSocial to set
	 */
	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}

	/**
	 * @return the fechaHoraPago
	 */
	public String getFechaHoraPago() {
		return fechaHoraPago;
	}

	/**
	 * @param fechaHoraPago
	 *            the fechaHoraPago to set
	 */
	public void setFechaHoraPago(String fechaHoraPago) {
		this.fechaHoraPago = fechaHoraPago;
	}

	/**
	 * @return the numeroOperacion
	 */
	public String getNumeroOperacion() {
		return numeroOperacion;
	}

	/**
	 * @param numeroOperacion
	 *            the numeroOperacion to set
	 */
	public void setNumeroOperacion(String numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}

	/**
	 * @return the llavePago
	 */
	public String getLlavePago() {
		return llavePago;
	}

	/**
	 * @param llavePago
	 *            the llavePago to set
	 */
	public void setLlavePago(String llavePago) {
		this.llavePago = llavePago;
	}

	/**
	 * @return the totalEfectivamentePagado
	 */
	public String getTotalEfectivamentePagado() {
		return totalEfectivamentePagado;
	}

	/**
	 * @param totalEfectivamentePagado
	 *            the totalEfectivamentePagado to set
	 */
	public void setTotalEfectivamentePagado(String totalEfectivamentePagado) {
		this.totalEfectivamentePagado = totalEfectivamentePagado;
	}

	/**
	 * @return the dependencia
	 */
	public String getDependencia() {
		return dependencia;
	}

	/**
	 * @param dependencia
	 *            the dependencia to set
	 */
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	/**
	 * @return the conceptos
	 */
	public List<Conceptos> getConceptos() {
		return conceptos;
	}

	/**
	 * @param conceptos
	 *            the conceptos to set
	 */
	public void setConceptos(List<Conceptos> conceptos) {
		this.conceptos = conceptos;
	}

}
