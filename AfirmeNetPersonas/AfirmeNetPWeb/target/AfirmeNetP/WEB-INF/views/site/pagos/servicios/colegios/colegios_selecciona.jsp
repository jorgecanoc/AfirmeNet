<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

    <script type="text/javascript">    
      $('document').ready(function(){
      
        $('.drop').dropkick({ mobile: true, change: function(dk){ $(this.data.elem).find('.dk-selected').addClass('f-verde'); } });
      // Solo para el ejemplo
      $('.dropfinal').dropkick({
        mobile: true,
        change: function(){ 
          $(this.data.elem).find('.dk-selected').addClass('f-verde');
          $('.acciones.hidden').removeClass('hidden');
        }
      });
      $('a.btn.verde').click(function() {
			if (validForm($('#colegios').attr('id')))
				submitFormAnimateWOC($('#colegios').attr('id'), $('#colegios').attr('action'));
		});
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
       <form:form commandName="colegios" method="POST" action="captura.htm">
       
		<div class="p20">

          <h3 class="titulo">Colegios Referenciados<spring:message code="afirmenet.pagos.seguros.titulo" /></h3>
          <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

          <a href="#" class="cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs">Colegio<spring:message code="afirmenet.transferencias.paso.paquete"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
            <span class="paso"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

          <div class="clearfix mb10">
            <h3 class="f-verdeO fL">Seleccionar Cuentas</h3>
            <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
          </div>

          <div class="mb20">
            <div class="row">
              <div class="col6 xs-break mb20">
                <h6 class="mb5">Cuenta Origen</h6>
                <select name="origen" class="drop">
                  <option>Seleccionar</option>
                  <option>Nómina de Danilo Black (**** 6575)</option>
                  <option>Jessica Andrea Lissette Arévalo Betancur (**** 3200)</option>
                </select>
              </div>
              <div class="col6 xs-break mb20">
                <h6 class="mb5">Seleccionar el Colegio</h6>
                <select name="destino" class="dropfinal">
                  <option>Seleccionar</option>
                  <option>Colegio Diego Rivera (**** 8988) </option>
                </select>
              </div>
            </div>
          </div>
          
          
          <div class="acciones hidden" align="right"><div class="btop2 pt20">
            <a class="btn verde">Continuar</a>
          </div></div>
        
        </div>

       </form:form>


        </div>
      
  
        </div>


    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>