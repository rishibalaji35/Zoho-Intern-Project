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
		<h1>Manager Signup page</h1>
		<form action = "Logman1" method="post">
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
				<input type="text" required="required" name=managerID placeholder="Manager ID"> 
			</div>
			
			<div class="inputbox">
				<input type="submit" value="Sign up">
			</div>
		</form>
		
		<form action="Managersignin.jsp" method = "post">
		<p>Already have an account</p>
		<input type = submit value = "Sign in">
		</form>
		</div>
		
		<!-- <form action="joinproject.jsp" method = "post">
		<p>Join existing project</p>
		<input type = submit value = "Sign in">
		</form> -->
		</div>
</body>
</html>