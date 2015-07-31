package com.afirme.afirmenet.service.impl.divisa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.divisas.DivisaDao;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Divisa;
import com.afirme.afirmenet.service.divisa.DivisaService;

@Service
public class DivisaServiceImpl implements DivisaService {

	@Autowired
	DivisaDao divisaDao;
	
	@Override
	public Divisa validaClaveMultimoneda(String claveTransferencia) {
		return divisaDao.validaClaveMultimoneda(claveTransferencia);
	}

	@Override
	public Map<String, String> getInfoCambioMoneda(String tipoMoneda) {
		return divisaDao.getInfoCambioMoneda(tipoMoneda);
	}

	@Override
	public BigDecimal getComisionSWIFT(boolean transferenciaUSD) {
		return divisaDao.getComisionSWIFT(transferenciaUSD);
	}

	@Override
	public BigDecimal getComisionSWIFT(BigDecimal monto) {
		return divisaDao.getComisionSWIFT(monto);
	}

	@Override
	public List<Divisa> getListaCuentasSWIFT(String idContrato, boolean intermediario) {
		return divisaDao.getListaCuentasSWIFT(idContrato, intermediario);
	}

	@Override
	public Divisa getCuentaSWIFT(String idUsuario, String idContratoSWIFT, boolean intermediario) {
		return divisaDao.getCuentaSWIFT(idUsuario, idContratoSWIFT, intermediario);
	}

	@Override
	public boolean guardaTransferenciaExitosa(Divisa divisa, String afirmeNetReference) {
		return divisaDao.guardaTransferenciaExitosa(divisa, afirmeNetReference);
	}

}
