package com.afirme.afirmenet.dao.impl.tarjetas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.tarjetas.TDCDao;
import com.afirme.afirmenet.daoUtil.DaoUtil;
import com.afirme.afirmenet.enums.ConfigPersonas;
import com.afirme.afirmenet.enums.ConfigProperties;
import com.afirme.afirmenet.ibs.beans.tarjetas.DatosTDC;
import com.afirme.afirmenet.ibs.databeans.DC_CONVENIO;
import com.afirme.afirmenet.ibs.databeans.TC5000PF;
import com.afirme.afirmenet.service.config.PropertyService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

@Repository
public class TDCDaoImpl implements TDCDao{
	
	static final Logger LOG = LoggerFactory.getLogger(TDCDaoImpl.class);
	
	@Autowired
	private DB2Dao db2Dao;
	
	@Autowired
	private AS400Dao as400Dao;
	
	@Override
	public List<TC5000PF> getListaTDC(String numcliente) {
		
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		List<TC5000PF> lstTDC = new ArrayList<TC5000PF>();
		
		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT TCTARJ,TCCLTA,TCTATI,TCCUNT,TCCUNA,TCNOMB,TCLIMC,TCTIPC,TCPAGM,TCTASA,TCFLNC,");
		sb.append(" CASE WHEN TCCLTA='P' THEN 1  WHEN TCCLTA='S' THEN 2 WHEN TCCLTA='I' THEN 3 ELSE 4  END ORDEN FROM "+schemaName+"TC5000L1");
		sb.append(" WHERE TCCUNT=? OR TCCUNA=? ORDER BY ORDEN, TCTATI,TCTARJ");
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sb.toString(), new Object[] {numcliente,numcliente});

		try{
		
		for (Map<String, Object> row : rows) {
			TC5000PF tdc = new TC5000PF();
			
			tdc.setTCTARJ(DaoUtil.getBigDecimal(row.get("TCTARJ")).toString());
			String tipoTarjeta=DaoUtil.getString(row.get("TCCLTA"));
			String descTipTarj="";
			if(tipoTarjeta.equals("I"))
				descTipTarj="Individual";
			else if(tipoTarjeta.equals("P"))
				descTipTarj="Titular";
			else if(tipoTarjeta.equals("S"))
				descTipTarj="Adicional";
			tdc.setTCCLTA(descTipTarj);
			if(DaoUtil.getBigDecimal(row.get("TCTATI")).toString() == "0" )
				tdc.setTCTATI(DaoUtil.getBigDecimal(row.get("TCTARJ")).toString());
			else
			tdc.setTCTATI(DaoUtil.getBigDecimal(row.get("TCTATI")).toString());
			tdc.setTCCUNT(DaoUtil.getBigDecimal(row.get("TCCUNT")).toString());
			tdc.setTCCUNA(DaoUtil.getBigDecimal(row.get("TCCUNA")).toString());
			tdc.setTCNOMB(DaoUtil.getString(row.get("TCNOMB")));
			tdc.setTCLIMC(DaoUtil.getBigDecimal(row.get("TCLIMC")).toString());
			tdc.setTCTIPC(DaoUtil.getString(row.get("TCTIPC")));
			tdc.setTCPAGM(DaoUtil.getBigDecimal(row.get("TCPAGM")).toString());
			tdc.setTCPAGM(DaoUtil.getBigDecimal(row.get("TCPAGM")).toString());
			tdc.setTCTASA(DaoUtil.getBigDecimal(row.get("TCTASA")).toString());
			lstTDC.add(tdc);
		}
		}catch(EmptyResultDataAccessException e){
			return null;			
		}
		
		return lstTDC;
	}
	
	@Override
	public double getPagoNoIntereses(DatosTDC datosTDC) {

		double saldoPromo=0.00;
		double pagoMensual=0.00;	
		double pagoNoIntereses=0.00;	

		Connection cnx = null;

		try {
			cnx = as400Dao.getAs400DataSource().getConnection();
			CallableStatement proc400 = null;
			proc400 = cnx
					.prepareCall("{ call "
							+ AfirmeNetConstants
									.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME)
							+ "TDC_PROM(?) }");

			 proc400.setString(1, datosTDC.getTdcTDCC());

			 ResultSet rs=proc400.executeQuery();
			 
		       while(rs.next())
		       {					
		    	   
		    	   int fechaCorte = Integer.parseInt(datosTDC.getTdcFECC());
		    	   int fechaPosteo = Integer.parseInt(rs.getString("M5FEPOS").trim());
		    	   		    	   
		    	   if(fechaPosteo<fechaCorte){
			    	   saldoPromo=saldoPromo+Double.parseDouble(rs.getString("M5PAGME").trim()); // monto pago mensual
			    	   pagoMensual=pagoMensual+Double.parseDouble(rs.getString("M5SLDPE").trim()); // saldo pendiente de promos
			    	   }   
				}
			
		       //Saldo del último corte (-) Saldo pendiente de promociones (+) cuota del mes de promociones (-) PAGOS=Saldo de contado sin intereses del mes
		       pagoNoIntereses=Double.parseDouble(datosTDC.getTdcSALC().replace(",",""))-saldoPromo+pagoMensual-Double.parseDouble(datosTDC.getTdcPGYCR().replace(",",""));

			
			proc400.close();
		}catch (SQLException e) {
			LOG.debug("Exception e : " + e);
		} finally {
			try {
				cnx.close();
			} catch (Exception e) {
			}
		}

		return pagoNoIntereses;
	}

	@Override
	public List<String> getListaBeanTDCAfirme() {
		
		String schemaName = AfirmeNetConstants.getValorConfigPersonas(ConfigPersonas.JDBC_LIBNAME);
		List<String> lista = new ArrayList<String>();
		
		JdbcTemplate jdbcTemplate = as400Dao.getJdbcTemplate();

		StringBuffer sb = new StringBuffer();
		sb.append(" select TCBIN  from "+schemaName+"tctasapf");
			
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sb.toString(), new Object[] {});

		try{
		
		for (Map<String, Object> row : rows) {
			lista.add(row.get("TCBIN").toString());
		}
		}catch(EmptyResultDataAccessException e){
			return null;
			
		}
		
		return lista;
	}

}
