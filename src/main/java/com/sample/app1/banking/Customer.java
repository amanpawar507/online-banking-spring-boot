package com.sample.app1.banking;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="customer_id")
private Long customerId;
private String firstname;
private String lastname;
private String city;
private long phone;
@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@JoinColumn(name="customer_id")
private List<Offers> offers;
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(Long  customerId, String firstname, String lastname, String city, long phone, List<Offers> offers) {
	super();
	this.customerId = customerId;
	this.firstname = firstname;
	this.lastname = lastname;
	this.city = city;
	this.phone = phone;
	this.offers = offers;
}
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public List<Offers> getOffers() {
	return offers;
}
public void setOffers(List<Offers> offers) {
	this.offers = offers;
}



}
