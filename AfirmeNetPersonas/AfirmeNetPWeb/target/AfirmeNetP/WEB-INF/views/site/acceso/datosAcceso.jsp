<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>

<form:form method="POST" commandName="acceso" action="login/datosAcceso.htm">
	<form:hidden path="contrato" id="contrato"/>
	<div class="aviso">
		<div class="container">
			<h3 align="center"><spring:message code="afirmenet.datosAcceso" /></h3>
			<div class="login">
				<div class="campo">
					<div class="label"><label><spring:message code="afirmenet.contrato" /></label></div>
					<div class="input"><input type="text" disabled value="${acceso.contratoMask}"></div>
				</div>

				<div class="campo">
					<div class="label vat"><label><spring:message code="afirmenet.datosAcceso.alias" /></label></div>
					<div class="alias">
						<div>
							<div class="frase"><strong>${acceso.alias}</strong></div>
							<div class="imagen" align="right">
								<a class="tooltip"><img src='<c:url value="/resources/img/photos/avatar2.png"/>'
									height="36" width="36" alt=""><span><spring:message code="afirmenet.datosAcceso.avatar" /></span></a>
							</div>
						</div>
					</div>
				</div>
				<div class="campo"><div class="label"><label><spring:message code="afirmenet.datosAcceso.password" /></label></div>
					<div class="input"><input class="bgbco" maxlength="10" type="password" name="password" id="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;&bull;">
						<a class="ayuda">?</a>
					</div>
				</div>
				<div class="campo"><div class="label"><label><spring:message code="afirmenet.datosAcceso.token" /></label></div>
					<div class="input"><input class="bgbco" maxlength="6" type="password" name="token" id="token" placeholder="&bull;&bull;&bull;&bull;&bull;">
						<a class="ayuda">?</a>
					</div>
				</div>
				<div class="p10-20 mb10" align="center">
					<a href="javascript: submitForm('acceso', '${context}/controlAcceso/recuperaPwd.htm');" class="h5 f-lima"><spring:message code="afirmenet.datosAcceso.olvido" /></a>
				</div>
				<div align="center" class="flex">
					<button id="continuar" onclick="return false;" class="btn verde"><spring:message code="afirmenet.datosAcceso.ingresar" /></button>
				</div>
			</div>
		</div>
	</div>
</form:form>



<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>
<script type="text/javascript">
		 $(document).ready(function () {
     
	     $('#continuar').click(function() {         
        	if ($('#password').val() != "" && $('#token').val() != "" ){
				submitFormAnimate($('#acceso').attr('id'), $('#acceso').attr('action'));
			  }else{
			      if($('.notificacion').length<1){					 
		            $('.aviso').prepend('<div class="notificacion advertencia"><div class="container"><div class="col10 off1 xs-col12"><span class="icon icon-warning"></span><h3><strong>ADVERTENCIA</strong><br> Para hacer uso de AfirmeNet favor de ingresar su contraseña y clave dinamica.</h3></div></div></div>');
		            $('.notificacion').slideDown();	
		            }	          
			  }
      		});		

	  });
</script>