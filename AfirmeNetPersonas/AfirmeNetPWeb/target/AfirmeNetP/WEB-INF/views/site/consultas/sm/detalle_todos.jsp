
<%@ include file="/WEB-INF/views/base/include/include.jsp"%>


<link href='<c:url value="/resources/css/cuentas.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/dropkick.css"/>' rel="stylesheet" type="text/css">


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

		<c:set var="enaAnterior" value="disabled"/>
		<c:set var="enaActual" value=""/>
		<c:set var="espacioAnterior" value="mb30"/>
		<c:if test="${consulta.esMesActual}">
			<c:set var="enaAnterior" value=""/>
			<c:set var="enaActual" value="disabled"/>
			<c:set var="espacioAnterior" value=""/>
		</c:if>
          <div class="bbot pb10 mb20">
            <div class="row">
              <div class="col4 xs-col2" align="right"><button ${enaAnterior } class="btn btn-xs verde" onclick="mesAnterior()"><span class="icon icon-left"></span></button></div>
              <div class="col4 xs-col8" align="center"><p class="h3 mb5 "><strong>${consulta.fechaTituloMes}</strong></p></div>
              <div class="col4 xs-col2" align="left"><button ${enaActual } class="btn btn-xs gris" onclick="mesActual()"><span class="icon icon-right"></span></button></div>
            </div>
            <div align="center"><p class="h6 op70">${consulta.registros} Movimientos</p></div>
          </div>

          <div class="pb10"><div class="row">

            <div class="col6 xs-col12">
              <h4 class="mb5">${consulta.cuentaNombre}</h4>
              <c:if test="${consulta.esMesActual}">
              	<h3 class="f-verde">$${consulta.saldoDisponibleStr} ${consulta.cuentaMoneda}</h3>
              </c:if>
              
            </div>

            <div class="col6 xs-col12 xs-left" align="right">
              <h6 class="op70">
                ${consulta.cuentaDesc}<br>
                Cuenta  ${consulta.cuenta}<br>
                CLABE ${consulta.cuentaClabe}
              </h6>
            </div>

          </div></div>

          <div class="tabs row ${espacioAnterior }">
            <a href="#" onclick="verDetalle('detalle-ultimos-movimientos.htm');" class="col3">�ltimos Movimientos</a>
            <a href="#" onclick="verDetalle('detalle-todos-movimientos.htm');" class="act col3">Todos</a>
            <a href="#" onclick="verDetalle('detalle-movimientos-retenidos.htm');" class="col3">Retenidos / Diferidos</a>
            <a href="#" onclick="verDetalle('buscar-movimientos-filtro.htm');" class="col3">Buscar</a>
          </div>
			<c:if test="${consulta.esMesActual}">
				<p class="saldo">SALDO INICIAL:  <strong class="h6">$${consulta.saldoIncialStr}</strong></p>
			</c:if>
          


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


          <div class="pag"><ul>
          	<c:set var="classPrimera" value="disabled"/>
          	<c:set var="classUltima" value="disabled"/>
          	<c:if test="${consulta.paginaActual > 1}">
          		<c:set var="classPrimera" value="f-verde"/>
          	</c:if>
          	<c:if test="${consulta.paginaActual ne consulta.paginas}">
          		<c:set var="classUltima" value="f-verde"/>
          	</c:if>
            <li><a href="#" class="${classPrimera}"  onClick="cambiaPagina(1)">|<span class="icon icon-left"></span> <span class="hide-xs">PRIMERA</span></a></li>
            <li><a href="#" class="${classPrimera}" onClick="cambiaPagina(${consulta.paginaActual-1})"><span class="icon icon-left"></span></a></li>
            
            <c:set var="i" value="1"/>
            <c:set var="j" value="${consulta.paginas}"/>
            <c:if test="${j > 5}">
            	<c:set var="j" value="5"/>
            	<c:if test="${consulta.paginaActual >= 5}">
            		<c:set var="i" value="${consulta.paginaActual}"/>
            		<c:set var="j" value="${consulta.paginaActual + 4}"/>
            		<c:if test="${j > consulta.paginas }">
            			<c:set var="j" value="${consulta.paginas}"/>
            			<c:set var="i" value="${j - 4}"/>
            		</c:if>
            	</c:if>
            </c:if>
            
            
            <c:forEach var="k" begin="${i}" end="${j}">
            	<c:set var="estilo" value=""/>
            	<c:set var="estilo2" value=""/>
            	<c:if test="${k eq consulta.paginaActual}">
            		<c:set var="estilo" value="disabled"/>
            	</c:if>
            	<c:if test="${((j-i)>3) && ((k+2) > j)}">
            		<c:set var="estilo2" value="hide-xs"/>
            	</c:if>
   				<li><a href="#" class="${estilo} ${estilo2}" onClick="cambiaPagina(${k})">${k}</a></li>	
			</c:forEach>
            <c:if test="${j<consulta.paginas}">
            	<li><a href="#" class="disabled">...</a></li>
            </c:if>
            
            <li><a href="#" class="${classUltima}" onClick="cambiaPagina(${consulta.paginaActual+1})"><span class="icon icon-right"></span></a></li>
            <li><a href="#" class="${classUltima}" onClick="cambiaPagina(${consulta.paginas})"><span class="hide-xs">�LTIMA</span> <span class="icon icon-right"></span>|</a></li>
          </ul></div>

          <div align="right" class="hide-xs mb15">
            <div class="btn-exp mr20">
              <a href="#">EXPORTAR</a>
              <select name="tipo-archivo" class="drop">
                <option>CSV</option>
                <option>PDF</option>
              </select>
            </div>
            <a href="#" class="btn verde hide-xs">IMPRIMIR</a>
          </div>
          <div class="show-xs mb15"><a href="#" class="btn verde show-xs">EXPORTAR</a></div>

          <table class="t-tot">
            <thead><tr>
              <th colspan="2">TOTALES:</th>
            </tr></thead>
            <tbody>
              <tr>
                <td width="50%">TOTAL CARGOS (${consulta.numCargos})</td>
                <td width="50%" align="right"><span class="retiro">$${consulta.cargosStr}</span></td>
              </tr>
              <tr>
                <td>TOTAL ABONOS (${consulta.numAbonos})</td>
                <td align="right"><span class="abono">$${consulta.abonosStr}</span></td>
              </tr>
              <c:if test="${consulta.esMesActual}">
	              <tr>
	                <td class="pb5"><strong>SALDO TOTAL</strong></td>
	                <td class="pb5" align="right"><span class="abono"><strong>$${consulta.saldoFinalStr}</strong></span></td>
	              </tr>
	              <tr>
	                <td><small>SALDO DIFERIDO</small></td>
	                <td align="right"><span class="abono"><small>$${consulta.saldoDiferidoStr}</small></span></td>
	              </tr>
	              <tr>
	                <td><small>SALDO DISPONIBLE</small></td>
	                <td align="right"><span class="abono"><small>$${consulta.saldoDisponibleStr}</small></span></td>
	              </tr>
	              <tr>
	                <td><small>INTER�S SOBREGIRO</small></td>
	                <td align="right"><span class="abono"><small>$${consulta.interesSobregiroStr}</small></span></td>
	              </tr>
	              <tr>
	                <td><small>INTER�S POR PAGAR</small></td>
	                <td align="right"><span class="abono"><small>$${consulta.interesPagarStr}</small></span></td>
	              </tr>
              </c:if>
            </tbody>
          </table>       

        </div></div>

      </div>

    </article>

  </div></section>

