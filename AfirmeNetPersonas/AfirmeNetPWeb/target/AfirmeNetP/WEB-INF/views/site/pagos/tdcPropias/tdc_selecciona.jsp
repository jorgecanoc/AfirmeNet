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
      
      //ENVIA FORMULARIO
      $('#continuar').click(function() {
			submitFormAnimate($('#pago').attr('id'), $('#pago').attr('action'));
	  });

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
       <form:form commandName="pago" method="POST" action="pagos/tdcPropias/captura_tdcPropia.htm">
       
		<div class="p20">

          <h3 class="titulo"><spring:message code="afirmenet.pagos.tdcpropia.titulo" /></h3>
          <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

          <a href="${context}/pagos/tdcPropias/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.montoapagar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

          <div class="clearfix mb10">
            <h3 class="f-verdeO fL"><spring:message code="afirmenet.transferencias.seleccionar"/></h3>
            <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
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
                <h6 class="mb5"><spring:message code="afirmenet.pagos.destinotc"/></h6>
                <form:select id="destino" name="datosTDC" path="datosTDC.tdcTDCC" cssClass="dropfinal">
                  <option>Seleccionar Tarjeta</option>
				    <c:forEach var="tdcPropia" items="${tdcPropias}">
				        <form:option value="${tdcPropia.TCTARJ}"><c:out value="${tdcPropia.TCNOMB} (${tdcPropia.numberMask}) ${tdcPropia.TCCLTA}"/></form:option>
				    </c:forEach>
                </form:select>
              </div>
            </div>
          </div>

          <div class="row acciones">
            <div class="col12 xs-center hidden" align="right">
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