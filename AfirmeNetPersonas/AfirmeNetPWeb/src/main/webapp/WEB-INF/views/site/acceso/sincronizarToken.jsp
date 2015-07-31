<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
<script type="text/javascript">
	$('document').ready(function() {
	
		var serialToken;
		var codigoToken;
		var codigoToken2;
		
		blurEvent($('.req'));
		
		$('#noserie input').focus(function() {
			$(this).parent().find('.tooltip').addClass('ttover');
		});
		
		$('#noserie input').blur(function() {
			$(this).parent().find('.tooltip').removeClass('ttover');
		});
		
		$('#btn-1 button.verde').click(function() {
			if (($('#inputSerialToken').val() != "") && ($('#inputCodigoToken').val() != "")) {
				$('#password input, #noserie input').removeClass('bgbco').attr('disabled', 'disabled');
				$('#c-password').parent().slideDown();
				$('.mensaje').slideUp();
				$('#btn-1, #btn-2').toggle();
				serialToken = $("#inputSerialToken").val();
				codigoToken = $("#inputCodigoToken").val();
			} else {
				if ($('#inputSerialToken').val() == "")
					$('#inputSerialToken').css('border-color','red');
				if ($('#inputCodigoToken').val() == "")
					$('#inputCodigoToken').css('border-color','red');
			}
			return false;
		});
		
		$('#btn-2 button.verde').click(function() {
			if ($('#inputCodigoToken2').val() != "") {
				codigoToken2 = $("#inputCodigoToken2").val();
				sincronizarToken();
			}
			return false;
		});
		
		$('#btn-3 button.verde').click(function() {
			
			window.location = '${context}/login.htm'
			return false;
		});
		
		function sincronizarToken() {
			blockPage();
			$.ajax({
				url: '${context}/controlAcceso/sincronizacionToken.json',
				method: 'POST',
				data: { 
					contrato: $('#contrato').val(), 
					serialToken: serialToken, 
					codigoToken: codigoToken, 
					codigoToken2: codigoToken2
				},
				success: function(response) {
					unblockPage();
					$('#c-password input').removeClass('bgbco').attr('disabled','disabled');
					$('#btn-2, #btn-3').toggle();
					$('html, body').stop().animate({scrollTop : 0}, 1000);
					
					if (response.errores) {
						$('.aviso').prepend('<div class="notificacion error"><div class="container"><div class="col10 off1"><span class="icon icon-error"></span><h3><strong>¡Error!</strong><br/>' + response.errores[1] + '<br/>' + response.errores[2] + '</h3></div></div></div>');
					} else {
						$('.aviso').prepend('<div class="notificacion"><div class="container"><div class="col10 off1"><span class="icon icon-success"></span><h3><strong>¡Listo!</strong>Tu token fue activado con éxito, ya puedes hacer uso de los servicios de AfirmeNet.</h3></div></div></div>');
					}
					$('.notificacion').slideDown();
				}
			}).done(function(){
				
			});
		}
	});
	
function blurEvent(DOMElementArray) {
	if (DOMElementArray.length) {
		$.each(DOMElementArray, function(index, DOMElement) {
			$(DOMElement).blur(function() {
				if ($(DOMElement).val() == "") {
					$(DOMElement).css('border-color','red');
				} else {
					$(DOMElement).css('border-color','');
				}
			});
		});
	}
}
</script>

<%@ include file="/WEB-INF/views/base/include/header.jsp"%>

<form:form method="POST" commandName="sincronizacion" action="">
  <form:hidden path="contrato" id="contrato"/>
  
  <div class="aviso">
  	
  	<div class="container">

    <h3 align="center"><spring:message code="afirmenet.syncToken" /></h3>

    <div class="login">

      <div class="campo">
        <div class="label"><label><spring:message code="afirmenet.contrato" /></label></div>
        <div class="input"><input type="text" disabled value="${sincronizacion.contratoMask}"></div>
      </div>

      <div class="mensaje advertencia"><span class="icon icon-warning"></span><p><spring:message code="afirmenet.syncToken.usoToken" /></p></div>

      <div class="campo" id="noserie">
        <div class="label"><label class="gris"><spring:message code="afirmenet.syncToken.noSerieToken" /></label></div>
        <div class="input">
          <input id="inputSerialToken" class="bgbco req" maxlength="9" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;">
          <a class="ayuda tooltip">? <span><img src="<c:url value="/resources/img/photos/token.png" />" alt=""><br>Lorem ipsum dolor sit amet, consectetur adipisicing elit</span></a>
        </div>
      </div>

      <div class="campo" id="password">
        <div class="label"><label class="gris"><spring:message code="afirmenet.syncToken.claveDinamica1" /></label></div>
        <div class="input"><input id="inputCodigoToken" class="bgbco req" maxlength="6" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;"><a class="ayuda">?</a></div>
      </div>

      <div style="display: none;"><div class="campo" id="c-password">
        <div class="label"><label class="gris"><spring:message code="afirmenet.syncToken.claveDinamica2" /></label></div>
        <div class="input"><input id="inputCodigoToken2" class="bgbco req" maxlength="6" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;"><a class="ayuda">?</a></div>
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