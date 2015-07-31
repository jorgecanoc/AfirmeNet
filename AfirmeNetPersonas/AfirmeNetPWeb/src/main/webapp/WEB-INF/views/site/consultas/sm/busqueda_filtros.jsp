
<%@ include file="/WEB-INF/views/base/include/include.jsp"%>


<link href='<c:url value="/resources/css/cuentas.css"/>' rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/pikaday.css"/>" rel="stylesheet" type="text/css" />


<body>

<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>
  <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">

<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>


      </div>
    <form:form method="POST" commandName="consulta" action="#">
      <div class="col-der relative">

        <div class="contenido"><div class="p20">

          <h3 class="titulo">Detalle de Movimientos</h3>

          <div class="bbot pb10"><div class="row">

            <div class="col6 xs-col12">
              <h4 class="mb5">${consulta.cuentaNombre}</h4>
              <h3 class="f-verde">$${consulta.saldoDisponibleStr} ${consulta.cuentaMoneda}</h3>
            </div>

            <div class="col6 xs-col12 xs-left" align="right">
              <h6 class="op70">
                ${consulta.cuentaDesc}<br>
                Cuenta   ${consulta.cuenta}<br>
                CLABE ${consulta.cuentaClabe}
              </h6>
            </div>

          </div></div>

          <div class="p20">
            <div class="row">
              <div class="col4 xs-col2" align="right"><button class="btn btn-xs verde"><span class="icon icon-left"></span></button></div>
              <div class="col4 xs-col8" align="center"><p class="h3 mb5 "><strong>${consulta.fechaTituloMes}</strong></p></div>
              <div class="col4 xs-col2" align="left"><button disabled class="btn btn-xs gris"><span class="icon icon-right"></span></button></div>
            </div>
<!--             <div align="center"><p class="h6 op70">41 Movimientos</p></div> -->
          </div>

          <div class="tabs row mb30">
            <a href="#" onclick="verDetalle('detalle-ultimos-movimientos.htm');" class="col3">Últimos Movimientos</a>
            <a href="#" onclick="verDetalle('detalle-todos-movimientos.htm');" class="col3">Todos</a>
            <a href="#" onclick="verDetalle('detalle-movimientos-retenidos.htm');" class="col3">Retenidos / Diferidos</a>
            <a href="#" onclick="verDetalle('buscar-movimientos-filtro.htm');" class="act col3">Buscar</a>
          </div>

         <h4 class="pt15 mb20">Selecciona los criterios de búsqueda:</h4>

          <div class="bbot pb15 mb15">
            <p class="h6">Fecha:</p>
            <div class="row">
              <div class="col6">
                <input value="Inicio" type="button" id="datepicker" name="datepicker" class="input">
              </div>
              <div class="col6">
                <input value="Fin" type="button" id="datepicker2" name="datepicker2" class="input">
              </div>
            </div>
          </div>

          <div class="bbot pb15 mb15">
            <p class="h6">No. de Referencia:</p>
            <div class="row">
              <div class="col6">
                <input placeholder="Sólo Números" type="text" name="referenciaInicial" class="input">
              </div>
              <div class="col6">
                <input placeholder="Sólo Números" type="text" name="referenciaFinal" class="input">
              </div>
            </div>
          </div>

          <div class="mb15">
            <p class="h6">Monto:</p>
            <div class="row">
              <div class="col6">
                <div class="form-input relative importe">
                  <strong class="divisa">$</strong>
                  <input name="montoInicial" placeholder="Mínima" type="text">
                </div>
              </div>
              <div class="col6">
                <div class="form-input relative importe">
                  <strong class="divisa">$</strong>
                  <input name="montoFinal" placeholder="Máxima" type="text">
                </div>
              </div>
            </div>
          </div>


          <div align="right"><button onclick="buscar();" class="btn verde">BUSCAR</button></div>

        </div></div>

      </div>

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
  <input type="hidden" name="fechaInicioStr" id="fechaInicioStr" value=""/>
  <input type="hidden" name="fechaFinStr" id="fechaFinStr" value=""/>
  <input type="hidden" name="cuenta" id="cuenta" value="${consulta.cuenta}"/>
  <input type="hidden" name="paginaActual" id="paginaActual" value="${consulta.paginaActual}"/>
  
  </form:form>
    </article>

  </div></section>

  <%@ include file="/WEB-INF/views/base/include/footerSession.jsp"%>

  <script src='<c:url value="/resources/js/vendor/moment.js"/>' type="text/javascript"></script>
  <script src='<c:url value="/resources/js/vendor/pikaday.js"/>' type="text/javascript"></script>
  <script type="text/javascript">
  	function buscar(){
  	//
	  	if($('#datepicker').val()=='Inicio' || $('#datepicker').val()==''){
	  		alert('Falta la decha inicial');
	  		return;
	  	}
	  	if($('#datepicker2').val()=='Fin' || $('#datepicker2').val()==''){
	  		alert('Falta la decha final');
	  		return;
	  	}
  		$('#fechaInicioStr').val($('#datepicker').val());
  		$('#fechaFinStr').val($('#datepicker2').val());
  		verDetalle('buscar-movimientos-resultado.htm');
  	}
  	function verDetalle(accion){
  		$('#consulta').attr('action',accion);
  		$('body').append('<div id="loading"></div>');
  		$('#loading').fadeIn(1, function(){
          $('#consulta').submit();
        });
  		return;
  	}
    $('document').ready(function(){

      var picker = new Pikaday({
        field: document.getElementById('datepicker'),
        maxDate: moment().startOf('day').toDate(),
        defaultDate: new Date(Date.now()),
        format: 'D - MMMM - YYYY',
        onSelect: function(){ $('#datepicker').css({'color':'#3d3935', 'text-transform': 'uppercase'}); }
      });

      var picker = new Pikaday({
        field: document.getElementById('datepicker2'),
        //maxDate: moment().startOf('day').toDate(),
        defaultDate: new Date(Date.now()),
        format: 'D - MMMM - YYYY',
        onSelect: function(){ $('#datepicker2').css({'color':'#3d3935', 'text-transform': 'uppercase'}); }
      });

      $(document).on('touchstart', function(e) {
        var $clicked = $(e.target);
        if( ! $clicked.parents().hasClass("pika-single") && !$clicked.hasClass("pika-single") ){
          $('.pika-single').addClass('is-hidden');
        }
      });

    });
  </script>

</body>
</html>