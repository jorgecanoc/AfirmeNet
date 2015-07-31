package com.afirme.afirmenet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.FinDiaDao;
import com.afirme.afirmenet.service.FinDiaService;

@Service
public class FinDiaServiceImpl implements FinDiaService {

	@Autowired
	private FinDiaDao finDiaDao;
	
	@Override
	public String getFinDia() {
		return finDiaDao.getFinDia();
	}

}
