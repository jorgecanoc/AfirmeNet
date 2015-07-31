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
				$('.favorita .f21').html('<spring:message code="afirmenet.favoritas.pregunta"/>');
			}
		});
		
		$('a.btn.atras').click(function() {
			submitFormAnimate($('#transferencia').attr('id'), 'transferencias/multimoneda/ingreso_datos.htm');
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
          
          	<form id="transferencia" method="POST" action="transferencias/multimoneda/comprobante.htm">
          
            <h3 class="titulo"><spring:message code="afirmenet.transferencias.multimoneda.titulo"/></h3>
			<p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
          
			<a href="${context}/transferencias/multimoneda/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
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
                  ${transferencia.destino.number}
                  </p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${transferencia.amountFormatted}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.moneda"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.descMoneda}</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.cambio"/>:</strong></h6>
                  <p class="h6 f-verdeO">$ ${transferencia.divisaVentaFormatted}</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.conversion"/>:</strong></h6>
                  <p class="h6 f-verdeO">
                  $ ${transferencia.montoUSDFormatted} ${transferencia.currency}<br/>
                  $ ${transferencia.montoConversionFormatted} ${transferencia.origen.ccy}
                  </p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.comision"/>:</strong></h6>
                  <p class="h6 f-verdeO">$ ${transferencia.commissionFormatted} ${transferencia.currency} + IVA</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.beneficiario"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.beneficiaryName}</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.tipotransfer"/>:</strong></h6>
                  <p class="h6 f-verdeO">
                  <c:if test="${not empty transferencia.codigoABA}">
                  <spring:message code="afirmenet.transferencias.multimoneda.hacia"/>
                  </c:if>
                  <c:if test="${not empty transferencia.codigoSWIFT}">
                  <spring:message code="afirmenet.transferencias.multimoneda.fuera"/>
                  </c:if>
                  </p>
                </div>

				<c:if test="${not empty transferencia.codigoSWIFT}">
				<div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.swift"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.codigoSWIFT}</p>
                </div>
                
				</c:if>
				<c:if test="${not empty transferencia.codigoABA}">
				<div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.aba"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.codigoABA}</p>
                </div>
				</c:if>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.banco"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.bankName}</p>
                </div>

                <c:if test="${not empty transferencia.plazaReceiving}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.plaza"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.plazaReceiving}</p>
                </div>
                </c:if>

                <c:if test="${not empty transferencia.narrative}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.instruccion"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.narrative}</p>
                </div>
                </c:if>
                
                <c:if test="${not empty transferencia.email}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.email"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.email}</p>
                </div>
                </c:if>

              </div>

            </div>
            
            </form>
            
          </div>

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
          </div>

        </div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>