<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<c:url value="/resources/js/vendor/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/pikaday.js"/>"></script>

<script type="text/javascript">
$(document).ready(function() {

	$('#valorFactura').val('');
	$('#cilindros').val('');
	
	// Dropdown
	$('.drop').dropkick({
		mobile : true,
		change : function() {
			$(this.data.elem).find('.dk-selected').addClass('f-verde');
		}
	});
	
	$('.modal').fancybox({
		maxWidth : 600,
		maxHeight : 450,
		autoHeight : true,
		fitToView : false,
		padding : 0
	});
	
	// Fecha
	var picker = new Pikaday({
		field : document.getElementById('datepicker'),
		minDate : moment().startOf('day').add(1, 'days').toDate(),
		defaultDate : new Date(Date.now()),
		format : 'D/MMMM/YYYY',
		onSelect : function() {
			$('#datepicker').css({
				'color' : '#008d36',
				'text-transform' : 'uppercase'
			});
			$('#fechaEvento').val(this);
			$('#fechaEscrituras').val(this);
		}
	});
	
	$('a.btn.verde').click(function() {
		if (validForm($('#pago').attr('id')) && validaCantidades() && validaCodigoPostal())
			submitFormAnimate('pago', $('#pago').attr('action'));
	});
	
	$('a.btn.atras').click(function() {
		submitFormAnimate('pago', 'pagos/gdf/gdf_seleccion.htm');
	});
	
	$('.onlyInt').keypress(function(tecla) {
		var char = tecla.charCode;
		var key = tecla.keyCode;
		var ctrl = tecla.ctrlKey;
		// permite las teclas backspace, flechas, inicio y fin
		if (key == 8 || (key >= 35 && key <= 40) || key == 9)
			return true;
		if (char < 48 || char > 57)
			return false;
	});
});

function validaCantidades() {
	var objArray = $('.validaCantidad');
	var valid = true;
	
	$.each(objArray, function(index, element) {
		try {
			if (Number($(element).val()) <= 0) {
				valid = false;
				return false;
			}
		} catch(ex) {
			return false;
		};		
	});
	
	return valid;
}

function validaCodigoPostal() {
	var codigoPostal = $('#codigoPostal').val();
	if (codigoPostal == '' || codigoPostal.length < 5)
		return false;
	else
		return true;
}

</script>

