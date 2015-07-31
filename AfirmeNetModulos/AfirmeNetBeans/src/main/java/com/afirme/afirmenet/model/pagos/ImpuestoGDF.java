package com.afirme.afirmenet.model.pagos;

import java.text.DecimalFormat;

import com.afirme.afirmenet.enums.ConceptoGDF;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

public class ImpuestoGDF extends TransferenciaBase {
	
	private String lineaCaptura;
	private String lineaCapturaBase;
	private ConceptoGDF conceptoGDF;
	// Atributos para el Recibo de Pago de Impuesto GDF
	private String nombre;
	private String domicilio;
	private String colonia;
	private String codigoPostal;
	private String delegacion;
	private String estado;
	// Atributos de la Tabla: Tesoreria Concepto (TESCPTOPF)
	private int idGrupo;
	private int idClave;
	private String concepto;
	private double importe;
	private String nombreGrupo;
	private char tipoTarifa;
	private String leyenda;
	// LICENCIA_CONDUCIR
	private String periodo;
	private String tipoLicencia;
	private String rfc;
	// TRAM_VEHICULAR, MULTA_REV_VEHICULAR, TENENCIA, MEDIO_AMB_VERFIC_EXTEMP
	private String claveMarca;
	private String marca;
	private String subMarca;
	private String origenTramite;
	private String origenTramiteDescripcion;
	private String modelo;
	private String placa;
	private double valorFactura;
	private int cilindros;
	// MULTA_INFRACCION
	private Long folioInfraccion;
	// MEDIO_AMBIENTE_CONTAM
	private int anioInfraccion;
	// MEDIO_AMBIENTE_HOLOGR
	private int claveVerificacion;
	private String tipoHolograma;
	private int cantidad;
	private long folio;
	// REGISTRO_CIVIL, REGISTRO_CIVIL_BUSQUEDA
	private double precioUnitario;
	// SERVICIO_POLICIA
	private long folioFactura;
	// IMP_PREDIAL
	private String cuentaPredial;
	// SUMINISTRO_AGUA
	private int ejercicio;
	private String bimestre;
	private String cuentaAgua;
	// IMP_NOMINA, IMP_RIFAS, IMP_HOSPEDAJE, AUTO_NUEVO
	private String mes;
	private double remuneracionesPagadas;
	private int numeroTrabajadores;
	private String fechaEvento;
	// IMP_INMUEBLES
	private String tipoOperacion;
	private String fechaEscrituras;
	// REGISTRO_PUBLICO
	private String tramite;
	private String numeroEscritura;
	// ISR_ENAJENACION
	private String subConcepto;
	private String claveSubConcepto;
	private String tipoDeclaracion;
	private String claveTipoDeclaracion;
	private String vigencia;
	private int numeroNotario;
	// PAGOS_TESORERIA
	private String referenciaPago;
	private String adminTributaria;
	private String claveAdminTributaria;
	private String conceptoPagoTesoreria;
	
	private static final String NUMBER_FORMAT = "###,###,###.00";
	
