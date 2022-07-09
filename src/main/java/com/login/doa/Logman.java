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
@webServlet("/Logman")

public class Logman extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//db adding code
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		
		String orgname = request.getParameter("orgname");
		String managerid = request.getParameter("managerID");
		
		LogDoa doa = new LogDoa();
		if (doa.isthere(orgname, managerid,name,pass)) {
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
