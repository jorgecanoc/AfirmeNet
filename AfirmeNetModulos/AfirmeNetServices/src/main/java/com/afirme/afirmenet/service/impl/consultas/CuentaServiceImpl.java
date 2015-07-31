package com.afirme.afirmenet.service.impl.consultas;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.consultas.CuentaDao;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.beans.consultas.Resumen;
import com.afirme.afirmenet.ibs.databeans.ACCTHIRDUSER;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.ibs.messages.ILN006001Message;
import com.afirme.afirmenet.ibs.messages.SUMDSJVMessage;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.transferencia.CuentaTercerosService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.socket.MessageContextFactory;
import com.afirme.afirmenet.utils.socket.SocketFactory;
import com.datapro.sockets.MessageContext;
import com.datapro.sockets.MessageRecord;

@Service
public class CuentaServiceImpl implements CuentaService {
	static final Logger LOG = LoggerFactory.getLogger(CuentaServiceImpl.class);
	@Autowired
	private CuentaDao cuentaDao;

	@Autowired
	private CuentaTercerosService tercerosService;

	@Override
	public List<Cuenta> getCuentas(String contrato, String cuentasExcluyentes,boolean conInfoExtra) {
		LOG.info("Entrando a getCuentas con el contrato '" + contrato
				+ "' y cuentas excluyentes '" + cuentasExcluyentes + "'");
		Socket s = null;
		MessageContext mc = null;
		MessageRecord newmessage = null;
		SUMDSJVMessage summary = null;
		List<Cuenta> lista = new ArrayList<Cuenta>();
		// JBNick nickbean;
		// ::TODO:: Definir constante NickMSGS="Alias no definido"
		// String NickMSGS="Alias no definido";
		// ::TODO:: Definir constante htmlConsultas
		String htmlConsultas = "detalle-ultimos-movimientos.htm";
		String htmlConsultasBonus = "detalle-ultimos-movimientos.htm";
		String htmlConsultasLNS = "detalle-ultimos-movimientos.htm";
		String htmlConsultasCDS = "detalle-ultimos-movimientos.htm";
		String htmlConsultasLCR = "detalle-ultimos-movimientos.htm";
		String htmlConsultasCLT = "detalle-ultimos-movimientos.htm";
		String htmlConsultasCCR = "detalle-ultimos-movimientos.htm";
		String htmlConsultasFEMST = "detalle-ultimos-movimientos.htm";
		String htmlConsultasLineas = "detalle-ultimos-movimientos.htm";

		try {
			s = SocketFactory.getSocket(AfirmeNetConstants.SOCKET_IP,
					AfirmeNetConstants.SOCKET_PUERTO,
					AfirmeNetConstants.SOCKET_PORT_SUMARY);
			mc = MessageContextFactory.getContext(s);
			// Sending Summary Message
			summary = (SUMDSJVMessage) mc.getMessageRecord("SUMDSJV");
			summary.setSUMUSR(contrato);

			summary.send();
			summary.destroy();
		} catch (Exception e) {
			LOG.error("Error al conectar con sockets: " + e.getMessage());
			e.printStackTrace();
			try {
				if (s == null)
					LOG.error("Error al cerrar el socket de DIBS.JOSummary, el socket es nulo");
				else
					s.close();
			} catch (IOException ex) {
				LOG.error("Error al cerrar el socket de DIBS.JOSummary " + ex);
			}
			return null;
		}
		try {
			// nickbean = new JBNick();
			newmessage = mc.receiveMessage();
			boolean GoIn = (((SUMDSJVMessage) newmessage).getSUMFLG().equals(
					"1") || ((SUMDSJVMessage) newmessage).getSUMFLG().equals(
					"2"));
			// Primero llegan las cuentas normales
			while (GoIn) {
				// Getting the values for the current message
				Cuenta oCuenta = new Cuenta();
				boolean agregaCuenta = true;
				oCuenta.setFlg(((SUMDSJVMessage) newmessage).getSUMFLG().trim());
				// String flag = ((SUMDSJVMessage)
				// newmessage).getSUMFLG().trim();
				// oCuenta.setType(((SUMDSJVMessage)
				// newmessage).getSUMTYP().trim());
				String type = ((SUMDSJVMessage) newmessage).getSUMTYP().trim();
				oCuenta.setType(type.trim());
				// oCuenta.setDescription(((SUMDSJVMessage)
				// newmessage).getSUMDSC().trim().toUpperCase());
				String desc = ((SUMDSJVMessage) newmessage).getSUMDSC().trim()
						.toUpperCase();
				oCuenta.setNumber(((SUMDSJVMessage) newmessage).getSUMACN()
						.trim());
				// String numb = ((SUMDSJVMessage)
				// newmessage).getSUMACN().trim();
				oCuenta.setClabe(((SUMDSJVMessage) newmessage).getSUMCLA());
				// String clabe = ((SUMDSJVMessage) newmessage).getSUMCLA();
				oCuenta.setBalance(((SUMDSJVMessage) newmessage)
						.getBigDecimalSUMBAL());
				// String bala = ((SUMDSJVMessage) newmessage).getSUMBAL();
				oCuenta.setAvailable(((SUMDSJVMessage) newmessage)
						.getBigDecimalSUMAVB());
				// String avai = ((SUMDSJVMessage) newmessage).getSUMAVB();
				oCuenta.setCcy(((SUMDSJVMessage) newmessage).getSUMCCY().trim());
				// String ccy = ((SUMDSJVMessage)
				// newmessage).getSUMCCY().trim();
				oCuenta.setNickname(((SUMDSJVMessage) newmessage).getSUMNNM()
						.trim());
				// String nick = ((SUMDSJVMessage)
				// newmessage).getSUMNNM().trim();
				if(conInfoExtra){
					oCuenta.setNewNickName(oCuenta.getNumber().length() > 12 ? ""
							: cuentaDao.getNickName(contrato, oCuenta.getNumber()));					
				}else{
					oCuenta.setNewNickName("");
				}
				// String newnick =nickbean.getNICK(contrato.getENTITYID(),
				// numb);
				// String link="";
				// ggleegon : factor Bonus
				// String factor = ((SUMDSJVMessage)
				// newmessage).getSUMFCP().trim();
				oCuenta.setFactorBonusEspecial(((SUMDSJVMessage) newmessage)
						.getSUMFCP().trim());

				oCuenta.setTipoInterno(Cuenta.TIPO_CUENTA);

				Date fechaApertura = new Date();
				Date fechaVencimiento = new Date();

				try {
					fechaApertura = Util.getFechaSummary(
							((SUMDSJVMessage) newmessage).getBigDecimalSUMODD()
									.intValue(), ((SUMDSJVMessage) newmessage)
									.getBigDecimalSUMODM().intValue(),
							((SUMDSJVMessage) newmessage).getBigDecimalSUMODY()
									.intValue());
				} catch (Exception ex) {
					LOG.error("Exception: no trae fecha: " + ex.getMessage());
				}
				oCuenta.setFechaApertura(fechaApertura);

				try {
					fechaVencimiento = Util.getFechaSummary(
							((SUMDSJVMessage) newmessage).getBigDecimalSUMMAD()
									.intValue(), ((SUMDSJVMessage) newmessage)
									.getBigDecimalSUMMAM().intValue(),
							((SUMDSJVMessage) newmessage).getBigDecimalSUMMAY()
									.intValue());

				} catch (Exception ex) {
					LOG.error("Exception: no trae fecha: " + ex.getMessage());
				}
				// calendarAux.set(Calendar.YEAR, ((SUMDSJVMessage)
				// newmessage).getBigDecimalSUMMAY().intValue());

				oCuenta.setFechaVencimiento(fechaVencimiento);

				// Verifica si la cuenta es de comercio

				// boolean newcom = cuentaDao.isComercio(oCuenta.getNumber());
				if(conInfoExtra){
					oCuenta.setComercio(oCuenta.getNumber().length() > 12 ? false
							: cuentaDao.isComercio(oCuenta.getNumber()));					
				}else{
					oCuenta.setComercio(false);					
				}

				// String flg = ((SUMDSJVMessage)
				// newmessage).getSUMFIR().trim();
				// if equals 2 or 3 do not show to debit
				// String serv = "";
				if (oCuenta.getCcy().equals("")) {
					oCuenta.setCcy("USD");
				}
				/*
				 * if (nick.equals("") ) { nick = NickMSGS.toUpperCase(); }
				 */
				// checking the type of account to call the correct servlet from
				// the summary Summary JSP
				// Account From ACMST
				if (type.equals("DDA")) {
					if (desc.equals(""))
						desc = "CUENTAS CORRIENTES";
					oCuenta.setHtmlDetalle(htmlConsultas);
					// JSConsultaOrdenada
				}
				if (type.equals("SAV")) {
					if (desc.equals(""))
						desc = "CUENTA DE AHORRO";
					oCuenta.setHtmlDetalle(htmlConsultas);
					// JSConsultaOrdenada
				}
				if (type.equals("BON")) {
					if (desc.equals(""))
						desc = "PROGRAMA BONUS";
					oCuenta.setHtmlDetalle(htmlConsultasBonus);
					// JSInqBON&AccNumber
				}
				if (type.equals("MMK")) {
					if (desc.equals(""))
						desc = "MONEY MARKET";
					oCuenta.setHtmlDetalle(htmlConsultas);
					oCuenta.setTipoInterno(Cuenta.TIPO_INVERSION);
					// JSConsultaOrdenada
				}
				if (type.equals("NOW")) {
					if (desc.equals(""))
						desc = "NOW ACCOUNT";
					oCuenta.setHtmlDetalle(htmlConsultas);
					// JSConsultaOrdenada
				}

				if (type.equals("CAL")) {
					if (desc.equals(""))
						desc = "CAL ACCOUNT";
					oCuenta.setHtmlDetalle(htmlConsultas);
					// JSConsultaOrdenada
				}

				if (type.equals("VAL")) {
					desc = "VALORES";
					oCuenta.setTipoInterno(Cuenta.TIPO_INVERSION);
				}
				// Accounts From DEALS
				if (type.equals("LNS") || type.equals("DES")
						|| type.equals("ARR")) {
					if (desc.equals("")) {
						if (type.equals("LNS")) {
							desc = "PRESTAMO";
							agregaCuenta = false;
						}

						if (type.equals("DES")) {
							desc = "DESCUENTOS";
						}
						if (type.equals("ARR")) {
							desc = "ARRENDAMIENTO";
						}
					}
					oCuenta.setHtmlDetalle(htmlConsultasLNS);
					// JSInqLNS
					oCuenta.setTipoInterno(Cuenta.TIPO_CREDITO);
				}

				if (type.equals("CDS") || type.equals("TDS")
						|| type.equals("PLS") || type.equals("PLP")
						|| type.equals("ACP") || type.equals("ACS")
						|| type.equals("TDS") || type.equals("CBU")
						|| type.equals("MES")) {
					if (desc.equals("")) {

						if (type.equals("CDS")) {
							desc = "CERTIFICADO DE DEPOSITO";
						}

						if (type.equals("TDS")) {
							desc = "DEPOSITO A PLAZO FIJO";
						}
						if (type.equals("PLS")) {
							desc = "INVERSIONES";
						}

						if (type.equals("PLP")) {
							desc = "INVERSIONES";
						}

						if (type.equals("ACP")) {
							desc = "ACEPTACION";
						}
						if (type.equals("ACS")) {
							desc = "ACEPTACION";
						}
						// nuevos solo para patrimonial
						if (type.equals("TDS")) {
							desc = "PAGARÉ AFIRME";
						}
						if (type.equals("CBU")) {
							desc = "CERTIFICADO BURSÁTIL";
						}
						if (type.equals("MES")) {
							desc = "REPORTOS";
						}
					}
					oCuenta.setHtmlDetalle(htmlConsultasCDS);
					// JSInqCDS
					oCuenta.setTipoInterno(Cuenta.TIPO_INVERSION);
				}

				// Accounts Letter of Credit
				if (type.equals("LCR")) {
					if (desc.equals("")) {
						desc = "CARTA DE CREDITO";
					}
					// JSInqLCR
					oCuenta.setHtmlDetalle(htmlConsultasLCR);
					oCuenta.setTipoInterno(Cuenta.TIPO_CREDITO);
				}
				if (type.equals("ACC")) {
					if (desc.equals("")) {
						desc = "ACEPTACIONE";
					}
					oCuenta.setHtmlDetalle(htmlConsultasLCR);
					// JSInqLCR
				}
				if (type.equals("CLT")) {
					if (desc.equals("")) {
						desc = "COBRANZAS";
					}
					oCuenta.setHtmlDetalle(htmlConsultasCLT);
					// JSInqCLT
				}
				// Accounts from CCARD
				if (type.equals("CC&")) {
					if (desc.equals("")) {
						desc = "TARJETA DE DÉBITO";
					}// JSInqCCR
					oCuenta.setHtmlDetalle(htmlConsultasCCR);
					// No se agregara
					agregaCuenta = false;
				}
				// Account From FEMST
				if (type.equals("FWS") || type.equals("FWP")) {
					if (desc.equals("")) {
						desc = "CONTRATO FUTURO";
					}
					oCuenta.setHtmlDetalle(htmlConsultasFEMST);
					// JSInqFEMST
				}

				if (type.equals("SPS") || type.equals("SPP")) {
					if (desc.equals("")) {
						desc = "SWAPS";
					}
					oCuenta.setHtmlDetalle(htmlConsultasFEMST);
					// JSInqFEMST
				}

				// serv = serv + desc + "</A>";

				boolean ACCOK = true;
				if (cuentasExcluyentes
						.contains("|" + oCuenta.getNumber() + "|"))
					ACCOK = false;

				// Anteriormente se llenaban todos las cuentas al la lista de
				// cuentas para EDC
				// summarybeanEDO.addRowC(desc, numb, bala, avai, ccy, nick,
				// serv, type, flg, lnick, clabe);

				if (ACCOK && agregaCuenta) {
					oCuenta.setDescription(desc);
					// oCuenta.setTipoInterno(Cuenta.TIPO_CUENTA);
					lista.add(oCuenta);
					// Adding Nicknames to nickname bean
					// Se llenaban la lista de nicks
					// nicknamelistbean.addRow(numb, desc, nick, bala, type);
					// Se cargan las cuentas de credito
					// if (flag.equals("2")) { // Credit Account
					/*
					 * summarybeanC.addRowC(desc, numb, bala, avai, ccy, nick,
					 * serv, type, flg, lnick, clabe, fechaApertura,
					 * fechaVencimineto, factorBonus);
					 */
					// }
					// Se cargan las cuentas de bedito
					// if (flag.equals("1")) { // Debit Account
					/*
					 * summarybeanD.addRowD(desc, numb, bala, ccy, nick, serv,
					 * type, flg, lnick);
					 */
					// }
					// if (newcom) { // Comercio
					// Link
					// JSInqCOM
					// Se carga en la lista de comercio
					/*
					 * summarybeanA.addRowA(desc, numb, bala, avai, ccy, nick,
					 * serv, type, flg, lnick, clabe);
					 */
					// }
				}

				// Receiving next summary message

				newmessage = mc.receiveMessage();

				GoIn = (((SUMDSJVMessage) newmessage).getSUMFLG().equals("1") || ((SUMDSJVMessage) newmessage)
						.getSUMFLG().equals("2"));
			} // end while

		} catch (Exception e) {
			LOG.error("Error en el socket de DIBS.JOSummary (segundo try) " + e);
			lista = null;
			try {
				s.close();
			} catch (IOException ex) {
				LOG.error("Error al cerrar el socket de DIBS.JOSummary " + ex);
			}
			return (lista);
		}
		// Reading Credit Lines
		try {

			newmessage = mc.receiveMessage();

			// oLog.setGetInfo("consulta", "01", "0", UserIdJSP, "", "", "", "",
			// newmessage, oFirma);

			boolean GoIn = !(((ILN006001Message) newmessage).getLN61LNECCY()
					.equals("***"));
			while (GoIn) {
				// Getting the values for the current message
				Cuenta oCuenta = new Cuenta();
				String pdat1 = "";
				String pdat2 = "";
				String pdat3 = "";

				String Number = ((ILN006001Message) newmessage).getLN61LNENUM()
						.trim();
				String Type = ((ILN006001Message) newmessage).getLN61TYPE()
						.trim();

				pdat1 = ((ILN006001Message) newmessage).getLN61LNEMT1();
				pdat2 = ((ILN006001Message) newmessage).getLN61LNEMT2();
				pdat3 = ((ILN006001Message) newmessage).getLN61LNEMT3();
				if (pdat1.length() == 1) {
					pdat1 = "0" + pdat1;
				}
				if (pdat2.length() == 1) {
					pdat2 = "0" + pdat2;
				}
				if (pdat3.length() == 1) {
					pdat3 = "0" + pdat3;
				}
				String MDate = pdat1 + "/" + pdat2 + "/" + pdat3;

				pdat1 = ((ILN006001Message) newmessage).getLN61LNEOP1();
				pdat2 = ((ILN006001Message) newmessage).getLN61LNEOP2();
				pdat3 = ((ILN006001Message) newmessage).getLN61LNEOP3();
				if (pdat1.length() == 1) {
					pdat1 = "0" + pdat1;
				}
				if (pdat2.length() == 1) {
					pdat2 = "0" + pdat2;
				}
				if (pdat3.length() == 1) {
					pdat3 = "0" + pdat3;
				}
				String ODate = pdat1 + "/" + pdat2 + "/" + pdat3;

				String APRAMT = ((ILN006001Message) newmessage).getLN61LNEAMN()
						.trim();
				String AVAAMT = ((ILN006001Message) newmessage).getLN61AVAILA()
						.trim();
				String COLAMT = ((ILN006001Message) newmessage).getLN61LNEPUR()
						.trim();
				String CREAMT = ((ILN006001Message) newmessage).getLN61LNEAMU()
						.trim();
				String CusNumber = ((ILN006001Message) newmessage)
						.getLN61LNECUN().trim();
				String DSC = ((ILN006001Message) newmessage).getLN61LNEPUR()
						.trim();
				String RTE = "";
				// String LINK = "JSInqCreditLine";

				// LINK = LINK + Number + "</A>";

				String CCY = ((ILN006001Message) newmessage).getLN61LNECCY()
						.trim();
				String DEUAMT = ((ILN006001Message) newmessage).getLN61LNEAMU()
						.trim();
				
				String TITCRD = "";
				if(conInfoExtra){
					TITCRD = cuentaDao.getTitularCredito(CusNumber);
				}
						

				oCuenta.setNumber(Number);
				oCuenta.setType(Type);
				oCuenta.setmDate(MDate);
				oCuenta.setaPRAMT(APRAMT);
				oCuenta.setaVAAMT(AVAAMT);
				oCuenta.setcOLAMT(COLAMT);
				oCuenta.setcREAMT(CREAMT);
				oCuenta.setCusNumber(CusNumber);
				oCuenta.setDescription(DSC);
				oCuenta.setcRERTE(RTE);
				oCuenta.setoDate(ODate);
				oCuenta.setHtmlDetalle(htmlConsultasLineas);
				oCuenta.setCcy(CCY);
				oCuenta.setdEUAMT(DEUAMT);
				oCuenta.settITCRD(TITCRD);
				oCuenta.setTipoInterno(Cuenta.TIPO_CREDITO);
				lista.add(oCuenta);
				// Se agregan a las cuentas para EDC
				// summarybeanEDO.addRowC(DSC, Number, AVAAMT, AVAAMT, COLAMT,
				// UserIdJSP, "", Type, "", "", TITCRD);

				// Se llena la lista de cuentas de creditos
				/*
				 * creditlbean.addRowB(Number, Type, MDate, APRAMT, AVAAMT,
				 * COLAMT, CREAMT, CusNumber, DSC, RTE, ODate, LINK, CCY,
				 * DEUAMT, TITCRD);
				 */

				newmessage = mc.receiveMessage();
				GoIn = !(((ILN006001Message) newmessage).getLN61LNECCY()
						.equals("***"));
			}
		} catch (Exception e) {
			LOG.error("Error en el socket de DIBS.JOSummary (tercer try) " + e);
			lista = null;
			try {
				s.close();
			} catch (IOException ex) {
				LOG.error("Error al cerrar el socket de DIBS.JOSummary " + ex);
			}
			return (lista);
		}

		try {
			s.close();
		} catch (IOException ex) {
			LOG.error("Error al cerrar el socket de DIBS.JOSummary " + ex);
		}
		// oLog.setSumInfo(UserIdJSP, "", "Fin de Carga de Datos", RemoteAddr,
		// oFirma);

		// En la lista se llenaron todas las cuentas
		/*
		 * session.setAttribute("summarybeanA", summarybeanA); // Putting
		 * summarybeanC Bean in Session session.setAttribute("summarybeanC",
		 * summarybeanC); // Putting summarybeanC Bean in Session Estado de
		 * cuenta session.setAttribute("summarybeanEDO", summarybeanEDO); //
		 * Putting summarybeanD Bean in Session
		 * session.setAttribute("summarybeanD", summarybeanD); // Putting
		 * NickName List Bean in Session
		 * session.setAttribute("nicknamelistbean", nicknamelistbean); //
		 * Putting Credit Line Bean in Session
		 * session.setAttribute("creditlbean", creditlbean);
		 */

		return lista;
	}