	public String getAmountFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(super.getAmount().doubleValue());
	}
	
	public String getImporteFormatted() {
		DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
		return decimalFormat.format(getImporte());
	}

	/**
	 * @return the lineaCaptura
	 */
	public String getLineaCaptura() {
		return lineaCaptura;
	}

	/**
	 * @param lineaCaptura the lineaCaptura to set
	 */
	public void setLineaCaptura(String lineaCaptura) {
		this.lineaCaptura = lineaCaptura;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the delegacion
	 */
	public String getDelegacion() {
		return delegacion;
	}

	/**
	 * @param delegacion the delegacion to set
	 */
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the numeroEscritura
	 */
	public String getNumeroEscritura() {
		return numeroEscritura;
	}

	/**
	 * @param numeroEscritura the numeroEscritura to set
	 */
	public void setNumeroEscritura(String numeroEscritura) {
		this.numeroEscritura = numeroEscritura;
	}

	/**
	 * @return the idGrupo
	 */
	public int getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	/**
	 * @return the idClave
	 */
	public int getIdClave() {
		return idClave;
	}

	/**
	 * @param idClave the idClave to set
	 */
	public void setIdClave(int idClave) {
		this.idClave = idClave;
	}

	/**
	 * @return the concepto
	 */
	public String getConcepto() {
		return concepto;
	}

	/**
	 * @param concepto the concepto to set
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @return the tipoTarifa
	 */
	public char getTipoTarifa() {
		return tipoTarifa;
	}

	/**
	 * @param tipoTarifa the tipoTarifa to set
	 */
	public void setTipoTarifa(char tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}

	/**
	 * @return the leyenda
	 */
	public String getLeyenda() {
		return leyenda;
	}

	/**
	 * @param leyenda the leyenda to set
	 */
	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the tipoLicencia
	 */
	public String getTipoLicencia() {
		return tipoLicencia;
	}

	/**
	 * @param tipoLicencia the tipoLicencia to set
	 */
	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the claveMarca
	 */
	public String getClaveMarca() {
		return claveMarca;
	}

	/**
	 * @param claveMarca the claveMarca to set
	 */
	public void setClaveMarca(String claveMarca) {
		this.claveMarca = claveMarca;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the origen
	 */
	public String getOrigenTramite() {
		return origenTramite;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigenTramite(String origenTramite) {
		this.origenTramite = origenTramite;
	}

	/**
	 * @return the origenDescripcion
	 */
	public String getOrigenTramiteDescripcion() {
		return origenTramiteDescripcion;
	}

	/**
	 * @param origenDescripcion the origenDescripcion to set
	 */
	public void setOrigenTramiteDescripcion(String origenTramiteDescripcion) {
		this.origenTramiteDescripcion = origenTramiteDescripcion;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the folioInfraccion
	 */
	public Long getFolioInfraccion() {
		return folioInfraccion;
	}

	/**
	 * @param folioInfraccion the folioInfraccion to set
	 */
	public void setFolioInfraccion(Long folioInfraccion) {
		this.folioInfraccion = folioInfraccion;
	}

	/**
	 * @return the anioInfraccion
	 */
	public int getAnioInfraccion() {
		return anioInfraccion;
	}

	/**
	 * @param anioInfraccion the anioInfraccion to set
	 */
	public void setAnioInfraccion(int anioInfraccion) {
		this.anioInfraccion = anioInfraccion;
	}

	/**
	 * @return the claveVerificacion
	 */
	public int getClaveVerificacion() {
		return claveVerificacion;
	}

	/**
	 * @param claveVerificacion the claveVerificacion to set
	 */
	public void setClaveVerificacion(int claveVerificacion) {
		this.claveVerificacion = claveVerificacion;
	}

	/**
	 * @return the tipoHolograma
	 */
	public String getTipoHolograma() {
		return tipoHolograma;
	}

	/**
	 * @param tipoHolograma the tipoHolograma to set
	 */
	public void setTipoHolograma(String tipoHolograma) {
		this.tipoHolograma = tipoHolograma;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the folio
	 */
	public long getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(long folio) {
		this.folio = folio;
	}

	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the folioFactura
	 */
	public long getFolioFactura() {
		return folioFactura;
	}

	/**
	 * @param folioFactura the folioFactura to set
	 */
	public void setFolioFactura(long folioFactura) {
		this.folioFactura = folioFactura;
	}

	/**
	 * @return the cuentaPredial
	 */
	public String getCuentaPredial() {
		return cuentaPredial;
	}

	/**
	 * @param cuentaPredial the cuentaPredial to set
	 */
	public void setCuentaPredial(String cuentaPredial) {
		this.cuentaPredial = cuentaPredial;
	}

	/**
	 * @return the ejercicio
	 */
	public int getEjercicio() {
		return ejercicio;
	}

	/**
	 * @param ejercicio the ejercicio to set
	 */
	public void setEjercicio(int ejercicio) {
		this.ejercicio = ejercicio;
	}

	/**
	 * @return the bimestre
	 */
	public String getBimestre() {
		return bimestre;
	}

	/**
	 * @param bimestre the bimestre to set
	 */
	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * @return the tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	/**
	 * @return the tramite
	 */
	public String getTramite() {
		return tramite;
	}

	/**
	 * @param tramite the tramite to set
	 */
	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	/**
	 * @return the subConcepto
	 */
	public String getSubConcepto() {
		return subConcepto;
	}

	/**
	 * @param subConcepto the subConcepto to set
	 */
	public void setSubConcepto(String subConcepto) {
		this.subConcepto = subConcepto;
	}

	/**
	 * @return the claveSubConcepto
	 */
	public String getClaveSubConcepto() {
		return claveSubConcepto;
	}

	/**
	 * @param claveSubConcepto the claveSubConcepto to set
	 */
	public void setClaveSubConcepto(String claveSubConcepto) {
		this.claveSubConcepto = claveSubConcepto;
	}

	/**
	 * @return the tipoDeclaracion
	 */
	public String getTipoDeclaracion() {
		return tipoDeclaracion;
	}

	/**
	 * @param tipoDeclaracion the tipoDeclaracion to set
	 */
	public void setTipoDeclaracion(String tipoDeclaracion) {
		this.tipoDeclaracion = tipoDeclaracion;
	}

	/**
	 * @return the claveTipoDeclaracion
	 */
	public String getClaveTipoDeclaracion() {
		return claveTipoDeclaracion;
	}

	/**
	 * @param claveTipoDeclaracion the claveTipoDeclaracion to set
	 */
	public void setClaveTipoDeclaracion(String claveTipoDeclaracion) {
		this.claveTipoDeclaracion = claveTipoDeclaracion;
	}

	/**
	 * @return the vigencia
	 */
	public String getVigencia() {
		return vigencia;
	}

	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	/**
	 * @return the referenciaPago
	 */
	public String getReferenciaPago() {
		return referenciaPago;
	}

	/**
	 * @param referenciaPago the referenciaPago to set
	 */
	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}

	/**
	 * @return the adminTributaria
	 */
	public String getAdminTributaria() {
		return adminTributaria;
	}

	/**
	 * @param adminTributaria the adminTributaria to set
	 */
	public void setAdminTributaria(String adminTributaria) {
		this.adminTributaria = adminTributaria;
	}

	/**
	 * @return the claveAdminTributaria
	 */
	public String getClaveAdminTributaria() {
		return claveAdminTributaria;
	}

	/**
	 * @param claveAdminTributaria the claveAdminTributaria to set
	 */
	public void setClaveAdminTributaria(String claveAdminTributaria) {
		this.claveAdminTributaria = claveAdminTributaria;
	}

	/**
	 * @return the conceptoPagoTesoreria
	 */
	public String getConceptoPagoTesoreria() {
		return conceptoPagoTesoreria;
	}

	/**
	 * @param conceptoPagoTesoreria the conceptoPagoTesoreria to set
	 */
	public void setConceptoPagoTesoreria(String conceptoPagoTesoreria) {
		this.conceptoPagoTesoreria = conceptoPagoTesoreria;
	}

	/**
	 * @return the conceptoGDF
	 */
	public ConceptoGDF getConceptoGDF() {
		return conceptoGDF;
	}

	/**
	 * @param conceptoGDF the conceptoGDF to set
	 */
	public void setConceptoGDF(ConceptoGDF conceptoGDF) {
		this.conceptoGDF = conceptoGDF;
	}

	/**
	 * @return the lineaCapturaBase
	 */
	public String getLineaCapturaBase() {
		return lineaCapturaBase;
	}

	/**
	 * @param lineaCapturaBase the lineaCapturaBase to set
	 */
	public void setLineaCapturaBase(String lineaCapturaBase) {
		this.lineaCapturaBase = lineaCapturaBase;
	}
	
	public String printOut() {
		StringBuilder build = new StringBuilder();
		build.append("ImpuestoGDF [\n");
		build.append("LineaCaptura = " + getLineaCaptura() + "\n");
		build.append("LineaCapturaBase = " + getLineaCapturaBase() + "\n");
		build.append("ConceptoGDF = " + getConceptoGDF() + "\n");
		build.append("Nombre = " + getNombre() + "\n");
		build.append("Domicilio = " + getDomicilio() + "\n");
		build.append("Colonia = " + getColonia() + "\n");
		build.append("CodigoPostal = " + getCodigoPostal() + "\n");
		build.append("Delegacion = " + getDelegacion() + "\n");
		build.append("Estado = " + getEstado() + "\n");
		build.append("NumeroEscritura = " + getNumeroEscritura() + "\n");
		build.append("IdGrupo = " + getIdGrupo() + "\n");
		build.append("IdClave = " + getIdClave() + "\n");
		build.append("Concepto = " + getConcepto() + "\n");
		build.append("Importe = " + getImporte() + "\n");
		build.append("NombreGrupo = " + getNombreGrupo() + "\n");
		build.append("TipoTarifa = " + getTipoTarifa() + "\n");
		build.append("Leyenda = " + getLeyenda() + "\n");
		build.append("Periodo = " + getPeriodo() + "\n");
		build.append("TipoLicencia = " + getTipoLicencia() + "\n");
		build.append("Rfc = " + getRfc() + "\n");
		build.append("ClaveMarca = " + getClaveMarca() + "\n");
		build.append("Marca = " + getMarca() + "\n");
		build.append("OrigenTramite = " + getOrigenTramite() + "\n");
		build.append("OrigenTramiteDescripcion = " + getOrigenTramiteDescripcion() + "\n");
		build.append("Modelo = " + getModelo() + "\n");
		build.append("Placa = " + getPlaca() + "\n");
		build.append("FolioInfraccion = " + getFolioInfraccion() + "\n");
		build.append("AnioInfraccion = " + getAnioInfraccion() + "\n");
		build.append("ClaveVerificacion = " + getClaveVerificacion() + "\n");
		build.append("TipoHolograma = " + getTipoHolograma() + "\n");
		build.append("Cantidad = " + getCantidad() + "\n");
		build.append("Folio = " + getFolio() + "\n");
		build.append("PrecioUnitario = " + getPrecioUnitario() + "\n");
		build.append("FolioFactura = " + getFolioFactura() + "\n");
		build.append("CuentaPredial = " + getCuentaPredial() + "\n");
		build.append("Ejercicio = " + getEjercicio() + "\n");
		build.append("Bimestre = " + getBimestre() + "\n");
		build.append("Mes = " + getMes() + "\n");
		build.append("TipoOperacion = " + getTipoOperacion() + "\n");
		build.append("Tramite = " + getTramite() + "\n");
		build.append("SubConcepto = " + getSubConcepto() + "\n");
		build.append("ClaveSubConcepto = " + getClaveSubConcepto() + "\n");
		build.append("TipoDeclaracion = " + getTipoDeclaracion() + "\n");
		build.append("ClaveTipoDeclaracion = " + getClaveTipoDeclaracion() + "\n");
		build.append("Vigencia = " + getVigencia() + "\n");
		build.append("ReferenciaPago = " + getReferenciaPago() + "\n");
		build.append("AdminTributaria = " + getAdminTributaria() + "\n");
		build.append("ClaveAdminTributaria = " + getClaveAdminTributaria() + "\n");
		build.append("ConceptoPagoTesoreria = " + getConceptoPagoTesoreria() + "\n");
		build.append("]\n");
		System.out.println(build);
		return null;
	}

	/**
	 * @return the subMarca
	 */
	public String getSubMarca() {
		return subMarca;
	}

	/**
	 * @param subMarca the subMarca to set
	 */
	public void setSubMarca(String subMarca) {
		this.subMarca = subMarca;
	}

	/**
	 * @return the valorFactura
	 */
	public double getValorFactura() {
		return valorFactura;
	}

	/**
	 * @param valorFactura the valorFactura to set
	 */
	public void setValorFactura(double valorFactura) {
		this.valorFactura = valorFactura;
	}

	/**
	 * @return the cilindros
	 */
	public int getCilindros() {
		return cilindros;
	}

	/**
	 * @param cilindro the cilindros to set
	 */
	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}

	/**
	 * @return the cuentaAgua
	 */
	public String getCuentaAgua() {
		return cuentaAgua;
	}

	/**
	 * @param cuentaAgua the cuentaAgua to set
	 */
	public void setCuentaAgua(String cuentaAgua) {
		this.cuentaAgua = cuentaAgua;
	}

	/**
	 * @return the remuneracionesPagadas
	 */
	public double getRemuneracionesPagadas() {
		return remuneracionesPagadas;
	}

	/**
	 * @param remuneracionesPagadas the remuneracionesPagadas to set
	 */
	public void setRemuneracionesPagadas(double remuneracionesPagadas) {
		this.remuneracionesPagadas = remuneracionesPagadas;
	}

	/**
	 * @return the numeroTrabajadores
	 */
	public int getNumeroTrabajadores() {
		return numeroTrabajadores;
	}

	/**
	 * @param numeroTrabajadores the numeroTrabajadores to set
	 */
	public void setNumeroTrabajadores(int numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}

	/**
	 * @return the fechaEvento
	 */
	public String getFechaEvento() {
		return fechaEvento;
	}

	/**
	 * @param fechaEvento the fechaEvento to set
	 */
	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	/**
	 * @return the numeroNotario
	 */
	public int getNumeroNotario() {
		return numeroNotario;
	}

	/**
	 * @param numeroNotario the numeroNotario to set
	 */
	public void setNumeroNotario(int numeroNotario) {
		this.numeroNotario = numeroNotario;
	}

	/**
	 * @return the fechaEscrituras
	 */
	public String getFechaEscrituras() {
		return fechaEscrituras;
	}

	/**
	 * @param fechaEscrituras the fechaEscrituras to set
	 */
	public void setFechaEscrituras(String fechaEscrituras) {
		this.fechaEscrituras = fechaEscrituras;
	}

}
