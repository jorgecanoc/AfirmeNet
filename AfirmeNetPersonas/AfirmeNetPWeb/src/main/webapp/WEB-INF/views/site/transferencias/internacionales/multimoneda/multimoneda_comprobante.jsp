<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$(document).ready(function() {
		$('.notificacion .icon-close2').click(function(){ $(this).parent().slideUp(); });
	});
</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
      	<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido">
        
          <c:if test="${fn:length(errores) eq 0}">
            <div class="notificacion bgturq">
              <a class="icon icon-close2"></a>
              <div class="clearfix"><span class="icon icon-success"></span><p class="f21 m0"><strong>CORRECTO</strong><br>Transferencia realizada exitosamente</p></div>
            </div>
          </c:if>

          <div class="p20">
          
            <h3 class="titulo"><spring:message code="afirmenet.transferencias.multimoneda.titulo"/></h3>
			<p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
          
			<a href="#" class="cerrar"></a>
			<div class="ovhidden mb30"><div class="pasos">
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
				<span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
			</div></div>

            <div class="row mb15">
              <h3 class="f-verdeO col8 xs-break"><spring:message code="afirmenet.transferencias.paso.comprobante"/></h3>
            </div>

            <div class="bbot2 mb15"><div class="row">

              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.tranferestado"/></strong></h6>
                <p class="h6 f-verdeO"><spring:message code="afirmenet.comprobantes.exitosa"/></p>
              </div>
              <div class="col6 xs-break">
                <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.rastreo"/></strong></h6>
                <p class="h6 f-verdeO">${listComprobantes[0].afirmeNetReference}</p>
              </div>

            </div></div>

            <div class="row">

              <div class="col6 xs-break">

                <div class="mb15">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                  <p class="h6 f-verdeO">
                  ${transferencia.origen.description} (${transferencia.origen.numberMask}) - $${transferencia.origen.balanceFormatted} - ${transferencia.origen.ccy}
                  </p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.contrato"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.contractId}</p>
                </div>

              </div>

              <div class="col6 xs-break">

                <div class="mb15">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.destino"/></strong></h6>
                  <p class="h6 f-verdeO">
                  ${transferencia.destino.number}
                  </p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.importe"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${transferencia.amountFormatted}</p>
                </div>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.multimoneda.moneda"/>:</strong></h6>
                  <p class="h6 f-verdeO">${transferencia.descMoneda}</p>
                </div>

                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.comision"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${transferencia.commissionFormatted} ${transferencia.currency} + IVA</p>
                </div>
                
                <c:if test="${not empty transferencia.intermediarioCuenta}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.dolares.intermediario"/>:</strong></h6>
                  <p class="h6 f-verdeO">
                  ${transferencia.intermediarioCodigo}<br/>
                  ${transferencia.intermediarioCuenta}<br/>
                  ${transferencia.intermediarioNombre}<br/>
                  ${transferencia.intermediarioPlaza}
                  </p>
                </div>
                </c:if>
                
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.banco"/></strong></h6>
                  <p class="h6 f-verdeO">
                  ${transferencia.codigoSWIFT}
                  ${transferencia.codigoABA}
                  <br>
                  ${transferencia.bankName}</p>
                </div>
                
                <c:if test="${not empty transferencia.email}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.email"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.email}</p>
                </div>
                </c:if>
                
                <c:if test="${not empty transferencia.narrative}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.instruccion"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.narrative}</p>
                </div>
                </c:if>
                
                <c:if test="${transferencia.plazaReceiving gt 0}">
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.instruccion"/></strong></h6>
                  <p class="h6 f-verdeO">${transferencia.plazaReceiving}</p>
                </div>
                </c:if>

              </div>

            </div>

            <div class="bbot2 btop2 p15-10"><div class="row">
              <div class="col4 xs-break xs-center xs-mb20"><p class="f21 m0"><spring:message code="afirmenet.comprobantes.impresion"/></p></div>
              <div class="col4 xs-break xs-center"><a href="#" class="h6 m0 f-verde">
              <span class="icon icon-pdf f21 mr10"></span> <spring:message code="afirmenet.comprobantes.pdf"/> <span class="hide-xs"><spring:message code="afirmenet.comprobantes.pdf2"/></span></a></div>
              <div class="col4 hide-xs"><a href="#" class="h6 m0 f-verde"><span class="icon icon-print f21 mr10"></span> Imprimir</a></div>
            </div></div>

            <div class="p15-20 xs-p100" align="center">
              <p class="f21"><spring:message code="afirmenet.comprobantes.recomendadas"/></p>
              <div class="acciones mt10 flex">
                <a href="#" class="btn atras mr10 xs-col12 xs-m0">consultar movimientos</a>
                <a href="#" class="btn verde xs-col12 xs-mb20">ASOCIAR CUENTA A CELULAR</a>
              </div>
            </div>

          </div>

          <div class="p30-20 bgturq promocion"><div class="row">
            <div class="col6 xs-break xs-mb20">
              <div class="bgbco" align="center"><img src="<c:url value="/resources/img/photos/candado.jpg"/>" alt=""></div>
            </div>
            <div class="col6 xs-break">
              <h3 class="f-bco m0"><strong>¡Hola!</strong> Jessica Lisseethe</h3>
              <p class="h6 f-bco">Con nuestro seguro AntiFraude, protege tus transferencias y mucho más. Adquiérelo desde $40 pesos mensuales.</p>
              <a href="#" class="btn">Solicítalo</a>
            </div>
          </div></div>

        </div>

      </div>

    </article>
	
</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>