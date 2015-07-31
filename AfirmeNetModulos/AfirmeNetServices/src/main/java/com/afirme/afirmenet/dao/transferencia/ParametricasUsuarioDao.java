package com.afirme.afirmenet.dao.transferencia;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.afirme.afirmenet.ibs.objects.parameter.JOParamAccumAcc;
import com.afirme.afirmenet.ibs.objects.parameter.JOParamOwnAcc;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;

public interface ParametricasUsuarioDao {
	/**
	 * Inserta un registro en la tabla de historial de los par�metros de cuentas
	 * 
	 * @param tranferenciaBase
	 *            La transferencia que se va a guardar
	 * @param tipoTransferencia
	 *            el tipo de transferencia que se va a guardar
	 * @throws SQLException
	 * @author jorge.canoc@gmail.com
	 */
	public void insert(Comprobante comprobante) throws SQLException;

	/**
	 * Borra un registro de la tabla, de acuerdo al contraro y a la referencia
	 * dada.
	 * 
	 * @param contract
	 *            El contrato con el que se di� de alta el registro.
	 * @param bxiRef
	 *            La referencia con la que se di� de alta la referencia.
	 * @throws SQLException
	 * @author jorge.canoc@gmail.com
	 */
	public void delete(long contract, String bxiRef) throws SQLException;

	/**
	 * Se trae los par�metros de transacci�n para el contrato proporcionado.
	 * Regresa una colecci�n de objetos de tipo JOParamOwnAcc
	 * 
	 * @param contract
	 *            El contrato del usuario.
	 * @param account
	 *            la cuenta del contrato
	 * @param transType
	 *            el tipo de transferencia
	 * @param serviceType
	 *            el tipo de servicio
	 * @param inerType
	 *            el tipo de subservicio
	 * @return Una colecci�n con los par�metros del usuario; una colecci�n vac�a
	 *         si no se encuentra registros.
	 * @throws Exception
	 * @author vmpermad
	 */
	public List<JOParamOwnAcc> getParameters(long contract, long account,
			String transtype, int serviceType, int intertype);

	/**
	 * Busca el registro con el n�mero interno solicitado para un rango de
	 * fecha. Regresa una colecci�n de objetos de tipo JOParamAccumAcc. Si la
	 * fecha final es null, la busqueda se hace de primero al �ltimo d�a del mes
	 * 
	 * @param contract
	 *            El contrato del usuario
	 * @param account
	 *            La cuenta del usuario
	 * @param transtype
	 *            La transacci�n que se quiere buscar
	 * @param servicetype
	 *            El n�mero de servicio.
	 * @param intertype
	 *            El n�mero interno del servicio.
	 * @param initialD
	 *            Fecha inicial de b�squeda
	 * @param finalD
	 *            Fecha Final de b�squeda.
	 * @return Una colecci�n de objetos con los registros encontrados para la
	 *         cuenta dada; una colecci�n vac�a en cualquier otro caso.
	 * @throws Exception
	 * @author vmpermad
	 */
	public List<JOParamAccumAcc> getAcumulado(long contract, long account,
			String transtype, int servicetype, int intertype, Date initialD,
			Date finalD);

	/**
	 * Valida si una transferencia esta en tiempo o no
	 * 
	 * @param tipo
	 * @param tiempo
	 * @param dia
	 * @return
	 */
	public boolean trasnferenciaEnTiempo(TipoTransferencia tipo, int tiempo,
			String dia);
	
	/**
	 * Guarda registros en la tabla
	 * @param c					Los registros que se van a guardar en la tabla.
	 * @return					El n�mero de registros guardados; cero si no se guardo ning�n registro.
	 * @throws Exception
	 * @author vmpermad
	 */
	public int insertParamOwnAcc(List<JOParamOwnAcc> parametricas);
	
	/**
	 * Actualiza registros de las transacci�n y/o servicios con los que cuenta la banca.
	 * @param c				Colecci�n de objetos de tipo JOParamOwnAcc
	 * @return				El n�mero de actualizaciones que se realizaron; 0 en caso de no realizar actualizaciones.
	 * @throws Exception	
	 * @author vmpermad
	 */
	public int updateParamOwnAcc (List<JOParamOwnAcc> parametricas);

	/**
	 * Busca los registros que fueron modificados para un contrato.
	 * La colecci�n que se regresa es de tipo JOParamOwnAcc
	 * @param contract			El contrato de los registros modficados.
	 * @return					Una coleci�n con la informaci�n encontrada en la tabla; una colecci�n vac�a en cualquier otro caso.
	 */
	public List<JOParamOwnAcc> findRegisterChanged(long contract);

}
