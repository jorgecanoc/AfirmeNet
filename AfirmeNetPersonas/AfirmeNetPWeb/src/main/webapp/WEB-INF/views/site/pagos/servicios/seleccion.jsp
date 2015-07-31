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

			<div class="col-der relative">
				<div class="contenido">
					<!--INCLUDE DE ERRORES PARA TRANSFERENCIAS-->
					<%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>
					<div class="p20">
						<form:form commandName="servicio" method="POST"
							modelAttribute="servicio"
							action="servicios/confirmar">
							<form:hidden path="idServicio" id="idServicio"/>
							<form:hidden path="idComercio" id="idComercio"/>
							<form:hidden path="idServicio400" id="idServicio400"/>
							<form:hidden path="nombre" id="nombre"/>
							<form:hidden path="ayuda" id="ayuda"/>
							<form:hidden path="imagen" id="imagen"/>	
																		
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
									<span class="paso"><span><spring:message code="afirmenet.pago.servicios.paso2" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.datos" /></small></span></span> 
									<span class="paso"><span><spring:message code="afirmenet.pago.servicios.paso3" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.confirmar" /></small></span></span>
									<span class="paso"><span><spring:message code="afirmenet.pago.servicios.paso4" /><small class="hide-xs"><spring:message code="afirmenet.pago.servicios.paso.comprobante" /></small></span></span>
										
								</div>
							</div>

				          <div class="clearfix mb10">
				            <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
				          </div>
						 
						 <c:if test="${!serviciosActivados}">
					          <div class="bbot2">
					            <div class="mensaje informacion no-flecha"><span class="icon icon-eye"></span><span class="icon icon-close2"></span><p><strong class="f-azul"><spring:message code="afirmenet.aviso" /></strong><br><spring:message code="afirmenet.pago.servicios.sin.operaciones" /></p></div>
					          </div>						 
						 </c:if>
				         <c:if test="${tiempoNoCumplido}">
					          <div>
					            <div class="mensaje exito no-flecha"><span class="icon icon-success f-turq"></span><span class="icon icon-close2"></span><p><strong class="f-turq"><spring:message code="afirmenet.correcto" /></strong><br><spring:message code="afirmenet.pago.servicios.leyenda.activacion" arguments="${minutosActivacion}" htmlEscape="false"/></p></div>
					          </div>				          
				         </c:if>
				         <c:if test="${mostrarServicios}">
				         	<c:if test="${!tiempoNoCumplido}">
					          <div class="mb20">
				                <h6 class="mb5"><spring:message code="afirmenet.transferencias.origen"/></h6>
				                <form:select id="origen" name="origen" path="origen.number" cssClass="drop req">
				                	<option value="">Seleccionar</option>
								    <c:forEach var="cuentaPropia" items="${cuentasPropias}">
								        <form:option value="${cuentaPropia.number}"><c:out value="${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} ${cuentaPropia.ccy}"/></form:option>
								    </c:forEach>
								</form:select>						          
					          </div>				         	
				         	</c:if>
				           <!-- Inicia Servicios Disponibles -->
				          <div class="mb20">  
				            <ul class="servicios ${tiempoNoCumplido ? 'op50': ''} clearfix">				            
				            	<c:forEach items="${servicios}" var="servicio">
									<li><a data-color="${servicio.SERCOLOR}" class="${not empty servicio.SERIMGH ? 'imgdif': ''}" onclick="onSelectServicio('${servicio.SERTYP}', '${servicio.SERCOM}','${servicio.SERNAM}','${servicio.SERHLP}','${servicio.SERIMG}', '${servicio.SERDTR}');">
											<div class="mb10">
												<img src="<c:url value="/resources/img/services/${servicio.SERIMG}"/>" height="60"
													width="92" alt="${servicio.SERNAM}" >						
												<c:if test="${not empty servicio.SERIMGH && !tiempoNoCumplido}">
													<img src="<c:url value="/resources/img/services/${servicio.SERIMGH}"/>" alt="" class="hidden">
												</c:if>	
											</div>
											<span>${servicio.SERNOM}</span><span class="f-bco hidden"><spring:message code="afirmenet.pagar" /></span>
										</a>
									</li>							
								</c:forEach>
				            </ul>
				          </div>
				         
				         </c:if>

							<!-- Inicia Acciones -->
							<div class="p20">
								<div class="row acciones">
									<c:if test="${!serviciosActivados}">
										<div class="col7 xs-break xs-center xs-mb20">
											<a href="${context}/servicios/contrato" data-fancybox-type="iframe" class="btn verde modal fR"><spring:message code="afirmenet.pago.servicios.acciones.activar"/></a>								
										</div>									
									</c:if>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>

<script type="text/javascript">
	$(document).ready(function() {
	    $('.modal').fancybox({
	        maxHeight: 600,
	        fitToView: false,
	        width: '90%',
	        height: '80%',
	        padding: 0
	    });

	    $('.drop').dropkick({
	        mobile: true,
	        change: function(dk) {
	            $(this.data.elem).find('.dk-selected').addClass('f-verde');
	        }
	    });
	    // Solo para el ejemplo
	    $('.dropfinal').dropkick({
	        mobile: true,
	        change: function() {
	            $(this.data.elem).find('.dk-selected').addClass('f-verde');
	            $('.acciones .hidden').removeClass('hidden');
	        }
	    });

	    var flag = '${tiempoNoCumplido}';

	    if (flag == 'false') {
	        $('.servicios a').hover(
	            function() {
	                $(this).find('span').toggleClass('hidden');
	                if ($(this).hasClass('imgdif'))
	                    $(this).find('img').toggleClass('hidden');
	                else
	                    $(this).find('img').toggleClass('filter');
	                $(this).css('background-color', '#' + $(this).data('color'));
	            },
	            function() {
	                $(this).find('span').toggleClass('hidden');
	                if ($(this).hasClass('imgdif'))
	                    $(this).find('img').toggleClass('hidden');
	                else
	                    $(this).find('img').toggleClass('filter');
	                $(this).css('background-color', 'transparent');
	            }
	        );
	    }
	});

	function activaServicios() {
	    submitFormAnimate($('#servicio').attr('id'), 'servicios/aceptaContrato');
	}

	function onSelectServicio(idServicio, idComercio, nombre, ayuda, imagen,idServicio400) {
	    if (validForm($('#servicio').attr('id'))) {
	        $('#idServicio').val(idServicio);
	        $('#idComercio').val(idComercio);
	        $('#nombre').val(nombre);
	        $('#ayuda').val(ayuda);
	        $('#imagen').val(imagen);
	        $('#idServicio400').val(idServicio400);	        
			submitFormAnimate($('#servicio').attr('id'), 'servicios/capturar');
	    }
	}
	
</script>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>