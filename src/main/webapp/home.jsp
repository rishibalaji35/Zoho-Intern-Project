<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="home.css">

<meta charset="ISO-8859-1">
<title>welcome page</title>
</head>
<body>
<!-- <img src = "Logo.jpg" alt = "logo" width="100" height = "100"> -->
<img src="Logo.jpg" alt="logo" style="position: absolute; width: 116px; height: 100px; left: 90px; top: 96px;">
	<div class="center">
	<form action  = "loginad" method="post">
	<div class="inputbox">

	<div class = "inputbox">
	<input type="submit" value="Create your own Business">
	</div>
	</div>
	</form><br>
	
	<form action  = "loginmanager" method="post">
	<div class="inputbox">
	<!-- <p><h1>Join Business as Manager</h1></p> -->
	<div class = "inputbox">
	<input type="submit" value="Join as a Manager">
	</div>
	</div>
	</form><br>
	
	<form action  = "loginemp" method="post">
	<div class="inputbox">
	<!-- <p><h1>Join Business as Employee</h1></p> -->
	<div class = "inputbox">
	<input type="submit" value="Join as an Employee">
	</div>
	</div>
	</form>
	
	</div>
	
</body>
</html>

