package com.ClassSelection.dto;

public class User implements java.io.Serializable {
	// Fields
	private String UserName;
	private String PasswordSHA1;
	private UserRole UserRole;
	private String Email;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String UserName, String PasswordSHA1, UserRole UserRole, String Email) {
		this.UserName = UserName;
		this.PasswordSHA1 = PasswordSHA1;
		this.UserRole = UserRole;
		this.Email = Email;
	}

	// Property accessors
	public String getUserName() {
		return this.UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getPasswordSHA1() {
		return this.PasswordSHA1;
	}

	public void setPasswordSHA1(String PasswordSHA1) {
		this.PasswordSHA1 = PasswordSHA1;
	}

	public UserRole getUserRole() {
		return this.UserRole;
	}

	public void setUserRole(UserRole UserRole) {
		this.UserRole = UserRole;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

}