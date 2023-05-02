<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<!-- INCRUSTA HEAD -->
		<jsp:include page="./partials/head.jsp" />
			
		<title>Acceso Restringido</title>
	</head>
	<body>
		<h1 style="text-align: center">Acceso Restringido</h1>
		<hr>
		
		<p style="font-weight: bold;">No tienes el perfil requerido para ver este contenido.</p>
		
		<p>Usuario: <security:authentication property="principal.username" /></p>
		<p>Rol:<security:authentication property="principal.authorities" /></p>
	
		<ul>
			<li><a href="${pageContext.request.contextPath}/">Volver a Inicio</a></li>
		</ul>
	</body>
</html>