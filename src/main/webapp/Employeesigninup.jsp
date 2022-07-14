<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Managersigninup.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="center">
		<h1>Employee signup page</h1>
		<form action = "LogEmployee" method="post">
		<div class="inputbox">
				<input type="text" required="required" name = name placeholder="Username"> 
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
				<input type="submit" value="Sign up">
			</div>
		</form>
		
		<form action="Employeesignin.jsp" method = "post">
		<p>Already have an account</p>
		<input type = submit value = "Sign in">
		</form>
		
		<form action="joinprojectee.jsp" method = "post">
		<p>Join existing project</p>
		<input type = submit value = "Sign in">
		</form>
		</div>
</body>
</html>