<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- INCRUSTA HEAD -->
		<jsp:include page="./partials/head.jsp" />
		
		<title>Insert title here</title>
	</head>
	<body>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" class="btn btn-danger" />
		</form:form>
	</body>
</html>