<%-- 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>


</head>
<style>
table {
	border-collapse: collapse;
	width: 70%;
	margin: 20px auto;
	font-family: Arial, Helvetica, sans-serif;
}

th, td {
	padding: 10px;
	text-align: left;
	border: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
	color: #333;
	font-weight: bold;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	color: blue;
	text-decoration: none;
	font-weight: bold;
}

.container-fluid {
	background-color: #f8f9fa;
	padding: 30px 0;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
	font-weight: bold;
	font-size: 40px;
	color: #333;
}

input[type="text"] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

input[type="text"]:focus {
	border: 2px solid #4CAF50;
}

.btn {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
	font-size: 16px;
}

.btn:hover {
	background-color: #45a049;
}

.container {
	text-align: center;
	margin-top: 30px;
}

a.btn {
	margin-top: 20px;
	font-weight: bold;
	font-size: 20px;
}
</style>

<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="rcol-md-10 bg-light mt-2 rounded pb-3">
			<h1>User Records</h1>
			<hr>
			<div class="form-inline">
				<label for="search_text" class="font-weight-bold lead text-dark">
				</label>&nbsp; &nbsp;&nbsp; <input type="text" id="search_text" name="search_text"
					class="form-control form-control-lg rounded-0 border-primary"
					placeholder="Enter name to search">
			</div>
		</div>
	</div>
</div>
<body>
	<table border="2" id="table-data">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>
			<th>address</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
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
	</table>
	<hr>
	<div class="container">

		<a href="/CrudApp"> Take Me Home! </a>

	</div>



</body>
</html>
  --%>
