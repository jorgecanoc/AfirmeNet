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
  <link rel="icon" href="favicon.ico" type="image/vnd.microsoft.icon" /> 
  <link rel="shortcut icon" href="favicon.ico" type="image/vnd.microsoft.icon" /> 
  <link rel="apple-touch-icon" href="apple-touch-icon.png" />
  <link rel="apple-touch-icon" sizes="72x72" href="apple-touch-icon-72x72-precomposed.png" />
  <link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114-precomposed.png" />
  <link rel="apple-touch-icon" sizes="144x144" href="apple-touch-icon-144x144-precomposed.png" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="Content-Language" content="es-MX" />
  <meta name="title" content="" /> 
  <meta name="author" content="" />
  <meta name="copyright" content="" />
  <meta name="Language" content="Spanish" />
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="robots" content="all | index | follow" />
  <meta name="description" content="" />
  <meta name="keywords" content="" />
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <title>AfirmeNET | Cancelar transacción </title>
  <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/resources/css/modal.css"/>" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="<c:url value="/resources/js/vendor/modernizr-2.6.2.min.js"/>"></script>
  <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.min.js"/>'></script>
  
</head>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<script>
	var context = "${context}";
</script>
<body>

  <div class="titulo-modal" align="center">
    <h1 class="f21 m0 f-verde">${titulo}</h1>
  </div>
  <div class="contenido-modal" align="center">
    <div class="mb60"><p class="f21">${mensaje}</p></div>
    <p class="f21 f-verdeO">${pregunta}</p>
    <div class="acciones">    
      <a onClick="window.parent.jQuery.fancybox.close()" class="btn atras mr10"><spring:message code="afirmenet.botones.atras" /></a>
      <a href="${context}/${action}" target="_parent" class="btn verde">${boton}</a>
    </div>
  </div>

</body>
</html>