package com.afirme.afirmenet.service.acceso;


import java.util.List;

import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.beans.JBBMuser;
import com.afirme.afirmenet.ibs.beans.JBLogList;
import com.afirme.afirmenet.ibs.beans.JBLogin;
import com.afirme.afirmenet.ibs.beans.JBProCode;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;

public interface LogInService {
    /**
     * Valida si es el primer login con alias
     * */
	public boolean verificarPrimerLoginConAlias(String contrato);
	
    /**
     * Actualiza si es el primer login con alias
     * */
	public boolean actualizarPrimerLoginConAlias(String contrato);
	
    /**
     * Actualiza si tiene INOUT
     * */
	public boolean verificaINOUT(String contrato);
	
    /**
     * Actualiza INOUT
     * */
	public boolean updateINOUT(String UserIdJSP, String Estatus);
	
    /**
     * Consulta IP
     * */
	public String consultaIP(String contrato,String usuario);
	
    /**
     * Inserta IP
     * */
	public boolean insertaIP(String contrato,String usuario,String ip);
	
    /**
     * Actualiza IP
     * */
	public boolean actualizaIP(String contrato,String usuario,String ip,String estatus);
	
    /**
     * Verifica si esta activo en banca movil
     * */
	public JBBMuser verificaBMUser(String contrato);
	
    /**
     * Actualiza BMUser
     * */
	public boolean updateBMUser(String contrato,String estatus);
	
    /**
     * Actualiza BMUser
     * */
	public boolean updateBMUser(String contrato);
	
	
	public JBLogin getUserLogin(String UserIdJSP,String UserPassJSP) throws AfirmeNetException;
	
	  /**
	    * Método que busca si hay cambios en las transacciones o bien si existe una nueva transacción y/o pago de servicio para que se le agregue a la parametrización del usuario. Si el usuario no tiene cargado la parametrización, el método la carga con valores por default.
	    * @param userIdJSP El contrato del usuario.
	    * @param groupId El grupo o paquete al que pertenece el usuario.
	    * @param session La sessión del usuario.
	    * @author vmpermad
	 * @throws Exception 
	    */
	public void defaultSetting(String userIdJSP, String groupId, List<Cuenta> cuentas, List<JBProCode> procode);

	/**
	 * Devuelve el ultimo login en un bean
	 * @param contrato
	 */
	
	public JBLogList getLastLoginPer(String contrato);

	/**
	 * Inserta acceso a Afirmenet
	 */
	public void getAddLogPer(String DTTM,String USERID,String LACTION,String REMARK,
			String ACCOUNT,String AMOUNT,String CURRENCY,String TYP_TRAN,String DCIBS_REF);

	/**
	 * Obtiene el listado de las transacciones
	 * @param bPaqueteSinToken
	 * @return
	 */
	public List<JBProCode> getProcode(boolean bPaqueteSinToken);

	  /**
	    * Busca si hay cambios en los límites de transferencias, si es así se valida que ya se haya cumplido el tiempo de espera para actualizarlos en caso contrario se mantienen hasta que el tiempo de espera se haya cumplido.
	    * @param userIdJSP El contrato del usuario.
	    */
	public void lookupChangeParameter(String contrato);
	   
}
