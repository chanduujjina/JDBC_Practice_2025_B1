package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLdemo2 {
	
	public static void main(String[] args) {
		
		String createSql = "create table employee_info(id int primary key auto_increment,name varchar(255) not null,gender varchar(255),salary double,dept_name varchar(255) not null)";
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				Statement statement = connection.createStatement()) {
			
			statement.execute(createSql);
			
			System.out.println("table created successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
