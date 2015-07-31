package com.afirme.afirmenet.web.controller.transferencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.transferencia.Favorita;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.transferencia.CuentaMailService;
import com.afirme.afirmenet.service.transferencia.FavoritaService;
import com.afirme.afirmenet.service.transferencia.TransferenciaFavoritaService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.model.FavoritasModel;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@SessionAttributes({ "favoritasModel", "horario" })
@RequestMapping("/transferencias/favoritas")
public class FavoritasController extends TransferenciaController {
	static final Logger LOG = LoggerFactory
			.getLogger(FavoritasController.class);

	@Autowired
	private CuentaMailService cuentaMailService;

	@Autowired
	private FavoritaService favoritaService;

	@Autowired
	private TransferenciaFavoritaService transferenciaFavoritaService;
	
	@Autowired
	private CuentaService cuentaService;

	/**
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/cuentas", method = RequestMethod.POST)
	public String cuentas(HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/favoritas/cuentas");
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		FavoritasModel favoritasModel = new FavoritasModel();
		favoritasModel.setFavoritas(favoritaService.getFavoritas(
				afirmeNetUser.getContrato(), 5));
		modelMap.addAttribute("favoritasModel", favoritasModel);
		modelMap.addAttribute("horario", AfirmeNetConstants.horarios
				.get(HorarioServicio.DOMINGO_ELECTRONICO));
		modelMap.addAttribute("editable", false);
		return AfirmeNetWebConstants.MV_FAVORITAS_SELECCIONA;
	}

	/**
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public String editar(
			@ModelAttribute("favoritasModel") FavoritasModel favoritasModel,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/favoritas/editar");
		modelMap.addAttribute("editable",
				Boolean.valueOf(request.getParameter("editable")));
		return AfirmeNetWebConstants.MV_FAVORITAS_SELECCIONA;
	}

	/**
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/confirmar", method = RequestMethod.POST)
	public String confirmar(
			@ModelAttribute("favoritasModel") FavoritasModel favoritasModel,
			HttpServletRequest request, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /transferencias/favoritas/confirmar");
		
		for (Favorita favorita : favoritasModel.getFavoritas()) {
			if (favorita.isEjecutar()) {
				Cuenta cuenta = cuentaService.getCuenta(favorita.getContractId(), favorita.getOrigen().getNumber(), "");
				favorita.setOrigen(cuenta);
				favorita.setDebitAccount(favorita.getOrigen().getNumber());
				favorita.setBankFrm(cuenta.getBankCode());
				favorita.setBankCode(cuenta.getBankCode());
				favorita.setCurrency(favorita.getOrigen().getCcy());
				setEjecucionInfo(favorita, new Date());
			}
		}
		return AfirmeNetWebConstants.MV_FAVORITAS_CONFIRMA;
	}

	/**
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ejecutar", method = RequestMethod.POST)
	public String ejecutar(
			@ModelAttribute("favoritasModel") FavoritasModel favoritasModel,
			HttpServletRequest request, ModelMap modelMap,
			SessionStatus sessionStatus) {
		LOG.debug("Atendiendo Peticion = /transferencias/favoritas/ejecutar");
		// Se genera la lista de ejecuciones
		List<TransferenciaBase> ejecutar = new ArrayList<TransferenciaBase>(0);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		// Se valida las favoritas seleccionadas
		for (Favorita favorita : favoritasModel.getFavoritas()) {
			if (favorita.isEjecutar()) {
				setEjecucionInfo(favorita, cal.getTime());
				favorita.setTransactionCode(favorita.getTipoTransferencia()
						.getValor());
				ejecutar.add(favorita);
			}
		}
		// Se setea la lista de las programaciones
		transferenciaFavoritaService.setTransferencias(ejecutar);
		// Se indica que las transferencias son de favoritas
		modelMap.addAttribute("esFavoritas", true);
		// Se ejecutan las transacciones
		String modelAndView = ejecutaTransferencia(modelMap, ejecutar,transferenciaFavoritaService, sessionStatus);
		//Se actualizan las operaciones favoritas confirmadas.
		favoritaService.actualizaFavoritas(favoritasModel.getFavoritas());

		return modelAndView;
	}

	/**
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ejecutar", method = RequestMethod.GET)
	public String ejecutarPRG(
			@ModelAttribute("favoritasModel") FavoritasModel favoritasModel,
			ModelMap modelMap,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return AfirmeNetWebConstants.MV_FAVORITAS_COMPROBANTE;
	}
}
