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
CONTRATACI�N DEL SERVICIO DE DOMICILIACI�N A TRAV�S DE AFIRMENET

T�RMINOS Y CONDICIONES GENERALES

ACTIVACI�N DEL SERVICIO

Al hacer clic en ?Continuar?, el Cliente autoriza a Afirme a cargar autom�ticamente en su Cuenta, el monto previamente definido por el propio Cliente, para el pago del recibo o servicio de que se trate (en lo sucesivo, la ?Domiciliaci�n?). Los cargos se realizar�n con la periodicidad en que el proveedor del servicio respectivo, emita las facturas correspondientes.

Afirme no tendr� responsabilidad alguna: (i) en caso de que el Cliente proporcione datos err�neos al momento de contratar el servicio; (ii) cuando la Cuenta de cargo, sea objeto de alguna medida de aseguramiento dictada por autoridad judicial o administrativa, no tenga saldo suficiente para cumplir las instrucciones, o bien, hubiere sido cancelada; (iii) en caso de que el Cliente establezca l�mites a los cargos peri�dicos o defina cantidades menores al total de cada factura; (iv) por mantenimiento, fallas o interrupciones en el funcionamiento de los sistemas transaccionales y/o en los sistemas de comunicaci�n en general y/o alg�n otro acontecimiento similar, fuera del control de Afirme.

CANCELACI�N DEL SERVICIO

En cualquier momento, el Cliente podr� solicitar la cancelaci�n del servicio de Domiciliaci�n, ya sea a trav�s de AfirmeNet o en sucursales de Afirme. La citada cancelaci�n surtir� efectos en un plazo no mayor a 3 (tres) d�as h�biles, posteriores al d�a en que Afirme reciba la solicitud. A partir de esa fecha, Afirme no realizar� cargos en la Cuenta relacionados con la Domiciliaci�n.

Afirme no cobrar� comisiones por tramitar y resolver solicitudes de cancelaci�n.

OBJECIONES

El Cliente podr� objetar los cargos realizados a su Cuenta con motivo de la Domiciliaci�n, dentro de los 90 (noventa) d�as naturales siguientes al �ltimo d�a del per�odo del estado de cuenta en donde aparezca el cargo materia de la objeci�n. Las objeciones se deber�n presentar en sucursales de Afirme.

Afirme no cobrar� comisiones por tramitar y resolver objeciones que resulten procedentes.

Cuando el Cliente objete alg�n cargo derivado del servicio de Domiciliaci�n durante los primeros 60 (sesenta) d�as, Afirme deber� abonar el monto reclamado a m�s tardar el d�a h�bil siguiente a la recepci�n de la objeci�n, sin que pueda requerir la realizaci�n de tr�mite adicional alguno. Si la objeci�n se realiza entre el d�a 61 (sesenta y uno) y el d�a 90 (noventa), Afirme deber� resolver sobre la procedencia de la reclamaci�n en un plazo m�ximo de 20 (veinte) d�as y, en caso de que la objeci�n resulte procedente, abonar el monto reclamado a m�s tardar el d�a h�bil siguiente a la fecha de resoluci�n.

En caso de que la objeci�n de cargos por Domiciliaci�n no resulte procedente, Afirme deber� poner a disposici�n del Cliente, el original impreso de la resoluci�n con firma del personal facultado en la que se expresen los argumentos que sustentan la improcedencia, as� como copia de los documentos o evidencia de soporte respectivos, incluyendo la proporcionada por el proveedor de que se trate, en la sucursal en la que, en su caso, se haya presentado la objeci�n o en la que hubiesen acordado, para tal efecto.

Adicionalmente, deber� enviar Cliente copia de dicha resoluci�n a trav�s de correo electr�nico cuando este haya presentado la objeci�n a trav�s de AfirmeNet, cuando as� lo haya solicitado al presentar la objeci�n.

DATOS DE CONTACTO

Para dudas o aclaraciones, comunicarse al 01 800 223 4763
T�RMINOS Y CONDICIONES DE CADA SERVICIO

Domiciliaci�n del pago del Servicio Telef�nico Telmex:

1.	Para el alta del servicio de Domiciliaci�n deber� tener incorporadas sus Cuentas al servicio de AfirmeNety no deber� de tener contratado el servicio de Domiciliaci�n con otro banco. En caso de cancelaci�n, robo o extrav�o de cuentas deber� incorporar sus Cuentas nuevamente al servicio de AfirmeNet y posteriormente contratar nuevamente el servicio de Domiciliaci�n.
2.	Este servicio aplica con cargo a Cuenta de Cheques y Tarjeta de D�bito.
3.	El servicio de Domiciliaci�n iniciar� cuando en su recibo telef�nico Telmex, aparezca la leyenda "Importe enviado a cobro en su Banco", por lo que deber� seguir pagando su recibo normalmente hasta que esto ocurra.
4.	Telmex realizar� el cobro antes de la fecha l�mite del recibo telef�nico. En consecuencia, en caso de falta de fondos podr� ocasionar la suspensi�n del servicio. En caso de que la fecha de cobro sea un d�a inh�bil, se cobrar� el d�a anterior.
5.	Si en tres ocasiones consecutivas, la Cuenta de Cheques y Tarjeta de D�bito no tiene los fondos suficientes para efectuar el pago del recibo telef�nico Telmex, la instrucci�n de pago se cancelar� autom�ticamente.
6.	Si el importe de su recibo Telmex es mayor al importe m�ximo que autoriz� para realizar el pago en forma autom�tica, el pago no se aplicar� y deber� acudir a pagar directamente a las oficinas Telmex antes de la fecha l�mite indicada en su recibo para evitar la suspensi�n del servicio.
7.	En caso de requerir alguna aclaraci�n referente al consumo o facturaci�n de su recibo telef�nico Telmex, deber� acudir directamente a las oficinas Telmex.
8.	La cancelaci�n de la instrucci�n, ya sea voluntaria o por insuficiencia de fondos, implica que en su recibo telef�nico no aparezca la leyenda "Importe enviado a cobro en su Banco".
</textarea>

<input type="submit" name="submit" value="submit" />

</form:form>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>