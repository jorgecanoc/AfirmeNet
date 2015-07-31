package com.afirme.afirmenet.model.pagos.impuestos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

@XmlRootElement(name = "CONCEPTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class Concepto {

	@XmlElement(name = "CLAVE")
	private String clave;

	@XmlElement(name = "DESCRIPCION")
	private String descripcion;

	@XmlElement(name = "VALOR")
	private String valor;

	@XmlElement(name = "VALORIMPRESION")
	private String valorImpresion;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValorImpresion() {
		return valorImpresion;
	}

	public void setValorImpresion(String valorImpresion) {
		this.valorImpresion = valorImpresion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Concepto [clave=");
		builder.append(clave);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", valorImpresion=");
		builder.append(valorImpresion);
		builder.append("]");
		return builder.toString();
	}

	public static Concepto getConcepto(List<Concepto> conceptos, String clave) {
		final String claveFinal = clave;
		Concepto concepto = (Concepto) CollectionUtils.find(conceptos,
				new Predicate() {

					@Override
					public boolean evaluate(Object arg0) {
						Concepto concepto = (Concepto) arg0;
						return concepto.getClave().equals(claveFinal);
					}
				});

		return concepto;
	}

	public static String getValorConcepto(List<Concepto> conceptos, String clave) {
		final String claveFinal = clave;
		String valor = "0";
		Concepto concepto = Concepto.getConcepto(conceptos, claveFinal);
		if (concepto != null) {
			valor = concepto.getValor();
		}
		return valor;
	}
}
