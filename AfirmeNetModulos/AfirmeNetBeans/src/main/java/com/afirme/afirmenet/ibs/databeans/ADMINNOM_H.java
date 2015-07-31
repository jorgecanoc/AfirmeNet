package com.afirme.afirmenet.ibs.databeans;

public class ADMINNOM_H implements java.io.Serializable
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * The attributes.
    */
   private String DCIBS_REF = ""; //
   private String ENTITYID = ""; //
   private String OUSER = ""; //
   private String NOMEMPRESA = ""; // NOMBRE DE LA EMPRESA
   private String NUMREF = ""; // NUMERO DE REFERENCIA
   private String NOCLIENTE = ""; // NUMERO DE CLIENTE
   private String DIVISION = ""; // DIVISION
   private String REGISTROS = ""; // NUMERO DE REGISTROS
   private String ESTATUS = ""; // ESTATUS
   private String ID400EMPLEADO = "";// ID unico del empleado dentro del lote de 400

   /**
    * Gets the values.
    */
   public String getDCIBS_REF()
   {
      return DCIBS_REF;
   }

   public String getRDcibsRef()
   {
      return "<input type='radio' name='AccNumber' checked value='" + this.DCIBS_REF + "'> <input type='hidden' name='Sts' value='" + this.ESTATUS + "'>";
   }

   public String getFecha()
   {
      return this.DCIBS_REF.substring(4, 6) + "/" + this.DCIBS_REF.substring(2, 4) + "/20" + this.DCIBS_REF.substring(0, 2);
   }

   public String getENTITYID()
   {
      return ENTITYID;
   }

   public String getOUSER()
   {
      return OUSER;
   }

   public String getNOMEMPRESA()
   {
      return NOMEMPRESA;
   }

   public String getNUMREF()
   {
      return NUMREF;
   }

   public String getNOCLIENTE()
   {
      return NOCLIENTE;
   }

   public String getDIVISION()
   {
      return DIVISION;
   }

   public String getREGISTROS()
   {
      return REGISTROS;
   }

   public String getESTATUS()
   {
      return ESTATUS;
   }

   public String getEstatus()
   {
      String sData = "";
      if(ESTATUS.equals("A"))
         sData = "No Procesada";
      else if(ESTATUS.equals("X"))
         sData = "Cancelada";
      else if(ESTATUS.equals("P"))
         sData = "Procesada";
      else if(ESTATUS.equals("R"))
         sData = "Rechazada";
      return sData;
   }

   public String getEstatusHi()
   {
      return "<input type='hidden' name='sts' value='" + this.ESTATUS + "'>";
   }

   /**
    * Sets the values.
    */
   public void setDCIBS_REF(String DATA)
   {
      this.DCIBS_REF = DATA != null ? DATA : "";
   }

   public void setENTITYID(String DATA)
   {
      this.ENTITYID = DATA != null ? DATA : "";
   }

   public void setOUSER(String DATA)
   {
      this.OUSER = DATA != null ? DATA : "";
   }

   public void setNOMEMPRESA(String DATA)
   {
      this.NOMEMPRESA = DATA != null ? DATA.trim() : "";
   }

   public void setNUMREF(String DATA)
   {
      this.NUMREF = DATA != null ? DATA : "";
   }

   public void setNOCLIENTE(String DATA)
   {
      this.NOCLIENTE = DATA != null ? DATA : "";
   }

   public void setDIVISION(String DATA)
   {
      this.DIVISION = DATA != null ? DATA : "";
   }

   public void setREGISTROS(String DATA)
   {
      this.REGISTROS = DATA != null ? DATA : "";
   }

   public void setESTATUS(String DATA)
   {
      this.ESTATUS = DATA != null ? DATA : "";
   }

   public String toString()
   {
      StringBuffer results = new StringBuffer();

      results.append(getClass().getName() + "\n");
      results.append("\tDCIBS_REF =" + DCIBS_REF + "\n");
      results.append("\tENTITYID  =" + ENTITYID + "\n");
      results.append("\tOUSER     =" + OUSER + "\n");
      results.append("\tNOMEMPRESA=" + NOMEMPRESA + "\n");
      results.append("\tNUMREF    =" + NUMREF + "\n");
      results.append("\tNOCLIENTE =" + NOCLIENTE + "\n");
      results.append("\tDIVISION  =" + DIVISION + "\n");
      results.append("\tREGISTROS =" + REGISTROS + "\n");
      results.append("\tESTATUS   =" + ESTATUS + "\n");

      return results.toString();
   }

   public String getID400EMPLEADO()
   {
      return ID400EMPLEADO;
   }

   public void setID400EMPLEADO(String id400empleado)
   {
      ID400EMPLEADO = id400empleado;
   }
}
