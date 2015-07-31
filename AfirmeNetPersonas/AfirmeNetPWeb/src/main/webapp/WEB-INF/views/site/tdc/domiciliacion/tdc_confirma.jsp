<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>


<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />


  <script type="text/javascript">
    $(document).ready(function(){

     $('.modal').fancybox({
        maxWidth : 600,
        maxHeight : 450,
        autoHeight: true,
        fitToView : false,
        padding   : 0
      });

      // Checkboxes
      $('.favorita .cbox').click(function(){
        if( $(this).is(':checked') ){ $('.favorita').addClass('act'); $('.favorita .f21').html($('#concepto').html()); }
        else { $('.favorita').removeClass('act'); $('.favorita .f21').html('¿Guardar como una operación favorita?'); }
      });

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
<%--         <form:form commandName="pago" method="POST" action="${context}/transferencias/propias/comprobante_propias.htm"> --%>
           <form id="pago"  method="POST" action="pagos/tdcDomiciliar/comprobante_tdcDomi.htm">
           <div class="p20">

            <h3 class="titulo"><spring:message code="afirmenet.pagos.tdcdomi.titulo" /></h3>
            <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO">Lunes a Viernes</span></p>

            <a href="${context}/pagos/tdcPropias/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
            <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
            <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso col4"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
 	          </div></div>

            <div class="mb30">
              <h3 class="f-verdeO"><spring:message code="afirmenet.confirmar"/></h3>
            </div>

            <div class="row">

              <div class="col6 xs-break">

                <div class="mb20">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                  <p class="h6 f-verdeO"></p>
                </div>

              </div>

              <div class="col6 xs-break">

                <div class="mb15">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                  <p class="h6 f-verdeO"> </p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></h6>
                  <p class="h6 f-verdeO">$</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></h6>
                  <p id="concepto" class="h6 f-verdeO"></p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.referencia"/></strong></h6>
                  <p class="h6 f-verdeO"></p>
                </div>
             </div>
            </div>
          </div>

          <div class="favorita p20"><div class="row">

            <div class="col8 xs-break xs-mb20">
              <div class="clearfix">
                <span class="icon icon-star-full f42 mr10 fL"></span>
                <p class="fL m0 mt5"><strong class="h6"><spring:message code="afirmenet.favoritas"/></strong><br><span class="f21"><spring:message code="afirmenet.favoritas.pregunta"/></span></p>
              </div>
            </div>

            <div class="col4 xs-break mt15">
              <input type="checkbox" id="check1" name="datos" class="cbox f-bco" />
              <label for="check1"><spring:message code="afirmenet.favoritas.guardar"/></label>           
            </div>

          </div></div>

          <div class="p30">
            <div class="acciones" align="right">
              <a href="${context}/pagos/tdcTerceros/atrasCaptura.htm" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
              <button id="continuar" onclick="return false;" class="btn verde"><spring:message code="afirmenet.botones.aceptar" /></button>
            </div>
          </div>
<%--      	</form:form> --%>
</form>
        </div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>