<%@ include file="/WEB-INF/views/base/include/footerSession.jsp"%>
  <form:form method="POST" commandName="consulta" action="#">
  <form:hidden path="paginas"/>
  <form:hidden path="cuenta"/>
  <form:hidden path="paginaActual"/>
  <form:hidden path="registros"/>
  <form:hidden path="numCargos"/>
  <form:hidden path="numAbonos"/>
  <form:hidden path="cargos"/>
  <form:hidden path="abonos"/>
  <form:hidden path="cuentaDesc"/>
  <form:hidden path="cuentaMoneda"/>
  <form:hidden path="cuentaNombre"/>
  <form:hidden path="cuentaClabe"/>
  <form:hidden path="clave"/>
  <form:hidden path="saldoIncial"/>
  <form:hidden path="saldoFinal"/>
  <form:hidden path="numCargos"/>
  <form:hidden path="numAbonos"/>
  <form:hidden path="cargos"/>
  <form:hidden path="abonos"/>
  <form:hidden path="saldoDiferido"/>
  <form:hidden path="saldoDisponible"/>
  <form:hidden path="interesSobregiro"/>
  <form:hidden path="interesPagar"/>
  <form:hidden path="fechaInicio"/>
  <input type="hidden" name="cuenta" id="cuenta" value="${consulta.cuenta}"/>
  <input type="hidden" name="paginaActual" id="paginaActual" value="${consulta.paginaActual}"/>
  
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
  	function cambiaPagina(pagina){
  		//alert(pagina);
  		if(pagina==${consulta.paginaActual})
  			return;
  		if(pagina<1)
  			return;
  		if(pagina>${consulta.paginas})
  			return;
  		$('#paginaActual').val(pagina);
  		$('#consulta').attr('action','detalle-todos-movimientos.htm');
  		$('body').append('<div id="loading"></div>');
  		$('#loading').fadeIn(1, function(){
          $('#consulta').submit();
        });
  		return;
  	}
  	function mesAnterior(){
  		$('#consulta').attr('action','detalle-todos-movimientos-anterior.htm');
  		$('#paginaActual').val('1');
  		$('body').append('<div id="loading"></div>');
  		$('#loading').fadeIn(1, function(){
          $('#consulta').submit();
        });
  		return;
  	}
  	function mesActual(){
  		$('#consulta').attr('action','detalle-todos-movimientos.htm');
  		$('#paginaActual').val('1');
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