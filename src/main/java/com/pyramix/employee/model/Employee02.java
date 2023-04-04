package com.pyramix.employee.model;

import lombok.Data;

@Data
public class Employee02 {

	private long id;
	
	private String name;
		
	private String email;
	
	private String title;
	
	private String department;
	
	private String status;
	
	private String role;
	
	private String img_Url;

	public Employee02() {
		super();
	}

	public Employee02(long id, String name, String email, String title, String department, String status, String role,
			String img_Url) {
		super();
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.title = title;
		this.department = department;
		this.status = status;
		this.role = role;
		this.img_Url = img_Url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImg_Url() {
		return img_Url;
	}

	public void setImgUrl(String img_Url) {
		this.img_Url = img_Url;
	}
}
