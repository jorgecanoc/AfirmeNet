package com.afirme.afirmenet.service.nomina;

import java.util.List;

import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.nomina.Nomina;

public interface NominaService {

	/**
	 * Servicio que valida el credito de una Cuenta de Nomina
	 * @param cuentaNomina
	 * @param tipoMovimiento
	 * @return
	 */
	public Nomina validaCredito(Nomina nomina);
	
	/**
	 * Servicio para extraer las cuentas de Nomina asociadas a las cuentas del usuario
	 * @param listadoCuentas
	 * @return Listado de Cuentas Nomina
	 */
	public List<Cuenta> getCuentasCreditoNomina(List<Cuenta> listadoCuentas);
}
