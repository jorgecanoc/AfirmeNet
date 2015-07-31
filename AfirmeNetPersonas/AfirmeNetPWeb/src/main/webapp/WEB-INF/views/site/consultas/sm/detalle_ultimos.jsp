
<%@ include file="/WEB-INF/views/base/include/include.jsp"%>


<link href='<c:url value="/resources/css/cuentas.css"/>' rel="stylesheet" type="text/css">


<body>

 <%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
  <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
      </div>

      <div class="col-der relative">

        <div class="contenido"><div class="p20">

          <div class="bbot mb20"><h3 class="titulo">Detalle de Movimientos</h3></div>

          <div class="bbot pb10 mb20">
            <div align="center"><p class="h3 mb5 "><strong>${consulta.fechaTitulo}</strong></p></div>
            <div align="center"><p class="h6 op70">${consulta.registros} Movimientos</p></div>
          </div>

          <div class="pb10"><div class="row">

            <div class="col6 xs-col12">
              <h4 class="mb5">${consulta.cuentaNombre}</h4>
              <h3 class="f-verde">$${consulta.saldoDisponibleStr} ${consulta.cuentaMoneda}</h3>
            </div>

            <div class="col6 xs-col12 xs-left" align="right">
              <h6 class="op70">
                ${consulta.cuentaDesc}<br>
                Cuenta  ${consulta.cuenta}<br>
                CLABE ${consulta.cuentaClabe}
              </h6>
            </div>

          </div></div>

          <div class="tabs row mb30">
            <a href="#" onclick="verDetalle('detalle-ultimos-movimientos.htm');" class="act col3">Últimos Movimientos</a>
            <a href="#" onclick="verDetalle('detalle-todos-movimientos.htm');" class="col3">Todos</a>
            <a href="#" onclick="verDetalle('detalle-movimientos-retenidos.htm');" class="col3">Retenidos / Diferidos</a>
            <a href="#" onclick="verDetalle('buscar-movimientos-filtro.htm');" class="col3">Buscar</a>
          </div>
 		<c:set var="fechaAnterior" value=""/>
 		<c:forEach var="movimiento" varStatus="status" items="${consulta.movimientos}">
 			<c:if test="${status.count==1}">
	 			<table class="t-mov">
	            <thead><tr>
	              <th width="46%">${movimiento.fechaLarga}</th>
	              <th width="18%" align="right"><small>CARGOS</small></th>
	              <th width="18%" align="right"><small>ABONO</small></th>
	              <th width="18%" align="right"><small>SALDO</small></th>
	            </tr></thead>
	            <tbody>
 			</c:if>
 			<c:if test="${(status.count > 1) && (fechaAnterior ne movimiento.fecha) }">
 				
		          </tbody>
		        </table>
 				<table class="t-mov">
	            <thead><tr>
	              <th width="46%">${movimiento.fechaLarga}</th>
	              <th width="18%" align="right"><small>&nbsp;</small></th>
	              <th width="18%" align="right"><small>&nbsp;</small></th>
	              <th width="18%" align="right"><small>&nbsp;</small></th>
	            </tr></thead>
	            <tbody>
 			</c:if>
	 		  <tr>
                <td><strong>${movimiento.narrativa}</strong>
                	<c:if test="${movimiento.referencia>0 }">
                		<br/><small>REFERENCIA ${movimiento.referencia}</small>
                	</c:if>
                </td>


                <td align="right" class="retiro">
                	<c:if test="${!movimiento.esCredito}">
                		${movimiento.montoStr}
                	</c:if>
                </td>
                <td align="right" class="abono">
                	<c:if test="${movimiento.esCredito}">
                		${movimiento.montoStr}
                	</c:if>
                
                </td>
                <td align="right">${movimiento.balanceStr}</td>
              </tr>
 			<c:set var="fechaAnterior" value="${movimiento.fecha}"/>
        </c:forEach>
        <c:if test="${fechaAnterior ne '' }">
		          </tbody>
		        </table>
        </c:if>


          <div align="right" class="hide-xs">
            <div class="btn-exp mr20">
              <a href="#">EXPORTAR</a>
              <select name="tipo-archivo" class="drop">
                <option>CSV</option>
                <option>PDF</option>
              </select>
            </div>
            <a href="#" class="btn verde hide-xs">IMPRIMIR</a>
          </div>
          <div class="show-xs"><a href="#" class="btn verde show-xs">EXPORTAR</a></div>     

        </div></div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footerSession.jsp"%>
  
  <form:form method="POST" commandName="consulta" action="#">
  <input type="hidden" name="cuenta" id="cuenta" value="${consulta.cuenta}"/>
  <input type="hidden" name="paginaActual" id="paginaActual" value="${consulta.paginaActual}"/>
  <form:hidden path="cuentaDesc"/>
  <form:hidden path="cuentaMoneda"/>
  <form:hidden path="cuentaNombre"/>
  <form:hidden path="cuentaClabe"/>
  <form:hidden path="clave"/>
  <form:hidden path="fechaInicio"/>
  </form:form>
  

  <script type="text/javascript">
  	function verDetalle(accion){
  		$('#consulta').attr('action',accion);
  		$('body').append('<div id="loading"></div>');
  		$('#loading').fadeIn(1, function(){
          $('#consulta').submit();
        });
  		return;
  	}
    $('document').ready(function(){

      $('.drop').dropkick({ mobile: true });

    });
  </script>

</body>
</html>