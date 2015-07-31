package com.afirme.afirmenet.model.pagos.impuestos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DERECHOS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Derechos {

	@XmlElement(required = true, name = "CONCEPTOS")
	private List<Conceptos> conceptos;

	@XmlElement(required = true, name = "IDENTIFICACION")
	private Identificacion identificacion;

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

	/**
	 * @return the identificacion
	 */
	public Identificacion getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Derechos [conceptos=");
		builder.append(conceptos);
		builder.append(", identificacion=");
		builder.append(identificacion);
		builder.append("]");
		return builder.toString();
	}
}
