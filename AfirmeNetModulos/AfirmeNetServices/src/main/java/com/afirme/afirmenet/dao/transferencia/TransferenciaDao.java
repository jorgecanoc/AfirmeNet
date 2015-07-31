package com.afirme.afirmenet.dao.transferencia;

import java.util.List;

import com.afirme.afirmenet.ibs.databeans.GRPUSR;
import com.afirme.afirmenet.model.transferencia.DomingoElectronico;

public interface TransferenciaDao {

	/**
	 * Obtiene las tarifas y comisiones del paquete del usuario
	 * 
	 * @param idContrato
	 * @param idGrupo
	 *            Paquete o plan del usuario
	 * @param tipoRegimen
	 *            Tipo de regimen fiscal del usuario de afirmenet 1-Persona
	 *            Moral, 2-Persona Fisica
	 * @return
	 */
	public GRPUSR getGroupCosts(String idGrupo, String tipoRegimen);

	/**
	 * Metodo que permite insertar una programacion de domingo electonico en la
	 * tabla dc_progconcen
	 * 
	 * @param domingoElectronico
	 */
	public void generaRegistroPagoConcentrado(
			DomingoElectronico domingoElectronico);

	/**
	 * Obtiene la lista de domingos electronicos programados autorizados,
	 * suceptibles de ser cancelados
	 * 
	 * @param contract
	 * @return
	 */
	public List<DomingoElectronico> getDomingosProgramados(String contract);


}
