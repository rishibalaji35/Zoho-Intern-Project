import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class status
 */
@webServlet("/Addintoproject")
public class Addintoproject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String driverName = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "logins";
		String userId = "root";
		String password = "password";

		try {
		Class.forName(driverName);
		} 
		catch (ClassNotFoundException e) {
		e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try{ 
			
			connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
			
			String projectname = request.getParameter("projectname");
			String name = request.getParameter("name");
			String status = request.getParameter("status");
			String approval = request.getParameter("approval");
			
			String sql2 = "select * from member where username = '"+name+"' and Approval = 'Approved'";
			
			statement = connection.prepareStatement(sql2);
			
			resultSet = statement.executeQuery(sql2);
			
			if(!resultSet.next()) {
				response.sendRedirect("Error.jsp");
			}
			else {
			
			String sql1 = "select * from projectmember where member = '"+name+"' and projectname = '"+projectname+"'";
			
			statement = connection.prepareStatement(sql1);
			
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				response.sendRedirect("Error.jsp");
			}
			else {
			String sql ="insert into projectmember(projectname,member,memberrole) values(?,?,?)";
			
			
			statement=connection.prepareStatement(sql);
			statement.setString(1, projectname);
			statement.setString(2, name);
			statement.setString(3, status);
			statement.executeUpdate();
			
			response.sendRedirect("Manager1.jsp");
			
			connection.close();
			statement.close();
			
			
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
			}
			finally
			{
			    System.out.println("Already Exist");
			}
	}
}
