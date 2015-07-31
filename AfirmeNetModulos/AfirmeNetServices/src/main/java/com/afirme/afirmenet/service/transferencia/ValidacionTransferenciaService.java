package com.afirme.afirmenet.service.transferencia;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

/**
 * Clase que permite validar cualquier transaccion de AfirmeNet
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public interface ValidacionTransferenciaService {
	/**
	 * Valida si la transferencia ingresada cumple con los parametros de limite
	 * diario permitido
	 * 
	 * @param tranferenciaBase
	 *            la transferencia que se quiere confirmar
	 * @return true si no sobre pasa el limite permitido
	 * @throws AfirmeNetException
	 */
	public boolean isOnDailyLimit(TransferenciaBase tranferenciaBase,
			TipoTransferencia tipo) throws AfirmeNetException;

	/**
	 * Valida si la transferencia ingresada cumple con los parametros de limite
	 * mensual permitido
	 * 
	 * @param tranferenciaBase
	 *            la transferencia que se quiere confirmar
	 * @return true si no sobre pasa el limite permitido
	 * @throws AfirmeNetException
	 */
	public boolean isOnMonthlyLimit(TransferenciaBase tranferenciaBase,
			TipoTransferencia tipo) throws AfirmeNetException;

	/**
	 * Valida si la transferencia ingresada cumple con los parametros de fecha
	 * permitido
	 * 
	 * @param tranferenciaBase
	 *            la transferencia que se quiere confirmar
	 * @return true si cumple
	 * @throws AfirmeNetException
	 */
	public boolean isValidDate(TransferenciaBase tranferenciaBase)
			throws AfirmeNetException;

	/**
	 * Valida si la transferencia ingresada cumple con los parametros de fecha
	 * permitido
	 * 
	 * @param tranferenciaBase
	 *            la transferencia que se quiere confirmar
	 * @return true si cumple
	 * @throws AfirmeNetException
	 */
	public boolean isValidTime(TransferenciaBase tranferenciaBase,
			TipoTransferencia tipo) throws AfirmeNetException;

	/**
	 * Valida si una fecha es festivo o no
	 * 
	 * @param YY
	 *            el año a validar
	 * @param MM
	 *            el mes a validar
	 * @param DD
	 *            el dia a validar
	 * @return true si es festivo false si no es festivo
	 */
	public boolean isHolyDate(String YY, String MM, String DD);

	/**
	 * Metodo que aplica un set de validaciones generales a una transaccion en
	 * particular, en caso de que una validacion no sea cumplida se amacenara en
	 * un mapa donde la llave del mapa corresponde a {@link CodigoExcepcion} y
	 * el valor corresponde a la descripcion del error, este error puede ser
	 * llevado hasta el usuario
	 * 
	 * Las validaciones que contempla este error son las siguientes:
	 * <ul>
	 * <li>Validacion de la fecha:
	 * <ul>
	 * <li>fecha al ejecutar el pago</li>
	 * <li>hora al ejecutar el pago</li>
	 * <li>dias festivos</li>
	 * <li>fin de de dia</li></li>
	 * </ul>
	 * <li>limite diario</li> <li>limite mensual</li> </ul>
	 * 
	 * @param tranferenciaBase
	 * @return
	 */
	public Map<CodigoExcepcion, String> applyGeneralValidations(
			TransferenciaBase tranferenciaBase, TipoTransferencia tipo);

	/**
	 * Metodo que aplica un set de validaciones generales a una lista de
	 * transacciones, los errores seran almacenados en un mapa de errores como
	 * atributo dentro de cada transaccion, el valor corresponde a la
	 * descripcion del error, este error puede ser llevado hasta el usuario
	 * 
	 * Las validaciones que contempla este error son las siguientes:
	 * <ul>
	 * <li>Validacion de la fecha:
	 * <ul>
	 * <li>fecha al ejecutar el pago</li>
	 * <li>hora al ejecutar el pago</li>
	 * <li>dias festivos</li>
	 * <li>fin de de dia</li></li>
	 * </ul>
	 * <li>limite diario</li> <li>limite mensual</li> </ul>
	 * 
	 * @param tranferencias
	 */
	public void applyValidations(List<TransferenciaBase> tranferencias,
			TipoTransferencia tipo, List<TipoValidacion> validaciones);
}
