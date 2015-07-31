<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>


<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

  <script type="text/javascript">
    $(document).ready(function(){

      // Interacciones listado
      $('.guardadas .icon-t-plus').click(function(){
        $('.guardadas .ver-detalle').removeClass('ver-detalle').find('.detalle').slideUp();
        $(this).closest('li').addClass('ver-detalle').find('.detalle').slideDown();
      });
      $('.guardadas .icon-t-minus').click(function(){
        $(this).closest('li').removeClass('ver-detalle').find('.detalle').slideUp();
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

          <div class="p20">

            <div class="clearfix">
              <div class="col1 xs-col2 btn-guardadas">
                <span class="icon icon-list"></span>
              </div>
              <div class="col11 xs-col10">
                <h3 class="titulo"><spring:message code="afirmenet.transferencias.propias.guardadas" /></h3>
                <p><spring:message code="afirmenet.horarios" /> <span class="f-verdeO"><c:out value="${horario}"/></span></p>                
              </div>
            </div>

             <a href="${context}/consultas/resumen-de-mis-cuentas.htm" class="cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
              <span class="paso col6 activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmarguardadas"/></small></span></span>
              <span class="paso col6 activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            </div></div>

            <div class="clearfix mb10">
              <h3 class="f-verdeO fL"><spring:message code="afirmenet.comprobante"/></h3>
            <a href="#" class="icon icon-info fR tooltip">
            <span><span class="icon icon-close2"></span>
            	  <span class="h6"><strong><spring:message code="afirmenet.tooltip.transpropia.titulo"/></strong></span>
            	  <span><spring:message code="afirmenet.tooltip.transpropia.desc"/></span></span>
            </a>
            </div>

            <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>	

            <ul class="guardadas">
			<c:forEach var="transferencia" items="${listTransferencias}">
            <li class="comprobante"><div>
              <div class="row mb10">
                <div class="col4">
                  <p><strong><spring:message code="afirmenet.comprobantes.tranferestado"/></strong></p>
                  <p class="f-verdeO"><spring:message code="afirmenet.comprobantes.exitosa"/></p>                    
                </div>
                <div class="col7">
                  <p><strong><spring:message code="afirmenet.comprobantes.folioAfirme"/></strong></p>
                  <p class="f-verdeO">${transferencia.referenceNumber}</p>                    
                </div>
                <div class="col1" align="right">
                  <a class="icon icon-t-plus"></a>
                  <a class="icon icon-t-minus"></a>
                </div>
              </div>
              <div class="row ocultar">
                <div class="col4">
                  <p><strong><spring:message code="afirmenet.transferencias.nacionales.tipo"/></strong></p>
                  <p class="f-verdeO"><spring:message code="afirmenet.transferencias.propias.titulo"/></p>                    
                </div>
                <div class="col3">
                  <p><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></p>
                  <p class="f-verdeO">$${transferencia.amount}</p>                    
                </div> 
                <div class="col5">
                  <p><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></p>
                  <p class="f-verdeO">${transferencia.description}</p>                    
                </div>                
              </div>
              <div class="detalle">
                <div class="btb mb15"><div class="row">

                  <div class="col6">
                    <p><strong><spring:message code="afirmenet.transferencias.nacionales.tipo"/></strong></p>
                    <p class="f-verdeO"><spring:message code="afirmenet.transferencias.propias.titulo"/></p>                  
                  </div>
                  <div class="col6">
                    <p><strong><spring:message code="afirmenet.comprobantes.referencia"/></strong></p>
                    <p class="f-verdeO">${transferencia.userReference}</p>                  
                  </div>

                </div></div>

                <div class="row">

                  <div class="col6 xs-break">

                    <div class="mb15">
                      <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                      <p class="f-verdeO">${transferencia.debitAccount}</p>
                    </div>

                    <div class="mb15">
                      <p><strong><spring:message code="afirmenet.comprobantes.contrato"/></strong></p>
                      <p class="f-verdeO">${transferencia.contractId}</p>
                    </div>

                  </div>

                  <div class="col6 xs-break">

                    <div class="mb15">
                      <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                      <p class="f-verdeO">${transferencia.creditAccount}</p>
                    </div>

                    <div class="mb15">
                      <p><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></p>
                      <p class="f-verdeO">$${transferencia.amount}</p>
                    </div>

                    <div class="mb15">
                      <p><strong><spring:message code="afirmenet.comprobantes.comision"/></strong></p>
                      <p class="f-verdeO"><spring:message code="afirmenet.comprobantes.sincomision"/></p>
                    </div>

                    <div class="mb15">
                      <p><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></p>
                      <p class="f-verdeO">${transferencia.description}</p>
                    </div>

                    <div class="mb15">
                      <p><strong><spring:message code="afirmenet.comprobantes.email"/></strong></p>
                      <p class="f-verdeO">${transferencia.emailBeneficiary}</p>
                    </div>

                    <div class="mb15">
                      <p><strong><spring:message code="afirmenet.comprobantes.programada"/></strong></p>
                      <p class="f-verdeO">
                        <spring:message code="afirmenet.comprobantes.inmediata"/><br>
                        <spring:message code="afirmenet.comprobantes.hora"/> ${transferencia.validationHour}:${transferencia.validationMinute} hrs<br>
                        <spring:message code="afirmenet.comprobantes.dia"/> ${transferencia.validationDay} / ${transferencia.validationMonth} / ${transferencia.validationYear}
                      </p>
                    </div>

                  </div>

                </div>                
              </div>
            </div></li>
  			</c:forEach>
            </ul>

          </div>

          <div class="bgcrema p20">

            <p class="f21 mb20"><strong class="f-gris6">¿Desea realizar todas las Transacciones?</strong></p>
            <div class="row">

              <div class="col6 xs-break xs-mb20">

              </div>

              <div class="col6 xs-break">
                <p class="h6 mb5">&nbsp;</p>
                <div class="acciones" align="right">
                  <a href="TRANSF_Nacionales-guardadas-comprobante.html" class="btn verde">Aceptar</a>
                </div>           
              </div>

            </div>
          </div>

        </div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>