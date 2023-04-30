<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<!-- BOOTSTRAP v5.2.3 CDN -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		
		<!-- FONTAWESOME CDN v5.2.0 -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.2.0/css/all.min.css" integrity="sha512-6c4nX2tn5KbzeBJo9Ywpa0Gkt+mzCzJBrE1RB6fmpcsoN+b/w/euwIMuQKNyUoU/nToKN3a8SgNOtPrbW12fug==" crossorigin="anonymous" referrerpolicy="no-referrer" />
		<title>Usuarios</title>
	</head>
	<body class="container">
		<header>
			<!-- Incrusta header -->
			<jsp:include page="./../partials/navbar.jsp" />
		</header>
		
		<main>
			<h2 class="text-center">Lista de Usuarios</h2>
		
			<table class="table table-bordered table-striped table-hover table-sm">
				<thead>
					<tr>
						<th>Usuario</th>
						<th>Contraseña</th>
						<th>Habilitado</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${datos}" var="dato">
						<tr>
							<td><c:out value="${dato.username}" /></td>
							<td><c:out value="${dato.password}" /></td>
							<td class="text-center">
								  <c:if test="${dato.enabled == 1}">
    								<i class="fas fa-check-circle text-success"></i>
  								</c:if>
								<c:if test="${dato.enabled != 1}">
								    <i class="fas fa-times-circle text-danger"></i>
								</c:if>
							</td>
							<td>
								<a href="<c:url value='/usuarios/editarUsuario'><c:param name='usuario' value='${dato.username}' /></c:url>" class="text-primary"><i class="fas fa-pencil-alt"></i></a>
								<a href="<c:url value='/usuarios/eliminarUsuario'><c:param name='usuario' value='${dato.username}' /></c:url>" class="text-danger"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		
			</table>
		</main>
		
		<footer>
		</footer>
		
		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>