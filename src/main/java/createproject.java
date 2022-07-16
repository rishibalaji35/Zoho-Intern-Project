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
@webServlet("/createproject")
public class createproject extends HttpServlet {
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
		//ResultSet resultSet = null;
		
		try{ 
			
			connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
			String projectname = request.getParameter("projectname");
			String description = request.getParameter("description");
			String deadline = request.getParameter("Deadline");

			String sql ="insert into project(projectname,description,Deadline) values(?,?,?)";
			
			
			statement=connection.prepareStatement(sql);
			statement.setString(1, projectname);
			statement.setString(2, description);
			statement.setString(3, deadline);
			statement.executeUpdate();
			HttpSession session = request.getSession();
			String username=request.getParameter("data");
			session.setAttribute("data",projectname);
			response.sendRedirect("Manager1.jsp");
			connection.close();
			statement.close();
			
			
			} catch (Exception e) {
			e.printStackTrace();
			}
			finally
			{
			    System.out.println("finally block executed");
			}
	}
}
