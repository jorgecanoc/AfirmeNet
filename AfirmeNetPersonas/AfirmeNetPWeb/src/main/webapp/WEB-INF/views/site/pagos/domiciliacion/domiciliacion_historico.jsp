<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>

<script>
$(document).ready(function(){
	$('a.btn.verde').click(function() {
		submitFormAnimate('convenio', $('#convenio').attr('action'));
	});
	
	$('#fechaInicio').css({'color' : '#008d36', 'text-transform' : 'uppercase'});
	$('#fechaFin').css({'color' : '#008d36', 'text-transform' : 'uppercase'});
	
	datePicker('fechaInicio');
	datePicker('fechaFin');
	
});

function datePicker(elementID) {
	var picker = new Pikaday({
		field : document.getElementById(elementID),
		defaultDate : new Date(Date.now()),
		format : 'DD/MMMM/YYYY',
		onSelect : function() {
			$('#' + elementID).css({
				'color' : '#008d36',
				'text-transform' : 'uppercase'
			});
		}
	});
}

</script>

<section><div class="container">

<form:form commandName="convenio" method="POST" action="domiciliacion_historico.htm">

${convenio.folio} <br/>
${convenio.acuerdo} <br/>
${convenio.servicio} <br/>
${convenio.descripcion} <br/>
${convenio.tipoMovimiento} <br/>
${convenio.referencia} <br/>
${convenio.fechaContratacion} <br/>
${convenio.horaContratacion} <br/>
${convenio.titular} <br/>
${convenio.pagoMin} <br/>
${convenio.pagoMax} <br/>

Desde: <input type="text" id="fechaInicio" name="fechaInicio" value="${fechaInicio}" readonly="readonly" />
Hasta: <input type="text" id="fechaFin" name="fechaFin" value="${fechaFin}" readonly="readonly" />

<input type="submit" name="submit" value="Buscar" />

</form:form>

<table>
	<tr>
		<td>Contrato</td>
		<td>Tipo de Servicio</td>
		<td>Referencia del Servicio</td>
		<td>Monto</td>
		<td>Fecha de Pago</td>
		<td>Hora de Pago</td>
		<td>Estatus</td>
		<td>Motivo de Rechazo</td>
	</tr>
	
	<c:forEach var="convenio" items="${listConvenios}">
	<tr>
		<td>${convenio.origen.number}</td>
		<td>${convenio.servicio}</td>
		<td>${convenio.referencia}</td>
		<td>${convenio.amount}</td>
		<td>${convenio.fechaPago}</td>
		<td>${convenio.horaPago}</td>
		<td>${convenio.estatusPago}</td>
		<td>${convenio.descEstatusPago}</td>
	</tr>
	</c:forEach>
	
</table>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>