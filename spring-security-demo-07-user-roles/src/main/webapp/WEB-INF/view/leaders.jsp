<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Saukum company LEADERS Page</title>
</head>
<body>
	<h2>Saukum company LEADERS Page</h2>

	<hr>
	Welcome To Saukum company Leaders Page !! See in on the Vacation
	.................. to Huwai ISLAND !!!!!
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>