
<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>

<form:form method="POST" commandName="aviso" action="${context}/login/avisoSeguridad.htm">
	<form:hidden path="contrato"/>
	
	<div class="aviso">
		<div class="container">
			<h3 align="center" class="mb40"><b><spring:message code="afirmenet.avisoImportante"/></b></h3>
			<div class="row mb40">
				<div class="col3 xs-col12 xs-mb20" align="center">
					<div class="h80"><img src='<c:url value="/resources/img/icons/aviso-ingreso.png"/>' height="50" width="80" alt=""></div>
					<h6><strong><spring:message code="afirmenet.noUtilizarBuscadores"/></strong><br><spring:message code="afirmenet.leyendaBuscadores"/></h6>
				</div>
				<div class="col3 xs-col12 xs-mb20" align="center">
					<div class="h80"><img src='<c:url value="/resources/img/icons/aviso-casa.png"/>' height="50" width="54" alt=""></div>
					<h6><strong><spring:message code="afirmenet.siempreIngresa"/></strong><br><spring:message code="afirmenet.laURL"/></h6>
				</div>
				<div class="col3 xs-col12 xs-mb20" align="center">
					<div class="h80"><img src='<c:url value="/resources/img/icons/aviso-llave.png"/>' height="38" width="59" alt=""></div>
					<h6><strong><spring:message code="afirmenet.nuncaProporciones"/></strong><br><spring:message code="afirmenet.tuToken"/></h6>
				</div>
				<div class="col3 xs-col12 xs-mb20" align="center">
					<div class="h80"><img src='<c:url value="/resources/img/icons/aviso-urls.png"/>'height="50" width="50" alt=""></div>
					<h6><strong><spring:message code="afirmenet.hazCasoOmiso"/></strong> <br><spring:message code="afirmenet.delosEmails"/></h6>
				</div>
			</div>
			<div align="center">
				<button onclick="submitFormAnimate('aviso','login/avisoSeguridad.htm'); return false;" class="btn verde"><spring:message code="afirmenet.estoydeAcuerdo"/></button>
				<div class="mt25">
					<div class="col4 off4 xs-col12 ovhidden" align="center">
						<input type="checkbox" id="noMostrarAvisoSeg" name="noMostrarAvisoSeg" class="cbox"checked /> 
						<label for="noMostrarAvisoSeg" class="f-verde"><spring:message code="afirmenet.noVolverAMostrar"/></label>
					</div>
				</div>
			</div>
		</div>
	</div>

</form:form>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>