package com.afirme.afirmenet.model.pagos.impuestos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "IDENTIFICACION")
public class Identificacion {

	@XmlElement(required = true, name = "CONCEPTO")
	private List<Concepto> conceptos;

	public List<Concepto> getConceptos() {
		return conceptos;
	}

	public void setConceptos(List<Concepto> conceptos) {
		this.conceptos = conceptos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Identificacion [conceptos=");
		builder.append(conceptos);
		builder.append("]");
		return builder.toString();
	}


}
