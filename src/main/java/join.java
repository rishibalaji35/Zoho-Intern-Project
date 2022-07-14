

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.login.doa.LogDoa1;

/**
 * Servlet implementation class join
 */
@webServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public join() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String joinname = request.getParameter("joinname");
		String joinpass = request.getParameter("joinpass");
		String projectid = request.getParameter("projectID");
		
		LogDoa1 doa1 = new LogDoa1();
		if (doa1.join(joinname, joinpass,projectid)) {
			response.sendRedirect("idadded.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
	}

}
