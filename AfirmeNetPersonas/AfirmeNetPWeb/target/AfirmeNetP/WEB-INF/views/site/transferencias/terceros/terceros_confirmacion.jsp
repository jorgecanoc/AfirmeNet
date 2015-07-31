<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function() {
	// Checkboxes
	$('.favorita .cbox').click(function() {
		if ($(this).is(':checked')) {
			$('.favorita').addClass('act');
			$('.favorita .f21').html(
				$('#concepto').html());
		} else {
			$('.favorita').removeClass('act');
			$('.favorita .f21').html('¿Guardar como una operación favorita?');
		}
	});
	
	$('a.btn.verde').click(function() {
		submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
	});
	
	$('a.btn.atras').click(function() {
		submitFormAnimate($('#transferencia').attr('id'), 'transferencias/terceros/ingreso_datos.htm');
	});
	
	$('.modal').fancybox({
		maxWidth : 600,
		maxHeight : 450,
		autoHeight : true,
		fitToView : false,
		padding : 0
	});
});
</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
        <%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido">

          <div class="p20">
          
			<form:form commandName="transferencia" method="POST" action="transferencias/terceros/realizarTransferencia.htm">

			<h3 class="titulo"><spring:message code="afirmenet.transferencias.terceros.titulo" /></h3>
          	<p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
          	
          	<a href="${context}/transferencias/terceros/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
	        <div class="ovhidden mb30"><div class="pasos">
	          <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
	          <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
	          <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
	          <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
	        </div></div>

            <div class="mb30">
              <h3 class="f-verdeO"><spring:message code="afirmenet.transferencias.paso.confirmar"/></h3>
            </div>

            <div class="row">

              <div class="col6 xs-break">

                <div class="mb20">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                  <p class="h6 f-verdeO">
                  ${transferencia.origen.description} (${transferencia.origen.numberMask}) - $${transferencia.origen.balanceFormatted} - ${transferencia.origen.ccy}
                  </p>
                </div>

              </div>

              <div class="col6 xs-break">

                <div class="mb15">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                  <p class="h6 f-verdeO">
                  ${transferencia.destino.description} (${transferencia.destino.numberMask}) - ${transferencia.bankReceiving}
                  </p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.importe"/>:</strong></h6>
                  <!-- TODO formatear AMOUNT -->
                  <p class="h6 f-verdeO">$ ${transferencia.amount}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.concepto"/>:</strong></h6>
                  <p id="concepto" class="h6 f-verdeO">${transferencia.description}</p>
                </div>

                <c:if test="${not empty transferencia.userReference}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.referencia"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.userReference}</p>
                </div>
                </c:if>

                <c:if test="${not empty transferencia.emailBeneficiary}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.email"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.emailBeneficiary}</p>
                </div>
                </c:if>

            </div>
          </div>

          <div class="favorita p20"><div class="row">

            <div class="col8 xs-break xs-mb20">
              <div class="clearfix">
                <span class="icon icon-star-full f42 mr10 fL"></span>
                <p class="fL m0 mt5"><strong class="h6"><spring:message code="afirmenet.favoritas"/></strong><br><span class="f21"><spring:message code="afirmenet.favoritas.pregunta"/></span></p>
              </div>
            </div>

            <div class="col4 xs-break mt15">
              <input type="checkbox" id="check1" name="datos" class="cbox f-bco" />
              <label for="check1"><spring:message code="afirmenet.favoritas.guardar"/></label>           
            </div>

          </div></div>

          <div class="bgcrema p20">

            <p class="f21 mb20"><strong class="f-gris6"><spring:message code="afirmenet.transferencias.pregunta.finalizar"/></strong></p>
            <div class="row">

              <div class="col6 xs-break xs-mb20">
                <p class="h6 mb5 f-gris6"><spring:message code="afirmenet.transferencias.clave.dinamica"/></p>
                <div class="relative input">
                  <input name="token" maxlength="6" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;" type="password">
                  <a class="ayuda">?</a>
                </div>
              </div>

              <div class="col6 xs-break">
                <p class="h6 mb5">&nbsp;</p>
                <div class="acciones" align="right">
                  <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras"/></a>
                  <a href="#" class="btn verde"><spring:message code="afirmenet.botones.aceptar"/></a>
                </div>           
              </div>

            </div>
            
            </form:form>
            
          </div>

        </div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>