<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript">
$('document').ready(function() {
	
	$('.btn.verde').click(function() {
		submitFormAnimate('acceso', $('#acceso').attr('action'));
	});
	
	$('.btn.mr10').click(function() {
		submitFormAnimate('acceso', 'login/avisoSeguridad.htm');
	});
	
	var error = '${not empty errores}';
	if (error)
		$('.notificacion').slideDown();
});
</script>
<form:form method="POST" commandName="acceso" action="controlAcceso/validaRespuesta.htm">
<form:hidden path="contrato" id="contrato"/>

  <div class="aviso">
  
  	<c:if test="${not empty errores}">
  	<div class="notificacion error">
  		<div class="container">
  			<div class="col10 off1">
  				<span class="icon icon-error"></span>
  				<h3><strong>¡Error!</strong><br/>${errores}</h3>
 			</div>
 		</div>
 	</div>
 	</c:if>
  
  	<div class="container">

    <h3 align="center"><span class="op50"><spring:message code="afirmenet.nuevoPwd" /></span><br><strong><spring:message code="afirmenet.nuevoPwd.pregSeguridad" /></strong></h3>

    <div class="login">

      <div class="relative clearfix mb10">
        <div class="col10 off1 xs-left" align="center"><h6 class="f-negro"><spring:message code="afirmenet.nuevoPwd.contestePregunta" /></h6></div>
        <a class="ayuda">?</a>
      </div>

      <div class="campo pregunta">
        <div class="label"><label><spring:message code="afirmenet.nuevoPwd.pregunta" /></label></div>
        <div class="input"><strong>¿${datosPreg[1]}?</strong></div>
      </div>

      <div class="campo" id="respuesta">
        <div class="label"><label class="gris"><spring:message code="afirmenet.nuevoPwd.respuesta" /></label></div>
        <div class="input"><input name="respuesta" class="bgbco" type="password" placeholder="Respuesta"><a href="#" class="ayuda tooltip">? <span><spring:message code="afirmenet.nuevoPwd.ayudaRespuesta" /></span></a></div>
      </div>

      <div align="center" class="flex pt10" id="btn-1">
        <button class="btn btn-lg sec mr10"><spring:message code="afirmenet.cancelar" /></button>
        <button class="btn btn-lg verde"><spring:message code="afirmenet.continuar" /></button>
      </div>

      <div style="display: none;" id="btn-2"><div align="center" class="flex pt10">
        <button onclick="window.location.href='LOGIN_Normal_datos-de-acceso.html'" class="btn btn-lg verde">Continuar</button>
      </div></div>
      
    </div>

  </div></div>
</form:form>
  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>