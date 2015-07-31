package com.afirme.afirmenet.service.impl.acceso;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.PasswordDao;
import com.afirme.afirmenet.security.JBFirmaDigital;
import com.afirme.afirmenet.service.acceso.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {

	@Autowired
	private PasswordDao passwordDao;
	
	@Override
	public Map<String, String> updatePassword(String idContrato, String password, String nuevoPassword) {
		return passwordDao.updatePassword(idContrato, password, nuevoPassword);
	}

	@Override
	public boolean setPassword(String idContrato, String password) {
		JBFirmaDigital firmaDigital = new JBFirmaDigital();
		firmaDigital.inicializaLlaves();
		return passwordDao.setPassword(idContrato, password, firmaDigital);
	}

	@Override
	public void mailNotificacionCambioPwd(String idContrato) {
		passwordDao.mailNotificacionCambioPwd(idContrato);
	}

	@Override
	public Map<String, String> solicitudCambioPwd(String idContrato, String nuevoPassword) {
		return passwordDao.solicitudCambioPwd(idContrato, nuevoPassword);
	}

	@Override
	public String validaPassword(String idContrato, String codigoToken) {
		return passwordDao.validaPassword(idContrato, codigoToken);
	}

}
