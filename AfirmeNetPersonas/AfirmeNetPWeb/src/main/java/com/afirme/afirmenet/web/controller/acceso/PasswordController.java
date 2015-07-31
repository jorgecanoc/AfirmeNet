package com.afirme.afirmenet.web.controller.acceso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.afirme.afirmenet.service.FinDiaService;
import com.afirme.afirmenet.service.acceso.PasswordService;
import com.afirme.afirmenet.web.model.Login;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@RequestMapping("/cambioPwd")
public class PasswordController {

	static final Logger LOG = LoggerFactory.getLogger(ControlAcceso.class);

	@Autowired
	private PasswordService passwordService;
	@Autowired
	private FinDiaService finDiaService;

	@RequestMapping(value = "/cambioPwd.htm", method = RequestMethod.POST)
	public String cambioPwd(@ModelAttribute("login") Login login, ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /cambioPwd/cambioPwd.htm");

		if (login.getContrato() == null) {
			// Timeout
			LOG.error("No se ha especificado el Contrato.");
			return AfirmeNetWebConstants.MV_LOGIN;
		}

		String finDiaError = finDiaService.getFinDia();

		if (finDiaError.equals("1")) {
			// Timeout
			return null;
		}
		
		if (finDiaError.equals("2")) {
			// Error
			return null;
		}

		return null;
	}

}
