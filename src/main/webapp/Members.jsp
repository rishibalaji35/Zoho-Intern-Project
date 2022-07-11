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


<h2 align="center"><font><strong>Logged in as a Super Admin</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
>
<td><b>UserName</b></td>
<td><b>Work status</b></td>
<td><b>Approval Status</b></td>
<td><b>Click To Add</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String orgname = (String)session.getAttribute("orgname");

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if(session.getAttribute("orgname")==null){
	response.sendRedirect("login.jsp");
}

String sql ="SELECT * FROM member WHERE Orgname = '"+orgname+"'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<tr bgcolor="#DEB887">
		<%
		String username = resultSet.getString("username");
		%>
		<td><%=username%></td>
		<td><%=resultSet.getString("status")%></td>
		<td><%=resultSet.getString("Approval")%></td>
		<td><form action="Included.jsp">
				<input type="hidden" name="name" value=<%=username%>><input
					type="submit" value="Add Into Organization">
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
<center>
<form action="Logout" method="post">
<input type="submit" value="Logout">
</form>
<center>

</body>
</html>


