package com.afirme.afirmenet.service.impl.acceso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.MenuDao;
import com.afirme.afirmenet.dao.transferencia.ParametricasUsuarioDao;
import com.afirme.afirmenet.enums.ConfigConvenios;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.beans.JBProCode;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuServicio;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuTransaccion;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.ibs.objects.parameter.JOParamOwnAcc;
import com.afirme.afirmenet.service.acceso.ParametricasLoginService;

@Service
public class ParametricasLoginServiceImpl implements ParametricasLoginService{
	
	@Autowired
	private ParametricasUsuarioDao parametricasUsuarioDao;	
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public void transactionSettings(long contract, String groupId,
			List<Cuenta> cuentas, List<INSER> servicios, List<JBProCode> procode) {

		try 
		{
			if (contract <= 0 || groupId == null)
				throw new AfirmeNetException ("3000"," El contrato y/o grupo del usuario incorrecto. Contrato: " + contract + " grupo: " + groupId);
				

			//Collection poCollection = ParamOwnAccBL.findParamOwnAcc(contract);
			List<JOParamOwnAcc> parametricas= parametricasUsuarioDao.getParameters(contract, 0, null, 0, 0);
			//CARGA LA TABLA DE TRANSACCIONES CON LIMITES
			List<JBMenuTransaccion> menuTransacciones= menuDao.findMenuTransaccional();
			//CARGA LA TABLA DE SERVICIOS CON LIMITES
			List<JBMenuServicio> menuServicios= menuDao.findMenuServios();
			for(Cuenta cuenta:cuentas){//while (account.getNextRowC())
				if(cuenta.getType().equals("DDA") || cuenta.getType().equals("SAV") || 
				   cuenta.getType().equals("NOW")|| 
				  (cuenta.getType().equals("MMK") && (!cuenta.getNumber().trim().substring(0,3).equals("900"))))
				{ 
					String accStr = cuenta.getNumber();
					String currency = cuenta.getCcy().trim();

					long accPointer = 0;
					

					List<JOParamOwnAcc> updateCollection = new ArrayList<JOParamOwnAcc>();
					List<JOParamOwnAcc> insertCollection = new ArrayList<JOParamOwnAcc>();
					for(JOParamOwnAcc parametro:parametricas)//while (poIter.hasNext())
					{		
						if (parametro.getAccount() == Long.valueOf(accStr).longValue() && parametro.getCurrency().trim().equals(currency.trim()))
						{
							// para cada número de cuenta se valida si hay nuevas transacciones o servicios	
							if (parametro.getAccount() != accPointer)						
							{
								insertCollection=lookupNewTransaction(groupId, contract, Long.valueOf(accStr.trim()).longValue(), 
										            currency, parametricas, servicios, procode, menuTransacciones,menuServicios, insertCollection);
							}
							// Valida si hay cambios en las transacciones que ya están dadas de alta.																		
							updateCollection=lookupTransactionChange(groupId, parametro, servicios, procode,menuTransacciones,menuServicios, updateCollection);
							
							accPointer = parametro.getAccount();
						}
												
					}
					if (insertCollection.size() > 0 )
						insertParamOwnAcc(insertCollection);
					if (updateCollection.size() > 0)
						updateParamOwnAcc(updateCollection);
					
					if (Long.valueOf(accStr).longValue() != accPointer)
						loadDefaultParameter(contract, Long.valueOf(accStr.trim()).longValue(), currency, groupId, servicios, procode,menuTransacciones,menuServicios);
				}				
			}
			
		} 
		catch (Exception e) 
		{
			
			throw new AfirmeNetException ("3000","No se puede cargar la información paramétrica del usuario ");
		}
		
	}

	@Override
	public List<JOParamOwnAcc> lookupNewTransaction (String groupId, long contract, long account, String currency, 
			List<JOParamOwnAcc> parametricas, List<INSER> servicios, List<JBProCode> procode, List<JBMenuTransaccion> menuTransacciones,
			List<JBMenuServicio> menuServicios, List<JOParamOwnAcc> insertCollection) throws Exception
	{
		
		try 
		{
			for(JBMenuTransaccion menuTransaccion:menuTransacciones){
				String name = getParametricName(menuTransaccion, menuServicios, servicios, procode);
				if (menuTransaccion.getActive().equals("S"))
				{
					if (menuTransaccion.getTranstype().trim().equals(JOParamOwnAcc.TRANSTYPE_PAGO_SERVICIOS) && isBasicService(menuTransaccion))
						newBasicService(contract, account, currency, String.valueOf(menuTransaccion.getTranstype()), parametricas, servicios,insertCollection);
					else
						newTransaction(contract, account, currency, name, menuTransaccion, parametricas,insertCollection);
				}				
			}
		} 
		catch (Exception e) 
		{
			throw new AfirmeNetException ("3000","No se pudo cargar la parametrización para el usuario. Por favor contacte a su administrador.");
		}
		
		return insertCollection;
	}

