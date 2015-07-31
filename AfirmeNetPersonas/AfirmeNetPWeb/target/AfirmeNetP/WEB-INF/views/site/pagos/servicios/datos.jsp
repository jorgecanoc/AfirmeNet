<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/dropkick.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="<c:url value="/resources/js/vendor/dropkick.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/afirmenet/jquery.maskMoney.js"/>"></script>

<section>
	<div class="container">
		<article>
			<div class="col-izq" id="menu-wrap">
				<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
			</div>
			<form:form commandName="servicio" method="POST"
				modelAttribute="servicio"
				action="servicios/confirmar">
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
									<span class="paso"><span><spring:message code="afirmenet.pago.servicios.paso3" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.confirmar" /></small></span></span>
									<span class="paso"><span><spring:message code="afirmenet.pago.servicios.paso4" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.comprobante" /></small></span></span>
										
								</div>
							</div>

				            <div class="row mb20">
				              <div class="col3 xs-break"><h3 class="f-verdeO m0"><spring:message code="afirmenet.transferencias.paso.datos" /></h3></div>
				              <div class="col6 xs-break"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio" /></span><span class="f-verdeO">*</span></h6></div>
				            </div>   
				            
				            <!-- Icono del Servicio -->
				            <fieldset>
				              <div class="form-label"><label for="importe"><spring:message code="afirmenet.pago.servicios.titulo" /></label></div>
				              <div class="form-input relative">
				                <img src="<c:url value="/resources/img/services/${servicio.imagen}"/>"  height="60" width="78" alt="">
				              </div>
				            </fieldset>
							<!-- Inicia Formulario -->
			
							<c:if test="${servicio.tipoServicio != 'TELEFONOS_DE_MEXICO'}">
								<!-- Numero de servicio  - referenceNumber -->			            			
					            <fieldset>
					              <div class="form-label"><label for="importe"><spring:message code="afirmenet.pago.servicios.referencia" /><span class="f-verdeO">*</span></label></div>
					              <div class="form-input relative">
					                <input name="referenceNumber" id="referenceNumber" placeholder="<spring:message code="afirmenet.placeholder.solonumeros" />" pattern="[0-9]*" class="req onlyNum no-white-space" type="text">
					                <a class="ayuda tooltip t-serv">? <span><span class="icon icon-close2"></span>${servicio.ayuda}<img src="<c:url value="/resources/img/services/${servicio.idServicio}help.png"/>" alt=""></span></a>
					              </div>
					            </fieldset>									
							</c:if>
																
							
							<!-- Formulario Especial para Telefonos de Mexico -->
							<c:if test="${servicio.tipoServicio == 'TELEFONOS_DE_MEXICO'}">
					            <fieldset>
					              <div class="form-label"><label for="importe"><spring:message code="afirmenet.pago.servicios.numero.telefono" /><span class="f-verdeO">*</span></label></div>
					              <div class="form-input">
					                <div class="clearfix">
					                  <div class="form-input fL w25"> 
					                    <input name="lada" placeholder="<spring:message code="afirmenet.placeholder.lada" />" pattern="[0-9]*" class="req onlyNum" type="text" maxlength="2">
					                  </div>
					                  <div class="form-input fR w75">
					                    <input name="numeroTelefonico" placeholder="<spring:message code="afirmenet.placeholder.solonumeros" />" pattern="[0-9]*" class="req onlyNum" type="text">
					                    <a class="ayuda">?</a>
					                  </div>
					                </div>
					              </div>
					            </fieldset>		
					            <!-- Propietario  - beneficiaryName -->		
					            <fieldset>
					              <div class="form-label"><label for="importe"><spring:message code="afirmenet.pago.servicios.propietario" /><span class="f-verdeO">*</span></label></div>
					              <div class="form-input relative">
					                <input name="beneficiaryName" placeholder="<spring:message code="afirmenet.placeholder.nombrecompleto" />" type="text" class="req">
					                <a class="ayuda">?</a>
					              </div>
					            </fieldset>							            					
							</c:if>
	         
 							<!-- Importe  - Amount -->					            		            	
				            <fieldset>
				              <div class="form-label"><label for="importe"><spring:message code="afirmenet.pago.servicios.importe" /><span class="f-verdeO">*</span></label></div>
				              <div class="form-input relative importe">
				                <strong>$</strong>
				                <input name="montoStr"  id="amount" placeholder="<spring:message code="afirmenet.placeholder.importe" />" class="req onlyNum" type="text">
				                <a class="ayuda">?</a>
				              </div>
				            </fieldset>				            		            	
				            	
				     
 							<!-- Concepto  - description -->						            	
				            <fieldset>
				              <div class="form-label"><label for="importe"><spring:message code="afirmenet.pago.servicios.concepto" /><span class="f-verdeO">*</span></label></div>
				              <div class="form-input relative">
				                <input name="description" placeholder="<spring:message code="afirmenet.placeholder.concepto" />" type="text" class="req">
				                <a class="ayuda">?</a>
				              </div>
				            </fieldset>	
				            
				            <spring:message code="afirmenet.transferencias.domingo.programacion.dia.placeholder" var="diaHolder"/>
				            
				            <c:if test="${servicio.tipoServicio == 'GAS_NATURAL_MEXICO'}">
	 							<!-- FechaVencimiento  - servicio.getAnioVencimiento(),servicio.getMesVencimiento() - 1, servicio.getDiaVencimiento() -->						            	
					            <fieldset>
					              <div class="form-label"><label for="importe"><spring:message code="afirmenet.pago.servicios.fechaVencimiento" /><span class="f-verdeO">*</span></label></div>
					              <div class="form-input relative">
					                <input name="fechaVencimiento" id="datepicker" placeholder="${diaHolder}" type="text" class="req">
					                <a class="ayuda">?</a>
					              </div>
					            </fieldset>	
				            </c:if>
				            				            				            
					     </div>      
					     <!-- Seccion de Resumen de Cuenta -->	
				          <div class="bgf1 p20">
				            <p class="h6 m0"><strong><spring:message code="afirmenet.pago.servicios.tipooperacion" /></strong></p>
				            <p class="h6">${servicio.nombre}</p>
				            <div class="row">
				              <div class="col6 xs-break">
				                <div class="mb15">
				                  <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></p>
				                  <p class="h6"><c:out value="${servicio.origen.description} (${servicio.origen.numberMask}) - $${servicio.origen.balanceFormatted} ${servicio.origen.ccy}"/></p>
				                </div>
				              </div>
				
				              <div class="col6 xs-break"> 
				                <p class="h6 m0"><strong><spring:message code="afirmenet.pago.servicios.titulo"/></strong></p>
				                <p>${servicio.nombre}</p>
				              </div>
				            </div>
				          </div>	
				          <!-- Seccion de Programacion -->	
				          <div class="p20 bbot2">
				
				            <div class="clearfix">
				              <input type="checkbox" id="check2" name="datos" class="cbox" />
				              <label for="check2"><spring:message code="afirmenet.transferencias.programar"/></label>
				            </div>
				            <div class="row pt20" style="display: none;">
				              <div class="col6 xs-break xs-mb20">
				                <fieldset>
				                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.fecha"/></label></div>
				                  <div class="form-input w70"><form:input path="inicioProgramacion" id="datepicker" name="inicioProgramacion" placeholder="${diaHolder}" /></div>
				                </fieldset>         				                          
				              </div>
				              <div class="col6 xs-break xs-mb20">
				                <fieldset>
				                  <div class="form-label"><label for="importe"><spring:message code="afirmenet.transferencias.domingo.programacion.hora"/><span class="f-verdeO">*</span></label></div>
				                  <div class="form-input w60 no-bg">
				                  <select name="horaProgramacion" class="drop req">
									<option value ="">Seleccionar Hora</option>
									<c:forEach var="hora" items="${mapHoras}">
									<option value="${hora.key}">${hora.value}</option>
									</c:forEach>
				                  </select>
				                  </div>
				                </fieldset>  
                
				              </div>
				            </div>
				          </div>				          
				          
				          <!-- Seccion de Acciones -->	
				          <div class="p20">
				            <div class="row acciones" align="right">
				                <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
				                <a href="#" class="btn verde"><spring:message code="afirmenet.botones.continuar" /></a>
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
			submitFormAnimate($('#servicio').attr('id'), 'servicios/seleccion');
		});	
			
		$('a.btn.verde').click(function() {
			if (validForm($('#servicio').attr('id')))
				submitFormAnimate($('#servicio').attr('id'), $('#servicio').attr('action'));
		});	
		
	      // Radio
	      $('.radio').click(function(){
	        if( $('#radio3').is(':checked') ) $('#otro-monto').slideDown();
	        else $('#otro-monto').slideUp();
	      });
	
	      // Checkboxes
	      $('.cbox').click(function(){
	        if( $(this).is(':checked') ) $(this).parent().next().slideDown();
	        else $(this).parent().next().slideUp();
	      });
	
	      // Fecha
	      var picker = new Pikaday({
	        field: document.getElementById('datepicker'),
	        //maxDate: moment().startOf('day').toDate(),
	        defaultDate: new Date(Date.now()),
	        format: 'D/MMMM/YYYY',
	        onSelect: function(){ $('#datepicker').css({'color':'#008d36', 'text-transform': 'uppercase'}); }
	      });
	
	
	      $(document).on('touchstart', function(e) {
	        var $clicked = $(e.target);
	        if( ! $clicked.parents().hasClass("pika-single") && !$clicked.hasClass("pika-single") ){
	          $('.pika-single').addClass('is-hidden');
	        }
	      });
	
	      // Dropdown
	      $('.drop').dropkick({ 
	        mobile: true,
	        change: function(){ 
	          $(this.data.elem).find('.dk-selected').addClass('f-verde');
	        }
	      }); 	
	      
	      $('#amount').maskMoney();
	      


			$('.no-white-space').change(function() {
					$(this).val($(this).val().replace(/\s/g, ""));
			});

	});
</script>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>