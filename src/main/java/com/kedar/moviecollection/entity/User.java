package com.kedar.moviecollection.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@NotEmpty(message = "Username is required")
	private String username;

	@NotEmpty(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters long")
	@Pattern(regexp = ".*[!@#$%^&*()].*", message = "Password must contain at least one special character")
	private String password;
	
	private boolean enabled;
	private String role;

	public User() {
		this.role = "ROLE_USER";
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
