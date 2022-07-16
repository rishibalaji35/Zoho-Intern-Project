package com.login.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogDoa1 {
	
	String url = "jdbc:mysql://localhost:3306/logins";
	String uname = "root";
	String pass = "password";
	
	
	
	public boolean join(String username,String password,String projectid) {
		
		String sql4 = "select * from member where username = '"+username+"' and Approval = 'Approved'";
		
		String sql3 = "SELECT * FROM manager where Joinproject = '"+projectid+"' and status = 'Manager'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			//PreparedStatement st = conn.prepareStatement(sql3);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql4);
			if(!rs.next()) {
				return false;
			}
			rs = st.executeQuery(sql3);
			if(rs.next()) {
				System.out.println("reached");
				String sql ="insert into manager(username,password,status,Approval,Joinproject) values(?,?,?,?,?)";
				PreparedStatement ps1 = conn.prepareStatement(sql);
				ps1.setString(1, username);
				ps1.setString(2,password);
				ps1.setString(3,"Manager1");
				ps1.setString(4,"pending");
				ps1.setString(5,projectid);
				
					
				ps1.executeUpdate();
				
				//already org exist with this name
				//try creating org with diff name
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
public boolean joinee(String username,String password,String projectid) {
		
		String sql3 = "SELECT * FROM manager where Joinproject = '"+projectid+"'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			//PreparedStatement st = conn.prepareStatement(sql3);
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql3);
	
			if(rs.next()) {
				System.out.println("reached");
				String sql ="insert into manager(username,password,status,Approval,Joinproject) values(?,?,?,?,?)";
				PreparedStatement ps1 = conn.prepareStatement(sql);
				ps1.setString(1, username);
				ps1.setString(2,password);
				ps1.setString(3,"Employee");
				ps1.setString(4,"pending");
				ps1.setString(5,projectid);
				
					
				if(ps1.executeUpdate()> 0 ) {
					return true;
				}
				
				//already org exist with this name
				//try creating org with diff name
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
