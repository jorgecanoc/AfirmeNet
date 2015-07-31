package com.afirme.afirmenet.ibs.beans.tarjetas;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.util.StringUtils;

public class DatosTDC {

	private NumberFormat moneyFormatter = new DecimalFormat("###,###,###.00");

	private String tdcSUCO; // Canal = AFI
	private String tdcTRNM; // 0001=Consulta saldos
	private String tdcCTO; // Contrato de AfirmeNet
	private String tdcUSER; // Usuario AfirmeNet
	private String tdcCLIE; // Número de Cliente
	private String tdcTDCC; // Núm. de Tarjeta
	private String tdcTIPT; // Tipo de Tarjeta
	private String tdcTASC; // Tasa de Interés compras
	private String tdcTASD; // Tasa de disp. Efectivo
	private String tdcLIMC; // Limite de Crédito Tarjeta
	private String tdcSALA; // Saldo deudor actual
	private String tdcSALD; // Crédito disponible
	private String tdcSALC; // Saldo al Corte
	private String tdcFECC; // Fecha de Corte
	private String tdcPANGI; // Pago p/no generar intereses
	private String tdcPAGM; // Pago Mínimo
	private String tdcFELP; // Fecha Limite Pago
	private String tdcLIMDE; // Limite de Disp. Efectivo
	private String tdcDIPEF; // Disposiciones en efectivo
	private String tdcDISPE; // Disponible Efectivo
	private String tdcPGYCR; // Pagos y Créditos
	private String tdcPPAPL; // Pagos por aplicar
	private String tdcNVCR; // Nuevos Cargos
	private String tdcPERI; // Fecha de periodo
	private String tdcDIASP; // Días del periodo
	private String tdcINTER; // Intereses al día
	private String tdcPTOS; // Puntos disponibles
	private String tdcPTOC; // Puntos al corte
	private String tdcPTPV; // Puntos por vencer 3 meses
	private String tdcFPTPV; // Fecha vencimientos puntos
	private String tdcRESP; // Respuesta de TSYS
	private String tdcDESR; // Descripción resp.
	private String tdcCXOC; // cargos por otras compras
	private String tdcNOMCLIE; // Nombre del cliente
	private String tdcMQPPOP; // pagos tdc

	public DatosTDC() {

		this.tdcSUCO = "";
		this.tdcTRNM = "";
		this.tdcCTO = "";
		this.tdcUSER = "";
		this.tdcCLIE = "";
		this.tdcTDCC = "";
		this.tdcTIPT = "";
		this.tdcTASC = "";
		this.tdcTASD = "";
		this.tdcLIMC = "";
		this.tdcSALA = "";
		this.tdcSALD = "";
		this.tdcSALC = "";
		this.tdcFECC = "";
		this.tdcPANGI = "";
		this.tdcPAGM = "";
		this.tdcFELP = "";
		this.tdcLIMDE = "";
		this.tdcDIPEF = "";
		this.tdcDISPE = "";
		this.tdcPGYCR = "";
		this.tdcPPAPL = "";
		this.tdcNVCR = "";
		this.tdcPERI = "";
		this.tdcDIASP = "";
		this.tdcINTER = "";
		this.tdcPTOS = "";
		this.tdcPTOC = "";
		this.tdcPTPV = "";
		this.tdcFPTPV = "";
		this.tdcRESP = "";
		this.tdcDESR = "";
		this.tdcCXOC = "";
		this.tdcNOMCLIE = "";
		this.tdcMQPPOP = "";
	}

	public String getTdcMQPPOP() {
		return tdcMQPPOP;
	}

	public void setTdcMQPPOP(String tdcMQPPOP) {
		this.tdcMQPPOP = tdcMQPPOP;
	}

	public String getTdcSUCO() {
		return tdcSUCO;
	}

	public void setTdcSUCO(String tdcSUCO) {
		this.tdcSUCO = tdcSUCO;
	}

	public String getTdcCXOC() {
		return tdcCXOC;
	}

	public void setTdcCXOC(String tdcCXOC) {
		this.tdcCXOC = tdcCXOC;
	}

	public String getTdcNOMCLIE() {
		return tdcNOMCLIE;
	}

	public void setTdcNOMCLIE(String tdcNOMCLIE) {
		this.tdcNOMCLIE = tdcNOMCLIE;
	}

	public NumberFormat getMoneyFormatter() {
		return moneyFormatter;
	}

	public void setMoneyFormatter(NumberFormat moneyFormatter) {
		this.moneyFormatter = moneyFormatter;
	}

	public String getTdcTRNM() {
		return tdcTRNM;
	}

	public void setTdcTRNM(String tdcTRNM) {
		this.tdcTRNM = tdcTRNM;
	}

	public String getTdcCTO() {
		return tdcCTO;
	}

	public void setTdcCTO(String tdcCTO) {
		this.tdcCTO = tdcCTO;
	}

	public String getTdcUSER() {
		return tdcUSER;
	}

	public void setTdcUSER(String tdcUSER) {
		this.tdcUSER = tdcUSER;
	}

	public String getTdcCLIE() {
		return tdcCLIE;
	}

	public void setTdcCLIE(String tdcCLIE) {
		this.tdcCLIE = tdcCLIE;
	}

	public String getTdcTDCC() {
		return tdcTDCC;
	}

