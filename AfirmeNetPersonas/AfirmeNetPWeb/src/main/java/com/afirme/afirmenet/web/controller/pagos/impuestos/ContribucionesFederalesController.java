package com.afirme.afirmenet.web.controller.pagos.impuestos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.afirme.afirmenet.enums.HorarioServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.generics.Util;
import com.afirme.afirmenet.model.pagos.impuestos.Concepto;
import com.afirme.afirmenet.model.pagos.impuestos.ConceptosImpuestosIdentificacion;
import com.afirme.afirmenet.model.pagos.impuestos.Derechos;
import com.afirme.afirmenet.model.pagos.impuestos.Ejercicio;
import com.afirme.afirmenet.model.pagos.impuestos.Identificacion;
import com.afirme.afirmenet.model.pagos.impuestos.Impuesto;
import com.afirme.afirmenet.model.pagos.impuestos.TipoImpuesto;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.pagos.impuestos.ImpuestosService;
import com.afirme.afirmenet.service.transferencia.PagoImpuestosSATService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.utils.xml.ParseXMLToPojoFactory;
import com.afirme.afirmenet.web.controller.base.BaseController;
import com.afirme.afirmenet.web.controller.transferencia.TransferenciaController;
import com.afirme.afirmenet.web.model.AfirmeNetUser;
import com.afirme.afirmenet.web.utils.AfirmeNetWebConstants;

@Controller
@RequestMapping("/impuestos/federales")
@SessionAttributes({ "horario", "cuentasPropias", "impuesto" })
public class ContribucionesFederalesController extends BaseController {

	static final Logger LOG = LoggerFactory
			.getLogger(ContribucionesFederalesController.class);

	@Autowired
	private CuentaService cuentaService;

	@Autowired
	private ImpuestosService impuestosService;

	@Autowired
	private PagoImpuestosSATService impuestosSATService;

