package com.afirme.afirmenet.service.divisa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Divisa;

public interface DivisaService {

	/**
	 * Servico para realizar la validacion de la clave de 
	 * Transferencia proporcionado por AFIRME, retorna un objeto
	 * conteniendo la informacion de la divisa correspondiente a la
	 * transferencia a realizarse
	 * @param claveTransferencia
	 * @return instancia de Divisa con informacion referente, NULL
	 * si la clave no es valida.
	 */
	public Divisa validaClaveMultimoneda(String claveTransferencia);
	
	/**
	 * Servicio para recaudar la moneda, descripcion y tarifa del 
	 * cambio de moneda.
	 * @param tipoMoneda
	 * @return Mapa con informacion del cambio de moneda
	 */
	public Map<String, String> getInfoCambioMoneda(String tipoMoneda);
	
	/**
	 * Servicio que obtiene las comisinoes de las transferencias SWIFT
	 * hacia EU
	 * @param transferenciaUSD
	 * @return comision de la transferencia
	 */
	public BigDecimal getComisionSWIFT(boolean transferenciaUSD);
	
	/**
	 * Servicio para obtener la comision de acuerdo al monto de transferencia SWIFT
	 * @param monto
	 * @return comision
	 */
	public BigDecimal getComisionSWIFT(BigDecimal monto);
	
	/**
	 * Servicio que obtiene la lista de cuentas SWIFT asociadas a un contrato
	 * @param idContrato
	 * @return Lista de Cuentas
	 */
	public List<Divisa> getListaCuentasSWIFT(String idContrato, boolean intermediario);
	
	/**
	 * Servicio que obtiene la informacion de una cuenta SWIFT
	 * @param idUsuario
	 * @param idContratoSWIFT
	 * @param intermediario
	 * @return
	 */
	public Divisa getCuentaSWIFT(String idUsuario, String idContratoSWIFT, boolean intermediario);

	/**
	 * Almacena la Transferencia exitosa en la BD
	 * @param divisa
	 * @return TRUE si la insercion en la BD fue exitosa
	 */
	public boolean guardaTransferenciaExitosa(Divisa divisa, String afirmeNetReference);
}
