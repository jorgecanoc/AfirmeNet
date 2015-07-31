<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>"
	rel="stylesheet" type="text/css" />

<section>
	<div class="container">
		<article>
			<div class="col-izq" id="menu-wrap">
				<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
			</div>
			<form:form commandName="servicio" method="POST"
				modelAttribute="servicio"
				action="servicios/ejecutar">
				<div class="col-der relative">
					<div class="contenido">
						<div class="p20">
							<h3 class="titulo">
								<spring:message code="afirmenet.pago.servicios.basicos.titulo" />
							</h3>
							<p>
								<spring:message code="afirmenet.horarios" />
								<span class="f-verdeO"><c:out value="${horario}" /></span>
							</p>
							<a href="#" class="cerrar"></a>
							<div class="ovhidden mb30">
								<div class="pasos">
									<span class="paso activo"><span><spring:message code="afirmenet.pago.servicios.paso1" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.servicio" /></small></span></span>
									<span class="paso activo"><span><spring:message code="afirmenet.pago.servicios.paso2" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.datos" /></small></span></span> 
									<span class="paso activo"><span><spring:message code="afirmenet.pago.servicios.paso3" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.confirmar" /></small></span></span>
									<span class="paso"><span><spring:message code="afirmenet.pago.servicios.paso4" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.comprobante" /></small></span></span>
										
								</div>
							</div>

				            <div class="mb30">
				              <h3 class="f-verdeO"><spring:message code="afirmenet.confirmar"/></h3>
				            </div>  
				            <div class="row">
				
				              <div class="col6 xs-break">
				
				                <div class="mb20">
				                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
				                  <p class="h6 f-verdeO">${servicio.origen.description} (${servicio.origen.numberMask}) - $${servicio.origen.balanceFormatted} - ${servicio.origen.ccy}</p>
				                </div>
				              </div>	
				              			            
				              <div class="col6 xs-break">
								<!-- Icono del Servicio -->
				                <div class="mb15">
					              <div class="form-input relative">
					                <img src="<c:url value="/resources/img/services/${servicio.imagen}"/>"  height="60" width="78" alt="">
					              </div>
				                </div>
				                
								<c:if test="${servicio.tipoServicio != 'TELEFONOS_DE_MEXICO'}">
					                <div class="mb15">
					                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.referencia"/></strong></h6>
					                  <p class="h6 f-verdeO">${servicio.referenceNumber}</p>
					                </div>										
								</c:if>
								<c:if test="${servicio.tipoServicio == 'TELEFONOS_DE_MEXICO'}">
					                <div class="mb15">								
					                  <h6 class="m0"><strong><spring:message code="afirmenet.pago.servicios.numero.telefono"/></strong></h6>
					                  <p class="h6 f-verdeO">${servicio.lada} - ${servicio.numeroTelefonico}</p>
					                </div>		
				                  
					                <div class="mb15">
					                  <h6 class="m0"><strong><spring:message code="afirmenet.pago.servicios.propietario"/></strong></h6>
					                  <p class="h6 f-verdeO">${servicio.beneficiaryName}</p>
					                </div>					                  						
								</c:if>
			                				                				
				                <div class="mb15">
				                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></h6>
				                  <p class="h6 f-verdeO">$ ${servicio.amount}</p>
				                </div>
				
				                <div class="mb15">
				                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.concepto"/></strong></h6>
				                  <p id="concepto" class="h6 f-verdeO">${servicio.description}</p>
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
				                    <spring:message code="afirmenet.comprobantes.hora"/> <span class="f-verdeO">${servicio.programmingHour}:${servicio.programmingMinute} hrs</span><br>
				                    <spring:message code="afirmenet.comprobantes.fechaInicio"/> <span class="f-verdeO">${servicio.programmingDate}</span><br>
				                  </p>
				                </div>				                
							</div>
		            
				           </div>
				           <c:if test="${servicio.tipoServicio == 'TELEFONOS_DE_MEXICO' || servicio.tipoServicio == 'CABLEVISION'}">
					          <div class="favorita p20"><div class="row">
					
					            <div class="col8 xs-break xs-mb20">
					              <div class="clearfix">
					                <span class="icon icon-star-full f42 mr10 fL"></span>
					                <p class="fL m0 mt5"><strong class="h6"><spring:message code="afirmenet.favoritas"/></strong><br><span class="f21"><spring:message code="afirmenet.favoritas.pregunta"/></span></p>
					              </div>
					            </div>
						
					            <div class="col4 xs-break mt15">
					              <input type="checkbox" id="check1" name="agregarFavoritas" class="cbox f-bco" />
					              <label for="check1"><spring:message code="afirmenet.favoritas.guardar"/></label>           
					            </div>
					
					          </div></div>					           
				           </c:if>

					          			           
				          	<div class="bgcrema p20">
				
				            <p class="f21 mb20"><strong class="f-gris6"><spring:message code="afirmenet.transferencias.pregunta.finalizar"/></strong></p>
				            <div class="row">
				
				              <div class="col6 xs-break xs-mb20">
				                <p class="h6 mb5 f-gris6"><spring:message code="afirmenet.transferencias.clave.dinamica"/></p>
				                <div class="relative input">
				                  <spring:message code="afirmenet.contrato.placeHolder" var="passwordHolder"/>
				                  <input name="token" maxlength="6" placeholder="${passwordHolder}" type="password">
				                  <a class="ayuda">?</a>
				                </div>
				              </div>
				
				              <div class="col6 xs-break">
				                <p class="h6 mb5">&nbsp;</p>
						            <div class="acciones" align="right">
						              <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
						                              <button onclick="submitFormAnimate('servicio','servicios/ejecutar.htm'); return false;"
										class="btn verde"><spring:message code="afirmenet.botones.aceptar" /></button>
						            </div>          
				              </div>
				
				            </div>
				          	</div>				            
						</div>			          				     
					</div>
					
				</div>
			</form:form>
		</article>
	</div>
</section>

<script type="text/javascript">
	$(document).ready(function() {
		$('a.btn.atras').click(function() {
			submitFormAnimate($('#servicio').attr('id'), 'servicios/capturar');
		});	
			
		$('a.btn.verde').click(function() {
			if (validForm($('#servicio').attr('id')))
				submitFormAnimate($('#servicio').attr('id'), $('#servicio').attr('action'));
		});	
		
	      // Checkboxes
	      $('.favorita .cbox').click(function(){
	        if( $(this).is(':checked') ){ $('.favorita').addClass('act'); $('.favorita .f21').html($('#concepto').html()); }
	        else { $('.favorita').removeClass('act'); $('.favorita .f21').html('¿Guardar como una operación favorita?'); }
	      });
	});	
</script>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>