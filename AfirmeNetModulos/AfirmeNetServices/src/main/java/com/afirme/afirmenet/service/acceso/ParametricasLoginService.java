package com.afirme.afirmenet.service.acceso;

import java.util.List;

import com.afirme.afirmenet.ibs.beans.JBProCode;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuServicio;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuTransaccion;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.ibs.objects.parameter.JOParamOwnAcc;

public interface ParametricasLoginService {

	/**
	 * Carga los parametros de transferencias del usuario.
	 * Si el usuario no ha cargado sus parametros, entonces se realiza la carga automática de las transacciones con cantidad por default. Una vez
	 * realizada la primera carga de los parametros, cada vez que el usuario entre en sessión se va a revisar si existe algún cambio en los
	 * parametros del sistema y se actualiza la parametrización.
	 * En el caso que se genere una excepción en la carga y/o validación de los parametros, ésta es propagada.
	 * @param contract			El contrato del usuario.
	 * @param groupId			El grupo o paquete del usuario
	 * @param account			Las cuentas propias del usuario.
	 * @param servicios			Los servicios con los que cuenta la banca
	 * @param procode			Las transacciones con los que cuenta la banca					
	 * @throws Exception
	 * @author vmpermad
	 */
	
	public void transactionSettings(long contract, String groupId, List<Cuenta> cuentas, List<INSER> servicios, List<JBProCode> procode);
	
	/**
	 * Método que valida si hay alguna nueva transacción y/o servicio en la tabla, para que se le agregue al conjunto de parametros del usuario.
	 * @param groupId			El grupo o paquete del usuario
	 * @param contract			El contrato del usuario.
	 * @param account			La cuenta del usuario
	 * @param currency			El tipo de moneda que maneja la cuenta
	 * @param poCollection		Los parametros que ya tiene dados de alta el usuario.
	 * @param servicioBean		Los servicios con los que cuenta la banca.
	 * @param procode			Las transacciones de la banca.
	 * @throws Exception
	 * @author vmpermad
	 */

	public List<JOParamOwnAcc> lookupNewTransaction (String groupId, long contract, long account, String currency, 
			List<JOParamOwnAcc> parametricas, List<INSER> servicios, List<JBProCode> procode,
			List<JBMenuTransaccion> menuTransacciones,List<JBMenuServicio> menuServicios,List<JOParamOwnAcc> insertCollection) throws Exception;
	
	/**
	 * Valida si se han realizado cambios en las transacciones y/o servicios de la banca, si hay algún cambio entonces se actualiza el registro.
	 * @param groupId				El grupo o paguete de servicio con el que cuenta el usuario
	 * @param po					El registro que se va a verificar si hay sufrido algún cambio.
	 * @param serviciosBean			Los servicios con los que cuenta la banca
	 * @param procode				Las transacciones propias de la banca.
	 * @throws Exception
	 * @author vmpermad
	 */
	public List<JOParamOwnAcc> lookupTransactionChange( String groupId, JOParamOwnAcc po, List<INSER> servicios, List<JBProCode> procode,
			                                            List<JBMenuTransaccion> menuTransacciones,List<JBMenuServicio> menuServicios, List<JOParamOwnAcc> updateCollection) throws Exception;
	
	
	/**
	 * Busca el nombre de la transacción o servicio cuando se carga por primera vez el servicio.
	 * Si el registro tiene un número interno consecutivo, el nombre del registro se obtiene de la tabla msCollection,
	 * Si el registro no cuenta con un número interno pero si con un número de servicio, el nombre del registro se obtiene de serviciosBean
	 * Si el registros nada más tiene número de transacción (tipo de servicio y número interno son cero), el nombre de obtiene de procode
	 * @param mt				El menú transaccional que permite validar si la transacción la puede accesar el paquete del usuario.
	 * @param msCollection		Los servicios que tienen un número interno.
	 * @param serviciosBean		Los servicios de la banca.
	 * @param procode			Las transacciones de la banca.
	 * @return
	 * @author vmpermad
	 */
	public String getParametricName (JBMenuTransaccion mt, List<JBMenuServicio> menuServicios, List<INSER> servicios, List<JBProCode> procode);

	/**
	 * Busca si el nombre del parámetro, que ya tiene dado de alta el usuario, tiene alguna modificación.
	 * Regresa el nuevo nombre del parámetro, si es el caso, que ya tiene dado de alta el usuario.
	 * Si el registro tiene un número interno consecutivo, el nombre del registro se obtiene de la tabla msCollection,
	 * Si el registro no cuenta con un número interno pero si con un número de servicio, el nombre del registro se obtiene de serviciosBean
	 * Si el registros nada más tiene número de transacción (tipo de servicio y número interno son cero), el nombre de obtiene de procode 
	 * @param po				El registro que ya tiene dado de alta el usuario.
	 * @param msCollection		Los servicios que tienen un número interno.
	 * @param serviciosBean		Los servicios con los que cuenta la banca.
	 * @param procode			Las transacciones de la banca.
	 * @return
	 * @author vmpermad
	 */
	public String getParametricNameChanged (JOParamOwnAcc po, List<JBMenuServicio> menuServicios, List<INSER> servicios, List<JBProCode> procode);

	/**
	 * Busca si existe un nuevo servicio dado de alta en la banca, si es así se agrega este servico al usuario.
	 * @param contract				El contrato del usuario.
	 * @param account				La cuenta del usuario
	 * @param currency				El tipo de moneda que maneja la cuenta
	 * @param transtype				El tipo o número de transacción, tipicamente es 28 por tratarse de servicio básico.
	 * @param poCollection			Lo parametros con los que ya cuenta el usuario.
	 * @param serviciosBean			Los servicios con los que cuenta la banca.
	 * @param insertCollection		Guarda los registros, si es el caso, que se le van agregar al usuario.
	 * @author vmpermad
	 */
	public void newBasicService (long contract, long account, String currency, String transtype, 
											List<JOParamOwnAcc> parametricas, List<INSER> servicios, List<JOParamOwnAcc> insertCollection);
	
