package com.login.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class LogDoa2 {
	String url = "jdbc:mysql://localhost:3306/logins";
	String uname = "root";
	String pass = "password";
	public boolean isthere(String orgname,String managerid,String username,String password) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    int length = 5;
	    for(int i = 0; i < length; i++) {
	      int index = random.nextInt(alphabet.length());
	      char randomChar = alphabet.charAt(index);
	      sb.append(randomChar);
	    }
	      String projectcode = sb.toString();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			String sql7 = "select * from member where username = '"+username+"'";
			PreparedStatement ps = conn.prepareStatement(sql7);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			String sql2 = "SELECT * FROM organization WHERE orgname = '" + orgname + "' and managerid =\"" + managerid+"\"";
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()) {
				String sql5 = "insert into member(username,password,status,Approval,orgname)values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql5);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, "Manager");
				ps.setString(4,"Pending");
				ps.setString(5,orgname);
				ps.executeUpdate();
				
				String sql6 = "INSERT INTO manager(username,password,status,Approval,joinproject)"+"values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql6);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, "Manager");
				ps.setString(4, "Approved");
				ps.setString(5, projectcode);
				ps.executeUpdate();
				//return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean issthere(String orgname,String username,String password) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    int length = 5;
	    for(int i = 0; i < length; i++) {
	      int index = random.nextInt(alphabet.length());
	      char randomChar = alphabet.charAt(index);
	      sb.append(randomChar);
	    }
	      String projectcode = sb.toString();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			String sql7 = "select * from member where username = '"+username+"' and Approval = 'Approved' and status='Employee'";
			PreparedStatement ps = conn.prepareStatement(sql7);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			//System.out.println("pending");
//			String sql2 = "SELECT * FROM organization WHERE orgname = '" + orgname + "' and managerid =\"" + managerid+"\"";
//			ps = conn.prepareStatement(sql2);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				String sql5 = "insert into member(username,password,status,Approval,orgname)values(?,?,?,?,?)";
//				ps = conn.prepareStatement(sql5);
//				ps.setString(1, username);
//				ps.setString(2, password);
//				ps.setString(3, "Manager");
//				ps.setString(4,"Pending");
//				ps.setString(5,orgname);
//				ps.executeUpdate();
//				
//				String sql6 = "INSERT INTO manager(username,password,status,Approval,joinproject)"+"values(?,?,?,?,?)";
//				ps = conn.prepareStatement(sql6);
//				ps.setString(1, username);
//				ps.setString(2, password);
//				ps.setString(3, "Manager");
//				ps.setString(4, "Approved");
//				ps.setString(5, projectcode);
//				ps.executeUpdate();
//				return true;
//			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
