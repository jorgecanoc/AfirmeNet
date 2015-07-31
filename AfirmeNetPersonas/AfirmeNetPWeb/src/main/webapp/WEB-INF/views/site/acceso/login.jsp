	<%@ include file="/WEB-INF/views/base/include/include.jsp"%>	
	<%@ include file="/WEB-INF/views/base/include/header.jsp"%>
	<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#contrato').focus();
			
			$('#contrato').keypress(function(key) {
				if (key.which == 13)
					formSubmit($('#login').attr('action'));
			});
			
			$('#enviar').click(function() {
				formSubmit($('#login').attr('action'));
			});
			
			$('#sincroniza').click(function() {
				formSubmit('controlAcceso/sincroniza.htm');
			});
		});
		
		function formSubmit(action) {
			if ($('#contrato').val() != "")
				submitFormAnimate($('#login').attr('id'), action);
			else
				displayWarning();
		}
		
		function displayWarning() {
			if (!$('.notificacion').length) {
				$('.aviso').prepend('<div class="notificacion advertencia"><div class="container"><div class="col10 off1 xs-col12"><span class="icon icon-warning"></span><h3><strong>ADVERTENCIA</strong><br> Para hacer uso de AfirmeNet favor de ingresar su contrato.</h3></div></div></div>');
				$('.notificacion').slideDown();
			}
			$('#contrato').focus();
		}
	</script>
	
	<form:form method="POST" commandName="login" action="login/contrato.htm">	
	  	<div class="aviso">
	  		<div class="container">
				<h3 align="center"><b><spring:message code="afirmenet.datosIngreso"/></b></h3>
	    		<div class="login">
				      <div class="campo">
				        <div class="label"><label><spring:message code="afirmenet.contrato"/></label></div>
				        <div class="input">
				        	<input name="contrato" id="contrato" class="bgbco req onlyNum" type="tel"  placeholder="<spring:message code="afirmenet.contrato.placeHolder"/>">
				        </div>
				      </div>	    		
		      		<div class="pt10" align="center"><button id="enviar" class="btn btn-lg verde" onclick="return false;"><spring:message code="afirmenet.login"/></button></div>	
		      		<div class="p20" align="center">
		      			<a href="#" class="h5 f-verde" style="float: left;"><spring:message code="afirmenet.login.ayuda"/></a>
		      			<a href="#" class="h5 f-verde" id="sincroniza" style="float: right;"><spring:message code="afirmenet.login.sincronizar"/></a>
		      		</div>
		      		<div class="p20" align="center"><a href="#" class="btn btn-lg amarillo"><spring:message code="afirmenet.login.sitio"/></a></div>
	    		</div>
	  		</div>
	  	</div>
	</form:form>
	<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>