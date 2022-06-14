<!Doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<html>
<head>
<title>Customer - Input Form</title>

<style type="text/css">
.error {color : red}
</style>
</head>

<body>
	<form:form action="processForm" modelAttribute="customer">
		<br> First Name : <form:input path="firstName" />

		<br> Last Name : <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		
		<br> Free Passes : <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		
		<br> Postal Code : <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		
		<br> Course Code : <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		<input type="submit" value="submit" />


	</form:form>


</body>
</html>