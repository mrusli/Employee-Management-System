package com.pyramix.employee.model;

import lombok.Data;

@Data
public class Employee {
	
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;

	public Employee() {
		super();

	}

	public Employee(long id, String firstName, String lastName, String emailId) {
		super();
		
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmailId(emailId);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
