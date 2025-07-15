package com.coolcoder.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallStoredProcedureInOUTdemo1 {
	
	public static void main(String[] args) {
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				CallableStatement callableStatement = connection.prepareCall("{call get_employee_name_by_id(?,?)}")) {
			
			callableStatement.setInt(1, 8);
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			
			
			
			callableStatement.execute();
			String name = callableStatement.getString(2);
			
			System.out.println(name);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
