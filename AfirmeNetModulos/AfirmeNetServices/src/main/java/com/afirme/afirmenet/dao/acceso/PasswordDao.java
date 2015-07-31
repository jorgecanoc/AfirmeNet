package com.afirme.afirmenet.dao.acceso;

import java.util.Map;

import com.afirme.afirmenet.security.JBFirmaDigital;

public interface PasswordDao {
	
	public Map<String, String> updatePassword(String idContrato, String password, String nuevoPassword);
	public boolean setPassword(String idContrato, String password, JBFirmaDigital firmaDigital);
	public void mailNotificacionCambioPwd(String idContrato);
	public Map<String, String> solicitudCambioPwd(String idContrato, String nuevoPassword);
	public String validaPassword(String idContrato, String codigoToken);
}
