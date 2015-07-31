package com.afirme.afirmenet.ibs.databeans;
import java.lang.String;
import java.math.BigDecimal;

public class DC_PAGOELECTRONICO_POST implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	protected String     ENTITYID= "";
	protected String     USERID  = "";
	protected String     NUMTRANS = "";
	protected String     DCIBSREF= "";
	protected String     REFERENCIAPAGO= "";
	protected String     MONEDA  = "";
	protected BigDecimal MONTO  = new BigDecimal("0");
	protected String	 DEBACC = "";
	protected String	 CREACC = "";
	protected String     NUMAPR = "";
	protected String     FECHA = "";
	protected String     HORA = "";
	protected String     ESTATUS = "";
	protected String     DESCRIPCIONERROR = "";
	protected String	 VDD = "";
	protected String	 VMM = "";
	protected String	 VYY = "";
	protected String	 VHH = "";
	protected String	 VSS = "";
	protected String     REFERENCIAENTRADA= "";
	
	
	protected String     CONVENIO   = ""; 
	protected String     CONCEPTO  = ""; 
	protected String     DESCRIPCION     = "";
	protected String     RESPONSEURL     = "";
	protected String     AUX1    = "";
	protected String     AUX2 = "";


	
	public String     getNUMTRANS(){ return NUMTRANS;}
	public String     getDCIBSREF(){ return DCIBSREF;}
	public String     getREFERENCIAPAGO(){ return REFERENCIAPAGO;}
	public String     getREFERENCIAENTRADA(){ return REFERENCIAENTRADA;}
	public String     getENTITYID(){ return ENTITYID;}
	public String     getUSERID  (){ return USERID;	 }
	public String     getCONVENIO   (){ return CONVENIO;   }
	public String     getCONCEPTO  (){ return CONCEPTO;  }
	public String     getDESCRIPCION     (){ return DESCRIPCION;     }
	public String     getRESPONSEURL     (){ return RESPONSEURL;     }
	public String     getAUX1    (){ return AUX1;    }
	public String     getAUX2 (){ return AUX2; }
	public String     getMONEDA  (){ return MONEDA;  }
	public BigDecimal getMONTO   (){ return MONTO;   }
	public String     getDEBACC  (){ return DEBACC;}
	public String     getCREACC  (){ return CREACC;}
	public String     getNUMAPR  (){ return NUMAPR;}
	public String     getFECHA  (){ return FECHA;}
	public String     getHORA  (){ return HORA;}
	public String     getESTATUS  (){ return ESTATUS;}
	public String     getDESCRIPCIONERROR  (){ return DESCRIPCIONERROR;}
	public String     getVDD     (){ return VDD;}
	public String     getVMM     (){ return VMM;}
	public String     getVYY     (){ return VYY;}
	public String     getVHH     (){ return VHH;}
	public String     getVSS     (){ return VSS;}


	public void setNUMTRANS(String    DATA){ this.NUMTRANS= DATA!=null?DATA.trim():"";}
	public void setDCIBSREF(String    DATA){ this.DCIBSREF= DATA!=null?DATA.trim():"";}
	public void setREFERENCIAPAGO(String    DATA){ this.REFERENCIAPAGO= DATA!=null?DATA.trim():"";}
	public void setREFERENCIAENTRADA(String    DATA){ this.REFERENCIAENTRADA= DATA!=null?DATA.trim():"";}
	public void setENTITYID(String     DATA){ this.ENTITYID= DATA!=null?DATA.trim():"";}
	public void setUSERID  (String     DATA){ this.USERID  = DATA!=null?DATA.trim():"";}
	public void setCONVENIO   (String     DATA){ this.CONVENIO   = DATA!=null?DATA.trim():"";}
	public void setCONCEPTO  (String     DATA){ this.CONCEPTO  = DATA!=null?DATA.trim():"";}
	public void setDESCRIPCION     (String     DATA){ this.DESCRIPCION     = DATA!=null?DATA.trim():"";}
	public void setRESPONSEURL     (String     DATA){ this.RESPONSEURL     = DATA!=null?DATA.trim():"";}
	public void setAUX1    (String     DATA){ this.AUX1    = DATA!=null?DATA.trim():"";}
	public void setAUX2 (String     DATA){ this.AUX2 = DATA!=null?DATA.trim():"";}
	public void setMONEDA  (String     DATA){ this.MONEDA  = DATA!=null?DATA.trim():"";}
	public void setMONTO   (BigDecimal DATA){ this.MONTO   = DATA!=null?DATA:new BigDecimal("0");}
	public void setDEBACC  (String     DATA){ this.DEBACC  = DATA!=null?DATA.trim():"";}
	public void setCREACC  (String     DATA){ this.CREACC  = DATA!=null?DATA.trim():"";}
	public void setNUMAPR  (String     DATA){ this.NUMAPR  = DATA!=null?DATA.trim():"";}
	public void setFECHA  (String     DATA){ this.FECHA  = DATA!=null?DATA.trim():"";}
	public void setHORA  (String     DATA){ this.HORA  = DATA!=null?DATA.trim():"";}
	public void setESTATUS  (String     DATA){ this.ESTATUS  = DATA!=null?DATA.trim():"";}
	public void setDESCRIPCIONERROR  (String     DATA){ this.DESCRIPCIONERROR  = DATA!=null?DATA.trim():"";}
	public void setVDD     (String     DATA){ this.VDD  = DATA!=null?DATA.trim():"";}
	public void setVMM     (String     DATA){ this.VMM  = DATA!=null?DATA.trim():"";}
	public void setVYY     (String     DATA){ this.VYY  = DATA!=null?DATA.trim():"";}
	public void setVHH     (String     DATA){ this.VHH  = DATA!=null?DATA.trim():"";}
	public void setVSS     (String     DATA){ this.VSS  = DATA!=null?DATA.trim():"";}
}