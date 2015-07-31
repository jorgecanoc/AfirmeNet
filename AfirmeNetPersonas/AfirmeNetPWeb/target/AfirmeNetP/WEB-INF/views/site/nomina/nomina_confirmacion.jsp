<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function() {

	$('a.btn.verde').click(function() {
		submitFormAnimate('pago', $('#pago').attr('action'));
	});
	
	$('a.btn.atras').click(function() {
		submitFormAnimate('pago', 'pagos/gdf/ingreso_datos.htm');
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
          
			<form:form commandName="pago" method="GET" action="nomina/disposicion/comprobante.htm">

			<h3 class="titulo"><spring:message code="afirmenet.pagos.gdf.titulo"/></h3>
          	<p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
          	
          	<a href="${context}/pagos/gdf/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
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
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                  <p class="h6 f-verdeO">${nomina.origen.nickname} (${nomina.origen.numberMask})</p>
                </div>

              </div>

              <div class="col6 xs-break">

                <div class="mb20">
                  <h6 class="f21 m0"><strong>Cuenta de Cargo</strong></h6>
                  <p class="h6 f-verdeO">${nomina.destino.description} (${nomina.destino.numberMask})</p>
                </div>
                
                <!-- Datos de Abono -->
                <c:if test="${nomina.clave eq 'A'}">
                <div class="mb15">
                  <h6 class="m0"><strong>Saldo a Capital</strong></h6>
                  <p class="h6 f-verdeO">${nomina.saldoCapital}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Importe del Abono a Capital</strong></h6>
                  <p class="h6 f-verdeO">${nomina.amount}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Nuevo Saldo a Capital</strong></h6>
                  <p class="h6 f-verdeO">${nomina.saldoCapital - nomina.amount}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Saldo Disponible Línea de Crédito</strong></h6>
                  <p class="h6 f-verdeO">${nomina.creditoDisponible}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Comisión por Disposición</strong></h6>
                  <p class="h6 f-verdeO">Sin costo</p>
                </div>
                </c:if>
                <!-- Fin Datos de Abono -->
                
                <c:if test="${nomina.clave eq 'C'}">
                <div class="mb15">
                  <h6 class="m0"><strong>Línea Autorizada</strong></h6>
                  <p class="h6 f-verdeO">${nomina.montoAutorizado}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Crédito Utilizado</strong></h6>
                  <p class="h6 f-verdeO">${nomina.creditoUtilizado - nomina.anticipoUtilizado - nomina.amount}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Anticipo Utilizado</strong></h6>
                  <p class="h6 f-verdeO">${nomina.anticipoUtilizado}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Disponible por Crédito Solicitado</strong></h6>
                  <p class="h6 f-verdeO">${nomina.amount}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Importe Total del Crédito</strong></h6>
                  <p class="h6 f-verdeO"></p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Saldo Disponible Línea de Crédito</strong></h6>
                  <p class="h6 f-verdeO">${nomina.creditoDisponible}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Tasa de Interés Anual</strong></h6>
                  <p class="h6 f-verdeO">${nomina.tasa}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Tasa de Interés Moratorio Más TIIE</strong></h6>
                  <p class="h6 f-verdeO">${nomina.moratoria}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Comisión por Disposición</strong></h6>
                  <p class="h6 f-verdeO">Sin costo</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Seguro de Vida Mensual</strong></h6>
                  <p class="h6 f-verdeO">${nomina.seguro}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Plazo de Pago</strong></h6>
                  <p class="h6 f-verdeO">${nomina.plazo} MESES</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong>Costo Anual Total (CAT)</strong></h6>
                  <p class="h6 f-verdeO">${nomina.CAT}</p>
                </div>
				</c:if>
				
            </div>
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
            
            </form:form>
            
          </div>

        </div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>