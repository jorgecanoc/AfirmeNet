package com.afirme.afirmenet.service.transferencia;

import java.util.List;

import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

public interface TransferenciaAfirmeNet {

	public <T extends TransferenciaBase> ComprobanteTransferencia ejecutaTransferencia(
			T TransferenciaBase) throws AfirmeNetException;

	public List<? extends ComprobanteTransferencia> ejecutaTransferencia(
			List<TransferenciaBase> transferencias);

}
