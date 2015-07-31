package com.afirme.afirmenet.helper.pagos.servicios;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.dao.pagos.PagosDao;
import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.model.pagos.servicios.ReferenciaServicio;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.utils.time.TimeUtils;

@Component
public class ValidacionesServicios {
	@Autowired
	PagosDao pagosDao;

	public Map<CodigoExcepcion, String> validaComapa(Servicio servicio) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);

		final int LINEA_IMPORTE = 1;
		final int LINEA_IMPORTE_FECHA = 2;
		final int LINEA_FECHA = 3;

		int tipoValidacion = Integer.parseInt(servicio.getReferenceNumber()
				.substring(servicio.getReferenceNumber().length() - 3,
						servicio.getReferenceNumber().length() - 2));

		int lmin = 10;
		int lmax = 64;
		if (!validaLongitudReferencia(servicio, lmin, lmax)) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"Favor de revisar la longitud de la referencia, debido a que es una longitud inválida."
							+ " Una referencia válida tiene un mínimo de "
							+ lmin
							+ " caracteres y un máximo de "
							+ lmax
							+ " caracteres.");
		}

		if (!validaRefLinea(servicio)) {
			errors.put(CodigoExcepcion.ERR_3000,
					"Favor de revisar la referencia, debido a que es una referencia inválida");
		}
		switch (tipoValidacion) {

		case LINEA_IMPORTE:
			if (!validaRefImporte(servicio)) {
				errors.put(
						CodigoExcepcion.ERR_3000,
						"Favor de revisar el monto a pagar, debido a que no corresponde con el monto de su recibo.");
			}
			break;
		case LINEA_IMPORTE_FECHA:
			if (!validaRefImporte(servicio)) {
				errors.put(
						CodigoExcepcion.ERR_3000,
						"Favor de revisar el monto a pagar, debido a que no corresponde con el monto de su recibo.");
			}
			if (!validaRefFecha(servicio)) {
				errors.put(
						CodigoExcepcion.ERR_3000,
						"Favor de revisar el monto a pagar, debido a que no corresponde con el monto de su recibo.");
			}
		case LINEA_FECHA:
			if (!validaRefFecha(servicio)) {
				errors.put(
						CodigoExcepcion.ERR_3000,
						"Favor de revisar el monto a pagar, debido a que no corresponde con el monto de su recibo.");
			}
			break;
		}

		return errors;
	}

	public Map<CodigoExcepcion, String> validaCodigoGas(Servicio servicio,
			String ciudad) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);
		String s = "";
		// Se verifica que el contrato perteneza a Monterrey o Saltillo
		s = servicio.getReferenceNumber().substring(2, 4);
		if (!(s.equals("17") || s.equals("16"))) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"Favor de revisar la referencia, debido a que no pertenece a una ciudad válida.");
		} else {
			if (ciudad.equals("S")) {
				if (!s.equals("16")) {
					errors.put(CodigoExcepcion.ERR_3000,
							"Favor de revisar la referencia, debido a que no pertenece a Saltillo.");

				}
			} else {
				if (!s.equals("17")) {
					errors.put(CodigoExcepcion.ERR_3000,
							"Favor de revisar la referencia, debido a que no pertenece a Monterrey.");
				}
			}
		}
		int m = 1;
		int suma = 0;
		int digito = 0;
		for (int i = 1; i <= 19; i++) {
			switch (m) {
			case 1:
				s = String.valueOf(2 * Integer.parseInt(servicio
						.getReferenceNumber().substring(i - 1, i)));
				m = 2;
				break;
			case 2:
				s = servicio.getReferenceNumber().substring(i - 1, i);
				m = 1;
				break;
			}
			for (int j = 1; j <= s.length(); j++)
				suma += Integer.parseInt(s.substring(j - 1, j));
		}
		digito = suma % 10;
		if (digito != 0)
			digito = 10 - digito;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(19, 20)) != digito) {
			errors.put(CodigoExcepcion.ERR_3000,
					"Favor de revisar la referencia, debido a que es una referencia inválida.");
		}

		if (!esValidaFechaProgramada(servicio)) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"No se puede realizar el pago, debido a que la fecha de ejecución es mayor a la fecha de vencimiento de la factura.");
		}

		if (!validaFechaVencimiento(servicio)) {
			errors.put(CodigoExcepcion.ERR_3000,
					"No se puede realizar el pago, debido a que ya pasó la fecha de vencimiento.");
		}
		return errors;
	}

	public Map<CodigoExcepcion, String> validaAxtel(Servicio servicio) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);

		ReferenciaServicio ref = pagosDao.getReferenciaServicio("AXTEL");
		if (ref == null) {
			errors.put(CodigoExcepcion.ERR_3000,
					"Hubo un problema en la validación. Intente más tarde");
		}
		int lmin = 3;
		int lmax = 26;
		if (!validaLongitudReferencia(servicio, lmin, lmax)) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"Favor de revisar la longitud de la referencia, debido a que es una longitud inválida."
							+ " Una referencia válida tiene un mínimo de "
							+ lmin
							+ " caracteres y un máximo de "
							+ lmax
							+ " caracteres.");
		}

		if (!validaRef_PRF(ref.getAlgoritmo(), servicio)) {
			errors.put(CodigoExcepcion.ERR_3000,
					"Favor de revisar la referencia, debido a que es una referencia inválida.");
		}

		// fecha de vencimiento
		if (ref.getAceptaPagosVencidos().equals("N")) {
			if (!validaFechaProgramada_PRF(servicio, ref.getDiasGracia())) {
				errors.put(
						CodigoExcepcion.ERR_3000,
						"No se puede realizar el pago, debido a que la fecha de ejecución es mayor a la fecha de vencimiento de la factura.");
			}
		}
		// Se calculan los recargos
		calculaRecargos(ref, servicio);

		// Acepta Pagos Parciales
		if (ref.getAceptaPagosParciales().equals("N")) {
			if (!validaModulo97(servicio)) {
				errors.put(CodigoExcepcion.ERR_3000,
						"Favor de revisar la referencia, debido a que es una referencia inválida.");
			}
		}

		return errors;
	}

	public Map<CodigoExcepcion, String> validaTDCRed(Servicio servicio) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);
		if (!validaTarjCredito(servicio)) {
			errors.put(CodigoExcepcion.ERR_3000,
					"El BIN de la tarjeta no fue localizado");
		}

		return errors;
	}

	public Map<CodigoExcepcion, String> validaCFEMonterrey(Servicio servicio) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);
		if (!validaMontoCFEMty(servicio)) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"Favor de revisar el monto a pagar, debido a que no corresponde con el monto de su recibo.");
		}
		if (!validaCodigoCFEMty(servicio)) {
			errors.put(CodigoExcepcion.ERR_3000,
					"Favor de revisar el código de barras, debido a que es un código inválido.");
		}

		return errors;
	}

	public Map<CodigoExcepcion, String> validaAguaMonterrey(Servicio servicio) {

		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
				0);

		int fechaCondensada = Integer.parseInt(servicio.getReferenceNumber()
				.substring(servicio.getReferenceNumber().length() - 7,
						servicio.getReferenceNumber().length() - 3));

		servicio.setAnioVencimiento(fechaCondensada / 372 + 2013);
		servicio.setMesVencimiento((fechaCondensada % 372) / 31 + 1);
		servicio.setDiaVencimiento((fechaCondensada % 372) % 31 + 1);

		if (!esValidaFechaProgramada(servicio)) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"No se puede realizar el pago, debido a que la fecha de ejecución es mayor a la fecha de vencimiento de la factura.");
		}

		if (!validaFechaVencimiento(servicio)) {
			errors.put(CodigoExcepcion.ERR_3000,
					"No se puede realizar el pago, debido a que ya pasó la fecha de vencimiento.");
		}

		if (!validaMontoModulo97(servicio)) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"Favor de revisar el monto a pagar, debido a que no corresponde con el monto de su recibo.");
		}
		int lmin = 9;
		int lmax = 30;

		if (!validaLongitudReferencia(servicio, lmin, lmax)) {
			errors.put(
					CodigoExcepcion.ERR_3000,
					"Favor de revisar la longitud de la referencia, debido a que es una longitud inválida."
							+ " Una referencia válida tiene un mínimo de 9 caracteres y un máximo de 30 caracteres.");
		}

		if (!validaModulo97(servicio)) {
			errors.put(CodigoExcepcion.ERR_3000,
					"Favor de revisar la referencia, debido a que es una referencia inválida.");
		}

		return errors;
	}

	/**
	 * Esta validacion se utiliza para validar la fecha de ejecucion contra la
	 * fecha de Vencimiento.
	 * 
	 * @param tipo
	 * @return
	 */
	private boolean esValidaFechaProgramada(Servicio servicio)
			throws AfirmeNetException {
		boolean esValida = true;
		// Crea la fecha apartir de inicioProgramacion y horaProgramacion
		Date fechaProgramada = null;

		if (servicio.getInicioProgramacion() != null && !StringUtils.isEmpty(servicio.getInicioProgramacion()) 
				&& servicio.getInicioProgramacion() != null && !StringUtils.isEmpty(servicio.getInicioProgramacion())) {
			fechaProgramada = TimeUtils.getDate(
					servicio.getInicioProgramacion() + " "
							+ servicio.getHoraProgramacion(),
					"dd/MMMM/yyyy HH:mm");
		} else {
			fechaProgramada = TimeUtils.getDate(servicio.getProgrammingDate()
					+ " 00:01", "dd/MM/yyyy HH:mm");
		}

		GregorianCalendar fechalimitePago = new GregorianCalendar();
		fechalimitePago.set(servicio.getAnioVencimiento(),
				servicio.getMesVencimiento() - 1, servicio.getDiaVencimiento(),
				23, 59, 58);
		fechalimitePago.add(Calendar.SECOND, 1);

		if (fechaProgramada.after(fechalimitePago.getTime())) {
			esValida = false;
		}
		return esValida;
	}

	/**
	 * Esta validacion se utiliza para comparar la fecha Actual contra la fecha
	 * de Vencimiento. Como comentario adicional esta validacion solo se usa
	 * para especificar el mensaje de que la fecha de vencimiento ya paso el dia
	 * actual, ya que esto se valida implicitamente en el metodo
	 * validaFechaProgramada
	 * 
	 * @param tipo
	 * @return
	 */
	private boolean validaFechaVencimiento(Servicio servicio) {
		boolean esValida = true;
		Date fechaHoy = Calendar.getInstance().getTime();
		
		
		Date fechalimitePago = TimeUtils.getDate(
				servicio.getDiaVencimiento() + "/"
						+ servicio.getMesVencimiento() + "/"
						+ servicio.getAnioVencimiento() + " 23:59",
				"dd/MM/yy HH:mm");		
		
		if (fechaHoy.after(fechalimitePago)) {
			esValida = false;
		}
		return esValida;
	}

	public static void main (String[] args){
		
//		boolean val = validaMontoModulo97();
//		Servicio servicio = new Servicio();
//		servicio.setAmount(BigDecimal.valueOf(1103.00));
//		servicio.setReferenceNumber("0549088001180957783");
//		
//		System.out.println("El resultado es:"+val);
//		
//		val = validaMontoModulo97(servicio);
//		System.out.println("El resultado es:"+val);
	}
	
	private  boolean validaMontoModulo97(Servicio servicio) {
		boolean esValida = true;
		String monto = com.afirme.afirmenet.utils.string.StringUtils.takeDot(servicio.getMontoStr());

		int digitoVF = 0;
		int[] vf = { 7, 3, 1 };
		int nr = 0;
		int suma = 0;
		for (int i = monto.length() - 1; i >= 0; i--) {
			suma += vf[nr] * Integer.parseInt(monto.substring(i, i + 1));
			nr++;
			if (nr == 3)
				nr = 0;
		}
		digitoVF = suma % 10;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				servicio.getReferenceNumber().length() - 3,
				servicio.getReferenceNumber().length() - 2)) != digitoVF) {

			esValida = false;
		}
		return esValida;
	}

	// Se usa para el servicio de Agua y Drenaje de Monterrey
	private boolean validaModulo97(Servicio servicio) {
		boolean esValida = true;
		int longRef = servicio.getReferenceNumber().length();

		int digitosVF = 0;
		int[] vf = { 11, 13, 17, 19, 23 };
		int nr = 0;
		int suma = 0;
		for (int i = longRef - 3; i >= 0; i--) {
			suma += vf[nr]
					* Integer.parseInt(servicio.getReferenceNumber()
							.substring(i, i + 1));
			nr++;
			if (nr == 5)
				nr = 0;
		}
		digitosVF = suma % 97;
		digitosVF += 1;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 2)) != digitosVF) {
			esValida = false;
		}

		return esValida;
	}

	// Se usa para el servicio de Agua y Drenaje de Monterrey
	private boolean validaLongitudReferencia(Servicio servicio, int lmin,
			int lmax) {
		boolean esValida = true;

		int longRef = servicio.getReferenceNumber().length();

		if (longRef >= lmin && longRef <= lmax) {
			// Nada que hacer
		} else {
			esValida = false;
		}

		return esValida;
	}

	private boolean validaMontoCFEMty(Servicio servicio) {
		boolean esValida = true;
		String montoRecibo = servicio.getReferenceNumber().substring(20, 29)
				+ "00";
		// El monto se convierte primero a cadena despues a entero para remover
		// los decimales y se asignan a string
		String monto = com.afirme.afirmenet.utils.string.StringUtils.takeDot(servicio.getMontoStr());

		monto = "000000000" + monto;
		monto = monto.substring(monto.length() - 11);

		if (!montoRecibo.equals(monto)) {
			esValida = false;
		}

		return esValida;
	}

	private boolean validaCodigoCFEMty(Servicio servicio) {
		boolean esValida = true;
		int[] vf = { 6, 5, 4, 3, 2, 7 };
		int nr = 0;
		int digito = 0;
		int suma = 0;
		for (int i = 1; i <= 29; i++) {
			suma += vf[nr]
					* Integer.parseInt(servicio.getReferenceNumber().substring(
							i - 1, i));
			nr++;
			if (nr == 6)
				nr = 0;
		}
		digito = suma % 11;
		if (digito >= 10)
			digito = digito - 10;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(29, 30)) != digito) {
			esValida = false;
		}

		return esValida;
	}

	private boolean validaTarjCredito(Servicio servicio) {
		return pagosDao
				.existeBIN400(servicio.getConvenio().getSERACC().substring(0, 6));
	}

	public boolean validaModulo45(Servicio servicio) {
		int lmin = 12;
		int lmax = 30;
		boolean esValida = true;

		if (!validaLongitudReferencia(servicio, lmin, lmax)) {
			return false;
		}

		int longRef = servicio.getReferenceNumber().length();

		Map<String, String> valorLetras = new HashMap<String, String>();
		valorLetras.put("A", "1");
		valorLetras.put("B", "2");
		valorLetras.put("C", "3");
		valorLetras.put("D", "4");
		valorLetras.put("E", "5");
		valorLetras.put("F", "6");
		valorLetras.put("G", "7");
		valorLetras.put("H", "8");
		valorLetras.put("I", "9");
		valorLetras.put("J", "1");
		valorLetras.put("K", "2");
		valorLetras.put("L", "3");
		valorLetras.put("M", "4");
		valorLetras.put("N", "5");
		valorLetras.put("O", "6");
		valorLetras.put("P", "7");
		valorLetras.put("Q", "8");
		valorLetras.put("R", "9");
		valorLetras.put("S", "1");
		valorLetras.put("T", "2");
		valorLetras.put("U", "3");
		valorLetras.put("V", "4");
		valorLetras.put("W", "5");
		valorLetras.put("X", "6");
		valorLetras.put("Y", "7");
		valorLetras.put("Z", "8");
		valorLetras.put("0", "0");
		valorLetras.put("1", "1");
		valorLetras.put("2", "2");
		valorLetras.put("3", "3");
		valorLetras.put("4", "4");
		valorLetras.put("5", "5");
		valorLetras.put("6", "6");
		valorLetras.put("7", "7");
		valorLetras.put("8", "8");
		valorLetras.put("9", "9");
		String s = "";
		int m = 1;
		int suma = 0;
		int digito = 0;
		for (int i = 1; i <= longRef - 1; i++) {
			int posNum = Integer.parseInt((String) valorLetras.get(servicio
					.getReferenceNumber().substring(i - 1, i)));
			switch (m) {
			case 1:
				s = String.valueOf(2 * posNum);
				m = 2;
				break;
			case 2:
				s = String.valueOf(posNum);
				m = 1;
				break;
			}
			for (int j = 1; j <= s.length(); j++)
				suma += Integer.parseInt(s.substring(j - 1, j));
		}
		digito = (suma / 10) * 10 + 10 - suma;
		if (digito == 10)
			digito = 0;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 1)) != digito) {
			esValida = false;
			// errorMsg =
			// "Favor de revisar la referencia, debido a que es una referencia inválida.";
		}

		return esValida;
	}

	public boolean validaRef_PRF(String algoritmo, Servicio servicio) {
		boolean errorVal = true;
		if (algoritmo.equals("DV0000")) {
			int lmin = 3;
			int lmax = 26;
			if (validaLongitudReferencia(servicio, lmin, lmax)) { // Valida
																	// longitudes
				errorVal = validaBase10(servicio);
			} else {
				errorVal = false;
			}

		} else if (algoritmo.equals("DV0001")) {
			int lmin = 9;
			int lmax = 30;
			if (validaLongitudReferencia(servicio, lmin, lmax)) { // Valida
																	// longitudes
				errorVal = validaBase11(servicio);
			} else {
				errorVal = false;
			}

		} else if (algoritmo.equals("DV0002")) {
			int lmin = 12;
			int lmax = 30;
			if (validaLongitudReferencia(servicio, lmin, lmax)) { // Valida
																	// longitudes
				errorVal = validaModulo45(servicio);
			} else {
				errorVal = false;
			}

		} else if (algoritmo.equals("DV0003")) {
			int lmin = 9;
			int lmax = 30;
			if (validaLongitudReferencia(servicio, lmin, lmax)) { // Valida
																	// longitudes
				errorVal = validaModulo97(servicio);
			} else {
				errorVal = false;
			}

		} else if (algoritmo.equals("DV0004")) {
			int lmin = 3;
			int lmax = 30;
			if (validaLongitudReferencia(servicio, lmin, lmax)) { // Valida
																	// longitudes
				errorVal = validaModulo98(servicio);
			} else {
				errorVal = false;
			}

		} else if (algoritmo.equals("DV0007")) {
			int lmin = 3;
			int lmax = 26;
			if (validaLongitudReferencia(servicio, lmin, lmax)) { // Valida
																	// longitudes
				errorVal = validaBase10Simple(servicio);
			} else {
				errorVal = false;
			}

		} else if (algoritmo.equals("DV0005")) {
			int lmin = 9;
			int lmax = 30;
			if (validaLongitudReferencia(servicio, lmin, lmax)) { // Valida
																	// longitudes
				errorVal = validaModulo99(servicio);
			} else {
				errorVal = false;
			}

		} else if (algoritmo.equals("")) {
			errorVal = false;
		}
		return errorVal;
	}

	public boolean validaBase10(Servicio servicio) {
		boolean errorVal = true;
		int longRef = servicio.getReferenceNumber().length();

		DecimalFormat formato12 = new DecimalFormat("000000000000");
		DecimalFormat formato25 = new DecimalFormat("0000000000000000000000000");
		String nuevaReferencia = formato12.format(Long.parseLong(servicio
				.getCuentaReferenciada()))
				+ formato25.format(Double.parseDouble(servicio
						.getReferenceNumber().substring(0, longRef - 1)));
		String s = "";
		int m = 1;
		int suma = 0;
		int digito = 0;
		for (int i = 1; i <= nuevaReferencia.length(); i++) {
			switch (m) {
			case 1:
				s = String.valueOf(2 * Integer.parseInt(nuevaReferencia
						.substring(i - 1, i)));
				m = 2;
				break;
			case 2:
				s = nuevaReferencia.substring(i - 1, i);
				m = 1;
				break;
			}
			for (int j = 1; j <= s.length(); j++)
				suma += Integer.parseInt(s.substring(j - 1, j));
		}
		digito = suma % 10;
		if (digito != 0)
			digito = 10 - digito;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 1)) != digito) {
			errorVal = false;
		}

		return errorVal;
	}

	/**
	 * Esta validacion se utiliza para validar la fecha de ejecucion contra la
	 * fecha de Vencimiento mas los dias de gracia.
	 * 
	 * @param tipo
	 * @return
	 */
	public boolean validaFechaProgramada_PRF(Servicio servicio, int diasGracia) {
		boolean errorVal = true;

		// Crea la fecha apartir de inicioProgramacion y horaProgramacion
		Date fechaProgramada = null;

		if (servicio.getInicioProgramacion() != null
				&& servicio.getInicioProgramacion() != null) {
			fechaProgramada = TimeUtils.getDate(
					servicio.getInicioProgramacion() + " "
							+ servicio.getHoraProgramacion(),
					"dd/MMMM/yyyy HH:mm");
		} else {
			fechaProgramada = TimeUtils.getDate(servicio.getProgrammingDate()
					+ " 00:00", "dd/MMMM/yyyy HH:mm");
		}

		GregorianCalendar fechalimitePago = new GregorianCalendar();
		fechalimitePago.set(servicio.getAnioVencimiento(),
				servicio.getMesVencimiento() - 1, servicio.getDiaVencimiento(),
				23, 59, 58);
		fechalimitePago.add(Calendar.SECOND, 1);
		if (diasGracia > 0) {
			fechalimitePago.add(Calendar.DATE, diasGracia);
		}
		if (fechaProgramada.after(fechalimitePago.getTime())) {
			errorVal = false;
		}
		return errorVal;
	}

	public void calculaRecargos(ReferenciaServicio ref, Servicio servicio) {
		BigDecimal recargos = BigDecimal.ZERO;
		try {
			// El monto se convierte primero a cadena despues a entero para
			// remover
			// los decimales y se asignan a string
			String monto = com.afirme.afirmenet.utils.string.StringUtils.takeDot(servicio.getMontoStr());

			String fechaVencimientoPR = String.valueOf(servicio
					.getAnioVencimiento())
					+ addCero(String.valueOf(servicio.getMesVencimiento()))
					+ addCero(String.valueOf(servicio.getDiaVencimiento()));

			String fechaProgEjecucion = String.valueOf(servicio
					.getProgrammingYear())
					+ addCero(String.valueOf(servicio.getProgrammingMonth()))
					+ addCero(String.valueOf(servicio.getProgrammingDay()));

			recargos = new BigDecimal(calculaRecargo(monto, fechaProgEjecucion,
					fechaVencimientoPR, ref));

			servicio.setRecargos(recargos);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

	private String addCero(String d1) {

		d1 = d1.length() == 1 ? "0" + d1 : d1;
		return d1;

	}

	/*
	 * Compara la fecha de ejecución (fechaHoy) con la fecha de
	 * Vencimiento(fechalimitePago) para calcular los recargos.
	 */
	public String calculaRecargo(String monto, String fecEjec, String fecVenc,
			ReferenciaServicio ref) {
		String recargo = "";
		String montoFijo = ref.getMontoPagoVencido();
		String porcentaje = ref.getPorcentajePagoVencido();
		// Se obtiene la fecha de hoy a las 00:00:01
		GregorianCalendar fechaHoy = new GregorianCalendar();
		fechaHoy.set(Integer.parseInt(fecEjec.substring(0, 4)),
				Integer.parseInt(fecEjec.substring(4, 6)) - 1,
				Integer.parseInt(fecEjec.substring(6, 8)), 0, 0, 0);
		fechaHoy.add(Calendar.SECOND, 1);
		// Se obtiene la fecha de vencimiento a las 00:00:01
		GregorianCalendar fechalimitePago = new GregorianCalendar();
		fechalimitePago.set(Integer.parseInt(fecVenc.substring(0, 4)),
				Integer.parseInt(fecVenc.substring(4, 6)) - 1,
				Integer.parseInt(fecVenc.substring(6, 8)), 0, 0, 0);
		fechalimitePago.add(Calendar.SECOND, 1);
		// Se le suman los dias de gracia
		fechalimitePago.add(Calendar.DATE, ref.getDiasGracia());
		if (ref.getFrecuenciaComision().equals("U")) {
			DecimalFormat formatoMonto = new DecimalFormat("##############0.00");
			if (Double.parseDouble(montoFijo) > 0) {
				BigDecimal mf = new BigDecimal(montoFijo);
				recargo = formatoMonto.format(mf.doubleValue());
			} else {
				BigDecimal montoOrig = new BigDecimal(monto);
				BigDecimal porcent = new BigDecimal(porcentaje);
				porcent = porcent.divide(new BigDecimal("100.00"),
						BigDecimal.ROUND_UP);
				montoOrig = montoOrig.multiply(porcent);
				recargo = formatoMonto.format(montoOrig.doubleValue());
			}
		} else if (ref.getFrecuenciaComision().equals("D")) {
			// Obten el numero de meses vencidos
			int diasVencidos = 1;
			fechalimitePago.add(Calendar.DATE, 1);
			while (fechalimitePago.before(fechaHoy)) {
				diasVencidos++;
				fechalimitePago.add(Calendar.DATE, 1);
			}
			DecimalFormat formatoMonto = new DecimalFormat("##############0.00");
			BigDecimal mv = new BigDecimal(String.valueOf(diasVencidos));
			if (Double.parseDouble(montoFijo) > 0) {
				BigDecimal mf = new BigDecimal(montoFijo);
				mf = mf.multiply(mv);
				recargo = formatoMonto.format(mf.doubleValue());
			} else {
				BigDecimal montoOrig = new BigDecimal(monto);
				BigDecimal porcent = new BigDecimal(porcentaje);
				porcent = porcent.divide(new BigDecimal("100.00"),
						BigDecimal.ROUND_UP);
				montoOrig = montoOrig.multiply(porcent);
				recargo = formatoMonto.format(montoOrig.doubleValue());
				montoOrig = new BigDecimal(recargo);
				montoOrig = montoOrig.multiply(mv);
				recargo = formatoMonto.format(montoOrig.doubleValue());
			}
		} else if (ref.getFrecuenciaComision().equals("M")) {
			// Obten el numero de meses vencidos
			int mesesVencidos = 1;
			fechalimitePago.add(Calendar.MONTH, 1);
			while (fechalimitePago.before(fechaHoy)) {
				mesesVencidos++;
				fechalimitePago.add(Calendar.MONTH, 1);
			}
			DecimalFormat formatoMonto = new DecimalFormat("##############0.00");
			BigDecimal mv = new BigDecimal(String.valueOf(mesesVencidos));
			if (Double.parseDouble(montoFijo) > 0) {
				BigDecimal mf = new BigDecimal(montoFijo);
				mf = mf.multiply(mv);
				recargo = formatoMonto.format(mf.doubleValue());
			} else {
				BigDecimal montoOrig = new BigDecimal(monto);
				BigDecimal porcent = new BigDecimal(porcentaje);
				porcent = porcent.divide(new BigDecimal("100.00"),
						BigDecimal.ROUND_UP);
				montoOrig = montoOrig.multiply(porcent);
				recargo = formatoMonto.format(montoOrig.doubleValue());
				montoOrig = new BigDecimal(recargo);
				montoOrig = montoOrig.multiply(mv);
				recargo = formatoMonto.format(montoOrig.doubleValue());
			}
		}
		return recargo;
	}

	public boolean validaBase11(Servicio servicio) {
		boolean errorVal = true;
		int longRef = servicio.getReferenceNumber().length();
		// int lmin=9;
		// int lmax=30;
		// if(longRef>=lmin && longRef<=lmax){
		int digito = 0;
		int[] vf = { 8, 1, 2, 3, 4, 5, 6, 7 };
		int nr = 0;
		int suma = 0;
		String s = "";
		for (int i = 1; i <= longRef - 1; i++) {
			s = String.valueOf(vf[nr]
					* Integer.parseInt(servicio.getReferenceNumber().substring(
							i - 1, i)));
			nr++;
			if (nr == 8)
				nr = 0;
			for (int j = 1; j <= s.length(); j++)
				suma += Integer.parseInt(s.substring(j - 1, j));
		}
		while (suma > 11) {
			s = String.valueOf(suma);
			suma = 0;
			for (int j = 1; j <= s.length(); j++)
				suma += Integer.parseInt(s.substring(j - 1, j));
		}
		digito = 11 - suma;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 1)) != digito) {
			errorVal = false;
		}

		// errorMsg="Favor de revisar la referencia, debido a que es una referencia inválida.";
		// }else{
		// errorMsg="Favor de revisar la longitud de la referencia, debido a que es una longitud inválida."
		// +" Una referencia válida tiene un mínimo de "+lmin+" caracteres y un máximo de "+lmax+" caracteres.";
		// }
		return errorVal;
	}

	public boolean validaModulo98(Servicio servicio) {
		boolean errorVal = true;
		int longRef = servicio.getReferenceNumber().length();

		Map<String, String> valorLetras = new HashMap<String, String>();
		valorLetras.put("A", "1");
		valorLetras.put("B", "2");
		valorLetras.put("C", "3");
		valorLetras.put("D", "4");
		valorLetras.put("E", "5");
		valorLetras.put("F", "6");
		valorLetras.put("G", "7");
		valorLetras.put("H", "8");
		valorLetras.put("I", "9");
		valorLetras.put("J", "1");
		valorLetras.put("K", "2");
		valorLetras.put("L", "3");
		valorLetras.put("M", "4");
		valorLetras.put("N", "5");
		valorLetras.put("O", "6");
		valorLetras.put("P", "7");
		valorLetras.put("Q", "8");
		valorLetras.put("R", "9");
		valorLetras.put("S", "1");
		valorLetras.put("T", "2");
		valorLetras.put("U", "3");
		valorLetras.put("V", "4");
		valorLetras.put("W", "5");
		valorLetras.put("X", "6");
		valorLetras.put("Y", "7");
		valorLetras.put("Z", "8");
		valorLetras.put("0", "0");
		valorLetras.put("1", "1");
		valorLetras.put("2", "2");
		valorLetras.put("3", "3");
		valorLetras.put("4", "4");
		valorLetras.put("5", "5");
		valorLetras.put("6", "6");
		valorLetras.put("7", "7");
		valorLetras.put("8", "8");
		valorLetras.put("9", "9");
		String s = "";
		int m = 1;
		int suma = 0;
		int digito = 0;
		for (int i = 1; i <= longRef - 1; i++) {
			int posNum = Integer.parseInt((String) valorLetras.get(servicio
					.getReferenceNumber().substring(i - 1, i)));
			switch (m) {
			case 1:
				s = String.valueOf(2 * posNum);
				m = 2;
				break;
			case 2:
				s = String.valueOf(posNum);
				m = 1;
				break;
			}
			for (int j = 1; j <= s.length(); j++)
				suma += Integer.parseInt(s.substring(j - 1, j));
		}
		digito = 10 - suma % 10;
		if (digito == 10)
			digito = 0;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 1)) != digito) {
			errorVal = false;
			// errorMsg =
			// "Favor de revisar la referencia, debido a que es una referencia inválida.";
		}

		return errorVal;
	}

	public boolean validaBase10Simple(Servicio servicio) {
		boolean errorVal = true;
		int longRef = servicio.getReferenceNumber().length();

		String nuevaReferencia = servicio.getReferenceNumber().substring(0,
				longRef - 1);
		String s = "";
		int suma = 0;
		int digito = 0;
		int mul;
		if (nuevaReferencia.length() % 2 == 0)
			mul = 1;
		else
			mul = 2;
		for (int i = 1; i <= nuevaReferencia.length(); i++) {
			s = String.valueOf(mul
					* Integer.parseInt(nuevaReferencia.substring(i - 1, i)));
			if (mul == 1)
				mul = 2;
			else
				mul = 1;
			for (int j = 1; j <= s.length(); j++)
				suma += Integer.parseInt(s.substring(j - 1, j));
		}
		digito = suma % 10;
		if (digito != 0)
			digito = 10 - digito;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 1)) != digito) {
			errorVal = false;
			// errorMsg="Favor de revisar la referencia, debido a que es una referencia inválida.";
		}
		return errorVal;
	}

	public boolean validaModulo99(Servicio servicio) {
		boolean errorVal = true;
		int longRef = servicio.getReferenceNumber().length();

		int digitosVF = 0;
		int[] vf = { 11, 13, 17, 19, 23 };
		int nr = 0;
		int suma = 0;
		for (int i = longRef - 3; i >= 0; i--) {
			suma += vf[nr]
					* Integer.parseInt(servicio.getReferenceNumber().substring(
							i, i + 1));
			nr++;
			if (nr == 5)
				nr = 0;
		}
		digitosVF = suma % 97;
		digitosVF += 1;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 2)) != digitosVF) {
			errorVal = false;
			// errorMsg="Favor de revisar la referencia, debido a que es una referencia inválida.";
		}

		return errorVal;
	}

	private boolean validaRefLinea(Servicio servicio) {
		boolean errorVal = true;
		int longRef = servicio.getReferenceNumber().length();
		// int lmin=10;
		// int lmax=64;
		// if(longRef>=lmin && longRef<=lmax){
		int digitosVF = 0;
		int[] vf = { 11, 13, 17, 19, 23 };
		int nr = 0;
		int suma = 0;
		for (int i = longRef - 3; i >= 0; i--) {
			suma += vf[nr]
					* Integer.parseInt(servicio.getReferenceNumber().substring(
							i, i + 1));
			nr++;
			if (nr == 5)
				nr = 0;
		}
		digitosVF = suma % 97;
		digitosVF += 1;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				longRef - 2)) != digitosVF) {
			errorVal = false;
			// errorMsg="Favor de revisar la referencia, debido a que es una referencia inválida.";
		}
		// }else{
		// errorMsg="Favor de revisar la longitud de la referencia, debido a que es una longitud inválida."
		// +" Una referencia válida tiene un mínimo de "+lmin+" caracteres y un máximo de "+lmax+" caracteres.";
		// }
		// System.out.println ("*****  VALIDACION DE LINEA : ["+errorVal+"]");
		return errorVal;
	}

	public boolean validaRefImporte(Servicio servicio) {
		boolean errorVal = true;
		// El monto se convierte primero a cadena despues a entero para
		// remover
		// los decimales y se asignan a string
		String monto = com.afirme.afirmenet.utils.string.StringUtils.takeDot(servicio.getMontoStr());
		int digitoVF = 0;
		int[] vf = { 7, 3, 1 };
		int nr = 0;
		int suma = 0;
		// System.out.println ("*****  MONTO  : ["+monto+"]");
		for (int i = monto.length() - 1; i >= 0; i--) {
			suma += vf[nr] * Integer.parseInt(monto.substring(i, i + 1));
			nr++;
			if (nr == 3)
				nr = 0;
		}
		digitoVF = suma % 10;
		if (Integer.parseInt(servicio.getReferenceNumber().substring(
				servicio.getReferenceNumber().length() - 4,
				servicio.getReferenceNumber().length() - 3)) != digitoVF) {
			errorVal = false;
		}

		// System.out.println ("*****  VALIDACION DE IMPORTE : ["+errorVal+"]");
		return errorVal;
	}

	public boolean validaRefFecha(Servicio servicio) {
		int fechaCondensada = Integer.parseInt(servicio.getReferenceNumber()
				.substring(servicio.getReferenceNumber().length() - 8,
						servicio.getReferenceNumber().length() - 4));
		int aVenc = fechaCondensada / 372 + 2013;
		int mVenc = (fechaCondensada % 372) / 31 + 1;
		int dVenc = (fechaCondensada % 372) % 31 + 1;

		servicio.setValidationYear(String.valueOf(aVenc));
		servicio.setValidationMonth(String.valueOf(mVenc));
		servicio.setValidationDay(String.valueOf(dVenc));
		return (!esValidaFechaProgramada(servicio) && !validaFechaVencimiento(servicio)) ? false
				: true;
	}
}
