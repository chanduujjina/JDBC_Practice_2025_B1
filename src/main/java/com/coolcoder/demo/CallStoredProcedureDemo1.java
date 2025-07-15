package com.coolcoder.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallStoredProcedureDemo1 {
	
	public static void main(String[] args) {
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				CallableStatement callableStatement = connection.prepareCall("{call get_employee_by_id(?)}")) {
			callableStatement.setInt(1, 8);
			ResultSet resultSet = callableStatement.executeQuery();
			
			
			
			while(resultSet.next()) {
				System.out.println("id :"+resultSet.getInt("id"));
				System.out.println("name :"+resultSet.getString("name"));
				System.out.println("gender :"+resultSet.getString("gender"));
				System.out.println("salary :"+resultSet.getDouble("salary"));
				System.out.println("dept_name :"+resultSet.getString("dept_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
