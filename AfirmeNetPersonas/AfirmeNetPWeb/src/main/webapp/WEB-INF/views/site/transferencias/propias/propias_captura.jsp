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

      // Agregar transacción
		$('#agregar-transaccion').click(function(){
			$('.btn-guardadas').removeClass('hidden').append('<div class="tip"><div class="clearfix"><a class="icon icon-close2"></a><span class="icon icon-success f-lima"></span><p><strong class="f-lima">CORRECTO</strong><br>La operación se agrego a la lista</p></div></div>').next().addClass('col11 xs-col10');
			
	        $('html, body').stop().animate({ scrollTop: 0 }, 400, function() {
	        	$('.btn-guardadas').append('<span class="notificaciones">'+$("#guardadas").val()+'</span>');
	        	$('.btn-guardadas .tip').slideDown();
	        });
	        
	        setTimeout(function() {
	        	$('.btn-guardadas .tip').slideUp(200, function(){
	        		if (validForm($('#transferencia').attr('id'), '${context}/transferencias/propias/guarda_propias.htm')){
	        		     var noComas=$('#importe').val().replace(/,/g, '');
                         $('#importe').val(noComas);
	        			 submitFormAnimate($('#transferencia').attr('id'), 'transferencias/propias/guarda_propias.htm');
	        			}
        		});
       		},2000);
	        
	        $('.btn-guardadas .tip .icon-close2').click(function() {
				$('.btn-guardadas .tip').slideUp();
				submitFormAnimate($('#transferencia').attr('id'), 'transferencias/propias/guarda_propias.htm');
			});
	        
	        $(this).fadeOut();
	        return false;
      });

      // Checkboxes
      $('.cbox').click(function(){
        if( $(this).is(':checked') ) $(this).parent().next().removeClass('hidden').slideDown();
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
          if($('#importe').val()==0)
             $('#importe').val('');
          
	      if (validForm($('#transferencia').attr('id')))
			submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
		  
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
        <form:form commandName="transferencia" method="POST" action="transferencias/propias/confirma_propias.htm">
        <input type="hidden" value="${guardadas + 1}" id="guardadas"/>
        <input type="hidden" name="fechaProgramacion" id="fechaProgramacion" />
        <div class="p20">            <div class="clearfix">
              <div class="col1 xs-col2 btn-guardadas hidden">
                <span class="icon icon-list"></span>
              </div>
              <div>
                <h3 class="titulo"><spring:message code="afirmenet.transferencias.propias.titulo" /></h3>
                <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>             
              </div>
            </div>

            <a href="${context}/transferencias/propias/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
             <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
             <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

            <div class="row mb20">
              <div class="col3 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.captura"/></h3></div>
              <div class="col6 xs-break"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></h6></div>
            </div>
              
            <div class="mb30">
            
            <div id="errores"></div>

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
                <div class="form-label"><label for="referencia"><spring:message code="afirmenet.transferencias.referencia"/></label></div>
                <div class="form-input relative">
               	  <spring:message code="afirmenet.transferencias.referencia.placeholder" var="referenciaHolder"/>
                  <form:input path="userReference" name="referencia" id="referencia" placeholder="${referenciaHolder}" type="tel" class="onlyNum"/>
                   <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transpropia.referencia"/></span>
                  </a>                  
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="concepto"><spring:message code="afirmenet.transferencias.concepto"/><span class="f-verdeO"><spring:message code="afirmenet.obligatorio.icon"/></span></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.concepto.placeholder" var="conceptoHolder"/>
                  <form:input path="description" name="concepto" id="concepto" placeholder="${conceptoHolder}" type="text" class="req"/>
                   <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transpropia.concepto"/></span>
                  </a> 
                </div>
              </fieldset>

              <fieldset>
                <div class="form-label"><label for="email"><spring:message code="afirmenet.transferencias.email"/></label></div>
                <div class="form-input relative">
                  <spring:message code="afirmenet.transferencias.email.placeholder" var="emailHolder"/>
                  <form:input path="emailBeneficiary" name="email" id="email" placeholder="${emailHolder}" type="email"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transpropia.email"/></span>
                  </a>
                </div>
              </fieldset>

            <c:if test="${cambioMoneda eq 1}">
              <fieldset>
                <div class="form-label"><label for="clave"><spring:message code="afirmenet.transferencias.propias.autorizacion"/></label></div>
                <div class="form-input relative">
                <spring:message code="afirmenet.transferencias.propias.autorizacion.placeholder"  var="claveHolder"/>
                  <form:input path="cveTasaPref" name="clave" placeholder="claveHolder" type="text"/>
                  <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                  	<span><spring:message code="afirmenet.tooltip.transpropia.clave"/></span>
                  </a>
                </div>
              </fieldset>
			</c:if>
            </div>
          
 
  
        </div>
        <div class="bgf1 p20">

            <div class="row">

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                <p>${transferencia.origen.description} (${transferencia.origen.numberMask}) - $${transferencia.origen.balanceFormatted} - ${transferencia.origen.ccy}</p>
              </div>

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                <p>${transferencia.destino.description} (${transferencia.destino.numberMask}) - $${transferencia.destino.balanceFormatted} - ${transferencia.destino.ccy}</p>          
              </div>
              
            </div>

          </div>

          <div class="p20 bbot2">

            <div class="clearfix">
              <input type="checkbox" id="check2" name="datos" class="cbox" />
              <label for="check2"><spring:message code="afirmenet.transferencias.programar"/></label>
            </div>
            <div class="row pt20" style="display: none;">
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.fecha"/></label></div>
                  <div class="form-input w70">
                    <c:set var="now" value="<%=new java.util.Date()%>"/>
                  	<input type="button" id="datepicker" name="datepicker" class="input req">
                  </div>
                </fieldset>                  
              </div>
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.hora"/></label></div>
                  <div class="form-input w70 no-bg">
                  <select name="hora" class="drop req">
                  	<c:forEach var="hora" items="${mapHoras}">
						<option value="${hora.key}">${hora.value}</option>
					</c:forEach>
                  </select></div>
                </fieldset>                  
              </div>
            </div>

          </div>

          <div class="p20">

            <div class="row acciones">
              <div class="col6 xs-break xs-center xs-mb20"><button id="agregar-transaccion" class="btn gris"><span class="icon icon-plus"></span><spring:message code="afirmenet.transferencias.guardar" /></button></div>
              <div class="col6 xs-break xs-center" align="right">
                <a href="${context}/transferencias/propias/atrasSelecciona.htm" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
                <button id="continuar" class="btn verde" onclick="return false;"><spring:message code="afirmenet.botones.continuar" /></button>
              </div>
            </div>

          </div>
     </form:form>
        </div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>