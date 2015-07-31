<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
<script type="text/javascript">
	$('document').ready(function() {
	
		var codigoToken;
		var codigoToken2;
	
		$('#btn-1 button.verde').click(function() {
			if ($('#inputCodigoToken').val() != "") {
				if ($('.nota').length < 1) {
					$('#password input').removeClass('bgbco').attr('disabled','disabled');
					$('#c-password').parent().slideDown();
					$('#btn-1, #btn-2').toggle();
					codigoToken = $("#inputCodigoToken").val();
				}
			}
			return false;
		});
		
		$('#btn-2 button.verde').click(function() {
			if ($('#inputCodigoToken2').val() != "") {
				codigoToken2 = $("#inputCodigoToken2").val();
				activarToken();
				if ($('.nota').length < 1) {
					$('#c-password').after('<div class="mensaje informacion"><span class="icon icon-eye"></span><p>Debe esperar 10 segundos para volver a solicitar un token</p></div>');
					$('#c-password').next().slideDown();
				}
			}
			return false;
		});
		
		$('#btn-3 button.verde').click(function() {
			window.location = '${context}/login.htm';
			return false;
		});
		
		function activarToken() {
			$('html, body').stop().animate({scrollTop : 0},1000);
			blockPage();
			$.ajax({
			url: '${context}/controlAcceso/activacionToken.htm',
			method: 'POST',
			data: { 
				contrato: $('#contrato').val(), 
				serialToken: $('#serialToken').val(), 
				codigoToken: codigoToken, 
				codigoToken2: codigoToken2
				}
			}).done(function(){
				unblockPage();
				$('#c-password input').removeClass('bgbco').attr('disabled','disabled');
				setTimeout(function() {
					$('#c-password').next().slideUp(300,function() {
						$('#btn-2, #btn-3').toggle();
					});
					$('.aviso').prepend('<div class="notificacion"><div class="container"><div class="col10 off1 xs-col12"><span class="icon icon-success"></span><h3><strong>¡Listo!</strong> Tu token fue sincronizado con éxito, ya puedes hacer uso de los servicios de AfirmeNet.</h3></div></div></div>');
					$('.notificacion').slideDown();
					codigoToken2 = $("#inputCodigoToken2").val();
				}, 2000);
			});
		}
	});
</script>

<%@ include file="/WEB-INF/views/base/include/header.jsp"%>

<form:form method="POST" commandName="activacion" action="">
  <form:hidden path="contrato" id="contrato"/>
  <form:hidden path="serialToken" id="serialToken"/>
  
  <div class="aviso"><div class="container">

    <h3 align="center"><span class="op50"><spring:message code="afirmenet.activaToken" /></span> <br> <strong><spring:message code="afirmenet.activaToken.claveToken" /></strong></h3>

    <div class="login">

      <div class="relative clearfix mb10">
        <div class="col10 off1 xs-left" align="center"><h6 class="f-negro"><spring:message code="afirmenet.activaToken.paraActivar" /></h6></div>
        <a class="ayuda">?</a>
      </div>

      <div class="campo" id="password">
        <div class="label"><label><spring:message code="afirmenet.syncToken.claveDinamica1" /></label></div>
        <div class="input"><input id="inputCodigoToken" name="inputCodigoToken" class="bgbco" maxlength="6" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;"></div>
      </div>

      <div style="display: none;"><div class="campo" id="c-password">
        <div class="label"><label><spring:message code="afirmenet.syncToken.claveDinamica2" /></label></div>
        <div class="input"><input id="inputCodigoToken2" name="inputCodigoToken2" class="bgbco" maxlength="6" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;"></div>
      </div></div>

      <div align="center" class="flex pt10" id="btn-1">
        <button class="btn sec mr20"><spring:message code="afirmenet.cancelar" /></button>
        <button class="btn verde"><spring:message code="afirmenet.continuar" /></button>
      </div>

      <div style="display: none;" id="btn-2"><div align="center" class="flex pt10">
        <button class="btn sec mr20"><spring:message code="afirmenet.cancelar" /></button>
        <button class="btn verde"><spring:message code="afirmenet.continuar" /></button>
      </div></div>

      <div style="display: none;" id="btn-3"><div align="center" class="flex pt10">
        <button class="btn verde">Continuar</button>
      </div></div>
      
    </div>

  </div></div>
</form:form>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>