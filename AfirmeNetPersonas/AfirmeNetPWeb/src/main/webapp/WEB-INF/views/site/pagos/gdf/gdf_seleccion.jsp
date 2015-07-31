<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/js/afirmenet/jquery.maskMoney.js"/>"></script>

<script type="text/javascript">
$(document).ready(function() {

	// Dropdown
	$('.drop').dropkick({
		mobile : true,
		change : function() {
			$(this.data.elem).find('.dk-selected').addClass('f-verde');
		}
	});
	
	$('a.btn.verde').click(function() {
		if (validForm('pago'))
			fillSubmitForm();
	});
	// Permite pegar el codigo de Linea de Captura completo, distribuyendo los valores 
	// en cada uno de los input text
	$('input[name="claveLineaCaptura"]').on('paste',function(e) {
		var pasteData;
		try {
			pasteData = e.originalEvent.clipboardData.getData('text').toUpperCase();
		} catch(ex) {
			pasteData = window.clipboardData.getData("Text").toUpperCase();
		}
		if (pasteData.length > 4) {
			splitLineaCaptura(pasteData);
			$('#amount').focus();
		} else {
			return true;
		}
		return false;
	});
	// Permite solo letras y numeros. Delimita a 4 caracteres por input text
	$('input[name="claveLineaCaptura"]').keypress(function(key) {
		
		var code = key.keyCode;
		var chCode = key.charCode;
		var keyInput = String.fromCharCode(key.which).toUpperCase();
		// Permite backspace, flechas izq, der, inicio y fin
		if (code == 8 || code == 9 || (code >= 35 && code <= 40)) {
			// Permite que la tecla Backspace pueda borrar el contenido de los inputbox anteriores al cursor
			if (code == 8 && this.value.length == 0) {
				var inputID = Number(this.id.substring(this.id.length-1));
				if (inputID > 1) {
					var previousInput = '#' + this.name + (inputID - 1);
					$(previousInput).focus();
				}
			}
			return true;
		}
		// Acepta solo letras y numeros
		if ((chCode >= 48 && chCode <= 57) || (chCode >= 65 && chCode <= 90) || (chCode >= 97 && chCode <= 122)) {
			// Si se intruduce mas de 4 caracteres, se comienza a escribir en el siguiente inputbox
			if ((this.value.length + 1) > 4) {
				
				var inputID = Number(this.id.substring(this.id.length-1));
				if (inputID < 5) {
					var selector = '#' + this.name + (inputID + 1);
					
					if ($(selector).val() == '') {
						$(selector).val(keyInput);
						$(selector).focus();
						$(selector).setCursorPosition(1);
					} else {
						$(selector).focus();
						if ($(selector).val().length < 4)
							$(selector).val(keyInput + $(selector).val());
						else
							$(selector).setCursorPosition($(selector).val().length);
					}
				}
				return false;
			}
			// Acepta Copy + Paste
			if (key.ctrlKey && key.charCode == 118)
				return true;
			else {
				$(this).val(function(_, value) {
					return value + keyInput;
				});
				return false;
			}
			
			return true;
			
		} else
			return false;
	});
	// Posiciona el cursor dado el numero de caracteres
	$.fn.setCursorPosition = function(pos) {
		this.each(function(index, elem) {
			if (elem.setSelectionRange) {
				elem.setSelectionRange(pos, pos);
			} else if (elem.createTextRange) {
				var range = elem.createTextRange();
				range.collapse(true);
				range.moveEnd('character', pos);
				range.moveStart('character', pos);
				range.select();
			}
		});
		return this;
	};

	$('.modal').fancybox({
		maxWidth : 600,
		maxHeight : 450,
		autoHeight : true,
		fitToView : false,
		padding : 0
	});
	
	$('#amount').keypress(function(key) {
		if (key.which == 13)
			if (validForm('pago'))
				fillSubmitForm()
	});
	
	$('#reset').click(function() {
		$('#claveLineaCaptura1').val('');
		$('#claveLineaCaptura2').val('');
		$('#claveLineaCaptura3').val('');
		$('#claveLineaCaptura4').val('');
		$('#claveLineaCaptura5').val('');
		$('#lineaCaptura').val('');
	});
	
	var warning = '${not empty error}';
	if (warning) {
		$('.notificacion.advertencia').hide();
		$('.notificacion.advertencia').removeClass('hidden');
		$('.notificacion.advertencia').slideDown();
	}
	
	var lineaCaptura = '${pago.lineaCaptura}';
	if (lineaCaptura != "") {
		splitLineaCaptura(lineaCaptura);
	}
	
	var amount = '${pago.amount}';
	if (amount > 0)
		$('#amount').val(amount);
	else
		$('#amount').val('');
	
	// Formato de moneda al importe
	//$('#amount').maskMoney();
});

