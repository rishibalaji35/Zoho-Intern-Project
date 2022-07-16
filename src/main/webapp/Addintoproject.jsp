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

<%
String username = request.getParameter("name");
String status = request.getParameter("status");
String approval = request.getParameter("approval");

%>
	<div class="center">
		<h1>Create a Project</h1>
		<form action = "Addintoproject" method="post">
		<div class="inputbox">
				<input type="text" required="required" name = projectname placeholder="ProjectName"> 
				<input type="hidden" name="name" value=<%=username%>><input type="hidden" name="status" value=<%=status%>>
				<input type="hidden" name="approval" value=<%=approval%>>
			</div>
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>

