package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLDemo1 {
	
	public static void main(String[] args) throws SQLException {
		
		String sql = "create table test1 (id int,name varchar(255),is_active Boolean)";
		Connection connection = null;
		Statement statement = null;
		
		try {
			 connection = DatabaseConnectionUtility.getConnection();
			
			 statement = connection.createStatement();
			
			statement.execute(sql);
			
			System.out.println("table created successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			//close the statement
			if (statement != null) {
				statement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
			
			//close the connection
		}
		
	}

}
