package com.afirme.afirmenet.web.controller.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.ModelMap;

import com.afirme.afirmenet.exception.AfirmeNetSessionExpiredException;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.beans.consultas.Resumen;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.token.ValidaTokenService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.web.config.InitConfig;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

/**
 * Super clase {@link @Controller} que encapsula atributos generales que seran
 * utilizados por todos los controladores, dentro de estos atributos se pueden
 * listar:
 * 
 * <ul>
 * <li>{@link MessageSource}: Archivo .properties que contiene un informacion
 * basada en un locale especifico</li>
 * <li>{@link Locale}: Es un objecto que representa una ubicacion geografica
 * especifica en java</li>
 * </ul>
 * 
 * @author jorge.canoc@gmail.com
 * @tag Start date: (23/03/15 11:03:39 AM)
 */
public class BaseController {

	@Autowired
	public MessageSource messageSource;
	@Autowired
	protected ValidaTokenService tokenService;

	@Autowired
	protected CuentaService cuentaService;

	public Locale locale = LocaleContextHolder.getLocale();

	/**
	 * Metodo que permite la obtencion de los mensajes del archido de recursos
	 * en el idioma que corresponda, asi como el paso de valores cuando existan
	 * place holders en el mensaje.
	 * 
	 * @param properties
	 * @param values
	 * @return El mensaje correspondiente
	 */
	public String getMessage(String properties, Object[] values) {
		return messageSource.getMessage(properties, values, locale);
	}

	/**
	 * Metodo que permite la obtencion de los mensajes del archido de recursos
	 * en el idioma que corresponda
	 * 
	 * @param properties
	 * @return El mensaje correspondiente
	 */

	public String getMessage(String properties) {
		return this.getMessage(properties, null);
	}

	/**
	 * Metodo que obtienen el usuario de la sesion actual
	 * 
	 * @param request
	 * @return
	 */
	public AfirmeNetUser getSessionUser(HttpServletRequest request) {
		AfirmeNetUser user = (AfirmeNetUser) request.getSession().getAttribute(
				AfirmeNetWebConstants.USUARIO_SESSION);
		if (user == null) {
			throw new AfirmeNetSessionExpiredException("0000", "Session Expiro");
		}
		return user;
	}

	public void validaConfiguracion() {
		if (!AfirmeNetConstants.configuracionCargada) {
			InitConfig init = new InitConfig();
			init.onInit();
		}
	}

	public boolean validaToken(String passCode, String contrato, String usuario,
			boolean basicoSinToken) {
		return tokenService.validaClave(passCode, contrato, usuario, basicoSinToken);
		
	}	
	public List<Cuenta> getCuentasPropias(AfirmeNetUser afirmeNetUser) {

		List<Cuenta> listaCuentasPropias = cuentaService.getCuentasPropias(
				getCuentas(afirmeNetUser),
				AfirmeNetWebConstants.CUENTAS_PROPIAS);

		return listaCuentasPropias;
	}

	public List<Cuenta> getCuentasPropiasMXP(AfirmeNetUser afirmeNetUser) {

		List<Cuenta> listaCuentasPropias = cuentaService.getCuentasPropiasMXP(
				getCuentas(afirmeNetUser),
				AfirmeNetWebConstants.CUENTAS_PROPIAS);

		return listaCuentasPropias;
	}

	public List<Cuenta> getCuentas(AfirmeNetUser afirmeNetUser) {
		List<Cuenta> listaCuentas = cuentaService.getCuentas(
				afirmeNetUser.getContrato(),
				afirmeNetUser.getCuentasExcluyentes(), false);
		return listaCuentas;
	}
	public List<Cuenta> calculaResumeCuentas(AfirmeNetUser usuario, ModelMap modelMap){
		//Carga informacion de cuentas
		List<Cuenta> cuentasTodas=cuentaService.getCuentas(usuario.getContrato(), usuario.getCuentasExcluyentes(), false);
		List<Cuenta> cuentas=cuentaService.segmentaCuentasPorTipo(Cuenta.TIPO_CUENTA, cuentasTodas);
		List<Cuenta> creditos=cuentaService.segmentaCuentasPorTipo(Cuenta.TIPO_CREDITO, cuentasTodas);
		List<Cuenta> inversiones=cuentaService.segmentaCuentasPorTipo(Cuenta.TIPO_INVERSION, cuentasTodas);
		List<Resumen> resumen=new ArrayList<Resumen>();
		Resumen resumenCuentas=cuentaService.calculaResumenPorCuenta(Cuenta.TIPO_CUENTA, cuentas);
		Resumen resumenCreditos=cuentaService.calculaResumenPorCredito(Cuenta.TIPO_CREDITO, creditos);
		Resumen resumenInversiones=cuentaService.calculaResumenPorCuenta(Cuenta.TIPO_INVERSION, inversiones);
		if(resumenCuentas.getTieneCuentas()>0)
			resumen.add(resumenCuentas);
		if(resumenCreditos.getTieneCuentas()>0)
			resumen.add(resumenCreditos);
		if(resumenInversiones.getTieneCuentas()>0)
			resumen.add(resumenInversiones);
		modelMap.addAttribute("resumen", resumen);
		return cuentas;
	}
}
