
<%@ include file="/WEB-INF/views/base/include/include.jsp"%>

<jsp:useBean id="consCuenta" class="com.afirme.afirmenet.ibs.beans.consultas.Cuenta" scope="session"/>

<link href='<c:url value="/resources/css/cuentas.css"/>' rel="stylesheet" type="text/css">

<body>

<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

  <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">

<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
        
      </div>

      <div class="col-der relative">

        <h3 class="titulo mt20"><spring:message code="afirmenet.consultas.sm.resumen.titulo"/></h3>

        <div class="row mt15" id="container">
        <c:set var="anchoUno" value="col4"/>
        <c:set var="anchoDos" value="col4"/>
        <c:set var="anchoTres" value="col4"/>
		<c:if test="${(resumenCuentas.tieneCuentas + resumenInversiones.tieneCuentas + resumenCreditos.tieneCuentas) eq 2 }">
			<c:set var="anchoUno" value="col8"/>
		</c:if>
		<c:if test="${(resumenCuentas.tieneCuentas + resumenInversiones.tieneCuentas + resumenCreditos.tieneCuentas) eq 1 }">
			<c:set var="anchoUno" value="col12"/>
		</c:if>

		<c:forEach var="res" varStatus="status" items="${resumen}">
			 <div class="item ${anchoUno} xs-col12 mb10">

            <a class="refresh"><span class="icon icon-refresh"></span><span class="loader"><span class="loader-inner"></span></span></a>
            <div class="cuenta">
              <div class="bbot mb10">
                <h4>${res.descripcion}</h4>
                <h3>$${res.totalStr}</h3>
              </div>
              <div class="clearfix">
                <p class="fL"><a href="resumen.jsp">${res.cuentas} <spring:message code="afirmenet.consultas.sm.resumen.cuentas"/></a></p>
              </div>
              <a href="#cuentas-0${status.count}" class="icon icon-zoom"></a>
            </div>

          </div>
			<div id="cuentas-0${status.count}" class="col12 detcuenta item"><ul>
			<c:set var="listaCuentas" value="${cuentas}"/>
			<c:if test="${res.descripcion eq consCuenta.consTipoCredito}">
				<c:set var="listaCuentas" value="${creditos}"/>
			</c:if>
			<c:if test="${res.descripcion eq consCuenta.consTipoInversion}">
				<c:set var="listaCuentas" value="${inversiones}"/>
			</c:if>
            <c:forEach var="cuenta" items="${listaCuentas}">
            	
            	<li><div class="row">
              <div class="col6 xs-col12">
                <p><a href="#" onclick="verDetalle('${cuenta.htmlDetalle}', '${cuenta.number}');" class="h4">${cuenta.description}</a></p>
                <p class="h6">
                  ${cuenta.nickname} <br>
                  <spring:message code="afirmenet.consultas.sm.resumen.cuenta"/> ${cuenta.number}<br>
                  <spring:message code="afirmenet.consultas.sm.resumen.clabe"/> ${cuenta.clabe}
                </p>
              </div>
              <div class="col6 xs-col12 xs-left" align="right">
                <h3>$
                <c:set var="monto" value="${cuenta.available}"/>
                <c:if test="${res.descripcion eq consCuenta.consTipoCredito}">
                	<c:set var="monto" value="${cuenta.dEUAMT}"/>
                </c:if>
                ${monto}
                
                </h3>
                <a href="#" onclick="verDetalle('${cuenta.htmlDetalle}', '${cuenta.number}');" class="btn btn-med gris"><spring:message code="afirmenet.resumen.VERDETALLE"/></a>
              </div>
            </div></li>
            </c:forEach>

          </ul></div>
		</c:forEach>

       


 


          <div class="item col6 xs-col12 mb10">

            <div class="bloque mb10">
              <div class="head"><div class="row mb10">
                <div class="col10"><p><strong><spring:message code="afirmenet.consultas.sm.resumen.operaciones.favoritas"/></strong></p></div>
                <div class="col2"><span class="icon icon-star f-verde"></span></div>
              </div></div>
              <ul class="l-verde">
                <li><a href="#" class="f-verde">Pagar Tarjeta Esposa</a></li>
                <li><a href="#" class="f-verde">Pagar Crédito Casa</a></li>
                <li><a href="#" class="f-verde">Enviar Dinero a Mamá¡</a></li>
                <li><a href="#" class="f-verde">Pagar Crédito Casa</a></li>
                <li><a href="#" class="f-verde">Enviar Dinero a Mamá¡</a></li>
              </ul>
            </div>

          </div>

          <div class="item col6 xs-col12 mb10">

            <div class="bloque">
              <div class="head"><div class="row mb10">
                <div class="col9"><p><strong><spring:message code="afirmenet.consultas.sm.resumen.pago.servicios"/></strong> <br> <small><spring:message code="afirmenet.consultas.sm.resumen.compra.tiempo.aire"/></small></p></div>
                <div class="col3" align="center"><span class="icon icon-services f-verde h3"></span></div>
              </div></div>
              <ul class="l-verde sm mb10">
                <li><a href="#">UDEM</a></li>
                <li><a href="#">Gas Natural</a></li>
                <li><a href="#">Telcel</a></li>
                <li><a href="#">CFE</a></li>
                <li><a href="#">Agua y drenaje</a></li>
              </ul>
              <div class="clearfix p4">
                <a href="#" class="icon icon-edit fL"></a>
                <a href="#" class="icon icon-add f-verde fR"></a>
              </div>
            </div>

          </div>  

        </div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footerSession.jsp"%>

  <form:form method="POST" commandName="consulta" action="#">
  <input type="hidden" name="cuenta" id="cuenta" value=""/>
  <input type="hidden" name="paginaActual" id="paginaActual" value="1"/>
  </form:form>
  

  <script type="text/javascript">
  	function verDetalle(accion, cuenta){
  		$('#consulta').attr('action',accion);
  		$('#cuenta').val(cuenta);
  		$('body').append('<div id="loading"></div>');
  		$('#loading').fadeIn(1, function(){
          $('#consulta').submit();
        });
  		//$('#consulta').submit();
  		return;
  	}
  
  
    $('document').ready(function(){

      var $container = $('#container');
      $container.packery({ itemSelector: '.item' });

      $('.cuenta').click(function(){ 
        var _this = $(this);
        $('.cuenta').not(_this).removeClass('open');
        $('.detcuenta').removeClass('open');
        var target = $(this).find('.icon-zoom').attr('href');
        if( _this.hasClass('open') ){ 
          $(_this).removeClass('open');
          $(target).removeClass('open');
          $container.packery();
        } else{
          _this.addClass('open'); 
          $(target).addClass('open');
          $container.packery();
        }
        return false;
      });
      $('.cuenta:eq(0)').trigger('click');

      $('.drop').dropkick({ mobile: true });

      $('.refresh .icon').click(function(){
        var _this = $(this).parent();
        _this.find('.icon').hide(0, function(){ _this.find('.loader').addClass('show'); setTimeout(function(){ _this.find('.loader').removeClass('show'); _this.find('.icon').show(); _this.parent().find('h3').html('$90,000.00'); }, 4000) })
      });

    });
</script>

</body>
</html>