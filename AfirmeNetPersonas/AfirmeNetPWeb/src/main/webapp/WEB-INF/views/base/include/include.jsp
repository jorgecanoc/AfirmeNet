
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
	<title><spring:message code="afirmenet.titulo"/></title>
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Language" content="es-MX" />
	<meta name="title" content="AfirmeNet" /> 
	<meta name="author" content="Afirme" />
	<meta name="copyright" content="Afirme" />
	<meta name="Language" content="Spanish" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="robots" content="all | index | follow" />
	<meta name="description" content="AfirmeNet" />
	<meta name="keywords" content="afirme,afirmenet,banco,banca,electronica,ebank,bank" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

  	<link rel="icon" href='<c:url value="/resources/favicon.ico"/>' type="image/vnd.microsoft.icon"/> 
  	<link rel="shortcut icon" href='<c:url value="/resources/favicon.ico"/>' type="image/vnd.microsoft.icon"/> 
  	<link rel="apple-touch-icon" href="apple-touch-icon.png" />
  	<link rel="apple-touch-icon" sizes="72x72" href="apple-touch-icon-72x72-precomposed.png" />
  	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114-precomposed.png" />
  	<link rel="apple-touch-icon" sizes="144x144" href="apple-touch-icon-144x144-precomposed.png" />
  	
    <!-- CSS PRINCIPAL	 -->
	<link href='<c:url value="/resources/css/main.css?frameX"/>' rel="stylesheet" type="text/css">
	<!-- CSS CARGA LOS ESTILOS DEL MODAL	 -->
	<link href='<c:url value="/resources/css/fancybox.css"/>' rel="stylesheet" type="text/css" />
	<!-- CSS Contiene los estilos requeridos del plugin Dropkick, utilizado para darle la apariencia a los selectores dropdown	 -->
	<link href="<c:url value="/resources/css/dropkick.css"/>" rel="stylesheet" type="text/css" />
	
	<!-- JS Librería de Javascript que controla interacciones, manipulación de elementos del DOM	 -->
    <script>window.jQuery || document.write('<script src=\'<c:url value="/resources/js/jquery-1.11.0.min.js"/>\'><\/script>')</script>
    <!-- JS Librería de Javascript que detecta características de HTML5 y CSS3, usado generalmente para la compatibilidad en browsers	 -->
  	<script src='<c:url value="/resources/js/vendor/modernizr-2.6.2.min.js"/>' type="text/javascript"></script>
  	<!-- JS Contiene las funciones Javascript utilizadas a través de todo el sitio	 -->  	
  	<script src='<c:url value="/resources/js/main.js"/>' type="text/javascript"></script>
  	<!-- JS Plugin de Javascript utilizado para cajas modales.	 -->
	<script src='<c:url value="/resources/js/vendor/jquery.fancybox.pack.js"/>' type="text/javascript"></script>
	<!-- JS Plugin de Javascript que ayuda en el despliegue de los bloques de Resumen de Cuentas	 --> 
	<script src='<c:url value="/resources/js/vendor/packery.js"/>' type="text/javascript"></script>
	<!-- Plugin de Javascript que da funcionalidad a los selectores dropdown estilizados	 -->
	<script src='<c:url value="/resources/js/vendor/dropkick.js"/>' type="text/javascript"></script>



</head>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<script>
	var context = "${context}";
</script>