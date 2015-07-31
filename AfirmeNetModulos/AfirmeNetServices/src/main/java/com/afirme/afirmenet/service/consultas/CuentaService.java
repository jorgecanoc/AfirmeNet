package com.afirme.afirmenet.service.consultas;

import java.util.List;

import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.beans.consultas.Resumen;

public interface CuentaService {
	
	public Cuenta getCuenta(String contrato, String numeroCuenta, String cuentasExcluyentes);
	public List<Cuenta> getCuentas(String contrato, String cuentasExcluyentes, boolean conInfoExtra);
	public Cuenta seleccionaCuenta(String numero, List<Cuenta> cuentas);
	public List<Cuenta> segmentaCuentasPorTipo(String tipo, List<Cuenta> cuentas);
	public Resumen calculaResumenPorCuenta(String tipo, List<Cuenta> cuentas);
	public Resumen calculaResumenPorCredito(String tipo, List<Cuenta> cuentas);
	//public List<Resumen> calculaResumen(String tipo, List<Cuenta> cuentas);
	public List<Cuenta> getCuentasPropias(List<Cuenta> cuentas, List<String> tipo);
	public List<Cuenta> getCuentasPropiasMXP(List<Cuenta> cuentas, List<String> tipo);
	public boolean esCuentasJunior(String cuenta);
	public List<ACCTHIRDUSER> getCuentasJunior(String contrato);
}
