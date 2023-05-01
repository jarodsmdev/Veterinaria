<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<!-- BOOTSTRAP v5.2.3 CDN -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		
		<!-- FONTAWESOME CDN v5.2.0 -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.2.0/css/all.min.css" integrity="sha512-6c4nX2tn5KbzeBJo9Ywpa0Gkt+mzCzJBrE1RB6fmpcsoN+b/w/euwIMuQKNyUoU/nToKN3a8SgNOtPrbW12fug==" crossorigin="anonymous" referrerpolicy="no-referrer" />
		
		<title>Nuevo Cliente</title>
	</head>
	<body class="container">
		<header>
			<!-- Incrusta header -->
			<jsp:include page="../partials/navbar.jsp" />
		</header>
	
	<main>
		<h2 class="text-center">Creación de Cliente</h2>
		<hr>
			
		<form action="" method="POST" class="need-validation" novalidate>
			<div class="form-floating mb-3" >
				<input type="text" class="form-control form-control-sm" id="rut" name="rut" placeholder="Ingrese RUT Cliente" required/>
				<label for="rut" class="">RUT Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar RUT de Cliente.
				</div>
			</div>

			<div class="form-floating mb-3" >
				<input type="text" class="form-control form-control-sm" id="nombre" name="nombre" placeholder="Ingrese Nombre Cliente" />
				<label for="nombre" class="">Nombre Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Nombre de Cliente.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<input type="text" class="form-control form-control-sm" id="apellido" name="apellido" placeholder="Ingrese Apellido Cliente" />
				<label for="apellido" class="">Apellido Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Apellido de Cliente.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<input type="email" class="form-control form-control-sm" id="email" name="email" placeholder="Ingrese Email Cliente" />
				<label for="email" class="" >Email Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Email de Cliente.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<input type="text" class="form-control form-control-sm" id="telefono" name="telefono" placeholder="Ingrese Teléfono Cliente" />
				<label for="telefono" class="" >Teléfono Cliente:</label>
				<div class="invalid-feedback">
					Debe ingresar Teléfono de Cliente.
				</div>
			</div>
			
			<div class="list-group mb-3">
				<a href="#" class="list-group-item list-group-item-action">+56912345678</li>
				<a href="#" class="list-group-item list-group-item-action">+56912345678</li>
				<a href="#" class="list-group-item list-group-item-action">+56912345678</li>
			</div>
			
			
			<div class="mb-3">
				<button type="submit" class="btn btn-success btn-sm w-25">Guardar <i class="fas fa-save"></i></button>		
			</div>
			
		</form>
	</main>
	

		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
	<footer>
	</footer>
</html>