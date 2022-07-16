<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "login.css">
<meta charset="ISO-8859-1">
<title>Admin Login </title>
</head>
<body>


	<div class="center">
		<h1>Create a Project</h1>
		<form action = "createproject" method="post">
		<div class="inputbox">
				<input type="text" required="required" name = projectname placeholder="ProjectName"> 
			</div>
			<div class="inputbox">
				<input type="text" required="required" name = description placeholder="Description"> 
			</div>
			<div class="inputbox">
				<input type="text" required="required" name = Deadline placeholder="Fix a DeadLine"> 
			</div>
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>

