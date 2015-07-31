/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: GRPUSR.java
 * Creado: Sep 26, 2005
 * Paquete: com.consiss.tests.databeans
 * Clase: GRPUSR
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.math.BigDecimal;

/**
 * @author Usuarioafirme
 * 
 */
public class GRPUSR implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String GRPUID = null;
	private String GRPLGT = null;
	private String GRPDSC = null;
	private BigDecimal EUSANUCL = null;
	private BigDecimal EUSMENCL = null;
	private BigDecimal EUSSPECL = null;
	private BigDecimal EUSSWFCL = null;
	private BigDecimal EUSDOMCL = null;
	private BigDecimal EUSTYACL = null;
	private BigDecimal EUSTNACL = null;
	private BigDecimal EUSNYACL = null;
	private BigDecimal EUSNNACL = null;
	private BigDecimal EUSIMPCL = null;
	private BigDecimal EUSANU = null;
	private BigDecimal EUSMEN = null;
	private BigDecimal EUSSPE = null;
	private BigDecimal EUSSWF = null;
	private BigDecimal EUSDOM = null;
	private BigDecimal EUSTYA = null;
	private BigDecimal EUSTNA = null;
	private BigDecimal EUSNYA = null;
	private BigDecimal EUSNNA = null;
	private BigDecimal EUSIMP = null;
	private BigDecimal EUSTXP = null;

	/**
	 * Set field GRPUID using a String value.
	 */
	public void setGRPUID(String newvalue) {
		GRPUID = newvalue;
	}

	/**
	 * Get value of field GRPUID as a String.
	 */
	public String getGRPUID() {
		return GRPUID;
	}

	/**
	 * Set field GRPLGT using a String value.
	 */
	public void setGRPLGT(String newvalue) {
		GRPLGT = newvalue;
	}

	/**
	 * Get value of GRPLGT as a String.
	 */
	public String getGRPLGT() {
		return GRPLGT;
	}

	/**
	 * Set GRPDSC using a String value.
	 */
	public void setGRPDSC(String newvalue) {
		GRPDSC = newvalue;
	}

	/**
	 * Get value of GRPDSC as a String.
	 */
	public String getGRPDSC() {
		return GRPDSC;
	}

	/**
	 * Set numeric EUSANUCL using a BigDecimal value.
	 */
	public void setEUSANUCL(BigDecimal newvalue) {
		EUSANUCL = newvalue;
	}

	/**
	 * Return value of numeric EUSANUCL as a BigDecimal.
	 */
	public BigDecimal getEUSANUCL() {
		return EUSANUCL;
	}

	/**
	 * Set numeric EUSMENCL using a BigDecimal value.
	 */
	public void setEUSMENCL(BigDecimal newvalue) {
		EUSMENCL = newvalue;
	}

	/**
	 * Return value of numeric EUSMENCL as a BigDecimal.
	 */
	public BigDecimal getEUSMENCL() {
		return EUSMENCL;
	}

	/**
	 * Set numeric EUSSPECL using a BigDecimal value.
	 */
	public void setEUSSPECL(BigDecimal newvalue) {
		EUSSPECL = newvalue;
	}

	/**
	 * Return value of numeric EUSSPECL as a BigDecimal.
	 */
	public BigDecimal getEUSSPECL() {
		return EUSSPECL;
	}

	/**
	 * Set numeric EUSSWFCL using a BigDecimal value.
	 */
	public void setEUSSWFCL(BigDecimal newvalue) {
		EUSSWFCL = newvalue;
	}

	/**
	 * Return value of numeric EUSSWFCL as a BigDecimal.
	 */
	public BigDecimal getEUSSWFCL() {
		return EUSSWFCL;
	}

	/**
	 * Set numeric EUSDOMCL using a BigDecimal value.
	 */
	public void setEUSDOMCL(BigDecimal newvalue) {
		EUSDOMCL = newvalue;
	}

	/**
	 * Return value of numeric EUSDOMCL as a BigDecimal.
	 */
	public BigDecimal getEUSDOMCL() {
		return EUSDOMCL;
	}

	/**
	 * Set numeric EUSTYACL using a BigDecimal value.
	 */
	public void setEUSTYACL(BigDecimal newvalue) {
		EUSTYACL = newvalue;
	}

	/**
	 * Return value of numeric EUSTYACL as a BigDecimal.
	 */
	public BigDecimal getEUSTYACL() {
		return EUSTYACL;
	}

	/**
	 * Set numeric EUSTNACL using a BigDecimal value.
	 */
	public void setEUSTNACL(BigDecimal newvalue) {
		EUSTNACL = newvalue;
	}

	/**
	 * Return value of numeric EUSTNACL as a BigDecimal.
	 */
	public BigDecimal getEUSTNACL() {
		return EUSTNACL;
	}

	/**
	 * Set numeric EUSNYACL using a BigDecimal value.
	 */
	public void setEUSNYACL(BigDecimal newvalue) {
		EUSNYACL = newvalue;
	}

	/**
	 * Return value of numeric EUSNYACL as a BigDecimal.
	 */
	public BigDecimal getEUSNYACL() {
		return EUSNYACL;
	}

	/**
	 * Set numeric EUSNNACL using a BigDecimal value.
	 */
	public void setEUSNNACL(BigDecimal newvalue) {
		EUSNNACL = newvalue;
	}

	/**
	 * Return value of numeric EUSNNACL as a BigDecimal.
	 */
	public BigDecimal getEUSNNACL() {
		return EUSNNACL;
	}

	/**
	 * Set numeric EUSIMPCL using a BigDecimal value.
	 */
	public void setEUSIMPCL(BigDecimal newvalue) {
		EUSIMPCL = newvalue;
	}

	/**
	 * Return value of numeric EUSIMPCL as a BigDecimal.
	 */
	public BigDecimal getEUSIMPCL() {
		return EUSIMPCL;
	}

	/**
	 * Set numeric EUSANU using a BigDecimal value.
	 */
	public void setEUSANU(BigDecimal newvalue) {
		EUSANU = newvalue;
	}

	/**
	 * Return value of numeric EUSANU as a BigDecimal.
	 */
	public BigDecimal getEUSANU() {
		return EUSANU;
	}

	/**
	 * Set numeric EUSMEN using a BigDecimal value.
	 */
	public void setEUSMEN(BigDecimal newvalue) {
		EUSMEN = newvalue;
	}

	/**
	 * Return value of numeric EUSMEN as a BigDecimal.
	 */
	public BigDecimal getEUSMEN() {
		return EUSMEN;
	}

	/**
	 * Set numeric EUSSPE using a BigDecimal value.
	 */
	public void setEUSSPE(BigDecimal newvalue) {
		EUSSPE = newvalue;
	}

	/**
	 * Return value of numeric EUSSPE as a BigDecimal.
	 */
	public BigDecimal getEUSSPE() {
		return EUSSPE;
	}

	/**
	 * Set numeric EUSSWF using a BigDecimal value.
	 */
	public void setEUSSWF(BigDecimal newvalue) {
		EUSSWF = newvalue;
	}

	/**
	 * Return value of numeric EUSSWF as a BigDecimal.
	 */
	public BigDecimal getEUSSWF() {
		return EUSSWF;
	}

	public void setEUSDOM(BigDecimal eUSDOM) {
		EUSDOM = eUSDOM;
	}

	/**
	 * Return value of numeric EUSDOM as a BigDecimal.
	 */
	public BigDecimal getEUSDOM() {
		return EUSDOM;
	}

	/**
	 * Set numeric EUSTYA using a BigDecimal value.
	 */
	public void setEUSTYA(BigDecimal newvalue) {
		EUSTYA = newvalue;
	}

	/**
	 * Return value of numeric EUSTYA as a BigDecimal.
	 */
	public BigDecimal getEUSTYA() {
		return EUSTYA;
	}

	/**
	 * Set numeric EUSTNA using a BigDecimal value.
	 */
	public void setEUSTNA(BigDecimal newvalue) {
		EUSTNA = newvalue;
	}

	/**
	 * Return value of numeric EUSTNA as a BigDecimal.
	 */
	public BigDecimal getEUSTNA() {
		return EUSTNA;
	}

	/**
	 * Set numeric EUSNYA using a BigDecimal value.
	 */
	public void setEUSNYA(BigDecimal newvalue) {
		EUSNYA = newvalue;
	}

	/**
	 * Return value of numeric EUSNYA as a BigDecimal.
	 */
	public BigDecimal getEUSNYA() {
		return EUSNYA;
	}

	/**
	 * Set numeric EUSNNA using a BigDecimal value.
	 */
	public void setEUSNNA(BigDecimal newvalue) {
		EUSNNA = newvalue;
	}

	/**
	 * Return value of numeric EUSNNA as a BigDecimal.
	 */
	public BigDecimal getEUSNNA() {
		return EUSNNA;
	}

	/**
	 * Set numeric EUSIMP using a BigDecimal value.
	 */
	public void setEUSIMP(BigDecimal newvalue) {
		EUSIMP = newvalue;
	}

	/**
	 * Return value of numeric EUSIMP as a BigDecimal.
	 */
	public BigDecimal getEUSIMP() {
		return EUSIMP;
	}

	/**
	 * Set numeric EUSTXP using a BigDecimal value.
	 */
	public void setEUSTXP(BigDecimal newvalue) {
		EUSTXP = newvalue;
	}

	/**
	 * Return value of numeric EUSTXP as a BigDecimal.
	 */
	public BigDecimal getEUSTXP() {
		return EUSTXP;
	}

	/**
	 * Obtiene las tarifas y comisiones del paquete del usuario
	 * 
	 * @param EntityID
	 * @param GroupID
	 *            -Paquete o plan del usuario
	 * @param as400libname
	 * @param tipoRegimen
	 *            -Tipo de regimen fiscal del usuario de afirmenet 1-Persona
	 *            Moral, 2-Persona Fisica
	 * @return boolean true-Error al realizar la consulta, false-Se realizo con
	 *         exito la consulta
	 */
