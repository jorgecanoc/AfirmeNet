package com.afirme.afirmenet.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.afirme.afirmenet.exception.ResourceNotFoundException;


/**
 * Controller principal que atiende las peticiones genericas generadas por
 * errores especificios de HTTP como:
 * <ul>
 * <li>404: Recurso solicitado no encontrado</li>
 * <li>403: Acceso no autorizado a un recurso solicitado</li>
 * <li>500: Error inesperado del servidor</li>
 * </ul>
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Controller
public class HttpErrorController {
	static final Logger LOG = LoggerFactory.getLogger(HttpErrorController.class);

	/**
	 * Metodo que atiende las peticiones de la URL /404, esta peticion es
	 * cachada en el web.xml mediante el tag: error-page y obtiene el recurso
	 * que fue solicitado en el request original, para posterirormente lanzar la
	 * excepcion y esta sea cachada por {@link ResourceNotFoundException}
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/404")
	public void error404(HttpServletRequest req) {
		String originalUri = (String) req
				.getAttribute("javax.servlet.forward.request_uri");

		LOG.info("Recurso no encontrado ==> " + originalUri);
		throw new ResourceNotFoundException(originalUri);
	}
}
