<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
$('document').ready(function() {

	$('#clave-transfer').focus();

	$('.notificacion .icon-close2').click(function(){ $(this).parent().slideUp(); });

	$('#clave-transfer').on('input', function() {
		if ($(this).val() != "")
			$('.acciones.hidden').removeClass('hidden');
		else
			$('.acciones').addClass('hidden');
	});
	
	$('#clave-transfer').keypress(function(key) {
		if (key.which == 13)
			submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
	});
	
	$('a.btn.verde').click(function() {
		submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
	});
	
	$('.modal').fancybox({
		maxWidth : 600,
		maxHeight : 450,
		autoHeight : true,
		fitToView : false,
		padding : 0
	});
	
	var warning = '{not empty claveError}';
	if (warning) {
		$('.notificacion.advertencia').hide();
		$('.notificacion.advertencia').removeClass('hidden');
		$('.notificacion.advertencia').slideDown();
	}
});
</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
        <%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido">
        
          <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>
        
          <c:if test="${claveError}">
          <div class="notificacion advertencia hidden">
            <a class="icon icon-close2"></a>
            <div class="clearfix"><span class="icon icon-warning"></span><p class="f21 m0">
            El número de clave no es válido.<br/>Para obtener la clave de tipo de cambio especial comuníquese al 01 800 2 AFIRME
            </p>
            </div>
          </div>
          </c:if>
            
          <div class="p20">
          
          <form:form commandName="transferencia" method="POST" action="transferencias/multimoneda/ingreso_datos.htm">

          <h3 class="titulo"><spring:message code="afirmenet.transferencias.multimoneda.titulo"/></h3>
          <p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
          
          <a href="${context}/transferencias/multimoneda/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

          <div class="row mb10">
            <div class="f-verdeO col11">
              <h3 class="m0"><spring:message code="afirmenet.transferencias.multimoneda.clave"/></h3>
              <p class="h6 op70"><spring:message code="afirmenet.transferencias.multimoneda.obtener"/><strong><spring:message code="afirmenet.transferencias.multimoneda.01800"/></strong></p>
            </div>  
            <div class="col1" align="right">
            <a href="#" class="icon icon-info fR tooltip">
            <span><span class="icon icon-close2"></span>
            	  <span class="h6"><strong><spring:message code="afirmenet.tooltip.transmultim.titulo"/></strong></span>
            	  <span><spring:message code="afirmenet.tooltip.transmultim.desc"/></span></span>
            </a>
          </div>
          </div>

          <div class="mb20">
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer"><spring:message code="afirmenet.transferencias.multimoneda.clave"/></label></div>
              <div class="form-input relative">
                <input name="claveTransferencia" class="f-verdeO" id="clave-transfer" placeholder="Clave de Transferencia" type="text">
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.clave"/></span>
                  </a>   
              </div>
            </fieldset>
          </div>

          <div class="acciones hidden" align="right"><div class="btop2 pt20">
            <a href="#" class="btn verde"><spring:message code="afirmenet.continuar"/></a>
          </div></div>
          
          </form:form>

        </div></div>

      </div>

    </article>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>