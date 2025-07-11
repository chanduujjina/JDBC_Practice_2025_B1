package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BatchInsertdemo1 {
	
	public static void main(String[] args) throws SQLException {
		
		String insertSql = "insert  employee_info (name,gender,salary,dept_name) values(?,?,?,?)";
		
		
		List<Employee> employeeList = EmployeeMockService.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// get the connection
			 connection = DatabaseConnectionUtility.getConnection();
			
			//set autocommit fasle
			connection.setAutoCommit(false);
			
			 preparedStatement = connection.prepareStatement(insertSql);
			
			for (Employee employee :employeeList) {
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setString(2, employee.getGender());
				preparedStatement.setDouble(3, employee.getSalary());
				preparedStatement.setString(4, employee.getDeptName());
				
				//add your object to batch
				preparedStatement.addBatch();
			}
			
			//execute the query using preparedstatement
			int[] executeBatch = preparedStatement.executeBatch();
			
			System.out.println("no of objects inserted "+executeBatch.length);
			//commit the transaction
			
			connection.commit();
		} catch (SQLException e) {
			
			if (null != connection) {
			connection.rollback();
			}
			e.printStackTrace();
		}
		
		finally {
			if (null != preparedStatement) {
				preparedStatement.close();
			}
			
			if (null != connection) {
				connection.close();
			}
		}
	}

}
