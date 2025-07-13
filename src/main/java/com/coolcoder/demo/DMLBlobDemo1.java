package com.coolcoder.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMLBlobDemo1 {
	
	public static void main(String[] args) {
		
		String sql = "insert into blob_demo (doc_name,doc_type,image_data) values(?,?,?)";
		
	try (Connection connection = DatabaseConnectionUtility.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			FileInputStream inputStream = new FileInputStream("src/main/resources/input/image/test3.jpg")) {
		prepareStatement.setString(1, "profile Photo");
		prepareStatement.setString(2, "image");
		prepareStatement.setBinaryStream(3, inputStream);
		
		prepareStatement.execute();
		
		System.out.println("Blob insered successfully");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch(IOException ex) {
		ex.printStackTrace();
	}
		
	}
	
	
	

}
