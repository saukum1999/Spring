<!Doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Student- Input Form</title>


</head>

<body>
	<form:form action="processForm" modelAttribute="student">
		<br> First Name : <form:input path="firstName" />
		<br> Last Name : <form:input path="lastName" />
		<br>
		Country : 
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
			<%-- <form:option value="India" label="IND"/>
			<form:option value="USA" label="USA"/>
			<form:option value="British" label="GBP"/> --%>
		</form:select>
		<br>
		Favourite Language :
		<form:radiobutton path="favouriteLanguage" value="Java" label="Java" />
		<form:radiobutton path="favouriteLanguage" value="Python"
			label="Python" />
		<form:radiobutton path="favouriteLanguage" value="C++" label="C++" />
		<form:radiobutton path="favouriteLanguage" value="C#" label="C#" />
		<br>
		Operating Systems : 
		<form:checkbox path="operatingSystems" value="Linux" label="Linux" />
		<form:checkbox path="operatingSystems" value="Mac OS" label="Mac OS" />
		<form:checkbox path="operatingSystems" value="Microsoft Windows" label="Microsoft Windows" />
		

		<input type="submit" value="submit" />


	</form:form>


</body>
</html>