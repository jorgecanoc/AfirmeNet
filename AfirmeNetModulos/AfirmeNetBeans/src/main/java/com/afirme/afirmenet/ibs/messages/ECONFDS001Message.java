package com.afirme.afirmenet.ibs.messages;

import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
* Class generated by AS/400 CRTCLASS command from ECONFDS001 physical file definition.
* 
* File level identifier is 1091211171138.
* Record format level identifier is 2C2D621CCFE6E.
*/
@SuppressWarnings("rawtypes")
public class ECONFDS001Message extends MessageRecord
{
  final static String fldnames[] = {
                                     "ECNFUSER",
                                     "ECNFREF",
                                     "ECNAUTOR"
                                   };
  final static String tnames[] = {
                                   "ECNFUSER",
                                   "ECNFREF",
                                   "ECNAUTOR"
                                 };
  final static String fid = "1091211171138";
  final static String rid = "2C2D621CCFE6E";
  final static String fmtname = "ECONFDS001";
  final int FIELDCOUNT = 3;
  private static Hashtable tlookup = new Hashtable();
  private CharacterField fieldECNFUSER = null;
  private CharacterField fieldECNFREF = null;
  private CharacterField fieldECNAUTOR = null;

  /**
  * Constructor for ECONFDS001Message.
  */
  public ECONFDS001Message()
  {
    createFields();
    initialize();
  }

  /**
  * Create fields for this message.
  * This method implements the abstract method in the MessageRecord superclass.
  */
@SuppressWarnings("unchecked")    protected void createFields()
  {
    recordsize = 32;
    fileid = fid;
    recordid = rid;
    message = new byte[getByteLength()];
    formatname = fmtname;
    fieldnames = fldnames;
    tagnames = tnames;
    fields = new MessageField[FIELDCOUNT];

    fields[0] = fieldECNFUSER =
    new CharacterField(message, HEADERSIZE + 0, 10, "ECNFUSER");
    fields[1] = fieldECNFREF =
    new CharacterField(message, HEADERSIZE + 10, 16, "ECNFREF");
    fields[2] = fieldECNAUTOR =
    new CharacterField(message, HEADERSIZE + 26, 6, "ECNAUTOR");

    synchronized (tlookup)
    {
      if (tlookup.isEmpty())
      {
        for (int i = 0; i < tnames.length; i++)
          tlookup.put(tnames[i], new Integer(i));
      }
    }

    taglookup = tlookup;
  }

  /**
  * Set field ECNFUSER using a String value.
  */
  public void setECNFUSER(String newvalue)
  {
    fieldECNFUSER.setString(newvalue);
  }

  /**
  * Get value of field ECNFUSER as a String.
  */
  public String getECNFUSER()
  {
    return fieldECNFUSER.getString();
  }

  /**
  * Set field ECNFREF using a String value.
  */
  public void setECNFREF(String newvalue)
  {
    fieldECNFREF.setString(newvalue);
  }

  /**
  * Get value of field ECNFREF as a String.
  */
  public String getECNFREF()
  {
    return fieldECNFREF.getString();
  }

  /**
  * Set field ECNAUTOR using a String value.
  */
  public void setECNAUTOR(String newvalue)
  {
    fieldECNAUTOR.setString(newvalue);
  }

  /**
  * Get value of field ECNAUTOR as a String.
  */
  public String getECNAUTOR()
  {
    return fieldECNAUTOR.getString();
  }

}