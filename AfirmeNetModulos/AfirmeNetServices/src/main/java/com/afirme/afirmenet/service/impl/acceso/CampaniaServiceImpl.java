package com.afirme.afirmenet.service.impl.acceso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.CampaniaDao;
import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.model.DCMessageIni;
import com.afirme.afirmenet.model.DCMessageIni.TipoPublicidad;
import com.afirme.afirmenet.service.acceso.CampaniaService;
import com.afirme.afirmenet.utils.string.StringUtils;

/**
 * Clase que implementa los metodos definidos para el manejo de campañas en
 * afirmenet
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Service
public class CampaniaServiceImpl implements CampaniaService {

	@Autowired
	CampaniaDao campaniaDao;

	@Override
	public DCMessageIni getCampania(TipoCliente tipoCliente, String contrato,
			String usuarioId, String token) {
		DCMessageIni msg = campaniaDao.getCampania(tipoCliente, contrato,
				usuarioId, token);
		//Se descarta la publicidad vieja
		if( msg != null && msg.getMessage().contains(".jpg")){
			return null;
		}
		if (msg != null) {
			if(msg.getTipoPublicidad().equals(TipoPublicidad.AMBAS)){

				msg.setMessage(StringUtils.formateaMensaje(msg.getMessage(), "$b",
						null, "<strong>", "</strong>", false));
				msg.setTerminos(StringUtils.formateaMensaje(msg.getTerminos(),
						"$b", null, "<strong>", "</strong>", false));
				
			}
		}
		return msg;
	}

}
