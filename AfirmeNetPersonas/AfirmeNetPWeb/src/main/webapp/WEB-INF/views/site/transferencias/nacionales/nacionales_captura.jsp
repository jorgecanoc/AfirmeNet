<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />





<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>

  <script type="text/javascript">
   $(document).ready(function() {
		// Agregar transacción
		$('#agregar-transaccion').click(function() {
		
			$('.btn-guardadas .tip .icon-close2').click(function() {
				$('.btn-guardadas .tip').slideUp();
			});
			
			if (validForm($('#transferencia').attr('id'), 'agrega_transaccion.htm')) {
				
				$('.btn-guardadas').removeClass('hidden').append(
					'<div class="tip"><div class="clearfix"><a class="icon icon-close2"></a><span class="icon icon-success f-lima"></span><p><strong class="f-lima">CORRECTO</strong><br>La operación se agrego a la lista</p></div></div>'
				).next().addClass('col11 xs-col10');
				
				$('html, body').stop().animate({scrollTop : 0}, 1000, function() {
					$('.btn-guardadas').append('<span class="notificaciones">${listaSize}</span>');
					$('.btn-guardadas .tip').slideDown();
					setTimeout(function() {
						$('.btn-guardadas .tip').slideUp();
						submitFormAnimateWOC($('#transferencia').attr('id'), 'agrega_transaccion.htm');
					}, 3000);
				});
				
				$(this).fadeOut();
			}
			
			return false;
		});

		// Checkboxes
		$('.cbox').click(function() {
			if ($(this).is(':checked'))
				$(this).parent().next().removeClass('hidden').slideDown();
			else
				$(this).parent().next().slideUp();
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
			if (validForm($('#transferencia').attr('id')))
				submitFormAnimateWOC($('#transferencia').attr('id'), $('#transferencia').attr('action'));
		});
		
		$('a.btn.atras').click(function() {
			submitFormAnimateWOC($('#transferencia').attr('id'), 'bancos_nacionales.htm');
		});
		<c:if test="${transferencia.transactionCode eq '09'}">
             //alert($('chkProgramar').is(':checked'));
			$('#chkProgramar').attr('checked', true);
			//$('chkProgramar').checked=true;
            //alert($('chkProgramar').is(':checked'));
            $('#chkProgramar').parent().next().removeClass('hidden').slideDown();
            $('#chkProgramar').attr('disabled', 'disabled');
        </c:if>
        
		<c:if test="${transferencia.transactionCode eq '05'}">
			$('#chkProgramar').removeAttr('checked');
		</c:if>
	});
  </script>



 <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
 		<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%> 
      </div>

      <div class="col-der relative">

        <div class="contenido">

	<form:form commandName="transferencia" method="POST" action="confirma.htm">
	        <input type="hidden" name="fechaProgramacion" id="fechaProgramacion" />
          <div class="p20">

            <div class="clearfix">
              <div class="col1 xs-col2 btn-guardadas hidden">
                <span class="icon icon-list"></span>
              </div>
              <div>
                <h3 class="titulo"><spring:message code="afirmenet.transferencias.nacionales.titulo" /></h3>
                <p><spring:message code="afirmenet.horarios"/><span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>             
              </div>
            </div>

            <a href="#" class="cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.transferencia"/></small></span></span>
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          
            </div></div>

            <div class="row mb20">
              <div class="col3 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.captura"/></h3></div>
              <div class="col6 xs-break"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></h6></div>
            </div>
              
            <div class="mb30">

              <fieldset>
                <div class="form-label"><label for="amount"><spring:message code="afirmenet.transferencias.importe"/><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></label></div>
                <div class="form-input relative importe">
                  <strong><spring:message code="afirmenet.moneda.icon"/></strong>
                  <spring:message code="afirmenet.transferencias.importe.placeholder" var="importeHolder"/>
                  <input name="amount" id="amount" placeholder="${importeHolder}" type="text" class='req' />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transnacionales.importe"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="description"><spring:message code="afirmenet.transferencias.concepto"/><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.concepto.placeholder" var="conceptoHolder"/>
                  <input name="description" id="description" placeholder="${conceptoHolder}" type="text" class='req' />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transnacionales.description"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="referenceNumber"><spring:message code="afirmenet.transferencias.referencia"/><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.referencia.placeholder" var="referenciaHolder"/>
                  <input name="referenceNumber" id="referenceNumber" placeholder="${referenciaHolder}" type="text" class='req' />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transnacionales.referencia"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="emailBeneficiary"><spring:message code="afirmenet.transferencias.email"/></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.email.placeholder" var="emailHolder"/>
                  
                  <input class="" name="emailBeneficiary" id="emailBeneficiary" placeholder="${emailHolder}" type="email" class='req' value="${transferencia.emailBeneficiary}" />
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transnacionales.email"/></span>
                  </a> 
                </div>
              </fieldset>

            </div>

          </div>

          <div class="bgf1 p20">

            <div class="mb10">
              <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.nacionales.tipo"/></strong></h6>
              <p>
              <c:if test="${transferencia.transactionCode eq '05'}">
              <spring:message code="afirmenet.transferencias.nacionales.SPEI"/>
              </c:if>
              <c:if test="${transferencia.transactionCode eq '09'}">
              <spring:message code="afirmenet.transferencias.nacionales.TEF"/>
              </c:if>
              </p>
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
                <label for="check1"><spring:message code="afirmenet.transferencias.fiscales"/></label>
              </div>
              <div class="pt20" style="display: none;">
                <fieldset>
                  <div class="form-label"><label for="rfc"><spring:message code="afirmenet.transferencias.rfc"/><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></label></div>
                  <div class="form-input w70"><input name="rfc" id="rfc" placeholder="RFC" type="text" class='req' /></div>
                </fieldset>
                <fieldset>
                  <div class="form-label"><label for="iva"><spring:message code="afirmenet.transferencias.IVA"/></label></div>
                  <div class="form-input w70 relative importe">
                    <strong class="f-gris"><spring:message code="afirmenet.moneda.icon"/></strong>
                    <input name="iva" ID="iva" placeholder="1,500" type="text" class='req' />
                  </div>
                </fieldset>
              </div>
            </div>

            <div class="col6 xs-break xs-mb20">
              <div class="clearfix">
                <input type="checkbox" id="chkProgramar" name="chkProgramar" class="cbox" value='1' checked />
                <label for="chkProgramar"><spring:message code="afirmenet.transferencias.programar"/></label>
              </div>
              <div class="pt20" style="display: none;" id="divProgramacion">
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.fecha"/></label></div>
                  <div class="form-input w70">
                  	<c:set var="now" value="<%=new java.util.Date()%>"/>
                  	<input value="<fmt:formatDate pattern="dd/MM/yyyy" value="${now}" />" type="button" id="datepicker" class="input req"></div>
                </fieldset>
                <fieldset>
                  <div class="form-label"><label for="horaProgramacion"><spring:message code="afirmenet.transferencias.hora"/></label></div>
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
  </form:form>
          </div></div>

          <div class="p20">

            <div class="row acciones">
              <div class="col6 xs-break xs-center xs-mb20"><a id="agregar-transaccion" class="btn gris"><span class="icon icon-plus"></span><spring:message code="afirmenet.transferencias.guardar" /></a></div>
              <div class="col6 xs-break xs-center" align="right">
                <a href="#" data-fancybox-type="iframe" class="modal btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
                <a href="#" class="btn verde" ><spring:message code="afirmenet.botones.continuar" /></a>
              </div>
            </div>

          </div>



    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>