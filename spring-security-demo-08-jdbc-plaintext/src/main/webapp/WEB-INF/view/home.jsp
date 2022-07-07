<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Saukum company Home Page</title>
</head>
<body>
	<h2>Saukum company Home Page</h2>

	<hr>
	Welcome To Saukum company Home Page !!

	<hr>
	User :
	<security:authentication property="principal.username" />
	<br> Role(s) :
	<security:authentication property="principal.authorities" />

	<hr>

	<!-- Add a link to point to leaders -->

	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leaders
				Meeting</a> (Only for Managers Peeps)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System
				Meeting</a> (Only for Admin Peeps)
		</p>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>