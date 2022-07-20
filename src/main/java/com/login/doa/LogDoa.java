package com.login.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.mysql.cj.protocol.Resultset;


public class LogDoa {
	
	String sql = "INSERT INTO organization(orgname,managerid,employeeid)"+"values(?,?,?)";
	String sql1= "INSERT INTO member(username,password,status,Approval,orgname)"+"values(?,?,?,?,?)";
	
	String sql4 = "select Orgname from member where Orgname=? and username=? and password=?";
	String sql5 = "select Orgname from member where Orgname=? and status='SuperAdmin'";
	
	
	
	
	String url = "jdbc:mysql://localhost:3306/logins";
	String uname = "root";
	String pass = "password";
	
	public boolean insert(String username,String password,String orgname,String managerid,String employeeid) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st = conn.prepareStatement(sql);
			PreparedStatement st1 = conn.prepareStatement(sql1);
			
			PreparedStatement st2 = conn.prepareStatement(sql4);
			st2.setString(1, orgname);
			st2.setString(2, username);
			st2.setString(3, password);
			
			st2.executeQuery();
			ResultSet rs = st2.executeQuery();
	
			if(rs.next()) {
				return true;
				//already org exist with this name
				//try creating org with diff name
			}
			
			PreparedStatement st3 = conn.prepareStatement(sql5);
			st3.setString(1, orgname);
			
			st3.executeQuery();
			ResultSet rs1 = st3.executeQuery();
	
			if(rs1.next()) {
				return false;
				//already org exist with this name
				//try creating org with diff name
			}
			
			st.setString(1, orgname);
			st.setString(2, managerid);
			st.setString(3,employeeid);
			st1.setString(1, username);
			st1.setString(2,password);
			st1.setString(3,"SuperAdmin");
			st1.setString(4, "Approved");
			st1.setString(5, orgname);
			st.executeUpdate();
			st1.executeUpdate();
			
			conn.close();
			st.close();
			st1.close();
			st2.close();
			
				return true;
				
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isthere(String orgname,String username,String password) {
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
			String sql7 = "select * from member where username = '"+username+"' and Approval = 'Approved' and status='Manager'";
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
	public boolean issthere(String orgname,String employeeid,String username,String password) {
		
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
				
			String sql2 = "SELECT * FROM organization WHERE orgname = '" + orgname + "' and employeeid =\"" + employeeid+"\"";
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()) {
				String sql5 = "insert into member(username,password,status,Approval,orgname)values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql5);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, "Employee");
				ps.setString(4,"Pending");
				ps.setString(5,orgname);
				ps.executeUpdate();
				
				String sql6 = "INSERT INTO manager(username,password,status,Approval,joinproject)"+"values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql6);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, "Employee");
				ps.setString(4, "pending");
				ps.setString(5, projectcode);
				ps.executeUpdate();
			
//			String sql2 = "SELECT * FROM organization WHERE orgname = '" + orgname + "' and employeeid =\"" + employeeid+"\"";
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(url,uname,pass);
//			PreparedStatement ps = conn.prepareStatement(sql2);
//			//ps.setString(1, orgname);
//			//ps.setString(2, managerid);
//			ps.executeQuery();
//			ResultSet rs = ps.executeQuery(sql2);
//			if(rs.next()) {
//				String sql3 = "insert into member(username,password,status,Approval,orgname)values(?,?,?,?,?)";
//				PreparedStatement ps1 = conn.prepareStatement(sql3);
//				ps1.setString(1, username);
//				ps1.setString(2,password);
//				ps1.setString(3, "Employee");
//				ps1.setString(4,"Pending");
//				ps1.setString(5,orgname);
//				if(ps1.executeUpdate() > 0) {
//					conn.close();
//					ps.close();
//					ps1.close();
//					
//					return true;
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}

//orgname,empid,manid
