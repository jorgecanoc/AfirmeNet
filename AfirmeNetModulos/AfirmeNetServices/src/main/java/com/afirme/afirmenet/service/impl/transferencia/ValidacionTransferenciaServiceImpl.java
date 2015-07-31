package com.afirme.afirmenet.service.impl.transferencia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.transferencia.ParametricasUsuarioDao;
import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.objects.parameter.JOParamAccumAcc;
import com.afirme.afirmenet.ibs.objects.parameter.JOParamOwnAcc;
import com.afirme.afirmenet.model.Holiday;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.transferencia.ValidacionTransferenciaService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
import com.afirme.afirmenet.utils.time.TimeUtils;

@Service
public class ValidacionTransferenciaServiceImpl implements
		ValidacionTransferenciaService {
	@Autowired
	ParametricasUsuarioDao parametricasTransaccionDao;


	@Override
	public boolean isOnDailyLimit(TransferenciaBase tranferenciaBase,TipoTransferencia tipo)
			throws AfirmeNetException {
		boolean goHead = true;
		// Se crea Objeto de Trasnporte
		String debitAccount = tranferenciaBase.getDebitAccount();
		if(tranferenciaBase.getOrigen() != null){
			debitAccount = tranferenciaBase.getOrigen().getNumber();
		}
		JOParamAccumAcc param = new JOParamAccumAcc(
				tranferenciaBase.getContractId(),
				debitAccount,
				tipo.getValor(), 
				tranferenciaBase.getInterType(), 
				tranferenciaBase.getServiceType(), 
				tranferenciaBase.getAmount().doubleValue(),
				tranferenciaBase.getValidationYear(),
				tranferenciaBase.getValidationMonth(),
				tranferenciaBase.getValidationDay());

		// Vetrifica si en la configuracion esta activa la validacion del limite
		// diario
		String property = AfirmeNetConstants
				.getValorConfigProperties(ConfigProperties.PROPERTYID_ACTIVE_LIMIT_TRANSFER);
		if (property == null || property.equals("Y")) {
			// Obtiene los parametros de transaccion del contrato especificaco
			// en la tranferenciaBase long contract, long account,String transtype, int serviceType, int intertype
			List<JOParamOwnAcc> parametros = parametricasTransaccionDao
					.getParameters(
							Long.valueOf(tranferenciaBase.getContractId()),
							Long.valueOf(debitAccount),
							tipo.getValor(), tranferenciaBase.getServiceType(), tranferenciaBase.getInterType());
			// Obtiene el acumulado mensual
			List<JOParamAccumAcc> acumulados = parametricasTransaccionDao
					.getAcumulado(param.getContract(), param.getAccount(),
							param.getTranstype(), param.getSertyp(),
							param.getIntertype(), param.getOpdate(),
							param.getOpdate());

			if (parametros.isEmpty()) {
				// Lanza excepcion
				throw new AfirmeNetException(CodigoExcepcion.ERR_3000.name(),"Mensaje temporal: no hay parametros de configuracion");				
//				throw new AfirmeNetException(CodigoExcepcion.ERR_2937.name(),
//						AfirmeNetConstants.errores.get(CodigoExcepcion.ERR_2937
//								.getValue()));

			}
			if (parametros.size() > 1) {
				// Lanza excepcion
				throw new AfirmeNetException(CodigoExcepcion.ERR_3000.name(),"Mensaje temporal: existen parametros duplicados");
				
//				throw new AfirmeNetException(CodigoExcepcion.ERR_2938.name(),
//						AfirmeNetConstants.errores.get(CodigoExcepcion.ERR_2938
//								.getValue()));
			}
			// Registro paramétrico.
			Iterator<JOParamOwnAcc> poIter = parametros.iterator();
			JOParamOwnAcc po = (JOParamOwnAcc) poIter.next();

			Iterator<JOParamAccumAcc> paaDIterator = acumulados.iterator();
			double dailyAccum = 0.0;
			while (paaDIterator.hasNext()) {
				JOParamAccumAcc paaD = (JOParamAccumAcc) paaDIterator.next();
				dailyAccum += paaD.getDailyamount();
			}
			// Monto remanente
			double remainingAmount = po.getDailyamount() - dailyAccum;

			if (po.getDailyamount() != 0.0) {

				if (dailyAccum >= po.getDailyamount()) {
					goHead = false;
				}
				if (param.getDailyamount() > remainingAmount) {
					goHead = false;
				}
			}
		}
		return goHead;

	}

	@Override
	public boolean isOnMonthlyLimit(TransferenciaBase tranferenciaBase,TipoTransferencia tipo)
			throws AfirmeNetException {
		boolean goHead = true;
		String debitAccount = tranferenciaBase.getDebitAccount();
		if(tranferenciaBase.getOrigen() != null){
			debitAccount = tranferenciaBase.getOrigen().getNumber();
		}		
		// Se crea Objeto de Trasnporte
		JOParamAccumAcc param = new JOParamAccumAcc(
				tranferenciaBase.getContractId(),
				debitAccount,
				tipo.getValor(), 
				tranferenciaBase.getInterType(), 
				tranferenciaBase.getServiceType(), 
				tranferenciaBase.getAmount().doubleValue(),
				tranferenciaBase.getValidationYear(),
				tranferenciaBase.getValidationMonth(),
				tranferenciaBase.getValidationDay());

		// Vetrifica si en la configuracion esta activa la validacion del limite
		// diario
		String property = AfirmeNetConstants
				.getValorConfigProperties(ConfigProperties.PROPERTYID_ACTIVE_LIMIT_TRANSFER);
		if (property == null || property.equals("Y")) {
			// Obtiene los parametros de transaccion del contrato especificaco
			// en la tranferenciaBase
			List<JOParamOwnAcc> parametros = parametricasTransaccionDao
					.getParameters(
							Long.valueOf(tranferenciaBase.getContractId()),
							Long.valueOf(debitAccount),
							tipo.getValor(), tranferenciaBase.getServiceType(), tranferenciaBase.getInterType());
			// Obtine el acumulado mensual
			List<JOParamAccumAcc> acumulados = parametricasTransaccionDao
					.getAcumulado(param.getContract(), param.getAccount(),
							param.getTranstype(), param.getSertyp(),
							param.getIntertype(), param.getOpdate(), null);

			if (parametros.isEmpty()) {
				// Lanza excepcion
				throw new AfirmeNetException(CodigoExcepcion.ERR_3000.name(),"Mensaje temporal: no hay parametros de configuracion");				
//				throw new AfirmeNetException(CodigoExcepcion.ERR_2937.name(),
//						AfirmeNetConstants.errores.get(CodigoExcepcion.ERR_2937
//								.getValue()));


			}
			if (parametros.size() > 1) {
				// Lanza excepcion
				throw new AfirmeNetException(CodigoExcepcion.ERR_3000.name(),"Mensaje temporal: existen parametros duplicados");
				
//				throw new AfirmeNetException(CodigoExcepcion.ERR_2938.name(),
//						AfirmeNetConstants.errores.get(CodigoExcepcion.ERR_2938
//								.getValue()));
			}
			// Registro paramétrico.
			Iterator<JOParamOwnAcc> poIter = parametros.iterator();
			JOParamOwnAcc po = (JOParamOwnAcc) poIter.next();

			Iterator<JOParamAccumAcc> paaDIterator = acumulados.iterator();
			double montlyAmount = 0.0;
			while (paaDIterator.hasNext()) {
				JOParamAccumAcc paaD = (JOParamAccumAcc) paaDIterator.next();
				montlyAmount += paaD.getDailyamount();
			}
			// Monto remanente
			double remainingAmount = po.getDailyamount() - montlyAmount;

			if (po.getDailyamount() != 0.0) {

				if (montlyAmount >= po.getDailyamount()) {
					goHead = false;
				}
				if (param.getDailyamount() > remainingAmount) {
					goHead = false;
				}
			}
		}
		return goHead;
	}

	@Override
	public boolean isValidDate(TransferenciaBase tranferenciaBase)
			throws AfirmeNetException {
		// Se valida si es feriado el dia
		if (isHolyDate(tranferenciaBase.getValidationYear(),
				tranferenciaBase.getValidationMonth(),
				tranferenciaBase.getValidationDay())) {
			return false;
		}
		// This Validates that the Date is not over today's date
		if (TimeUtils.compareYYMMDD(tranferenciaBase.getValidationYear(),
				tranferenciaBase.getValidationDay(),
				tranferenciaBase.getValidationMonth())) {
			return false;
		}

		return true;
	}

	@Override
	public Map<CodigoExcepcion, String> applyGeneralValidations(
			TransferenciaBase tranferenciaBase,TipoTransferencia tipo) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>();
		try {
			if (!this.isValidTime(tranferenciaBase, tipo)) {
				// Almacena Error
				errors.put(CodigoExcepcion.ERR_2931, AfirmeNetConstants.errores
						.get(CodigoExcepcion.ERR_2931.getValue()));
			}
		} catch (Exception e) {
			errors.put(CodigoExcepcion.ERR_2931, AfirmeNetConstants.errores
					.get(CodigoExcepcion.ERR_2931.getValue()));
		}
	
		try {
			if (!this.isOnDailyLimit(tranferenciaBase, tipo)) {
				// Almacena Error
				errors.put(CodigoExcepcion.ERR_2908 , AfirmeNetConstants.errores
						.get(CodigoExcepcion.ERR_2908.getValue()));
			}
		} catch (AfirmeNetException e) {
			errors.put(CodigoExcepcion.findByValue(2935), e.getErrMsg());
		}

		try {
			if (!this.isOnMonthlyLimit(tranferenciaBase, tipo)) {
				errors.put(CodigoExcepcion.ERR_2936, AfirmeNetConstants.errores
						.get(CodigoExcepcion.ERR_2936.getValue()));
			}
		} catch (AfirmeNetException e) {
			errors.put(CodigoExcepcion.findByValue(2936), e.getErrMsg());
		}

		try {
			if (!this.isValidDate(tranferenciaBase)) {
				errors.put(CodigoExcepcion.ERR_2931, AfirmeNetConstants.errores
						.get(CodigoExcepcion.ERR_2931.getValue()));
			}
		} catch (AfirmeNetException e) {
			errors.put(CodigoExcepcion.findByValue(2931), e.getErrMsg());
		}

		return errors;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isHolyDate(String YY, String MM, String DD) {

		boolean holy = false;
		for (Holiday holiday : (List<Holiday>) AfirmeNetConstants.holidayList) {
			String YYB = holiday.getYear();
			while (YYB.length() < 2) {
				YYB = "0" + YYB;
			}
			String MMB = holiday.getMonth();
			while (MMB.length() < 2) {
				MMB = "0" + MMB;
			}
			String DDB = holiday.getDayOfMonth();
			while (DDB.length() < 2) {
				DDB = "0" + DDB;
			}
			String WKB = holiday.getDay();

			if (YY.equals(YYB) && MM.equals(MMB) && DD.equals(DDB)) {
				if (!WKB.equals("SU") && !WKB.equals("SA")) {
					holy = true;
					break;
				}
				break;
			}
		}

		return (holy);
	}

	@Override
	public void applyValidations(List<TransferenciaBase> tranferencias, TipoTransferencia tipo, List<TipoValidacion> validaciones) {
		Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(0);
		if(validaciones == null || validaciones.isEmpty()){
			return;
		}
		for (TransferenciaBase tx : tranferencias) {
			if(tx.getTipoTransferencia() == null){
				tx.setTipoTransferencia(tipo);	
			}
			
			for(TipoValidacion validacion: validaciones){
				switch (validacion) {
				case HORARIO:
					try {
						if (!this.isValidTime(tx, tx.getTipoTransferencia())) {
							// Almacena Error
							errors.put(CodigoExcepcion.ERR_2931, AfirmeNetConstants.errores
									.get(CodigoExcepcion.ERR_2931.getValue()));
						}
					} catch (Exception e) {
						errors.put(CodigoExcepcion.ERR_2931, AfirmeNetConstants.errores
								.get(CodigoExcepcion.ERR_2931.getValue()));
					}
					break;
				case FECHA:
					try {
						if (!this.isValidDate(tx)) {
							errors.put(CodigoExcepcion.ERR_2931, AfirmeNetConstants.errores
									.get(CodigoExcepcion.ERR_2931.getValue()));
						}
					} catch (AfirmeNetException e) {
						errors.put(CodigoExcepcion.findByValue(2931), e.getErrMsg());
					}					
					break;
				case LIMITE_DIARIO:
					try {
						if (!this.isOnDailyLimit(tx, tx.getTipoTransferencia())) {
							// Almacena Error
							errors.put(CodigoExcepcion.ERR_2908 , AfirmeNetConstants.errores
									.get(CodigoExcepcion.ERR_2908.getValue()));
						}
					} catch (AfirmeNetException e) {
						errors.put(CodigoExcepcion.findByValue(2935), e.getErrMsg());
					}					
					break;
				case LIMITE_MENSUAL:
					try {
						if (!this.isOnMonthlyLimit(tx, tx.getTipoTransferencia())) {
							errors.put(CodigoExcepcion.ERR_2936, AfirmeNetConstants.errores
									.get(CodigoExcepcion.ERR_2936.getValue()));
						}
					} catch (AfirmeNetException e) {
						errors.put(CodigoExcepcion.findByValue(2936), e.getErrMsg());
					}					
					break;

				default:
					break;
				}

			}

			if (!errors.isEmpty()) {
				tx.setErrores(errors);
			}
		}
	}

	@Override
	public boolean isValidTime(TransferenciaBase tranferenciaBase, TipoTransferencia tipo)
			throws AfirmeNetException {
		boolean isValid = false;
		
		int addTime= 1;
		
		switch (tipo) {
		case TRASPASO_PROPIAS:
			addTime = 2;
			break;
		case TRANSFERENCIA_SPEI:
			addTime = 5;
			break;
		case TRASPASO_TERCEROS:
			addTime = 5;
			break;
		default:
			addTime = 100;
			break;
		}
		
	      boolean timeOk = false;
	      boolean date = false;

	      int dd = Integer.parseInt(tranferenciaBase.getValidationDay());
	      int mm = Integer.parseInt(tranferenciaBase.getValidationMonth());
	      int yy = Integer.parseInt(tranferenciaBase.getValidationYear());
	      if((dd == Integer.parseInt(TimeUtils.getDD())) && (mm == Integer.parseInt(TimeUtils.getMM())) && (yy == Integer.parseInt(TimeUtils.getYY())))
	      {
	    	  date = true;
	      }
	      
	      int hh = Integer.parseInt(tranferenciaBase.getValidationHour());
	      int ss = Integer.parseInt(tranferenciaBase.getValidationMinute());
	      int tTime = 0;
	      int cTime = 0;
	      
		if ((hh == 0) && (ss == 0)) {
			if (date) {
				hh = Integer.parseInt(TimeUtils.getHH());
				ss = Integer.parseInt(TimeUtils.getSS());

				String dayWeek = TimeUtils.getDayofWeek(mm, dd, yy);
				tTime = (hh * 100) + ss;
				timeOk = parametricasTransaccionDao.trasnferenciaEnTiempo(tipo,
						tTime, dayWeek);
			} else {
				timeOk = false;
			}
		} else {
			String dayWeek = TimeUtils.getDayofWeek(mm, dd, yy);
			tTime = (hh * 100) + ss;
			timeOk = parametricasTransaccionDao.trasnferenciaEnTiempo(tipo,tTime, dayWeek);

			if (timeOk) {
				cTime = (Integer.parseInt(TimeUtils.getHH()) * 100)
						+ Integer.parseInt(TimeUtils.getSS()) + addTime;
				if (date) {
					if (cTime > tTime) {
						timeOk = false;
					}
				}

			}
		}

		if (timeOk) {
			timeOk = !TimeUtils.compareDate(String.valueOf(yy),
					String.valueOf(dd), String.valueOf(mm), String.valueOf(hh),
					String.valueOf(ss));
		}
		if (!timeOk) {
			isValid = false;
		}else{
			isValid = true;
		}
		return isValid;
	}
	

}
