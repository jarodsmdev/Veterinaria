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
		
		<title>Eliminar Usuario</title>
	</head>
	<body class="container">
		<header>
			<!-- Incrusta header -->
			<jsp:include page="./../partials/navbar.jsp" />
		</header>
		
		<main>

			<h2 class="text-center">Eliminar Usuario</h2>
			
			<form action="${pageContext.request.contextPath}/usuarios/eliminarUsuario" method="POST" class="need-validation" novalidate th:object="${userForm}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<input type="hidden" name="username_id" value="${user.username}" />
				
				<div class="form-floating mb-3">
					<input type="text" readonly class="form-control-plaintext" id="username" name="username" value="${user.username}" placeholder="Nombre de Usuario" required>
					<label for="username">Nombre de Usuario:</label>
					<div class="invalid-feedback">
						Debe ingresar nombre de Usuario.
					</div>
				</div>
				
				<div class="form-floating mb-3">
					<input type="password" class="form-control form-control-sm" id="password" name="password" value="${user.password}" placeholder="Contraseña" required>
					<label for="password">Contraseña:</label>
				</div>
				
				<div class="form-floating mb-3">
					<input type="password" class="form-control form-control-sm" id="password2" name="password2" value="${user.password}" placeholder="Repita su contraseña" required>
					<label for="password2">Repita su contraseña:</label>
				</div>
				
				<div class="form-check form-switch mb-3">
					<input type="hidden" name="enabled" value="${user.enabled}" id="enabled-hidden">
			    	<input type="checkbox" class="form-check-input" role="switch" id="enabled-visible" name="enabled-visible" ${user.enabled == 1 ? "checked" : ""} disabled/>
			    	<label class="form-check-label" for="enabled-visible">Habilitado</label>
				</div>

				<button type="submit" class="btn btn-danger btn-sm w-25">Eliminar <i class="fas fa-trash-alt"></i></button>
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