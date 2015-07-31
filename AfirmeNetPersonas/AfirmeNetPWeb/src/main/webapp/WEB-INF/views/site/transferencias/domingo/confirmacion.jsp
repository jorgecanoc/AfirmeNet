<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/dropkick.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/edocuenta.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<c:url value="/resources/js/vendor/modernizr-2.6.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/dropkick.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>

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
          
			<form:form commandName="transferencia" method="POST" action="${context}/transferencias/terceros/realizarTransferencia.htm">

            <h3 class="titulo"><spring:message code="afirmenet.transferencias.domingo.titulo" /></h3>
            <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>     

            <a href="#" class="cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
	             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
	             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
	             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
	             <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            </div></div>

            <div class="mb30">
              <h3 class="f-verdeO"><spring:message code="afirmenet.confirmar"/></h3>
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
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></h6>
                  <!-- TODO formatear AMOUNT -->
                  <p class="h6 f-verdeO">$${transferencia.amount}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></h6>
                  <p id="concepto" class="h6 f-verdeO">${transferencia.description}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.programada"/></strong></h6>
                  <p class="h6">
                    <spring:message code="afirmenet.comprobantes.dias"/> <span class="f-verdeO">${dias}</span><br>
                    <spring:message code="afirmenet.comprobantes.hora"/> <span class="f-verdeO">${hora} hrs</span><br>
                    <spring:message code="afirmenet.comprobantes.fechaInicio"/> <span class="f-verdeO">${fechaInicio}</span><br>
                    <spring:message code="afirmenet.comprobantes.fechaFin"/> <span class="f-verdeO">${fechaFin}</span>                  	
                  </p>
                </div>

            </div>
          </div>

          	<div class="bgcrema p20">

            <p class="f21 mb20"><strong class="f-gris6"><spring:message code="afirmenet.transferencias.pregunta.finalizar"/></strong></p>
            <div class="row">

              <div class="col6 xs-break xs-mb20">
                <p class="h6 mb5 f-gris6"><spring:message code="afirmenet.transferencias.clave.dinamica"/></p>
                <div class="relative input">
                  <spring:message code="afirmenet.contrato.placeHolder" var="passwordHolder"/>
                  <input name="token" maxlength="6" placeholder="${passwordHolder}" type="password">
                  <a class="ayuda">?</a>
                </div>
              </div>

              <div class="col6 xs-break">
                <p class="h6 mb5">&nbsp;</p>
		            <div class="acciones" align="right">
		              <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
		                              <button onclick="submitFormAnimate('transferencia','transferencias/domingo/ejecutar.htm'); return false;"
						class="btn verde"><spring:message code="afirmenet.botones.aceptar" /></button>
		            </div>          
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