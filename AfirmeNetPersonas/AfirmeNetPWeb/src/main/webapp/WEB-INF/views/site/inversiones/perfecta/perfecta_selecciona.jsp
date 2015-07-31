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

            <h3 class="titulo">Inversi�n Perfecta </h3>
            <p>Horario de Servicio: <span class="f-verdeO">Lunes a Viernes de 2:00am a 10:30pm. S�bado y Domingo las 24 horas del d�a</span></p>

            <a href="#" class="cerrar"></a>
            <div class="mb30"><div class="pasos">
              <span class="paso col4 activo"><span>1 <small class="hide-xs">Datos de Inversi�n</small></span></span>
              <span class="paso col4"><span>2 <small class="hide-xs">Confirmar</small></span></span>
              <span class="paso col4"><span>3 <small class="hide-xs">Comprobante</small></span></span>
            </div></div>

            <div class="row">
              <div class="col9 xs-mb20">
                <h3 class="f-verdeO m0 fL">Seleccionar Cuenta</h3>
                <div class="ml20 fL xs-col12 xs-m0"><h6 class="m0 mt7"><span class="op50">Campo Obligatorio</span><span class="f-verdeO">*</span></h6></div>
              </div>
              <div class="col3">
                <a href="#" class="icon icon-info fR tooltip"><span><span class="icon icon-close2"></span><span class="h6"><strong>INFORMACI�N DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>
              </div>
            </div>

            <div class="p20-0 mb30">
              <h6 class="mb5">Cuenta Cargo</h6>
              <select name="origen" class="drop">
                <option>Seleccionar</option>
                <option>N�mina de Danilo Black  (**** 6575) - $120,000.00 MXP</option>
                <option>Jessica Andrea Lissette Ar�valo Betancur (**** 3200) - $120,000.00 MXP</option>
              </select>
            </div>

            <h3 class="f-verdeO mb20">Datos de la Inversi�n</h3>
            <div class="clearfix">
              <h6 class="fL mb5">D�as de Plazo<span class="f-verdeO">*</span></h6>
              <label class="fL arrow-box hidden" id="dias-regalo">15 d�as de regalo</label>
            </div>            
            <div class="row mb30"><div class="col6">
              <select name="dias" class="drop-dias">
                <option>Seleccionar</option>
                <option>60 d�as</option>
                <option>90 d�as</option>
                <option>120 d�as</option>
              </select>              
            </div></div>
            <div class="clearfix">
              <h6 class="fL">Importe de Inversi�n<span class="f-verdeO">*</span></h6>
              <label class="fL arrow-box">Tasa 60 d�as: 3%</label>
            </div> 
            <div class="row mb30"><div class="col8 xs-col12">
              <div class="form-input relative importe">
                <strong>$</strong>
                <input name="importe" pattern="[0-9]*" placeholder="9,999" class="numinput" type="text">
                <a class="ayuda">?</a>
              </div>
            </div></div>
            <fieldset>
              <div class="form-label"><label for="importe">Concepto de Inversi�n<span class="f-verdeO">*</span></label></div>
              <div class="form-input">
                <input name="importe" placeholder="Concepto" type="text">
              </div>
            </fieldset>           
          </div>

          <div class="bgf1 p20">
            <div class="clearfix bbot2 pb10 mb20">
              <h3 class="f-verdeO fL">Consultar Tasas de Rendimiento</h3>
              <a class="fR" id="tasas"><span class="icon icon-t-minus hidden"></span><span class="icon icon-t-plus"></span></a>
            </div>
            <div style="display: none;">
              <h6 class="mb5">D�as de Plazo<span class="f-verdeO">*</span></h6>
              <div class="row mb30"><div class="col6">
                <select name="dias" class="drop">
                  <option>Seleccionar</option>
                  <option>60 d�as</option>
                </select>              
              </div></div>
              <table class="tasas mb10">
                <thead><tr>
                  <th width="33%">Rango Menor</th>
                  <th width="33%">Rango Mayor</th>
                  <th>Tasa</th>
                </tr></thead>
                <tbody>
                  <tr>
                    <td>$25,000.00</td>
                    <td>$49,999.00</td>
                    <td>2.044000</td>
                  </tr>
                  <tr>
                    <td>$50,000.00</td>
                    <td>$99,999.00</td>
                    <td>2.184000</td>
                  </tr>
                  <tr>
                    <td>$100,000.00</td>
                    <td>$249,999.00</td>
                    <td>2.660000</td>
                  </tr>
                  <tr>
                    <td>$250,000.00</td>
                    <td>$499,999.00</td>
                    <td>2.828000</td>
                  </tr>
                  <tr>
                    <td>$500,000.00</td>
                    <td>$999,999.00</td>
                    <td>2.968000</td>
                  </tr>
                </tbody>
              </table>    
              <p>* La tasa es compuesta, incluye los meses de regalo</p>  
            </div>    
          </div>

          <div class="p0-20 hidden"><div class="btop2 p20-0">

            <div class="acciones" align="right">
              <a href="#" class="btn verde">Continuar</a>
            </div>

          </div></div>

        </div>

      </div>


      

     
    </article>

  </div></section>


  <%@ include file="/WEB-INF/views/base/include/footer.jsp"%>