/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: DC_SWIFTTRANS.java
 * Creado: Mar 15, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: DC_SWIFTTRANS
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datapro.exception.ServiceLocatorException;
import com.datapro.services.ServiceLocator;

/**
 * @author cosurof
 * 
 */
public class DC_SWIFTTRANSPER implements Serializable {
	static final Logger LOG = LoggerFactory
			.getLogger(DC_SWIFTTRANSPER.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ENTITYID;
	// private String USERID;
	private String DEBACC;
	private String CCY;
	private BigDecimal AMTINCCY;
	private BigDecimal EXRATE;
	private BigDecimal AMOUNT;
	private String INSTRUCCIONES1;
	private String INSTRUCCIONES2;
	private String BENENAME;
	private String DESCRIP1;
	private String DESCRIP2;
	private String CREACC;
	private String SWIFTNUM;
	private String SWIFTNOM;
	private String SWIFTARE;
	private String SWIFTEDO;
	private String SWIFTCD;
	private String SWIFTPAI;
	private String SWIFTADD;
	private String SWIFTFULL;
	private BigDecimal ABANUM;
	private String ABANOM;
	private String ABACTY;
	private String ABAEDO;
	private String VMM;
	private String VDD;
	private String VYY;
	private String VHH;
	private String VSS;
	private String ODATE;
	private String OUSER;
	private String VDATE;
	private String VUSER;
	private String AUSER;
	private String ADATE;
	private BigDecimal NUMAPR;
	private String DCIBS_REF;
	private String FLAG;
	private String STS;
	private String CCYCONV;
	private String VIA;
	private String PDD;
	private String PMM;
	private String PYY;
	private String PHH;
	private String PSS;
	private String BY;
	private String CONFNUM;

	public DC_SWIFTTRANSPER() {
		this.ENTITYID = "";
		// this. USERID = "";
		this.DEBACC = "";
		this.CCY = "";
		this.AMTINCCY = new BigDecimal(0);
		this.EXRATE = new BigDecimal(0);
		this.AMOUNT = new BigDecimal(0);
		this.INSTRUCCIONES1 = "";
		this.INSTRUCCIONES2 = "";
		this.BENENAME = "";
		this.DESCRIP1 = "";
		this.DESCRIP2 = "";
		this.CREACC = "";
		this.SWIFTNUM = "";
		this.SWIFTNOM = "";
		this.SWIFTARE = "";
		this.SWIFTEDO = "";
		this.SWIFTCD = "";
		this.SWIFTPAI = "";
		this.SWIFTADD = "";
		this.SWIFTFULL = "";
		this.ABANUM = new BigDecimal(0);
		this.ABANOM = "";
		this.ABACTY = "";
		this.ABAEDO = "";
		this.VMM = "";
		this.VDD = "";
		this.VYY = "";
		this.VHH = "";
		this.VSS = "";
		this.ODATE = "";
		this.VDATE = "";
		this.ADATE = "";
		this.OUSER = "";
		this.VUSER = "";
		this.AUSER = "";

		this.NUMAPR = new BigDecimal(0);
		this.DCIBS_REF = "";
		this.FLAG = "";
		this.STS = "";
		this.VIA = "";
		this.PDD = "";
		this.PMM = "";
		this.PYY = "";
		this.BY = "";
	}

	/**
	 * @return
	 */
	public String getABACTY() {
		return ABACTY;
	}

	/**
	 * @return
	 */
	public String getABAEDO() {
		return ABAEDO;
	}

	/**
	 * @return
	 */
	public String getABANOM() {
		return ABANOM;
	}

	/**
	 * @return
	 */
	public BigDecimal getABANUM() {
		return ABANUM;
	}

	/**
	 * @return
	 */
	public BigDecimal getAMOUNT() {
		return AMOUNT;
	}

	/**
	 * @return
	 */
	public BigDecimal getAMTINCCY() {
		return AMTINCCY;
	}

	/**
	 * @return
	 */
	public String getBENENAME() {
		return BENENAME;
	}

	/**
	 * @return
	 */
	public String getCCY() {
		return CCY;
	}

	/**
	 * @return
	 */
	public String getCREACC() {
		return CREACC;
	}

	/**
	 * @return
	 */
	public String getDCIBS_REF() {
		return DCIBS_REF;
	}

	/**
	 * @return
	 */
	public String getDEBACC() {
		return DEBACC;
	}

	/**
	 * @return
	 */
	public String getDESCRIP1() {
		return DESCRIP1;
	}

	/**
	 * @return
	 */
	public String getDESCRIP2() {
		return DESCRIP2;
	}

	/**
	 * @return
	 */
	public String getENTITYID() {
		return ENTITYID;
	}

	/**
	 * @return
	 */
	public BigDecimal getEXRATE() {
		return EXRATE;
	}

	/**
	 * @return
	 */
	public String getFLAG() {
		return FLAG;
	}

	/**
	 * @return
	 */
	public String getINSTRUCCIONES1() {
		return INSTRUCCIONES1;
	}

	/**
	 * @return
	 */
	public String getINSTRUCCIONES2() {
		return INSTRUCCIONES2;
	}

	/**
	 * @return
	 */
	public BigDecimal getNUMAPR() {
		return NUMAPR;
	}

	/**
	 * @return
	 */
	public String getODATE() {
		return ODATE;
	}

	/**
	 * @return
	 */
	public String getOUSER() {
		return OUSER;
	}

	/**
	 * @return
	 */
	public String getSWIFTADD() {
		return SWIFTADD;
	}

	/**
	 * @return
	 */
	public String getSWIFTARE() {
		return SWIFTARE;
	}

	/**
	 * @return
	 */
	public String getSWIFTCD() {
		return SWIFTCD;
	}

	/**
	 * @return
	 */
	public String getSWIFTEDO() {
		return SWIFTEDO;
	}

	/**
	 * @return
	 */
	public String getSWIFTFULL() {
		return SWIFTFULL;
	}

	/**
	 * @return
	 */
	public String getSWIFTNOM() {
		return SWIFTNOM;
	}

	/**
	 * @return
	 */
	public String getSWIFTNUM() {
		return SWIFTNUM;
	}

	/**
	 * @return
	 */
	public String getSWIFTPAI() {
		return SWIFTPAI;
	}

	/**
	 * @return
	 */
	/*
	 * public String getUSERID() { return USERID; }
	 */
	/**
	 * @return
	 */
	public String getVDATE() {
		return VDATE;
	}

	/**
	 * @return
	 */
	public String getVDD() {
		return VDD;
	}

	/**
	 * @return
	 */
	public String getVHH() {
		return VHH;
	}

	/**
	 * @return
	 */
	public String getVMM() {
		return VMM;
	}

	/**
	 * @return
	 */
	public String getVSS() {
		return VSS;
	}

	/**
	 * @return
	 */
	public String getVUSER() {
		return VUSER;
	}

	/**
	 * @return
	 */
	public String getVYY() {
		return VYY;
	}

	/**
	 * @param string
	 */
	public void setABACTY(String string) {
		ABACTY = string;
	}

	/**
	 * @param string
	 */
	public void setABAEDO(String string) {
		ABAEDO = string;
	}

	/**
	 * @param string
	 */
	public void setABANOM(String string) {
		ABANOM = string;
	}

	/**
	 * @param string
	 */
	public void setABANUM(BigDecimal bigdecimal) {
		ABANUM = bigdecimal;
	}

	/**
	 * @param string
	 */
	public void setAMOUNT(BigDecimal bigdecimal) {
		AMOUNT = bigdecimal;
	}

	/**
	 * @param string
	 */
	public void setAMTINCCY(BigDecimal bigdecimal) {
		AMTINCCY = bigdecimal;
	}

	/**
	 * @param string
	 */
	public void setBENENAME(String string) {
		BENENAME = string;
	}

	/**
	 * @param string
	 */
	public void setCCY(String string) {
		CCY = string;
	}

	/**
	 * @param string
	 */
	public void setCREACC(String string) {
		CREACC = string;
	}

	/**
	 * @param string
	 */
	public void setDCIBS_REF(String string) {
		DCIBS_REF = string;
	}

	/**
	 * @param string
	 */
	public void setDEBACC(String string) {
		DEBACC = string;
	}

	/**
	 * @param string
	 */
	public void setDESCRIP1(String string) {
		DESCRIP1 = string;
	}

	/**
	 * @param string
	 */
	public void setDESCRIP2(String string) {
		DESCRIP2 = string;
	}

	/**
	 * @param string
	 */
	public void setENTITYID(String string) {
		ENTITYID = string;
	}

	/**
	 * @param string
	 */
	public void setEXRATE(BigDecimal bigdecimal) {
		EXRATE = bigdecimal;
	}

	/**
	 * @param string
	 */
	public void setFLAG(String string) {
		FLAG = string;
	}

	/**
	 * @param string
	 */
	public void setINSTRUCCIONES1(String string) {
		INSTRUCCIONES1 = string;
	}

	/**
	 * @param string
	 */
	public void setINSTRUCCIONES2(String string) {
		INSTRUCCIONES2 = string;
	}

	/**
	 * @param i
	 */
	public void setNUMAPR(BigDecimal bigdecimal) {
		NUMAPR = bigdecimal;
	}

	/**
	 * @param string
	 */
	public void setODATE(String string) {
		ODATE = string;
	}

	/**
	 * @param string
	 */
	public void setOUSER(String string) {
		OUSER = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTADD(String string) {
		SWIFTADD = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTARE(String string) {
		SWIFTARE = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTCD(String string) {
		SWIFTCD = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTEDO(String string) {
		SWIFTEDO = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTFULL(String string) {
		SWIFTFULL = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTNOM(String string) {
		SWIFTNOM = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTNUM(String string) {
		SWIFTNUM = string;
	}

	/**
	 * @param string
	 */
	public void setSWIFTPAI(String string) {
		SWIFTPAI = string;
	}

	/**
	 * @param string
	 */
	/*
	 * public void setUSERID(String string) { USERID = string; }
	 */

	/**
	 * @param string
	 */
	public void setVDATE(String string) {
		VDATE = string;
	}

	/**
	 * @param string
	 */
	public void setVDD(String string) {
		VDD = string;
	}

	/**
	 * @param string
	 */
	public void setVHH(String string) {
		VHH = string;
	}

	/**
	 * @param string
	 */
	public void setVMM(String string) {
		VMM = string;
	}

	/**
	 * @param string
	 */
	public void setVSS(String string) {
		VSS = string;
	}

	/**
	 * @param string
	 */
	public void setVUSER(String string) {
		VUSER = string;
	}

	/**
	 * @param string
	 */
	public void setVYY(String string) {
		VYY = string;
	}

	/**
	 * @return
	 */
	public String getSTS() {
		return STS;
	}

	/**
	 * @param string
	 */
	public void setSTS(String string) {
		STS = string;
	}

	/**
	 * @return
	 */
	public String getCCYCONV() {
		return CCYCONV;
	}

	/**
	 * @param string
	 */
	public void setCCYCONV(String string) {
		CCYCONV = string;
	}

	/**
	 * @return
	 */
	public String getVIA() {
		return VIA;
	}

	/**
	 * @param string
	 */
	public void setVIA(String string) {
		VIA = string;
	}

	/**
	 * @return
	 */
	public String getPDD() {
		return PDD;
	}

	/**
	 * @return
	 */
	public String getPMM() {
		return PMM;
	}

	/**
	 * @return
	 */
	public String getPYY() {
		return PYY;
	}

	/**
	 * @param string
	 */
	public void setPDD(String string) {
		PDD = string;
	}

	/**
	 * @param string
	 */
	public void setPMM(String string) {
		PMM = string;
	}

	/**
	 * @param string
	 */
	public void setPYY(String string) {
		PYY = string;
	}

	/**
	 * @return
	 */
	public String getBY_CODE() {
		return BY;
	}

	/**
	 * @param string
	 */
	public void setBY_CODE(String string) {
		BY = string;
	}

	public boolean updateSwiftRecordData(DC_SWIFTTRANSPER swiftbean) {
		boolean sqlerror = false;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = "" + "UPDATE DC_SWIFTTRANSPER " + " SET "
					+ " AMTINCCY = ?,"
					+ " INSTRUCCIONES1 = ?,	INSTRUCCIONES2 = ?, "
					+ " DESCRIP1  = ?, DESCRIP2 = ?, "
					+ " VYY  = ?, VMM = ?,  VDD= ?, " + " VHH  = ?, VSS = ? "
					+ " WHERE " + " ENTITYID = ? AND DCIBS_REF = ?";

			PreparedStatement st = cnx.prepareStatement(STMT);
			st.setBigDecimal(1, swiftbean.getAMTINCCY());
			st.setString(2, swiftbean.getINSTRUCCIONES1().trim());
			st.setString(3, swiftbean.getINSTRUCCIONES2().trim());
			st.setString(4, swiftbean.getDESCRIP1().trim());
			st.setString(5, swiftbean.getDESCRIP2().trim());
			st.setString(6, swiftbean.getVYY().trim());
			st.setString(7, swiftbean.getVMM().trim());
			st.setString(8, swiftbean.getVDD().trim());
			st.setString(9, swiftbean.getVHH().trim());
			st.setString(10, swiftbean.getVSS().trim());
			st.setString(11, swiftbean.getENTITYID().trim());
			// st.setString (12,swiftbean.getUSERID().trim());
			st.setString(12, swiftbean.getDCIBS_REF().trim());

			st.executeUpdate();

		} catch (SQLException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}

		return (sqlerror);

	}

	public boolean updateSwiftRecord(String STS, BigDecimal NUMAPR) {
		boolean sqlerror = false;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = "" + "UPDATE DC_SWIFTTRANSPER " + " SET "
					+ " NUMAPR = ?,	STS = ?, "
					+ " OUSER  = ?, VUSER = ?, AUSER= ?,"
					+ " ODATE  = ?, VDATE = ?, ADATE= ? " + " WHERE "
					+ " ENTITYID = ? AND DCIBS_REF = ?";

			PreparedStatement st = cnx.prepareStatement(STMT);
			st.setBigDecimal(1, NUMAPR);
			st.setString(2, STS);
			st.setString(3, getOUSER());
			st.setString(4, getVUSER());
			st.setString(5, getAUSER());
			st.setString(6, getODATE());
			st.setString(7, getVDATE());
			st.setString(8, getADATE());
			st.setString(9, getENTITYID());
			// st.setString (10, getUSERID());
			st.setString(10, getDCIBS_REF());

			st.executeUpdate();

		} catch (SQLException e) {
			LOG.debug("Exception e : " + e);
			e.printStackTrace();
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}

		return (sqlerror);

	}

	public boolean createSwiftRecord() {
		boolean sqlerror = false;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = ""
					+ "insert into DC_SWIFTTRANS "
					+ " ("
					+ "ENTITYID,			"
					+ "DEBACC,			CREACC , "
					+ "CCY ,				CCYCONV,"
					+ "AMTINCCY,			EXRATE,"
					+ "AMOUNT,	"
					+ "INSTRUCCIONES1,	INSTRUCCIONES2,	"
					+ "BENENAME,"
					+ "DESCRIP1,	DESCRIP2,"
					+ "SWIFTNUM,	SWIFTNOM,	SWIFTARE,	SWIFTEDO,	SWIFTCD,	SWIFTPAI,	SWIFTFULL,"
					+ "ABANUM,	ABANOM,		ABACTY,		ABAEDO,"
					+ "VMM,		VDD,		VYY,		VHH,		VSS,"
					+ "PMM,		PDD,		PYY,"
					+ "OUSER,		VUSER,		AUSER,"
					+ "ODATE,		VDATE,		ADATE,"
					+ "NUMAPR,	DCIBS_REF,	STS,"
					+ "VIA,		BY_CODE,"
					+ "PHH,		PSS"
					+ ") "
					+ " values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?)";

			PreparedStatement st = cnx.prepareStatement(STMT);
			st.setString(1, getENTITYID());
			// st.setString (2, getUSERID());
			st.setString(2, getDEBACC());
			st.setString(3, getCREACC());
			st.setString(4, getCCY());
			st.setString(5, getCCYCONV());
			st.setBigDecimal(6, getAMTINCCY());
			st.setBigDecimal(7, getEXRATE());
			st.setBigDecimal(8, getAMOUNT());
			st.setString(9, getINSTRUCCIONES1());
			st.setString(10, getINSTRUCCIONES2());
			st.setString(11, getBENENAME());
			st.setString(12, getDESCRIP1());
			st.setString(13, getDESCRIP2());
			st.setString(14, getSWIFTNUM());
			st.setString(15, getSWIFTNOM());
			st.setString(16, getSWIFTARE());
			st.setString(17, getSWIFTEDO());
			st.setString(18, getSWIFTCD());
			st.setString(19, getSWIFTPAI());
			st.setString(20, getSWIFTFULL());
			st.setBigDecimal(21, getABANUM());
			st.setString(22, getABANOM());
			st.setString(23, getABACTY());
			st.setString(24, getABAEDO());
			st.setString(25, getVMM());
			st.setString(26, getVDD());
			st.setString(27, getVYY());
			st.setString(28, getVHH());
			st.setString(29, getVSS());
			st.setString(30, getPMM());
			st.setString(31, getPDD());
			st.setString(32, getPYY());

			st.setString(33, getOUSER());
			st.setString(34, getVUSER());
			st.setString(35, getAUSER());
			st.setString(36, getODATE());
			st.setString(37, getVDATE());
			st.setString(38, getADATE());
			st.setBigDecimal(39, getNUMAPR());
			st.setString(40, getDCIBS_REF());
			st.setString(41, getSTS());
			st.setString(42, getVIA());
			st.setString(43, getBY_CODE());

			st.setString(44, getPHH());
			st.setString(45, getPSS());

			st.executeUpdate();

		} catch (SQLException e) {
			LOG.debug("Exception e : " + e);
			e.printStackTrace();
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}

		return (sqlerror);

	}

	/**
	 * @return
	 */
	public String getADATE() {
		return ADATE;
	}

	/**
	 * @return
	 */
	public String getAUSER() {
		return AUSER;
	}

	/**
	 * @param string
	 */
	public void setADATE(String string) {
		ADATE = string;
	}

	/**
	 * @param string
	 */
	public void setAUSER(String string) {
		AUSER = string;
	}

	/**
	 * @return
	 */
	public String getPHH() {
		return PHH;
	}

	/**
	 * @return
	 */
	public String getPSS() {
		return PSS;
	}

	/**
	 * @param string
	 */
	public void setPHH(String string) {
		PHH = string;
	}

	/**
	 * @param string
	 */
	public void setPSS(String string) {
		PSS = string;
	}

	/**
	 * @return
	 */
	public String getCONFNUM() {
		return CONFNUM;
	}

	/**
	 * @param string
	 */
	public void setCONFNUM(String string) {
		CONFNUM = string;
	}

//	public DC_SWIFTTRANSPER getSwiftTransfer(String ENTITYID,
//			HttpSession session, String AccNumber) {
//
//		DC_SWIFTTRANSPER swiftbean = null;
//
//		Connection cnx = null;
//
//		try {
//
//			cnx = ServiceLocator.getInstance().getDBConn("MSS");
//
//			String STM = "";
//
//			STM = "SELECT * " + " from DC_SWIFTTRANSPER where ENTITYID = '"
//					+ ENTITYID + "' and DCIBS_REF='" + AccNumber + "'"
//					+ " and STS = '1' order by DCIBS_REF DESC";
//
//			PreparedStatement ps = cnx.prepareStatement(STM);
//			ResultSet rs = ps.executeQuery();
//			ResultSetMetaData md = rs.getMetaData();
//
//			while (rs.next()) {
//				swiftbean = new DC_SWIFTTRANSPER();
//				BeanParser bp = new BeanParser(swiftbean);
//				bp.parseResultSet(md, rs);
//
//			}
//			ps.close();
//
//			rs.close();
//
//		} catch (SQLException e) {
//			LOG.debug("Exception e : " + e);
//
//		} catch (ServiceLocatorException e) {
//			LOG.debug("Exception e : " + e);
//		} finally {
//			try {
//				cnx.close();
//			} catch (SQLException e) {
//				LOG.debug("Exception e : " + e);
//			}
//		}
//
//		return (swiftbean);
//	}
//
//	public boolean procUpdateConfNUM(String CONFNUM, String DCIBS_REF,
//			String ENTITYID) throws ServletException, IOException {
//
//		Connection cnx = null;
//		boolean ok = false;
//
//		try {
//
//			cnx = ServiceLocator.getInstance().getDBConn("MSS");
//
//			String STM = "update DC_SWIFTTRANS" + " set CONFNUM = ?"
//					+ " where DCIBS_REF = ? and ENTITYID = ?";
//
//			PreparedStatement st = cnx.prepareStatement(STM);
//
//			st.setString(1, CONFNUM);
//			st.setString(2, DCIBS_REF);
//			st.setString(3, ENTITYID);
//
//			ok = st.executeUpdate() > 0;
//		} catch (SQLException e) {
//			LOG.debug("Exception e : " + e);
//			ok = false;
//		} catch (ServiceLocatorException e) {
//			LOG.debug("Exception e : " + e);
//			ok = false;
//		} finally {
//			try {
//				cnx.close();
//			} catch (SQLException e) {
//				LOG.debug("Exception e : " + e);
//				ok = false;
//			}
//		}
//		return ok;
//	}
//
//	public boolean getSwiftTransferList(String ENTITYID, HttpSession session,
//			JBUserAccSubList lstAccUserTransbean) {
//
//		DC_SWIFTTRANSPER swiftbean;
//		BeanList lstSwiftTransfers;
//
//		lstSwiftTransfers = new BeanList();
//
//		boolean sqlerror = false;
//
//		Connection cnx = null;
//
//		try {
//
//			cnx = ServiceLocator.getInstance().getDBConn("MSS");
//
//			String STM = "";
//
//			STM = "SELECT * " + " from DC_SWIFTTRANSPER where ENTITYID = '"
//					+ ENTITYID + "'" + " and STS = '1' order by DCIBS_REF DESC";
//
//			PreparedStatement ps = cnx.prepareStatement(STM);
//			ResultSet rs = ps.executeQuery();
//			ResultSetMetaData md = rs.getMetaData();
//
//			while (rs.next()) {
//				swiftbean = new DC_SWIFTTRANSPER();
//				BeanParser bp = new BeanParser(swiftbean);
//				bp.parseResultSet(md, rs);
//
//				boolean addtobean = false;
//
//				lstAccUserTransbean.initRowC();
//
//				while (lstAccUserTransbean.getNextRowC()) {
//					String AccBean = lstAccUserTransbean.getACC().trim();
//					if (swiftbean.getDEBACC().trim().equals(AccBean)) {
//						addtobean = true;
//						break;
//					}
//				}
//				if (addtobean) {
//					lstSwiftTransfers.addRow(swiftbean);
//				}
//			}
//			ps.close();
//
//			rs.close();
//
//		} catch (SQLException e) {
//			LOG.debug("Exception e : " + e);
//			sqlerror = true;
//		} catch (ServiceLocatorException e) {
//			LOG.debug("Exception e : " + e);
//			sqlerror = true;
//		} finally {
//			try {
//				cnx.close();
//			} catch (SQLException e) {
//				LOG.debug("Exception e : " + e);
//				sqlerror = true;
//			}
//		}
//
//		// Putting lstTransfers Bean in Session
//		session.setAttribute("lstSwiftTransfers", lstSwiftTransfers);
//
//		return (sqlerror);
//	}
//
//	public boolean deleteSwiftRecord(DC_SWIFTTRANSPER swiftbean) {
//
//		boolean ok = false;
//
//		Connection cnx = null;
//
//		try {
//
//			cnx = ServiceLocator.getInstance().getDBConn("MSS");
//			String STM = "delete from DC_SWIFTTRANS where ENTITYID = ? AND DCIBS_REF = ?";
//
//			PreparedStatement st = cnx.prepareStatement(STM);
//
//			st.setString(1, swiftbean.getENTITYID());
//			// st.setString(2,swiftbean.getUSERID());
//			st.setString(2, swiftbean.getDCIBS_REF());
//
//			ok = st.executeUpdate() == 0;
//
//			cnx.close();
//		} catch (SQLException e) {
//			LOG.debug("Exception e : " + e);
//			ok = true;
//		} catch (ServiceLocatorException e) {
//			LOG.debug("Exception e : " + e);
//			ok = true;
//		} finally {
//			try {
//				cnx.close();
//			} catch (SQLException e) {
//				LOG.debug("Exception e : " + e);
//				ok = true;
//			}
//		}
//
//		return (ok);
//	}

}
