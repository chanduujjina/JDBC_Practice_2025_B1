package com.coolcoder.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClobFechDemo1 {

	public static void main(String[] args) {

		try (Connection connection = DatabaseConnectionUtility.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement("select * from clob_demo1");
				FileWriter fileWriter = new FileWriter("src/main/resources/output/Files/text1.txt")) {

			prepareStatement.execute();

				ResultSet resultSet = prepareStatement.getResultSet();
				while (resultSet.next()) {
					System.out.println("id : " + resultSet.getInt("doc_id"));

					System.out.println("name : " + resultSet.getString("doc_name"));

					System.out.println("type: " + resultSet.getString("doc_type"));
					
					Reader characterStream = resultSet.getCharacterStream("file_data");
					
					int ch =0;
					
					StringBuilder builder = new StringBuilder();
					
					while((ch = characterStream.read()) !=-1) {
						builder.append((char)ch);
					}
					fileWriter.write(builder.toString());
					
					System.out.println("Clob fetched suceesfully");
				}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
