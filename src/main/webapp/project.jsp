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


<h2 align="center"><font><strong>Logged in as a Manager</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
>
<td><b>UserName</b></td>
<td><b>Work status</b></td>
<!--<td> <b>Approval Status</b></td> -->
<td><b>Assign Role</b></td> 
<!-- <td><b>Click To Remove</b></td> -->
<td>Deadline</td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
//String username = (String)session.getAttribute("username");
//String projectid = (String)request.getAttribute("data");

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

//String projectid = (String)request.getAttribute("data");
String projectid = (String)session.getAttribute("data");


String sql ="SELECT * FROM manager WHERE Joinproject = '"+projectid+"' and Approval = 'Approved'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		String username = resultSet.getString("username");
		
		String status = resultSet.getString("status");
		
		String approval = resultSet.getString("Approval");
		

		
		if(status.equals("Manager")){
			
			continue;
		}
		%>
		
		
		<td><%=username%></td>
		
		<td><%=resultSet.getString("status")%></td>
		
		 <td><form action="include.jsp">
				<input type="hidden" name="name" value=<%=username%>>
				<input type="hidden" name="projectid" value=<%=projectid%>><input
					type="submit" value="Assign Role">
			</form></td> 
		
			<td><input type="date" id="start" name="trip-start"
       value="2021-08-22"
       min="2021-01-01" max="2021-12-31"></td>
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

<form action = "Task" method = "post">
<input type = "text" name = task id = "task">
<input type = "Submit" value = "Create Task">
</form>

<form action = "ViewTask.jsp" method = "post">
<input type = "Submit" value = "View Task">
</form>


<center>

</body>
</html>


