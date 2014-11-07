package com.mlkj.model;

public class User {
	private int id;
	private String name;
	private String userId;
	private String[] department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String[] getDepartment() {
		return department;
	}

	public void setDepartment(String[] department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
