package com.afirme.afirmenet.service.transferencia;

import java.util.List;

import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;

public interface CuentaTercerosService {

	// TODO terminar de migrar metodos de JBAccThird
	//public List<ACCTHIRD> getListaTercerosDeCuenta(String idContrato, String tipoContrato, String flag);
	
	/**
	 * Servicio para obtener la lista de cuentas de Terceros asociados a una Cuenta
	 * @param idContrato
	 * @param tipoContrato
	 * @param idUsuario
	 * @return
	 */
	public List<ACCTHIRDUSER> getListaTerceros(String idContrato, String tipoContrato, String idUsuario);
	
	/**
	 * Servicio para obtener la informacion de una cuenta de Terceros especifica
	 * @param idContrato
	 * @param cuentaTercero
	 * @param tipoContrato
	 * @param idUsuario
	 * @param tiempoEsperaCuentas
	 * @return
	 */
	public ACCTHIRDUSER getCuentaTercero(String idContrato, String cuentaTercero, String tipoContrato, String idUsuario);
}
