package com.afirme.afirmenet.service.acceso;

public interface MenuService {
	
	/**
	 *  Obtiene el menu
	 * @param grupoId
	 * @param renglon
	 * @return
	 */
	public String getMenu(String grupoId,int renglon,String contrato);
	
}
