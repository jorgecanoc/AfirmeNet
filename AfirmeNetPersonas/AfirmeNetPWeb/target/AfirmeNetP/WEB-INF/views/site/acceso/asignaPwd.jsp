<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
<script type="text/javascript">
    $('document').ready(function(){
    
    	var validPass = false;
    	
    	$('.btn.verde').click(function() {
    		var password = $('#inputPwd').val();
			var confirma = $('#confirma').val();
    	
    		if ((password != "") && (confirma != ""))
    			submitFormAnimate('activacion', $('#activacion').attr('action'));
    		else {
    			if (password == "")
    				$('#inputPwd').css('border-color','red');
    			if (confirma == "")
    				$('#confirma').css('border-color','red');
    		}
    		return false;
    	});
    	
    	$('.btn.mr20').click(function() {
    		submitFormAnimate('activacion', 'controlAcceso/cancelar.htm');
    	});

		$('#password input').keyup(function(){
			var pass = $(this).val().length;
			if( $('.mensaje').length < 1 )
				$('#password').after('<div class="mensaje" style="display:none;"></div>');
			if( pass < 7 && pass > 3 ){
				$('.mensaje').html('<span class="icon icon-error"></span><p>La contraseña debe tener al menos 8 caracteres y máximo 10, incluyendo mayúsculas y minúsculas, números y signos de puntuación.</p>').removeClass('advertencia exito').addClass('error');
				$('#password').removeClass('s-media s-alta').addClass('s-baja');
			}
			if( pass == 7 ){
				$('.mensaje').html('<span class="icon icon-warning"></span><p>La contraseña debe tener signos de puntuación.</p>').removeClass('error exito').addClass('advertencia');
				$('#password').removeClass('s-baja s-alta').addClass('s-media');
			}
			if( pass > 7 ){
				$('.mensaje').html('<span class="icon icon-success"></span><p>Tu contraseña es lo suficientemente fuerte.</p>').removeClass('advertencia error').addClass('exito');
				$('#password').removeClass('s-media s-baja').addClass('s-alta');
				validPass = true;
			}
			if( pass > 3 ){ 
				$('#password').addClass('focus'); $('.mensaje').slideDown(); 
			} else { 
				$('.mensaje').slideUp(); $('#password').removeClass('focus'); 
			}
		});
			
		$('#password input').blur(function(){ if( $('.mensaje').hasClass('exito') ){ $('.mensaje').slideUp(); }});
		$('#c-password input').keyup(function(){ if( $(this).val() == $('#password input').val() ) $('#c-password').addClass('s-alta'); else $('#c-password').removeClass('s-alta').addClass('s-baja'); });

    });
</script>
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>

<form:form method="POST" commandName="activacion" action="controlAcceso/establecePwd.htm">
<form:hidden path="contrato" id="contrato" />
<form:hidden path="serialToken" id="serialToken" />

  <div class="aviso"><div class="container">

    <h3 align="center"><span class="op50"><spring:message code="afirmenet.activacion" /></span> <br> <strong><spring:message code="afirmenet.asignaPwd" /></strong></h3>

    <div class="login">

      <div class="relative clearfix mb10">
        <div class="col10 off1 xs-left" align="center"><h6 class="f-negro"><spring:message code="afirmenet.asignaPwd.escribaPwd" /></h6></div>
        <a class="ayuda">?</a>
      </div>

      <div class="campo" id="password">
        <div class="label"><label class="gris"><spring:message code="afirmenet.asignaPwd.nuevoPwd" /></label></div>
        <div class="input">
        	<input name="password" id="inputPwd" class="bgbco" maxlength="10" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;&bull;">
        	<div class="seguridad"><span></span><span></span><span></span><span></span><span></span></div></div>
      </div>

      <div class="campo" id="c-password">
        <div class="label"><label class="gris"><spring:message code="afirmenet.asignaPwd.confirmarPwd" /></label></div>
        <div class="input">
        	<input name="confirma" id="confirma" class="bgbco" maxlength="10" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;&bull;">
       	</div>
      </div>
      
      <div align="center" class="flex pt10">
        <button class="btn sec mr20"><spring:message code="afirmenet.cancelar" /></button>
        <button class="btn verde"><spring:message code="afirmenet.continuar" /></button>
      </div>
      
    </div>

  </div></div>

</form:form>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>