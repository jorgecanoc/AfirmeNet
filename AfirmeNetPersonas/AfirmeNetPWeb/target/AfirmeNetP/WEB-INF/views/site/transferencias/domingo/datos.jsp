<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/dropkick.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="<c:url value="/resources/js/vendor/dropkick.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
		// Agregar transacción
		$('#agregar-transaccion').click(function() {
			$('.btn-guardadas').removeClass('hidden').append(
				'<div class="tip"><div class="clearfix"><a class="icon icon-close2"></a><span class="icon icon-success f-lima"></span><p><strong class="f-lima">CORRECTO</strong><br>La operación se agrego a la lista</p></div></div>'
			).next().addClass('col11 xs-col10');
			
			$('html, body').stop().animate({scrollTop : 0}, 1000, function() {
				$('.btn-guardadas').append('<span class="notificaciones">1</span>');
				$('.btn-guardadas .tip').slideDown();
				setTimeout(function() {
					$('.btn-guardadas .tip').slideUp();
				}, 3000);
			});
			
			$('.btn-guardadas .tip .icon-close2').click(function() {
				$('.btn-guardadas .tip').slideUp();
			});
			
			$(this).fadeOut();
			
			return false;
		});

		// Checkboxes
		$('.cbox').click(function() {
			if ($(this).is(':checked'))
				$(this).parent().next().removeClass('hidden').slideDown();
			else
				$(this).parent().next().slideUp();
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
			if (validForm($('#transferencia').attr('id')))
				submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
		});

	});
</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
        <%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido"><div class="p20">
          
	        <form:form commandName="transferencia" method="POST" action="transferencias/domingo/confirmacion.htm">

            <div class="clearfix">
              <div class="col1 xs-col2 btn-guardadas hidden">
                <span class="icon icon-list"></span>
              </div>
              <div>
                <h3 class="titulo"><spring:message code="afirmenet.transferencias.domingo.titulo" /></h3>
                <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>              
              </div>
            </div>

            <a href="#" class="cerrar"></a>
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
                <div class="form-label"><label for="amount"><spring:message code="afirmenet.transferencias.importe" /><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative importe">
                  <strong>$</strong>
                   <spring:message code="afirmenet.transferencias.importe.placeholder" var="importeHolder"/>
                  <input name="amount" placeholder="${importeHolder}" type="text" class="req" />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdomi.amount"/></span>
                  </a>
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="description"><spring:message code="afirmenet.transferencias.concepto" /><span class="f-verdeO">*</span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.concepto.placeholder" var="conceptoHolder"/>
                  <input name="description" placeholder="${conceptoHolder}" type="text" class="req" />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transdomi.description"/></span>
                  </a>
                </div>
              </fieldset>
            </div>

          <div class="bgf1 p20">

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

	      <div class="p20 bbot2">

            <h3 class="f-verdeO mb20"><spring:message code="afirmenet.transferencias.domingo.programacion"/></h3>
            <div class="clearfix ticks">
              <div class="radio-wrap">
<%--               	<form:radiobutton path="${programacion}" value="DIARIA" label="Diaria"/> --%>
                <input data-freq="Diaria" type="radio" id="radio" name="programacion" class="radio" value="DIARIA"  checked="checked">
                <label for="radio"><span class="h6"><spring:message code="afirmenet.transferencias.domingo.programacion.diaria"/></span></label>
              </div>
              <div class="radio-wrap">
                <input data-freq="Semanal" type="radio" id="radio2" name="programacion" class="radio" value="SEMANAL">
                <label for="radio2"><span class="h6"><spring:message code="afirmenet.transferencias.domingo.programacion.semanal"/></span></label>
              </div>
              <div class="radio-wrap">
                <input data-freq="Mensual" type="radio" id="radio3" name="programacion" class="radio" value="MENSUAL">
                <label for="radio3"><span class="h6"><spring:message code="afirmenet.transferencias.domingo.programacion.mensual"/></span></label>
              </div>
            </div>
            <div class="semana mb30">
              <div class="dia check"><spring:message code="afirmenet.transferencias.domingo.programacion.lunes"/></div>
              <div class="dia check"><spring:message code="afirmenet.transferencias.domingo.programacion.martes"/></div>
              <div class="dia check"><spring:message code="afirmenet.transferencias.domingo.programacion.miercoles"/></div>
              <div class="dia check"><spring:message code="afirmenet.transferencias.domingo.programacion.jueves"/></div>
              <div class="dia check"><spring:message code="afirmenet.transferencias.domingo.programacion.viernes"/></div>
              <div class="dia check"><spring:message code="afirmenet.transferencias.domingo.programacion.sabado"/></div>
              <div class="dia check"><spring:message code="afirmenet.transferencias.domingo.programacion.domingo"/></div>
            </div>
            <div class="row">
              <div class="col6 xs-break">
                <fieldset>
                  <div class="form-label w40"><label for="importe"><spring:message code="afirmenet.transferencias.domingo.programacion.hora"/><span class="f-verdeO">*</span></label></div>
                  <div class="form-input w60 no-bg">
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
            <div class="row">
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <spring:message code="afirmenet.transferencias.domingo.programacion.dia.placeholder" var="diaHolder"/>
                  <div class="form-label w40"><label for="importe"><spring:message code="afirmenet.transferencias.domingo.programacion.dia"/><span class="f-verdeO">*</span></label></div>
                  <div class="form-input w60">
                  <form:input path="inicioProgramacion" id="datepicker" class="req" name="inicioProgramacion" placeholder="${diaHolder}" />
                  </div>
                </fieldset>                  
              </div>
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <div class="form-label w40"><label for="importe"><spring:message code="afirmenet.transferencias.domingo.programacion.fin"/><span class="f-verdeO">*</span></label></div>
                  <div class="form-input w60">
                  <form:input path="finProgramacion" id="datepicker2" class="req" name="finProgramacion" placeholder="${diaHolder}" />
                  </div>
                </fieldset>                  
              </div>
            </div>

          </div>
	

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

  <script type="text/javascript">
    $(document).ready(function(){

      // Fecha
      var picker = new Pikaday({
        field: document.getElementById('datepicker'),
        minDate:  moment().add("days", 1).toDate(),
        defaultDate:  moment().add("days", 1).toDate(),
        format: 'D/MMMM/YYYY',
        onSelect: function(){ $('#datepicker').css({'color':'#008d36', 'text-transform': 'uppercase'}); }
      });

      // Fecha
      var picker = new Pikaday({
        field: document.getElementById('datepicker2'),
        minDate: moment().add("days", 2).toDate(),
        defaultDate: moment().add("days", 2).toDate(),
        format: 'D/MMMM/YYYY',
        onSelect: function(){ $('#datepicker2').css({'color':'#008d36', 'text-transform': 'uppercase'}); }
      });

      $(document).on('touchstart', function(e) {
        var $clicked = $(e.target);
        if( ! $clicked.parents().hasClass("pika-single") && !$clicked.hasClass("pika-single") ){
          $('.pika-single').addClass('is-hidden');
        }
      });

      // Programación Domingo
      $('.radio').click(function(e) {
        if( $(this).data('freq') == 'Diaria' ) $('.semana').show().find('.dia').addClass('check');
        if( $(this).data('freq') == 'Semanal' ){ $('.semana').show().find('.dia').removeClass('check'); $('.semana .dia:last').addClass('check'); }
        if( $(this).data('freq') == 'Mensual' ) $('.semana').hide();
      });

      // Dropdown
      $('.drop').dropkick({ mobile: true });

    });
  </script>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>