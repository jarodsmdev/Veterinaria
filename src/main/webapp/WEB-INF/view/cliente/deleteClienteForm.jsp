<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<!-- INCRUSTA HEAD -->
			<jsp:include page="./../partials/head.jsp" />
		
		<title>Eliminar Cliente</title>
	</head>
	<body>
		<header>
			<!-- Incrusta header -->
			<jsp:include page="./../partials/navbar.jsp" />
		</header>
		
		<main class="container">

			<h2 class="text-center my-5">Eliminar Cliente</h2>
			
			<form action="${pageContext.request.contextPath}/cliente/eliminarCliente" method="POST" class="need-validation" novalidate="true">
			  <input type="hidden" name="idCliente" value="${cliente.idCliente}" />
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="row">
				<div class="form-floating mb-3 col-6">
			    <input type="text" class="form-control-plaintext" id="nombre" name="nombre" value="${cliente.nombre}" placeholder="Nombre de cliente" readonly required />
			    <label for="nombre">Nombre de Cliente:</label>
			 </div>
			  
			  <div class="form-floating mb-3 col-6">
			    <input type="text" class="form-control-plaintext" id="apellido" name="apellido" value="${cliente.apellido}" placeholder="Apellido de cliente" readonly required />
			    <label for="apellido">Apellido de Cliente:</label>
			  </div>
			</div>
			  
			<div class="row">
			<div class="form-floating mb-3 col-6">
			    <input type="text" class="form-control-plaintext" id="telefono" name="telefono" value="${cliente.telefono}" placeholder="Teléfono de cliente" readonly required />
			    <label for="telefono">Teléfono de Cliente:</label>
			  </div>

			  <div class="form-floating mb-3 col-6">
			    <input type="text" class="form-control-plaintext" id="email" name="email" value="${cliente.email}" placeholder="Email de cliente" readonly required />
			    <label for="email">Email de Cliente:</label>
			</div>
			
			</div>
			  
			  <div class="form-floating mb-3">
			    <input type="text" class="form-control-plaintext" id="direccion" name="direccion" value="${cliente.direccion}" placeholder="Dirección de cliente" readonly required />
			    <label for="direccion">Dirección de Cliente:</label>
			  </div>	  
			  
			  <p class="text-danger text-center">Eliminar el cliente conlleva a la pérdida de información lo cual es irrecuperable.</p>
			  
			  <div class="d-grid gap-2 col-6 mx-auto">
			  	<button type="submit" class="btn btn-danger btn-sm">Eliminar <i class="fas fa-trash-alt"></i></button>
			  	<a href="${pageContext.request.contextPath}/cliente/listarClientes" class="btn btn-primary btn-sm my-2"><i class="fas fa-users"></i> Volver </a>
			  </div>
			</form>

		</main>
		
		<footer>
		</footer>
		
		<script>
		//SCRIPT QUE CONTROLA EL CAMBIO DE VALUE DE 1 O 0 DEL CHECKBOX PARA LUEGO SER ENVIADO AL CONTROLADOR Y SETEE A ENABLED EL USUARIO.
    		let enabledCheckbox = document.getElementById('enabled-visible');
    		let enabledHidden = document.getElementById('enabled-hidden');

    		enabledCheckbox.addEventListener('click', function() {
        		if (enabledCheckbox.checked) {
            		enabledHidden.value = 1;
           			//alert("on")
        		} else {
            		enabledHidden.value = 0;
            		//alert("off")
        		}
   			 });
			</script>
		
		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>