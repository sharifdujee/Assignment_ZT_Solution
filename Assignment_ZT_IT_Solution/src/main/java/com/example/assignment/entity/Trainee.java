package com.example.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Marks class as an entity.
@Entity
public class Trainee {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer traineeid;
	private String name;
	private String username;
	//@Email (regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	private String password;
	
	//create default constructor 
	public Trainee() {
		super();
	}

// parameterized Constructor 
	public Trainee(Integer traineeid, String name, String username, String email, String password) {
		super();
		this.traineeid = traineeid;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	// Getter and Setter Method

	public Integer getTraineeid() {
		return traineeid;
	}


	public void setTraineeid(Integer traineeid) {
		this.traineeid = traineeid;
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
