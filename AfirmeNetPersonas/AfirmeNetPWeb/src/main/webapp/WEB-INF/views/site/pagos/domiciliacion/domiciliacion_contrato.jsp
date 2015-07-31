<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script>
$(document).ready(function(){
	$('a.btn.verde').click(function() {
		submitFormAnimate('convenio', $('#convenio').attr('action'));
	});
});
</script>

<section><div class="container">

<form:form commandName="convenio" method="POST" action="domiciliacion_activacion.htm">

<textarea cols="180" rows="25">
CONTRATACIÓN DEL SERVICIO DE DOMICILIACIÓN A TRAVÉS DE AFIRMENET

TÉRMINOS Y CONDICIONES GENERALES

ACTIVACIÓN DEL SERVICIO

Al hacer clic en ?Continuar?, el Cliente autoriza a Afirme a cargar automáticamente en su Cuenta, el monto previamente definido por el propio Cliente, para el pago del recibo o servicio de que se trate (en lo sucesivo, la ?Domiciliación?). Los cargos se realizarán con la periodicidad en que el proveedor del servicio respectivo, emita las facturas correspondientes.

Afirme no tendrá responsabilidad alguna: (i) en caso de que el Cliente proporcione datos erróneos al momento de contratar el servicio; (ii) cuando la Cuenta de cargo, sea objeto de alguna medida de aseguramiento dictada por autoridad judicial o administrativa, no tenga saldo suficiente para cumplir las instrucciones, o bien, hubiere sido cancelada; (iii) en caso de que el Cliente establezca límites a los cargos periódicos o defina cantidades menores al total de cada factura; (iv) por mantenimiento, fallas o interrupciones en el funcionamiento de los sistemas transaccionales y/o en los sistemas de comunicación en general y/o algún otro acontecimiento similar, fuera del control de Afirme.

CANCELACIÓN DEL SERVICIO

En cualquier momento, el Cliente podrá solicitar la cancelación del servicio de Domiciliación, ya sea a través de AfirmeNet o en sucursales de Afirme. La citada cancelación surtirá efectos en un plazo no mayor a 3 (tres) días hábiles, posteriores al día en que Afirme reciba la solicitud. A partir de esa fecha, Afirme no realizará cargos en la Cuenta relacionados con la Domiciliación.

Afirme no cobrará comisiones por tramitar y resolver solicitudes de cancelación.

OBJECIONES

El Cliente podrá objetar los cargos realizados a su Cuenta con motivo de la Domiciliación, dentro de los 90 (noventa) días naturales siguientes al último día del período del estado de cuenta en donde aparezca el cargo materia de la objeción. Las objeciones se deberán presentar en sucursales de Afirme.

Afirme no cobrará comisiones por tramitar y resolver objeciones que resulten procedentes.

Cuando el Cliente objete algún cargo derivado del servicio de Domiciliación durante los primeros 60 (sesenta) días, Afirme deberá abonar el monto reclamado a más tardar el día hábil siguiente a la recepción de la objeción, sin que pueda requerir la realización de trámite adicional alguno. Si la objeción se realiza entre el día 61 (sesenta y uno) y el día 90 (noventa), Afirme deberá resolver sobre la procedencia de la reclamación en un plazo máximo de 20 (veinte) días y, en caso de que la objeción resulte procedente, abonar el monto reclamado a más tardar el día hábil siguiente a la fecha de resolución.

En caso de que la objeción de cargos por Domiciliación no resulte procedente, Afirme deberá poner a disposición del Cliente, el original impreso de la resolución con firma del personal facultado en la que se expresen los argumentos que sustentan la improcedencia, así como copia de los documentos o evidencia de soporte respectivos, incluyendo la proporcionada por el proveedor de que se trate, en la sucursal en la que, en su caso, se haya presentado la objeción o en la que hubiesen acordado, para tal efecto.

Adicionalmente, deberá enviar Cliente copia de dicha resolución a través de correo electrónico cuando este haya presentado la objeción a través de AfirmeNet, cuando así lo haya solicitado al presentar la objeción.

DATOS DE CONTACTO

Para dudas o aclaraciones, comunicarse al 01 800 223 4763
TÉRMINOS Y CONDICIONES DE CADA SERVICIO

Domiciliación del pago del Servicio Telefónico Telmex:

1.	Para el alta del servicio de Domiciliación deberá tener incorporadas sus Cuentas al servicio de AfirmeNety no deberá de tener contratado el servicio de Domiciliación con otro banco. En caso de cancelación, robo o extravío de cuentas deberá incorporar sus Cuentas nuevamente al servicio de AfirmeNet y posteriormente contratar nuevamente el servicio de Domiciliación.
2.	Este servicio aplica con cargo a Cuenta de Cheques y Tarjeta de Débito.
3.	El servicio de Domiciliación iniciará cuando en su recibo telefónico Telmex, aparezca la leyenda "Importe enviado a cobro en su Banco", por lo que deberá seguir pagando su recibo normalmente hasta que esto ocurra.
4.	Telmex realizará el cobro antes de la fecha límite del recibo telefónico. En consecuencia, en caso de falta de fondos podrá ocasionar la suspensión del servicio. En caso de que la fecha de cobro sea un día inhábil, se cobrará el día anterior.
5.	Si en tres ocasiones consecutivas, la Cuenta de Cheques y Tarjeta de Débito no tiene los fondos suficientes para efectuar el pago del recibo telefónico Telmex, la instrucción de pago se cancelará automáticamente.
6.	Si el importe de su recibo Telmex es mayor al importe máximo que autorizó para realizar el pago en forma automática, el pago no se aplicará y deberá acudir a pagar directamente a las oficinas Telmex antes de la fecha límite indicada en su recibo para evitar la suspensión del servicio.
7.	En caso de requerir alguna aclaración referente al consumo o facturación de su recibo telefónico Telmex, deberá acudir directamente a las oficinas Telmex.
8.	La cancelación de la instrucción, ya sea voluntaria o por insuficiencia de fondos, implica que en su recibo telefónico no aparezca la leyenda "Importe enviado a cobro en su Banco".
</textarea>

<input type="submit" name="submit" value="submit" />

</form:form>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>