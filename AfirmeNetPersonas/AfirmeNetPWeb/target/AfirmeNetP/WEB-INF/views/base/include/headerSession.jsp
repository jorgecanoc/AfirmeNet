
<header>
	<div class="container">
		<div class="head-izq">
			<a id="logo" href='${context}/home.htm'><img src='<c:url value="/resources/img/icons/logotipo.png"/>'  alt="Afirme"></a> 
			<a class="btn-menu"> 
				<span class="linea"></span>
				<span class="linea"></span>
				<span class="linea"></span> 
				<span class="notificaciones">${afirmeNetUser.notificaciones}</span>
			</a>
		</div>

		<div class="head-der">

			<div class="head-btns">
				<a class="avatar"> <img src='<c:url value="/resources/img/photos/avatar2.png"/>'
					height="36" width="36" alt="${sessionScope.afirmeNetUser.nombreCorto}"> <span
					class="notificaciones">${afirmeNetUser.notificaciones}</span>
				</a> <a href="#" class="btn" onclick="submitFormAnimate('menu','login/logout.htm')"><span class="txt"><spring:message code="afirmenet.header.cerrarSession"/></span><span
					class="icon icon-exit"></span></a>
							
			</div>
			<div class="head-datos">
				<p> <spring:message code="afirmenet.header.saludo"/> <strong>${sessionScope.afirmeNetUser.nombreLargo}</strong>
				</p>
				<p class="f12">
					<spring:message code="afirmenet.header.contrato"/> <strong>${sessionScope.afirmeNetUser.contrato}</strong> 
					<spring:message code="afirmenet.header.ultimoAcceso"/>  <strong>${sessionScope.afirmeNetUser.ultimoAccesoStr}</strong>
				</p>
			</div>

		</div>

	</div>

</header>