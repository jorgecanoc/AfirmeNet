<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
$(document).ready(function(){
	$('#cancelar').click(function() {
		submitFormAnimate('convenio', 'pagos/domiciliacion/domiciliacion_cancelacion.htm');
	});
	
	$('#historico').click(function() {
		submitFormAnimate('convenio', 'pagos/domiciliacion/domiciliacion_historico.htm');
	});
});
</script>

<section><div class="container">

<form:form commandName="convenio" method="POST" action="domiciliacion_confirmacion.htm">

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
<form:input path="pagoMax" />

<input type="submit" name="submit" value="submit" />
<input type="submit" name="submit" value="cancelar" id="cancelar" />
<input type="submit" name="historico" value="historico" id="historico" />

</form:form>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>