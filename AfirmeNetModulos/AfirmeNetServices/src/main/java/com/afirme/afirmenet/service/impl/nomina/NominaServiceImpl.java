package com.afirme.afirmenet.service.impl.nomina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.nomina.NominaDao;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.nomina.Nomina;
import com.afirme.afirmenet.service.nomina.NominaService;

@Service
public class NominaServiceImpl implements NominaService {

	@Autowired
	NominaDao nominaDao;
	
	@Override
	public Nomina validaCredito(Nomina nomina) {
		return nominaDao.validaCredito(nomina);
	}

	@Override
	public List<Cuenta> getCuentasCreditoNomina(List<Cuenta> listadoCuentas) {
		
		List<Cuenta> cuentasNomina = nominaDao.getCuentasCreditoNomina(listadoCuentas);
		
		if (cuentasNomina != null) {
			
			Map<String, Cuenta> mapCuentas = new HashMap<String, Cuenta>();
			for (Cuenta propia : listadoCuentas) {
				mapCuentas.put(propia.getNumber(), propia);
			}
			
			List<Cuenta> listResult = new ArrayList<Cuenta>();
			for (Cuenta nomina : cuentasNomina) {
				if (mapCuentas.containsKey(nomina.getNumber()))
					listResult.add(mapCuentas.get(nomina.getNumber()));
			}
			
			return listResult;
		}
		
		return null;
	}

}
