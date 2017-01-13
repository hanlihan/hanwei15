package com.ittx.Student.Model;

public class Users {
	private int id;
	private String username;
	private String password;
	private int number;

	public Users(String username, String password, int number) {
		this.username = username;
		this.password = password;
		this.number = number;
	}

	public Users(int id,String username, String password, int number) {
        this.id = id;
		this.username = username;
		this.password = password;
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", number=" + number + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
