package com.afirme.afirmenet.dao.acceso;

import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.model.DCMessageIni;

/**
 * Clase que permite mostrar las campa�as configurdas para los clientes de
 * afirmeNet
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public interface CampaniaDao {
	/**
	 * Metodo que permite obtener una campa�a dado un tipo de cliente, contrato,
	 * usuario y token
	 * 
	 * @param tipoCliente
	 * @param contrato
	 * @param usuarioId
	 * @param token
	 * @return
	 */
	public DCMessageIni getCampania(TipoCliente tipoCliente, String contrato,
			String usuarioId, String token);
}
