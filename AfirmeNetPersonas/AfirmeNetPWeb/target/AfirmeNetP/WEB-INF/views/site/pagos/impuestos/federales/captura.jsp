<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

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
						<form:form commandName="impuesto" method="POST"
							modelAttribute="impuesto"
							action="impuestos/federales/confirmar">
							<c:set var="now" value="<%=new java.text.SimpleDateFormat("dd/MMMM/yy HH:mm").format(new java.util.Date())%>" />
							<c:set var="fechaLong" value="<%=new java.util.Date().getTime()%>" />
							<form:hidden path="datosXML" id="datosXML"/>
							<form:hidden path="datos" id="datos"/>
							<form:hidden path="datosImpl" id="datosImpl"/>
							<form:hidden path="cadenaOriginal" id="cadenaOriginal"/>
							<form:hidden path="tipoImpuesto" id="tipoImpuesto" />
							<form:hidden path="contratoId" id="contratoId"/>
							<form:hidden path="nombreCliente" id="nombreCliente"/>
							
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
									<span class="paso col4"><span><spring:message code="afirmenet.pago.impuestos.federales.paso2" /><small class="hide-xs"><spring:message code="afirmenet.pago.impuestos.federales.paso.confirmar" /></small></span></span>
									<span class="paso col4"><span><spring:message code="afirmenet.pago.impuestos.federales.paso3" /><small class="hide-xs"><spring:message code="afirmenet.pago.impuestos.federales.paso.comprobante" /></small></span></span>
								</div>
							</div>
						 
							<div id="errores"></div>
				            <div class="row">
				              <div class="col9 xs-mb20">
				                <h3 class="f-verdeO m0 fL"><spring:message code="afirmenet.transferencias.seleccionar" /></h3> 
				                <div class="ml20 fL xs-col12 xs-m0"><h6 class="m0 mt7"><span class="op50"><spring:message code="afirmenet.obligatorio" /></span><span class="f-verdeO">*</span></h6></div>
				              </div>
				              <div class="col3">
				                <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
				              </div>
				            </div>
            
						 <!-- Listado de Cuentas -->
				           <div class="p20-0 mb30">
			                <h6 class="mb5"><spring:message code="afirmenet.transferencias.origen"/></h6>
			                <form:select id="origen" name="origen" path="origen.number" cssClass="drop req">
			                	<option value="">Seleccionar</option>
							    <c:forEach var="cuentaPropia" items="${cuentasPropias}">
							        <form:option value="${cuentaPropia.number}"><c:out value="${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} ${cuentaPropia.ccy}"/></form:option>
							    </c:forEach>
							</form:select>						          
				          </div>		
				          
				            <div class="clearfix">
				              <h6 class="fL"><spring:message code="afirmenet.pago.impuestos.federales.fecha"/><span class="f-verdeO">*</span></h6>
				            </div> 
				            <div class="row mb30"><div class="col6 xs-col12">
				              <div class="form-input relative importe">
				                <input name="fechaOperacion"  type="text" value="${now}" readonly="readonly">
				                <a class="ayuda">?</a>
				              </div>
				            </div></div>

		          		    <h3 class="f-verdeO mb20"><spring:message code="afirmenet.pago.impuestos.federales.datos"/></h3> 
		          		  
				          <!-- Applet -->
				          <div class="mb20">  

				          	<script type="text/javascript">
				          	<!--
				          		  var tipoImpuesto = $('#tipoImpuesto').val();
				          		  
				          		  if(tipoImpuesto == 'ANUAL'){
									  document.writeln("<APPLET id='AppImpEjercicio' style='LEFT: 0px; TOP: 0px' name='AppImpEjercicio' code='ejercicio.EjercicioAWT.class' archive='<c:url value="/resources/applet/Ejercicio.jar"/>'' width='850' height='700' VIEWASTEXT >");
									  document.writeln("<param Name='NUMERO_CONCEPTOS'value='5' /> ");
									  document.writeln("<param name='FECHA_ACTUAL' VALUE='${fechaLong}'/>");
									  document.writeln("<param name='TARJETA_TRIBUTARIA' value='i'  />");
									  document.writeln("</APPLET>");					          		  
				          		  }else{
									  document.writeln("<APPLET id='AppImpEjercicio' style='LEFT: 0px; TOP: 0px' name='AppImpEjercicio' code='derechos.DerechosAWT.class' archive='<c:url value="/resources/applet/Derechos.jar"/>'' width='850' height='700' VIEWASTEXT >");
									  document.writeln("<param Name='NUMERO_CONCEPTOS'value='5' /> ");
									  document.writeln("<param name='FECHA_ACTUAL' VALUE='${now}'/>");
									  document.writeln("<param name='TARJETA_TRIBUTARIA' value=''  />");
									  document.writeln("</APPLET>");					          		  
				          		  }	
							
							//-->
				          	</script>
				          </div>
				          <!-- Seccion de Acciones -->	
				          <div class="p20">
				            <div class="row acciones" align="right">
				                <a href="#" class="btn verde"><spring:message code="afirmenet.botones.continuar" /></a>
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
	      
		$('a.btn.verde').click(function() {
			if (validForm($('#impuesto').attr('id')) && setDatosSAT())
				submitFormAnimate($('#impuesto').attr('id'), $('#impuesto').attr('action'));

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

	});

	function setDatosSAT(){
		if(document.AppImpEjercicio.getXMLValue() =='*'){
			  $('#errores').prepend('<div class="mensaje error fc"><span class="icon icon-error"></span><span class="icon icon-close2"></span><p><strong class="error">ERRORES</strong><br>Debe confirmar los datos.</p></div>');
              $('.mensaje .icon-close2').click(function(){ $(this).parent().slideUp(); });			
			return false;
		}
		$('#datosXML').val(document.AppImpEjercicio.getXMLValue());
		$('#datos').val( document.AppImpEjercicio.appEnviaDatos());
		$('#datosImpl').val( document.AppImpEjercicio.appEnviaImpresion());
		$('#cadenaOriginal').val( document.AppImpEjercicio.appEnviaCadOriginal());
		return true;
	}
</script>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>