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

        <div class="contenido">

          <div class="p20">

            <h3 class="titulo">Mis Tarjetas AFIRME</h3>
            <p>Horario de Servicio: <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

            <a href="#" class="cerrar"></a>
            <div class="mb30"><div class="pasos">
              <span class="paso activo"><span>1 <small class="hide-xs">Seguro</small></span></span>
              <span class="paso activo"><span>2 <small class="hide-xs">Ingresar Datos</small></span></span>
              <span class="paso"><span>3 <small class="hide-xs">Confirmar</small></span></span>
              <span class="paso"><span>4 <small class="hide-xs">Comprobante</small></span></span>
            </div></div>

            <div class="row mb20">
              <div class="col3 xs-break"><h3 class="f-verdeO m0">Ingresar Datos</h3></div>
              <div class="col4 xs-break xs-mb20"><h6 class="m0 mt7"><span class="op50">Campo Obligatorio</span><span class="f-verdeO">*</span></h6></div>
            </div>


            <fieldset>
              <div class="form-label"><label for="importe">Importe<span class="f-verdeO">*</span></label></div>
              <div class="form-input relative importe">
                <strong>$</strong>
                <input name="importe" pattern="[0-9]*" placeholder="9,999" class="numinput" type="text">
                <a class="ayuda">?</a>
              </div>
            </fieldset>

            <fieldset>
              <div class="form-label"><label for="importe">Email Beneficiario</label></div>
              <div class="form-input relative">
                <input name="desc" placeholder="Concepto del Pago" type="email" class="f-verdeO">
                <a class="ayuda">?</a>
              </div>
            </fieldset>

          </div>

          <div class="bgf1 p20">

            <p class="h6 m0"><strong>Tipo de Operación</strong></p>
            <p class="h6">Pago de Seguro AFIRME </p>

            <div class="row">

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong>Cuenta Origen</strong></p>
                  <p class="h6">Jessica Andrea Lissette Arévalo Betancur (**** 3200) - $10,000.00 - MXP </p>
                </div>
              </div>

              <div class="col6 xs-break">
                <p class="h6 m0"><strong>Seguro</strong></p>
                <p>Seguro Anti Fraude "Básico" (0100044342400)</p>
              </div>
              
            </div>

          </div>

          <div class="p20 bbot2">

            <div class="clearfix">
              <input type="checkbox" id="check2" name="datos" class="cbox" />
              <label for="check2">Programar Pago</label>
            </div>
            <div class="row pt20" style="display: none;">
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <div class="form-label"><label for="importe">Fecha</label></div>
                  <div class="form-input w70"><input value="01/MARZO/2015" type="button" id="datepicker" class="input"></div>
                </fieldset>                  
              </div>
              <div class="col6 xs-break xs-mb20">
                <fieldset>
                  <div class="form-label"><label for="importe">Hora</label></div>
                  <div class="form-input w70 no-bg"><select name="hora" class="drop">
                    <option>9:00 hrs</option>
                    <option>10:00 hrs</option>
                    <option>11:00 hrs</option>
                    <option>12:00 hrs</option>
                    <option>13:00 hrs</option>
                    <option>14:00 hrs</option>
                    <option>15:00 hrs</option>
                    <option>16:00 hrs</option>
                    <option>17:00 hrs</option>
                  </select></div>
                </fieldset>                  
              </div>
            </div>

          </div>

          <div class="p20">

            <div class="acciones" align="right">
              <a href="PAGOS_Propias.html" data-fancybox-type="iframe" class="modal btn atras mr10">Atrás</a>
              <a href="PAGOS_Propias-paso-3.html" class="btn verde">Continuar</a>
            </div>

          </div>

        </div></div>
       
     
    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>