<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
				<!-- INCRUSTA HEAD -->
				<jsp:include page="./../partials/head.jsp" />
			<title>Agrega Teléfono</title>
	</head>
	<body>
		<header>
			<!-- Incrusta header -->
			<jsp:include page="./../partials/navbar.jsp" />
		</header>
		
		<main class="container">
			<h2 class="text-center my-5">Agregar Número Teléfonico</h2>
			
			<hr>
			
			<form action="" method="POST">
				<div class="form-floating mb-3">
					<input type="text" class="form-control form-control-sm" name="telefonoCliente" id="telefonoCliente" placeholder="Teléfono de contacto" autocomplete="off" />
					<label for="telefonoCliente">Teléfono de Contacto</label>
				</div>
				<hr>
				<div class="row justify-content-end mt-2">
					<button type="submit" class="btn btn-success btn-sm w-50 my-2" id="btnEnviar"><i class="fas fa-save"></i> Guardar</button>
				</div>
			</form>
		</main>
		
		<footer>
		</footer>
	</body>
</html>