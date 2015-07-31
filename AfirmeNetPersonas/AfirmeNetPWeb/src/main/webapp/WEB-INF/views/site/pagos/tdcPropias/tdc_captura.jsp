<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/afirmenet/jquery.maskMoney.js"/>"></script>

    <script type="text/javascript">
     $(document).ready(function(){
     
      $('.modal').fancybox({
        maxWidth : 600,
        maxHeight : 450,
        autoHeight: true,
        fitToView : false,
        padding   : 0
      });

      // Radio
      $('.radio').click(function(){
        if( $('#radio4').is(':checked') ) $('#otro-monto').slideDown();
        else $('#otro-monto').slideUp();        
      });

      // Checkboxes
      $('.cbox').click(function(){
        if( $(this).is(':checked') ) $(this).parent().next().slideDown();
        else $(this).parent().next().slideUp();
      });

      // Fecha
      var picker = new Pikaday({
        field: document.getElementById('datepicker'),
        minDate: moment().startOf('day').toDate(),
        defaultDate: new Date(Date.now()),
        format: 'DD/MMMM/YYYY',
        onSelect: function(){ $('#datepicker').css({'color':'#008d36', 'text-transform': 'uppercase'});
        $('#fechaProgramacion').val(this);
        }
       
      });

      $(document).on('touchstart', function(e) {
        var $clicked = $(e.target);
        if( ! $clicked.parents().hasClass("pika-single") && !$clicked.hasClass("pika-single") ){
          $('.pika-single').addClass('is-hidden');
        }
      });

      // Dropdown
      $('.drop').dropkick({ mobile: true });
      
            // Envia la transaccion pero quita las comas del importe antes de
      $('#continuar').click(function() {
      
        if($('#radio1').is(':checked')) $('#importe').val( $('#radio1').val());
        
        if($('#radio2').is(':checked')) $('#importe').val( $('#radio2').val());
        
        if($('#radio3').is(':checked')) $('#importe').val( $('#radio3').val());
        
          var noComas=$('#importe').val().replace(/,/g, '');
           $('#importe').val(noComas);
	      if (validForm($('#pago').attr('id')))
			submitFormAnimate($('#pago').attr('id'), $('#pago').attr('action'));
		  
	  });
	  
	  //Agrega la mascara de moneda al campo de importe
	  $('#importe').maskMoney();

    });

    </script>



 <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
 		<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%> 
      </div>

      <div class="col-der relative">

        <div class="contenido">
       <!--INCLUDE DE ERRORES PARA TRANSFERENCIAS-->
	   <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>	
       <form:form commandName="pago" method="POST" action="pagos/tdcPropias/confirma_tdcPropia.htm">
       <input type="hidden" name="fechaProgramacion" id="fechaProgramacion" />
          <div class="p20">

            <h3 class="titulo"><spring:message code="afirmenet.pagos.tdcpropia.titulo" /></h3>
            <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

            <a href="${context}/pagos/tdcPropias/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>            
            <div class="ovhidden mb30"><div class="pasos">
	            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
	            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.montoapagar"/></small></span></span>
	            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
	            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
	        </div></div>

            <div class="row mb20">
              <div class="col4 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.pagos"/></h3></div>
              <div class="col4 xs-break xs-mb20"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></h6></div>
            </div>
            
            <div class="row mb20">
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio1" name="radio" class="radio" checked value="${pago.datosTDC.tdcPAGM}">
                  <label for="radio1"><span class="h6">$${pago.datosTDC.tdcPAGM} MXP  </span><br><span class="f14"><spring:message code="afirmenet.pagos.tdcpropia.minimo"/></span></label>
                </div>
              </div>
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio2" name="radio" class="radio" value="${pago.datosTDC.tdcPAGM}">
                  <label for="radio2"><span class="h6">$${pago.datosTDC.tdcPAGM} MXP  </span><br><span class="f14"><spring:message code="afirmenet.pagos.tdcpropia.minmaspromo"/></span></label>
                </div>
              </div>
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio3" name="radio" class="radio" value="${pago.datosTDC.tdcPANGI}">
                  <label for="radio3"><span class="h6">$${pago.datosTDC.tdcPANGI} MXP  </span><br><span class="f14"><spring:message code="afirmenet.pagos.tdcpropia.nointereses"/></span></label>
                </div>
              </div>
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio4" name="radio" class="radio" >
                  <label for="radio4"><span class="h6"><spring:message code="afirmenet.pagos.tdcpropia.fijo"/></span></label>
                </div>
              </div>
            </div>

            <div id="otro-monto" style="display:none">

              <fieldset>
                <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.importe"/><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></label></div>
                <div class="form-input relative importe">                  
                  <strong><spring:message code="afirmenet.moneda.icon"/></strong>
                  <spring:message code="afirmenet.transferencias.importe.placeholder" var="importeHolder"/>
                  <form:input path="amount" name="importe" id="importe" placeholder="${importeHolder}" type="tel" class="req"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transpropia.importe"/></span>
                  </a> 
                </div>
              </fieldset>
