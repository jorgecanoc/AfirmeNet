package com.afirme.afirmenet.dao.acceso;

import java.util.List;

import com.afirme.afirmenet.ibs.beans.menu.JBMenu;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuServicio;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuTransaccion;

public interface MenuDao {
	
	/**
	 *  Obtiene el menu
	 * @param grupoId
	 * @param renglon
	 * @return
	 */
	public List<JBMenu> findMenu(String grupoId,int renglon, String contrato);
	
	/**
	 *  Obtiene el menu transaccional
	 * @param grupoId
	 * @param renglon
	 * @return
	 */
	public List<JBMenuTransaccion> findMenuTransaccional();
	
	/**
	 *  Obtiene el menu parametrico
	 * @param grupoId
	 * @param renglon
	 * @return
	 */
	public List<JBMenuServicio> findMenuServios();
	
}
