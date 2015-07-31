package com.afirme.afirmenet.web.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.AfirmeNetSessionExpiredException;
import com.afirme.afirmenet.exception.ResourceNotFoundException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.ibm.db2.jcc.a.SqlException;

/**
 * {@link @Controller} global que permite cachar y manejar todas las excepciones
 * generadas por las clases anotadas con {@link @Controller}
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@ControllerAdvice
public class GlobalExceptionController {
	static final Logger LOG = LoggerFactory
			.getLogger(GlobalExceptionController.class);

	/**
	 * Metodo que permite manejar las excepciones de tipo
	 * {@link SocketFactoryException} que se generan en la capa de servicios y
	 * son lanzadas a la capa del controlador
	 * 
	 * @param socketFactoryException
	 * @return pagina de error generica
	 */
	@ExceptionHandler(SocketFactoryException.class)
	public ModelAndView handleCustomException(
			SocketFactoryException socketFactoryException) {
		LOG.error("********Error al generar una coxion por Socket********",
				socketFactoryException);
		ModelAndView model = new ModelAndView("base/error/customError");
		model.addObject("errCode", socketFactoryException.getErrCode());
		model.addObject("errMsg", socketFactoryException.getErrMsg());
		
		return model;

	}

	/**
	 * Metodo que permite tratar las excepciones producidas en el controlador por intentos de reenvio de formularios
	 * 
	 * @param exception
	 * @return pagina de error generica
	 */
	@ExceptionHandler(HttpSessionRequiredException.class)
	public ModelAndView handleHttpSessionRequiredException(HttpSessionRequiredException exception) {
		LOG.error("##########Ocurrio una excepcion Inesperada#############",
				exception);
		ModelAndView model = new ModelAndView("base/error/genericError");
		model.addObject("errMsg",
				"Se genero un error al tratar de enviar su petición en más de 1 ocasión, le sugerimos revisar el movimientos efectuados");
		model.addObject("titleError", "Afirmenet detecto un error al procesar su información");
		return model;

	}
	
	/**
	 * Metodo que permite tratar las excepciones generales no clasificadas generadas en
	 * la capa del controlador
	 * 
	 * @param exception
	 * @return pagina de error generica
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception exception) {
		LOG.error("##########Ocurrio una excepcion Inesperada#############",
				exception);
		ModelAndView model = new ModelAndView("base/error/genericError");
		model.addObject("errMsg",
				"Ocurrio un error, por favor intente mas tarde");
		model.addObject("titleError", "Ocurrio un Error");
		return model;

	}

	/**
	 * Metodo que permite cachar y evaluar los errores ocacionados por un codigo
	 * HTTP 404
	 * 
	 * @param resourceNotFoundException
	 * @return pagina de error generica
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleResourceNotFoundException(
			ResourceNotFoundException resourceNotFoundException) {
		LOG.error(
				"|||||||Se genero un error al solicitar un recurso no localizado|||||||||",
				resourceNotFoundException);
		ModelAndView model = new ModelAndView("base/error/genericError");
		model.addObject("errMsg", "El recurso solicitado no fue encontrado: "
				+ resourceNotFoundException.getResourceNotFound());
		return model;
	}

	@ExceptionHandler(SqlException.class)
	public ModelAndView handleSQLException(SqlException sqlException){
		LOG.error("$$$$$$Ocurrio una excepcion de SQL $$$$$$",
				sqlException);
		ModelAndView model = new ModelAndView("base/error/genericError");
		model.addObject("errMsg",
				"Ocurrio un error, por favor intente mas tarde");
		return model;
	}

	/**
	 * Metodo que permite manejar las excepciones de tipo
	 * {@link AfirmeNetException} que se generan en la capa de servicios y
	 * son lanzadas a la capa del controlador
	 * 
	 * @param socketFactoryException
	 * @return pagina de error generica
	 */
	@ExceptionHandler(AfirmeNetException.class)
	public ModelAndView handleCustomException(
			AfirmeNetException afirmeNetException) {
		LOG.error("********Error al generar una coxion por Socket********",
				afirmeNetException);
		ModelAndView model = new ModelAndView("base/error/genericError");
		model.addObject("errMsg", afirmeNetException.getErrMsg());
		model.addObject("titleError", "Por el momento el AfirmeNet no puede procesar su petición");
		return model;

	}	
	
	/**
	 * Metodo que permite manejar las excepciones de tipo
	 * {@link SocketFactoryException} que se generan en la capa de servicios y
	 * son lanzadas a la capa del controlador
	 * 
	 * @param socketFactoryException
	 * @return pagina de error generica
	 */
	@ExceptionHandler(AfirmeNetSessionExpiredException.class)
	public ModelAndView handleSessionExpiredException(
			AfirmeNetSessionExpiredException exception) {
		LOG.info("********La session expiro********",exception);
		ModelAndView model = new ModelAndView("base/error/genericError");
		model.addObject("errMsg", "La sesion expiro, ingrese nuevamente");
		model.addObject("titleError", "Por el momento el AfirmeNet no puede procesar su petición");
		return model;

	}
	
}
