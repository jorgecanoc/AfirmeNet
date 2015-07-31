/*
 * vmpermad
 * Sep 3, 2009
 * Afirme Grupo Financiero
 */
package com.afirme.afirmenet.ibs.objects.parameter;


import java.util.Date;
import java.util.GregorianCalendar;


public class JOParamAccumAcc extends JOParametric 
{
	private String bxIRef;
	
	public JOParamAccumAcc()
	{
	}
	
	public JOParamAccumAcc(String contract,String account,String transtype,int intertype,int sertyp,double dailyamount,String vyy,String vmm,String vdd)
	{
		GregorianCalendar opDate = new GregorianCalendar();
		opDate.set(2000+Integer.parseInt(vyy),Integer.parseInt(vmm)-1,Integer.parseInt(vdd));
		
		setContract(new Long(contract).longValue());
		setAccount(new Long(account).longValue());
		setTranstype(transtype);
		setSertyp(sertyp);
		setIntertype(intertype);
		setDailytransnum(0);
		setDailyamount(dailyamount);
		setOpdate(new Date(opDate.getTimeInMillis()));
		setTransname(null);
		setBxIRef(null);
	}
	
	public JOParamAccumAcc(String contract,String account,String transtype,int intertype,double dailyamount,String vyy,String vmm,String vdd)
	{
		GregorianCalendar opDate = new GregorianCalendar();
		opDate.set(2000+Integer.parseInt(vyy),Integer.parseInt(vmm)-1,Integer.parseInt(vdd));
				
		setContract(new Long(contract).longValue());
		setAccount(new Long(account).longValue());
		setTranstype(transtype);
		setIntertype(intertype);
		setDailytransnum(0);
		setDailyamount(dailyamount);
		setOpdate(new Date(opDate.getTimeInMillis()));
		setSertyp(0);
		setTransname(null);
		setBxIRef(null);
	}
	
	public JOParamAccumAcc(String contract,String account,String dcibs_ref,String transtype,int intertype,int sertyp,double dailyamount,String vyy,String vmm,String vdd)
	{
		GregorianCalendar opDate = new GregorianCalendar();
		opDate.set(2000+Integer.parseInt(vyy),Integer.parseInt(vmm)-1,Integer.parseInt(vdd));
				
		setContract(new Long(contract).longValue());
		setAccount(new Long(account).longValue());
		setBxIRef(dcibs_ref);
		setTranstype(transtype);
		setSertyp(sertyp);
		setIntertype(intertype);
		setDailyamount(dailyamount);
		setOpdate(new Date(opDate.getTimeInMillis()));
		setTransname(null);
		setDailytransnum(0);
	}
		
	/**
	* @return
	* @author vmpermad
	*/
	public String getBxIRef() {
		return bxIRef;
	}

	/**
	* @param string
	* @author vmpermad
	*/
	public void setBxIRef(String string) {
		bxIRef = string;
	}

}
