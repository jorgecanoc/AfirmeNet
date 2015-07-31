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
	 * M�todo que obtiene listado de ID's y Preguntas secretas asociadas 
	 * al ID de Contrato definido.
	 * @param idContrato
	 * @return Lista de preguntas secretas.
	 */
	public List<String> getPregunta(String idContrato);
	
	/**
	 * M�todo que obtiene la respuesta encriptada de la Pregunta
	 * Secreta a partir del ID de Contrato y ID Pregunta.
	 * @param idContrato
	 * @param idPregunta
	 * @return Respuesta encriptada de la pregunta secreta del contrato.
	 */
	public String getPreguntaPersSecretaEncrypt(String idContrato, int idPregunta);
	
	/**
	 * M�todo que obtiene el Mapa de la asociaci�n de ID Preguntas y su
	 * ID Contrato a partir de un Contrato definido. 
	 * @param idContrato
	 * @return Mapa<ID Pregunta, ID Contrato>
	 */
	public Map<String, String> getPregUsadas(String idContrato);
	
	/**
	 * M�todo que obtiene el listado general de Preguntas Secretas.
	 * @return Listado de Preguntas Secretas
	 */
	public List<PreguntaSecreta> getListadoPreguntas();
	
	/**
	 * M�todo que Guarda la Pregunta Secreta asociada al ID de Contrato con
	 * su respectiva Respuesta definida. Si la Pregunta Secreta ya fue previamente
	 * respondida, �sta es actualizada por la nueva Respuesta.
	 * @param idContrato
	 * @param idPregunta
	 * @param pregunta
	 * @param respuesta
	 * @return TRUE si no hubo errores al efectuarse la operaci�n.
	 */
	public boolean setPreguntaPersSecreta(String idContrato, int idPregunta, String pregunta, String respuesta);
	
	/**
	 * M�todo que almacena la asociaci�n del ID Contrato y ID Pregunta,
	 * indicando que �sta ya ha sido respondida. 
	 * @param idContrato
	 * @param idPregunta
	 * @return TRUE si hubo errores al efectuarse la operaci�n.
	 */
	public boolean guardaPreguntaUsada(String idContrato, int idPregunta);
}