	private boolean isBasicService(JBMenuTransaccion menuTransaccion) {
		return (menuTransaccion.getTranstype().equals("28") && menuTransaccion.getSertyp() == 0 && menuTransaccion.getIntertype() == 0);
	}

	@Override
	public String getParametricName(JBMenuTransaccion mt,
			List<JBMenuServicio> menuServicios, List<INSER> servicios,
			List<JBProCode> procodes) {
		String name = null;
		if (mt.getTranstype() != null && mt.getIntertype() > 0)
		{			
			for(JBMenuServicio ms:menuServicios)
			{				
				if (mt.getTranstype().trim().equals(ms.getTranstype()) && mt.getSertyp() == ms.getSertyp() && mt.getIntertype() == ms.getIntertype())
				{
					name = ms.getTransname();
					break;
				}
			}
		}
		else if (mt.getTranstype() != null && mt.getSertyp() > 0 && mt.getIntertype() == 0)
		{
			for(INSER servicio:servicios)
			{				
				if (mt.getSertyp() == servicio.getSERTYP().intValue())
				{
					name = servicio.getSERNAM();
					break;
				}
			}
		}
		else
		{
			for(JBProCode procode:procodes)
			{
				if (mt.getTranstype().equals(procode.getTRANSTYPE().trim()))
				{
					name = procode.getTRANSDESC();
					break;
				}
			}
		}
		return name;
	}

	@Override
	public void newBasicService(long contract, long account,
			String currency, String transtype,
			List<JOParamOwnAcc> parametricas, List<INSER> servicios, List<JOParamOwnAcc> insertCollection) {
		
		JOParamOwnAcc poN = null;
		
		for(INSER servicio:servicios)
		{
			int sertyp = servicio.getSERTYP().intValue();
			String serviceName = servicio.getSERNAM().trim();
			int pointer = 0;
			for(JOParamOwnAcc po:parametricas)
			{			
				if ((account == po.getAccount() && sertyp == po.getSertyp())  || sertyp == ConfigConvenios.SERVICIO_TDC.getValor() || sertyp == ConfigConvenios.SERVICIO_PAGO_REFERENCIADO_SAT.getValor() || 
				    sertyp == ConfigConvenios.SERVICIO_SEGUROS_AFIRME.getValor() || sertyp == ConfigConvenios.SERVICIO_APORTACION_VOLUNTARIA_AFORE.getValor())
				{
					pointer = sertyp;
					break;
				}
			}
			if (sertyp != pointer)
			{   
				poN = new JOParamOwnAcc();
				poN.setAccount(account);
				poN.setContract(contract);
				poN.setCurrency(currency);
				poN.setTranstype(transtype);
				poN.setSertyp(sertyp);
				poN.setIntertype(0);
				poN.setTransname(serviceName);
				poN.setDailytransnum(0);
				poN.setDailyamount(0);
				poN.setMonthlytransnum(0);
				poN.setMonthlyamount(0);
				poN.setDailytransnum_c(0);
				poN.setDailyamount_c(0);
				poN.setMonthlytransnum_c(0);
				poN.setMonthlyamount_c(0);
				poN.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
				insertCollection.add(poN);
			}
		}
		
	}

	@Override
	public void newTransaction(long contract, long account,
			String currency, String name, JBMenuTransaccion mt,
			List<JOParamOwnAcc> parametricas,List<JOParamOwnAcc> insertCollection) {
		
		JOParamOwnAcc poN = null;
		String pointer = null;
		
		for(JOParamOwnAcc po:parametricas )
		{			
			if (account == po.getAccount() && mt.getTranstype().trim().equals(po.getTranstype().trim()) && mt.getSertyp() == po.getSertyp() && mt.getIntertype() == po.getIntertype())
			{
				pointer = mt.getTranstype().trim();
				break;
			}
		}
		if (pointer == null)
		{
			  
			poN = new JOParamOwnAcc();
			poN.setAccount(account);
			poN.setContract(contract);
			poN.setCurrency(currency);
			poN.setTranstype(String.valueOf(mt.getTranstype()));
			poN.setSertyp(mt.getSertyp());
			poN.setIntertype(mt.getIntertype());
			poN.setTransname(name);
			poN.setDailytransnum(0);
			poN.setDailyamount(0);
			poN.setMonthlytransnum(0);
			poN.setMonthlyamount(0);
			poN.setDailytransnum_c(0);
			poN.setDailyamount_c(0);
			poN.setMonthlytransnum_c(0);
			poN.setMonthlyamount_c(0);
			poN.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
			insertCollection.add(poN);
		}
		
	}

