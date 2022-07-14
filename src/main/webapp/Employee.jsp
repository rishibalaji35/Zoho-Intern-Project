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


<h2 align="center"><font><strong>Logged in as a Employee</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
>
<td><b>UserName</b></td>
<td><b>Work status</b></td>
<td><b>Project code</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();

String projectid = (String)session.getAttribute("data");

String username=session.getAttribute("data").toString();

String sql ="SELECT * FROM manager WHERE username = '"+username+"' and Approval = 'Approved'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		
		String status = resultSet.getString("status");
		
		String joinproject = resultSet.getString("Joinproject");
		
		
		%>
		
		
		<td><%=username%></td>
		<td><%=resultSet.getString("status")%></td>
		
		<!-- Approval status for a manager entry -->
		<td><form action="role" method = "post">
				<input type="hidden" name="name" value=<%=username%>><input
					type="submit" value=<%=joinproject%>>
			</form></td>
		
		<!-- <td><form action="Included.jsp">
				<input type="hidden" name="name" value=<%=username%>><input
					type="submit" value="Assign Role">
			</form></td>  -->
			
			<!-- Remove the selected entry -->
			
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
<center>
<form action="Logout" method="post">
<input type="submit" value="Logout">
</form>

<form action = "project.jsp" method = "post">
<input type="hidden" name="projectid" value=projectid>
<input type = "submit" value = "View Project">
</form>
<center>

</body>
</html>


