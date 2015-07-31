package com.afirme.afirmenet.service.impl.transferencia;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.transferencia.TasaCambioPreferencialDao;
import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.beans.JBSIC001PF;
import com.afirme.afirmenet.ibs.databeans.cardif.SeguroCardif;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.model.transferencia.TransferenciaCuentasPropias;
import com.afirme.afirmenet.service.transferencia.TransferenciaAfirmeNet;
import com.afirme.afirmenet.service.transferencia.ValidacionEspecificaTransferenciaService;

@Service
public class ValidacionEspecificaTransferenciaServiceImpl implements
		ValidacionEspecificaTransferenciaService {

	@Autowired
	TasaCambioPreferencialDao tasaCambioPreferencialDao;

	@Override
	public void applyValidationsEspecific(
			List<TransferenciaCuentasPropias> tranferencias,
			TipoTransferencia tipo, List<TipoValidacionEspecial> validaciones) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);
		for (TransferenciaCuentasPropias tx : tranferencias) {

			for (TipoValidacionEspecial validacion : validaciones) {

				switch (validacion) {
				case CLAVE_CAMBIO_PREFERENCIAL:
					try {
						if (!tx.getOrigen().getCcy().trim()
								.equals(tx.getDestino().getCcy().trim())) {
							if(tx.getCveTasaPref()!=null && !tx.getCveTasaPref().equals("")){
								if (!this.isValidClave(
										(TransferenciaCuentasPropias) tx, tipo)) {
									// Almacena Error
									errors.put(
											CodigoExcepcion.ERR_3000,
											"La clave de tipo de cambio especial ingresada es incorrecta, favor de verificar");
								} else {
									if (!this.isClaveVencida(
											(TransferenciaCuentasPropias) tx, tipo)) {
										// Almacena Error
										errors.put(
												CodigoExcepcion.ERR_3000,
												"La clave de tipo de cambio especial ingresada está vencida, favor de verificar");
								       }
									tx.setAmount(tx.getCambioDolares().getOrigenAmt());
							   }
							}
						}

					} catch (Exception e) {
						errors.put(
								CodigoExcepcion.ERR_3000,
								"La clave de tipo de cambio especial ingresada es incorrecta, favor de verificar");
					}
					break;

				default:
					break;
				}

			}

			if (!errors.isEmpty()) {
				tx.setErrores(errors);
			}
		}
	}

	@Override
	public boolean isValidClave(TransferenciaCuentasPropias tranferenciaBase,
			TipoTransferencia tipo) throws AfirmeNetException {
		boolean goHead = true;

		JBSIC001PF transferTasaBean = tasaCambioPreferencialDao
				.validateCveTasaPreferencial(tranferenciaBase.getCveTasaPref());

		if (transferTasaBean == null) {
			return false;
		} else {
			transferTasaBean.setAmountOrigin(tranferenciaBase.getAmount());
			transferTasaBean.setCcyOrigin(tranferenciaBase.getOrigen().getCcy());
			tranferenciaBase.setCambioDolares(transferTasaBean);
		}

		return goHead;

	}

	@Override
	public boolean isClaveVencida(TransferenciaCuentasPropias tranferenciaBase,
			TipoTransferencia tipo) throws AfirmeNetException {
		boolean goHead = true;

		if (tranferenciaBase
				.getCambioDolares()
				.getSICDAT()
				.compareTo(
						new BigDecimal(20
								+ tranferenciaBase.getValidationYear()
								+ tranferenciaBase.getValidationMonth()
								+ tranferenciaBase.getValidationDay())) != 0)
			return false;

		return goHead;

	}

	@Override
	public void applicaValidaticioEspecifica(
			List<? extends TransferenciaBase> tranferencias,
			List<TipoValidacionEspecial> validaciones) {
		this.applicaValidaticioEspecifica(tranferencias, validaciones, null);
	}

	@Override
	public void applicaValidaticioEspecifica(
			List<? extends TransferenciaBase> tranferencias,
			List<TipoValidacionEspecial> validaciones, TransferenciaAfirmeNet servicio) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);
		for (TransferenciaBase tx : tranferencias) {

			for (TipoValidacionEspecial validacion : validaciones) {

				switch (validacion) {
				case SEGURO_CARDIF:
					try {
						SeguroCardifServiceImpl segurosPagoService= (SeguroCardifServiceImpl) servicio;
						
						SeguroCardif oBeanCardif =(SeguroCardif)tx;
						segurosPagoService.validacion(oBeanCardif);
					} catch (Exception e) {
						errors.put(
								CodigoExcepcion.ERR_3000,
								"No se ha podido validar la compra del seguro");
					}
					break;

				default:
					break;
				}

			}
		}
	}
}
