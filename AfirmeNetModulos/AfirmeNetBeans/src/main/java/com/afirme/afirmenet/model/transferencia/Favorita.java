package com.afirme.afirmenet.model.transferencia;


public class Favorita extends TransferenciaBase {
	private String numeroServicio;
	private Integer ordenFavorito;
	private boolean ejecutar;

	/**
	 * @return the numeroServicio
	 */
	public String getNumeroServicio() {
		return numeroServicio;
	}

	/**
	 * @param numeroServicio
	 *            the numeroServicio to set
	 */
	public void setNumeroServicio(String numeroServicio) {
		this.numeroServicio = numeroServicio;
	}

	/**
	 * @return the ordenFavorito
	 */
	public Integer getOrdenFavorito() {
		return ordenFavorito;
	}

	/**
	 * @param ordenFavorito
	 *            the ordenFavorito to set
	 */
	public void setOrdenFavorito(Integer ordenFavorito) {
		this.ordenFavorito = ordenFavorito;
	}


	/**
	 * @return the ejecutar
	 */
	public boolean isEjecutar() {
		return ejecutar;
	}

	/**
	 * @param ejecutar the ejecutar to set
	 */
	public void setEjecutar(boolean ejecutar) {
		this.ejecutar = ejecutar;
	}

}
