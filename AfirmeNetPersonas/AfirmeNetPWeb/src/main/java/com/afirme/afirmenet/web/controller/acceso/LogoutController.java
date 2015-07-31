package com.afirme.afirmenet.web.controller.acceso;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.service.acceso.LogInService;
import com.afirme.afirmenet.web.controller.base.BaseController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@RequestMapping("/login")
public class LogoutController extends BaseController {

	static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LogInService logInService;

	@RequestMapping(value = "/logout.htm", method = RequestMethod.POST)
	public String logOutSeguro(ModelMap modelMap, HttpServletRequest request) {

		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		LOG.debug("Atendiendo Peticion = /login/contrato.htm contrato ===> "
				+ afirmeNetUser.getContrato());
		logInService.getAddLogPer(Util.getRefNum(),
				afirmeNetUser.getContrato(), "LOGIN", "USER LOGIN OK", "",
				"0.00", "", "OKL", Util.getRefNum());

		logInService.updateINOUT(afirmeNetUser.getContrato(), "N");
		logInService.updateBMUser(afirmeNetUser.getContrato(), "N");

		return AfirmeNetWebConstants.MV_LOGIN;
	}

}
