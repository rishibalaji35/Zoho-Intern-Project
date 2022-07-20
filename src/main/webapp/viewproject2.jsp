<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%



String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "logins";
String userId = "root";
String password = "password";
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>


<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "login.css">
<meta charset="ISO-8859-1">
<title>Admin Login </title>
</head>
<body>


	<div class="center">
		<h1>View a Project</h1>
		<form action = "viewproject.jsp" method="post">
		<div class="inputbox">
				<input type="text" required="required" name = projectname placeholder="ProjectName"> 
			</div>
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
	
	<h2 align="center"><font><strong></strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">

<td><b>Available Projects</b></td>
 <td><b>Description</b></td>
 <td><b>DeadLine</b></td> 
 
<!-- <td> <b>Approval Status</b></td>

 <td><b>Click To Remove</b></td> -->


</tr>
<%
try{ 
	//String projectname = request.getParameter("projectname");
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
//String username = (String)session.getAttribute("username");
//String projectid = (String)request.getAttribute("data");

//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");




String sql ="SELECT * FROM project";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		String projectname = resultSet.getString("projectname");
	%>	
		<td>
		<form action = "viewproject.jsp" method = "post">
		<input type = "submit" value = <%=projectname%> name = projectname>
		</form>
		</td>
		<td><%=resultSet.getString("description") %></td>
		<td><%=resultSet.getString("Deadline") %></td>
			
	<% 
	

}
connection.close();
statement.close();

} catch (Exception e) {
e.printStackTrace();
}
finally
{
    System.out.println("finally block executed");
}
%>
</table>
</body>
</html>

