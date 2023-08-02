<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Error</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
}

h1 {
	font-size: 3em;
	text-align: center;
	color: #cc0000;
	margin-top: 50px;
}

p {
	font-size: 1.2em;
	text-align: center;
	color: #333333;
	margin-top: 20px;
}

a {
	font-size: 1.2em;
	text-align: center;
	color: #333333;
	margin-top: 20px;
}
</style>
</head>
<body>
	<h1>OOps Something Went Wrong</h1>
	<p>We're sorry, ${msg }</p>
	<a href="/CrudApp"> Take Me Home! </a>
</body>
</html>