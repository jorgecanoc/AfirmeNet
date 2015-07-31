	
	<div class="resumen">
		<div class="container">
			<div class="row">
				<div class="col3">
					<h3>
						<spring:message code="afirmenet.resumen"/><br> <strong class="h3"><spring:message code="afirmenet.resumen.misCuentas"/></strong>
					</h3>
					<a href="#" class="btn verde" onclick="submitFormAnimate('menu','consultas/resumen-de-mis-cuentas.htm')"><spring:message code="afirmenet.resumen.VERDETALLE"/></a>
				</div>
				
				
		<c:forEach var="res" varStatus="status" items="${resumen}">
			 
			 
				<div class="col3">
					<a class="refresh"><span class="icon icon-refresh"></span><span
						class="loader"><span class="loader-inner"></span></span></a>
					<div class="bloque cuenta"
						onclick="submitFormAnimate('menu','consultas/resumen-de-mis-cuentas.htm')">
						<div class="bbot mb10">
							<h4>${res.descripcion}</h4>
							<h3>$${res.totalStr}</h3>
						</div>
						<div class="clearfix">
							<p class="fL">
								<a href="#" onclick="submitFormAnimate('menu','consultas/resumen-de-mis-cuentas.htm')">${res.cuentas} <spring:message code="afirmenet.consultas.sm.resumen.cuentas"/></a>
							</p>
						</div>
						<a href="#" onclick="submitFormAnimate('menu','consultas/resumen-de-mis-cuentas.htm')"
							class="icon icon-zoom"></a>
					</div>
				</div>
			 
		
		</c:forEach>
		
				
			</div>
		</div>
	</div>
