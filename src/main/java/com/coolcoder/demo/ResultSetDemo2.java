package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo2 {
	
	public static void main(String[] args) {
		
		fetchDataFromEmployee("female");
	}

	private static void fetchDataFromEmployee(String gender) {
		String sql ="select * from employee_info where gender ='{gender}'";
		
		sql = sql.replace("{gender}", gender);
		
		System.out.println(sql);
		
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				Statement statement=connection.createStatement()
				) {
			statement.execute(sql);
			
			
			ResultSet resultSet = statement.getResultSet();
			
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
