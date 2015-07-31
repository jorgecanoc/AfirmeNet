package com.afirme.afirmenet.dao.acceso;

import java.sql.SQLException;

import com.afirme.afirmenet.ibs.beans.Contrato;
import com.afirme.afirmenet.ibs.beans.JBLogin;

public interface ContratoDao {
	public Contrato getDatosContrato(String idContrato);
	public boolean updateContrato(Contrato contrato, String idContrato);
	public boolean setPassword(String idContrato, String password, String status);
	public boolean setStatus(String idContrato, String status);
	public JBLogin getDatosLogIn(String idContrato) throws SQLException;
}
