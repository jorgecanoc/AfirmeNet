package com.afirme.afirmenet.ibs.databeans;




/**
 * Jdbc Bean Class<br>
 * <br>
 * Autogenerated on 11/06/2003 11:06:46<br>
 * &nbsp;&nbsp;&nbsp; table = "DC_TAXCODEBean"
*
* @author Generator
*/
@SuppressWarnings("serial")
public class DC_TAXCODE implements java.io.Serializable {

   /**
    * The CODE attribute.
   */
	protected java.lang.String CODE = "";

   /**
    * Gets the CODE value.
   */
   public java.lang.String getCODE() {
      return CODE.toUpperCase().trim();
   }
   
   /**
    * Sets the CODE value.
   */
   public void setCODE(java.lang.String CODE) {
      this.CODE = CODE;
   }
   /**
    * The CODE_NAME attribute.
   */
   protected java.lang.String CODE_NAME = "";
   
   /**
    * Gets the CODE_NAME value.
   */
   public java.lang.String getCODE_NAME() {
      return CODE_NAME.toUpperCase().trim();
   }
   
   /**
    * Sets the CODE_NAME value.
   */
   public void setCODE_NAME(java.lang.String CODE_NAME) {
      this.CODE_NAME = CODE_NAME;
   }
   /**
    * The CODE_CODES attribute.
   */
   protected java.lang.String CODE_CODES = "";
   
   /**
    * Gets the CODE_CODES value.
   */
   public java.lang.String getCODE_CODES() {
      return CODE_CODES.toUpperCase().trim();
   }
   
   /**
    * Sets the CODE_CODES value.
   */
   public void setCODE_CODES(java.lang.String CODE_CODES) {
      this.CODE_CODES = CODE_CODES;
   }
   /**
    * The CODE_LINE attribute.
   */
   protected java.lang.String CODE_LINE = "";
   
   /**
    * Gets the CODE_LINE value.
   */
   public java.lang.String getCODE_LINE() {
      return CODE_LINE.toUpperCase().trim();
   }
   
   /**
    * Sets the CODE_LINE value.
   */
   public void setCODE_LINE(java.lang.String CODE_LINE) {
      this.CODE_LINE = CODE_LINE;
   }
   public String toString() {
      StringBuffer results = new StringBuffer();

      results.append(getClass().getName() + "\n");
      results.append("\tCODE=" + CODE + "\n");
      results.append("\tCODE_NAME=" + CODE_NAME + "\n");
      results.append("\tCODE_CODES=" + CODE_CODES + "\n");
      results.append("\tCODE_LINE=" + CODE_LINE + "\n");

      return results.toString();
   }

}