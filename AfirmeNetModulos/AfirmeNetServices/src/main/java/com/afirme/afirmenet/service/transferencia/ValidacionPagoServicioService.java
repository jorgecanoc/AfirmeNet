package com.afirme.afirmenet.service.transferencia;

import java.util.List;

import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;

public interface ValidacionPagoServicioService {
	/**
	 * Valida el servicio de acuerdo al tipo de servicio se validara,
	 * referencia, fecha de vencimiento, monto
	 * 
	 * @param servicio
	 * @return
	 * @throws AfirmeNetException
	 */
	void sonServiciosValidos(List<Servicio> servicios) throws AfirmeNetException;

	/**
	 * Valida el servicio de acuerdo al tipo de servicio se validara,
	 * referencia, fecha de vencimiento, monto
	 * 
	 * @param servicio
	 * @return
	 * @throws AfirmeNetException
	 */
	void esServicioValido(Servicio servicio) throws AfirmeNetException;

}
