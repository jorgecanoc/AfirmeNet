<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />


    <script type="text/javascript">
    $('document').ready(function(){

      $('.drop').dropkick({ mobile: true, change: function(dk){ $(this.data.elem).find('.dk-selected').addClass('f-verde'); } });
      // Solo para el ejemplo
      $('.dropfinal').dropkick({
        mobile: true,
        change: function(){ 
          $(this.data.elem).find('.dk-selected').addClass('f-verde');
          $('.acciones .hidden').removeClass('hidden');
        }
      });
		
		$('a.btn.verde').click(function() {
			if (validForm($('#transferencia').attr('id')))
				submitFormAnimateWOC($('#transferencia').attr('id'), $('#transferencia').attr('action'));
		});
		//onclick="submitFormAnimate('transferencia','captura.htm'); return false;"
		
    });
  </script>



 <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
 		<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%> 
      </div>

      <div class="col-der relative">

        <div class="contenido">
        
        

		<c:if test="${fn:length(errores) gt 0}">
		          <div class="notificacion error">
		          	<a class="icon icon-close2"></a>
		       		<div class="clearfix">
		       			<span class="icon icon-error"></span>
		       			<p class="f21 m0"><strong>ERROR</strong><br>
		        			<c:forEach var="error" items="${errores}">
							Error al realizar la Transferencia de ${error.key}
							<br/>
							${error.value}
							<br/>
							</c:forEach>
		       			</p>
		    		</div>
				  </div>
		        </c:if>
        
        
        <div class="p20">

	<form:form commandName="transferencia" method="POST" action="captura.htm">
          <h3 class="titulo"><spring:message code="afirmenet.transferencias.nacionales.titulo" /></h3>
          <p><spring:message code="afirmenet.horarios"/><span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

          <a href="#" class="cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.transferencia"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.datos"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso4"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>          
          </div></div>
          <div class="clearfix mb10">
            <h3 class="f-verdeO fL"><spring:message code="afirmenet.transferencias.nacionales.tipo"/></h3>
            <a href="#" class="icon icon-info fR tooltip">
            <span><span class="icon icon-close2"></span>
            	  <span class="h6"><strong><spring:message code="afirmenet.tooltip.transnacionales.titulo"/></strong></span>
            	  <span><spring:message code="afirmenet.tooltip.transnacionales.desc"/></span></span>
            </a>
          </div>

          <div class="bbot2 mb20">
            <div class="row mb20"><div class="col6 xs-col12">
             
              <form:select id="tipo" path="transactionCode" cssClass="drop req">
                <option value=''><spring:message code="afirmenet.transferencias.nacionales.selecionar"/></option>
                <option value='05'><spring:message code="afirmenet.transferencias.nacionales.SPEI"/></option>
                <option value='09'><spring:message code="afirmenet.transferencias.nacionales.TEF"/></option>
              </form:select>
            </div></div>
          </div>

          <div class="bbot2 mb20">
            <div class="row">
              <div class="col6 xs-break mb20">
                <h6 class="mb5"><spring:message code="afirmenet.transferencias.origen"/></h6>
                <form:select id="origen" path="origen.number" cssClass="drop req">
                	<option value =""><spring:message code="afirmenet.transferencias.nacionales.selecionar.cuenta"/></option>
                	<c:forEach var="cuentaPropia" items="${cuentasOrigen}">
                	<option value="${cuentaPropia.number}">
                		${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} - ${cuentaPropia.ccy}
               		</option>
                	</c:forEach>
                </form:select>

              </div>
              <div class="col6 xs-break mb20">
                <h6 class="mb5"><spring:message code="afirmenet.transferencias.destino"/></h6>
               <form:select id="destino" path="destino.number" cssClass="dropfinal req">
                	<option value ="">Seleccionar Cuenta</option>
                	<c:forEach var="cuentaTercero" items="${cuentasDestino}">
                	<option value="${cuentaTercero.ACCNUM}">
                		${cuentaTercero.ACCOWNER} (${cuentaTercero.ACCNUMMask}) - ${cuentaTercero.BNKNAME}
               		</option>
                	</c:forEach>
               	</form:select>
              </div>
            </div>
          </div>

          <div class="row acciones">
            <div class="col6 xs-break xs-center xs-mb20"><a href="#" class="btn gris"><span class="icon icon-plus"></span><spring:message code="afirmenet.botones.agregarcuenta1"/><span class="hide-xs"><spring:message code="afirmenet.botones.agregarcuenta2"/></span></a></div>
            <div class="col6 xs-break xs-center hidden" align="right">
              <a href="#" class="btn verde"><spring:message code="afirmenet.botones.continuar" /></a>
            </div>
          </div>

  </form:form>
        </div></div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>