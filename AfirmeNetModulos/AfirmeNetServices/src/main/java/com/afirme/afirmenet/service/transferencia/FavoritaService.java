package com.afirme.afirmenet.service.transferencia;

import java.util.List;

import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Favorita;

public interface FavoritaService {
	/**
	 * Metodo que evalua la listra de comprobantes y si el comprobante no tiene
	 * errores y la transferencia fue marcada como agregar en favoritos se
	 * inserta el registro y se marca el comprobante como operacion de favorito,
	 * si esta operacion ya existia en favoritos solo se marca el mismo
	 * 
	 * @param comprobantes
	 */
	public void procesaFavoritas(List<Comprobante> comprobantes);

	/**
	 * Metodo que lista las operaciones favoritas almacenadas de acuerdo al
	 * contrato proporcionado, ademas la opcion de solkicitar el numero de
	 * favoritas en caso de ser 0 retornara todas las encontradas
	 * 
	 * @param contractId
	 * @return
	 */
	public List<Favorita> getFavoritas(String contractId, int cuantas);

	/**
	 * Metodo que actualiza las operaciones favoritas
	 * 
	 * @param contractId
	 * @return
	 */
	public void actualizaFavoritas(List<Favorita> favoritas);
}
