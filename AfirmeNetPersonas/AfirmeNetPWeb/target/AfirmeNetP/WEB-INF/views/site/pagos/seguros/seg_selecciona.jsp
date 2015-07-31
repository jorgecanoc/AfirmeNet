<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

    <script type="text/javascript">    
    function habilitaBoton(){
    	if($('input[name=radio]:checked').length > 0 && $('#origen').val()!=''){
      		$('.btop2.hidden').removeClass('hidden');
      	}else{
      		$('.btop2').addClass('hidden');
      	}
    }
    function enviaForm(){
    	submitFormAnimateWOC($('#seguroCardif').attr('id'), $('#seguroCardif').attr('action'));
    }
      $('document').ready(function(){
      
      $('.modal').fancybox({
        maxHeight : 600,
        fitToView : false,
        width     : '90%',
        height    : '80%',
        padding   : 0
      });
      
      // Radio
      $('.radio').click(function(){
        $('.paquete').removeClass('sel');
        $(this).parent().parent().addClass('sel');
        habilitaBoton();
      });

      $('.drop').dropkick({ mobile: true, change: function(dk){ $(this.data.elem).find('.dk-selected').addClass('f-verde'); habilitaBoton();} });
      
      
    });
    
    
    
  </script>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

 <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
 		<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%> 
      </div>

      <div class="col-der relative">

        <div class="contenido">
       <!--INCLUDE DE ERRORES PARA TRANSFERENCIAS-->
	   <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>	
       <form:form commandName="seguroCardif" method="POST" action="confirma_seguros.htm">
       
		<div class="p20">

          <h3 class="titulo"><spring:message code="afirmenet.pagos.seguros.titulo" /></h3>
          <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO"><c:out value="${horario}"/></span></p>

          <a href="#" class="cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.paquete"/></small></span></span>
            <span class="paso col4"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso col4"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

          <div class="clearfix mb10">
            <h3 class="f-verdeO fL"><spring:message code="afirmenet.pagos.seguros.paquete"/></h3>
            <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong><spring:message code="afirmenet.pagos.seguros.tooltip.titulo"/></strong></span><span><spring:message code="afirmenet.pagos.seguros.tooltip.contenido"/></span></span></a>
          </div>

          <div class="mb40">
            <h6 class="mb5"><spring:message code="afirmenet.transferencias.origen"/></h6>
            <form:select id="origen" path="origen.number" cssClass="drop req">
              <option value =""><spring:message code="afirmenet.pagos.seguros.selecionar"/></option>
              	<c:forEach var="cuentaPropia" items="${catCuentasCardif}">
                	<option value="${cuentaPropia.number}">
                		${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} - ${cuentaPropia.ccy}
               		</option>
                </c:forEach>
            </form:select>
          </div>

          <div class="row mb20">
            <div class="col4 xs-mb20 xs-break"><div class="paquete">
              <div class="titulo-paquete">
                <input type="radio" id="radio1" name="radio" class="radio" value="${cBasico.tipo}">
                <label for="radio1"><span class="f21"><c:out value="${cBasico.nombre}"/> </span></label>
              </div>
              <div class="detalle-paquete">
                <p class="f42 f-verdeO"><strong><small>$</small> <c:out value="${cBasico.costoMensual}"/></strong></p>
                <ul>
                  <li><strong><spring:message code="afirmenet.pagos.seguros.coberturas.titulo"/></strong></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.tarjetas"/> $<c:out value="${cBasico.tarjetas}"/> </li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.cheques"/> $<c:out value="${cBasico.cheques}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.internet"/> $<c:out value="${cBasico.internet}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.cajeros"/> $<c:out value="${cBasico.cajeros}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.compra"/> $<c:out value="${cBasico.compra}"/></li>
                </ul>
              </div>
            </div></div>
            <div class="col4 xs-mb20 xs-break"><div class="paquete">
              <div class="titulo-paquete">
                <input type="radio" id="radio2" name="radio" class="radio"  value="${cOro.tipo}">
                <label for="radio2"><span class="f21"><c:out value="${cOro.nombre}"/> </span></label>
              </div>
              <div class="detalle-paquete">
                <p class="f42 f-verdeO"><strong><small>$</small> <c:out value="${cOro.costoMensual}"/></strong></p>
                <ul>
                  <li><strong><spring:message code="afirmenet.pagos.seguros.coberturas.titulo"/></strong></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.tarjetas"/> $<c:out value="${cOro.tarjetas}"/> </li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.cheques"/> $<c:out value="${cOro.cheques}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.internet"/> $<c:out value="${cOro.internet}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.cajeros"/> $<c:out value="${cOro.cajeros}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.compra"/> $<c:out value="${cOro.compra}"/></li>
                </ul>
              </div>
            </div></div>
            <div class="col4 xs-mb20 xs-break"><div class="paquete">
              <div class="titulo-paquete">
                <input type="radio" id="radio3" name="radio" class="radio" value="${cPlatino.tipo}" >
                <label for="radio3"><span class="f21"><c:out value="${cPlatino.nombre}"/> </span></label>
              </div>
              <div class="detalle-paquete">
                <p class="f42 f-verdeO"><strong><small>$</small> <c:out value="${cPlatino.costoMensual}"/></strong></p>
                <ul>
                  <li><strong><spring:message code="afirmenet.pagos.seguros.coberturas.titulo"/></strong></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.tarjetas"/> $<c:out value="${cPlatino.tarjetas}"/> </li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.cheques"/> $<c:out value="${cPlatino.cheques}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.internet"/> $<c:out value="${cPlatino.internet}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.cajeros"/> $<c:out value="${cPlatino.cajeros}"/></li>
                  <li><spring:message code="afirmenet.pagos.seguros.coberturas.compra"/> $<c:out value="${cPlatino.compra}"/></li>
                </ul>
              </div>
              </div>
            </div></div>
          </div>

       </form:form>
          <div class="p20 btop2 hidden">

            <div class="row acciones" align="right">
				<a href="${context}/pagos/seguros/cardif/contrato_seguros.htm" data-fancybox-type="iframe" class="modal btn verde"><spring:message code="afirmenet.pagos.seguros.continuar"/></a>
            </div>

          </div>

        </div>
      
  
        </div>


    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>