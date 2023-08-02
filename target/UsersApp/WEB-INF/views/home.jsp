<!DOCTYPE html>
<html>
<head>
<title>User Management Dashboard</title>
<style>
/* basic styles for the dashboard */
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.container {
	width: 100%;
	height: 100vh;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background-color: #f5f5f5;
}

h1 {
	font-size: 2.5rem;
	margin-bottom: 1rem;
	text-align: center;
}

nav {
	display: flex;
	justify-content: center;
	margin-bottom: 2rem;
}

nav button {
	font-size: 1.2rem;
	margin: 0 1rem;
	padding: 0.5rem 1rem;
	border: none;
	border-radius: 4px;
	background-color: #4CAF50;
	color: white;
	cursor: pointer;
}

nav button:hover {
	background-color: #3e8e41;
}
/* styles for the content area */
.content {
	width: 80%;
	background-color: white;
	padding: 2rem;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
	<div class="container">
		<h1>User Management Dashboard</h1>
		<nav>
			<a href="Register">
				<button>Add User</button>
			</a> <a href="view">
				<button>View User</button>
			</a>
			
			<button>Search</button>
		</nav>
		<div class="content">
			<!-- content goes here -->
		</div>
	</div>
</body>
</html>