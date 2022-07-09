package com.login.doa;

import java.sql.*;

import com.login.doa.LogDoa;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  implementation class LoginAdmin
 */
@webServlet("/LogEmployee")

public class LogEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		
		String orgname = request.getParameter("orgname");
		String employeeid = request.getParameter("employeeID");
		
		LogDoa doa = new LogDoa();
		if (doa.issthere(orgname, employeeid,username,password)) {
			response.sendRedirect("idadded.jsp");
		}
//		 else if(ins.add(uname, pass,stat)){
//			
//			response.sendRedirect("Added.jsp");
//		}
		else {
			response.sendRedirect("Error.jsp");
		}
	}

}
