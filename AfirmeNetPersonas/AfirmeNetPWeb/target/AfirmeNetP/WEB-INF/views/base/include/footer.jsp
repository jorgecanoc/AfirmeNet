		<footer>
			<div class="container">
				<img src="<c:url value="/resources/img/photos/globo.png"/>" id="globo">
				<div class="row mb40 flex">
					<div class="col6">
						<img src="<c:url value="/resources/img/icons/logotipo-20.png"/>" alt="20 años">
					</div>
					<div class="col5 pt15" align="right">
						<div class="dib">
							<h6>
								<spring:message code="afirmenet.asistenciaTelefonica" />
								<br><a href="tel:018002234763"><spring:message code="afirmenet.01800" /></a>
							</h6>
						</div>
						<a href="#" class="btn btn-lg lima"><spring:message code="afirmenet.AYUDA" /></a>
					</div>
				</div>
				<div class="row">
					<div class="col6">
						<strong><spring:message code="afirmenet.copyright" /></strong><br>
						<a href="#"><spring:message code="afirmenet.avisoPrivacidad" /></a> | <a href="#"><spring:message code="afirmenet.terminosLegales" /></a>
					</div>
					<div class="col5" align="right">
						<p class="h6"><spring:message code="afirmenet.sellosDeSeguridad" /></p>
						<img class="ml20" src="<c:url value="/resources/img/icons/verisign.jpg"/>" alt="Verisign">
						<img class="ml20" src="<c:url value="/resources/img/icons/amipci.jpg"/>">
					</div>
				</div>
			</div>
		</footer>
	</body>
	<!-- JS para las funciones propias de AfirmeNet	 -->
	<script src='<c:url value="/resources/js/afirmenet/utils.js"/>' type="text/javascript"></script>		
</html>