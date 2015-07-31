package com.afirme.afirmenet.service.impl.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.pagos.ConveniosDomiciliacionDao;
import com.afirme.afirmenet.model.pagos.ConvenioDomiciliacion;
import com.afirme.afirmenet.service.pagos.ConveniosDomiciliacionService;

@Service
public class ConveniosDomiciliacionServiceImpl implements
		ConveniosDomiciliacionService {

	@Autowired
	ConveniosDomiciliacionDao conveniosDao;
	
	@Override
	public List<ConvenioDomiciliacion> getServiciosBasicos400() {
		return conveniosDao.getServiciosBasicos400();
	}

	@Override
	public List<ConvenioDomiciliacion> getContratoServicioDomiciliacion(String contrato) {
		return conveniosDao.getContratoServicioDomiciliacion(contrato);
	}

	@Override
	public ConvenioDomiciliacion getInfoServicioDomiciliacion(int folio) {
		return conveniosDao.getInfoServicioDomiciliacion(folio);
	}

	@Override
	public List<ConvenioDomiciliacion> getHistorialMovimientos(
			ConvenioDomiciliacion convenio, String fechaInicio, String fechaFin) {
		return conveniosDao.getHistorialMovimientos(convenio, fechaInicio,
				fechaFin);
	}

}
