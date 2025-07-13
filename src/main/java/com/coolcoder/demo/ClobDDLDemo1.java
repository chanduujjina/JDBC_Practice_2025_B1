package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClobDDLDemo1 {
	
	public static void main(String[] args) {
		
		String sql = "create table clob_demo1 (doc_id int primary key auto_increment,doc_name varchar(255) not null,doc_type varchar(255) not null,file_data text)";
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				Statement statement = connection.createStatement()
				) {
			
			statement.execute(sql);
			
			System.out.println("clob table created suucessfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
	

}