	@Override
	public List<JOParamOwnAcc> lookupTransactionChange(String groupId,
			JOParamOwnAcc po, List<INSER> servicios, List<JBProCode> procode,
			List<JBMenuTransaccion> menuTransacciones, List<JBMenuServicio> menuServicios,
			List<JOParamOwnAcc> updateCollection) throws Exception {
				
		try 
		{
			// Valida cambio en el nombre de la transacción
			String name = getParametricNameChanged(po, menuServicios, servicios, procode);
				
			if (name != null && !name.trim().equals(po.getTransname().trim()))
				po.setTransname(name);
			
			String pointer = "-99";			
			for(JBMenuTransaccion mt:menuTransacciones)
			{				
				if (po.getTranstype().trim().equals(mt.getTranstype().trim()))
				{
					// Cambios en Servicios Básico
					if (po.getTranstype().trim().equals(mt.getTranstype().trim()) && po.getSertyp() > 0  && isBasicService(mt) &&
					    po.getSertyp() != ConfigConvenios.SERVICIO_TDC.getValor() && po.getSertyp() != ConfigConvenios.SERVICIO_SEGUROS_AFIRME.getValor())
					{	
						basicServiceChange(po, mt, servicios, updateCollection);
						pointer = mt.getTranstype().trim();
						break; 
					} 
					// Cambios en otras transacciones
					else if (po.getSertyp() == mt.getSertyp() && po.getIntertype() == mt.getIntertype())
					{
						transactionChange(po, mt, menuServicios, procode, servicios, updateCollection);
						pointer = mt.getTranstype().trim();
						break;
					} 
				}				
			}
			// Si la transacción ya no se encuentra en el menu transaccional
			if (!po.getTranstype().trim().equals(pointer.trim()))
			{
				po.setStatus(JOParamOwnAcc.ESTATUS_INACTIVO_SISTEMA);
				updateCollection.add(po);			
			}
		} 
		catch (Exception e) 
		{
			
			throw new AfirmeNetException ("3000","No se pudo cargar la información del usuario.");
		}
		
		return updateCollection;
	}

	@Override
	public String getParametricNameChanged(JOParamOwnAcc po,
			List<JBMenuServicio> menuServicios, List<INSER> servicios,
			List<JBProCode> procodes) {

		String name = null;
		if (Integer.valueOf(po.getTranstype().trim()).intValue() > 0 && po.getIntertype() >0 )
		{
			for(JBMenuServicio ms:menuServicios)
			{
				if (po.getTranstype().trim().equals(ms.getTranstype().trim()) && po.getSertyp() == ms.getSertyp() && po.getIntertype() == ms.getIntertype())
				{
					name = ms.getTransname();
					break;
				}
			}
		}
		else if (Integer.valueOf(po.getTranstype().trim()).intValue() > 0 && po.getSertyp() > 0 && po.getIntertype() == 0)
		{
			for(INSER servicio:servicios)
			{
				if (po.getSertyp() == servicio.getSERTYP().intValue())
				{
					name = servicio.getSERNAM();
					break;
				}
			}
		}
		else
		{
			for(JBProCode procode:procodes)
			{
				if (Integer.parseInt(po.getTranstype().trim()) == Integer.parseInt(procode.getTRANSTYPE().trim()))
				{
					name = procode.getTRANSDESC();
					break;
				}
			}
		}
		
		return name;
	}