	public void setTdcTDCC(String tdcTDCC) {
		this.tdcTDCC = tdcTDCC;
	}

	public String getTdcTIPT() {
		return tdcTIPT;
	}

	public void setTdcTIPT(String tdcTIPT) {
		this.tdcTIPT = tdcTIPT;
	}

	public String getTdcTASC() {
		return tdcTASC;
	}

	public void setTdcTASC(String tdcTASC) {
		this.tdcTASC = tdcTASC;
	}

	public String getTdcTASD() {
		return tdcTASD;
	}

	public void setTdcTASD(String tdcTASD) {
		this.tdcTASD = tdcTASD;
	}

	public String getTdcLIMC() {
		return tdcLIMC;
	}

	public void setTdcLIMC(String tdcLIMC) {
		this.tdcLIMC = tdcLIMC;
	}

	public String getTdcSALA() {
		return tdcSALA;
	}

	public void setTdcSALA(String tdcSALA) {
		this.tdcSALA = tdcSALA;
	}

	public String getTdcSALD() {
		return tdcSALD;
	}

	public void setTdcSALD(String tdcSALD) {
		this.tdcSALD = tdcSALD;
	}

	public String getTdcSALC() {
		return tdcSALC;
	}

	public void setTdcSALC(String tdcSALC) {
		this.tdcSALC = tdcSALC;
	}

	public String getTdcFECC() {
		return tdcFECC;
	}

	public void setTdcFECC(String tdcFECC) {
		this.tdcFECC = tdcFECC;
	}

	public String getTdcPANGI() {
		return tdcPANGI;
	}

	public void setTdcPANGI(String tdcPANGI) {
		this.tdcPANGI = tdcPANGI;
	}

	public String getTdcPAGM() {
		return tdcPAGM;
	}

	public void setTdcPAGM(String tdcPAGM) {
		this.tdcPAGM = tdcPAGM;
	}

	public String getTdcFELP() {
		return tdcFELP;
	}

	public void setTdcFELP(String tdcFELP) {
		this.tdcFELP = tdcFELP;
	}

	public String getTdcLIMDE() {
		return tdcLIMDE;
	}

	public void setTdcLIMDE(String tdcLIMDE) {
		this.tdcLIMDE = tdcLIMDE;
	}

	public String getTdcDIPEF() {
		return tdcDIPEF;
	}

	public void setTdcDIPEF(String tdcDIPEF) {
		this.tdcDIPEF = tdcDIPEF;
	}

	public String getTdcDISPE() {
		return tdcDISPE;
	}

	public void setTdcDISPE(String tdcDISPE) {
		this.tdcDISPE = tdcDISPE;
	}

	public String getTdcPGYCR() {
		return tdcPGYCR;
	}

	public void setTdcPGYCR(String tdcPGYCR) {
		this.tdcPGYCR = tdcPGYCR;
	}

	public String getTdcPPAPL() {
		return tdcPPAPL;
	}

	public void setTdcPPAPL(String tdcPPAPL) {
		this.tdcPPAPL = tdcPPAPL;
	}

	public String getTdcNVCR() {
		return tdcNVCR;
	}

	public void setTdcNVCR(String tdcNVCR) {
		this.tdcNVCR = tdcNVCR;
	}

	public String getTdcPERI() {
		return tdcPERI;
	}

	public void setTdcPERI(String tdcPERI) {
		this.tdcPERI = tdcPERI;
	}

	public String getTdcDIASP() {
		return tdcDIASP;
	}

	public void setTdcDIASP(String tdcDIASP) {
		this.tdcDIASP = tdcDIASP;
	}

	public String getTdcINTER() {
		return tdcINTER;
	}

	public void setTdcINTER(String tdcINTER) {
		this.tdcINTER = tdcINTER;
	}

	public String getTdcPTOS() {
		return tdcPTOS;
	}

	public void setTdcPTOS(String tdcPTOS) {
		this.tdcPTOS = tdcPTOS;
	}

	public String getTdcPTOC() {
		return tdcPTOC;
	}

	public void setTdcPTOC(String tdcPTOC) {
		this.tdcPTOC = tdcPTOC;
	}

	public String getTdcPTPV() {
		return tdcPTPV;
	}

	public void setTdcPTPV(String tdcPTPV) {
		this.tdcPTPV = tdcPTPV;
	}

	public String getTdcFPTPV() {
		return tdcFPTPV;
	}

	public void setTdcFPTPV(String tdcFPTPV) {
		this.tdcFPTPV = tdcFPTPV;
	}

	public String getTdcRESP() {
		return tdcRESP;
	}

	public void setTdcRESP(String tdcRESP) {
		this.tdcRESP = tdcRESP;
	}

	public String getTdcDESR() {
		return tdcDESR;
	}

	public void setTdcDESR(String tdcDESR) {
		this.tdcDESR = tdcDESR;
	}

	public String addMoneyMask(double d) {
		String s = moneyFormatter.format(d);
		return s;
	}
	
	/**
	 * @return numero de cuenta con mascara
	 */
	public String getNumberMask() {
		if (!StringUtils.isEmpty(this.tdcTDCC)) {
			return (this.tdcTDCC.substring(0, this.tdcTDCC.length() - 4))
					.replaceAll(".", "*")
					.concat(this.tdcTDCC.substring(this.tdcTDCC.length() - 4));
		}
		return "************";
	}

}
