package com.sample.app1.sec;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="usrtab")
public class User {
	@Id	// note. let us not auto generate the value of this column
	private Long customerId; // the customer id comes from the newly created customer record
	private String username;  // username comes from newly created customer record
	private String password; // password comes from newly created customer record
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="customerId")
	private Set<Role> role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long customerId, String username, String password, Set<Role> role) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
		  
}
