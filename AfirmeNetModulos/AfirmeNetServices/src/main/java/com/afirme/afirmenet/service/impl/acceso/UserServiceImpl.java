package com.afirme.afirmenet.service.impl.acceso;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.UserDao;
import com.afirme.afirmenet.service.acceso.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public String obtenerTipoRegimen(String contrato) {
		return userDao.obtenerTipoRegimen(contrato);
	}

	@Override
	public BigDecimal obtenerComisionEspecial(String numeroCliente, String codigoTransaccion, BigDecimal comision) {
		return userDao.obtenerComisionEspecial(numeroCliente, codigoTransaccion, comision);
	}

	@Override
	public String obtenerNumeroClienteContrato(String contrato) {
		return userDao.obtenerNumeroClienteContrato(contrato);
	}
	
	@Override
	public String obtenerContratoToken(String serialToken) {
		return userDao.obtenerContratoToken(serialToken);
	}
	
	@Override
	public String getMailUsuario(String contrato) {
		return userDao.getMailUsuario(contrato);
	}

	@Override
	public int obtenerNumeroIntento(String contrato) {
		return userDao.obtenerNumeroIntento(contrato);
	}

	@Override
	public boolean verificarUsuarioRegistrado(String contrato) {
		return userDao.verificarUsuarioRegistrado(contrato);
	}

	@Override
	public boolean registrarUsuarioAlias(String contrato) {
		return userDao.registrarUsuarioAlias(contrato);
	}

	@Override
	public boolean actualizarPrimerLoginConAlias(String contrato) {
		return userDao.actualizarPrimerLoginConAlias(contrato);
	}

	@Override
	public boolean incrementarNumeroIntentos(String contrato) {
		return userDao.incrementarNumeroIntentos(contrato);
	}

	@Override
	public boolean actualizarAlias(String contrato, String alias) {
		return userDao.actualizarAlias(contrato, alias);
	}
}
