package com.afirme.afirmenet.dao.divisas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Divisa;

public interface DivisaDao {

	/**
	 * Metodo para validar la clave de Transferencia proporcionada por AFIRME
	 * al usuario previo a la realizacion de una Transferencia Multimoneda
	 * @param claveTransferencia
	 * @return Instancia de Divisa, NULL si la clave de Transferencia no es valida. 
	 */
	public Divisa validaClaveMultimoneda(String claveTransferencia);
	
	/**
	 * Metodo que retorna la tarifa del tipo de cambio de moneda especificada.
	 * @param tipoMoneda
	 * @return Mapa conteniendo: moneda, descripcion y tarifa del cambio de moneda
	 */
	public Map<String, String> getInfoCambioMoneda(String tipoMoneda);
	
	/**
	 * Obtiene la comision de transferencia SWIFT hacia EU
	 * @param transferenciaUSD
	 * @return comision
	 */
	public BigDecimal getComisionSWIFT(boolean transferenciaUSD);
	
	/**
	 * Obtiene la comision de transferencia SWIFT hacia un destino distinto a EU 
	 * @param monto
	 * @return
	 */
	public BigDecimal getComisionSWIFT(BigDecimal monto);
	
	/**
	 * Obtiene el listado de cuentas SWIFT asociadas al contrato
	 * @param idContrato
	 * @param idUsuario
	 * @return
	 */
	public List<Divisa> getListaCuentasSWIFT(String idContrato, boolean intermediario);
	
	/**
	 * Obtiene la inforamcion de una cuenta SWIFT
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
