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

            <h3 class="titulo">Inversiones Diarias </h3>
            <p>Horario de Servicio: <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. Sábado y Domingo las 24 horas del día</span></p>

            <a href="#" class="cerrar"></a>
            <div class="mb30"><div class="pasos">
              <span class="paso col4 activo"><span>1 <small class="hide-xs">Datos de Inversión</small></span></span>
              <span class="paso col4"><span>2 <small class="hide-xs">Confirmar</small></span></span>
              <span class="paso col4"><span>3 <small class="hide-xs">Comprobante</small></span></span>
            </div></div>

            <div class="btop2 pt20">

              <div class="row mb20">
                <div class="col3 xs-break"><h3 class="f-verdeO m0">Datos de la Inversión</h3></div>
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
            </div>

          </div>

          <div class="bgf1 p20">

            <div class="row">

              <div class="col6 xs-break">
                <div class="mb15">
                  <p class="h6 m0"><strong>Cuenta Origen</strong></p>
                  <p class="h6">Jessica Andrea Lissette Arévalo Betancur (**** 3200) - $120,000.00 - MXP </p>
                </div>
              </div>

              <div class="col6 xs-break">
                <p class="h6 m0"><strong>Cuenta Destino</strong></p>
                <p class="h6">José Manuel Concepción Escobar Turrubiates (**** 2835) - Banco Santander</p>
              </div>

            </div>

          </div>

          <div class="p20">

            <div class="pb20">

              <div class="clearfix">
                <input type="checkbox" id="check2" name="datos" class="cbox" />
                <label for="check2">Programar Inversión</label>
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

            <div class="btop2 pt20">

              <div class="acciones" align="right">
                <a href="#" class="btn verde">Continuar</a>
              </div>

            </div>

          </div>
        </div>

      </div>

      

     
    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>