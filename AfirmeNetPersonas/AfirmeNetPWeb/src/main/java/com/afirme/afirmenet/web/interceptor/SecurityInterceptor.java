package com.afirme.afirmenet.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.afirme.afirmenet.utils.time.TimeUtils;

/**
 * Interceptor global de seguridad, esta clase intercepta todas las peticiones
 * que son solicitadas con el prefijo de la url /ebank/*
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {
	static final Logger LOG = LoggerFactory
			.getLogger(SecurityInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		LOG.info("afterCompletion ====>"
				+ TimeUtils.completeDateFormat.format(new Date()));

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {
		LOG.info(" postHandle ====>"
				+ TimeUtils.completeDateFormat.format(new Date()));

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		LOG.info("preHandle ====>"
				+ TimeUtils.completeDateFormat.format(new Date()));
		// TODO: Aqui se validaria que el usuario tenga una session valida, en
		// caso que sea valida retornar true en caso contrario hacer un redirect
		// response.sendRedirect(request.getContextPath() +"/error.htm"); y
		// retornal false

		return true;
	}

}
