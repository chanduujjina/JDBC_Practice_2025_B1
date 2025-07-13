package com.coolcoder.demo;

public class EmployeeDetails {
	
	private Integer id;
	
	private String name;
	
	private String phoneNumber;
	
	private Double salary;
	
	private String gender;
	
	private String email;

	private Documents documents;
	

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public EmployeeDetails(Integer id, String name, String phoneNumber, Double salary, String gender, String email,
			Documents documents) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.gender = gender;
		this.email = email;
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", salary=" + salary
				+ ", gender=" + gender + ", email=" + email + ", documents=" + documents + "]";
	}

	public Documents getDocuments() {
		return documents;
	}

	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
