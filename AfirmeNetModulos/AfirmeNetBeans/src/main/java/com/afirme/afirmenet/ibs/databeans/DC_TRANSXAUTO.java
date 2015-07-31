package com.afirme.afirmenet.ibs.databeans;


public class DC_TRANSXAUTO implements java.io.Serializable
{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * The attributes.
    */
   protected java.lang.String TRANSTYPE = "";
   protected java.lang.String SERVLET = "";
   protected java.lang.String PB = "";
   protected java.lang.String PB1 = "";
   protected java.lang.String TITULO = "";

   /**
    * Gets the values.
    */
   public java.lang.String getTRANSTYPE()
   {
      return TRANSTYPE;
   }

   public java.lang.String getSERVLET()
   {
      return SERVLET;
   }

   public java.lang.String getPB()
   {
      return PB;
   }

   public java.lang.String getPB1()
   {
      return PB1;
   }

   public java.lang.String getTITULO()
   {
      return TITULO;
   }

   /**
    * Sets the values.
    */
   public void setTRANSTYPE(java.lang.String DATA)
   {
      this.TRANSTYPE = DATA != null ? DATA.trim() : "";
   }

   public void setSERVLET(java.lang.String DATA)
   {
      this.SERVLET = DATA != null ? DATA.trim() : "";
   }

   public void setPB(java.lang.String DATA)
   {
      this.PB = DATA != null ? DATA.trim() : "";
   }

   public void setPB1(java.lang.String DATA)
   {
      this.PB1 = DATA != null ? DATA.trim() : "";
   }

   public void setTITULO(java.lang.String DATA)
   {
      this.TITULO = DATA != null ? DATA.trim() : "";
   }

   public String toString()
   {
      StringBuffer results = new StringBuffer();

      results.append(getClass().getName() + "\n");
      results.append("\tTRANSTYPE=" + TRANSTYPE + "\n");
      results.append("\tSERVLET  =" + SERVLET + "\n");
      results.append("\tPB       =" + PB + "\n");
      results.append("\tPB1      =" + PB1 + "\n");
      results.append("\tTITULO   =" + TITULO + "\n");

      return results.toString();
   }
}