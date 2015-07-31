<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>


<link href="<c:url value="/resources/css/dropkick.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<section>
	<div class="container">
		<article>
	        <div class="col-izq" id="menu-wrap">
	 		   <%@ include file="/WEB-INF/views/site/comun/menu.jsp"%> 
	        </div>
			<div class="col-der relative">
				<div class="contenido">
					<div class="p20">
						<form:form commandName="favoritasModel" method="POST" modelAttribute="favoritasModel"
							action="${context}/transferencias/favoritas/confirmar">
							<h3 class="titulo">
								<spring:message code="afirmenet.transferencias.favoritas.titulo" />
							</h3>
							<p>
								<spring:message code="afirmenet.horarios" />
								<span class="f-verdeO"><c:out value="${horario}" /></span>
							</p>
				            <a href="#" class="cerrar"></a>
				            <div class="ovhidden mb30">
				            	<div class="pasos">
					              <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.seleccionarOperaciones"/></small></span></span>
					              <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
					              <span class="paso col4"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
				            	</div>
				            </div>

							<c:choose>
								<c:when test="${not empty favoritasModel.favoritas}">
									<ul class="guardadas">
										<!-- Inicia iteracion de Favoritos -->
										
										<c:forEach var="favorita" items="${favoritasModel.favoritas}" varStatus="i">

											<c:if test="${favorita.ejecutar}">
								              <li>
								                <div class="row mb10">
								                  <div class="col10">
								                    <p><strong><spring:message code="afirmenet.transferencias.tipo.operacion"/></strong></p>
								                    <p class="f-verdeO">${favorita.tipoTransferencia}</p>                    
								                  </div>
								                  <div class="col2" align="right">
								                    <a class="icon icon-t-minus"></a>
								                    <a class="icon icon-t-plus"></a>
								                  </div>
								                </div>
								                <div class="row">
								                  <div class="col6 xs-break xs-mb15">
													<p>
														<strong><spring:message code="afirmenet.transferencias.origen"/></strong><br> <span
															class="f-verdeO">
															${favorita.origen.nickname} (${favorita.origen.numberMask}) - $${favorita.origen.balanceFormatted} - ${favorita.origen.ccy}</span>
													</p>
								                  </div>
								                  <div class="col6 xs-break">
													<p>
														<strong><spring:message code="afirmenet.transferencias.destino"/></strong><br> <span
															class="f-verdeO">
															${favorita.destino.nickname} (${favorita.destino.numberMask}) - $${favorita.destino.balanceFormatted} - ${favorita.destino.ccy}</span>
													</p>
								                  </div>
								                </div>
								                <div class="detalle row">
								
								                  <div class="col6 off6 xs-break">
								
								                    <div class="mb15">
								                      <p><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></p>
								                      <p class="f-verdeO">$${favorita.amount}</p>
								                    </div>
								
								                    <div class="mb15">
								                      <p><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></p>
								                      <p id="concepto" class="f-verdeO">${favorita.description}</p>
								                    </div>
								
								                    <div class="mb15">
								                      <p><strong><spring:message code="afirmenet.comprobantes.referencia"/></strong></p>
								                      <p class="f-verdeO">${favorita.referenceNumber}</p>
								                    </div>
								
								                    <div class="mb15">
								                      <p><strong><spring:message code="afirmenet.comprobantes.email"/></strong></p>
								                      <p class="f-verdeO">${favorita.emailBeneficiary}</p>
								                    </div>
								
								                    <div class="mb15">
								                      <p><strong><spring:message code="afirmenet.comprobantes.rfc"/></strong></p>
								                      <p class="f-verdeO">${favorita.rfc}</p>
								                    </div>
								
								                    <div class="mb15">
								                      <p><strong><spring:message code="afirmenet.comprobantes.programada"/></strong></p>
								                      <p class="f-verdeO">
								                        <spring:message code="afirmenet.comprobantes.inmediata"/><br>
								                        <spring:message code="afirmenet.comprobantes.hora"/> ${favorita.validationHour}:${favorita.validationMinute} hrs<br>
								                        <spring:message code="afirmenet.comprobantes.dia"/> ${favorita.validationDay} / ${favorita.validationMonth} / ${favorita.validationYear}
								                      </p>
								                    </div>
								
								                  </div>
								                  
								                </div>
								              </li>											
											
											</c:if>
										</c:forEach>
									</ul>
								</c:when>
								<c:otherwise>
									<!-- Mensaje  -->
									<div class="bbot2">
										<div class="mensaje informacion no-flecha">
											<span class="icon icon-eye"></span><span
												class="icon icon-close2"></span>
											<p>
												<strong class="f-azul"><spring:message
														code="afirmenet.transferencias.favoritas.aviso" /></strong><br>
												<spring:message
													code="afirmenet.transferencias.favoritas.sin.operaciones" />
											</p>
										</div>
									</div>
								</c:otherwise>
							</c:choose>							

							<!-- Inicia Acciones -->
					          <div class="bgcrema p20">
					            <p class="f21 mb20"><strong class="f-gris6"><spring:message code="afirmenet.transferencias.pregunta.multiple" /></strong></p>
					            <div class="row">
					              <div class="col6 xs-break xs-mb20">
					                <p class="h6 mb5 f-gris6"><spring:message code="afirmenet.transferencias.clave.dinamica" /></p>
					                <div class="relative input">
					                  <input name="token" maxlength="6" placeholder="<spring:message code="afirmenet.contrato.placeHolder" />" type="password">
					                  <a class="ayuda">?</a>
					                </div>
					              </div>
					
					              <div class="col6 xs-break">
					                <p class="h6 mb5">&nbsp;</p>
					                <div class="acciones" align="right">
					                  <a href="#" class="btn atras mr10" onclick="submitFormAnimate('favoritasModel','/transferencias/favoritas/editar?editable=false'); return false;"><spring:message code="afirmenet.botones.atras" /></a>
					                  <a href="#" class="btn verde" onclick="submitFormAnimate('favoritasModel','transferencias/favoritas/ejecutar'); return false;"><spring:message code="afirmenet.botones.aceptar" /></a>
					                  
					                </div>           
					              </div>
					
					            </div>
					          </div>
						</form:form>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>

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
  