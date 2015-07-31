<%@ include file="/WEB-INF/views/base/include/include.jsp"%>

<link href='<c:url value="/resources/css/modal.css"/>' rel="stylesheet"
	type="text/css">
<body>
	<form:form commandName="contrato" method="POST"
		modelAttribute="contrato" onsubmit="javascript:parent.$.fancybox.close();"
		action="servicios/aceptaContrato">
		<div class="contenido">
			<h3 class="f-verde">
				<spring:message code="afirmenet.pago.servicios.terminos.titulo" />
			</h3>
			<p>
				<strong><spring:message
						code="afirmenet.pago.servicios.terminos.cat" arguments="${CAT}"
						htmlEscape="false" /></strong>
			</p>
			<spring:message code="afirmenet.pago.servicios.terminos.leyenda" />
		</div>

		<div class="contenido-modal" align="center">
			<p class="h6">
				<spring:message code="afirmenet.pago.servicios.terminos.instruccion" />
			</p>
			<div class="acciones">
				<a href="javascript:parent.$.fancybox.close();"
					class="btn atras mr10"><spring:message
						code="afirmenet.pago.servicios.terminos.acciones.cancelar" /></a> <a
					onclick="parent.activaServicios(); return false;"
					target="_parent" class="btn verde"><spring:message
						code="afirmenet.pago.servicios.terminos.acciones.activar" /></a>
			</div>
		</div>


	</form:form>
</body>
	<!-- JS para las funciones propias de AfirmeNet	 -->
	<script src='<c:url value="/resources/js/afirmenet/utils.js"/>' type="text/javascript"></script>	
</html>