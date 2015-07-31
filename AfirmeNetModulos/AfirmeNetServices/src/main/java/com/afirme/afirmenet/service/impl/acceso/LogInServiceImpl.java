package com.afirme.afirmenet.service.impl.acceso;

import java.io.IOException;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.LogInDao;
import com.afirme.afirmenet.dao.convenios.ConveniosDao;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.exception.MessageContextFactoryException;
import com.afirme.afirmenet.exception.SocketFactoryException;
import com.afirme.afirmenet.ibs.beans.JBBMuser;
import com.afirme.afirmenet.ibs.beans.JBLogList;
import com.afirme.afirmenet.ibs.beans.JBLogin;
import com.afirme.afirmenet.ibs.beans.JBProCode;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.ibs.messages.INLOGIN02Message;
import com.afirme.afirmenet.service.acceso.LogInService;
import com.afirme.afirmenet.service.acceso.ParametricasLoginService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	private ConveniosDao conveniosDao;

	@Autowired
	private LogInDao loginDao;	
	
	@Autowired
	private ParametricasLoginService parametricasLoginService;

	@Override
	public boolean verificarPrimerLoginConAlias(String UserIdJSP) {
		return loginDao.verificarPrimerLoginConAlias(UserIdJSP);
	}

	@Override
	public boolean actualizarPrimerLoginConAlias(String UserIdJSP) {
		return loginDao.actualizarPrimerLoginConAlias(UserIdJSP);
	}

	@Override
	public String consultaIP(String UserIdJSP, String UserId) {
		return loginDao.consultaIP(UserIdJSP, UserId);
	}

	@Override
	public boolean insertaIP(String UserIdJSP, String UserId, String ip) {
		return loginDao.insertaIP(UserIdJSP, UserId, ip);
	}

	@Override
	public boolean actualizaIP(String UserIdJSP, String UserId, String ip,
			String estatus) {
		return loginDao.actualizaIP(UserIdJSP, UserId, ip, estatus);
	}

	@Override
	public boolean updateINOUT(String UserIdJSP, String Estatus) {
		return loginDao.updateINOUT(UserIdJSP, Estatus);
	}

	@Override
	public boolean updateBMUser(String UserIdJSP, String Estatus) {
		return loginDao.updateBMUser(UserIdJSP, Estatus);
	}

	@Override
	public boolean updateBMUser(String UserIdJSP) {
		return loginDao.updateBMUser(UserIdJSP);
	}

	@Override
	public JBBMuser verificaBMUser(String UserIdJSP) {

		JBBMuser bmuser = loginDao.getBMUser(UserIdJSP);
		bmuser.setActivo(false);
		if (bmuser.getEstatus().equals("")) {
			// no tiene contrato afirme movil
		} else if (bmuser.getEstatus().equals("N")) {
			loginDao.updateBMUser(UserIdJSP, "S");
		} else if (bmuser.getEstatus().equals("S")) {

			String ultimoLogIn = bmuser.getFechaLogIn() + bmuser.getHoraLogIn();
			String ultimaActiv = bmuser.getFechaTrx() + bmuser.getHoraTrx();

			// Si no encontro datos entonces toma un default
			if (ultimoLogIn.length() < 14)
				ultimoLogIn = "20070301000000";
			if (ultimaActiv.length() < 14)
				ultimaActiv = "20070301000000";

			if (Long.parseLong(ultimoLogIn) > Long.parseLong(ultimaActiv)) {
				ultimaActiv = ultimoLogIn;
			}

			GregorianCalendar ultimaActividad = new GregorianCalendar();
			int year = Integer.parseInt(ultimaActiv.substring(0, 4));

			ultimaActividad.set(year,
					Integer.parseInt(ultimaActiv.substring(4, 6)) - 1,
					Integer.parseInt(ultimaActiv.substring(6, 8)),
					Integer.parseInt(ultimaActiv.substring(8, 10)),
					Integer.parseInt(ultimaActiv.substring(10, 12)),
					Integer.parseInt(ultimaActiv.substring(12, 14)));
			bmuser.setEspera(loginDao.getSegundosSignOff());
			ultimaActividad.add(Calendar.SECOND, bmuser.getEspera());
			GregorianCalendar fechaActual = new GregorianCalendar();

			if (fechaActual.before(ultimaActividad)) {
				bmuser.setActivo(true);
			} else {
				bmuser.setActivo(false);
			}

		}
		return bmuser;
	}

	@Override
	public boolean verificaINOUT(String UserIdJSP) {

		boolean activo = false;
		String inout = loginDao.getINOUT(UserIdJSP);
		if (inout.equals("")) {
			loginDao.insertaINOUT(UserIdJSP);
		} else if (inout.equals("N")) {
			loginDao.updateINOUT(UserIdJSP, "Y");
		} else if (inout.equals("Y")) {
			// Obtiene fecha del ultimo acceso
			String ultimaActiv = loginDao.getLTime(UserIdJSP);
			// Si no encontro datos entonces toma un default
			if (ultimaActiv.length() < 12)
				ultimaActiv = "070301000000";
			GregorianCalendar ultimaActividad = new GregorianCalendar();
			int year = Integer.parseInt(ultimaActiv.substring(0, 2));
			if (year >= 90)
				year += 1900;
			else
				year += 2000;
			ultimaActividad.set(year,
					Integer.parseInt(ultimaActiv.substring(2, 4)) - 1,
					Integer.parseInt(ultimaActiv.substring(4, 6)),
					Integer.parseInt(ultimaActiv.substring(6, 8)),
					Integer.parseInt(ultimaActiv.substring(8, 10)),
					Integer.parseInt(ultimaActiv.substring(10, 12)));
			ultimaActividad.add(Calendar.MINUTE, 20);
			GregorianCalendar fechaActual = new GregorianCalendar();

			if (fechaActual.before(ultimaActividad)) {
				activo = true;
			} else {
				activo = false;
			}
		}
		return activo;
	}

	@Override
	public JBLogin getUserLogin(String UserIdJSP, String UserPassJSP) throws AfirmeNetException {
		try {
		JBLogin login = new JBLogin();

		// establece conexion con socket
		Socket socket;

			socket = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP,
					AfirmeNetConstants.SOCKET_PUERTO, 0);

			// prepara el mensaje
			MessageContext messageContext = MessageContextFactory
					.getContext(socket);
			// prepara mensaje con nuevos parámetros
			INLOGIN02Message password = (INLOGIN02Message) messageContext
					.getMessageRecord("INLOGIN02");

			password.setPWDUSR(UserIdJSP);
			password.setPWDPWD(UserPassJSP);
			password.setPWDLGT("2");

			password.send();
			password.destroy();

			MessageRecord newMessage = messageContext.receiveMessage();
			System.out.println("Login: "+ newMessage);
			login.setFormatName(((INLOGIN02Message) newMessage).getFormatName()
					.trim());
			login.setPWDUSR(((INLOGIN02Message) newMessage).getPWDUSR().trim());
			login.settCliente(((INLOGIN02Message) newMessage).getPWDLGT()
					.trim());
			login.setEmail(((INLOGIN02Message) newMessage).getPWDIAD().trim());
			login.setStatus(((INLOGIN02Message) newMessage).getPWDSTS().trim());
			login.setEussts(((INLOGIN02Message) newMessage).getPWDEST().trim());
			login.setUserMAXI(((INLOGIN02Message) newMessage).getPWDMAX());
			login.setGroupID(((INLOGIN02Message) newMessage).getPWDBUC().trim());
			login.setAlias(((INLOGIN02Message) newMessage).getPWDALIAS().trim());
			login.setkID(((INLOGIN02Message) newMessage).getPWDKID().trim());
			login.setSuc2(((INLOGIN02Message) newMessage).getPWDSUC().trim());
			login.setCliente(((INLOGIN02Message) newMessage).getPWDCUN().trim());
			login.setGrpId(((INLOGIN02Message) newMessage).getPWDGRP().trim());
			login.setNombreCliente(((INLOGIN02Message) newMessage).getPWDNME()
					.trim());
			login.setOfficerName(((INLOGIN02Message) newMessage).getPWDOFC()
					.trim());
			login.setOfficerEmail(((INLOGIN02Message) newMessage).getPWDEML()
					.trim());
			login.setEsPatrimonial(((INLOGIN02Message) newMessage).getPWDPAT()
					.trim());
			login.setFDate(((INLOGIN02Message) newMessage).getPWDDTF());

			socket.close();

			return login;
		} catch (SocketFactoryException e) {
			throw new AfirmeNetException("0000","El sistema no se encuentra disponible por el momento : "  + e.getErrMsg());
		} catch (MessageContextFactoryException e) {
			throw new AfirmeNetException("0000","El sistema no se encuentra disponible por el momento : "  + e.getErrMsg());
		} catch (IOException e) {
			throw new AfirmeNetException("0000","El sistema no se encuentra disponible por el momento : "  + e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new AfirmeNetException("0000","El sistema no se encuentra disponible por el momento : "  + e.getMessage());		
		} catch (IllegalAccessException e) {
			throw new AfirmeNetException("0000","El sistema no se encuentra disponible por el momento : "  + e.getMessage());
		} catch (InstantiationException e) {
			throw new AfirmeNetException("0000","El sistema no se encuentra disponible por el momento : "  + e.getMessage());
		}

	}

	@SuppressWarnings("unused")
	@Override
	public void defaultSetting(String userIdJSP, String groupId,
			List<Cuenta> cuentas, List<JBProCode> procode) {

		// Carga lista de servicios basicos
		List<INSER> servicios = conveniosDao.getConvListAS400(ConveniosDao.CONVENIOS_LOGIN.toString());
		//YA LO TENGO EN LA LISTA DE CUENTASS
		// JBSummaryC summarybeanC = (JBSummaryC) session.getAttribute("summarybeanC");
		//LO PASO COMO PARAMETRO EN LA LISTA DE PROCODE
		// JBProCodeList pcl = (JBProCodeList) session.getAttribute("procodelistbean");
	
		//FALTA IMPLEMENTAR
		// summarybeanC = removeDuplicateAccount(summarybeanC);
		
		// ParamOwnAccBL.transactionSettings(Long.valueOf(userIdJSP).longValue(), groupId, summarybeanC, beanServicios, pcl);
		parametricasLoginService.transactionSettings(Long.valueOf(userIdJSP).longValue(), groupId, cuentas, servicios, procode);

	}

	@Override
	public JBLogList getLastLoginPer(String contrato) {
		return loginDao.getLastLoginPer(contrato);

	}

	@Override
	public void getAddLogPer(String DTTM, String USERID, String LACTION,
			String REMARK, String ACCOUNT, String AMOUNT, String CURRENCY,
			String TYP_TRAN, String DCIBS_REF) {
		loginDao.getAddLogPer(DTTM, USERID, LACTION, REMARK, ACCOUNT, AMOUNT,
				CURRENCY, TYP_TRAN, DCIBS_REF);

	}

	@Override
	public List<JBProCode> getProcode(boolean bPaqueteSinToken) {
		return loginDao.getProcode(bPaqueteSinToken);
	}

	@Override
	public void lookupChangeParameter(String contrato) {
	      try
	      {
	    	  parametricasLoginService.lookUpChangeParameter(Long.valueOf(contrato).longValue());
	      }
	      catch (NumberFormatException e)
	      {
	         System.out.println(e);
	         throw new AfirmeNetException("3000"," No se pudo actualizar los límites de transferencia. Por favor, contacte a su administrador. ");
	      }
	      catch (Exception e)
	      {
	         System.out.println(e);
	         throw new AfirmeNetException("3000"," No se pudo actualizar los límites de transferencia. Por favor, contacte a su administrador. ");
	      }
		
	}


}
