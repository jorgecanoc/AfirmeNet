<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>
<link href="<c:url value="/resources/css/edocuenta.css"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/main.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/vendor/dropkick.js"/>'></script>
<script type="text/javascript">
	$('document').ready(function() {
		$('.cbox').click(function() {
			if ($('.cbox').is(':checked'))
				$('button.verde').removeAttr('disabled');
			else
				$('button.verde').attr('disabled', 'disabled');
		});
	});
</script>
<section>
	<div class="container">

		<article>
			<div class="col-izq" id="menu-wrap">
				<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>
			</div>
			<div class="col-der relative">
				<div class="contenido">
					<div class="p20">
						<h3 class="titulo">
							<spring:message code="afirmenet.edocta" />
						</h3>
						<div class="contrato">
							<h6>&nbsp;</h6>
							<h6>CONSULTA DE ESTADO DE CUENTA A TRAVÉS DE MEDIOS ELECTRÓNICOS</h6>
							<h6>TÉRMINOS Y CONDICIONES</h6>
							<h6>&nbsp;</h6>
							<h6>
								Por medio del presente, el "Cliente" instruye a "Afirme"
								para que a partir de la siguiente fecha de corte, deje de
								enviarle sus estados de cuenta en papel a través de correo
								tradicional y a cambio, le permita consultar dichos estados de
								cuenta a través de "AfirmeNet", o bien, se los haga llegar a su
								correo electrónico, sin que en ningún caso se dejen de generar
								estados de cuenta.
							</h6>
							<h6>
								Para tal efecto, el "Cliente" deberá seleccionar del
								menú respectivo la opción deseada, en la inteligencia que en
								caso de optar por el envío de sus estados de cuenta a través de
								correo electrónico, el "Cliente" deberá proporcionar también una
								dirección de correo electrónico válida, siendo responsable de
								informar a "Afirme" de cualquier posible actualización de la
								misma.
							</h6>
							<h6>
								"Afirme" no será responsable, en caso de que los estados
								de cuenta no sean recibidos por el "Cliente" por causas ajenas a
								"Afirme", como fallas en conexiones a internet y equipos de
								cómputo del "Cliente", por lo que libera a "Afirme" de cualquier
								responsabilidad que se genere por los envíos a través de dicho
								medio.
							</h6>
							<h6>
								Asimismo, "Afirme" quedará autorizado para que a su sola
								discreción, principalmente por situaciones de seguridad y
								protección de información del "Cliente", pueda suspender en
								cualquier momento el envío de estados de cuenta a través de
								medios electrónicos, debiendo en este caso enviarlos nuevamente
								al domicilio del "Cliente".
							</h6>
							<h6>
								Sin perjuicio de lo anterior, el "Cliente" podrá obtener
								una copia de sus estados de cuenta en cualquier Sucursal de
								"Afirme", en el entendido que únicamente la primera copia será
								gratuita, en términos del contrato correspondiente.
							</h6>
							<h6>&nbsp;</h6>
							<h6>
								Banca Afirme S.A., Institución de Banca Múltiple, Afirme Grupo Financiero
							</h6>
							<h6>&nbsp;</h6>
							<h6>&nbsp;</h6>
						</div>
						<div class="p20 clearfix xs-p20-0">
							<div class="col10 off1 xs-col12" align="center">
								<input type="checkbox" id="radio1" name="datos"class="cbox f-negro" />
								<label for="radio1"><spring:message code="afirmenet.edocta.deacuerdo" /></label>
							</div>
						</div>
						<div align="center">
							<button disabled onclick="window.location.href='ESTADODECUENTAELECTRONICO_emision-estado-de-cuenta-electronico.html'" class="btn verde">
								<spring:message code="afirmenet.edocta.activar" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</article>

	</div>
</section>

<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>