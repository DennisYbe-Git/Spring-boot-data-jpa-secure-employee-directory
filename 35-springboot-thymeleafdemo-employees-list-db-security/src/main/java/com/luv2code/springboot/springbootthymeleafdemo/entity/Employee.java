package com.luv2code.springboot.springbootthymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	@NotEmpty(message="{label.enter.first}")
	private String firstName;
	
	@Column(name="last_name")
	@NotEmpty(message="{label.enter.last}")
	private String lastName;
	
	@Column(name="email")
	@NotEmpty(message="{label.enter.email}")
	private String email;
	
	public Employee() {
	}
	
	public Employee(int id, String firstname, String lastName, String email) {
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
