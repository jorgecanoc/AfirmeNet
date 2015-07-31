<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
    $('document').ready(function(){
    
      $('.modal').fancybox({
        maxWidth : 600,
        maxHeight : 450,
        autoHeight: true,
        fitToView : false,
        padding   : 0
      });
    

      $('.drop').dropkick({ mobile: true, change: function(dk){ $(this.data.elem).find('.dk-selected').addClass('f-verde'); } });
      // Solo para el ejemplo
      $('.dropfinal').dropkick({
        mobile: true,
        change: function(){ 
          $(this.data.elem).find('.dk-selected').addClass('f-verde');
          $('.acciones .hidden').removeClass('hidden');
        }
      });
      
      $('#continuar').click(function() {
	      if( $("#origen").val() == $("#destino").val() ){
	      if (!$('.mensaje').length) {
			  $('#errores').prepend('<div class="mensaje error fc"><span class="icon icon-error"></span><span class="icon icon-close2"></span><p><strong class="error">ERRORES</strong><br>La cuenta origen debe ser diferente a la cuenta destino</p></div>');
              $('.mensaje .icon-close2').click(function(){ $(this).parent().slideUp(); });
              }
		  }else{
			submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
		  }
	  });
	  
	  $('.btn-guardadas').click(function() {	      
			submitFormAnimate($('#transferencia').attr('id'), 'transferencias/propias/confguardadas_propias.htm'); 
	  });

      $('.btn-guardadas').hover(function() {
	        $(this).css('cursor','pointer');
	  });
	  
	  $('.btn-guardadas').append('<span class="notificaciones">'+$("#guardadas").val()+'</span>');
	  
	  var listaTransfer = '${guardadas gt 0}';
	  if (listaTransfer) {
	  	$('.btn-guardadas').next().addClass('col11 xs-col10');
	  }
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
        
        <div class="p20">

	<form:form commandName="transferencia" method="POST" action="transferencias/propias/captura_propias.htm">
	      <input type="hidden" value="${guardadas}" id="guardadas"/>
          <div class="clearfix">
          	<c:if test="${guardadas > 0}">   
            <div class="col1 xs-col2 btn-guardadas">
               <span class="icon icon-list"></span>
            </div>
          	</c:if>
            <div>
	          	<h3 class="titulo"><spring:message code="afirmenet.transferencias.propias.titulo" /></h3>
	          	<p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>
	        </div>
          </div>
            
          <a href="${context}/transferencias/propias/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

		  <div id="errores"></div>
			
          <div class="clearfix mb10">
            <h3 class="f-verdeO fL"><spring:message code="afirmenet.transferencias.seleccionar"/></h3>
            <a href="#" class="icon icon-info fR tooltip">
            <span><span class="icon icon-close2"></span>
            	  <span class="h6"><strong><spring:message code="afirmenet.tooltip.transpropia.titulo"/></strong></span>
            	  <span><spring:message code="afirmenet.tooltip.transpropia.desc"/></span></span>
            </a>
          </div>

          <div class="bbot2 mb20">
            <div class="row">
              <div class="col6 xs-break mb20">
                <h6 class="mb5"><spring:message code="afirmenet.transferencias.origen"/></h6>
                <form:select id="origen" name="origen" path="origen.number" cssClass="drop">
                	<option>Seleccionar</option>
				    <c:forEach var="cuentaPropia" items="${cuentasPropias}">
				        <form:option value="${cuentaPropia.number}"><c:out value="${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} ${cuentaPropia.ccy}"/></form:option>
				    </c:forEach>
				</form:select>	
              </div>
              <div class="col6 xs-break mb20">
                <h6 class="mb5"><spring:message code="afirmenet.transferencias.destino"/></h6> 
                <form:select id="destino" name="destino" path="destino.number" cssClass="dropfinal">
                	<option>Seleccionar Cuenta</option>
				    <c:forEach var="cuentaPropia" items="${cuentasPropias}">
				        <form:option value="${cuentaPropia.number}"><c:out value="${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} ${cuentaPropia.ccy}"/></form:option>
				    </c:forEach>
				    <option>Nueva cuenta destino</option>
				</form:select>	
              </div>
            </div>
          </div>

          <div class="row acciones">
            <div class="col12 xs-center hidden" align="right">
              <button id="continuar" class="btn verde" onclick="return false;"><spring:message code="afirmenet.botones.continuar" /></button>
            </div>
          </div>
          
  </form:form>
  
        </div></div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>