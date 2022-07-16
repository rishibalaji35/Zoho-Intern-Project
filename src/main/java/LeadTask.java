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
@webServlet("/LeadTask")
public class LeadTask extends HttpServlet {
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
			//String name = request.getParameter("name");
			connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
			
			String taskname = request.getParameter("task");
			String assignedby = request.getParameter("assignedby");
			String assignedfor = request.getParameter("assignedfor");
			String Deadline = request.getParameter("Deadline");

			String sql ="insert into task(taskname,assignedby,assignedfor,Deadline) values(?,?,?,?)";
			
			
			statement=connection.prepareStatement(sql);
			statement.setString(1, taskname);
			statement.setString(2, assignedby);
			statement.setString(3, assignedfor);
			statement.setString(4, Deadline);
			statement.executeUpdate();
			
			response.sendRedirect("TeamLeadTask.jsp");
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
