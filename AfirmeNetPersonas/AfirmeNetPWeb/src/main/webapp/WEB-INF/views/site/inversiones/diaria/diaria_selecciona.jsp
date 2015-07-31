<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href="<c:url value="/resources/css/transaccion.css"/>" rel="stylesheet" type="text/css" />

    <script type="text/javascript">    
  
      $('document').ready(function(){
      
     
      
    });
    
    
    
  </script>
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

 <section><div class="container">

    <article>

      <div class="col-izq" id="menu-wrap">
 		<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%> 
      </div>


      <div class="col-der relative">

        <div class="contenido"><div class="p20">

          <h3 class="titulo">Inversiones Diarias </h3>
          <p>Horario de Servicio: <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

          <a href="#" class="cerrar"></a>
          <div class="mb30"><div class="pasos">
            <span class="paso col4 activo"><span>1 <small class="hide-xs">Datos de Inversión</small></span></span>
            <span class="paso col4"><span>2 <small class="hide-xs">Confirmar</small></span></span>
            <span class="paso col4"><span>3 <small class="hide-xs">Comprobante</small></span></span>
          </div></div>

          <div class="row mb20">
            <div class="col9 xs-mb20">
              <h3 class="f-verdeO m0 fL">Seleccionar Cuentas</h3>
              <div class="ml20 fL xs-col12 xs-m0"><h6 class="m0 mt7 hidden"><span class="op50">Campo Obligatorio</span><span class="f-verdeO">*</span></h6></div>
            </div>
            <div class="col3">
              <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
            </div>
          </div>

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
              <h6 class="mb5">Cuenta Destino</h6>
              <select name="destino" class="dropfinal">
                <option>Seleccionar Cuenta</option>
                <option>Inversión AFIRME  (**** 1234) </option>
                <option value="nueva">Agregar Nueva Cuenta</option>
              </select>
            </div>
          </div>

          <div class="hidden">

            <div class="btop2 pt20">

              <div class="acciones" align="right">
                <a href="INVERSIONES_Diarias-paso-2.html" class="btn verde">Continuar</a>
              </div>

            </div>
            
          </div>

        </div></div>

      </div>

     
    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>