package com.coolcoder.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobFetchDemo1 {
	
	public static void main(String[] args) {
		
		String sql = "select * from blob_demo";
		
		try (Connection connection = DatabaseConnectionUtility.getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(sql);
				FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/output/image/test1.jpg");
				) {
			
			preparedStatement.execute();
			
			ResultSet resultSet = preparedStatement.getResultSet();
			
			while(resultSet.next()) {
				System.out.println("id : "+resultSet.getInt("doc_id"));
				
				System.out.println("name : "+resultSet.getString("doc_name"));
				
				System.out.println("type: "+resultSet.getString("doc_type"));
				
				InputStream binaryStream = resultSet.getBinaryStream("image_data");
				
				fileOutputStream.write(binaryStream.readAllBytes());
				
				System.out.println("Blob fetch succesfully");
			}
			
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	

}
