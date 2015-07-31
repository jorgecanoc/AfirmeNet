package com.afirme.afirmenet.ibs.beans;

import java.util.Vector;

public class JBMessages {

	   private int row;
	   private int currentRow;
	   private Vector Text;
	   private String CName = "";
	   private String OName = "";
	   private String Message = "";
	   private String Readonly = "";
	   private String ReadonlyFLG = "";
	   private String Disabled = "";
	   private String Error = "";
	   private String Title = "";
	   private String EMail = "";
	   private String User = "";
	   private String FDate = "";
	   private String FDateT = "";
	   private String FAC = "";
	   private String STS = "";
	   private String MsgOK = "";
	   boolean errorFlag = false;
	   private String Correo = ""; // se agrego para el cambio de email
	   private String NCorreo = "";// se agrego para el cambio de email
	   private String NFDate = "";// se agrego para el cambio de email
	   private String NFHour = "";// se agrego para el cambio de email
	   
	   

	   public JBMessages()
	   {}

	   public void addRow(String newtxt)
	   {
	      Text.addElement(newtxt);

	      row++;
	   }

	   public String getSTS()
	   {
	      return STS;
	   }

	   public String getCName()
	   {
	      return CName;
	   }

	   public String getEMail()
	   {
	      return EMail;
	   }

	   public String getFDate()
	   {
	      return FDate;
	   }

	   public String getFDateT()
	   {
	      return FDateT;
	   }

	   public String getFAC()
	   {
	      return FAC;
	   }

	   public String getMessage()
	   {
	      return Message;
	   }

	   public String getError()
	   {
	      return Error;
	   }

	   public String getTitle()
	   {
	      return Title;
	   }

	   public String getReadonly()
	   {
	      return Readonly;
	   }

	   public String getReadonlyFLG()
	   {
	      return ReadonlyFLG;
	   }

	   public String getDisabled()
	   {
	      return Disabled;
	   }

	   public boolean getNextRowB()
	   {
	      currentRow++;
	      return (currentRow < row);
	   }

	   public String getOName()
	   {
	      return OName;
	   }

	   public int getRowB()
	   {
	      return row;
	   }

	   public String getText()
	   {
	      String rtxt = (String) Text.elementAt(currentRow);
	      return rtxt;
	   }

	   public String getUser()
	   {
	      return User;
	   }
	   
	   public String getCorreo()
	   {
	      return Correo;
	   }   
	   
	   public String getNCorreo()
	   {
	      return NCorreo;
	   }   

	   public String getNFDate()
	   {
	      return NFDate;
	   }

	   public String getNFHour()
	   {
	      return NFHour;
	   }

	   public void init()
	   {

	      Text = new java.util.Vector();

	      row = 0;

	   }

	   public void initRow()
	   {
	      currentRow = -1;
	   }

	   public void setSTS(String newValue)
	   {
	      STS = newValue;
	   }

	   public void setCName(String newValue)
	   {
	      CName = newValue;
	   }

	   public void setEMail(String newValue)
	   {
	      EMail = newValue;
	   }

	   public void setFDate(String newValue)
	   {
	      FDate = newValue;
	   }

	   public void setFDateT(String newValue)
	   {
	      FDateT = newValue;
	   }

	   public void setFAC(String newValue)
	   {
	      FAC = newValue;
	   }

	   public void setMessage(String newValue)
	   {
	      Message = newValue;
	   }

	   public void setError(String newValue)
	   {
	      Error = newValue;
	   }

	   public void setReadonly(String newValue)
	   {
	      Readonly = newValue;
	   }

	   public void setReadonlyFLG(String newValue)
	   {
	      ReadonlyFLG = newValue;
	   }

	   public void setDisabled(String newValue)
	   {
	      Disabled = newValue;
	   }

	   public void setTitle(String newValue)
	   {
	      Title = newValue;
	   }

	   public void setOName(String newValue)
	   {
	      OName = newValue;
	   }

	   public void setUser(String newValue)
	   {
	      User = newValue;
	   }

	   public void setCorreo(String correo)
	   {
	      Correo = correo;
	   }
	   
	   public void setNCorreo(String correo)
	   {
	      NCorreo = correo;
	   }
	   
	   public void setNFDate(String date)
	   {
	      NFDate = date;
	   }

	   public void setNFHour(String hour)
	   {
	      NFHour = hour;
	   }

	   /**
	    * @return
	    */
	   public String getMsgOK()
	   {
	      return MsgOK;
	   }

	   /**
	    * @param string
	    */
	   public void setMsgOK(String string)
	   {
	      MsgOK = string;
	   }

	   /**
	    * @return
	    */
	   public boolean isErrorFlag()
	   {
	      return errorFlag;
	   }

	   /**
	    * @param b
	    */
	   public void setErrorFlag(boolean b)
	   {
	      errorFlag = b;
	   }

}
