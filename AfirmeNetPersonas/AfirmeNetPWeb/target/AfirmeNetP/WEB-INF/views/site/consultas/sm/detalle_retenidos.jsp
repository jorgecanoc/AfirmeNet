
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

          <div class="bbot pb10 mb20">
            <div class="row">
              <div class="col4 xs-col2" align="right"><button class="btn btn-xs verde"><span class="icon icon-left"></span></button></div>
              <div class="col4 xs-col8" align="center"><p class="h3 mb5 "><strong>ENERO 2015</strong></p></div>
              <div class="col4 xs-col2" align="left"><button disabled class="btn btn-xs gris"><span class="icon icon-right"></span></button></div>
            </div>
            <div align="center"><p class="h6 op70">5 Movimientos</p></div>
          </div>

          <div class="pb10"><div class="row">

            <div class="col6 xs-col12">
              <h4 class="mb5">Jessica Arévalo</h4>
              <h3 class="f-verde">$1,410,000.00 MXP</h3>
            </div>

            <div class="col6 xs-col12 xs-left" align="right">
              <h6 class="op70">
                Cuenta Visión<br>
                Cuenta  806418412<br>
                CLABE 062580008064184121
              </h6>
            </div>

          </div></div>

          <div class="tabs row mb30">
             <a href="#" onclick="verDetalle('detalle-ultimos-movimientos.htm');" class="col3">Últimos Movimientos</a>
            <a href="#" onclick="verDetalle('detalle-todos-movimientos.htm');" class="col3">Todos</a>
            <a href="#" onclick="verDetalle('detalle-movimientos-retenidos.htm');" class="act col3">Retenidos / Diferidos</a>
            <a href="#" onclick="verDetalle('buscar-movimientos-filtro.htm');" class="col3">Buscar</a>
          </div>

          <table class="t-mov">
            <thead><tr>
              <th width="46%">LUNES 05 MARZO 2015</th>
              <th width="18%" align="right"><small>CARGOS</small></th>
              <th width="18%" align="right"><small>ABONO</small></th>
              <th width="18%" align="right"><small>SALDO</small></th>
            </tr></thead>
            <tbody>
              <tr>
                <td><strong>Traspaso de 806418412</strong><br><small>REFERENCIA 123456<br>VENCE EL: 12-01-2014 DÍAS: 2</small></td>
                <td align="right"></td>
                <td align="right" class="abono">$40,000.00</td>
                <td align="right">$1,350,000.00</td>
              </tr>
              <tr>
                <td><strong>Retiro Cajero Valle Oriente </strong><br><small>REFERENCIA 123456<br>VENCE EL: 12-01-2014 DÍAS: 2</small></td>
                <td align="right" class="retiro">$40,000.00</td>
                <td align="right"></td>
                <td align="right">$1,350,000.00</td>
              </tr>
              <tr>
                <td><strong>Traspaso de 806279412 </strong><br><small>REFERENCIA 123456<br>VENCE EL: 12-01-2014 DÍAS: 2</small></td>
                <td align="right"></td>
                <td align="right" class="abono">$40,000.00</td>
                <td align="right">$1,350,000.00</td>
              </tr>
            </tbody>
          </table>

          <table class="t-mov">
            <thead><tr>
              <th width="40%">MARTES 06 MARZO 2015</th>
              <th width="18%" align="right">&nbsp;</th>
              <th width="18%" align="right">&nbsp;</th>
              <th width="18%" align="right">&nbsp;</th>
            </tr></thead>
            <tbody>
              <tr>
                <td><strong>Traspaso de 806418412</strong><br><small>REFERENCIA 123456<br>VENCE EL: 12-01-2014 DÍAS: 2</small></td>
                <td align="right"></td>
                <td align="right" class="abono">$5,000.00</td>
                <td align="right">$1,350,000.00</td>
              </tr>
              <tr>
                <td><strong>Traspaso de 806279412 </strong><br><small>REFERENCIA 123456<br>VENCE EL: 12-01-2014 DÍAS: 2</small></td>
                <td align="right"></td>
                <td align="right" class="abono">$20,000.00</td>
                <td align="right">$1,350,000.00</td>
              </tr>
            </tbody>
          </table>

          <div class="pag"><ul>
            <li><a href="#" class="disabled">|<span class="icon icon-left"></span> <span class="hide-xs">PRIMERA</span></a></li>
            <li><a href="#" class="disabled"><span class="icon icon-left"></span></a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#" class="hide-xs">4</a></li>
            <li><a href="#" class="hide-xs">5</a></li>
            <li><a href="#">...</a></li>
            <li><a href="#" class="f-verde"><span class="icon icon-right"></span></a></li>
            <li><a href="#" class="f-verde"><span class="hide-xs">ÚLTIMA</span> <span class="icon icon-right"></span>|</a></li>
          </ul></div>

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
    $('document').ready(function(){

      $('.drop').dropkick({ mobile: true });

    });
  </script>

</body>
</html>