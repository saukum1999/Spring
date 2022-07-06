<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Saukum company SYSTEMS Page</title>
</head>
<body>
	<h2>Saukum company SYSTEMS Page</h2>

	<hr>
	Welcome To Saukum company SYSTEMS Page !! See in on the Vacation
	.................. to Carabian ISLAND !!!!!
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>