<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>about</title>
</head>
<body>
	<h1>hello about</h1>
 
	<%
	String name = (String) request.getAttribute("name");

	out.println(name);
	System.out.print(name);

	Integer id = (Integer) request.getAttribute("id");

	out.println(id);
	System.out.print(id);
	%>
	<h1>${name }</h1>
	<h1>${id }</h1>
	<hr>

	<c:forEach var="ele" items="${marks}">

		<h1>${ ele}</h1>
	</c:forEach>


</body>
</html>