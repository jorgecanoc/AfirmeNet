package com.afirme.afirmenet.service.transferencia;

import java.util.List;

import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.model.transferencia.TransferenciaCuentasPropias;

/**
 * Clase que permite aplicar validaciones especificas a transaccion de AfirmeNet
 * 
 */
public interface ValidacionEspecificaTransferenciaService {
	
	/**
	 * Metodo que aplica un set de validaciones especificas a una lista de
	 * transacciones, los errores seran almacenados en un mapa de errores como
	 * atributo dentro de cada transaccion, el valor corresponde a la
	 * descripcion del error, este error puede ser llevado hasta el usuario
	 * 
	 * Las validaciones que contempla este error son las siguientes:
	 * <ul>
	 * <li>TIPO DE CAMBIO PREFERENCIAL
	 * <ul>
	 * 
	 * @param tranferencias
	 */
	public void applyValidationsEspecific(List<TransferenciaCuentasPropias> tranferencias,
			TipoTransferencia tipo, List<TipoValidacionEspecial> validaciones);

	/**
	 * Metodo que aplica un set de validaciones especificas a una lista de
	 * transacciones, los errores seran almacenados en un mapa de errores como
	 * atributo dentro de cada transaccion, el valor corresponde a la
	 * descripcion del error, este error puede ser llevado hasta el usuario
	 * 
	 * Las validaciones que contempla este error son las siguientes:
	 * <ul>
	 * <li>TIPO DE CAMBIO PREFERENCIAL
	 * <ul>
	 * 
	 * @param tranferencias
	 */
	public void applicaValidaticioEspecifica(List<? extends TransferenciaBase>  tranferencias, List<TipoValidacionEspecial> validaciones);	
	/**
	 * Metodo que aplica un set de validaciones especificas a una lista de
	 * transacciones, los errores seran almacenados en un mapa de errores como
	 * atributo dentro de cada transaccion, el valor corresponde a la
	 * descripcion del error, este error puede ser llevado hasta el usuario
	 * 
	 * Las validaciones que contempla este error son las siguientes:
	 * <ul>
	 * <li>TIPO DE CAMBIO PREFERENCIAL
	 * <ul>
	 * 
	 * @param tranferencias
	 */
	public void applicaValidaticioEspecifica(List<? extends TransferenciaBase>  tranferencias, List<TipoValidacionEspecial> validaciones, TransferenciaAfirmeNet servicio);	
	/**
	 * Valida si la clave para transferencia en dolares es valida 
	 * 
	 * 
	 * @param tranferenciaBase
	 *            la transferencia que se quiere confirmar
	 * @return true si no sobre pasa el limite permitido
	 * @throws AfirmeNetException
	 */
	boolean isValidClave(TransferenciaCuentasPropias tranferenciaBase,
			TipoTransferencia tipo) throws AfirmeNetException;
	
	/**
	 * Valida si la clave para transferencia en dolares esta vencida 
	 * 
	 * 
	 * @param tranferenciaBase
	 *            la transferencia que se quiere confirmar
	 * @return true si no sobre pasa el limite permitido
	 * @throws AfirmeNetException
	 */
	boolean isClaveVencida(TransferenciaCuentasPropias tranferenciaBase,
			TipoTransferencia tipo) throws AfirmeNetException;

}
