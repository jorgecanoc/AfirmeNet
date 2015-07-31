<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:if test="${not empty errores}">
<div class="notificacion error">
	<a class="icon icon-close2"></a>
	<div class="clearfix">
		<span class="icon icon-error"></span>
		<span class="f21 m0"><strong>ERROR</strong></span>
		<br>
		<ul>
			<c:forEach var="erroresTotal" items="${errores}">
				<c:forEach var="error" items="${erroresTotal.value}">
					<li>${erroresTotal.key} - ${error} </li>
				</c:forEach>
		 	</c:forEach>
	 	</ul>
	</div>
</div>
</c:if>


