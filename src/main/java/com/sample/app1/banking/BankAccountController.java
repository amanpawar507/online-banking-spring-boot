package com.sample.app1.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app1.emp.Employee;

@RestController
@RequestMapping("/bankaccounts")
@CrossOrigin("http://localhost:4200")
public class BankAccountController {
	
	@Autowired
	private BankAccountService service;
	

	@GetMapping("/roleadmin")
	public String adminRoleTestMethod() {
		return "Hello Admin ";
	}
	
	@GetMapping("/rolecustomer")
	public String customerRoleTestMethod() {
		return "Hello Customer ";
	}
	
	@GetMapping("/roleany")
	public String anyRoleTestMethod() {
		return "Hello Unknown Role";
	}
	
	
	
	@PostMapping
	public BankAccount save(@RequestBody BankAccount bankAccount) {
		
		System.out.println("Act Number = " + bankAccount.getActNumber());
		System.out.println("Act Type = " + bankAccount.getActType());
		System.out.println("Act Date = " + bankAccount.getActCreationDate());
		System.out.println("Act balance = " + bankAccount.getActBalance());
		System.out.println("Customer First name =" + bankAccount.getCustomer().getFirstname());
		System.out.println("Customer last name = " + bankAccount.getCustomer().getLastname());
		System.out.println("Customer city = " + bankAccount.getCustomer().getCity());	
		return service.save(bankAccount);
	}
	
	@GetMapping
	public List<BankAccount> findAll(){
		List<BankAccount> list = service.findAll();
		System.out.println("*********find all************");
		for(BankAccount bankAccount: list) {
			System.out.println("Act Number = " + bankAccount.getActNumber());
			System.out.println("Act Type = " + bankAccount.getActType());
			System.out.println("Act Date = " + bankAccount.getActCreationDate());
			System.out.println("Act balance = " + bankAccount.getActBalance());
			System.out.println("Customer First name =" + bankAccount.getCustomer().getFirstname());
			System.out.println("Customer last name = " + bankAccount.getCustomer().getLastname());
			System.out.println("Customer city = " + bankAccount.getCustomer().getCity());
			
		}
		System.out.println("*********find all************");
		return list;
	}
	
	@GetMapping("/{customerId}")
	public BankAccount findByCustomerId(@PathVariable Long customerId) {
		System.out.println("findByCustomerId(@PathVariable Long customerId) = " + customerId);
		return service.findByCustomerId(customerId);
	}

	@GetMapping("/accountAge/{customerId}")
	public long accountAge(@PathVariable Long customerId) {		
		System.out.println("accountAge(Long customerId)= " + customerId);
		return yearsDiff(customerId);
	}
	
	private long yearsDiff(Long customerId) {
		System.out.println("yearsDiff(Long customerId)= " + customerId);
		BankAccount bankAccount = service.findByCustomerId(customerId);
		System.out.println("type of date..");
		System.out.println( bankAccount.getActCreationDate() instanceof java.sql.Date);
		System.out.println("****actcreation date***==" + bankAccount.getActCreationDate());
		long actCreationDateInMillis = bankAccount.getActCreationDate().getTime();
		
		System.out.println("Account creation date in millis =>" + actCreationDateInMillis);
		long currentDateInMillis= System.currentTimeMillis();
		System.out.println("Current date in millis =>" + currentDateInMillis);
		System.out.println("time diff1 = " + (currentDateInMillis-actCreationDateInMillis));
		System.out.println("time diff2 = " + (actCreationDateInMillis-currentDateInMillis));
		System.out.println("years = " + ((currentDateInMillis-actCreationDateInMillis) / (1000l * 60 * 60 * 24 * 365)));
		long diffInMillis = currentDateInMillis-actCreationDateInMillis;
		long years = (diffInMillis / (1000l * 60 * 60 * 24 * 365));	
		return years;
		
//		Employee e1 = repo.findById(101).get();
//		Employee e2 = repo.findById(102).get();
//		long e1Dob = e1.getEmpDob().getTime();
//		long e2Dob = e2.getEmpDob().getTime();
//		long diff = e2Dob-e1Dob;
//		long years = (diff
//                / (1000l * 60 * 60 * 24 * 365));
	}
}