	@Override
	public Cuenta seleccionaCuenta(String numero, List<Cuenta> cuentas) {
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getNumber().trim().equals(numero.trim()))
				return cuenta;
		}
		return null;
	}

	@Override
	public List<Cuenta> segmentaCuentasPorTipo(String tipo, List<Cuenta> cuentas) {
		List<Cuenta> cuentasValidas = new ArrayList<Cuenta>();
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getTipoInterno().equalsIgnoreCase(tipo))
				cuentasValidas.add(cuenta);
		}
		return cuentasValidas;
	}

	@Override
	public Resumen calculaResumenPorCuenta(String tipo, List<Cuenta> cuentas) {
		Resumen res = new Resumen();
		res.setDescripcion(tipo);
		BigDecimal total = BigDecimal.ZERO;
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getAvailable() != null)
				total = total.add(cuenta.getAvailable());
		}
		res.setTotal(total);
		res.setCuentas(cuentas.size());
		return res;
	}

	/**
	 * Obtiene la lista de cuentas propias
	 */
	@Override
	public List<Cuenta> getCuentasPropias(List<Cuenta> cuentas,
			List<String> tipo) {
		List<Cuenta> cuentasValidas = new ArrayList<Cuenta>();
		for (Cuenta cuenta : cuentas) {
			if (tipo.contains(cuenta.getType())
					&& cuenta.getCcy().equals("MXP"))
				cuentasValidas.add(cuenta);
		}
		return cuentasValidas;
	}

	/**
	 * Obtiene la lista de cuentas propias de pesos
	 */
	@Override
	public List<Cuenta> getCuentasPropiasMXP(List<Cuenta> cuentas,
			List<String> tipo) {
		List<Cuenta> cuentasValidas = new ArrayList<Cuenta>();
		for (Cuenta cuenta : cuentas) {
			if (tipo.contains(cuenta.getType())
					&& cuenta.getCcy().equals("MXP"))
				cuentasValidas.add(cuenta);
		}
		return cuentasValidas;
	}

	@Override
	public boolean esCuentasJunior(String cuenta) {
		if (cuentaDao.esCuentasJunior(cuenta)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ACCTHIRDUSER> getCuentasJunior(String contrato) {
		List<ACCTHIRDUSER> cuentasJr = new ArrayList<ACCTHIRDUSER>(0);
		// Obtiene las cuentas de terceros
		List<ACCTHIRDUSER> cuentasTerceros = tercerosService.getListaTerceros(
				contrato, "03", "");
		// filtra solo las cuentas JR

		for (ACCTHIRDUSER cuenta : cuentasTerceros) {
			if (this.esCuentasJunior(cuenta.getACCNUM())) {
				cuentasJr.add(cuenta);
			}
		}

		return cuentasJr;
	}

	@Override
	public Resumen calculaResumenPorCredito(String tipo, List<Cuenta> cuentas) {
		Resumen res = new Resumen();
		res.setDescripcion(tipo);
		BigDecimal total = BigDecimal.ZERO;
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getdEUAMT() != null) {
				String monto = cuenta.getdEUAMT().replaceAll("\\,", "");
				total = total.add(new BigDecimal(monto));
			}
		}
		res.setTotal(total);
		res.setCuentas(cuentas.size());
		return res;
	}

	@Override
	public Cuenta getCuenta(String contrato, String numeroCuenta,
			String cuentasExcluyentes) {
		List<Cuenta> cuentas = getCuentas(contrato, cuentasExcluyentes, false);
		Cuenta cuenta = null;
		for (Cuenta item : cuentas) {
			if (item.getNumber().equals(numeroCuenta)) {
				cuenta = item;
				break;
			}
		}

		return cuenta;
	}
}
