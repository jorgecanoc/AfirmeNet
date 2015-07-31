<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
<script type="text/javascript">
	$('document').ready(function() {

		$('#noserie').focus(function() {
			$(this).parent().find('.tooltip').addClass('ttover');
		});
		$('#noserie').blur(function() {
			$(this).parent().find('.tooltip').removeClass('ttover');
		});
		
		$('.btn.verde').click(function() {
			if (($('#noserie').val() != "") && ($('#codigoToken').val() != ""))
				submitFormAnimate('activacion', $('#activacion').attr('action'));
			else {
				$('#noserie').css('border-color','red');
				$('#codigoToken').css('border-color','red');
			}
			return false;
		});
		
	});
</script>

<form:form method="POST" commandName="activacion" action="controlAcceso/validaUsrActivacion.htm">
  <form:hidden path="contrato" id="contrato"/>
  <div class="aviso"><div class="container">

    <h3 align="center"><spring:message code="afirmenet.activacion" /></h3>

    <div class="login">

      <div class="campo">
        <div class="label"><label><spring:message code="afirmenet.header.contrato" /></label></div>
        <div class="input"><input type="text" disabled value="${activacion.contratoMask}"></div>
        <div class="opcional">&nbsp;</div>
      </div>

      <div class="mensaje advertencia"><span class="icon icon-warning"></span><p><spring:message code="afirmenet.activacion.paraHacer" /></p></div>

      <div class="campo">
        <div class="label"><label class="gris"><spring:message code="afirmenet.activacion.noSerieToken" /></label></div>
        <div class="input">
          <input name="serialToken" class="bgbco" id="noserie" maxlength="9" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;">
          <a href="#" class="ayuda tooltip">? <span><img src="<c:url value="/resources/img/photos/token.png"/>" alt=""><br>Lorem ipsum dolor sit amet, consectetur adipisicing elit</span></a>
        </div>
      </div>

      <div class="campo">
        <div class="label"><label class="gris"><spring:message code="afirmenet.activacion.codigoSeguridad" /></label></div>
        <div class="input">
          <input name="codigoActivacion" id="codigoToken" class="bgbco" maxlength="10" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;&bull;">
          <a class="ayuda">?</a>
        </div>
      </div>

      <div align="center" class="flex pt10">
        <button class="btn sec mr20"><spring:message code="afirmenet.cancelar" /></button>
        <button class="btn verde accion"><spring:message code="afirmenet.continuar" /></button>
      </div>
      
    </div>

  </div></div>

</form:form>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>