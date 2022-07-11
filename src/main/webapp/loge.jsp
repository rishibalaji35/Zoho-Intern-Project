<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="loge.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="center">
		<h1>Employee Login page</h1>
		<form action = "LogEmployee" method="post">
		<div class="inputbox">
				<input type="text" required="required" name = name placeholder="UserName"> 
			</div>
			<div class="inputbox">
				<input type="password" required="required" name = pass placeholder="Password"> 
			</div>
			<div class="inputbox">
				<input type="text" required="required" name = orgname placeholder="Organization Name"> 
			</div>
			<div class="inputbox">
				<input type="text" required="required" name=employeeID placeholder="Employee ID"> 
			</div>
			
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
</body>
</html>