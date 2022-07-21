

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


@webServlet("./completionstatus")
public class completionstatus extends HttpServlet {
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
		Statement statement = null;
		//ResultSet resultSet = null;
		
		try{ 
			String taskname = request.getParameter("taskname");
			connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);

			String sql ="update task set completionstatus = 'Completed' where taskname = '"+taskname+"'";
	
			statement=connection.createStatement();
			statement.executeUpdate(sql);
			response.sendRedirect("ViewTask.jsp");
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
