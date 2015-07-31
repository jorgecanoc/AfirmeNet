package com.afirme.afirmenet.service.impl.transferencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.transferencia.TransferenciaDao;
import com.afirme.afirmenet.ibs.databeans.GRPUSR;
import com.afirme.afirmenet.model.transferencia.DomingoElectronico;
import com.afirme.afirmenet.service.acceso.UserService;
import com.afirme.afirmenet.service.transferencia.TransferenciaService;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

	@Autowired
	TransferenciaDao transferenciaDao;

	@Autowired
	UserService userService;

	@Override
	public GRPUSR getGroupCosts(String idContrato, String idGrupo) {
		String tipoRegimen = userService.obtenerTipoRegimen(idContrato);
		return transferenciaDao.getGroupCosts(idGrupo, tipoRegimen);
	}

	@Override
	public void generaRegistroPagoConcentrado(
			DomingoElectronico domingoElectronico) {
		transferenciaDao.generaRegistroPagoConcentrado(domingoElectronico);
	}


}