<section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
      	<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido">
        
          <form:form commandName="pago" action="pagos/gdf/confirmacion.htm">

          <div class="p20">
          
            <h3 class="titulo"><spring:message code="afirmenet.pagos.gdf.titulo"/></h3>
            <p>Horario de Servicio: <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

            <a href="${context}/transferencias/terceros/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
            <div class="ovhidden mb30"><div class="pasos">
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
              <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
              <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            </div></div>

            <h3 class="f-verdeO m0"><spring:message code="afirmenet.pagos.gdf.nombreImpuesto"/></h3>
            
          </div>

          <div class="bgf1 p20 mb30">

            <div class="row">

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.tramite"/></strong></p>
                  <p class="h6">${pago.nombreGrupo}</p>
                </div>
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.concepto"/></strong></p>
                  <p class="h6">${pago.concepto}</p>
                </div>
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.lineaCaptura"/></strong></p>
                  <p class="h6">${pago.lineaCaptura}</p>
                </div>
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.fecha"/></strong></p>
                  <p class="h6">${pago.validationDate}</p>
                </div>
                <div>
                  <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.importe"/></strong></p>
                  <p class="h6">$ ${pago.amount}</p>
                </div>
              </div>
              
              <div class="col6 xs-break">

				<c:if test="${pago.conceptoGDF == 'LICENCIA_CONDUCIR'}">
              	  <div class="mb15">
              	  	<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.tipo"/></strong></p>
                    <p class="h6">${pago.tipoLicencia}</p>
                  </div>
                  <div class="mb15">
                  	<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.periodo"/></strong></p>
                  	<p class="h6">${pago.periodo}</p>
                  </div>
                  <div class="mb15">
                    <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></p>
                    <p class="h6">${pago.rfc}</p>
                  </div>
                </c:if>
                
                <c:if test="${pago.conceptoGDF == 'TENENCIA'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></p>
               		<p class="h6">${pago.placa}</p>
               	  </div>
               	  <div class="mb15">
                  	<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.modeloFolio"/></strong></p>
                  	<p class="h6">${pago.modelo}</p>
                  </div>
                  <div class="mb15">
                    <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.ejercicioFiscal"/></strong></p>
                    <p class="h6">${pago.ejercicio}</p>
                  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'TRAM_VEHICULAR'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.origen"/></strong></p>
               		<p class="h6">${pago.origenTramite}</p>
               	  </div>
               	  <div class="mb15">
                  	<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></p>
                  	<p class="h6">${pago.placa}</p>
                  </div>
                  <div class="mb15">
                    <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.modelo"/></strong></p>
                    <p class="h6">${pago.modelo}</p>
                  </div>
                  <div class="mb15">
                    <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.marca"/></strong></p>
                    <p class="h6">${pago.marca}</p>
                  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'MULTA_REV_VEHICULAR' || pago.conceptoGDF == 'MEDIO_AMB_VERFIC_EXTEMP'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.placa"/></strong></p>
               		<p class="h6">${pago.placa}</p>
               	  </div>
               	  <div class="mb15">
                  	<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.modelo"/></strong></p>
                  	<p class="h6">${pago.modelo}</p>
                  </div>
                  <div class="mb15">
                    <p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.marca"/></strong></p>
                    <p class="h6">${pago.marca}</p>
                  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'MULTA_INFRACCION'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.folioInfraccion"/></strong></p>
               		<p class="h6">${pago.folioInfraccion}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'MEDIO_AMBIENTE_HOLOGR'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.claveVerificentro"/></strong></p>
               		<p class="h6">${pago.claveVerificacion}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.tipoHolograma"/></strong></p>
               		<p class="h6">${pago.tipoHolograma}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.cantidad"/></strong></p>
               		<p class="h6">${pago.cantidad}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></p>
               		<p class="h6">${pago.folio}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'REGISTRO_CIVIL'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></p>
               		<p class="h6">${pago.folio}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.cantidad"/></strong></p>
               		<p class="h6">${pago.cantidad}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.precioUnitario"/></strong></p>
               		<p class="h6">${pago.precioUnitario}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'REGISTRO_CIVIL_BUSQUEDA'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></p>
               		<p class="h6">${pago.folio}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'PAGOS_TESORERIA'}">
				  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></p>
               		<p class="h6">${pago.referenciaPago}</p>
               	  </div>
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></p>
               		<p class="h6">${pago.folio}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.administracionTributaria"/></strong></p>
               		<p class="h6">${pago.adminTributaria}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'SERVICIO_POLICIA'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.folioFactura"/></strong></p>
               		<p class="h6">${pago.folioFactura}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'IMP_PREDIAL'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.cuenta"/></strong></p>
               		<p class="h6">${pago.cuentaPredial}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.ejercicio"/></strong></p>
               		<p class="h6">${pago.ejercicio}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.bimestre"/></strong></p>
               		<p class="h6">${pago.bimestre}</p>
               	  </div>
				</c:if> 
				
				<c:if test="${pago.conceptoGDF == 'IMP_NOMINA' || pago.conceptoGDF == 'IMP_RIFAS' || 
							  pago.conceptoGDF == 'IMP_HOSPEDAJE' || pago.conceptoGDF == 'AUTO_NUEVO'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.rfc"/></strong></p>
               		<p class="h6">${pago.rfc}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.ejercicio"/></strong></p>
               		<p class="h6">${pago.ejercicio}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.mes"/></strong></p>
               		<p class="h6">${pago.mes}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'IMP_INMUEBLES'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.cuentaPredial"/></strong></p>
               		<p class="h6">${pago.cuentaPredial}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.tipoOperacion"/></strong></p>
               		<p class="h6">${pago.tipoOperacion}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'REGISTRO_PUBLICO'}">
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.folio"/></strong></p>
               		<p class="h6">${pago.folio}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.tramite"/></strong></p>
               		<p class="h6">${pago.tramite}</p>
               	  </div>
				</c:if>
				
				<c:if test="${pago.conceptoGDF == 'ISR_ENAJENACION'}">
				  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.subconcepto"/></strong></p>
               		<p class="h6">${pago.subConcepto}</p>
               	  </div>
                  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.referencia"/></strong></p>
               		<p class="h6">${pago.cuentaPredial}</p>
               	  </div>
               	  <div class="mb15">
               		<p class="h6 m0"><strong><spring:message code="afirmenet.pagos.gdf.tipoDeclaracion"/></strong></p>
               		<p class="h6">${pago.tipoDeclaracion}</p>
               	  </div>
				</c:if>
				
              </div>
              
            </div>

            <div class="row">

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong><spring:message code="afirmenet.transferencias.origen"/></strong></p>
                  <p class="h6">
                  ${pago.origen.description} (${pago.origen.numberMask}) - $${pago.origen.balanceFormatted} - ${pago.origen.ccy}
                  </p>
                </div>
              </div>
              
            </div>

          </div>

          <div class="p20 btop2">

            <div class="clearfix">
              <h3 class="f-verdeO fL"><spring:message code="afirmenet.pagos.gdf.reciboTesoreria"/></h3>
              <h6 class="fL mt7 ml20"><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO">*</span></h6>
            </div>
            <p><em><spring:message code="afirmenet.pagos.gdf.reciboInstruccion"/></em></p>

            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.nombre"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input w80 relative">
                <spring:message code="afirmenet.placeholder.nombrecompleto" var="nombrePlaceholder"/>
                <form:input path="nombre" placeholder="${nombrePlaceholder}" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>

            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.domicilio"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input w80 relative">
                <spring:message code="afirmenet.pagos.gdf.domicilio.placeholder" var="domicilioPlaceholder"/>
                <form:input path="domicilio" placeholder="${domicilioPlaceholder}" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>

            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.colonia"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input w30 xs-mb15 relative">
                <spring:message code="afirmenet.pagos.gdf.colonia.placeholder" var="coloniaPlaceholder"/>
                <form:input path="colonia" placeholder="${coloniaPlaceholder}" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
              <div class="form-label w20 pl20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.codigoPostal"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input w30 relative">
                <spring:message code="afirmenet.pagos.gdf.codigoPostal.placeholder" var="codigoPostalPlaceholder"/>
                <form:input path="codigoPostal" placeholder="${codigoPostalPlaceholder}" cssClass="fR req onlyInt" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>

            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.delegacion"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input w30 xs-mb15 relative">
                <spring:message code="afirmenet.pagos.gdf.delegacion.placeholder" var="delegacionPlaceholder"/>
                <form:input path="delegacion" placeholder="${delegacionPlaceholder}" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
              <div class="form-label w20 pl20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.estado"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input w30 relative">
              	
              	<form:select path="estado" cssClass="drop req">
              		<option value="">Seleccionar</option>
	              	<c:forEach var="estado" items="${estadosList}">
	              	<option value="${estado}">${estado}</option>
	              	</c:forEach>
              	</form:select>
              	
              </div>
            </fieldset>

          </div>
          
          <c:if test="${(pago.conceptoGDF == 'REGISTRO_CIVIL') || (pago.conceptoGDF == 'SUMINISTRO_AGUA') || (pago.conceptoGDF == 'TENENCIA') || 
          				(pago.conceptoGDF == 'IMP_NOMINA') || (pago.conceptoGDF == 'IMP_RIFAS') || (pago.conceptoGDF == 'IMP_INMUEBLES') || 
          				(pago.conceptoGDF == 'REGISTRO_PUBLICO') || (pago.conceptoGDF == 'ISR_ENAJENACION')}">

          <div class="p20 btop2">

            <h3 class="f-verdeO"><spring:message code="afirmenet.pagos.gdf.datosAdicionales"/></h3>
            <h6><span class="op50"><spring:message code="afirmenet.obligatorio"/></span><span class="f-verdeO">*</span></h6>
            
            <c:if test="${pago.conceptoGDF == 'REGISTRO_CIVIL'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.numeroEscritura"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
              	<spring:message code="afirmenet.placeholder.solonumeros" var="soloNumeros"/>
                <form:input path="numeroEscritura" placeholder="${soloNumeros}" pattern="[0-9]*" cssClass="numinput req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>
            
            <c:if test="${pago.conceptoGDF == 'SUMINISTRO_AGUA'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.numeroCuentaAgua"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="cuentaAgua" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>
            
            <c:if test="${pago.conceptoGDF == 'TENENCIA'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.marca"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="marca" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.subMarca"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="subMarca" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.valorFactura"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="valorFactura" cssClass="req onlyNum validaCantidad" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.cilindros"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="cilindros" placeholder="${soloNumeros}" cssClass="req onlyInt validaCantidad" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>
            
            <c:if test="${pago.conceptoGDF == 'IMP_NOMINA'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.tipoDeclaración"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="tipoDeclaracion" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.remuneracionesPagadas"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="remuneracionesPagadas" cssClass="req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.numeroTrabajadores"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="numeroTrabajadores" placeholder="${soloNumeros}" cssClass="req onlyInt validaCantidad" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>
            
            <c:if test="${pago.conceptoGDF == 'IMP_RIFAS'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.fechaEvento"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
              	<input value="" type="button" id="datepicker" class="input req" />
              	<spring:message code="afirmenet.pagos.gdf.eventoInstruccion"/>
                <form:hidden path="fechaEvento" cssClass="input req" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>
            
            <c:if test="${pago.conceptoGDF == 'IMP_INMUEBLES'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.fechaEscritura"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
              	<input value="" type="button" id="datepicker" class="input req" />
                <form:hidden path="fechaEscrituras" />
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>
            
            <c:if test="${pago.conceptoGDF == 'REGISTRO_PUBLICO'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.numeroEscritura"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="numeroEscritura" cssClass="req" />
                <spring:message code="afirmenet.pagos.gdf.escrituraInstruccion"/>
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>
            
            <c:if test="${pago.conceptoGDF == 'ISR_ENAJENACION'}">
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.numeroNotario"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="numeroNotario" maxlength="3" cssClass="req" />
                <spring:message code="afirmenet.pagos.gdf.notarioInstruccion"/>
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w20"><label for="importe"><spring:message code="afirmenet.pagos.gdf.numeroEscritura"/><span class="f-verdeO">*</span></label></div>
              <div class="form-input relative">
                <form:input path="numeroEscritura" maxlength="12" cssClass="req" />
                <spring:message code="afirmenet.pagos.gdf.escrituraInstruccion"/>
                <a class="ayuda">?</a>
              </div>
            </fieldset>
            </c:if>

          </div>
          
          </c:if>

          <div class="p20 btop2">

            <div class="acciones" align="right">
              <a href="#" data-fancybox-type="iframe" class="btn atras mr10"><spring:message code="afirmenet.botones.atras"/></a>
              <a href="#" class="btn verde"><spring:message code="afirmenet.continuar"/></a>
            </div>

          </div>
          
       	</form:form>

        </div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>