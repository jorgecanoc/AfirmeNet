package com.afirme.afirmenet.service.impl.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.convenios.ConveniosDao;
import com.afirme.afirmenet.dao.pagos.PagosDao;
import com.afirme.afirmenet.dao.tarjetas.TDCDao;
import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.model.DCPermisoServicio;
import com.afirme.afirmenet.service.pagos.PagosService;

@Service
public class PagosServiceImpl implements PagosService {

	@Autowired
	private TDCDao tdcDao;

	@Autowired
	private PagosDao pagosDao;

	@Autowired
	private ConveniosDao conveniosDao;

	@Override
	public List<DC_CONVENIO> getConvenios(String contrato, String tipoPago) {
		return pagosDao.getConvenios(tdcDao.getListaBeanTDCAfirme(), contrato,
				tipoPago);
	}

	@Override
	public List<INSER> getConvenios400TDC() {
		return conveniosDao.getConvenios400TDC();
	}

	@Override
	public List<INSER> getConvenios400_TDCPROPIAS() {
		return conveniosDao.getConvenios400TDCPropias();
	}

	@Override
	public List<INSER> getConvenios400() {
		return conveniosDao.getConvListAS400(ConveniosDao.CONVENIOS_PAGOS
				.toString());

	}

	@Override
	public void activaServicios(String contractId, TipoCliente cliente) {
		conveniosDao.activaServicios(contractId, cliente);
	}

	@Override
	public DCPermisoServicio getActivacionServicios(String contractId,
			TipoCliente cliente) {
		return conveniosDao.getActivacionServicios(contractId, cliente);
	}

	@Override
	public List<DC_CONVENIO> getConveniosSeg(String contrato) {
		return pagosDao.getConveniosSeg(contrato);

	}

	@Override
	public List<INSER> getConveniosSeg400() {
		return conveniosDao.getConvListAS400(ConveniosDao.CONVENIOS_SEGUROS
				.toString());
	}

	@Override
	public INSER getConvenio(String sercom) {
		return conveniosDao.getConvenio(sercom);
	}

}
