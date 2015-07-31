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
 * Interceptor global, esta clase intercepta todas las peticiones que son
 * realizadas a la aplicacion
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class GlobalIntercerptor implements HandlerInterceptor {
	static final Logger LOG = LoggerFactory.getLogger(GlobalIntercerptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		LOG.info("afterCompletion ====>"
				+ TimeUtils.completeDateFormat.format(new Date()));

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		LOG.info(" postHandle ====>"
				+ TimeUtils.completeDateFormat.format(new Date()));

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		LOG.info("preHandle ====>"
				+ TimeUtils.completeDateFormat.format(new Date()));
		return true;
	}

}
