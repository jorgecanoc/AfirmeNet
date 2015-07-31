package com.afirme.afirmenet.service.impl.transferencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.transferencia.CuentaTercerosDao;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;
import com.afirme.afirmenet.service.config.PropertyService;
import com.afirme.afirmenet.service.transferencia.CuentaTercerosService;

@Service
public class CuentaTercerosServiceImpl implements CuentaTercerosService {

	@Autowired
	CuentaTercerosDao cuentaTercerosDao;
	@Autowired
	PropertyService propertyService;
	/*
	@Override
	public List<ACCTHIRD> getListaTercerosDeCuenta(String idContrato, String tipoContrato, String flag) {
		return cuentaTercerosDao.getListaTercerosDeCuenta(idContrato, tipoContrato, flag);
	}
	*/
	@Override
	public List<ACCTHIRDUSER> getListaTerceros(String idContrato, String tipoContrato, String idUsuario) {
		String tiempoEsperaCuentas = propertyService.obtenerTiempoEsperaSegundos(ConfigProperties.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
		return cuentaTercerosDao.getListaTerceros(idContrato, tipoContrato, idUsuario, tiempoEsperaCuentas);
	}
	
	@Override
	public ACCTHIRDUSER getCuentaTercero(String idContrato, String cuentaTercero, String tipoContrato, String idUsuario) {
		String tiempoEsperaCuentas = propertyService.obtenerTiempoEsperaSegundos(ConfigProperties.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
		return cuentaTercerosDao.getCuentaTercero(idContrato, cuentaTercero, tipoContrato, idUsuario, tiempoEsperaCuentas);
	}
	
}