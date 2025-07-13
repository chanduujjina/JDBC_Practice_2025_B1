package com.coolcoder.demo;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManagementService {
	
	public static void main(String[] args) {
		
	   try (Connection connection = DatabaseConnectionUtility.getConnection();
			   FileInputStream inputStream = new FileInputStream("src/main/resources/input/image/test3.jpg");
			   FileReader fileReader = new FileReader("src/main/resources/input/Files/test1.txt");
			   ) {
		   
		  
		   Documents documents = new Documents(1, "image_text", "employee_docs", inputStream, fileReader);
		EmployeeDetails employeeDetails = new EmployeeDetails(2, "Raju", "9573532531", 10000d, "male","Raju@gmail.com",documents);
		  
		   
		   Integer empId = insertEmployeeDetails(connection,employeeDetails);
		   
			System.out.println("Employee saved successfully id "+empId);
		   
		   insertDocuments(connection,empId,employeeDetails.getDocuments());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   catch(IOException ex) {
		   ex.printStackTrace();
	   }
		
	}

	private static void insertDocuments(Connection connection, Integer empId, Documents documents) {
		
		String sql = "insert into documents (doc_name,doc_type,image_data,text_data,emp_id) values(?,?,?,?,?)";
		
		try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
			prepareStatement.setString(1, documents.getDocName());
			prepareStatement.setString(2, documents.getDocType());
			prepareStatement.setBinaryStream(3, documents.getImageData());
			prepareStatement.setCharacterStream(4, documents.getTextData());
			prepareStatement.setInt(5, empId);
			
			prepareStatement.execute();
			
			System.out.println("document created succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Integer insertEmployeeDetails(Connection connection, EmployeeDetails employeeDetails) {
		
		String sql = "insert into employee(name,phoneNumber,salary,gender,email) values(?,?,?,?,?)";
		
		try (PreparedStatement prepareStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			prepareStatement.setString(1, employeeDetails.getName());
			prepareStatement.setString(2, employeeDetails.getPhoneNumber());
			prepareStatement.setDouble(3, employeeDetails.getSalary());
			prepareStatement.setString(4, employeeDetails.getGender());
			prepareStatement.setString(5, employeeDetails.getEmail());
			
			prepareStatement.execute();
		
			
			//get the auto generatedkeys
			
			try (ResultSet generatedKeys = prepareStatement.getGeneratedKeys()) {
				
				while(generatedKeys.next()) {
					return generatedKeys.getInt(1);
				}
				
				
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
