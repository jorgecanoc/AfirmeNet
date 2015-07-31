package com.afirme.afirmenet.web.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.web.controller.base.BaseController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

/**
 * Controller principal que atiende las peticiones mas genericas como /, /index,
 * /home, /inicio
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Controller
public class HomeController  extends BaseController{
	@RequestMapping("test/dispatcher")
	public String dispatcher(
			ModelMap model, HttpServletRequest request) {
		String nextAction = (String)request.getParameter("nextAction");
		if(nextAction.equals("123")){
			return AfirmeNetWebConstants.MV_HOME;
		}else{
			return "site/comun/testContenidoAjax";
		}
		
	}

	@RequestMapping("/esperando")
	public String esperando(@RequestParam(required = true) String nextAction,
			ModelMap model) {
		model.addAttribute("nextAction",nextAction);
		return "site/comun/progressBar";
	}

	/**
	 * Metodo que atiende las peticiones al contexto /
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping("/")
	public String home(ModelMap model) {
		return AfirmeNetWebConstants.MV_LOGIN;
	}

	/**
	 * Metodo que atiende las peticiones al contexto /login.htm
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping("/login.htm")
	public String login(ModelMap model) {
		return AfirmeNetWebConstants.MV_LOGIN;
	}

	/**
	 * Metodo que atiende las peticiones al contexto /index.htm
	 * 
	 * @param model
	 * @return pagina JSP
	 */
	@RequestMapping("/index.htm")
	public String index(ModelMap model) {
		return AfirmeNetWebConstants.MV_LOGIN;
	}

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap modelMap) {
		AfirmeNetUser afirmeNetUser = getSessionUser(request);
		if (afirmeNetUser != null) {
			List<Cuenta> cuentas=this.calculaResumeCuentas(afirmeNetUser, modelMap);
			request.getSession().setAttribute(AfirmeNetWebConstants.CUENTAS_SESSION, cuentas);
			return AfirmeNetWebConstants.MV_HOME;
		} else {
			return AfirmeNetWebConstants.MV_LOGIN;
		}
	}

}
