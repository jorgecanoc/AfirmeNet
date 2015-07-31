package com.afirme.afirmenet.web.model;

import java.util.List;

import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Favorita;

public class FavoritasModel {
	private List<Favorita> favoritas;
	private List<Comprobante> comprobantes;

	/**
	 * @return the favoritas
	 */
	public List<Favorita> getFavoritas() {
		return favoritas;
	}

	/**
	 * @param favoritas
	 *            the favoritas to set
	 */
	public void setFavoritas(List<Favorita> favoritas) {
		this.favoritas = favoritas;
	}

	/**
	 * @return the comprobantes
	 */
	public List<Comprobante> getComprobantes() {
		return comprobantes;
	}

	/**
	 * @param comprobantes the comprobantes to set
	 */
	public void setComprobantes(List<Comprobante> comprobantes) {
		this.comprobantes = comprobantes;
	}

}
