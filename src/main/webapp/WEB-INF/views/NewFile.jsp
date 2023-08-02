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



<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">


<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<style>
h1 {
	text-align: center;
	margin-bottom: 20px;
	font-weight: bold;
	font-size: 40px;
	color: #333;
}

a {
	text-align: center;
	margin-bottom: 20px;
	font-weight: bold;
	font-size: 20px;
	color: #333;
}
</style>

<script>
	$(document).ready(function() {
		$('#usersTable').DataTable();

		$('#checkBoxAll').click(function() {
			if ($(this).is(":checked"))
				$('.chkCheckBoxId').prop('checked', true);
			else
				$('.chkCheckBoxId').prop('checked', false);
		});

	});
</script>
<title>View All Users</title>
</head>
<h1>Users List</h1>
<body>

	<form action="DeleteProcess" method="post">


		<input type="submit" name="submit" value="Delete"
			onclick="return confirm('Are You Sure?')" />
		<table id="usersTable" class="hover" style="width: 100%">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkBoxAll" Name="checkBoxAll"></th>
					<th>Id</th>
					<th>Name</th>

					<th>Email</th>
					<th>Address</th>
					<th>Edit</th>
					<th>Delete</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${user}">
					<tr>
						<td><input type="checkbox" class="chkCheckBoxId" 
							Name="deleteMul" value="${user.id }"></td>

						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.address}</td>
						<td><a href="editUser/${user.id}"><button>Edit</button></a></td>
						<td><a href="deleteUser/${user.id}"><button>Delete</button></a></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>
	
	<hr>
	<a href="/UsersApp"> Take Me Home! </a></form>
</body>

</html>