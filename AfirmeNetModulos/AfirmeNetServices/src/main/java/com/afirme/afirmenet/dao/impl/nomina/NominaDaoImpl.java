package com.afirme.afirmenet.dao.impl.nomina;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.nomina.NominaDao;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.helper.nomina.NominaHelper;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.messages.CRNNOMI01Message;
import com.afirme.afirmenet.model.nomina.Nomina;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;

@Repository
public class NominaDaoImpl implements NominaDao {
	
	@Autowired
	AS400Dao as400Dao;
	
	static final Logger LOG = LoggerFactory.getLogger(NominaDaoImpl.class);
	
	@Override
	public Nomina validaCredito(Nomina nomina) {
		// Declaracion de Variables
		//Comprobante comprobante = null;
		CRNNOMI01Message afitrans = null;
		Socket socket = null;
		MessageContext messageContext = null;
		NominaHelper nominaHelper = new NominaHelper();
		// Invocacion del Socket
		try {
			socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP, AfirmeNetConstants.SOCKET_PUERTO + 6);
			messageContext = MessageContextFactory.getContext(socket);
		} catch (SocketFactoryException e) {
			throw new AfirmeNetException("0000", "Por el momento no se puede ejecutar su operacion.");
		} catch (MessageContextFactoryException e) {
			throw new AfirmeNetException("0001", "Por el momento no se puede ejecutar su operacion.");
		}

		try {
			// Incializa Bean de operacion
			afitrans = (CRNNOMI01Message) messageContext.getMessageRecord("CRNNOMI01");
			// Setea informacion en el bean de operacion
			nominaHelper.setAS400Data(afitrans, nomina);
			// Si el movimiento es Ejecucion de Credito(A) o Ejecucion de Abono(P), se añade el folio
			if (nomina.getMovimiento().equals("A") || nomina.getMovimiento().equals("P"))
				afitrans.setINFOLAUD(nomina.getFolio());
			// Envia peticion a AS400
			afitrans.send();
			afitrans.destroy();
			// Se evalua la respuesta de AS400
			//comprobante = nominaHelper.evaluaRespuestaAS400(messageContext, nomina);
			Nomina nominaResult = (Nomina) nominaHelper.evaluaRespuestaAS400(messageContext, nomina);
			
			if (nominaResult != null)
				return nominaResult;
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new AfirmeNetException("0003", "Por el momento no se puede ejecutar su operacion.");
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}

		return null;
	}

	@Override
	public List<Cuenta> getCuentasCreditoNomina(List<Cuenta> listadoCuentas) {
		
		String sql = 
			"SELECT ACMACC, ACMPRO, ACMATY " +
			"FROM " + AfirmeNetConstants.AS400_LIBRARY + "ACMST " +
			"WHERE ACMPRO IN ('AHN1', 'C004', 'ACO1', 'LI10', 'AE09', 'C003', 'C006', 'LI11') " +
			"AND ACMACC IN (";
		
		List<String> numerosCuenta = new ArrayList<String>();
		for (Cuenta cuenta : listadoCuentas) {
			numerosCuenta.add(cuenta.getNumber());
		}
		
		String cuentas = StringUtils.collectionToDelimitedString(numerosCuenta, ",");
		sql += cuentas + ")";
		
		List<Map<String, Object>> listResult;
		try {
			listResult = as400Dao.getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			LOG.error("Error al ejecutar query: " + e.getMessage());
			return null;
		}
		
		Set<Cuenta> setCuentas = new HashSet<Cuenta>();
		for (Map<String, Object> map : listResult) {
			Cuenta cuenta = new Cuenta();
			cuenta.setNumber(map.get("ACMACC").toString());
			setCuentas.add(cuenta);
		}
		
		return new ArrayList<Cuenta>(setCuentas);
	}

}
