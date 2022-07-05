<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Saukum company Home Page</title>
</head>
<body>
	<h2>Saukum company Home Page</h2>
	<hr>
	Welcome To Saukum company Home Page !!
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>