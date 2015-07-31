package com.afirme.afirmenet.ibs.databeans.nominaMasiva;

import java.io.Serializable;
import java.math.BigDecimal;

public class DC_NOMINA_PROG implements Serializable {
	private static final long serialVersionUID = 1L;
	private String INCUSR;
	private String INCREF;
	private String INCNARR;
	private String INCCTACGO;
	private String INCFECPROG;
	private String INCHORPROG;
	private int INCTIPNOM;
	private String INCFECAPR;
	private String INCHORAPR;
	private String INCUSUAPR;
	private String INCUS1;
	private String INCUS2;
	private String INCUS3;
	private String INCMAILAD;
	private BigDecimal AMOUNTTOT;
	private BigDecimal TOTALFEE;
	private BigDecimal TOTALFEETAX;
	private String ODATE;
	private String OHORA;
	private String VDATE;
	private String VHORA;
	private String ADATE;
	private int NUMAPR;
	private int STATUS;
	private int INCREGSOK;
	private BigDecimal INCABONOSOK;
	private String INCTANOM;
	private String INCCVEDUP;
	private String INCFREC;
	private String CONNARRATIVA;
	private int INCREGSER;
	private BigDecimal INCABONOSER;
	private String NoCliente;
	private int INCREGS;
	private int paginas;
	private int pagina;
	private String filtro = "";

	/**
	 * @return el iNCUSR
	 */
	public String getINCUSR() {
		return INCUSR;
	}

	/**
	 * @param incusr
	 *            el iNCUSR a establecer
	 */
	public void setINCUSR(String incusr) {
		INCUSR = incusr;
	}

	/**
	 * @return el iNCREF
	 */
	public String getINCREF() {
		return INCREF;
	}

	/**
	 * @param incref
	 *            el iNCREF a establecer
	 */
	public void setINCREF(String incref) {
		INCREF = incref;
	}

	/**
	 * @return el iNCNARR
	 */
	public String getINCNARR() {
		return INCNARR;
	}

	/**
	 * @param incnarr
	 *            el iNCNARR a establecer
	 */
	public void setINCNARR(String incnarr) {
		INCNARR = incnarr;
	}

	/**
	 * @return el iNCCTACGO
	 */
	public String getINCCTACGO() {
		return INCCTACGO;
	}

	/**
	 * @param incctacgo
	 *            el iNCCTACGO a establecer
	 */
	public void setINCCTACGO(String incctacgo) {
		INCCTACGO = incctacgo;
	}

	/**
	 * @return el iNCFECPROG
	 */
	public String getINCFECPROG() {
		return INCFECPROG;
	}

	/**
	 * @param incfecprog
	 *            el iNCFECPROG a establecer
	 */
	public void setINCFECPROG(String incfecprog) {
		INCFECPROG = incfecprog;
	}

	/**
	 * @return el iNCHORPROG
	 */
	public String getINCHORPROG() {
		return INCHORPROG;
	}

	/**
	 * @param inchorprog
	 *            el iNCHORPROG a establecer
	 */
	public void setINCHORPROG(String inchorprog) {
		INCHORPROG = inchorprog;
	}

	/**
	 * @return el iNCTIPNOM
	 */
	public int getINCTIPNOM() {
		return INCTIPNOM;
	}

	/**
	 * @param inctipnom
	 *            el iNCTIPNOM a establecer
	 */
	public void setINCTIPNOM(int inctipnom) {
		INCTIPNOM = inctipnom;
	}

	/**
	 * @return el iNCFECAPR
	 */
	public String getINCFECAPR() {
		return INCFECAPR;
	}

	/**
	 * @param incfecapr
	 *            el iNCFECAPR a establecer
	 */
	public void setINCFECAPR(String incfecapr) {
		INCFECAPR = incfecapr;
	}

	/**
	 * @return el iNCHORAPR
	 */
	public String getINCHORAPR() {
		return INCHORAPR;
	}

