package com.afirme.afirmenet.service.impl.transferencia;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.transferencia.CuentaMailDao;
import com.afirme.afirmenet.service.transferencia.CuentaMailService;

@Service
public class CuentaMailServiceImpl implements CuentaMailService {

	@Autowired
	private CuentaMailDao cuentaMailDao;
	
	@Override
	public Map<String, String> getEmailReferences(String idContrato) {
		return cuentaMailDao.getEmailReferences(idContrato);
	}

	@Override
	public String getCorreoCuenta(String contrato, String cuenta) {
		return cuentaMailDao.getCorreoCuenta(contrato, cuenta);
	}
	
	@Override
	public boolean setCorreoCuenta(String contrato, String cuenta, String correo) {
		 return cuentaMailDao.setCorreoCuenta(contrato, cuenta,correo);
	}

	@Override
	public void guardaCorreoCuenta(String contrato, String cuenta, String correo) {
		if (correo!=null){
			if (cuentaMailDao.tieneCorreo(contrato,cuenta)==true){
				cuentaMailDao.updateCorreoCuenta(contrato, cuenta,correo);
			}else{
				cuentaMailDao.setCorreoCuenta(contrato, cuenta,correo);
			}
		}		
	}

}
