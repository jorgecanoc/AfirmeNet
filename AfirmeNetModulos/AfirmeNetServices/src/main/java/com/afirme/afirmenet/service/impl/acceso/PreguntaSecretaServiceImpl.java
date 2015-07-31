package com.afirme.afirmenet.service.impl.acceso;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.PreguntaSecretaDao;
import com.afirme.afirmenet.ibs.beans.PreguntaSecreta;
import com.afirme.afirmenet.ibs.objects.JOEncrypt;
import com.afirme.afirmenet.service.acceso.PreguntaSecretaService;

@Service
public class PreguntaSecretaServiceImpl implements PreguntaSecretaService {

	@Autowired
	private PreguntaSecretaDao preguntaDao;
	
	@Override
	public List<String> getPregunta(String idContrato) {
		return preguntaDao.getPregunta(idContrato);
	}

	@Override
	public String getPreguntaPersSecretaEncrypt(String idContrato, int idPregunta) {
		return preguntaDao.getPreguntaSecretaEncrypt(idContrato, idPregunta);
	}

	@Override
	public Map<String, String> getPregUsadas(String idContrato) {
		return preguntaDao.getPregUsadas(idContrato);
	}

	@Override
	public List<PreguntaSecreta> getListadoPreguntas() {
		return preguntaDao.getListadoPreguntas();
	}

	@Override
	public boolean setPreguntaPersSecreta(String idContrato, int idPregunta, String pregunta, String respuesta) {
		JOEncrypt encrypt = new JOEncrypt();
		return preguntaDao.setPreguntaSecreta(idContrato, idPregunta, pregunta, encrypt.getEncrypt(respuesta.toUpperCase()));
	}

	@Override
	public boolean guardaPreguntaUsada(String idContrato, int idPregunta) {
		return preguntaDao.guardaPreguntaUsada(idContrato, idPregunta);
	}
	
}
