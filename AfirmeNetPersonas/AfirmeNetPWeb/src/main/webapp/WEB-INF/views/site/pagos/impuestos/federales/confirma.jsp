<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>"
	rel="stylesheet" type="text/css" />
  <script type="text/javascript">
    $(document).ready(function(){

      $('.notificacion .icon-close2').click(function(){ $(this).parent().slideUp(); });

    });
  </script>
<section>
	<div class="container">
		<article>
			<div class="col-izq" id="menu-wrap">
				<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
			</div>
			<form:form commandName="impuesto" method="POST"
				modelAttribute="impuesto"
				action="impuestos/federales/ejecutar">
				<div class="col-der relative">
					<div class="contenido">
						<div class="p20">
							<h3 class="titulo">
								<spring:message code="afirmenet.pago.impuestos.federales.anual.titulo" />
							</h3>
							<p>
								<spring:message code="afirmenet.horarios" />
								<span class="f-verdeO"><c:out value="${horario}" /></span>
							</p>
							<a href="#" class="cerrar"></a>
							<div class="ovhidden mb30">
								<div class="pasos">
									<span class="paso col4 activo"><span><spring:message code="afirmenet.pago.impuestos.federales.paso1" /><small class="hide-xs"><spring:message code="afirmenet.pago.impuestos.federales.paso.datos" /></small></span></span> 
									<span class="paso col4 activo"><span><spring:message code="afirmenet.pago.impuestos.federales.paso2" /><small class="hide-xs"><spring:message code="afirmenet.pago.impuestos.federales.paso.confirmar" /></small></span></span>
									<span class="paso col4"><span><spring:message code="afirmenet.pago.impuestos.federales.paso3" /><small class="hide-xs"><spring:message code="afirmenet.pago.impuestos.federales.paso.comprobante" /></small></span></span>
								</div>
							</div>


				            <div class="row mb15 hide-print">
				              <h3 class="f-verdeO col8 xs-break"><spring:message code="afirmenet.confirmar"/></h3>
				            </div>

							<!-- Inicia Informacion de Datos de Usuario -->
				            <div class="row mb15 hide-print">
				              <h3 class="f-verdeO col8 xs-break">Datos de Usuario</h3>
				            </div>							
							
				            <div class="bbot2 mb15">
				            	<div class="row">
					              <div class="col6 xs-break">
					                <p><strong>Numero de Contrato:</strong></p>
					                <p class="h6 f-verdeO">${impuesto.contratoId}</p>                  
					              </div>
					              <div class="col6 xs-break">
					                <p><strong>Operacion:</strong></p>
					                <p class="h6 f-verdeO">Pago de Impuestos</p>                  
					              </div>
				            	</div>
				            </div>

							<!-- Inicia Informacion de Datos de Cuenta -->
				            <div class="row mb15 hide-print">
				              <h3 class="f-verdeO col8 xs-break">Datos de La cuenta</h3>
				            </div>	
				            
				            <div class="bbot2 mb15">
				            	<div class="row">
					              <div class="col6 xs-break">
				                	<p><strong><spring:message code="afirmenet.transferencias.origen"/></strong></p>
					                <p class="h6 f-verdeO">${impuesto.origen.description} (${impuesto.origen.numberMask}) - $${impuesto.origen.balanceFormatted} - ${impuesto.origen.ccy}</p>   					              </div>
					              <div class="col6 xs-break">
					                <p><strong>Compañia de Servicios a Pagar:</strong></p>
					                <p class="h6 f-verdeO">SECRETARIA DE HACIENDA Y CREDITO PUBLICO</p>                  
					              </div>
				            	</div>				            
				            	<div class="row">
					              <div class="col6 xs-break">
					              	<!-- Nombre o Razon Social -->
					                <p><strong>Nomnbre o Razon Social:</strong></p>
					                <p class="h6 f-verdeO">${impuesto.nombreORazonSocial}</p>     					              
					              </div>
					              <div class="col6 xs-break">
					                <p><strong>Llave de Pago:</strong></p>
					                <p class="h6 f-verdeO">${impuesto.llavePago}</p>                 
					              </div>
				            	</div>
				            	<div class="row">
					              <div class="col6 xs-break">
					              	<!-- Nombre o Razon Social -->
					                <p><strong>Nombre Cliente:</strong></p>
					                <p class="h6 f-verdeO">${impuesto.nombreCliente}</p>     			              
					              </div>
					              <div class="col6 xs-break">
					                <p><strong>RFC:</strong></p>
					                <p class="h6 f-verdeO">${impuesto.rfc}</p>                 
					              </div>
				            	</div>	
				            	<div class="row">		
					              <div class="col6 xs-break">
					                <p><strong>Fecha y Hora de Pago:</strong></p>
					                <p class="h6 f-verdeO">${impuesto.fechaOperacion}</p>     			              
					              </div>
					              <div class="col6 xs-break">
					                <p><strong>Total Efectivamente Pagado:</strong></p>
					                <p class="h6 f-verdeO">${impuesto.totalPagado}</p>                  
					              </div>
				            	</div>		
				            	<div class="row">		
					              <div class="col6 xs-break">
					                <p><strong>Comision de la Transaccion:</strong></p>
					                <p class="h6 f-verdeO">Sin Costo</p>    			              
					              </div>
					              <div class="col6 xs-break">
					              </div>
				            	</div>				            
							</div>
				            
							<!-- Inicia Informacion de Conceptos -->
				            <div class="row mb15 hide-print">
				              <h3 class="f-verdeO col8 xs-break">Conceptos</h3>
				            </div>	
				            
				            <ul class="guardadas">
								<c:forEach items="${impuesto.conceptos}" var="concepto" varStatus="indexHeader">
									<li class="comprobante">
										<div>
	              							<div class="row hide-print">
	              								<div class="col6">
	              									<p><strong>Concepto:</strong></p>
	              									<p class="f-verdeO">${concepto.conceptos[0].valorImpresion}</p>  
	              								</div>							
												<div class="col5">
												</div>
								                <div class="col1" align="right">
								                  <a class="icon icon-t-plus"></a>
								                  <a class="icon icon-t-minus"></a>
								                </div>	
								            </div>
								            <div class="detalle">
	                							<h3 class="show-print f-verdeO">Resultado de la Operación</h3>
								                <div class="mb15">
													<div class="row">
														<div class="col6">               
														</div>
														<div class="col6">
								            				<c:forEach items="${concepto.conceptos}" var="conceptoDetalle" varStatus="indexDetalle">
								            					<p><strong>${conceptoDetalle.descripcion}:</strong></p>
								  								<p class="f-verdeO">${conceptoDetalle.valorImpresion}</p>
								            				</c:forEach>													
														</div>
													</div>
												</div>							            
								            </div>
								        </div>
								    </li>    
								</c:forEach>                
							</ul>
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
										<a href="#" class="btn verde"><spring:message code="afirmenet.botones.aceptar" /></a>
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
			submitFormAnimate($('#impuesto').attr('id'), 'impuestos/federales/capturaAnual');
		});	
			
		$('a.btn.verde').click(function() {
			if (validForm($('#impuesto').attr('id')))
				submitFormAnimate($('#impuesto').attr('id'), $('#impuesto').attr('action'));
		});	
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