package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Table(name = "users")
@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "username", nullable = false)
	@NotEmpty(message = "User Name is Required")
	@Size(min = 8, max = 25, message = "Username must be needed at least 8 character ")
	private String username;
	@Column(unique = true)
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size(min = 6, max = 15, message = "Set at Least 6 character")
	private String password;

	public User() {
		super();
	}

	public User(Integer userId, String name,
			@NotEmpty @Size(min = 8, message = "Username must be needed at least 8 character ") String username,
			@NotEmpty @Email String email,
			@NotEmpty @Size(min = 6, message = "Set at Least 6 character") String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
