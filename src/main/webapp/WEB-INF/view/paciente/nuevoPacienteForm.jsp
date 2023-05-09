<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<!-- INCRUSTA HEAD -->
			<jsp:include page="./../partials/head.jsp" />
		
		<title>Nuevo Paciente</title>
	</head>
	<body>
		<header>
			<!-- Incrusta header -->
			<jsp:include page="../partials/navbar.jsp" />
		</header>
	
	<main class="container">
		<h2 class="text-center my-5">Agregar Paciente</h2>
		<hr>
			
		<form action="" method="POST" class="need-validation" novalidate>
			<div class="form-floating mb-3">
				<select class="form-select" id="especie" aria-label="Floating label select example">
					<option selected disabled>Seleccione Especie</option>
					<option value="1">Gato</option>
					<option value="2">Perro</option>
					<option value="3">Elefante</option>
					<option value="4">T-Rex</option>
				</select>
				<label for="especie">Seleccione Especie</label>
				<div class="invalid-feedback">
					Debe seleccionar género.
				</div>
			</div>
		
			<div class="form-floating mb-3" >
				<select class="form-select" id="genero" aria-label="Floating label select example">
					<option selected disabled>Seleccione Género</option>
					<option value="1">Macho</option>
					<option value="2">Hembra</option>
				</select>
				<label for="genero">Seleccione Género</label>
				<div class="invalid-feedback">
					Debe seleccionar género.
				</div>
			</div>
			
			<div class="form-floating mb-3" >
				<input type="text" class="form-control form-control-sm" id="nombrePaciente" name="nombrePaciente" placeholder="Ingrese nombre paciente" />
				<label for="nombrePaciente" class="">Ingrese nombre:</label>
				<div class="invalid-feedback">
					Debe ingresar nombre paciente.
				</div>
			</div>
			
			
		
			<div class="form-floating mb-3" >
				<input type="text" class="form-control form-control-sm" id="color" name="color" placeholder="Ingrese color paciente" />
				<label for="color" class="">Ingrese color:</label>
				<div class="invalid-feedback">
					Debe ingresar color paciente.
				</div>
			</div>

			<div class="input-group mb-3">
				<div class="form-floating">
					<input type="text" class="form-control form-control-sm" id="peso" name="peso" placeholder="Ingrese peso paciente" />
					<label for="peso" class="">Peso en Kg:</label>
				</div>
				<span class="input-group-text">Kgs.</span>
				<div class="invalid-feedback">
					Debe ingresar peso en kgs.
				</div>
			</div>
			
			<div class="form-floating mb-3">
				<input type="date" class="form-control form-control-sm" id="fechaNacimiento" name="fechaNacimiento" />
				<label for="fechaNacimiento">Fecha Nacimiento:</label>
			</div>
			
			<div class="form-floating mb-3">
				<textarea class="form-control form-control-sm" placeholder="Observaciones" id="observaciones" style="resize: none; height: 100px;"></textarea>
				<label for="observaciones">Observaciones:</label>
			</div>
			
			<div class="mb-3">
				<input type="submit" value="Guardar" class="btn btn-success btn-sm w-25" />			
			</div>
			
		</form>
	</main>
	

		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
	
	<div>
		<!-- Incrusta footer -->
		<jsp:include page="./../partials/footer.jsp" />
	</div>
</html>