<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$('document').ready(function() {
		$('.drop').dropkick({
			mobile : true,
			change : function(dk) {
				$(this.data.elem).find('.dk-selected').addClass('f-verde');
				continuar();
			}
		});
		
		$('a.btn.verde').click(function() {
			submitFormAnimate($('#transferencia').attr('id'), $('#transferencia').attr('action'));
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
        
        <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>
        
        <div class="p20">
        
        <form:form commandName="transferencia" method="POST" action="transferencias/dolares/ingreso_datos.htm">

          <h3 class="titulo"><spring:message code="afirmenet.transferencias.dolares.titulo"/></h3>
          <p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

		  <a href="${context}/transferencias/dolares/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

          <div class="clearfix mb10">
            <h3 class="f-verdeO fL">Seleccionar Cuentas</h3>
            <a href="#" class="icon icon-info fR tooltip">
            <span><span class="icon icon-close2"></span>
            	  <span class="h6"><strong><spring:message code="afirmenet.tooltip.transdolares.titulo"/></strong></span>
            	  <span><spring:message code="afirmenet.tooltip.transdolares.desc"/></span></span>
            </a>
          </div>

          <div class="bbot2 mb20">
            <div class="row">
              <div class="col6 xs-break mb20">
                <h6 class="mb5">Cuenta Origen</h6>
                
                <form:select id="origen" path="origen.number" cssClass="drop req">
                	<option value ="">Seleccionar Cuenta</option>
                	<c:forEach var="cuentaPropia" items="${cuentasOrigen}">
                	<option value="${cuentaPropia.number}">
                		${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} - ${cuentaPropia.ccy}
               		</option>
                	</c:forEach>
                </form:select>
                
              </div>
              <div class="col6 xs-break mb20">
                <h6 class="mb5">Cuenta Destino</h6>
                
                <form:select id="destino" path="creditAccount" cssClass="drop req">
                	<option value ="">Seleccionar Cuenta</option>
                	<c:if test="${not empty cuentasDestino}">
                	<c:forEach var="cuentaSWIFT" items="${cuentasDestino}">
                	<option value="${cuentaSWIFT.creditAccount}">
                		<c:if test="${not empty cuentaSWIFT.codigoABA}">
                			${cuentaSWIFT.creditAccount} (${cuentaSWIFT.codigoABA}) - ${cuentaSWIFT.bankName}
               			</c:if>
               			<c:if test="${not empty cuentaSWIFT.codigoSWIFT}">
                			${cuentaSWIFT.creditAccount} (${cuentaSWIFT.codigoSWIFT}) - ${cuentaSWIFT.bankName}
               			</c:if>
               		</option>
                	</c:forEach>
                	</c:if>
                </form:select>
                
              </div>
            </div>
          </div>

          <div class="row acciones">
            <div class="col6 xs-break xs-center xs-mb20"><a href="#" class="btn gris"><span class="icon icon-plus"></span>Agregar cuenta <span class="hide-xs">destino</span></a></div>
            <div class="col6 xs-break xs-center hidden" align="right">
              <a href="#" class="btn verde">Continuar</a>
            </div>
          </div>

        </form:form>
        
        </div></div>

      </div>

    </article>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>