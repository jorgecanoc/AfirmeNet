package com.afirme.afirmenet.dao.transferencia;

import com.afirme.afirmenet.ibs.beans.JBSIC001PF;

public interface TasaCambioPreferencialDao {
	
	/**
	 * 
	 * Obtiene el bean de clave preferencial
	 * @param cveTasaPref
	 * @return
	 */
	
	public JBSIC001PF validateCveTasaPreferencial(String cveTasaPref);

}
