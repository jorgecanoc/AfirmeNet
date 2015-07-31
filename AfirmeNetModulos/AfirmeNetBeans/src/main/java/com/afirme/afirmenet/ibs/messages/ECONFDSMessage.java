package com.afirme.afirmenet.ibs.messages;

import java.util.Hashtable;

import com.datapro.sockets.CharacterField;
import com.datapro.sockets.MessageField;
import com.datapro.sockets.MessageRecord;

/**
* Class generated by AS/400 CRTCLASS command from ECONFDS physical file definition.
* 
* File level identifier is 1030902115722.
* Record format level identifier is 29EA155E66F13.
*/
@SuppressWarnings("rawtypes")
public class ECONFDSMessage extends MessageRecord
{
  final static String fldnames[] = {
                                     "ECNFUSER",
                                     "ECNFREF"
                                   };
  final static String tnames[] = {
                                   "ECNFUSER",
                                   "ECNFREF"
                                 };
  final static String fid = "1030902115722";
  final static String rid = "29EA155E66F13";
  final static String fmtname = "ECONFDS";
  final int FIELDCOUNT = 2;
  private static Hashtable tlookup = new Hashtable();
  private CharacterField fieldECNFUSER = null;
  private CharacterField fieldECNFREF = null;

  /**
  * Constructor for ECONFDSMessage.
  */
  public ECONFDSMessage()
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
    recordsize = 26;
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

}
