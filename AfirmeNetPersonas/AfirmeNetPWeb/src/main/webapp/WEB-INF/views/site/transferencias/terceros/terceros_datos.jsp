<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/afirmenet/jquery.maskMoney.js"/>"></script>

<script type="text/javascript">
$(document).ready(function() {

	// Agregar transacción
	$('#agregar-transaccion').click(function() {
		
		if (validForm($('#transferencia').attr('id'), '${context}/transferencias/propias/guarda_propias.htm')) {
			
			$('.btn-guardadas').removeClass('hidden').append(
				'<div class="tip"><div class="clearfix"><a class="icon icon-close2" id="close"></a><span class="icon icon-success f-lima"></span><p><strong class="f-lima">CORRECTO</strong><br>La operación se agrego a la lista</p></div></div>'
			).next().addClass('col11 xs-col10');
			
			$('html, body').stop().animate({scrollTop : 0}, 50, function() {
				$('.btn-guardadas').append('<span class="notificaciones">${listaSize + 1}</span>');
				$('.btn-guardadas .tip').slideDown();
				setTimeout(function() {
					$('.btn-guardadas .tip').slideUp();
					submitFormAnimate($('#transferencia').attr('id'), 'transferencias/terceros/agrega_transaccion');
				}, 2000);
			});
			
			$('.btn-guardadas .tip .icon-close2').click(function() {
				$('.btn-guardadas .tip').slideUp();
				submitFormAnimate($('#transferencia').attr('id'), 'transferencias/terceros/agrega_transaccion');
			});
			
			$(this).fadeOut();
		}
		
		return false;
	});

	// Checkboxes
	$('.cbox').click(function() {
		if ($(this).is(':checked'))
			$(this).parent().next().removeClass('hidden').slideDown();
		else {
			$(this).parent().next().slideUp();
			$('#fechaProgramacion').val('');
		}
	});

	// Fecha
	var picker = new Pikaday({
		field : document.getElementById('datepicker'),
		minDate : moment().startOf('day').add(1, 'days').toDate(),
		defaultDate : new Date(Date.now()),
		format : 'D/MMMM/YYYY',
		onSelect : function() {
			$('#datepicker').css({
				'color' : '#008d36',
				'text-transform' : 'uppercase'
			});
			$('#fechaProgramacion').val(this);
		}
	});

	$(document).on('touchstart', function(e) {
		var $clicked = $(e.target);
		if (!$clicked.parents().hasClass("pika-single") && !$clicked.hasClass("pika-single")) {
			$('.pika-single').addClass('is-hidden');
		}
	});

	// Dropdown
	$('.drop').dropkick({
		mobile : true
	});
	
	$('a.btn.verde').click(function() {
		if (validForm($('#transferencia').attr('id'))) {
			var amount = $('#importe').val().replace(/,/g, '');
			$('#importe').val(amount);
			submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
		}
	});
	
	$('a.btn.atras').click(function() {
		submitFormAnimate($('#transferencia').attr('id'), 'transferencias/terceros/cuentas_terceros.htm');
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
</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
        <%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido"><div class="p20">
          
	        <form:form commandName="transferencia" method="POST" action="transferencias/terceros/confirmacion.htm">
	        <input type="hidden" name="fechaProgramacion" id="fechaProgramacion" />

            <div class="clearfix">
              <div class="col1 xs-col2 btn-guardadas hidden">
                <span class="icon icon-list"></span>
              </div>
              <div>
                <h3 class="titulo"><spring:message code="afirmenet.transferencias.terceros.titulo" /></h3>
                <p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>             
              </div>
            </div>

            <a href="${context}/transferencias/terceros/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
				<span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
				<span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            </div></div>

            <div class="row mb20">
              <div class="col3 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.transferencias.paso.datos" /></h3></div>
              <div class="col6 xs-break"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio" /></span><span class="f-verdeO">*</span></h6></div>
            </div>              
            <div class="mb30">

              <fieldset>
                <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.importe" /><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative importe">
                  <strong><spring:message code="afirmenet.moneda.icon"/></strong>
                  <input id="importe" name="amount" placeholder="<spring:message code="afirmenet.transferencias.importe.placeholder" />" type="text" class="req onlyNum" />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transterceros.importe"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.concepto" /><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <input name="description" placeholder="<spring:message code="afirmenet.transferencias.concepto.placeholder" />" type="text" class="req" />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transterceros.description"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.referencia" /></label></div>
                <div class="form-input relative">
                  <input id="referencia" name="userReference" placeholder="<spring:message code="afirmenet.transferencias.referencia.placeholder" />" type="text" class="onlyNum" />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transterceros.referencia"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.email" /></label></div>
                <div class="form-input relative">
                  <input class="f-verdeO" name="emailBeneficiary" placeholder="<spring:message code="afirmenet.transferencias.email.placeholder" />" type="email" />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transterceros.email"/></span>
                  </a> 
                </div>
              </fieldset>

            </div>

          <div class="bgf1 p20">

            <div class="mb10">
              <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.tipotransfer" /></strong></h6>
              <p>Cuentas Terceros</p>
            </div>

            <div class="row">

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                <p>${transferencia.origen.description} (${transferencia.origen.numberMask}) - $${transferencia.origen.balanceFormatted} - ${transferencia.origen.ccy}</p>
              </div>

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                <p>${transferencia.destino.description} (${transferencia.destino.numberMask}) - ${transferencia.bankReceiving}</p>
              </div>
              
            </div>

          </div>

          <div class="p20 bbot2"><div class="row">

            <div class="col6 xs-break xs-mb20">
              <div class="clearfix">
                <input type="checkbox" id="check1" name="datos" class="cbox" />
                <label for="check1"><spring:message code="afirmenet.transferencias.fiscales" /></label>
              </div>
              <div class="pt20" style="display: none;">
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.rfc" /><span class="f-verdeO">*</span></label></div>
                  <div class="form-input w70"><input name="rfc" placeholder="<spring:message code="afirmenet.transferencias.rfc" />" type="text" class="req"></div>
                </fieldset>
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.IVA" /></label></div>
                  <div class="form-input w70 relative importe">
                    <strong class="f-gris"><spring:message code="afirmenet.moneda.icon"/></strong>
                    <input name="iva" placeholder="1,500" type="text" />
                  </div>
                </fieldset>
              </div>
            </div>

            <div class="col6 xs-break xs-mb20">
              <div class="clearfix">
                <input type="checkbox" id="check2" name="datos" class="cbox" />
                <label for="check2"><spring:message code="afirmenet.transferencias.programar" /></label>
              </div>
              <div class="pt20" style="display: none;">
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.fecha" /></label></div>
                  <div class="form-input w70">
                  	<input value="" type="button" id="datepicker" class="input req" />
                  </div>
                </fieldset>
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.hora" /></label></div>
                  <div class="form-input w70 no-bg">
                  <select name="horaProgramacion" class="drop req">
					<option value ="">Seleccionar Hora</option>
					<c:forEach var="hora" items="${mapHoras}">
					<option value="${hora.key}">${hora.value}</option>
					</c:forEach>
                  </select>
                  </div>
                </fieldset>
              </div>
            </div>

          </div></div>

          <div class="p20">

            <div class="row acciones">
              <div class="col6 xs-break xs-center xs-mb20"><a id="agregar-transaccion" class="btn gris"><span class="icon icon-plus"></span><spring:message code="afirmenet.transferencias.guardar" /></a></div>
              <div class="col6 xs-break xs-center" align="right">
                <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
                <a href="#" class="btn verde"><spring:message code="afirmenet.botones.continuar" /></a>
              </div>
            </div>

          </div>
          
          </form:form>

        </div></div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>