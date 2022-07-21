import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@webServlet("./Nowsms")
public class Nowsms extends HttpServlet {
	public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";
	private static final long serialVersionUID = 1L;
       
    
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber(""),
	                new com.twilio.type.PhoneNumber(""),
	                "Project has been Ended by the Manager")
	            .create();

	        System.out.println(message.getSid());
	        response.sendRedirect("Manager1.jsp");
	}


}
