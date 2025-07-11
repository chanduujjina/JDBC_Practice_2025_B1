package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDemo3 {
	
	public static void main(String[] args) {
		
		String sql ="select * from employee_info where id = ? and name = ? and dept_name= ?";
		
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(sql);
				) {
			
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "siva");
			preparedStatement.setString(3, "it");
			preparedStatement.execute();
			
			
			ResultSet resultSet = preparedStatement.getResultSet();
			
			if (null != resultSet) {
				while(resultSet.next()) {
					System.out.println("id: "+resultSet.getInt("id"));
					System.out.println("name: "+resultSet.getString("name"));
					System.out.println("gender: "+resultSet.getString("gender"));
					System.out.println("salary: "+resultSet.getDouble("salary"));
					System.out.println("dept name: "+resultSet.getString("dept_name"));
					
					System.out.println("----------------------------------");
				}
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