function fillSubmitForm() {
	var captura1 = $('#claveLineaCaptura1').val();
	var captura2 = $('#claveLineaCaptura2').val();
	var captura3 = $('#claveLineaCaptura3').val();
	var captura4 = $('#claveLineaCaptura4').val();
	var captura5 = $('#claveLineaCaptura5').val();
	$('#lineaCaptura').val(captura1 + captura2 + captura3 + captura4 + captura5);
	
	submitFormAnimate('pago', $('#pago').attr('action'));
}

function splitLineaCaptura(lineaCaptura) {
	var pasteArray = lineaCaptura.match(/.{1,4}/g);
	$('#claveLineaCaptura1').val(pasteArray[0]);
	$('#claveLineaCaptura2').val(pasteArray[1]);
	$('#claveLineaCaptura3').val(pasteArray[2]);
	$('#claveLineaCaptura4').val(pasteArray[3]);
	$('#claveLineaCaptura5').val(pasteArray[4]);
}

</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
      	<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido">
        
          <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>
        
          <form:form commandName="pago" method="POST" action="pagos/gdf/ingreso_datos.htm">
          <form:hidden path="lineaCaptura" />
          
          <c:if test="${not empty error}">
          <div class="notificacion advertencia hidden">
            <a class="icon icon-close2"></a>
            <div class="clearfix"><span class="icon icon-warning"></span>
            <p class="f21 m0">${error}</p>
            </div>
          </div>
          </c:if>

          <div class="p20 bbot2">

            <h3 class="titulo"><spring:message code="afirmenet.pagos.gdf.titulo"/></h3>
            <p>Horario de Servicio: <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

            <a href="${context}/pagos/gdf/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            </div></div>

            <div class="clearfix mb10">
              <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
            </div>

            <div class="clearfix mb20">
              <div class="fL mr20"><img src="<c:url value="/resources/img/icons/gdf.png"/>" alt="Ciudad de México"></div>
              <div class="">
                <p><spring:message code="afirmenet.pagos.gdf.instruccion1"/></p>
                <p><spring:message code="afirmenet.pagos.gdf.instruccion2"/></p>
              </div>
            </div>

            <div class="mb20">
              <h6 class="mb5"><spring:message code="afirmenet.transferencias.origen"/></h6>
              
              <form:select path="origen.number" cssClass="drop req">
              	<option value=""><spring:message code="afirmenet.transferencias.seleccionar"/></option>
              	<c:forEach var="cuenta" items="${cuentasPropias}">
              	<option value="${cuenta.number}">
              	${cuenta.description} (${cuenta.numberMask}) - $${cuenta.balanceFormatted} - ${cuenta.ccy}
              	</option>
              	</c:forEach>
              </form:select>
              
            </div>

          </div>

          <div class="p20 bbot2">

            <fieldset>
              <div class="form-label"><label for="lineaCaptura"><spring:message code="afirmenet.pagos.gdf.lineaCaptura"/></label></div>
              <div class="form-input w70">
                <div class="clearfix">
                  <div class="form-input fL w20 pr20">
                    <input name="claveLineaCaptura" id="claveLineaCaptura1" type="text">
                  </div>
                  <div class="form-input fL w20 pr20">
                    <input name="claveLineaCaptura" id="claveLineaCaptura2" type="text">
                  </div>
                  <div class="form-input fL w20 pr20">
                    <input name="claveLineaCaptura" id="claveLineaCaptura3" type="text">
                  </div>
                  <div class="form-input fL w20 pr20">
                    <input name="claveLineaCaptura" id="claveLineaCaptura4" type="text">
                  </div>
                  <div class="form-input fL w20 pr20">
                    <input name="claveLineaCaptura" id="claveLineaCaptura5" type="text" maxlength="4">
                  </div>
                </div>
              </div>
              <a class="icon icon-close2" id="reset"></a>
            </fieldset>
            
            <fieldset>
              <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.importe"/></label></div>
              <div class="form-input relative importe">
                <strong>$</strong>
                <spring:message code="afirmenet.placeholder.importe" var="amountPlaceholder"/>
                <form:input path="amount" placeholder="${amountPlaceholder}" cssClass="req onlyNum"/>
              </div>
            </fieldset>

          </div>

          <div class="p20">
            <div class="acciones" align="right">
              <a href="${context}/pagos/gdf/cancelar.htm" data-fancybox-type="iframe" class="modal btn atras mr10"><spring:message code="afirmenet.botones.atras"/></a>
              <a href="#" class="btn verde"><spring:message code="afirmenet.continuar"/></a>
            </div>
          </div>
          
          </form:form>

        </div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>