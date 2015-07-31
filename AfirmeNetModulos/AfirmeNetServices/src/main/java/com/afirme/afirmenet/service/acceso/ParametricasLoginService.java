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
	 * Si el usuario no ha cargado sus parametros, entonces se realiza la carga autom�tica de las transacciones con cantidad por default. Una vez
	 * realizada la primera carga de los parametros, cada vez que el usuario entre en sessi�n se va a revisar si existe alg�n cambio en los
	 * parametros del sistema y se actualiza la parametrizaci�n.
	 * En el caso que se genere una excepci�n en la carga y/o validaci�n de los parametros, �sta es propagada.
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
	 * M�todo que valida si hay alguna nueva transacci�n y/o servicio en la tabla, para que se le agregue al conjunto de parametros del usuario.
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
	 * Valida si se han realizado cambios en las transacciones y/o servicios de la banca, si hay alg�n cambio entonces se actualiza el registro.
	 * @param groupId				El grupo o paguete de servicio con el que cuenta el usuario
	 * @param po					El registro que se va a verificar si hay sufrido alg�n cambio.
	 * @param serviciosBean			Los servicios con los que cuenta la banca
	 * @param procode				Las transacciones propias de la banca.
	 * @throws Exception
	 * @author vmpermad
	 */
	public List<JOParamOwnAcc> lookupTransactionChange( String groupId, JOParamOwnAcc po, List<INSER> servicios, List<JBProCode> procode,
			                                            List<JBMenuTransaccion> menuTransacciones,List<JBMenuServicio> menuServicios, List<JOParamOwnAcc> updateCollection) throws Exception;
	
	
	/**
	 * Busca el nombre de la transacci�n o servicio cuando se carga por primera vez el servicio.
	 * Si el registro tiene un n�mero interno consecutivo, el nombre del registro se obtiene de la tabla msCollection,
	 * Si el registro no cuenta con un n�mero interno pero si con un n�mero de servicio, el nombre del registro se obtiene de serviciosBean
	 * Si el registros nada m�s tiene n�mero de transacci�n (tipo de servicio y n�mero interno son cero), el nombre de obtiene de procode
	 * @param mt				El men� transaccional que permite validar si la transacci�n la puede accesar el paquete del usuario.
	 * @param msCollection		Los servicios que tienen un n�mero interno.
	 * @param serviciosBean		Los servicios de la banca.
	 * @param procode			Las transacciones de la banca.
	 * @return
	 * @author vmpermad
	 */
	public String getParametricName (JBMenuTransaccion mt, List<JBMenuServicio> menuServicios, List<INSER> servicios, List<JBProCode> procode);

	/**
	 * Busca si el nombre del par�metro, que ya tiene dado de alta el usuario, tiene alguna modificaci�n.
	 * Regresa el nuevo nombre del par�metro, si es el caso, que ya tiene dado de alta el usuario.
	 * Si el registro tiene un n�mero interno consecutivo, el nombre del registro se obtiene de la tabla msCollection,
	 * Si el registro no cuenta con un n�mero interno pero si con un n�mero de servicio, el nombre del registro se obtiene de serviciosBean
	 * Si el registros nada m�s tiene n�mero de transacci�n (tipo de servicio y n�mero interno son cero), el nombre de obtiene de procode 
	 * @param po				El registro que ya tiene dado de alta el usuario.
	 * @param msCollection		Los servicios que tienen un n�mero interno.
	 * @param serviciosBean		Los servicios con los que cuenta la banca.
	 * @param procode			Las transacciones de la banca.
	 * @return
	 * @author vmpermad
	 */
	public String getParametricNameChanged (JOParamOwnAcc po, List<JBMenuServicio> menuServicios, List<INSER> servicios, List<JBProCode> procode);

	/**
	 * Busca si existe un nuevo servicio dado de alta en la banca, si es as� se agrega este servico al usuario.
	 * @param contract				El contrato del usuario.
	 * @param account				La cuenta del usuario
	 * @param currency				El tipo de moneda que maneja la cuenta
	 * @param transtype				El tipo o n�mero de transacci�n, tipicamente es 28 por tratarse de servicio b�sico.
	 * @param poCollection			Lo parametros con los que ya cuenta el usuario.
	 * @param serviciosBean			Los servicios con los que cuenta la banca.
	 * @param insertCollection		Guarda los registros, si es el caso, que se le van agregar al usuario.
	 * @author vmpermad
	 */
	public void newBasicService (long contract, long account, String currency, String transtype, 
											List<JOParamOwnAcc> parametricas, List<INSER> servicios, List<JOParamOwnAcc> insertCollection);
	
	/**
	 * Verifica si la banca cuenta con alguna nueva transacci�n si es as�, entonces se guarda la informaci�n para agregarla al conjunto de parametros
	 * del usuario.
	 * @param contract			El contraro del usuario.
	 * @param account			La cuenta del usuario.
	 * @param currency			La moneda que maneja la cuenta.
	 * @param name				El nombre de la nueva transacci�n 
	 * @param mt				La transacci�n de la banca que se va a validar si es nueva o no.
	 * @param poCollection		Los parametros que ya tiene registrados el usuario.
	 * @param insertCollection
	 * @author vmpermad
	 */
	public void newTransaction(long contract, long account, String currency, String name, 
								JBMenuTransaccion mt, List<JOParamOwnAcc> parametricas, List<JOParamOwnAcc> insertCollection);

	/**
	 * Verifica si existe alg�n cambio en los servicios que ya tiene dados de alta el usuario. Cualquier cambio de nombre, o que el servicio se 
	 * haya dado de baja, se actualiza el registro para el usuario.
	 * En el caso que el registro haya sido inhabilitado por el propio usuario, este registro no se modifica su estatus, salvo que el mismo haya
	 * sido dado de baja de la banca.
	 * @param po					El servicio que se va a validar si no ha sido dado de baja de la banca.
	 * @param mt					El men� transaccional, que nos permiete verificar si el servicio est� disponible para el tipo de paquete del
	 * 								usuario.
	 * @param servicioBean			Los servicios con los que cuenta la banca
	 * @param updateCollection		Se guarda los registros que se van actualizar para el usuario.
	 * @author vmpermad
	 */
	public void basicServiceChange (JOParamOwnAcc po, JBMenuTransaccion mt,  List<INSER> servicios, List<JOParamOwnAcc> updateCollection);

	/**
	 * Verifica si la transacci�n tiene alg�n cambio y se actualiza el registro.
	 * Si el registro fu� inhabilitado por el usuario, el estatus no se moficia, salvo que la transacci�n haya sido quitada de la banca.
	 * @param po				El registro que ya tiene dado de alta el servicio.
	 * @param mt				El men� transaccional, que indica si el paquete del usuario tiene acceso a la transacci�n
	 * @param msCollection		Los servicios que tienen un n�mero interno.
	 * @param procode			Las transacciones con los que cuenta la banca.
	 * @param serviciosBean		Los servicios de la banca.
	 * @param updateCollection	Colecci�n que guarda los registros que se van a actualizar.
	 * @author vmpermad
	 */
	public void transactionChange (JOParamOwnAcc po, JBMenuTransaccion mt, List<JBMenuServicio> menuServicios,
									List<JBProCode> procode, List<INSER> servicios, List<JOParamOwnAcc> updateCollection);
	
	/**
	 * Guarda registros en la tabla
	 * @param c					Los registros que se van a guardar en la tabla.
	 * @return					El n�mero de registros guardados; cero si no se guardo ning�n registro.
	 * @throws Exception
	 * @author vmpermad
	 */
	public int insertParamOwnAcc (List<JOParamOwnAcc> parametricas);
	
	/**
	 * Actualiza registros de las transacci�n y/o servicios con los que cuenta la banca.
	 * @param c				Colecci�n de objetos de tipo JOParamOwnAcc
	 * @return				El n�mero de actualizaciones que se realizaron; 0 en caso de no realizar actualizaciones.
	 * @throws Exception	
	 * @author vmpermad
	 */
	public int updateParamOwnAcc (List<JOParamOwnAcc> parametricas);

	/**
	 * Carga pos primera vez los parametros del usuario, esta carga se realiza con informaci�n por default.
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
	 * Carga por primera vez los servicios b�sico para un usuario.
	 * @param contract			El contraro del usuario
	 * @param account			La cuenta del usuario, para la cual se van a cargar los servicios b�sico
	 * @param currency			El tipo de moneda de la cuenta
	 * @param transtype			El tipo o n�mero de transacci�n, tipicamente 28 por ser servicio b�sico.
	 * @param serviciosBean		Los servicios con los que cuenta la banca
	 * @param c					Colecci�n que guarda los registos que se van a actualizar.
	 * @author vmpermad
	 */
	public List<JOParamOwnAcc> loadBasicService (long contract, long account, String currency, String transtype, List<INSER> servicios,List<JOParamOwnAcc> dataColection);

	   /**
	    * Busca si hay cambios en los l�mites de transferencias, si es as� se valida que ya se haya cumplido el tiempo de espera para actualizarlos en caso contrario se mantienen hasta que el tiempo de espera se haya cumplido.
	    * @param userIdJSP El contrato del usuario.
	    * @throws Exception
	    * @author vmpermad
	    */
	public void lookUpChangeParameter(long contract);


}
