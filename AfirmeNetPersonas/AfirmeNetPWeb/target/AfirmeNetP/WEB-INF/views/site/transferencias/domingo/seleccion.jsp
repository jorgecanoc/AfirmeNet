<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$('document').ready(
			function() {
				$('.drop').dropkick(
						{
							mobile : true,
							change : function(dk) {
								$(this.data.elem).find('.dk-selected')
										.addClass('f-verde');
								continuar();
							}
						});

				$('a.btn.verde').click(
						function() {
							submitFormAnimate($('#transferencia').attr('id'),
									$('#transferencia').attr('action'));
						});

				var $btnContinuar;

				function continuar() {
					// se almacena el elemento solamente si este se encuentra oculto
					if ($('.acciones').find('.hidden').length)
						$btnContinuar = $('.acciones').find('.hidden');
					// si ambos selects contienen valores, el elemento se muestra, de lo contraro se oculta
					if (validForm($('#transferencia').attr('id')))
						$btnContinuar.removeClass('hidden');
					else
						$btnContinuar.addClass('hidden');
				}
			});
</script>

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

						<form:form commandName="transferencia" method="POST"
							action="transferencias/domingo/datos.htm">

							<h3 class="titulo">
								<spring:message code="afirmenet.transferencias.domingo.titulo" />
							</h3>
							<p>
								<spring:message code="afirmenet.horarios" />
								<span class="f-verdeO"><c:out value="${horario}" /></span>
							</p>

							<a href="#" class="cerrar"></a>
							<div class="ovhidden mb30">
								<div class="pasos">
									<span class="paso activo"><span><spring:message
												code="afirmenet.transferencias.paso1" /><small
											class="hide-xs"><spring:message
													code="afirmenet.transferencias.paso.cuentas" /></small></span></span> <span
										class="paso"><span><spring:message
												code="afirmenet.transferencias.paso2" /><small
											class="hide-xs"><spring:message
													code="afirmenet.transferencias.paso.datos" /></small></span></span> <span
										class="paso"><span><spring:message
												code="afirmenet.transferencias.paso3" /><small
											class="hide-xs"><spring:message
													code="afirmenet.transferencias.paso.confirmar" /></small></span></span> <span
										class="paso"><span><spring:message
												code="afirmenet.transferencias.paso4" /><small
											class="hide-xs"><spring:message
													code="afirmenet.transferencias.paso.comprobante" /></small></span></span>
								</div>
							</div>


							<div class="clearfix mb10">
								<h3 class="f-verdeO fL">
									<spring:message code="afirmenet.transferencias.seleccionar" />
								</h3>
					            <a href="#" class="icon icon-info fR tooltip">
					            <span><span class="icon icon-close2"></span>
					            	  <span class="h6"><strong><spring:message code="afirmenet.tooltip.transdomi.titulo"/></strong></span>
					            	  <span><spring:message code="afirmenet.tooltip.transdomi.desc"/></span></span>
					            </a>
							</div>

							<div class="bbot2 mb20">
								<div class="row">
									<div class="col6 xs-break mb20">
										<h6 class="mb5">
											<spring:message code="afirmenet.transferencias.origen" />
										</h6>

										<form:select id="origen" path="origen.number"
											cssClass="drop req">
											<option value="">Seleccionar Cuenta</option>
											<c:forEach var="cuentaPropia" items="${cuentasPropias}">
												<option value="${cuentaPropia.number}">
													${cuentaPropia.description} (${cuentaPropia.numberMask}) -
													$${cuentaPropia.balanceFormatted} - ${cuentaPropia.ccy}</option>
											</c:forEach>
										</form:select>

									</div>

									<div class="col6 xs-break mb20">
										<h6 class="mb5">
											<spring:message code="afirmenet.transferencias.destino" />
										</h6>

										<form:select id="destino" path="destino.number"
											cssClass="drop req">
											<option value="">Seleccionar Cuenta</option>
											<c:forEach var="cuentaTercero" items="${cuentasJr}">
												<option value="${cuentaTercero.ACCNUM}">
													${cuentaTercero.ACCOWNER} (${cuentaTercero.ACCNUMMask}) -
													${cuentaTercero.BNKNAME}</option>
											</c:forEach>
										</form:select>

									</div>
								</div>
							</div>

							<div class="row acciones">
								<div class="col6 xs-break xs-center xs-mb20">
									<a href="#" class="btn gris"><span class="icon icon-plus"></span>
									<spring:message code="afirmenet.botones.agregarcuenta1" /><span
										class="hide-xs"><spring:message
												code="afirmenet.botones.agregarcuenta2" /></span></a>
								</div>
								<div class="col6 xs-break xs-center hidden" align="right">
									<a href="#" class="btn verde"><spring:message
											code="afirmenet.botones.continuar" /></a>
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