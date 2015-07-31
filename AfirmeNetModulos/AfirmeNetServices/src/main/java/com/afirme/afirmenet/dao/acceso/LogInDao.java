package com.afirme.afirmenet.dao.acceso;

import java.util.List;

import com.afirme.afirmenet.ibs.beans.JBBMuser;
import com.afirme.afirmenet.ibs.beans.JBLogList;
import com.afirme.afirmenet.ibs.beans.JBProCode;

public interface LogInDao {

    /**
     * Valida si es el primer login con alias
     * */
	public boolean verificarPrimerLoginConAlias(String UserIdJSP);
	
    /**
     * Actualiza si es el primer login con alias
     * */
	public boolean actualizarPrimerLoginConAlias(String UserIdJSP);
	
    /**
     * Obtiene INOUT
     * */
	public String getINOUT(String UserIdJSP);
	
    /**
     * Inserta INOUT
     * */
	public boolean insertaINOUT(String UserIdJSP);
	
    /**
     * Actualiza INOUT
     * */
	public boolean updateINOUT(String UserIdJSP, String estatus);
    /**
     * Actualiza INOUT
     * */
	public String getLTime(String UserIdJSP);
	
    /**
     * Consulta IP
     * */
	public String consultaIP(String contrato, String usuario);
	
    /**
     * Inserta IP
     * */
	public boolean insertaIP(String contrato,String usuario,String ip);
	
    /**
     * Actualiza IP
     * */
	public boolean actualizaIP(String contrato,String usuario,String ip,String estatus);
	
    /**
     * Obtiene BMUser
     * */
	public JBBMuser getBMUser(String contrato);
	
    /**
     * Actualiza BMUser
     * */
	public boolean updateBMUser(String contrato,String estatus);
	
    /**
     * Actualiza BMUser
     * */
	public boolean updateBMUser(String contratos);
	
    /**
     * 
     * */
	public int getSegundosSignOff();
	
    /**
     * Obtiene ultimo login
     * */
	public JBLogList getLastLoginPer(String contrato);

	/**
	 * Inserta acceso a Afirmenet
	 */	
	public void getAddLogPer(String dTTM, String uSERID, String lACTION,
			String rEMARK, String aCCOUNT, String aMOUNT, String cURRENCY,
			String tYP_TRAN, String dCIBS_REF);

	public List<JBProCode> getProcode(boolean bPaqueteSinToken);
}
