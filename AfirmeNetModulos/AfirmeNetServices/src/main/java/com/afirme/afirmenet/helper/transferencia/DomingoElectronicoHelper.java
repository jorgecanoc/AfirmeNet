package com.afirme.afirmenet.helper.transferencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.BeanUtils;

import com.afirme.afirmenet.model.transferencia.DomingoElectronico;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.utils.time.TimeUtils;

public class DomingoElectronicoHelper {
	public static final int SEMANAL = 1;
	public static final int MENSUAL = 2;
	public static final int DIARIA = 3;

	public List<TransferenciaBase> getProgramacionDomingos(
			TransferenciaBase base) {
		DomingoElectronico domingo = (DomingoElectronico) base;
		List<TransferenciaBase> programacionList = new ArrayList<TransferenciaBase>(
				0);
		// Inicializacion de variables
		Date fechaIncioProgramacion = TimeUtils.getDate(
				domingo.getInicioProgramacion() + " "
						+ domingo.getHoraProgramacion(), "dd/MMMM/yyyy HH:mm");
		Date fechaFinProgramacion = TimeUtils.getDate(
				domingo.getFinProgramacion() + " "
						+ domingo.getHoraProgramacion(), "dd/MMMM/yyyy HH:mm");

		DateTime fechaFinal = new DateTime(fechaFinProgramacion);

		DateTime fechaPivote = new DateTime(fechaIncioProgramacion);
		
		
		while (fechaPivote.isBefore(fechaFinal)) {
			int tipoProgramacion = SEMANAL;
			
			if (domingo.getProgramacion().equals("DIARIA")) {
				tipoProgramacion = DIARIA;
			} else if (domingo.getProgramacion().equals("SEMANAL")) {
				tipoProgramacion = SEMANAL;
				fechaPivote =fechaPivote.withDayOfWeek(DateTimeConstants.SUNDAY);
			} else { // MENSUAL
				tipoProgramacion = MENSUAL;
			}

			programacionList.add(generaNuevaProgramacion(fechaPivote, base));
			fechaPivote = getSiguenteProgramacion(fechaPivote, tipoProgramacion);			
		}

		return programacionList;
	}

	public TransferenciaBase generaNuevaProgramacion(DateTime fechaPivote,
			TransferenciaBase base) {
		
		TransferenciaBase nuevaProgramacion = new TransferenciaBase();
		BeanUtils.copyProperties(base, nuevaProgramacion);

		nuevaProgramacion.setValidationDate(TimeUtils.getDateFormat(
				fechaPivote.toDate(), "dd/MM/yy"));
		nuevaProgramacion.setValidationYear(TimeUtils.getDateFormat(
				fechaPivote.toDate(), "yy"));
		nuevaProgramacion.setValidationMonth(TimeUtils.getDateFormat(
				fechaPivote.toDate(), "MM"));
		nuevaProgramacion.setValidationDay(TimeUtils.getDateFormat(
				fechaPivote.toDate(), "dd"));
		nuevaProgramacion.setValidationHour(TimeUtils.getDateFormat(
				fechaPivote.toDate(), "HH"));
		nuevaProgramacion.setValidationMinute(TimeUtils.getDateFormat(
				fechaPivote.toDate(), "mm"));

		return nuevaProgramacion;
	}

	public DateTime getSiguenteProgramacion(DateTime fechaPivote,
			int tipoProgramacion) {
		DateTime fechaCalculada = new DateTime();
		if (tipoProgramacion == DIARIA) {
			fechaCalculada = fechaPivote.plusDays(1);
		} else if (tipoProgramacion == SEMANAL) {
			fechaCalculada = fechaPivote.plusWeeks(1).withDayOfWeek(DateTimeConstants.SUNDAY);
		} else if (tipoProgramacion == MENSUAL) {
			fechaCalculada = fechaPivote.plusMonths(1);
		}
		return fechaCalculada;
	}
}
