<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<h2>${Header}</h2>
<h1>${user.name }</h1>
<h2>Added in database</h2>

		<a href="/home">
				<button>Back to home</button>
			</a>

</body>
</html>