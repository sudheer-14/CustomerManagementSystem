package com.mainproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mainproject.model.Admin;
import com.mainproject.model.User;

public class AdminDao {

	public static String url ="jdbc:mysql://localhost:3306/mainproject";
	public static String user="root";
	public static String password="bobby";
	public static Connection con =null;
	public static Statement st = null;
	public static PreparedStatement ps= null;
	public static ResultSet rs =null;
	public static String insert ="insert into user (name,city,email) values (?,?,?)";
	public static String select ="select * from user";
	public static String delete ="delete  from user where id =?";
	public static String selectid ="select * from user where id=?";
	public static String updateuser ="update user set name=?,email=?,city=? where id=?";
	public static String validate(Admin a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st =con.createStatement();
			rs = st.executeQuery("select * from admin");
			while(rs.next()) {
				String dusername=rs.getString("username");
				String dpass = rs.getString("password");
				
				if(dusername.equals(a.getUsername()) && dpass.equals(a.getPassword()) ) {
					
					return "success";
					
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return "failure";
		
	}
	
	public static void insertUser(User u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(insert);
			ps.setString(1, u.getName());
			ps.setString(2, u.getCity());
			ps.setString(3, u.getEmail());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<User> displayUser() {
		ArrayList<User> us = new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name= rs.getString("name");
				String city = rs.getString("city");
				String email = rs.getString("email");
				User u = new User(id, name, email, city);
				us.add(u);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return us;
	}

	public static void deleteuser(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static User selectuser(int id1) {
		User u =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(selectid);
			ps.setInt(1, id1);
			rs= ps.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String city = rs.getString("city");
			String email = rs.getString("email");
			
			 u = new User(id, name,email , city);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
		
	}

	public static void updateUser(User u) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(updateuser);
			ps.setString(1, u.getName());
			ps.setString(2, u.getCity());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getId());
			ps.executeUpdate();  
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

