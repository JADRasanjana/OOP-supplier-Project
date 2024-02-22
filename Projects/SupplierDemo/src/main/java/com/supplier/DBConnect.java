package com.supplier;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/vehicle_spare_parts";
	private static String username = "root";
	private static String password = "Dilshan2000@";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con =(Connection) DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			
			System.out.println("Database connection is faild!!");
		}
		
			return con;
	}

}
