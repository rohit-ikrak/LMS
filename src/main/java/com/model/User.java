package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private long phoneno;
	private String dob;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;	
	private String role;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	
	public void setRole(String role) {
		this.role = role;
		if(role==null) {
			this.role = "user";
		}
	}

	public String getRole() {
		return role;
	}
	
	public User() {
		super();
		this.role="user";
		// TODO Auto-generated constructor stub
	}
	
	public User(Long id, String name, long phoneno, String dob, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.phoneno = phoneno;
		this.dob = dob;
		this.email = email;
		this.password = password;
		// Set default role to 'user' if not provided
        if (role == null) {
            this.role = "user";
        }
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneno=" + phoneno + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
	
}
