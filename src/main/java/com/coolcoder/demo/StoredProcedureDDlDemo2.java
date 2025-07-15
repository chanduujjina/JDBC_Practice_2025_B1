package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcedureDDlDemo2 {
	
	public static void main(String[] args) {
		
		String sql ="CREATE PROCEDURE GET_EMPLOYEE_NAME_BY_ID(IN INPUT_ID INT,OUT OUT_NAME VARCHAR(255)) "
				+ "BEGIN "
				+ "SELECT NAME INTO OUT_NAME FROM EMPLOYEE_INFO WHERE ID = INPUT_ID; "
				+ "END";
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				Statement createStatement = connection.createStatement()) {
			createStatement.execute(sql);
			
			System.out.println("Stored procedure created Sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
