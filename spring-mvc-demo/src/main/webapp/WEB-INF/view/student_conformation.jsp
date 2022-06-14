<!Doctype html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Student Confirmation Page</title>
</head>

<body>

	Hello world of Spring!
	<br>
	<br> Student first name: ${student.firstName}
	<br> Student last name: ${student.lastName}
	<br>
	<br>
	<br> Student Country : ${student.country}
	<br> Student's Favourite Language : ${student.favouriteLanguage}
	<br>
	<br> Operating System : 
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}">
				<li>${temp}</li>
			</c:forEach>

		</ul>

	<%-- Message : ${message} --%>

	<hr>
	<a href="/spring-mvc-demo">Main Menu</a>
</body>
</html>