//	public boolean getGroupCosts(String EntityID, String GroupID,
//			String as400libname, String tipoRegimen) {
//		boolean sqlerror = false;
//		Connection cnx = null;
//		String comisionAnual = "";
//		String comisionMensual = "";
//
//		try {
//			cnx = ServiceLocator.getInstance().getDBConn("AS400");
//
//			// Obtenemos el tipo de regimen fisal del usuario de AfirmeNet
//			try {
//				UserDAOImpl userDao = new UserDAOImpl();
//				tipoRegimen = userDao
//						.obtenerTipoRegimen(EntityID, as400libname);
//			} catch (Exception e) {
//				System.out.println("Error userDao.obtenerTipoRegimen: "
//						+ e.getMessage());
//
//			}
//
//			// Dependiendo del tipo de regimen fiscal del usuario, se
//			// seleccionan las tarifas de distintos campos de la tabla.
//			if (tipoRegimen.equals("1")) {// PersonaMoral
//				comisionAnual = "EUSANUALPM";
//				comisionMensual = "EUSMENSPM";
//			} else {
//				comisionAnual = "EUSANUALPF";
//				comisionMensual = "EUSMENSPF";
//			}
//
//			Statement st = cnx.createStatement();
//			String STM = "SELECT GRPUID,GRPLGT,GRPDSC,EUSANUCL,EUSMENCL,EUSSPECL,EUSSWFCL,EUSDOMCL,EUSTYACL,EUSTNACL,EUSNYACL,EUSNNACL,EUSIMPCL,"
//					+ comisionAnual
//					+ ","
//					+ comisionMensual
//					+ ",EUSSPE,EUSSWF,EUSDOM,EUSTYA,EUSTNA,EUSNYA,EUSNNA,EUSIMP,EUSTXP from "
//					+ as400libname + "GRPUSR WHERE GRPUID = '" + GroupID + "'";
//
//			ResultSet rs = st.executeQuery(STM);
//
//			boolean GoIn = rs.next();
//
//			if (GoIn) {
//				// GRPUID,GRPLGT,GRPDSC,EUSANUCL,EUSMENCL,EUSSPECL,EUSSWFCL,EUSDOMCL,EUSTYACL,EUSTNACL,EUSNYACL,EUSNNACL,EUSIMPCL,EUSANU,EUSMEN,EUSSPE,EUSSWF,EUSDOM,EUSTYA,EUSTNA,EUSNYA,EUSNNA,EUSIMP,EUSTXP
//				GRPUID = rs.getString("GRPUID").trim();
//				GRPLGT = rs.getString("GRPLGT").trim();
//				GRPDSC = rs.getString("GRPDSC").trim();
//				EUSANUCL = rs.getBigDecimal("EUSANUCL");
//				EUSMENCL = rs.getBigDecimal("EUSMENCL");
//				EUSSPECL = rs.getBigDecimal("EUSSPECL");
//				EUSSWFCL = rs.getBigDecimal("EUSSWFCL");
//				EUSDOMCL = rs.getBigDecimal("EUSDOMCL");
//				EUSTYACL = rs.getBigDecimal("EUSTYACL");
//				EUSTNACL = rs.getBigDecimal("EUSTNACL");
//				EUSNYACL = rs.getBigDecimal("EUSNYACL");
//				EUSNNACL = rs.getBigDecimal("EUSNNACL");
//				EUSIMPCL = rs.getBigDecimal("EUSIMPCL");
//				EUSANU = rs.getBigDecimal(comisionAnual);
//				EUSMEN = rs.getBigDecimal(comisionMensual);
//				EUSSPE = rs.getBigDecimal("EUSSPE");
//				EUSSWF = rs.getBigDecimal("EUSSWF");
//				EUSDOM = rs.getBigDecimal("EUSDOM");
//				EUSTYA = rs.getBigDecimal("EUSTYA");
//				EUSTNA = rs.getBigDecimal("EUSTNA");
//				EUSNYA = rs.getBigDecimal("EUSNYA");
//				EUSNNA = rs.getBigDecimal("EUSNNA");
//				EUSIMP = rs.getBigDecimal("EUSIMP");
//				EUSTXP = rs.getBigDecimal("EUSTXP");
//
//			} else {
//				sqlerror = true;
//			}
//			rs.close();
//		} catch (NullPointerException e) {
//			System.out.println("Exception e : " + e);
//			sqlerror = true;
//		} catch (SQLException e) {
//			System.out.println("Exception e : " + e);
//			sqlerror = true;
//		} catch (ServiceLocatorException e) {
//			System.out.println("Exception e : " + e);
//			sqlerror = true;
//		} finally {
//			try {
//				cnx.close();
//			} catch (SQLException e) {
//				System.out.println("Exception e : " + e);
//				sqlerror = true;
//			}
//		}
//		return (sqlerror);
//	}

}
