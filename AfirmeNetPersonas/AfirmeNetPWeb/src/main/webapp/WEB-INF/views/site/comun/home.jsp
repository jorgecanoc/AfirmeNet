<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/home.css"/>' rel="stylesheet" type="text/css">
<body class="comercial">
<%@ include file="/WEB-INF/views/base/include/headerSession.jsp"%>

	
<div id="stage">
	<span class="stage-overlay"></span> 
	<img src= '<c:url value="${sessionScope.backgroudImg}"/>' height="649" width="1280" alt="">

	<div class="txt-stage">
		<div class="container">
			<c:if test="${not empty sessionScope.afirmeNetUser.campania}">
				<div class="col6 off6">
					<div class="mb20">
						<h1>
							${sessionScope.afirmeNetUser.campania.saludo}<br>
							<strong>${sessionScope.afirmeNetUser.nombreCorto}</strong>
						</h1>
						${sessionScope.afirmeNetUser.campania.message}
					</div>
					<div class="clearfix">
						<c:if test="${not empty sessionScope.afirmeNetUser.campania.accion and not empty sessionScope.afirmeNetUser.campania.textoAlConfirmar}">
							<a href="#" class="btn verde fL mr10">${sessionScope.afirmeNetUser.campania.textoAlConfirmar}</a> 
						</c:if>
						<c:if test="${not empty sessionScope.afirmeNetUser.campania.url}">
							<a href="${sessionScope.afirmeNetUser.campania.url}" data-fancybox-type="iframe" class="btn gris fL video modal"><span class="icon icon-play"></span> Ver video</a>
						</c:if>
						<c:if test="${not empty sessionScope.afirmeNetUser.campania.terminos}">
							<a href="${context}/login/terminos.htm"
								data-fancybox-type="iframe" class="modal fR"><spring:message code="afirmenet.home.terminos.boton"/></a>
						</c:if>					
					</div>
				</div>			
			</c:if>
		</div>
	</div>
	
<%@ include file="/WEB-INF/views/site/comun/resumenCuentas.jsp"%>
</div>
<div id="popup"></div>
<div class="menu">
	<div class="container">
<%@ include file="/WEB-INF/views/site/comun/menu.jsp"%>

	</div>
</div>
<%@ include file="/WEB-INF/views/base/include/footerSession.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {

		if ($('#stage img').length > 0) {
			var stage = $('#stage img').attr('src');
			$('#stage').css('background-image', 'url(' + stage + ')');
			$('#stage img').hide();
		}

		$('.modal').fancybox({
			maxHeight : 600,
			fitToView : false,
			width : '90%',
			height : '80%',
			padding : 0
		});

		$('.refresh .icon').click(function() {
			var _this = $(this).parent();
			_this.find('.icon').hide(0, function() {
				_this.find('.loader').addClass('show');
				setTimeout(function() {
					_this.find('.loader').removeClass('show');
					_this.find('.icon').show();
					_this.parent().find('h3').html('$90,000.00');
				}, 4000)
			})
		});

	});
	

</script>

</body>
</html>


