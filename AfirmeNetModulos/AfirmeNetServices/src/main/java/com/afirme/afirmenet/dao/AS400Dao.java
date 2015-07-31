package com.afirme.afirmenet.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

/**
 * Clase de Servicio que encapsula el {@link DataSource} definido para AS400 y
 * provee el {@link JdbcTemplate} especificio para AS400
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Component
public class AS400Dao {

	@Autowired
	private DataSource as400DataSource;

	/**
	 * Retorna {@link JdbcTemplate} creado apartir del {@link DataSource} de DB2
	 * 
	 * @return jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(as400DataSource);
	}

	/**
	 * retorna el {@link DataSource} en caso que se requiera realizar una
	 * conexion JDBC
	 * 
	 * @return the as400DataSource
	 */
	public DataSource getAs400DataSource() {
		return as400DataSource;
	}


	/**
	 * Retorna {@link SimpleJdbcCall} creado apartir del {@link DataSource} de
	 * DB2
	 * 
	 * @return
	 */
	public SimpleJdbcCall getSimpleJdbcCall() {
		return new SimpleJdbcCall(as400DataSource);
	}	
}
