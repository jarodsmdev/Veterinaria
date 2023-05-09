<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home Page</title>
		<!-- INCRUSTA HEAD -->
		<jsp:include page="./partials/head.jsp" />
		
	</head>
	<body>
		<header>
			<!-- Incrusta header -->
			<jsp:include page="./partials/navbar.jsp" />
		</header>

		<main class="container">
			<h2 class="text-center my-5">Consulta Veterinaria</h2>
			
			<hr>
			<img src="${pageContext.request.contextPath}/resources/img/1.jpg" class="img-fluid" alt="...">
		</main>
		
		
		<!-- BOOTSTRAP JS CDN v5.2.3 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

	</body>
	
	<div>
		<!-- Incrusta footer -->
		<jsp:include page="./partials/footer.jsp" />
	</div>
</html>