</div><div>
              <fieldset>
                <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.concepto"/><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></label></div>
                <div class="form-input relative">
                <spring:message code="afirmenet.transferencias.concepto.placeholder" var="conceptoHolder"/>
                  <form:input path="description" name="concepto" id="concepto" placeholder="${conceptoHolder}" type="text" class="req"/>
                   <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transpropia.concepto"/></span>
                  </a> 
                </div>
              </fieldset>

            </div>

          </div>

          <div class="bgf1 p20">

            <div class="row">

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.tdcpropia.saldocorte"/></strong></p>
                  <p class="h6">$${pago.datosTDC.tdcSALC} MXP </p>
                </div>
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.tdcpropia.saldonointeres"/></strong></p>
                  <p class="h6">$${pago.datosTDC.tdcPANGI} MXP </p>
                </div>
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.tdcpropia.fechapago"/></strong></p>
                  <p class="h6">                  <c:set var="now" value="${pago.datosTDC.tdcFELP}" />
				  <fmt:parseDate value="${now}" var="parsedEmpDate" pattern="yyyyMMdd" />
				  <fmt:formatDate pattern="dd/MMMM/yyyy"value="${parsedEmpDate}" /></p>                
				</div>
                <div>
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.tipooperacion"/></strong></p>
                  <p class="h6">Pago de Mis Tarjetas de Crédito </p>
                </div>
              </div>

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.tdcpropia.saldoactual"/></strong></p>
                  <p class="h6">$${pago.datosTDC.tdcSALA} MXP </p>
                </div>
                <div>
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.tdcpropia.minimo"/></strong></p>
                  <p class="h6">$${pago.datosTDC.tdcPAGM} MXP </p>
                </div> 
              </div>
              
            </div>

            <div class="row">

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></p>
                  <p class="h6">${pago.origen.description} (${pago.origen.numberMask}) - $${pago.origen.balanceFormatted} - ${pago.origen.ccy}</p>
                </div>
              </div>

              <div class="col6 xs-break">
                <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></p>
                <p class="h6">${pago.datosTDC.tdcNOMCLIE} (${pago.datosTDC.numberMask})</p>
              </div>
              
            </div>

          </div>

          <div class="p20 bbot2">

            <div class="clearfix">
              <input type="checkbox" id="check2" name="datos" class="cbox" />
              <label for="check2"><spring:message code="afirmenet.transferencias.programarpago"/></label>
            </div>
            <div class="row pt20" style="display: none;">
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.fecha"/></label></div>
                  <div class="form-input w70">
                  	<input value="" type="button" id="datepicker" class="input req" />
                  </div>
                </fieldset>                    
              </div>
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.hora"/></label></div>
                  <div class="form-input w70 no-bg">
                  <select name="hora" class="drop req">
					<option value ="">Seleccionar Hora</option>
					<c:forEach var="hora" items="${mapHoras}">
					<option value="${hora.key}">${hora.value}</option>
					</c:forEach>
                  </select>
				  </div>
                </fieldset>                  
              </div>
            </div>

          </div>

          <div class="p20">

            <div class="acciones" align="right">
                <a href="${context}/pagos/tdcPropias/atrasSelecciona.htm" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
                <button id="continuar" class="btn verde" onclick="return false;"><spring:message code="afirmenet.botones.continuar" /></button>
              </div>

          </div>
          
       </form:form>
  
        </div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>