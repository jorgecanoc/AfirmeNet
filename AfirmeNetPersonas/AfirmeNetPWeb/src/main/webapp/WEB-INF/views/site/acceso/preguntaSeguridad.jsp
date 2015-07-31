<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/dropkick.css"/>' rel="stylesheet" type="text/css" />
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css" />
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/vendor/dropkick.js"/>'></script>
<script type="text/javascript">
$('document').ready(function(){

	$('.drop').dropkick({ mobile: true });
	
	$('.btn.verde').click(function() {
		var respuesta = $('#respuesta').val();
		var confirmar = $('#confirmar').val();
		
		if (validForm('activacion') && (respuesta != "") && (confirmar != ""))
			submitFormAnimate('activacion', $('#activacion').attr('action'));
		else {
			if (respuesta == "")
				$('#respuesta').css('border-color','red');
			if (confirmar == "")
				$('#confirmar').css('border-color','red');
		}
		return false;
	});
	
	$('.btn.mr20').click(function() {
		submitFormAnimate('activacion', 'controlAcceso/cancelar.htm');
	});
	
});
</script>
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>

<form:form method="POST" commandName="activacion" action="controlAcceso/guardaPregSecreta.htm">
<form:hidden path="contrato" id="contrato" />
<form:hidden path="serialToken" id="serialToken" />

  <div class="aviso"><div class="container">

    <h3 align="center"><span class="op50"><spring:message code="afirmenet.activacion"/></span> <br> <strong><spring:message code="afirmenet.pregunta"/></strong></h3>

    <div class="login">

      <div class="relative clearfix mb10">
        <div class="col10 off1 xs-left" align="center"><h6 class="f-negro"><spring:message code="afirmenet.porfavor"/></h6></div>
        <a class="ayuda">?</a>
      </div>

      <div class="campo z10">
        <div class="label"><label><spring:message code="afirmenet.preguntaSecreta"/></label></div>
        <div class="input">
        
          <select name="pregunta" class="drop req">
            <option value=""><spring:message code="afirmenet.seleccione"/></option>
            <c:forEach var="pregunta" items="${listadoPreguntas}">
            <option value="${pregunta.idPregunta}">${pregunta.pregunta}</option>
            </c:forEach>
          </select>
          
        </div>
      </div>

      <div class="campo">
        <div class="label"><label><spring:message code="afirmenet.respuesta"/></label></div>
        <div class="input"><input name="respuesta" id="respuesta" class="bgbco" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;&bull;"><a class="ayuda">?</a></div>
      </div>

      <div class="campo">
        <div class="label"><label><spring:message code="afirmenet.confirmar"/></label></div>
        <div class="input"><input name="confirmar" id="confirmar" class="bgbco" type="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;&bull;"><a class="ayuda">?</a></div>
      </div>

      <div align="center" class="flex pt10">
        <button class="btn sec mr20"><spring:message code="afirmenet.cancelar"/></button>
        <button class="btn verde"><spring:message code="afirmenet.continuar"/></button>
      </div>
      
    </div>

  </div></div>

</form:form>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>