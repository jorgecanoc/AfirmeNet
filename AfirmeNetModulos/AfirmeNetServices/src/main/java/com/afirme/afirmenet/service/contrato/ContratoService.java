package com.afirme.afirmenet.service.contrato;

import java.sql.SQLException;


import com.afirme.afirmenet.ibs.beans.Contrato;
import com.afirme.afirmenet.ibs.beans.JBLogin;

public interface ContratoService {

	public Contrato getDatosContrato(String idContrato);
	public JBLogin getDatosLogIn(String idContrato) throws SQLException;
	public boolean setStatus(String idContrato, String status);
	public boolean updateContrato(Contrato contrato, String idContrato);
	public boolean setPassword(String idContrato, String password, String status);
	/* TODO: JBEntity aún tiene métodos por implementar. Agregar conforme se vayan necesitando.*/
}
