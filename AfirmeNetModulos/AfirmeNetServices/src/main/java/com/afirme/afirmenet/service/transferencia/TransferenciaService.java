package com.afirme.afirmenet.service.transferencia;

import com.afirme.afirmenet.ibs.databeans.GRPUSR;
import com.afirme.afirmenet.model.transferencia.DomingoElectronico;

public interface TransferenciaService {

	/**
	 * Servicio que obtiene las tarifas y comisiones del paquete del usuario
	 * 
	 * @param idContrato
	 * @param idGrupo
	 *            Paquete o plan del usuario
	 * @return
	 */
	public GRPUSR getGroupCosts(String idContrato, String idGrupo);

	/**
	 * Metodo que permite insertar una programacion de domingo electonico en la
	 * tabla dc_progconcen
	 * 
	 * @param domingoElectronico
	 */
	public void generaRegistroPagoConcentrado(
			DomingoElectronico domingoElectronico);
}
