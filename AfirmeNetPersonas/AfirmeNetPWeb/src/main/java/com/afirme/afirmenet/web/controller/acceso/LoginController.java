package com.afirme.afirmenet.web.controller.acceso;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.afirme.afirmenet.enums.ConfigLogIn;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.enums.TipoCliente;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.beans.JBBMuser;
import com.afirme.afirmenet.ibs.beans.JBLogList;
import com.afirme.afirmenet.ibs.beans.JBLogin;
import com.afirme.afirmenet.ibs.beans.JBProCode;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.beans.consultas.Resumen;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.service.FinDiaService;
import com.afirme.afirmenet.service.acceso.CampaniaService;
import com.afirme.afirmenet.service.acceso.LogInService;
import com.afirme.afirmenet.service.acceso.MenuService;
import com.afirme.afirmenet.service.acceso.OTPAdminService;
import com.afirme.afirmenet.service.acceso.OTPAgenteService;
import com.afirme.afirmenet.service.acceso.OTPService;
import com.afirme.afirmenet.service.config.PropertyService;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.contrato.ContratoService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.web.controller.base.BaseController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.model.Login;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

/**
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	CampaniaService campaniaService;

	@Autowired
	private ContratoService contratoService;

	@Autowired
	private LogInService logInService;

	@Autowired
	private OTPAdminService oTPAdminService;

	@Autowired
	private OTPAgenteService oTPAgenteService;

	@Autowired
	private OTPService otpService;

	@Autowired
	private FinDiaService finDiaService;

	@Autowired
	private MenuService menuService;

	@Autowired(required = true)
	private CuentaService cuentaService;
	
	@Autowired
	private PropertyService propertyService;

	@RequestMapping(value = "/contrato.htm", method = RequestMethod.POST)
	public String mostrarAvisoSeguridad(@ModelAttribute("login") Login login,
			ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /login/contrato.htm contrato ===> "
				+ login.getContrato());
		modelMap.put("aviso", login);
		return AfirmeNetWebConstants.MV_LOGIN_AVISO_SEGURIDAD;
	}

	@RequestMapping(value = "/avisoSeguridad.htm", method = RequestMethod.POST)
	public String mostrarDatosAcceso(@ModelAttribute("aviso") Login login,
			ModelMap modelMap) {
		LOG.debug("Atendiendo Peticion = /login/avisoSeguridad.htm contrato ===> "
				+ login.getContrato());
		try{
		
			JBLogin loginUser = contratoService.getDatosLogIn(login.getContrato());
	
			boolean basicoSinToken = false;
			
	
			StringTokenizer paqSinToken = new StringTokenizer(
					AfirmeNetConstants.getValorConfigPersonas(
							ConfigPersonas.GENERAL_PAQ_SIN_TOKEN, String.class),
					",");
	
			if (paqSinToken != null) {
				while (paqSinToken.hasMoreTokens()) {
					if (loginUser.getPaquete().equals(
							paqSinToken.nextToken().trim())) {
						basicoSinToken = true;
						break;
					}
				}
			}
	
			if (loginUser.getEstatus().equals(ConfigLogIn.USER_INACTIVO.getValor())
					|| loginUser.getEstatus().equals(
							ConfigLogIn.USER_SUSPENDIDO.getValor())
					|| loginUser.getEstatus().equals(
							ConfigLogIn.USER_NUEVO.getValor())
					|| loginUser.getEstatus().equals(
							ConfigLogIn.USER_INACTIVIDAD.getValor())
					|| loginUser.getEstatus().equals(
							ConfigLogIn.USER_CUENTA_CANCELADA.getValor())
					|| loginUser.getEstatus().equals(
							ConfigLogIn.USER_PAQUETE_PYME.getValor())) {
	
				if (loginUser.getEstatus().equals(
						ConfigLogIn.USER_INACTIVO.getValor())) {
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.inactive"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.inactive.label"));
					return AfirmeNetWebConstants.MV_LOGIN_USERINACTIVO;
				}
	
				if (loginUser.getEstatus().equals(
						ConfigLogIn.USER_SUSPENDIDO.getValor())) {
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.suspended"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.suspended.label"));
					return AfirmeNetWebConstants.MV_LOGIN_USERSUSPENDIDO;
				}
	
				if (loginUser.getEstatus()
						.equals(ConfigLogIn.USER_NUEVO.getValor())) {
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.new"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.new.label"));				
					return AfirmeNetWebConstants.MV_LOGIN_USERNUEVO;
				}
	
				if (loginUser.getEstatus().equals(
						ConfigLogIn.USER_INACTIVIDAD.getValor())) {
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.inactividad"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.inactividad.label"));		
					return AfirmeNetWebConstants.MV_LOGIN_USERINACTIVIDAD;
				}
	
				if (loginUser.getEstatus().equals(
						ConfigLogIn.USER_CUENTA_CANCELADA.getValor())) {
					
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.cuentacancelada"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.cuentacancelada.label"));
					return AfirmeNetWebConstants.MV_LOGIN_ACCCANCELADA;
				}
	
				if (loginUser.getEstatus().equals(
						ConfigLogIn.USER_PAQUETE_PYME.getValor())) {
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.pyme"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.pyme.label"));
					return AfirmeNetWebConstants.MV_LOGIN_AVISO_ACCPAGOPYME;
				}
	
				/*
				 * VALIDAR COMO ENTRA if(loginUser.getTipo().equals("1")) { return
				 * AfirmeNetWebConstants.MV_LOGIN_PATHEMPRESAS; }
				 */
	
			}
	
			// Si el contrato se encuentra pendiente de activar
			if (loginUser.getEstatus().equals(
					ConfigLogIn.USER_PTEACTIVAR.getValor())) {
				// revisar si es personas o empresas
				if (loginUser.getTipo()
						.equals(ConfigLogIn.TIPO_EMPRESAS.getValor())) {
					// VALIDAR COMO SE DIRECCIONA A EMPRESAS
					// resp.sendRedirect(SuperServlet.WebAppCTREmpresas + Path +
					// "act_frame.jsp" + UserPatrimonialAdd + "&contrato=" +
					// UserIdJSP);
					// return AfirmeNetWebConstants.MV_LOGIN_AVISO_USERINACTIVE;
				} else if (loginUser.getTipo().equals(
						ConfigLogIn.TIPO_PERSONAS.getValor())) {
					// revisar si es basico sin token o no
					if (!basicoSinToken) {
						// si usa token
						// Entonces se redirecciona al aviso de pendiente de activar
						// su token
						// resp.sendRedirect(SuperServlet.WebAppCTR + Path +
						// "act_frame.jsp?tipo=2&contrato=" + UserIdJSP);
						modelMap.put("activacion", login);
						return AfirmeNetWebConstants.MV_ACTIVA_CONTRATO;
					} else {
						// Se redirecciona a la activación de contrato basico simple
						// sin token
						// resp.sendRedirect(SuperServlet.WebAppCTR + Path +
						// "act_frame.jsp?tipo=3&contrato=" + UserIdJSP);
						modelMap.put("activacion", login);
						return AfirmeNetWebConstants.MV_ACTIVA_CONTRATO;
					}
				} else {
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.invalid"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.invalid.label"));		
					return AfirmeNetWebConstants.MV_LOGIN_USERIVALIDO;
				}
			}
	
			if (loginUser.getTipo().equals(ConfigLogIn.TIPO_EMPRESAS.getValor())) {
	
				if (loginUser.getEstatus().equals(
						ConfigLogIn.USER_AVISO_CUENTA_CANCELADA)) {	
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginaviso.user.cuentacancelada"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginaviso.user.cuentacancelada.label"));		
					modelMap.addAttribute("action", "");		
					return AfirmeNetWebConstants.MV_LOGIN_AVISO_ACCCANCELADA;
				} else if (loginUser.getEstatus().equals(
						ConfigLogIn.USER_AVISO_PAQUETE_PYME.getValor())) {
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginaviso.user.pyme"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginaviso.user.pyme.label"));		
					modelMap.addAttribute("action", "");
					return AfirmeNetWebConstants.MV_LOGIN_AVISO_ACCPAGOPYME;
				} else {
					// resp.sendRedirect(SuperServlet.WebAppCTR + Path +
					// "body_wait_portal.jsp" + UserPatrimonialAdd);
	
				}
	
				// session.invalidate();
			} else if (loginUser.getTipo().equals(
					ConfigLogIn.TIPO_PERSONAS.getValor())) {
				// Revisar si es basico sin token
				if (basicoSinToken) {
	
					login.setAlias(loginUser.getAlias());
					login.setbPaqueteSinToken(true);
					login.setsPaqueteSinToken(true);
	
					if (loginUser.getAlias() != null
							&& !loginUser.getAlias().equals("")) {
						if (logInService.verificarPrimerLoginConAlias(login
								.getContrato())) {
							logInService.actualizarPrimerLoginConAlias(login
									.getContrato());
						}
						if (loginUser.getEstatus().equals(
								ConfigLogIn.USER_AVISO_CUENTA_CANCELADA.getValor())) {
							modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginaviso.user.cuentacancelada"));
							modelMap.addAttribute("errMsg", getMessage("afirmenet.loginaviso.user.cuentacancelada.label"));		
							modelMap.addAttribute("action", "");	
							return AfirmeNetWebConstants.MV_LOGIN_AVISO_ACCCANCELADA;
						} else {
	
							String contratoMask = "&bull;&bull;&bull;&bull;&bull;&bull;"
									+ login.getContrato().substring(
											login.getContrato().length() - 4,
											login.getContrato().length());
	
							login.setAlias(loginUser.getAlias());
							login.setPatrimonial(loginUser.getPatrimonial());
							modelMap.put("acceso", login);
							modelMap.addAttribute("contratoMask", contratoMask);
	
							return AfirmeNetWebConstants.MV_LOGIN_DATOS_ACCESO; // validar
						}
					} else {
						return AfirmeNetWebConstants.MV_LOGIN_DATOS_ACCESO;
					}
	
				} else {
					if (loginUser.getEstatus().equals(
							ConfigLogIn.USER_AVISO_CUENTA_CANCELADA.getValor())) {
						modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginaviso.user.cuentacancelada"));
						modelMap.addAttribute("errMsg", getMessage("afirmenet.loginaviso.user.cuentacancelada.label"));		
						modelMap.addAttribute("action", "");
						return AfirmeNetWebConstants.MV_LOGIN_AVISO_ACCCANCELADA;
					} else {
						String contratoMask = "&bull;&bull;&bull;&bull;&bull;&bull;"
								+ login.getContrato().substring(
										login.getContrato().length() - 4,
										login.getContrato().length());
	
						login.setAlias(loginUser.getAlias());
						login.setPatrimonial(loginUser.getPatrimonial());
						modelMap.put("acceso", login);
						modelMap.addAttribute("contratoMask", contratoMask);
	
						return AfirmeNetWebConstants.MV_LOGIN_DATOS_ACCESO;
					}
	
				}
			} else {
				modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.invalid"));
				modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.invalid.label"));		
				return AfirmeNetWebConstants.MV_LOGIN_USERIVALIDO;
			}
			modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.invalid"));
			modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.invalid.label"));		
			return AfirmeNetWebConstants.MV_LOGIN_USERIVALIDO;
		}catch (Exception e){
			throw new AfirmeNetException("0000", getMessage("afirmenet.noDisponible"));
		}
	}


	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/datosAcceso.htm", method = RequestMethod.POST)
	public String mostrarHome(@ModelAttribute("acceso") Login login,
			HttpServletRequest request, ModelMap modelMap) throws AfirmeNetException{
		LOG.debug("Atendiendo Peticion = /login/datosAcceso.htm contrato ===> "
				+ login.getContrato());

		JBLogin loginUser = null;

		// VALIDA QUE EL CONTRATO O PASS NO SEAN VACIOS
		if (login.getContrato() == null || login.getPassword() == null) {
			return AfirmeNetWebConstants.MV_LOGIN;
		}

		// VALIDA QUE ESTEN ACTIVOS LOS SOCKET
		String finDiaError = finDiaService.getFinDia();

		if (finDiaError.equals("1")) {
			// Timeout
			return null;
		}

		if (finDiaError.equals("2")) {
			// Error
			return null;
		}

		// OBTIENE USUARIO DE 400
		if (!(login.getPassword().equals(""))) {

			loginUser = logInService.getUserLogin(login.getContrato(),
						login.getPassword());


			if (loginUser.getFormatName().equals("INLOGIN02") == false
					|| loginUser.getPWDUSR().equals(login.getContrato()) == false) {
				return AfirmeNetWebConstants.MV_LOGIN;
			}

			if (!loginUser.gettCliente().equals("2")) {		
				modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.invalid"));
			    modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.invalid.label"));	
				return AfirmeNetWebConstants.MV_LOGIN_USERIVALIDO;
			}
		} else {
			return AfirmeNetWebConstants.MV_LOGIN_DATOS_ACCESO;
		}

		// VALIDA ESTATUS INVALIDOS DE 400
		if (loginUser.getStatus().equals(
				ConfigLogIn.USER_400_INVALIDO.getValor())) {
			modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.invalid"));
		    modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.invalid.label"));	
			return AfirmeNetWebConstants.MV_LOGIN_USERIVALIDO;
		} else if (loginUser.getStatus().equals(
				ConfigLogIn.USER_400_PASSINCORRECTO.getValor())) {
			if (loginUser.getEussts().equals(
					ConfigLogIn.USER_400_INACTIVO.getValor())) {
				// enviarCorreoAlertaBloqueo(loginUser.getEmail(),
				// loginUser.getCliente());
			}
			modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.invalidpass"));
		    modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.invalidpass.label"));	
			return AfirmeNetWebConstants.MV_LOGIN_INVALIDPASS;
		}

		// Verifica si usa tokens o no
		boolean usaTok = otpService.usaTokens(login.getContrato());
		ArrayList tokenRSA = new ArrayList();
		tokenRSA.add(new Boolean(usaTok));

		StringTokenizer paqSinToken = new StringTokenizer(
				AfirmeNetConstants.getValorConfigPersonas(
						ConfigPersonas.GENERAL_PAQ_SIN_TOKEN, String.class),
				",");

		boolean bPaqueteSinToken = false;

		if (paqSinToken != null) {
			while (paqSinToken.hasMoreTokens()) {
				if (loginUser.getGrpId().equals(paqSinToken.nextToken().trim())) {
					bPaqueteSinToken = true;
					usaTok = false;
				}
			}
		}

		// GUARDA EN SESION SI ES PAQUETE BASICO SIN TOKEN
		request.getSession().setAttribute("bPaqueteSinToken", bPaqueteSinToken);
		

		// GUARDA SERIE DEL TOKEN
		if (usaTok == true && bPaqueteSinToken == false) {
			tokenRSA.add(otpService.obtenToken(login.getContrato()));
		}

		// Se obtiene el estatus del contrato de Afirmenet
		String status2 = loginUser.getEussts();

		if (status2.equals(ConfigLogIn.USER_PTEACTIVAR.getValor())
				&& usaTok == true) {
			modelMap.put("activacion", login);
			return AfirmeNetWebConstants.MV_ACTIVA_CONTRATO;
		} else if (status2.equals(ConfigLogIn.USER_PTEACTIVAR.getValor())
				&& bPaqueteSinToken == true) {
			return AfirmeNetWebConstants.MV_ACTIVA_CONTRATOSINTOKEN;
		}
		// Estatus bloqueado por inactividad
		if (status2.equals(ConfigLogIn.USER_INACTIVIDAD.getValor())) {
			modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.inactividad"));
			modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.inactividad.label"));	
			return AfirmeNetWebConstants.MV_LOGIN_USERINACTIVIDAD;
		}

		if (loginUser.getStatus().equals("")) {

			String ipActual = request.getRemoteAddr();

			JBBMuser bmUser = new JBBMuser();

			// Se verifica el inout
			if (ConfigPersonas.INOUT.getValor().equals("Y")
					&& !login.getPassword().equals("")) {

				boolean activo = logInService
						.verificaINOUT(login.getContrato());
				// Si ya esta activa una sesion con este usuario
				if (activo == true) {

					String ipAnterior = logInService.consultaIP(
							login.getContrato(), login.getContrato());

					if (ipAnterior.trim().equals("") == false
							&& ipActual.equals(ipAnterior) == false) {
						// Envia correo por doble sesion
						// enviarCorreoAlertaDobleSession(UserIdJSP);
					} else {
						// enviarCorreoAlertaContratoBloqueado(UserIdJSP);
					}
					
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.inout"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.inout.label"));	
					return AfirmeNetWebConstants.MV_LOGIN_INOUT;

				} else {
					// Inserta o actualiza IP del usuario

					if (logInService
							.consultaIP(login.getContrato(),
									login.getContrato()).trim().equals("") == true) {
						// Si no existe, inserta
						logInService.insertaIP(login.getContrato(),
								login.getContrato(), ipActual);
					} else {
						// Si existe actualiza
						logInService.actualizaIP(login.getContrato(),
								login.getContrato(), ipActual, "0");
					}

				}
			}

			// VALIDA BANCAMOVIL
			if (ConfigPersonas.INOUT.getValor().equals("Y")
					&& !login.getPassword().equals("")) {
				bmUser = logInService.verificaBMUser(login.getContrato());
				boolean activo = bmUser.isActivo();
				// Si ya esta activa una sesion con este usuario
				if (activo == true) {
					// enviarCorreoAlertaAfirmeMovilBloqueado(UserIdJSP);
					modelMap.addAttribute("errEstatus", getMessage("afirmenet.loginmsg.user.bmuser"));
					modelMap.addAttribute("errMsg", getMessage("afirmenet.loginmsg.user.bmuser.label"));	
					return AfirmeNetWebConstants.MV_LOGIN_BANCAMOVIL; 

				}
			}

			AfirmeNetUser usuario = new AfirmeNetUser();
			usuario.setContrato(login.getContrato());
			usuario.setNumCliente(loginUser.getCliente());
			usuario.setNombreCompleto(loginUser.getNombreCliente());
			usuario.setNombreLargo(loginUser.getNombreCliente());
			usuario.setNombreCorto(loginUser.getNombreCliente());
			usuario.setCorreoElectronico(loginUser.getEmail());
			usuario.setPaqueteAfirmeNet(loginUser.getGrpId());
			usuario.setNotificaciones(6);
			usuario.setBasicoSinToken(bPaqueteSinToken);

			// CREA JBSUMMARY
			// CARGA CUENTAS DE TERCEROS
			// CARGA PROCODE
			List<JBProCode> procode = logInService.getProcode(bPaqueteSinToken);
			// CARGA JBSUMMARY
			List<Cuenta> cuentas=this.calculaResumeCuentas(usuario, modelMap);
			request.getSession().setAttribute(AfirmeNetWebConstants.CUENTAS_SESSION, cuentas);
			// CARGA ULTIMO LOGIN
			JBLogList ultimoLogIn = new JBLogList();
			ultimoLogIn = logInService.getLastLoginPer(usuario.getContrato());
			usuario.setUltimoAcceso(TimeUtils.getDate(ultimoLogIn.getDTTM(),
					TimeUtils.AS400_DATE_FORMAT));
			// CARGA LAS CONFIGURACIONES DE LA TABLA DC_PROPERTIES
			AfirmeNetConstants.setPropertiesConfig(propertyService.getConfiguracionesMap());
			// CARGA TIEMPO DE ESPERA CUENTA Y ACTUALIZA EN EL MAPA DE CONFIGURACIONES
			//propertyService.setTiempoEspera(ConfigProperties.PROPERTYID_THIRD_ACCOUNT_TIME_PER);
			
			// CARGA NUMERO DE INTENTOS CUENTA
			// CARGA VIGENCIA CUENTAS
			// INSERTA USUARIO ACCESO A AFIRMENET
			// logbean.getAddLogPer(Util.getRefNum(), UserIdJSP, LACTION, RMK,ACCOUNT, AMOUNT, CURRENCY, TYP_TRAN, Util.getRefNum());
			logInService.getAddLogPer(Util.getRefNum(), usuario.getContrato(),
					"LOGIN", "USER LOGIN OK", "", "0.00", "", "OKL",
					Util.getRefNum());
			// ACTUALIZA BMUSER LOGEADO EN AFIRMENET
			logInService.updateBMUser(usuario.getContrato());

			// Se carga el menú
			String menu = menuService.getMenu(loginUser.getGroupID(), 1,usuario.getContrato());
			request.getSession().setAttribute("menu", menu);
			// Carga, actualiza o elimina los límites de transferencia
			logInService.defaultSetting(usuario.getContrato(),
					loginUser.getGroupID(), cuentas, procode);
			// Busca cambios en los límites de transferencia, si ya pasaron el
			// tiempo de espera los actualiza, de lo contrario los deja como
			// están.
			logInService.lookupChangeParameter(usuario.getContrato());
			// Buscar capañas a morstrar por usuario
			usuario.setCampania(campaniaService.getCampania(
					TipoCliente.PERSONAS, login.getContrato(),
					login.getContrato(), "215421"));

			String bgImg = AfirmeNetWebConstants.BACKGROUD_PATH_IMAGE;
			// Se valida si existe campaña de imagen, de lo contrario se setea
			// la
			// default

			if (usuario.getCampania() != null
					&& usuario.getCampania().getImagen() != null
					&& !usuario.getCampania().getImagen().equals("null")
					&& StringUtils
							.isNotEmpty(usuario.getCampania().getImagen())) {
				bgImg = AfirmeNetConstants
						.getValorConfigPersonas(ConfigPersonas.CAMPANIAS_IMG_URL)
						+ usuario.getCampania().getImagen();
			}
			request.getSession().setAttribute(
					AfirmeNetWebConstants.BACKGROUD_IMAGE, bgImg);

			// Se elimina el usuario de session y se coloca el nuevo
			request.getSession().removeAttribute(
					AfirmeNetWebConstants.USUARIO_SESSION);
			request.getSession().setAttribute(
					AfirmeNetWebConstants.USUARIO_SESSION, usuario);

			return AfirmeNetWebConstants.MV_HOME;

		}

		return AfirmeNetWebConstants.MV_LOGIN;

	}

	@RequestMapping(value = "/terminos.htm", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String mostrarTerminos() {
		return AfirmeNetWebConstants.MV_HOME_TERMINOS;
	}

}
