package com.login.doa;

import java.sql.*;

import com.login.doa.LogDoa;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *  implementation class LoginAdmin
 */
@webServlet("/LogEmployee2")

public class LogEmployee2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		
		String orgname = request.getParameter("orgname");
		String employeeid = request.getParameter("employeeID");
		
		LogDoa2 doa = new LogDoa2();
		if (doa.issthere(orgname, employeeid,username,password)) {
			response.sendRedirect("home.jsp");
		}

		else {
//			PrintWriter out=response.getWriter();
//			response.setContentType("text/html");
//			out.println("<html>");
//			out.println("<head>");
//			/*out.println("<meta http-equiv=\"Content-Language\" content=\"en-us\">");
//			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">");
//			out.println("<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 4.0\">");
//			out.println("<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">");*/
//			out.println("<title>");
//			out.println("Employee Home Page");
//			out.println("</TITLE>");
//			out.println("<SCRIPT LANGUAGE=javascript>");
//			out.println("<!--");
//			out.println("function window_onload() { alert(\"User Already Exist\") } ");
//			out.println("//-->");
//			out.println("</SCRIPT>");
//			out.println("</head>");
//			out.println("<body onload=window_onload()>");
//			out.println("</body>");
//			out.println("</html>");
			HttpSession session = request.getSession();
			String project=request.getParameter("data");
			session.setAttribute("data",username);
			//response.sendRedirect("Employee.jsp");
			response.sendRedirect("Employee1.jsp");
						
		}
	}

}
