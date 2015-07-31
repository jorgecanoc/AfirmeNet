package com.afirme.afirmenet.dao.transferencia;

import java.util.List;

import com.afirme.afirmenet.model.transferencia.Favorita;

public interface FavoritaDao {
	public void agregar(Favorita favorita);

	public List<Favorita> listar(String contractId);

	public void modificar(Favorita favorita);

	public void eliminar(String contractId, Integer orden);

	public Favorita consulta(String contractId, Integer orden);

	public boolean existeFavorita(Favorita favorita);

}
