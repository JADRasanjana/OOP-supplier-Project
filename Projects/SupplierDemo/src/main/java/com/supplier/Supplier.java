package com.supplier;

public class Supplier {

	private int id;
	private String name;
	private String email;
	private String phone;
	private String userName;
	private String password;
	
	public Supplier(int id, String name, String email, String phone, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return this.userName;
	}

	public String getPassword() {
		return password;
	}
	
}
