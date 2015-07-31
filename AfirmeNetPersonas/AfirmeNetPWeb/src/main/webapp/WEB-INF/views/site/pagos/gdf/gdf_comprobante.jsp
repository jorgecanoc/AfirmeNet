<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$(document).ready(function(){
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
          
            <h3 class="titulo"><spring:message code="afirmenet.pagos.gdf.titulo"/></h3>
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
                <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.folioAfirme"/></strong></h6>
                <p class="h6 f-verdeO">${listComprobantes[0].afirmeNetReference}</p>
              </div>

            </div></div>

            <div class="row">

              <div class="col6 xs-break">

                <div class="mb15">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></h6>
                  <p class="h6 f-verdeO">
                  ${pago.origen.description} (${pago.origen.numberMask})
                  </p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.comprobantes.contrato"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.contractId}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.nombre"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.nombre}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.domicilio"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.domicilio}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.colonia"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.colonia}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.codigoPostal"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.codigoPostal}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.delegacion"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.delegacion}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.estado"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.estado}</p>
                </div>

              </div>

              <div class="col6 xs-break">
                
                <div class="mb20">
                  <h6 class="f21 m0"><strong><spring:message code="afirmenet.pagos.gdf.tramite"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.nombreGrupo}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.concepto"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.concepto}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.lineaCaptura"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.lineaCaptura}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.fecha"/></strong></h6>
                  <p class="h6 f-verdeO">${pago.validationDate}</p>
                </div>
                <div class="mb15">
                  <h6 class="m0"><strong><spring:message code="afirmenet.transferencias.importe"/></strong></h6>
                  <p class="h6 f-verdeO">$ ${pago.amountFormatted}</p>
                </div>
                
                <c:if test="${pago.conceptoGDF == 'LICENCIA_CONDUCIR'}">
              	  <div class="mb15">
              	  	<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.tipo"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.tipoLicencia}</p>
                  </div>
                  <div class="mb15">
                  	<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.periodo"/></strong></h6>
                  	<p class="h6 f-verdeO">${pago.periodo}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.rfc}</p>
                  </div>
                </c:if>
                
                <c:if test="${pago.conceptoGDF == 'TENENCIA'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.placa}</p>
               	  </div>
               	  <div class="mb15">
                  	<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.modeloFolio"/></strong></h6>
                  	<p class="h6 f-verdeO">${pago.modelo}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.ejercicioFiscal"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.ejercicio}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.marca"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.marca}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.subMarca"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.subMarca}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.valorFactura"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.valorFactura}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.cilindros"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.cilindros}</p>
                  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'TRAM_VEHICULAR'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.origen"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.origenTramite}</p>
               	  </div>
               	  <div class="mb15">
                  	<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></h6>
                  	<p class="h6 f-verdeO">${pago.placa}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.modelo"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.modelo}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.marca"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.marca}</p>
                  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'MULTA_REV_VEHICULAR' || pago.conceptoGDF == 'MEDIO_AMB_VERFIC_EXTEMP'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.placa"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.placa}</p>
               	  </div>
               	  <div class="mb15">
                  	<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.modelo"/></strong></h6>
                  	<p class="h6 f-verdeO">${pago.modelo}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.marca"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.marca}</p>
                  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'MULTA_INFRACCION'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.folioInfraccion"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.folioInfraccion}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'MEDIO_AMBIENTE_HOLOGR'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.claveVerificentro"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.claveVerificacion}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.tipoHolograma"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.tipoHolograma}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.cantidad"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.cantidad}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.folio}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'REGISTRO_CIVIL'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.folio}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.cantidad"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.cantidad}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.precioUnitario"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.precioUnitario}</p>
               	  </div>
               	  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.numeroEscritura"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.numeroEscritura}</p>
                  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'REGISTRO_CIVIL_BUSQUEDA'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.folio}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'PAGOS_TESORERIA'}">
				  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.referenciaPago}</p>
               	  </div>
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.folio}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.administracionTributaria"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.adminTributaria}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'SERVICIO_POLICIA'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.folioFactura"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.folioFactura}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'IMP_PREDIAL'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.cuenta"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.cuentaPredial}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.ejercicio"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.ejercicio}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.bimestre"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.bimestre}</p>
               	  </div>
				</c:if> 
				
				<c:if test="${pago.conceptoGDF == 'IMP_NOMINA' || pago.conceptoGDF == 'IMP_RIFAS' || 
							  pago.conceptoGDF == 'IMP_HOSPEDAJE' || pago.conceptoGDF == 'AUTO_NUEVO'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.rfc"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.rfc}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.ejercicio"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.ejercicio}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.mes"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.mes}</p>
               	  </div>
               	  
               	  <c:if test="${pago.conceptoGDF == 'IMP_NOMINA'}">
               	  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.tipoDeclaracion"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.tipoDeclaracion}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.remuneracionesPagadas"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.remuneracionesPagadas}</p>
                  </div>
                  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.numeroTrabajadores"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.numeroTrabajadores}</p>
                  </div>
               	  </c:if>
               	  
               	  <c:if test="${pago.conceptoGDF == 'IMP_RIFAS'}">
               	  <div class="mb15">
                    <h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.fechaEvento"/></strong></h6>
                    <p class="h6 f-verdeO">${pago.fechaEvento}</p>
                  </div>
               	  </c:if>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'IMP_INMUEBLES'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.cuentaPredial"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.cuentaPredial}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.tipoOperacion"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.tipoOperacion}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.fechaEscritura"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.fechaEscrituras}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'REGISTRO_PUBLICO'}">
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.folio}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.tramite"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.tramite}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.numeroEscritura"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.numeroEscritura}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'ISR_ENAJENACION'}">
				  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.subconcepto"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.subConcepto}</p>
               	  </div>
                  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.cuentaPredial}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.tipoDeclaracion"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.tipoDeclaracion}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.numeroNotario"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.numeroNotario}</p>
               	  </div>
               	  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.numeroEscritura"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.numeroEscritura}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'SUMINISTRO_AGUA'}">
				  <div class="mb15">
               		<h6 class="m0"><strong><spring:message code="afirmenet.pagos.gdf.numeroCuentaAgua"/></strong></h6>
               		<p class="h6 f-verdeO">${pago.cuentaAgua}</p>
               	  </div>
               	</c:if>

              </div>

            </div>

            <div class="bbot2 btop2 p15-10"><div class="row">
              <div class="col4 xs-break xs-center xs-mb20"><p class="f21 m0"><spring:message code="afirmenet.comprobantes.impresion"/></p></div>
              <div class="col4 xs-break xs-center"><a href="#" class="h6 m0 f-verde">
              <span class="icon icon-pdf f21 mr10"></span> <spring:message code="afirmenet.comprobantes.pdf"/> <span class="hide-xs"><spring:message code="afirmenet.comprobantes.pdf2"/></span></a></div>
              <div class="col4 hide-xs"><a href="#" class="h6 m0 f-verde"><span class="icon icon-print f21 mr10"></span> <spring:message code="afirmenet.comprobantes.imprimir"/></a></div>
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