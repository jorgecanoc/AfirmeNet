<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/js/afirmenet/jquery.maskMoney.js"/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
	
		checkTransferType();
		
		// Radio
		$('.radio').click(function() {
			checkTransferType();
		});

		// Checkboxes
		$('.cbox').click(function() {
			if ($(this).is(':checked'))
				$(this).parent().parent().next().slideDown();
			else
				$(this).parent().parent().next().slideUp();
		});

		$(document).on('touchstart', function(e) {
			var $clicked = $(e.target);
			if (!$clicked.parents().hasClass("pika-single")
					&& !$clicked.hasClass("pika-single")) {
				$('.pika-single').addClass('is-hidden');
			}
		});

		// Dropdown
		$('.drop').dropkick({
			mobile : true
		});
		
		$('a.btn.atras').click(function() {
			submitFormAnimate($('#transferencia').attr('id'), 'transferencias/dolares/dolares.htm');
		});

		$('a.btn.verde').click(function() {
			if (validForm($('#transferencia').attr('id'))) {
				var amount = $('#importe').val().replace(/,/g, '');
				$('#importe').val(amount);
				submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
			}
		});
		
		$('.modal').fancybox({
			maxWidth : 600,
			maxHeight : 450,
			autoHeight : true,
			fitToView : false,
			padding : 0
		});
		
		// Formato de moneda al importe
		$('#importe').maskMoney();
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

          <div class="p20">
          
          	<form:form commandName="transferencia" method="POST" action="transferencias/dolares/confirmacion.htm">

            <h3 class="titulo"><spring:message code="afirmenet.transferencias.dolares.titulo"/></h3>
            <p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
            
            <a href="${context}/transferencias/dolares/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            </div></div>

            <div class="row mb20">
              <div class="col4 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.transferencias.dolares.informacion"/></h3></div>
              <div class="col4 xs-break xs-mb20"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO">*</span></h6></div>
              <div class="col4 xs-break">
                <label class="ribbon r-verde f15"><spring:message code="afirmenet.transferencias.dolares.dolar"/> = $${transferencia.divisaVentaFormatted} <spring:message code="afirmenet.transferencias.dolares.pesos"/></label>
              </div>
            </div>

            <div class="mb30">

              <fieldset>
                <div class="form-label w33"><label for="importe"><spring:message code="afirmenet.transferencias.dolares.importe"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative importe">
                  <strong>$</strong>
                  <spring:message code="afirmenet.transferencias.importe.placeholder" var="importe"/>
                  <input name="amount" id="importe" placeholder="${importe}" type="text" class="req onlyNum"/>
                   <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.importe"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"><label for="nombre"><spring:message code="afirmenet.transferencias.dolares.beneficiario"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.dolares.beneficiario.placeholder" var="beneficiario"/>
                  <input name="beneficiaryName" id="nombre" placeholder="${beneficiario}" type="text" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.beneficiaryName"/></span>
                  </a> 
                </div>
              </fieldset>

            </div>

            <p class="f21 f-gris5"><strong><spring:message code="afirmenet.transferencias.dolares.tipo"/></strong></p>
            <div class="row mb20">
              <div class="col6 xs-break">
                <div class="radio-wrap">
                
                  <c:choose>
                  	<c:when test="${not empty transferencia.codigoSWIFT}">
                  <input type="radio" id="radio1" name="radio" class="radio" disabled="disabled" checked>
                  	</c:when>
                  	<c:otherwise>
                  <input type="radio" id="radio1" name="radio" class="radio" disabled="disabled">
                  	</c:otherwise>
                  </c:choose>
                  
                  <label for="radio1"><span class="h6"><spring:message code="afirmenet.transferencias.dolares.fuera"/></span><br>
                  <span class="f14"><span class="f-verdeO"><spring:message code="afirmenet.transferencias.dolares.swift"/></span><spring:message code="afirmenet.transferencias.dolares.internacional"/></span></label>
                </div>
              </div>
              <div class="col6 xs-break">
                <div class="radio-wrap">
                
                  <c:choose>
                  	<c:when test="${not empty transferencia.codigoABA}">
                  <input type="radio" id="radio2" name="radio" class="radio" disabled="disabled" checked>
                  	</c:when>
                  	<c:otherwise>
                  <input type="radio" id="radio2" name="radio" class="radio" disabled="disabled">
                  	</c:otherwise>
                  </c:choose>
                  
                  <label for="radio2"><span class="h6"><spring:message code="afirmenet.transferencias.dolares.hacia"/></span><br>
                  <span class="f14"><span class="f-verdeO"><spring:message code="afirmenet.transferencias.dolares.aba"/></span><spring:message code="afirmenet.transferencias.dolares.routing"/></span></label>
                </div>
              </div>
            </div>

            <div id="tab-swift">
              
              <fieldset>
                <div class="form-label w33"><label for="swift"><spring:message code="afirmenet.transferencias.dolares.codigoswift"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.dolares.codigoswift.placeholder" var="codigoSwift"/>
                  <form:input path="codigoSWIFT" id="swift" placeholder="${codigoSwift}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.codigoSWIFT"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"><label for="banco"><spring:message code="afirmenet.transferencias.dolares.banco"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.dolares.nombre.placeholder" var="nombreBanco"/>
                  <form:input path="bankName" id="banco" placeholder="${nombreBanco}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.bankName"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"><label for="plaza"><spring:message code="afirmenet.transferencias.dolares.plaza"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.dolares.nombre.placeholder" var="plaza"/>
                  <form:input path="plazaReceiving" id="plaza" placeholder="${plaza}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.plazaReceiving"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33 vat"><label for="instruccion"><spring:message code="afirmenet.transferencias.dolares.instruccion"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <textarea name="narrative" id="instruccion" class="req"></textarea>
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"><label for="email"><spring:message code="afirmenet.transferencias.dolares.email"/></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.dolares.email.placeholder" var="email"/>
                  <input name="email" placeholder="${email}" type="email">
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.email"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"></div>
                <div class="form-input relative">
                  <input type="checkbox" id="check1" name="intermediario" class="cbox mb-10" />
                  <label for="check1"><spring:message code="afirmenet.transferencias.dolares.intermediario"/></label>
                </div>
              </fieldset>

              <div style="display: none;">
              
              	<fieldset class="mb30">
              	<form:select id="intermediario" path="intermediarioCuenta" cssClass="drop req">
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
              
            </div>

            <div id="tab-aba" style="display: none;">

              <fieldset>
                <div class="form-label w33"><label for="importe"><spring:message code="afirmenet.transferencias.dolares.codigoaba"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.dolares.codigoaba.placeholder" var="codigoAba"/>
                  <form:input path="codigoABA" id="ABA" placeholder="${codigoAba}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.codigoABA"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"><label for="importe"><spring:message code="afirmenet.transferencias.dolares.banco"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.dolares.nombre.placeholder" var="nombreBanco"/>
                  <form:input path="bankName" id="banco" placeholder="${nombreBanco}" type="text" readonly="true" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.bankName"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33 vat"><label for="importe"><spring:message code="afirmenet.transferencias.dolares.instruccion"/><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <textarea name="narrative" id="instruccion" placeholder="Escribir Instrucción" class="req"></textarea>
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"><label for="importe"><spring:message code="afirmenet.transferencias.dolares.email"/></label></div>
                <div class="form-input relative">
                  <input name="emailBeneficiary" placeholder="<spring:message code='afirmenet.transferencias.dolares.email.placeholder'/>" type="email">
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.email"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"></div>
                <div class="form-input relative">
                  <input type="checkbox" id="check1" name="intermediario" class="cbox mb-10" />
                  <label for="check1"><spring:message code="afirmenet.transferencias.dolares.intermediario"/></label>
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label w33"><label for="importe"><spring:message code="afirmenet.transferencias.dolares.clave"/></label></div>
                <div class="form-input relative">
                  <input name="clave" placeholder="<spring:message code="afirmenet.transferencias.dolares.clave.placeholder"/>" type="text">
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdolares.clave"/></span>
                  </a> 
                </div>
              </fieldset>

            </div>
            
            </form:form>

          </div>

          <div class="bgf1 p20">

            <div class="row">

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                <p>${transferencia.origen.description} (${transferencia.origen.numberMask}) - $${transferencia.origen.balanceFormatted} - ${transferencia.origen.ccy}</p>
              </div>

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                <p>
                <c:if test="${not empty transferencia.codigoABA}">
        		${transferencia.creditAccount} (${transferencia.codigoABA}) - ${transferencia.bankName}
       			</c:if>
       			<c:if test="${not empty transferencia.codigoSWIFT}">
        		${transferencia.creditAccount} (${transferencia.codigoSWIFT}) - ${transferencia.bankName}
       			</c:if>
				</p>          
              </div>
              
            </div>

          </div>

          <div class="p20">

            <div class="row acciones" align="right">
              <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras"/></a>
              <a href="#" class="btn verde"><spring:message code="afirmenet.continuar"/></a>
            </div>

          </div>

        </div></div>


    </article>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>