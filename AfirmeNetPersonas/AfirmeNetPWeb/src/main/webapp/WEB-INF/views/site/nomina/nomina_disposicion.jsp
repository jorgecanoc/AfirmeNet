<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
$(document).ready(function(){
	$('a.btn.verde').click(function() {
		submitFormAnimate('nomina', $('#nomina').attr('action'));
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
          
          <form:form commandName="nomina" method="POST" action="nomina/disposicion/confirmacion.htm">

          <h3 class="titulo">Disposición de Crédito</h3>
          <p><spring:message code="afirmenet.horarios"/> <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>
          
          <a href="${context}/transferencias/multimoneda/cancelar.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

          <div class="row mb10">
            <div class="f-verdeO col11">
              <h3 class="m0">Información de la Cuenta de Nómina</h3>
              <p class="h6 op70"><strong></strong></p>
            </div>  
            <div class="col1" align="right">
            <a href="#" class="icon icon-info fR tooltip">
            <span><span class="icon icon-close2"></span>
            	  <span class="h6"><strong><spring:message code="afirmenet.tooltip.transmultim.titulo"/></strong></span>
            	  <span><spring:message code="afirmenet.tooltip.transmultim.desc"/></span>
        	</span>
            </a>
          </div>
          </div>

          <div class="mb20">
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Número de Cuenta</label></div>
              <div class="form-input relative">
              	${nomina.destino.number}
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Nickname</label></div>
              <div class="form-input relative">
              	${nomina.destino.nickname}
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Línea Autorizada</label></div>
              <div class="form-input relative">
              	$ ${nomina.montoAutorizadoFormatted}
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Crédito Utilizado</label></div>
              <div class="form-input relative">
              	${nomina.creditoUtilizado - nomina.anticipoUtilizado}
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Anticipo Utilizado</label></div>
              <div class="form-input relative">
              	${nomina.anticipoUtilizado}
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Crédito Otorgado</label></div>
              <div class="form-input relative">
              	${nomina.creditoUtilizado}
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Crédito Disponible</label></div>
              <div class="form-input relative">
              	$ ${nomina.creditoDisponibleFormatted}
              </div>
            </fieldset>
            <fieldset>
              <div class="form-label w33"><label for="clave-transfer">Importe a Solicitar</label></div>
              <div class="form-input relative">
              	<input name="amount" class="f-verdeO" id="clave-transfer" placeholder="Clave de Transferencia" type="text">
                <a class="ayuda tooltip t-serv"><spring:message code="afirmenet.ayuda.icon"/>
                	<span><spring:message code="afirmenet.tooltip.transmultim.clave"/></span>
                </a>
              </div>
            </fieldset>            
          </div>
          
          <div class="p20">
            <div class="acciones" align="right">
              <a href="${context}/nomina/disposicion/cancelar.htm" data-fancybox-type="iframe" class="modal btn atras mr10"><spring:message code="afirmenet.botones.atras"/></a>
              <a href="#" class="btn verde"><spring:message code="afirmenet.continuar"/></a>
            </div>
          </div>
          
          </form:form>

        </div></div>

      </div>

    </article>

</div></section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>