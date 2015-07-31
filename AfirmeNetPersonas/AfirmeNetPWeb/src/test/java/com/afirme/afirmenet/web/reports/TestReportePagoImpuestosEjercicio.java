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

import com.afirme.afirmenet.model.pagos.impuestos.Ejercicio;
import com.afirme.afirmenet.model.pagos.impuestos.ImpresionImpuesto;
import com.afirme.afirmenet.utils.time.TimeUtils;
import com.afirme.afirmenet.utils.xml.ParseXMLToPojoFactory;

public class TestReportePagoImpuestosEjercicio {
	private static String MASTER = "ComprobantePagoImpuestos.jrxml";
	private static String DETAIL = "ComprobantePagoImpuestosDetalle.jrxml";
	private static String SUB_DETAIL = "ComprobanteDetalleConceptos.jrxml";
//	private static String PATH = "C:\\workspace\\AfirmeNetMVC\\AfirmeNet\\AfirmeNetPersonas\\AfirmeNetPWeb\\src\\test\\resources\\";
	private static String PATH = "src/test/resources/";

	@Test
	public void generaReporte() throws JRException, FileNotFoundException {
		String xml = "<?xml version=\"1.0\" ?><EJERCICIO><IDENTIFICACION><CONCEPTO><CLAVE>10001</CLAVE><DESCRIPCION>RFC</DESCRIPCION><VALOR>CACJ811003H35</VALOR><VALORIMPRESION>CACJ811003H35</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>10003</CLAVE><DESCRIPCION>Apellido paterno</DESCRIPCION><VALOR>CANO</VALOR><VALORIMPRESION>CANO</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>10004</CLAVE><DESCRIPCION>Apellido materno</DESCRIPCION><VALOR>CUEVAS</VALOR><VALORIMPRESION>CUEVAS</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>10005</CLAVE><DESCRIPCION>Nombre</DESCRIPCION><VALOR>JORGE ALBERTO</VALOR><VALORIMPRESION>JORGE ALBERTO</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>10017</CLAVE><DESCRIPCION>Total efectivamente pagado</DESCRIPCION><VALOR>5708</VALOR><VALORIMPRESION>&#x24;5,708.00</VALORIMPRESION></CONCEPTO></IDENTIFICACION><CONCEPTOS><CONCEPTO><CLAVE>11001</CLAVE><DESCRIPCION>Nombre del Concepto</DESCRIPCION><VALOR>ISR retenciones por salarios</VALOR><VALORIMPRESION>ISR retenciones por salarios</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11002</CLAVE><DESCRIPCION>Per&#xed;odo</DESCRIPCION><VALOR>35</VALOR><VALORIMPRESION>Del Ejercicio</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11027</CLAVE><DESCRIPCION>Ejercicio</DESCRIPCION><VALOR>2014</VALOR><VALORIMPRESION>2014</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11022</CLAVE><DESCRIPCION>Tipo de Pago</DESCRIPCION><VALOR>1</VALOR><VALORIMPRESION>Normal</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11004</CLAVE><DESCRIPCION>A Cargo</DESCRIPCION><VALOR>5000</VALOR><VALORIMPRESION>&#x24;5,000.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11005</CLAVE><DESCRIPCION>Parte Actualizada</DESCRIPCION><VALOR>350</VALOR><VALORIMPRESION>&#x24;350.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11006</CLAVE><DESCRIPCION>Recargos</DESCRIPCION><VALOR>52</VALOR><VALORIMPRESION>&#x24;52.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11008</CLAVE><DESCRIPCION>Total de Contribuciones</DESCRIPCION><VALOR>5402</VALOR><VALORIMPRESION>&#x24;5,402.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11016</CLAVE><DESCRIPCION>Total de aplicaciones</DESCRIPCION><VALOR>0</VALOR><VALORIMPRESION>&#x24;0.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11017</CLAVE><DESCRIPCION>Cantidad a Cargo</DESCRIPCION><VALOR>5402</VALOR><VALORIMPRESION>&#x24;5,402.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>11020</CLAVE><DESCRIPCION>Cantidad Pagada</DESCRIPCION><VALOR>5402</VALOR><VALORIMPRESION>&#x24;5,402.00</VALORIMPRESION></CONCEPTO></CONCEPTOS><CONCEPTOS><CONCEPTO><CLAVE>15301</CLAVE><DESCRIPCION>Nombre del Concepto</DESCRIPCION><VALOR>Impuesto a los dep&#xf3;sitos en efectivo</VALOR><VALORIMPRESION>Impuesto a los dep&#xf3;sitos en efectivo</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15302</CLAVE><DESCRIPCION>Per&#xed;odo</DESCRIPCION><VALOR>35</VALOR><VALORIMPRESION>Del Ejercicio</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15327</CLAVE><DESCRIPCION>Ejercicio</DESCRIPCION><VALOR>2014</VALOR><VALORIMPRESION>2014</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15322</CLAVE><DESCRIPCION>Tipo de Pago</DESCRIPCION><VALOR>1</VALOR><VALORIMPRESION>Normal</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15304</CLAVE><DESCRIPCION>A Cargo</DESCRIPCION><VALOR>250</VALOR><VALORIMPRESION>&#x24;250.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15305</CLAVE><DESCRIPCION>Parte Actualizada</DESCRIPCION><VALOR>35</VALOR><VALORIMPRESION>&#x24;35.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15306</CLAVE><DESCRIPCION>Recargos</DESCRIPCION><VALOR>21</VALOR><VALORIMPRESION>&#x24;21.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15308</CLAVE><DESCRIPCION>Total de Contribuciones</DESCRIPCION><VALOR>306</VALOR><VALORIMPRESION>&#x24;306.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15316</CLAVE><DESCRIPCION>Total de aplicaciones</DESCRIPCION><VALOR>0</VALOR><VALORIMPRESION>&#x24;0.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15317</CLAVE><DESCRIPCION>Cantidad a Cargo</DESCRIPCION><VALOR>306</VALOR><VALORIMPRESION>&#x24;306.00</VALORIMPRESION></CONCEPTO><CONCEPTO><CLAVE>15320</CLAVE><DESCRIPCION>Cantidad Pagada</DESCRIPCION><VALOR>306</VALOR><VALORIMPRESION>&#x24;306.00</VALORIMPRESION></CONCEPTO></CONCEPTOS></EJERCICIO>";
		Ejercicio ejercicio = ParseXMLToPojoFactory
				.transform(xml, Ejercicio.class);

		ImpresionImpuesto impresion = new ImpresionImpuesto(ejercicio,
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
		OutputStream output = new FileOutputStream(new File(PATH+"PagoEjercicio.pdf"));
		JasperExportManager.exportReportToPdfStream(print, output);

	}
}
