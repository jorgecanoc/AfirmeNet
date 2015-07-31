package com.afirme.afirmenet.web.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.junit.Test;

import com.afirme.afirmenet.model.pagos.impuestos.Derechos;
import com.afirme.afirmenet.model.pagos.impuestos.ImpresionImpuesto;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.utils.xml.ParseXMLToPojoFactory;

public class TestReportePagoImpuestosDerechos {
	private static String MASTER = "ComprobantePagoImpuestos.jrxml";
	private static String DETAIL = "ComprobantePagoImpuestosDetalle.jrxml";
	private static String SUB_DETAIL = "ComprobanteDetalleConceptos.jrxml";
//	private static String PATH = "C:\\workspace\\AfirmeNetMVC\\AfirmeNet\\AfirmeNetPersonas\\AfirmeNetPWeb\\src\\test\\resources\\";
	private static String PATH = "src/test/resources/";

	@Test
	public void generaReporte() throws JRException, FileNotFoundException {
		String xml = "<?xml version=\"1.0\" ?><DERECHOS><IDENTIFICACION><CONCEPTO><CLAVE>10001</CLAVE><DESCRIPCION>RFC</DESCRIPCION><VALOR>WEB081026AC7</VALOR><VALORIMPRESION>WEB081026AC7</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>10006</CLAVE><DESCRIPCION>Denominaci&#xf3;n o raz&#xf3;n social</DESCRIPCION><VALOR>WEBCOMUNIC&#x40;CION S.A. DE C.V.</VALOR><VALORIMPRESION>WEBCOMUNIC&#x40;CION S.A. DE C.V.</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>10017</CLAVE><DESCRIPCION>Total efectivamente pagado</DESCRIPCION><VALOR>3200</VALOR><VALORIMPRESION>&#x24;3,200.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>30005</CLAVE><DESCRIPCION>Dependencia</DESCRIPCION><VALOR>15</VALOR><VALORIMPRESION>15 Secretar&#xed;a de Salud</VALORIMPRESION></CONCEPTO></IDENTIFICACION><CONCEPTOS><CONCEPTO><CLAVE>14701</CLAVE><DESCRIPCION>Nombre del Concepto</DESCRIPCION><VALOR>Derechos, Productos y Aprovechamientos</VALOR><VALORIMPRESION>Derechos, Productos y Aprovechamientos</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>14702</CLAVE><DESCRIPCION>Per&#xed;odo</DESCRIPCION><VALOR>5</VALOR><VALORIMPRESION>Mayo</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>14727</CLAVE><DESCRIPCION>Ejercicio</DESCRIPCION><VALOR>2013</VALOR><VALORIMPRESION>2013</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>14704</CLAVE><DESCRIPCION>Importe</DESCRIPCION><VALOR>3200</VALOR><VALORIMPRESION>&#x24;3,200.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>14708</CLAVE><DESCRIPCION>Total de Contribuciones</DESCRIPCION><VALOR>3200</VALOR><VALORIMPRESION>&#x24;3,200.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>14720</CLAVE><DESCRIPCION>Cantidad Pagada</DESCRIPCION><VALOR>3200</VALOR><VALORIMPRESION>&#x24;3,200.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>14733</CLAVE><DESCRIPCION>Clave de Referencia del DPA</DESCRIPCION><VALOR>156000134</VALOR><VALORIMPRESION>156000134</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>14734</CLAVE><DESCRIPCION>Cadena de la dependencia</DESCRIPCION><VALOR>SSA20130500001</VALOR><VALORIMPRESION>SSA20130500001</VALORIMPRESION></CONCEPTO></CONCEPTOS></DERECHOS>";
		Derechos derechos = ParseXMLToPojoFactory
				.transform(xml, Derechos.class);

		ImpresionImpuesto impresion = new ImpresionImpuesto(derechos,
				"202194045", "202194045", "101000249",
				"Jorge Alberto Cano Cuevas");
		//Valores generados
		impresion.setCompaniaAPagar("SECRETARIA DE HACIENDA Y CREDITO PUBLICO");
		impresion.setFechaHoraPago(TimeUtils.getDateFormat(new Date(), "dd/MMMM/yy HH:mm:ss"));
		impresion.setLlavePago("ASDFG32154");
		impresion.setOperacion("Pago de Impuestos");
		impresion.setNumeroOperacion("321654987");
		List<ImpresionImpuesto> dataSource = new ArrayList<ImpresionImpuesto>(0);
		dataSource.add(impresion);
		Map<String, Object> parameters = new HashMap<String, Object>();

		JasperReport master = JasperCompileManager.compileReport(PATH + MASTER);
		JasperReport detail = JasperCompileManager.compileReport(PATH +DETAIL);
		JasperReport subDetail = JasperCompileManager.compileReport(PATH +SUB_DETAIL);

		parameters
				.put("TITULO",
						"Recibo Bancario de Pago de Contribuciones, Productos y Aprovechamientos Federales");
		parameters.put("SUBREPORTE", detail);
		parameters.put("SUBSUBREPORTE", subDetail);
		JasperPrint print = JasperFillManager.fillReport(master, parameters,
				new JRBeanCollectionDataSource(dataSource));
		OutputStream output = new FileOutputStream(new File(PATH+"PagoDerechos.pdf"));
		JasperExportManager.exportReportToPdfStream(print, output);

	}
}
