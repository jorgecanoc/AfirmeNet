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

<form:form commandName="convenio" method="POST" action="domiciliacion_contrato.htm">

	<form:select path="folio" cssClass="drop req">
		<option value="">Seleccionar Servicio</option>
		<c:forEach var="servicio" items="${listServicios}">
			<option value="${servicio.folio}">${servicio.servicio}</option>
		</c:forEach>
	</form:select>
	<input type="submit" name="submit" value="submit" />

</form:form>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>