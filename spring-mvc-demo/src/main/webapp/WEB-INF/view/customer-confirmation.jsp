<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!Doctype html>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<html>
<head>
<title>Customer Confirmation Page</title>
</head>

<body>

	<br> Customer First name: ${customer.firstName}
	<br> Customer Last name: ${customer.lastName}
	<br> Customer Free Passes: ${customer.freePasses}
	<br> Customer Postal Code: ${customer.postalCode}
	<br> Customer Course Code: ${customer.courseCode}

	<%-- Message : ${message} --%>

	<hr>
	<a href="/spring-mvc-demo">Main Menu</a>
</body>
</html>