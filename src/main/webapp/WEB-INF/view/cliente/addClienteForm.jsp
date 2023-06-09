<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
			<!-- INCRUSTA HEAD -->
			<jsp:include page="./../partials/head.jsp" />
		
		<title>Nuevo Cliente</title>
	</head>
	<body>
		<header>
			<!-- Incrusta header -->
			<jsp:include page="../partials/navbar.jsp" />
		</header>
	
	<main class="container">
		<h2 class="text-center my-5">Creación de Cliente</h2>
		<hr>
		
		<a href="${pageContext.request.contextPath}/cliente/listarClientes" class="btn btn-primary btn-sm my-2"><i class="fas fa-users"></i> Listar Clientes </a>
		<hr>
		
		<form:form action="crearCliente" modelAttribute="cliente" method="POST" class="need-validation" novalidate="true">
			<div class="form-floating mb-3" >
				<form:input path="rut" type="text" class="form-control form-control-sm" id="rut" name="rut" placeholder="Ingrese RUT Cliente" required="true" />
				<label for="rut" class="">RUT Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar RUT de Cliente.
				</div>
			</div>

			<div class="form-floating mb-3" >
				<form:input path="nombre" type="text" class="form-control form-control-sm" id="nombre" name="nombre" placeholder="Ingrese Nombre Cliente" />
				<label for="nombre" class="">Nombre Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Nombre de Cliente.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<form:input path="apellido" type="text" class="form-control form-control-sm" id="apellido" name="apellido" placeholder="Ingrese Apellido Cliente" />
				<label for="apellido" class="">Apellido Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Apellido de Cliente.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<form:input path="email" type="email" class="form-control form-control-sm" id="email" name="email" placeholder="Ingrese Email Cliente" />
				<label for="email" class="" >Email Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Email de Cliente.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<form:input path="telefono" type="text" class="form-control form-control-sm" id="telefono" name="telefono" placeholder="Ingrese Teléfono Cliente" />
				<label for="telefono" class="" >Teléfono Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Teléfono de Cliente.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<form:input path="direccion" type="text" class="form-control form-control-sm" id="direccion" name="direccion" placeholder="Ingrese Dirección Cliente" />
				<label for="telefono" class="" >Dirección:</label>
				<div class="invalid-feedback">
					Debe ingresar dirección de Cliente.
				</div>
			</div>
				
			<div class="mb-3">
				<button type="submit" class="btn btn-success btn-sm w-25">Guardar <i class="fas fa-save"></i></button>		
			</div>
			
		</form:form>
	</main>
	
		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
	<div>
		<!-- Incrusta footer -->
		<jsp:include page="./../partials/footer.jsp" />
	</div>
</html>