	@Override
	public void basicServiceChange(JOParamOwnAcc po,
			JBMenuTransaccion mt, List<INSER> servicios, List<JOParamOwnAcc> updateCollection) {

		if (mt.getActive().equals("S"))
		{
			int pointerService = 0;
			for(INSER servicio:servicios)
			{
				if (po.getSertyp() == servicio.getSERTYP().intValue())
				{
					if (po.getStatus() != JOParamOwnAcc.ESTATUS_INACTIVO_USUARIO)
						po.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
					updateCollection.add(po);
					pointerService = po.getSertyp();
					break;			
				}
			}
			if (po.getSertyp() != pointerService)
			{
				po.setStatus(JOParamOwnAcc.ESTATUS_CANCELADO);
				updateCollection.add(po);
			}
	}
	else
		{
			po.setStatus(JOParamOwnAcc.ESTATUS_INACTIVO_SISTEMA);
			updateCollection.add(po);
		}
	}

	@Override
	public void transactionChange(JOParamOwnAcc po,
			JBMenuTransaccion mt, List<JBMenuServicio> menuServicios,
			List<JBProCode> procodes, List<INSER> servicios, List<JOParamOwnAcc> updateCollection) {

		if (mt.getActive().equals("S"))
		{
			int pointer = 0;
			if (Integer.valueOf(po.getTranstype().trim()).intValue()> 0 && po.getIntertype() > 0 )
			{
				for(JBMenuServicio ms:menuServicios)
				{	
					if (po.getTranstype().trim().equals(ms.getTranstype().trim()) && po.getSertyp() == ms.getSertyp() && 
					    po.getIntertype() == ms.getIntertype())
					{
						if (po.getStatus() != JOParamOwnAcc.ESTATUS_INACTIVO_USUARIO)
							po.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
						updateCollection.add(po);
						pointer = po.getIntertype();
						break;
					}				
				}
				if (po.getIntertype() != pointer)
				{
					po.setStatus(JOParamOwnAcc.ESTATUS_INACTIVO_SISTEMA);
					updateCollection.add(po);
				} 
								
			}
			else if (Integer.valueOf(po.getTranstype().trim()).intValue()> 0 && po.getSertyp() > 0 && po.getIntertype() == 0 )
			{
				for(INSER servicio:servicios)
				{
					if (po.getSertyp() == servicio.getSERTYP().intValue())
					{
						if (po.getStatus() != JOParamOwnAcc.ESTATUS_INACTIVO_USUARIO)
							po.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
						pointer = po.getSertyp();
						updateCollection.add(po);
						break;
					}
				}
				if (po.getSertyp() != pointer)
				{
					po.setStatus(JOParamOwnAcc.ESTATUS_INACTIVO_SISTEMA);
					updateCollection.add(po); 
				}
			}
			else if (Integer.valueOf(po.getTranstype().trim()).intValue()> 0 && po.getSertyp() == 0 && po.getIntertype() == 0)
			{
				for(JBProCode procode:procodes)
				{
					if (Integer.valueOf(po.getTranstype().trim()).intValue() == Integer.valueOf(procode.getTRANSTYPE().trim()).intValue())
					{
						if (po.getStatus() != JOParamOwnAcc.ESTATUS_INACTIVO_USUARIO)
							po.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
						pointer = Integer.valueOf(po.getTranstype().trim()).intValue();
						updateCollection.add(po);
						break;
					}
				}
				if (Integer.valueOf(po.getTranstype().trim()).intValue() != pointer)
				{
					po.setStatus(JOParamOwnAcc.ESTATUS_INACTIVO_SISTEMA);
					updateCollection.add(po); 
				} 
			}
		}
		else
		{
			po.setStatus(JOParamOwnAcc.ESTATUS_INACTIVO_SISTEMA);
			updateCollection.add(po);
		}
			
	}

	@Override
	public int insertParamOwnAcc(List<JOParamOwnAcc> parametricas) {
		return parametricasUsuarioDao.insertParamOwnAcc(parametricas);
	}

	@Override
	public int updateParamOwnAcc(List<JOParamOwnAcc> parametricas) {
		return parametricasUsuarioDao.updateParamOwnAcc(parametricas);
	}

