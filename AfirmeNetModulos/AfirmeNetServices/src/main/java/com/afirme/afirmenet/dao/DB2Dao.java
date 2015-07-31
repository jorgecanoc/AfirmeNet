package com.afirme.afirmenet.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

/**
 * Clase de Servicio que encapsula el {@link DataSource} definido para DB2 y
 * provee el {@link JdbcTemplate} especificio para DB2
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Component
public class DB2Dao {
	static final Logger LOG = LoggerFactory.getLogger(DB2Dao.class);

	/**
	 * Datasource vinculado ala BD de BD2
	 */
	@Autowired
	private DataSource db2DataSource;

	/**
	 * retorna el {@link DataSource} en caso que se requiera realizar una
	 * conexion JDBC
	 * 
	 * @return the db2DataSource
	 */
	public DataSource getDb2DataSource() {
		return db2DataSource;
	}

	/**
	 * Retorna {@link JdbcTemplate} creado apartir del {@link DataSource} de DB2
	 * 
	 * @return jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(db2DataSource);
	}

	/**
	 * Retorna {@link SimpleJdbcCall} creado apartir del {@link DataSource} de
	 * DB2
	 * 
	 * @return
	 */
	public SimpleJdbcCall getSimpleJdbcCall() {
		return new SimpleJdbcCall(db2DataSource);
	}
}
