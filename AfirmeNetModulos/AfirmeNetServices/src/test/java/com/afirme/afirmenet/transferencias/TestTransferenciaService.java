package com.afirme.afirmenet.transferencias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.service.config.ConfiguracionService;
import com.afirme.afirmenet.service.transferencia.TransferenciaTercerosService;
import com.afirme.afirmenet.utils.AfirmeNetConstants;

public class TestTransferenciaService {

	@SuppressWarnings({ "resource", "unchecked" })
	@Test
	public void testTransferenciaTerceros() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"services-config.xml");
//		init();
//		
//		TransferenciaTercerosService tercerosModel = context
//				.getBean(TransferenciaTercerosService.class);
//
//		// Inicializa Lista de feriados
//		ConfiguracionService config = context
//				.getBean(ConfiguracionService.class);
//		AfirmeNetConstants.holidayList = config.getDiasFeriados();
//		AfirmeNetConstants.bankList=config.getBANList();
//		AfirmeNetConstants.plazaList = config.getPlazas();
//
//		// Inicializa las transferencias
////		tercerosModel.preparaNuevaTransferencia(getTxBase());
//		List<TransferenciaBase> txs = new ArrayList<TransferenciaBase>(0);
//		txs.add(getTxBase());
//
//		tercerosModel.setTransferencias(txs);
//		// Valida carrito de tx
//		System.out.println("Carrito de TX size===> "
//				+ tercerosModel.getTransferencias().size());
//		
//		// obtiene la ultima Tx insertada
//		TransferenciaBase txReadOnly = tercerosModel.getTransferencias().get(
//				tercerosModel.getTransferencias().size() - 1);
//		System.out.println("Contact Id ===> " + txReadOnly.getContractId());
//		System.out.println("DebitAccount===> " + txReadOnly.getDebitAccount());
//		System.out.println("Amount===> " + txReadOnly.getAmount());
//
//		// ejecuta transferencia
//
//		List<Comprobante> comprobantes = (List<Comprobante>) tercerosModel.confirmaTransferencias();
//		print(comprobantes);
	}
	public void print(List<Comprobante> comprobantes){
		for(ComprobanteTransferencia comprobanteI : comprobantes){
			Comprobante comprobante = (Comprobante)comprobanteI;
			System.out.println(comprobante.toString());
		}
	}
	public void init(){
		// Inicializa socket
		AfirmeNetConstants.JAVA_PATH = "com.afirme.afirmenet.ibs";
		AfirmeNetConstants.SOCKET_PUERTO = 7300;
		AfirmeNetConstants.SOCKET_IP = "172.20.70.96";
		AfirmeNetConstants.SOCKET_PORT_SUMARY = 1;
		AfirmeNetConstants.SOCKET_TIMEOUT = 10000;		
	}
	public TransferenciaBase getTxBase() {
		// Inicializa Datos de TX
		TransferenciaBase txBase = new TransferenciaBase();

		txBase.setUserId("1311266001");
		txBase.setDebitAccount("800828708");
		txBase.setCreditAccount("801230512");
		txBase.setContractId("1311266001");
		txBase.setAmount(BigDecimal.ONE);
		txBase.setCurrency("MXP");
		txBase.setBankReceiving("62");
		txBase.setPlazaReceiving("0");
		txBase.setBankFrm("62");
		txBase.setBeneficiaryName("LUIS ENRIQUE RODRIGUEZ ESPINOSA");
		txBase.setEmailBeneficiary("");
		txBase.setNarrative("");
		txBase.setUserReference("311112");
		txBase.setValidationDate("28/05/15");
		txBase.setValidationYear("15");
		txBase.setValidationMonth("5");
		txBase.setValidationDay("28");
		txBase.setValidationMinute("00");
		txBase.setValidationHour("00");
		txBase.setTransactionCode("03");
		txBase.setIva(BigDecimal.ONE);
		txBase.setCommision(BigDecimal.ZERO);
		txBase.setDescription("INSTRUCCION DE PAGO");
		txBase.setRfc("CACJ811003H35");
		return txBase;
	}
}
