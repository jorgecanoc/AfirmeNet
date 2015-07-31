package com.afirme.afirmenet.model;

import java.math.BigDecimal;
import java.util.Date;

import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.model.base.ModelBase;

public class DCMessageIni implements ModelBase {

	/**
	 * Clase de transporte que mapea la informacion de la tabla DC_MSGINI en la
	 * BD de DB2
	 * 
	 * @author jorge.canoc@gmail.com
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal idMsg;
	private String title;
	private String message;
	private TipoCliente tipoCliente;
	private Date startDate;
	private Date finalDate;
	private TipoPublicidad tipoPublicidad;
	private String tipoProducto;
	private String frecuencia;
	private Estatus estatus;
	private String saludo;
	private String imagen;
	private String accion;
	private String terminos;
	private String textoAlConfirmar;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public enum TipoPublicidad {
		IMAGEN("img"), TEXTO("text"), AMBAS("img/text");
		private String value;

		TipoPublicidad(String value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		public static TipoPublicidad getNameByValue(String value) {
			TipoPublicidad obj = null;
			for (TipoPublicidad item : TipoPublicidad.values()) {
				if (value.equals(item.getValue())) {
					obj = item;
					break;
				}
			}
			return obj;
		}

	}

	public enum TipoAviso {
		AVISO(1), CAMPANIA(2);
		private int value;

		TipoAviso(int value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}

		public static TipoAviso getNameByValue(String value) {
			TipoAviso obj = null;
			for (TipoAviso item : TipoAviso.values()) {
				if (value.equals(item.getValue())) {
					obj = item;
					break;
				}
			}
			return obj;
		}

	}

	public enum Estatus {
		ACTIVO("A"), CANCELADO("C");
		private String value;

		Estatus(String value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		public static Estatus getNameByValue(String value) {
			Estatus estatus = null;
			for (Estatus item : Estatus.values()) {
				if (value.equals(item.getValue())) {
					estatus = item;
					break;
				}
			}
			return estatus;
		}

	}

	/**
	 * @return the idMsg
	 */
	public BigDecimal getIdMsg() {
		return idMsg;
	}

	/**
	 * @param idMsg
	 *            the idMsg to set
	 */
	public void setIdMsg(BigDecimal idMsg) {
		this.idMsg = idMsg;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the tipoCliente
	 */
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * @param tipoCliente
	 *            the tipoCliente to set
	 */
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the finalDate
	 */
	public Date getFinalDate() {
		return finalDate;
	}

	/**
	 * @param finalDate
	 *            the finalDate to set
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	/**
	 * @return the tipoPublicidad
	 */
	public TipoPublicidad getTipoPublicidad() {
		return tipoPublicidad;
	}

	/**
	 * @param tipoPublicidad
	 *            the tipoPublicidad to set
	 */
	public void setTipoPublicidad(TipoPublicidad tipoPublicidad) {
		this.tipoPublicidad = tipoPublicidad;
	}

	/**
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * @param tipoProducto
	 *            the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	/**
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * @param frecuencia
	 *            the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * @return the estatus
	 */
	public Estatus getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus
	 *            the estatus to set
	 */
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the saludo
	 */
	public String getSaludo() {
		return saludo;
	}

	/**
	 * @param saludo
	 *            the saludo to set
	 */
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion
	 *            the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * @return the terminos
	 */
	public String getTerminos() {
		if(terminos==null)
			return "";
		return terminos;
	}

	/**
	 * @param terminos
	 *            the terminos to set
	 */
	public void setTerminos(String terminos) {
		this.terminos = terminos;
	}

	/**
	 * @return the textoAlConfirmar
	 */
	public String getTextoAlConfirmar() {
		return textoAlConfirmar;
	}

	/**
	 * @param textoAlConfirmar
	 *            the textoAlConfirmar to set
	 */
	public void setTextoAlConfirmar(String textoAlConfirmar) {
		this.textoAlConfirmar = textoAlConfirmar;
	}

}
