<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>


<link href="<c:url value="/resources/css/dropkick.css"/>"
	rel="stylesheet" type="text/css" />
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
						<form:form commandName="favoritasModel" method="POST"
							modelAttribute="favoritasModel"
							action="transferencias/favoritas/confirmar">
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
									<span class="paso col4 activo"><span><spring:message
												code="afirmenet.transferencias.paso1" /><small
											class="hide-xs"><spring:message
													code="afirmenet.transferencias.paso.seleccionarOperaciones" /></small></span></span>
									<span class="paso col4"><span><spring:message
												code="afirmenet.transferencias.paso2" /><small
											class="hide-xs"><spring:message
													code="afirmenet.transferencias.paso.confirmar" /></small></span></span> <span
										class="paso col4"><span><spring:message
												code="afirmenet.transferencias.paso3" /><small
											class="hide-xs"><spring:message
													code="afirmenet.transferencias.paso.comprobante" /></small></span></span>
								</div>
							</div>

							<div class="row mb10">
								<div class="col11">
									<div class="clearfix">

										<h3 class="fL f-verdeO m0">
											<spring:message
												code="afirmenet.transferencias.paso.seleccionarOperaciones" />
										</h3>
										<h6 class="fL m0 mt7 ml20 xs-m0">
											<span class="op50"><spring:message
													code="afirmenet.transferencias.campo.obligatorio" /></span><span
												class="f-verdeO">*</span>
										</h6>
									</div>
									<c:if test="${not empty favoritasModel.favoritas}">
										<p class="h6">
											<spring:message
												code="afirmenet.transferencias.seleccionar.operacion" />
										</p>
									</c:if>
								</div>
								<div class="col1" align="right">
									<a href="#" class="icon icon-info fR tooltip"><span><span
											class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN
													DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet,
												consectetur adipisicing elit, sed do eiusmod tempor
												incididunt ut labore et dolore magna aliqua. Ut enim ad
												minim veniam, quis nostrud exercitation ullamco laboris nisi
												ut aliquip ex ea</span></span></a>
								</div>
							</div>
							<c:choose>
								<c:when test="${not empty favoritasModel.favoritas}">
									<ul class="guardadas favs">
										<!-- Inicia iteracion de Favoritos -->

										<c:forEach var="favorita" items="${favoritasModel.favoritas}"
											varStatus="i">

											<form:hidden path="favoritas[${i.index}].ejecutar"
												name="favoritas[${i.index}].ejecutar" />
											<c:set var="cssClass" value="" />	
											<c:choose>
												<c:when test="${favorita.ejecutar}">
													<c:set var="requerido" value="req" />
												</c:when>
												<c:otherwise>
													<c:set var="cssClass" value="op50" />
													<c:set var="requerido" value="" />
												</c:otherwise>
											</c:choose>
											<li class="${cssClass}">

												<div class="row mb10">
													<div class="col1 xs-col2">
														<form:checkbox
															path="favoritas[${i.index}].agregarFavoritas"
															id="check0${i.index}"
															name="favoritas[${i.index}].agregarFavoritas"
															class="cbox" value="favoritas[${i.index}].ejecutar" />
														<label for="check0${i.index}"></label>
													</div>
													<div class="col10 xs-col8">
														<div class="row">
															<div class="col6 xs-break xs-mb20">
																<div class="mb10">
																	<p>
																		<spring:message
																			code="afirmenet.transferencias.concepto" />
																		<span class="f-verdeO">*</span>
																	</p>
																	<div class="form-input w100">
																		<form:input path="favoritas[${i.index}].description"
																			name="favoritas[${i.index}].description"
																			disabled="${!editable}"
																			value="${favorita.description}"
																			placeholder="${favorita.description}" />
																	</div>
																</div>
																<p class="mb20">
																	<strong>${favorita.tipoTransferencia}</strong>
																</p>
																<p>
																	<strong><spring:message
																			code="afirmenet.transferencias.origen" /></strong><br> <span
																		class="f-verdeO"><c:out value="${favorita.origen.description} (${favorita.origen.numberMask}) - $${favorita.origen.balanceFormatted} ${favorita.origen.ccy}"/></span>
																		
																</p>
																<p>
																	<strong><spring:message
																			code="afirmenet.transferencias.destino" /></strong><br> <span
																		class="f-verdeO"> 
																		<c:out value="${favorita.destino.description} (${favorita.destino.numberMask}) - $${favorita.destino.balanceFormatted} ${favorita.destino.ccy}"/></span>
																</p>
															</div>
															<div class="col6 xs-break xs-mb20">
																<div class="mb10 t-right">
																	<p>
																		<spring:message
																			code="afirmenet.transferencias.importe" />
																		<span class="f-verdeO">*</span>
																	</p>
																	<div class="form-input w100 relative importe">
																		<form:input path="favoritas[${i.index}].amount"
																			name="favoritas[${i.index}].amount"
																			disabled="${!editable && !favoritas.ejecutar}"
																			value="${favorita.amount}" class="${requerido}"
																			placeholder="${favorita.amount}" />

																	</div>
																</div>
																<div class="mb10 t-right">
																	<p>
																		<spring:message
																			code="afirmenet.transferencias.referencia" />
																		<span class="f-verdeO">*</span>
																	</p>
																	<div class="form-input w100">
																		<form:input
																			path="favoritas[${i.index}].referenceNumber"
																			name="favoritas[${i.index}].referenceNumber"
																			disabled="${!editable}" class="${requerido}"
																			value="${favorita.userReference}"
																			placeholder="${favorita.userReference}" />

																	</div>
																</div>
																<div class="t-right">
																	<p>
																		<strong><spring:message
																				code="afirmenet.transferencias.email" /></strong><br> <span
																			class="f-verdeO">${favorita.emailBeneficiary}</span>
																	</p>
																</div>
															</div>
														</div>
													</div>
													<div class="col1 xs-col2">
														<c:choose>
															<c:when test="${editable}">
																<a class="icon icon-check f-verdeO"
																	onclick="submitFormAnimate('favoritasModel','transferencias/favoritas/editar?editable=false'); return false;"></a>
																<br>
																<a href="#" class="icon icon-return f-rojo"
																	onclick="submitFormAnimate('favoritasModel','transferencias/favoritas/editar?editable=false'); return false;"></a>
															</c:when>
															<c:otherwise>
																<a href="#" class="icon icon-t-edit"
																	onclick="submitFormAnimate('favoritasModel','transferencias/favoritas/editar?editable=true'); return false;"></a>
															</c:otherwise>
														</c:choose>
													</div>
												</div>
											</li>
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
							<div class="p20">
								<div class="row acciones">
									<div class="col7 xs-break xs-center xs-mb20">
										<a class="btn gris">Configurar operaciones favoritas</a>
									</div>
									<c:if test="${not empty favoritasModel.favoritas}">
										<div class="col5 xs-break xs-center" align="right">
											<a href="#" class="btn verde hidden"><spring:message
													code="afirmenet.botones.continuar" /></a>
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
	function continuar() {
		//Validar que este chekeado al menos 1 favorito
		if($("input:checked").length > 0){
			$('.acciones').find('.hidden').removeClass('hidden');
		}else{
			$('.acciones').find('.hidden').addClass('hidden');
		}
		
	}
	$(document).ready(
			function() {
				$('a.btn.verde').click(
						function() {
							submitFormAnimate($('#favoritasModel').attr('id'),
									$('#favoritasModel').attr('action'));
						});
				// Interacciones listado
				$('.cbox').click(function() {
					if ($('.cbox').is(':checked')) {
						$('.hidden').removeClass('hidden');
					} else {
						$('.acciones .col5').addClass('hidden');
					}
					if ($(this).is(':checked')) {
						$('.hidden').removeClass('hidden');
						$(this).closest('li').removeClass('op50');
					} else {
						$(this).closest('li').addClass('op50');
					}					
				});
			
				continuar();
			});

	$(document).on(
			'change',
			'.cbox',
			function() {
				var index = $(this).attr('id').substring(
						$(this).attr('id').length - 1);
				$('input[name="favoritas[' + index + '].ejecutar"]').val(
						$('#' + $(this).attr('id')).is(":checked"));
				if($('#' + $(this).attr('id')).is(":checked")){
					continuar();
				}
			});
			
			
</script>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>