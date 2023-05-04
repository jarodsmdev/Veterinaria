<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
			<!-- INCRUSTA HEAD -->
			<jsp:include page="./../partials/head.jsp" />
		
		<title>Lista Clientes</title>
	</head>
	<body>
		<header>
			<!-- Incrusta header -->
			<jsp:include page="./../partials/navbar.jsp" />
		</header>
		
		<main  class="container">
			<h2 class="text-center my-5">Lista de Clientes</h2>
			
			<hr>
			
			<c:if test="${not empty success}">
  				<div class="alert alert-success alert-dismissible fade show" role="alert">
  					<strong><i class="fas fa-check-circle"></i></strong> ${success}.
 					<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
			
			<a href="${pageContext.request.contextPath}/cliente/nuevoCliente" class="btn btn-primary btn-sm my-2"><i class="fas fa-plus-circle"></i> Crear Cliente</a>
			
			<hr>
		
			<div class="table-responsive">
				<table class="table table-bordered table-striped table-hover table-sm mb-5">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Teléfono</th>
							<th>email</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td><c:out value="${cliente.nombre}" /></td>
								<td><c:out value="${cliente.apellido}" /></td>
								<td><c:out value="${cliente.telefono}" /></td>
								<td><c:out value="${cliente.email}" /></td>
								<td class="d-flex justify-content-evenly">
									<a href="<c:url value='/cliente/editarCliente'><c:param name='cliente' value='${cliente.idCliente}' /></c:url>" class="btn btn-outline-primary btn-sm mx-1"><i class="fas fa-user-edit"></i></a>
									<a href="<c:url value='/cliente/eliminarCliente'><c:param name='cliente' value='${cliente.idCliente}' /></c:url>" class="btn btn-outline-danger btn-sm mx-1"><i class="fas fa-user-minus"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
			
				</table>
			</div>
		</main>
		
		<footer>
		</footer>
		
		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>