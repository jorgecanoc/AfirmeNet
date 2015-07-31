
	<%@ include file="/WEB-INF/views/base/include/include.jsp"%>	
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
	<%@ include file="/WEB-INF/views/base/include/header.jsp"%>
	  	<div class="aviso">
	  		<div class="container">
	  			<h3 align="center"><b>Custom Error</b></h3>
					<c:if test="${not empty errMsg}">
						<h4 align="center">${errMsg}</h4>
					</c:if>
					<c:choose>
						<c:when test="${not empty afirmeNetUser}">							
							<div class="p20" align="center"><a href="'${context}/home.htm'" class="h5 f-verde">Home</a></div>
						</c:when>
						<c:otherwise>
							<div class="p20" align="center"><a href="<c:url value="/login.htm"/>" class="h5 f-verde">Home</a></div>
						</c:otherwise>
					</c:choose>
	  		</div>
	  	</div>
	  	
	<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>