	@RequestMapping(value = "/capturaAnual", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String capturaAnuales(HttpServletRequest request, ModelMap modelMap) {
		prepare(request, modelMap, TipoImpuesto.ANUAL);
		return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_FED_CAPTURA;
	}

	@RequestMapping(value = "/capturaDerechos", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String capturaDerechos(HttpServletRequest request, ModelMap modelMap) {
		prepare(request, modelMap, TipoImpuesto.DERECHOS);
		return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_FED_CAPTURA;
	}

	private void prepare(HttpServletRequest request, ModelMap modelMap,
			TipoImpuesto tipoImpuesto) {
		// Obtiene el usuario de Session
		AfirmeNetUser user = getSessionUser(request);
		// Obtiene la lista de cuentas propias
		List<Cuenta> cuentasPropias = getCuentasPropias(user);
		// Obtiene el horario de servicio
		modelMap.addAttribute("horario",
				AfirmeNetConstants.horarios.get(HorarioServicio.PAGO_IMPUESTOS));
		modelMap.addAttribute("cuentasPropias", cuentasPropias);
		// Informacion de cliente y contrato
		Impuesto impuesto = new Impuesto();
		impuesto.setTipoImpuesto(tipoImpuesto);
		impuesto.setContratoId(user.getContrato());
		impuesto.setContractId(user.getContrato());
		impuesto.setNombreCliente(user.getNombreCompleto());

		modelMap.addAttribute("impuesto", impuesto);

	}

	/**
	 * Metodo que muestra la confirmacion del pago de impuestos
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/confirmar", method = RequestMethod.POST)
	public String confirmarContribucionesFederalesAnuales(
			@ModelAttribute("impuesto") Impuesto impuesto, ModelMap modelMap) {
		LOG.debug("Tipo Impuesto    ==>" + impuesto.getTipoImpuesto());
		LOG.debug("Cadena XML       ==>" + impuesto.getDatosXML());
		LOG.debug("Cadena Original  ==>" + impuesto.getCadenaOriginal());
		LOG.debug("Cadena Imp       ==>" + impuesto.getDatosImpl());
		LOG.debug("Cadena Datos     ==>" + impuesto.getDatos());

		Identificacion identificacion = null;
		if (impuesto.getTipoImpuesto().equals(TipoImpuesto.ANUAL)) {
			// Parsea el XML del applet a Pojo
			Ejercicio ejercicio = ParseXMLToPojoFactory.transform(
					impuesto.getDatosXML(), Ejercicio.class);

			identificacion = ejercicio.getIdentificacion();
			impuesto.setEjercicio(ejercicio);
			impuesto.setConceptos(ejercicio.getConceptos());
			modelMap.addAttribute("ejercicio", ejercicio);

		} else {
			Derechos derechos = ParseXMLToPojoFactory.transform(
					impuesto.getDatosXML(), Derechos.class);

			identificacion = derechos.getIdentificacion();
			impuesto.setDerechos(derechos);
			impuesto.setConceptos(derechos.getConceptos());
			modelMap.addAttribute("derechos", derechos);
		}

		impuesto.setIdentificacion(identificacion);
		// Se la informacion capturada
		Date fechaPago = TimeUtils.getDate(impuesto.getFechaOperacion(),
				"dd/MMMM/yy HH:mm");
		String nombre = getNombre(identificacion);

		Concepto total = Concepto.getConcepto(identificacion.getConceptos(),
				ConceptosImpuestosIdentificacion.TOTAL_EFECTIVAMENTE_PAGADO
						.getValor());
		Concepto rfc = Concepto.getConcepto(identificacion.getConceptos(),
				ConceptosImpuestosIdentificacion.RFC.getValor());

		// Se genera el folio fiscal de la operacion
		String folioFiscal = impuestosService.generaFolioFiscal(
				impuesto.getContratoId(), rfc.getValor());

		// Se genera la llave del pago
		String llavePago = impuestosService.generaLlaveDePago(
				TimeUtils.getDateFormat(fechaPago, "yyyy")
						+ TimeUtils.getDateFormat(fechaPago, "MM")
						+ TimeUtils.getDateFormat(fechaPago, "dd"),
				TimeUtils.getDateFormat(fechaPago, "MM"), nombre,
				total.getValor(), folioFiscal);
		// Se genera la referencia de afirmenet
		impuesto.setAfirmeNetReference(Util.getRefNum());
		impuesto.setLlavePago(llavePago);
		impuesto.setNombreORazonSocial(nombre);
		impuesto.setRfc(rfc.getValor());
		impuesto.setTotalPagado(total.getValorImpresion());
		impuesto.setFolioPago(folioFiscal);

		impuesto.setValidationDate(TimeUtils.getDateFormat(fechaPago, "yyyy")
				+ TimeUtils.getDateFormat(fechaPago, "MM")
				+ TimeUtils.getDateFormat(fechaPago, "dd"));
		impuesto.setValidationYear(TimeUtils.getDateFormat(fechaPago, "yy"));
		impuesto.setValidationMonth(TimeUtils.getDateFormat(fechaPago, "MM"));
		impuesto.setValidationDay(TimeUtils.getDateFormat(fechaPago, "dd"));
		impuesto.setValidationHour(TimeUtils.getDateFormat(fechaPago, "HH"));
		impuesto.setValidationMinute(TimeUtils.getDateFormat(fechaPago, "mm"));
		impuesto.setPlazaReceiving("0");
		impuesto.setBankFrm("62");
		impuesto.setInterType(Integer.valueOf(impuesto.getTipoImpuesto()
				.getValor()));
		impuesto.setServiceType(Integer
				.valueOf(TipoTransferencia.PAGO_DE_IMPUESTOS.getValor()));

		modelMap.addAttribute("impuesto", impuesto);
		return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_FED_CONFIRMA;
	}

	/**
	 * Metodo que muestra la confirmacion del pago de impuestos
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ejecutar", method = RequestMethod.POST)
	public String ejecutaContribucionesFederalesAnuales(
			@ModelAttribute("impuesto") Impuesto impuesto, ModelMap modelMap,
			SessionStatus sessionStatus, HttpServletRequest request) {

		// Se crea la lista de transferencias
		List<TransferenciaBase> listTransferencias = new ArrayList<TransferenciaBase>(
				0);
		listTransferencias.add(impuesto);

		impuestosSATService.setTransferencias(listTransferencias);

		// Se validan las transferencias
		impuestosSATService.validaTransferencias(listTransferencias);
		if (listTransferencias.get(0).getErrores() != null
				&& !listTransferencias.get(0).getErrores().isEmpty()) {
			// retorna errores
			Map<String, List<String>> errores = TransferenciaController
					.getErrores(listTransferencias);
			sessionStatus.setComplete();
			prepare(request, modelMap, impuesto.getTipoImpuesto());
			modelMap.addAttribute("errores", errores);
			return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_FED_CAPTURA;
		} else {
			// Si no hay errores de validacion se confirman los impuestos
			// Se ejecuta la programacion
			@SuppressWarnings("unchecked")
			List<Comprobante> comprobantes = (List<Comprobante>) impuestosSATService
					.confirmaTransferencias();
			if (comprobantes.get(0).getErrores() != null
					|| !comprobantes.get(0).getErrores().isEmpty()) {
				sessionStatus.setComplete();
				Map<String, List<String>> errores = TransferenciaController
						.getErrores(comprobantes);
				prepare(request, modelMap, impuesto.getTipoImpuesto());
				modelMap.addAttribute("errores", errores);
				
				return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_FED_CAPTURA;
			}

			impuesto.setReferenceNumber(comprobantes.get(0)
					.getReferenceNumber());
			modelMap.addAttribute("impuesto", impuesto);
			// redirectAttributes.addFlashAttribute("transferencia",
			// comprobantes.get(0));
			// return "redirect:" +
			// AfirmeNetWebConstants.MV_DOMINGO_ELEC_EJECUTAR;

			return AfirmeNetWebConstants.MV_PAGOS_IMPUESTOS_FED_COMPROBANTE;
		}

	}

	private String getNombre(Identificacion identificacion) {
		String nombreStr = "";
		Concepto cia = Concepto.getConcepto(identificacion.getConceptos(),
				ConceptosImpuestosIdentificacion.DENOMINACION.getValor());
		if (cia == null) {

			Concepto nombre = Concepto.getConcepto(
					identificacion.getConceptos(), "10005");
			Concepto paterno = Concepto.getConcepto(
					identificacion.getConceptos(), "10003");
			Concepto materno = Concepto.getConcepto(
					identificacion.getConceptos(), "10004");

			nombreStr = paterno.getValorImpresion() + " "
					+ materno.getValorImpresion() + " "
					+ nombre.getValorImpresion();
		} else {
			nombreStr = cia.getValorImpresion();
		}

		return nombreStr;
	}

}
