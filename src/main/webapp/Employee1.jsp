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
<td><b>Project Name</b></td>
<td><b>Assign Task</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();

//String projectid = (String)session.getAttribute("data");

String username=session.getAttribute("data").toString();

String sql ="SELECT * FROM projectmember WHERE member = '"+username+"'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		
		String status = resultSet.getString("memberrole");
		
		//String joinproject = resultSet.getString("Joinproject");
		String projectname = resultSet.getString("projectname");
		
		%>
		
		
		<td><%=username%></td>
		<td><%=status%></td>
		
		<!-- Approval status for a manager entry -->
		<td><input
					type="submit" value=<%=projectname%>>
			</td>
			<%
			if(status.equals("Team Lead")){
			
			%>
		
		 <td><form action="TeamLeadTask1.jsp">
				<input type="hidden" name="name" value=<%=username%>>
				<input type="hidden" name="projectname" value=<%=projectname%>>
				<input type="submit" value="Assign Task">
			</form></td> 
			<%} %>
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

<br><br>
<form action="Logout" method="post">
<input type="submit" value="Logout">
</form>


<center>

</body>
</html>


