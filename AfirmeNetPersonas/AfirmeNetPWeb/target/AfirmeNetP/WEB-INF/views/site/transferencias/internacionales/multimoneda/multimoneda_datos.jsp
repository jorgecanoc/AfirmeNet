<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$(document).ready(function() {
	
		checkTransferType();
		
		// Radio
		$('.radio').click(function() {
			checkTransferType();
		});
		
		// Checkboxes
		$('.cbox').click(function() {
			if ($(this).is(':checked')) {
				$(this).parent().next().slideDown();
				$('#cuentaIntermediario').prop('disabled', false);
			} else {
				$(this).parent().next().slideUp();
				$('#cuentaIntermediario').prop('disabled', true);
			}
		});
		
		// Dropdown
		$('.drop').dropkick({
			mobile : true
		});
		
		$('#destino').dropkick({
			mobile : true,
			change: function() {
				$.ajax({
					url: '${context}/transferencias/multimoneda/get_cuenta_swift.json',
					method: 'POST',
					data: { cuentaDestino: this.value },
					success: function(response) {
					
						console.log(response);
					
						var SWIFT = response.transferencia.codigoSWIFT;
						var ABA = response.transferencia.codigoABA;
						
						if (SWIFT != null) {
							$('#radio1').prop('checked', true);
							$('.cbox').prop('disabled', false);
						}
						if (ABA != null) {
							$('#radio2').prop('checked', true);
							$('.cbox').prop('disabled', true);
							if ($('.cbox').is(':checked')) {
								$('.cbox').prop('checked', false);
								$('.cbox').parent().next().slideUp();
							}
						}
							
						checkTransferType();
						
						if (SWIFT != null) {
							$('#bancoSWIFT').val(response.transferencia.bankName);
							$('#bancoABA').val('');
						}
						if (ABA != null) {
							$('#bancoSWIFT').val('');
							$('#bancoABA').val(response.transferencia.bankName);
						}
						
						$('#tipoCodigo').val(response.transferencia.tipoCodigo);
						$('#swift').val(response.transferencia.codigoSWIFT);
						$('#aba').val(response.transferencia.codigoABA);
						$('#plaza').val(response.transferencia.plazaReceiving);
						$('#instruccion').val(response.transferencia.narrative);
						$('#email').val(response.transferencia.email);
					}				
				});
			}
		});
		
		$('a.btn.atras').click(function() {
			submitFormAnimate($('#transferencia').attr('id'), 'transferencias/multimoneda/multimoneda.htm');
		});
		
		$('a.btn.verde').click(function() {
			if (validForm($('#transferencia').attr('id')))
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
	
	function disableChildElements(elementID) {
		$inputElements = $(elementID + ' :input');
		$.each($inputElements, function(index, element) {
			$(element).prop('disabled', true);
		});
	}
	
	function enableChildElements(elementID) {
		$inputElements = $(elementID + ' :input');
		$.each($inputElements, function(index, element) {
			$(element).prop('disabled', false);
		});
	}
	
	function checkTransferType() {
		if ($('#radio1').is(':checked')) {
			$('#tab-swift').show();
			enableChildElements('#tab-swift');
			$('#tab-aba').hide();
			disableChildElements('#tab-aba');
		}
		if ($('#radio2').is(':checked')) {
			$('#tab-swift').hide();
			disableChildElements('#tab-swift');
			$('#tab-aba').show();
			enableChildElements('#tab-aba');
		}
	}
</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
        <%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido">

          <div class="p20 pb0">
          
          	<form:form commandName="transferencia" method="POST" action="transferencias/multimoneda/confirmacion.htm">

            <h3 class="titulo"><spring:message code="afirmenet.transferencias.multimoneda.titulo"/></h3>
			<p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
          
			<a href="${context}/transferencias/multimoneda/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
			<div class="ovhidden mb30"><div class="pasos">
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
				<span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
				<span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
			</div></div>

            <div class="row mb20">
              <div class="col3 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.captura"/></h3></div>
              <div class="col6 xs-break"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO">*</span></h6></div>
            </div>

            <div class="bbot2">

              <div class="row">

                <div class="col6 xs-break">

                  <div class="mb20">
                    <p class="h6"><spring:message code="afirmenet.transferencias.origen"/></p>
                    <form:select id="origen" path="origen.number" cssClass="drop req">
	                	<option value ="">Seleccionar Cuenta</option>
	                	<c:forEach var="cuentaPropia" items="${cuentasOrigen}">
	                	<option value="${cuentaPropia.number}">
	                		${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} - ${cuentaPropia.ccy}
	               		</option>
	                	</c:forEach>
	                </form:select>
                  </div>

                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.importe"/>:</strong></h6>
                    <p class="h6 f-verdeO">$ ${transferencia.amountFormatted}</p>
                  </div>

                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.moneda"/>:</strong></h6>
                    <p class="h6 f-verdeO">${transferencia.descMoneda}</p>
                  </div>

                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.cambio"/>:</strong></h6>
                    <p class="h6 f-verdeO">$ ${transferencia.tipoCambioFormatted} USD</p>
                  </div>

                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.usd"/>:</strong></h6>
                    <p class="h6 f-verdeO">$ ${transferencia.divisaVentaFormatted} USD</p>
                  </div>
                  
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.conversion"/>:</strong></h6>
                    <p class="h6 f-verdeO">
                    $ ${transferencia.amountFormatted} USD<br/>
                    $ ${transferencia.conversionFormatted} MXP</p>
                  </div>

                </div>

                <div class="col6 xs-break">

                  <div class="mb20">
                    <p class="h6"><spring:message code="afirmenet.transferencias.destino"/></p>
                    <form:select id="destino" path="destino.number" cssClass="req">
                		<option value ="">Seleccionar Cuenta</option>
	                	<c:forEach var="cuentaSWIFT" items="${cuentasDestino}">
	                	<option value="${cuentaSWIFT.creditAccount}">
	                		<c:if test="${not empty cuentaSWIFT.codigoABA}">
                			${cuentaSWIFT.creditAccount} (${cuentaSWIFT.codigoABA}) - ${cuentaSWIFT.bankName}
	               			</c:if>
	               			<c:if test="${not empty cuentaSWIFT.codigoSWIFT}">
	                		${cuentaSWIFT.creditAccount} (${cuentaSWIFT.codigoSWIFT}) - ${cuentaSWIFT.bankName}
	               			</c:if>
	               		</option>
	                	</c:forEach>
	               	</form:select>
                  </div>
                  
                  <div class="mb20">
                    <input type="checkbox" id="check1" name="intermediario" class="cbox" />
                    <label for="check1"><spring:message code="afirmenet.transferencias.multimoneda.intermediario"/></label>
                  </div>

                  <div class="pt5" style="display: none;">

                    <fieldset class="mb30">
                      <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.cuentas"/><span class="f-verdeO">*</span></label>
	                    <form:select id="cuentaIntermediario" path="intermediarioCuenta" cssClass="drop req">
	                		<option value ="">Seleccionar Cuenta</option>
		                	<c:forEach var="intermediario" items="${cuentasIntermediario}">
		                	<option value="${intermediario.creditAccount}">
		                		<c:if test="${not empty intermediario.codigoABA}">
		                			${intermediario.creditAccount} (${intermediario.codigoABA}) - ${intermediario.bankName}
		               			</c:if>
		               			<c:if test="${not empty intermediario.codigoSWIFT}">
		                			${intermediario.creditAccount} (${intermediario.codigoSWIFT}) - ${intermediario.bankName}
		               			</c:if>
		               		</option>
		                	</c:forEach>
		               	</form:select>
                    </fieldset>

                  </div>
                  
                  <fieldset class="mb15">
                    <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.beneficiario"/><span class="f-verdeO">*</span></label>
                    <div class="form-input w100 relative">
                      <spring:message code="afirmenet.transferencias.multimoneda.beneficiario.placeholder" var="nombreBeneficiario"/>
                      <input name="beneficiaryName" placeholder="${nombreBeneficiario}" type="text" class="req">
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.beneficiaryName"/></span>
                  </a> 
                    </div>
                  </fieldset>

                  <div class="clearfix mb10">
                    <input type="radio" id="radio1" name="radio" class="radio" disabled="disabled" checked>
                    <label for="radio1"><span class="h6"><spring:message code="afirmenet.transferencias.multimoneda.fuera"/></span><br>
                    <span class="f14"><span class="f-verdeO"><spring:message code="afirmenet.transferencias.multimoneda.swift"/></span><spring:message code="afirmenet.transferencias.multimoneda.internacional"/></span></label>
                  </div>
                  <div class="clearfix mb30">
                    <input type="radio" id="radio2" name="radio" class="radio" disabled="disabled">
                    <label for="radio2"><span class="h6"><spring:message code="afirmenet.transferencias.multimoneda.hacia"/></span><br>
                    <span class="f14"><span class="f-verdeO"><spring:message code="afirmenet.transferencias.multimoneda.aba"/></span><spring:message code="afirmenet.transferencias.multimoneda.routing"/></span></label>
                  </div>

                  <p class="f21 f-gris5"><strong><spring:message code="afirmenet.transferencias.multimoneda.destino"/></strong></p>

                  <div id="tab-swift">
                    <fieldset class="mb15">
                      <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.codigoswift"/><span class="f-verdeO">*</span></label>
                      <div class="form-input w100 relative">
                        <spring:message code="afirmenet.transferencias.multimoneda.codigoswift" var="codigoSwift"/>
                      	<form:input path="codigoSWIFT" id="swift" placeholder="${codigoSwift}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.codigoSWIFT"/></span>
                  </a> 
                      </div>
                    </fieldset>

                    <fieldset class="mb15">
                      <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.banco"/><span class="f-verdeO">*</span></label>
                      <div class="form-input w100 relative">
                      	<spring:message code="afirmenet.transferencias.multimoneda.banco.placeholder" var="nombreBanco"/>
                        <form:input path="bankName" id="bancoSWIFT" placeholder="${nombreBanco}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.bankName"/></span>
                  </a> 
                      </div>
                    </fieldset>

                    <fieldset class="mb15">
                      <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.plaza"/><span class="f-verdeO">*</span></label>
                      <div class="form-input w100 relative">
                      	<spring:message code="afirmenet.transferencias.multimoneda.plaza.placeholder" var="nombrePlaza"/>
                        <form:input path="plazaReceiving" id="plaza" placeholder="${nombrePlaza}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.plazaReceiving"/></span>
                  </a> 
                      </div>
                    </fieldset>
                  </div>

                  <div id="tab-aba">
                    <fieldset class="mb15">
                      <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.codigoaba"/><span class="f-verdeO">*</span></label>
                      <div class="form-input w100 relative">
                      	<spring:message code="afirmenet.transferencias.multimoneda.codigoaba.placeholder" var="codigoAba"/>
                      	<form:input path="codigoABA" id="aba" placeholder="${codigoAba}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.codigoABA"/></span>
                  </a> 
                      </div>
                    </fieldset>

                    <fieldset class="mb15">
                      <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.banco"/><span class="f-verdeO">*</span></label>
                      <div class="form-input w100 relative">
                      	<spring:message code="afirmenet.transferencias.multimoneda.banco.placeholder" var="nombreBanco"/>
                        <form:input path="bankName" id="bancoABA" placeholder="${nombreBanco}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.bankName"/></span>
                  </a> 
                      </div>
                    </fieldset>
                  </div>

                  <p class="f21 f-gris5"><strong><spring:message code="afirmenet.transferencias.multimoneda.datos"/></strong></p>
                  <fieldset class="mb15">
                    <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.instruccion"/><span class="f-verdeO">*</span></label>
                    <div class="form-input w100 relative">
                      <spring:message code="afirmenet.transferencias.multimoneda.instruccion.placeholder" var="instrucciones"/>
                      <textarea name="narrative" id="instruccion" placeholder="${instrucciones}" class="req"></textarea>
                    </div>
                  </fieldset>

                  <fieldset class="mb30">
                    <label for="importe"><spring:message code="afirmenet.transferencias.multimoneda.email"/></label>
                    <div class="form-input w100 relative">
                      <spring:message code='afirmenet.transferencias.multimoneda.email.placeholder' var="email"/>
                      <input name="email" placeholder="${email}" type="email">
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transmultim.email"/></span>
                  </a> 
                    </div>
                  </fieldset>

                </div>

              </div>

            </div>
            
            </form:form>

          </div>

          <div class="p20">

            <div class="row acciones">
              <div class="col6 xs-break xs-center xs-mb20"><a class="btn gris">
              <span class="icon icon-plus"></span><spring:message code="afirmenet.botones.agregarcuenta1"/><spring:message code="afirmenet.botones.agregarcuenta2"/></a>
              </div>
              <div class="col6 xs-break xs-center" align="right">
                <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras"/></a>
                <a href="#" class="btn verde"><spring:message code="afirmenet.botones.continuar"/></a>
              </div>
            </div>

          </div>

        </div></div>

    </article>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>