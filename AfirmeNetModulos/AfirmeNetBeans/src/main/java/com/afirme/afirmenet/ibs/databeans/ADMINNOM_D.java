package com.afirme.afirmenet.ibs.databeans;

import java.util.TreeMap;

@SuppressWarnings("rawtypes")
public class ADMINNOM_D implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The attributes.
	 */
	private String CODIGO_ESPECIAL_EDO = "EM";
	private String CODIGO_ESPECIAL_EDO_NUEVO = "MX";
	private String CODIGO_ESPECIAL_EDO_DESC = "ESTADO DE MEXICO";
	protected int ID = 0;
	protected String NOMBRES = ""; // Nombre(s) del solicitante
	protected String APEPAT = ""; // Apellido paterno
	protected String APEMAT = ""; // Apellido materno
	protected String NOMCORTO = ""; // Nombre corto
	protected String CALLENUM = ""; // Calle y número
	protected String COLONIA = ""; // Colonia
	protected String CIUDAD = ""; // Población
	protected String ESTADO = ""; // Estado
	protected String SEXO = ""; // Sexo
	protected String EDOCIVIL = ""; // Estado civil
	protected String RFC = ""; // RFC
	protected String TELCASA = ""; // Teléfono particular
	protected String TELOFI = ""; // Teléfono oficina
	protected String CODPOS = ""; // Código postal
	protected String CIUDANAC = ""; // Ciudad de nacimiento
	protected String EDONAC = ""; // Estado de nacimiento
	protected String FECNAC = ""; // Fecha de nacimiento
	protected String PROFSN = ""; // Profesión
	protected String NOMBEN1 = ""; // Beneficiario 1
	protected String PARBEN1 = ""; // Parentesco 1
	protected String PORBEN1 = ""; // Porcentaje ( % )
	protected String NOMBEN2 = ""; // Beneficiario 2
	protected String PARBEN2 = ""; // Parentesco 2
	protected String PORBEN2 = ""; // Porcentaje ( % )
	protected String NOMBEN3 = ""; // Beneficiario 3
	protected String PARBEN3 = ""; // Parentesco 3
	protected String PORBEN3 = ""; // Porcentaje ( % )

	protected String NUMCTE = ""; // No Cliente
	protected String NUMCTA = ""; // No Cuenta
	protected String NUMTAR = ""; // No. Tarjeta
	protected String IMAGEN = ""; // Imagen
	protected String NEGOCIO = ""; // Centro de Negocios
	protected String REFNOM = ""; // Referencia de Nómina
	protected String COBASI = ""; // Contrato Básico Simple
	protected String EMAIL = ""; // Correo Electrónico

	protected String ESTATUS = ""; // Estatus
	protected String OBSERVA = ""; // Observacion
	protected String CUENTAR = ""; // LO AGRERARON DE 400

	protected String CODIGOCOLONIA = "";
	protected String CODIGOCIUDAD = "";
	protected String CODIGOESTADO = "";
	protected String CODIGOPAIS = "";

	/**
	 * Gets the values.
	 */
	public int getID() {
		return ID;
	}

	public String getNOMBRES() {
		return NOMBRES;
	}

	public String getAPEPAT() {
		return APEPAT;
	}

	public String getAPEMAT() {
		return APEMAT;
	}

	public String getNombreC() {
		String NombreC = "";
		if (!NOMBRES.equals(""))
			NombreC = NOMBRES + " ";
		if (!APEPAT.equals(""))
			NombreC = NombreC + APEPAT + " ";
		if (!APEMAT.equals(""))
			NombreC = NombreC + APEMAT;
		return NombreC.trim();
	}

	public String getNombreH() {
		char c2 = 34;
		return "<a href='#' onclick='javascript:goDetail(" + ID + ")' "
				+ " onmouseover=" + c2
				+ "window.status='Haz click para ver el detalle';return true"
				+ c2 + " onmouseout=" + c2 + "window.status='';return true"
				+ c2 + ">" + this.getNombreC() + "</a>";
	}

	public String getNOMCORTO() {
		return NOMCORTO;
	}

	public String getCALLENUM() {
		return CALLENUM;
	}

	public String getCOLONIA() {
		return COLONIA;
	}

	public String getCIUDAD() {
		return CIUDAD;
	}

	public String getESTADO() {
		if ((ESTADO != null) && (ESTADO.equals(CODIGO_ESPECIAL_EDO_NUEVO))) {
			return CODIGO_ESPECIAL_EDO;
		}
		return ESTADO;
	}

	public String getEstado(TreeMap EDOSList) {
		CNOFC EDO = (CNOFC) EDOSList.get(ESTADO);
		if ((ESTADO != null) && (ESTADO.equals(CODIGO_ESPECIAL_EDO))) {
			return CODIGO_ESPECIAL_EDO_DESC;
		}
		return EDO != null ? EDO.getCNODSC() : "";
	}

	public String getSEXO() {
		return SEXO;
	}

	public String getSexo() {
		String sData = "";
		if (SEXO.equals("M"))
			sData = "MASCULINO";
		else if (SEXO.equals("F"))
			sData = "FEMENINO";
		return sData;
	}

	public String getEDOCIVIL() {
		return EDOCIVIL;
	}

	public String getEdoCivil() {
		String sData = "";
		if (EDOCIVIL.equals("1"))
			sData = "SOLTERO";
		else if (EDOCIVIL.equals("2"))
			sData = "CASADO";
		else if (EDOCIVIL.equals("3"))
			sData = "DIVORCIADO";
		else if (EDOCIVIL.equals("4"))
			sData = "VIUDO";
		else if (EDOCIVIL.equals("5"))
			sData = "COHABITADO";
		return sData;
	}

	public String getRFC() {
		return RFC;
	}

	public String getTELCASA() {
		return TELCASA;
	}

	public String getTELOFI() {
		return TELOFI;
	}

	public String getCODPOS() {
		return CODPOS;
	}

	public String getCIUDANAC() {
		return CIUDANAC;
	}

	public String getEDONAC() {
		if ((EDONAC != null) && (EDONAC.equals(CODIGO_ESPECIAL_EDO_NUEVO))) {
			return CODIGO_ESPECIAL_EDO;
		}

		return EDONAC;
	}

	public String getEdoNac(TreeMap EDOSList) {
		CNOFC EDO = (CNOFC) EDOSList.get(EDONAC);
		if ((EDONAC != null) && (EDONAC.equals(CODIGO_ESPECIAL_EDO))) {
			return CODIGO_ESPECIAL_EDO_DESC;
		}
		return EDO != null ? EDO.getCNODSC() : "";
	}

	public String getFECNAC() {
		return FECNAC;
	}

	public String getFecNac() {
		return FECNAC.length() == 8 ? (FECNAC.substring(0, 2) + "/"
				+ FECNAC.substring(2, 4) + "/" + FECNAC.substring(4, 8)) : "";
	}

	public String getPROFSN() {
		return PROFSN;
	}

	public String getProfsn() {
		String sData = "";
		if (PROFSN.equals("1"))
			sData = "ACCIONISTA";
		else if (PROFSN.equals("2"))
			sData = "COMERCIANTE";
		else if (PROFSN.equals("3"))
			sData = "COMISIONISTA";
		else if (PROFSN.equals("4"))
			sData = "EMPLEADO";
		else if (PROFSN.equals("5"))
			sData = "INDEPENDIENTE";
		else if (PROFSN.equals("6"))
			sData = "OBRERO";
		else if (PROFSN.equals("7"))
			sData = "EMPRESARIO";
		else if (PROFSN.equals("8"))
			sData = "PRESTADOR DE SERVICIOS";
		else if (PROFSN.equals("9"))
			sData = "OTRO";
		return sData;
	}

	public String getNOMBEN1() {
		return NOMBEN1;
	}

	public String getPARBEN1() {
		return PARBEN1;
	}

	public String getParBen1(TreeMap PARENList) {
		CNOFC PAREN = (CNOFC) PARENList.get(PARBEN1);
		return PAREN != null ? PAREN.getCNODSC() : "";
	}

	public String getPORBEN1() {
		return PORBEN1;
	}

	public String getNOMBEN2() {
		return NOMBEN2;
	}

	public String getPARBEN2() {
		return PARBEN2;
	}

	public String getParBen2(TreeMap PARENList) {
		CNOFC PAREN = (CNOFC) PARENList.get(PARBEN2);
		return PAREN != null ? PAREN.getCNODSC() : "";
	}

	public String getPORBEN2() {
		return PORBEN2;
	}

	public String getNOMBEN3() {
		return NOMBEN3;
	}

	public String getPARBEN3() {
		return PARBEN3;
	}

	public String getParBen3(TreeMap PARENList) {
		CNOFC PAREN = (CNOFC) PARENList.get(PARBEN3);
		return PAREN != null ? PAREN.getCNODSC() : "";
	}

	public String getPORBEN3() {
		return PORBEN3;
	}

	public String getNUMCTE() {
		return NUMCTE;
	}

	public String getNUMCTA() {
		return NUMCTA;
	}

	public String getNUMTAR() {
		return NUMTAR;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public String getEstatus() {
		String sData = "";
		if (ESTATUS.equals("A"))
			sData = "No Procesado";
		else if (ESTATUS.equals("X"))
			sData = "Cancelado";
		else if (ESTATUS.equals("P"))
			sData = "Procesado";
		else if (ESTATUS.equals("R"))
			sData = "Rechazado";
		return sData;
	}

	public String getEstatusH() {
		char c2 = 34;
		String sData = "";
		if (ESTATUS.equals("A"))
			sData = "No Procesado";
		else if (ESTATUS.equals("X"))
			sData = "Cancelado";
		else if (ESTATUS.equals("P"))
			sData = "Procesado";
		else if (ESTATUS.equals("R"))
			sData = "<a href='#' onclick='javascript:goDetail("
					+ ID
					+ ")' "
					+ " onmouseover="
					+ c2
					+ "window.status='Haz click para ver el detalle';return true"
					+ c2 + " onmouseout=" + c2 + "window.status='';return true"
					+ c2 + ">Rechazado</a>";
		return sData;
	}

	public String getOBSERVA() {
		return OBSERVA;
	}

	public String getIMAGEN() {
		return IMAGEN;
	}

	public String getNEGOCIO() {
		return NEGOCIO;
	}

	public String getREFNOM() {
		return REFNOM;
	}

	public String getCOBASI() {
		return COBASI;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	/**
	 * Sets the values.
	 */
	public void setID(int DATA) {
		this.ID = DATA;
	}

	public void setNOMBRES(String DATA) {
		this.NOMBRES = DATA != null ? DATA.trim() : "";
		this.NOMBRES = this.NOMBRES.replace('Á', 'A');
		this.NOMBRES = this.NOMBRES.replace('É', 'E');
		this.NOMBRES = this.NOMBRES.replace('Í', 'I');
		this.NOMBRES = this.NOMBRES.replace('Ó', 'O');
		this.NOMBRES = this.NOMBRES.replace('Ú', 'U');
		this.NOMBRES = this.NOMBRES.replace('Ü', 'U');
		this.NOMBRES = this.NOMBRES.replace('Ñ', 'N');
		this.NOMBRES = this.NOMBRES.replace('#', 'N');
	}

	public void setAPEPAT(String DATA) {
		this.APEPAT = DATA != null ? DATA.trim() : "";
		this.APEPAT = this.APEPAT.replace('Á', 'A');
		this.APEPAT = this.APEPAT.replace('É', 'E');
		this.APEPAT = this.APEPAT.replace('Í', 'I');
		this.APEPAT = this.APEPAT.replace('Ó', 'O');
		this.APEPAT = this.APEPAT.replace('Ú', 'U');
		this.APEPAT = this.APEPAT.replace('Ü', 'U');
		this.APEPAT = this.APEPAT.replace('Ñ', 'N');
		this.APEPAT = this.APEPAT.replace('#', 'N');
	}

	public void setAPEMAT(String DATA) {
		this.APEMAT = DATA != null ? DATA.trim() : "";
		this.APEMAT = this.APEMAT.replace('Á', 'A');
		this.APEMAT = this.APEMAT.replace('É', 'E');
		this.APEMAT = this.APEMAT.replace('Í', 'I');
		this.APEMAT = this.APEMAT.replace('Ó', 'O');
		this.APEMAT = this.APEMAT.replace('Ú', 'U');
		this.APEMAT = this.APEMAT.replace('Ü', 'U');
		this.APEMAT = this.APEMAT.replace('Ñ', 'N');
		this.APEMAT = this.APEMAT.replace('#', 'N');
	}

	public void setNOMCORTO(String DATA) {
		this.NOMCORTO = DATA != null ? DATA.trim() : "";
		this.NOMCORTO = this.NOMCORTO.replace('Á', 'A');
		this.NOMCORTO = this.NOMCORTO.replace('É', 'E');
		this.NOMCORTO = this.NOMCORTO.replace('Í', 'I');
		this.NOMCORTO = this.NOMCORTO.replace('Ó', 'O');
		this.NOMCORTO = this.NOMCORTO.replace('Ú', 'U');
		this.NOMCORTO = this.NOMCORTO.replace('Ü', 'U');
		this.NOMCORTO = this.NOMCORTO.replace('Ñ', 'N');
		this.NOMCORTO = this.NOMCORTO.replace('#', 'N');
	}

	public void setCALLENUM(String DATA) {
		this.CALLENUM = DATA != null ? DATA.trim() : "";
	}

	public void setCOLONIA(String DATA) {
		this.COLONIA = DATA != null ? DATA.trim() : "";
	}

	public void setCIUDAD(String DATA) {
		this.CIUDAD = DATA != null ? DATA.trim() : "";
	}

	public void setESTADO(String DATA) {
		this.ESTADO = DATA != null ? DATA.trim() : "";
	}

	public void setSEXO(String DATA) {
		this.SEXO = DATA != null ? DATA.trim() : "";
	}

	public void setEDOCIVIL(String DATA) {
		this.EDOCIVIL = DATA != null ? DATA.trim() : "";
	}

	public void setRFC(String DATA) {
		this.RFC = DATA != null ? DATA.trim() : "";
	}

	public void setTELCASA(String DATA) {
		this.TELCASA = DATA != null ? DATA.trim() : "";
	}

	public void setTELOFI(String DATA) {
		this.TELOFI = DATA != null ? DATA.trim() : "";
	}

	public void setCODPOS(String DATA) {
		this.CODPOS = DATA != null ? DATA.trim() : "";
	}

	public void setCIUDANAC(String DATA) {
		this.CIUDANAC = DATA != null ? DATA.trim() : "";
	}

	public void setEDONAC(String DATA) {
		this.EDONAC = DATA != null ? DATA.trim() : "";
	}

	public void setFECNAC(String DATA) {
		this.FECNAC = DATA != null ? DATA : "";
		if (this.FECNAC.startsWith("0000")) {
			this.FECNAC = "19000101";
		}
	}

	public void setPROFSN(String DATA) {
		this.PROFSN = DATA != null ? DATA.trim() : "";
	}

	public void setNOMBEN1(String DATA) {
		this.NOMBEN1 = DATA != null ? DATA.trim() : "";
		this.NOMBEN1 = this.NOMBEN1.replace('Á', 'A');
		this.NOMBEN1 = this.NOMBEN1.replace('É', 'E');
		this.NOMBEN1 = this.NOMBEN1.replace('Í', 'I');
		this.NOMBEN1 = this.NOMBEN1.replace('Ó', 'O');
		this.NOMBEN1 = this.NOMBEN1.replace('Ú', 'U');
		this.NOMBEN1 = this.NOMBEN1.replace('Ü', 'U');
		this.NOMBEN1 = this.NOMBEN1.replace('Ñ', 'N');
		this.NOMBEN1 = this.NOMBEN1.replace('#', 'N');
	}

	public void setPARBEN1(String DATA) {
		this.PARBEN1 = DATA != null ? DATA.trim() : "";
	}

	public void setPORBEN1(String DATA) {
		this.PORBEN1 = DATA != null ? DATA.trim() : "";
	}

	public void setNOMBEN2(String DATA) {
		this.NOMBEN2 = DATA != null ? DATA.trim() : "";
		this.NOMBEN2 = this.NOMBEN2.replace('Á', 'A');
		this.NOMBEN2 = this.NOMBEN2.replace('É', 'E');
		this.NOMBEN2 = this.NOMBEN2.replace('Í', 'I');
		this.NOMBEN2 = this.NOMBEN2.replace('Ó', 'O');
		this.NOMBEN2 = this.NOMBEN2.replace('Ú', 'U');
		this.NOMBEN2 = this.NOMBEN2.replace('Ü', 'U');
		this.NOMBEN2 = this.NOMBEN2.replace('Ñ', 'N');
		this.NOMBEN2 = this.NOMBEN2.replace('#', 'N');
	}

	public void setPARBEN2(String DATA) {
		this.PARBEN2 = DATA != null ? DATA.trim() : "";
	}

	public void setPORBEN2(String DATA) {
		this.PORBEN2 = DATA != null ? DATA.trim() : "";
	}

	public void setNOMBEN3(String DATA) {
		this.NOMBEN3 = DATA != null ? DATA.trim() : "";
		this.NOMBEN3 = this.NOMBEN3.replace('Á', 'A');
		this.NOMBEN3 = this.NOMBEN3.replace('É', 'E');
		this.NOMBEN3 = this.NOMBEN3.replace('Í', 'I');
		this.NOMBEN3 = this.NOMBEN3.replace('Ó', 'O');
		this.NOMBEN3 = this.NOMBEN3.replace('Ú', 'U');
		this.NOMBEN3 = this.NOMBEN3.replace('Ü', 'U');
		this.NOMBEN3 = this.NOMBEN3.replace('Ñ', 'N');
		this.NOMBEN3 = this.NOMBEN3.replace('#', 'N');
	}

	public void setPARBEN3(String DATA) {
		this.PARBEN3 = DATA != null ? DATA.trim() : "";
	}

	public void setPORBEN3(String DATA) {
		this.PORBEN3 = DATA != null ? DATA.trim() : "";
	}

	public void setNUMCTE(String DATA) {
		this.NUMCTE = DATA != null ? DATA.trim() : "";
	}

	public void setNUMCTA(String DATA) {
		this.NUMCTA = DATA != null ? DATA.trim() : "";
	}

	public void setNUMTAR(String DATA) {
		this.NUMTAR = DATA != null ? DATA.trim() : "";
	}

	public void setESTATUS(String DATA) {
		this.ESTATUS = DATA != null ? DATA.trim() : "";
	}

	public void setOBSERVA(String DATA) {
		this.OBSERVA = DATA != null ? DATA.trim() : "";
	}

	public void setIMAGEN(String DATA) {
		this.IMAGEN = DATA != null ? DATA.trim() : "";
	}

	public void setNEGOCIO(String DATA) {
		this.NEGOCIO = DATA != null ? DATA.trim() : "";
	}

	public void setREFNOM(String DATA) {
		this.REFNOM = DATA != null ? DATA.trim() : "";
	}

	public void setCOBASI(String DATA) {
		this.COBASI = DATA != null ? DATA.trim() : "";
	}

	public void setEMAIL(String DATA) {
		this.EMAIL = DATA != null ? DATA.trim() : "";
	}

	public String toString() {
		StringBuffer results = new StringBuffer();

		results.append(getClass().getName() + "\n");

		results.append("\tID      =" + ID + "\n");
		results.append("\tNOMBRES =" + NOMBRES + "\n");
		results.append("\tAPEPAT  =" + APEPAT + "\n");
		results.append("\tAPEMAT  =" + APEMAT + "\n");
		results.append("\tNOMCORTO=" + NOMCORTO + "\n");
		results.append("\tCALLENUM=" + CALLENUM + "\n");
		results.append("\tCOLONIA =" + COLONIA + "\n");
		results.append("\tCIUDAD  =" + CIUDAD + "\n");
		results.append("\tESTADO  =" + ESTADO + "\n");
		results.append("\tSEXO    =" + SEXO + "\n");
		results.append("\tEDOCIVIL=" + EDOCIVIL + "\n");
		results.append("\tRFC     =" + RFC + "\n");
		results.append("\tTELCASA =" + TELCASA + "\n");
		results.append("\tTELOFI  =" + TELOFI + "\n");
		results.append("\tCODPOS  =" + CODPOS + "\n");
		results.append("\tCIUDANAC=" + CIUDANAC + "\n");
		results.append("\tEDONAC  =" + EDONAC + "\n");
		results.append("\tFECNAC  =" + FECNAC + "\n");
		results.append("\tPROFSN  =" + PROFSN + "\n");
		results.append("\tNOMBEN1 =" + NOMBEN1 + "\n");
		results.append("\tPARBEN1 =" + PARBEN1 + "\n");
		results.append("\tPORBEN1 =" + PORBEN1 + "\n");
		results.append("\tNOMBEN2 =" + NOMBEN2 + "\n");
		results.append("\tPARBEN2 =" + PARBEN2 + "\n");
		results.append("\tPORBEN2 =" + PORBEN2 + "\n");
		results.append("\tNOMBEN3 =" + NOMBEN3 + "\n");
		results.append("\tPARBEN3 =" + PARBEN3 + "\n");
		results.append("\tPORBEN3 =" + PORBEN3 + "\n");
		results.append("\tNUMCTE  =" + NUMCTE + "\n");
		results.append("\tNUMCTA  =" + NUMCTA + "\n");
		results.append("\tNUMTAR  =" + NUMTAR + "\n");
		results.append("\tIMAGEN  =" + IMAGEN + "\n");
		results.append("\tNEGOCIO =" + NEGOCIO + "\n");
		results.append("\tREFNOM  =" + REFNOM + "\n");
		results.append("\tCOBASI  =" + COBASI + "\n");
		results.append("\tEMAIL   =" + EMAIL + "\n");
		results.append("\tESTATUS =" + ESTATUS + "\n");
		results.append("\tOBSERVA =" + OBSERVA + "\n");

		return results.toString();
	}

	/**
	 * @return
	 */
	public String getCUENTAR() {
		return CUENTAR;
	}

	/**
	 * @param string
	 */
	public void setCUENTAR(String string) {
		CUENTAR = string;
	}

	public boolean esRegistroValido() {
		return this.validarNOMBRES() && this.validarAPEPAT()
				&& this.validarAPEMAT() && this.validarNOMCORTO()
				&& this.validarCALLENUM() && this.validarCOLONIA()
				&& this.validarCIUDAD() && this.validarESTADO()
				&& this.validarSEXO() && this.validarEDOCIVIL()
				&& this.validarRFC() && this.validarTELOFI()
				&& this.validarCODPOS() && this.validarCIUDANAC()
				&& this.validarEDONAC() && this.validarFECNAC()
				&& this.validarPROFSN();
	}

	public boolean validarNOMBRES() {
		return validarCampo(this.getNOMBRES());
	}

	public boolean validarAPEPAT() {
		return validarCampo(this.getAPEPAT());
	}

	public boolean validarAPEMAT() {
		return validarCampo(this.getAPEMAT());
	}

	public boolean validarNOMCORTO() {
		return validarCampo(this.getNOMCORTO());
	}

	public boolean validarCALLENUM() {
		return validarCampo(this.getCALLENUM());
	}

	public boolean validarCOLONIA() {
		return validarCampo(this.getCOLONIA());
	}

	public boolean validarCIUDAD() {
		return validarCampo(this.getCIUDAD());
	}

	public boolean validarESTADO() {
		return validarCampo(this.getESTADO());
	}

	public boolean validarSEXO() {
		return validarCampo(this.getSEXO());
	}

	public boolean validarEDOCIVIL() {
		return validarCampo(this.getEDOCIVIL());
	}

	public boolean validarRFC() {
		return validarCampo(this.getRFC());
	}

	public boolean validarTELOFI() {
		return validarCampo(this.getTELOFI());
	}

	public boolean validarCODPOS() {
		return validarCampo(this.getCODPOS());
	}

	public boolean validarCIUDANAC() {
		return validarCampo(this.getCIUDANAC());
	}

	public boolean validarEDONAC() {
		return validarCampo(this.getEDONAC());
	}

	public boolean validarFECNAC() {
		return validarCampo(this.getFECNAC());
	}

	public boolean validarPROFSN() {
		return validarCampo(this.getPROFSN());
	}

	public boolean validarCampo(String staCampo) {
		if (staCampo != null && staCampo.trim().length() > 0) {
			return true;
		}

		return false;
	}

	public String getCODIGOCOLONIA() {
		return CODIGOCOLONIA;
	}

	public void setCODIGOCOLONIA(String codigocolonia) {
		CODIGOCOLONIA = codigocolonia;
	}

	public String getCODIGOCIUDAD() {
		return CODIGOCIUDAD;
	}

	public void setCODIGOCIUDAD(String codigociudad) {
		CODIGOCIUDAD = codigociudad;
	}

	public String getCODIGOESTADO() {
		return CODIGOESTADO;
	}

	public void setCODIGOESTADO(String codigoestado) {
		CODIGOESTADO = codigoestado;
	}

	public String getCODIGOPAIS() {
		return CODIGOPAIS;
	}

	public void setCODIGOPAIS(String codigopais) {
		CODIGOPAIS = codigopais;
	}

}
