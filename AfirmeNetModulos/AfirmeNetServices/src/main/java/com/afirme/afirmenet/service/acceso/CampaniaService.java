package com.afirme.afirmenet.service.acceso;

import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.model.DCMessageIni;

/**
 * Interface que define los metodos diponibles para el manejo de las campañas en
 * afirmenet
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public interface CampaniaService {
	/**
	 * Metodo que permite mostrar si existe una campaña disponible para el
	 * usuario que ingresa en afirmenet
	 * 
	 * @param tipoCliente
	 *            el tipo de cliente {@link TipoCliente}
	 * @param contrato
	 *            el contrarto de usuario que esta logeado
	 * @param usuarioId
	 *            el id del usuario que esta logeado
	 * @param token
	 *            el token que ingreso el usuario
	 * @return
	 */
	public DCMessageIni getCampania(TipoCliente tipoCliente, String contrato,
			String usuarioId, String token);

}
