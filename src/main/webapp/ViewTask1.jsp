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
<html>
<head>
<!--  -->
<link rel="stylesheet" href="Members.css">
<head>
<title>View Members</title>
<body>


<h2 align="center"><font><strong>Logged in</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
>
<td><b>Task</b></td>
<td><b>Assigned By</b></td>
  <td><b>Assigned For</b></td>
  <td><b>Deadline</b></td>  
  <td><b>Completion Status</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String projectname = request.getParameter("projectname");

String sql ="SELECT * FROM task where projectname = '"+projectname+"' ORDER BY Deadline";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		String taskname = resultSet.getString("taskname");
		
		String completionstatus = resultSet.getString("completionstatus");
		
		//String approval = resultSet.getString("Approval");
		
		%>
		
		
		<td><%=taskname%></td>
		<td><%=resultSet.getString("assignedby")%></td>
		<td><%=resultSet.getString("assignedfor")%></td>
		<td><%=resultSet.getString("Deadline")%></td>
		<td><form action = "completionstatus1" method="post">
					<input type=submit value=<%=completionstatus%>>
					<input type = "hidden" value =<%=taskname%> name=taskname>
				</form></td>
		
		
	</tr>

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


