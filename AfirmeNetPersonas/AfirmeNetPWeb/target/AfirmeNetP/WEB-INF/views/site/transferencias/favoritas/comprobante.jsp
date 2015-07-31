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

      <div class="col-der relative">

        <div class="contenido">
       	  <!--INCLUDE DE ERRORES PARA TRANSFERENCIAS-->
	   	  <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>		
          <div class="notificacion bgturq">
            <a class="icon icon-close2"></a>
            <div class="clearfix"><span class="icon icon-success"></span><p class="f21 m0"><strong><spring:message code="afirmenet.comprobantes.mensaje"/></strong><br><spring:message code="afirmenet.comprobantes.mensaje2"/></p></div>
          </div>
			
          <div class="p20">

            <h3 class="titulo"><spring:message code="afirmenet.transferencias.favoritas.titulo" /></h3>
            <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>

            <a href="${context}/consultas/resumen-de-mis-cuentas.htm" class="cerrar"></a>
            <div class="ovhidden mb30">
            	<div class="pasos">
	              <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.seleccionarOperaciones"/></small></span></span>
	              <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
	              <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            	</div>
			</div>
			
            <h3 class="f-verdeO"><span><spring:message code="afirmenet.comprobante"/></span></h3>

          </div>		
		
		  <ul class="guardadas">
	  		<c:forEach var="favorita" items="${favoritasModel.comprobantes}">
				<li class="comprobante">
				
					<c:choose>
						<c:when test="${favorita.tipoTransferencia == 'PAGO_DE_SERVICIOS'}">
							<div>
								<div class="row mb10">
									<div class="col4">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.tranferestado"/></strong>
										</p>
										<p class="f-verdeO"><spring:message code="afirmenet.comprobantes.exitosa"/></p>
									</div>
									<div class="col7">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.rastreo"/></strong>
										</p>
										<p class="f-verdeO">${favorita.afirmeNetReference}</p>
									</div>
									<div class="col1" align="right">
										<a class="icon icon-t-plus"></a> <a class="icon icon-t-minus"></a>
									</div>
								</div>
								<div class="row ocultar">
									<div class="col4">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.tipotransfer"/></strong>
										</p>
										<p class="f-verdeO">${favorita.tipoTransferencia}</p>
									</div>
									<div class="col3">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.importe"/></strong>
										</p>
										<p class="f-verdeO">$${favorita.amount}</p>
									</div>
									<div class="col5">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.referencia"/></strong>
										</p>
										<p class="f-verdeO">${favorita.description}</p>
									</div>
								</div>
								<div class="detalle">
									<div class="btb mb15">
										<div class="row">
		
											<div class="col6">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.tipotransfer"/></strong>
												</p>
												<p class="f-verdeO">${favorita.tipoTransferencia}</p>
											</div>
											<div class="col6">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.folioAfirme"/></strong>
												</p>
												<p class="f-verdeO">${favorita.afirmeNetReference}</p>
											</div>
		
										</div>
									</div>
		
									<div class="row">
										<div class="col6 xs-break">
											<div class="mb15">
												<h6 class="m0">
													<strong><spring:message code="afirmenet.transferencias.origen" />:</strong>
												</h6>
												<p class="f-verdeO">${favorita.origen.nickname} (${favorita.origen.numberMask}) -- $${favorita.origen.balanceFormatted} - ${favorita.origen.ccy}</p>
											</div>
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.contrato" /></strong>
												</p>
												<p class="f-verdeO">${favorita.contractId}</p>
											</div>
										</div>
										<div class="col6 xs-break">
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.pago.servicios.titulo" />:</strong>
												</p>
												<p class="f-verdeO">${favorita.tipoServicio}</p>
											</div>										
							               <c:if test="${favorita.tipoServicio != 'TELEFONOS_DE_MEXICO'}">
								                <div class="mb15">
								                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.referencia"/>:</strong></h6>
								                  <p class="f-verdeO">${favorita.referenceNumber}</p>
								                </div>
							               </c:if>
										   <c:if test="${favorita.tipoServicio == 'TELEFONOS_DE_MEXICO'}">
								                <div class="mb15">								
								                  <h6 class="m0"><strong><spring:message code="afirmenet.pago.servicios.numero.telefono"/>:</strong></h6>
								                  <p class="f-verdeO">${favorita.referenceNumber}</p>
								                </div>		
							                  
								                <div class="mb15">
								                  <h6 class="m0"><strong><spring:message code="afirmenet.pago.servicios.propietario"/>:</strong></h6>
								                  <p class="f-verdeO">${favorita.beneficiaryName}</p>
								                </div>			   
										   </c:if>
								
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.importe" /></strong>
												</p>
												<p class="f-verdeO">$${favorita.amount}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.comision" /></strong>
												</p>
												<p class="f-verdeO">$${favorita.commision} + IVA</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.concepto" /></strong>
												</p>
												<p class="f-verdeO">${favorita.description}</p>
											</div>	
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.transferencias.email" />:</strong>
												</p>
												<p class="f-verdeO">${favorita.emailBeneficiary}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.transferencias.IVA" />:</strong>
												</p>
												<p class="f-verdeO">$${favorita.iva}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.programada" /></strong>
												</p>
												<p class="f-verdeO">
													<spring:message code="afirmenet.comprobantes.inmediata" /><br> <spring:message code="afirmenet.comprobantes.hora" />${transferencia.validationHour}:${transferencia.validationMinute} hrs<br> <spring:message code="afirmenet.comprobantes.dia" /> ${transferencia.validationDay} /
													${favorita.validationMonth} / ${favorita.validationYear} 
												</p>
											</div>
		
										</div>
		
									</div>
								</div>
							</div>						
						
						</c:when>
						<c:otherwise>
							<div>
								<div class="row mb10">
									<div class="col4">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.tranferestado"/></strong>
										</p>
										<p class="f-verdeO"><spring:message code="afirmenet.comprobantes.exitosa"/></p>
									</div>
									<div class="col7">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.rastreo"/></strong>
										</p>
										<p class="f-verdeO">${favorita.trackingCode}</p>
									</div>
									<div class="col1" align="right">
										<a class="icon icon-t-plus"></a> <a class="icon icon-t-minus"></a>
									</div>
								</div>
								<div class="row ocultar">
									<div class="col4">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.tipotransfer"/></strong>
										</p>
										<p class="f-verdeO">${favorita.tipoTransferencia}</p>
									</div>
									<div class="col3">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.importe"/></strong>
										</p>
										<p class="f-verdeO">$${favorita.amount}</p>
									</div>
									<div class="col5">
										<p>
											<strong><spring:message code="afirmenet.comprobantes.referencia"/></strong>
										</p>
										<p class="f-verdeO">${favorita.description}</p>
									</div>
								</div>
								<div class="detalle">
									<div class="btb mb15">
										<div class="row">
		
											<div class="col6">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.tipotransfer"/></strong>
												</p>
												<p class="f-verdeO">${favorita.tipoTransferencia}</p>
											</div>
											<div class="col6">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.folioAfirme"/></strong>
												</p>
												<p class="f-verdeO">${favorita.afirmeNetReference}</p>
											</div>
		
										</div>
									</div>
		
									<div class="row">
										<div class="col6 xs-break">
											<div class="mb15">
												<h6 class="m0">
													<strong><spring:message code="afirmenet.transferencias.origen" /></strong>
												</h6>
												<p class="f-verdeO">${favorita.origen.nickname} (${favorita.origen.numberMask}) -- $${favorita.origen.balanceFormatted} - ${favorita.origen.ccy}</p>
											</div>
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.contrato" /></strong>
												</p>
												<p class="f-verdeO">${favorita.contractId}</p>
											</div>
										</div>
										<div class="col6 xs-break">
											<div class="mb15">
												<h6 class="m0">
													<strong><spring:message code="afirmenet.transferencias.destino" /></strong>
												</h6>
												<p class="f-verdeO">${favorita.destino.nickname} (${favorita.destino.numberMask}) -- $${favorita.destino.balanceFormatted} - ${favorita.destino.ccy}</p>
		
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.importe" /></strong>
												</p>
												<p class="f-verdeO">$${favorita.amount}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.comision" /></strong>
												</p>
												<p class="f-verdeO">$${favorita.commision} + IVA</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.concepto" /></strong>
												</p>
												<p class="f-verdeO">${favorita.description}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.referencia" /></strong>
												</p>
												<p class="f-verdeO">${favorita.referenceNumber}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.transferencias.email" /></strong>
												</p>
												<p class="f-verdeO">${favorita.emailBeneficiary}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.transferencias.rfc" /></strong>
												</p>
												<p class="f-verdeO">${favorita.rfc}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.transferencias.IVA" /></strong>
												</p>
												<p class="f-verdeO">$${favorita.iva}</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.programada" /></strong>
												</p>
												<p class="f-verdeO">
													<spring:message code="afirmenet.comprobantes.inmediata" /><br> <spring:message code="afirmenet.comprobantes.hora" />${transferencia.validationHour}:${transferencia.validationMinute} hrs<br> <spring:message code="afirmenet.comprobantes.dia" /> ${transferencia.validationDay} /
													${favorita.validationMonth} / ${favorita.validationYear} 
												</p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.banco" /></strong>
												</p>
												<p class="f-verdeO">${favorita.bankReceiving} </p>
											</div>
		
											<div class="mb15">
												<p>
													<strong><spring:message code="afirmenet.comprobantes.plaza" /></strong>
												</p>
												<p class="op50">No se indicó</p>
											</div>
		
										</div>
		
									</div>
								</div>
							</div>						
						</c:otherwise>
					</c:choose>

				</li>
			</c:forEach>	
		  </ul>

	
            <div class="bbot2 btop2 p15-10"><div class="row">
              <div class="col4 xs-break xs-center xs-mb20"><p class="f21 m0"><spring:message code="afirmenet.comprobantes.impresion"/></p></div>
              <div class="col4 xs-break xs-center"><a href="#" class="h6 m0 f-verde"><span class="icon icon-pdf f21 mr10"></span> <spring:message code="afirmenet.comprobantes.pdf"/> <span class="hide-xs"><spring:message code="afirmenet.comprobantes.pdf2"/></span></a></div>
              <div class="col4 hide-xs"><a href="#" class="h6 m0 f-verde"><span class="icon icon-print f21 mr10"></span> <spring:message code="afirmenet.comprobantes.imprimir"/></a></div>
            </div></div>

            <div class="p15-20 xs-p100" align="center">
              <p class="f21"><spring:message code="afirmenet.comprobantes.recomendadas"/></p>
              <div class="acciones mt10 flex">
                <a href="#" class="btn atras mr10 xs-col12 xs-m0">consultar movimientos</a>
                <a href="#" class="btn verde xs-col12 xs-mb20">ASOCIAR CUENTA A CELULAR</a>
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

    </article>

  </div></section>
  <script type="text/javascript">
    $(document).ready(function(){

      // Interacciones listado
      $('.guardadas .icon-t-plus').click(function(){
        $('.guardadas .comprobante').removeClass('extendido').find('.detalle').slideUp();
        $(this).closest('li').addClass('extendido').find('.detalle').slideDown();
      });
      $('.guardadas .icon-t-minus').click(function(){
        var _this = $(this).closest('li');
        _this.find('.detalle').slideUp(300,function(){ _this.removeClass('extendido'); });
      });

      $('.notificacion .icon-close2').click(function(){ $(this).parent().slideUp(); });

    });
  </script>

  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>