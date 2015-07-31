package com.afirme.afirmenet.dao.transferencia;

import java.util.List;

import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;

public interface CuentaTercerosDao {
	
	// TODO Terminar por migrar resto de metodos de JBAccThird
	
	/**
	 * Metodo DAO para obtencion de lista de Terceros de una cuenta especifica 
	 * Referencia: JBAccThird.getAccThirdListEntity
	 * @param idContrato
	 * @param tipoContrato
	 * @param flag
	 * @return lista de cuentas de terceros
	 */
	//public List<ACCTHIRD> getListaTercerosDeCuenta(String idContrato, String tipoContrato, String flag);
	
	/**
	 * Metodo DAO para obtencion de lista de Terceros y sus usuarios referentes
	 * Referencia: JBAccThird.getAccThirdListUser
	 * @param idContrato
	 * @param tipoContrato
	 * @param idUsuario
	 * @param tiempoEsperaCuentas
	 * @return Lista de usuarios y cuenta de terceros
	 */
	public List<ACCTHIRDUSER> getListaTerceros(String idContrato, String tipoContrato, String idUsuario, String tiempoEsperaCuentas);
	
	/**
	 * Metodo para obtener una cuenta de Tercero especifica
	 * @param idContrato
	 * @param tipoContrato
	 * @param idUsuario
	 * @param tiempoEsperaCuentas
	 * @return
	 */
	public ACCTHIRDUSER getCuentaTercero(String idContrato, String cuentaTercero, String tipoContrato, String idUsuario, String tiempoEsperaCuentas);
}
