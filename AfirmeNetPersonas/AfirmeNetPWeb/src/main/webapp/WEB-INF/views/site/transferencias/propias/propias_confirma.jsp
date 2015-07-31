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

    });
  </script>
 <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
 		<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%> 
      </div>

      <div class="col-der relative">

        <div class="contenido">
        <form:form commandName="transferencia" method="POST" action="${context}/transferencias/propias/comprobante_propias.htm">
           <div class="p20">

            <h3 class="titulo"><spring:message code="afirmenet.transferencias.propias.titulo" /></h3>
            <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>

            <a href="${context}/transferencias/propias/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
             <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
             <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
             </div></div>

            <div class="mb30">
              <h3 class="f-verdeO"><spring:message code="afirmenet.confirmar"/></h3>
            </div>

            <div class="row">

              <div class="col6 xs-break">

                <div class="mb20">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.origen.description} (${transferencia.origen.numberMask}) - $${transferencia.origen.balanceFormatted} - ${transferencia.origen.ccy}</p>
                </div>

              </div>

              <div class="col6 xs-break">

                <div class="mb15">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.destino.description} (${transferencia.destino.numberMask}) - $${transferencia.destino.balanceFormatted} - ${transferencia.destino.ccy} </p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${transferencia.amount}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></h6>
                  <p id="concepto" class="h6 f-verdeO">${transferencia.description}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.referencia"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.userReference}</p>
                </div>
                
            <c:if test="${transferencia.origen.ccy ne transferencia.destino.ccy}">    
                
            <c:if test="${not empty transferencia.cveTasaPref}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.propias.compatasa"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.cveTasaPref}</p>
                </div>               
              
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.propias.compatasa"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.cambioDolares.TRate}</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.propias.compinmpo"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.cambioDolares.formattedAmount}</p>
                </div>
			</c:if>
			<c:if test="${transferencia.cveTasaPref eq ''}">
                <div class="mb15">                                  
                  <h6 class="m0"><strong>
                   <c:if test="${transferencia.CUR eq 'B'}">
                  	<spring:message code="afirmenet.transferencias.propias.tasacompra"/>
                  </c:if>
                  <c:if test="${transferencia.CUR eq 'S'}">
                  	<spring:message code="afirmenet.transferencias.propias.tasaventa"/>
                  </c:if>
                  </strong></h6>
                  <p class="h6 f-verdeO">${transferencia.CURCCY}</p>
                </div>               
              
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.propias.compinmpo"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${transferencia.AMTCCY}</p>
                </div>

			</c:if>
			</c:if>
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
              <form:checkbox path="agregarFavoritas" id="check1" class="cbox f-bco"/>
              <label for="check1"><spring:message code="afirmenet.favoritas.guardar"/></label>           
            </div>

          </div></div>

          <div class="p30">
            <div class="acciones" align="right">
              <a href="${context}/transferencias/propias/atrasCaptura.htm" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
              <button onclick="submitFormAnimate('transferencia','transferencias/propias/comprobante_propias.htm'); return false;"
				class="btn verde"><spring:message code="afirmenet.botones.aceptar" /></button>
            </div>
          </div>
     	</form:form>
        </div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>