	@Override
	public void loadDefaultParameter(long contract, long account,
			String currency, String groupId, List<INSER> servicios,
			List<JBProCode> procode, List<JBMenuTransaccion> menuTransacciones,
			List<JBMenuServicio> menuServicios) {
		try 
		{
			List<JOParamOwnAcc> dataCollection = new ArrayList<JOParamOwnAcc>();
			for(JBMenuTransaccion mt:menuTransacciones)
			{
				if ( mt.getActive().equals("S"))
				{
					String name = getParametricName(mt, menuServicios, servicios, procode);					
					// CARGA SERVICIOS BASICOS
					if (mt.getTranstype().trim().equals(JOParamOwnAcc.TRANSTYPE_PAGO_SERVICIOS)&& isBasicService(mt))
					{
						loadBasicService(contract, account, currency, mt.getTranstype(), servicios,dataCollection);
					}
					// CARGA EL RESTO DE LAS TRANSACCIONES A PARAMETRIZAR
					else
					{
						JOParamOwnAcc po = new JOParamOwnAcc();
						po.setAccount(account);
						po.setContract(contract);
						po.setCurrency(currency);
						po.setTranstype(mt.getTranstype().trim());
						po.setSertyp(mt.getSertyp());
						po.setIntertype(mt.getIntertype());
						po.setTransname(name);
						po.setDailytransnum(0);
						po.setDailyamount(0);
						po.setMonthlytransnum(0);
						po.setMonthlyamount(0);
						po.setDailytransnum_c(0);
						po.setDailyamount_c(0);
						po.setMonthlytransnum_c(0);
						po.setMonthlyamount_c(0);
						po.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
						dataCollection.add(po);
					}
				}
			}
			insertParamOwnAcc(dataCollection);
		} 
		catch (Exception e) 
		{
			throw new AfirmeNetException ("3000","No se pudo guardar la información parametrica del usuario");
		}
		
	}

	@Override
	public List<JOParamOwnAcc> loadBasicService(long contract, long account,
			String currency, String transtype, List<INSER> servicios,List<JOParamOwnAcc> dataColection) {

		for(INSER servicio:servicios)
		{
			int sertyp = servicio.getSERTYP().intValue();
	 
			if ( sertyp != ConfigConvenios.SERVICIO_TDC.getValor() && sertyp != ConfigConvenios.SERVICIO_PAGO_REFERENCIADO_SAT.getValor() && 
				 sertyp != ConfigConvenios.SERVICIO_SEGUROS_AFIRME.getValor() && sertyp != ConfigConvenios.SERVICIO_APORTACION_VOLUNTARIA_AFORE.getValor())
			{
				JOParamOwnAcc po = new JOParamOwnAcc();
				po.setAccount(account);
				po.setContract(contract);
				po.setCurrency(currency);
				po.setTranstype(transtype);
				po.setSertyp(servicio.getSERTYP().intValue());
				po.setIntertype(0);
				po.setTransname(servicio.getSERNAM());
				po.setDailytransnum(0);
				po.setDailyamount(0);
				po.setMonthlytransnum(0);
				po.setMonthlyamount(0);
				po.setDailytransnum_c(0);
				po.setDailyamount_c(0);
				po.setMonthlytransnum_c(0);
				po.setMonthlyamount_c(0);
				po.setStatus(JOParamOwnAcc.ESTATUS_ACTIVO);
				dataColection.add(po);
			}								
		}	
		
		return dataColection;
	}

	@Override
	public void lookUpChangeParameter(long contract) {

		try
		{
			List<JOParamOwnAcc> poCollection= parametricasUsuarioDao.findRegisterChanged(contract);
			String minuteStr = ConfigProperties.PROPERTYID_TRANSFER_LIMIT_TIME.getValor();
			int minute = Integer.valueOf(minuteStr).intValue();
			List<JOParamOwnAcc> updateCollection = new ArrayList<JOParamOwnAcc>(0);
			for(JOParamOwnAcc po:poCollection)
			{
				Calendar current = Calendar.getInstance();
				Calendar changed = Calendar.getInstance();
				changed.setTime(po.getOpdate());
				changed.add(Calendar.MINUTE, minute);				
				
				if (((po.getDailyamount_c() > 0.0 && po.getMonthlyamount_c() > 0.0) || (po.getStatus() == JOParamOwnAcc.ESTATUS_INACTIVO_USUARIO)) && current.after(changed))
				{
					po.setDailyamount(po.getDailyamount_c());
					po.setDailytransnum(po.getDailytransnum_c());
					po.setMonthlyamount(po.getMonthlyamount_c());
					po.setMonthlytransnum(po.getMonthlytransnum_c());
					po.setDailyamount_c(0);
					po.setDailytransnum_c(0);
					po.setMonthlyamount_c(0);
					po.setMonthlytransnum_c(0);
					updateCollection.add(po);		
				}
			}
			updateParamOwnAcc(updateCollection);
			
		}
		catch (AfirmeNetException e)
		{
			throw new AfirmeNetException ("3000"," No se cargaron los parámetros correctamente, por favor contacte a su administrador. ");
		}
		
	}

}
