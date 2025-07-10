package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtility {
	
	private static Connection connection;
	
	private DatabaseConnectionUtility() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		
		try {
			if (connection == null) {
				connection=	DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_practice_2025_b1","root","root");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return connection;
		
	}

}
