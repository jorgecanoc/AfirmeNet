package com.afirme.afirmenet.service.impl.transferencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.helper.pagos.servicios.ValidacionesServicios;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.service.transferencia.ValidacionPagoServicioService;

@Service
public class ValidacionPagoServicioServiceImpl implements
		ValidacionPagoServicioService {

	@Autowired
	ValidacionesServicios validacionesServicios;

	@Override
	public void esServicioValido(Servicio servicio) throws AfirmeNetException {
		Map<CodigoExcepcion, String> errores = new HashMap<CodigoExcepcion, String>(
				0);
		switch (servicio.getTipoServicio()) {
		case AGUA_Y_DRENAJE_DE_MONTERREY:
			errores = validacionesServicios.validaAguaMonterrey(servicio);
			break;
		case ARRENDADORA_AFIRME:
			//No hay validaciones para Arrendadora
			break;
		case APORTACIONES_VOLUNTARIAS_EN_AFORE:
			//No hay validaciones para aportaciones
			break;
		case AXTEL:
			errores = validacionesServicios.validaAxtel(servicio);
			break;
		case CABLEVISION:

			break;
		case COMISION_DIA_ACTUAL_FAX:

			break;
		case COMISION_MES_ACTUAL_FAX:

			break;
		case COMISION_MES_ANTERIOR_FAX:

			break;
		case GAS_NATURAL_MEXICO:
			errores = validacionesServicios.validaCodigoGas(servicio, "M");
			break;
		case LUZ_CFE:
			errores = validacionesServicios.validaCFEMonterrey(servicio);
			break;
		case PAGO_COMAPA_AFIRMENET:
			errores = validacionesServicios.validaComapa(servicio);
			break;
		case PAGO_PEMEX:

			break;
		case PAGO_REFERENCIADO_SAT:

			break;
		case SEGUROS_AFIRME:

			break;
		case TARJETA_DE_CREDITO_BANCOS_RED:
			errores = validacionesServicios.validaTDCRed(servicio);
			break;
		case TELEFONOS_DE_MEXICO:

			break;

		default:
			break;
		}
		if (!errores.isEmpty()) {
			servicio.setErrores(errores);
		}
	}

	@Override
	public void sonServiciosValidos(List<Servicio> servicios)
			throws AfirmeNetException {
		for (Servicio servicio : servicios) {
			esServicioValido(servicio);
		}

	}

}
