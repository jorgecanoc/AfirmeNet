	<%@ include file="/WEB-INF/views/base/include/include.jsp"%>	
	<%@ include file="/WEB-INF/views/base/include/header.jsp"%>
	<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
	
	<form:form method="POST" commandName="login" action="${context}/login/contrato.htm">	
		  <div class="aviso"><div class="container">
		
		    <h3 align="center"><span class="op50"><spring:message code="afirmenet.loginmsg.titulo" /></span> <br><br> <strong>${errEstatus}</strong></h3>
		    <br>
		    <div class="contrato">
		      <h6 align="center">${errMsg}</h6>
            </div>
		
		    <div align="center">
		      <a href="<c:url value="/login.htm"/>" class="btn verde mb20"><spring:message code="afirmenet.continuar" /></a>
		    </div>      
		
		  </div></div>
	</form:form>
	<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>
