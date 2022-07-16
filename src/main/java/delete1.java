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
@webServlet("/delete1")
public class delete1 extends HttpServlet {
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
		ResultSet resultSet = null;
		
		try{ 
			connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
			statement=connection.createStatement();
			String username = request.getParameter("username");

			String sql ="DELETE FROM member where username = '"+username+"'" ;
			statement.executeUpdate(sql);
			String sql1 ="DELETE FROM manager where username = '"+username+"'" ;
			statement.executeUpdate(sql1);
			String sql2 ="DELETE FROM manager where username = '"+username+"'" ;
			statement.executeUpdate(sql2);
			String sql3 ="DELETE FROM task where assignedby = '"+username+"'" ;
			statement.executeUpdate(sql3);
			String sql4 ="DELETE FROM task where assignedfor = '"+username+"'" ;
			statement.executeUpdate(sql4);
			String sql5 ="DELETE FROM projectmember where member = '"+username+"'" ;
			statement.executeUpdate(sql5);
			//String sql1 = "update manager set status = 'Manager' where username = '"+username+"'";
			//statement.executeUpdate(sql1);
			connection.close();
			statement.close();
			response.sendRedirect("Manager.jsp");

			} catch (Exception e) {
			e.printStackTrace();
			}
			finally
			{
			    System.out.println("finally block executed");
			}
	}
}
