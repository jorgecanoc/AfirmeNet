<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

    <script type="text/javascript">    
    
      $('document').ready(function(){
      
      $('.modal').fancybox({
        maxHeight : 600,
        fitToView : false,
        width     : '90%',
        height    : '80%',
        padding   : 0
      });
      
      $('.drop').dropkick({ mobile: true, change: function(dk){ $(this.data.elem).find('.dk-selected').addClass('f-verde'); } });
      // Solo para el ejemplo
      $('.dropfinal').dropkick({
        mobile: true,
        change: function(){ 
          $(this.data.elem).find('.dk-selected').addClass('f-verde');
          $('.acciones .hidden').removeClass('hidden');
        }
      });
      
      //ENVIA FORMULARIO
      $('#continuar').click(function() {
			submitFormModal($('#domiciliar').attr('id'), $('#domiciliar').attr('action'));
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
       <!--INCLUDE DE ERRORES PARA TRANSFERENCIAS-->
	   <%@ include file="/WEB-INF/views/site/transferencias/error.jsp"%>	
       <form:form commandName="domiciliar" method="POST" action="pagos/tdcDomiciliar/contrato_tdcDomi.htm">
       
	   <div class="p20">

          <h3 class="titulo"><spring:message code="afirmenet.pagos.tdcdomi.titulo" /></h3>
          <p><spring:message code="afirmenet.horarios" /><span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

          <a href="${context}/pagos/tdcDomiciliar/cancela.htm" data-fancybox-type="iframe" class="modal cerrar"></a>
          <div class="ovhidden mb30"><div class="pasos">
            <span class="paso col4 activo"><span><spring:message code="afirmenet.transferencias.paso1"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.cuentas"/></small></span></span>
            <span class="paso col4"><span><spring:message code="afirmenet.transferencias.paso2"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.confirmar"/></small></span></span>
            <span class="paso col4"><span><spring:message code="afirmenet.transferencias.paso3"/><small class="hide-xs"><spring:message code="afirmenet.transferencias.paso.comprobante"/></small></span></span>
          </div></div>

          <div class="clearfix mb10">
            <h3 class="f-verdeO fL"><spring:message code="afirmenet.transferencias.seleccionar"/></h3>
            <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
          </div>

          <div class="bbot2 mb20">
            <div class="row">
              <div class="col6 xs-break mb20">
                <h6 class="mb5"><spring:message code="afirmenet.transferencias.origen"/></h6>
                <select name="origen" class="drop">
                  <option>Seleccionar</option>
                  <option>Nómina de Danilo Black (**** 6575)</option>
                  <option>Jessica Andrea Lissette Arévalo Betancur (**** 3200)</option>
                </select>
              </div>
              <div class="col6 xs-break mb20">
                <h6 class="mb5"><spring:message code="afirmenet.pagos.tdcdomi.tarjeta"/></h6>
                <select name="destino" class="dropfinal">
                  <option>Seleccionar Tarjeta</option>
                  <option>AFIRME Básica (**** 1234)</option>
                  <option>Jessica Andrea Lissette Arévalo Betancur (**** 8765)</option>
                  <option>Tarjeta de Andreita (**** 9890)</option>
                  <option value="nueva">Agregar Nueva Tarjeta Destino</option>
                </select>
              </div>
            </div>
          </div>

          <div class="bbot2 mb20">
            <p class="f21 f-gris5"><strong><spring:message code="afirmenet.pagos.tdcdomi.pago"/></strong></p>
            <div class="row mb20">
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio1" name="radio" class="radio" checked>
                  <label for="radio1"><span class="f15"><spring:message code="afirmenet.pagos.tdcpropia.minimo"/></span></label>
                </div>
              </div>
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio2" name="radio" class="radio" >
                  <label for="radio2"><span class="f15"><spring:message code="afirmenet.pagos.tdcpropia.minmaspromo"/></span></label>
                </div>
              </div>
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio3" name="radio" class="radio" >
                  <label for="radio3"><span class="f15"><spring:message code="afirmenet.pagos.tdcpropia.nointereses"/></span></label>
                </div>
              </div>
              <div class="col3 xs-break">
                <div class="radio-wrap">
                  <input type="radio" id="radio4" name="radio" class="radio" >
                  <label for="radio4"><span class="h6"><spring:message code="afirmenet.pagos.tdcpropia.fijo"/></span></label>
                </div>
              </div>
            </div>
            <div class="mensaje informacion"><span class="icon icon-eye"></span><span class="icon icon-close2"></span><p><strong class="f-azul">AVISO</strong><br>El importe mínimo requerido por la tarjeta de crédito se cargará cada mes un día anterior a la fecha límite de pago a partir de las 07:00 hrs</p></div>
          </div>

          <div class="row acciones" align="right">
            <a href="${context}/pagos/tdcDomiciliar/contrato_tdcDomi.htm" data-fancybox-type="iframe" class="modal btn verde">Continuar</a>
<%--             <button id="continuar" class="modal btn verde" onclick="return false;" data-fancybox-type="iframe"><spring:message code="afirmenet.botones.continuar" /></button> --%>
          </div>

        </div>
          
       </form:form>
  
        </div>

      </div>

    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>