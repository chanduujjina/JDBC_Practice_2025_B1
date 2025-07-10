package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLDemo1 {
	
	public static void main(String[] args) {
		
		
		//get the connection
		
		String insertSql = "insert into test1 values(1,'chandu',true)";
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				Statement statement = connection.createStatement();
				) {
			
			statement.execute(insertSql);
			
			System.out.println("Insert data successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
