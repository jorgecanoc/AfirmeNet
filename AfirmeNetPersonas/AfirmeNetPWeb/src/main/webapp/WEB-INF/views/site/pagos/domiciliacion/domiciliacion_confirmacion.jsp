<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$(document).ready(function() {
		
		$('a.btn.atras').click(function() {
			submitFormAnimate('convenio', 'pagos/domiciliacion/domiciliacion_datos.htm');
		});
		
		$('a.btn.verde').click(function() {
			submitFormAnimate('convenio', $('#convenio').attr('action'));
		});
		
		$('.modal').fancybox({
			maxWidth : 600,
			maxHeight : 450,
			autoHeight : true,
			fitToView : false,
			padding : 0
		});
	});
</script>

  <section><div class="container">
	
    <article>

      <div class="col-izq" id="menu-wrap">
      	<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido">

          <div class="p20">
          
          	<form id="convenio" method="POST" action="pagos/domiciliacion/domiciliacion_comprobante.htm">
          
            <h3 class="titulo"><spring:message code="afirmenet.pagos.domiciliacion.titulo"/></h3>
            <p><spring:message code="afirmenet.horarios"/><span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
            
            <a href="${context}/transferencias/dolares/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            </div></div>

            <div class="mb30">
              <h3 class="f-verdeO"><spring:message code="afirmenet.transferencias.paso.confirmar"/></h3>
            </div>

            <div class="row">

              <div class="col6 xs-break">

                <div class="mb20">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.cuentaCargo"/></strong></h6>
                  <p class="h6 f-verdeO">
                  ${convenio.origen.description} (${convenio.origen.numberMask}) - $${convenio.origen.balanceFormatted} - ${convenio.origen.ccy}
                  </p>
                </div>

              </div>

              <div class="col6 xs-break">
              
                <div class="mb20">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.proveedor"/></strong></h6>
                  <p class="h6 f-verdeO">${convenio.servicio}</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.comision"/></strong></h6>
                  <p class="h6 f-verdeO">Sin Comisión</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.titular"/></strong></h6>
                  <p class="h6 f-verdeO">${convenio.titular}</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.periodicidad"/></strong></h6>
                  <p class="h6 f-verdeO">Periodicidad con la que emita la factura ${convenio.servicio}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.montoMaximo"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${convenio.pagoMax}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.referencia"/></strong></h6>
                  <p class="h6 f-verdeO">${convenio.referencia}</p>
                </div>

				<c:if test="${convenio.email}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.domiciliacion.email"/></strong></h6>
                  <p class="h6 f-verdeO">${convenio.email}</p>
                </div>
                </c:if>
                
              </div>

            </div>
            
            </form>
            
          </div>

          <div class="bgcrema p20">

            <p class="f21 mb20"><strong class="f-gris6"><spring:message code="afirmenet.transferencias.pregunta.finalizar"/></strong></p>
            <div class="row">

              <div class="col6 xs-break xs-mb20">
                <p class="h6 mb5 f-gris6"><spring:message code="afirmenet.transferencias.clave.dinamica"/></p>
                <div class="relative input">
                  <input name="token" maxlength="6" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;" type="password">
                  <a class="ayuda">?</a>
                </div>
              </div>

              <div class="col6 xs-break">
                <p class="h6 mb5">&nbsp;</p>
                <div class="acciones" align="right">
                  <a href="#" class="btn atras mr10"><spring:message code="afirmenet.botones.atras"/></a>
                  <a href="#" class="btn verde"><spring:message code="afirmenet.botones.aceptar"/></a>
                </div>           
              </div>

            </div>
          </div>

        </div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>