	/**
	 * @param inchorapr
	 *            el iNCHORAPR a establecer
	 */
	public void setINCHORAPR(String inchorapr) {
		INCHORAPR = inchorapr;
	}

	/**
	 * @return el iNCUSUAPR
	 */
	public String getINCUSUAPR() {
		return INCUSUAPR;
	}

	/**
	 * @param incusuapr
	 *            el iNCUSUAPR a establecer
	 */
	public void setINCUSUAPR(String incusuapr) {
		INCUSUAPR = incusuapr;
	}

	/**
	 * @return el iNCUS1
	 */
	public String getINCUS1() {
		return INCUS1;
	}

	/**
	 * @param incus1
	 *            el iNCUS1 a establecer
	 */
	public void setINCUS1(String incus1) {
		INCUS1 = incus1;
	}

	/**
	 * @return el iNCUS2
	 */
	public String getINCUS2() {
		return INCUS2;
	}

	/**
	 * @param incus2
	 *            el iNCUS2 a establecer
	 */
	public void setINCUS2(String incus2) {
		INCUS2 = incus2;
	}

	/**
	 * @return el iNCUS3
	 */
	public String getINCUS3() {
		return INCUS3;
	}

	/**
	 * @param incus3
	 *            el iNCUS3 a establecer
	 */
	public void setINCUS3(String incus3) {
		INCUS3 = incus3;
	}

	/**
	 * @return el iNCMAILAD
	 */
	public String getINCMAILAD() {
		return INCMAILAD;
	}

	/**
	 * @param incmailad
	 *            el iNCMAILAD a establecer
	 */
	public void setINCMAILAD(String incmailad) {
		INCMAILAD = incmailad;
	}

	/**
	 * @return el aMOUNTTOT
	 */
	public BigDecimal getAMOUNTTOT() {
		return AMOUNTTOT;
	}

	/**
	 * @param amounttot
	 *            el aMOUNTTOT a establecer
	 */
	public void setAMOUNTTOT(BigDecimal amounttot) {
		AMOUNTTOT = amounttot;
	}

	/**
	 * @return el tOTALFEE
	 */
	public BigDecimal getTOTALFEE() {
		return TOTALFEE;
	}

	/**
	 * @param totalfee
	 *            el tOTALFEE a establecer
	 */
	public void setTOTALFEE(BigDecimal totalfee) {
		TOTALFEE = totalfee;
	}

	/**
	 * @return el tOTALFEETAX
	 */
	public BigDecimal getTOTALFEETAX() {
		return TOTALFEETAX;
	}

	/**
	 * @param totalfeetax
	 *            el tOTALFEETAX a establecer
	 */
	public void setTOTALFEETAX(BigDecimal totalfeetax) {
		TOTALFEETAX = totalfeetax;
	}

	/**
	 * @return el oDATE
	 */
	public String getODATE() {
		return ODATE;
	}

	/**
	 * @param odate
	 *            el oDATE a establecer
	 */
	public void setODATE(String odate) {
		ODATE = odate;
	}

	/**
	 * @return el oHORA
	 */
	public String getOHORA() {
		return OHORA;
	}

	/**
	 * @param ohora
	 *            el oHORA a establecer
	 */
	public void setOHORA(String ohora) {
		OHORA = ohora;
	}

	/**
	 * @return el vDATE
	 */
	public String getVDATE() {
		return VDATE;
	}

	/**
	 * @param vdate
	 *            el vDATE a establecer
	 */
	public void setVDATE(String vdate) {
		VDATE = vdate;
	}

	/**
	 * @return el vHORA
	 */
	public String getVHORA() {
		return VHORA;
	}

	/**
	 * @param vhora
	 *            el vHORA a establecer
	 */
	public void setVHORA(String vhora) {
		VHORA = vhora;
	}

	/**
	 * @return el aDATE
	 */
	public String getADATE() {
		return ADATE;
	}

	/**
	 * @param adate
	 *            el aDATE a establecer
	 */
	public void setADATE(String adate) {
		ADATE = adate;
	}

