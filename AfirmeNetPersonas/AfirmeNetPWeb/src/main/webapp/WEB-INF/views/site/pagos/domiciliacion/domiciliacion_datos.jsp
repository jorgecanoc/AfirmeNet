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

<form:form commandName="convenio" method="POST" action="domiciliacion_confirmacion.htm">

<form:select path="origen.number" cssClass="drop req">
	<option value="">Seleccionar Cuenta</option>
	<c:forEach var="cuenta" items="${cuentasPropias}">
	<option value="${cuenta.number}">
		${cuenta.description} (${cuenta.numberMask}) -
		$${cuenta.balanceFormatted} - ${cuenta.ccy}</option>
	</c:forEach>
</form:select>
<br/>
Proveedor del servicio: ${convenio.servicio} <br/>
Comision del servicio: Sin comision <br/>
Nombre del titular del servicio: 
<input type="text" name="titular" /> <br/>
Periodicidad del pago: Periodicidad con la que emita la factura C.F.E <br/>
Ingrese monto máximo por periodo de facturación: 
<input type="text" name="pagoMax" /> <br/>
Ingrese su número de Servicio: 
<input type="text" name="referencia" /> <br/>
Correo Electrónico alterno para avisos: 
<input type="text" name="email" />

<input type="submit" name="submit" value="submit" />

<div style="display: none;">
${convenio.folio} <br/>
${convenio.acuerdo} <br/>
${convenio.descripcion} <br/>
${convenio.tipoMovimiento} <br/>
${convenio.referencia} <br/>
${convenio.fechaContratacion} <br/>
${convenio.horaContratacion} <br/>
${convenio.titular} <br/>
${convenio.pagoMin} <br/>
${convenio.pagoMax} <br/>
</div>

</form:form>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>