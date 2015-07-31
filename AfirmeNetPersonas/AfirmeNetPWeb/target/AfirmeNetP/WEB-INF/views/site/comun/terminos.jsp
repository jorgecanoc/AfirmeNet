<%@ include file="/WEB-INF/views/base/include/include.jsp"%>

<link href='<c:url value="/resources/css/modal.css"/>' rel="stylesheet"
	type="text/css">
<body>
	<div class="contenido">

		<h1 class="f21 mb20 f-verde">
			<strong><spring:message code="afirmenet.terminos.titulo" /></strong>
		</h1>
		<p>${sessionScope.afirmeNetUser.campania.terminos}</p>
	</div>
	<div class="botones" align="center">
		<a href="javascript:parent.$.fancybox.close();" class="btn verde"><spring:message
				code="afirmenet.terminos.continuar" /></a>
	</div>
</body>
</html>