	/**
	 * @return el nUMAPR
	 */
	public int getNUMAPR() {
		return NUMAPR;
	}

	/**
	 * @param numapr
	 *            el nUMAPR a establecer
	 */
	public void setNUMAPR(int numapr) {
		NUMAPR = numapr;
	}

	/**
	 * @return el sTATUS
	 */
	public int getSTATUS() {
		return STATUS;
	}

	/**
	 * @param status
	 *            el sTATUS a establecer
	 */
	public void setSTATUS(int status) {
		STATUS = status;
	}

	/**
	 * @return el iNCREGSOK
	 */
	public int getINCREGSOK() {
		return INCREGSOK;
	}

	/**
	 * @param incregsok
	 *            el iNCREGSOK a establecer
	 */
	public void setINCREGSOK(int incregsok) {
		INCREGSOK = incregsok;
	}

	/**
	 * @return el iNCABONOSOK
	 */
	public BigDecimal getINCABONOSOK() {
		return INCABONOSOK;
	}

	/**
	 * @param incabonosok
	 *            el iNCABONOSOK a establecer
	 */
	public void setINCABONOSOK(BigDecimal incabonosok) {
		INCABONOSOK = incabonosok;
	}

	/**
	 * @return el iNCTANOM
	 */
	public String getINCTANOM() {
		return INCTANOM;
	}

	/**
	 * @param inctanom
	 *            el iNCTANOM a establecer
	 */
	public void setINCTANOM(String inctanom) {
		INCTANOM = inctanom;
	}

	/**
	 * @return el iNCCVEDUP
	 */
	public String getINCCVEDUP() {
		return INCCVEDUP;
	}

	/**
	 * @param inccvedup
	 *            el iNCCVEDUP a establecer
	 */
	public void setINCCVEDUP(String inccvedup) {
		INCCVEDUP = inccvedup;
	}

	/**
	 * @return el iNCFREC
	 */
	public String getINCFREC() {
		return INCFREC;
	}

	/**
	 * @param incfrec
	 *            el iNCFREC a establecer
	 */
	public void setINCFREC(String incfrec) {
		INCFREC = incfrec;
	}

	/**
	 * @return el cONNARRATIVA
	 */
	public String getCONNARRATIVA() {
		return CONNARRATIVA;
	}

	/**
	 * @param connarrativa
	 *            el cONNARRATIVA a establecer
	 */
	public void setCONNARRATIVA(String connarrativa) {
		CONNARRATIVA = connarrativa;
	}

	/**
	 * @return el iNCREGSER
	 */
	public int getINCREGSER() {
		return INCREGSER;
	}

	/**
	 * @param incregser
	 *            el iNCREGSER a establecer
	 */
	public void setINCREGSER(int incregser) {
		INCREGSER = incregser;
	}

	/**
	 * @return el iNCABONOSER
	 */
	public BigDecimal getINCABONOSER() {
		return INCABONOSER;
	}

	/**
	 * @param incabonoser
	 *            el iNCABONOSER a establecer
	 */
	public void setINCABONOSER(BigDecimal incabonoser) {
		INCABONOSER = incabonoser;
	}

	/**
	 * @return el noCliente
	 */
	public String getNoCliente() {
		return NoCliente;
	}

	/**
	 * @param noCliente
	 *            el noCliente a establecer
	 */
	public void setNoCliente(String noCliente) {
		NoCliente = noCliente;
	}

	/**
	 * @return el iNCREGS
	 */
	public int getINCREGS() {
		return INCREGS;
	}

	/**
	 * @param iNCREGS
	 *            el iNCREGS a establecer
	 */
	public void setINCREGS(int iNCREGS) {
		INCREGS = iNCREGS;
	}

	/**
	 * @return el paginas
	 */
	public int getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas
	 *            el paginas a establecer
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	/**
	 * @return el pagina
	 */
	public int getPagina() {
		return pagina;
	}

	/**
	 * @param pagina
	 *            el pagina a establecer
	 */
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	/**
	 * @return el filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro
	 *            el filtro a establecer
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}
