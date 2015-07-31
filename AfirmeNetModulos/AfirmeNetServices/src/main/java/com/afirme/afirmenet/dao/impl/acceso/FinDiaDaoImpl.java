package com.afirme.afirmenet.dao.impl.acceso;

import java.io.IOException;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.acceso.FinDiaDao;
import com.afirme.afirmenet.ibs.messages.EODDSJVMessage;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

@Repository
public class FinDiaDaoImpl implements FinDiaDao {

	static final Logger LOG = LoggerFactory.getLogger(FinDiaDaoImpl.class);

	@Override
	public String getFinDia() {
		LOG.debug("Obteniendo información de Fin de Día.");

		String sqlerror = "1";

		GregorianCalendar fechaHoy = new GregorianCalendar();
		GregorianCalendar fechaRevisarMin = new GregorianCalendar();
		fechaRevisarMin.set(Calendar.HOUR_OF_DAY, 8);
		fechaRevisarMin.set(Calendar.MINUTE, 0);
		fechaRevisarMin.set(Calendar.SECOND, 0);
		fechaRevisarMin.set(Calendar.MILLISECOND, 0);
		GregorianCalendar fechaRevisarMax = new GregorianCalendar();
		//Algo esta mal cuando hace la consulta al bean da timeout y la version anterior no
		fechaRevisarMax.set(Calendar.HOUR_OF_DAY, 22);
		//fechaRevisarMax.set(Calendar.HOUR_OF_DAY, 20);
		fechaRevisarMax.set(Calendar.MINUTE, 0);
		fechaRevisarMax.set(Calendar.SECOND, 0);
		fechaRevisarMax.set(Calendar.MILLISECOND, 0);

		// Se valida Fin Dia (EOD) cuando la aplicacion se encuentre fuera del siguiente rango
		if (fechaHoy.after(fechaRevisarMin) && fechaHoy.before(fechaRevisarMax)) {
			sqlerror = "0";
		} else {

			Socket socket = null;

			try {
				// establece conexion con socket
				socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP,
						AfirmeNetConstants.SOCKET_PUERTO,
						AfirmeNetConstants.SOCKET_PORT_SUMARY,
						AfirmeNetConstants.SOCKET_TIMEOUT + 10000);
				// prepara el mensaje
				MessageContext messageContext = MessageContextFactory.getContext(socket);

				EODDSJVMessage eodMsg = (EODDSJVMessage) messageContext.getMessageRecord("EODDSJV");

				LOG.debug("Obteniendo Message de Socket...");
				eodMsg.send();
				eodMsg.destroy();

				MessageRecord newMessage = messageContext.receiveMessage();

				if (newMessage.getFormatName().equals("EODDSJV")) {

					String EODF = ((EODDSJVMessage) newMessage).getEODFLG();

					if (EODF.equals("Y"))
						sqlerror = "2";
					else
						sqlerror = "0";
				}
				
			} catch (Exception e) {
				LOG.error("Error en el socket para EOD DIBS " + e);
			} finally {
				
				try {
					if (socket == null) {
						LOG.error("Error al cerrar el socket para EOD DIBS, el socket es nulo");
						sqlerror = "2";
					} else
						socket.close();
				} catch (IOException e) {
					LOG.error("Error al cerrar el socket para EOD DIBS " + e);
				}
			}
		}

		return sqlerror;
	}

}
