package com.supplier;

import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class SupplierDBUtil {
	
	private static boolean isSucccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
		
public static boolean validate1(String userName,String password) {
		
		boolean isSuccess = false;
		try {
			con  = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from supplier where username='"+userName+"' and password='"+password+"'";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				isSuccess  = true;
				
			}else {
				
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Supplier> validate(String userName, String password) {
		
		ArrayList<Supplier> sup = new ArrayList<>();
		
		try {
			
			con  = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from supplier where username='"+userName+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);    
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);
				
				Supplier s = new Supplier(id,name,email,phone,userU,passU);
				sup.add(s);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return sup;
	}
	
	public static List<Supplier> getSupplier(String userName) {
		
		ArrayList<Supplier> sup = new ArrayList<>();
		
		try {
			
			con  = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from supplier where username '"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);    
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Supplier su = new Supplier(id,name,email,phone,username,password);
				sup.add(su);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return sup;
	}
	
	
	public static boolean insertsupplier(String name, String email, String phone, String userName, String password) {
		
		
		boolean isSuccess = false;
		
			try {
				
				con  = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "insert into supplier values(0,'"+name+"','"+email+"','"+phone+"','"+userName+"','"+password+"')";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;
					
				}else {
					isSuccess = false;
				}
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		
		return isSuccess;
	}
	
	public static boolean updatesupplier(String id, String name, String email, String phone, String userName, String password) {
	
		boolean isSuccess = false;
		try {
			con  = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "Update supplier set name='"+name+"', email='"+email+"' ,phone='"+phone+"' ,username='"+userName+"' ,password='"+password+"'"
					+"where id='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isSuccess  = true;
				
			}else {
				
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Supplier> getSupplierDetails(String ID){
		
		int convertedID = Integer.parseInt(ID);
		
		ArrayList<Supplier> sup = new ArrayList<Supplier>();
		
		try {
			con  = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "Select * from supplier where id = '"+convertedID+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Supplier s = new Supplier(id,name,email,phone,username,password);
				sup.add(s);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return sup;
	}
	public static boolean deletesupplier(String id) {
		
		int convID = Integer.parseInt(id);
		
		boolean isSuccess = false;
		try {
			con  = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "delete from supplier where id='"+convID+"'";
			
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
				
				isSuccess  = true;
				
			}else {
				
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	

}

