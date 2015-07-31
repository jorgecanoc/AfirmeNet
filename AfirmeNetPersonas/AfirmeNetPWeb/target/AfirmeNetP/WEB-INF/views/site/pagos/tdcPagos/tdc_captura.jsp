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
        //minDate: moment().startOf('day').toDate(),
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
       <form:form commandName="pago" method="POST" action="pagos/tdcPagos/confirma_tdcPago.htm">
       <input type="hidden" name="fechaProgramacion" id="fechaProgramacion" />
          <div class="p20">
            <c:choose>
			 <c:when test="${tipoTDC eq '1'}">
			    <h3 class="titulo"><spring:message code="afirmenet.pagos.tdcotros.titulo" /></h3>
			 </c:when>
			 <c:when test="${tipoTDC eq '2'}">
			    <h3 class="titulo"><spring:message code="afirmenet.pagos.tdcamerican.titulo" /></h3>
			 </c:when>
			 <c:when test="${tipoTDC eq '3'}">
			    <h3 class="titulo"><spring:message code="afirmenet.pagos.tdcterceros.titulo" /></h3>
			 </c:when>
			 <c:otherwise>
			    <h3 class="titulo"><spring:message code="afirmenet.pagos.seguropago.titulo" /></h3>
			 </c:otherwise>
			</c:choose>
            <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>

            <a href="${context}/pagos/tdcPropias/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>            
            <div class="ovhidden mb30"><div class="pasos">
	            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
	            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
	            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
	            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
	        </div></div>

            <div class="row mb20">
              <div class="col3 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.captura"/></h3></div>
              <div class="col4 xs-break xs-mb20"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></h6></div>
            </div>
            
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

            <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.tipooperacion"/></strong></p>
            <p class="h6">Pago de Tarjeta de Crédito</p>

            <div class="row">

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></p>
                  <p class="h6">${pago.origen.description} (${pago.origen.numberMask}) - $${pago.origen.balanceFormatted} - ${pago.origen.ccy}</p>
                </div>
              </div>

              <div class="col6 xs-break">
                <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></p>
                <p class="h6">${pago.convenio.TCNOMBRE} (${pago.convenio.numberMask})</p>          
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
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.hora" /></label></div>
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
                <a href="${context}/pagos/tdcPagos/atrasSelecciona.htm" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
                <button id="continuar" class="btn verde" onclick="return false;"><spring:message code="afirmenet.botones.continuar" /></button>
              </div>

          </div>
          
       </form:form>
  
        </div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>