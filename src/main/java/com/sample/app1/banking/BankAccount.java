package com.sample.app1.banking;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccount {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
private Long actNumber;
private String actType;
private int actBalance;
private Date actCreationDate;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="customer_id")
private Customer customer;
public BankAccount() {
	super();
	// TODO Auto-generated constructor stub
}
public BankAccount(Long actNumber, String actType, int actBalance, Date actCreationDate, Customer customer) {
	super();
	this.actNumber = actNumber;
	this.actType = actType;
	this.actBalance = actBalance;
	this.actCreationDate = actCreationDate;
	this.customer = customer;
}
public Long getActNumber() {
	return actNumber;
}
public void setActNumber(Long actNumber) {
	this.actNumber = actNumber;
}
public String getActType() {
	return actType;
}
public void setActType(String actType) {
	this.actType = actType;
}
public int getActBalance() {
	return actBalance;
}
public void setActBalance(int actBalance) {
	this.actBalance = actBalance;
}
public Date getActCreationDate() {
	return actCreationDate;
}
public void setActCreationDate(Date actCreationDate) {
	this.actCreationDate = actCreationDate;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}


}
