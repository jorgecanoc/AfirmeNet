<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />


<script type="text/javascript">
	$(document).ready(function(){
		$('.notificacion .icon-close2').click(function(){ $(this).parent().slideUp(); });
	});
</script>

  <section><div class="container">

    <article>

		<div class="col-izq" id="menu-wrap">
			<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
		</div>
			<form:form commandName="servicio" method="POST"
				modelAttribute="servicio"
				action="servicios/ejecutar">
      <div class="col-der relative">

        <div class="contenido">
       	  <!--INCLUDE DE ERRORES PARA TRANSFERENCIAS-->
	   	  <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>		
          <div class="notificacion bgturq">
            <a class="icon icon-close2"></a>
            <div class="clearfix"><span class="icon icon-success"></span><p class="f21 m0"><strong><spring:message code="afirmenet.comprobantes.mensaje"/></strong><br><spring:message code="afirmenet.comprobantes.mensaje2"/></p></div>
          </div>

          <div class="p20">

			<h3 class="titulo">
				<spring:message code="afirmenet.pago.servicios.basicos.titulo" />
			</h3>
            <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>  
            
            <a href="#" class="cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
				<span class="paso activo"><span><spring:message code="afirmenet.pago.servicios.paso1" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.servicio" /></small></span></span>
				<span class="paso activo"><span><spring:message code="afirmenet.pago.servicios.paso2" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.datos" /></small></span></span> 
				<span class="paso activo"><span><spring:message code="afirmenet.pago.servicios.paso3" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.confirmar" /></small></span></span>
				<span class="paso activo"><span><spring:message code="afirmenet.pago.servicios.paso4" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.comprobante" /></small></span></span>
            </div></div>

            <div class="row mb15">
               <h3 class="f-verdeO col8 xs-col6"><spring:message code="afirmenet.comprobante"/></h3>
               <c:if test="${comprobante.esFavoritas}">
	              <div class="col4 xs-break">
	                <label class="ribbon r-turq"><span class="icon icon-star-full"></span><spring:message code="afirmenet.favoritas"/></label>
	              </div>               
               </c:if>
            </div>

            <div class="bbot2 mb15"><div class="row">

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.tranferestado"/></strong></h6>
                <p class="h6 f-verdeO"><spring:message code="afirmenet.comprobantes.exitosa"/></p>                  
              </div>
              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.folioAfirme"/></strong></h6>
                <p class="h6 f-verdeO">${comprobante.afirmeNetReference}</p>                  
              </div>

            </div></div>

            <div class="bbot2 mb15"><div class="row">

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.tipo.operacion"/>:</strong></h6>
                <p class="h6 f-verdeO">${comprobante.tipoTransferencia}</p>                  
              </div>
              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.pago.servicios.titulo"/>:</strong></h6>
                <p class="h6 f-verdeO">${comprobante.tipoServicio}</p>                  
              </div>
            </div></div>

            <div class="row">

              <div class="col6 xs-break">

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                  <p class="h6 f-verdeO">${comprobante.debitAccount}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.contrato"/></strong></h6>
                  <p class="h6 f-verdeO">${comprobante.contractId}</p>
                </div>
				<c:if test="${comprobante.esFavoritas}">
	                <div class="mb15">
	                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.favorita"/></strong></h6>
	                  <p class="h6 f-verdeO">Si</p>
	                </div>
				</c:if>
              </div>

              <div class="col6 xs-break">
               <c:if test="${comprobante.tipoServicio != 'TELEFONOS_DE_MEXICO'}">
	                <div class="mb15">
	                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.referencia"/></strong></h6>
	                  <p class="h6 f-verdeO">${comprobante.referenceNumber}</p>
	                </div>
               </c:if>
			   <c:if test="${comprobante.tipoServicio == 'TELEFONOS_DE_MEXICO'}">
	                <div class="mb15">								
	                  <h6 class="m0"><strong><spring:message code="afirmenet.pago.servicios.numero.telefono"/></strong></h6>
	                  <p class="h6 f-verdeO">${servicio.lada} - ${servicio.numeroTelefonico}</p>
	                </div>		
                  
	                <div class="mb15">
	                  <h6 class="m0"><strong><spring:message code="afirmenet.pago.servicios.propietario"/></strong></h6>
	                  <p class="h6 f-verdeO">${comprobante.beneficiaryName}</p>
	                </div>			   
			   </c:if>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${comprobante.amount}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></h6>
                  <p id="concepto" class="h6 f-verdeO">${comprobante.description}</p>
                </div>
                <c:if test="${servicio.tipoServicio == 'GAS_NATURAL_MEXICO'}">
                  	<div class="mb15">
						<h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.fechaVencimiento"/></strong></h6>
	                  	<p id="concepto" class="h6 f-verdeO">${servicio.fechaVencimiento}</p>
	                </div>	                
                </c:if>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.programada"/></strong></h6>
                  <p class="h6">
                    <spring:message code="afirmenet.comprobantes.hora"/> <span class="f-verdeO">${comprobante.programmingHour}:${comprobante.programmingMinute} hrs</span><br>
                    <spring:message code="afirmenet.comprobantes.fechaInicio"/> <span class="f-verdeO">${comprobante.programmingDate}</span><br>            	
                  </p>
                </div>	


              </div>

            </div>


            <div class="bbot2 btop2 p15-10"><div class="row">
              <div class="col4 xs-break xs-center xs-mb20"><p class="f21 m0"><spring:message code="afirmenet.comprobantes.impresion"/></p></div>
              <div class="col4 xs-break xs-center"><a href="#" class="h6 m0 f-verde"><span class="icon icon-pdf f21 mr10"></span> <spring:message code="afirmenet.comprobantes.pdf"/> <span class="hide-xs"><spring:message code="afirmenet.comprobantes.pdf2"/></span></a></div>
              <div class="col4 hide-xs"><a href="#" class="h6 m0 f-verde"><span class="icon icon-print f21 mr10"></span> <spring:message code="afirmenet.comprobantes.imprimir"/></a></div>
            </div></div>

            <div class="p15-20 xs-p100" align="center">
              <p class="f21">Operaciones Recomendadas</p>
              <div class="acciones mt10 flex">
                <a href="#" class="btn atras mr10 xs-col12 xs-m0">consultar movimientos</a>
                <a href="#" class="btn verde xs-col12 xs-mb20">ASOCIAR CUENTA A CELULAR</a>
              </div>
            </div>

          </div>

          <div class="p30-20 bgturq promocion"><div class="row">
            <div class="col6 xs-break xs-mb20">
              <div class="bgbco" align="center"><img src="<c:url value="/resources/img/photos/candado.jpg"/>" alt=""></div>
            </div>
            <div class="col6 xs-break">
              <h3 class="f-bco m0"><strong>¡Hola!</strong> Jessica Lisseethe</h3>
              <p class="h6 f-bco">Con nuestro seguro AntiFraude, protege tus transferencias y mucho más. Adquiérelo desde $40 pesos mensuales.</p>
              <a href="#" class="btn">Solicítalo</a>
            </div>
          </div></div>

        </div>
		
		
      </div>
	</form:form>
    </article>

  </div></section>


<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>