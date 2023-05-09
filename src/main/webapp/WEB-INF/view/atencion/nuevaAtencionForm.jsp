<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<!-- INCRUSTA HEAD -->
			<jsp:include page="./../partials/head.jsp" />
		<title>Nueva Atención</title>
	</head>
<body>
	<header>
		<!-- Incrusta header -->
		<jsp:include page="../partials/navbar.jsp" />
	</header>

	<main class="container">
		<h2 class="text-center my-5">Agregar Atención</h2>
		<hr>

		<form action="" method="POST" class="need-validation" novalidate>
		
		<div class="row">
			<div class="form-floating mb-1 col-6 col-sm-4 border">
				<input type="text" readonly class="form-control-plaintext" id="nombreCliente" value="Juan" />
				<label for="nombreCliente" >Nombre:</label>
			</div>
			
			<div class="form-floating mb-1 col-6 col-sm-4 border">
				<input type="text" readonly class="form-control-plaintext" id="apellidoCliente" value="Pérez" />
				<label for="apellidoCliente" >Apellido:</label>
			</div>
			
			<div class="form-floating mb-1 col-12 col-sm-4 border">
				<input type="text" readonly class="form-control-plaintext" id="telefonoCliente" value="+56912345678" />
				<label for="telefonoCliente" >Teléfono:</label>
			</div>
		</div>
		
		<div class="row">

			<div class="form-floating mb-1 col-6 col-sm-6 col-md-6 col-lg-4 col-xl-3 border">
				<input type="text" readonly class="form-control-plaintext" id="nombrePaciente"  value="Rocky" />
				<label 	for="nombrePaciente">Nombre del Paciente</label>
			</div>
		
			<div class="form-floating mb-1 col-6 col-sm-6 col-md-6 col-lg-4 col-xl-2 border">
				<input type="text" readonly class="form-control-plaintext" id="fechaNacimiento" value="14.Dic.2022" />
				<label 	for="fechaNacimiento">Fecha Nacimiento</label>
			</div>
			
			<div class="form-floating mb-1 col-4 col-sm-4 col-md-3 col-lg-4 col-xl-2 border">
				<input type="text" readonly class="form-control-plaintext" id="genero" value="Macho" />
				<label 	for="genero">Género:</label>
			</div>
			
			<div class="form-floating mb-1 col-5 col-sm-4 col-md-5 col-lg-6 col-xl-3 border">
				<input type="text" readonly class="form-control-plaintext" id="color" value="Negro/Amarillo" />
				<label 	for="color">Color:</label>
			</div>
			
			<div class="form-floating mb-1 col-3 col-sm-4 col-md-4 col-lg-6 col-xl-2 border">
				<input type="text" readonly class="form-control-plaintext" id="peso" value="20,4" />
				<label 	for="peso">Peso (Kgs.):</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<!-- SELECTOR DE SERVICIOS -->
				<select class="form-select my-3" size=5 aria-label=".form-select example" id="servicios" style="height:200px;" >
		
					<option value="1">SERVICIO A</option>
					<option value="2">SERVICIO B</option>
					<option value="3">SERVICIO C</option>		
				</select>
				<input type="button" class="btn btn-primary btn-sm mb-3" value="Agregar" id="agregarServicio"  />
			</div>
			
			<div class="col-sm-6">
				<select class="form-select my-3" size=5 aria-label="multiple select example" id="opciones" style="height:200px;"></select>
				<input type="button" class="btn btn-danger btn-sm mb-3" value="Quitar" id="quitarServicio"/>	
			</div>
		</div>

			<div class="my-5">
				<input type="submit" value="Guardar" class="btn btn-success btn-sm w-25" />
			</div>

		</form>
	</main>


	<!-- BOOTSTRAP JS CDN v5.2.3 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
		
	<!-- CUSTOM JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/atencionFunciones.js"></script>
</body>

	<div>
		<!-- Incrusta footer -->
		<jsp:include page="./../partials/footer.jsp" />
	</div>
</html>