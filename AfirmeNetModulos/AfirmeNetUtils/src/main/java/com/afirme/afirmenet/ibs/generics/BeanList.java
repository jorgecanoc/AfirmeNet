package com.afirme.afirmenet.ibs.generics;

import java.util.ArrayList;
import java.util.Vector;

public class BeanList
{

   protected int row;
   protected int currentRow;
   private Vector flag;

   protected ArrayList record;

   protected int firstRec;
   protected int lastRec;
   protected boolean showPrev;
   protected boolean showNext;
   protected boolean noResult;

   public BeanList()
   {

      init();

   }

   public void addRow(Object newRecord)
   {

      record.add(newRecord);

      lastRec = firstRec + row;
      row++;

      noResult = false;
   }

   public Object getList()
   {
      return record;
   }

   /**
    * Insert the method's description here. Creation date: (7/28/2000 11:38:33 AM)
    * @return int
    */
   public int getCurrentRow()
   {
      return currentRow;
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:29:46 PM)
    * @return int
    */
   public int getFirstRec()
   {
      return firstRec;
   }

   public String getFlag()
   {
      return (String) flag.elementAt(currentRow);
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:30:07 PM)
    * @return int
    */
   public int getLastRec()
   {
      return lastRec;
   }

   public boolean getNextRow()
   {

      currentRow++;
      return (currentRow < row);

   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:32:34 PM)
    * @return boolean
    */
   public boolean getNoResult()
   {
      return noResult;
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:30:53 PM)
    * @return String
    */
   public Object getRecord()
   {
      return record.get(currentRow);
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:31:11 PM)
    * @return boolean
    */
   public boolean getShowNext()
   {
      return showNext;
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:30:53 PM)
    * @return boolean
    */
   public boolean getShowPrev()
   {
      return showPrev;
   }

   public void init()
   {

      record = new java.util.ArrayList();

      row = 0; // Initialize internal counter

      initRow(); // Initialize cuurent row variable

      firstRec = 0;
      lastRec = 0;
      showPrev = false;
      showNext = false;
      noResult = true;
   }

   public void initRow()
   {

      currentRow = -1;

   }

   /**
    * Insert the method's description here. Creation date: (7/28/2000 11:38:33 AM)
    * @param newCurrentRow int
    */
   public void setCurrentRow(int newCurrentRow)
   {
      currentRow = newCurrentRow;
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:29:46 PM)
    * @param newFirstRec int
    */
   public void setFirstRec(int newFirstRec)
   {

      firstRec = newFirstRec;
      showPrev = (newFirstRec > 1);

   }

   public void setFlag(String value, int srow)
   {

      flag.setElementAt(value, srow);

   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:30:07 PM)
    * @param newLastRec int
    */
   public void setLastRec(int newLastRec)
   {
      lastRec = newLastRec;
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:32:34 PM)
    * @param newNoResult boolean
    */
   public void setNoResult(boolean newNoResult)
   {
      noResult = newNoResult;
   }

   public void setRecord(Object value, int srow)
   {

      record.add(srow, value);

   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:31:11 PM)
    * @param newShowNext boolean
    */
   public void setShowNext(boolean newShowNext)
   {
      showNext = newShowNext;
   }

   /**
    * Insert the method's description here. Creation date: (5/23/2000 4:30:53 PM)
    * @param newShowPrev boolean
    */
   public void setShowPrev(boolean newShowPrev)
   {
      showPrev = newShowPrev;
   }

}