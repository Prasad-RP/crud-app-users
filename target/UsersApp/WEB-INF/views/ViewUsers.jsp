<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script>
	$(document).ready(function() {
		$('#usersTable').DataTable();
	});
</script>
<title>Document</title>
</head>

<body>
	<table id="usersTable" class="table table-striped" style="width: 100%">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>address</th>
				<th>edit</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${user}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.address}</td>
					<td><a href="editUser/${user.id}">Edit</a></td>
					<td><a href="deleteUser/${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>


</body>

</html>