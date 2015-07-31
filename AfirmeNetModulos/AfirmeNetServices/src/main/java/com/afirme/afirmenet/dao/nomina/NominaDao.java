package com.afirme.afirmenet.dao.nomina;

import java.util.List;

import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.nomina.Nomina;

public interface NominaDao {

	/**
	 * Metodo para validar el credito de nomina y regresar el importe autorizado,
	 * la tasa de interes, la tasa moratoria y los limites maximos y minimos permitidos
	 * @param cuentaNomina
	 * @param tipoMovimiento
	 * @return
	 */
	public Nomina validaCredito(Nomina nomina);
	
	/**
	 * Metodo para extraer las cuentas de Nomina asociadas a las cuentas del usuario
	 * @param listadoCuentas
	 * @return Listado de Cuentas Nomina
	 */
	public List<Cuenta> getCuentasCreditoNomina(List<Cuenta> listadoCuentas);
}
