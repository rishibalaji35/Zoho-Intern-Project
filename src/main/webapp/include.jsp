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
int x = 1;

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
<!--  --><link rel="stylesheet" href="included.css">
<meta charset="ISO-8859-1">
<title>User Added</title>
</head>
<body>
<center>
<!-- <p>Selected User added Successfully!!</p> -->
<p>Assign a Role to the selected User</p><br>
</center>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String username = request.getParameter("name");

String projectid = request.getParameter("projectid");

//String sql ="UPDATE member set Approval = 'Approved' where username = '"+username+"'" ;
%>
<center>
<form action = "assignmanagerrole.jsp" method = "post">
<!-- <input type = "text" name = "role" placeholder = "Assign a role"><br> -->
<label for="role">Assign a Role:</label>
  <select name="role" id="role">
    <option value="Team Lead">Team Lead</option>
    <option value="Team Member">Team Member</option>
 
  </select>
  <br><br>
<input type="hidden" name="name" value=<%=username%>>
<input type="hidden" name="projectid" value=<%=projectid%>><br>
<input type = "submit" value = "Assign">
</form>
</center>

<%
//statement.executeUpdate(sql);

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
</body>
</html>