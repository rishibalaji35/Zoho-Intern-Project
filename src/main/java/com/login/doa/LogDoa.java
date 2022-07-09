package com.login.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;


public class LogDoa {
	
	String sql = "INSERT INTO organization(orgname,managerid,employeeid)"+"values(?,?,?)";
	String sql1= "INSERT INTO member(username,member,status,Approval)"+"values(?,?,?,?)";
	
	String sql4 = "select orgname from organization";
	String url = "jdbc:mysql://localhost:3306/logins";
	String uname = "root";
	String pass = "password";
	
	public boolean check(String username,String password,String orgname,String managerid,String employeeid) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st = conn.prepareStatement(sql);
			PreparedStatement st1 = conn.prepareStatement(sql1);
			
			PreparedStatement st2 = conn.prepareStatement(sql4);
			st2.executeQuery();
			ResultSet rs = st2.executeQuery();
			if(rs.next()) {
				return true;
			}
			st.setString(1, orgname);
			st.setString(2, managerid);
			st.setString(3,employeeid);
			st1.setString(1, username);
			st1.setString(2,password);
			st1.setString(3,"SuperAdmin");
			st1.setString(4, "Approved");
			st.executeUpdate();
			st1.executeUpdate();
			
				return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isthere(String orgname,String managerid,String username,String password) {
		try {
			String sql2 = "SELECT * FROM organization WHERE orgname = '" + orgname + "' and managerid =\"" + managerid+"\"";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = conn.prepareStatement(sql2);
			//ps.setString(1, orgname);
			//ps.setString(2, managerid);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//return true;
				String sql3 = "insert into member(username,member,status,Approval)values(?,?,?,?)";
				PreparedStatement ps1 = conn.prepareStatement(sql3);
				ps1.setString(1, username);
				ps1.setString(2, password);
				ps1.setString(3, "Manager");
				ps1.setString(4,"Pending");
				//ResultSet rs = ps1.executeUpdate(sql3);
				//ps.executeUpdate();
				if(ps1.executeUpdate()> 0) {
					return true;
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean issthere(String orgname,String employeeid,String username,String password) {
		try {
			String sql2 = "SELECT * FROM organization WHERE orgname = '" + orgname + "' and employeeid =\"" + employeeid+"\"";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = conn.prepareStatement(sql2);
			//ps.setString(1, orgname);
			//ps.setString(2, managerid);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery(sql2);
			if(rs.next()) {
				String sql3 = "insert into member(username,member,status,Approval)values(?,?,?,?)";
				PreparedStatement ps1 = conn.prepareStatement(sql3);
				ps1.setString(1, username);
				ps1.setString(2,password);
				ps1.setString(3, "Employee");
				ps1.setString(4,"Pending");
				if(ps1.executeUpdate() > 0) {
					return true;
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

//orgname,empid,manid
