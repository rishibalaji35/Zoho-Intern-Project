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
<td><b>ProjectName</b></td>
<td><b>Description</b></td>
<!--<td> <b>Approval Status</b></td> -->
<td><b>DeadLine</b></td> 
<!-- <td><b>Click To Remove</b></td> -->


</tr>
<%
try{ 
	String projectname = request.getParameter("projectname");
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
//String username = (String)session.getAttribute("username");
//String projectid = (String)request.getAttribute("data");

//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");




String sql ="SELECT * FROM project WHERE projectname = '"+projectname+"'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		String name = resultSet.getString("projectname");
		
		String description = resultSet.getString("description");
		
		String deadline = resultSet.getString("Deadline");
	%>
		
		
		<td><%=name%></td>
		
		<td><%=description%></td>
		
		<td><%=deadline%></td>		
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

<h2 align="center"><font><strong>Members</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
>
<td><b>UserName</b></td>
<td><b>Work status</b></td>
<!--<td> <b>Approval Status</b></td> -->
<td><b>Update Role</b></td> 
<!-- <td><b>Click To Remove</b></td> -->

</tr>
<%

try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
//String username = (String)session.getAttribute("username");
//String projectid = (String)request.getAttribute("data");

//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

//String projectid = (String)request.getAttribute("data");


String projectname = request.getParameter("projectname");
String sql ="SELECT * FROM projectmember WHERE projectname = '"+projectname+"'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		String username = resultSet.getString("member");
		
		String status = resultSet.getString("memberrole");
		
		/*if(status.equals("Manager")){
			
			continue;
		}*/
		%>
		
		
		<td><%=username%></td>
		
		<td><%=status%></td>
		
		 <td><form action="include1.jsp">
				<input type="hidden" name="name" value=<%=username%>>
				<input type="hidden" name="projectname" value=<%=projectname%>><input
					type="submit" value="Update Role">
			</form></td> 
	</tr>

	<% 
	

}

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
<br>
<form action = "Task" method = "post">

<input type = "text" name = task placeholder = "Create a Task">
<br><br>
<input type = "text" name = assignedby placeholder = "Assigned By">
<br><br>
<input type = "text" name = assignedfor placeholder = "Assigned For">
<br><br>
<% 
String projectname = request.getParameter("projectname");
String sql1 = "select Deadline from project where projectname = '"+projectname+"'";

resultSet = statement.executeQuery(sql1);
while(resultSet.next()){
%>
<input type = "Date" min="2010-01-01" max=<%=resultSet.getString("Deadline")%> name = Deadline placeholder = "Fix a DeadLine"><br>
<%} %>
<br>
<input type = "text" name = projectname placeholder = "project Name">
<br><br>
<input type = "Submit" value = "Create Task">
</form>

<form action = "ViewTask.jsp" method = "post">
<input type = "text" name = projectname placeholder="Enter project Name">
<input type = "hidden" value =projectname>
<input type = "Submit" value = "View Task">
</form>

<form action="Nowsms" method = "post">

<input type = "submit" value = "End project">
</form>
<center>

</body>
</html>


