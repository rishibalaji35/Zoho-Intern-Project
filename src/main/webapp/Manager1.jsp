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
<td><b>Approval</b></td>
<td><b>Add into Project</b></td>
 <!--<td><b>Assign Role</b></td>   -->
 <td><b>Click To Remove</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
//String username = (String)session.getAttribute("username");

//String projectid = (String)session.getAttribute("data");

//String projectid = (String)request.getAttribute("data");

//request.setAttribute("data",projectid);
//RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
//rd.forward(request, response);

//String project=request.getParameter("data");
//session.setAttribute("data",projectid);

String sql ="SELECT * FROM member order by status desc";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	
%>
	<tr bgcolor="#DEB887">
		<%
		String username = resultSet.getString("username");
		
		String status = resultSet.getString("status");
		
		String approval = resultSet.getString("Approval");
		
		if(status.equals("SuperAdmin")){			
			continue;
		}
		%>
		
		
		<td><%=username%></td>
		<td><%=resultSet.getString("status")%></td>
		<td><form action="status1" method = "post">
				<input type="hidden" name="name" value=<%=username%>><input
					type="submit" value=<%=approval%>>
			</form></td>
		
		<!-- Approval status for a manager entry -->
		<td><form action="Addintoproject.jsp" method = "post">
				<input type="hidden" name="name" value=<%=username%>><input type="hidden" name="status" value=<%=status%>>
				<input type="hidden" name="approval" value=<%=approval%>>
				<input type="submit" value= Addintoproject>
			</form></td>
			
			<%if(status.equals("Employee")){
				
			 %>
			<td><form action="delete1" method = "post">
				<input type="hidden" name="username" value=<%=username%>><input
					type="submit" value="Remove">
			</form></td>
		
	<%} else{%>
		<td></td>
	<% }%>
		
			
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
<form action = "createproject.jsp" method = "post">
<input type="hidden" name="projectid" value=projectid>
<input type = "submit" value = "Create Project">
</form>
<br>
<form action = "viewproject2.jsp" method = "post">
<input type="hidden" name="projectid" value=projectid>
<input type = "submit" value = "View Project">
</form>
<br>
<form action="Logout" method="post">
<input type="submit" value="Logout">
</form>


<center>

</body>
</html>


