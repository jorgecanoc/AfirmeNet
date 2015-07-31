package com.afirme.afirmenet.service.acceso;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.ibs.beans.PreguntaSecreta;

/**
 * @author 0cdcarguz
 *
 */
public interface PreguntaSecretaService {
	
	/**
	 * Método que obtiene listado de ID's y Preguntas secretas asociadas 
	 * al ID de Contrato definido.
	 * @param idContrato
	 * @return Lista de preguntas secretas.
	 */
	public List<String> getPregunta(String idContrato);
	
	/**
	 * Método que obtiene la respuesta encriptada de la Pregunta
	 * Secreta a partir del ID de Contrato y ID Pregunta.
	 * @param idContrato
	 * @param idPregunta
	 * @return Respuesta encriptada de la pregunta secreta del contrato.
	 */
	public String getPreguntaPersSecretaEncrypt(String idContrato, int idPregunta);
	
	/**
	 * Método que obtiene el Mapa de la asociación de ID Preguntas y su
	 * ID Contrato a partir de un Contrato definido. 
	 * @param idContrato
	 * @return Mapa<ID Pregunta, ID Contrato>
	 */
	public Map<String, String> getPregUsadas(String idContrato);
	
	/**
	 * Método que obtiene el listado general de Preguntas Secretas.
	 * @return Listado de Preguntas Secretas
	 */
	public List<PreguntaSecreta> getListadoPreguntas();
	
	/**
	 * Método que Guarda la Pregunta Secreta asociada al ID de Contrato con
	 * su respectiva Respuesta definida. Si la Pregunta Secreta ya fue previamente
	 * respondida, ésta es actualizada por la nueva Respuesta.
	 * @param idContrato
	 * @param idPregunta
	 * @param pregunta
	 * @param respuesta
	 * @return TRUE si no hubo errores al efectuarse la operación.
	 */
	public boolean setPreguntaPersSecreta(String idContrato, int idPregunta, String pregunta, String respuesta);
	
	/**
	 * Método que almacena la asociación del ID Contrato y ID Pregunta,
	 * indicando que ésta ya ha sido respondida. 
	 * @param idContrato
	 * @param idPregunta
	 * @return TRUE si hubo errores al efectuarse la operación.
	 */
	public boolean guardaPreguntaUsada(String idContrato, int idPregunta);
}
