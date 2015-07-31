package com.afirme.afirmenet.web.controller.nomina;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.nomina.Nomina;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.nomina.NominaService;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

/**
 * @author 0cdcarguz
 *
 */
@Controller
@SessionAttributes({"nomina"})
@RequestMapping("/nomina/disposicion")
public class CreditoNominaController extends TransferenciaController {

	@Autowired
	NominaService nominaService;
	@Autowired
	CuentaService cuentaService;
	
	static final Logger LOG = LoggerFactory.getLogger(CreditoNominaController.class);
	
	@RequestMapping(value = "/disposicion.htm", method = RequestMethod.GET)
	public String disposicionCredito(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /nomina/disposicion/disposicion.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		Nomina nomina = inicializaDatosNomina(request);
		nomina.setClave("C"); // Para realizacion de disposicion de Credito
		nomina.setMovimiento("I"); // Validacion de Cuenta Credito
		// Valida las cuentas de Credito Nomina
		Nomina nominaResult = nominaService.validaCredito(nomina);
		
		if (nominaResult.getErrores() == null) {
			// Obtiene la informacion de la Cuenta de Nomina
			Cuenta cuentaCredito = cuentaService.seleccionaCuenta(nominaResult.getCreditAccount(), getCuentasPropias(afirmeNetUser));
			nominaResult.setDestino(cuentaCredito);
			
			Cuenta cuenta = new Cuenta();
			cuenta.setNumber(afirmeNetUser.getContrato());
			cuenta.setNickname(afirmeNetUser.getNombreCompleto());
			nominaResult.setOrigen(cuenta);
			
			nomina.setMovimiento("V"); // Confirmacion de Cuenta Credito
			
			modelMap.addAttribute("nomina", nominaResult);
			return AfirmeNetWebConstants.MV_NOMINA_DISPOSICION;
			
		} else {
			modelMap.addAttribute("errores", nomina.getErrores());
		}
		
		return AfirmeNetWebConstants.MV_NOMINA;
	}
	
	@RequestMapping(value = "/abono.htm", method = RequestMethod.GET)
	public String abonoCredito(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /nomina/disposicion/abono.htm");
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		Nomina nomina = inicializaDatosNomina(request);
		nomina.setClave("A"); // Para realizacion de Abono a Capital
		nomina.setMovimiento("I"); // Validacion de Cuenta Credito
		
		Nomina nominaResult = nominaService.validaCredito(nomina);
		
		if (nominaResult.getErrores() == null) {
			Cuenta cuenta = new Cuenta();
			cuenta.setNumber(afirmeNetUser.getContrato());
			cuenta.setNickname(afirmeNetUser.getNombreCompleto());
			nominaResult.setOrigen(cuenta);
			
			nomina.setMovimiento("F"); // Confirmacion de Abono
			
			modelMap.addAttribute("cuentasNomina", nominaService.getCuentasCreditoNomina(getCuentas(afirmeNetUser)));
			modelMap.addAttribute("nomina", nominaResult);
			return AfirmeNetWebConstants.MV_NOMINA_ABONO;
			
		} else {
			modelMap.addAttribute("errores", nomina.getErrores());
		}
		
		return AfirmeNetWebConstants.MV_NOMINA;
	}
	
	@RequestMapping(value = "/confirmacion.htm", method = RequestMethod.POST)
	public String confirmacionCredito(@ModelAttribute("nomina") Nomina nomina,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /nomina/disposicion/disposicion.htm");
		
		Nomina nominaResult = nominaService.validaCredito(nomina);
		
		if (nominaResult.getErrores() == null) {
			// Si se realiza Abono a Capital, se extrae la informacion de la Cuenta de Cargo
			if (nominaResult.getClave().equals("A")) {
				AfirmeNetUser afirmeNetUser = getSessionUser(request);
				// Obtiene la informacion de la Cuenta de Nomina
				Cuenta cuentaCredito = cuentaService.seleccionaCuenta(nominaResult.getCreditAccount(), getCuentasPropias(afirmeNetUser));
				nominaResult.setDestino(cuentaCredito);
				// Se especifica el siguiente Movimiento a realizar: Ejecucion Abono
				nominaResult.setMovimiento("P");
			} else {
				// Ejecucion Credito
				nominaResult.setMovimiento("A");
			}
			
			modelMap.addAttribute("nomina", nominaResult);
			return AfirmeNetWebConstants.MV_NOMINA_CONFIRMACION;
			
		} else {
			modelMap.addAttribute("errores", nomina.getErrores());
		}
		
		if (nominaResult.getClave().equals("A"))
			return AfirmeNetWebConstants.MV_NOMINA_ABONO;
		else
			return AfirmeNetWebConstants.MV_NOMINA_DISPOSICION;
	}
	
	@RequestMapping(value = "/comprobante.htm", method = RequestMethod.GET)
	public String ejecucion(@ModelAttribute("nomina") Nomina nomina,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /nomina/disposicion/nomina_consulta.htm");
		
		Nomina nominaResult = nominaService.validaCredito(nomina);
		
		if (nominaResult.getErrores() == null) {
			// TODO cdcarguz falta terminar la ejecucion de Nomina y pantallas de comprobante
			return AfirmeNetWebConstants.MV_NOMINA_CONFIRMACION;
		} else {
			modelMap.addAttribute("errores", nomina.getErrores());
		}
		
		if (nominaResult.getClave().equals("A"))
			return AfirmeNetWebConstants.MV_NOMINA_ABONO;
		else
			return AfirmeNetWebConstants.MV_NOMINA_DISPOSICION;
	}
	
	private Nomina inicializaDatosNomina(HttpServletRequest request) {
		
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		
		Nomina nomina = new Nomina();
		nomina.setContractId(afirmeNetUser.getContrato());
		nomina.setTipoTransferencia(TipoTransferencia.CREDITO_DE_NOMINA);
		nomina.setTransactionCode(TipoTransferencia.CREDITO_DE_NOMINA.getValor());
		nomina.setCreditAccount(afirmeNetUser.getContrato()); // Cuenta
		nomina.setAccountNumber(afirmeNetUser.getNumCliente()); // Numero de Cliente
		nomina.setAmount(new BigDecimal(BigInteger.ZERO));
		nomina.setCommision(new BigDecimal(BigInteger.ZERO));
		nomina.setIva(new BigDecimal(BigInteger.ZERO));
		// Establece fecha y hora de ejecucion
		String fechaActual = TimeUtils.getDateFormat(new Date(), "dd/MMMM/yyyy") + " " + Util.getHH() + ":" + Util.getMM();
		Date fechaProgramacion = TimeUtils.getDate(fechaActual, "dd/MMMM/yyyy HH:mm");
		setEjecucionInfo(nomina, fechaProgramacion);
		
		return nomina;
	}
}
