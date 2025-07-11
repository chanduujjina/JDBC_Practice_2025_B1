package com.coolcoder.demo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMockService {

	private EmployeeMockService() {

	}

	private static List<Employee> employeeList = null;
	
	
	static {
		if (employeeList == null) {
			employeeList = new ArrayList<>();
		}
		
		employeeList.add(new Employee(4, "Hemanth", "male", 50000d, "it"));
		employeeList.add(new Employee(5, "Rajasekhar", "male", 30000d, "admin"));
		employeeList.add(new Employee(6, "Sudhakar", "male", 40000d, "HR"));
		employeeList.add(new Employee(7, "Abhiram", "male", 50000d, "Finance"));
		employeeList.add(new Employee(8, "Ganesh", "male", 70000d, "Operations"));
	}
	
	
	public static List<Employee> getInstance(){
		return employeeList;
	}

}