	/**
	 * Verifica si la banca cuenta con alguna nueva transacción si es así, entonces se guarda la información para agregarla al conjunto de parametros
	 * del usuario.
	 * @param contract			El contraro del usuario.
	 * @param account			La cuenta del usuario.
	 * @param currency			La moneda que maneja la cuenta.
	 * @param name				El nombre de la nueva transacción 
	 * @param mt				La transacción de la banca que se va a validar si es nueva o no.
	 * @param poCollection		Los parametros que ya tiene registrados el usuario.
	 * @param insertCollection
	 * @author vmpermad
	 */
	public void newTransaction(long contract, long account, String currency, String name, 
								JBMenuTransaccion mt, List<JOParamOwnAcc> parametricas, List<JOParamOwnAcc> insertCollection);

	/**
	 * Verifica si existe algún cambio en los servicios que ya tiene dados de alta el usuario. Cualquier cambio de nombre, o que el servicio se 
	 * haya dado de baja, se actualiza el registro para el usuario.
	 * En el caso que el registro haya sido inhabilitado por el propio usuario, este registro no se modifica su estatus, salvo que el mismo haya
	 * sido dado de baja de la banca.
	 * @param po					El servicio que se va a validar si no ha sido dado de baja de la banca.
	 * @param mt					El menú transaccional, que nos permiete verificar si el servicio está disponible para el tipo de paquete del
	 * 								usuario.
	 * @param servicioBean			Los servicios con los que cuenta la banca
	 * @param updateCollection		Se guarda los registros que se van actualizar para el usuario.
	 * @author vmpermad
	 */
	public void basicServiceChange (JOParamOwnAcc po, JBMenuTransaccion mt,  List<INSER> servicios, List<JOParamOwnAcc> updateCollection);

	/**
	 * Verifica si la transacción tiene algún cambio y se actualiza el registro.
	 * Si el registro fué inhabilitado por el usuario, el estatus no se moficia, salvo que la transacción haya sido quitada de la banca.
	 * @param po				El registro que ya tiene dado de alta el servicio.
	 * @param mt				El menú transaccional, que indica si el paquete del usuario tiene acceso a la transacción
	 * @param msCollection		Los servicios que tienen un número interno.
	 * @param procode			Las transacciones con los que cuenta la banca.
	 * @param serviciosBean		Los servicios de la banca.
	 * @param updateCollection	Colección que guarda los registros que se van a actualizar.
	 * @author vmpermad
	 */
	public void transactionChange (JOParamOwnAcc po, JBMenuTransaccion mt, List<JBMenuServicio> menuServicios,
									List<JBProCode> procode, List<INSER> servicios, List<JOParamOwnAcc> updateCollection);
	
	/**
	 * Guarda registros en la tabla
	 * @param c					Los registros que se van a guardar en la tabla.
	 * @return					El número de registros guardados; cero si no se guardo ningún registro.
	 * @throws Exception
	 * @author vmpermad
	 */
	public int insertParamOwnAcc (List<JOParamOwnAcc> parametricas);
	
	/**
	 * Actualiza registros de las transacción y/o servicios con los que cuenta la banca.
	 * @param c				Colección de objetos de tipo JOParamOwnAcc
	 * @return				El número de actualizaciones que se realizaron; 0 en caso de no realizar actualizaciones.
	 * @throws Exception	
	 * @author vmpermad
	 */
	public int updateParamOwnAcc (List<JOParamOwnAcc> parametricas);

	/**
	 * Carga pos primera vez los parametros del usuario, esta carga se realiza con información por default.
	 * @param contract			Contrato del usuario
	 * @param account			La cuenta para la cual se va a generar la carga inicial.
	 * @param currency			El tipo de moneda que maneja la cuenta
	 * @param groupId			El grupo o paquete que tiene el usuario.
	 * @param serviciosBean		Los servicios con los que cuenta la banca.
	 * @param procode			Las transacciones propias de la banca.
	 * @throws Exception
	 * @author vmpermad
	 */
	public void loadDefaultParameter (long contract, long account, String currency, String groupId, List<INSER> servicios, List<JBProCode> procode,List<JBMenuTransaccion> menuTransacciones,List<JBMenuServicio> menuServicios);
	
	/**
	 * Carga por primera vez los servicios básico para un usuario.
	 * @param contract			El contraro del usuario
	 * @param account			La cuenta del usuario, para la cual se van a cargar los servicios básico
	 * @param currency			El tipo de moneda de la cuenta
	 * @param transtype			El tipo o número de transacción, tipicamente 28 por ser servicio básico.
	 * @param serviciosBean		Los servicios con los que cuenta la banca
	 * @param c					Colección que guarda los registos que se van a actualizar.
	 * @author vmpermad
	 */
	public List<JOParamOwnAcc> loadBasicService (long contract, long account, String currency, String transtype, List<INSER> servicios,List<JOParamOwnAcc> dataColection);

	   /**
	    * Busca si hay cambios en los límites de transferencias, si es así se valida que ya se haya cumplido el tiempo de espera para actualizarlos en caso contrario se mantienen hasta que el tiempo de espera se haya cumplido.
	    * @param userIdJSP El contrato del usuario.
	    * @throws Exception
	    * @author vmpermad
	    */
	public void lookUpChangeParameter(long contract);


}
