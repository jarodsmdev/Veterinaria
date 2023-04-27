<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Inicio de Sesión</title>
		
		<!-- BOOTSTRAP v4.0 -->
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
		<!-- CUSTOM CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginForm.css">
	</head>
<body>
	<main class="login-wrap">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked />
			<label
				for="tab-1" class="tab">INICIAR SESIÓN</label> <input id="tab-2"
				type="radio" name="tab" class="for-pwd"><label for="tab-2"
				class="tab">OLVIDÉ MI CONTRASEÑA
			</label>
			<div class="login-form">
				<form action="" method="POST" class="sign-in-htm">
					<div class="group">
						<label for="user" class="label">Usuario</label>
						<input id="user" type="text" class="input" placeholder="Nombre de Usuario" autocomplete="false"  />
					</div>
					<div class="group">
						<label for="pass" class="label">Password</label>
						<input id="pass" type="password" class="input" data-type="password" placeholder="Contraseña" />
					</div>
					<div class="group">
						<input type="submit" class="button" value="Iniciar Sesión" />
					</div>
					<div class="hr"></div>
				</form>
				<form action="" method="POST" class="for-pwd-htm">
					<div class="group">
						<label for="user" class="label">Usuario</label>
						<input 	id="user" type="text" class="input" placeholder="Nombre de usuario" autocomplete="false" />
					</div>
					<div class="group">
						<input type="submit" class="button" value="Recuperar Contraseña">
					</div>
					<div class="hr"></div>
				</form>
			</div>
		</div>
	</main>
	
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>