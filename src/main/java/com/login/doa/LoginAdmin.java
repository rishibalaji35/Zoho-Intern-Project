package com.login.doa;


import java.sql.*;
import java.util.Random;

import com.login.doa.LogDoa;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginAdmin
 */
@webServlet("/LoginAdmin")

public class LoginAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("name");
		String pass = request.getParameter("pass");
		String orgname = request.getParameter("orgname");
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    int length = 5;
	    for(int i = 0; i < length; i++) {
	      int index = random.nextInt(alphabet.length());
	      char randomChar = alphabet.charAt(index);
	      sb.append(randomChar);
	    }
	      String manid = sb.toString();
	      
	      
	      StringBuilder sb1 = new StringBuilder();
		    Random random1 = new Random();
		    int lengths = 5;
		    for(int i = 0; i < lengths; i++) {
		      int index = random1.nextInt(alphabet.length());
		      char randomChar = alphabet.charAt(index);
		      sb1.append(randomChar);
		    }
		      String empid = sb1.toString();
		      
		      
		LogDoa doa = new LogDoa();
//		insert ins = new insert();
		if (doa.check(username,pass,orgname,manid,empid)) {
			response.sendRedirect("Members.jsp");
		}
//		 else if(ins.add(uname, pass,stat)){
//			
//			response.sendRedirect("Added.jsp");
//		}
//		else {
//			response.sendRedirect("Error.jsp");
//		}
	}
}
