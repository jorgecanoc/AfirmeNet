package com.afirme.afirmenet.service.impl.contrato;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.ContratoDao;
import com.afirme.afirmenet.ibs.beans.Contrato;
import com.afirme.afirmenet.ibs.beans.JBLogin;
import com.afirme.afirmenet.service.contrato.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService {
	
	@Autowired
	private ContratoDao contratoDao;
	
	@Override
	public Contrato getDatosContrato(String idContrato) {
		return contratoDao.getDatosContrato(idContrato);
	}

	@Override
	public JBLogin getDatosLogIn(String idContrato) throws SQLException{
		return contratoDao.getDatosLogIn(idContrato);
	}

	@Override
	public boolean setStatus(String idContrato, String status) {
		return contratoDao.setStatus(idContrato, status);
	}

	@Override
	public boolean updateContrato(Contrato contrato, String idContrato) {
		return contratoDao.updateContrato(contrato, idContrato);
	}

	@Override
	public boolean setPassword(String idContrato, String password, String status) {
		return contratoDao.setPassword(idContrato, password, status);
	}
}
