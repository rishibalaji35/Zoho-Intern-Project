<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="center">
		<h1>Manager Login page</h1>
		<form action = "LoginManager" method="post">
		<div class="inputbox">
				UserName<input type="text" required="required" name = name> 
			</div>
			<div class="inputbox">
				Password<input type="text" required="required" name = pass> 
			</div>
			<div class="inputbox">
				Organization Name<input type="text" required="required" name = orgname> 
			</div>
			<div class="inputbox">
				Manager ID<input type="text" required="required" name=managerID> 
			</div>
			
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
</body>
</html>