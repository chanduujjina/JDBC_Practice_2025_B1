package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMLDemo2 {
	
	public static void main(String[] args) {
		
		
		//get the connection
		
		String insertSql = "insert into employee_info (name,gender,salary,dept_name) values(?,?,?,?)";
		
		Employee employee = new Employee(2, "siva", "male", 100000d, "it");
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(insertSql)
				) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getGender());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setString(4, employee.getDeptName());
			preparedStatement.execute();
			
			System.out.println("Insert data successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
