package com.coolcoder.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLBlobDemo1 {
	
	public static void main(String[] args) {
		
		
		String sql ="create table Blob_demo(doc_id int primary key auto_increment,doc_name varchar(255) not null,doc_type varchar(255),image_data blob)";
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				Statement statement = connection.createStatement()
				) {
			
			statement.execute(sql);
			
			System.out.println("table created suucessfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}

}
