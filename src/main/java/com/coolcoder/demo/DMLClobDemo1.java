package com.coolcoder.demo;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMLClobDemo1 {
	
	public static void main(String[] args) {
		
		
		String sql = "insert into clob_demo1 (doc_name,doc_type,file_data) values(?,?,?)";
		
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				FileReader fileReader = new FileReader("src/main/resources/input/Files/test1.txt")) {
			
			prepareStatement.setString(1, "bio");
			prepareStatement.setString(2, "text");
			prepareStatement.setCharacterStream(3, fileReader);
			
			prepareStatement.execute();
			
			System.out.println("Clob created successfully");
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
