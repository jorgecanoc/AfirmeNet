<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript">
$('document').ready(function(){
	$('.btn.verde').click(function() {
		if ($('#codigoToken').val() == "")
			$('#codigoToken').css('border-color','red');
		else
			submitFormAnimate($('#acceso').attr('id'), $('#acceso').attr('action'));
		return false;
	});
	
	var error = '${not empty errores}';
	if (error)
		$('.notificacion').slideDown();
});
</script>

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
	
	<form:form method="POST" commandName="acceso" action="controlAcceso/validaDatosRec.htm">
	<form:hidden path="contrato" id="contrato"/>
	
    <h3 align="center"><spring:message code="afirmenet.nuevoPwd" /></h3>

    <div class="login">

      <div class="campo">
        <div class="label"><label><spring:message code="afirmenet.contrato" /></label></div>
        <div class="input"><input type="text" disabled value="${acceso.contratoMask}"></div>
        <div class="opcional">&nbsp;</div>
      </div>

      <div class="campo">
        <div class="label vat"><label><spring:message code="afirmenet.datosAcceso.alias" /></label></div>
        <div class="alias"><div>
          <div class="frase"><strong>${acceso.alias}</strong></div>
          <div class="imagen" align="right"><a class="tooltip"><img src="<c:url value="/resources/img/photos/avatar2.png"/>" height="36" width="36" alt=""><span><spring:message code="afirmenet.datosAcceso.avatar" /></span></a></div>
        </div></div>
      </div>

      <div class="campo">
        <div class="label"><label class="gris"><spring:message code="afirmenet.recPwd.claveDinamica" /></label></div>
        <div class="input"><input name="codigoToken" id="codigoToken" class="bgbco" maxlength="6" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;"><a class="ayuda">?</a></div>
      </div>

      <div align="center" class="flex pt10">
        <button onclick="submitForm('acceso', '${context}/login/avisoSeguridad.htm'); return false;" class="btn sec mr20"><spring:message code="afirmenet.cancelar" /></button>
        <button class="btn verde"><spring:message code="afirmenet.continuar" /></button>
      </div>
      
    </div>
    
    </form:form>

  </div></div>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>