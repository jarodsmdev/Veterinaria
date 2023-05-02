<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<!-- INCRUSTA HEAD -->
			<jsp:include page="./../partials/head.jsp" />
		
		<title>Editar Usuario</title>
	</head>
	<body>
		<header>
			<!-- Incrusta header -->
			<jsp:include page="./../partials/navbar.jsp" />
		</header>
		
		<main class="container">

			<h2 class="text-center my-5">Editar Usuario</h2>
			
			<hr>
				<a href="${pageContext.request.contextPath}/usuarios/listarUsuarios" class="btn btn-primary btn-sm my-2"><i class="fas fa-users"></i> Listar Usuarios </a>
			
			<hr>
			
			<form action="${pageContext.request.contextPath}/usuarios/actualizarUsuario" method="POST" class="need-validation" novalidate th:object="${userForm}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<input type="hidden" name="username_id" value="${user.username}" />
				
				<div class="form-floating mb-3">
					<input type="text" readonly class="form-control-plaintext" id="username" name="username" value="${user.username}" placeholder="Nombre de Usuario" required autocomplete="off" />
					<label for="username">Nombre de Usuario:</label>
					<div class="invalid-feedback">
						Debe ingresar nombre de Usuario.
					</div>
				</div>
				
				<div class="row">
					<div class="form-floating mb-3 col-6">
						<input type="text" class="form-control form-control-sm" id="password" name="password" value="${user.password}" placeholder="Contraseña" required autocomplete="off" />
						<label for="password" class="ms-2">Contraseña:</label>
						<div class="invalid-feedback errorMsg">
							Debe ingresar constraseña.
						</div>
					</div>
					
					<div class="form-floating mb-3 col-6">
						<input type="text" class="form-control form-control-sm" id="password2" name="password2" value="${user.password}" placeholder="Repita su contraseña" required autocomplete="off" />
						<label for="password2" class="ms-2">Repita su contraseña:</label>
						<div class="invalid-feedback errorMsg">
							Debe ingresar constraseña.
						</div>
					</div>
				</div>
				
				<div class="form-check form-switch mb-3">
					<input type="hidden" name="enabled" value="${user.enabled}" id="enabled-hidden">
			    	<input type="checkbox" class="form-check-input" role="switch" id="enabled-visible" name="enabled-visible" ${user.enabled == 1 ? "checked" : ""} />
			    	<label class="form-check-label" for="enabled-visible">Habilitado</label>
				</div>
				
				<!-- SECCION DE ROLES -->

				<div class="row">
				    <div class="col-5">
				        <h5 class="text-center">Roles disponibles</h5>
				        <select multiple class="form-control" id="roles-disponibles">
							<option value="ROLE_USUARIO">ROLE_USUARIO</option>
							<option value="ROLE_ADMINISTRADOR">ROLE_ADMINISTRADOR</option>
						</select>
				    </div>
				    <div class="col-2 text-center">
				        <br><br>
				        <button type="button" class="btn btn-primary btn-sm" id="btn-add-role">&gt;&gt;</button>
				        <br><br>
				        <button type="button" class="btn btn-danger btn-sm" id="btn-remove-role">&lt;&lt;</button>
				    </div>
				    <div class="col-5">
				        <h5 class="text-center">Roles asignados</h5>
				        <select multiple class="form-control" id="roles-asignados" name="rolesAsignados">
				        	<c:forEach var="authority" items="${user.authorities}">
				        		<option value="${authority.authority}" selected>${authority.authority}</option>
				        	</c:forEach>
				        </select>
				    </div>
				</div>

				<hr>
				<div class="row justify-content-end mt-2">
					<button type="submit" class="btn btn-success btn-sm w-50 my-2" id="btnEnviar" disabled>Actualizar <i class="fas fa-save"></i></button>
				</div>
			</form>

		</main>
		
		<footer>
		</footer>
		
		<!-- SELECCION DE ROLES JS -->
		<script src="${pageContext.request.contextPath}/resources/js/seleccionRoles.js"></script>
		
		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>