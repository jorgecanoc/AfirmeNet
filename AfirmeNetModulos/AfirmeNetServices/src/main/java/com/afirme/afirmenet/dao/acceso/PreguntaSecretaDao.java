package com.afirme.afirmenet.dao.acceso;

import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.ibs.beans.PreguntaSecreta;

public interface PreguntaSecretaDao {
	
	public List<String> getPregunta(String idContrato);
	public String getPreguntaSecretaEncrypt(String idContrato, int idPregunta);
	public Map<String, String> getPregUsadas(String idContrato);
	public List<PreguntaSecreta> getListadoPreguntas();
	public boolean setPreguntaSecreta(String idContrato, int idPregunta, String pregunta, String respuesta);
	public boolean guardaPreguntaUsada(String idContrato, int idPregunta);
}
