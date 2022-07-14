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
import java.io.IOException;

/**
 * Servlet implementation class status
 */
@webServlet("/Task")
public class Task extends HttpServlet {
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
			
			String taskname = request.getParameter("task");

			String sql ="insert into task(taskname) values(?)";
			
			
			statement=connection.prepareStatement(sql);
			statement.setString(1, taskname);
			statement.executeUpdate();
			response.sendRedirect("project.jsp");
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
